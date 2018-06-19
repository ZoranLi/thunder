package com.qihoo360.replugin.packages;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qihoo360.loader2.ab;
import com.qihoo360.loader2.m;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginEventCallbacks.InstallResult;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.model.c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PluginManagerServer */
public final class d {
    public static final byte[] a = new byte[0];
    private static final byte[] d = new byte[0];
    public Map<String, PluginRunningList> b = new ConcurrentHashMap();
    public a c;
    private Context e;
    private c f = new c();

    /* compiled from: PluginManagerServer */
    private class a extends com.qihoo360.replugin.packages.a.a {
        final /* synthetic */ d a;

        private a(d dVar) {
            this.a = dVar;
        }

        public final PluginInfo a(String str) throws RemoteException {
            synchronized (d.d) {
                str = d.a(this.a, str);
            }
            return str;
        }

        public final List<PluginInfo> a() throws RemoteException {
            List<PluginInfo> a;
            synchronized (d.d) {
                a = d.a(this.a);
            }
            return a;
        }

        public final List<PluginInfo> b() throws RemoteException {
            List<PluginInfo> b;
            synchronized (d.d) {
                b = this.a.b();
            }
            return b;
        }

        public final void a(String str, boolean z) throws RemoteException {
            synchronized (d.d) {
                d.a(this.a, str, z);
            }
        }

        public final boolean a(PluginInfo pluginInfo) throws RemoteException {
            synchronized (d.d) {
                pluginInfo = d.a(this.a, pluginInfo);
            }
            return pluginInfo;
        }

        public final PluginRunningList c() throws RemoteException {
            PluginRunningList c;
            synchronized (d.d) {
                c = d.c(this.a);
            }
            return c;
        }

        public final boolean a(String str, String str2) throws RemoteException {
            synchronized (d.d) {
                str = this.a.a(str, str2);
            }
            return str;
        }

        public final void a(PluginRunningList pluginRunningList) throws RemoteException {
            synchronized (d.d) {
                d.a(this.a, pluginRunningList);
            }
        }

        public final void a(String str, int i, String str2) throws RemoteException {
            synchronized (d.d) {
                d.a(this.a, str, i, str2);
            }
        }

        public final String[] b(String str) throws RemoteException {
            synchronized (d.d) {
                str = d.b(this.a, str);
            }
            return str;
        }
    }

    public d(Context context) {
        this.e = context;
        this.c = new a();
    }

