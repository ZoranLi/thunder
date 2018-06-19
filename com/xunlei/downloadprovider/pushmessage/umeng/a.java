package com.xunlei.downloadprovider.pushmessage.umeng;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.PushAgent;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.e;

/* compiled from: UmengPushManager */
public final class a extends e {
    public final String a() {
        return "upush";
    }

    protected final void a(Context context, int[] iArr) {
    }

    protected final String b() {
        return "umeng_register_id";
    }

    public final void a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = com.umeng.message.PushAgent.getInstance(r2);	 Catch:{ Exception -> 0x0016 }
        r0 = 0;	 Catch:{ Exception -> 0x0016 }
        r2.setDebugMode(r0);	 Catch:{ Exception -> 0x0016 }
        r0 = new com.xunlei.downloadprovider.pushmessage.umeng.b;	 Catch:{ Exception -> 0x0016 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0016 }
        r2.register(r0);	 Catch:{ Exception -> 0x0016 }
        r0 = com.xunlei.downloadprovider.pushmessage.umeng.UmengPushHandleService.class;	 Catch:{ Exception -> 0x0016 }
        r2.setPushIntentServiceClass(r0);	 Catch:{ Exception -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.umeng.a.a(android.content.Context):void");
    }

    public final void a(String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(PushAgent.getInstance(BrothersApplication.getApplicationInstance()).getRegistrationId())) {
            XLThreadPool.execute(new c(this, strArr));
        }
    }
}
