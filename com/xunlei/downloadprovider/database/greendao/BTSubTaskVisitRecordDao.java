package com.xunlei.downloadprovider.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xunlei.downloadprovider.database.a.a;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class BTSubTaskVisitRecordDao extends AbstractDao<a, Long> {
    public static final String TABLENAME = "BT_SUB_TASK_VISIT_RECORD";

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BTSubTaskVisitRecordDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BTSubTaskVisitRecordDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        z = z ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(z);
        stringBuilder.append("\"BT_SUB_TASK_VISIT_RECORD\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"bt_task_id\" INTEGER NOT NULL ,\"bt_info_hash\" TEXT NOT NULL UNIQUE ,\"bt_sub_index\" INTEGER NOT NULL );");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE ");
        stringBuilder.append(z ? "IF EXISTS " : "");
        stringBuilder.append("\"BT_SUB_TASK_VISIT_RECORD\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(DatabaseStatement databaseStatement, a aVar) {
        databaseStatement.clearBindings();
        Long l = aVar.a;
        if (l != null) {
            databaseStatement.bindLong(1, l.longValue());
        }
        databaseStatement.bindLong(2, aVar.b);
        databaseStatement.bindString(3, aVar.c);
        databaseStatement.bindLong(4, (long) aVar.d);
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, a aVar) {
        sQLiteStatement.clearBindings();
        Long l = aVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindLong(2, aVar.b);
        sQLiteStatement.bindString(3, aVar.c);
        sQLiteStatement.bindLong(4, (long) aVar.d);
    }

    public Long readKey(Cursor cursor, int i) {
        i += 0;
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }

    public a readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        return new a(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getLong(i + 1), cursor.getString(i + 2), cursor.getInt(i + 3));
    }

    public void readEntity(Cursor cursor, a aVar, int i) {
        int i2 = i + 0;
        aVar.a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        aVar.b = cursor.getLong(i + 1);
        aVar.c = cursor.getString(i + 2);
        aVar.d = cursor.getInt(i + 3);
    }

    protected final Long updateKeyAfterInsert(a aVar, long j) {
        aVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(a aVar) {
        return aVar != null ? aVar.a : null;
    }

    public boolean hasKey(a aVar) {
        return aVar.a != null ? true : null;
    }
}
