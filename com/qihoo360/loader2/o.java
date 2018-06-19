package com.qihoo360.loader2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.qihoo360.mobilesafe.api.b;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.model.PluginInfo;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Plugin */
public final class o {
    static final HashMap<String, String> a = new HashMap();
    static final HashMap<String, String> b = new HashMap();
    static final HashMap<String, WeakReference<ClassLoader>> c = new HashMap();
    static final HashMap<String, WeakReference<Resources>> d = new HashMap();
    static final HashMap<String, WeakReference<PackageInfo>> e = new HashMap();
    static final HashMap<String, WeakReference<ComponentList>> f = new HashMap();
    static volatile ArrayList<String> g;
    private static final byte[] q = new byte[0];
    public PluginInfo h;
    boolean i;
    Context j;
    ClassLoader k;
    s l;
    boolean m;
    public l n;
    final Handler o = new Handler(Looper.getMainLooper());
    com.qihoo360.replugin.component.a.a p;

    /* compiled from: Plugin */
    private static class a implements Runnable {
        PluginInfo a;

        a(PluginInfo pluginInfo) {
            this.a = pluginInfo;
        }

        public final void run() {
            try {
                ac.c().a(this.a);
            } catch (Throwable th) {
                new StringBuilder("ph u p i: ").append(th.getMessage());
            }
        }
    }

    public static final o a(PluginInfo pluginInfo) {
        return new o(pluginInfo);
    }

    public static final o a(Context context, o oVar, ClassLoader classLoader, s sVar) {
        if (oVar == null) {
            return null;
        }
        oVar = a(oVar.h);
        oVar.a(context, classLoader, sVar);
        return oVar;
    }

