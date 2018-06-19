package mtopsdk.mtop.common;

public final class l {
    public static mtopsdk.mtop.domain.MtopResponse a(mtopsdk.mtop.domain.MtopResponse r8, mtopsdk.mtop.a r9, mtopsdk.mtop.common.m r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r8 != 0) goto L_0x0007;
    L_0x0002:
        r8 = new mtopsdk.mtop.domain.MtopResponse;
        r8.<init>();
    L_0x0007:
        r0 = 0;
        if (r9 == 0) goto L_0x0020;
    L_0x000a:
        r0 = r9.g;
        r0 = r0.getApiName();
        r8.setApi(r0);
        r0 = r9.g;
        r0 = r0.getVersion();
        r8.setV(r0);
        r0 = r9.k;
        r0 = r0.q;
    L_0x0020:
        r1 = r10.a;
        r2 = r10.b;
        r8.setResponseCode(r1);
        r8.setHeaderFields(r2);
        r10 = r10.c;
        if (r10 == 0) goto L_0x003a;
    L_0x002e:
        r10 = r10.c();	 Catch:{ IOException -> 0x0036 }
        r8.setBytedata(r10);	 Catch:{ IOException -> 0x0036 }
        goto L_0x003a;
    L_0x0036:
        r10 = move-exception;
        r10.printStackTrace();
    L_0x003a:
        if (r1 >= 0) goto L_0x009e;
    L_0x003c:
        r9 = -200; // 0xffffffffffffff38 float:NaN double:NaN;
        if (r9 != r1) goto L_0x004b;
    L_0x0040:
        r9 = "ANDROID_SYS_NO_NETWORK";
        r8.setRetCode(r9);
        r9 = "无网络";
    L_0x0047:
        r8.setRetMsg(r9);
        goto L_0x0053;
    L_0x004b:
        r9 = "ANDROID_SYS_NETWORK_ERROR";
        r8.setRetCode(r9);
        r9 = "网络错误";
        goto L_0x0047;
    L_0x0053:
        r9 = mtopsdk.common.util.TBSdkLog$LogEnable.ErrorEnable;
        r9 = mtopsdk.common.util.j.a(r9);
        if (r9 == 0) goto L_0x009d;
    L_0x005b:
        r9 = new java.lang.StringBuilder;
        r10 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r9.<init>(r10);
        r10 = "[parseNetworkRlt] api=";
        r9.append(r10);
        r10 = r8.getApi();
        r9.append(r10);
        r10 = ",v=";
        r9.append(r10);
        r10 = r8.getV();
        r9.append(r10);
        r10 = ",retCode =";
        r9.append(r10);
        r10 = r8.getRetCode();
        r9.append(r10);
        r10 = ",responseCode =";
        r9.append(r10);
        r9.append(r1);
        r10 = ",responseHeader=";
        r9.append(r10);
        r9.append(r2);
        r9 = r9.toString();
        mtopsdk.common.util.j.e(r0, r9);
    L_0x009d:
        return r8;
    L_0x009e:
        mtopsdk.mtop.a.g.a();
        r10 = mtopsdk.mtop.a.g.e();
        r1 = 1;
        r3 = 0;
        if (r10 != 0) goto L_0x00b0;
    L_0x00a9:
        r10 = "[parseUnitSettingHeader]unitSwitchOpen is false";
        mtopsdk.common.util.j.b(r0, r10);
        goto L_0x017e;
    L_0x00b0:
        if (r2 == 0) goto L_0x017e;
    L_0x00b2:
        r10 = r2.isEmpty();
        if (r10 == 0) goto L_0x00ba;
    L_0x00b8:
        goto L_0x017e;
    L_0x00ba:
        r10 = "x-m-update-unitinfo";
        r10 = com.taobao.tao.remotebusiness.listener.c.a(r2, r10);
        r4 = mtopsdk.common.util.i.a(r10);
        if (r4 == 0) goto L_0x0104;
    L_0x00c6:
        r10 = mtopsdk.mtop.unit.a.a(r10, r0);
        if (r10 != 0) goto L_0x00de;
    L_0x00cc:
        r4 = new java.lang.StringBuilder;
        r5 = "[updateAndStoreUserUnitInfo]  invalid userUnit,userUnit=";
        r4.<init>(r5);
        r4.append(r10);
        r10 = r4.toString();
        mtopsdk.common.util.j.c(r0, r10);
        goto L_0x0104;
    L_0x00de:
        r4 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r4 = mtopsdk.common.util.j.a(r4);
        if (r4 == 0) goto L_0x0104;
    L_0x00e6:
        r4 = "[updateAndStoreUserUnitInfo] update userUnitinfo succeed.userid=%s ;utdid=%s ;unitPrefix=%s";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = r10.userId;
        r5[r3] = r6;
        mtopsdk.mtop.a.d.a();
        r6 = mtopsdk.mtop.a.d.f();
        r5[r1] = r6;
        r6 = 2;
        r10 = r10.unitPrefix;
        r5[r6] = r10;
        r10 = java.lang.String.format(r4, r5);
        mtopsdk.common.util.j.b(r0, r10);
    L_0x0104:
        r10 = "x-m-update-unitapi";
        r10 = com.taobao.tao.remotebusiness.listener.c.a(r2, r10);
        r2 = mtopsdk.common.util.i.a(r10);
        if (r2 == 0) goto L_0x017e;
    L_0x0110:
        r10 = mtopsdk.mtop.unit.a.b(r10, r0);
        r2 = "v=";
        r2 = r10.get(r2);
        r2 = (java.lang.String) r2;
        r4 = "url=";
        r10 = r10.get(r4);
        r10 = (java.lang.String) r10;
        r4 = mtopsdk.common.util.i.b(r2);
        if (r4 != 0) goto L_0x0165;
    L_0x012a:
        r4 = mtopsdk.common.util.i.b(r10);
        if (r4 == 0) goto L_0x0131;
    L_0x0130:
        goto L_0x0165;
    L_0x0131:
        mtopsdk.mtop.a.d.a();
        r4 = mtopsdk.mtop.a.d.j();
        if (r4 == 0) goto L_0x015c;
    L_0x013a:
        r4 = r4.version;
        r4 = r2.equals(r4);
        if (r4 == 0) goto L_0x015c;
    L_0x0142:
        r10 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;
        r10 = mtopsdk.common.util.j.a(r10);
        if (r10 == 0) goto L_0x017e;
    L_0x014a:
        r10 = new java.lang.StringBuilder;
        r4 = "[updateAndStoreApiUnitInfo] current apiUnit version is up-to-date,version=";
        r10.<init>(r4);
        r10.append(r2);
        r10 = r10.toString();
        mtopsdk.common.util.j.a(r0, r10);
        goto L_0x017e;
    L_0x015c:
        r2 = new mtopsdk.mtop.unit.b;
        r2.<init>(r10, r0);
        mtopsdk.mtop.util.e.a(r2);
        goto L_0x017e;
    L_0x0165:
        r4 = new java.lang.StringBuilder;
        r5 = "[updateAndStoreApiUnitInfo] invalid apiUnitInfo,version=";
        r4.<init>(r5);
        r4.append(r2);
        r2 = ",url=";
        r4.append(r2);
        r4.append(r10);
        r10 = r4.toString();
        mtopsdk.common.util.j.c(r0, r10);
    L_0x017e:
        r10 = new mtopsdk.mtop.util.Result;
        r10.<init>(r8);
        r0 = r8.getResponseCode();
        r2 = 420; // 0x1a4 float:5.89E-43 double:2.075E-321;
        if (r0 == r2) goto L_0x01a4;
    L_0x018b:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r0 == r2) goto L_0x01a4;
    L_0x018f:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r0 != r2) goto L_0x0194;
    L_0x0193:
        goto L_0x01a4;
    L_0x0194:
        r2 = 419; // 0x1a3 float:5.87E-43 double:2.07E-321;
        if (r0 != r2) goto L_0x01a0;
    L_0x0198:
        r0 = "ANDROID_SYS_API_41X_ANTI_ATTACK";
        r8.setRetCode(r0);
        r0 = "哎哟喂,被挤爆啦,请稍后重试!";
        goto L_0x01ba;
    L_0x01a0:
        r10.setSuccess(r3);
        goto L_0x01bd;
    L_0x01a4:
        if (r9 == 0) goto L_0x01b3;
    L_0x01a6:
        r0 = r9.g;
        r0 = r0.getKey();
        r4 = mtopsdk.mtop.a.e.a();
        mtopsdk.mtop.antiattack.c.b(r0, r4);
    L_0x01b3:
        r0 = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
        r8.setRetCode(r0);
        r0 = "哎哟喂,被挤爆啦,请稍后重试";
    L_0x01ba:
        r8.setRetMsg(r0);
    L_0x01bd:
        r0 = r10.isSuccess();
        if (r0 == 0) goto L_0x01ca;
    L_0x01c3:
        r8 = r10.getModel();
        r8 = (mtopsdk.mtop.domain.MtopResponse) r8;
        return r8;
    L_0x01ca:
        r10 = new mtopsdk.mtop.util.Result;
        r10.<init>(r8);
        r8.getResponseCode();
        r10.setSuccess(r3);
        r0 = r10.isSuccess();
        if (r0 == 0) goto L_0x01e2;
    L_0x01db:
        r8 = r10.getModel();
        r8 = (mtopsdk.mtop.domain.MtopResponse) r8;
        return r8;
    L_0x01e2:
        r10 = r8.getBytedata();
        if (r10 != 0) goto L_0x01f3;
    L_0x01e8:
        r9 = "ANDROID_SYS_JSONDATA_BLANK";
        r8.setRetCode(r9);
        r9 = "返回JSONDATA为空";
        r8.setRetMsg(r9);
        return r8;
    L_0x01f3:
        if (r8 == 0) goto L_0x0213;
    L_0x01f5:
        r10 = r8.getHeaderFields();
        if (r10 != 0) goto L_0x01fc;
    L_0x01fb:
        goto L_0x0213;
    L_0x01fc:
        r10 = r8.getHeaderFields();
        r0 = "x-retcode";
        r10 = com.taobao.tao.remotebusiness.listener.c.a(r10, r0);
        r0 = mtopsdk.common.util.i.a(r10);
        if (r0 == 0) goto L_0x0210;
    L_0x020c:
        r8.setRetCode(r10);
        goto L_0x0213;
    L_0x0210:
        r8.parseJsonByte();
    L_0x0213:
        r10 = r8.isExpiredRequest();
        if (r10 == 0) goto L_0x025e;
    L_0x0219:
        if (r9 == 0) goto L_0x025e;
    L_0x021b:
        r10 = r9.h;
        r10 = r10.correctTimeStamp;
        if (r10 != 0) goto L_0x025e;
    L_0x0221:
        if (r8 == 0) goto L_0x0256;
    L_0x0223:
        r10 = r8.getHeaderFields();
        if (r10 != 0) goto L_0x022a;
    L_0x0229:
        goto L_0x0256;
    L_0x022a:
        r8 = r8.getHeaderFields();	 Catch:{ Exception -> 0x0251 }
        r10 = "x-systime";	 Catch:{ Exception -> 0x0251 }
        r8 = com.taobao.tao.remotebusiness.listener.c.a(r8, r10);	 Catch:{ Exception -> 0x0251 }
        r10 = mtopsdk.common.util.i.a(r8);	 Catch:{ Exception -> 0x0251 }
        if (r10 == 0) goto L_0x0256;	 Catch:{ Exception -> 0x0251 }
    L_0x023a:
        r2 = java.lang.Long.parseLong(r8);	 Catch:{ Exception -> 0x0251 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0251 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0251 }
        r4 = r4 / r6;	 Catch:{ Exception -> 0x0251 }
        r6 = r2 - r4;	 Catch:{ Exception -> 0x0251 }
        r8 = "t_offset";	 Catch:{ Exception -> 0x0251 }
        r10 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0251 }
        mtopsdk.xstate.a.a(r8, r10);	 Catch:{ Exception -> 0x0251 }
        goto L_0x0256;
    L_0x0251:
        r8 = "[computeTimeOffset]parse systime from mtop response data error";
        mtopsdk.common.util.j.f(r8);
    L_0x0256:
        r8 = r9.h;
        r8.correctTimeStamp = r1;
        r8 = r9.a();
    L_0x025e:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.common.l.a(mtopsdk.mtop.domain.MtopResponse, mtopsdk.mtop.a, mtopsdk.mtop.common.m):mtopsdk.mtop.domain.MtopResponse");
    }
}
