package com.hianalytics.android.v1;

import android.content.Context;
import com.baidu.android.common.security.RSAUtil;
import com.hianalytics.android.b.a.a;
import com.hianalytics.android.b.a.b;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import org.json.JSONObject;

public final class c implements Runnable {
    boolean a;
    private Context b;
    private JSONObject c;

    public c(Context context, JSONObject jSONObject, boolean z) {
        this.b = context;
        this.c = jSONObject;
        this.a = z;
    }

    private String a(byte[] bArr) {
        String format = String.format("%016d", new Object[]{Long.valueOf(Math.abs(new SecureRandom().nextLong() % 10000000000000000L))});
        try {
            bArr = b.a(format, bArr);
            byte[] bytes = format.getBytes("UTF-8");
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new RSAPublicKeySpec(new BigInteger("24907259431961377209480304447420314675278854956424737688244507998454379688588314890162679979323703303509240796245532111474023047392580178709435281576624542294613207523485034492914828565153172773053351891188090398210811384185501117117991603774176386409127476628856566065613009756131651597266262540467980974946876675842468600552312158771248419700603327630677244315755445967726919102965015263135288381740211593751262078285738436597133664401598420056690274760726854877181978220226448211936820860496708860964018593025172845041095854180953040116559241637133730839837036910305932797451786785855051024967644159284784940216337"), new BigInteger("65537")));
            if (rSAPublicKey == null) {
                throw new UnsupportedEncodingException();
            }
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            instance.init(1, rSAPublicKey);
            bytes = instance.doFinal(bytes);
            String e = a.e(this.b);
            StringBuilder stringBuilder = new StringBuilder("{\"vs\":\"");
            stringBuilder.append(e);
            stringBuilder.append("\",\"ed\":\"");
            stringBuilder.append(a.b(bArr));
            stringBuilder.append("\",\"ek\":\"");
            stringBuilder.append(a.b(bytes));
            stringBuilder.append("\"}");
            return stringBuilder.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(JSONObject jSONObject, String str) {
        UnsupportedEncodingException e;
        StringBuilder stringBuilder;
        String toLowerCase = str.toLowerCase();
        try {
            byte[] a = a.a(jSONObject.toString().getBytes("UTF-8"));
            if (a == null) {
                return false;
            }
            String a2 = a(a);
            if (a2 == null) {
                return false;
            }
            try {
                a = a2.getBytes("UTF-8");
                if (toLowerCase.indexOf("https") >= 0) {
                    return false;
                }
                a.h();
                return b.a(str, a);
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                stringBuilder = new StringBuilder("UnsupportedEncodingException:");
                stringBuilder.append(e.getMessage());
                a.h();
                return false;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            stringBuilder = new StringBuilder("UnsupportedEncodingException:");
            stringBuilder.append(e.getMessage());
            a.h();
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r21 = this;
        r1 = r21;
        r2 = r1.c;	 Catch:{ Exception -> 0x017c }
        r3 = "type";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x017c }
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r2 = r1.b;	 Catch:{ Exception -> 0x017c }
        r3 = r1.c;	 Catch:{ Exception -> 0x017c }
        r4 = r1.a;	 Catch:{ Exception -> 0x017c }
        r5 = com.hianalytics.android.a.a.a.a(r2);	 Catch:{ Exception -> 0x017c }
        if (r5 != 0) goto L_0x001d;
    L_0x0019:
        com.hianalytics.android.b.a.a.h();	 Catch:{ Exception -> 0x017c }
        return;
    L_0x001d:
        r6 = "cached";
        r6 = com.hianalytics.android.b.a.c.b(r2, r6);	 Catch:{ Exception -> 0x017c }
        r7 = new org.json.JSONObject;	 Catch:{ Exception -> 0x017c }
        r7.<init>();	 Catch:{ Exception -> 0x017c }
        r8 = "type";
        r8 = r3.getString(r8);	 Catch:{ JSONException -> 0x0171 }
        if (r8 != 0) goto L_0x0031;
    L_0x0030:
        return;
    L_0x0031:
        r9 = "type";
        r3.remove(r9);	 Catch:{ JSONException -> 0x0171 }
        r9 = 0;
        r10 = 1;
        if (r6 == 0) goto L_0x004f;
    L_0x003a:
        r11 = r6.isNull(r8);	 Catch:{ JSONException -> 0x0171 }
        if (r11 == 0) goto L_0x0048;
    L_0x0040:
        r11 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0171 }
        r11.<init>();	 Catch:{ JSONException -> 0x0171 }
    L_0x0045:
        r12 = r6;
        r6 = r10;
        goto L_0x005a;
    L_0x0048:
        r11 = r6.getJSONArray(r8);	 Catch:{ JSONException -> 0x0171 }
        r12 = r6;
        r6 = r9;
        goto L_0x005a;
    L_0x004f:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0171 }
        r6.<init>();	 Catch:{ JSONException -> 0x0171 }
        r11 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0171 }
        r11.<init>();	 Catch:{ JSONException -> 0x0171 }
        goto L_0x0045;
    L_0x005a:
        if (r4 == 0) goto L_0x0062;
    L_0x005c:
        if (r6 == 0) goto L_0x0062;
    L_0x005e:
        com.hianalytics.android.b.a.a.h();	 Catch:{ JSONException -> 0x0171 }
        return;
    L_0x0062:
        if (r4 != 0) goto L_0x0067;
    L_0x0064:
        r11.put(r3);	 Catch:{ JSONException -> 0x0171 }
    L_0x0067:
        r3 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0171 }
        r3.<init>();	 Catch:{ JSONException -> 0x0171 }
        r4 = r11.length();	 Catch:{ JSONException -> 0x0171 }
    L_0x0070:
        r6 = r4 + -1;
        if (r9 <= r6) goto L_0x00d5;
    L_0x0074:
        r4 = r3.length();	 Catch:{ JSONException -> 0x0171 }
        if (r4 > 0) goto L_0x007e;
    L_0x007a:
        com.hianalytics.android.b.a.a.h();	 Catch:{ JSONException -> 0x0171 }
        return;
    L_0x007e:
        r12.remove(r8);	 Catch:{ JSONException -> 0x0171 }
        r12.put(r8, r3);	 Catch:{ JSONException -> 0x0171 }
        r4 = "g";
        r7.put(r4, r5);	 Catch:{ JSONException -> 0x0171 }
        r4 = "s";
        r7.put(r4, r3);	 Catch:{ JSONException -> 0x0171 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
        r4 = "message=";
        r3.<init>(r4);	 Catch:{ Exception -> 0x017c }
        r4 = r7.toString();	 Catch:{ Exception -> 0x017c }
        r3.append(r4);	 Catch:{ Exception -> 0x017c }
        com.hianalytics.android.b.a.a.h();	 Catch:{ Exception -> 0x017c }
        r3 = com.hianalytics.android.b.a.a.i();	 Catch:{ Exception -> 0x017c }
        r3 = r1.a(r7, r3);	 Catch:{ Exception -> 0x017c }
        if (r3 == 0) goto L_0x00cc;
    L_0x00a9:
        r3 = "flag";
        r3 = com.hianalytics.android.b.a.c.a(r2, r3);	 Catch:{ Exception -> 0x017c }
        r4 = com.hianalytics.android.b.a.a.f(r2);	 Catch:{ Exception -> 0x017c }
        if (r4 == 0) goto L_0x00c3;
    L_0x00b5:
        r3 = r3.edit();	 Catch:{ Exception -> 0x017c }
        r4 = "rom_version";
        r5 = android.os.Build.DISPLAY;	 Catch:{ Exception -> 0x017c }
        r3.putString(r4, r5);	 Catch:{ Exception -> 0x017c }
        r3.commit();	 Catch:{ Exception -> 0x017c }
    L_0x00c3:
        r3 = "cached";
        com.hianalytics.android.b.a.c.c(r2, r3);	 Catch:{ Exception -> 0x017c }
        com.hianalytics.android.b.a.a.h();	 Catch:{ Exception -> 0x017c }
        return;
    L_0x00cc:
        r3 = "cached";
        com.hianalytics.android.b.a.c.a(r2, r12, r3);	 Catch:{ Exception -> 0x017c }
        com.hianalytics.android.b.a.a.h();	 Catch:{ Exception -> 0x017c }
        return;
    L_0x00d5:
        r6 = r11.getJSONObject(r9);	 Catch:{ JSONException -> 0x0171 }
        r13 = "b";
        r13 = r6.has(r13);	 Catch:{ JSONException -> 0x0171 }
        r15 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r13 == 0) goto L_0x012c;
    L_0x00e3:
        r13 = "b";
        r13 = r6.getJSONArray(r13);	 Catch:{ JSONException -> 0x0171 }
        if (r13 == 0) goto L_0x016d;
    L_0x00eb:
        r17 = r13.length();	 Catch:{ JSONException -> 0x0171 }
        if (r17 <= 0) goto L_0x016d;
    L_0x00f1:
        r17 = r13.length();	 Catch:{ JSONException -> 0x0171 }
        r14 = r17 + -1;
        r13 = r13.getString(r14);	 Catch:{ JSONException -> 0x0171 }
        r14 = ",";
        r13 = r13.split(r14);	 Catch:{ JSONException -> 0x0171 }
        r19 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0171 }
        r19 = r19 / r15;
        r14 = r13[r10];	 Catch:{ JSONException -> 0x0171 }
        r14 = com.hianalytics.android.b.a.a.a(r14);	 Catch:{ JSONException -> 0x0171 }
        r16 = r19 - r14;
        r14 = 2;
        r13 = r13[r14];	 Catch:{ JSONException -> 0x0171 }
        r13 = java.lang.Long.parseLong(r13);	 Catch:{ JSONException -> 0x0171 }
        r18 = r16 - r13;
        r13 = com.hianalytics.android.b.a.a.b();	 Catch:{ JSONException -> 0x0171 }
        r13 = r13.longValue();	 Catch:{ JSONException -> 0x0171 }
        r15 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1));
        if (r15 >= 0) goto L_0x0128;
    L_0x0124:
        r3.put(r6);	 Catch:{ JSONException -> 0x0171 }
        goto L_0x016d;
    L_0x0128:
        com.hianalytics.android.b.a.a.h();	 Catch:{ JSONException -> 0x0171 }
        goto L_0x016d;
    L_0x012c:
        r13 = "e";
        r13 = r6.has(r13);	 Catch:{ JSONException -> 0x0171 }
        if (r13 == 0) goto L_0x016d;
    L_0x0134:
        r13 = "e";
        r13 = r6.getJSONArray(r13);	 Catch:{ JSONException -> 0x0171 }
        if (r13 == 0) goto L_0x016d;
    L_0x013c:
        r14 = r13.length();	 Catch:{ JSONException -> 0x0171 }
        if (r14 <= 0) goto L_0x016d;
    L_0x0142:
        r14 = r13.length();	 Catch:{ JSONException -> 0x0171 }
        r14 = r14 - r10;
        r13 = r13.getString(r14);	 Catch:{ JSONException -> 0x0171 }
        r14 = ",";
        r13 = r13.split(r14);	 Catch:{ JSONException -> 0x0171 }
        r19 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0171 }
        r19 = r19 / r15;
        r14 = 2;
        r13 = r13[r14];	 Catch:{ JSONException -> 0x0171 }
        r13 = com.hianalytics.android.b.a.a.a(r13);	 Catch:{ JSONException -> 0x0171 }
        r15 = r19 - r13;
        r13 = com.hianalytics.android.b.a.a.b();	 Catch:{ JSONException -> 0x0171 }
        r13 = r13.longValue();	 Catch:{ JSONException -> 0x0171 }
        r17 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1));
        if (r17 >= 0) goto L_0x0128;
    L_0x016c:
        goto L_0x0124;
    L_0x016d:
        r9 = r9 + 1;
        goto L_0x0070;
    L_0x0171:
        r0 = move-exception;
        r3 = r0;
        r3.printStackTrace();	 Catch:{ Exception -> 0x017c }
        r3 = "cached";
        com.hianalytics.android.b.a.c.c(r2, r3);	 Catch:{ Exception -> 0x017c }
        return;
    L_0x017c:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();
        r2 = r1.b;
        r3 = "cached";
        com.hianalytics.android.b.a.c.c(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.v1.c.run():void");
    }
}
