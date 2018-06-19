package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AgGetParser */
public class j {
    private static final String a = "j";

    /* compiled from: AgGetParser */
    public static class a {
        public byte a;
        public l b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public final STYLES_INFO h;
        public e i;

        public a(byte b, String str, l lVar, String str2, String str3, String str4, STYLES_INFO styles_info, String str5) {
            this.a = b;
            this.g = str;
            this.b = lVar;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.h = styles_info;
            this.f = str5;
        }
    }

    public static com.xunlei.downloadprovider.ad.common.adget.j.a a(com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO r26, org.json.JSONObject r27) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r26;
        r2 = r27;
        r12 = "";
        r13 = -20;
        r14 = 0;
        r15 = 0;
        if (r2 == 0) goto L_0x038b;
    L_0x000c:
        r3 = "bid";
        r3 = r2.optJSONArray(r3);
        r4 = 6;
        if (r3 == 0) goto L_0x0366;
    L_0x0015:
        r5 = r3.length();
        if (r5 == 0) goto L_0x0366;
    L_0x001b:
        r3 = r3.getJSONObject(r14);	 Catch:{ JSONException -> 0x0359 }
        if (r3 == 0) goto L_0x0353;	 Catch:{ JSONException -> 0x0359 }
    L_0x0021:
        r5 = "source";	 Catch:{ JSONException -> 0x0359 }
        r5 = r3.optString(r5);	 Catch:{ JSONException -> 0x0359 }
        r6 = "impid";	 Catch:{ JSONException -> 0x034e }
        r6 = r3.optString(r6);	 Catch:{ JSONException -> 0x034e }
        r7 = "styleid";	 Catch:{ JSONException -> 0x034a }
        r7 = r3.optString(r7);	 Catch:{ JSONException -> 0x034a }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ JSONException -> 0x0343 }
        r9 = 1;
        if (r8 != 0) goto L_0x004a;
    L_0x003a:
        r8 = r1.containStyleInfo(r7);	 Catch:{ JSONException -> 0x0042 }
        if (r8 != 0) goto L_0x004a;
    L_0x0040:
        r8 = r9;
        goto L_0x004b;
    L_0x0042:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r10 = r7;
    L_0x0046:
        r4 = r15;
        r9 = r4;
        goto L_0x0360;
    L_0x004a:
        r8 = r14;
    L_0x004b:
        r10 = "alliance";	 Catch:{ JSONException -> 0x033c }
        r10 = r3.optString(r10);	 Catch:{ JSONException -> 0x033c }
        r11 = "default_ad";	 Catch:{ JSONException -> 0x033c }
        r11 = r3.optBoolean(r11);	 Catch:{ JSONException -> 0x033c }
        r12 = "sdk";	 Catch:{ JSONException -> 0x033c }
        r12 = r5.equals(r12);	 Catch:{ JSONException -> 0x033c }
        if (r12 == 0) goto L_0x011d;	 Catch:{ JSONException -> 0x033c }
    L_0x005f:
        if (r10 == 0) goto L_0x011d;	 Catch:{ JSONException -> 0x033c }
    L_0x0061:
        r12 = ":";	 Catch:{ JSONException -> 0x033c }
        r10 = r10.split(r12);	 Catch:{ JSONException -> 0x033c }
        r12 = r10.length;	 Catch:{ JSONException -> 0x033c }
        if (r12 == 0) goto L_0x006d;	 Catch:{ JSONException -> 0x033c }
    L_0x006a:
        r12 = r10[r14];	 Catch:{ JSONException -> 0x033c }
        goto L_0x006f;	 Catch:{ JSONException -> 0x033c }
    L_0x006d:
        r12 = "100";	 Catch:{ JSONException -> 0x033c }
    L_0x006f:
        r14 = r12.length();	 Catch:{ JSONException -> 0x033c }
        if (r14 <= r9) goto L_0x0078;	 Catch:{ JSONException -> 0x033c }
    L_0x0075:
        r10 = r10[r9];	 Catch:{ JSONException -> 0x033c }
        goto L_0x0079;
    L_0x0078:
        r10 = r7;
    L_0x0079:
        r14 = android.text.TextUtils.isEmpty(r10);	 Catch:{ JSONException -> 0x0118 }
        if (r14 != 0) goto L_0x0087;	 Catch:{ JSONException -> 0x0118 }
    L_0x007f:
        r14 = r1.containStyleInfo(r10);	 Catch:{ JSONException -> 0x0118 }
        if (r14 != 0) goto L_0x0087;	 Catch:{ JSONException -> 0x0118 }
    L_0x0085:
        r8 = r9;	 Catch:{ JSONException -> 0x0118 }
        goto L_0x0088;	 Catch:{ JSONException -> 0x0118 }
    L_0x0087:
        r8 = 0;	 Catch:{ JSONException -> 0x0118 }
    L_0x0088:
        r14 = "101";	 Catch:{ JSONException -> 0x0118 }
        r14 = r12.equals(r14);	 Catch:{ JSONException -> 0x0118 }
        if (r14 == 0) goto L_0x009d;	 Catch:{ JSONException -> 0x0118 }
    L_0x0090:
        r4 = r1.getStyleInfo(r10);	 Catch:{ JSONException -> 0x0118 }
        r4 = r4.mLoadStrate;	 Catch:{ JSONException -> 0x0118 }
        r4 = r4 & r9;	 Catch:{ JSONException -> 0x0118 }
        r4 = (byte) r4;	 Catch:{ JSONException -> 0x0118 }
        r9 = "baidu";	 Catch:{ JSONException -> 0x0118 }
    L_0x009a:
        r17 = r4;	 Catch:{ JSONException -> 0x0118 }
        goto L_0x00b0;	 Catch:{ JSONException -> 0x0118 }
    L_0x009d:
        r9 = "100";	 Catch:{ JSONException -> 0x0118 }
        r9 = r12.equals(r9);	 Catch:{ JSONException -> 0x0118 }
        if (r9 == 0) goto L_0x0117;	 Catch:{ JSONException -> 0x0118 }
    L_0x00a5:
        r9 = "tencent";	 Catch:{ JSONException -> 0x0118 }
        r5 = r1.getStyleInfo(r10);	 Catch:{ JSONException -> 0x0110 }
        r5 = r5.mLoadStrate;	 Catch:{ JSONException -> 0x0110 }
        r4 = r4 & r5;	 Catch:{ JSONException -> 0x0110 }
        r4 = (byte) r4;	 Catch:{ JSONException -> 0x0110 }
        goto L_0x009a;	 Catch:{ JSONException -> 0x0110 }
    L_0x00b0:
        if (r8 == 0) goto L_0x00e8;	 Catch:{ JSONException -> 0x0110 }
    L_0x00b2:
        r3 = new com.xunlei.downloadprovider.ad.common.adget.j$a;	 Catch:{ JSONException -> 0x0110 }
        r17 = 2;	 Catch:{ JSONException -> 0x0110 }
        r19 = 0;	 Catch:{ JSONException -> 0x0110 }
        r20 = 0;	 Catch:{ JSONException -> 0x0110 }
        r21 = 0;	 Catch:{ JSONException -> 0x0110 }
        r22 = 0;	 Catch:{ JSONException -> 0x0110 }
        r23 = r26.getDefStyle();	 Catch:{ JSONException -> 0x0110 }
        if (r2 == 0) goto L_0x00cd;	 Catch:{ JSONException -> 0x0110 }
    L_0x00c4:
        r4 = "id";	 Catch:{ JSONException -> 0x0110 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0110 }
        r24 = r4;	 Catch:{ JSONException -> 0x0110 }
        goto L_0x00cf;	 Catch:{ JSONException -> 0x0110 }
    L_0x00cd:
        r24 = r15;	 Catch:{ JSONException -> 0x0110 }
    L_0x00cf:
        r16 = r3;	 Catch:{ JSONException -> 0x0110 }
        r18 = r6;	 Catch:{ JSONException -> 0x0110 }
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24);	 Catch:{ JSONException -> 0x0110 }
        r4 = "single_request_style_id_error";	 Catch:{ JSONException -> 0x00df }
        r4 = com.xunlei.downloadprovider.ad.common.report.e.a(r13, r4);	 Catch:{ JSONException -> 0x00df }
        r3.i = r4;	 Catch:{ JSONException -> 0x00df }
        return r3;
    L_0x00df:
        r0 = move-exception;
        r4 = r3;
        r12 = r6;
        r14 = r8;
        r5 = r9;
        r9 = r15;
        r3 = r0;
        goto L_0x0360;
    L_0x00e8:
        r4 = new com.xunlei.downloadprovider.ad.common.adget.j$a;	 Catch:{ JSONException -> 0x0110 }
        r19 = 0;	 Catch:{ JSONException -> 0x0110 }
        r5 = "alliance_imp_url";	 Catch:{ JSONException -> 0x0110 }
        r20 = r3.optString(r5);	 Catch:{ JSONException -> 0x0110 }
        r5 = "alliance_click_url";	 Catch:{ JSONException -> 0x0110 }
        r21 = r3.optString(r5);	 Catch:{ JSONException -> 0x0110 }
        r23 = r1.getStyleInfo(r10);	 Catch:{ JSONException -> 0x0110 }
        r5 = "id";	 Catch:{ JSONException -> 0x0110 }
        r24 = r2.optString(r5);	 Catch:{ JSONException -> 0x0110 }
        r16 = r4;	 Catch:{ JSONException -> 0x0110 }
        r18 = r6;	 Catch:{ JSONException -> 0x0110 }
        r22 = r9;	 Catch:{ JSONException -> 0x0110 }
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24);	 Catch:{ JSONException -> 0x0110 }
        if (r11 != 0) goto L_0x010e;
    L_0x010d:
        return r4;
    L_0x010e:
        r5 = r9;
        goto L_0x011f;
    L_0x0110:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r14 = r8;
        r5 = r9;
        goto L_0x0046;
    L_0x0117:
        return r15;
    L_0x0118:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        goto L_0x0340;
    L_0x011d:
        r10 = r7;
        r4 = r15;
    L_0x011f:
        r9 = new com.xunlei.downloadprovider.ad.common.adget.b;	 Catch:{ JSONException -> 0x0336 }
        r9.<init>(r6);	 Catch:{ JSONException -> 0x0336 }
        r12 = "order_id";	 Catch:{ JSONException -> 0x0331 }
        r12 = r3.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.k = r12;	 Catch:{ JSONException -> 0x0331 }
        r12 = "crid";	 Catch:{ JSONException -> 0x0331 }
        r12 = r3.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.l = r12;	 Catch:{ JSONException -> 0x0331 }
        r7 = r1.getStyleInfo(r7);	 Catch:{ JSONException -> 0x0331 }
        r9.v = r7;	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x013f;	 Catch:{ JSONException -> 0x0331 }
    L_0x013c:
        r7 = "ssp";	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0140;	 Catch:{ JSONException -> 0x0331 }
    L_0x013f:
        r7 = r5;	 Catch:{ JSONException -> 0x0331 }
    L_0x0140:
        r9.z = r7;	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x0147;	 Catch:{ JSONException -> 0x0331 }
    L_0x0144:
        r7 = "合作方";	 Catch:{ JSONException -> 0x0331 }
        goto L_0x014d;	 Catch:{ JSONException -> 0x0331 }
    L_0x0147:
        r7 = "source_display";	 Catch:{ JSONException -> 0x0331 }
        r7 = r3.optString(r7);	 Catch:{ JSONException -> 0x0331 }
    L_0x014d:
        r9.y = r7;	 Catch:{ JSONException -> 0x0331 }
        r9.q = r11;	 Catch:{ JSONException -> 0x0331 }
        r7 = "admnative";	 Catch:{ JSONException -> 0x0331 }
        r3 = r3.optJSONObject(r7);	 Catch:{ JSONException -> 0x0331 }
        if (r3 == 0) goto L_0x032e;	 Catch:{ JSONException -> 0x0331 }
    L_0x0159:
        r7 = "link";	 Catch:{ JSONException -> 0x0331 }
        r7 = r3.optJSONObject(r7);	 Catch:{ JSONException -> 0x0331 }
        if (r7 == 0) goto L_0x0191;	 Catch:{ JSONException -> 0x0331 }
    L_0x0161:
        r11 = "url";	 Catch:{ JSONException -> 0x0331 }
        r11 = r7.optString(r11);	 Catch:{ JSONException -> 0x0331 }
        r9.g = r11;	 Catch:{ JSONException -> 0x0331 }
        r11 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x0331 }
        r11.<init>();	 Catch:{ JSONException -> 0x0331 }
        r12 = "clicktrackers";	 Catch:{ JSONException -> 0x0331 }
        r12 = r7.optJSONArray(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r12 == 0) goto L_0x0187;	 Catch:{ JSONException -> 0x0331 }
    L_0x0176:
        r14 = 0;	 Catch:{ JSONException -> 0x0331 }
    L_0x0177:
        r13 = r12.length();	 Catch:{ JSONException -> 0x0331 }
        if (r14 >= r13) goto L_0x0187;	 Catch:{ JSONException -> 0x0331 }
    L_0x017d:
        r13 = r12.getString(r14);	 Catch:{ JSONException -> 0x0331 }
        r11.add(r13);	 Catch:{ JSONException -> 0x0331 }
        r14 = r14 + 1;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0177;	 Catch:{ JSONException -> 0x0331 }
    L_0x0187:
        r12 = "landingtype";	 Catch:{ JSONException -> 0x0331 }
        r7 = r7.optInt(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.i = r7;	 Catch:{ JSONException -> 0x0331 }
        r9.w = r11;	 Catch:{ JSONException -> 0x0331 }
    L_0x0191:
        r7 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x0331 }
        r7.<init>();	 Catch:{ JSONException -> 0x0331 }
        r11 = "imptrackers";	 Catch:{ JSONException -> 0x0331 }
        r11 = r3.optJSONArray(r11);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x01af;	 Catch:{ JSONException -> 0x0331 }
    L_0x019e:
        r12 = 0;	 Catch:{ JSONException -> 0x0331 }
    L_0x019f:
        r13 = r11.length();	 Catch:{ JSONException -> 0x0331 }
        if (r12 >= r13) goto L_0x01af;	 Catch:{ JSONException -> 0x0331 }
    L_0x01a5:
        r13 = r11.getString(r12);	 Catch:{ JSONException -> 0x0331 }
        r7.add(r13);	 Catch:{ JSONException -> 0x0331 }
        r12 = r12 + 1;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x019f;	 Catch:{ JSONException -> 0x0331 }
    L_0x01af:
        r9.x = r7;	 Catch:{ JSONException -> 0x0331 }
        r7 = "assets";	 Catch:{ JSONException -> 0x0331 }
        r3 = r3.optJSONArray(r7);	 Catch:{ JSONException -> 0x0331 }
        if (r3 == 0) goto L_0x032e;	 Catch:{ JSONException -> 0x0331 }
    L_0x01b9:
        r7 = 0;	 Catch:{ JSONException -> 0x0331 }
    L_0x01ba:
        r11 = r3.length();	 Catch:{ JSONException -> 0x0331 }
        if (r7 >= r11) goto L_0x032e;	 Catch:{ JSONException -> 0x0331 }
    L_0x01c0:
        r11 = r3.getJSONObject(r7);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x01c6:
        r12 = "id";	 Catch:{ JSONException -> 0x0331 }
        r12 = r11.optInt(r12);	 Catch:{ JSONException -> 0x0331 }
        r13 = 101; // 0x65 float:1.42E-43 double:5.0E-322;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x01e4;	 Catch:{ JSONException -> 0x0331 }
    L_0x01d0:
        r12 = "title";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x01df;	 Catch:{ JSONException -> 0x0331 }
    L_0x01d8:
        r12 = "text";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x01e0;	 Catch:{ JSONException -> 0x0331 }
    L_0x01df:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x01e0:
        r9.a = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x01e4:
        r13 = 901; // 0x385 float:1.263E-42 double:4.45E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x01fc;	 Catch:{ JSONException -> 0x0331 }
    L_0x01e8:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x01f7;	 Catch:{ JSONException -> 0x0331 }
    L_0x01f0:
        r12 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x01f8;	 Catch:{ JSONException -> 0x0331 }
    L_0x01f7:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x01f8:
        r9.b = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x01fc:
        r13 = 912; // 0x390 float:1.278E-42 double:4.506E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x0214;	 Catch:{ JSONException -> 0x0331 }
    L_0x0200:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x020f;	 Catch:{ JSONException -> 0x0331 }
    L_0x0208:
        r12 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0210;	 Catch:{ JSONException -> 0x0331 }
    L_0x020f:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x0210:
        r9.n = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0214:
        r13 = 914; // 0x392 float:1.281E-42 double:4.516E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x0236;	 Catch:{ JSONException -> 0x0331 }
    L_0x0218:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x0227;	 Catch:{ JSONException -> 0x0331 }
    L_0x0220:
        r12 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0228;	 Catch:{ JSONException -> 0x0331 }
    L_0x0227:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x0228:
        r12 = "null";	 Catch:{ JSONException -> 0x0331 }
        r12 = r12.equals(r11);	 Catch:{ JSONException -> 0x0331 }
        if (r12 == 0) goto L_0x0232;	 Catch:{ JSONException -> 0x0331 }
    L_0x0230:
        r11 = "";	 Catch:{ JSONException -> 0x0331 }
    L_0x0232:
        r9.p = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0236:
        r13 = 301; // 0x12d float:4.22E-43 double:1.487E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x0254;	 Catch:{ JSONException -> 0x0331 }
    L_0x023a:
        r12 = "video";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0242:
        r12 = "url";	 Catch:{ JSONException -> 0x0331 }
        r12 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.j = r12;	 Catch:{ JSONException -> 0x0331 }
        r12 = "duration";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optInt(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.r = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0254:
        r13 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x026c;	 Catch:{ JSONException -> 0x0331 }
    L_0x0258:
        r12 = "img";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x0267;	 Catch:{ JSONException -> 0x0331 }
    L_0x0260:
        r12 = "url";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0268;	 Catch:{ JSONException -> 0x0331 }
    L_0x0267:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x0268:
        r9.c = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x026c:
        r13 = 202; // 0xca float:2.83E-43 double:1.0E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x0284;	 Catch:{ JSONException -> 0x0331 }
    L_0x0270:
        r12 = "img";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x027f;	 Catch:{ JSONException -> 0x0331 }
    L_0x0278:
        r12 = "url";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0280;	 Catch:{ JSONException -> 0x0331 }
    L_0x027f:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x0280:
        r9.m = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0284:
        r13 = 204; // 0xcc float:2.86E-43 double:1.01E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x029c;	 Catch:{ JSONException -> 0x0331 }
    L_0x0288:
        r12 = "img";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x0297;	 Catch:{ JSONException -> 0x0331 }
    L_0x0290:
        r12 = "url";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x0298;	 Catch:{ JSONException -> 0x0331 }
    L_0x0297:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x0298:
        r9.d = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x029c:
        r13 = 203; // 0xcb float:2.84E-43 double:1.003E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x02b4;	 Catch:{ JSONException -> 0x0331 }
    L_0x02a0:
        r12 = "img";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x02af;	 Catch:{ JSONException -> 0x0331 }
    L_0x02a8:
        r12 = "url";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        goto L_0x02b0;	 Catch:{ JSONException -> 0x0331 }
    L_0x02af:
        r11 = r15;	 Catch:{ JSONException -> 0x0331 }
    L_0x02b0:
        r9.o = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x02b4:
        r13 = 905; // 0x389 float:1.268E-42 double:4.47E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x02e6;	 Catch:{ JSONException -> 0x0331 }
    L_0x02b8:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x02e1;
    L_0x02c0:
        r14 = "value";	 Catch:{ NumberFormatException -> 0x02d1 }
        r14 = r11.optString(r14);	 Catch:{ NumberFormatException -> 0x02d1 }
        r14 = java.lang.Long.valueOf(r14);	 Catch:{ NumberFormatException -> 0x02d1 }
        r16 = r14.longValue();	 Catch:{ NumberFormatException -> 0x02d1 }
        r11 = r16;
        goto L_0x02e3;
    L_0x02d1:
        r14 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0331 }
        r12 = "ASSET_DOWNLOAD_COUNT is invalid. value: ";	 Catch:{ JSONException -> 0x0331 }
        r14.<init>(r12);	 Catch:{ JSONException -> 0x0331 }
        r12 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        r14.append(r11);	 Catch:{ JSONException -> 0x0331 }
    L_0x02e1:
        r11 = 0;	 Catch:{ JSONException -> 0x0331 }
    L_0x02e3:
        r9.e = r11;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x02e6:
        r13 = 903; // 0x387 float:1.265E-42 double:4.46E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x0316;	 Catch:{ JSONException -> 0x0331 }
    L_0x02ea:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        r12 = 0;
        if (r11 == 0) goto L_0x0313;
    L_0x02f3:
        r13 = "value";	 Catch:{ NumberFormatException -> 0x0303 }
        r13 = r11.optString(r13);	 Catch:{ NumberFormatException -> 0x0303 }
        r13 = java.lang.Float.valueOf(r13);	 Catch:{ NumberFormatException -> 0x0303 }
        r13 = r13.floatValue();	 Catch:{ NumberFormatException -> 0x0303 }
        r12 = r13;
        goto L_0x0313;
    L_0x0303:
        r13 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0331 }
        r14 = "ASSET_SCORE is invalid. value: ";	 Catch:{ JSONException -> 0x0331 }
        r13.<init>(r14);	 Catch:{ JSONException -> 0x0331 }
        r14 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r14);	 Catch:{ JSONException -> 0x0331 }
        r13.append(r11);	 Catch:{ JSONException -> 0x0331 }
    L_0x0313:
        r9.f = r12;	 Catch:{ JSONException -> 0x0331 }
        goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0316:
        r13 = 910; // 0x38e float:1.275E-42 double:4.496E-321;	 Catch:{ JSONException -> 0x0331 }
        if (r12 != r13) goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x031a:
        r12 = "data";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optJSONObject(r12);	 Catch:{ JSONException -> 0x0331 }
        if (r11 == 0) goto L_0x032a;	 Catch:{ JSONException -> 0x0331 }
    L_0x0322:
        r12 = "value";	 Catch:{ JSONException -> 0x0331 }
        r11 = r11.optString(r12);	 Catch:{ JSONException -> 0x0331 }
        r9.h = r11;	 Catch:{ JSONException -> 0x0331 }
    L_0x032a:
        r7 = r7 + 1;
        goto L_0x01ba;
    L_0x032e:
        r12 = r6;
        r14 = r8;
        goto L_0x0363;
    L_0x0331:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r14 = r8;
        goto L_0x0360;
    L_0x0336:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r14 = r8;
        r9 = r15;
        goto L_0x0360;
    L_0x033c:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r10 = r7;
    L_0x0340:
        r14 = r8;
        goto L_0x0046;
    L_0x0343:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        r10 = r7;
        r4 = r15;
        r9 = r4;
        goto L_0x035f;
    L_0x034a:
        r0 = move-exception;
        r3 = r0;
        r12 = r6;
        goto L_0x0350;
    L_0x034e:
        r0 = move-exception;
        r3 = r0;
    L_0x0350:
        r4 = r15;
        r9 = r4;
        goto L_0x035e;
    L_0x0353:
        r4 = r15;
        r5 = r4;
        r9 = r5;
        r10 = r9;
        r14 = 0;
        goto L_0x0363;
    L_0x0359:
        r0 = move-exception;
        r3 = r0;
        r4 = r15;
        r5 = r4;
        r9 = r5;
    L_0x035e:
        r10 = r9;
    L_0x035f:
        r14 = 0;
    L_0x0360:
        r3.printStackTrace();
    L_0x0363:
        r22 = r5;
        goto L_0x0391;
    L_0x0366:
        r13 = new com.xunlei.downloadprovider.ad.common.adget.j$a;
        r3 = r1.getStyleInfo(r15);
        r3 = r3.mLoadStrate;
        r3 = r3 & r4;
        r4 = (byte) r3;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = r1.getStyleInfo(r15);
        if (r2 == 0) goto L_0x0382;
    L_0x037a:
        r3 = "id";
        r3 = r2.optString(r3);
        r11 = r3;
        goto L_0x0383;
    L_0x0382:
        r11 = r15;
    L_0x0383:
        r3 = r13;
        r5 = r12;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11);
        r4 = r13;
        r9 = r15;
        goto L_0x038d;
    L_0x038b:
        r4 = r15;
        r9 = r4;
    L_0x038d:
        r10 = r9;
        r22 = r10;
        r14 = 0;
    L_0x0391:
        if (r9 == 0) goto L_0x03ba;
    L_0x0393:
        r3 = r9.q;
        if (r3 != 0) goto L_0x03ba;
    L_0x0397:
        r3 = new com.xunlei.downloadprovider.ad.common.adget.j$a;
        r17 = 0;
        r20 = 0;
        r21 = 0;
        r23 = r1.getStyleInfo(r10);
        if (r2 == 0) goto L_0x03ae;
    L_0x03a5:
        r4 = "id";
        r4 = r2.optString(r4);
        r24 = r4;
        goto L_0x03b0;
    L_0x03ae:
        r24 = r15;
    L_0x03b0:
        r16 = r3;
        r18 = r12;
        r19 = r9;
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24);
        goto L_0x03c5;
    L_0x03ba:
        if (r4 == 0) goto L_0x03c4;
    L_0x03bc:
        if (r9 == 0) goto L_0x03c4;
    L_0x03be:
        r3 = r9.q;
        if (r3 == 0) goto L_0x03c4;
    L_0x03c2:
        r4.b = r9;
    L_0x03c4:
        r3 = r4;
    L_0x03c5:
        if (r14 == 0) goto L_0x03f2;
    L_0x03c7:
        r3 = new com.xunlei.downloadprovider.ad.common.adget.j$a;
        r17 = 2;
        r20 = 0;
        r21 = 0;
        r22 = 0;
        r23 = r26.getDefStyle();
        if (r2 == 0) goto L_0x03dd;
    L_0x03d7:
        r1 = "id";
        r15 = r2.optString(r1);
    L_0x03dd:
        r24 = r15;
        r16 = r3;
        r18 = r12;
        r19 = r9;
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24);
        r1 = "single_request_content_error";
        r2 = -20;
        r1 = com.xunlei.downloadprovider.ad.common.report.e.a(r2, r1);
        r3.i = r1;
    L_0x03f2:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.common.adget.j.a(com.xunlei.downloadprovider.ad.common.adget.ADConst$THUNDER_AD_INFO, org.json.JSONObject):com.xunlei.downloadprovider.ad.common.adget.j$a");
    }

    public static THUNDER_AD_INFO a(List<THUNDER_AD_INFO> list, JSONObject jSONObject) {
        THUNDER_AD_INFO thunder_ad_info = null;
        if (jSONObject == null) {
            return null;
        }
        jSONObject = jSONObject.optJSONArray("bid");
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            jSONObject = jSONObject.optJSONObject(0);
            if (jSONObject != null) {
                jSONObject = jSONObject.optString("impid");
                for (THUNDER_AD_INFO thunder_ad_info2 : list) {
                    if (thunder_ad_info2.mPositionId.equals(jSONObject)) {
                        break;
                    }
                }
            }
            THUNDER_AD_INFO thunder_ad_info22 = null;
            if (thunder_ad_info22 != null) {
                thunder_ad_info = thunder_ad_info22;
            }
        }
        return thunder_ad_info;
    }
}
