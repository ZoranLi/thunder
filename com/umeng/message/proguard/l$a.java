package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: MsgLogStore */
public class l$a {
    public String a;
    public long b;
    public int c;
    final /* synthetic */ l d;

    public l$a(l lVar, String str, int i, long j) {
        this.d = lVar;
        this.a = str;
        this.c = i;
        this.b = j;
    }

    public l$a(l lVar, Cursor cursor) {
        this.d = lVar;
        this.a = cursor.getString(cursor.getColumnIndex(l.i));
        this.b = cursor.getLong(cursor.getColumnIndex(l.l));
        this.c = cursor.getInt(cursor.getColumnIndex("ActionType"));
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(l.i, this.a);
        contentValues.put(l.l, Long.valueOf(this.b));
        contentValues.put("ActionType", Integer.valueOf(this.c));
        return contentValues;
    }
}