    private static boolean a(java.lang.String r2, com.qihoo360.replugin.model.PluginInfo r3) {
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
        r0 = new java.io.File;
        r0.<init>(r2);
        r2 = r3.getApkFile();
        r1 = r2.exists();
        if (r1 == 0) goto L_0x0012;
    L_0x000f:
        com.qihoo360.replugin.utils.c.d(r2);
    L_0x0012:
        r1 = com.qihoo360.replugin.RePlugin.getConfig();	 Catch:{ IOException -> 0x002f }
        r1 = r1.f;	 Catch:{ IOException -> 0x002f }
        if (r1 == 0) goto L_0x001e;	 Catch:{ IOException -> 0x002f }
    L_0x001a:
        com.qihoo360.replugin.utils.c.c(r0, r2);	 Catch:{ IOException -> 0x002f }
        goto L_0x0021;	 Catch:{ IOException -> 0x002f }
    L_0x001e:
        com.qihoo360.replugin.utils.c.b(r0, r2);	 Catch:{ IOException -> 0x002f }
    L_0x0021:
        r2 = r2.getAbsolutePath();
        r3.setPath(r2);
        r2 = 11;
        r3.setType(r2);
        r2 = 1;
        return r2;
    L_0x002f:
        r3 = new java.lang.StringBuilder;
        r1 = "copyOrMoveApk: Copy/Move Failed! src=";
        r3.<init>(r1);
        r3.append(r0);
        r0 = "; dest=";
        r3.append(r0);
        r3.append(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.packages.d.a(java.lang.String, com.qihoo360.replugin.model.PluginInfo):boolean");
    }

    private static int a(PluginInfo pluginInfo) {
        if (pluginInfo == null) {
            return null;
        }
        return pluginInfo.isPnPlugin() != null ? 1 : 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.qihoo360.replugin.model.PluginInfo r5, com.qihoo360.replugin.model.PluginInfo r6) {
        /*
        r0 = r6.getIsPendingCover();
        r1 = 21;
        if (r0 == 0) goto L_0x00a7;
    L_0x0008:
        r2 = com.qihoo360.replugin.b.c.a;
        if (r2 == 0) goto L_0x002f;
    L_0x000c:
        r2 = "PluginManagerServer";
        r3 = new java.lang.StringBuilder;
        r4 = "move. curPi=";
        r3.<init>(r4);
        r4 = r5.getPath();
        r3.append(r4);
        r4 = "; newPi=";
        r3.append(r4);
        r4 = r6.getPath();
        r3.append(r4);
        r3 = r3.toString();
        com.qihoo360.replugin.b.c.b(r2, r3);
    L_0x002f:
        r2 = r6.getApkFile();	 Catch:{ IOException -> 0x0081 }
        r3 = r5.getApkFile();	 Catch:{ IOException -> 0x0081 }
        com.qihoo360.replugin.utils.c.b(r2, r3);	 Catch:{ IOException -> 0x0081 }
        r2 = r6.getDexFile();	 Catch:{ IOException -> 0x0081 }
        r2 = r2.exists();	 Catch:{ IOException -> 0x0081 }
        if (r2 == 0) goto L_0x004f;
    L_0x0044:
        r2 = r6.getDexFile();	 Catch:{ IOException -> 0x0081 }
        r3 = r5.getDexFile();	 Catch:{ IOException -> 0x0081 }
        com.qihoo360.replugin.utils.c.b(r2, r3);	 Catch:{ IOException -> 0x0081 }
    L_0x004f:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IOException -> 0x0081 }
        if (r2 >= r1) goto L_0x005e;
    L_0x0053:
        r1 = r6.getExtraOdexDir();	 Catch:{ IOException -> 0x0081 }
        r2 = r5.getExtraOdexDir();	 Catch:{ IOException -> 0x0081 }
        com.qihoo360.replugin.utils.c.a(r1, r2);	 Catch:{ IOException -> 0x0081 }
    L_0x005e:
        r1 = r6.getNativeLibsDir();	 Catch:{ IOException -> 0x0081 }
        r1 = r1.exists();	 Catch:{ IOException -> 0x0081 }
        if (r1 == 0) goto L_0x0073;
    L_0x0068:
        r1 = r6.getNativeLibsDir();	 Catch:{ IOException -> 0x0081 }
        r2 = r5.getNativeLibsDir();	 Catch:{ IOException -> 0x0081 }
        com.qihoo360.replugin.utils.c.a(r1, r2);	 Catch:{ IOException -> 0x0081 }
    L_0x0073:
        r1 = r6.getApkFile();	 Catch:{ IOException -> 0x0091 }
        r1 = r1.getParentFile();	 Catch:{ IOException -> 0x0091 }
        com.qihoo360.replugin.utils.c.c(r1);	 Catch:{ IOException -> 0x0091 }
        goto L_0x00d1;
    L_0x007f:
        r5 = move-exception;
        goto L_0x0096;
    L_0x0081:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x007f }
        r1 = r6.getApkFile();	 Catch:{ IOException -> 0x0091 }
        r1 = r1.getParentFile();	 Catch:{ IOException -> 0x0091 }
        com.qihoo360.replugin.utils.c.c(r1);	 Catch:{ IOException -> 0x0091 }
        goto L_0x00d1;
    L_0x0091:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d1;
    L_0x0096:
        r6 = r6.getApkFile();	 Catch:{ IOException -> 0x00a2 }
        r6 = r6.getParentFile();	 Catch:{ IOException -> 0x00a2 }
        com.qihoo360.replugin.utils.c.c(r6);	 Catch:{ IOException -> 0x00a2 }
        goto L_0x00a6;
    L_0x00a2:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00a6:
        throw r5;
    L_0x00a7:
        r2 = new java.io.File;	 Catch:{ IOException -> 0x00cd }
        r3 = r5.getPath();	 Catch:{ IOException -> 0x00cd }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00cd }
        com.qihoo360.replugin.utils.c.c(r2);	 Catch:{ IOException -> 0x00cd }
        r2 = r5.getDexFile();	 Catch:{ IOException -> 0x00cd }
        com.qihoo360.replugin.utils.c.c(r2);	 Catch:{ IOException -> 0x00cd }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IOException -> 0x00cd }
        if (r2 >= r1) goto L_0x00c5;
    L_0x00be:
        r1 = r5.getExtraOdexDir();	 Catch:{ IOException -> 0x00cd }
        com.qihoo360.replugin.utils.c.c(r1);	 Catch:{ IOException -> 0x00cd }
    L_0x00c5:
        r1 = r5.getNativeLibsDir();	 Catch:{ IOException -> 0x00cd }
        com.qihoo360.replugin.utils.c.c(r1);	 Catch:{ IOException -> 0x00cd }
        goto L_0x00d1;
    L_0x00cd:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00d1:
        r1 = 11;
        r6.setType(r1);
        r1 = com.qihoo360.replugin.b.c.a;
        if (r1 == 0) goto L_0x0109;
    L_0x00da:
        r1 = "PluginManagerServer";
        r2 = new java.lang.StringBuilder;
        r3 = "updateNow: Update. pn=";
        r2.<init>(r3);
        r3 = r5.getVersion();
        r2.append(r3);
        r3 = "; cur_ver=";
        r2.append(r3);
        r3 = r5.getVersion();
        r2.append(r3);
        r3 = "; update_ver=";
        r2.append(r3);
        r3 = r6.getVersion();
        r2.append(r3);
        r2 = r2.toString();
        com.qihoo360.replugin.b.c.b(r1, r2);
    L_0x0109:
        r1 = 0;
        if (r0 == 0) goto L_0x011f;
    L_0x010c:
        r5.setPendingCover(r1);
        r5 = 0;
        r6.setIsPendingCover(r5);
        r5 = r6.getApkFile();
        r5 = r5.getPath();
        r6.setPath(r5);
        return;
    L_0x011f:
        r5.update(r6);
        r5.setPendingUpdate(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.packages.d.a(com.qihoo360.replugin.model.PluginInfo, com.qihoo360.replugin.model.PluginInfo):void");
    }

    private boolean b(PluginInfo pluginInfo) {
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder = new StringBuilder("Not running. Uninstall now! pn=");
            stringBuilder.append(pluginInfo.getName());
            com.qihoo360.replugin.b.c.b("PluginManagerServer", stringBuilder.toString());
        }
        if (pluginInfo != null) {
            try {
                File apkFile = pluginInfo.getApkFile();
                if (apkFile.exists()) {
                    com.qihoo360.replugin.utils.c.c(apkFile);
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(pluginInfo.getApkFile());
                    }
                }
                apkFile = pluginInfo.getDexFile();
                if (apkFile.exists()) {
                    com.qihoo360.replugin.utils.c.c(apkFile);
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(pluginInfo.getDexFile());
                    }
                }
                if (VERSION.SDK_INT > 25) {
                    apkFile = pluginInfo.getDexParentDir();
                    String a = com.qihoo360.replugin.utils.c.a(pluginInfo.getDexFile().getAbsolutePath());
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a);
                    stringBuilder2.append(".vdex");
                    File file = new File(apkFile, stringBuilder2.toString());
                    com.qihoo360.replugin.utils.c.c(file);
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(file);
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(pluginInfo.getApkFile().getAbsolutePath());
                    stringBuilder3.append(".prof");
                    apkFile = new File(stringBuilder3.toString());
                    com.qihoo360.replugin.utils.c.c(apkFile);
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(apkFile);
                    }
                }
                if (VERSION.SDK_INT < 21) {
                    com.qihoo360.replugin.utils.c.c(pluginInfo.getExtraOdexDir());
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(pluginInfo.getExtraOdexDir());
                    }
                }
                if (pluginInfo.getNativeLibsDir().exists()) {
                    com.qihoo360.replugin.utils.c.c(pluginInfo.getNativeLibsDir());
                    if (com.qihoo360.mobilesafe.a.a.a) {
                        new StringBuilder("delete ").append(pluginInfo.getNativeLibsDir());
                    }
                }
                File file2 = new File(g.a().getFilesDir(), String.format("plugin_v3_%s.lock", new Object[]{pluginInfo.getApkFile().getName()}));
                com.qihoo360.replugin.utils.c.c(file2);
                if (com.qihoo360.mobilesafe.a.a.a) {
                    new StringBuilder("delete ").append(file2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f.a(pluginInfo.getName());
        this.f.b(this.e);
        return true;
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            for (PluginRunningList b : this.b.values()) {
                if (b.b(str)) {
                    return true;
                }
            }
        }
        PluginRunningList pluginRunningList = (PluginRunningList) this.b.get(str2);
        if (!(pluginRunningList == null || pluginRunningList.b(str) == null)) {
            return true;
        }
        return null;
    }

    private List<PluginInfo> b() {
        Iterator it = this.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            PluginInfo pluginInfo = (PluginInfo) it.next();
            boolean z = true;
            StringBuilder stringBuilder;
            if (!a(pluginInfo.getName(), null)) {
                if (pluginInfo.isNeedUninstall()) {
                    if (com.qihoo360.replugin.b.c.a) {
                        stringBuilder = new StringBuilder("updateIfNeeded: delete plugin. pn=");
                        stringBuilder.append(pluginInfo.getName());
                        com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder.toString());
                    }
                    z = b(pluginInfo.getPendingDelete());
                } else if (pluginInfo.isNeedUpdate()) {
                    a(pluginInfo, pluginInfo.getPendingUpdate());
                } else if (pluginInfo.isNeedCover()) {
                    a(pluginInfo, pluginInfo.getPendingCover());
                } else if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder = new StringBuilder("updateIfNeeded: Not need to update. pn=");
                    stringBuilder.append(pluginInfo.getName());
                    com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder.toString());
                }
                if (z) {
                    i++;
                }
            } else if (com.qihoo360.replugin.b.c.a) {
                stringBuilder = new StringBuilder("updateIfNeeded: Plugin is running. pn=");
                stringBuilder.append(pluginInfo.getName());
                com.qihoo360.replugin.b.c.c("PluginManagerServer", stringBuilder.toString());
            }
            z = false;
            if (z) {
                i++;
            }
        }
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("updateAllIfNeeded: Updated ");
            stringBuilder2.append(i);
            stringBuilder2.append(" plugins");
            com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder2.toString());
        }
        if (i > 0) {
            this.f.b(this.e);
        }
        return new ArrayList(this.f.a);
    }

    static /* synthetic */ PluginInfo a(d dVar, String str) {
        boolean z = RePlugin.getConfig().d;
        PackageInfo packageArchiveInfo = dVar.e.getPackageManager().getPackageArchiveInfo(str, z ? 192 : 128);
        if (packageArchiveInfo == null) {
            if (com.qihoo360.replugin.b.c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("installLocked: Not a valid apk. path=");
                stringBuilder.append(str);
                com.qihoo360.replugin.b.c.d("PluginManagerServer", stringBuilder.toString());
            }
            RePlugin.getConfig();
            dVar = InstallResult.READ_PKG_INFO_FAIL;
            return null;
        }
        StringBuilder stringBuilder2;
        if (z) {
            if (com.qihoo360.loader2.d.a(packageArchiveInfo)) {
                if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder2 = new StringBuilder("verifySignature: valid cert:  name=");
                    stringBuilder2.append(packageArchiveInfo);
                    com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder2.toString());
                }
                z = true;
            } else {
                if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder2 = new StringBuilder("verifySignature: invalid cert:  name=");
                    stringBuilder2.append(packageArchiveInfo);
                    com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder2.toString());
                }
                RePlugin.getConfig();
                InstallResult installResult = InstallResult.VERIFY_SIGN_FAIL;
                z = false;
            }
            if (!z) {
                return null;
            }
        }
        PluginInfo parseFromPackageInfo = PluginInfo.parseFromPackageInfo(packageArchiveInfo, str);
        if (com.qihoo360.replugin.b.c.a) {
            stringBuilder2 = new StringBuilder("installLocked: Info=");
            stringBuilder2.append(parseFromPackageInfo);
            com.qihoo360.replugin.b.c.b("PluginManagerServer", stringBuilder2.toString());
        }
        parseFromPackageInfo.setType(10);
        PluginInfo a = m.a(parseFromPackageInfo.getName(), false);
        if (a != null) {
            StringBuilder stringBuilder3;
            if (com.qihoo360.replugin.b.c.a) {
                stringBuilder3 = new StringBuilder("installLocked: Has installed plugin. current=");
                stringBuilder3.append(a);
                com.qihoo360.replugin.b.c.b("PluginManagerServer", stringBuilder3.toString());
            }
            boolean z2 = true;
            if (parseFromPackageInfo.getVersion() == a.getVersion() && a(parseFromPackageInfo) == a(a)) {
                if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder3 = new StringBuilder("isSameVersion: same version. inst_ver=");
                    stringBuilder3.append(parseFromPackageInfo.getVersion());
                    stringBuilder3.append("; cur_ver=");
                    stringBuilder3.append(a.getVersion());
                    com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder3.toString());
                }
                z2 = false;
            } else if (parseFromPackageInfo.getVersion() >= a.getVersion()) {
                PluginInfo pendingUpdate = a.getPendingUpdate();
                if (pendingUpdate == null || parseFromPackageInfo.getVersion() >= pendingUpdate.getVersion()) {
                    z2 = true;
                } else if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder3 = new StringBuilder("checkVersion: Older than updating plugin. Ignore. pn=");
                    stringBuilder3.append(a.getName());
                    stringBuilder3.append("; cur_ver=");
                    stringBuilder3.append(a.getVersion());
                    stringBuilder3.append("; old_ver=");
                    stringBuilder3.append(pendingUpdate.getVersion());
                    stringBuilder3.append("; new_ver=");
                    stringBuilder3.append(parseFromPackageInfo.getVersion());
                    com.qihoo360.replugin.b.c.d("PluginManagerServer", stringBuilder3.toString());
                }
            } else if (com.qihoo360.replugin.b.c.a) {
                stringBuilder2 = new StringBuilder("checkVersion: Older than current, install fail. pn=");
                stringBuilder2.append(a.getName());
                stringBuilder2.append("; inst_ver=");
                stringBuilder2.append(parseFromPackageInfo.getVersion());
                stringBuilder2.append("; cur_ver=");
                stringBuilder2.append(a.getVersion());
                com.qihoo360.replugin.b.c.d("PluginManagerServer", stringBuilder2.toString());
            }
            if (z2 >= false) {
                RePlugin.getConfig();
                dVar = InstallResult.VERIFY_VER_FAIL;
                return null;
            } else if (!z2) {
                parseFromPackageInfo.setIsPendingCover(true);
            }
        }
        if (a(str, parseFromPackageInfo) == null) {
            RePlugin.getConfig();
            dVar = InstallResult.COPY_APK_FAIL;
            return null;
        }
        ab.a(parseFromPackageInfo.getPath(), parseFromPackageInfo.getNativeLibsDir());
        if (a != null) {
            StringBuilder stringBuilder4;
            if (com.qihoo360.replugin.b.c.a != null) {
                stringBuilder4 = new StringBuilder("updateOrLater: Need update. pn=");
                stringBuilder4.append(a.getName());
                stringBuilder4.append("; cur_ver=");
                stringBuilder4.append(a.getVersion());
                stringBuilder4.append("; update_ver=");
                stringBuilder4.append(parseFromPackageInfo.getVersion());
                com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder4.toString());
            }
            if (a.isPnPlugin() != null) {
                dVar.f.a(a);
            }
            str = a.getPendingUpdate();
            if (str != null) {
                if (str.getVersion() < parseFromPackageInfo.getVersion()) {
                    if (com.qihoo360.replugin.b.c.a) {
                        stringBuilder4 = new StringBuilder("updatePendingUpdate: Found newer plugin, replace. pn=");
                        stringBuilder4.append(a.getName());
                        stringBuilder4.append("; cur_ver=");
                        stringBuilder4.append(a.getVersion());
                        stringBuilder4.append("; old_ver=");
                        stringBuilder4.append(str.getVersion());
                        stringBuilder4.append("; new_ver=");
                        stringBuilder4.append(parseFromPackageInfo.getVersion());
                        com.qihoo360.replugin.b.c.b("PluginManagerServer", stringBuilder4.toString());
                    }
                    a.setPendingUpdate(parseFromPackageInfo);
                    try {
                        com.qihoo360.replugin.utils.c.c(new File(str.getPath()));
                    } catch (String str2) {
                        str2.printStackTrace();
                    }
                } else if (com.qihoo360.replugin.b.c.a != null) {
                    com.qihoo360.replugin.b.c.d("PluginManagerServer", "updatePendingUpdate: Older than updating plugin. But...");
                }
            } else if (RePlugin.isPluginRunning(a.getName()) != null) {
                if (com.qihoo360.replugin.b.c.a != null) {
                    stringBuilder4 = new StringBuilder("updateOrLater: Plugin is running. Later. pn=");
                    stringBuilder4.append(a.getName());
                    com.qihoo360.replugin.b.c.c("PluginManagerServer", stringBuilder4.toString());
                }
                if (parseFromPackageInfo.getVersion() <= a.getVersion()) {
                    if (parseFromPackageInfo.getVersion() != a.getVersion() || a(parseFromPackageInfo) == a(a)) {
                        if (parseFromPackageInfo.getVersion() == a.getVersion()) {
                            a.setPendingCover(parseFromPackageInfo);
                            a.setPendingDelete(null);
                            if (com.qihoo360.replugin.b.c.a != null) {
                                com.qihoo360.replugin.b.c.c("PluginManagerServer", "updateOrLater: Plugin need update same version. clear PendingDelete.");
                            }
                        }
                        parseFromPackageInfo.setParentInfo(a);
                    }
                }
                a.setPendingUpdate(parseFromPackageInfo);
                a.setPendingDelete(null);
                a.setPendingCover(null);
                if (com.qihoo360.replugin.b.c.a != null) {
                    com.qihoo360.replugin.b.c.c("PluginManagerServer", "updateOrLater: Plugin need update high version. clear PendingDelete and PendingCover.");
                }
                parseFromPackageInfo.setParentInfo(a);
            } else {
                if (com.qihoo360.replugin.b.c.a != null) {
                    StringBuilder stringBuilder5 = new StringBuilder("updateOrLater: Not running. Update now! pn=");
                    stringBuilder5.append(a.getName());
                    com.qihoo360.replugin.b.c.b("PluginManagerServer", stringBuilder5.toString());
                }
                a(a, parseFromPackageInfo);
            }
        } else {
            dVar.f.a(parseFromPackageInfo);
        }
        dVar.f.b(dVar.e);
        return parseFromPackageInfo;
    }

    static /* synthetic */ List a(d dVar) {
        if (dVar.f.a(dVar.e)) {
            return dVar.b();
        }
        return null;
    }

    static /* synthetic */ void a(d dVar, String str, boolean z) {
        PluginInfo a = m.a(str, false);
        if (a != null) {
            a.setIsUsed(z);
            dVar.f.b(dVar.e);
            g.a();
            if (com.qihoo360.replugin.b.c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("updateIsUsed: Prepare to send broadcast, pn=");
                stringBuilder.append(str);
                stringBuilder.append("; used=");
                stringBuilder.append(z);
                com.qihoo360.replugin.b.c.b("PluginInfoUpdater", stringBuilder.toString());
            }
            dVar = new Intent("com.qihoo360.replugin.pms.ACTION_UPDATE_INFO");
            dVar.putExtra("pn", str);
            dVar.putExtra("used", z);
            b.b(dVar);
        }
    }

    static /* synthetic */ boolean a(d dVar, PluginInfo pluginInfo) {
        if (pluginInfo == null) {
            return false;
        }
        if (!RePlugin.isPluginRunning(pluginInfo.getName())) {
            return dVar.b(pluginInfo);
        }
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder = new StringBuilder("Is running. Uninstall later! pn=");
            stringBuilder.append(pluginInfo.getName());
            com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder.toString());
        }
        PluginInfo a = m.a(pluginInfo.getName(), false);
        if (a == null) {
            return false;
        }
        a.setPendingDelete(pluginInfo);
        dVar.f.b(dVar.e);
        return false;
    }

    static /* synthetic */ PluginRunningList c(d dVar) {
        PluginRunningList pluginRunningList = new PluginRunningList();
        for (PluginRunningList it : dVar.b.values()) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!pluginRunningList.b(str)) {
                    pluginRunningList.a(str);
                }
            }
        }
        return pluginRunningList;
    }

    static /* synthetic */ void a(d dVar, PluginRunningList pluginRunningList) {
        dVar.b.put(pluginRunningList.b, new PluginRunningList(pluginRunningList));
        if (com.qihoo360.replugin.b.c.a) {
            StringBuilder stringBuilder = new StringBuilder("syncRunningPluginsLocked: Synced! pl=");
            stringBuilder.append(pluginRunningList);
            stringBuilder.append("; map=");
            stringBuilder.append(dVar.b);
            com.qihoo360.replugin.b.c.a("PluginManagerServer", stringBuilder.toString());
        }
    }

    static /* synthetic */ void a(d dVar, String str, int i, String str2) {
        PluginRunningList pluginRunningList = (PluginRunningList) dVar.b.get(str);
        if (pluginRunningList == null) {
            pluginRunningList = new PluginRunningList();
            dVar.b.put(str, pluginRunningList);
        }
        pluginRunningList.a(str, i);
        pluginRunningList.a(str2);
        if (com.qihoo360.replugin.b.c.a != null) {
            i = new StringBuilder("addToRunningPluginsLocked: Added! pl =");
            i.append(pluginRunningList);
            i.append("; map=");
            i.append(dVar.b);
            com.qihoo360.replugin.b.c.a("PluginManagerServer", i.toString());
        }
    }

    static /* synthetic */ String[] b(d dVar, String str) {
        ArrayList arrayList = new ArrayList();
        for (PluginRunningList pluginRunningList : dVar.b.values()) {
            if (pluginRunningList.b(str)) {
                arrayList.add(pluginRunningList.b);
            }
        }
        return (String[]) arrayList.toArray(new String[null]);
    }
}
