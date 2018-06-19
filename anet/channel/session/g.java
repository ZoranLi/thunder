package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
class g implements RequestCb {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void onResponseCode(int r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        if (r7 > 0) goto L_0x0015;
    L_0x0003:
        r1 = r6.a;
        r1 = r1.d;
        r2 = anet.channel.entity.EventType.DISCONNECTED;
        r3 = new anet.channel.entity.d;
        r4 = anet.channel.entity.EventType.DISCONNECTED;
        r5 = "Http connect fail";
        r3.<init>(r4, r0, r5);
        r1.handleCallbacks(r2, r3);
    L_0x0015:
        r1 = "s-rt";	 Catch:{ NumberFormatException -> 0x0035 }
        r1 = r8.get(r1);	 Catch:{ NumberFormatException -> 0x0035 }
        r1 = (java.util.List) r1;	 Catch:{ NumberFormatException -> 0x0035 }
        if (r1 == 0) goto L_0x0035;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x001f:
        r2 = r1.isEmpty();	 Catch:{ NumberFormatException -> 0x0035 }
        if (r2 != 0) goto L_0x0035;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x0025:
        r2 = r6.a;	 Catch:{ NumberFormatException -> 0x0035 }
        r2 = r2.b;	 Catch:{ NumberFormatException -> 0x0035 }
        r0 = r1.get(r0);	 Catch:{ NumberFormatException -> 0x0035 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0035 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0035 }
        r2.serverRT = r0;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x0035:
        r0 = r6.a;
        r0 = r0.c;
        r0.onResponseCode(r7, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.g.onResponseCode(int, java.util.Map):void");
    }

    public void onDataReceive(ByteArray byteArray, boolean z) {
        this.a.c.onDataReceive(byteArray, z);
    }

    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
        this.a.c.onFinish(i, str, requestStatistic);
    }
}
