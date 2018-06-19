package com.qihoo360.mobilesafe.svcmanager;

import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo360.loader2.PluginBinderInfo;
import com.qihoo360.loader2.ac;
import com.qihoo360.loader2.m;
import com.qihoo360.mobilesafe.a.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PluginServiceManager */
class c {
    private static final boolean a;
    private static final String b;
    private static Map<String, PluginServiceRecord> c = new HashMap();

    c() {
    }

    static {
        boolean z = a.a;
        a = z;
        b = z ? "PluginServiceManager" : c.class.getSimpleName();
    }

    static IBinder a(String str, String str2, int i, IBinder iBinder) throws RemoteException {
        PluginServiceRecord pluginServiceRecord;
        synchronized (c) {
            String a = a(str, str2);
            pluginServiceRecord = (PluginServiceRecord) c.get(a);
            if (!(pluginServiceRecord == null || pluginServiceRecord.isServiceAlive())) {
                pluginServiceRecord = null;
            }
            if (pluginServiceRecord == null) {
                pluginServiceRecord = new PluginServiceRecord(str, str2);
                c.put(a, pluginServiceRecord);
            }
        }
        return pluginServiceRecord.getService(i, iBinder);
    }

    static void a(String str, String str2, int i) {
        synchronized (c) {
            PluginServiceRecord pluginServiceRecord = (PluginServiceRecord) c.get(a(str, str2));
            if (pluginServiceRecord != null && pluginServiceRecord.decrementProcessRef(i) <= null) {
                a(pluginServiceRecord);
            }
        }
    }

    static void b(String str, String str2, int i) {
        synchronized (c) {
            PluginServiceRecord pluginServiceRecord = (PluginServiceRecord) c.get(a(str, str2));
            if (pluginServiceRecord != null && pluginServiceRecord.refProcessDied(i) <= null) {
                a(pluginServiceRecord);
            }
        }
    }

    private static void a(PluginServiceRecord pluginServiceRecord) {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder("[removePluginServiceRecord]: ");
            stringBuilder.append(pluginServiceRecord.mPluginName);
            stringBuilder.append(", ");
            stringBuilder.append(pluginServiceRecord.mServiceName);
        }
        synchronized (c) {
            String a = a(pluginServiceRecord.mPluginName, pluginServiceRecord.mServiceName);
            if (pluginServiceRecord.mPluginBinder == null) {
                return;
            }
            pluginServiceRecord = pluginServiceRecord.mPluginBinder;
            if (com.qihoo360.replugin.b.c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("MP.releasePluginBinder ... pid=");
                stringBuilder2.append(pluginServiceRecord.c);
                stringBuilder2.append(" binder=");
                stringBuilder2.append(pluginServiceRecord.d);
                com.qihoo360.replugin.b.c.a("ws001", stringBuilder2.toString());
            }
            if (com.qihoo360.replugin.b.c.a && m.a != null) {
                HashMap hashMap = m.a;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(pluginServiceRecord.a);
                stringBuilder2.append(Constants.COLON_SEPARATOR);
                stringBuilder2.append(pluginServiceRecord.b);
                hashMap.remove(stringBuilder2.toString());
            }
            PluginBinderInfo pluginBinderInfo = new PluginBinderInfo(4);
            pluginBinderInfo.b = pluginServiceRecord.c;
            try {
                ac.c().b(pluginBinderInfo, pluginServiceRecord.d);
            } catch (PluginServiceRecord pluginServiceRecord2) {
                new StringBuilder("mp.r.p.b: ").append(pluginServiceRecord2.getMessage());
            }
            c.remove(a);
        }
    }

    private static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
