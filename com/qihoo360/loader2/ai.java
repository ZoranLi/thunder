package com.qihoo360.loader2;

import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PluginTable */
final class ai {
    static final HashMap<String, PluginInfo> a = new HashMap();

    static final void a(Map<String, o> map) {
        synchronized (a) {
            map = map.values().iterator();
            while (map.hasNext()) {
                d(((o) map.next()).h);
            }
        }
    }

    static final void a(PluginInfo pluginInfo) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("update plugin table: info=");
            stringBuilder.append(pluginInfo);
            c.a("ws001", stringBuilder.toString());
        }
        synchronized (a) {
            RePlugin.getConfig();
            d(pluginInfo);
        }
    }

    static final void b(PluginInfo pluginInfo) {
        boolean z;
        synchronized (a) {
            PluginInfo pluginInfo2 = (PluginInfo) a.get(pluginInfo.getName());
            if (pluginInfo2 == null || !pluginInfo2.canReplaceForPn(pluginInfo)) {
                z = false;
            } else {
                d(pluginInfo);
                z = true;
            }
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("replace plugin table: info=");
            stringBuilder.append(pluginInfo);
            stringBuilder.append(" rc=");
            stringBuilder.append(z);
            c.a("ws001", stringBuilder.toString());
        }
    }

    static final void c(PluginInfo pluginInfo) {
        boolean z;
        synchronized (a) {
            if (((PluginInfo) a.get(pluginInfo.getName())) != null) {
                a.remove(pluginInfo.getPackageName());
                a.remove(pluginInfo.getAlias());
                z = true;
            } else {
                z = false;
            }
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("removeInfo plugin table: info=");
            stringBuilder.append(pluginInfo);
            stringBuilder.append(" rc=");
            stringBuilder.append(z);
            c.a("ws001", stringBuilder.toString());
        }
    }

    static final PluginInfo a(String str) {
        PluginInfo pluginInfo;
        synchronized (a) {
            pluginInfo = (PluginInfo) a.get(str);
        }
        return pluginInfo;
    }

    static final List<PluginInfo> a() {
        if (c.a) {
            c.a("ws001", "build plugins");
        }
        List<PluginInfo> a = m.a(false);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("build ");
            stringBuilder.append(a.size());
            stringBuilder.append(" plugins");
            c.a("ws001", stringBuilder.toString());
        }
        return a;
    }

    private static void d(PluginInfo pluginInfo) {
        a.put(pluginInfo.getPackageName(), pluginInfo);
        if (!TextUtils.isEmpty(pluginInfo.getAlias())) {
            a.put(pluginInfo.getAlias(), pluginInfo);
        }
    }
}
