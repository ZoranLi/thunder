package com.xiaomi.slim;

import com.alipay.sdk.util.h;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.e;
import com.xiaomi.push.service.aw;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class c {
    private ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);
    private Adler32 c = new Adler32();
    private e d;
    private InputStream e;
    private f f;
    private volatile boolean g;
    private byte[] h;

    c(InputStream inputStream, f fVar) {
        this.e = new BufferedInputStream(inputStream);
        this.f = fVar;
        this.d = new e();
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.e.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
        r6 = this;
        r0 = 0;
        r6.g = r0;
        r1 = r6.c();
        r2 = "CONN";
        r3 = r1.a();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0063;
    L_0x0013:
        r1 = r1.k();
        r1 = com.xiaomi.push.protobuf.b.f.b(r1);
        r2 = r1.e();
        if (r2 == 0) goto L_0x002b;
    L_0x0021:
        r0 = r6.f;
        r2 = r1.d();
        r0.a(r2);
        r0 = 1;
    L_0x002b:
        r2 = r1.h();
        if (r2 == 0) goto L_0x004e;
    L_0x0031:
        r2 = r1.i();
        r3 = new com.xiaomi.slim.b;
        r3.<init>();
        r4 = "SYNC";
        r5 = "CONF";
        r3.a(r4, r5);
        r2 = r2.c();
        r4 = 0;
        r3.a(r2, r4);
        r2 = r6.f;
        r2.a(r3);
    L_0x004e:
        r2 = new java.lang.StringBuilder;
        r3 = "[Slim] CONN: host = ";
        r2.<init>(r3);
        r1 = r1.f();
        r2.append(r1);
        r1 = r2.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r1);
    L_0x0063:
        if (r0 != 0) goto L_0x0072;
    L_0x0065:
        r0 = "[Slim] Invalid CONN";
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = new java.io.IOException;
        r1 = "Invalid Connection";
        r0.<init>(r1);
        throw r0;
    L_0x0072:
        r0 = r6.f;
        r0 = r0.a();
        r6.h = r0;
    L_0x007a:
        r0 = r6.g;
        if (r0 != 0) goto L_0x0129;
    L_0x007e:
        r0 = r6.c();
        r1 = r6.f;
        r1.o();
        r1 = r0.m();
        switch(r1) {
            case 1: goto L_0x0122;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00a4;
            default: goto L_0x008e;
        };
    L_0x008e:
        r1 = new java.lang.StringBuilder;
        r2 = "[Slim] unknow blob type ";
        r1.<init>(r2);
        r0 = r0.m();
        r1.append(r0);
        r0 = r1.toString();
    L_0x00a0:
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        goto L_0x007a;
    L_0x00a4:
        r1 = r6.d;	 Catch:{ Exception -> 0x00b6 }
        r2 = r0.k();	 Catch:{ Exception -> 0x00b6 }
        r3 = r6.f;	 Catch:{ Exception -> 0x00b6 }
        r1 = r1.a(r2, r3);	 Catch:{ Exception -> 0x00b6 }
        r2 = r6.f;	 Catch:{ Exception -> 0x00b6 }
        r2.b(r1);	 Catch:{ Exception -> 0x00b6 }
        goto L_0x007a;
    L_0x00b6:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "[Slim] Parse packet from Blob ";
        r2.<init>(r3);
    L_0x00be:
        r0 = r0.toString();
        r2.append(r0);
        r0 = " failure:";
        r2.append(r0);
        r0 = r1.getMessage();
        r2.append(r0);
        r0 = r2.toString();
        goto L_0x00a0;
    L_0x00d6:
        r1 = "SECMSG";
        r2 = r0.a();
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0122;
    L_0x00e2:
        r1 = r0.b();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0122;
    L_0x00ec:
        r1 = r0.c();	 Catch:{ Exception -> 0x0119 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0119 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0119 }
        r2 = r0.j();	 Catch:{ Exception -> 0x0119 }
        r3 = com.xiaomi.push.service.ap.a();	 Catch:{ Exception -> 0x0119 }
        r1 = r3.b(r1, r2);	 Catch:{ Exception -> 0x0119 }
        r2 = r6.d;	 Catch:{ Exception -> 0x0119 }
        r1 = r1.i;	 Catch:{ Exception -> 0x0119 }
        r1 = r0.d(r1);	 Catch:{ Exception -> 0x0119 }
        r3 = r6.f;	 Catch:{ Exception -> 0x0119 }
        r1 = r2.a(r1, r3);	 Catch:{ Exception -> 0x0119 }
        r2 = r6.f;	 Catch:{ Exception -> 0x0119 }
        r2.b(r1);	 Catch:{ Exception -> 0x0119 }
        goto L_0x007a;
    L_0x0119:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "[Slim] Parse packet from Blob ";
        r2.<init>(r3);
        goto L_0x00be;
    L_0x0122:
        r1 = r6.f;
        r1.a(r0);
        goto L_0x007a;
    L_0x0129:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.slim.c.d():void");
    }

    private ByteBuffer e() {
        this.a.clear();
        a(this.a, 8);
        short s = this.a.getShort(0);
        short s2 = this.a.getShort(2);
        if (s == (short) -15618) {
            if (s2 == (short) 5) {
                int i = this.a.getInt(4);
                int position = this.a.position();
                if (i > 32768) {
                    throw new IOException("Blob size too large");
                }
                int i2;
                StringBuilder stringBuilder;
                int i3 = 2048;
                if (i + 4 > this.a.remaining()) {
                    i3 = 2048 + i;
                } else {
                    if (this.a.capacity() > 4096 && i < 2048) {
                    }
                    a(this.a, i);
                    this.b.clear();
                    a(this.b, 4);
                    this.b.position(0);
                    i2 = this.b.getInt();
                    this.c.reset();
                    this.c.update(this.a.array(), 0, this.a.position());
                    if (i2 == ((int) this.c.getValue())) {
                        stringBuilder = new StringBuilder("CRC = ");
                        stringBuilder.append((int) this.c.getValue());
                        stringBuilder.append(" and ");
                        stringBuilder.append(i2);
                        b.a(stringBuilder.toString());
                        throw new IOException("Corrupted Blob bad CRC");
                    }
                    if (this.h != null) {
                        aw.a(this.h, this.a.array(), true, position, i);
                    }
                    return this.a;
                }
                ByteBuffer allocate = ByteBuffer.allocate(i3);
                allocate.put(this.a.array(), 0, this.a.arrayOffset() + this.a.position());
                this.a = allocate;
                a(this.a, i);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                i2 = this.b.getInt();
                this.c.reset();
                this.c.update(this.a.array(), 0, this.a.position());
                if (i2 == ((int) this.c.getValue())) {
                    if (this.h != null) {
                        aw.a(this.h, this.a.array(), true, position, i);
                    }
                    return this.a;
                }
                stringBuilder = new StringBuilder("CRC = ");
                stringBuilder.append((int) this.c.getValue());
                stringBuilder.append(" and ");
                stringBuilder.append(i2);
                b.a(stringBuilder.toString());
                throw new IOException("Corrupted Blob bad CRC");
            }
        }
        throw new IOException("Malformed Input");
    }

    void a() {
        try {
            d();
        } catch (IOException e) {
            if (!this.g) {
                throw e;
            }
        }
    }

    void b() {
        this.g = true;
    }

    b c() {
        int position;
        IOException e;
        byte[] array;
        StringBuilder stringBuilder;
        try {
            ByteBuffer e2 = e();
            position = e2.position();
            try {
                e2.flip();
                e2.position(8);
                b b = b.b(e2.slice());
                stringBuilder = new StringBuilder("[Slim] Read {cmd=");
                stringBuilder.append(b.a());
                stringBuilder.append(";chid=");
                stringBuilder.append(b.c());
                stringBuilder.append(";len=");
                stringBuilder.append(position);
                stringBuilder.append(h.d);
                b.c(stringBuilder.toString());
                return b;
            } catch (IOException e3) {
                e = e3;
                if (position == 0) {
                    position = this.a.position();
                }
                stringBuilder = new StringBuilder("[Slim] read Blob [");
                array = this.a.array();
                if (position > 128) {
                    position = 128;
                }
                stringBuilder.append(e.a(array, 0, position));
                stringBuilder.append("] Err:");
                stringBuilder.append(e.getMessage());
                b.a(stringBuilder.toString());
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            position = 0;
            if (position == 0) {
                position = this.a.position();
            }
            stringBuilder = new StringBuilder("[Slim] read Blob [");
            array = this.a.array();
            if (position > 128) {
                position = 128;
            }
            stringBuilder.append(e.a(array, 0, position));
            stringBuilder.append("] Err:");
            stringBuilder.append(e.getMessage());
            b.a(stringBuilder.toString());
            throw e;
        }
    }
}
