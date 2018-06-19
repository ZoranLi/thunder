package com.taobao.tao.remotebusiness;

import com.taobao.tao.remotebusiness.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.domain.MtopResponse;

public final class a {
    private static List a = new ArrayList();
    private static Lock b = new ReentrantLock();

    public static void a() {
        b.lock();
        try {
            if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                StringBuilder stringBuilder = new StringBuilder("retry all request, current size=");
                stringBuilder.append(a.size());
                j.b(stringBuilder.toString());
            }
            Iterator it = new ArrayList(a).iterator();
            while (it.hasNext()) {
                ((MtopBusiness) it.next()).retryRequest();
            }
        } finally {
            b.unlock();
        }
    }

    public static void a(MtopBusiness mtopBusiness) {
        b.lock();
        try {
            a.add(mtopBusiness);
            j.b(mtopBusiness.getSeqNo(), "request add to request pool");
        } finally {
            b.unlock();
        }
    }

    public static void a(String str, String str2) {
        b.lock();
        try {
            j.b("session fail  all request");
            for (MtopBusiness mtopBusiness : a) {
                MtopResponse mtopResponse = mtopBusiness.request != null ? new MtopResponse(mtopBusiness.request.getApiName(), mtopBusiness.request.getVersion(), str, str2) : new MtopResponse(str, str2);
                b a = com.taobao.tao.remotebusiness.a.a.a(null, null, mtopBusiness);
                a.e = mtopResponse;
                com.taobao.tao.remotebusiness.a.a.a().obtainMessage(3, a).sendToTarget();
            }
            a.clear();
        } finally {
            b.unlock();
        }
    }

    public static void b(com.taobao.tao.remotebusiness.MtopBusiness r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b;
        r0.lock();
        r0 = r2.getSeqNo();	 Catch:{ Exception -> 0x0013, all -> 0x0019 }
        r1 = "request remove from request pool";	 Catch:{ Exception -> 0x0013, all -> 0x0019 }
        mtopsdk.common.util.j.b(r0, r1);	 Catch:{ Exception -> 0x0013, all -> 0x0019 }
        r0 = a;	 Catch:{ Exception -> 0x0013, all -> 0x0019 }
        r0.remove(r2);	 Catch:{ Exception -> 0x0013, all -> 0x0019 }
    L_0x0013:
        r2 = b;
        r2.unlock();
        return;
    L_0x0019:
        r2 = move-exception;
        r0 = b;
        r0.unlock();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.a.b(com.taobao.tao.remotebusiness.MtopBusiness):void");
    }
}
