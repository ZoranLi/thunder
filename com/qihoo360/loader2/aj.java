package com.qihoo360.loader2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.qihoo360.i.IModule;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PmBase */
public class aj {
    private static final byte[] s = new byte[0];
    public final Context a;
    final HashSet<String> b = new HashSet();
    public final HashMap<String, HashMap<String, IModule>> c = new HashMap();
    public ClassLoader d;
    public final Map<String, o> e = new ConcurrentHashMap();
    public final HashMap<String, b> f = new HashMap();
    public final HashMap<String, a> g = new HashMap();
    String h;
    public o i;
    public long j;
    a k;
    an l;
    public af m;
    public s n;
    public z o;
    private final HashSet<String> p = new HashSet();
    private final HashSet<String> q = new HashSet();
    private boolean r;

    /* compiled from: PmBase */
    private static class a {
        public String a;
        String b;
        Class c;
        String d;

        private a() {
        }
    }

    static final void a(android.content.Intent r1) {
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
        r0 = "compatible";	 Catch:{ Exception -> 0x0010 }
        r1.removeExtra(r0);	 Catch:{ Exception -> 0x0010 }
        r0 = "plugin";	 Catch:{ Exception -> 0x0010 }
        r1.removeExtra(r0);	 Catch:{ Exception -> 0x0010 }
        r0 = "activity";	 Catch:{ Exception -> 0x0010 }
        r1.removeExtra(r0);	 Catch:{ Exception -> 0x0010 }
        return;
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.aj.a(android.content.Intent):void");
    }

    aj(Context context) {
        this.a = context;
        if (aa.b == -1 || aa.a()) {
            String str;
            if (aa.b == -1) {
                str = "N1";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(aa.b);
                str = stringBuilder.toString();
            }
            HashSet hashSet = this.p;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(com.qihoo360.replugin.a.b.c);
            stringBuilder2.append(".loader.p.Provider");
            stringBuilder2.append(str);
            hashSet.add(stringBuilder2.toString());
            hashSet = this.q;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(com.qihoo360.replugin.a.b.c);
            stringBuilder2.append(".loader.s.Service");
            stringBuilder2.append(str);
            hashSet.add(stringBuilder2.toString());
        }
        this.m = new af(context, this, aa.b, this.b);
        this.n = new s(context, this);
        this.o = new z(this);
    }

