package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: MsgLogStore */
public class l$c {
    public String a;
    public String b;
    final /* synthetic */ l c;

    public l$c(l lVar, String str, String str2) {
        this.c = lVar;
        this.a = str;
        this.b = str2;
    }

    public l$c(l lVar, Cursor cursor) {
        this.c = lVar;
        this.a = cursor.getString(cursor.getColumnIndex(l.i));
        this.b = cursor.getString(cursor.getColumnIndex(l.j));
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(l.i, this.a);
        contentValues.put(l.j, this.b);
        return contentValues;
    }
}
