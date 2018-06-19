package com.qihoo360.loader2;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo360.a.a.c;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: MP */
public final class m {
    public static volatile HashMap<String, String> a;

    /* compiled from: MP */
    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final IBinder d;

        a(String str, String str2, int i, IBinder iBinder) {
            this.a = str;
            this.b = str2;
            this.d = iBinder;
            this.c = i;
        }
    }

    public static final com.qihoo360.loader2.m.a a(java.lang.String r9, java.lang.String r10) {
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
        r0 = com.qihoo360.replugin.b.c.a;
        if (r0 == 0) goto L_0x001f;
    L_0x0004:
        r0 = "ws001";
        r1 = new java.lang.StringBuilder;
        r2 = "MP.fetchPluginBinder ... plugin=";
        r1.<init>(r2);
        r1.append(r9);
        r2 = " binder.name=";
        r1.append(r2);
        r1.append(r10);
        r1 = r1.toString();
        com.qihoo360.replugin.b.c.a(r0, r1);
    L_0x001f:
        r0 = com.qihoo360.replugin.RePlugin.getConfig();
        r0 = r0.g;
        if (r0 == 0) goto L_0x00a0;
    L_0x0027:
        r0 = "";
        r1 = java.lang.Thread.currentThread();
        r1 = r1.getStackTrace();
        r2 = r1.length;
        r3 = 0;
    L_0x0033:
        if (r3 >= r2) goto L_0x007c;
    L_0x0035:
        r4 = r1[r3];
        r5 = r4.isNativeMethod();
        if (r5 != 0) goto L_0x0079;
    L_0x003d:
        r5 = r4.getClassName();
        r6 = r4.getMethodName();
        r7 = r4.getFileName();
        r4 = r4.getLineNumber();
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r8.append(r0);
        r8.append(r5);
        r0 = ".";
        r8.append(r0);
        r8.append(r6);
        r0 = "(";
        r8.append(r0);
        r8.append(r7);
        r0 = ":";
        r8.append(r0);
        r8.append(r4);
        r0 = ")\n";
        r8.append(r0);
        r0 = r8.toString();
    L_0x0079:
        r3 = r3 + 1;
        goto L_0x0033;
    L_0x007c:
        r1 = a;
        if (r1 != 0) goto L_0x0087;
    L_0x0080:
        r1 = new java.util.HashMap;
        r1.<init>();
        a = r1;
    L_0x0087:
        r1 = a;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r9);
        r3 = ":";
        r2.append(r3);
        r2.append(r10);
        r2 = r2.toString();
        r1.put(r2, r0);
    L_0x00a0:
        r0 = new com.qihoo360.loader2.PluginBinderInfo;
        r1 = 4;
        r0.<init>(r1);
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = 0;
        r1 = a(r9, r1, r0);	 Catch:{ Throwable -> 0x00df }
        if (r1 != 0) goto L_0x00b0;	 Catch:{ Throwable -> 0x00df }
    L_0x00af:
        return r2;	 Catch:{ Throwable -> 0x00df }
    L_0x00b0:
        r1 = r1.a(r9, r10);	 Catch:{ Throwable -> 0x00df }
        r3 = com.qihoo360.replugin.b.c.a;	 Catch:{ Throwable -> 0x00e0 }
        if (r3 == 0) goto L_0x00d5;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00b8:
        r3 = "ws001";	 Catch:{ Throwable -> 0x00e0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e0 }
        r5 = "MP.fetchPluginBinder binder.object=";	 Catch:{ Throwable -> 0x00e0 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00e0 }
        r4.append(r1);	 Catch:{ Throwable -> 0x00e0 }
        r5 = " pid=";	 Catch:{ Throwable -> 0x00e0 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00e0 }
        r5 = r0.b;	 Catch:{ Throwable -> 0x00e0 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00e0 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00e0 }
        com.qihoo360.replugin.b.c.a(r3, r4);	 Catch:{ Throwable -> 0x00e0 }
    L_0x00d5:
        if (r1 == 0) goto L_0x00ec;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00d7:
        r3 = com.qihoo360.loader2.ac.c();	 Catch:{ Throwable -> 0x00e0 }
        r3.a(r0, r1);	 Catch:{ Throwable -> 0x00e0 }
        goto L_0x00ec;
    L_0x00df:
        r1 = r2;
    L_0x00e0:
        r3 = new java.lang.StringBuilder;
        r4 = "mp.f.p.b: p=";
        r3.<init>(r4);
        r4 = r0.b;
        r3.append(r4);
    L_0x00ec:
        if (r1 != 0) goto L_0x00ef;
    L_0x00ee:
        return r2;
    L_0x00ef:
        r2 = new com.qihoo360.loader2.m$a;
        r0 = r0.b;
        r2.<init>(r9, r10, r0, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.m.a(java.lang.String, java.lang.String):com.qihoo360.loader2.m$a");
    }

    public static final PluginInfo a(String str) {
        c cVar;
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder = new StringBuilder("MP.pluginDownloaded ... path=");
            stringBuilder.append(str);
            com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
        }
        if (str != null) {
            try {
                File file = new File(str);
                String name = file.getName();
                String parent = file.getParent();
                if (name.startsWith("p-n-")) {
                    Context a = g.a();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(name);
                    stringBuilder2.append(".lock");
                    cVar = new c(a, parent, stringBuilder2.toString());
                    if (cVar != null) {
                        try {
                            if (!cVar.b() && com.qihoo360.replugin.b.c.a) {
                                StringBuilder stringBuilder3 = new StringBuilder("MP.pluginDownloaded ... lock file + ");
                                stringBuilder3.append(str);
                                stringBuilder3.append(" failed! ");
                                com.qihoo360.replugin.b.c.a("ws001", stringBuilder3.toString());
                            }
                        } catch (Throwable th) {
                            str = th;
                            new StringBuilder("mp.pded: ").append(str.getMessage());
                            if (cVar != null) {
                                cVar.d();
                            }
                            return null;
                        }
                    }
                    str = ac.c().b(str);
                    if (str != null) {
                        RePlugin.getConfig();
                    }
                    if (cVar != null) {
                        cVar.d();
                    }
                    return str;
                }
            } catch (Throwable th2) {
                str = th2;
                cVar = null;
                if (cVar != null) {
                    cVar.d();
                }
                throw str;
            }
        }
        cVar = null;
        if (cVar != null) {
            StringBuilder stringBuilder32 = new StringBuilder("MP.pluginDownloaded ... lock file + ");
            stringBuilder32.append(str);
            stringBuilder32.append(" failed! ");
            com.qihoo360.replugin.b.c.a("ws001", stringBuilder32.toString());
        }
        str = ac.c().b(str);
        if (str != null) {
            RePlugin.getConfig();
        }
        if (cVar != null) {
            cVar.d();
        }
        return str;
    }

    public static final boolean b(String str) {
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder = new StringBuilder("MP.pluginUninstall ... pluginName=");
            stringBuilder.append(str);
            com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
        }
        PluginInfo a = a(str, true);
        if (a == null) {
            if (com.qihoo360.replugin.b.c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("Not installed. pluginName=");
                stringBuilder2.append(str);
                com.qihoo360.replugin.b.c.a("ws001", stringBuilder2.toString());
            }
            return true;
        }
        try {
            return ac.c().b(a);
        } catch (String str2) {
            new StringBuilder("uninstall. error: ").append(str2.getMessage());
            return null;
        }
    }

    public static final List<PluginInfo> a(boolean z) {
        List arrayList = new ArrayList();
        synchronized (ai.a) {
            for (Object obj : ai.a.values()) {
                if (z) {
                    Object obj2 = (PluginInfo) obj2.clone();
                }
                if (!arrayList.contains(obj2)) {
                    arrayList.add(obj2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.qihoo360.replugin.model.PluginInfo a(java.lang.String r2, boolean r3) {
        /*
        r0 = com.qihoo360.loader2.ai.a;
        monitor-enter(r0);
        r1 = com.qihoo360.loader2.ai.a;	 Catch:{ all -> 0x0019 }
        r2 = r1.get(r2);	 Catch:{ all -> 0x0019 }
        r2 = (com.qihoo360.replugin.model.PluginInfo) r2;	 Catch:{ all -> 0x0019 }
        if (r3 == 0) goto L_0x0017;
    L_0x000d:
        if (r2 == 0) goto L_0x0017;
    L_0x000f:
        r2 = r2.clone();	 Catch:{ all -> 0x0019 }
        r2 = (com.qihoo360.replugin.model.PluginInfo) r2;	 Catch:{ all -> 0x0019 }
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        return r2;
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        return r2;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0019 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.m.a(java.lang.String, boolean):com.qihoo360.replugin.model.PluginInfo");
    }

    public static final i a(String str, int i, PluginBinderInfo pluginBinderInfo) throws RemoteException {
        return ac.c().a(str, i, pluginBinderInfo);
    }
}
