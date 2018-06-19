package com.qihoo360.replugin.component.provider;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.qihoo360.replugin.a.b;

public abstract class PluginPitProviderBase extends ContentProvider {
    public static final String AUTHORITY_PREFIX;
    a a;

    public boolean onCreate() {
        return true;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c);
        stringBuilder.append(".Plugin.NP.");
        AUTHORITY_PREFIX = stringBuilder.toString();
    }

    protected PluginPitProviderBase(String str) {
        this.a = new a(str);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a a = this.a.a(uri);
        if (a == null) {
            return null;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return null;
        }
        return a2.query(a.a, strArr, str, strArr2, str2);
    }

    @TargetApi(16)
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        a a = this.a.a(uri);
        if (a == null) {
            return null;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return null;
        }
        return a2.query(a.a, strArr, str, strArr2, str2, cancellationSignal);
    }

    public String getType(Uri uri) {
        a a = this.a.a(uri);
        if (a == null) {
            return null;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return null;
        }
        return a2.getType(a.a);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        a a = this.a.a(uri);
        if (a == null) {
            return null;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return null;
        }
        return a2.insert(a.a, contentValues);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        a a = this.a.a(uri);
        if (a == null) {
            return -1;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return -1;
        }
        return a2.bulkInsert(a.a, contentValuesArr);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a a = this.a.a(uri);
        if (a == null) {
            return -1;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return -1;
        }
        return a2.delete(a.a, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a a = this.a.a(uri);
        if (a == null) {
            return -1;
        }
        ContentProvider a2 = this.a.a(a);
        if (a2 == null) {
            return -1;
        }
        return a2.update(a.a, contentValues, str, strArr);
    }

    public void onLowMemory() {
        for (ContentProvider onLowMemory : this.a.a.values()) {
            onLowMemory.onLowMemory();
        }
        super.onLowMemory();
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        for (ContentProvider onTrimMemory : this.a.a.values()) {
            onTrimMemory.onTrimMemory(i);
        }
        super.onTrimMemory(i);
    }
}
