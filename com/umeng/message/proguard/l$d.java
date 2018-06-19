package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: MsgLogStore */
public class l$d {
    public String a;
    public String b;
    public String c;
    final /* synthetic */ l d;

    public l$d(l lVar, String str, String str2, String str3) {
        this.d = lVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public l$d(l lVar, Cursor cursor) {
        this.d = lVar;
        this.a = cursor.getString(cursor.getColumnIndex(l.i));
        this.b = cursor.getString(cursor.getColumnIndex(l.m));
        this.c = cursor.getString(cursor.getColumnIndex(l.n));
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(l.i, this.a);
        contentValues.put(l.m, this.b);
        contentValues.put(l.n, this.c);
        return contentValues;
    }
}
