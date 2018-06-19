package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;

public class PushServiceReceiver extends BroadcastReceiver {
    public void onReceive(android.content.Context r3, android.content.Intent r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new android.content.Intent;
        r1 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r0.<init>(r3, r1);
        r0.putExtras(r4);
        r4 = r4.getAction();
        r0.setAction(r4);
        r3.startService(r0);	 Catch:{ Exception -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushServiceReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
