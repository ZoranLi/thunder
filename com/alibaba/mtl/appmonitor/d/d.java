package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import java.util.Map;

/* compiled from: AlarmModuleSampling */
public final class d extends h {
    private int c = this.a;
    private int d = this.a;

    public final /* bridge */ /* synthetic */ boolean a(int i, String str, Map map) {
        return super.a(i, str, map);
    }

    public d(String str) {
        super(str, 0);
    }

    public final boolean a(int i, String str, Boolean bool, Map<String, String> map) {
        i.a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.c), "failSampling:", Integer.valueOf(this.d));
        if (this.b != null) {
            i iVar = (i) this.b.get(str);
            if (iVar != null && (iVar instanceof e)) {
                return ((e) iVar).a(i, bool, map);
            }
        }
        return bool.booleanValue() != null ? i < this.c : i < this.d;
    }

    public final void b(org.json.JSONObject r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r6.a(r7);
        r0 = "monitorPoints";	 Catch:{ Exception -> 0x0041 }
        r7 = r7.getJSONArray(r0);	 Catch:{ Exception -> 0x0041 }
        if (r7 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0041 }
    L_0x000b:
        r0 = 0;	 Catch:{ Exception -> 0x0041 }
    L_0x000c:
        r1 = r7.length();	 Catch:{ Exception -> 0x0041 }
        if (r0 >= r1) goto L_0x0040;	 Catch:{ Exception -> 0x0041 }
    L_0x0012:
        r1 = r7.getJSONObject(r0);	 Catch:{ Exception -> 0x0041 }
        r2 = "monitorPoint";	 Catch:{ Exception -> 0x0041 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x0041 }
        r3 = com.alibaba.mtl.appmonitor.f.b.a(r2);	 Catch:{ Exception -> 0x0041 }
        if (r3 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x0041 }
    L_0x0022:
        r3 = r6.b;	 Catch:{ Exception -> 0x0041 }
        r3 = r3.get(r2);	 Catch:{ Exception -> 0x0041 }
        r3 = (com.alibaba.mtl.appmonitor.d.i) r3;	 Catch:{ Exception -> 0x0041 }
        if (r3 != 0) goto L_0x003a;	 Catch:{ Exception -> 0x0041 }
    L_0x002c:
        r3 = new com.alibaba.mtl.appmonitor.d.e;	 Catch:{ Exception -> 0x0041 }
        r4 = r6.c;	 Catch:{ Exception -> 0x0041 }
        r5 = r6.d;	 Catch:{ Exception -> 0x0041 }
        r3.<init>(r2, r4, r5);	 Catch:{ Exception -> 0x0041 }
        r4 = r6.b;	 Catch:{ Exception -> 0x0041 }
        r4.put(r2, r3);	 Catch:{ Exception -> 0x0041 }
    L_0x003a:
        r3.b(r1);	 Catch:{ Exception -> 0x0041 }
    L_0x003d:
        r0 = r0 + 1;
        goto L_0x000c;
    L_0x0040:
        return;
    L_0x0041:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.d.b(org.json.JSONObject):void");
    }

    protected final void a(org.json.JSONObject r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        super.a(r6);
        r0 = r5.a;
        r5.c = r0;
        r0 = r5.a;
        r5.d = r0;
        r0 = "successSampling";	 Catch:{ Exception -> 0x004d }
        r0 = r6.getInt(r0);	 Catch:{ Exception -> 0x004d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x004d }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x004d }
    L_0x0017:
        r1 = r0.intValue();	 Catch:{ Exception -> 0x004d }
        r5.c = r1;	 Catch:{ Exception -> 0x004d }
    L_0x001d:
        r1 = "failSampling";	 Catch:{ Exception -> 0x004d }
        r1 = r6.getInt(r1);	 Catch:{ Exception -> 0x004d }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x004d }
        if (r1 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x004d }
    L_0x0029:
        r1 = r1.intValue();	 Catch:{ Exception -> 0x004d }
        r5.d = r1;	 Catch:{ Exception -> 0x004d }
    L_0x002f:
        r1 = "AlarmModuleSampling";	 Catch:{ Exception -> 0x004d }
        r2 = 5;	 Catch:{ Exception -> 0x004d }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x004d }
        r3 = 0;	 Catch:{ Exception -> 0x004d }
        r4 = "[updateSelfSampling]";	 Catch:{ Exception -> 0x004d }
        r2[r3] = r4;	 Catch:{ Exception -> 0x004d }
        r3 = 1;	 Catch:{ Exception -> 0x004d }
        r2[r3] = r6;	 Catch:{ Exception -> 0x004d }
        r6 = 2;	 Catch:{ Exception -> 0x004d }
        r3 = "successSampling:";	 Catch:{ Exception -> 0x004d }
        r2[r6] = r3;	 Catch:{ Exception -> 0x004d }
        r6 = 3;	 Catch:{ Exception -> 0x004d }
        r2[r6] = r0;	 Catch:{ Exception -> 0x004d }
        r6 = 4;	 Catch:{ Exception -> 0x004d }
        r0 = "failSampling";	 Catch:{ Exception -> 0x004d }
        r2[r6] = r0;	 Catch:{ Exception -> 0x004d }
        com.alibaba.mtl.log.e.i.a(r1, r2);	 Catch:{ Exception -> 0x004d }
        return;
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.d.a(org.json.JSONObject):void");
    }
}
