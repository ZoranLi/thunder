package com.qihoo360.replugin.packages;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qihoo360.loader2.aj;
import com.qihoo360.loader2.n;
import com.qihoo360.loader2.o;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;

public class PluginFastInstallProvider extends ContentProvider {
    public static final String a;
    public static final Uri b;

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.c);
        stringBuilder.append(".loader.p.pip");
        a = stringBuilder.toString();
        stringBuilder = new StringBuilder("content://");
        stringBuilder.append(a);
        b = Uri.parse(stringBuilder.toString());
    }

    static ContentValues a(PluginInfo pluginInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pi", pluginInfo.getJSON().toString());
        return contentValues;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (c.a != null) {
            strArr = new StringBuilder("update: cv=");
            strArr.append(contentValues);
            c.a("PluginFastInstallPv", strArr.toString());
        }
        if (TextUtils.isEmpty(str) != null) {
            return 0;
        }
        uri = -1;
        if (str.hashCode() == 3237446) {
            if (str.equals("inst") != null) {
                uri = null;
            }
        }
        if (uri == null && contentValues != null) {
            uri = contentValues.getAsString("pi");
            if (TextUtils.isEmpty(uri) == null) {
                uri = PluginInfo.parseFromJsonText(uri);
                contentValues = n.b.n;
                str = contentValues.b;
                o a = o.a(uri);
                a.a(str.a, str.d, contentValues);
                contentValues = aj.a(a, 2, false);
                if (contentValues != null) {
                    uri = contentValues.n.g;
                } else {
                    if (c.a != null) {
                        str = new StringBuilder("not found plugin=");
                        str.append(uri.getName());
                        c.a("ws001", str.toString());
                    }
                    uri = null;
                }
                if (uri != null) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
