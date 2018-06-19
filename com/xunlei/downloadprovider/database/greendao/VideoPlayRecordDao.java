package com.xunlei.downloadprovider.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class VideoPlayRecordDao extends AbstractDao<VideoPlayRecord, Long> {
    public static final String TABLENAME = "VIDEO_PLAY_RECORD";

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public VideoPlayRecordDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public VideoPlayRecordDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        z = z ? "IF NOT EXISTS " : "";
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(z);
        stringBuilder.append("\"VIDEO_PLAY_RECORD\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"type_tag\" TEXT,\"name\" TEXT,\"play_url\" TEXT NOT NULL UNIQUE ,\"cover_url\" TEXT,\"duration\" INTEGER NOT NULL ,\"played_time\" INTEGER NOT NULL ,\"max_played_time\" INTEGER NOT NULL ,\"last_play_timestamp\" INTEGER NOT NULL ,\"size\" INTEGER NOT NULL ,\"download_url\" TEXT,\"cid\" TEXT,\"gcid\" TEXT,\"movie_id\" TEXT);");
        database.execSQL(stringBuilder.toString());
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DROP TABLE ");
        stringBuilder.append(z ? "IF EXISTS " : "");
        stringBuilder.append("\"VIDEO_PLAY_RECORD\"");
        database.execSQL(stringBuilder.toString());
    }

    protected final void bindValues(DatabaseStatement databaseStatement, VideoPlayRecord videoPlayRecord) {
        databaseStatement.clearBindings();
        Long l = videoPlayRecord.b;
        if (l != null) {
            databaseStatement.bindLong(1, l.longValue());
        }
        String str = videoPlayRecord.c;
        if (str != null) {
            databaseStatement.bindString(2, str);
        }
        str = videoPlayRecord.d;
        if (str != null) {
            databaseStatement.bindString(3, str);
        }
        databaseStatement.bindString(4, videoPlayRecord.e);
        str = videoPlayRecord.f;
        if (str != null) {
            databaseStatement.bindString(5, str);
        }
        databaseStatement.bindLong(6, videoPlayRecord.g);
        databaseStatement.bindLong(7, videoPlayRecord.h);
        databaseStatement.bindLong(8, videoPlayRecord.i);
        databaseStatement.bindLong(9, videoPlayRecord.j);
        databaseStatement.bindLong(10, videoPlayRecord.k);
        str = videoPlayRecord.l;
        if (str != null) {
            databaseStatement.bindString(11, str);
        }
        str = videoPlayRecord.m;
        if (str != null) {
            databaseStatement.bindString(12, str);
        }
        str = videoPlayRecord.n;
        if (str != null) {
            databaseStatement.bindString(13, str);
        }
        videoPlayRecord = videoPlayRecord.o;
        if (videoPlayRecord != null) {
            databaseStatement.bindString(14, videoPlayRecord);
        }
    }

    protected final void bindValues(SQLiteStatement sQLiteStatement, VideoPlayRecord videoPlayRecord) {
        sQLiteStatement.clearBindings();
        Long l = videoPlayRecord.b;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String str = videoPlayRecord.c;
        if (str != null) {
            sQLiteStatement.bindString(2, str);
        }
        str = videoPlayRecord.d;
        if (str != null) {
            sQLiteStatement.bindString(3, str);
        }
        sQLiteStatement.bindString(4, videoPlayRecord.e);
        str = videoPlayRecord.f;
        if (str != null) {
            sQLiteStatement.bindString(5, str);
        }
        sQLiteStatement.bindLong(6, videoPlayRecord.g);
        sQLiteStatement.bindLong(7, videoPlayRecord.h);
        sQLiteStatement.bindLong(8, videoPlayRecord.i);
        sQLiteStatement.bindLong(9, videoPlayRecord.j);
        sQLiteStatement.bindLong(10, videoPlayRecord.k);
        str = videoPlayRecord.l;
        if (str != null) {
            sQLiteStatement.bindString(11, str);
        }
        str = videoPlayRecord.m;
        if (str != null) {
            sQLiteStatement.bindString(12, str);
        }
        str = videoPlayRecord.n;
        if (str != null) {
            sQLiteStatement.bindString(13, str);
        }
        videoPlayRecord = videoPlayRecord.o;
        if (videoPlayRecord != null) {
            sQLiteStatement.bindString(14, videoPlayRecord);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        i += 0;
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }

    public VideoPlayRecord readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        int i3 = i + 1;
        String string = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 2;
        String string2 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        String string3 = cursor2.getString(i + 3);
        int i5 = i + 4;
        String string4 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        long j = cursor2.getLong(i + 5);
        long j2 = cursor2.getLong(i + 6);
        long j3 = cursor2.getLong(i + 7);
        long j4 = cursor2.getLong(i + 8);
        long j5 = cursor2.getLong(i + 9);
        int i6 = i + 10;
        String string5 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        i6 = i + 11;
        String string6 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        i6 = i + 12;
        int i7 = i + 13;
        return new VideoPlayRecord(valueOf, string, string2, string3, string4, j, j2, j3, j4, j5, string5, string6, cursor2.isNull(i6) ? null : cursor2.getString(i6), cursor2.isNull(i7) ? null : cursor2.getString(i7));
    }

    public void readEntity(Cursor cursor, VideoPlayRecord videoPlayRecord, int i) {
        int i2 = i + 0;
        String str = null;
        videoPlayRecord.b = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        i2 = i + 1;
        videoPlayRecord.c = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 2;
        videoPlayRecord.d = cursor.isNull(i2) ? null : cursor.getString(i2);
        videoPlayRecord.e = cursor.getString(i + 3);
        i2 = i + 4;
        videoPlayRecord.f = cursor.isNull(i2) ? null : cursor.getString(i2);
        videoPlayRecord.g = cursor.getLong(i + 5);
        videoPlayRecord.h = cursor.getLong(i + 6);
        videoPlayRecord.i = cursor.getLong(i + 7);
        videoPlayRecord.j = cursor.getLong(i + 8);
        videoPlayRecord.k = cursor.getLong(i + 9);
        i2 = i + 10;
        videoPlayRecord.l = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 11;
        videoPlayRecord.m = cursor.isNull(i2) ? null : cursor.getString(i2);
        i2 = i + 12;
        videoPlayRecord.n = cursor.isNull(i2) ? null : cursor.getString(i2);
        i += 13;
        if (!cursor.isNull(i)) {
            str = cursor.getString(i);
        }
        videoPlayRecord.o = str;
    }

    protected final Long updateKeyAfterInsert(VideoPlayRecord videoPlayRecord, long j) {
        videoPlayRecord.b = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(VideoPlayRecord videoPlayRecord) {
        return videoPlayRecord != null ? videoPlayRecord.b : null;
    }

    public boolean hasKey(VideoPlayRecord videoPlayRecord) {
        return videoPlayRecord.b != null ? true : null;
    }
}
