package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.stat.base.XLStatCommandID;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    protected Set<K> usedPks = new HashSet();

    protected abstract T createEntity(K k);

    protected abstract K createRandomPk();

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
    }

    protected void setUp() throws Exception {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn != null) {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
                this.pkColumn = property;
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testInsertAndLoad() {
        Object nextPk = nextPk();
        Object createEntity = createEntity(nextPk);
        this.dao.insert(createEntity);
        assertEquals(nextPk, this.daoAccess.getKey(createEntity));
        nextPk = this.dao.load(nextPk);
        assertNotNull(nextPk);
        assertEquals(this.daoAccess.getKey(createEntity), this.daoAccess.getKey(nextPk));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        Object arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        assertEquals((long) arrayList.size(), this.dao.count());
    }

    public void testCount() {
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(1, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(2, this.dao.count());
    }

    public void testInsertTwice() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.nextPk();
        r0 = r2.createEntity(r0);
        r1 = r2.dao;
        r1.insert(r0);
        r1 = r2.dao;	 Catch:{ SQLException -> 0x0018 }
        r1.insert(r0);	 Catch:{ SQLException -> 0x0018 }
        r0 = "Inserting twice should not work";	 Catch:{ SQLException -> 0x0018 }
        fail(r0);	 Catch:{ SQLException -> 0x0018 }
        return;
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.test.AbstractDaoTestSinglePk.testInsertTwice():void");
    }

    public void testInsertOrReplaceTwice() {
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        long insert = this.dao.insert(createEntityWithRandomPk);
        long insertOrReplace = this.dao.insertOrReplace(createEntityWithRandomPk);
        if (this.dao.getPkProperty().type == Long.class) {
            assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        Iterable arrayList = new ArrayList();
        Object arrayList2 = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Object createEntityWithRandomPk = createEntityWithRandomPk();
            if (i % 2 == 0) {
                arrayList.add(createEntityWithRandomPk);
            }
            arrayList2.add(createEntityWithRandomPk);
        }
        this.dao.insertOrReplaceInTx(arrayList);
        this.dao.insertOrReplaceInTx(arrayList2);
        assertEquals((long) arrayList2.size(), this.dao.count());
    }

    public void testDelete() {
        Object nextPk = nextPk();
        this.dao.deleteByKey(nextPk);
        this.dao.insert(createEntity(nextPk));
        assertNotNull(this.dao.load(nextPk));
        this.dao.deleteByKey(nextPk);
        assertNull(this.dao.load(nextPk));
    }

    public void testDeleteAll() {
        Object<Object> arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        for (Object key : arrayList) {
            Object key2 = this.daoAccess.getKey(key2);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteInTx() {
        List arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        List<Object> arrayList2 = new ArrayList();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.dao.deleteInTx(arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object key : arrayList2) {
            Object key2 = this.daoAccess.getKey(key2);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteByKeyInTx() {
        List arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        List arrayList2 = new ArrayList();
        arrayList2.add(this.daoAccess.getKey(arrayList.get(0)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(3)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(4)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(8)));
        this.dao.deleteByKeyInTx(arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object next : arrayList2) {
            assertNotNull(next);
            assertNull(this.dao.load(next));
        }
    }

    public void testRowId() {
        assertTrue(this.dao.insert(createEntityWithRandomPk()) != this.dao.insert(createEntityWithRandomPk()));
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        Object arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            arrayList.add(createEntity(nextPk()));
        }
        this.dao.insertInTx(arrayList);
        assertEquals(arrayList.size(), this.dao.loadAll().size());
    }

    public void testQuery() {
        this.dao.insert(createEntityWithRandomPk());
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        this.dao.insert(createEntityWithRandomPk());
        StringBuilder stringBuilder = new StringBuilder("WHERE ");
        stringBuilder.append(this.dao.getPkColumns()[0]);
        stringBuilder.append("=?");
        String stringBuilder2 = stringBuilder.toString();
        List queryRaw = this.dao.queryRaw(stringBuilder2, new String[]{nextPk.toString()});
        assertEquals(1, queryRaw.size());
        assertEquals(nextPk, this.daoAccess.getKey(queryRaw.get(0)));
    }

    public void testUpdate() {
        this.dao.deleteAll();
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        this.dao.insert(createEntityWithRandomPk);
        this.dao.update(createEntityWithRandomPk);
        assertEquals(1, this.dao.count());
    }

    public void testReadWithOffset() {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(5, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.getKey(this.daoAccess.readEntity(queryWithDummyColumnsInFront, 5)));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void testLoadPkWithOffset() {
        runLoadPkTest(10);
    }

    public void testLoadPk() {
        runLoadPkTest(0);
    }

    public void testSave() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            Object createEntity = createEntity(null);
            if (createEntity != null) {
                this.dao.save(createEntity);
                this.dao.save(createEntity);
                assertEquals(1, this.dao.count());
            }
        }
    }

    public void testSaveInTx() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            Iterable arrayList = new ArrayList();
            Object arrayList2 = new ArrayList();
            for (int i = 0; i < 20; i++) {
                Object createEntity = createEntity(null);
                if (i % 2 == 0) {
                    arrayList.add(createEntity);
                }
                arrayList2.add(createEntity);
            }
            this.dao.saveInTx(arrayList);
            this.dao.saveInTx(arrayList2);
            assertEquals((long) arrayList2.size(), this.dao.count());
        }
    }

    protected void runLoadPkTest(int i) {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(i, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.readKey(queryWithDummyColumnsInFront, i));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    protected Cursor queryWithDummyColumnsInFront(int i, String str, K k) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            stringBuilder.append(str);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        SqlUtils.appendColumns(stringBuilder, "T", this.dao.getAllColumns()).append(" FROM ");
        stringBuilder.append('\"');
        stringBuilder.append(this.dao.getTablename());
        stringBuilder.append('\"');
        stringBuilder.append(" T");
        if (k != null) {
            stringBuilder.append(" WHERE ");
            assertEquals(1, this.dao.getPkColumns().length);
            stringBuilder.append(this.dao.getPkColumns()[0]);
            stringBuilder.append("=");
            DatabaseUtils.appendValueToSql(stringBuilder, k);
        }
        Cursor rawQuery = this.db.rawQuery(stringBuilder.toString(), null);
        assertTrue(rawQuery.moveToFirst());
        while (i2 < i) {
            try {
                assertEquals(str, rawQuery.getString(i2));
                i2++;
            } catch (int i4) {
                rawQuery.close();
                throw i4;
            }
        }
        if (k != null) {
            assertEquals(1, rawQuery.getCount());
        }
        return rawQuery;
    }

    protected boolean checkKeyIsNullable() {
        if (createEntity(null) != null) {
            return true;
        }
        DaoLog.d("Test is not available for entities with non-null keys");
        return false;
    }

    protected K nextPk() {
        for (int i = 0; i < XLStatCommandID.XLCID_LOGIN; i++) {
            K createRandomPk = createRandomPk();
            if (this.usedPks.add(createRandomPk)) {
                return createRandomPk;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    protected T createEntityWithRandomPk() {
        return createEntity(nextPk());
    }
}
