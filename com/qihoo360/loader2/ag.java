package com.qihoo360.loader2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.IBinder;
import android.text.TextUtils;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.loader2.b.a;
import com.qihoo360.loader2.b.b;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.process.ProcessPitProviderBase;
import com.qihoo360.replugin.component.process.ProcessPitProviderPersist;
import java.util.Arrays;

/* compiled from: PluginProviderStub */
public final class ag {
    static b a;
    static a b;
    private static final String[] c = new String[]{RePlugin.PLUGIN_NAME_MAIN};

    public static final Cursor a(String[] strArr, String str) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("stubMain projection=");
            stringBuilder.append(Arrays.toString(strArr));
            stringBuilder.append(" selection=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        if ("main_binder".equals(str) != null) {
            return BinderCursor.a(n.b.l);
        }
        if ("main_pref".equals(str) == null) {
            return null;
        }
        if (a == null) {
            strArr = new b();
            a = strArr;
            b = strArr;
        }
        return BinderCursor.a(a);
    }

    public static final Uri a(ContentValues contentValues) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("stubPlugin values=");
            stringBuilder.append(contentValues);
            c.a("ws001", stringBuilder.toString());
        }
        if (!TextUtils.equals(contentValues.getAsString("main_method"), "start_process")) {
            return null;
        }
        Uri build = new Builder().scheme("content").authority(IPluginManager.KEY_PROCESS).encodedPath("status").encodedQuery("loaded=1").build();
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("plugin provider: return uri=");
            stringBuilder2.append(build);
            c.a("ws001", stringBuilder2.toString());
        }
        long longValue = contentValues.getAsLong("cookie").longValue();
        StringBuilder stringBuilder3;
        if (n.b.j == 0) {
            if (c.a != null) {
                stringBuilder3 = new StringBuilder("set cookie: ");
                stringBuilder3.append(longValue);
                c.a("ws001", stringBuilder3.toString());
            }
            n.b.j = longValue;
        } else if (n.b.j != longValue) {
            if (c.a != null) {
                stringBuilder3 = new StringBuilder("reset cookie: ");
                stringBuilder3.append(longValue);
                c.a("ws001", stringBuilder3.toString());
            }
            n.b.j = longValue;
            ac.b();
        }
        return build;
    }

    static final IBinder a(Context context) {
        return a(context, "main_binder");
    }

    private static final IBinder a(Context context, String str) {
        Cursor query;
        try {
            query = context.getContentResolver().query(ProcessPitProviderPersist.a, c, str, null, null);
            if (query == null) {
                try {
                    if (c.a != null) {
                        c.a("ws001", "proxy fetch binder: cursor is null");
                    }
                    com.qihoo360.replugin.utils.b.a(query);
                    return null;
                } catch (Throwable th) {
                    str = th;
                }
            } else {
                do {
                } while (query.moveToNext() != null);
                str = BinderCursor.a(query);
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("proxy fetch binder: binder=");
                    stringBuilder.append(str);
                    c.a("ws001", stringBuilder.toString());
                }
                com.qihoo360.replugin.utils.b.a(query);
                return str;
            }
        } catch (Throwable th2) {
            str = th2;
            query = null;
            com.qihoo360.replugin.utils.b.a(query);
            throw str;
        }
    }

    static final boolean a(Context context, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("main_method", "start_process");
        contentValues.put("cookie", Long.valueOf(n.b.j));
        context = context.getContentResolver().insert(ProcessPitProviderBase.buildUri(i), contentValues);
        if (c.a != 0) {
            String str = "ws001";
            StringBuilder stringBuilder = new StringBuilder("proxyStartPluginProcess insert.rc=");
            stringBuilder.append(context != null ? context.toString() : "null");
            c.a(str, stringBuilder.toString());
        }
        if (context != null) {
            return true;
        }
        if (c.a != null) {
            c.a("ws001", "proxyStartPluginProcess failed");
        }
        return null;
    }
}
