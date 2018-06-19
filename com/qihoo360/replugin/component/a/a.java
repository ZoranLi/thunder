package com.qihoo360.replugin.component.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: PluginApplicationClient */
public final class a {
    public static Method a;
    private static volatile boolean d;
    private static final byte[] e = new byte[0];
    private static com.qihoo360.replugin.utils.a.a<String, WeakReference<a>> h = new com.qihoo360.replugin.utils.a.a();
    public final ClassLoader b;
    public Application c;
    private final ApplicationInfo f;
    private Constructor g;

    public static a a(String str, ClassLoader classLoader, ComponentList componentList, PluginInfo pluginInfo) {
        if (pluginInfo.getFrameworkVersion() <= 1) {
            if (c.a != null) {
                componentList = new StringBuilder("PAC.create(): FrameworkVer less than 1. cl=");
                componentList.append(classLoader);
                c.a("ws001", componentList.toString());
            }
            return null;
        }
        a aVar;
        WeakReference weakReference = (WeakReference) h.get(str);
        if (weakReference == null) {
            aVar = null;
        } else {
            aVar = (a) weakReference.get();
        }
        if (aVar != null) {
            if (c.a != null) {
                componentList = new StringBuilder("PAC.create(): Already Loaded.");
                componentList.append(classLoader);
                c.a("ws001", componentList.toString());
            }
            return aVar;
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("PAC.create(): Create and load Application. cl=");
            stringBuilder.append(classLoader);
            c.a("ws001", stringBuilder.toString());
        }
        try {
            if (!d) {
                synchronized (e) {
                    if (d) {
                    } else {
                        Method declaredMethod = Application.class.getDeclaredMethod("attach", new Class[]{Context.class});
                        a = declaredMethod;
                        declaredMethod.setAccessible(true);
                        d = true;
                    }
                }
            }
            aVar = new a(classLoader, componentList, pluginInfo);
            if (aVar.d() == null) {
                return null;
            }
            h.put(str, new WeakReference(aVar));
            if (VERSION.SDK_INT >= 14) {
                g.a().registerComponentCallbacks(new b(aVar));
            }
            return aVar;
        } catch (String str2) {
            if (com.qihoo360.mobilesafe.a.a.a != null) {
                str2.printStackTrace();
            }
            return null;
        }
    }

    public static void a() {
        for (WeakReference weakReference : h.values()) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public static void a(int i) {
        for (WeakReference weakReference : h.values()) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.b(i);
            }
        }
    }

    public static void a(Configuration configuration) {
        for (WeakReference weakReference : h.values()) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.b(configuration);
            }
        }
    }

    private a(ClassLoader classLoader, ComponentList componentList, PluginInfo pluginInfo) {
        this.b = classLoader;
        this.f = componentList.getApplication();
        try {
            if (this.f != null && TextUtils.isEmpty(this.f.className) == null) {
                c();
            }
            if (d() == null && pluginInfo.getFrameworkVersion() >= 3) {
                this.c = new Application();
            }
        } catch (ClassLoader classLoader2) {
            if (com.qihoo360.mobilesafe.a.a.a != null) {
                classLoader2.printStackTrace();
            }
            this.c = new Application();
        }
    }

    public final void b() {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("PAC.callOnLowMemory(): Call onLowMemory(), cl=");
            stringBuilder.append(this.b);
            c.a("ws001", stringBuilder.toString());
        }
        this.c.onLowMemory();
    }

    public final void b(int i) {
        if (VERSION.SDK_INT >= 14) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("PAC.callOnLowMemory(): Call onTrimMemory(), cl=");
                stringBuilder.append(this.b);
                stringBuilder.append("; lv=");
                stringBuilder.append(i);
                c.a("ws001", stringBuilder.toString());
            }
            this.c.onTrimMemory(i);
        }
    }

    public final void b(Configuration configuration) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("PAC.callOnLowMemory(): Call onConfigurationChanged(), cl=");
            stringBuilder.append(this.b);
            stringBuilder.append("; nc=");
            stringBuilder.append(configuration);
            c.a("ws001", stringBuilder.toString());
        }
        this.c.onConfigurationChanged(configuration);
    }

    private boolean d() {
        return this.c != null;
    }

    private boolean c() {
        boolean z = false;
        try {
            this.g = this.b.loadClass(this.f.className).getConstructor(new Class[0]);
            Object newInstance = this.g.newInstance(new Object[0]);
            if (newInstance instanceof Application) {
                this.c = (Application) newInstance;
            }
            if (this.c != null) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            if (com.qihoo360.mobilesafe.a.a.a) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
