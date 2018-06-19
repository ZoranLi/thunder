package com.alipay.b.a.a.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public final class a {
    public static java.io.File a() {
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
        r1 = android.os.Environment.class;	 Catch:{ Exception -> 0x001e }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x001e }
        r3 = "Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5";	 Catch:{ Exception -> 0x001e }
        r3 = com.alipay.b.a.a.a.a.a.a(r3);	 Catch:{ Exception -> 0x001e }
        r2.<init>(r3);	 Catch:{ Exception -> 0x001e }
        r3 = 0;	 Catch:{ Exception -> 0x001e }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x001e }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x001e }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x001e }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x001e }
        r1 = (java.io.File) r1;	 Catch:{ Exception -> 0x001e }
        return r1;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.a():java.io.File");
    }

    public static String a(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String a(Map<String, String> map, String str, String str2) {
        if (map == null) {
            return str2;
        }
        String str3 = (String) map.get(str);
        return str3 == null ? str2 : str3;
    }

    public static boolean a(String str) {
        if (str != null) {
            int length = str.length();
            if (length == 0) {
                return true;
            }
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static java.lang.String b(java.lang.String r7, java.lang.String r8) {
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
        r0 = "android.os.SystemProperties";	 Catch:{ Exception -> 0x0027 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0027 }
        r1 = "get";	 Catch:{ Exception -> 0x0027 }
        r2 = 2;	 Catch:{ Exception -> 0x0027 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r5 = 0;	 Catch:{ Exception -> 0x0027 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r6 = 1;	 Catch:{ Exception -> 0x0027 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0027 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0027 }
        r1 = 0;	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0027 }
        r2[r5] = r7;	 Catch:{ Exception -> 0x0027 }
        r2[r6] = r8;	 Catch:{ Exception -> 0x0027 }
        r7 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0027 }
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x0027 }
        return r7;
    L_0x0027:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }

    public static java.lang.String d(java.lang.String r7) {
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
        r1 = a(r7);	 Catch:{ Exception -> 0x0041 }
        if (r1 == 0) goto L_0x0008;	 Catch:{ Exception -> 0x0041 }
    L_0x0007:
        return r0;	 Catch:{ Exception -> 0x0041 }
    L_0x0008:
        r1 = "SHA-1";	 Catch:{ Exception -> 0x0041 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0041 }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x0041 }
        r7 = r7.getBytes(r2);	 Catch:{ Exception -> 0x0041 }
        r1.update(r7);	 Catch:{ Exception -> 0x0041 }
        r7 = r1.digest();	 Catch:{ Exception -> 0x0041 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0041 }
        r1.<init>();	 Catch:{ Exception -> 0x0041 }
        r2 = 0;	 Catch:{ Exception -> 0x0041 }
        r3 = r2;	 Catch:{ Exception -> 0x0041 }
    L_0x0022:
        r4 = r7.length;	 Catch:{ Exception -> 0x0041 }
        if (r3 >= r4) goto L_0x003c;	 Catch:{ Exception -> 0x0041 }
    L_0x0025:
        r4 = "%02x";	 Catch:{ Exception -> 0x0041 }
        r5 = 1;	 Catch:{ Exception -> 0x0041 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0041 }
        r6 = r7[r3];	 Catch:{ Exception -> 0x0041 }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Exception -> 0x0041 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0041 }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x0041 }
        r1.append(r4);	 Catch:{ Exception -> 0x0041 }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0041 }
        goto L_0x0022;	 Catch:{ Exception -> 0x0041 }
    L_0x003c:
        r7 = r1.toString();	 Catch:{ Exception -> 0x0041 }
        return r7;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.d(java.lang.String):java.lang.String");
    }

    public static java.lang.String e(java.lang.String r5) {
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
        r0 = 4;
        r1 = java.nio.ByteBuffer.allocate(r0);	 Catch:{ Exception -> 0x0053 }
        r2 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ Exception -> 0x0053 }
        r1 = r1.order(r2);	 Catch:{ Exception -> 0x0053 }
        r2 = r5.length();	 Catch:{ Exception -> 0x0053 }
        r1 = r1.putInt(r2);	 Catch:{ Exception -> 0x0053 }
        r1 = r1.array();	 Catch:{ Exception -> 0x0053 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0053 }
        r3 = r5.length();	 Catch:{ Exception -> 0x0053 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0053 }
        r3 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x0053 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0053 }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x0053 }
        r5 = r5.getBytes(r4);	 Catch:{ Exception -> 0x0053 }
        r3.write(r5);	 Catch:{ Exception -> 0x0053 }
        r3.close();	 Catch:{ Exception -> 0x0053 }
        r2.close();	 Catch:{ Exception -> 0x0053 }
        r5 = r2.toByteArray();	 Catch:{ Exception -> 0x0053 }
        r5 = r5.length;	 Catch:{ Exception -> 0x0053 }
        r5 = r5 + r0;	 Catch:{ Exception -> 0x0053 }
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0053 }
        r3 = 0;	 Catch:{ Exception -> 0x0053 }
        java.lang.System.arraycopy(r1, r3, r5, r3, r0);	 Catch:{ Exception -> 0x0053 }
        r1 = r2.toByteArray();	 Catch:{ Exception -> 0x0053 }
        r2 = r2.toByteArray();	 Catch:{ Exception -> 0x0053 }
        r2 = r2.length;	 Catch:{ Exception -> 0x0053 }
        java.lang.System.arraycopy(r1, r3, r5, r0, r2);	 Catch:{ Exception -> 0x0053 }
        r0 = 8;	 Catch:{ Exception -> 0x0053 }
        r5 = android.util.Base64.encodeToString(r5, r0);	 Catch:{ Exception -> 0x0053 }
        return r5;
    L_0x0053:
        r5 = "";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.e(java.lang.String):java.lang.String");
    }

    public static java.lang.String f(java.lang.String r8) {
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
        r0 = "";
        r1 = a(r8);
        if (r1 == 0) goto L_0x000b;
    L_0x0008:
        r8 = "";
        return r8;
    L_0x000b:
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x004e }
        r2 = "utf-8";	 Catch:{ Exception -> 0x004e }
        r8 = r8.getBytes(r2);	 Catch:{ Exception -> 0x004e }
        r1.<init>(r8);	 Catch:{ Exception -> 0x004e }
        r8 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004e }
        r8.<init>();	 Catch:{ Exception -> 0x004e }
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x004e }
        r2.<init>(r8);	 Catch:{ Exception -> 0x004e }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x004e }
        r4 = new byte[r3];	 Catch:{ Exception -> 0x004e }
    L_0x0024:
        r5 = 0;	 Catch:{ Exception -> 0x004e }
        r6 = r1.read(r4, r5, r3);	 Catch:{ Exception -> 0x004e }
        r7 = -1;	 Catch:{ Exception -> 0x004e }
        if (r6 == r7) goto L_0x0030;	 Catch:{ Exception -> 0x004e }
    L_0x002c:
        r2.write(r4, r5, r6);	 Catch:{ Exception -> 0x004e }
        goto L_0x0024;	 Catch:{ Exception -> 0x004e }
    L_0x0030:
        r2.flush();	 Catch:{ Exception -> 0x004e }
        r2.close();	 Catch:{ Exception -> 0x004e }
        r2 = r8.toByteArray();	 Catch:{ Exception -> 0x004e }
        r8.flush();	 Catch:{ Exception -> 0x004e }
        r8.close();	 Catch:{ Exception -> 0x004e }
        r1.close();	 Catch:{ Exception -> 0x004e }
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x004e }
        r1 = 2;	 Catch:{ Exception -> 0x004e }
        r1 = android.util.Base64.encode(r2, r1);	 Catch:{ Exception -> 0x004e }
        r8.<init>(r1);	 Catch:{ Exception -> 0x004e }
        return r8;
    L_0x004e:
        r8 = r0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.f(java.lang.String):java.lang.String");
    }
}
