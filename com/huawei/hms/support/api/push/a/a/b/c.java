package com.huawei.hms.support.api.push.a.a.b;

/* compiled from: Proguard */
public abstract class c {
    private static String a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(java.lang.String r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r6 = "";
        return r6;
    L_0x0009:
        r0 = r6.length();
        r1 = 2;
        if (r0 >= r1) goto L_0x0011;
    L_0x0010:
        return r6;
    L_0x0011:
        r0 = r6.length();	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = r0 * 25;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = (double) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = r0 / r2;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = java.lang.Math.ceil(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = (int) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r1 = r6.length();	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r1 = r1 * 50;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r4 = (double) r1;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r4 = r4 / r2;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r1 = java.lang.Math.ceil(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r1 = (int) r1;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r3 = 0;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r3 = r6.substring(r3, r0);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r3 = 42;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r3 = a(r3, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r0 = r0 + r1;	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r6 = r6.substring(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r2.append(r6);	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        r6 = r2.toString();	 Catch:{ IndexOutOfBoundsException -> 0x0050 }
        return r6;
    L_0x0050:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.push.a.a.b.c.a(java.lang.String):java.lang.String");
    }
}
