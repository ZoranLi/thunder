package com.getui.gtc.e;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class k {
    private static void a(InputStream inputStream, String str) {
        OutputStream fileOutputStream = new FileOutputStream(new File(str));
        OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    public static boolean a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
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
        r0 = 1;
        r1 = 0;
        r2 = 0;
        r3 = new java.util.jar.JarFile;	 Catch:{ Throwable -> 0x006f, all -> 0x006b }
        r3.<init>(r9);	 Catch:{ Throwable -> 0x006f, all -> 0x006b }
        r9 = r3.entries();	 Catch:{ Throwable -> 0x0069 }
        r4 = r1;
        r1 = r2;
    L_0x000e:
        r5 = r9.hasMoreElements();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        if (r5 == 0) goto L_0x005b;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
    L_0x0014:
        r5 = r9.nextElement();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r5 = (java.util.jar.JarEntry) r5;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r6 = r5.getName();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7 = r6.contains(r11);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        if (r7 == 0) goto L_0x000e;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
    L_0x0024:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7.<init>();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7.append(r10);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7.append(r6);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r6 = r7.toString();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7 = "/";	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7 = r6.lastIndexOf(r7);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r8 = new java.io.File;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7 = r6.substring(r2, r7);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r8.<init>(r7);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        r7 = r8.exists();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        if (r7 != 0) goto L_0x004b;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
    L_0x0048:
        r8.mkdirs();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
    L_0x004b:
        r7 = r5.isDirectory();	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        if (r7 != 0) goto L_0x000e;	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
    L_0x0051:
        r1 = r3.getInputStream(r5);	 Catch:{ Throwable -> 0x0066, all -> 0x0064 }
        a(r1, r6);	 Catch:{ Throwable -> 0x0069 }
        r4 = r1;
        r1 = r0;
        goto L_0x000e;
    L_0x005b:
        if (r4 == 0) goto L_0x0060;
    L_0x005d:
        r4.close();	 Catch:{ IOException -> 0x0060 }
    L_0x0060:
        r3.close();
        return r1;
    L_0x0064:
        r9 = move-exception;
        goto L_0x0086;
    L_0x0066:
        r9 = move-exception;
        r1 = r4;
        goto L_0x0071;
    L_0x0069:
        r9 = move-exception;
        goto L_0x0071;
    L_0x006b:
        r9 = move-exception;
        r3 = r1;
        r4 = r3;
        goto L_0x0086;
    L_0x006f:
        r9 = move-exception;
        r3 = r1;
    L_0x0071:
        r10 = new java.lang.String[r0];	 Catch:{ all -> 0x0084 }
        r9 = r9.toString();	 Catch:{ all -> 0x0084 }
        r10[r2] = r9;	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x007e;
    L_0x007b:
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x007e:
        if (r3 == 0) goto L_0x0083;
    L_0x0080:
        r3.close();
    L_0x0083:
        return r2;
    L_0x0084:
        r9 = move-exception;
        r4 = r1;
    L_0x0086:
        if (r4 == 0) goto L_0x008b;
    L_0x0088:
        r4.close();	 Catch:{ IOException -> 0x008b }
    L_0x008b:
        if (r3 == 0) goto L_0x0090;
    L_0x008d:
        r3.close();
    L_0x0090:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.e.k.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
