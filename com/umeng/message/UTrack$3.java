package com.umeng.message;

import com.umeng.message.UTrack.ICallBack;

class UTrack$3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ ICallBack c;
    final /* synthetic */ UTrack d;

    UTrack$3(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
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
        r2 = r14.a;
        r2 = android.text.TextUtils.isEmpty(r2);
        r3 = 0;
        if (r2 == 0) goto L_0x002a;
    L_0x000d:
        r2 = com.umeng.message.UTrack.a();
        r4 = "addExclusiveAlias: empty type";
        com.umeng.message.common.UmLog.e(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "addExclusiveAlias: empty type";
        r2.append(r0);
        r0 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.d;
        goto L_0x002b;
    L_0x002a:
        r2 = r3;
    L_0x002b:
        r4 = r14.d;
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
        r4 = r14.d;
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
        r4 = r14.d;
        r4 = com.umeng.message.UTrack.a(r4);
        r4 = com.umeng.message.MessageSharedPrefs.getInstance(r4);
        r5 = r14.b;
        r6 = r14.a;
        r7 = 1;
        r4 = r4.isAliasSet(r7, r5, r6);
        r5 = 0;
        if (r4 == 0) goto L_0x00d6;
    L_0x009d:
        r2 = com.umeng.message.UTrack.a();
        r4 = "addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.";
        r6 = 2;
        r8 = new java.lang.Object[r6];
        r9 = r14.b;
        r8[r5] = r9;
        r9 = r14.a;
        r8[r7] = r9;
        r4 = java.lang.String.format(r4, r8);
        com.umeng.message.common.UmLog.d(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r1 = "addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.";
        r4 = new java.lang.Object[r6];
        r6 = r14.b;
        r4[r5] = r6;
        r6 = r14.a;
        r4[r7] = r6;
        r1 = java.lang.String.format(r1, r4);
        r2.append(r1);
        r1 = r2.toString();
        r2 = com.umeng.message.UTrack$SuccessState.a;
    L_0x00d6:
        r4 = r14.d;	 Catch:{ Exception -> 0x0131 }
        r4 = com.umeng.message.UTrack.b(r4);	 Catch:{ Exception -> 0x0131 }
        if (r2 != 0) goto L_0x010e;
    L_0x00de:
        r0 = "alias";	 Catch:{ Exception -> 0x010b }
        r1 = r14.b;	 Catch:{ Exception -> 0x010b }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x010b }
        r0 = "type";	 Catch:{ Exception -> 0x010b }
        r1 = r14.a;	 Catch:{ Exception -> 0x010b }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x010b }
        r0 = "last_alias";	 Catch:{ Exception -> 0x010b }
        r1 = r14.d;	 Catch:{ Exception -> 0x010b }
        r1 = com.umeng.message.UTrack.a(r1);	 Catch:{ Exception -> 0x010b }
        r1 = com.umeng.message.MessageSharedPrefs.getInstance(r1);	 Catch:{ Exception -> 0x010b }
        r2 = r14.a;	 Catch:{ Exception -> 0x010b }
        r1 = r1.getLastAlias(r7, r2);	 Catch:{ Exception -> 0x010b }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x010b }
        r0 = "ts";	 Catch:{ Exception -> 0x010b }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x010b }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x010b }
        goto L_0x0121;	 Catch:{ Exception -> 0x010b }
    L_0x010b:
        r0 = move-exception;	 Catch:{ Exception -> 0x010b }
        r9 = r4;	 Catch:{ Exception -> 0x010b }
        goto L_0x0133;	 Catch:{ Exception -> 0x010b }
    L_0x010e:
        r3 = com.umeng.message.UTrack$SuccessState.d;	 Catch:{ Exception -> 0x010b }
        if (r2 != r3) goto L_0x0118;	 Catch:{ Exception -> 0x010b }
    L_0x0112:
        r1 = "fail";	 Catch:{ Exception -> 0x010b }
        r4.put(r1, r0);	 Catch:{ Exception -> 0x010b }
        goto L_0x0121;	 Catch:{ Exception -> 0x010b }
    L_0x0118:
        r0 = com.umeng.message.UTrack$SuccessState.a;	 Catch:{ Exception -> 0x010b }
        if (r2 != r0) goto L_0x0121;	 Catch:{ Exception -> 0x010b }
    L_0x011c:
        r0 = "success";	 Catch:{ Exception -> 0x010b }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x010b }
    L_0x0121:
        r8 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x010b }
        r9 = r14.b;	 Catch:{ Exception -> 0x010b }
        r10 = r14.a;	 Catch:{ Exception -> 0x010b }
        r12 = r14.c;	 Catch:{ Exception -> 0x010b }
        r13 = 1;	 Catch:{ Exception -> 0x010b }
        r11 = r4;	 Catch:{ Exception -> 0x010b }
        r8.addExclusiveAlias(r9, r10, r11, r12, r13);	 Catch:{ Exception -> 0x010b }
        return;
    L_0x0131:
        r0 = move-exception;
        r9 = r3;
    L_0x0133:
        r1 = r0.getMessage();
        if (r1 == 0) goto L_0x01af;
    L_0x0139:
        r1 = r0.getMessage();
        r2 = com.umeng.message.MsgConstant.HTTPS_ERROR;
        r1 = r1.contains(r2);
        if (r1 == 0) goto L_0x0176;
    L_0x0145:
        r6 = com.umeng.message.UTrack.b();	 Catch:{ Exception -> 0x0154 }
        r7 = r14.b;	 Catch:{ Exception -> 0x0154 }
        r8 = r14.a;	 Catch:{ Exception -> 0x0154 }
        r10 = r14.c;	 Catch:{ Exception -> 0x0154 }
        r11 = 0;	 Catch:{ Exception -> 0x0154 }
        r6.addExclusiveAlias(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0154 }
        goto L_0x0197;
    L_0x0154:
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
        r1.onMessage(r5, r2);
        goto L_0x0197;
    L_0x0176:
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
        r1.onMessage(r5, r2);
    L_0x0197:
        r1 = r14.d;
        r1 = com.umeng.message.UTrack.a(r1);
        r2 = com.umeng.message.MessageSharedPrefs.getInstance(r1);
        r3 = r14.b;
        r4 = r14.a;
        r5 = 1;
        r6 = 1;
        r7 = r0.getMessage();
        r2.addAlias(r3, r4, r5, r6, r7);
        return;
    L_0x01af:
        r0 = r14.c;
        r1 = new java.lang.StringBuilder;
        r2 = "alias:";
        r1.<init>(r2);
        r2 = r14.b;
        r1.append(r2);
        r2 = "添加失败";
        r1.append(r2);
        r1 = r1.toString();
        r0.onMessage(r5, r1);
        r0 = r14.d;
        r0 = com.umeng.message.UTrack.a(r0);
        r1 = com.umeng.message.MessageSharedPrefs.getInstance(r0);
        r2 = r14.b;
        r3 = r14.a;
        r4 = 1;
        r5 = 1;
        r6 = "添加失败";
        r1.addAlias(r2, r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UTrack$3.run():void");
    }
}
