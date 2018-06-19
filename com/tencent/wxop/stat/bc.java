package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.r;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.util.ArrayList;
import java.util.List;

class bc extends SQLiteOpenHelper {
    private String a = "";
    private Context b = null;

    public bc(Context context, String str) {
        super(context, str, null, 3);
        this.a = str;
        this.b = context.getApplicationContext();
        if (StatConfig.isDebugEnable()) {
            StatLogger e = au.h;
            StringBuilder stringBuilder = new StringBuilder("SQLiteOpenHelper ");
            stringBuilder.append(this.a);
            e.i(stringBuilder.toString());
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query(MessageInfo.USER, null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    cursor = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", r.b((String) cursor));
                }
                if (cursor != null) {
                    sQLiteDatabase.update(MessageInfo.USER, contentValues, "uid=?", new String[]{cursor});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            au.h.e(th);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<bd> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new bd(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (bd bdVar : arrayList) {
                    contentValues.put("content", r.b(bdVar.b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(bdVar.a)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            au.h.e(th);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatLogger e = au.h;
        StringBuilder stringBuilder = new StringBuilder("upgrade DB from oldVersion ");
        stringBuilder.append(i);
        stringBuilder.append(" to newVersion ");
        stringBuilder.append(i2);
        e.debug(stringBuilder.toString());
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i == 2) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }
}
