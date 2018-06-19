package com.xunlei.downloadprovider.vod.manager;

import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.android.volley.Request;
import com.android.volley.toolbox.z;
import com.tencent.connect.common.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.e;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/* compiled from: MCPRequestManager */
public class c extends e {
    private static final String a = "c";
    private static final String[] b = new String[]{"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", "a", b.a, "c", d.a, com.xunlei.downloadprovider.pushmessage.e.a, f.a};

    public static String a() {
        return "http://api.tw06.xlmc.sandai.net/";
    }

    public final void a(String str, String str2, Map<String, String> map, com.xunlei.downloadprovider.member.payment.a.e.c<String> cVar) {
        a((Map) map, str2);
        XLThreadPool.execute(new e(this, str, cVar, map));
    }

    final String a(String str, Map<String, String> map) {
        String str2 = "";
        z a = z.a();
        Request dVar = new d(this, str, a, a, map);
        dVar.setShouldCache(null);
        this.e.a(dVar);
        try {
            return (String) a.get(5000, TimeUnit.MILLISECONDS);
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }

    static void a(Map<String, String> map, String str) {
        if (map != null) {
            map.put("appId", Constants.VIA_REPORT_TYPE_START_GROUP);
            map.put("v", str);
            map.put("callId", String.valueOf(System.currentTimeMillis()));
            map.put("appVersion", "5.60.2.5510");
            map.put("gz", "1");
            map.put("deviceId", AndroidConfig.getShouleiMemberDeviceId());
            map.put("xlt", LoginHelper.a().c());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            map.put("xluid", stringBuilder.toString());
            map.put(INoCaptchaComponent.sig, b(map, "ed35b80ab6de3944a96466be405de2fc"));
            new StringBuilder("addCommonData deviceId : ").append(AndroidConfig.getShouleiMemberDeviceId());
        }
    }

    private static String b(Map<String, String> map, String str) {
        if (map.size() == 0) {
            return "";
        }
        TreeMap treeMap = new TreeMap();
        for (String str2 : map.keySet()) {
            treeMap.put(str2, map.get(str2));
        }
        map = new Vector();
        for (String str22 : treeMap.keySet()) {
            Object obj = treeMap.get(str22);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str22);
            stringBuilder.append("=");
            stringBuilder.append(obj);
            map.add(stringBuilder.toString());
        }
        String[] strArr = new String[map.size()];
        map.toArray(strArr);
        map = null;
        for (int i = 0; i < strArr.length; i++) {
            for (int length = strArr.length - 1; length > i; length--) {
                int i2 = length - 1;
                if (strArr[length].compareTo(strArr[i2]) < 0) {
                    String str3 = strArr[length];
                    strArr[length] = strArr[i2];
                    strArr[i2] = str3;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (map < strArr.length) {
            stringBuilder2.append(strArr[map]);
            map++;
        }
        stringBuilder2.append(str);
        if (TextUtils.isEmpty(null) == null) {
            stringBuilder2.append(null);
        }
        return a(stringBuilder2.toString());
    }

    private static java.lang.String a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x0046 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x0046 }
        r6 = r6.getBytes();	 Catch:{ Exception -> 0x0046 }
        r6 = r0.digest(r6);	 Catch:{ Exception -> 0x0046 }
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0046 }
        r0.<init>();	 Catch:{ Exception -> 0x0046 }
        r1 = 0;	 Catch:{ Exception -> 0x0046 }
    L_0x0014:
        r2 = r6.length;	 Catch:{ Exception -> 0x0046 }
        if (r1 >= r2) goto L_0x0041;	 Catch:{ Exception -> 0x0046 }
    L_0x0017:
        r2 = r6[r1];	 Catch:{ Exception -> 0x0046 }
        if (r2 >= 0) goto L_0x001e;	 Catch:{ Exception -> 0x0046 }
    L_0x001b:
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ Exception -> 0x0046 }
        r2 = r2 + r3;	 Catch:{ Exception -> 0x0046 }
    L_0x001e:
        r3 = r2 >>> 4;	 Catch:{ Exception -> 0x0046 }
        r3 = r3 & 15;	 Catch:{ Exception -> 0x0046 }
        r2 = r2 & 15;	 Catch:{ Exception -> 0x0046 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046 }
        r4.<init>();	 Catch:{ Exception -> 0x0046 }
        r5 = b;	 Catch:{ Exception -> 0x0046 }
        r3 = r5[r3];	 Catch:{ Exception -> 0x0046 }
        r4.append(r3);	 Catch:{ Exception -> 0x0046 }
        r3 = b;	 Catch:{ Exception -> 0x0046 }
        r2 = r3[r2];	 Catch:{ Exception -> 0x0046 }
        r4.append(r2);	 Catch:{ Exception -> 0x0046 }
        r2 = r4.toString();	 Catch:{ Exception -> 0x0046 }
        r0.append(r2);	 Catch:{ Exception -> 0x0046 }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x0046 }
        goto L_0x0014;	 Catch:{ Exception -> 0x0046 }
    L_0x0041:
        r6 = r0.toString();	 Catch:{ Exception -> 0x0046 }
        goto L_0x0047;
    L_0x0046:
        r6 = 0;
    L_0x0047:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.manager.c.a(java.lang.String):java.lang.String");
    }
}
