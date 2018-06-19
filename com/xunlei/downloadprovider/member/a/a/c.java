package com.xunlei.downloadprovider.member.a.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HighSpeedDatapool */
public final class c {
    static Map<String, String> a = new HashMap();
    static Map<String, String> b;

    static {
        Map hashMap = new HashMap();
        b = hashMap;
        hashMap.put("before_trial-button", "加速试用");
        b.put("before_trial-text", "免费试用会员加速特权,更快完成下载");
        b.put("on_trial-button", "开通会员");
        b.put("on_trial-text", "会员加速:还剩%s,会员不限量");
        b.put("after_trial-button", "开通会员");
        b.put("after_trial-text", "试用结束,会员%s内下完");
        b.put("netspeed", "400");
        b.put("ending_trial-button", "开通会员");
        b.put("ending_trial-text", "试用将结束,会员%s内下完");
    }

    protected static void a(java.lang.String r6, java.lang.String r7) throws org.json.JSONException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>(r7);
        r7 = r0.keys();
    L_0x0009:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x008f;
    L_0x000f:
        r1 = r7.next();
        r1 = (java.lang.String) r1;
        r2 = r0.get(r1);
        r2 = r2.toString();
        r3 = new java.lang.StringBuilder;
        r4 = "key:";
        r3.<init>(r4);
        r3.append(r1);
        r4 = "--";
        r3.append(r4);
        r3.append(r2);
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0056 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0056 }
        r3 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x0056 }
        if (r3 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0056 }
    L_0x003a:
        a(r1, r2);	 Catch:{ Exception -> 0x0056 }
        goto L_0x0009;	 Catch:{ Exception -> 0x0056 }
    L_0x003e:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0056 }
        r3.<init>();	 Catch:{ Exception -> 0x0056 }
        r3.append(r6);	 Catch:{ Exception -> 0x0056 }
        r4 = "-";	 Catch:{ Exception -> 0x0056 }
        r3.append(r4);	 Catch:{ Exception -> 0x0056 }
        r3.append(r1);	 Catch:{ Exception -> 0x0056 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0056 }
        a(r3, r2);	 Catch:{ Exception -> 0x0056 }
        goto L_0x0009;
    L_0x0056:
        r3 = new java.lang.StringBuilder;
        r4 = "really value,not a json string,key=";
        r3.<init>(r4);
        r3.append(r6);
        r4 = "-";
        r3.append(r4);
        r3.append(r1);
        r3 = android.text.TextUtils.isEmpty(r6);
        if (r3 == 0) goto L_0x0074;
    L_0x006e:
        r3 = a;
        r3.put(r1, r2);
        goto L_0x0009;
    L_0x0074:
        r3 = a;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r6);
        r5 = "-";
        r4.append(r5);
        r4.append(r1);
        r1 = r4.toString();
        r3.put(r1, r2);
        goto L_0x0009;
    L_0x008f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.a.a.c.a(java.lang.String, java.lang.String):void");
    }

    protected static void a() {
        for (String str : a.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("==");
            stringBuilder.append((String) a.get(str));
        }
    }

    protected static boolean b() {
        return a.isEmpty();
    }

    protected static String a(String str) {
        String str2 = "";
        if (a.containsKey(str)) {
            return (String) a.get(str);
        }
        return b.containsKey(str) ? (String) b.get(str) : str2;
    }
}
