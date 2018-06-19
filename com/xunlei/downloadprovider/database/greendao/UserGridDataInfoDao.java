package com.xunlei.downloadprovider.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xunlei.downloadprovider.personal.a.b.b.b;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class UserGridDataInfoDao extends AbstractDao<b, Long> {
    public static final String TABLENAME = "USER_GRID_DATA_INFO";

    public static class Properties {
        public static final Property EnableRedDot = new Property(10, Integer.class, "enableRedDot", false, "enable_red_dot");
        public static final Property GridKeyword = new Property(2, String.class, "gridKeyword", false, "grid_keyword");
        public static final Property GridViewType = new Property(1, Integer.class, "gridViewType", false, "grid_view_type");
        public static final Property IconRes = new Property(9, Integer.class, "iconRes", false, "icon_res");
        public static final Property IconUrl = new Property(5, String.class, "iconUrl", false, "icon_url");
        public static final Property Id = new Property(0, Long.class, AgooConstants.MESSAGE_ID, true, "_id");
        public static final Property JumpClientKey = new Property(7, String.class, "jumpClientKey", false, "jump_client_key");
        public static final Property JumpType = new Property(8, String.class, "jumpType", false, "jump_type");
        public static final Property JumpUrl = new Property(6, String.class, "jumpUrl", false, "jump_url");
        public static final Property RedEndTime = new Property(12, String.class, "redEndTime", false, "red_end_time");
        public static final Property RedStartTime = new Property(11, String.class, "redStartTime", false, "red_start_time");
        public static final Property Text = new Property(4, String.class, "text", false, "text");
        public static final Property Title = new Property(3, String.class, "title", false, "title");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserGridDataInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public UserGridDataInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        z = z ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(z);
        stringBuilder.append("\"USER_GRID_DATA_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"grid_view_type\" INTEGER,\"grid_keyword\" TEXT,\"title\" TEXT,\"text\" TEXT,\"icon_url\" TEXT,\"jump_url\" TEXT,\"jump_client_key\" TEXT,\"jump_type\" TEXT,\"icon_res\" INTEGER,\"enable_red_dot\" INTEGER,\"red_start_time\" TEXT,\"red_end_time\" TEXT);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE ");
        stringBuilder.append(z ? "IF EXISTS " : "");
        stringBuilder.append("\"USER_GRID_DATA_INFO\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(DatabaseStatement databaseStatement, b bVar) {
        databaseStatement.clearBindings();
        Long l = bVar.a;
        if (l != null) {
            databaseStatement.bindLong(1, l.longValue());
        }
        Integer num = bVar.b;
        if (num != null) {
            databaseStatement.bindLong(2, (long) num.intValue());
        }
        String str = bVar.c;
        if (str != null) {
            databaseStatement.bindString(3, str);
        }
        str = bVar.d;
        if (str != null) {
            databaseStatement.bindString(4, str);
        }
        str = bVar.e;
        if (str != null) {
            databaseStatement.bindString(5, str);
        }
        str = bVar.f;
        if (str != null) {
            databaseStatement.bindString(6, str);
        }
        str = bVar.g;
        if (str != null) {
            databaseStatement.bindString(7, str);
        }
        str = bVar.h;
        if (str != null) {
            databaseStatement.bindString(8, str);
        }
        str = bVar.i;
        if (str != null) {
            databaseStatement.bindString(9, str);
        }
        num = bVar.j;
        if (num != null) {
            databaseStatement.bindLong(10, (long) num.intValue());
        }
        num = bVar.k;
        if (num != null) {
            databaseStatement.bindLong(11, (long) num.intValue());
        }
        str = bVar.l;
        if (str != null) {
            databaseStatement.bindString(12, str);
        }
        bVar = bVar.m;
        if (bVar != null) {
            databaseStatement.bindString(13, bVar);
        }
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, b bVar) {
        sQLiteStatement.clearBindings();
        Long l = bVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        Integer num = bVar.b;
        if (num != null) {
            sQLiteStatement.bindLong(2, (long) num.intValue());
        }
        String str = bVar.c;
        if (str != null) {
            sQLiteStatement.bindString(3, str);
        }
        str = bVar.d;
        if (str != null) {
            sQLiteStatement.bindString(4, str);
        }
        str = bVar.e;
        if (str != null) {
            sQLiteStatement.bindString(5, str);
        }
        str = bVar.f;
        if (str != null) {
            sQLiteStatement.bindString(6, str);
        }
        str = bVar.g;
        if (str != null) {
            sQLiteStatement.bindString(7, str);
        }
        str = bVar.h;
        if (str != null) {
            sQLiteStatement.bindString(8, str);
        }
        str = bVar.i;
        if (str != null) {
            sQLiteStatement.bindString(9, str);
        }
        num = bVar.j;
        if (num != null) {
            sQLiteStatement.bindLong(10, (long) num.intValue());
        }
        num = bVar.k;
        if (num != null) {
            sQLiteStatement.bindLong(11, (long) num.intValue());
        }
        str = bVar.l;
        if (str != null) {
            sQLiteStatement.bindString(12, str);
        }
        bVar = bVar.m;
        if (bVar != null) {
            sQLiteStatement.bindString(13, bVar);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        i += 0;
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }

    public b readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = i + 3;
        int i6 = i + 4;
        int i7 = i + 5;
        int i8 = i + 6;
        int i9 = i + 7;
        int i10 = i + 8;
        int i11 = i + 9;
        int i12 = i + 10;
        int i13 = i + 11;
        int i14 = i + 12;
        return new b(cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2)), cursor2.isNull(i3) ? null : Integer.valueOf(cursor2.getInt(i3)), cursor2.isNull(i4) ? null : cursor2.getString(i4), cursor2.isNull(i5) ? null : cursor2.getString(i5), cursor2.isNull(i6) ? null : cursor2.getString(i6), cursor2.isNull(i7) ? null : cursor2.getString(i7), cursor2.isNull(i8) ? null : cursor2.getString(i8), cursor2.isNull(i9) ? null : cursor2.getString(i9), cursor2.isNull(i10) ? null : cursor2.getString(i10), cursor2.isNull(i11) ? null : Integer.valueOf(cursor2.getInt(i11)), cursor2.isNull(i12) ? null : Integer.valueOf(cursor2.getInt(i12)), cursor2.isNull(i13) ? null : cursor2.getString(i13), cursor2.isNull(i14) ? null : cursor2.getString(i14));
    }

    public void readEntity(Cursor cursor, b bVar, int i) {
        int i2 = i + 0;
        String str = null;
        bVar.a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        i2 = i + 1;
        bVar.b = cursor.isNull(i2) ? null : Integer.valueOf(cursor.getInt(i2));
        i2 = i + 2;
        bVar.c = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 3;
        bVar.d = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 4;
        bVar.e = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 5;
        bVar.f = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 6;
        bVar.g = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 7;
        bVar.h = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 8;
        bVar.i = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 9;
        bVar.j = cursor.isNull(i2) ? null : Integer.valueOf(cursor.getInt(i2));
        i2 = i + 10;
        bVar.k = cursor.isNull(i2) ? null : Integer.valueOf(cursor.getInt(i2));
        i2 = i + 11;
        bVar.l = cursor.isNull(i2) ? null : cursor.getString(i2);
        i += 12;
        if (!cursor.isNull(i)) {
            str = cursor.getString(i);
        }
        bVar.m = str;
    }

    protected final Long updateKeyAfterInsert(b bVar, long j) {
        bVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(b bVar) {
        return bVar != null ? bVar.a : null;
    }

    public boolean hasKey(b bVar) {
        return bVar.a != null ? true : null;
    }
}
