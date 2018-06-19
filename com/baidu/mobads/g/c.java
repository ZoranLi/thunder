package com.baidu.mobads.g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.mobads.g.o.a;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class c extends Thread {
    private static volatile c f;
    a a = new d(this);
    private volatile String b;
    private String c = null;
    private double d;
    private Handler e;
    private final Context g;
    private o h = null;
    private final e i;
    private IXAdLogger j = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public static c a(Context context, e eVar, String str, Handler handler) {
        if (f == null) {
            f = new c(context, eVar, str, handler);
        }
        return f;
    }

    private c(Context context, e eVar, String str, Handler handler) {
        this.g = context;
        this.i = eVar;
        a(eVar.c());
        this.e = handler;
        this.c = str;
    }

    public void a(String str) {
        this.b = str;
        interrupt();
    }

    public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r0 = r7.b();	 Catch:{ Throwable -> 0x0046 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = 0;
        r1 = "download apk successfully, downloader exit";	 Catch:{ IOException -> 0x0017 }
        r7.a();	 Catch:{ IOException -> 0x0017 }
        r2 = r7.j;	 Catch:{ IOException -> 0x0017 }
        r3 = "XAdApkDownloadThread";	 Catch:{ IOException -> 0x0017 }
        r2.d(r3, r1);	 Catch:{ IOException -> 0x0017 }
        f = r0;	 Catch:{ IOException -> 0x0017 }
        goto L_0x003a;
    L_0x0017:
        r1 = move-exception;
        r2 = r7.j;	 Catch:{ Throwable -> 0x0046 }
        r3 = 2;	 Catch:{ Throwable -> 0x0046 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0046 }
        r4 = 0;	 Catch:{ Throwable -> 0x0046 }
        r5 = "XAdApkDownloadThread";	 Catch:{ Throwable -> 0x0046 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0046 }
        r4 = 1;	 Catch:{ Throwable -> 0x0046 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0046 }
        r6 = "create File or HTTP Get failed, exception: ";	 Catch:{ Throwable -> 0x0046 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.getMessage();	 Catch:{ Throwable -> 0x0046 }
        r5.append(r1);	 Catch:{ Throwable -> 0x0046 }
        r1 = r5.toString();	 Catch:{ Throwable -> 0x0046 }
        r3[r4] = r1;	 Catch:{ Throwable -> 0x0046 }
        r2.e(r3);	 Catch:{ Throwable -> 0x0046 }
    L_0x003a:
        r1 = r7.j;	 Catch:{ Throwable -> 0x0046 }
        r2 = "XAdApkDownloadThread";	 Catch:{ Throwable -> 0x0046 }
        r3 = "no newer apk, downloader exit";	 Catch:{ Throwable -> 0x0046 }
        r1.d(r2, r3);	 Catch:{ Throwable -> 0x0046 }
        f = r0;	 Catch:{ Throwable -> 0x0046 }
        return;
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.c.run():void");
    }

    private void a(String str, e eVar, String str2) {
        if (str.equals("OK") != null || str.equals("ERROR") != null) {
            str2 = this.e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", eVar);
            bundle.putString("CODE", str);
            str2.setData(bundle);
            this.e.sendMessage(str2);
        }
    }

    private String a() {
        StringBuilder stringBuilder = new StringBuilder("__xadsdk__remote__final__");
        stringBuilder.append(UUID.randomUUID().toString());
        stringBuilder.append(ShareConstants.JAR_SUFFIX);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.c);
        stringBuilder3.append(stringBuilder2);
        String stringBuilder4 = stringBuilder3.toString();
        File file = new File(stringBuilder4);
        try {
            file.createNewFile();
            this.h.a(this.c, stringBuilder2);
            return stringBuilder4;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    private boolean b() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r0 = 2;
        r1 = 1;
        r2 = 0;
        r3 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x001b }
        r4 = r12.b;	 Catch:{ MalformedURLException -> 0x001b }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x001b }
        r4 = new com.baidu.mobads.g.o;	 Catch:{ MalformedURLException -> 0x001b }
        r5 = r12.g;	 Catch:{ MalformedURLException -> 0x001b }
        r6 = r12.i;	 Catch:{ MalformedURLException -> 0x001b }
        r7 = r12.a;	 Catch:{ MalformedURLException -> 0x001b }
        r4.<init>(r5, r3, r6, r7);	 Catch:{ MalformedURLException -> 0x001b }
        r12.h = r4;	 Catch:{ MalformedURLException -> 0x001b }
        goto L_0x002a;
    L_0x0018:
        r3 = move-exception;
        goto L_0x00d9;
    L_0x001b:
        r3 = new com.baidu.mobads.g.o;	 Catch:{ Exception -> 0x0018 }
        r4 = r12.g;	 Catch:{ Exception -> 0x0018 }
        r5 = r12.b;	 Catch:{ Exception -> 0x0018 }
        r6 = r12.i;	 Catch:{ Exception -> 0x0018 }
        r7 = r12.a;	 Catch:{ Exception -> 0x0018 }
        r3.<init>(r4, r5, r6, r7);	 Catch:{ Exception -> 0x0018 }
        r12.h = r3;	 Catch:{ Exception -> 0x0018 }
    L_0x002a:
        r3 = com.baidu.mobads.g.g.c;
        r4 = 0;
        if (r3 == 0) goto L_0x0035;
    L_0x0030:
        r3 = com.baidu.mobads.g.g.c;
        r6 = r3.a;
        goto L_0x0041;
    L_0x0035:
        r3 = com.baidu.mobads.g.g.b;
        if (r3 == 0) goto L_0x0040;
    L_0x0039:
        r3 = com.baidu.mobads.g.g.b;
        r3 = com.baidu.mobads.g.g.b;
        r6 = r3.a;
        goto L_0x0041;
    L_0x0040:
        r6 = r4;
    L_0x0041:
        r3 = r12.j;
        r8 = "XAdApkDownloadThread";
        r9 = new java.lang.StringBuilder;
        r10 = "isNewApkAvailable: local apk version is: ";
        r9.<init>(r10);
        r9.append(r6);
        r10 = ", remote apk version: ";
        r9.append(r10);
        r10 = r12.i;
        r10 = r10.b();
        r9.append(r10);
        r9 = r9.toString();
        r3.d(r8, r9);
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x009a;
    L_0x0068:
        r3 = r12.i;
        r6 = r3.b();
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x008a;
    L_0x0072:
        r3 = r12.j;
        r0 = new java.lang.Object[r0];
        r4 = "XAdApkDownloadThread";
        r0[r2] = r4;
        r2 = "remote not null, local apk version is null, force upgrade";
        r0[r1] = r2;
        r3.e(r0);
        r0 = r12.i;
        r2 = r0.b();
        r12.d = r2;
        return r1;
    L_0x008a:
        r3 = r12.j;
        r0 = new java.lang.Object[r0];
        r4 = "XAdApkDownloadThread";
        r0[r2] = r4;
        r4 = "remote is null, local apk version is null, do not upgrade";
        r0[r1] = r4;
        r3.e(r0);
        return r2;
    L_0x009a:
        r3 = r12.i;
        r8 = r3.b();
        r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x00c5;
    L_0x00a4:
        r3 = r12.j;
        r0 = new java.lang.Object[r0];
        r4 = "XAdApkDownloadThread";
        r0[r2] = r4;
        r4 = new java.lang.StringBuilder;
        r5 = "remote apk version is: null, local apk version is: ";
        r4.<init>(r5);
        r4.append(r6);
        r5 = ", do not upgrade";
        r4.append(r5);
        r4 = r4.toString();
        r0[r1] = r4;
        r3.e(r0);
        return r2;
    L_0x00c5:
        r0 = r12.i;
        r3 = r0.b();
        r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d8;
    L_0x00cf:
        r0 = r12.i;
        r2 = r0.b();
        r12.d = r2;
        return r1;
    L_0x00d8:
        return r2;
    L_0x00d9:
        r4 = new java.lang.StringBuilder;
        r5 = "parse apk failed, error:";
        r4.<init>(r5);
        r3 = r3.toString();
        r4.append(r3);
        r3 = r4.toString();
        r4 = r12.j;
        r0 = new java.lang.Object[r0];
        r5 = "XAdApkDownloadThread";
        r0[r2] = r5;
        r0[r1] = r3;
        r4.e(r0);
        r0 = new com.baidu.mobads.g.g$a;
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.c.b():boolean");
    }
}
