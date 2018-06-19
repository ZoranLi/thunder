package com.alipay.sdk.util;

import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback.Stub;

final class g extends Stub {
    final /* synthetic */ e a;

    public final boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    public final void payEnd(boolean z, String str) throws RemoteException {
    }

    g(e eVar) {
        this.a = eVar;
    }

    public final void startActivity(java.lang.String r4, java.lang.String r5, int r6, android.os.Bundle r7) throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new android.content.Intent;
        r1 = "android.intent.action.MAIN";
        r2 = 0;
        r0.<init>(r1, r2);
        if (r7 != 0) goto L_0x000f;
    L_0x000a:
        r7 = new android.os.Bundle;
        r7.<init>();
    L_0x000f:
        r1 = "CallingPid";	 Catch:{ Exception -> 0x0017 }
        r7.putInt(r1, r6);	 Catch:{ Exception -> 0x0017 }
        r0.putExtras(r7);	 Catch:{ Exception -> 0x0017 }
    L_0x0017:
        r0.setClassName(r4, r5);
        r4 = r3.a;
        r4 = r4.a;
        if (r4 == 0) goto L_0x002b;
    L_0x0022:
        r4 = r3.a;
        r4 = r4.a;
        r4.startActivity(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.g.startActivity(java.lang.String, java.lang.String, int, android.os.Bundle):void");
    }
}
