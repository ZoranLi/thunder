package com.huawei.hms.c;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IOUtils */
public final class c {
    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(java.io.Closeable r1) {
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
        if (r1 == 0) goto L_0x000d;
    L_0x0002:
        r1.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        r1 = "IOUtils";
        r0 = "An exception occurred while closing the 'Closeable' object.";
        com.huawei.hms.support.log.a.d(r1, r0);
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.c.a(java.io.Closeable):void");
    }

    public static InputStream a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }
}
