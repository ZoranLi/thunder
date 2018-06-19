package com.xunlei.downloadprovider.pushmessage.umeng;

import com.umeng.message.UmengMessageService;

public class UmengPushHandleService extends UmengMessageService {
    static final String a = "UmengPushHandleService";

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onMessage(android.content.Context r4, android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "body";	 Catch:{ Exception -> 0x002a }
        r5 = r5.getStringExtra(r0);	 Catch:{ Exception -> 0x002a }
        r0 = new com.umeng.message.entity.UMessage;	 Catch:{ Exception -> 0x002a }
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x002a }
        r1.<init>(r5);	 Catch:{ Exception -> 0x002a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x002a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002a }
        r2 = "custom=";	 Catch:{ Exception -> 0x002a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x002a }
        r0 = r0.custom;	 Catch:{ Exception -> 0x002a }
        r1.append(r0);	 Catch:{ Exception -> 0x002a }
        r0 = com.xunlei.downloadprovider.pushmessage.b.b.a();	 Catch:{ Exception -> 0x002a }
        r1 = "umeng_register_id";	 Catch:{ Exception -> 0x002a }
        r0 = r0.a(r1);	 Catch:{ Exception -> 0x002a }
        com.xunlei.downloadprovider.pushmessage.h.b(r4, r5, r0);	 Catch:{ Exception -> 0x002a }
        return;
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.umeng.UmengPushHandleService.onMessage(android.content.Context, android.content.Intent):void");
    }
}
