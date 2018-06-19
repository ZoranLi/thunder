package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;

public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    public final void onReceive(android.content.Context r2, android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new com.xiaomi.mipush.sdk.MessageHandleService$a;
        r0.<init>(r3, r1);
        com.xiaomi.mipush.sdk.MessageHandleService.addJob(r0);
        r3 = new android.content.Intent;
        r0 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r3.<init>(r2, r0);
        r2.startService(r3);	 Catch:{ Exception -> 0x0012 }
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushMessageReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }
}
