package com.xunlei.downloadprovider.homepage.follow;

import android.content.BroadcastReceiver;

/* compiled from: FollowManager */
final class c extends BroadcastReceiver {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = "com.xunlei.downloadprovider.intent.action.FOLLOW_LIST_CHANGE";
        r0 = r5.getAction();
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0034;
    L_0x000c:
        r4 = "playerid";	 Catch:{ Exception -> 0x0033 }
        r4 = r5.getStringExtra(r4);	 Catch:{ Exception -> 0x0033 }
        r0 = java.lang.Long.parseLong(r4);	 Catch:{ Exception -> 0x0033 }
        r4 = "followed";
        r2 = 0;
        r4 = r5.getBooleanExtra(r4, r2);
        if (r4 == 0) goto L_0x002d;
    L_0x001f:
        r4 = new com.xunlei.downloadprovider.publiser.common.h;
        r4.<init>();
        r5 = new com.xunlei.downloadprovider.homepage.follow.d;
        r5.<init>(r3);
        r4.a(r0, r5);
        return;
    L_0x002d:
        r4 = r3.a;
        com.xunlei.downloadprovider.homepage.follow.b.a(r4, r0);
        goto L_0x0034;
    L_0x0033:
        return;
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.follow.c.onReceive(android.content.Context, android.content.Intent):void");
    }
}
