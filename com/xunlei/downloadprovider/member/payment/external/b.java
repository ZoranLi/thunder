package com.xunlei.downloadprovider.member.payment.external;

import android.support.v4.view.ViewCompat;

/* compiled from: InsecureSHA1PRNGKeyDerivator */
public final class b {
    private static final int[] a = new int[]{Integer.MIN_VALUE, 8388608, 32768, 128};
    private static final int[] b = new int[]{0, 40, 48, 56};
    private static final int[] c = new int[]{0, 8, 16, 24};
    private static final int[] d = new int[]{0, 24, 16, 8};
    private static final int[] e = new int[]{-1, ViewCompat.MEASURED_SIZE_MASK, 65535, 255};
    private transient int[] f = new int[87];
    private transient long g;
    private transient int[] h;
    private transient byte[] i;
    private transient int j;
    private transient long k;
    private transient int l;

    public static byte[] a(byte[] bArr) {
        b bVar = new b();
        if (bArr == null) {
            throw new NullPointerException("seed == null");
        }
        if (bVar.l == 2) {
            System.arraycopy(bVar.h, 0, bVar.f, 82, 5);
        }
        bVar.l = 1;
        if (bArr.length != 0) {
            a(bVar.f, bArr, bArr.length - 1);
            bVar.g += (long) bArr.length;
        }
        bArr = new byte[32];
        bVar.b(bArr);
        return bArr;
    }

    private b() {
        this.f[82] = 1732584193;
        this.f[83] = -271733879;
        this.f[84] = -1732584194;
        this.f[85] = 271733878;
        this.f[86] = -1009589776;
        this.g = 0;
        this.h = new int[37];
        this.i = new byte[20];
        this.j = 20;
        this.k = 0;
        this.l = 0;
    }

    private synchronized void b(byte[] bArr) {
        b bVar = this;
        Object obj = bArr;
        synchronized (this) {
            int i;
            try {
                int i2 = 81;
                i = bVar.f[81];
                int i3 = 0;
                if (i != 0) {
                    i = (bVar.f[81] + 7) >> 2;
                }
            } finally {
                obj = 
/*
Method generation error in method: com.xunlei.downloadprovider.member.payment.external.b.b(byte[]):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b7: MERGE  (r2_3 'obj' java.lang.Object) = (r0_1 int), (r6_34 'i3' int) in method: com.xunlei.downloadprovider.member.payment.external.b.b(byte[]):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 27 more

*/

                private static void a(int[] iArr) {
                    int i;
                    int i2 = iArr[82];
                    int i3 = iArr[83];
                    int i4 = iArr[84];
                    int i5 = iArr[85];
                    int i6 = iArr[86];
                    for (i = 16; i < 80; i++) {
                        int i7 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                        iArr[i] = (i7 >>> 31) | (i7 << 1);
                    }
                    i = 0;
                    int i8 = i3;
                    i3 = i2;
                    i2 = i8;
                    int i9 = i5;
                    i5 = i4;
                    i4 = i6;
                    i6 = i9;
                    while (true) {
                        int i10 = 20;
                        if (i >= 20) {
                            break;
                        }
                        i4 = ((i4 + iArr[i]) + 1518500249) + (((i3 << 5) | (i3 >>> 27)) + ((i2 & i5) | ((i2 ^ -1) & i6)));
                        i++;
                        i8 = i5;
                        i5 = (i2 >>> 2) | (i2 << 30);
                        i2 = i3;
                        i3 = i4;
                        i4 = i6;
                        i6 = i8;
                    }
                    i8 = i3;
                    i3 = i2;
                    i2 = i8;
                    i9 = i5;
                    i5 = i4;
                    i4 = i6;
                    i6 = i9;
                    while (true) {
                        i = 40;
                        if (i10 >= 40) {
                            break;
                        }
                        i5 = ((i5 + iArr[i10]) + 1859775393) + (((i2 << 5) | (i2 >>> 27)) + ((i3 ^ i6) ^ i4));
                        i10++;
                        i8 = (i3 >>> 2) | (i3 << 30);
                        i3 = i2;
                        i2 = i5;
                        i5 = i4;
                        i4 = i6;
                        i6 = i8;
                    }
                    i8 = i3;
                    i3 = i2;
                    i2 = i8;
                    i9 = i5;
                    i5 = i4;
                    i4 = i6;
                    i6 = i9;
                    while (true) {
                        i10 = 60;
                        if (i >= 60) {
                            break;
                        }
                        i6 = ((i6 + iArr[i]) - 1894007588) + (((i3 << 5) | (i3 >>> 27)) + (((i2 & i4) | (i2 & i5)) | (i4 & i5)));
                        i++;
                        i8 = i4;
                        i4 = (i2 >>> 2) | (i2 << 30);
                        i2 = i3;
                        i3 = i6;
                        i6 = i5;
                        i5 = i8;
                    }
                    i8 = i3;
                    i3 = i2;
                    i2 = i8;
                    i9 = i5;
                    i5 = i4;
                    i4 = i6;
                    i6 = i9;
                    while (i10 < 80) {
                        i4 = ((i4 + iArr[i10]) - 899497514) + (((i2 << 5) | (i2 >>> 27)) + ((i3 ^ i5) ^ i6));
                        i10++;
                        i8 = (i3 >>> 2) | (i3 << 30);
                        i3 = i2;
                        i2 = i4;
                        i4 = i6;
                        i6 = i5;
                        i5 = i8;
                    }
                    iArr[82] = iArr[82] + i2;
                    iArr[83] = iArr[83] + i3;
                    iArr[84] = iArr[84] + i5;
                    iArr[85] = iArr[85] + i6;
                    iArr[86] = iArr[86] + i4;
                }

                private static void a(int[] iArr, byte[] bArr, int i) {
                    int i2 = iArr[81];
                    int i3 = i2 >> 2;
                    int i4 = i2 & 3;
                    iArr[81] = (((i2 + i) - 0) + 1) & 63;
                    if (i4 != 0) {
                        i2 = 0;
                        while (i2 <= i && i4 < 4) {
                            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((3 - i4) << 3));
                            i4++;
                            i2++;
                        }
                        if (i4 == 4) {
                            i3++;
                            if (i3 == 16) {
                                a(iArr);
                                i3 = 0;
                            }
                        }
                        if (i2 > i) {
                            return;
                        }
                    }
                    i2 = 0;
                    i4 = ((i - i2) + 1) >> 2;
                    int i5 = i2;
                    for (i2 = 0; i2 < i4; i2++) {
                        iArr[i3] = ((((bArr[i5] & 255) << 24) | ((bArr[i5 + 1] & 255) << 16)) | ((bArr[i5 + 2] & 255) << 8)) | (bArr[i5 + 3] & 255);
                        i5 += 4;
                        i3++;
                        if (i3 >= 16) {
                            a(iArr);
                            i3 = 0;
                        }
                    }
                    i = (i - i5) + 1;
                    if (i != 0) {
                        i2 = (bArr[i5] & 255) << 24;
                        if (i != 1) {
                            i2 |= (bArr[i5 + 1] & 255) << 16;
                            if (i != 2) {
                                i2 |= (bArr[i5 + 2] & 255) << 8;
                            }
                        }
                        iArr[i3] = i2;
                    }
                }
            }
