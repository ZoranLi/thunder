package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.d;
import com.igexin.b.a.b.f;
import com.igexin.b.a.c.a;
import com.igexin.push.c.i;
import com.igexin.push.config.SDKUrlConfig;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.android.spdy.TnetStatusCode;

public final class c extends a {
    private d i;
    private Socket j;

    public c(d dVar) {
        super(TnetStatusCode.EASY_REASON_INVALID_DATA, null, null);
        this.i = dVar;
    }

    public final int b() {
        return TnetStatusCode.EASY_REASON_INVALID_DATA;
    }

    public final void b_() {
        super.b_();
        i.a().e().a();
        String cmAddress = SDKUrlConfig.getCmAddress();
        StringBuilder stringBuilder;
        try {
            String[] a = f.a(cmAddress);
            String str = a[1];
            int parseInt = Integer.parseInt(a[2]);
            StringBuilder stringBuilder2 = new StringBuilder("S-SCT|start connect :  ");
            stringBuilder2.append(cmAddress);
            stringBuilder2.append(" *********");
            a.b(stringBuilder2.toString());
            if (this.i != null) {
                this.i.a(cmAddress);
            }
            this.j = new Socket();
            try {
                this.j.connect(new InetSocketAddress(str, parseInt), 10000);
                stringBuilder = new StringBuilder("S-SCT|connected :  ");
                stringBuilder.append(cmAddress);
                stringBuilder.append(" #########");
                a.b(stringBuilder.toString());
                if (this.f != b.INTERRUPT) {
                    this.f = b.NORMAL;
                }
            } catch (Exception e) {
                if (this.f != b.INTERRUPT) {
                    this.f = b.EXCEPTION;
                    this.g = e.toString();
                }
            }
            this.e = true;
        } catch (Exception e2) {
            stringBuilder = new StringBuilder("S-SCT|ips invalid, ");
            stringBuilder.append(e2.toString());
            a.b(stringBuilder.toString());
            throw e2;
        }
    }

    public final void f() {
        super.f();
        a.b("S-SCT|dispose");
        if (this.i != null) {
            if (this.f == b.INTERRUPT) {
                this.i.a(this);
            } else if (this.f == b.EXCEPTION) {
                if (!TextUtils.isEmpty(this.g)) {
                    this.i.a(new Exception(this.g));
                }
            } else if (this.f == b.NORMAL && this.j != null) {
                this.i.a(this.j);
            }
        }
        this.i = null;
    }

    public final void h() {
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
        r0 = com.igexin.b.a.b.a.a.b.INTERRUPT;
        r1.f = r0;
        r0 = r1.j;	 Catch:{ Exception -> 0x0011 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0011 }
    L_0x0008:
        r0 = r1.e;	 Catch:{ Exception -> 0x0011 }
        if (r0 != 0) goto L_0x0011;	 Catch:{ Exception -> 0x0011 }
    L_0x000c:
        r0 = r1.j;	 Catch:{ Exception -> 0x0011 }
        r0.notifyAll();	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.c.h():void");
    }
}
