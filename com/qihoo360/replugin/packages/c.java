package com.qihoo360.replugin.packages;

import android.os.RemoteException;
import android.text.TextUtils;
import com.qihoo360.loader2.j;
import com.qihoo360.loader2.m;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.model.PluginInfo;
import java.util.List;

/* compiled from: PluginManagerProxy */
public final class c {
    private static a a;
    private static boolean b;
    private static PluginRunningList c;

    static {
        PluginRunningList pluginRunningList = new PluginRunningList();
        c = pluginRunningList;
        pluginRunningList.a(b.a, b.b);
    }

    public static void a(j jVar) throws RemoteException {
        if (a != null) {
            if (com.qihoo360.replugin.b.c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("connectToServer: Already connected! host=");
                stringBuilder.append(a);
                com.qihoo360.replugin.b.c.d("PluginManagerClient", stringBuilder.toString());
            }
            return;
        }
        a = jVar.e();
    }

    public static void a() {
        a = null;
        b = false;
    }

    public static List<PluginInfo> b() throws RemoteException {
        return a.a();
    }

    public static List<PluginInfo> c() throws RemoteException {
        return a.a();
    }

    public static void a(String str) throws RemoteException {
        PluginInfo a = m.a(str, false);
        if (a != null) {
            if (a.isUsed()) {
                if (com.qihoo360.replugin.b.c.a) {
                    StringBuilder stringBuilder = new StringBuilder("updateUsedIfNeeded: pi.isUsed == used, ignore. used=true; pn=");
                    stringBuilder.append(str);
                    com.qihoo360.replugin.b.c.b("PluginManagerClient", stringBuilder.toString());
                }
            } else if (a.isPnPlugin() == null && a != null) {
                a.a(a.getName(), true);
            }
        }
    }

    public static boolean b(String str) throws RemoteException {
        if (c.b(str)) {
            return true;
        }
        if (a == null) {
            return null;
        }
        return a.a(str, null);
    }

    public static void d() throws RemoteException {
        if (!b && (c.a.isEmpty() ^ 1) != 0) {
            a.a(c);
            b = true;
        }
    }

    public static void c(String str) {
        c.a(str);
        if (a != null) {
            try {
                a.a(c.b, c.c, str);
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }

    public static PluginRunningList e() {
        PluginRunningList pluginRunningList;
        if (a != null) {
            try {
                pluginRunningList = new PluginRunningList(a.c());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return pluginRunningList != null ? new PluginRunningList(c) : pluginRunningList;
        }
        pluginRunningList = null;
        if (pluginRunningList != null) {
        }
    }

    public static String[] d(String str) {
        if (a != null) {
            try {
                return a.b(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return c.b(str) != null ? new String[]{c.b} : new String[0];
    }

    public static boolean a(String str, String str2) throws RemoteException {
        if (TextUtils.equals(str2, b.a)) {
            return c.b(str);
        }
        if (a == null) {
            return null;
        }
        return a.a(str, str2);
    }
}
