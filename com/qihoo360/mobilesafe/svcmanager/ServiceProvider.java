package com.qihoo360.mobilesafe.svcmanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.qihoo360.mobilesafe.a.a;
import com.qihoo360.replugin.a.b;

public class ServiceProvider extends ContentProvider {
    public static final String a;
    private static final boolean b = a.a;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c);
        stringBuilder.append(".svcmanager");
        a = stringBuilder.toString();
    }

    public boolean onCreate() {
        if (b) {
            new StringBuilder("[onCreate] App = ").append(getContext().getApplicationContext());
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (b != null) {
            new StringBuilder("[query] uri = ").append(uri == null ? "null" : uri.toString());
        }
        return g.b;
    }
}
