package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.igexin.b.a.c.a;
import com.igexin.sdk.PushConsts;

public class n extends BroadcastReceiver {
    private static n a;

    private n() {
    }

    public static n a() {
        if (a == null) {
            a = new n();
        }
        return a;
    }

    private void a(android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "----------------------------------------------------------------------------------";	 Catch:{ Exception -> 0x0064 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x0064 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0064 }
        r1 = "InternalPublicReceiver|action = ";	 Catch:{ Exception -> 0x0064 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0064 }
        r1 = r5.getAction();	 Catch:{ Exception -> 0x0064 }
        r0.append(r1);	 Catch:{ Exception -> 0x0064 }
        r1 = ", component = ";	 Catch:{ Exception -> 0x0064 }
        r0.append(r1);	 Catch:{ Exception -> 0x0064 }
        r1 = r5.getComponent();	 Catch:{ Exception -> 0x0064 }
        r0.append(r1);	 Catch:{ Exception -> 0x0064 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0064 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x0064 }
        r5 = r5.getExtras();	 Catch:{ Exception -> 0x0064 }
        if (r5 == 0) goto L_0x005f;	 Catch:{ Exception -> 0x0064 }
    L_0x002c:
        r0 = r5.keySet();	 Catch:{ Exception -> 0x0064 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0064 }
    L_0x0034:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0064 }
        if (r1 == 0) goto L_0x005e;	 Catch:{ Exception -> 0x0064 }
    L_0x003a:
        r1 = r0.next();	 Catch:{ Exception -> 0x0064 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0064 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0064 }
        r3 = "InternalPublicReceiver|key [";	 Catch:{ Exception -> 0x0064 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0064 }
        r2.append(r1);	 Catch:{ Exception -> 0x0064 }
        r3 = "]: ";	 Catch:{ Exception -> 0x0064 }
        r2.append(r3);	 Catch:{ Exception -> 0x0064 }
        r1 = r5.get(r1);	 Catch:{ Exception -> 0x0064 }
        r2.append(r1);	 Catch:{ Exception -> 0x0064 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0064 }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ Exception -> 0x0064 }
        goto L_0x0034;	 Catch:{ Exception -> 0x0064 }
    L_0x005e:
        return;	 Catch:{ Exception -> 0x0064 }
    L_0x005f:
        r5 = "InternalPublicReceiver|no extras";	 Catch:{ Exception -> 0x0064 }
        com.igexin.b.a.c.a.b(r5);	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.a(android.content.Intent):void");
    }

    public void onReceive(Context context, Intent intent) {
        if (!(intent == null || intent.getAction() == null || !intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE))) {
            a(intent);
        }
        StringBuilder stringBuilder = new StringBuilder("InternalPublicReceiver InternalPublicReceiver:");
        stringBuilder.append(intent);
        a.b(stringBuilder.toString() != null ? intent.getAction() : "null");
        if (f.a() != null) {
            Message message = new Message();
            message.what = a.d;
            message.obj = intent;
            f.a().a(message);
        }
    }
}
