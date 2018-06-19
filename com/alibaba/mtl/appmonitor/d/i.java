package com.alibaba.mtl.appmonitor.d;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: MonitorPointSampling */
class i extends a<JSONObject> {
    protected List<c> b;
    private String c;

    public i(String str, int i) {
        super(i);
        this.c = str;
    }

    public boolean a(int i, Map<String, String> map) {
        if (!(this.b == null || map == null)) {
            for (c a : this.b) {
                Boolean a2 = a.a(i, map);
                if (a2 != null) {
                    return a2.booleanValue();
                }
            }
        }
        return a(i);
    }

    public void b(org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.a(r5);
        r0 = "extra";	 Catch:{ Exception -> 0x0034 }
        r5 = r5.optJSONArray(r0);	 Catch:{ Exception -> 0x0034 }
        if (r5 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0034 }
    L_0x000b:
        r0 = 0;	 Catch:{ Exception -> 0x0034 }
    L_0x000c:
        r1 = r5.length();	 Catch:{ Exception -> 0x0034 }
        if (r0 >= r1) goto L_0x0033;	 Catch:{ Exception -> 0x0034 }
    L_0x0012:
        r1 = r5.getJSONObject(r0);	 Catch:{ Exception -> 0x0034 }
        r2 = new com.alibaba.mtl.appmonitor.d.c;	 Catch:{ Exception -> 0x0034 }
        r3 = r4.a;	 Catch:{ Exception -> 0x0034 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0034 }
        r3 = r4.b;	 Catch:{ Exception -> 0x0034 }
        if (r3 != 0) goto L_0x0028;	 Catch:{ Exception -> 0x0034 }
    L_0x0021:
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0034 }
        r3.<init>();	 Catch:{ Exception -> 0x0034 }
        r4.b = r3;	 Catch:{ Exception -> 0x0034 }
    L_0x0028:
        r3 = r4.b;	 Catch:{ Exception -> 0x0034 }
        r3.add(r2);	 Catch:{ Exception -> 0x0034 }
        r2.b(r1);	 Catch:{ Exception -> 0x0034 }
        r0 = r0 + 1;
        goto L_0x000c;
    L_0x0033:
        return;
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.i.b(org.json.JSONObject):void");
    }
}
