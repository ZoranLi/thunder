package mtopsdk.mtop.a;

import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.xstate.a;

public final class e {
    private static d a = d.a();

    public static long a() {
        return b() + (System.currentTimeMillis() / 1000);
    }

    public static void a(String str, String str2) {
        a.a("sid", str);
        a.a("uid", str2);
        mtopsdk.mtop.util.e.a(new f());
        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
            StringBuilder stringBuilder = new StringBuilder("[registerSessionInfo]register sessionInfo succeed");
            stringBuilder.append(",sid=");
            stringBuilder.append(str);
            stringBuilder.append(",uid=");
            stringBuilder.append(str2);
            j.b(stringBuilder.toString());
        }
    }

    private static long b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.xstate.a.c();
        r1 = mtopsdk.common.util.i.a(r0);
        if (r1 == 0) goto L_0x0015;
    L_0x000a:
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x000f }
        return r0;
    L_0x000f:
        r0 = "[getTimeOffset]parse t_offset failed";
        mtopsdk.common.util.j.e(r0);
        goto L_0x001c;
    L_0x0015:
        r0 = "t_offset";
        r1 = "0";
        mtopsdk.xstate.a.a(r0, r1);
    L_0x001c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.a.e.b():long");
    }
}
