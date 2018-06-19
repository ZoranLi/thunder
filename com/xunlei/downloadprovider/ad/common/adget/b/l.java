package com.xunlei.downloadprovider.ad.common.adget.b;

import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.report.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MultiParser */
final class l {
    static Map<THUNDER_AD_INFO, a> a(List<THUNDER_AD_INFO> list, String str) {
        Map<THUNDER_AD_INFO, a> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString(AgooConstants.MESSAGE_ID);
            JSONArray optJSONArray = jSONObject.optJSONArray("bid");
            a aVar;
            if (optJSONArray == null || optJSONArray.length() == 0) {
                for (THUNDER_AD_INFO thunder_ad_info : list) {
                    aVar = new a((byte) 2, thunder_ad_info.getPositionId(), null, null, null, null, thunder_ad_info.getDefStyle(), str);
                    aVar.i = e.a(-18, "multi_request_no_ad");
                    hashMap.put(thunder_ad_info, aVar);
                }
                return hashMap;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                THUNDER_AD_INFO a = a((List) list, jSONObject2);
                if (a != null) {
                    hashMap.put(a, a(a, str, jSONObject2));
                }
            }
            for (THUNDER_AD_INFO thunder_ad_info2 : list) {
                if (!hashMap.keySet().contains(thunder_ad_info2)) {
                    aVar = new a((byte) 2, thunder_ad_info2.getPositionId(), null, null, null, null, thunder_ad_info2.getDefStyle(), str);
                    aVar.i = e.a(-19, "multi_request_lack_ad");
                    hashMap.put(thunder_ad_info2, aVar);
                }
            }
            return hashMap;
        } catch (List<THUNDER_AD_INFO> list2) {
            list2.printStackTrace();
        }
    }

    private static com.xunlei.downloadprovider.ad.common.adget.j.a a(com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO r30, java.lang.String r31, org.json.JSONObject r32) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r30;
        r2 = r32;
        r3 = "";
        r4 = -20;
        r5 = 0;
        r6 = 0;
        if (r2 == 0) goto L_0x0374;
    L_0x000c:
        r7 = "source";	 Catch:{ JSONException -> 0x0365 }
        r7 = r2.optString(r7);	 Catch:{ JSONException -> 0x0365 }
        r8 = "impid";	 Catch:{ JSONException -> 0x0360 }
        r8 = r2.optString(r8);	 Catch:{ JSONException -> 0x0360 }
        r3 = "styleid";	 Catch:{ JSONException -> 0x035d }
        r3 = r2.optString(r3);	 Catch:{ JSONException -> 0x035d }
        r9 = android.text.TextUtils.isEmpty(r3);	 Catch:{ JSONException -> 0x0355 }
        r10 = 1;
        if (r9 != 0) goto L_0x0038;
    L_0x0025:
        r9 = r1.containStyleInfo(r3);	 Catch:{ JSONException -> 0x002d }
        if (r9 != 0) goto L_0x0038;
    L_0x002b:
        r9 = r10;
        goto L_0x0039;
    L_0x002d:
        r0 = move-exception;
        r2 = r0;
        r20 = r3;
        r9 = r5;
        r19 = r9;
        r18 = r6;
        goto L_0x0370;
    L_0x0038:
        r9 = r6;
    L_0x0039:
        r11 = "alliance";	 Catch:{ JSONException -> 0x034a }
        r11 = r2.optString(r11);	 Catch:{ JSONException -> 0x034a }
        r12 = "default_ad";	 Catch:{ JSONException -> 0x034a }
        r15 = r2.optBoolean(r12);	 Catch:{ JSONException -> 0x034a }
        r12 = "sdk";	 Catch:{ JSONException -> 0x034a }
        r12 = r7.equals(r12);	 Catch:{ JSONException -> 0x034a }
        if (r12 == 0) goto L_0x012a;	 Catch:{ JSONException -> 0x034a }
    L_0x004d:
        if (r11 == 0) goto L_0x012a;	 Catch:{ JSONException -> 0x034a }
    L_0x004f:
        r12 = ":";	 Catch:{ JSONException -> 0x034a }
        r11 = r11.split(r12);	 Catch:{ JSONException -> 0x034a }
        r12 = r11.length;	 Catch:{ JSONException -> 0x034a }
        if (r12 == 0) goto L_0x005b;	 Catch:{ JSONException -> 0x034a }
    L_0x0058:
        r12 = r11[r6];	 Catch:{ JSONException -> 0x034a }
        goto L_0x005d;	 Catch:{ JSONException -> 0x034a }
    L_0x005b:
        r12 = "100";	 Catch:{ JSONException -> 0x034a }
    L_0x005d:
        r13 = r12.length();	 Catch:{ JSONException -> 0x034a }
        if (r13 <= r10) goto L_0x0067;	 Catch:{ JSONException -> 0x034a }
    L_0x0063:
        r11 = r11[r10];	 Catch:{ JSONException -> 0x034a }
        r14 = r11;
        goto L_0x0068;
    L_0x0067:
        r14 = r3;
    L_0x0068:
        r11 = android.text.TextUtils.isEmpty(r14);	 Catch:{ JSONException -> 0x0124 }
        if (r11 != 0) goto L_0x0081;
    L_0x006e:
        r11 = r1.containStyleInfo(r14);	 Catch:{ JSONException -> 0x0077 }
        if (r11 != 0) goto L_0x0081;
    L_0x0074:
        r18 = r10;
        goto L_0x0083;
    L_0x0077:
        r0 = move-exception;
        r2 = r0;
        r19 = r5;
        r18 = r9;
        r20 = r14;
        goto L_0x0352;
    L_0x0081:
        r18 = r6;
    L_0x0083:
        r9 = "101";	 Catch:{ JSONException -> 0x011b }
        r9 = r12.equals(r9);	 Catch:{ JSONException -> 0x011b }
        if (r9 == 0) goto L_0x00a1;
    L_0x008b:
        r9 = r1.getStyleInfo(r14);	 Catch:{ JSONException -> 0x0098 }
        r9 = r9.mLoadStrate;	 Catch:{ JSONException -> 0x0098 }
        r9 = r9 & r10;	 Catch:{ JSONException -> 0x0098 }
        r9 = (byte) r9;	 Catch:{ JSONException -> 0x0098 }
        r10 = "baidu";	 Catch:{ JSONException -> 0x0098 }
        r7 = r10;
        r10 = r9;
        goto L_0x00b6;
    L_0x0098:
        r0 = move-exception;
        r2 = r0;
        r9 = r5;
        r19 = r9;
        r20 = r14;
        goto L_0x0370;
    L_0x00a1:
        r9 = "100";	 Catch:{ JSONException -> 0x011b }
        r9 = r12.equals(r9);	 Catch:{ JSONException -> 0x011b }
        if (r9 == 0) goto L_0x011a;	 Catch:{ JSONException -> 0x011b }
    L_0x00a9:
        r9 = "tencent";	 Catch:{ JSONException -> 0x011b }
        r7 = 6;
        r10 = r1.getStyleInfo(r14);	 Catch:{ JSONException -> 0x0111 }
        r10 = r10.mLoadStrate;	 Catch:{ JSONException -> 0x0111 }
        r7 = r7 & r10;
        r7 = (byte) r7;
        r10 = r7;
        r7 = r9;
    L_0x00b6:
        if (r18 == 0) goto L_0x00e9;
    L_0x00b8:
        r2 = new com.xunlei.downloadprovider.ad.common.adget.j$a;	 Catch:{ JSONException -> 0x00df }
        r10 = 2;	 Catch:{ JSONException -> 0x00df }
        r12 = 0;	 Catch:{ JSONException -> 0x00df }
        r13 = 0;	 Catch:{ JSONException -> 0x00df }
        r3 = 0;	 Catch:{ JSONException -> 0x00df }
        r15 = 0;	 Catch:{ JSONException -> 0x00df }
        r16 = r30.getDefStyle();	 Catch:{ JSONException -> 0x00df }
        r9 = r2;
        r11 = r8;
        r6 = r14;
        r14 = r3;
        r17 = r31;
        r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ JSONException -> 0x00dd }
        r3 = "multi_request_style_id_error";	 Catch:{ JSONException -> 0x00d5 }
        r3 = com.xunlei.downloadprovider.ad.common.report.e.a(r4, r3);	 Catch:{ JSONException -> 0x00d5 }
        r2.i = r3;	 Catch:{ JSONException -> 0x00d5 }
        return r2;
    L_0x00d5:
        r0 = move-exception;
        r19 = r2;
        r9 = r5;
        r20 = r6;
        goto L_0x0344;
    L_0x00dd:
        r0 = move-exception;
        goto L_0x00e1;
    L_0x00df:
        r0 = move-exception;
        r6 = r14;
    L_0x00e1:
        r2 = r0;
        r9 = r5;
        r19 = r9;
        r20 = r6;
        goto L_0x0370;
    L_0x00e9:
        r19 = new com.xunlei.downloadprovider.ad.common.adget.j$a;	 Catch:{ JSONException -> 0x011b }
        r12 = 0;	 Catch:{ JSONException -> 0x011b }
        r9 = "alliance_imp_url";	 Catch:{ JSONException -> 0x011b }
        r13 = r2.optString(r9);	 Catch:{ JSONException -> 0x011b }
        r9 = "alliance_click_url";	 Catch:{ JSONException -> 0x011b }
        r16 = r2.optString(r9);	 Catch:{ JSONException -> 0x011b }
        r17 = r1.getStyleInfo(r14);	 Catch:{ JSONException -> 0x011b }
        r9 = r19;
        r11 = r8;
        r20 = r14;
        r14 = r16;
        r6 = r15;
        r15 = r7;
        r16 = r17;
        r17 = r31;
        r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ JSONException -> 0x010f }
        if (r6 != 0) goto L_0x0131;
    L_0x010e:
        return r19;
    L_0x010f:
        r0 = move-exception;
        goto L_0x011e;
    L_0x0111:
        r0 = move-exception;
        r20 = r14;
        r2 = r0;
        r19 = r5;
        r7 = r9;
        goto L_0x0352;
    L_0x011a:
        return r5;
    L_0x011b:
        r0 = move-exception;
        r20 = r14;
    L_0x011e:
        r2 = r0;
        r9 = r5;
        r19 = r9;
        goto L_0x0370;
    L_0x0124:
        r0 = move-exception;
        r20 = r14;
        r2 = r0;
        goto L_0x034e;
    L_0x012a:
        r6 = r15;
        r20 = r3;
        r19 = r5;
        r18 = r9;
    L_0x0131:
        r9 = new com.xunlei.downloadprovider.ad.common.adget.b;	 Catch:{ JSONException -> 0x0346 }
        r9.<init>(r8);	 Catch:{ JSONException -> 0x0346 }
        r10 = "order_id";	 Catch:{ JSONException -> 0x0343 }
        r10 = r2.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.k = r10;	 Catch:{ JSONException -> 0x0343 }
        r10 = "crid";	 Catch:{ JSONException -> 0x0343 }
        r10 = r2.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.l = r10;	 Catch:{ JSONException -> 0x0343 }
        r3 = r1.getStyleInfo(r3);	 Catch:{ JSONException -> 0x0343 }
        r9.v = r3;	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0151;	 Catch:{ JSONException -> 0x0343 }
    L_0x014e:
        r3 = "ssp";	 Catch:{ JSONException -> 0x0343 }
        goto L_0x0152;	 Catch:{ JSONException -> 0x0343 }
    L_0x0151:
        r3 = r7;	 Catch:{ JSONException -> 0x0343 }
    L_0x0152:
        r9.z = r3;	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0159;	 Catch:{ JSONException -> 0x0343 }
    L_0x0156:
        r3 = "合作方";	 Catch:{ JSONException -> 0x0343 }
        goto L_0x015f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0159:
        r3 = "source_display";	 Catch:{ JSONException -> 0x0343 }
        r3 = r2.optString(r3);	 Catch:{ JSONException -> 0x0343 }
    L_0x015f:
        r9.y = r3;	 Catch:{ JSONException -> 0x0343 }
        r9.q = r6;	 Catch:{ JSONException -> 0x0343 }
        r3 = "admnative";	 Catch:{ JSONException -> 0x0343 }
        r2 = r2.optJSONObject(r3);	 Catch:{ JSONException -> 0x0343 }
        if (r2 == 0) goto L_0x037d;	 Catch:{ JSONException -> 0x0343 }
    L_0x016b:
        r3 = "link";	 Catch:{ JSONException -> 0x0343 }
        r3 = r2.optJSONObject(r3);	 Catch:{ JSONException -> 0x0343 }
        if (r3 == 0) goto L_0x01a3;	 Catch:{ JSONException -> 0x0343 }
    L_0x0173:
        r6 = "url";	 Catch:{ JSONException -> 0x0343 }
        r6 = r3.optString(r6);	 Catch:{ JSONException -> 0x0343 }
        r9.g = r6;	 Catch:{ JSONException -> 0x0343 }
        r6 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x0343 }
        r6.<init>();	 Catch:{ JSONException -> 0x0343 }
        r10 = "clicktrackers";	 Catch:{ JSONException -> 0x0343 }
        r10 = r3.optJSONArray(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r10 == 0) goto L_0x0199;	 Catch:{ JSONException -> 0x0343 }
    L_0x0188:
        r11 = 0;	 Catch:{ JSONException -> 0x0343 }
    L_0x0189:
        r12 = r10.length();	 Catch:{ JSONException -> 0x0343 }
        if (r11 >= r12) goto L_0x0199;	 Catch:{ JSONException -> 0x0343 }
    L_0x018f:
        r12 = r10.getString(r11);	 Catch:{ JSONException -> 0x0343 }
        r6.add(r12);	 Catch:{ JSONException -> 0x0343 }
        r11 = r11 + 1;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x0189;	 Catch:{ JSONException -> 0x0343 }
    L_0x0199:
        r10 = "landingtype";	 Catch:{ JSONException -> 0x0343 }
        r3 = r3.optInt(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.i = r3;	 Catch:{ JSONException -> 0x0343 }
        r9.w = r6;	 Catch:{ JSONException -> 0x0343 }
    L_0x01a3:
        r3 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x0343 }
        r3.<init>();	 Catch:{ JSONException -> 0x0343 }
        r6 = "imptrackers";	 Catch:{ JSONException -> 0x0343 }
        r6 = r2.optJSONArray(r6);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x01c1;	 Catch:{ JSONException -> 0x0343 }
    L_0x01b0:
        r10 = 0;	 Catch:{ JSONException -> 0x0343 }
    L_0x01b1:
        r11 = r6.length();	 Catch:{ JSONException -> 0x0343 }
        if (r10 >= r11) goto L_0x01c1;	 Catch:{ JSONException -> 0x0343 }
    L_0x01b7:
        r11 = r6.getString(r10);	 Catch:{ JSONException -> 0x0343 }
        r3.add(r11);	 Catch:{ JSONException -> 0x0343 }
        r10 = r10 + 1;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x01b1;	 Catch:{ JSONException -> 0x0343 }
    L_0x01c1:
        r9.x = r3;	 Catch:{ JSONException -> 0x0343 }
        r3 = "assets";	 Catch:{ JSONException -> 0x0343 }
        r2 = r2.optJSONArray(r3);	 Catch:{ JSONException -> 0x0343 }
        if (r2 == 0) goto L_0x037d;	 Catch:{ JSONException -> 0x0343 }
    L_0x01cb:
        r3 = 0;	 Catch:{ JSONException -> 0x0343 }
    L_0x01cc:
        r6 = r2.length();	 Catch:{ JSONException -> 0x0343 }
        if (r3 >= r6) goto L_0x037d;	 Catch:{ JSONException -> 0x0343 }
    L_0x01d2:
        r6 = r2.getJSONObject(r3);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x01d8:
        r10 = "id";	 Catch:{ JSONException -> 0x0343 }
        r10 = r6.optInt(r10);	 Catch:{ JSONException -> 0x0343 }
        r11 = 101; // 0x65 float:1.42E-43 double:5.0E-322;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x01f6;	 Catch:{ JSONException -> 0x0343 }
    L_0x01e2:
        r10 = "title";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x01f1;	 Catch:{ JSONException -> 0x0343 }
    L_0x01ea:
        r10 = "text";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x01f2;	 Catch:{ JSONException -> 0x0343 }
    L_0x01f1:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x01f2:
        r9.a = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x01f6:
        r11 = 901; // 0x385 float:1.263E-42 double:4.45E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x020e;	 Catch:{ JSONException -> 0x0343 }
    L_0x01fa:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0209;	 Catch:{ JSONException -> 0x0343 }
    L_0x0202:
        r10 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x020a;	 Catch:{ JSONException -> 0x0343 }
    L_0x0209:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x020a:
        r9.b = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x020e:
        r11 = 912; // 0x390 float:1.278E-42 double:4.506E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x0226;	 Catch:{ JSONException -> 0x0343 }
    L_0x0212:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0221;	 Catch:{ JSONException -> 0x0343 }
    L_0x021a:
        r10 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x0222;	 Catch:{ JSONException -> 0x0343 }
    L_0x0221:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x0222:
        r9.n = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0226:
        r11 = 914; // 0x392 float:1.281E-42 double:4.516E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x0248;	 Catch:{ JSONException -> 0x0343 }
    L_0x022a:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0239;	 Catch:{ JSONException -> 0x0343 }
    L_0x0232:
        r10 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x023a;	 Catch:{ JSONException -> 0x0343 }
    L_0x0239:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x023a:
        r10 = "null";	 Catch:{ JSONException -> 0x0343 }
        r10 = r10.equals(r6);	 Catch:{ JSONException -> 0x0343 }
        if (r10 == 0) goto L_0x0244;	 Catch:{ JSONException -> 0x0343 }
    L_0x0242:
        r6 = "";	 Catch:{ JSONException -> 0x0343 }
    L_0x0244:
        r9.p = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0248:
        r11 = 301; // 0x12d float:4.22E-43 double:1.487E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x0266;	 Catch:{ JSONException -> 0x0343 }
    L_0x024c:
        r10 = "video";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0254:
        r10 = "url";	 Catch:{ JSONException -> 0x0343 }
        r10 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.j = r10;	 Catch:{ JSONException -> 0x0343 }
        r10 = "duration";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optInt(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.r = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0266:
        r11 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x027e;	 Catch:{ JSONException -> 0x0343 }
    L_0x026a:
        r10 = "img";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0279;	 Catch:{ JSONException -> 0x0343 }
    L_0x0272:
        r10 = "url";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x027a;	 Catch:{ JSONException -> 0x0343 }
    L_0x0279:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x027a:
        r9.c = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x027e:
        r11 = 202; // 0xca float:2.83E-43 double:1.0E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x0296;	 Catch:{ JSONException -> 0x0343 }
    L_0x0282:
        r10 = "img";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x0291;	 Catch:{ JSONException -> 0x0343 }
    L_0x028a:
        r10 = "url";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x0292;	 Catch:{ JSONException -> 0x0343 }
    L_0x0291:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x0292:
        r9.m = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0296:
        r11 = 204; // 0xcc float:2.86E-43 double:1.01E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x02ae;	 Catch:{ JSONException -> 0x0343 }
    L_0x029a:
        r10 = "img";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x02a9;	 Catch:{ JSONException -> 0x0343 }
    L_0x02a2:
        r10 = "url";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x02aa;	 Catch:{ JSONException -> 0x0343 }
    L_0x02a9:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x02aa:
        r9.d = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x02ae:
        r11 = 203; // 0xcb float:2.84E-43 double:1.003E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x02c6;	 Catch:{ JSONException -> 0x0343 }
    L_0x02b2:
        r10 = "img";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x02c1;	 Catch:{ JSONException -> 0x0343 }
    L_0x02ba:
        r10 = "url";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        goto L_0x02c2;	 Catch:{ JSONException -> 0x0343 }
    L_0x02c1:
        r6 = r5;	 Catch:{ JSONException -> 0x0343 }
    L_0x02c2:
        r9.o = r6;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x02c6:
        r11 = 905; // 0x389 float:1.268E-42 double:4.47E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x02f9;	 Catch:{ JSONException -> 0x0343 }
    L_0x02ca:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        r10 = 0;
        if (r6 == 0) goto L_0x02f5;
    L_0x02d4:
        r12 = "value";	 Catch:{ NumberFormatException -> 0x02e3 }
        r12 = r6.optString(r12);	 Catch:{ NumberFormatException -> 0x02e3 }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ NumberFormatException -> 0x02e3 }
        r12 = r12.longValue();	 Catch:{ NumberFormatException -> 0x02e3 }
        goto L_0x02f6;
    L_0x02e3:
        r12 = com.xunlei.downloadprovider.ad.common.adget.b.b.a;	 Catch:{ JSONException -> 0x0343 }
        r12 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0343 }
        r13 = "ASSET_DOWNLOAD_COUNT is invalid. value: ";	 Catch:{ JSONException -> 0x0343 }
        r12.<init>(r13);	 Catch:{ JSONException -> 0x0343 }
        r13 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r13);	 Catch:{ JSONException -> 0x0343 }
        r12.append(r6);	 Catch:{ JSONException -> 0x0343 }
    L_0x02f5:
        r12 = r10;	 Catch:{ JSONException -> 0x0343 }
    L_0x02f6:
        r9.e = r12;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x02f9:
        r11 = 903; // 0x387 float:1.265E-42 double:4.46E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x032b;	 Catch:{ JSONException -> 0x0343 }
    L_0x02fd:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        r10 = 0;
        if (r6 == 0) goto L_0x0327;
    L_0x0306:
        r11 = "value";	 Catch:{ NumberFormatException -> 0x0315 }
        r11 = r6.optString(r11);	 Catch:{ NumberFormatException -> 0x0315 }
        r11 = java.lang.Float.valueOf(r11);	 Catch:{ NumberFormatException -> 0x0315 }
        r11 = r11.floatValue();	 Catch:{ NumberFormatException -> 0x0315 }
        goto L_0x0328;
    L_0x0315:
        r11 = com.xunlei.downloadprovider.ad.common.adget.b.b.a;	 Catch:{ JSONException -> 0x0343 }
        r11 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0343 }
        r12 = "ASSET_SCORE is invalid. value: ";	 Catch:{ JSONException -> 0x0343 }
        r11.<init>(r12);	 Catch:{ JSONException -> 0x0343 }
        r12 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r12);	 Catch:{ JSONException -> 0x0343 }
        r11.append(r6);	 Catch:{ JSONException -> 0x0343 }
    L_0x0327:
        r11 = r10;	 Catch:{ JSONException -> 0x0343 }
    L_0x0328:
        r9.f = r11;	 Catch:{ JSONException -> 0x0343 }
        goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x032b:
        r11 = 910; // 0x38e float:1.275E-42 double:4.496E-321;	 Catch:{ JSONException -> 0x0343 }
        if (r10 != r11) goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x032f:
        r10 = "data";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optJSONObject(r10);	 Catch:{ JSONException -> 0x0343 }
        if (r6 == 0) goto L_0x033f;	 Catch:{ JSONException -> 0x0343 }
    L_0x0337:
        r10 = "value";	 Catch:{ JSONException -> 0x0343 }
        r6 = r6.optString(r10);	 Catch:{ JSONException -> 0x0343 }
        r9.h = r6;	 Catch:{ JSONException -> 0x0343 }
    L_0x033f:
        r3 = r3 + 1;
        goto L_0x01cc;
    L_0x0343:
        r0 = move-exception;
    L_0x0344:
        r2 = r0;
        goto L_0x0370;
    L_0x0346:
        r0 = move-exception;
        r2 = r0;
        r9 = r5;
        goto L_0x0370;
    L_0x034a:
        r0 = move-exception;
        r2 = r0;
        r20 = r3;
    L_0x034e:
        r19 = r5;
        r18 = r9;
    L_0x0352:
        r9 = r19;
        goto L_0x0370;
    L_0x0355:
        r0 = move-exception;
        r2 = r0;
        r20 = r3;
        r9 = r5;
        r19 = r9;
        goto L_0x036e;
    L_0x035d:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0363;
    L_0x0360:
        r0 = move-exception;
        r2 = r0;
        r8 = r3;
    L_0x0363:
        r9 = r5;
        goto L_0x036a;
    L_0x0365:
        r0 = move-exception;
        r2 = r0;
        r8 = r3;
        r7 = r5;
        r9 = r7;
    L_0x036a:
        r19 = r9;
        r20 = r19;
    L_0x036e:
        r18 = 0;
    L_0x0370:
        r2.printStackTrace();
        goto L_0x037d;
    L_0x0374:
        r8 = r3;
        r7 = r5;
        r9 = r7;
        r19 = r9;
        r20 = r19;
        r18 = 0;
    L_0x037d:
        r27 = r7;
        r2 = r19;
        r3 = r20;
        if (r9 == 0) goto L_0x03a1;
    L_0x0385:
        r5 = r9.q;
        if (r5 != 0) goto L_0x03a1;
    L_0x0389:
        r2 = new com.xunlei.downloadprovider.ad.common.adget.j$a;
        r22 = 0;
        r25 = 0;
        r26 = 0;
        r28 = r1.getStyleInfo(r3);
        r21 = r2;
        r23 = r8;
        r24 = r9;
        r29 = r31;
        r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29);
        goto L_0x03ab;
    L_0x03a1:
        if (r2 == 0) goto L_0x03ab;
    L_0x03a3:
        if (r9 == 0) goto L_0x03ab;
    L_0x03a5:
        r3 = r9.q;
        if (r3 == 0) goto L_0x03ab;
    L_0x03a9:
        r2.b = r9;
    L_0x03ab:
        if (r18 != 0) goto L_0x03af;
    L_0x03ad:
        if (r2 != 0) goto L_0x03d0;
    L_0x03af:
        r2 = new com.xunlei.downloadprovider.ad.common.adget.j$a;
        r22 = 2;
        r25 = 0;
        r26 = 0;
        r27 = 0;
        r28 = r30.getDefStyle();
        r21 = r2;
        r23 = r8;
        r24 = r9;
        r29 = r31;
        r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29);
        r1 = "multi_request_content_error";
        r1 = com.xunlei.downloadprovider.ad.common.report.e.a(r4, r1);
        r2.i = r1;
    L_0x03d0:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.common.adget.b.l.a(com.xunlei.downloadprovider.ad.common.adget.ADConst$THUNDER_AD_INFO, java.lang.String, org.json.JSONObject):com.xunlei.downloadprovider.ad.common.adget.j$a");
    }

    private static THUNDER_AD_INFO a(List<THUNDER_AD_INFO> list, JSONObject jSONObject) {
        jSONObject = jSONObject.optString("impid");
        for (THUNDER_AD_INFO thunder_ad_info : list) {
            if (thunder_ad_info.mPositionId.equals(jSONObject)) {
                return thunder_ad_info;
            }
        }
        return null;
    }
}
