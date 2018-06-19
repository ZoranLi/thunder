package com.alibaba.mtl.log.e;

/* compiled from: RC4 */
public final class n {

    /* compiled from: RC4 */
    private static class a {
        public int[] a;
        public int b;
        public int c;

        private a() {
            this.a = new int[256];
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            str = a(str);
            if (str == null || bArr == null || str == null) {
                return null;
            }
            int i = str.b;
            int i2 = str.c;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                i = (i + 1) % 256;
                i2 = (str.a[i] + i2) % 256;
                int i4 = str.a[i];
                str.a[i] = str.a[i2];
                str.a[i2] = i4;
                i4 = (str.a[i] + str.a[i2]) % 256;
                bArr[i3] = (byte) (str.a[i4] ^ bArr[i3]);
            }
            str.b = i;
            str.c = i2;
            return bArr;
        }
        return null;
    }

    private static com.alibaba.mtl.log.e.n.a a(java.lang.String r9) {
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
        r0 = 0;
        if (r9 == 0) goto L_0x0045;
    L_0x0003:
        r1 = new com.alibaba.mtl.log.e.n$a;
        r2 = 0;
        r1.<init>();
        r3 = r2;
    L_0x000a:
        r4 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r3 >= r4) goto L_0x0015;
    L_0x000e:
        r4 = r1.a;
        r4[r3] = r3;
        r3 = r3 + 1;
        goto L_0x000a;
    L_0x0015:
        r1.b = r2;
        r1.c = r2;
        r3 = r2;
        r5 = r3;
    L_0x001b:
        if (r2 >= r4) goto L_0x0044;
    L_0x001d:
        r6 = r9.charAt(r3);	 Catch:{ Exception -> 0x0043 }
        r7 = r1.a;	 Catch:{ Exception -> 0x0043 }
        r7 = r7[r2];	 Catch:{ Exception -> 0x0043 }
        r6 = r6 + r7;	 Catch:{ Exception -> 0x0043 }
        r6 = r6 + r5;	 Catch:{ Exception -> 0x0043 }
        r5 = r6 % 256;	 Catch:{ Exception -> 0x0043 }
        r6 = r1.a;	 Catch:{ Exception -> 0x0043 }
        r6 = r6[r2];	 Catch:{ Exception -> 0x0043 }
        r7 = r1.a;	 Catch:{ Exception -> 0x0043 }
        r8 = r1.a;	 Catch:{ Exception -> 0x0043 }
        r8 = r8[r5];	 Catch:{ Exception -> 0x0043 }
        r7[r2] = r8;	 Catch:{ Exception -> 0x0043 }
        r7 = r1.a;	 Catch:{ Exception -> 0x0043 }
        r7[r5] = r6;	 Catch:{ Exception -> 0x0043 }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0043 }
        r6 = r9.length();	 Catch:{ Exception -> 0x0043 }
        r3 = r3 % r6;	 Catch:{ Exception -> 0x0043 }
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0043:
        return r0;
    L_0x0044:
        return r1;
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.n.a(java.lang.String):com.alibaba.mtl.log.e.n$a");
    }
}
