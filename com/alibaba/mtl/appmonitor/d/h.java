package com.alibaba.mtl.appmonitor.d;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ModuleSampling */
class h extends a<JSONObject> {
    protected Map<String, i> b = new HashMap();
    private String c;

    public h(String str, int i) {
        super(i);
        this.c = str;
    }

    public boolean a(int i, String str, Map<String, String> map) {
        if (this.b != null) {
            i iVar = (i) this.b.get(str);
            if (iVar != null) {
                return iVar.a(i, map);
            }
        }
        return a(i);
    }

    public void b(org.json.JSONObject r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r13.a(r14);
        r0 = "monitorPoints";	 Catch:{ Exception -> 0x0107 }
        r14 = r14.optJSONArray(r0);	 Catch:{ Exception -> 0x0107 }
        if (r14 == 0) goto L_0x0106;	 Catch:{ Exception -> 0x0107 }
    L_0x000b:
        r0 = 0;	 Catch:{ Exception -> 0x0107 }
        r1 = r0;	 Catch:{ Exception -> 0x0107 }
    L_0x000d:
        r2 = r14.length();	 Catch:{ Exception -> 0x0107 }
        if (r1 >= r2) goto L_0x0106;	 Catch:{ Exception -> 0x0107 }
    L_0x0013:
        r2 = r14.getJSONObject(r1);	 Catch:{ Exception -> 0x0107 }
        r3 = "monitorPoint";	 Catch:{ Exception -> 0x0107 }
        r3 = r2.optString(r3);	 Catch:{ Exception -> 0x0107 }
        r4 = "metric_comment_detail";	 Catch:{ Exception -> 0x0107 }
        r4 = r2.optString(r4);	 Catch:{ Exception -> 0x0107 }
        r5 = com.alibaba.mtl.appmonitor.f.b.a(r3);	 Catch:{ Exception -> 0x0107 }
        if (r5 == 0) goto L_0x0102;	 Catch:{ Exception -> 0x0107 }
    L_0x0029:
        r5 = r13.b;	 Catch:{ Exception -> 0x0107 }
        r5 = r5.get(r3);	 Catch:{ Exception -> 0x0107 }
        r5 = (com.alibaba.mtl.appmonitor.d.i) r5;	 Catch:{ Exception -> 0x0107 }
        if (r5 != 0) goto L_0x003f;	 Catch:{ Exception -> 0x0107 }
    L_0x0033:
        r5 = new com.alibaba.mtl.appmonitor.d.i;	 Catch:{ Exception -> 0x0107 }
        r6 = r13.a;	 Catch:{ Exception -> 0x0107 }
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x0107 }
        r6 = r13.b;	 Catch:{ Exception -> 0x0107 }
        r6.put(r3, r5);	 Catch:{ Exception -> 0x0107 }
    L_0x003f:
        r5.b(r2);	 Catch:{ Exception -> 0x0107 }
        r5 = com.alibaba.mtl.appmonitor.model.j.a();	 Catch:{ Exception -> 0x0107 }
        r6 = r13.c;	 Catch:{ Exception -> 0x0107 }
        r5 = r5.a(r6, r3);	 Catch:{ Exception -> 0x0107 }
        if (r5 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0107 }
    L_0x004e:
        r5.a(r4);	 Catch:{ Exception -> 0x0107 }
    L_0x0051:
        r4 = "measures";	 Catch:{ Exception -> 0x0107 }
        r2 = r2.opt(r4);	 Catch:{ Exception -> 0x0107 }
        r4 = r2 instanceof org.json.JSONArray;	 Catch:{ Exception -> 0x0107 }
        if (r4 == 0) goto L_0x0102;	 Catch:{ Exception -> 0x0107 }
    L_0x005b:
        r2 = (org.json.JSONArray) r2;	 Catch:{ Exception -> 0x0107 }
        r4 = com.alibaba.mtl.appmonitor.model.MeasureSet.a();	 Catch:{ Exception -> 0x0107 }
        r5 = r2.length();	 Catch:{ Exception -> 0x0107 }
        r6 = r0;	 Catch:{ Exception -> 0x0107 }
    L_0x0066:
        if (r6 >= r5) goto L_0x009f;	 Catch:{ Exception -> 0x0107 }
    L_0x0068:
        r7 = r2.getJSONObject(r6);	 Catch:{ Exception -> 0x0107 }
        if (r7 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0107 }
    L_0x006e:
        r8 = "name";	 Catch:{ Exception -> 0x0107 }
        r8 = r7.optString(r8);	 Catch:{ Exception -> 0x0107 }
        r9 = "min";	 Catch:{ Exception -> 0x0107 }
        r9 = r7.optDouble(r9);	 Catch:{ Exception -> 0x0107 }
        r9 = java.lang.Double.valueOf(r9);	 Catch:{ Exception -> 0x0107 }
        r10 = "max";	 Catch:{ Exception -> 0x0107 }
        r10 = r7.optDouble(r10);	 Catch:{ Exception -> 0x0107 }
        r7 = java.lang.Double.valueOf(r10);	 Catch:{ Exception -> 0x0107 }
        if (r8 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0107 }
    L_0x008a:
        if (r9 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0107 }
    L_0x008c:
        if (r7 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0107 }
    L_0x008e:
        r10 = new com.alibaba.mtl.appmonitor.model.Measure;	 Catch:{ Exception -> 0x0107 }
        r11 = 0;	 Catch:{ Exception -> 0x0107 }
        r11 = java.lang.Double.valueOf(r11);	 Catch:{ Exception -> 0x0107 }
        r10.<init>(r8, r11, r9, r7);	 Catch:{ Exception -> 0x0107 }
        r4.a(r10);	 Catch:{ Exception -> 0x0107 }
    L_0x009c:
        r6 = r6 + 1;	 Catch:{ Exception -> 0x0107 }
        goto L_0x0066;	 Catch:{ Exception -> 0x0107 }
    L_0x009f:
        r2 = com.alibaba.mtl.appmonitor.model.j.a();	 Catch:{ Exception -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107 }
        r6 = "config_prefix";	 Catch:{ Exception -> 0x0107 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0107 }
        r6 = r13.c;	 Catch:{ Exception -> 0x0107 }
        r5.append(r6);	 Catch:{ Exception -> 0x0107 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0107 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107 }
        r7 = "config_prefix";	 Catch:{ Exception -> 0x0107 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x0107 }
        r6.append(r3);	 Catch:{ Exception -> 0x0107 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0107 }
        r2 = r2.a(r5, r6);	 Catch:{ Exception -> 0x0107 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ Exception -> 0x0107 }
    L_0x00c7:
        r5 = com.alibaba.mtl.appmonitor.model.j.a();	 Catch:{ Exception -> 0x0107 }
        r6 = r5.a;	 Catch:{ Exception -> 0x0107 }
        r6 = r6.contains(r2);	 Catch:{ Exception -> 0x0107 }
        if (r6 == 0) goto L_0x00d8;	 Catch:{ Exception -> 0x0107 }
    L_0x00d3:
        r5 = r5.a;	 Catch:{ Exception -> 0x0107 }
        r5.remove(r2);	 Catch:{ Exception -> 0x0107 }
    L_0x00d8:
        r2 = new com.alibaba.mtl.appmonitor.model.a;	 Catch:{ Exception -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107 }
        r6 = "config_prefix";	 Catch:{ Exception -> 0x0107 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0107 }
        r6 = r13.c;	 Catch:{ Exception -> 0x0107 }
        r5.append(r6);	 Catch:{ Exception -> 0x0107 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0107 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107 }
        r7 = "config_prefix";	 Catch:{ Exception -> 0x0107 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x0107 }
        r6.append(r3);	 Catch:{ Exception -> 0x0107 }
        r3 = r6.toString();	 Catch:{ Exception -> 0x0107 }
        r2.<init>(r5, r3, r4);	 Catch:{ Exception -> 0x0107 }
        r3 = com.alibaba.mtl.appmonitor.model.j.a();	 Catch:{ Exception -> 0x0107 }
        r3.a(r2);	 Catch:{ Exception -> 0x0107 }
    L_0x0102:
        r1 = r1 + 1;
        goto L_0x000d;
    L_0x0106:
        return;
    L_0x0107:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.h.b(org.json.JSONObject):void");
    }
}
