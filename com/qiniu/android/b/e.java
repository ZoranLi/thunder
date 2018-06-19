package com.qiniu.android.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ZoneInfo */
public final class e {
    private static int c = 600;
    public final List<String> a;
    public final Map<String, Long> b;
    private final int d;

    public e(int i, List<String> list, Map<String, Long> map) {
        this.d = i;
        this.a = list;
        this.b = map;
    }

    public static com.qiniu.android.b.e a(org.json.JSONObject r13) throws org.json.JSONException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "ttl";
        r0 = r13.getInt(r0);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.util.concurrent.ConcurrentHashMap;
        r2.<init>();
        r3 = "up";
        r13 = r13.getJSONObject(r3);
        r3 = 4;
        r4 = new java.lang.String[r3];
        r5 = "acc";
        r6 = 0;
        r4[r6] = r5;
        r5 = "src";
        r7 = 1;
        r4[r7] = r5;
        r5 = "old_acc";
        r7 = 2;
        r4[r7] = r5;
        r5 = "old_src";
        r7 = 3;
        r4[r7] = r5;
        r5 = r6;
    L_0x002e:
        if (r5 >= r3) goto L_0x0079;
    L_0x0030:
        r7 = r4[r5];
        r7 = r13.getJSONObject(r7);
        r8 = "main";
        r8 = r7.getJSONArray(r8);
        r9 = r6;
    L_0x003d:
        r10 = r8.length();
        r11 = 0;
        if (r9 >= r10) goto L_0x0056;
    L_0x0045:
        r10 = r8.getString(r9);
        r1.add(r10);
        r11 = java.lang.Long.valueOf(r11);
        r2.put(r10, r11);
        r9 = r9 + 1;
        goto L_0x003d;
    L_0x0056:
        r8 = "backup";	 Catch:{ JSONException -> 0x0076 }
        r7 = r7.getJSONArray(r8);	 Catch:{ JSONException -> 0x0076 }
        if (r7 == 0) goto L_0x0076;	 Catch:{ JSONException -> 0x0076 }
    L_0x005e:
        r8 = r6;	 Catch:{ JSONException -> 0x0076 }
    L_0x005f:
        r9 = r7.length();	 Catch:{ JSONException -> 0x0076 }
        if (r8 >= r9) goto L_0x0076;	 Catch:{ JSONException -> 0x0076 }
    L_0x0065:
        r9 = r7.getString(r8);	 Catch:{ JSONException -> 0x0076 }
        r1.add(r9);	 Catch:{ JSONException -> 0x0076 }
        r10 = java.lang.Long.valueOf(r11);	 Catch:{ JSONException -> 0x0076 }
        r2.put(r9, r10);	 Catch:{ JSONException -> 0x0076 }
        r8 = r8 + 1;
        goto L_0x005f;
    L_0x0076:
        r5 = r5 + 1;
        goto L_0x002e;
    L_0x0079:
        r13 = new com.qiniu.android.b.e;
        r13.<init>(r0, r1, r2);
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.b.e.a(org.json.JSONObject):com.qiniu.android.b.e");
    }

    public final void a(String str) {
        this.b.put(str, Long.valueOf((System.currentTimeMillis() / 1000) + ((long) c)));
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("ttl", Integer.valueOf(this.d));
        hashMap.put("upDomainList", this.a);
        hashMap.put("upDomainMap", this.b);
        return new JSONObject(hashMap).toString();
    }
}
