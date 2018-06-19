package com.xunlei.common.new_ptl.member.task.g;

import com.xunlei.common.httpclient.BaseHttpClientListener;

/* compiled from: UserGetAuthQRCodeTask */
final class a$2 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$2(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int r4, org.apache.http.Header[] r5, byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 != r5) goto L_0x004b;
    L_0x0004:
        r4 = 1026; // 0x402 float:1.438E-42 double:5.07E-321;
        r5 = new java.lang.String;	 Catch:{ NumberFormatException -> 0x0034 }
        r5.<init>(r6);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = r5.intValue();	 Catch:{ NumberFormatException -> 0x0034 }
        r0 = "UserGetAuthQRCodeTask";	 Catch:{ NumberFormatException -> 0x0034 }
        r1 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0034 }
        r2 = "get qr image error = ";	 Catch:{ NumberFormatException -> 0x0034 }
        r1.<init>(r2);	 Catch:{ NumberFormatException -> 0x0034 }
        r1.append(r5);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = r1.toString();	 Catch:{ NumberFormatException -> 0x0034 }
        com.xunlei.common.base.XLLog.v(r0, r5);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = r3.a;	 Catch:{ NumberFormatException -> 0x0034 }
        r0 = 50331650; // 0x3000002 float:3.761583E-37 double:2.4867139E-316;	 Catch:{ NumberFormatException -> 0x0034 }
        com.xunlei.common.new_ptl.member.task.g.a.b(r5, r0);	 Catch:{ NumberFormatException -> 0x0034 }
        r5 = r3.a;	 Catch:{ NumberFormatException -> 0x0034 }
        com.xunlei.common.new_ptl.member.task.g.a.a(r5, r4);	 Catch:{ NumberFormatException -> 0x0034 }
        return;
    L_0x0034:
        r5 = "UserGetAuthQRCodeTask";
        r0 = "get qr image succeed!";
        com.xunlei.common.base.XLLog.v(r5, r0);
        r5 = r3.a;
        com.xunlei.common.new_ptl.member.task.g.a.a(r5, r6);
        r5 = r3.a;
        r6 = 0;
        com.xunlei.common.new_ptl.member.task.g.a.b(r5, r6);
        r5 = r3.a;
        com.xunlei.common.new_ptl.member.task.g.a.a(r5, r4);
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.g.a$2.onSuccess(int, org.apache.http.Header[], byte[]):void");
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        a.b(this.a, 50331650);
        a.a(this.a, 1026);
    }
}
