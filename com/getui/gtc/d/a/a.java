package com.getui.gtc.d.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class a {
    SQLiteOpenHelper a;

    public a(SQLiteOpenHelper sQLiteOpenHelper) {
        this.a = sQLiteOpenHelper;
    }

    public final int a(String str, String[] strArr) {
        return this.a.getWritableDatabase().delete(a(), str, strArr);
    }

    public final long a(ContentValues contentValues) {
        return this.a.getWritableDatabase().replace(a(), null, contentValues);
    }

    protected abstract String a();
}
