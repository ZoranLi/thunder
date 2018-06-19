package com.igexin.push.core.b;

import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public class b implements a {
    private static b b;
    private Map<String, byte[]> a = new HashMap();

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }
}