    final void a() {
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
        r12 = this;
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = "ws001";
        r1 = "search plugins from file system";
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x000b:
        r0 = new com.qihoo360.loader2.an;
        r1 = r12.a;
        r0.<init>(r1, r12);
        r12.l = r0;
        r0 = r12.l;
        com.qihoo360.loader2.ac.a(r0);
        com.qihoo360.loader2.ac.e();
        r0 = new com.qihoo360.loader2.c$a;
        r0.<init>();
        r12.k = r0;
        r0 = r12.a;
        r1 = r12.k;
        r2 = 0;
        r3 = 0;
        r4 = r0.getAssets();	 Catch:{ FileNotFoundException -> 0x00c2, Throwable -> 0x00b0 }
        r5 = "plugins-builtin.json";	 Catch:{ FileNotFoundException -> 0x00c2, Throwable -> 0x00b0 }
        r4 = r4.open(r5);	 Catch:{ FileNotFoundException -> 0x00c2, Throwable -> 0x00b0 }
        r2 = com.qihoo360.replugin.utils.a.a;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r2 = com.qihoo360.replugin.utils.d.a(r4, r2);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r5 = new org.json.JSONArray;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r5.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r2 = r3;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x003f:
        r6 = r5.length();	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r2 >= r6) goto L_0x00ce;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x0045:
        r6 = r5.getJSONObject(r2);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r6 == 0) goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x004b:
        r7 = "name";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r7 = r6.getString(r7);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r7 == 0) goto L_0x006f;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x0057:
        r7 = com.qihoo360.replugin.b.c.a;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r7 == 0) goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x005b:
        r7 = "ws001";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r9 = "built-in plugins config: invalid item: name is empty, json=";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.append(r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r6 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        com.qihoo360.replugin.b.c.a(r7, r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x006f:
        r6 = com.qihoo360.replugin.model.PluginInfo.buildFromBuiltInJson(r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r7 = r6.match();	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r7 != 0) goto L_0x0091;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x0079:
        r7 = com.qihoo360.replugin.b.c.a;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r7 == 0) goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x007d:
        r7 = "ws001";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r9 = "built-in plugins config: mismatch item: ";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.append(r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r6 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        com.qihoo360.replugin.b.c.d(r7, r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        goto L_0x00ab;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x0091:
        r7 = com.qihoo360.replugin.b.c.a;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        if (r7 == 0) goto L_0x00a8;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x0095:
        r7 = "ws001";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r9 = "built-in plugins config: item: ";	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.<init>(r9);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8.append(r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        r8 = r8.toString();	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
        com.qihoo360.replugin.b.c.a(r7, r8);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x00a8:
        r1.a(r6);	 Catch:{ FileNotFoundException -> 0x00c3, Throwable -> 0x00ae }
    L_0x00ab:
        r2 = r2 + 1;
        goto L_0x003f;
    L_0x00ae:
        r2 = move-exception;
        goto L_0x00b4;
    L_0x00b0:
        r4 = move-exception;
        r11 = r4;
        r4 = r2;
        r2 = r11;
    L_0x00b4:
        r5 = com.qihoo360.replugin.b.c.a;
        if (r5 == 0) goto L_0x00ce;
    L_0x00b8:
        r5 = "ws001";
        r6 = r2.getMessage();
        com.qihoo360.replugin.b.c.a(r5, r6, r2);
        goto L_0x00ce;
    L_0x00c2:
        r4 = r2;
    L_0x00c3:
        r2 = com.qihoo360.replugin.b.c.a;
        if (r2 == 0) goto L_0x00ce;
    L_0x00c7:
        r2 = "ws001";
        r5 = "plugins-builtin.json not found";
        com.qihoo360.replugin.b.c.d(r2, r5);
    L_0x00ce:
        com.qihoo360.replugin.utils.b.a(r4);
        r2 = "plugins_v3";
        r2 = r0.getDir(r2, r3);
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = com.qihoo360.replugin.RePlugin.getConfig();
        r5 = r5.c;
        r6 = com.qihoo360.replugin.b.c.a;
        if (r6 == 0) goto L_0x00fd;
    L_0x00e6:
        r6 = "ws001";
        r7 = new java.lang.StringBuilder;
        r8 = "search v5 files: dir=";
        r7.<init>(r8);
        r8 = r5.getAbsolutePath();
        r7.append(r8);
        r7 = r7.toString();
        com.qihoo360.replugin.b.c.a(r6, r7);
    L_0x00fd:
        com.qihoo360.loader2.as.a(r5, r4);
        r4 = r4.iterator();
    L_0x0104:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x015c;
    L_0x010a:
        r5 = r4.next();
        r5 = (com.qihoo360.loader2.ar) r5;
        r6 = new com.qihoo360.a.a.c;
        r7 = com.qihoo360.replugin.g.a();
        r8 = r5.b;
        r8 = r8.getParent();
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = r5.b;
        r10 = r10.getName();
        r9.append(r10);
        r10 = ".lock";
        r9.append(r10);
        r9 = r9.toString();
        r6.<init>(r7, r8, r9);
        r6 = r6.a();
        if (r6 != 0) goto L_0x0104;
    L_0x013c:
        r5 = r5.a(r0, r2, r3);
        if (r5 != 0) goto L_0x014e;
    L_0x0142:
        r5 = com.qihoo360.replugin.b.c.a;
        if (r5 == 0) goto L_0x0104;
    L_0x0146:
        r5 = "ws001";
        r6 = "search: fail to update v5 plugin";
        com.qihoo360.replugin.b.c.a(r5, r6);
        goto L_0x0104;
    L_0x014e:
        r6 = r1.c;
        r6 = r1.a(r6, r5);
        if (r6 == 0) goto L_0x0104;
    L_0x0156:
        r6 = r1.a;
        r1.a(r6, r5);
        goto L_0x0104;
    L_0x015c:
        r3 = new java.util.HashSet;
        r3.<init>();
        r4 = com.qihoo360.replugin.b.c.a;
        if (r4 == 0) goto L_0x017c;
    L_0x0165:
        r4 = "ws001";
        r5 = new java.lang.StringBuilder;
        r6 = "search plugins: dir=";
        r5.<init>(r6);
        r6 = r2.getAbsolutePath();
        r5.append(r6);
        r5 = r5.toString();
        com.qihoo360.replugin.b.c.a(r4, r5);
    L_0x017c:
        com.qihoo360.loader2.g.a(r2, r1, r3);
        r2 = r3.iterator();
    L_0x0183:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x01cc;
    L_0x0189:
        r4 = r2.next();
        r4 = (java.io.File) r4;
        r5 = com.qihoo360.replugin.b.c.a;
        if (r5 == 0) goto L_0x01aa;
    L_0x0193:
        r5 = "ws001";
        r6 = new java.lang.StringBuilder;
        r7 = "search: delete plugin dir invalid file=";
        r6.<init>(r7);
        r7 = r4.getAbsolutePath();
        r6.append(r7);
        r6 = r6.toString();
        com.qihoo360.replugin.b.c.a(r5, r6);
    L_0x01aa:
        r5 = r4.delete();
        if (r5 != 0) goto L_0x0183;
    L_0x01b0:
        r5 = com.qihoo360.replugin.b.c.a;
        if (r5 == 0) goto L_0x0183;
    L_0x01b4:
        r5 = "ws001";
        r6 = new java.lang.StringBuilder;
        r7 = "search: can't delete plugin dir invalid file=";
        r6.<init>(r7);
        r4 = r4.getAbsolutePath();
        r6.append(r4);
        r4 = r6.toString();
        com.qihoo360.replugin.b.c.a(r5, r4);
        goto L_0x0183;
    L_0x01cc:
        r3.clear();
        r2 = r1.b;
        r2 = r2.iterator();
    L_0x01d5:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0216;
    L_0x01db:
        r3 = r2.next();
        r3 = (com.qihoo360.replugin.model.PluginInfo) r3;
        r4 = com.qihoo360.replugin.b.c.a;
        if (r4 == 0) goto L_0x01f8;
    L_0x01e5:
        r4 = "ws001";
        r5 = new java.lang.StringBuilder;
        r6 = "delete obsolote plugin=";
        r5.<init>(r6);
        r5.append(r3);
        r5 = r5.toString();
        com.qihoo360.replugin.b.c.a(r4, r5);
    L_0x01f8:
        r4 = r3.deleteObsolote(r0);
        if (r4 != 0) goto L_0x01d5;
    L_0x01fe:
        r4 = com.qihoo360.replugin.b.c.a;
        if (r4 == 0) goto L_0x01d5;
    L_0x0202:
        r4 = "ws001";
        r5 = new java.lang.StringBuilder;
        r6 = "can't delete obsolote plugin=";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        com.qihoo360.replugin.b.c.a(r4, r3);
        goto L_0x01d5;
    L_0x0216:
        com.qihoo360.loader2.c.a(r0, r1);
        com.qihoo360.loader2.c.b(r0, r1);
        r0 = r12.k;
        r0 = r0.c;
        r12.b(r0);
        r0 = com.qihoo360.replugin.packages.c.b();	 Catch:{ RemoteException -> 0x022d }
        if (r0 == 0) goto L_0x022c;	 Catch:{ RemoteException -> 0x022d }
    L_0x0229:
        r12.b(r0);	 Catch:{ RemoteException -> 0x022d }
    L_0x022c:
        return;
    L_0x022d:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "lst.p: ";
        r1.<init>(r2);
        r0 = r0.getMessage();
        r1.append(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.aj.a():void");
    }

    final void b() {
        List b;
        if (c.a) {
            c.a("ws001", "list plugins from persistent process");
        }
        ac.b();
        List list = null;
        try {
            b = ac.c().b();
        } catch (Throwable th) {
            new StringBuilder("lst.p: ").append(th.getMessage());
            b = null;
        }
        if (a(b)) {
            if (c.a) {
                c.a("ws001", "plugins need to perform update operations");
            }
            try {
                list = com.qihoo360.replugin.packages.c.c();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (list != null) {
            b(list);
        } else {
            b(b);
        }
    }

    private static boolean a(List<PluginInfo> list) {
        if (list != null) {
            for (PluginInfo json : list) {
                if (json.getJSON().optJSONObject("upinfo") != null) {
                    return true;
                }
            }
        }
        return null;
    }

    private final void b(List<PluginInfo> list) {
        if (list != null) {
            for (PluginInfo pluginInfo : list) {
                a(pluginInfo, o.a(pluginInfo));
            }
        }
    }

    private void a(PluginInfo pluginInfo, o oVar) {
        if (!this.e.containsKey(pluginInfo.getAlias())) {
            if (!this.e.containsKey(pluginInfo.getPackageName())) {
                this.e.put(pluginInfo.getPackageName(), oVar);
                if (!TextUtils.isEmpty(pluginInfo.getAlias())) {
                    this.e.put(pluginInfo.getAlias(), oVar);
                }
                return;
            }
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("当前内置插件列表中已经有");
            stringBuilder.append(pluginInfo.getName());
            stringBuilder.append("，需要看看谁的版本号大。");
            c.a("ws001", stringBuilder.toString());
        }
        o oVar2 = (o) this.e.get(pluginInfo.getPackageName());
        if (oVar2 == null) {
            oVar2 = (o) this.e.get(pluginInfo.getAlias());
        }
        if (oVar2.h.getVersion() < pluginInfo.getVersion()) {
            if (c.a) {
                stringBuilder = new StringBuilder("新传入的纯APK插件, name=");
                stringBuilder.append(pluginInfo.getName());
                stringBuilder.append(", 版本号比较大,ver=");
                stringBuilder.append(pluginInfo.getVersion());
                stringBuilder.append(",以TA为准。");
                c.a("ws001", stringBuilder.toString());
            }
            this.e.put(pluginInfo.getPackageName(), oVar);
            if (!TextUtils.isEmpty(pluginInfo.getAlias())) {
                this.e.put(pluginInfo.getAlias(), oVar);
            }
        } else if (c.a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("新传入的纯APK插件");
            stringBuilder2.append(pluginInfo.getName());
            stringBuilder2.append("版本号还没有内置的大，什么都不做。");
            c.a("ws001", stringBuilder2.toString());
        }
    }

    final void c() {
        try {
            this.h = ac.c().a(com.qihoo360.replugin.a.b.a, aa.b, this.m, this.h);
        } catch (Throwable th) {
            new StringBuilder("c.n.a: ").append(th.getMessage());
        }
    }

    public final boolean a(String str, String str2, String str3, String str4, Class cls) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("addDynamicClass: class=");
            stringBuilder.append(str);
            stringBuilder.append(" plugin=");
            stringBuilder.append(str2);
            stringBuilder.append(" type=");
            stringBuilder.append(str3);
            stringBuilder.append(" target=");
            stringBuilder.append(str4);
            stringBuilder.append(" def=");
            stringBuilder.append(cls);
            c.a("ws001", stringBuilder.toString());
        }
        if (this.g.containsKey(str)) {
            return false;
        }
        a aVar = new a();
        aVar.a = str2;
        aVar.b = str3;
        aVar.d = str4;
        aVar.c = cls;
        this.g.put(str, aVar);
        return true;
    }

    public final void a(String str) {
        LocalBroadcastManager.getInstance(this.a).registerReceiver(new ak(this, str), new IntentFilter(str));
    }

    public final java.lang.Class<?> b(java.lang.String r8) {
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
        r7 = this;
        r0 = com.qihoo360.replugin.component.service.server.PluginPitService.class;
        r0 = r0.getName();
        r0 = r8.startsWith(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x000c:
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x0023;
    L_0x0010:
        r0 = "PmBase";
        r1 = new java.lang.StringBuilder;
        r2 = "loadClass: Loading PitService Class... clz=";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        com.qihoo360.replugin.b.c.b(r0, r8);
    L_0x0023:
        r8 = com.qihoo360.replugin.component.service.server.PluginPitService.class;
        return r8;
    L_0x0026:
        r0 = r7.b;
        r0 = r0.contains(r8);
        if (r0 == 0) goto L_0x003a;
    L_0x002e:
        r0 = r7.m;
        r8 = r0.a(r8);
        if (r8 == 0) goto L_0x0037;
    L_0x0036:
        return r8;
    L_0x0037:
        r8 = com.qihoo360.replugin.component.dummy.DummyActivity.class;
        return r8;
    L_0x003a:
        r0 = r7.q;
        r0 = r0.contains(r8);
        if (r0 == 0) goto L_0x004c;
    L_0x0042:
        r8 = r7.f(r8);
        if (r8 == 0) goto L_0x0049;
    L_0x0048:
        return r8;
    L_0x0049:
        r8 = com.qihoo360.replugin.component.dummy.DummyService.class;
        return r8;
    L_0x004c:
        r0 = r7.p;
        r0 = r0.contains(r8);
        if (r0 == 0) goto L_0x005e;
    L_0x0054:
        r8 = r7.g(r8);
        if (r8 == 0) goto L_0x005b;
    L_0x005a:
        return r8;
    L_0x005b:
        r8 = com.qihoo360.replugin.component.dummy.DummyProvider.class;
        return r8;
    L_0x005e:
        r0 = r7.g;
        r0 = r0.get(r8);
        r0 = (com.qihoo360.loader2.aj.a) r0;
        if (r0 == 0) goto L_0x01db;
    L_0x0068:
        r1 = com.qihoo360.replugin.g.a();
        r2 = r0.a;
        r2 = com.qihoo360.loader2.w.a(r2);
        r3 = com.qihoo360.replugin.b.c.a;
        if (r3 == 0) goto L_0x00c3;
    L_0x0076:
        r3 = "loadClass";
        r4 = new java.lang.StringBuilder;
        r5 = "desc=";
        r4.<init>(r5);
        r4.append(r2);
        r4 = r4.toString();
        com.qihoo360.replugin.b.c.a(r3, r4);
        if (r2 == 0) goto L_0x00a0;
    L_0x008b:
        r3 = "loadClass";
        r4 = new java.lang.StringBuilder;
        r5 = "desc.isLarge()=";
        r4.<init>(r5);
        r5 = r2.b;
        r4.append(r5);
        r4 = r4.toString();
        com.qihoo360.replugin.b.c.a(r3, r4);
    L_0x00a0:
        r3 = "loadClass";
        r4 = new java.lang.StringBuilder;
        r5 = "RePlugin.isPluginDexExtracted(";
        r4.<init>(r5);
        r5 = r0.a;
        r4.append(r5);
        r5 = ") = ";
        r4.append(r5);
        r5 = r0.a;
        r5 = com.qihoo360.replugin.RePlugin.isPluginDexExtracted(r5);
        r4.append(r5);
        r4 = r4.toString();
        com.qihoo360.replugin.b.c.a(r3, r4);
    L_0x00c3:
        if (r2 == 0) goto L_0x00ec;
    L_0x00c5:
        r3 = r2.a;
        r4 = com.qihoo360.loader2.ai.a(r3);
        if (r4 != 0) goto L_0x00ec;
    L_0x00cd:
        r8 = com.qihoo360.replugin.b.c.a;
        if (r8 == 0) goto L_0x00e9;
    L_0x00d1:
        r8 = "loadClass";
        r0 = new java.lang.StringBuilder;
        r1 = "plugin=";
        r0.<init>(r1);
        r0.append(r3);
        r1 = " not found, return DynamicClassProxyActivity.class";
        r0.append(r1);
        r0 = r0.toString();
        com.qihoo360.replugin.b.c.a(r8, r0);
    L_0x00e9:
        r8 = com.qihoo360.replugin.component.activity.DynamicClassProxyActivity.class;
        return r8;
    L_0x00ec:
        if (r2 == 0) goto L_0x00fc;
    L_0x00ee:
        r2 = r2.b;
        if (r2 == 0) goto L_0x00fc;
    L_0x00f2:
        r2 = r0.a;
        r2 = com.qihoo360.replugin.RePlugin.isPluginDexExtracted(r2);
        if (r2 != 0) goto L_0x00fc;
    L_0x00fa:
        r2 = 1;
        goto L_0x00fd;
    L_0x00fc:
        r2 = 0;
    L_0x00fd:
        r3 = com.qihoo360.replugin.b.c.a;
        if (r3 == 0) goto L_0x0114;
    L_0x0101:
        r3 = "loadClass";
        r4 = new java.lang.StringBuilder;
        r5 = "needStartLoadingActivity = ";
        r4.<init>(r5);
        r4.append(r2);
        r4 = r4.toString();
        com.qihoo360.replugin.b.c.a(r3, r4);
    L_0x0114:
        if (r2 == 0) goto L_0x012f;
    L_0x0116:
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r3.setFlags(r4);
        r4 = new android.content.ComponentName;
        r5 = com.qihoo360.replugin.a.b.c;
        r6 = "com.qihoo360.loader2.updater.PluginLoadingActivity2";
        r4.<init>(r5, r6);
        r3.setComponent(r4);
        r1.startActivity(r3);
    L_0x012f:
        r3 = r0.a;
        r3 = r7.d(r3);
        r4 = com.qihoo360.replugin.b.c.a;
        if (r4 == 0) goto L_0x014c;
    L_0x0139:
        r4 = "loadClass";
        r5 = new java.lang.StringBuilder;
        r6 = "p=";
        r5.<init>(r6);
        r5.append(r3);
        r5 = r5.toString();
        com.qihoo360.replugin.b.c.a(r4, r5);
    L_0x014c:
        if (r3 == 0) goto L_0x0163;
    L_0x014e:
        r3 = r3.a();	 Catch:{ Throwable -> 0x0189 }
        r4 = r0.d;	 Catch:{ Throwable -> 0x0189 }
        r3 = r3.loadClass(r4);	 Catch:{ Throwable -> 0x0189 }
        if (r2 == 0) goto L_0x0162;	 Catch:{ Throwable -> 0x0189 }
    L_0x015a:
        r2 = new com.qihoo360.loader2.al;	 Catch:{ Throwable -> 0x0189 }
        r2.<init>(r7, r1);	 Catch:{ Throwable -> 0x0189 }
        com.qihoo360.mobilesafe.api.b.c(r2);	 Catch:{ Throwable -> 0x0189 }
    L_0x0162:
        return r3;
    L_0x0163:
        r2 = com.qihoo360.replugin.b.c.a;
        if (r2 == 0) goto L_0x0181;
    L_0x0167:
        r2 = "loadClass";
        r3 = new java.lang.StringBuilder;
        r4 = "加载 ";
        r3.<init>(r4);
        r4 = r0.a;
        r3.append(r4);
        r4 = " 失败";
        r3.append(r4);
        r3 = r3.toString();
        com.qihoo360.replugin.b.c.a(r2, r3);
    L_0x0181:
        r2 = new com.qihoo360.loader2.am;
        r2.<init>(r7, r1);
        com.qihoo360.mobilesafe.api.b.c(r2);
    L_0x0189:
        r1 = new java.lang.StringBuilder;
        r2 = "p m hlc dc failed: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = " t=";
        r1.append(r8);
        r8 = r0.d;
        r1.append(r8);
        r8 = " tp=";
        r1.append(r8);
        r8 = r0.b;
        r1.append(r8);
        r8 = " df=";
        r1.append(r8);
        r8 = r0.c;
        r1.append(r8);
        r8 = "activity";
        r1 = r0.b;
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x01be;
    L_0x01bb:
        r8 = com.qihoo360.replugin.component.dummy.DummyActivity.class;
        return r8;
    L_0x01be:
        r8 = "service";
        r1 = r0.b;
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x01cb;
    L_0x01c8:
        r8 = com.qihoo360.replugin.component.dummy.DummyService.class;
        return r8;
    L_0x01cb:
        r8 = "provider";
        r1 = r0.b;
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x01d8;
    L_0x01d5:
        r8 = com.qihoo360.replugin.component.dummy.DummyProvider.class;
        return r8;
    L_0x01d8:
        r8 = r0.c;
        return r8;
    L_0x01db:
        r8 = r7.h(r8);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.aj.b(java.lang.String):java.lang.Class<?>");
    }

    private final Class<?> f(String str) {
        o oVar = this.i;
        if (oVar == null) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("plugin service loader: not found default plugin,  in=");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            return null;
        }
        ServiceInfo[] serviceInfoArr = oVar.n.d.services;
        if (serviceInfoArr != null) {
            if (serviceInfoArr.length > 0) {
                String str2 = serviceInfoArr[0].name;
                ClassLoader a = oVar.a();
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("plugin service loader: in=");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" target=");
                    stringBuilder2.append(str2);
                    c.a("ws001", stringBuilder2.toString());
                }
                try {
                    str = a.loadClass(str2);
                } catch (String str3) {
                    if (c.a) {
                        c.a("ws001", str3.getMessage(), str3);
                    }
                    str3 = null;
                }
                if (c.a) {
                    stringBuilder = new StringBuilder("plugin service loader: c=");
                    stringBuilder.append(str3);
                    stringBuilder.append(", loader=");
                    stringBuilder.append(a);
                    c.a("ws001", stringBuilder.toString());
                }
                return str3;
            }
        }
        if (c.a != null) {
            c.a("ws001", "plugin service loader: manifest not item found");
        }
        return null;
    }

    private final Class<?> g(String str) {
        o oVar = this.i;
        if (oVar == null) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("plugin provider loader: not found default plugin,  in=");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            return null;
        }
        ProviderInfo[] providerInfoArr = oVar.n.d.providers;
        if (providerInfoArr != null) {
            if (providerInfoArr.length > 0) {
                String str2 = providerInfoArr[0].name;
                ClassLoader a = oVar.a();
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("plugin provider loader: in=");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" target=");
                    stringBuilder2.append(str2);
                    c.a("ws001", stringBuilder2.toString());
                }
                try {
                    str = a.loadClass(str2);
                } catch (String str3) {
                    if (c.a) {
                        c.a("ws001", str3.getMessage(), str3);
                    }
                    str3 = null;
                }
                if (c.a) {
                    stringBuilder = new StringBuilder("plugin provider loader: c=");
                    stringBuilder.append(str3);
                    stringBuilder.append(", loader=");
                    stringBuilder.append(a);
                    c.a("ws001", stringBuilder.toString());
                }
                return str3;
            }
        }
        if (c.a != null) {
            c.a("ws001", "plugin provider loader: manifest not item found");
        }
        return null;
    }

    private final Class<?> h(String str) {
        o oVar = this.i;
        Class<?> cls = null;
        if (oVar == null) {
            if (aa.a() && c.a) {
                StringBuilder stringBuilder = new StringBuilder("plugin class loader: not found default plugin,  in=");
                stringBuilder.append(str);
                c.a("ws001", stringBuilder.toString());
            }
            return null;
        }
        ClassLoader a = oVar.a();
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("plugin class loader: in=");
            stringBuilder2.append(str);
            c.a("ws001", stringBuilder2.toString());
        }
        try {
            cls = a.loadClass(str);
        } catch (Throwable th) {
            if (c.a) {
                if (th.getCause() instanceof ClassNotFoundException) {
                    if (c.a) {
                        stringBuilder2 = new StringBuilder("plugin classloader not found className=");
                        stringBuilder2.append(str);
                        c.a("ws001", stringBuilder2.toString());
                    }
                } else if (c.a != null) {
                    c.a("ws001", th.getMessage(), th);
                }
            }
        }
        if (c.a != null) {
            stringBuilder = new StringBuilder("plugin class loader: c=");
            stringBuilder.append(cls);
            stringBuilder.append(", loader=");
            stringBuilder.append(a);
            c.a("ws001", stringBuilder.toString());
        }
        return cls;
    }

    public final o c(String str) {
        return (o) this.e.get(str);
    }

    final o a(String str, s sVar) {
        return a(o.a(this.a, (o) this.e.get(str), this.d, sVar), (int) null, true);
    }

    public final o d(String str) {
        return a((o) this.e.get(str), 3, true);
    }

    public static o a(o oVar, int i, boolean z) {
        if (oVar == null) {
            return null;
        }
        if (oVar.a(i, z)) {
            return oVar;
        }
        z = new StringBuilder("pmb.lp: f to l. lt=");
        z.append(i);
        z.append("; i=");
        z.append(oVar.h);
        return null;
    }

    public final o a(ClassLoader classLoader) {
        for (o oVar : this.e.values()) {
            if (oVar != null && oVar.a() == classLoader) {
                return oVar;
            }
        }
        return null;
    }

    final void a(PluginInfo pluginInfo, boolean z) {
        ai.a(pluginInfo);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("insert new plugin: info=");
            stringBuilder.append(pluginInfo);
            c.a("ws001", stringBuilder.toString());
        }
        synchronized (s) {
            RePlugin.getConfig();
            o oVar = (o) this.e.get(pluginInfo.getName());
            if ((oVar != null && oVar.h.getType() == 2 && pluginInfo.getType() == 1) || oVar == null || !oVar.m) {
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("insert new plugin: ok: plugin=");
                    stringBuilder2.append(pluginInfo);
                    c.a("ws001", stringBuilder2.toString());
                }
                oVar = o.a(pluginInfo);
                oVar.a(this.a, this.d, this.n);
                a(pluginInfo, oVar);
            } else {
                if (c.a) {
                    StringBuilder stringBuilder3 = new StringBuilder("insert new plugin: failed cause plugin has loaded, plugin=");
                    stringBuilder3.append(pluginInfo);
                    c.a("ws001", stringBuilder3.toString());
                }
                this.r = true;
            }
        }
        String name = pluginInfo.getName();
        int version = pluginInfo.getVersion();
        if (c.a) {
            stringBuilder3 = new StringBuilder("PStatusC.setStatus(): Status is OK, Clear. pn=");
            stringBuilder3.append(name);
            stringBuilder3.append("; ver=");
            stringBuilder3.append(version);
            c.a("ws001", stringBuilder3.toString());
        }
        ah.a(ah.a, name);
        if (com.qihoo360.replugin.a.b.e) {
            z = this.r;
        }
        StringBuilder stringBuilder4 = new StringBuilder("p.m. n p f n=");
        stringBuilder4.append(pluginInfo.getName());
        stringBuilder4.append(" b1=");
        stringBuilder4.append(z);
        stringBuilder4.append(" b2=");
        stringBuilder4.append(this.r);
        Intent intent = new Intent("com.qihoo360.loader2.ACTION_NEW_PLUGIN");
        intent.putExtra("plugin_info", pluginInfo);
        intent.putExtra("persist_need_restart", z);
        intent.putExtra("self_need_restart", this.r);
        LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
    }

    final void a(PluginInfo pluginInfo) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("Clear plugin cache. pn=");
            stringBuilder.append(pluginInfo.getName());
            c.a("ws001", stringBuilder.toString());
        }
        if (this.e.containsKey(pluginInfo.getName())) {
            this.e.remove(pluginInfo.getName());
        }
        ai.c(pluginInfo);
        o.g(o.b(pluginInfo.getName()));
    }

    final i a(String str, int i, PluginBinderInfo pluginBinderInfo) {
        int a;
        Throwable th;
        boolean a2;
        StringBuilder stringBuilder;
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("start plugin process: plugin=");
            stringBuilder2.append(str);
            stringBuilder2.append(" info=");
            stringBuilder2.append(pluginBinderInfo);
            c.a("ws001", stringBuilder2.toString());
        }
        if (pluginBinderInfo.a == 1 && i == Integer.MIN_VALUE) {
            i = -1;
        }
        if (pluginBinderInfo.a == 4 && r8 == Integer.MIN_VALUE) {
            i = -1;
        }
        ac.e();
        i a3 = ac.a(str, i, pluginBinderInfo);
        if (a3 != null) {
            if (c.a != 0) {
                pluginBinderInfo = new StringBuilder("start plugin process: probe client ok, already running, plugin=");
                pluginBinderInfo.append(str);
                pluginBinderInfo.append(" client=");
                pluginBinderInfo.append(a3);
                c.a("ws001", pluginBinderInfo.toString());
            }
            return a3;
        }
        try {
            a = ac.a(str, i);
            try {
                if (c.a) {
                    StringBuilder stringBuilder3 = new StringBuilder("start plugin process: alloc process ok, plugin=");
                    stringBuilder3.append(str);
                    stringBuilder3.append(" index=");
                    stringBuilder3.append(a);
                    c.a("ws001", stringBuilder3.toString());
                }
            } catch (Throwable th2) {
                th = th2;
                new StringBuilder("a.p.p: ").append(th.getMessage());
                if (a == -1) {
                }
                a2 = ag.a(this.a, a);
                if (c.a) {
                    stringBuilder = new StringBuilder("start plugin process: start process ok, plugin=");
                    stringBuilder.append(str);
                    stringBuilder.append(" index=");
                    stringBuilder.append(a);
                    c.a("ws001", stringBuilder.toString());
                }
                if (a2) {
                    return null;
                }
                i = ac.a(str, i, pluginBinderInfo);
                if (i != 0) {
                    return null;
                }
                if (c.a) {
                    stringBuilder2 = new StringBuilder("start plugin process: probe client ok, plugin=");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" index=");
                    stringBuilder2.append(pluginBinderInfo.c);
                    c.a("ws001", stringBuilder2.toString());
                }
                return i;
            }
        } catch (Throwable th3) {
            th = th3;
            a = Integer.MIN_VALUE;
            new StringBuilder("a.p.p: ").append(th.getMessage());
            if (a == -1) {
            }
            a2 = ag.a(this.a, a);
            if (c.a) {
                stringBuilder = new StringBuilder("start plugin process: start process ok, plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" index=");
                stringBuilder.append(a);
                c.a("ws001", stringBuilder.toString());
            }
            if (a2) {
                return null;
            }
            i = ac.a(str, i, pluginBinderInfo);
            if (i != 0) {
                return null;
            }
            if (c.a) {
                stringBuilder2 = new StringBuilder("start plugin process: probe client ok, plugin=");
                stringBuilder2.append(str);
                stringBuilder2.append(" index=");
                stringBuilder2.append(pluginBinderInfo.c);
                c.a("ws001", stringBuilder2.toString());
            }
            return i;
        }
        if (a == -1 && !com.qihoo360.replugin.component.process.a.a(a) && !aa.b(a)) {
            return null;
        }
        a2 = ag.a(this.a, a);
        if (c.a) {
            stringBuilder = new StringBuilder("start plugin process: start process ok, plugin=");
            stringBuilder.append(str);
            stringBuilder.append(" index=");
            stringBuilder.append(a);
            c.a("ws001", stringBuilder.toString());
        }
        if (a2) {
            return null;
        }
        i = ac.a(str, i, pluginBinderInfo);
        if (i != 0) {
            return null;
        }
        if (c.a) {
            stringBuilder2 = new StringBuilder("start plugin process: probe client ok, plugin=");
            stringBuilder2.append(str);
            stringBuilder2.append(" index=");
            stringBuilder2.append(pluginBinderInfo.c);
            c.a("ws001", stringBuilder2.toString());
        }
        return i;
    }

    final b e(String str) {
        b bVar;
        synchronized (this.f) {
            bVar = (b) this.f.get(str);
        }
        return bVar;
    }
}
