package com.qihoo360.loader2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.i.Factory2;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.a;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.e;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;

/* compiled from: PluginLibraryInternalProxy */
public final class z {
    public aj a;

    z(aj ajVar) {
        this.a = ajVar;
    }

    public final boolean a(Context context, Intent intent) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("start context: intent=");
            stringBuilder.append(intent);
            c.a("ws001", stringBuilder.toString());
        }
        if (intent.getBooleanExtra(IPluginManager.KEY_COMPATIBLE, false)) {
            aj.a(intent);
            if (c.a != null) {
                c.a("ws001", "start context: COMPATIBLE is true, direct start");
            }
            return false;
        }
        String stringExtra = intent.getStringExtra("activity");
        if (TextUtils.isEmpty(stringExtra)) {
            ComponentName component = intent.getComponent();
            if (component != null) {
                stringExtra = component.getClassName();
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("start context: custom context=");
                    stringBuilder2.append(context);
                    c.a("ws001", stringBuilder2.toString());
                }
            }
        }
        if (this.a.b.contains(stringExtra)) {
            aj.a(intent);
            if (c.a != null) {
                c.a("ws001", "start context: context is container, direct start");
            }
            return false;
        }
        Object stringExtra2 = intent.getStringExtra(IPluginManager.KEY_PLUGIN);
        ComponentName component2 = intent.getComponent();
        if (component2 != null) {
            if (c.a) {
                StringBuilder stringBuilder3 = new StringBuilder("isHookingClass(");
                stringBuilder3.append(stringExtra2);
                stringBuilder3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder3.append(component2.getClassName());
                stringBuilder3.append(") = ");
                stringBuilder3.append(a((String) stringExtra2, component2.getClassName()));
                c.a("loadClass", stringBuilder3.toString());
            }
            if (a((String) stringExtra2, component2.getClassName())) {
                intent.putExtra(IPluginManager.KEY_COMPATIBLE, true);
                intent.setComponent(new ComponentName(b.c, component2.getClassName()));
                context.startActivity(intent);
                return false;
            }
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                String str = null;
                a a = activity.getComponentName() != null ? this.a.m.b.a(activity.getComponentName().getClassName()) : null;
                if (a != null) {
                    str = a.c;
                }
                stringExtra2 = str;
            }
            if (c.a) {
                StringBuilder stringBuilder4 = new StringBuilder("start context: custom plugin is empty, query plugin=");
                stringBuilder4.append(stringExtra2);
                c.a("ws001", stringBuilder4.toString());
            }
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = RePlugin.fetchPluginNameByClassLoader(context.getClassLoader());
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            aj.a(intent);
            if (c.a != null) {
                c.a("ws001", "start context: plugin and context is empty, direct start");
            }
            return false;
        }
        int intExtra = intent.getIntExtra(IPluginManager.KEY_PROCESS, Integer.MIN_VALUE);
        aj.a(intent);
        return Factory.startActivityWithNoInjectCN(context, intent, stringExtra2, stringExtra, intExtra);
    }

    public final boolean a(Context context, Intent intent, String str, String str2, int i, boolean z) {
        StringBuilder stringBuilder;
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("start activity: intent=");
            stringBuilder2.append(intent);
            stringBuilder2.append(" plugin=");
            stringBuilder2.append(str);
            stringBuilder2.append(" activity=");
            stringBuilder2.append(str2);
            stringBuilder2.append(" process=");
            stringBuilder2.append(i);
            stringBuilder2.append(" download=");
            stringBuilder2.append(z);
            c.a("ws001", stringBuilder2.toString());
        }
        if (z && !ai.a(str)) {
            if (c.a) {
                stringBuilder = new StringBuilder("plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" not found, start download ...");
                c.a("ws001", stringBuilder.toString());
            }
            File file = new File(RePlugin.getConfig().c, ar.a(str));
            if (file.exists()) {
                if (c.a) {
                    StringBuilder stringBuilder3 = new StringBuilder("isNeedToDownload(): V5 file exists. Extracting... Plugin = ");
                    stringBuilder3.append(str);
                    c.a("ws001", stringBuilder3.toString());
                }
                if (m.a(file.getAbsolutePath())) {
                    if (c.a) {
                        stringBuilder = new StringBuilder("isNeedToDownload(): V5 file is Okay. Loading... Plugin = ");
                        stringBuilder.append(str);
                        c.a("ws001", stringBuilder.toString());
                    }
                    z = false;
                    if (z) {
                        return RePlugin.getConfig().a.a(str, intent);
                    }
                } else if (c.a) {
                    stringBuilder = new StringBuilder("isNeedToDownload(): V5 file is invalid. Plugin = ");
                    stringBuilder.append(str);
                    c.a("ws001", stringBuilder.toString());
                }
            } else if (c.a) {
                stringBuilder = new StringBuilder("isNeedToDownload(): V5 file not exists. Plugin = ");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            z = true;
            if (z) {
                return RePlugin.getConfig().a.a(str, intent);
            }
        }
        if (c.a) {
            stringBuilder = new StringBuilder("isHookingClass(");
            stringBuilder.append(str);
            stringBuilder.append(k.u);
            stringBuilder.append(str2);
            stringBuilder.append(") = ");
            stringBuilder.append(Factory2.isDynamicClass(str, str2));
            c.a("loadClass", stringBuilder.toString());
        }
        if (Factory2.isDynamicClass(str, str2)) {
            intent.putExtra(IPluginManager.KEY_COMPATIBLE, true);
            intent.setComponent(new ComponentName(b.c, str2));
            context.startActivity(intent);
            return true;
        } else if (ah.a(str, (int) true) >= false) {
            if (c.a != null) {
                str2 = new StringBuilder("PluginLibraryInternalProxy.startActivity(): Plugin Disabled. pn=");
                str2.append(str);
                c.a("ws001", str2.toString());
            }
            return RePlugin.getConfig().a.a(str, intent);
        } else {
            if (!RePlugin.isPluginDexExtracted(str)) {
                z = w.a(str);
                if (z && z.b) {
                    if (c.a != null) {
                        intent = new StringBuilder("PM.startActivity(): Large Plugin! p=");
                        intent.append(str);
                        c.a("ws001", intent.toString());
                    }
                    RePlugin.getConfig();
                    return false;
                }
            }
            z = new Intent(intent);
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                z.setComponent(new ComponentName(str, str2));
            }
            z = this.a.n.a(intent, str, str2, i);
            if (z) {
                intent.setComponent(z);
                if (c.a != null) {
                    str2 = new StringBuilder("start activity: real intent=");
                    str2.append(intent);
                    c.a("ws001", str2.toString());
                }
                context.startActivity(intent);
                RePlugin.getConfig();
                return true;
            }
            if (c.a != null) {
                z = new StringBuilder("plugin cn not found: intent=");
                z.append(intent);
                z.append(" plugin=");
                z.append(str);
                z.append(" activity=");
                z.append(str2);
                z.append(" process=");
                z.append(i);
                c.a("ws001", z.toString());
            }
            return false;
        }
    }

    public static JSONArray a(String str) {
        List<PluginInfo> a = m.a(false);
        JSONArray jSONArray = new JSONArray();
        synchronized (ai.a) {
            for (PluginInfo pluginInfo : a) {
                if (TextUtils.isEmpty(str) || TextUtils.equals(pluginInfo.getName(), str)) {
                    jSONArray.put(pluginInfo.getJSON());
                }
            }
        }
        return jSONArray;
    }

    public final boolean a(String str, String str2) {
        aj ajVar = this.a;
        if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str))) {
            a aVar = (a) ajVar.g.get(str2);
            if (aVar != null) {
                return str.equals(aVar.a);
            }
        }
        return null;
    }

    public static int a(Activity activity) {
        try {
            ClassLoader classLoader = activity.getClassLoader();
            String str = "android.view.ContextThemeWrapper";
            String str2 = "getThemeResId";
            Object[] objArr = new Object[0];
            Class[] clsArr = null;
            if (activity != null) {
                Class cls = Class.forName(str, false, classLoader);
                if (cls != null) {
                    Method method = cls.getMethod(str2, null);
                    if (method != null) {
                        method.setAccessible(true);
                        clsArr = method.invoke(activity, objArr);
                    }
                }
            }
            return ((Integer) clsArr).intValue();
        } catch (Activity activity2) {
            activity2.printStackTrace();
            return -1;
        }
    }

    public static int a() {
        if (a.l) {
            try {
                return ((Integer) e.a(Class.forName("android.support.v7.appcompat.R$style"), null, "Theme_AppCompat")).intValue();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
        return 16973830;
    }

    public static boolean a(Activity activity, Intent intent, int i, Bundle bundle) {
        Object obj = "";
        if (intent.getComponent() != null) {
            obj = intent.getComponent().getPackageName();
        }
        if (TextUtils.isEmpty(obj) || obj.contains(".")) {
            obj = RePlugin.fetchPluginNameByClassLoader(activity.getClassLoader());
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("start activity with startActivityForResult: intent=");
            stringBuilder.append(intent);
            c.a("ws001", stringBuilder.toString());
        }
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        ComponentName loadPluginActivity = Factory.loadPluginActivity(intent, obj, component.getClassName(), Integer.MIN_VALUE);
        if (loadPluginActivity == null) {
            return false;
        }
        intent.setComponent(loadPluginActivity);
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
        return true;
    }
}