    public static final String a(String str) {
        String str2;
        synchronized (a) {
            str2 = (String) a.get(str);
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("cached pluginName: ");
                stringBuilder.append(str);
                stringBuilder.append(" -> ");
                stringBuilder.append(str2);
                c.a("ws001", stringBuilder.toString());
            }
        }
        return str2;
    }

    public static final String b(String str) {
        String str2;
        synchronized (b) {
            str2 = (String) b.get(str);
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("cached filename: ");
                stringBuilder.append(str);
                stringBuilder.append(" -> ");
                stringBuilder.append(str2);
                c.a("ws001", stringBuilder.toString());
            }
        }
        return str2;
    }

    public static final ClassLoader c(String str) {
        ClassLoader classLoader = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (c) {
                WeakReference weakReference = (WeakReference) c.get(str);
                if (weakReference != null) {
                    classLoader = (ClassLoader) weakReference.get();
                    if (classLoader == null) {
                        c.remove(str);
                    }
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("cached Dex ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(classLoader);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
        }
        return classLoader;
    }

    public static final Resources d(String str) {
        Resources resources = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (d) {
                WeakReference weakReference = (WeakReference) d.get(str);
                if (weakReference != null) {
                    resources = (Resources) weakReference.get();
                    if (resources == null) {
                        d.remove(str);
                    }
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("cached Resources ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(resources);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
        }
        return resources;
    }

    static final PackageInfo e(String str) {
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (e) {
                WeakReference weakReference = (WeakReference) e.get(str);
                if (weakReference != null) {
                    packageInfo = (PackageInfo) weakReference.get();
                    if (packageInfo == null) {
                        e.remove(str);
                    }
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("cached packageInfo ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(packageInfo);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
        }
        return packageInfo;
    }

    static final ComponentList f(String str) {
        ComponentList componentList = null;
        if (!TextUtils.isEmpty(str)) {
            synchronized (f) {
                WeakReference weakReference = (WeakReference) f.get(str);
                if (weakReference != null) {
                    componentList = (ComponentList) weakReference.get();
                    if (componentList == null) {
                        f.remove(str);
                    }
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("cached componentList ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(componentList);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
        }
        return componentList;
    }

    static final void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            WeakReference weakReference;
            StringBuilder stringBuilder;
            WeakReference weakReference2;
            synchronized (c) {
                weakReference = (WeakReference) c.get(str);
                if (weakReference != null) {
                    ClassLoader classLoader = (ClassLoader) weakReference.get();
                    c.remove(str);
                    if (c.a) {
                        stringBuilder = new StringBuilder("clear Cached Dex ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(classLoader);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
            synchronized (d) {
                weakReference2 = (WeakReference) d.get(str);
                if (weakReference2 != null) {
                    Resources resources = (Resources) weakReference2.get();
                    d.remove(str);
                    if (c.a) {
                        stringBuilder = new StringBuilder("clear Cached Resources ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(resources);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
            synchronized (e) {
                weakReference = (WeakReference) e.get(str);
                if (weakReference != null) {
                    PackageInfo packageInfo = (PackageInfo) weakReference.get();
                    e.remove(str);
                    if (c.a) {
                        stringBuilder = new StringBuilder("clear Cached packageInfo ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(packageInfo);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
            synchronized (f) {
                weakReference2 = (WeakReference) f.get(str);
                if (weakReference2 != null) {
                    ComponentList componentList = (ComponentList) weakReference2.get();
                    f.remove(str);
                    if (c.a) {
                        stringBuilder = new StringBuilder("clear Cached componentList ");
                        stringBuilder.append(str);
                        stringBuilder.append(" -> ");
                        stringBuilder.append(componentList);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
        }
    }

    private o(PluginInfo pluginInfo) {
        this.h = pluginInfo;
    }

    public final String toString() {
        if (!c.a) {
            return super.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(" {info=");
        stringBuilder.append(this.h);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }

    public final void a(Context context, ClassLoader classLoader, s sVar) {
        this.j = context;
        this.k = classLoader;
        this.l = sVar;
    }

    final ClassLoader a() {
        if (this.n == null) {
            return null;
        }
        return this.n.g;
    }

    final boolean a(int i, boolean z) {
        PluginInfo pluginInfo = this.h;
        z = b(i, z);
        if (i == 3 && z) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b();
            } else {
                this.o.postAtFrontOfQueue(new q(this));
            }
        }
        if (z && this.h != pluginInfo) {
            b.b(new a((PluginInfo) this.h.clone()));
        }
        return z;
    }

    private boolean b(int i, boolean z) {
        int i2 = i;
        int a = ah.a(this.h.getName(), this.h.getVersion());
        if (a < 0) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("loadLocked(): Disable in=");
                stringBuilder.append(r1.h.getName());
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(r1.h.getVersion());
                stringBuilder.append("; st=");
                stringBuilder.append(a);
                c.a("ws001", stringBuilder.toString());
            }
            return false;
        } else if (!r1.m) {
            String str;
            StringBuilder stringBuilder2;
            boolean z2;
            StringBuilder stringBuilder3;
            s sVar;
            r1.m = true;
            if (RePlugin.getConfig().g) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("");
                stringBuilder4.append("--- plugin: ");
                stringBuilder4.append(r1.h.getName());
                stringBuilder4.append(" ---\n");
                String stringBuilder5 = stringBuilder4.toString();
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stringBuilder5);
                stringBuilder4.append("load=");
                stringBuilder4.append(i2);
                stringBuilder4.append("\n");
                stringBuilder5 = stringBuilder4.toString();
                str = stringBuilder5;
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        String methodName = stackTraceElement.getMethodName();
                        String fileName = stackTraceElement.getFileName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        if (c.a) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(className);
                            stringBuilder2.append(".");
                            stringBuilder2.append(methodName);
                            stringBuilder2.append(k.s);
                            stringBuilder2.append(fileName);
                            stringBuilder2.append(Constants.COLON_SEPARATOR);
                            stringBuilder2.append(lineNumber);
                            stringBuilder2.append(k.t);
                            c.b("ws001", stringBuilder2.toString());
                        }
                        r4 = new StringBuilder();
                        r4.append(str);
                        r4.append(className);
                        r4.append(".");
                        r4.append(methodName);
                        r4.append(k.s);
                        r4.append(fileName);
                        r4.append(Constants.COLON_SEPARATOR);
                        r4.append(lineNumber);
                        r4.append(")\n");
                        str = r4.toString();
                    }
                }
                if (g == null) {
                    g = new ArrayList();
                }
                g.add(str);
            }
            if (z) {
                String b;
                ComponentList f;
                Resources d;
                PackageInfo e;
                if (i2 == 0) {
                    b = b(r1.h.getName());
                    PackageInfo e2 = e(b);
                    f = f(b);
                    if (!(e2 == null || f == null)) {
                        r1.n = new l(r1.j, r1.h.getName(), null, r1);
                        r1.n.d = e2;
                        r1.n.h = f;
                        if (c.a) {
                            c.b("ws000", "loadLocked(): Cached, pkgInfo loaded");
                        }
                        z2 = true;
                        if (z2) {
                            return true;
                        }
                    }
                }
                if (i2 == 1) {
                    b = b(r1.h.getName());
                    d = d(b);
                    e = e(b);
                    f = f(b);
                    if (!(d == null || e == null || f == null)) {
                        r1.n = new l(r1.j, r1.h.getName(), null, r1);
                        r1.n.e = d;
                        r1.n.d = e;
                        r1.n.h = f;
                        if (c.a) {
                            c.b("ws000", "loadLocked(): Cached, resource loaded");
                        }
                        z2 = true;
                        if (z2) {
                            return true;
                        }
                    }
                }
                if (i2 == 2) {
                    b = b(r1.h.getName());
                    d = d(b);
                    e = e(b);
                    ComponentList f2 = f(b);
                    ClassLoader c = c(b);
                    if (!(d == null || e == null || f2 == null || c == null)) {
                        r1.n = new l(r1.j, r1.h.getName(), null, r1);
                        r1.n.e = d;
                        r1.n.d = e;
                        r1.n.h = f2;
                        r1.n.g = c;
                        if (c.a) {
                            c.b("ws000", "loadLocked(): Cached, dex loaded");
                        }
                        z2 = true;
                        if (z2) {
                            return true;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return true;
                }
            }
            Context context = r1.j;
            s sVar2 = r1.l;
            String str2 = "try1";
            str = String.format("plugin_v3_%s.lock", new Object[]{r1.h.getApkFile().getName()});
            com.qihoo360.a.a.c cVar = new com.qihoo360.a.a.c(context, str);
            if (c.a) {
                StringBuilder stringBuilder6 = new StringBuilder("loadLocked(): Ready to lock! logtag = ");
                stringBuilder6.append(str2);
                stringBuilder6.append("; pn = ");
                stringBuilder6.append(r1.h.getName());
                c.b("ws001", stringBuilder6.toString());
            }
            if (!cVar.c()) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str2);
                stringBuilder3.append(": failed to lock: can't wait plugin ready");
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean a2 = a(context, sVar2, i2);
            if (c.a) {
                stringBuilder2 = new StringBuilder("load ");
                stringBuilder2.append(r1.h.getPath());
                stringBuilder2.append(" ");
                stringBuilder2.append(hashCode());
                stringBuilder2.append(" c=");
                stringBuilder2.append(i2);
                stringBuilder2.append(" rc=");
                stringBuilder2.append(a2);
                stringBuilder2.append(" delta=");
                sVar = sVar2;
                stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
                c.b("ws001", stringBuilder2.toString());
            } else {
                sVar = sVar2;
            }
            cVar.d();
            if (c.a) {
                StringBuilder stringBuilder7 = new StringBuilder("loadLocked(): Unlock! logtag = ");
                stringBuilder7.append(str2);
                stringBuilder7.append("; pn = ");
                stringBuilder7.append(r1.h.getName());
                c.b("ws001", stringBuilder7.toString());
            }
            if (!a2) {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(str2);
                stringBuilder8.append(": loading fail1");
            }
            if (a2) {
                if (c.a && RePlugin.getConfig().g && (i2 == 2 || i2 == 3)) {
                    c.a(r1.h, i2);
                    r4 = new StringBuilder("act=, loadLocked, flag=, End-1, pn=, ");
                    r4.append(r1.h.getName());
                    r4.append(", type=, ");
                    r4.append(i2);
                    c.e("RePlugin", r4.toString());
                }
                try {
                    com.qihoo360.replugin.packages.c.c(r1.h.getName());
                } catch (Throwable th) {
                    new StringBuilder("p.u.1: ").append(th.getMessage());
                }
                return true;
            }
            String str3 = "try2";
            com.qihoo360.a.a.c cVar2 = new com.qihoo360.a.a.c(context, str);
            if (!cVar2.c()) {
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append(str3);
                stringBuilder9.append(": failed to lock: can't wait plugin ready");
            }
            r1.n = null;
            File dexFile = r1.h.getDexFile();
            if (dexFile.exists()) {
                if (c.a) {
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append(str3);
                    stringBuilder10.append(": delete exist odex=");
                    stringBuilder10.append(dexFile.getAbsolutePath());
                    c.a("ws001", stringBuilder10.toString());
                }
                dexFile.delete();
            }
            if (VERSION.SDK_INT < 21) {
                try {
                    com.qihoo360.replugin.utils.c.c(r1.h.getExtraOdexDir());
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            z2 = a(context, sVar, i2);
            if (c.a) {
                stringBuilder3 = new StringBuilder("load2 ");
                stringBuilder3.append(r1.h.getPath());
                stringBuilder3.append(" ");
                stringBuilder3.append(hashCode());
                stringBuilder3.append(" c=");
                stringBuilder3.append(i2);
                stringBuilder3.append(" rc=");
                stringBuilder3.append(z2);
                stringBuilder3.append(" delta=");
                stringBuilder3.append(System.currentTimeMillis() - currentTimeMillis2);
                c.b("ws001", stringBuilder3.toString());
            }
            cVar2.d();
            if (z2) {
                if (c.a && RePlugin.getConfig().g && (i2 == 2 || i2 == 3)) {
                    c.a(r1.h, i2);
                    r4 = new StringBuilder("act=, loadLocked, flag=, End-2, pn=, ");
                    r4.append(r1.h.getName());
                    r4.append(", type=, ");
                    r4.append(i2);
                    c.e("RePlugin", r4.toString());
                }
                try {
                    com.qihoo360.replugin.packages.c.c(r1.h.getName());
                } catch (Throwable th2) {
                    new StringBuilder("p.u.2: ").append(th2.getMessage());
                }
                return true;
            }
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append(str3);
            stringBuilder11.append(": loading fail2");
            return false;
        } else if (r1.n == null) {
            if (c.a) {
                c.b("ws000", "loadLocked(): Initialized but mLoader is Null");
            }
            return false;
        } else if (i2 == 0) {
            r2 = r1.n.a();
            if (c.a) {
                r4 = new StringBuilder("loadLocked(): Initialized, pkginfo loaded = ");
                r4.append(r2);
                c.b("ws000", r4.toString());
            }
            return r2;
        } else if (i2 == 1) {
            r2 = r1.n.b();
            if (c.a) {
                r4 = new StringBuilder("loadLocked(): Initialized, resource loaded = ");
                r4.append(r2);
                c.b("ws000", r4.toString());
            }
            return r2;
        } else if (i2 == 2) {
            r2 = r1.n.c();
            if (c.a) {
                r4 = new StringBuilder("loadLocked(): Initialized, dex loaded = ");
                r4.append(r2);
                c.b("ws000", r4.toString());
            }
            return r2;
        } else {
            r2 = r1.n.d();
            if (c.a) {
                r4 = new StringBuilder("loadLocked(): Initialized, is loaded = ");
                r4.append(r2);
                c.b("ws000", r4.toString());
            }
            return r2;
        }
    }

    final IBinder h(String str) {
        try {
            return this.n.m.a.a(str);
        } catch (String str2) {
            new StringBuilder("q.b.e.m").append(str2.getMessage());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(android.content.Context r13, com.qihoo360.loader2.s r14, int r15) {
        /*
        r12 = this;
        r0 = r12.n;
        r1 = 2;
        r2 = 1;
        if (r0 != 0) goto L_0x02bd;
    L_0x0006:
        r0 = 0;
        r3 = r12.h;
        r3 = r3.getType();
        r4 = 3;
        r5 = 0;
        if (r3 != r1) goto L_0x0136;
    L_0x0011:
        r0 = "plugins_v3";
        r0 = r13.getDir(r0, r5);
        r3 = r12.h;
        r3 = r3.getDexParentDir();
        r6 = r12.h;
        r6 = r6.getApkFile();
        r6 = r6.getName();
        r7 = r12.h;
        r8 = r0.getAbsolutePath();
        r3.getAbsolutePath();
        r3 = r7.getPath();
        r9 = new java.io.File;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r10.append(r8);
        r11 = "/";
        r10.append(r11);
        r10.append(r6);
        r10 = r10.toString();
        r9.<init>(r10);
        r10 = r9.getParentFile();
        r11 = r10.exists();
        if (r11 != 0) goto L_0x006e;
    L_0x0057:
        r11 = r10.mkdirs();
        if (r11 != 0) goto L_0x006e;
    L_0x005d:
        r3 = new java.lang.StringBuilder;
        r9 = "can't create: ";
        r3.<init>(r9);
        r9 = r10.getPath();
        r3.append(r9);
        r3 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.FAIL;
        goto L_0x00ca;
    L_0x006e:
        r11 = r10.exists();
        if (r11 == 0) goto L_0x00ba;
    L_0x0074:
        r11 = r10.isDirectory();
        if (r11 != 0) goto L_0x007b;
    L_0x007a:
        goto L_0x00ba;
    L_0x007b:
        r10 = r9.exists();
        if (r10 == 0) goto L_0x0084;
    L_0x0081:
        r3 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.EXISTED;
        goto L_0x00ca;
    L_0x0084:
        r3 = com.qihoo360.replugin.utils.AssetsUtils.a(r13, r3, r8, r6);
        r10 = com.qihoo360.replugin.b.c.a;
        if (r10 == 0) goto L_0x00a4;
    L_0x008c:
        r10 = new java.lang.StringBuilder;
        r11 = "create new: ";
        r10.<init>(r11);
        r11 = r9.getPath();
        r10.append(r11);
        if (r3 == 0) goto L_0x009f;
    L_0x009c:
        r11 = " ok";
        goto L_0x00a1;
    L_0x009f:
        r11 = " error";
    L_0x00a1:
        r10.append(r11);
    L_0x00a4:
        if (r3 != 0) goto L_0x00b7;
    L_0x00a6:
        r3 = new java.lang.StringBuilder;
        r10 = "a u e rc f ";
        r3.<init>(r10);
        r9 = r9.getPath();
        r3.append(r9);
        r3 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.FAIL;
        goto L_0x00ca;
    L_0x00b7:
        r3 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.SUCCESS;
        goto L_0x00ca;
    L_0x00ba:
        r3 = new java.lang.StringBuilder;
        r9 = "can't create dir: ";
        r3.<init>(r9);
        r9 = r10.getPath();
        r3.append(r9);
        r3 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.FAIL;
    L_0x00ca:
        r9 = com.qihoo360.replugin.utils.AssetsUtils.AnonymousClass1.a;
        r3 = r3.ordinal();
        r3 = r9[r3];
        switch(r3) {
            case 1: goto L_0x010d;
            case 2: goto L_0x010b;
            default: goto L_0x00d5;
        };
    L_0x00d5:
        r3 = new java.io.File;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r9.append(r8);
        r8 = "/";
        r9.append(r8);
        r9.append(r6);
        r8 = r9.toString();
        r3.<init>(r8);
        r7 = r7.getNativeLibsDir();
        r8 = r3.getAbsolutePath();
        r7 = com.qihoo360.loader2.ab.a(r8, r7);
        if (r7 != 0) goto L_0x010b;
    L_0x00fc:
        r8 = new java.lang.StringBuilder;
        r9 = "a u e rc f so ";
        r8.<init>(r9);
        r3 = r3.getPath();
        r8.append(r3);
        goto L_0x010e;
    L_0x010b:
        r7 = r2;
        goto L_0x010e;
    L_0x010d:
        r7 = r5;
    L_0x010e:
        if (r7 != 0) goto L_0x011d;
    L_0x0110:
        r13 = new java.lang.StringBuilder;
        r14 = "p e b i p f ";
        r13.<init>(r14);
        r14 = r12.h;
        r13.append(r14);
        return r5;
    L_0x011d:
        r3 = new java.io.File;
        r3.<init>(r0, r6);
        r0 = r12.h;
        r0 = r0.clone();
        r0 = (com.qihoo360.replugin.model.PluginInfo) r0;
        r3 = r3.getPath();
        r0.setPath(r3);
        r0.setType(r2);
        goto L_0x020c;
    L_0x0136:
        r3 = r12.h;
        r3 = r3.getType();
        if (r3 != r4) goto L_0x020c;
    L_0x013e:
        r0 = new java.io.File;
        r3 = r12.h;
        r3 = r3.getPath();
        r0.<init>(r3);
        r3 = r12.h;
        r3 = r3.getV5Type();
        r0 = com.qihoo360.loader2.ar.a(r0, r3);
        if (r0 != 0) goto L_0x0162;
    L_0x0155:
        r13 = new java.lang.StringBuilder;
        r14 = "p e b v i f ";
        r13.<init>(r14);
        r14 = r12.h;
        r13.append(r14);
        return r5;
    L_0x0162:
        r3 = "plugins_v3";
        r3 = r13.getDir(r3, r5);
        r0 = r0.a(r13, r3, r2);
        if (r0 != 0) goto L_0x017b;
    L_0x016e:
        r13 = new java.lang.StringBuilder;
        r14 = "p u v f t f ";
        r13.<init>(r14);
        r14 = r12.h;
        r13.append(r14);
        return r5;
    L_0x017b:
        r6 = r0.getLowInterfaceApi();
        r7 = r12.h;
        r7 = r7.getLowInterfaceApi();
        if (r6 != r7) goto L_0x0193;
    L_0x0187:
        r6 = r0.getHighInterfaceApi();
        r7 = r12.h;
        r7 = r7.getHighInterfaceApi();
        if (r6 == r7) goto L_0x020c;
    L_0x0193:
        r6 = com.qihoo360.replugin.b.c.a;
        if (r6 == 0) goto L_0x01b4;
    L_0x0197:
        r6 = "ws001";
        r7 = new java.lang.StringBuilder;
        r8 = "v5 plugin has changed: plugin=";
        r7.<init>(r8);
        r7.append(r0);
        r8 = ", original=";
        r7.append(r8);
        r8 = r12.h;
        r7.append(r8);
        r7 = r7.toString();
        com.qihoo360.replugin.b.c.a(r6, r7);
    L_0x01b4:
        r6 = r12.h;
        r6 = r6.getApkFile();
        r6 = r6.getName();
        r7 = new java.io.File;
        r7.<init>(r3, r6);
        r3 = r7.exists();
        if (r3 != 0) goto L_0x0205;
    L_0x01c9:
        r13 = new java.lang.StringBuilder;
        r14 = "can't load: v5 plugin has changed to ";
        r13.<init>(r14);
        r14 = r0.getLowInterfaceApi();
        r13.append(r14);
        r14 = "-";
        r13.append(r14);
        r14 = r0.getHighInterfaceApi();
        r13.append(r14);
        r14 = ", orig ";
        r13.append(r14);
        r14 = r12.h;
        r14 = r14.getLowInterfaceApi();
        r13.append(r14);
        r14 = "-";
        r13.append(r14);
        r14 = r12.h;
        r14 = r14.getHighInterfaceApi();
        r13.append(r14);
        r14 = " bare not exist";
        r13.append(r14);
        return r5;
    L_0x0205:
        r0 = com.qihoo360.replugin.model.PluginInfo.build(r7);
        if (r0 != 0) goto L_0x020c;
    L_0x020b:
        return r5;
    L_0x020c:
        if (r0 == 0) goto L_0x0210;
    L_0x020e:
        r12.h = r0;
    L_0x0210:
        r0 = new com.qihoo360.loader2.l;
        r3 = r12.h;
        r3 = r3.getName();
        r6 = r12.h;
        r6 = r6.getPath();
        r0.<init>(r13, r3, r6, r12);
        r12.n = r0;
        r13 = r12.n;
        r13 = r13.a(r15);
        if (r13 != 0) goto L_0x022c;
    L_0x022b:
        return r5;
    L_0x022c:
        r13 = r12.h;	 Catch:{ RemoteException -> 0x0236 }
        r13 = r13.getName();	 Catch:{ RemoteException -> 0x0236 }
        com.qihoo360.replugin.packages.c.a(r13);	 Catch:{ RemoteException -> 0x0236 }
        goto L_0x023a;
    L_0x0236:
        r13 = move-exception;
        r13.printStackTrace();
    L_0x023a:
        if (r15 != r4) goto L_0x02bd;
    L_0x023c:
        r13 = r12.i;
        if (r13 == 0) goto L_0x025a;
    L_0x0240:
        r13 = new java.lang.StringBuilder;
        r14 = "p.lel dm ";
        r13.<init>(r14);
        r14 = r12.h;
        r14 = r14.getName();
        r13.append(r14);
        r13 = r12.n;
        r14 = new com.qihoo360.loader2.p;
        r14.<init>(r12);
        r13.k = r14;
        goto L_0x02a7;
    L_0x025a:
        r13 = com.qihoo360.replugin.b.c.a;
        if (r13 == 0) goto L_0x0273;
    L_0x025e:
        r13 = "ws001";
        r0 = new java.lang.StringBuilder;
        r3 = "Plugin.loadEntryLocked(): Load entry, info=";
        r0.<init>(r3);
        r3 = r12.h;
        r0.append(r3);
        r0 = r0.toString();
        com.qihoo360.replugin.b.c.a(r13, r0);
    L_0x0273:
        r13 = r12.n;
        r13 = r13.f();
        if (r13 == 0) goto L_0x0285;
    L_0x027b:
        r13 = r12.n;
        r13 = r13.h();
        if (r13 != 0) goto L_0x02a7;
    L_0x0283:
        r13 = r5;
        goto L_0x02ba;
    L_0x0285:
        r13 = r12.n;
        r13 = r13.e();
        if (r13 == 0) goto L_0x0296;
    L_0x028d:
        r13 = r12.n;
        r13 = r13.a(r14);
        if (r13 != 0) goto L_0x02a7;
    L_0x0295:
        goto L_0x0283;
    L_0x0296:
        r13 = r12.n;
        r13 = r13.g();
        if (r13 == 0) goto L_0x02a9;
    L_0x029e:
        r13 = r12.n;
        r13 = r13.h();
        if (r13 != 0) goto L_0x02a7;
    L_0x02a6:
        goto L_0x0283;
    L_0x02a7:
        r13 = r2;
        goto L_0x02ba;
    L_0x02a9:
        r13 = new java.lang.StringBuilder;
        r14 = "p.lel f ";
        r13.<init>(r14);
        r14 = r12.h;
        r14 = r14.getName();
        r13.append(r14);
        goto L_0x0283;
    L_0x02ba:
        if (r13 != 0) goto L_0x02bd;
    L_0x02bc:
        return r5;
    L_0x02bd:
        if (r15 != 0) goto L_0x02c6;
    L_0x02bf:
        r13 = r12.n;
        r13 = r13.a();
        return r13;
    L_0x02c6:
        if (r15 != r2) goto L_0x02cf;
    L_0x02c8:
        r13 = r12.n;
        r13 = r13.b();
        return r13;
    L_0x02cf:
        if (r15 != r1) goto L_0x02d8;
    L_0x02d1:
        r13 = r12.n;
        r13 = r13.c();
        return r13;
    L_0x02d8:
        r13 = r12.n;
        r13 = r13.d();
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.o.a(android.content.Context, com.qihoo360.loader2.s, int):boolean");
    }

    private void b() {
        if (this.i) {
            new StringBuilder("p.cal dm ").append(this.h.getName());
        } else if (this.p == null) {
            this.p = com.qihoo360.replugin.component.a.a.a(this.h.getName(), this.n.g, this.n.h, this.n.c.h);
            if (this.p != null) {
                com.qihoo360.replugin.component.a.a aVar = this.p;
                Context context = this.n.f;
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("PAC.callAttachBaseContext(): Call attachBaseContext(), cl=");
                    stringBuilder.append(aVar.b);
                    c.a("ws001", stringBuilder.toString());
                }
                try {
                    com.qihoo360.replugin.component.a.a.a.setAccessible(true);
                    com.qihoo360.replugin.component.a.a.a.invoke(aVar.c, new Object[]{context});
                } catch (Throwable th) {
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        th.printStackTrace();
                    }
                }
                aVar = this.p;
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("PAC.callOnCreate(): Call onCreate(), cl=");
                    stringBuilder2.append(aVar.b);
                    c.a("ws001", stringBuilder2.toString());
                }
                aVar.c.onCreate();
            }
        }
    }
}
