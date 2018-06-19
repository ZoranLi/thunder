package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AppMonitorService extends Service {
    r a = null;

    public IBinder onBind(Intent intent) {
        if (this.a == null) {
            this.a = new s(getApplication());
        }
        return (IBinder) this.a;
    }

    public void onDestroy() {
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
        r1 = this;
        r0 = r1.a;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.a;	 Catch:{ RemoteException -> 0x0009 }
        r0.b();	 Catch:{ RemoteException -> 0x0009 }
    L_0x0009:
        super.onDestroy();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorService.onDestroy():void");
    }

    public void onLowMemory() {
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
        r1 = this;
        r0 = r1.a;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.a;	 Catch:{ RemoteException -> 0x0009 }
        r0.b();	 Catch:{ RemoteException -> 0x0009 }
    L_0x0009:
        super.onLowMemory();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorService.onLowMemory():void");
    }
}
