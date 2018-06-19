package com.xunlei.downloadprovider.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xunlei.downloadprovider.cardslide.a.e;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class CardSlideInfoDao extends AbstractDao<e, Long> {
    public static final String TABLENAME = "CARD_SLIDE_INFO";

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public CardSlideInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CardSlideInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        z = z ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(z);
        stringBuilder.append("\"CARD_SLIDE_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"RES_ID\" TEXT,\"videoId\" TEXT,\"videoPlayUrl\" TEXT,\"videoTitle\" TEXT,\"videoCoverUrl\" TEXT,\"gCid\" TEXT,\"likeCount\" INTEGER,\"userPortraitUrl\" TEXT,\"userNickname\" TEXT,\"userId\" TEXT,\"userGender\" TEXT,\"userProvince\" TEXT,\"userCity\" TEXT,\"userKind\" TEXT,\"isAuthPub\" INTEGER,\"isVip\" INTEGER,\"vipLevel\" INTEGER,\"isYearVip\" INTEGER,\"vipType\" INTEGER);");
        database.execSQL(stringBuilder.toString());
        stringBuilder = new StringBuilder("CREATE UNIQUE INDEX ");
        stringBuilder.append(z);
        stringBuilder.append("IDX_CARD_SLIDE_INFO_RES_ID ON \"CARD_SLIDE_INFO\" (\"RES_ID\" ASC);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE ");
        stringBuilder.append(z ? "IF EXISTS " : "");
        stringBuilder.append("\"CARD_SLIDE_INFO\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(DatabaseStatement databaseStatement, e eVar) {
        databaseStatement.clearBindings();
        Long l = eVar.a;
        if (l != null) {
            databaseStatement.bindLong(1, l.longValue());
        }
        String str = eVar.b;
        if (str != null) {
            databaseStatement.bindString(2, str);
        }
        str = eVar.c;
        if (str != null) {
            databaseStatement.bindString(3, str);
        }
        str = eVar.d;
        if (str != null) {
            databaseStatement.bindString(4, str);
        }
        str = eVar.e;
        if (str != null) {
            databaseStatement.bindString(5, str);
        }
        str = eVar.f;
        if (str != null) {
            databaseStatement.bindString(6, str);
        }
        str = eVar.g;
        if (str != null) {
            databaseStatement.bindString(7, str);
        }
        Integer num = eVar.h;
        if (num != null) {
            databaseStatement.bindLong(8, (long) num.intValue());
        }
        str = eVar.i;
        if (str != null) {
            databaseStatement.bindString(9, str);
        }
        str = eVar.j;
        if (str != null) {
            databaseStatement.bindString(10, str);
        }
        str = eVar.k;
        if (str != null) {
            databaseStatement.bindString(11, str);
        }
        str = eVar.l;
        if (str != null) {
            databaseStatement.bindString(12, str);
        }
        str = eVar.m;
        if (str != null) {
            databaseStatement.bindString(13, str);
        }
        str = eVar.n;
        if (str != null) {
            databaseStatement.bindString(14, str);
        }
        str = eVar.o;
        if (str != null) {
            databaseStatement.bindString(15, str);
        }
        Boolean bool = eVar.p;
        long j = 0;
        if (bool != null) {
            databaseStatement.bindLong(16, bool.booleanValue() ? 1 : 0);
        }
        bool = eVar.q;
        if (bool != null) {
            databaseStatement.bindLong(17, bool.booleanValue() ? 1 : 0);
        }
        num = eVar.r;
        if (num != null) {
            databaseStatement.bindLong(18, (long) num.intValue());
        }
        bool = eVar.s;
        if (bool != null) {
            if (bool.booleanValue()) {
                j = 1;
            }
            databaseStatement.bindLong(19, j);
        }
        eVar = eVar.t;
        if (eVar != null) {
            databaseStatement.bindLong(20, (long) eVar.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, e eVar) {
        sQLiteStatement.clearBindings();
        Long l = eVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = eVar.b;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        str = eVar.c;
        if (str != null) {
            sQLiteStatement.bindString(3, str);
        }
        str = eVar.d;
        if (str != null) {
            sQLiteStatement.bindString(4, str);
        }
        str = eVar.e;
        if (str != null) {
            sQLiteStatement.bindString(5, str);
        }
        str = eVar.f;
        if (str != null) {
            sQLiteStatement.bindString(6, str);
        }
        str = eVar.g;
        if (str != null) {
            sQLiteStatement.bindString(7, str);
        }
        Integer num = eVar.h;
        if (num != null) {
            sQLiteStatement.bindLong(8, (long) num.intValue());
        }
        str = eVar.i;
        if (str != null) {
            sQLiteStatement.bindString(9, str);
        }
        str = eVar.j;
        if (str != null) {
            sQLiteStatement.bindString(10, str);
        }
        str = eVar.k;
        if (str != null) {
            sQLiteStatement.bindString(11, str);
        }
        str = eVar.l;
        if (str != null) {
            sQLiteStatement.bindString(12, str);
        }
        str = eVar.m;
        if (str != null) {
            sQLiteStatement.bindString(13, str);
        }
        str = eVar.n;
        if (str != null) {
            sQLiteStatement.bindString(14, str);
        }
        str = eVar.o;
        if (str != null) {
            sQLiteStatement.bindString(15, str);
        }
        Boolean bool = eVar.p;
        long j = 0;
        if (bool != null) {
            sQLiteStatement.bindLong(16, bool.booleanValue() ? 1 : 0);
        }
        bool = eVar.q;
        if (bool != null) {
            sQLiteStatement.bindLong(17, bool.booleanValue() ? 1 : 0);
        }
        num = eVar.r;
        if (num != null) {
            sQLiteStatement.bindLong(18, (long) num.intValue());
        }
        bool = eVar.s;
        if (bool != null) {
            if (bool.booleanValue()) {
                j = 1;
            }
            sQLiteStatement.bindLong(19, j);
        }
        eVar = eVar.t;
        if (eVar != null) {
            sQLiteStatement.bindLong(20, (long) eVar.intValue());
        }
    }

    public Long readKey(Cursor cursor, int i) {
        i += 0;
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }

    public e readEntity(Cursor cursor, int i) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        int i3 = i + 1;
        String string = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 2;
        String string2 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i + 3;
        String string3 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = i + 4;
        String string4 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        int i7 = i + 5;
        String string5 = cursor2.isNull(i7) ? null : cursor2.getString(i7);
        int i8 = i + 6;
        String string6 = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i + 7;
        Integer valueOf2 = cursor2.isNull(i9) ? null : Integer.valueOf(cursor2.getInt(i9));
        int i10 = i + 8;
        String string7 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = i + 9;
        String string8 = cursor2.isNull(i11) ? null : cursor2.getString(i11);
        int i12 = i + 10;
        String string9 = cursor2.isNull(i12) ? null : cursor2.getString(i12);
        int i13 = i + 11;
        String string10 = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = i + 12;
        String string11 = cursor2.isNull(i14) ? null : cursor2.getString(i14);
        int i15 = i + 13;
        String string12 = cursor2.isNull(i15) ? null : cursor2.getString(i15);
        i15 = i + 14;
        String string13 = cursor2.isNull(i15) ? null : cursor2.getString(i15);
        i15 = i + 15;
        if (cursor2.isNull(i15)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor2.getShort(i15) != (short) 0);
        }
        i15 = i + 16;
        if (cursor2.isNull(i15)) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(cursor2.getShort(i15) != (short) 0);
        }
        i15 = i + 17;
        Integer valueOf3 = cursor2.isNull(i15) ? null : Integer.valueOf(cursor2.getInt(i15));
        i15 = i + 18;
        if (cursor2.isNull(i15)) {
            bool3 = null;
        } else {
            bool3 = Boolean.valueOf(cursor2.getShort(i15) != (short) 0);
        }
        int i16 = i + 19;
        return new e(valueOf, string, string2, string3, string4, string5, string6, valueOf2, string7, string8, string9, string10, string11, string12, string13, bool, bool2, valueOf3, bool3, cursor2.isNull(i16) ? null : Integer.valueOf(cursor2.getInt(i16)));
    }

    public void readEntity(Cursor cursor, e eVar, int i) {
        Boolean bool;
        int i2 = i + 0;
        Integer num = null;
        eVar.a = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        i2 = i + 1;
        eVar.b = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 2;
        eVar.c = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 3;
        eVar.d = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 4;
        eVar.e = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 5;
        eVar.f = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 6;
        eVar.g = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 7;
        eVar.h = cursor.isNull(i2) ? null : Integer.valueOf(cursor.getInt(i2));
        i2 = i + 8;
        eVar.i = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 9;
        eVar.j = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 10;
        eVar.k = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 11;
        eVar.l = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 12;
        eVar.m = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 13;
        eVar.n = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 14;
        eVar.o = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 15;
        boolean z = true;
        if (cursor.isNull(i2)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i2) != (short) 0);
        }
        eVar.p = bool;
        i2 = i + 16;
        if (cursor.isNull(i2)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i2) != (short) 0);
        }
        eVar.q = bool;
        i2 = i + 17;
        eVar.r = cursor.isNull(i2) ? null : Integer.valueOf(cursor.getInt(i2));
        i2 = i + 18;
        if (cursor.isNull(i2)) {
            bool = null;
        } else {
            if (cursor.getShort(i2) == (short) 0) {
                z = false;
            }
            bool = Boolean.valueOf(z);
        }
        eVar.s = bool;
        i += 19;
        if (!cursor.isNull(i)) {
            num = Integer.valueOf(cursor.getInt(i));
        }
        eVar.t = num;
    }

    protected final Long updateKeyAfterInsert(e eVar, long j) {
        eVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(e eVar) {
        return eVar != null ? eVar.a : null;
    }

    public boolean hasKey(e eVar) {
        return eVar.a != null ? true : null;
    }
}
