package com.qihoo360.replugin.packages;

import android.content.ContentProviderClient;
import android.content.Context;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;

/* compiled from: PluginFastInstallProviderProxy */
public final class b {
    private static final byte[] a = new byte[0];
    private static ContentProviderClient b;

    public static boolean a(Context context, PluginInfo pluginInfo) {
        if (pluginInfo.isDexExtracted()) {
            if (c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("install: Already loaded, no need to install. pi=");
                stringBuilder.append(pluginInfo);
                c.c("PluginFastInstallPr", stringBuilder.toString());
            }
            return true;
        }
        context = a(context);
        if (context == null) {
            return false;
        }
        try {
            context = context.update(PluginFastInstallProvider.b, PluginFastInstallProvider.a(pluginInfo), "inst", null);
            if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("install: Install. pi=");
                stringBuilder2.append(pluginInfo);
                stringBuilder2.append("; result=");
                stringBuilder2.append(context);
                c.b("PluginFastInstallPr", stringBuilder2.toString());
            }
            if (context > null) {
                return true;
            }
            return false;
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        }
    }

    private static ContentProviderClient a(Context context) {
        if (b != null) {
            return b;
        }
        synchronized (a) {
            if (b != null) {
                context = b;
                return context;
            }
            context = context.getContentResolver();
            if (context == null) {
                return null;
            }
            context = context.acquireContentProviderClient(PluginFastInstallProvider.b);
            if (context == null) {
                return null;
            }
            b = context;
            return context;
        }
    }
}
