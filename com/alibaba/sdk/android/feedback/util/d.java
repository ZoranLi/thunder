package com.alibaba.sdk.android.feedback.util;

class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void run() {
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
        r5 = this;
        r0 = r5.a;
        r1 = com.alibaba.sdk.android.feedback.util.j.b;
        r1 = com.alibaba.sdk.android.feedback.util.c.a(r1);
        r0.a = r1;
        r0 = r5.a;
        r0 = r0.a;
        if (r0 != 0) goto L_0x001b;
    L_0x0013:
        r0 = r5.a;
        r1 = "createAudioFile fail";
        r0.b(r1);
        return;
    L_0x001b:
        r0 = r5.a;
        r0 = r0.c;
        if (r0 == 0) goto L_0x0024;
    L_0x0023:
        return;
    L_0x0024:
        r0 = 0;
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        if (r1 != 0) goto L_0x0037;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
    L_0x002d:
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r2 = new android.media.MediaRecorder;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r2.<init>();	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.b = r2;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
    L_0x0037:
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r2 = 1;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setAudioSource(r2);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = 3;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setOutputFormat(r3);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setAudioEncoder(r2);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setAudioSamplingRate(r3);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = 67000; // 0x105b8 float:9.3887E-41 double:3.31024E-319;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setAudioEncodingBitRate(r3);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = r3.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r3 = r3.getAbsolutePath();	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.setOutputFile(r3);	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r1.b;	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1.prepare();	 Catch:{ IllegalStateException -> 0x011e, IOException -> 0x00f5, RuntimeException -> 0x00cc }
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00a7 }
        r1 = r1.b;	 Catch:{ RuntimeException -> 0x00a7 }
        if (r1 == 0) goto L_0x00a1;	 Catch:{ RuntimeException -> 0x00a7 }
    L_0x008f:
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00a7 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x00a7 }
        r1.d = r3;	 Catch:{ RuntimeException -> 0x00a7 }
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00a7 }
        r1 = r1.b;	 Catch:{ RuntimeException -> 0x00a7 }
        r1.start();	 Catch:{ RuntimeException -> 0x00a7 }
    L_0x00a1:
        r0 = r5.a;
        r0.c = r2;
        return;
    L_0x00a7:
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00c1 }
        r1 = r1.b;	 Catch:{ RuntimeException -> 0x00c1 }
        if (r1 == 0) goto L_0x00c1;	 Catch:{ RuntimeException -> 0x00c1 }
    L_0x00af:
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00c1 }
        r1 = r1.b;	 Catch:{ RuntimeException -> 0x00c1 }
        r1.reset();	 Catch:{ RuntimeException -> 0x00c1 }
        r1 = r5.a;	 Catch:{ RuntimeException -> 0x00c1 }
        r1 = r1.b;	 Catch:{ RuntimeException -> 0x00c1 }
        r1.release();	 Catch:{ RuntimeException -> 0x00c1 }
    L_0x00c1:
        r1 = r5.a;
        r1.b = r0;
        r0 = r5.a;
        r0.g();
        return;
    L_0x00cc:
        r1 = move-exception;
        r2 = r5.a;	 Catch:{ RuntimeException -> 0x00e7 }
        r2 = r2.b;	 Catch:{ RuntimeException -> 0x00e7 }
        if (r2 == 0) goto L_0x00e7;	 Catch:{ RuntimeException -> 0x00e7 }
    L_0x00d5:
        r2 = r5.a;	 Catch:{ RuntimeException -> 0x00e7 }
        r2 = r2.b;	 Catch:{ RuntimeException -> 0x00e7 }
        r2.reset();	 Catch:{ RuntimeException -> 0x00e7 }
        r2 = r5.a;	 Catch:{ RuntimeException -> 0x00e7 }
        r2 = r2.b;	 Catch:{ RuntimeException -> 0x00e7 }
        r2.release();	 Catch:{ RuntimeException -> 0x00e7 }
    L_0x00e7:
        r2 = r5.a;
        r2.b = r0;
        r1.printStackTrace();
        r0 = r5.a;
        r0.g();
        return;
    L_0x00f5:
        r1 = move-exception;
        r2 = r5.a;
        r2 = r2.b;
        if (r2 == 0) goto L_0x0115;
    L_0x00fe:
        r2 = r5.a;
        r2 = r2.b;
        r2.reset();
        r2 = r5.a;
        r2 = r2.b;
        r2.release();
        r2 = r5.a;
        r2.b = r0;
    L_0x0115:
        r1.printStackTrace();
        r0 = r5.a;
        r0.g();
        return;
    L_0x011e:
        r1 = move-exception;
        r2 = r5.a;
        r2 = r2.b;
        if (r2 == 0) goto L_0x013e;
    L_0x0127:
        r2 = r5.a;
        r2 = r2.b;
        r2.reset();
        r2 = r5.a;
        r2 = r2.b;
        r2.release();
        r2 = r5.a;
        r2.b = r0;
    L_0x013e:
        r1.printStackTrace();
        r0 = r5.a;
        r0.g();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.d.run():void");
    }
}
