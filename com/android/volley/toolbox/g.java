package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ByteArrayPool */
public final class g {
    protected static final Comparator<byte[]> a = new h();
    private final List<byte[]> b = new LinkedList();
    private final List<byte[]> c = new ArrayList(64);
    private int d = 0;
    private final int e = 4096;

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            byte[] bArr = (byte[]) this.c.get(i2);
            if (bArr.length >= i) {
                this.d -= bArr.length;
                this.c.remove(i2);
                this.b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x002e;
    L_0x0003:
        r0 = r3.length;	 Catch:{ all -> 0x002b }
        r1 = r2.e;	 Catch:{ all -> 0x002b }
        if (r0 <= r1) goto L_0x0009;
    L_0x0008:
        goto L_0x002e;
    L_0x0009:
        r0 = r2.b;	 Catch:{ all -> 0x002b }
        r0.add(r3);	 Catch:{ all -> 0x002b }
        r0 = r2.c;	 Catch:{ all -> 0x002b }
        r1 = a;	 Catch:{ all -> 0x002b }
        r0 = java.util.Collections.binarySearch(r0, r3, r1);	 Catch:{ all -> 0x002b }
        if (r0 >= 0) goto L_0x001b;
    L_0x0018:
        r0 = -r0;
        r0 = r0 + -1;
    L_0x001b:
        r1 = r2.c;	 Catch:{ all -> 0x002b }
        r1.add(r0, r3);	 Catch:{ all -> 0x002b }
        r0 = r2.d;	 Catch:{ all -> 0x002b }
        r3 = r3.length;	 Catch:{ all -> 0x002b }
        r0 = r0 + r3;
        r2.d = r0;	 Catch:{ all -> 0x002b }
        r2.a();	 Catch:{ all -> 0x002b }
        monitor-exit(r2);
        return;
    L_0x002b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x002e:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.g.a(byte[]):void");
    }

    private synchronized void a() {
        while (this.d > this.e) {
            byte[] bArr = (byte[]) this.b.remove(0);
            this.c.remove(bArr);
            this.d -= bArr.length;
        }
    }
}
