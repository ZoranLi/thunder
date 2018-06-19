package com.xiaomi.push.service;

import android.os.Handler;

class bl extends Handler {
    final /* synthetic */ XMPushService a;

    bl(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void handleMessage(android.os.Message r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        super.handleMessage(r5);
        if (r5 == 0) goto L_0x003d;
    L_0x0005:
        r0 = r5.what;	 Catch:{ Throwable -> 0x003d }
        switch(r0) {
            case 17: goto L_0x002e;
            case 18: goto L_0x000b;
            default: goto L_0x000a;
        };	 Catch:{ Throwable -> 0x003d }
    L_0x000a:
        return;	 Catch:{ Throwable -> 0x003d }
    L_0x000b:
        r0 = 0;	 Catch:{ Throwable -> 0x003d }
        r1 = 0;	 Catch:{ Throwable -> 0x003d }
        r0 = android.os.Message.obtain(r0, r1);	 Catch:{ Throwable -> 0x003d }
        r1 = 18;	 Catch:{ Throwable -> 0x003d }
        r0.what = r1;	 Catch:{ Throwable -> 0x003d }
        r1 = new android.os.Bundle;	 Catch:{ Throwable -> 0x003d }
        r1.<init>();	 Catch:{ Throwable -> 0x003d }
        r2 = "xmsf_region";	 Catch:{ Throwable -> 0x003d }
        r3 = r4.a;	 Catch:{ Throwable -> 0x003d }
        r3 = r3.f;	 Catch:{ Throwable -> 0x003d }
        r1.putString(r2, r3);	 Catch:{ Throwable -> 0x003d }
        r0.setData(r1);	 Catch:{ Throwable -> 0x003d }
        r5 = r5.replyTo;	 Catch:{ Throwable -> 0x003d }
        r5.send(r0);	 Catch:{ Throwable -> 0x003d }
        return;	 Catch:{ Throwable -> 0x003d }
    L_0x002e:
        r0 = r5.obj;	 Catch:{ Throwable -> 0x003d }
        if (r0 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003d }
    L_0x0032:
        r5 = r5.obj;	 Catch:{ Throwable -> 0x003d }
        r5 = (android.content.Intent) r5;	 Catch:{ Throwable -> 0x003d }
        r0 = r4.a;	 Catch:{ Throwable -> 0x003d }
        r1 = com.xiaomi.push.service.XMPushService.c;	 Catch:{ Throwable -> 0x003d }
        r0.onStart(r5, r1);	 Catch:{ Throwable -> 0x003d }
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bl.handleMessage(android.os.Message):void");
    }
}
