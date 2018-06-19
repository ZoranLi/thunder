package com.umeng.message;

import com.umeng.message.UTrack.ICallBack;

class UTrack$4 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ ICallBack c;
    final /* synthetic */ UTrack d;

    UTrack$4(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
        this.d = uTrack;
        this.a = str;
        this.b = str2;
        this.c = iCallBack;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = "";
        r1 = "";
        r2 = r11.a;
        r2 = android.text.TextUtils.isEmpty(r2);
        r3 = 0;
        if (r2 == 0) goto L_0x002a;
    L_0x000d:
        r2 = com.umeng.message.UTrack.a();
        r4 = "removeAlias: empty type";
        com.umeng.message.common.UmLog.e(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "removeAlias: empty type";
        r2.append(r0);
        r0 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.d;
        goto L_0x002b;
    L_0x002a:
        r2 = r3;
    L_0x002b:
        r4 = r11.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.common.UmengMessageDeviceConfig.getUtdid(r4);
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0057;
    L_0x003b:
        r2 = com.umeng.message.UTrack.a();
        r4 = "UTDID is empty";
        com.umeng.message.common.UmLog.e(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "UTDID is empty;";
        r2.append(r0);
        r0 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.d;
    L_0x0057:
        r4 = r11.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.MessageSharedPrefs.getInstance(r4);
        r4 = r4.getDeviceToken();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0087;
    L_0x006b:
        r2 = com.umeng.message.UTrack.a();
        r4 = "RegistrationId is empty";
        com.umeng.message.common.UmLog.e(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "RegistrationId is empty;";
        r2.append(r0);
        r0 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.d;
    L_0x0087:
        r4 = r11.d;	 Catch:{ Exception -> 0x00cc }
        r4 = com.umeng.message.UTrack.b(r4);	 Catch:{ Exception -> 0x00cc }
        if (r2 != 0) goto L_0x00a9;
    L_0x008f:
        r0 = "alias";	 Catch:{ Exception -> 0x00a7 }
        r1 = r11.b;	 Catch:{ Exception -> 0x00a7 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x00a7 }
        r0 = "type";	 Catch:{ Exception -> 0x00a7 }
        r1 = r11.a;	 Catch:{ Exception -> 0x00a7 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x00a7 }
        r0 = "ts";	 Catch:{ Exception -> 0x00a7 }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a7 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x00a7 }
        goto L_0x00bc;	 Catch:{ Exception -> 0x00a7 }
    L_0x00a7:
        r0 = move-exception;	 Catch:{ Exception -> 0x00a7 }
        goto L_0x00ce;	 Catch:{ Exception -> 0x00a7 }
    L_0x00a9:
        r3 = com.umeng.message.UTrack$SuccessState.d;	 Catch:{ Exception -> 0x00a7 }
        if (r2 != r3) goto L_0x00b3;	 Catch:{ Exception -> 0x00a7 }
    L_0x00ad:
        r1 = "fail";	 Catch:{ Exception -> 0x00a7 }
        r4.put(r1, r0);	 Catch:{ Exception -> 0x00a7 }
        goto L_0x00bc;	 Catch:{ Exception -> 0x00a7 }
    L_0x00b3:
        r0 = com.umeng.message.UTrack$SuccessState.a;	 Catch:{ Exception -> 0x00a7 }
        if (r2 != r0) goto L_0x00bc;	 Catch:{ Exception -> 0x00a7 }
    L_0x00b7:
        r0 = "success";	 Catch:{ Exception -> 0x00a7 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x00a7 }
    L_0x00bc:
        r5 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x00a7 }
        r6 = r11.b;	 Catch:{ Exception -> 0x00a7 }
        r7 = r11.a;	 Catch:{ Exception -> 0x00a7 }
        r9 = r11.c;	 Catch:{ Exception -> 0x00a7 }
        r10 = 1;	 Catch:{ Exception -> 0x00a7 }
        r8 = r4;	 Catch:{ Exception -> 0x00a7 }
        r5.removeAlias(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x00a7 }
        return;
    L_0x00cc:
        r0 = move-exception;
        r4 = r3;
    L_0x00ce:
        r1 = r0.getMessage();
        r7 = 0;
        if (r1 == 0) goto L_0x0134;
    L_0x00d5:
        r1 = r0.getMessage();
        r2 = com.umeng.message.MsgConstant.HTTPS_ERROR;
        r1 = r1.contains(r2);
        if (r1 == 0) goto L_0x0112;
    L_0x00e1:
        r1 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x00f0 }
        r2 = r11.b;	 Catch:{ Exception -> 0x00f0 }
        r3 = r11.a;	 Catch:{ Exception -> 0x00f0 }
        r5 = r11.c;	 Catch:{ Exception -> 0x00f0 }
        r6 = 0;	 Catch:{ Exception -> 0x00f0 }
        r1.removeAlias(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00f0 }
        return;
    L_0x00f0:
        r1 = r11.c;
        r2 = new java.lang.StringBuilder;
        r3 = "alias:";
        r2.<init>(r3);
        r3 = r11.b;
        r2.append(r3);
        r3 = "移除失败:";
        r2.append(r3);
        r0 = r0.getMessage();
        r2.append(r0);
        r0 = r2.toString();
        r1.onMessage(r7, r0);
        return;
    L_0x0112:
        r1 = r11.c;
        r2 = new java.lang.StringBuilder;
        r3 = "alias:";
        r2.<init>(r3);
        r3 = r11.b;
        r2.append(r3);
        r3 = "移除失败:";
        r2.append(r3);
        r0 = r0.getMessage();
        r2.append(r0);
        r0 = r2.toString();
        r1.onMessage(r7, r0);
        return;
    L_0x0134:
        r0 = r11.c;
        r1 = new java.lang.StringBuilder;
        r2 = "alias:";
        r1.<init>(r2);
        r2 = r11.b;
        r1.append(r2);
        r2 = "移除失败";
        r1.append(r2);
        r1 = r1.toString();
        r0.onMessage(r7, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UTrack$4.run():void");
    }
}
