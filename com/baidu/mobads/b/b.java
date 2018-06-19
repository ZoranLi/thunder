package com.baidu.mobads.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.a.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;

public class b extends d {
    protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private a d;
    private String e;
    private File f;
    private Boolean g;

    public b(Context context, String str, File file, boolean z) {
        super(context);
        this.e = str;
        this.f = file;
        this.g = Boolean.valueOf(z);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.d = (a) broadcastReceiver;
    }

    public void a() {
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
        r4 = this;
        r0 = r4.e;	 Catch:{ Exception -> 0x0027 }
        if (r0 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0027 }
    L_0x0004:
        r0 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x0027 }
        r1 = "android.intent.action.PACKAGE_ADDED";	 Catch:{ Exception -> 0x0027 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0027 }
        r1 = "package";	 Catch:{ Exception -> 0x0027 }
        r0.addDataScheme(r1);	 Catch:{ Exception -> 0x0027 }
        r1 = r4.b;	 Catch:{ Exception -> 0x0027 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0027 }
        r1.registerReceiver(r2, r0);	 Catch:{ Exception -> 0x0027 }
    L_0x0017:
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x0027 }
        r0 = r0.getPackageUtils();	 Catch:{ Exception -> 0x0027 }
        r1 = r4.b;	 Catch:{ Exception -> 0x0027 }
        r2 = r4.f;	 Catch:{ Exception -> 0x0027 }
        r0.b(r1, r2);	 Catch:{ Exception -> 0x0027 }
        return;
    L_0x0027:
        r0 = r4.a;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "XAdInstallController";
        r1[r2] = r3;
        r2 = 1;
        r3 = "";
        r1[r2] = r3;
        r0.e(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.b.b.a():void");
    }
}
