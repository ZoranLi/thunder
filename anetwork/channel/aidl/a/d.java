package anetwork.channel.aidl.a;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.util.ALog;
import anetwork.channel.aidl.j.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public final class d extends a {
    private static final ByteArray g = ByteArray.create(0);
    public int a;
    public int b = 10000;
    public String c = "";
    public String d = "";
    final ReentrantLock e = new ReentrantLock();
    final Condition f = this.e.newCondition();
    private final AtomicBoolean h = new AtomicBoolean(false);
    private LinkedList<ByteArray> i = new LinkedList();
    private int j;
    private int k;
    private int l = 0;

    public final void a(ByteArray byteArray) {
        if (!this.h.get()) {
            this.e.lock();
            try {
                this.i.add(byteArray);
                this.l += byteArray.getDataLength();
                this.f.signal();
            } finally {
                this.e.unlock();
            }
        }
    }

    public final void e() {
        a(g);
        if (ALog.isPrintLog(1)) {
            ALog.d("anet.ParcelableInputStreamImpl", "set EOS flag to stream", this.d, new Object[0]);
        }
        if (this.a != 0 && this.a != this.l) {
            ALog.e("anet.ParcelableInputStreamImpl", "data length no match!", this.d, "ContentLength", Integer.valueOf(this.a), "Received", Integer.valueOf(this.l), "url", this.c);
        }
    }

    private void f() {
        this.e.lock();
        try {
            ((ByteArray) this.i.set(this.j, g)).recycle();
        } finally {
            this.e.unlock();
        }
    }

    public final int a() throws RemoteException {
        if (this.h.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.e.lock();
        try {
            int i = 0;
            if (this.j == this.i.size()) {
                return i;
            }
            ListIterator listIterator = this.i.listIterator(this.j);
            while (listIterator.hasNext()) {
                i += ((ByteArray) listIterator.next()).getDataLength();
            }
            i -= this.k;
            this.e.unlock();
            return i;
        } finally {
            this.e.unlock();
        }
    }

    public final void b() throws RemoteException {
        if (this.h.compareAndSet(false, true)) {
            this.e.lock();
            try {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ByteArray byteArray = (ByteArray) it.next();
                    if (byteArray != g) {
                        byteArray.recycle();
                    }
                }
                this.i.clear();
                this.i = null;
                this.j = -1;
                this.k = -1;
                this.a = 0;
            } finally {
                this.e.unlock();
            }
        }
    }

    public final int c() throws android.os.RemoteException {
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
        r4 = this;
        r0 = r4.h;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = new java.lang.RuntimeException;
        r1 = "Stream is closed";
        r0.<init>(r1);
        throw r0;
    L_0x0010:
        r0 = r4.e;
        r0.lock();
    L_0x0015:
        r0 = r4.j;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r4.i;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r1.size();	 Catch:{ InterruptedException -> 0x0072 }
        if (r0 != r1) goto L_0x0037;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x001f:
        r0 = r4.f;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r4.b;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = (long) r1;	 Catch:{ InterruptedException -> 0x0072 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0072 }
        r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x0072 }
        if (r0 != 0) goto L_0x0037;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x002c:
        r4.b();	 Catch:{ InterruptedException -> 0x0072 }
        r0 = new java.lang.RuntimeException;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = "await timeout.";	 Catch:{ InterruptedException -> 0x0072 }
        r0.<init>(r1);	 Catch:{ InterruptedException -> 0x0072 }
        throw r0;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x0037:
        r0 = r4.i;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r4.j;	 Catch:{ InterruptedException -> 0x0072 }
        r0 = r0.get(r1);	 Catch:{ InterruptedException -> 0x0072 }
        r0 = (anet.channel.bytes.ByteArray) r0;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = g;	 Catch:{ InterruptedException -> 0x0072 }
        if (r0 != r1) goto L_0x0047;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x0045:
        r0 = -1;	 Catch:{ InterruptedException -> 0x0072 }
        goto L_0x005d;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x0047:
        r1 = r4.k;	 Catch:{ InterruptedException -> 0x0072 }
        r2 = r0.getDataLength();	 Catch:{ InterruptedException -> 0x0072 }
        if (r1 >= r2) goto L_0x0063;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x004f:
        r0 = r0.getBuffer();	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r4.k;	 Catch:{ InterruptedException -> 0x0072 }
        r0 = r0[r1];	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r4.k;	 Catch:{ InterruptedException -> 0x0072 }
        r1 = r1 + 1;	 Catch:{ InterruptedException -> 0x0072 }
        r4.k = r1;	 Catch:{ InterruptedException -> 0x0072 }
    L_0x005d:
        r1 = r4.e;
        r1.unlock();
        return r0;
    L_0x0063:
        r4.f();	 Catch:{ InterruptedException -> 0x0072 }
        r0 = r4.j;	 Catch:{ InterruptedException -> 0x0072 }
        r0 = r0 + 1;	 Catch:{ InterruptedException -> 0x0072 }
        r4.j = r0;	 Catch:{ InterruptedException -> 0x0072 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x0072 }
        r4.k = r0;	 Catch:{ InterruptedException -> 0x0072 }
        goto L_0x0015;
    L_0x0070:
        r0 = move-exception;
        goto L_0x007d;
    L_0x0072:
        r4.b();	 Catch:{ all -> 0x0070 }
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0070 }
        r1 = "await interrupt";	 Catch:{ all -> 0x0070 }
        r0.<init>(r1);	 Catch:{ all -> 0x0070 }
        throw r0;	 Catch:{ all -> 0x0070 }
    L_0x007d:
        r1 = r4.e;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.a.d.c():int");
    }

    public final int a(byte[] r6, int r7, int r8) throws android.os.RemoteException {
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
        r5 = this;
        r0 = r5.h;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r6 = new java.lang.RuntimeException;
        r7 = "Stream is closed";
        r6.<init>(r7);
        throw r6;
    L_0x0010:
        if (r6 != 0) goto L_0x0018;
    L_0x0012:
        r6 = new java.lang.NullPointerException;
        r6.<init>();
        throw r6;
    L_0x0018:
        if (r7 < 0) goto L_0x00aa;
    L_0x001a:
        if (r8 < 0) goto L_0x00aa;
    L_0x001c:
        r8 = r8 + r7;
        r0 = r6.length;
        if (r8 <= r0) goto L_0x0022;
    L_0x0020:
        goto L_0x00aa;
    L_0x0022:
        r0 = r5.e;
        r0.lock();
        r0 = r7;
    L_0x0028:
        if (r0 >= r8) goto L_0x009f;
    L_0x002a:
        r1 = r5.j;	 Catch:{ InterruptedException -> 0x008e }
        r2 = r5.i;	 Catch:{ InterruptedException -> 0x008e }
        r2 = r2.size();	 Catch:{ InterruptedException -> 0x008e }
        if (r1 != r2) goto L_0x004c;	 Catch:{ InterruptedException -> 0x008e }
    L_0x0034:
        r1 = r5.f;	 Catch:{ InterruptedException -> 0x008e }
        r2 = r5.b;	 Catch:{ InterruptedException -> 0x008e }
        r2 = (long) r2;	 Catch:{ InterruptedException -> 0x008e }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x008e }
        r1 = r1.await(r2, r4);	 Catch:{ InterruptedException -> 0x008e }
        if (r1 != 0) goto L_0x004c;	 Catch:{ InterruptedException -> 0x008e }
    L_0x0041:
        r5.b();	 Catch:{ InterruptedException -> 0x008e }
        r6 = new java.lang.RuntimeException;	 Catch:{ InterruptedException -> 0x008e }
        r7 = "await timeout.";	 Catch:{ InterruptedException -> 0x008e }
        r6.<init>(r7);	 Catch:{ InterruptedException -> 0x008e }
        throw r6;	 Catch:{ InterruptedException -> 0x008e }
    L_0x004c:
        r1 = r5.i;	 Catch:{ InterruptedException -> 0x008e }
        r2 = r5.j;	 Catch:{ InterruptedException -> 0x008e }
        r1 = r1.get(r2);	 Catch:{ InterruptedException -> 0x008e }
        r1 = (anet.channel.bytes.ByteArray) r1;	 Catch:{ InterruptedException -> 0x008e }
        r2 = g;	 Catch:{ InterruptedException -> 0x008e }
        if (r1 == r2) goto L_0x009f;	 Catch:{ InterruptedException -> 0x008e }
    L_0x005a:
        r2 = r1.getDataLength();	 Catch:{ InterruptedException -> 0x008e }
        r3 = r5.k;	 Catch:{ InterruptedException -> 0x008e }
        r2 = r2 - r3;	 Catch:{ InterruptedException -> 0x008e }
        r3 = r8 - r0;	 Catch:{ InterruptedException -> 0x008e }
        if (r2 >= r3) goto L_0x007c;	 Catch:{ InterruptedException -> 0x008e }
    L_0x0065:
        r1 = r1.getBuffer();	 Catch:{ InterruptedException -> 0x008e }
        r3 = r5.k;	 Catch:{ InterruptedException -> 0x008e }
        java.lang.System.arraycopy(r1, r3, r6, r0, r2);	 Catch:{ InterruptedException -> 0x008e }
        r0 = r0 + r2;	 Catch:{ InterruptedException -> 0x008e }
        r5.f();	 Catch:{ InterruptedException -> 0x008e }
        r1 = r5.j;	 Catch:{ InterruptedException -> 0x008e }
        r1 = r1 + 1;	 Catch:{ InterruptedException -> 0x008e }
        r5.j = r1;	 Catch:{ InterruptedException -> 0x008e }
        r1 = 0;	 Catch:{ InterruptedException -> 0x008e }
        r5.k = r1;	 Catch:{ InterruptedException -> 0x008e }
        goto L_0x0028;	 Catch:{ InterruptedException -> 0x008e }
    L_0x007c:
        r1 = r1.getBuffer();	 Catch:{ InterruptedException -> 0x008e }
        r2 = r5.k;	 Catch:{ InterruptedException -> 0x008e }
        java.lang.System.arraycopy(r1, r2, r6, r0, r3);	 Catch:{ InterruptedException -> 0x008e }
        r1 = r5.k;	 Catch:{ InterruptedException -> 0x008e }
        r1 = r1 + r3;	 Catch:{ InterruptedException -> 0x008e }
        r5.k = r1;	 Catch:{ InterruptedException -> 0x008e }
        r0 = r0 + r3;
        goto L_0x0028;
    L_0x008c:
        r6 = move-exception;
        goto L_0x0099;
    L_0x008e:
        r5.b();	 Catch:{ all -> 0x008c }
        r6 = new java.lang.RuntimeException;	 Catch:{ all -> 0x008c }
        r7 = "await interrupt";	 Catch:{ all -> 0x008c }
        r6.<init>(r7);	 Catch:{ all -> 0x008c }
        throw r6;	 Catch:{ all -> 0x008c }
    L_0x0099:
        r7 = r5.e;
        r7.unlock();
        throw r6;
    L_0x009f:
        r6 = r5.e;
        r6.unlock();
        r0 = r0 - r7;
        if (r0 <= 0) goto L_0x00a8;
    L_0x00a7:
        return r0;
    L_0x00a8:
        r6 = -1;
        return r6;
    L_0x00aa:
        r6 = new java.lang.ArrayIndexOutOfBoundsException;
        r6.<init>();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.a.d.a(byte[], int, int):int");
    }

    public final int a(byte[] bArr) throws RemoteException {
        return a(bArr, 0, bArr.length);
    }

    public final long a(int i) throws RemoteException {
        this.e.lock();
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.j == this.i.size()) {
                    break;
                }
                ByteArray byteArray = (ByteArray) this.i.get(this.j);
                if (byteArray == g) {
                    break;
                }
                int dataLength = byteArray.getDataLength();
                if (dataLength - this.k < i - i2) {
                    i2 += dataLength - this.k;
                    f();
                    this.j++;
                    this.k = 0;
                    break;
                }
                this.k += i - i;
                i2 = i;
            } catch (Throwable th) {
                this.e.unlock();
            }
        }
        this.e.unlock();
        return (long) i2;
    }

    public final int d() throws RemoteException {
        return this.a;
    }
}
