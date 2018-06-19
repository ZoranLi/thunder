package com.qihoo360.loader2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.IBinder;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.mobilesafe.parser.manifest.ManifestParser;
import com.qihoo360.mobilesafe.svcmanager.QihooServiceManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.component.process.a;
import com.qihoo360.replugin.component.utils.PluginClientHelper;
import java.util.List;

/* compiled from: PluginCommImpl */
public final class s {
    public Context a;
    public aj b;

    s(Context context, aj ajVar) {
        this.a = context;
        this.b = ajVar;
    }

    public final IBinder a(String str, String str2) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("query: name=");
            stringBuilder.append(str);
            stringBuilder.append(" binder=");
            stringBuilder.append(str2);
            c.a("ws001", stringBuilder.toString());
        }
        b e = this.b.e(str);
        if (e != null) {
            if (c.a != null) {
                c.a("ws001", "use buildin plugin");
            }
            return e.a();
        }
        o d = this.b.d(str);
        if (d != null) {
            return d.h(str2);
        }
        if (c.a) {
            stringBuilder = new StringBuilder("query: not found plugin,  name=");
            stringBuilder.append(str);
            stringBuilder.append(" binder=");
            stringBuilder.append(str2);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public final PackageInfo a(String str) {
        PackageInfo e = o.e(o.b(str));
        if (e != null) {
            return e;
        }
        o a = this.b.a(str, this);
        if (a != null) {
            return a.n.d;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("not found plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public final ComponentList b(String str) {
        ComponentList f = o.f(o.b(str));
        if (f != null) {
            return f;
        }
        o a = this.b.a(str, this);
        if (a != null) {
            return a.n.h;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("not found plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public static List<ActivityInfo> a(Intent intent) {
        j c = ac.c();
        if (c != null) {
            try {
                return c.a(intent);
            } catch (Intent intent2) {
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("Query PluginsReceiverList fail:");
                    stringBuilder.append(intent2.toString());
                    c.d("ws001", stringBuilder.toString());
                }
            }
        }
        return null;
    }

    public final ComponentName a(Intent intent, String str, String str2, int i) {
        ActivityInfo a;
        PluginBinderInfo pluginBinderInfo = new PluginBinderInfo(1);
        String str3;
        try {
            a = a(str, str2, intent);
            if (a == null) {
                try {
                    if (c.a != null) {
                        c.a("ws001", "PACM: bindActivity: activity not found");
                    }
                    return null;
                } catch (Throwable th) {
                    str2 = th;
                    str3 = 0;
                    new StringBuilder("l.p.a spp|aac: ").append(str2.getMessage());
                    if (TextUtils.isEmpty(str3) == null) {
                        return null;
                    }
                    aj.a(intent);
                    str2 = new y(intent);
                    str2.a("plugin:", str);
                    str2.a("activity:", a.name);
                    str2.d();
                    str2.a("container:", str3);
                    str2.a(0);
                    return new ComponentName(com.qihoo360.replugin.a.b.c, str3);
                }
            }
            intent.putExtra("__themeId", a.theme);
            if (c.a) {
                c.a("theme", String.format("intent.putExtra(%s, %s);", new Object[]{a.name, Integer.valueOf(a.theme)}));
            }
            if (a.processName != null) {
                i = PluginClientHelper.a(a.processName).intValue();
            }
            i a2 = m.a(str, i, pluginBinderInfo);
            if (a2 == null) {
                return null;
            }
            str3 = a2.a(str, i, a.name, intent);
            try {
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("alloc success: container=");
                    stringBuilder.append(str3);
                    stringBuilder.append(" plugin=");
                    stringBuilder.append(str);
                    stringBuilder.append(" activity=");
                    stringBuilder.append(str2);
                    c.b("ws001", stringBuilder.toString());
                }
            } catch (Throwable th2) {
                str2 = th2;
                new StringBuilder("l.p.a spp|aac: ").append(str2.getMessage());
                if (TextUtils.isEmpty(str3) == null) {
                    return null;
                }
                aj.a(intent);
                str2 = new y(intent);
                str2.a("plugin:", str);
                str2.a("activity:", a.name);
                str2.d();
                str2.a("container:", str3);
                str2.a(0);
                return new ComponentName(com.qihoo360.replugin.a.b.c, str3);
            }
            if (TextUtils.isEmpty(str3) == null) {
                return null;
            }
            aj.a(intent);
            str2 = new y(intent);
            str2.a("plugin:", str);
            str2.a("activity:", a.name);
            str2.d();
            str2.a("container:", str3);
            str2.a(0);
            return new ComponentName(com.qihoo360.replugin.a.b.c, str3);
        } catch (Throwable th3) {
            str2 = th3;
            str3 = 0;
            a = str3;
            new StringBuilder("l.p.a spp|aac: ").append(str2.getMessage());
            if (TextUtils.isEmpty(str3) == null) {
                return null;
            }
            aj.a(intent);
            str2 = new y(intent);
            str2.a("plugin:", str);
            str2.a("activity:", a.name);
            str2.d();
            str2.a("container:", str3);
            str2.a(0);
            return new ComponentName(com.qihoo360.replugin.a.b.c, str3);
        }
    }

    public static ComponentName a(String str, int i) {
        PluginBinderInfo pluginBinderInfo = new PluginBinderInfo(2);
        try {
            if (m.a(str, i, pluginBinderInfo) == null) {
                return null;
            }
            str = new StringBuilder();
            str.append(com.qihoo360.replugin.a.b.c);
            str.append(".loader.s.Service");
            str.append(pluginBinderInfo.c);
            return new ComponentName(com.qihoo360.replugin.a.b.c, str.toString());
        } catch (String str2) {
            new StringBuilder("l.p.p spp: ").append(str2.getMessage());
            return null;
        }
    }

    public static Uri b(String str, int i) {
        PluginBinderInfo pluginBinderInfo = new PluginBinderInfo(3);
        try {
            if (m.a(str, i, pluginBinderInfo) == null) {
                return null;
            }
            str = new StringBuilder();
            str.append(com.qihoo360.replugin.a.b.c);
            str.append(".loader.p.pr");
            str.append(pluginBinderInfo.c);
            return new Builder().scheme("content").encodedAuthority(str.toString()).encodedPath(RePlugin.PLUGIN_NAME_MAIN).build();
        } catch (String str2) {
            new StringBuilder("l.p.p spp: ").append(str2.getMessage());
            return null;
        }
    }

    public final ActivityInfo a(String str, String str2, Intent intent) {
        o d = this.b.d(str);
        if (d == null) {
            if (c.a != null) {
                str2 = new StringBuilder("PACM: bindActivity: may be invalid plugin name or load plugin failed: plugin=");
                str2.append(d);
                c.a("ws001", str2.toString());
            }
            return null;
        } else if (!TextUtils.isEmpty(str2)) {
            return d.n.h.getActivity(str2);
        } else {
            str2 = this.a;
            if (str == null) {
                return null;
            }
            return Factory.queryActivityInfo(str, com.qihoo360.replugin.component.utils.b.a(str2, intent, ManifestParser.INS.getActivityFilterMap(str)));
        }
    }

    public final IBinder a(String str, String str2, int i) {
        if (com.qihoo360.replugin.a.b.e && i == -2) {
            return a(str, str2);
        }
        if (com.qihoo360.replugin.a.b.f && i == -1) {
            return a(str, str2);
        }
        String a = a.a(com.qihoo360.replugin.a.b.a);
        if (a.a.containsKey(a) && i == ((Integer) a.a.get(a)).intValue()) {
            return a(str, str2);
        }
        if (i != -2) {
            return QihooServiceManager.getPluginService(this.a, str, str2);
        }
        try {
            return ac.c().a(str, str2);
        } catch (String str3) {
            new StringBuilder("q.p.b: ").append(str3.getMessage());
            return null;
        }
    }
}
