package com.umeng.message;

import com.umeng.message.UTrack.ICallBack;

class UTrack$2 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ ICallBack c;
    final /* synthetic */ UTrack d;

    UTrack$2(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
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
        r14 = this;
        r0 = "";
        r1 = "";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "utdid:";
        r2.append(r0);
        r0 = r14.d;
        r0 = com.umeng.message.UTrack.a(r0);
        r0 = com.umeng.message.common.UmengMessageDeviceConfig.getUtdid(r0);
        r2.append(r0);
        r0 = ",deviceToken:";
        r2.append(r0);
        r0 = r14.d;
        r0 = com.umeng.message.UTrack.a(r0);
        r0 = com.umeng.message.MessageSharedPrefs.getInstance(r0);
        r0 = r0.getDeviceToken();
        r2.append(r0);
        r0 = ";";
        r2.append(r0);
        r0 = r2.toString();
        r2 = r14.a;
        r2 = android.text.TextUtils.isEmpty(r2);
        r3 = 0;
        if (r2 != 0) goto L_0x0051;
    L_0x0046:
        r2 = r14.b;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x004f;
    L_0x004e:
        goto L_0x0051;
    L_0x004f:
        r2 = r3;
        goto L_0x006d;
    L_0x0051:
        r2 = com.umeng.message.UTrack.a();
        r4 = "addAlias: empty type or alias";
        com.umeng.message.common.UmLog.e(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "addAlias: empty type or alias;";
        r2.append(r0);
        r0 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.d;
    L_0x006d:
        r4 = r14.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.common.UmengMessageDeviceConfig.getUtdid(r4);
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0099;
    L_0x007d:
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
    L_0x0099:
        r4 = r14.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.MessageSharedPrefs.getInstance(r4);
        r4 = r4.getDeviceToken();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x00c9;
    L_0x00ad:
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
    L_0x00c9:
        r4 = r14.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.MessageSharedPrefs.getInstance(r4);
        r5 = r14.b;
        r6 = r14.a;
        r7 = 0;
        r4 = r4.isAliasSet(r7, r5, r6);
        if (r4 == 0) goto L_0x0118;
    L_0x00de:
        r2 = com.umeng.message.UTrack.a();
        r4 = "addAlias: <%s, %s> has been synced to the server before. Ingore this request.";
        r5 = 2;
        r6 = new java.lang.Object[r5];
        r8 = r14.b;
        r6[r7] = r8;
        r8 = r14.a;
        r9 = 1;
        r6[r9] = r8;
        r4 = java.lang.String.format(r4, r6);
        com.umeng.message.common.UmLog.d(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r1 = "addAlias: <%s, %s> has been synced to the server before. Ingore this request;";
        r4 = new java.lang.Object[r5];
        r5 = r14.b;
        r4[r7] = r5;
        r5 = r14.a;
        r4[r9] = r5;
        r1 = java.lang.String.format(r1, r4);
        r2.append(r1);
        r1 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.a;
    L_0x0118:
        r4 = r14.d;	 Catch:{ Exception -> 0x0172 }
        r4 = com.umeng.message.UTrack.b(r4);	 Catch:{ Exception -> 0x0172 }
        if (r2 != 0) goto L_0x014f;
    L_0x0120:
        r0 = "alias";	 Catch:{ Exception -> 0x014d }
        r1 = r14.b;	 Catch:{ Exception -> 0x014d }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x014d }
        r0 = "type";	 Catch:{ Exception -> 0x014d }
        r1 = r14.a;	 Catch:{ Exception -> 0x014d }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x014d }
        r0 = "last_alias";	 Catch:{ Exception -> 0x014d }
        r1 = r14.d;	 Catch:{ Exception -> 0x014d }
        r1 = com.umeng.message.UTrack.a(r1);	 Catch:{ Exception -> 0x014d }
        r1 = com.umeng.message.MessageSharedPrefs.getInstance(r1);	 Catch:{ Exception -> 0x014d }
        r2 = r14.a;	 Catch:{ Exception -> 0x014d }
        r1 = r1.getLastAlias(r7, r2);	 Catch:{ Exception -> 0x014d }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x014d }
        r0 = "ts";	 Catch:{ Exception -> 0x014d }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x014d }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x014d }
        goto L_0x0162;	 Catch:{ Exception -> 0x014d }
    L_0x014d:
        r0 = move-exception;	 Catch:{ Exception -> 0x014d }
        goto L_0x0174;	 Catch:{ Exception -> 0x014d }
    L_0x014f:
        r3 = com.umeng.message.UTrack$SuccessState.d;	 Catch:{ Exception -> 0x014d }
        if (r2 != r3) goto L_0x0159;	 Catch:{ Exception -> 0x014d }
    L_0x0153:
        r1 = "fail";	 Catch:{ Exception -> 0x014d }
        r4.put(r1, r0);	 Catch:{ Exception -> 0x014d }
        goto L_0x0162;	 Catch:{ Exception -> 0x014d }
    L_0x0159:
        r0 = com.umeng.message.UTrack$SuccessState.a;	 Catch:{ Exception -> 0x014d }
        if (r2 != r0) goto L_0x0162;	 Catch:{ Exception -> 0x014d }
    L_0x015d:
        r0 = "success";	 Catch:{ Exception -> 0x014d }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x014d }
    L_0x0162:
        r8 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x014d }
        r9 = r14.b;	 Catch:{ Exception -> 0x014d }
        r10 = r14.a;	 Catch:{ Exception -> 0x014d }
        r12 = r14.c;	 Catch:{ Exception -> 0x014d }
        r13 = 1;	 Catch:{ Exception -> 0x014d }
        r11 = r4;	 Catch:{ Exception -> 0x014d }
        r8.addAlias(r9, r10, r11, r12, r13);	 Catch:{ Exception -> 0x014d }
        return;
    L_0x0172:
        r0 = move-exception;
        r4 = r3;
    L_0x0174:
        r1 = r0.getMessage();
        if (r1 == 0) goto L_0x01f0;
    L_0x017a:
        r1 = r0.getMessage();
        r2 = com.umeng.message.MsgConstant.HTTPS_ERROR;
        r1 = r1.contains(r2);
        if (r1 == 0) goto L_0x01b7;
    L_0x0186:
        r1 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x0195 }
        r2 = r14.b;	 Catch:{ Exception -> 0x0195 }
        r3 = r14.a;	 Catch:{ Exception -> 0x0195 }
        r5 = r14.c;	 Catch:{ Exception -> 0x0195 }
        r6 = 0;	 Catch:{ Exception -> 0x0195 }
        r1.addAlias(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0195 }
        goto L_0x01d8;
    L_0x0195:
        r1 = r14.c;
        r2 = new java.lang.StringBuilder;
        r3 = "alias:";
        r2.<init>(r3);
        r3 = r14.b;
        r2.append(r3);
        r3 = "添加失败:";
        r2.append(r3);
        r3 = r0.getMessage();
        r2.append(r3);
        r2 = r2.toString();
        r1.onMessage(r7, r2);
        goto L_0x01d8;
    L_0x01b7:
        r1 = r14.c;
        r2 = new java.lang.StringBuilder;
        r3 = "alias:";
        r2.<init>(r3);
        r3 = r14.b;
        r2.append(r3);
        r3 = "添加失败:";
        r2.append(r3);
        r3 = r0.getMessage();
        r2.append(r3);
        r2 = r2.toString();
        r1.onMessage(r7, r2);
    L_0x01d8:
        r1 = r14.d;
        r1 = com.umeng.message.UTrack.a(r1);
        r2 = com.umeng.message.MessageSharedPrefs.getInstance(r1);
        r3 = r14.b;
        r4 = r14.a;
        r5 = 0;
        r6 = 1;
        r7 = r0.getMessage();
        r2.addAlias(r3, r4, r5, r6, r7);
        return;
    L_0x01f0:
        r0 = r14.c;
        r1 = new java.lang.StringBuilder;
        r2 = "alias:";
        r1.<init>(r2);
        r2 = r14.b;
        r1.append(r2);
        r2 = "添加失败";
        r1.append(r2);
        r1 = r1.toString();
        r0.onMessage(r7, r1);
        r0 = r14.d;
        r0 = com.umeng.message.UTrack.a(r0);
        r1 = com.umeng.message.MessageSharedPrefs.getInstance(r0);
        r2 = r14.b;
        r3 = r14.a;
        r4 = 0;
        r5 = 1;
        r6 = "添加失败";
        r1.addAlias(r2, r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UTrack$2.run():void");
    }
}
