package com.igexin.push.c;

class q implements Runnable {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
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
        r11 = this;
    L_0x0000:
        r0 = r11.a;
        r0 = r0.L;
        if (r0 == 0) goto L_0x01c3;
    L_0x0008:
        r0 = r11.a;
        r0 = r0.e;
        r0 = r0.isInterrupted();
        if (r0 != 0) goto L_0x01c3;
    L_0x0014:
        r0 = 0;
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.h;	 Catch:{ Exception -> 0x0140 }
        r1.lock();	 Catch:{ Exception -> 0x0140 }
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.j;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x0140 }
        if (r1 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0140 }
    L_0x002a:
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.i;	 Catch:{ Exception -> 0x0140 }
        r1.await();	 Catch:{ Exception -> 0x0140 }
    L_0x0033:
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.j;	 Catch:{ Exception -> 0x0140 }
        r1.clear();	 Catch:{ Exception -> 0x0140 }
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.M;	 Catch:{ Exception -> 0x0140 }
        if (r1 == 0) goto L_0x004e;
    L_0x0044:
        r0 = r11.a;	 Catch:{ Exception -> 0x004d }
        r0 = r0.h;	 Catch:{ Exception -> 0x004d }
        r0.unlock();	 Catch:{ Exception -> 0x004d }
    L_0x004d:
        return;
    L_0x004e:
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.f;	 Catch:{ Exception -> 0x0140 }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x0140 }
    L_0x0056:
        r1 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r1 = r1.f;	 Catch:{ Exception -> 0x0140 }
        r2 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r2 = r2.c;	 Catch:{ Exception -> 0x0140 }
        r1.a(r2);	 Catch:{ Exception -> 0x0140 }
    L_0x0065:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0140 }
        r3 = r11.a;	 Catch:{ Exception -> 0x0140 }
        r3 = r3.c;	 Catch:{ Exception -> 0x0140 }
        r3 = r3.a();	 Catch:{ Exception -> 0x0140 }
        r3 = com.igexin.b.a.b.f.a(r3);	 Catch:{ Exception -> 0x0140 }
        r4 = new java.net.Socket;	 Catch:{ Exception -> 0x0140 }
        r4.<init>();	 Catch:{ Exception -> 0x0140 }
        r0 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5 = 1;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r3[r5];	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5 = r5.c;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5 = r5.d();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.<init>(r3, r5);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r4.connect(r0, r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5 = r0.c;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = "socket://";	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r4.getInetAddress();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r3.getHostAddress();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = ":";	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r3.c;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r3 = r3.d();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r3);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r6 = r0.toString();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r7 = r9 - r1;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r5.a(r6, r7, r9);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.<init>();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = com.igexin.push.c.p.b;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = "|detect ";	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r1.z();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = "ok, time: ";	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r1.c;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = r1.e();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = " ######";	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.append(r1);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r0.f;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        if (r0 == 0) goto L_0x0123;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
    L_0x010a:
        r0 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r0.M;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        if (r0 != 0) goto L_0x0123;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
    L_0x0112:
        r0 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0 = r0.f;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r1 = com.igexin.push.c.g.SUCCESS;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r2 = r11.a;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r2 = r2.c;	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
        r0.a(r1, r2);	 Catch:{ Exception -> 0x013b, all -> 0x0137 }
    L_0x0123:
        r0 = r11.a;	 Catch:{ Exception -> 0x012c }
        r0 = r0.h;	 Catch:{ Exception -> 0x012c }
        r0.unlock();	 Catch:{ Exception -> 0x012c }
    L_0x012c:
        r0 = r4.isClosed();
        if (r0 != 0) goto L_0x0000;
    L_0x0132:
        r4.close();	 Catch:{ Exception -> 0x0000 }
        goto L_0x0000;
    L_0x0137:
        r1 = move-exception;
        r0 = r4;
        goto L_0x01ae;
    L_0x013b:
        r1 = move-exception;
        r0 = r4;
        goto L_0x0141;
    L_0x013e:
        r1 = move-exception;
        goto L_0x01ae;
    L_0x0140:
        r1 = move-exception;
    L_0x0141:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013e }
        r2.<init>();	 Catch:{ all -> 0x013e }
        r3 = com.igexin.push.c.p.b;	 Catch:{ all -> 0x013e }
        r2.append(r3);	 Catch:{ all -> 0x013e }
        r3 = "|detect ";	 Catch:{ all -> 0x013e }
        r2.append(r3);	 Catch:{ all -> 0x013e }
        r3 = r11.a;	 Catch:{ all -> 0x013e }
        r3 = r3.z();	 Catch:{ all -> 0x013e }
        r2.append(r3);	 Catch:{ all -> 0x013e }
        r3 = "thread -->";	 Catch:{ all -> 0x013e }
        r2.append(r3);	 Catch:{ all -> 0x013e }
        r1 = r1.toString();	 Catch:{ all -> 0x013e }
        r2.append(r1);	 Catch:{ all -> 0x013e }
        r1 = r2.toString();	 Catch:{ all -> 0x013e }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ all -> 0x013e }
        r1 = r11.a;	 Catch:{ all -> 0x013e }
        r1 = r1.M;	 Catch:{ all -> 0x013e }
        if (r1 != 0) goto L_0x0198;	 Catch:{ all -> 0x013e }
    L_0x0176:
        r1 = r11.a;	 Catch:{ all -> 0x013e }
        r1 = r1.c;	 Catch:{ all -> 0x013e }
        r1.b();	 Catch:{ all -> 0x013e }
        r1 = r11.a;	 Catch:{ all -> 0x013e }
        r1 = r1.f;	 Catch:{ all -> 0x013e }
        if (r1 == 0) goto L_0x0198;	 Catch:{ all -> 0x013e }
    L_0x0187:
        r1 = r11.a;	 Catch:{ all -> 0x013e }
        r1 = r1.f;	 Catch:{ all -> 0x013e }
        r2 = com.igexin.push.c.g.EXCEPTION;	 Catch:{ all -> 0x013e }
        r3 = r11.a;	 Catch:{ all -> 0x013e }
        r3 = r3.c;	 Catch:{ all -> 0x013e }
        r1.a(r2, r3);	 Catch:{ all -> 0x013e }
    L_0x0198:
        r1 = r11.a;	 Catch:{ Exception -> 0x01a1 }
        r1 = r1.h;	 Catch:{ Exception -> 0x01a1 }
        r1.unlock();	 Catch:{ Exception -> 0x01a1 }
    L_0x01a1:
        if (r0 == 0) goto L_0x0000;
    L_0x01a3:
        r1 = r0.isClosed();
        if (r1 != 0) goto L_0x0000;
    L_0x01a9:
        r0.close();	 Catch:{ Exception -> 0x0000 }
        goto L_0x0000;
    L_0x01ae:
        r2 = r11.a;	 Catch:{ Exception -> 0x01b7 }
        r2 = r2.h;	 Catch:{ Exception -> 0x01b7 }
        r2.unlock();	 Catch:{ Exception -> 0x01b7 }
    L_0x01b7:
        if (r0 == 0) goto L_0x01c2;
    L_0x01b9:
        r2 = r0.isClosed();
        if (r2 != 0) goto L_0x01c2;
    L_0x01bf:
        r0.close();	 Catch:{ Exception -> 0x01c2 }
    L_0x01c2:
        throw r1;
    L_0x01c3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.q.run():void");
    }
}
