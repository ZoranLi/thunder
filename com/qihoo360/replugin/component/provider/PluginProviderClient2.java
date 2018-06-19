package com.qihoo360.replugin.component.provider;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.qihoo360.replugin.b.c;

public class PluginProviderClient2 {
    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentProviderClient acquireContentProviderClient = PluginProviderClient.acquireContentProviderClient(context, "");
        if (acquireContentProviderClient != null) {
            try {
                return acquireContentProviderClient.query(PluginProviderClient.toCalledUri(context, uri), strArr, str, strArr2, str2);
            } catch (Context context2) {
                if (c.a != null) {
                    context2.toString();
                }
            }
        }
        if (c.a != null) {
            String.format("call query1 %s fail", new Object[]{uri.toString()});
        }
        return null;
    }

    @TargetApi(16)
    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        ContentProviderClient acquireContentProviderClient = PluginProviderClient.acquireContentProviderClient(context, "");
        if (acquireContentProviderClient != null) {
            try {
                return acquireContentProviderClient.query(PluginProviderClient.toCalledUri(context, uri), strArr, str, strArr2, str2, cancellationSignal);
            } catch (Context context2) {
                if (c.a != null) {
                    context2.toString();
                }
            }
        }
        if (c.a != null) {
            String.format("call query2 %s fail", new Object[]{uri.toString()});
        }
        return null;
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ContentProviderClient acquireContentProviderClient = PluginProviderClient.acquireContentProviderClient(context, "");
        if (acquireContentProviderClient != null) {
            try {
                return acquireContentProviderClient.update(PluginProviderClient.toCalledUri(context, uri), contentValues, str, strArr);
            } catch (Context context2) {
                if (c.a != null) {
                    context2.toString();
                }
            }
        }
        if (c.a != null) {
            String.format("call update %s", new Object[]{uri.toString()});
        }
        return -1;
    }
}
