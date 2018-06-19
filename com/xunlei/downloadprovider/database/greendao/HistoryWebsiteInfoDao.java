package com.xunlei.downloadprovider.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xunlei.downloadprovider.web.website.b.d;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class HistoryWebsiteInfoDao extends AbstractDao<d, Long> {
    public static final String TABLENAME = "HISTORY_WEBSITE_INFO";

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public HistoryWebsiteInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public HistoryWebsiteInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        z = z ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(z);
        stringBuilder.append("\"HISTORY_WEBSITE_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"WEBSITE_URL\" TEXT,\"name\" TEXT,\"accessTime\" INTEGER NOT NULL ,\"hasEvenCreatedTask\" INTEGER NOT NULL ,\"iconUrl\" TEXT);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE ");
        stringBuilder.append(z ? "IF EXISTS " : "");
        stringBuilder.append("\"HISTORY_WEBSITE_INFO\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(DatabaseStatement databaseStatement, d dVar) {
        databaseStatement.clearBindings();
        Long l = dVar.a;
        if (l != null) {
            databaseStatement.bindLong(1, l.longValue());
        }
        String str = dVar.b;
        if (str != null) {
            databaseStatement.bindString(2, str);
        }
        str = dVar.c;
        if (str != null) {
            databaseStatement.bindString(3, str);
        }
        databaseStatement.bindLong(4, dVar.d);
        databaseStatement.bindLong(5, (long) dVar.e);
        dVar = dVar.f;
        if (dVar != null) {
            databaseStatement.bindString(6, dVar);
        }
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, d dVar) {
        sQLiteStatement.clearBindings();
        Long l = dVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = dVar.b;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        str = dVar.c;
        if (str != null) {
            sQLiteStatement.bindString(3, str);
        }
        sQLiteStatement.bindLong(4, dVar.d);
        sQLiteStatement.bindLong(5, (long) dVar.e);
        dVar = dVar.f;
        if (dVar != null) {
            sQLiteStatement.bindString(6, dVar);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        i += 0;
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }

    public d readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        i2 = i + 1;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 2;
        String string2 = cursor.isNull(i2) ? null : cursor.getString(i2);
        long j = cursor.getLong(i + 3);
        int i3 = cursor.getInt(i + 4);
        i += 5;
        return new d(valueOf, string, string2, j, i3, cursor.isNull(i) ? null : cursor.getString(i));
    }

    public void readEntity(Cursor cursor, d dVar, int i) {
        int i2 = i + 0;
        String str = null;
        dVar.a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        i2 = i + 1;
        dVar.b = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 2;
        dVar.c = cursor.isNull(i2) ? null : cursor.getString(i2);
        dVar.d = cursor.getLong(i + 3);
        dVar.e = cursor.getInt(i + 4);
        i += 5;
        if (!cursor.isNull(i)) {
            str = cursor.getString(i);
        }
        dVar.f = str;
    }

    protected final Long updateKeyAfterInsert(d dVar, long j) {
        dVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(d dVar) {
        return dVar != null ? dVar.a : null;
    }

    public boolean hasKey(d dVar) {
        return dVar.a != null ? true : null;
    }
}
