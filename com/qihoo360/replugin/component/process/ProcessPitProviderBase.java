package com.qihoo360.replugin.component.process;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.qihoo360.loader2.ag;
import com.qihoo360.mobilesafe.a.a;
import com.qihoo360.replugin.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ProcessPitProviderBase extends ContentProvider {
    public static final String AUTHORITY_PREFIX;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @SuppressLint({"Override"})
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c);
        stringBuilder.append(".loader.p.main");
        AUTHORITY_PREFIX = stringBuilder.toString();
    }

    public static final Uri buildUri(int i) {
        StringBuilder stringBuilder;
        String str = "";
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("N");
            str = stringBuilder.toString();
            i *= -1;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(i);
        i = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("content://");
        stringBuilder2.append(AUTHORITY_PREFIX);
        stringBuilder2.append(i);
        stringBuilder2.append("/main");
        i = Uri.parse(stringBuilder2.toString());
        if (a.a) {
            new StringBuilder("buildUri: uri=").append(i);
        }
        return i;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return ag.a(contentValues);
    }
}
