package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

/* compiled from: PushNotificationHandler */
public final class f {
    private Handler a;

    public final void a(android.content.Context r4, android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new com.xunlei.xllib.android.XLIntent;	 Catch:{ Exception -> 0x00a1 }
        r0.<init>();	 Catch:{ Exception -> 0x00a1 }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x00a1 }
        r0.addFlags(r1);	 Catch:{ Exception -> 0x00a1 }
        r0 = "push_biz";	 Catch:{ Exception -> 0x00a1 }
        r0 = r5.getSerializableExtra(r0);	 Catch:{ Exception -> 0x00a1 }
        r0 = (com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz) r0;	 Catch:{ Exception -> 0x00a1 }
        if (r0 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x00a1 }
    L_0x0014:
        return;	 Catch:{ Exception -> 0x00a1 }
    L_0x0015:
        r1 = "ACTION";	 Catch:{ Exception -> 0x00a1 }
        r2 = -1;	 Catch:{ Exception -> 0x00a1 }
        r5 = r5.getIntExtra(r1, r2);	 Catch:{ Exception -> 0x00a1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a1 }
        r2 = "onReceive pushBiz: ";	 Catch:{ Exception -> 0x00a1 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a1 }
        r2 = r0.toString();	 Catch:{ Exception -> 0x00a1 }
        r1.append(r2);	 Catch:{ Exception -> 0x00a1 }
        r2 = ",action=";	 Catch:{ Exception -> 0x00a1 }
        r1.append(r2);	 Catch:{ Exception -> 0x00a1 }
        r1.append(r5);	 Catch:{ Exception -> 0x00a1 }
        r1 = 4;	 Catch:{ Exception -> 0x00a1 }
        switch(r5) {
            case 500: goto L_0x006d;
            case 501: goto L_0x0037;
            default: goto L_0x0036;
        };	 Catch:{ Exception -> 0x00a1 }
    L_0x0036:
        goto L_0x00a0;	 Catch:{ Exception -> 0x00a1 }
    L_0x0037:
        r5 = r0.getInfo();	 Catch:{ Exception -> 0x00a1 }
        r5 = r5.getServerType();	 Catch:{ Exception -> 0x00a1 }
        if (r5 == r1) goto L_0x0068;
    L_0x0041:
        switch(r5) {
            case 1: goto L_0x0063;
            case 2: goto L_0x0045;
            default: goto L_0x0044;
        };
    L_0x0044:
        goto L_0x006c;
    L_0x0045:
        r5 = new com.umeng.message.entity.UMessage;	 Catch:{ JSONException -> 0x0062 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0062 }
        r2 = r0.getInfo();	 Catch:{ JSONException -> 0x0062 }
        r2 = r2.getOriginMsgBody();	 Catch:{ JSONException -> 0x0062 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0062 }
        r5.<init>(r1);	 Catch:{ JSONException -> 0x0062 }
        r1 = com.umeng.message.UTrack.getInstance(r4);	 Catch:{ JSONException -> 0x0062 }
        r1.trackMsgDismissed(r5);	 Catch:{ JSONException -> 0x0062 }
        a(r4, r0);	 Catch:{ JSONException -> 0x0062 }
        return;
    L_0x0062:
        return;
    L_0x0063:
        a(r4, r0);	 Catch:{ Exception -> 0x0067 }
        return;
    L_0x0067:
        return;
    L_0x0068:
        a(r4, r0);	 Catch:{ Exception -> 0x006c }
        return;
    L_0x006c:
        return;
    L_0x006d:
        r5 = r0.getInfo();	 Catch:{ Exception -> 0x00a1 }
        r5 = r5.getServerType();	 Catch:{ Exception -> 0x00a1 }
        if (r5 == r1) goto L_0x009d;
    L_0x0077:
        switch(r5) {
            case 1: goto L_0x0099;
            case 2: goto L_0x007b;
            default: goto L_0x007a;
        };
    L_0x007a:
        goto L_0x00a0;
    L_0x007b:
        r5 = new com.umeng.message.entity.UMessage;	 Catch:{ JSONException -> 0x0098 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0098 }
        r2 = r0.getInfo();	 Catch:{ JSONException -> 0x0098 }
        r2 = r2.getOriginMsgBody();	 Catch:{ JSONException -> 0x0098 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0098 }
        r5.<init>(r1);	 Catch:{ JSONException -> 0x0098 }
        r1 = com.umeng.message.UTrack.getInstance(r4);	 Catch:{ JSONException -> 0x0098 }
        r1.trackMsgClick(r5);	 Catch:{ JSONException -> 0x0098 }
        r3.b(r4, r0);	 Catch:{ JSONException -> 0x0098 }
        return;
    L_0x0098:
        return;
    L_0x0099:
        r3.b(r4, r0);	 Catch:{ Exception -> 0x00a1 }
        return;	 Catch:{ Exception -> 0x00a1 }
    L_0x009d:
        r3.b(r4, r0);	 Catch:{ Exception -> 0x00a1 }
    L_0x00a0:
        return;
    L_0x00a1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.f.a(android.content.Context, android.content.Intent):void");
    }

    private static void a(Context context, BasePushBiz basePushBiz) {
        if (basePushBiz != null) {
            basePushBiz.onDismiss(context);
        }
    }

    private void b(Context context, BasePushBiz basePushBiz) {
        new StringBuilder("dispatchJump -----------msg.displayType=").append(basePushBiz.getInfo().getDisplayType());
        Intent createClickIntent = basePushBiz.createClickIntent(context);
        if (createClickIntent != null) {
            if (this.a == null) {
                this.a = new Handler();
            }
            Handler handler = this.a;
            Runnable gVar = new g(this, context, createClickIntent, basePushBiz);
            long j = 500;
            if ("OPPO".equals(AndroidConfig.getPhoneBrand()) != null) {
                j = 0;
            }
            handler.postDelayed(gVar, j);
        }
    }
}
