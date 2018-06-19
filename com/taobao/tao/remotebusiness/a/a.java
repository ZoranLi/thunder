package com.taobao.tao.remotebusiness.a;

import android.os.Handler;
import android.os.Looper;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.j;
import mtopsdk.mtop.common.h;
import mtopsdk.mtop.common.k;

public final class a extends Handler {
    private static Handler a;

    private a(Looper looper) {
        super(looper);
    }

    public static synchronized Handler a() {
        Handler handler;
        synchronized (a.class) {
            if (a == null) {
                a = new a(Looper.getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    public static b a(k kVar, h hVar, MtopBusiness mtopBusiness) {
        return new b(kVar, hVar, mtopBusiness);
    }

    private static boolean a(b bVar) {
        if (bVar == null) {
            j.e(bVar.d.getSeqNo(), "HandlerMsg is null.");
            return false;
        } else if (!bVar.d.isTaskCanceled()) {
            return true;
        } else {
            j.b(bVar.d.getSeqNo(), "The request of RemoteBusiness is canceled.");
            return false;
        }
    }

    public final void handleMessage(android.os.Message r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = r14.what;
        r1 = 0;
        switch(r0) {
            case 1: goto L_0x00e0;
            case 2: goto L_0x00ac;
            case 3: goto L_0x0008;
            default: goto L_0x0006;
        };
    L_0x0006:
        goto L_0x0107;
    L_0x0008:
        r0 = r14.obj;
        r0 = (com.taobao.tao.remotebusiness.a.b) r0;
        r2 = a(r0);
        if (r2 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r2 = r0.d;
        r2 = r2.getSeqNo();
        r3 = "onReceive: ON_FINISHED.";
        mtopsdk.common.util.j.b(r2, r3);
        r2 = java.lang.System.currentTimeMillis();
        r4 = 0;
        r6 = r0.e;
        if (r6 == 0) goto L_0x004f;
    L_0x0028:
        r6 = r0.e;
        r6 = r6.getMtopStat();
        if (r6 == 0) goto L_0x004d;
    L_0x0030:
        r7 = r6.h();
        r8 = r0.d;
        r8 = r8.onBgFinishTime;
        r10 = r2 - r8;
        r7.g = r10;
        r8 = r0.e;
        r8 = r8.getBytedata();
        if (r8 == 0) goto L_0x0051;
    L_0x0044:
        r4 = r0.e;
        r4 = r4.getBytedata();
        r4 = r4.length;
        r4 = (long) r4;
        goto L_0x0051;
    L_0x004d:
        r7 = r1;
        goto L_0x0051;
    L_0x004f:
        r6 = r1;
        r7 = r6;
    L_0x0051:
        r8 = r0.d;
        r9 = r0.e;
        r10 = r0.c;
        r8.doFinish(r9, r10);
        r8 = java.lang.System.currentTimeMillis();
        r10 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r10 = mtopsdk.common.util.j.a(r10);
        if (r10 == 0) goto L_0x00a6;
    L_0x0066:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "doFinishTime=";
        r10.append(r11);
        r11 = r8 - r2;
        r10.append(r11);
        r2 = "; dataSize=";
        r10.append(r2);
        r10.append(r4);
        r2 = "; ";
        r10.append(r2);
        if (r7 == 0) goto L_0x008b;
    L_0x0084:
        r2 = r7.toString();
        r10.append(r2);
    L_0x008b:
        r0 = r0.d;
        r0 = r0.getSeqNo();
        r2 = new java.lang.StringBuilder;
        r3 = "onReceive: ON_FINISHED. ";
        r2.<init>(r3);
        r3 = r10.toString();
        r2.append(r3);
        r2 = r2.toString();
        mtopsdk.common.util.j.b(r0, r2);
    L_0x00a6:
        if (r6 == 0) goto L_0x0107;
    L_0x00a8:
        r0 = 1;
        r6.a = r0;
        goto L_0x0107;
    L_0x00ac:
        r0 = r14.obj;
        r0 = (com.taobao.tao.remotebusiness.a.b) r0;
        r2 = a(r0);
        if (r2 != 0) goto L_0x00b7;
    L_0x00b6:
        return;
    L_0x00b7:
        r2 = r0.d;
        r2 = r2.getSeqNo();
        r3 = "onReceive: ON_HEADER.";
        mtopsdk.common.util.j.b(r2, r3);
        r2 = r0.a;	 Catch:{ Throwable -> 0x00d4 }
        r2 = (com.taobao.tao.remotebusiness.IRemoteProcessListener) r2;	 Catch:{ Throwable -> 0x00d4 }
        r3 = r0.b;	 Catch:{ Throwable -> 0x00d4 }
        r3 = (mtopsdk.mtop.common.j) r3;	 Catch:{ Throwable -> 0x00d4 }
        r4 = r0.d;	 Catch:{ Throwable -> 0x00d4 }
        r4 = r4.getReqContext();	 Catch:{ Throwable -> 0x00d4 }
        r2.onHeader(r3, r4);	 Catch:{ Throwable -> 0x00d4 }
        goto L_0x0107;
    L_0x00d4:
        r0 = r0.d;
        r0 = r0.getSeqNo();
        r2 = "listener onHeader callback error.";
        mtopsdk.common.util.j.f(r0, r2);
        goto L_0x0107;
    L_0x00e0:
        r0 = r14.obj;
        r0 = (com.taobao.tao.remotebusiness.a.b) r0;
        r2 = a(r0);
        if (r2 != 0) goto L_0x00eb;
    L_0x00ea:
        return;
    L_0x00eb:
        r2 = r0.d;
        r2 = r2.getSeqNo();
        r3 = "onReceive: ON_DATA_RECEIVED.";
        mtopsdk.common.util.j.b(r2, r3);
        r2 = r0.a;
        r2 = (com.taobao.tao.remotebusiness.IRemoteProcessListener) r2;
        r3 = r0.b;
        r3 = (mtopsdk.mtop.common.n) r3;
        r0 = r0.d;
        r0 = r0.getReqContext();
        r2.onDataReceived(r3, r0);
    L_0x0107:
        r14.obj = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.a.a.handleMessage(android.os.Message):void");
    }
}
