package com.duiba.maila.sdk.util;

import android.util.Base64;
import java.security.Key;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class h {
    public static String a = "SDKCache";
    public static String b = "9b47ce17ebfcdee6b2244cd031027f405a2a898083d0553bb3b55ba09e43460ac1f4a48a19355d5f827b57e7423ce49f2c96a944d317b66d229264a91d666b233409865d8d7836c1b8268f5105557703edce33ca3415f5639d79448f739c18b9e3908d120082a8e833af3e10b6f69924f51bed95509ef1ba72825cd8254f72cf";

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
        r0 = "SHA-1";	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r6 = r6.getBytes();	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r0.update(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r6 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r0 = new java.lang.StringBuffer;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r0.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r1 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r2 = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
    L_0x0018:
        r3 = r6.length;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        if (r2 >= r3) goto L_0x0033;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
    L_0x001b:
        r3 = r6[r2];	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r3 = r3 & 255;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r4 = r3.length();	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r5 = 2;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        if (r4 >= r5) goto L_0x002d;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
    L_0x002a:
        r0.append(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
    L_0x002d:
        r0.append(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        r2 = r2 + 1;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        goto L_0x0018;	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
    L_0x0033:
        r6 = r0.toString();	 Catch:{ NoSuchAlgorithmException -> 0x0038, Exception -> 0x003c }
        return r6;
    L_0x0038:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x003c:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.util.h.a(java.lang.String):java.lang.String");
    }

    public static String a(Map<String, String> map) {
        TreeMap treeMap = new TreeMap(map);
        map = new StringBuilder();
        for (Entry value : treeMap.entrySet()) {
            String str = (String) value.getValue();
            if (!(str == null || str.length() == 0)) {
                map.append(str);
            }
        }
        return map.toString();
    }

    public static String a(String str, String str2) {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
        str2 = Cipher.getInstance("AES");
        str2.init(1, secretKeySpec);
        return Base64.encodeToString(str2.doFinal(str.getBytes("utf-8")), null);
    }

    public static boolean b(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static String a() {
        char[] cArr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random random = new Random();
        int i = 0;
        while (i < 8) {
            int abs = Math.abs(random.nextInt(26));
            if (abs >= 0 && abs < 26) {
                stringBuffer.append(cArr[abs]);
                i++;
            }
        }
        return stringBuffer.toString();
    }
}
