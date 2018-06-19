package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import java.util.Map;

/* compiled from: AlarmMonitorPointSampling */
public final class e extends i {
    private int c;
    private int d;

    public final /* bridge */ /* synthetic */ boolean a(int i, Map map) {
        return super.a(i, map);
    }

    public e(String str, int i, int i2) {
        super(str, 0);
        this.c = i;
        this.d = i2;
    }

    public final boolean a(int i, Boolean bool, Map<String, String> map) {
        i.a("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.c), "failSampling:", Integer.valueOf(this.d));
        if (!(this.b == null || map == null)) {
            for (c a : this.b) {
                Boolean a2 = a.a(i, map);
                if (a2 != null) {
                    return a2.booleanValue();
                }
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
        super.b(r7);
        r0 = r6.a;
        r6.c = r0;
        r0 = r6.a;
        r6.d = r0;
        r0 = "successSampling";	 Catch:{ Exception -> 0x0050 }
        r0 = r7.getInt(r0);	 Catch:{ Exception -> 0x0050 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0050 }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x0050 }
    L_0x0017:
        r1 = r0.intValue();	 Catch:{ Exception -> 0x0050 }
        r6.c = r1;	 Catch:{ Exception -> 0x0050 }
    L_0x001d:
        r1 = "failSampling";	 Catch:{ Exception -> 0x0050 }
        r1 = r7.getInt(r1);	 Catch:{ Exception -> 0x0050 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0050 }
        if (r1 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0050 }
    L_0x0029:
        r2 = r1.intValue();	 Catch:{ Exception -> 0x0050 }
        r6.d = r2;	 Catch:{ Exception -> 0x0050 }
    L_0x002f:
        r2 = "AlarmMonitorPointSampling";	 Catch:{ Exception -> 0x0050 }
        r3 = 6;	 Catch:{ Exception -> 0x0050 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0050 }
        r4 = 0;	 Catch:{ Exception -> 0x0050 }
        r5 = "[updateSelfSampling]";	 Catch:{ Exception -> 0x0050 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0050 }
        r4 = 1;	 Catch:{ Exception -> 0x0050 }
        r3[r4] = r7;	 Catch:{ Exception -> 0x0050 }
        r7 = 2;	 Catch:{ Exception -> 0x0050 }
        r4 = "successSampling:";	 Catch:{ Exception -> 0x0050 }
        r3[r7] = r4;	 Catch:{ Exception -> 0x0050 }
        r7 = 3;	 Catch:{ Exception -> 0x0050 }
        r3[r7] = r0;	 Catch:{ Exception -> 0x0050 }
        r7 = 4;	 Catch:{ Exception -> 0x0050 }
        r0 = "failSampling";	 Catch:{ Exception -> 0x0050 }
        r3[r7] = r0;	 Catch:{ Exception -> 0x0050 }
        r7 = 5;	 Catch:{ Exception -> 0x0050 }
        r3[r7] = r1;	 Catch:{ Exception -> 0x0050 }
        com.alibaba.mtl.log.e.i.a(r2, r3);	 Catch:{ Exception -> 0x0050 }
        return;
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.e.b(org.json.JSONObject):void");
    }
}
