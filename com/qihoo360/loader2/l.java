package com.qihoo360.loader2;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.i.IModule;
import com.qihoo360.i.IPlugin;
import com.qihoo360.mobilesafe.parser.manifest.ManifestParser;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.model.PluginInfo;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Loader */
public final class l {
    public final String a;
    final String b;
    final o c;
    PackageInfo d;
    public Resources e;
    public Context f;
    public ClassLoader g;
    ComponentList h;
    Method i;
    Method j;
    public IPlugin k;
    j l;
    a m;
    HashSet<String> n = new HashSet();
    HashMap<String, Constructor<?>> o = new HashMap();
    private final Context p;

    /* compiled from: Loader */
    static class a implements IPlugin {
        h a;

        a(IBinder iBinder) {
            this.a = com.qihoo360.loader2.h.a.a(iBinder);
        }

        public final IModule query(Class<? extends IModule> cls) {
            try {
                this.a.a(cls.getName());
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("query(");
                stringBuilder.append(cls);
                stringBuilder.append(") exception: ");
                stringBuilder.append(th.getMessage());
            }
            return null;
        }
    }

    l(Context context, String str, String str2, o oVar) {
        this.p = context;
        this.a = str;
        this.b = str2;
        this.c = oVar;
    }

    final boolean a() {
        return this.d != null;
    }

    final boolean b() {
        return a() && this.e != null;
    }

    final boolean c() {
        return b() && this.g != null;
    }

    public final boolean d() {
        return this.k != null;
    }

