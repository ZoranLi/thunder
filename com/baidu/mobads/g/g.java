package com.baidu.mobads.g;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.k;
import com.baidu.mobads.utils.l;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread.UncaughtExceptionHandler;

public class g {
    protected static UncaughtExceptionHandler a;
    protected static volatile a b;
    protected static volatile a c;
    protected static volatile Class d;
    protected static String e;
    protected static final Handler f = new h(Looper.getMainLooper());
    private static String i;
    protected Handler g = f;
    @SuppressLint({"HandlerLeak"})
    protected final Handler h = new i(this, Looper.getMainLooper());
    private com.baidu.mobads.openad.d.a j;
    private e k;
    private final Context l;
    private IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private boolean n = false;
    private c o;

    public static final class a extends Exception {
        public a(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    protected static final class b extends Exception {
        public b(String str) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(str);
        }
    }

    public interface c {
        void a(boolean z);
    }

    public final String a() {
        return "8.7036";
    }

    private void k() {
        try {
            File[] listFiles = this.l.getFilesDir().listFiles();
            int i = 0;
            while (listFiles != null && i < listFiles.length) {
                if (listFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__") && listFiles[i].getAbsolutePath().endsWith("dex")) {
                    listFiles[i].delete();
                }
                i++;
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
    }

    public g(Context context) {
        if (i == null) {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(uRIUitls.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/pa/"));
            stringBuilder.append(com.baidu.mobads.a.b.b());
            stringBuilder.append("/__pasys_remote_banner.php");
            i = stringBuilder.toString();
        }
        this.l = context;
        c(context);
        if (a == null) {
            a = q.a(context);
            q.a(context).a(new j(this));
        }
        if ((Thread.getDefaultUncaughtExceptionHandler() instanceof q) == null) {
            Thread.setDefaultUncaughtExceptionHandler(a);
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(e)) {
            context = context.getDir("baidu_ad_sdk", 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getAbsolutePath());
            stringBuilder.append("/");
            e = stringBuilder.toString();
        }
    }

    private SharedPreferences l() {
        return this.l.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    protected void b() {
        new File(f()).delete();
    }

    @TargetApi(9)
    protected void a(String str) {
        if (b != null) {
            str = l().edit();
            str.putFloat("__badApkVersion__8.7036", (float) b.a);
            if (VERSION.SDK_INT >= 9) {
                str.apply();
                return;
            }
            str.commit();
        }
    }

    private boolean m() {
        String string = l().getString("previousProxyVersion", null);
        String a = a();
        if (string != null && string.equals(a)) {
            return false;
        }
        return true;
    }

    private void a(boolean z) {
        Message obtainMessage = this.g.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = false;
        this.g.sendMessage(obtainMessage);
    }

    protected static String c() {
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append("__xadsdk__remote__final__builtin__.jar");
        return stringBuilder.toString();
    }

    protected static String d() {
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append("__xadsdk__remote__final__builtinversion__.jar");
        return stringBuilder.toString();
    }

    protected void e() {
        d(this.l);
        String c = c();
        b bVar = new b(c, this.l);
        if (!k.a((File) bVar)) {
            StringBuilder stringBuilder = new StringBuilder("loadBuiltInApk failed: ");
            stringBuilder.append(c);
            throw new b(stringBuilder.toString());
        } else if (c(bVar)) {
            b(true);
        }
    }

    private static synchronized void d(Context context) {
        synchronized (g.class) {
            try {
                String c = c();
                if (Double.valueOf("8.7036").doubleValue() > a(context, c)) {
                    b bVar = new b(c, context);
                    if (bVar.exists()) {
                        bVar.delete();
                    }
                    XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileFromAssetsTo(context, "bdxadsdk.jar", c);
                }
            } catch (Context context2) {
                StringBuilder stringBuilder = new StringBuilder("loadBuiltInApk failed: ");
                stringBuilder.append(context2.toString());
                throw new b(stringBuilder.toString());
            }
        }
    }

    private void a(b bVar) {
        Class b = bVar.b();
        synchronized (this) {
            c = new a(b, this.l, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.a);
        }
    }

    private void b(b bVar) {
        StringBuilder stringBuilder = new StringBuilder("len=");
        stringBuilder.append(bVar.length());
        stringBuilder.append(", path=");
        stringBuilder.append(bVar.getAbsolutePath());
        if (b == null) {
            String a = a(this.l);
            b bVar2 = new b(a, this.l);
            if (bVar2.exists()) {
                bVar2.delete();
            }
            try {
                XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(new FileInputStream(bVar), a);
            } catch (Throwable e) {
                this.m.e(e);
            }
            b = new a(bVar2.b(), this.l, com.baidu.mobads.a.b.a(), com.baidu.mobads.a.b.a);
            try {
                IXAdContainerFactory a2 = b.a();
                StringBuilder stringBuilder2 = new StringBuilder("preloaded apk.version=");
                stringBuilder2.append(a2.getRemoteVersion());
                this.m.d("XAdApkLoader", stringBuilder2.toString());
                return;
            } catch (a e2) {
                IXAdLogger iXAdLogger = this.m;
                Object[] objArr = new Object[2];
                objArr[0] = "XAdApkLoader";
                StringBuilder stringBuilder3 = new StringBuilder("preload local apk ");
                stringBuilder3.append(bVar.getAbsolutePath());
                stringBuilder3.append(" failed, msg:");
                stringBuilder3.append(e2.getMessage());
                stringBuilder3.append(", v=");
                stringBuilder3.append(b.a);
                objArr[1] = stringBuilder3.toString();
                iXAdLogger.w(objArr);
                a(e2.getMessage());
                throw e2;
            }
        }
        bVar = this.m;
        Object[] objArr2 = new Object[2];
        objArr2[0] = "XAdApkLoader";
        stringBuilder3 = new StringBuilder("mApkBuilder already initialized, version: ");
        stringBuilder3.append(b.a);
        objArr2[1] = stringBuilder3.toString();
        bVar.w(objArr2);
    }

    private boolean c(b bVar) {
        synchronized (this) {
            b(bVar);
            StringBuilder stringBuilder = new StringBuilder("loaded: ");
            stringBuilder.append(bVar.getPath());
            this.m.d("XAdApkLoader", stringBuilder.toString());
        }
        return true;
    }

    private boolean n() {
        try {
            if (!k.b(c())) {
                if (!k.b(f())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            this.m.d(e);
            return false;
        }
    }

    private void b(boolean z) {
        if (z || n()) {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        } else {
            this.n = true;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, z), this.n ? 0 : 5000);
    }

    private synchronized void o() {
        try {
            if (this.j != null) {
                this.j.removeAllListeners();
                this.j.a();
            }
            this.j = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(boolean z, String str) {
        q.a(this.l).b();
        if (this.o != null) {
            this.o.a(z);
            this.o = false;
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(e)) {
            context = context.getDir("baidu_ad_sdk", 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getAbsolutePath());
            stringBuilder.append("/");
            e = stringBuilder.toString();
        }
        if (TextUtils.isEmpty(e) != null) {
            return "";
        }
        context = new StringBuilder();
        context.append(e);
        context.append("__xadsdk__remote__final__running__.jar");
        return context.toString();
    }

    protected static String f() {
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append("__xadsdk__remote__final__downloaded__.jar");
        return stringBuilder.toString();
    }

    protected void g() {
        if (p()) {
            b(true);
            return;
        }
        this.m.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e) {
            IXAdLogger iXAdLogger = this.m;
            Object[] objArr = new Object[2];
            objArr[0] = "XAdApkLoader";
            StringBuilder stringBuilder = new StringBuilder("loadBuiltInApk failed: ");
            stringBuilder.append(e.toString());
            objArr[1] = stringBuilder.toString();
            iXAdLogger.e(objArr);
            StringBuilder stringBuilder2 = new StringBuilder("load built-in apk failed");
            stringBuilder2.append(e.toString());
            throw new a(stringBuilder2.toString());
        }
    }

    private boolean p() {
        b bVar = new b(f(), this.l);
        if (k.a((File) bVar)) {
            try {
                if (m()) {
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    StringBuilder stringBuilder = new StringBuilder("loadDownloadedOrBuiltInApk len=");
                    stringBuilder.append(bVar.length());
                    stringBuilder.append(", path=");
                    stringBuilder.append(bVar.getAbsolutePath());
                    b(bVar);
                    double d = (double) l().getFloat("__badApkVersion__8.7036", -1.0f);
                    StringBuilder stringBuilder2 = new StringBuilder("downloadedApkFile.getApkVersion(): ");
                    stringBuilder2.append(bVar.c());
                    stringBuilder2.append(", badApkVersion: ");
                    stringBuilder2.append(d);
                    this.m.d("XAdApkLoader", stringBuilder2.toString());
                    if (bVar.c() == d) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    StringBuilder stringBuilder3 = new StringBuilder("loaded: ");
                    stringBuilder3.append(bVar.getPath());
                    this.m.d("XAdApkLoader", stringBuilder3.toString());
                }
                return true;
            } catch (a e) {
                IXAdLogger iXAdLogger = this.m;
                Object[] objArr = new Object[2];
                objArr[0] = "XAdApkLoader";
                StringBuilder stringBuilder4 = new StringBuilder("load downloaded apk failed: ");
                stringBuilder4.append(e.toString());
                stringBuilder4.append(", fallback to built-in");
                objArr[1] = stringBuilder4.toString();
                iXAdLogger.e(objArr);
                if (bVar.exists()) {
                    bVar.delete();
                }
                i();
            }
        }
        return false;
    }

    private void a(e eVar) {
        if (eVar.a().booleanValue()) {
            c a = c.a(this.l, eVar, e, this.h);
            if (a.isAlive()) {
                this.m.d("XAdApkLoader", "XApkDownloadThread already started");
                a.a(eVar.c());
            } else {
                this.m.d("XAdApkLoader", "XApkDownloadThread starting ...");
                a.start();
            }
        }
    }

    private void b(c cVar, Handler handler) {
        this.o = cVar;
        this.g = handler;
        if (b == null) {
            g();
        } else {
            b(true);
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        new Thread(new n(this, cVar, handler)).start();
    }

    public void a(c cVar) {
        a(cVar, f);
    }

    public IXAdContainerFactory h() {
        return a(b);
    }

    private com.baidu.mobads.interfaces.IXAdContainerFactory a(com.baidu.mobads.g.a r2) {
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
        r1 = this;
        r0 = 0;
        if (r2 == 0) goto L_0x0008;
    L_0x0003:
        r2 = r2.a();	 Catch:{ Exception -> 0x0008 }
        r0 = r2;
    L_0x0008:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.g.a(com.baidu.mobads.g.a):com.baidu.mobads.interfaces.IXAdContainerFactory");
    }

    protected void i() {
        if (b != null) {
            b.b();
            b = null;
        }
    }

    public static double b(android.content.Context r8) {
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
        c(r8);	 Catch:{ Exception -> 0x0049 }
        r0 = f();	 Catch:{ Exception -> 0x0049 }
        r0 = a(r8, r0);	 Catch:{ Exception -> 0x0049 }
        r2 = d();	 Catch:{ Exception -> 0x0049 }
        r3 = a(r8, r2);	 Catch:{ Exception -> 0x0049 }
        r5 = "8.7036";	 Catch:{ Exception -> 0x0049 }
        r5 = java.lang.Double.valueOf(r5);	 Catch:{ Exception -> 0x0049 }
        r5 = r5.doubleValue();	 Catch:{ Exception -> 0x0049 }
        r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));	 Catch:{ Exception -> 0x0049 }
        if (r7 <= 0) goto L_0x003c;	 Catch:{ Exception -> 0x0049 }
    L_0x0021:
        r3 = new com.baidu.mobads.g.b;	 Catch:{ Exception -> 0x0049 }
        r3.<init>(r2, r8);	 Catch:{ Exception -> 0x0049 }
        r4 = r3.exists();	 Catch:{ Exception -> 0x0049 }
        if (r4 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0049 }
    L_0x002c:
        r3.delete();	 Catch:{ Exception -> 0x0049 }
    L_0x002f:
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0049 }
        r3 = r3.getIoUtils();	 Catch:{ Exception -> 0x0049 }
        r4 = "bdxadsdk.jar";	 Catch:{ Exception -> 0x0049 }
        r3.copyFileFromAssetsTo(r8, r4, r2);	 Catch:{ Exception -> 0x0049 }
    L_0x003c:
        r2 = d();	 Catch:{ Exception -> 0x0049 }
        r2 = a(r8, r2);	 Catch:{ Exception -> 0x0049 }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ Exception -> 0x0049 }
        return r0;
    L_0x0049:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.g.b(android.content.Context):double");
    }

    public static double a(android.content.Context r4, java.lang.String r5) {
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
        r0 = 0;
        r4 = new java.io.File;	 Catch:{ Exception -> 0x002c }
        r4.<init>(r5);	 Catch:{ Exception -> 0x002c }
        r5 = com.baidu.mobads.utils.k.a(r4);	 Catch:{ Exception -> 0x002c }
        if (r5 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x002c }
    L_0x000d:
        r5 = new java.util.jar.JarFile;	 Catch:{ Exception -> 0x002c }
        r5.<init>(r4);	 Catch:{ Exception -> 0x002c }
        r4 = r5.getManifest();	 Catch:{ Exception -> 0x002c }
        r4 = r4.getMainAttributes();	 Catch:{ Exception -> 0x002c }
        r2 = "Implementation-Version";	 Catch:{ Exception -> 0x002c }
        r4 = r4.getValue(r2);	 Catch:{ Exception -> 0x002c }
        r2 = java.lang.Double.parseDouble(r4);	 Catch:{ Exception -> 0x002c }
        r5.close();	 Catch:{ Exception -> 0x002c }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 <= 0) goto L_0x002c;
    L_0x002b:
        return r2;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.g.a(android.content.Context, java.lang.String):double");
    }
}
