package com.igexin.push.core.a;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.push.config.l;
import com.igexin.push.core.g;
import com.igexin.push.f.a.e;
import org.json.JSONArray;

public class t extends b {
    private static final String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.a);
        stringBuilder.append("_RedirectServerAction");
        a = stringBuilder.toString();
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str2.equals(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|new location = ");
            stringBuilder.append(str);
            stringBuilder.append("; pre location = ");
            stringBuilder.append(str2);
            stringBuilder.append(", send snl retire broadcast");
            a.b(stringBuilder.toString());
            Intent intent = new Intent();
            intent.setAction("com.igexin.sdk.action.snlretire");
            intent.putExtra("groupid", str2);
            intent.putExtra("branch", "open");
            g.f.sendBroadcast(intent);
        }
    }

    private void a(String str, JSONArray jSONArray) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|start fetch idc config, url : ");
            stringBuilder.append(str);
            a.b(stringBuilder.toString());
            c.b().a(new e(new com.igexin.push.core.c.e(str, jSONArray)), false, true);
        } catch (Exception e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append(e.toString());
            a.b(stringBuilder2.toString());
        }
    }

    public static String[] a(JSONArray jSONArray) {
        String[] strArr;
        Exception e;
        try {
            strArr = new String[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    StringBuilder stringBuilder = new StringBuilder("http://");
                    stringBuilder.append(jSONArray.getString(i));
                    strArr[i] = stringBuilder.toString();
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            strArr = null;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|parseIDCConfigURL exception");
            stringBuilder2.append(e.toString());
            a.b(stringBuilder2.toString());
            return strArr;
        }
        return strArr;
    }

    public boolean a(java.lang.Object r20, org.json.JSONObject r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r1 = r19;
        r2 = r21;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = a;
        r3.append(r4);
        r4 = "|redirect server resp data : ";
        r3.append(r4);
        r3.append(r2);
        r3 = r3.toString();
        com.igexin.b.a.c.a.b(r3);
        r4 = "action";	 Catch:{ Exception -> 0x01ac }
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x01ac }
        if (r4 == 0) goto L_0x01c6;	 Catch:{ Exception -> 0x01ac }
    L_0x0025:
        r4 = "action";	 Catch:{ Exception -> 0x01ac }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x01ac }
        r5 = "redirect_server";	 Catch:{ Exception -> 0x01ac }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x01ac }
        if (r4 == 0) goto L_0x01c6;	 Catch:{ Exception -> 0x01ac }
    L_0x0033:
        r4 = "delay";	 Catch:{ Exception -> 0x01ac }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x01ac }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x01ac }
        r5.<init>();	 Catch:{ Exception -> 0x01ac }
        r6 = "address_list";	 Catch:{ Exception -> 0x01ac }
        r6 = r2.getJSONArray(r6);	 Catch:{ Exception -> 0x01ac }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ac }
        r8 = "redirect|";	 Catch:{ Exception -> 0x01ac }
        r7.<init>(r8);	 Catch:{ Exception -> 0x01ac }
        r7.append(r4);	 Catch:{ Exception -> 0x01ac }
        r8 = "|";	 Catch:{ Exception -> 0x01ac }
        r7.append(r8);	 Catch:{ Exception -> 0x01ac }
        r8 = r6.toString();	 Catch:{ Exception -> 0x01ac }
        r7.append(r8);	 Catch:{ Exception -> 0x01ac }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01ac }
        com.igexin.b.a.c.a.b(r7);	 Catch:{ Exception -> 0x01ac }
        r7 = 0;	 Catch:{ Exception -> 0x01ac }
        r8 = r7;	 Catch:{ Exception -> 0x01ac }
    L_0x0063:
        r9 = r6.length();	 Catch:{ Exception -> 0x01ac }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x01ac }
        if (r8 >= r9) goto L_0x00aa;	 Catch:{ Exception -> 0x01ac }
    L_0x006b:
        r9 = r6.getString(r8);	 Catch:{ Exception -> 0x01ac }
        r12 = 44;	 Catch:{ Exception -> 0x01ac }
        r12 = r9.indexOf(r12);	 Catch:{ Exception -> 0x01ac }
        if (r12 <= 0) goto L_0x00a7;	 Catch:{ Exception -> 0x01ac }
    L_0x0077:
        r13 = r9.substring(r7, r12);	 Catch:{ Exception -> 0x01ac }
        r12 = r12 + 1;	 Catch:{ Exception -> 0x01ac }
        r9 = r9.substring(r12);	 Catch:{ Exception -> 0x01ac }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01ac }
        r16 = java.lang.Long.parseLong(r9);	 Catch:{ NumberFormatException -> 0x00a7 }
        r9 = new com.igexin.push.c.e;	 Catch:{ NumberFormatException -> 0x00a7 }
        r9.<init>();	 Catch:{ NumberFormatException -> 0x00a7 }
        r12 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x00a7 }
        r3 = "socket://";	 Catch:{ NumberFormatException -> 0x00a7 }
        r12.<init>(r3);	 Catch:{ NumberFormatException -> 0x00a7 }
        r12.append(r13);	 Catch:{ NumberFormatException -> 0x00a7 }
        r3 = r12.toString();	 Catch:{ NumberFormatException -> 0x00a7 }
        r9.a = r3;	 Catch:{ NumberFormatException -> 0x00a7 }
        r16 = r16 * r10;	 Catch:{ NumberFormatException -> 0x00a7 }
        r10 = r14 + r16;	 Catch:{ NumberFormatException -> 0x00a7 }
        r9.b = r10;	 Catch:{ NumberFormatException -> 0x00a7 }
        r5.add(r9);	 Catch:{ NumberFormatException -> 0x00a7 }
    L_0x00a7:
        r8 = r8 + 1;
        goto L_0x0063;
    L_0x00aa:
        r8 = 0;
        r3 = java.lang.Long.parseLong(r4);	 Catch:{ Exception -> 0x00b2 }
        r3 = r3 * r10;
        goto L_0x00b3;
    L_0x00b2:
        r3 = r8;
    L_0x00b3:
        r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r6 < 0) goto L_0x00b9;
    L_0x00b7:
        com.igexin.push.core.g.E = r3;	 Catch:{ Exception -> 0x01ac }
    L_0x00b9:
        r3 = "loc";	 Catch:{ Exception -> 0x01ac }
        r3 = r2.has(r3);	 Catch:{ Exception -> 0x01ac }
        if (r3 == 0) goto L_0x0179;	 Catch:{ Exception -> 0x01ac }
    L_0x00c1:
        r3 = "conf";	 Catch:{ Exception -> 0x01ac }
        r3 = r2.has(r3);	 Catch:{ Exception -> 0x01ac }
        if (r3 == 0) goto L_0x0179;
    L_0x00c9:
        r3 = "loc";	 Catch:{ Exception -> 0x015f }
        r3 = r2.getString(r3);	 Catch:{ Exception -> 0x015f }
        r4 = com.igexin.push.core.g.d;	 Catch:{ Exception -> 0x015f }
        com.igexin.push.config.SDKUrlConfig.setLocation(r3);	 Catch:{ Exception -> 0x015f }
        r6 = com.igexin.push.config.m.n;	 Catch:{ Exception -> 0x015f }
        if (r6 == 0) goto L_0x00db;	 Catch:{ Exception -> 0x015f }
    L_0x00d8:
        r1.a(r3, r4);	 Catch:{ Exception -> 0x015f }
    L_0x00db:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x015f }
        r3.<init>();	 Catch:{ Exception -> 0x015f }
        r4 = a;	 Catch:{ Exception -> 0x015f }
        r3.append(r4);	 Catch:{ Exception -> 0x015f }
        r4 = " set group id : ";	 Catch:{ Exception -> 0x015f }
        r3.append(r4);	 Catch:{ Exception -> 0x015f }
        r4 = com.igexin.push.core.g.d;	 Catch:{ Exception -> 0x015f }
        r3.append(r4);	 Catch:{ Exception -> 0x015f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x015f }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Exception -> 0x015f }
        r3 = "conf";	 Catch:{ Exception -> 0x015f }
        r2 = r2.getJSONArray(r3);	 Catch:{ Exception -> 0x015f }
        r3 = a(r2);	 Catch:{ Exception -> 0x015f }
        if (r3 == 0) goto L_0x0179;	 Catch:{ Exception -> 0x015f }
    L_0x0102:
        r4 = r3.length;	 Catch:{ Exception -> 0x015f }
        if (r4 <= 0) goto L_0x0179;	 Catch:{ Exception -> 0x015f }
    L_0x0105:
        r4 = com.igexin.push.config.SDKUrlConfig.getIdcConfigUrl();	 Catch:{ Exception -> 0x015f }
        if (r4 == 0) goto L_0x012d;	 Catch:{ Exception -> 0x015f }
    L_0x010b:
        r6 = r3[r7];	 Catch:{ Exception -> 0x015f }
        r4 = r4[r7];	 Catch:{ Exception -> 0x015f }
        r4 = r6.equals(r4);	 Catch:{ Exception -> 0x015f }
        if (r4 != 0) goto L_0x0116;	 Catch:{ Exception -> 0x015f }
    L_0x0115:
        goto L_0x012d;	 Catch:{ Exception -> 0x015f }
    L_0x0116:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x015f }
        r2.<init>();	 Catch:{ Exception -> 0x015f }
        r3 = a;	 Catch:{ Exception -> 0x015f }
        r2.append(r3);	 Catch:{ Exception -> 0x015f }
        r3 = "|current idc config url == new idc config url, return";	 Catch:{ Exception -> 0x015f }
        r2.append(r3);	 Catch:{ Exception -> 0x015f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x015f }
    L_0x0129:
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x015f }
        goto L_0x0179;	 Catch:{ Exception -> 0x015f }
    L_0x012d:
        r10 = com.igexin.push.core.g.aw;	 Catch:{ Exception -> 0x015f }
        r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x015f }
        if (r4 != 0) goto L_0x0139;	 Catch:{ Exception -> 0x015f }
    L_0x0133:
        r3 = r3[r7];	 Catch:{ Exception -> 0x015f }
    L_0x0135:
        r1.a(r3, r2);	 Catch:{ Exception -> 0x015f }
        goto L_0x0179;	 Catch:{ Exception -> 0x015f }
    L_0x0139:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x015f }
        r10 = com.igexin.push.core.g.aw;	 Catch:{ Exception -> 0x015f }
        r12 = r8 - r10;	 Catch:{ Exception -> 0x015f }
        r8 = 7200000; // 0x6ddd00 float:1.0089349E-38 double:3.5572727E-317;	 Catch:{ Exception -> 0x015f }
        r4 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));	 Catch:{ Exception -> 0x015f }
        if (r4 <= 0) goto L_0x014b;	 Catch:{ Exception -> 0x015f }
    L_0x0148:
        r3 = r3[r7];	 Catch:{ Exception -> 0x015f }
        goto L_0x0135;	 Catch:{ Exception -> 0x015f }
    L_0x014b:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x015f }
        r2.<init>();	 Catch:{ Exception -> 0x015f }
        r3 = a;	 Catch:{ Exception -> 0x015f }
        r2.append(r3);	 Catch:{ Exception -> 0x015f }
        r3 = "|get idc cfg last time less than 2 hours return";	 Catch:{ Exception -> 0x015f }
        r2.append(r3);	 Catch:{ Exception -> 0x015f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x015f }
        goto L_0x0129;
    L_0x015f:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ac }
        r3.<init>();	 Catch:{ Exception -> 0x01ac }
        r4 = a;	 Catch:{ Exception -> 0x01ac }
        r3.append(r4);	 Catch:{ Exception -> 0x01ac }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01ac }
        r3.append(r2);	 Catch:{ Exception -> 0x01ac }
        r2 = r3.toString();	 Catch:{ Exception -> 0x01ac }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x01ac }
    L_0x0179:
        r2 = com.igexin.push.c.i.a();	 Catch:{ Exception -> 0x01ac }
        r2 = r2.e();	 Catch:{ Exception -> 0x01ac }
        r2.a(r5);	 Catch:{ Exception -> 0x01ac }
        r2 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x01ac }
        r3 = 1;	 Catch:{ Exception -> 0x01ac }
        r2.c(r3);	 Catch:{ Exception -> 0x01ac }
        r2 = com.igexin.push.util.EncryptUtils.isLoadSuccess();	 Catch:{ Exception -> 0x01ac }
        if (r2 == 0) goto L_0x01c6;	 Catch:{ Exception -> 0x01ac }
    L_0x0192:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ac }
        r2.<init>();	 Catch:{ Exception -> 0x01ac }
        r3 = a;	 Catch:{ Exception -> 0x01ac }
        r2.append(r3);	 Catch:{ Exception -> 0x01ac }
        r3 = "|redirect reInit so ~~~~~";	 Catch:{ Exception -> 0x01ac }
        r2.append(r3);	 Catch:{ Exception -> 0x01ac }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01ac }
        com.igexin.b.a.c.a.b(r2);	 Catch:{ Exception -> 0x01ac }
        com.igexin.push.util.EncryptUtils.reset();	 Catch:{ Exception -> 0x01ac }
        goto L_0x01c6;
    L_0x01ac:
        r0 = move-exception;
        r2 = r0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = a;
        r3.append(r4);
        r2 = r2.toString();
        r3.append(r2);
        r2 = r3.toString();
        com.igexin.b.a.c.a.b(r2);
    L_0x01c6:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.t.a(java.lang.Object, org.json.JSONObject):boolean");
    }
}
