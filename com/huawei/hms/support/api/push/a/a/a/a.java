package com.huawei.hms.support.api.push.a.a.a;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.alipay.sdk.packet.d;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseUtil */
public abstract class a {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static org.json.JSONArray a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r2);
        r1 = 0;
        if (r0 == 0) goto L_0x0015;
    L_0x0007:
        r2 = com.huawei.hms.support.log.a.a();
        if (r2 == 0) goto L_0x0014;
    L_0x000d:
        r2 = "BaseUtil";
        r0 = "jsonString is null";
        com.huawei.hms.support.log.a.a(r2, r0);
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x001b }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x001b }
        return r0;
    L_0x001b:
        r2 = com.huawei.hms.support.log.a.a();
        if (r2 == 0) goto L_0x0028;
    L_0x0021:
        r2 = "BaseUtil";
        r0 = "cast jsonString to jsonArray error";
        com.huawei.hms.support.log.a.a(r2, r0);
    L_0x0028:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.push.a.a.a.a.a(java.lang.String):org.json.JSONArray");
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr[i2] = a[(b & 240) >> 4];
            cArr[i2 + 1] = a[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        try {
            str = str.getBytes("UTF-8");
            for (int i = 0; i < length; i++) {
                StringBuilder stringBuilder = new StringBuilder("0x");
                byte[] bArr2 = new byte[1];
                bArr2[0] = str[i * 2];
                stringBuilder.append(new String(bArr2, "UTF-8"));
                byte byteValue = (byte) (Byte.decode(stringBuilder.toString()).byteValue() << 4);
                StringBuilder stringBuilder2 = new StringBuilder("0x");
                stringBuilder2.append(new String(new byte[]{str[r8 + 1]}, "UTF-8"));
                bArr[i] = (byte) (byteValue ^ Byte.decode(stringBuilder2.toString()).byteValue());
            }
        } catch (String str2) {
            if (com.huawei.hms.support.log.a.a()) {
                StringBuilder stringBuilder3 = new StringBuilder("hexString2ByteArray error");
                stringBuilder3.append(str2.getMessage());
                com.huawei.hms.support.log.a.a("BaseUtil", stringBuilder3.toString());
            }
        }
        return bArr;
    }

    public static JSONArray a(List<String> list, Context context) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        c cVar = new c(context, "tags_info");
        for (String str : list) {
            if (cVar.c(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagKey", str);
                jSONObject.put("opType", 2);
                if (jSONObject.length() > null) {
                    jSONArray.put(jSONObject);
                }
            } else if (com.huawei.hms.support.log.a.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" not exist, need not to remove");
                com.huawei.hms.support.log.a.a("BaseUtil", stringBuilder.toString());
            }
        }
        return jSONArray;
    }

    public static void a(ApiClient apiClient, String str) {
        if (apiClient != null) {
            Map hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put("sdk_ver", "20502300");
            Object obj = null;
            SubAppInfo subAppInfo = apiClient.getSubAppInfo();
            if (subAppInfo != null) {
                obj = subAppInfo.getSubAppID();
            }
            if (obj == null) {
                obj = apiClient.getAppID();
            }
            hashMap.put(Constants.APP_ID, obj);
            str = str.split("\\.");
            if (str.length == 2) {
                hashMap.put(NotificationCompat.CATEGORY_SERVICE, str[0]);
                hashMap.put(d.i, str[1]);
            }
            hashMap.put("result", "0");
            hashMap.put("cost_time", "0");
            com.huawei.hms.support.b.a.a().a(apiClient.getContext(), "HMS_SDK_API_CALL", hashMap);
        }
    }
}
