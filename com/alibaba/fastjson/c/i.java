package com.alibaba.fastjson.c;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ServiceLoader */
public final class i {
    private static final Set<String> a = new HashSet();

    public static <T> java.util.Set<T> a(java.lang.Class<T> r5, java.lang.ClassLoader r6) {
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
        if (r6 != 0) goto L_0x0007;
    L_0x0002:
        r5 = java.util.Collections.emptySet();
        return r5;
    L_0x0007:
        r0 = new java.util.HashSet;
        r0.<init>();
        r5 = r5.getName();
        r1 = new java.lang.StringBuilder;
        r2 = "META-INF/services/";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        r1 = new java.util.HashSet;
        r1.<init>();
        r5 = r6.getResources(r5);	 Catch:{ IOException -> 0x004c }
    L_0x0027:
        r2 = r5.hasMoreElements();	 Catch:{ IOException -> 0x004c }
        if (r2 == 0) goto L_0x004c;	 Catch:{ IOException -> 0x004c }
    L_0x002d:
        r2 = r5.nextElement();	 Catch:{ IOException -> 0x004c }
        r2 = (java.net.URL) r2;	 Catch:{ IOException -> 0x004c }
        r3 = a;	 Catch:{ IOException -> 0x004c }
        r4 = r2.toString();	 Catch:{ IOException -> 0x004c }
        r3 = r3.contains(r4);	 Catch:{ IOException -> 0x004c }
        if (r3 != 0) goto L_0x0027;	 Catch:{ IOException -> 0x004c }
    L_0x003f:
        a(r2, r1);	 Catch:{ IOException -> 0x004c }
        r3 = a;	 Catch:{ IOException -> 0x004c }
        r2 = r2.toString();	 Catch:{ IOException -> 0x004c }
        r3.add(r2);	 Catch:{ IOException -> 0x004c }
        goto L_0x0027;
    L_0x004c:
        r5 = r1.iterator();
    L_0x0050:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0068;
    L_0x0056:
        r1 = r5.next();
        r1 = (java.lang.String) r1;
        r1 = r6.loadClass(r1);	 Catch:{ Exception -> 0x0050 }
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0050 }
        r0.add(r1);	 Catch:{ Exception -> 0x0050 }
        goto L_0x0050;
    L_0x0068:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.i.a(java.lang.Class, java.lang.ClassLoader):java.util.Set<T>");
    }

    private static void a(URL url, Set<String> set) throws IOException {
        Closeable closeable = null;
        Closeable openStream;
        try {
            openStream = url.openStream();
            try {
                Closeable bufferedReader = new BufferedReader(new InputStreamReader(openStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            int indexOf = readLine.indexOf(35);
                            if (indexOf >= 0) {
                                readLine = readLine.substring(0, indexOf);
                            }
                            readLine = readLine.trim();
                            if (readLine.length() != 0) {
                                set.add(readLine);
                            }
                        } else {
                            e.a(bufferedReader);
                            e.a(openStream);
                            return;
                        }
                    } catch (Throwable th) {
                        set = th;
                        closeable = bufferedReader;
                    }
                }
            } catch (Throwable th2) {
                set = th2;
                e.a(closeable);
                e.a(openStream);
                throw set;
            }
        } catch (Throwable th3) {
            set = th3;
            openStream = null;
            e.a(closeable);
            e.a(openStream);
            throw set;
        }
    }
}
