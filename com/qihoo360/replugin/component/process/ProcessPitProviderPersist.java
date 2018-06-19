package com.qihoo360.replugin.component.process;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.qihoo360.loader2.ag;
import com.qihoo360.replugin.a.b;

public class ProcessPitProviderPersist extends ContentProvider {
    public static final Uri a;
    public static boolean b;
    private static final String c;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c);
        stringBuilder.append(".loader.p.main");
        c = stringBuilder.toString();
        stringBuilder = new StringBuilder("content://");
        stringBuilder.append(c);
        stringBuilder.append("/main");
        a = Uri.parse(stringBuilder.toString());
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b = true;
        return ag.a(strArr, str);
    }
}
