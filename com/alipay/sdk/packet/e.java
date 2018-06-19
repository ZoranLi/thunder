package com.alipay.sdk.packet;

import com.alipay.sdk.encrypt.d;
import com.alipay.sdk.util.k;
import java.util.Locale;

public final class e {
    private boolean a;
    private String b = k.c();

    public e(boolean z) {
        this.a = z;
    }

    public final com.alipay.sdk.packet.c a(com.alipay.sdk.packet.b r7, boolean r8) {
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
        r6 = this;
        r0 = r7.a;
        r0 = r0.getBytes();
        r7 = r7.b;
        r7 = r7.getBytes();
        r1 = 0;
        if (r8 == 0) goto L_0x0016;
    L_0x000f:
        r2 = com.alipay.sdk.encrypt.c.a(r7);	 Catch:{ Exception -> 0x0015 }
        r7 = r2;
        goto L_0x0016;
    L_0x0015:
        r8 = r1;
    L_0x0016:
        r2 = r6.a;
        r3 = 2;
        r4 = 1;
        if (r2 == 0) goto L_0x0038;
    L_0x001c:
        r2 = r6.b;
        r5 = com.alipay.sdk.cons.a.b;
        r2 = com.alipay.sdk.encrypt.d.a(r2, r5);
        r5 = r6.b;
        r7 = com.alipay.sdk.encrypt.e.a(r5, r7);
        r5 = 3;
        r5 = new byte[r5][];
        r5[r1] = r0;
        r5[r4] = r2;
        r5[r3] = r7;
        r7 = a(r5);
        goto L_0x0042;
    L_0x0038:
        r2 = new byte[r3][];
        r2[r1] = r0;
        r2[r4] = r7;
        r7 = a(r2);
    L_0x0042:
        r0 = new com.alipay.sdk.packet.c;
        r0.<init>(r8, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.e.a(com.alipay.sdk.packet.b, boolean):com.alipay.sdk.packet.c");
    }

    public final com.alipay.sdk.packet.b a(com.alipay.sdk.packet.c r6) {
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
        r5 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x005f, all -> 0x0057 }
        r2 = r6.b;	 Catch:{ Exception -> 0x005f, all -> 0x0057 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x005f, all -> 0x0057 }
        r2 = 5;
        r3 = new byte[r2];	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r1.read(r3);	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r3 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r1.read(r3);	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0055, all -> 0x0053 }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r1.read(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r2 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        if (r2 <= 0) goto L_0x004e;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
    L_0x0031:
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r1.read(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r3 = r5.a;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        if (r3 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
    L_0x003a:
        r3 = r5.b;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r2 = com.alipay.sdk.encrypt.e.b(r3, r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
    L_0x0040:
        r6 = r6.a;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        if (r6 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
    L_0x0044:
        r2 = com.alipay.sdk.encrypt.c.b(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
    L_0x0048:
        r6 = new java.lang.String;	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0061, all -> 0x0053 }
        goto L_0x004f;
    L_0x004e:
        r6 = r0;
    L_0x004f:
        r1.close();	 Catch:{ Exception -> 0x0067 }
        goto L_0x0067;
    L_0x0053:
        r6 = move-exception;
        goto L_0x0059;
    L_0x0055:
        r4 = r0;
        goto L_0x0061;
    L_0x0057:
        r6 = move-exception;
        r1 = r0;
    L_0x0059:
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.close();	 Catch:{ Exception -> 0x005e }
    L_0x005e:
        throw r6;
    L_0x005f:
        r1 = r0;
        r4 = r1;
    L_0x0061:
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();	 Catch:{ Exception -> 0x0066 }
    L_0x0066:
        r6 = r0;
    L_0x0067:
        if (r4 != 0) goto L_0x006c;
    L_0x0069:
        if (r6 != 0) goto L_0x006c;
    L_0x006b:
        return r0;
    L_0x006c:
        r0 = new com.alipay.sdk.packet.b;
        r0.<init>(r4, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.e.a(com.alipay.sdk.packet.c):com.alipay.sdk.packet.b");
    }

    private static byte[] a(String str, String str2) {
        return d.a(str, str2);
    }

    private static byte[] a(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.a(str, bArr);
    }

    private static byte[] b(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.b(str, bArr);
    }

    private static byte[] a(byte[]... r9) {
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
        r0 = 0;
        r1 = r9.length;
        if (r1 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x005c, all -> 0x004e }
        r1.<init>();	 Catch:{ Exception -> 0x005c, all -> 0x004e }
        r2 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x004c, all -> 0x0049 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x004c, all -> 0x0049 }
        r3 = 0;
        r4 = r3;
    L_0x0011:
        r5 = r9.length;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        if (r4 >= r5) goto L_0x0039;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
    L_0x0014:
        r5 = r9[r4];	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r5 = r5.length;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r6 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r7 = "%05d";	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r8 = 1;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r8[r3] = r5;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r5 = java.lang.String.format(r6, r7, r8);	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r5 = r5.getBytes();	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r2.write(r5);	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r5 = r9[r4];	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r2.write(r5);	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        goto L_0x0011;	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
    L_0x0039:
        r2.flush();	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r9 = r1.toByteArray();	 Catch:{ Exception -> 0x005e, all -> 0x0047 }
        r1.close();	 Catch:{ Exception -> 0x0043 }
    L_0x0043:
        r2.close();	 Catch:{ Exception -> 0x0069 }
        goto L_0x0069;
    L_0x0047:
        r9 = move-exception;
        goto L_0x0051;
    L_0x0049:
        r9 = move-exception;
        r2 = r0;
        goto L_0x0051;
    L_0x004c:
        r2 = r0;
        goto L_0x005e;
    L_0x004e:
        r9 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0051:
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0056:
        if (r2 == 0) goto L_0x005b;
    L_0x0058:
        r2.close();	 Catch:{ Exception -> 0x005b }
    L_0x005b:
        throw r9;
    L_0x005c:
        r1 = r0;
        r2 = r1;
    L_0x005e:
        if (r1 == 0) goto L_0x0063;
    L_0x0060:
        r1.close();	 Catch:{ Exception -> 0x0063 }
    L_0x0063:
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r2.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        r9 = r0;
    L_0x0069:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.e.a(byte[][]):byte[]");
    }

    private static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", new Object[]{Integer.valueOf(i)});
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }
}
