package com.qihoo360.i;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.qihoo360.loader2.aj;
import com.qihoo360.loader2.o;
import com.qihoo360.loader2.s;
import com.qihoo360.loader2.z;
import com.qihoo360.mobilesafe.a.a;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import java.util.HashMap;
import java.util.List;

public final class Factory {
    public static final String PLUGIN_ENTRY_CLASS_NAME = "Entry";
    public static final Class<?>[] PLUGIN_ENTRY_EXPORT_METHOD2_PARAMS = new Class[]{Context.class, ClassLoader.class, IBinder.class};
    public static final String PLUGIN_ENTRY_EXPORT_METHOD_NAME = "create";
    public static final Class<?>[] PLUGIN_ENTRY_EXPORT_METHOD_PARAMS = new Class[]{Context.class, IPluginManager.class};
    public static final String PLUGIN_ENTRY_PACKAGE_PREFIX = "com.qihoo360.plugin";
    public static final String REPLUGIN_LIBRARY_ENTRY_PACKAGE_PREFIX = "com.qihoo360.replugin";
    public static s sPluginManager;

    @Deprecated
    public static final IModule query(String str, Class<? extends IModule> cls) {
        s sVar = sPluginManager;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("query: name=");
            stringBuilder.append(str);
            stringBuilder.append(" class=");
            stringBuilder.append(cls.getName());
            c.a("ws001", stringBuilder.toString());
        }
        HashMap hashMap = (HashMap) sVar.b.c.get(str);
        if (hashMap != null) {
            return (IModule) hashMap.get(cls.getName());
        }
        o d = sVar.b.d(str);
        if (d != null) {
            return d.n.k.query(cls);
        }
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("query: not found plugin,  name=");
            stringBuilder2.append(str);
            stringBuilder2.append(" class=");
            stringBuilder2.append(cls.getName());
            c.a("ws001", stringBuilder2.toString());
        }
        return null;
    }

    public static final boolean isPluginLoaded(String str) {
        s sVar = sPluginManager;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("isPluginLoaded: name=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        str = sVar.b.c(str);
        if (str == null || str.n == null) {
            return false;
        }
        return str.n.d();
    }

    public static final IBinder query(String str, String str2) {
        return sPluginManager.a(str, str2);
    }

    public static final IBinder query(String str, String str2, int i) {
        return sPluginManager.a(str, str2, i);
    }

    public static final Context queryPluginContext(String str) {
        o d = sPluginManager.b.d(str);
        if (d != null) {
            return d.n.f;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("not found plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public static final Resources queryPluginResouces(String str) {
        s sVar = sPluginManager;
        Resources d = o.d(o.b(str));
        if (d != null) {
            return d;
        }
        aj ajVar = sVar.b;
        o a = aj.a(o.a(ajVar.a, (o) ajVar.e.get(str), ajVar.d, sVar), 1, true);
        if (a != null) {
            return a.n.e;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("not found plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public static final PackageInfo queryPluginPackageInfo(String str) {
        return sPluginManager.a(str);
    }

    public static final PackageInfo queryPluginPackageInfo(String str, int i) {
        i = sPluginManager;
        str = o.a(str);
        return !TextUtils.isEmpty(str) ? i.a(str) : null;
    }

    public static final ComponentList queryPluginComponentList(String str) {
        return sPluginManager.b(str);
    }

    public static final ClassLoader queryPluginClassLoader(String str) {
        s sVar = sPluginManager;
        ClassLoader c = o.c(o.b(str));
        if (c != null) {
            return c;
        }
        aj ajVar = sVar.b;
        o a = aj.a(o.a(ajVar.a, (o) ajVar.e.get(str), ajVar.d, sVar), 2, true);
        if (a != null) {
            return a.n.g;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("not found plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        return null;
    }

    public static final ActivityInfo queryActivityInfo(String str, String str2) {
        str = sPluginManager.b(str);
        return str != null ? str.getActivity(str2) : null;
    }

    public static final ServiceInfo queryServiceInfo(String str, String str2) {
        str = sPluginManager.b(str);
        return str != null ? str.getService(str2) : null;
    }

    public static ActivityInfo getActivityInfo(String str, String str2, Intent intent) {
        return sPluginManager.a(str, str2, intent);
    }

    public static List<ActivityInfo> queryPluginsReceiverList(Intent intent) {
        return s.a(intent);
    }

    public static final boolean startActivity(Context context, Intent intent, String str, String str2, int i) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            intent.setComponent(RePlugin.createComponentName(str, str2));
        }
        return startActivityWithNoInjectCN(context, intent, str, str2, i);
    }

    public static final boolean startActivityWithNoInjectCN(Context context, Intent intent, String str, String str2, int i) {
        s sVar = sPluginManager;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("start activity: intent=");
            stringBuilder.append(intent);
            stringBuilder.append(" plugin=");
            stringBuilder.append(str);
            stringBuilder.append(" activity=");
            stringBuilder.append(str2);
            stringBuilder.append(" process=");
            stringBuilder.append(i);
            c.a("ws001", stringBuilder.toString());
        }
        context = sVar.b.o.a(context, intent, str, str2, i, true);
        RePlugin.getConfig();
        return context;
    }

    public static final ComponentName loadPluginActivity(Intent intent, String str, String str2, int i) {
        return sPluginManager.a(intent, str, str2, i);
    }

    public static final ComponentName loadPluginService(String str, String str2, int i) {
        return s.a(str, i);
    }

    @Deprecated
    public static final Uri loadPluginProvider(String str, String str2, int i) {
        return s.b(str, i);
    }

    public static final Uri makePluginProviderUri(String str, Uri uri, int i) {
        if (a.a == null) {
            return uri;
        }
        throw new IllegalStateException();
    }

    public static final String fetchPluginName(ClassLoader classLoader) {
        s sVar = sPluginManager;
        if (classLoader == sVar.a.getClassLoader()) {
            return RePlugin.PLUGIN_NAME_MAIN;
        }
        classLoader = sVar.b.a(classLoader);
        if (classLoader == null) {
            return null;
        }
        return classLoader.h.getName();
    }

    public static boolean startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("startActivityForResult: intent=");
            stringBuilder.append(intent);
            stringBuilder.append(" requestCode=");
            stringBuilder.append(i);
            stringBuilder.append(" options=");
            stringBuilder.append(bundle);
            c.a("ws001", stringBuilder.toString());
        }
        return z.a(activity, intent, i, bundle);
    }
}
