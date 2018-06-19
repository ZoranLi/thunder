package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.e;
import okio.g;
import okio.v;
import okio.w;

/* compiled from: Http2Reader */
final class q implements Closeable {
    static final Logger a = Logger.getLogger(c.class.getName());
    final g b;
    final boolean c;
    final a d = new a(this.e);
    private final a e = new a(this.b);

    /* compiled from: Http2Reader */
    interface b {
        void a(int i, long j);

        void a(int i, List<a> list) throws IOException;

        void a(int i, ErrorCode errorCode);

        void a(int i, ByteString byteString);

        void a(x xVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, List<a> list);

        void a(boolean z, int i, g gVar, int i2) throws IOException;
    }

    /* compiled from: Http2Reader */
    static final class a implements v {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final g f;

        public final void close() throws IOException {
        }

        a(g gVar) {
            this.f = gVar;
        }

        public final long a(e eVar, long j) throws IOException {
            while (this.d == 0) {
                this.f.f((long) this.e);
                this.e = (short) 0;
                if ((this.b & 4) != 0) {
                    return -1;
                }
                int i = this.c;
                int a = q.a(this.f);
                this.d = a;
                this.a = a;
                byte d = (byte) (this.f.d() & 255);
                this.b = (byte) (this.f.d() & 255);
                if (q.a.isLoggable(Level.FINE)) {
                    q.a.fine(c.a(true, this.c, this.a, d, this.b));
                }
                this.c = this.f.f() & Integer.MAX_VALUE;
                if (d != (byte) 9) {
                    throw c.b("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(d)});
                } else if (this.c != i) {
                    throw c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            eVar = this.f.a(eVar, Math.min(j, (long) this.d));
            if (eVar == -1) {
                return -1;
            }
            this.d = (int) (((long) this.d) - eVar);
            return eVar;
        }

        public final w a() {
            return this.f.a();
        }
    }

    q(g gVar, boolean z) {
        this.b = gVar;
        this.c = z;
    }

    public final boolean a(boolean r12, okhttp3.internal.http2.q.b r13) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = 0;
        r1 = r11.b;	 Catch:{ IOException -> 0x02ad }
        r2 = 9;	 Catch:{ IOException -> 0x02ad }
        r1.a(r2);	 Catch:{ IOException -> 0x02ad }
        r1 = r11.b;
        r1 = a(r1);
        r2 = 1;
        if (r1 < 0) goto L_0x029e;
    L_0x0011:
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        if (r1 <= r3) goto L_0x0017;
    L_0x0015:
        goto L_0x029e;
    L_0x0017:
        r4 = r11.b;
        r4 = r4.d();
        r4 = r4 & 255;
        r4 = (byte) r4;
        r5 = 4;
        if (r12 == 0) goto L_0x0034;
    L_0x0023:
        if (r4 == r5) goto L_0x0034;
    L_0x0025:
        r12 = "Expected a SETTINGS frame but was %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Byte.valueOf(r4);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0034:
        r12 = r11.b;
        r12 = r12.d();
        r12 = r12 & 255;
        r12 = (byte) r12;
        r6 = r11.b;
        r6 = r6.f();
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r6 = r6 & r7;
        r8 = a;
        r9 = java.util.logging.Level.FINE;
        r8 = r8.isLoggable(r9);
        if (r8 == 0) goto L_0x005a;
    L_0x0051:
        r8 = a;
        r9 = okhttp3.internal.http2.c.a(r2, r6, r1, r4, r12);
        r8.fine(r9);
    L_0x005a:
        r8 = 8;
        switch(r4) {
            case 0: goto L_0x025d;
            case 1: goto L_0x0229;
            case 2: goto L_0x0207;
            case 3: goto L_0x01cb;
            case 4: goto L_0x014b;
            case 5: goto L_0x011d;
            case 6: goto L_0x00ec;
            case 7: goto L_0x009e;
            case 8: goto L_0x0067;
            default: goto L_0x005f;
        };
    L_0x005f:
        r12 = r11.b;
        r0 = (long) r1;
        r12.f(r0);
        goto L_0x029d;
    L_0x0067:
        if (r1 == r5) goto L_0x0078;
    L_0x0069:
        r12 = "TYPE_WINDOW_UPDATE length !=4: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0078:
        r12 = r11.b;
        r12 = r12.f();
        r3 = (long) r12;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r9 = r3 & r7;
        r3 = 0;
        r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x0099;
    L_0x008a:
        r12 = "windowSizeIncrement was 0";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Long.valueOf(r9);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0099:
        r13.a(r6, r9);
        goto L_0x029d;
    L_0x009e:
        if (r1 >= r8) goto L_0x00af;
    L_0x00a0:
        r12 = "TYPE_GOAWAY length < 8: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x00af:
        if (r6 == 0) goto L_0x00ba;
    L_0x00b1:
        r12 = "TYPE_GOAWAY streamId != 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x00ba:
        r12 = r11.b;
        r12 = r12.f();
        r3 = r11.b;
        r3 = r3.f();
        r1 = r1 - r8;
        r4 = okhttp3.internal.http2.ErrorCode.fromHttp2(r3);
        if (r4 != 0) goto L_0x00dc;
    L_0x00cd:
        r12 = "TYPE_GOAWAY unexpected error code: %d";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r3);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x00dc:
        r0 = okio.ByteString.EMPTY;
        if (r1 <= 0) goto L_0x00e7;
    L_0x00e0:
        r0 = r11.b;
        r3 = (long) r1;
        r0 = r0.c(r3);
    L_0x00e7:
        r13.a(r12, r0);
        goto L_0x029d;
    L_0x00ec:
        if (r1 == r8) goto L_0x00fd;
    L_0x00ee:
        r12 = "TYPE_PING length != 8: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x00fd:
        if (r6 == 0) goto L_0x0108;
    L_0x00ff:
        r12 = "TYPE_PING streamId != 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0108:
        r1 = r11.b;
        r1 = r1.f();
        r3 = r11.b;
        r3 = r3.f();
        r12 = r12 & r2;
        if (r12 == 0) goto L_0x0118;
    L_0x0117:
        r0 = r2;
    L_0x0118:
        r13.a(r0, r1, r3);
        goto L_0x029d;
    L_0x011d:
        if (r6 != 0) goto L_0x0128;
    L_0x011f:
        r12 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0128:
        r3 = r12 & 8;
        if (r3 == 0) goto L_0x0135;
    L_0x012c:
        r0 = r11.b;
        r0 = r0.d();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x0135:
        r3 = r11.b;
        r3 = r3.f();
        r3 = r3 & r7;
        r1 = r1 + -4;
        r1 = a(r1, r12, r0);
        r12 = r11.a(r1, r0, r12, r6);
        r13.a(r3, r12);
        goto L_0x029d;
    L_0x014b:
        if (r6 == 0) goto L_0x0156;
    L_0x014d:
        r12 = "TYPE_SETTINGS streamId != 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0156:
        r12 = r12 & r2;
        if (r12 == 0) goto L_0x0164;
    L_0x0159:
        if (r1 == 0) goto L_0x029d;
    L_0x015b:
        r12 = "FRAME_SIZE_ERROR ack frame should be empty!";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0164:
        r12 = r1 % 6;
        if (r12 == 0) goto L_0x0177;
    L_0x0168:
        r12 = "TYPE_SETTINGS length %% 6 != 0: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0177:
        r12 = new okhttp3.internal.http2.x;
        r12.<init>();
        r4 = r0;
    L_0x017d:
        if (r4 >= r1) goto L_0x01c6;
    L_0x017f:
        r6 = r11.b;
        r6 = r6.e();
        r7 = r11.b;
        r7 = r7.f();
        switch(r6) {
            case 1: goto L_0x01c0;
            case 2: goto L_0x01b3;
            case 3: goto L_0x01b1;
            case 4: goto L_0x01a5;
            case 5: goto L_0x018f;
            default: goto L_0x018e;
        };
    L_0x018e:
        goto L_0x01c0;
    L_0x018f:
        if (r7 < r3) goto L_0x0196;
    L_0x0191:
        r8 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        if (r7 <= r8) goto L_0x01c0;
    L_0x0196:
        r12 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r7);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x01a5:
        r6 = 7;
        if (r7 >= 0) goto L_0x01c0;
    L_0x01a8:
        r12 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x01b1:
        r6 = r5;
        goto L_0x01c0;
    L_0x01b3:
        if (r7 == 0) goto L_0x01c0;
    L_0x01b5:
        if (r7 == r2) goto L_0x01c0;
    L_0x01b7:
        r12 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x01c0:
        r12.a(r6, r7);
        r4 = r4 + 6;
        goto L_0x017d;
    L_0x01c6:
        r13.a(r12);
        goto L_0x029d;
    L_0x01cb:
        if (r1 == r5) goto L_0x01dc;
    L_0x01cd:
        r12 = "TYPE_RST_STREAM length: %d != 4";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x01dc:
        if (r6 != 0) goto L_0x01e7;
    L_0x01de:
        r12 = "TYPE_RST_STREAM streamId == 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x01e7:
        r12 = r11.b;
        r12 = r12.f();
        r1 = okhttp3.internal.http2.ErrorCode.fromHttp2(r12);
        if (r1 != 0) goto L_0x0202;
    L_0x01f3:
        r13 = "TYPE_RST_STREAM unexpected error code: %d";
        r1 = new java.lang.Object[r2];
        r12 = java.lang.Integer.valueOf(r12);
        r1[r0] = r12;
        r12 = okhttp3.internal.http2.c.b(r13, r1);
        throw r12;
    L_0x0202:
        r13.a(r6, r1);
        goto L_0x029d;
    L_0x0207:
        r12 = 5;
        if (r1 == r12) goto L_0x0219;
    L_0x020a:
        r12 = "TYPE_PRIORITY length: %d != 5";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0219:
        if (r6 != 0) goto L_0x0224;
    L_0x021b:
        r12 = "TYPE_PRIORITY streamId == 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0224:
        r11.a();
        goto L_0x029d;
    L_0x0229:
        if (r6 != 0) goto L_0x0234;
    L_0x022b:
        r12 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0234:
        r3 = r12 & 1;
        if (r3 == 0) goto L_0x023a;
    L_0x0238:
        r3 = r2;
        goto L_0x023b;
    L_0x023a:
        r3 = r0;
    L_0x023b:
        r4 = r12 & 8;
        if (r4 == 0) goto L_0x0248;
    L_0x023f:
        r0 = r11.b;
        r0 = r0.d();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x0248:
        r4 = r12 & 32;
        if (r4 == 0) goto L_0x0251;
    L_0x024c:
        r11.a();
        r1 = r1 + -5;
    L_0x0251:
        r1 = a(r1, r12, r0);
        r12 = r11.a(r1, r0, r12, r6);
        r13.a(r3, r6, r12);
        goto L_0x029d;
    L_0x025d:
        if (r6 != 0) goto L_0x0268;
    L_0x025f:
        r12 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0268:
        r3 = r12 & 1;
        if (r3 == 0) goto L_0x026e;
    L_0x026c:
        r3 = r2;
        goto L_0x026f;
    L_0x026e:
        r3 = r0;
    L_0x026f:
        r4 = r12 & 32;
        if (r4 == 0) goto L_0x0275;
    L_0x0273:
        r4 = r2;
        goto L_0x0276;
    L_0x0275:
        r4 = r0;
    L_0x0276:
        if (r4 == 0) goto L_0x0281;
    L_0x0278:
        r12 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA";
        r13 = new java.lang.Object[r0];
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x0281:
        r4 = r12 & 8;
        if (r4 == 0) goto L_0x028e;
    L_0x0285:
        r0 = r11.b;
        r0 = r0.d();
        r0 = r0 & 255;
        r0 = (short) r0;
    L_0x028e:
        r12 = a(r1, r12, r0);
        r1 = r11.b;
        r13.a(r3, r6, r1, r12);
        r12 = r11.b;
        r0 = (long) r0;
        r12.f(r0);
    L_0x029d:
        return r2;
    L_0x029e:
        r12 = "FRAME_SIZE_ERROR: %s";
        r13 = new java.lang.Object[r2];
        r1 = java.lang.Integer.valueOf(r1);
        r13[r0] = r1;
        r12 = okhttp3.internal.http2.c.b(r12, r13);
        throw r12;
    L_0x02ad:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.q.a(boolean, okhttp3.internal.http2.q$b):boolean");
    }

