package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.FastCursor;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;
    protected final Database db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    protected void attachEntity(T t) {
    }

    public abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    public abstract void bindValues(DatabaseStatement databaseStatement, T t);

    public abstract K getKey(T t);

    public abstract boolean hasKey(T t);

    public abstract boolean isEntityUpdateable();

    public abstract T readEntity(Cursor cursor, int i);

    public abstract void readEntity(Cursor cursor, T t, int i);

    public abstract K readKey(Cursor cursor, int i);

    public abstract K updateKeyAfterInsert(T t, long j);

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        this.db = daoConfig.db;
        this.isStandardSQLite = this.db.getRawDatabase() instanceof SQLiteDatabase;
        this.identityScope = daoConfig.getIdentityScope();
        if ((this.identityScope instanceof IdentityScopeLong) != null) {
            this.identityScopeLong = (IdentityScopeLong) this.identityScope;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        this.pkOrdinal = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public T load(K k) {
        assertSinglePk();
        if (k == null) {
            return null;
        }
        if (this.identityScope != null) {
            T t = this.identityScope.get(k);
            if (t != null) {
                return t;
            }
        }
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()}));
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    protected T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            T loadUnique = loadUnique(cursor);
            return loadUnique;
        } finally {
            cursor.close();
        }
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        StringBuilder stringBuilder = new StringBuilder("Expected unique result, but count was ");
        stringBuilder.append(cursor.getCount());
        throw new DaoException(stringBuilder.toString());
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    public boolean detach(T t) {
        if (this.identityScope == null) {
            return null;
        }
        return this.identityScope.detach(getKeyVerified(t), t);
    }

    public void detachAll() {
        if (this.identityScope != null) {
            this.identityScope.clear();
        }
    }

    protected List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            List<T> loadAllFromCursor = loadAllFromCursor(cursor);
            return loadAllFromCursor;
        } finally {
            cursor.close();
        }
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executeInsertInTx(org.greenrobot.greendao.database.DatabaseStatement r6, java.lang.Iterable<T> r7, boolean r8) {
        /*
        r5 = this;
        r0 = r5.db;
        r0.beginTransaction();
        monitor-enter(r6);	 Catch:{ all -> 0x007b }
        r0 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        r0.lock();	 Catch:{ all -> 0x0078 }
    L_0x000f:
        r0 = r5.isStandardSQLite;	 Catch:{ all -> 0x006d }
        r1 = 0;
        if (r0 == 0) goto L_0x0039;
    L_0x0014:
        r0 = r6.getRawStatement();	 Catch:{ all -> 0x006d }
        r0 = (android.database.sqlite.SQLiteStatement) r0;	 Catch:{ all -> 0x006d }
        r7 = r7.iterator();	 Catch:{ all -> 0x006d }
    L_0x001e:
        r2 = r7.hasNext();	 Catch:{ all -> 0x006d }
        if (r2 == 0) goto L_0x0058;
    L_0x0024:
        r2 = r7.next();	 Catch:{ all -> 0x006d }
        r5.bindValues(r0, r2);	 Catch:{ all -> 0x006d }
        if (r8 == 0) goto L_0x0035;
    L_0x002d:
        r3 = r0.executeInsert();	 Catch:{ all -> 0x006d }
        r5.updateKeyAfterInsertAndAttach(r2, r3, r1);	 Catch:{ all -> 0x006d }
        goto L_0x001e;
    L_0x0035:
        r0.execute();	 Catch:{ all -> 0x006d }
        goto L_0x001e;
    L_0x0039:
        r7 = r7.iterator();	 Catch:{ all -> 0x006d }
    L_0x003d:
        r0 = r7.hasNext();	 Catch:{ all -> 0x006d }
        if (r0 == 0) goto L_0x0058;
    L_0x0043:
        r0 = r7.next();	 Catch:{ all -> 0x006d }
        r5.bindValues(r6, r0);	 Catch:{ all -> 0x006d }
        if (r8 == 0) goto L_0x0054;
    L_0x004c:
        r2 = r6.executeInsert();	 Catch:{ all -> 0x006d }
        r5.updateKeyAfterInsertAndAttach(r0, r2, r1);	 Catch:{ all -> 0x006d }
        goto L_0x003d;
    L_0x0054:
        r6.execute();	 Catch:{ all -> 0x006d }
        goto L_0x003d;
    L_0x0058:
        r7 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        if (r7 == 0) goto L_0x0061;
    L_0x005c:
        r7 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        r7.unlock();	 Catch:{ all -> 0x0078 }
    L_0x0061:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6 = r5.db;	 Catch:{ all -> 0x007b }
        r6.setTransactionSuccessful();	 Catch:{ all -> 0x007b }
        r6 = r5.db;
        r6.endTransaction();
        return;
    L_0x006d:
        r7 = move-exception;
        r8 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        if (r8 == 0) goto L_0x0077;
    L_0x0072:
        r8 = r5.identityScope;	 Catch:{ all -> 0x0078 }
        r8.unlock();	 Catch:{ all -> 0x0078 }
    L_0x0077:
        throw r7;	 Catch:{ all -> 0x0078 }
    L_0x0078:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r7;	 Catch:{ all -> 0x007b }
    L_0x007b:
        r6 = move-exception;
        r7 = r5.db;
        r7.endTransaction();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.executeInsertInTx(org.greenrobot.greendao.database.DatabaseStatement, java.lang.Iterable, boolean):void");
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement(), true);
    }

    public long insertWithoutSettingPk(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), false);
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), true);
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement, boolean z) {
        long insertInsideTx;
        if (this.db.isDbLockedByCurrentThread()) {
            insertInsideTx = insertInsideTx(t, databaseStatement);
        } else {
            insertInsideTx = this.db;
            insertInsideTx.beginTransaction();
            try {
                insertInsideTx = insertInsideTx(t, databaseStatement);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(t, insertInsideTx, true);
        }
        return insertInsideTx;
    }

    private long insertInsideTx(T t, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, (Object) t);
                long executeInsert = sQLiteStatement.executeInsert();
                return executeInsert;
            }
            bindValues(databaseStatement, (Object) t);
            executeInsert = databaseStatement.executeInsert();
            return executeInsert;
        }
    }

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public void save(T t) {
        if (hasKey(t)) {
            update(t);
        } else {
            insert(t);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void saveInTx(Iterable<T> iterable) {
        int i = 0;
        int i2 = 0;
        for (T hasKey : iterable) {
            if (hasKey(hasKey)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i > 0 && i2 > 0) {
            Iterable arrayList = new ArrayList(i);
            Iterable arrayList2 = new ArrayList(i2);
            for (Object next : iterable) {
                if (hasKey(next)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            this.db.beginTransaction();
            try {
                updateInTx(arrayList);
                insertInTx(arrayList2);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        } else if (i2 > 0) {
            insertInTx((Iterable) iterable);
        } else {
            if (i > 0) {
                updateInTx((Iterable) iterable);
            }
        }
    }

    protected List<T> loadAllFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        if (count == 0) {
            return new ArrayList();
        }
        boolean z;
        List<T> arrayList = new ArrayList(count);
        CursorWindow cursorWindow = null;
        if (cursor instanceof CrossProcessCursor) {
            cursorWindow = ((CrossProcessCursor) cursor).getWindow();
            if (cursorWindow != null) {
                if (cursorWindow.getNumRows() == count) {
                    cursor = new FastCursor(cursorWindow);
                    z = true;
                    if (cursor.moveToFirst()) {
                        if (this.identityScope != null) {
                            this.identityScope.lock();
                            this.identityScope.reserveRoom(count);
                        }
                        if (!(z || cursorWindow == null)) {
                            try {
                                if (this.identityScope != null) {
                                    loadAllUnlockOnWindowBounds(cursor, cursorWindow, arrayList);
                                    if (this.identityScope != null) {
                                        this.identityScope.unlock();
                                    }
                                }
                            } catch (Throwable th) {
                                if (this.identityScope != null) {
                                    this.identityScope.unlock();
                                }
                            }
                        }
                        do {
                            arrayList.add(loadCurrent(cursor, 0, false));
                        } while (cursor.moveToNext());
                        if (this.identityScope != null) {
                            this.identityScope.unlock();
                        }
                    }
                    return arrayList;
                }
                StringBuilder stringBuilder = new StringBuilder("Window vs. result size: ");
                stringBuilder.append(cursorWindow.getNumRows());
                stringBuilder.append("/");
                stringBuilder.append(count);
                DaoLog.d(stringBuilder.toString());
            }
        }
        z = false;
        if (cursor.moveToFirst()) {
            if (this.identityScope != null) {
                this.identityScope.lock();
                this.identityScope.reserveRoom(count);
            }
            if (this.identityScope != null) {
                loadAllUnlockOnWindowBounds(cursor, cursorWindow, arrayList);
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            do {
                arrayList.add(loadCurrent(cursor, 0, false));
            } while (cursor.moveToNext());
            if (this.identityScope != null) {
                this.identityScope.unlock();
            }
        }
        return arrayList;
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            i++;
            if (i >= startPosition) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked != null) {
                    startPosition = moveToNextUnlocked.getStartPosition() + moveToNextUnlocked.getNumRows();
                } else {
                    return;
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i++;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            if (cursor.moveToNext()) {
                cursor = ((CrossProcessCursor) cursor).getWindow();
                return cursor;
            }
            this.identityScope.lock();
            return null;
        } finally {
            this.identityScope.lock();
        }
    }

    protected final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            T 2 = z ? this.identityScopeLong.get2(j) : this.identityScopeLong.get2NoLock(j);
            if (2 != null) {
                return 2;
            }
            cursor = readEntity(cursor, i);
            attachEntity(cursor);
            if (z) {
                this.identityScopeLong.put2(j, cursor);
            } else {
                this.identityScopeLong.put2NoLock(j, cursor);
            }
            return cursor;
        } else if (this.identityScope != null) {
            Object readKey = readKey(cursor, i);
            if (i != 0 && readKey == null) {
                return null;
            }
            T noLock = z ? this.identityScope.get(readKey) : this.identityScope.getNoLock(readKey);
            if (noLock != null) {
                return noLock;
            }
            cursor = readEntity(cursor, i);
            attachEntity(readKey, cursor, z);
            return cursor;
        } else if (i != 0 && !readKey(cursor, i)) {
            return null;
        } else {
            cursor = readEntity(cursor, i);
            attachEntity(cursor);
            return cursor;
        }
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    public List<T> queryRaw(String str, String... strArr) {
        Database database = this.db;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.statements.getSelectAll());
        stringBuilder.append(str);
        return loadAllAndCloseCursor(database.rawQuery(stringBuilder.toString(), strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.statements.getSelectAll());
        stringBuilder.append(str);
        return Query.internalCreate(this, stringBuilder.toString(), collection.toArray());
    }

    public void deleteAll() {
        Database database = this.db;
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM '");
        stringBuilder.append(this.config.tablename);
        stringBuilder.append("'");
        database.execSQL(stringBuilder.toString());
        if (this.identityScope != null) {
            this.identityScope.clear();
        }
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            } catch (Throwable th) {
                this.db.endTransaction();
            }
        }
        if (this.identityScope != null) {
            this.identityScope.remove((Object) k);
        }
    }

    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k).longValue());
        } else if (k == null) {
            throw new DaoException("Cannot delete entity, key is null");
        } else {
            databaseStatement.bindString(1, k.toString());
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.db.beginTransaction();
        try {
            Iterable arrayList;
            synchronized (deleteStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        for (T keyVerified : iterable) {
                            Object keyVerified2 = getKeyVerified(keyVerified);
                            deleteByKeyInsideSynchronized(keyVerified2, deleteStatement);
                            if (arrayList != null) {
                                arrayList.add(keyVerified2);
                            }
                        }
                    } catch (Throwable th) {
                        if (this.identityScope != null) {
                            this.identityScope.unlock();
                        }
                    }
                }
                if (iterable2 != null) {
                    for (Iterable<K> iterable22 : iterable22) {
                        deleteByKeyInsideSynchronized(iterable22, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(iterable22);
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.db.setTransactionSuccessful();
            if (!(arrayList == null || this.identityScope == null)) {
                this.identityScope.remove(arrayList);
            }
            this.db.endTransaction();
        } catch (Throwable th2) {
            this.db.endTransaction();
        }
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void refresh(T t) {
        assertSinglePk();
        Object keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                StringBuilder stringBuilder = new StringBuilder("Entity does not exist in the database anymore: ");
                stringBuilder.append(t.getClass());
                stringBuilder.append(" with key ");
                stringBuilder.append(keyVerified);
                throw new DaoException(stringBuilder.toString());
            } else if (rawQuery.isLast()) {
                readEntity(rawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("Expected unique result, but count was ");
                stringBuilder2.append(rawQuery.getCount());
                throw new DaoException(stringBuilder2.toString());
            }
        } finally {
            rawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((Object) t, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized((Object) t, updateStatement, true);
                }
            }
            return;
        }
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((Object) t, updateStatement, true);
            }
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
        } catch (Throwable th) {
            this.db.endTransaction();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    protected void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean z) {
        bindValues(databaseStatement, (Object) t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            databaseStatement.bindString(length, key.toString());
        }
        databaseStatement.execute();
        attachEntity(key, t, z);
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, (Object) t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            sQLiteStatement.bindString(length, key.toString());
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    protected final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        if (!(this.identityScope == null || k == null)) {
            if (z) {
                this.identityScope.put(k, t);
                return;
            }
            this.identityScope.putNoLock(k, t);
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                        for (T updateInsideSynchronized : iterable) {
                            updateInsideSynchronized((Object) updateInsideSynchronized, sQLiteStatement, false);
                        }
                    } else {
                        for (T updateInsideSynchronized2 : iterable) {
                            updateInsideSynchronized((Object) updateInsideSynchronized2, updateStatement, false);
                        }
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.db.setTransactionSuccessful();
        } catch (RuntimeException e) {
            iterable = e;
        } finally {
            try {
                this.db.endTransaction();
            } catch (Iterable<T> iterable2) {
                throw iterable2;
            }
        }
        iterable2 = null;
        if (iterable2 != null) {
            throw iterable2;
        }
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this);
            stringBuilder.append(" (");
            stringBuilder.append(this.config.tablename);
            stringBuilder.append(") does not have a single-column primary key");
            throw new DaoException(stringBuilder.toString());
        }
    }

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        if (t == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao(this);
        }
        return this.rxDaoPlain;
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao(this, Schedulers.io());
        }
        return this.rxDao;
    }

    public Database getDatabase() {
        return this.db;
    }
}
