package anet.channel.bytes;

import java.util.Random;
import java.util.TreeSet;

/* compiled from: Taobao */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";
    private final TreeSet<ByteArray> a = new TreeSet();
    private final ByteArray b = ByteArray.create(0);
    private final Random c = new Random();
    private long d = 0;
    private long e = 0;

    /* compiled from: Taobao */
    static class a {
        public static a a = new a();

        a() {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(anet.channel.bytes.ByteArray r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        if (r8 == 0) goto L_0x0078;
    L_0x0003:
        r0 = r8.bufferLength;	 Catch:{ all -> 0x0075 }
        r1 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        if (r0 < r1) goto L_0x000a;
    L_0x0009:
        goto L_0x0078;
    L_0x000a:
        r0 = r7.d;	 Catch:{ all -> 0x0075 }
        r2 = r8.bufferLength;	 Catch:{ all -> 0x0075 }
        r2 = (long) r2;	 Catch:{ all -> 0x0075 }
        r4 = r0 + r2;
        r7.d = r4;	 Catch:{ all -> 0x0075 }
        r0 = r7.a;	 Catch:{ all -> 0x0075 }
        r0.add(r8);	 Catch:{ all -> 0x0075 }
    L_0x0018:
        r0 = r7.d;	 Catch:{ all -> 0x0075 }
        r2 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0044;
    L_0x0021:
        r0 = r7.c;	 Catch:{ all -> 0x0075 }
        r0 = r0.nextBoolean();	 Catch:{ all -> 0x0075 }
        if (r0 == 0) goto L_0x0032;
    L_0x0029:
        r0 = r7.a;	 Catch:{ all -> 0x0075 }
        r0 = r0.pollFirst();	 Catch:{ all -> 0x0075 }
        r0 = (anet.channel.bytes.ByteArray) r0;	 Catch:{ all -> 0x0075 }
        goto L_0x003a;
    L_0x0032:
        r0 = r7.a;	 Catch:{ all -> 0x0075 }
        r0 = r0.pollLast();	 Catch:{ all -> 0x0075 }
        r0 = (anet.channel.bytes.ByteArray) r0;	 Catch:{ all -> 0x0075 }
    L_0x003a:
        r1 = r7.d;	 Catch:{ all -> 0x0075 }
        r0 = r0.bufferLength;	 Catch:{ all -> 0x0075 }
        r3 = (long) r0;	 Catch:{ all -> 0x0075 }
        r5 = r1 - r3;
        r7.d = r5;	 Catch:{ all -> 0x0075 }
        goto L_0x0018;
    L_0x0044:
        r0 = 1;
        r1 = anet.channel.util.ALog.isPrintLog(r0);	 Catch:{ all -> 0x0075 }
        if (r1 == 0) goto L_0x0073;
    L_0x004b:
        r1 = "awcn.ByteArrayPool";
        r2 = "ByteArray Pool refund";
        r3 = 0;
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0075 }
        r5 = 0;
        r6 = "refund";
        r4[r5] = r6;	 Catch:{ all -> 0x0075 }
        r8 = r8.getBufferLength();	 Catch:{ all -> 0x0075 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0075 }
        r4[r0] = r8;	 Catch:{ all -> 0x0075 }
        r8 = 2;
        r0 = "total";
        r4[r8] = r0;	 Catch:{ all -> 0x0075 }
        r8 = 3;
        r5 = r7.d;	 Catch:{ all -> 0x0075 }
        r0 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0075 }
        r4[r8] = r0;	 Catch:{ all -> 0x0075 }
        anet.channel.util.ALog.d(r1, r2, r3, r4);	 Catch:{ all -> 0x0075 }
    L_0x0073:
        monitor-exit(r7);
        return;
    L_0x0075:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
    L_0x0078:
        monitor-exit(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.bytes.a.a(anet.channel.bytes.ByteArray):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized anet.channel.bytes.ByteArray a(int r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        if (r10 < r0) goto L_0x000d;
    L_0x0005:
        r10 = anet.channel.bytes.ByteArray.create(r10);	 Catch:{ all -> 0x000b }
        monitor-exit(r9);
        return r10;
    L_0x000b:
        r10 = move-exception;
        goto L_0x006b;
    L_0x000d:
        r0 = r9.b;	 Catch:{ all -> 0x000b }
        r0.bufferLength = r10;	 Catch:{ all -> 0x000b }
        r0 = r9.a;	 Catch:{ all -> 0x000b }
        r1 = r9.b;	 Catch:{ all -> 0x000b }
        r0 = r0.ceiling(r1);	 Catch:{ all -> 0x000b }
        r0 = (anet.channel.bytes.ByteArray) r0;	 Catch:{ all -> 0x000b }
        if (r0 != 0) goto L_0x0022;
    L_0x001d:
        r0 = anet.channel.bytes.ByteArray.create(r10);	 Catch:{ all -> 0x000b }
        goto L_0x0069;
    L_0x0022:
        r1 = r0.buffer;	 Catch:{ all -> 0x000b }
        r2 = 0;
        java.util.Arrays.fill(r1, r2);	 Catch:{ all -> 0x000b }
        r0.dataLength = r2;	 Catch:{ all -> 0x000b }
        r1 = r9.a;	 Catch:{ all -> 0x000b }
        r1.remove(r0);	 Catch:{ all -> 0x000b }
        r3 = r9.d;	 Catch:{ all -> 0x000b }
        r1 = r0.bufferLength;	 Catch:{ all -> 0x000b }
        r5 = (long) r1;	 Catch:{ all -> 0x000b }
        r7 = r3 - r5;
        r9.d = r7;	 Catch:{ all -> 0x000b }
        r3 = r9.e;	 Catch:{ all -> 0x000b }
        r5 = (long) r10;	 Catch:{ all -> 0x000b }
        r7 = r3 + r5;
        r9.e = r7;	 Catch:{ all -> 0x000b }
        r1 = 1;
        r3 = anet.channel.util.ALog.isPrintLog(r1);	 Catch:{ all -> 0x000b }
        if (r3 == 0) goto L_0x0069;
    L_0x0046:
        r3 = "awcn.ByteArrayPool";
        r4 = "ByteArray Pool retrieve";
        r5 = 0;
        r6 = 4;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x000b }
        r7 = "retrieve";
        r6[r2] = r7;	 Catch:{ all -> 0x000b }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x000b }
        r6[r1] = r10;	 Catch:{ all -> 0x000b }
        r10 = 2;
        r1 = "reused";
        r6[r10] = r1;	 Catch:{ all -> 0x000b }
        r10 = 3;
        r1 = r9.e;	 Catch:{ all -> 0x000b }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x000b }
        r6[r10] = r1;	 Catch:{ all -> 0x000b }
        anet.channel.util.ALog.d(r3, r4, r5, r6);	 Catch:{ all -> 0x000b }
    L_0x0069:
        monitor-exit(r9);
        return r0;
    L_0x006b:
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.bytes.a.a(int):anet.channel.bytes.ByteArray");
    }

    public ByteArray a(byte[] bArr, int i) {
        ByteArray a = a(i);
        System.arraycopy(bArr, 0, a.buffer, 0, i);
        a.dataLength = i;
        return a;
    }
}
