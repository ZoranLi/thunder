package mtopsdk.mtop.d;

import java.util.Map;
import mtopsdk.a.a;
import mtopsdk.mtop.a.d;

public final class b implements a {
    private static a a(mtopsdk.a.b.b bVar) {
        d.a();
        return d.k().a(bVar);
    }

    private static mtopsdk.a.b.b c(mtopsdk.mtop.a aVar, Map map) {
        if (aVar != null) {
            if (map != null) {
                return new mtopsdk.mtop.d.a.b().a(aVar, map);
            }
        }
        return null;
    }

    public final mtopsdk.mtop.domain.MtopResponse a(mtopsdk.mtop.a r6, java.util.Map r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r6.k;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = new mtopsdk.mtop.util.h;
        r0.<init>();
        r6.k = r0;
    L_0x000b:
        r0 = r6.k;
        r0 = r0.q;
        r1 = r6.g;
        r2 = r1.getKey();
        r3 = mtopsdk.mtop.util.d.a();
        r3 = r3.contains(r2);
        if (r3 != 0) goto L_0x0054;
    L_0x001f:
        r3 = mtopsdk.mtop.a.e.a();
        r3 = mtopsdk.mtop.antiattack.c.a(r2, r3);
        if (r3 == 0) goto L_0x0054;
    L_0x0029:
        r6 = new mtopsdk.mtop.domain.MtopResponse;
        r7 = r1.getApiName();
        r1 = r1.getVersion();
        r3 = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
        r4 = "哎哟喂,被挤爆啦,请稍后重试";
        r6.<init>(r7, r1, r3, r4);
        r7 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;
        r7 = mtopsdk.common.util.j.a(r7);
        if (r7 == 0) goto L_0x0053;
    L_0x0042:
        r7 = new java.lang.StringBuilder;
        r1 = "[syncTransform] ANDROID_SYS_API_FLOW_LIMIT_LOCKED apiKey=";
        r7.<init>(r1);
        r7.append(r2);
        r7 = r7.toString();
        mtopsdk.common.util.j.c(r0, r7);
    L_0x0053:
        return r6;
    L_0x0054:
        r7 = c(r6, r7);
        r2 = 0;
        r3 = r6.k;	 Catch:{ Throwable -> 0x0075 }
        r3.e();	 Catch:{ Throwable -> 0x0075 }
        r7 = a(r7);	 Catch:{ Throwable -> 0x0075 }
        r7 = r7.b();	 Catch:{ Throwable -> 0x0075 }
        r3 = r6.k;	 Catch:{ Throwable -> 0x0076 }
        r3.f();	 Catch:{ Throwable -> 0x0076 }
        if (r7 == 0) goto L_0x008b;	 Catch:{ Throwable -> 0x0076 }
    L_0x006d:
        r3 = r6.k;	 Catch:{ Throwable -> 0x0076 }
        r4 = r7.d;	 Catch:{ Throwable -> 0x0076 }
        r3.a(r4);	 Catch:{ Throwable -> 0x0076 }
        goto L_0x008b;
    L_0x0075:
        r7 = r2;
    L_0x0076:
        r3 = new java.lang.StringBuilder;
        r4 = "[syncTransform] invoke call.execute error :apiKey=";
        r3.<init>(r4);
        r1 = r1.getKey();
        r3.append(r1);
        r1 = r3.toString();
        mtopsdk.common.util.j.f(r0, r1);
    L_0x008b:
        r0 = r6.k;
        r0.c();
        if (r7 != 0) goto L_0x00b0;
    L_0x0092:
        r7 = new mtopsdk.mtop.domain.MtopResponse;
        r0 = "ANDROID_SYS_NETWORK_ERROR";
        r1 = "网络错误";
        r7.<init>(r0, r1);
        if (r6 == 0) goto L_0x00bf;
    L_0x009d:
        r0 = r6.g;
        r0 = r0.getApiName();
        r7.setApi(r0);
        r0 = r6.g;
        r0 = r0.getVersion();
        r7.setV(r0);
        goto L_0x00bf;
    L_0x00b0:
        r0 = new mtopsdk.mtop.common.m;
        r1 = r7.a;
        r3 = r7.b;
        r7 = r7.c;
        r0.<init>(r1, r3, r7);
        r7 = mtopsdk.mtop.common.l.a(r2, r6, r0);
    L_0x00bf:
        r6 = r6.k;
        r6.d();
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.d.b.a(mtopsdk.mtop.a, java.util.Map):mtopsdk.mtop.domain.MtopResponse");
    }

    public final mtopsdk.mtop.common.a b(mtopsdk.mtop.a r8, java.util.Map r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r8.k;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = new mtopsdk.mtop.util.h;
        r0.<init>();
        r8.k = r0;
    L_0x000b:
        r0 = r8.k;
        r0 = r0.q;
        r1 = r8.g;
        r2 = r1.getKey();
        r3 = mtopsdk.mtop.util.d.a();
        r3 = r3.contains(r2);
        r4 = 0;
        if (r3 != 0) goto L_0x005d;
    L_0x0020:
        r5 = mtopsdk.mtop.a.e.a();
        r3 = mtopsdk.mtop.antiattack.c.a(r2, r5);
        if (r3 == 0) goto L_0x005d;
    L_0x002a:
        r9 = new mtopsdk.mtop.domain.MtopResponse;
        r0 = r1.getApiName();
        r1 = r1.getVersion();
        r3 = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
        r5 = "哎哟喂,被挤爆啦,请稍后重试";
        r9.<init>(r0, r1, r3, r5);
        r8.a(r9);
        r9 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;
        r9 = mtopsdk.common.util.j.a(r9);
        if (r9 == 0) goto L_0x0057;
    L_0x0046:
        r9 = new java.lang.StringBuilder;
        r0 = "[asyncTransform] ANDROID_SYS_API_FLOW_LIMIT_LOCKED apiKey=";
        r9.<init>(r0);
        r9.append(r2);
        r9 = r9.toString();
        mtopsdk.common.util.j.c(r9);
    L_0x0057:
        r9 = new mtopsdk.mtop.common.a;
        r9.<init>(r4, r8);
        return r9;
    L_0x005d:
        r9 = c(r8, r9);
        r2 = mtopsdk.mtop.util.d.a(r8);
        if (r2 == 0) goto L_0x006b;
    L_0x0067:
        r3 = r8.k;
        r2.c = r3;
    L_0x006b:
        r3 = r8.k;	 Catch:{ Exception -> 0x0078 }
        r3.e();	 Catch:{ Exception -> 0x0078 }
        r9 = a(r9);	 Catch:{ Exception -> 0x0078 }
        r9.a(r2);	 Catch:{ Exception -> 0x0079 }
        goto L_0x008e;
    L_0x0078:
        r9 = r4;
    L_0x0079:
        r2 = new java.lang.StringBuilder;
        r3 = "[asyncTransform] invoke call.enqueue error :apiKey=";
        r2.<init>(r3);
        r1 = r1.getKey();
        r2.append(r1);
        r1 = r2.toString();
        mtopsdk.common.util.j.f(r0, r1);
    L_0x008e:
        r0 = new mtopsdk.mtop.common.a;
        r0.<init>(r9, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.d.b.b(mtopsdk.mtop.a, java.util.Map):mtopsdk.mtop.common.a");
    }
}
