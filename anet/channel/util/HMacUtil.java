package anet.channel.util;

/* compiled from: Taobao */
public class HMacUtil {
    private static final String TAG = "awcn.HMacUtil";

    public static java.lang.String hmacSha1Hex(byte[] r7, byte[] r8) {
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
        r0 = "";
        r1 = 1;
        r2 = 0;
        r3 = 2;
        r4 = 0;
        r7 = hmacSha1(r7, r8);	 Catch:{ Throwable -> 0x001e }
        r7 = anet.channel.util.StringUtils.bytesToHexString(r7);	 Catch:{ Throwable -> 0x001e }
        r8 = "awcn.HMacUtil";	 Catch:{ Throwable -> 0x001f }
        r0 = "hmacSha1Hex";	 Catch:{ Throwable -> 0x001f }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x001f }
        r6 = "result";	 Catch:{ Throwable -> 0x001f }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x001f }
        r5[r1] = r7;	 Catch:{ Throwable -> 0x001f }
        anet.channel.util.ALog.i(r8, r0, r4, r5);	 Catch:{ Throwable -> 0x001f }
        goto L_0x002e;
    L_0x001e:
        r7 = r0;
    L_0x001f:
        r8 = "awcn.HMacUtil";
        r0 = "hmacSha1Hex";
        r3 = new java.lang.Object[r3];
        r5 = "result";
        r3[r2] = r5;
        r3[r1] = r7;
        anet.channel.util.ALog.e(r8, r0, r4, r3);
    L_0x002e:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.HMacUtil.hmacSha1Hex(byte[], byte[]):java.lang.String");
    }

    private static byte[] hmacSha1(byte[] r2, byte[] r3) {
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
        r0 = new javax.crypto.spec.SecretKeySpec;
        r1 = "HmacSHA256";
        r0.<init>(r2, r1);
        r2 = "HmacSHA256";	 Catch:{ NoSuchAlgorithmException -> 0x0015, NoSuchAlgorithmException -> 0x0015 }
        r2 = javax.crypto.Mac.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0015, NoSuchAlgorithmException -> 0x0015 }
        r2.init(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0015, NoSuchAlgorithmException -> 0x0015 }
        r2 = r2.doFinal(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0015, NoSuchAlgorithmException -> 0x0015 }
        goto L_0x0016;
    L_0x0015:
        r2 = 0;
    L_0x0016:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.HMacUtil.hmacSha1(byte[], byte[]):byte[]");
    }
}