    final boolean a(int i) {
        try {
            PackageManager packageManager = this.p.getPackageManager();
            this.d = o.e(this.b);
            j jVar = null;
            if (this.d == null) {
                this.d = packageManager.getPackageArchiveInfo(this.b, Opcodes.INT_TO_SHORT);
                if (this.d != null) {
                    if (this.d.applicationInfo != null) {
                        if (c.a) {
                            StringBuilder stringBuilder = new StringBuilder("get package archive info, pi=");
                            stringBuilder.append(this.d);
                            c.a("ws001", stringBuilder.toString());
                        }
                        this.d.applicationInfo.sourceDir = this.b;
                        this.d.applicationInfo.publicSourceDir = this.b;
                        if (TextUtils.isEmpty(this.d.applicationInfo.processName)) {
                            this.d.applicationInfo.processName = this.d.applicationInfo.packageName;
                        }
                        this.d.applicationInfo.nativeLibraryDir = this.c.h.getNativeLibsDir().getAbsolutePath();
                        synchronized (o.a) {
                            o.a.put(this.d.packageName, this.a);
                        }
                        synchronized (o.b) {
                            o.b.put(this.a, this.b);
                        }
                        synchronized (o.e) {
                            o.e.put(this.b, new WeakReference(this.d));
                        }
                    }
                }
                if (c.a != 0) {
                    c.a("ws001", "get package archive info null");
                }
                this.d = null;
                return false;
            }
            if (this.c.h.getFrameworkVersion() == 0) {
                this.c.h.setFrameworkVersionByMeta(this.d.applicationInfo.metaData);
            }
            this.h = o.f(this.b);
            if (this.h == null) {
                this.h = new ComponentList(this.d, this.b, this.c.h);
                String name = this.c.h.getName();
                if (this.l == null) {
                    IBinder a = ag.a(this.p);
                    if (a != null) {
                        jVar = com.qihoo360.loader2.j.a.a(a);
                    } else if (c.a) {
                        c.d("ms-receiver", "p.p fhb fail");
                    }
                    this.l = jVar;
                }
                if (this.l != null) {
                    this.l.a(name, ManifestParser.INS.getReceiverFilterMap(name));
                }
                synchronized (o.f) {
                    o.f.put(this.b, new WeakReference(this.h));
                }
                b(this.d.applicationInfo);
                a(this.a, this.d.applicationInfo);
            }
            if (i == 0) {
                return a();
            }
            StringBuilder stringBuilder2;
            this.e = o.d(this.b);
            if (this.e == null) {
                try {
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        Resources resourcesForApplication = packageManager.getResourcesForApplication(this.d.applicationInfo);
                        this.e = new Resources(resourcesForApplication.getAssets(), resourcesForApplication.getDisplayMetrics(), resourcesForApplication.getConfiguration());
                    } else {
                        this.e = packageManager.getResourcesForApplication(this.d.applicationInfo);
                    }
                    if (this.e == null) {
                        if (c.a != 0) {
                            c.a("ws001", "get resources null");
                        }
                        return false;
                    }
                    if (c.a) {
                        stringBuilder2 = new StringBuilder("get resources for app, r=");
                        stringBuilder2.append(this.e);
                        c.a("ws001", stringBuilder2.toString());
                    }
                    synchronized (o.d) {
                        o.d.put(this.b, new WeakReference(this.e));
                    }
                } catch (int i2) {
                    if (c.a) {
                        c.a("ws001", i2.getMessage(), i2);
                    }
                    return false;
                }
            }
            if (i2 == 1) {
                return b();
            }
            this.g = o.c(this.b);
            if (this.g == null) {
                ClassLoader systemClassLoader;
                long currentTimeMillis;
                boolean z;
                String path = this.c.h.getDexParentDir().getPath();
                stringBuilder2 = new StringBuilder("load ");
                stringBuilder2.append(this.b);
                stringBuilder2.append(" ...");
                if (com.qihoo360.mobilesafe.a.a.a) {
                    systemClassLoader = ClassLoader.getSystemClassLoader();
                } else {
                    systemClassLoader = getClass().getClassLoader().getParent();
                }
                ClassLoader classLoader = systemClassLoader;
                String str = this.d.applicationInfo.nativeLibraryDir;
                if (c.a) {
                    currentTimeMillis = System.currentTimeMillis();
                    File dexFile = this.c.h.getDexFile();
                    z = dexFile.exists() && dexFile.length() > 0;
                } else {
                    z = false;
                    currentTimeMillis = 0;
                }
                RePlugin.getConfig();
                this.g = new com.qihoo360.replugin.c(this.c.h, this.b, path, str, classLoader);
                StringBuilder stringBuilder3 = new StringBuilder("load ");
                stringBuilder3.append(this.b);
                stringBuilder3.append(" = ");
                stringBuilder3.append(this.g);
                if (this.g == null) {
                    if (c.a != 0) {
                        c.a("ws001", "get dex null");
                    }
                    return false;
                }
                if (c.a) {
                    if (z) {
                        stringBuilder2 = new StringBuilder(" --无需释放DEX, (plugin=");
                        stringBuilder2.append(this.a);
                        stringBuilder2.append(", version=");
                        stringBuilder2.append(this.c.h.getVersion());
                        stringBuilder2.append("), use:");
                        stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
                        stringBuilder2.append(", process:");
                        stringBuilder2.append(b.a);
                    } else {
                        stringBuilder2 = new StringBuilder(" --释放DEX, (plugin=");
                        stringBuilder2.append(this.a);
                        stringBuilder2.append(", version=");
                        stringBuilder2.append(this.c.h.getVersion());
                        stringBuilder2.append("), use:");
                        stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
                        stringBuilder2.append(", process:");
                        stringBuilder2.append(b.a);
                    }
                }
                synchronized (o.c) {
                    o.c.put(this.b, new WeakReference(this.g));
                }
            }
            if (i2 == 2) {
                return c();
            }
            this.f = new u(this.p, this.g, this.e, this.a, this);
            if (c.a != 0) {
                stringBuilder2 = new StringBuilder("pkg context=");
                stringBuilder2.append(this.f);
                c.a("ws001", stringBuilder2.toString());
            }
            return true;
        } catch (int i22) {
            StringBuilder stringBuilder4 = new StringBuilder("p=");
            stringBuilder4.append(this.b);
            stringBuilder4.append(" m=");
            stringBuilder4.append(i22.getMessage());
            return false;
        }
    }

    final boolean e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0049 }
        r1 = "com.qihoo360.plugin.";	 Catch:{ Throwable -> 0x0049 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0049 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0049 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0049 }
        r1 = ".Entry";	 Catch:{ Throwable -> 0x0049 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0049 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0049 }
        r1 = r5.g;	 Catch:{ Throwable -> 0x0049 }
        r1 = r1.loadClass(r0);	 Catch:{ Throwable -> 0x0049 }
        r2 = com.qihoo360.replugin.b.c.a;	 Catch:{ Throwable -> 0x0049 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Throwable -> 0x0049 }
    L_0x001f:
        r2 = "ws001";	 Catch:{ Throwable -> 0x0049 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0049 }
        r4 = "found entry: className=";	 Catch:{ Throwable -> 0x0049 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0049 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0049 }
        r0 = ", loader=";	 Catch:{ Throwable -> 0x0049 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0049 }
        r0 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0049 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0049 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0049 }
        com.qihoo360.replugin.b.c.a(r2, r0);	 Catch:{ Throwable -> 0x0049 }
    L_0x003e:
        r0 = "create";	 Catch:{ Throwable -> 0x0049 }
        r2 = com.qihoo360.i.Factory.PLUGIN_ENTRY_EXPORT_METHOD_PARAMS;	 Catch:{ Throwable -> 0x0049 }
        r0 = r1.getDeclaredMethod(r0, r2);	 Catch:{ Throwable -> 0x0049 }
        r5.i = r0;	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0054;
    L_0x0049:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x0054;
    L_0x004d:
        r0 = "ws001";
        r1 = "loadEntryMethod exception";
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x0054:
        r0 = r5.i;
        if (r0 == 0) goto L_0x005a;
    L_0x0058:
        r0 = 1;
        return r0;
    L_0x005a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.l.e():boolean");
    }

    final boolean a(s sVar) {
        try {
            this.k = (IPlugin) this.i.invoke(null, new Object[]{this.f, sVar});
            if (c.a != null) {
                String str = "ws001";
                StringBuilder stringBuilder = new StringBuilder("Loader.invoke(): plugin=");
                stringBuilder.append(this.b);
                stringBuilder.append(", cl=");
                stringBuilder.append(this.k != null ? this.k.getClass().getClassLoader() : "null");
                c.a(str, stringBuilder.toString());
            }
            return true;
        } catch (s sVar2) {
            sVar2.getMessage();
            return false;
        }
    }

    final boolean f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0048 }
        r1 = "com.qihoo360.plugin.";	 Catch:{ Throwable -> 0x0048 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0048 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0048 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0048 }
        r1 = ".Entry";	 Catch:{ Throwable -> 0x0048 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0048 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0048 }
        r1 = r5.g;	 Catch:{ Throwable -> 0x0048 }
        r1 = r1.loadClass(r0);	 Catch:{ Throwable -> 0x0048 }
        r2 = com.qihoo360.replugin.b.c.a;	 Catch:{ Throwable -> 0x0048 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ Throwable -> 0x0048 }
    L_0x001f:
        r2 = "ws001";	 Catch:{ Throwable -> 0x0048 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0048 }
        r4 = "found entry: className=";	 Catch:{ Throwable -> 0x0048 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0048 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0048 }
        r0 = ", loader=";	 Catch:{ Throwable -> 0x0048 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0048 }
        r0 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0048 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0048 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0048 }
        com.qihoo360.replugin.b.c.a(r2, r0);	 Catch:{ Throwable -> 0x0048 }
    L_0x003e:
        r0 = "create";	 Catch:{ Throwable -> 0x0048 }
        r2 = com.qihoo360.i.Factory.PLUGIN_ENTRY_EXPORT_METHOD2_PARAMS;	 Catch:{ Throwable -> 0x0048 }
        r0 = r1.getDeclaredMethod(r0, r2);	 Catch:{ Throwable -> 0x0048 }
        r5.j = r0;	 Catch:{ Throwable -> 0x0048 }
    L_0x0048:
        r0 = r5.j;
        if (r0 == 0) goto L_0x004e;
    L_0x004c:
        r0 = 1;
        return r0;
    L_0x004e:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.l.f():boolean");
    }

    final boolean g() {
        try {
            String str = "com.qihoo360.replugin.Entry";
            Class loadClass = this.g.loadClass(str);
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("found entry: className=");
                stringBuilder.append(str);
                stringBuilder.append(", loader=");
                stringBuilder.append(loadClass.getClassLoader());
                c.a("ws001", stringBuilder.toString());
            }
            this.j = loadClass.getDeclaredMethod(Factory.PLUGIN_ENTRY_EXPORT_METHOD_NAME, Factory.PLUGIN_ENTRY_EXPORT_METHOD2_PARAMS);
        } catch (Throwable th) {
            th.getMessage();
        }
        return this.j != null;
    }

    final boolean h() {
        try {
            IBinder iBinder = (IBinder) this.j.invoke(null, new Object[]{this.f, getClass().getClassLoader(), null});
            if (iBinder == null) {
                return false;
            }
            this.m = new a(iBinder);
            this.k = this.m;
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("Loader.invoke2(): plugin=");
                stringBuilder.append(this.b);
                stringBuilder.append(", plugin.binder.cl=");
                stringBuilder.append(iBinder.getClass().getClassLoader());
                c.a("ws001", stringBuilder.toString());
            }
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private static List<String> i() {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.c);
            stringBuilder.append(":p");
            stringBuilder.append(i);
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    private static void a(Set<String> set, ComponentInfo[] componentInfoArr) {
        if (componentInfoArr != null) {
            for (ComponentInfo componentInfo : componentInfoArr) {
                set.add(componentInfo.processName);
            }
        }
    }

    private static HashMap<String, String> a(ApplicationInfo applicationInfo) {
        HashMap<String, String> hashMap = new HashMap();
        applicationInfo = applicationInfo.metaData;
        if (applicationInfo != null) {
            if (!TextUtils.isEmpty(applicationInfo.getString("process_map"))) {
                try {
                    JSONArray jSONArray = new JSONArray(applicationInfo.getString("process_map"));
                    for (applicationInfo = null; applicationInfo < jSONArray.length(); applicationInfo++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(applicationInfo);
                        if (jSONObject != null) {
                            Object toLowerCase = jSONObject.getString("to").toLowerCase();
                            if (toLowerCase.equals("$ui")) {
                                toLowerCase = b.c;
                            } else if (toLowerCase.contains("$p")) {
                                toLowerCase = (String) com.qihoo360.replugin.component.process.a.b.get(toLowerCase);
                            }
                            hashMap.put(jSONObject.getString("from"), toLowerCase);
                        }
                    }
                } catch (ApplicationInfo applicationInfo2) {
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        applicationInfo2.printStackTrace();
                    }
                }
                return hashMap;
            }
        }
        return hashMap;
    }

    private void b(ApplicationInfo applicationInfo) {
        HashMap a = a(applicationInfo);
        if (a.isEmpty()) {
            int i = 0;
            PluginInfo a2 = m.a(this.a, false);
            if (a2 != null && a2.getFrameworkVersion() >= 4) {
                a = new HashMap();
                List i2 = i();
                Set hashSet = new HashSet();
                String str = this.h.getApplication().packageName;
                a(hashSet, this.h.getProviders());
                a(hashSet, this.h.getActivities());
                a(hashSet, this.h.getServices());
                a(hashSet, this.h.getReceivers());
                hashSet.remove(str);
                List asList = Arrays.asList(hashSet.toArray(new String[0]));
                int size = i2.size();
                if (size > 0) {
                    int size2 = asList != null ? asList.size() : 0;
                    while (i < size2) {
                        a.put(asList.get(i), i2.get(i % size));
                        i++;
                    }
                }
            }
        }
        if (c.a) {
            for (Entry entry : a.entrySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append(" -> ");
                stringBuilder.append((String) entry.getValue());
            }
        }
        a(a, this.h.getActivityMap());
        a(a, this.h.getServiceMap());
        a(a, this.h.getReceiverMap());
        a(a, this.h.getProviderMap());
        if (c.a != null) {
            new StringBuilder("--- 调整插件中组件的进程 END --- ").append(b.a);
        }
    }

    private static void a(HashMap<String, String> hashMap, HashMap<String, ? extends ComponentInfo> hashMap2) {
        if (hashMap != null) {
            if (!hashMap.isEmpty()) {
                hashMap2 = hashMap2.entrySet().iterator();
                while (hashMap2.hasNext()) {
                    ComponentInfo componentInfo = (ComponentInfo) ((Entry) hashMap2.next()).getValue();
                    if (componentInfo != null) {
                        String str = (String) hashMap.get(componentInfo.processName);
                        if (!TextUtils.isEmpty(str)) {
                            if (c.a) {
                                String.format("--- 调整组件 %s, %s -> %s", new Object[]{componentInfo.name, componentInfo.processName, str});
                            }
                            componentInfo.processName = str;
                        }
                    }
                }
            }
        }
    }

    private void a(String str, ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                boolean z = bundle.getBoolean("use_default_task_affinity", true);
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("useDefault = ");
                    stringBuilder.append(z);
                    c.a("task-affinity", stringBuilder.toString());
                }
                if (!z) {
                    if (c.a) {
                        c.a("task-affinity", String.format("替换插件 %s 中默认的 TaskAffinity", new Object[]{str}));
                    }
                    applicationInfo = applicationInfo.packageName;
                    for (Entry value : this.h.getActivityMap().entrySet()) {
                        ActivityInfo activityInfo = (ActivityInfo) value.getValue();
                        if (c.a && activityInfo != null) {
                            c.a("task-affinity", String.format("%s.taskAffinity = %s ", new Object[]{activityInfo.name, activityInfo.taskAffinity}));
                        }
                        if (activityInfo != null && activityInfo.taskAffinity.equals(applicationInfo)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(activityInfo.taskAffinity);
                            stringBuilder2.append(".");
                            stringBuilder2.append(str);
                            activityInfo.taskAffinity = stringBuilder2.toString();
                            if (c.a) {
                                c.a("task-affinity", String.format("修改 %s 的 TaskAffinity 为 %s", new Object[]{activityInfo.name, activityInfo.taskAffinity}));
                            }
                        }
                    }
                }
            }
        }
    }
}
