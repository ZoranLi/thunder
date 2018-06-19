package com.xunlei.downloadprovider.homepage.follow.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.b.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: FollowingListDbHelper */
public final class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "follow.db", null, 4);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists following_id_list (_id integer primary key autoincrement, following_uid integer)");
        sQLiteDatabase.execSQL("create table if not exists following_detail_list (_id integer primary key autoincrement, following_uid integer, title text, update_time integer, avatar_url text, update_count integer, latest_res_title text)");
        sQLiteDatabase.execSQL("create table if not exists following_read_count (_id integer primary key autoincrement, uid integer, following_uid integer, total_count integer, read_count integer)");
        sQLiteDatabase.execSQL("create table if not exists following_video_feed (_id integer primary key autoincrement, feed_id text, user_info text, video_info text)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS following_id_list");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS following_detail_list");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS following_read_count");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS following_video_feed");
        onCreate(sQLiteDatabase);
    }

    public final void a(Set<Long> set) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        for (Long put : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("following_uid", put);
            writableDatabase.insert("following_id_list", "following_uid", contentValues);
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }

    public final Set<Long> a() {
        Exception e;
        Throwable th;
        Set<Long> hashSet = new HashSet();
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("following_id_list", new String[]{"following_uid"}, null, null, null, null, null, null);
            try {
                int columnIndex = query.getColumnIndex("following_uid");
                while (query.moveToNext()) {
                    hashSet.add(Long.valueOf(query.getLong(columnIndex)));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                try {
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return hashSet;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return hashSet;
        }
        return hashSet;
    }

    public final Map<Long, f> b() {
        Cursor query = getReadableDatabase().query("following_read_count", null, "uid=?", new String[]{String.valueOf(LoginHelper.a().g.c())}, null, null, null);
        int columnIndex = query.getColumnIndex("uid");
        int columnIndex2 = query.getColumnIndex("following_uid");
        int columnIndex3 = query.getColumnIndex("total_count");
        int columnIndex4 = query.getColumnIndex("read_count");
        Map<Long, f> hashMap = new HashMap();
        while (query.moveToNext()) {
            f fVar = new f();
            fVar.a = query.getLong(columnIndex);
            long j = query.getLong(columnIndex2);
            fVar.b = j;
            fVar.c = query.getInt(columnIndex3);
            fVar.d = query.getInt(columnIndex4);
            hashMap.put(Long.valueOf(j), fVar);
        }
        query.close();
        return hashMap;
    }

    public final void a(f fVar) {
        getWritableDatabase().insert("following_read_count", "following_uid", c(fVar));
    }

    public final int b(f fVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        fVar.a = LoginHelper.a().g.c();
        long j = fVar.b;
        String[] strArr = new String[]{String.valueOf(r1), String.valueOf(j)};
        return writableDatabase.update("following_read_count", c(fVar), "uid=? AND following_uid=?", strArr);
    }

    private static ContentValues c(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uid", Long.valueOf(LoginHelper.a().g.c()));
        contentValues.put("following_uid", Long.valueOf(fVar.b));
        contentValues.put("total_count", Integer.valueOf(fVar.c));
        contentValues.put("read_count", Integer.valueOf(fVar.d));
        return contentValues;
    }

    public final void a(List<d> list) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        for (d dVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("feed_id", dVar.a);
            contentValues.put(VideoUserInfo.JSON_KEY, dVar.e);
            contentValues.put(BaseVideoInfo.JSON_KEY, dVar.d);
            writableDatabase.insert("following_video_feed", null, contentValues);
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }

    public final void c() {
        getWritableDatabase().delete("following_video_feed", null, null);
    }
}
