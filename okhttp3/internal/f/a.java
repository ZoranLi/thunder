package okhttp3.internal.f;

import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;

/* compiled from: PublicSuffixDatabase */
public final class a {
    private static final byte[] a = new byte[]{(byte) 42};
    private static final String[] b = new String[0];
    private static final String[] c = new String[]{"*"};
    private static final a d = new a();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static a a() {
        return d;
    }

    public final String a(String str) {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a = a(split);
        if (split.length == a.length && a[0].charAt(0) != '!') {
            return null;
        }
        int length;
        if (a[0].charAt(0) == '!') {
            length = split.length - a.length;
        } else {
            length = split.length - (a.length + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        str = str.split("\\.");
        for (length = 
/*
Method generation error in method: okhttp3.internal.f.a.a(java.lang.String):java.lang.String
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_7 'length' int) = (r0_4 'length' int), (r0_6 'length' int) binds: {(r0_4 'length' int)=B:11:0x0031, (r0_6 'length' int)=B:12:0x0035} in method: okhttp3.internal.f.a.a(java.lang.String):java.lang.String
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
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
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 22 more

*/

        private java.lang.String[] a(java.lang.String[] r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r8 = this;
            r0 = r8.e;
            r0 = r0.get();
            r1 = 0;
            r2 = 0;
            r3 = 1;
            if (r0 != 0) goto L_0x006a;
        L_0x000b:
            r0 = r8.e;
            r0 = r0.compareAndSet(r1, r3);
            if (r0 == 0) goto L_0x006a;
        L_0x0013:
            r0 = okhttp3.internal.f.a.class;
            r0 = r0.getClassLoader();
            r4 = "publicsuffixes.gz";
            r0 = r0.getResourceAsStream(r4);
            if (r0 == 0) goto L_0x0059;
        L_0x0021:
            r4 = new okio.k;
            r0 = okio.m.a(r0);
            r4.<init>(r0);
            r0 = okio.m.a(r4);
            r4 = r0.f();	 Catch:{ IOException -> 0x0046 }
            r4 = new byte[r4];	 Catch:{ IOException -> 0x0046 }
            r0.a(r4);	 Catch:{ IOException -> 0x0046 }
            r5 = r0.f();	 Catch:{ IOException -> 0x0046 }
            r5 = new byte[r5];	 Catch:{ IOException -> 0x0046 }
            r0.a(r5);	 Catch:{ IOException -> 0x0046 }
            okhttp3.internal.c.a(r0);
            goto L_0x005b;
        L_0x0044:
            r9 = move-exception;
            goto L_0x0055;
        L_0x0046:
            r4 = move-exception;
            r5 = okhttp3.internal.e.e.b();	 Catch:{ all -> 0x0044 }
            r6 = 5;	 Catch:{ all -> 0x0044 }
            r7 = "Failed to read public suffix list";	 Catch:{ all -> 0x0044 }
            r5.a(r6, r7, r4);	 Catch:{ all -> 0x0044 }
            okhttp3.internal.c.a(r0);
            goto L_0x0059;
        L_0x0055:
            okhttp3.internal.c.a(r0);
            throw r9;
        L_0x0059:
            r4 = r2;
            r5 = r4;
        L_0x005b:
            monitor-enter(r8);
            r8.g = r4;	 Catch:{ all -> 0x0067 }
            r8.h = r5;	 Catch:{ all -> 0x0067 }
            monitor-exit(r8);	 Catch:{ all -> 0x0067 }
            r0 = r8.f;
            r0.countDown();
            goto L_0x006f;
        L_0x0067:
            r9 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x0067 }
            throw r9;
        L_0x006a:
            r0 = r8.f;	 Catch:{ InterruptedException -> 0x006f }
            r0.await();	 Catch:{ InterruptedException -> 0x006f }
        L_0x006f:
            monitor-enter(r8);
            r0 = r8.g;	 Catch:{ all -> 0x010e }
            if (r0 != 0) goto L_0x007c;	 Catch:{ all -> 0x010e }
        L_0x0074:
            r9 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010e }
            r0 = "Unable to load publicsuffixes.gz resource from the classpath.";	 Catch:{ all -> 0x010e }
            r9.<init>(r0);	 Catch:{ all -> 0x010e }
            throw r9;	 Catch:{ all -> 0x010e }
        L_0x007c:
            monitor-exit(r8);	 Catch:{ all -> 0x010e }
            r0 = r9.length;
            r0 = new byte[r0][];
            r4 = r1;
        L_0x0081:
            r5 = r9.length;
            if (r4 >= r5) goto L_0x0091;
        L_0x0084:
            r5 = r9[r4];
            r6 = okhttp3.internal.c.e;
            r5 = r5.getBytes(r6);
            r0[r4] = r5;
            r4 = r4 + 1;
            goto L_0x0081;
        L_0x0091:
            r9 = r1;
        L_0x0092:
            r4 = r0.length;
            if (r9 >= r4) goto L_0x00a1;
        L_0x0095:
            r4 = r8.g;
            r4 = a(r4, r0, r9);
            if (r4 == 0) goto L_0x009e;
        L_0x009d:
            goto L_0x00a2;
        L_0x009e:
            r9 = r9 + 1;
            goto L_0x0092;
        L_0x00a1:
            r4 = r2;
        L_0x00a2:
            r9 = r0.length;
            if (r9 <= r3) goto L_0x00c0;
        L_0x00a5:
            r9 = r0.clone();
            r9 = (byte[][]) r9;
            r5 = r1;
        L_0x00ac:
            r6 = r9.length;
            r6 = r6 - r3;
            if (r5 >= r6) goto L_0x00c0;
        L_0x00b0:
            r6 = a;
            r9[r5] = r6;
            r6 = r8.g;
            r6 = a(r6, r9, r5);
            if (r6 == 0) goto L_0x00bd;
        L_0x00bc:
            goto L_0x00c1;
        L_0x00bd:
            r5 = r5 + 1;
            goto L_0x00ac;
        L_0x00c0:
            r6 = r2;
        L_0x00c1:
            if (r6 == 0) goto L_0x00d3;
        L_0x00c3:
            r9 = r0.length;
            r9 = r9 - r3;
            if (r1 >= r9) goto L_0x00d3;
        L_0x00c7:
            r9 = r8.h;
            r9 = a(r9, r0, r1);
            if (r9 == 0) goto L_0x00d0;
        L_0x00cf:
            goto L_0x00d4;
        L_0x00d0:
            r1 = r1 + 1;
            goto L_0x00c3;
        L_0x00d3:
            r9 = r2;
        L_0x00d4:
            if (r9 == 0) goto L_0x00eb;
        L_0x00d6:
            r0 = new java.lang.StringBuilder;
            r1 = "!";
            r0.<init>(r1);
            r0.append(r9);
            r9 = r0.toString();
            r0 = "\\.";
            r9 = r9.split(r0);
            return r9;
        L_0x00eb:
            if (r4 != 0) goto L_0x00f2;
        L_0x00ed:
            if (r6 != 0) goto L_0x00f2;
        L_0x00ef:
            r9 = c;
            return r9;
        L_0x00f2:
            if (r4 == 0) goto L_0x00fb;
        L_0x00f4:
            r9 = "\\.";
            r9 = r4.split(r9);
            goto L_0x00fd;
        L_0x00fb:
            r9 = b;
        L_0x00fd:
            if (r6 == 0) goto L_0x0106;
        L_0x00ff:
            r0 = "\\.";
            r0 = r6.split(r0);
            goto L_0x0108;
        L_0x0106:
            r0 = b;
        L_0x0108:
            r1 = r9.length;
            r2 = r0.length;
            if (r1 <= r2) goto L_0x010d;
        L_0x010c:
            return r9;
        L_0x010d:
            return r0;
        L_0x010e:
            r9 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x010e }
            throw r9;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.f.a.a(java.lang.String[]):java.lang.String[]");
        }

        private static String a(byte[] bArr, byte[][] bArr2, int i) {
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                int i4 = (i2 + length) / 2;
                while (i4 >= 0 && bArr[i4] != (byte) 10) {
                    i4--;
                }
                i4++;
                int i5 = 1;
                while (true) {
                    i3 = i4 + i5;
                    if (bArr[i3] == (byte) 10) {
                        break;
                    }
                    i5++;
                }
                int i6 = i3 - i4;
                int i7 = i;
                i5 = 0;
                int i8 = i5;
                int i9 = i8;
                while (true) {
                    int i10;
                    if (i5 != 0) {
                        i10 = 46;
                        i5 = 0;
                    } else {
                        i10 = bArr2[i7][i8] & 255;
                    }
                    i10 -= bArr[i4 + i9] & 255;
                    if (i10 != 0) {
                        break;
                    }
                    i9++;
                    i8++;
                    if (i9 != i6) {
                        if (bArr2[i7].length == i8) {
                            if (i7 == bArr2.length - 1) {
                                break;
                            }
                            i7++;
                            i8 = -1;
                            i5 = 1;
                        }
                    } else {
                        break;
                    }
                }
                if (i10 < 0) {
                    length = i4 - 1;
                } else if (i10 > 0) {
                    i2 = i3 + 1;
                } else {
                    int i11 = i6 - i9;
                    i5 = bArr2[i7].length - i8;
                    while (true) {
                        i7++;
                        if (i7 >= bArr2.length) {
                            break;
                        }
                        i5 += bArr2[i7].length;
                    }
                    if (i5 < i11) {
                        length = i4 - 1;
                    } else if (i5 <= i11) {
                        return new String(bArr, i4, i6, c.e);
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            return null;
        }
    }
