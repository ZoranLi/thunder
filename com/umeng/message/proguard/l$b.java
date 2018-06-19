package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: MsgLogStore */
public class l$b {
    public String a;
    public String b;
    public String c;
    public long d;
    final /* synthetic */ l e;

    public l$b(l lVar, String str, String str2, String str3, long j) {
        this.e = lVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    public l$b(l lVar, Cursor cursor) {
        this.e = lVar;
        this.a = cursor.getString(cursor.getColumnIndex(l.i));
        this.b = cursor.getString(cursor.getColumnIndex(l.m));
        this.c = cursor.getString(cursor.getColumnIndex(l.n));
        this.d = cursor.getLong(cursor.getColumnIndex(l.l));
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(l.i, this.a);
        contentValues.put(l.m, this.b);
        contentValues.put(l.n, this.c);
        contentValues.put(l.l, Long.valueOf(this.d));
        return contentValues;
    }
}