    private List<a> a(int i, short s, byte b, int i2) throws IOException {
        a aVar = this.e;
        this.e.d = i;
        aVar.a = i;
        this.e.e = s;
        this.e.b = b;
        this.e.c = i2;
        i = this.d;
        while (i.b.c() == (short) 0) {
            byte d = i.b.d() & 255;
            if (d == Byte.MIN_VALUE) {
                throw new IOException("index == 0");
            } else if ((d & 128) == 128) {
                s = i.a(d, Byte.MAX_VALUE) - 1;
                if (a.c(s) != (byte) 0) {
                    i.a.add(b.a[s]);
                } else {
                    b = i.a(s - b.a.length);
                    if (b >= (byte) 0) {
                        if (b <= i.e.length - 1) {
                            i.a.add(i.e[b]);
                        }
                    }
                    b = new StringBuilder("Header index too large ");
                    b.append(s + 1);
                    throw new IOException(b.toString());
                }
            } else if (d == (byte) 64) {
                i.a(new a(b.a(i.b()), i.b()));
            } else if ((d & 64) == 64) {
                i.a(new a(i.b(i.a(d, (byte) 63) - 1), i.b()));
            } else if ((d & 32) == (byte) 32) {
                i.d = i.a(d, (byte) 31);
                if (i.d >= (short) 0) {
                    if (i.d <= i.c) {
                        i.a();
                    }
                }
                b = new StringBuilder("Invalid dynamic table size update ");
                b.append(i.d);
                throw new IOException(b.toString());
            } else {
                if (d != (byte) 16) {
                    if (d != (byte) 0) {
                        i.a.add(new a(i.b(i.a(d, (byte) 15) - 1), i.b()));
                    }
                }
                i.a.add(new a(b.a(i.b()), i.b()));
            }
        }
        i = this.d;
        s = new ArrayList(i.a);
        i.a.clear();
        return s;
    }

    private void a() throws IOException {
        this.b.f();
        this.b.d();
    }

    public final void close() throws IOException {
        this.b.close();
    }

    static int a(g gVar) throws IOException {
        return (gVar.d() & 255) | (((gVar.d() & 255) << 16) | ((gVar.d() & 255) << 8));
    }

    private static int a(int i, byte b, short s) throws IOException {
        if ((b & 8) != (byte) 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw c.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }
}
