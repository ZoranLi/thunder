package com.google.protobuf.micro;

public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public abstract void a(c cVar);

    public void a(byte[] r1, int r2, int r3) {
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
        r0 = this;
        r1 = com.google.protobuf.micro.c.a(r1, r2, r3);	 Catch:{ IOException -> 0x000b }
        r0.a(r1);	 Catch:{ IOException -> 0x000b }
        r1.c();	 Catch:{ IOException -> 0x000b }
        return;
    L_0x000b:
        r1 = new java.lang.RuntimeException;
        r2 = "Serializing to a byte array threw an IOException (should never happen).";
        r1.<init>(r2);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.micro.e.a(byte[], int, int):void");
    }

    protected boolean a(b bVar, int i) {
        return bVar.b(i);
    }

    public abstract int b();

    public com.google.protobuf.micro.e b(byte[] r1, int r2, int r3) {
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
        r0 = this;
        r1 = com.google.protobuf.micro.b.a(r1, r2, r3);	 Catch:{ d -> 0x0014, IOException -> 0x000c }
        r0.a(r1);	 Catch:{ d -> 0x0014, IOException -> 0x000c }
        r2 = 0;	 Catch:{ d -> 0x0014, IOException -> 0x000c }
        r1.a(r2);	 Catch:{ d -> 0x0014, IOException -> 0x000c }
        return r0;
    L_0x000c:
        r1 = new java.lang.RuntimeException;
        r2 = "Reading from a byte array threw an IOException (should never happen).";
        r1.<init>(r2);
        throw r1;
    L_0x0014:
        r1 = move-exception;
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.micro.e.b(byte[], int, int):com.google.protobuf.micro.e");
    }

    public byte[] c() {
        byte[] bArr = new byte[b()];
        a(bArr, 0, bArr.length);
        return bArr;
    }
}
