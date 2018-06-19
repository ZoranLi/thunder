package okhttp3.internal.http2;

import anet.channel.util.HttpConstant;
import com.alipay.sdk.packet.d;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.download.Downloads.Impl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.c;
import okio.ByteString;
import okio.e;
import okio.g;
import okio.m;
import okio.v;

/* compiled from: Hpack */
final class b {
    static final a[] a;
    static final Map<ByteString, Integer> b;

    /* compiled from: Hpack */
    static final class a {
        final List<a> a;
        final g b;
        final int c;
        int d;
        a[] e;
        int f;
        int g;
        int h;

        a(v vVar) {
            this(vVar, (byte) 0);
        }

        private a(v vVar, byte b) {
            this.a = new ArrayList();
            this.e = new a[(byte) 8];
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            this.c = 4096;
            this.d = 4096;
            this.b = m.a(vVar);
        }

        final void a() {
            if (this.d < this.h) {
                if (this.d == 0) {
                    c();
                    return;
                }
                d(this.h - this.d);
            }
        }

        private void c() {
            Arrays.fill(this.e, null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private int d(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.e.length - 1; length >= this.f && i > 0; length--) {
                    i -= this.e[length].i;
                    this.h -= this.e[length].i;
                    this.g--;
                    i2++;
                }
                System.arraycopy(this.e, this.f + 1, this.e, (this.f + 1) + i2, this.g);
                this.f += i2;
            }
            return i2;
        }

        final int a(int i) {
            return (this.f + 1) + i;
        }

        final ByteString b(int i) {
            if (c(i)) {
                return b.a[i].g;
            }
            return this.e[a(i - b.a.length)].g;
        }

        static boolean c(int i) {
            return i >= 0 && i <= b.a.length - 1;
        }

        final void a(a aVar) {
            this.a.add(aVar);
            int i = aVar.i;
            if (i > this.d) {
                c();
                return;
            }
            d((this.h + i) - this.d);
            if (this.g + 1 > this.e.length) {
                Object obj = new a[(this.e.length * 2)];
                System.arraycopy(this.e, 0, obj, this.e.length, this.e.length);
                this.f = this.e.length - 1;
                this.e = obj;
            }
            int i2 = this.f;
            this.f = i2 - 1;
            this.e[i2] = aVar;
            this.g++;
            this.h += i;
        }

        private int d() throws IOException {
            return this.b.d() & 255;
        }

        final int a(int i, int i2) throws IOException {
            i &= i2;
            if (i < i2) {
                return i;
            }
            i = 0;
            while (true) {
                int d = d();
                if ((d & 128) == 0) {
                    return i2 + (d << i);
                }
                i2 += (d & Opcodes.NEG_FLOAT) << i;
                i += 7;
            }
        }

        final ByteString b() throws IOException {
            int d = d();
            int i = 0;
            int i2 = (d & 128) == 128 ? 1 : 0;
            d = a(d, Opcodes.NEG_FLOAT);
            if (i2 == 0) {
                return this.b.c((long) d);
            }
            t a = t.a();
            byte[] e = this.b.e((long) d);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            a aVar = a.a;
            int i4 = i3;
            while (i < e.length) {
                i4 = (i4 << 8) | (e[i] & 255);
                i3 += 8;
                while (i3 >= 8) {
                    aVar = aVar.a[(i4 >>> (i3 - 8)) & 255];
                    if (aVar.a == null) {
                        byteArrayOutputStream.write(aVar.b);
                        i3 -= aVar.c;
                        aVar = a.a;
                    } else {
                        i3 -= 8;
                    }
                }
                i++;
            }
            while (i3 > 0) {
                a aVar2 = aVar.a[(i4 << (8 - i3)) & 255];
                if (aVar2.a != null || aVar2.c > i3) {
                    break;
                }
                byteArrayOutputStream.write(aVar2.b);
                i3 -= aVar2.c;
                aVar = a.a;
            }
            return ByteString.of(byteArrayOutputStream.toByteArray());
        }
    }

    /* compiled from: Hpack */
    static final class b {
        int a;
        int b;
        a[] c;
        int d;
        int e;
        int f;
        private final e g;
        private final boolean h;
        private int i;
        private boolean j;

        b(e eVar) {
            this(eVar, (byte) 0);
        }

        private b(e eVar, byte b) {
            this.i = (byte) -1;
            this.c = new a[(byte) 8];
            this.d = this.c.length - (byte) 1;
            this.e = 0;
            this.f = 0;
            this.a = 4096;
            this.b = 4096;
            this.h = true;
            this.g = eVar;
        }

        private void a() {
            Arrays.fill(this.c, null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.c.length - 1; length >= this.d && i > 0; length--) {
                    i -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.c, this.d + 1, this.c, (this.d + 1) + i2, this.e);
                Arrays.fill(this.c, this.d + 1, (this.d + 1) + i2, null);
                this.d += i2;
            }
            return i2;
        }

        private void a(a aVar) {
            int i = aVar.i;
            if (i > this.b) {
                a();
                return;
            }
            b((this.f + i) - this.b);
            if (this.e + 1 > this.c.length) {
                Object obj = new a[(this.c.length * 2)];
                System.arraycopy(this.c, 0, obj, this.c.length, this.c.length);
                this.d = this.c.length - 1;
                this.c = obj;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.c[i2] = aVar;
            this.e++;
            this.f += i;
        }

        final void a(List<a> list) throws IOException {
            if (this.j) {
                if (this.i < this.b) {
                    a(this.i, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                int length;
                int i3;
                a aVar = (a) list.get(i);
                ByteString toAsciiLowercase = aVar.g.toAsciiLowercase();
                ByteString byteString = aVar.h;
                Integer num = (Integer) b.b.get(toAsciiLowercase);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (!c.a(b.a[intValue - 1].h, (Object) byteString)) {
                            if (c.a(b.a[intValue].h, (Object) byteString)) {
                                i2 = intValue;
                                intValue++;
                                if (intValue == -1) {
                                    length = this.c.length;
                                    for (i3 = this.d + 1; i3 < length; i3++) {
                                        if (c.a(this.c[i3].g, (Object) toAsciiLowercase)) {
                                            if (!c.a(this.c[i3].h, (Object) byteString)) {
                                                intValue = b.a.length + (i3 - this.d);
                                                break;
                                            } else if (i2 != -1) {
                                                i2 = (i3 - this.d) + b.a.length;
                                            }
                                        }
                                    }
                                }
                                if (intValue == -1) {
                                    a(intValue, Opcodes.NEG_FLOAT, 128);
                                } else if (i2 == -1) {
                                    this.g.b(64);
                                    a(toAsciiLowercase);
                                    a(byteString);
                                    a(aVar);
                                } else if (toAsciiLowercase.startsWith(a.a) || a.f.equals(toAsciiLowercase)) {
                                    a(i2, 63, 64);
                                    a(byteString);
                                    a(aVar);
                                } else {
                                    a(i2, 15, 0);
                                    a(byteString);
                                }
                            }
                        }
                    }
                    i2 = intValue;
                    intValue = -1;
                    if (intValue == -1) {
                        length = this.c.length;
                        for (i3 = this.d + 1; i3 < length; i3++) {
                            if (c.a(this.c[i3].g, (Object) toAsciiLowercase)) {
                                if (!c.a(this.c[i3].h, (Object) byteString)) {
                                    intValue = b.a.length + (i3 - this.d);
                                    break;
                                } else if (i2 != -1) {
                                    i2 = (i3 - this.d) + b.a.length;
                                }
                            }
                        }
                    }
                    if (intValue == -1) {
                        a(intValue, Opcodes.NEG_FLOAT, 128);
                    } else if (i2 == -1) {
                        if (toAsciiLowercase.startsWith(a.a)) {
                        }
                        a(i2, 63, 64);
                        a(byteString);
                        a(aVar);
                    } else {
                        this.g.b(64);
                        a(toAsciiLowercase);
                        a(byteString);
                        a(aVar);
                    }
                } else {
                    intValue = -1;
                }
                i2 = intValue;
                if (intValue == -1) {
                    length = this.c.length;
                    for (i3 = this.d + 1; i3 < length; i3++) {
                        if (c.a(this.c[i3].g, (Object) toAsciiLowercase)) {
                            if (!c.a(this.c[i3].h, (Object) byteString)) {
                                intValue = b.a.length + (i3 - this.d);
                                break;
                            } else if (i2 != -1) {
                                i2 = (i3 - this.d) + b.a.length;
                            }
                        }
                    }
                }
                if (intValue == -1) {
                    a(intValue, Opcodes.NEG_FLOAT, 128);
                } else if (i2 == -1) {
                    this.g.b(64);
                    a(toAsciiLowercase);
                    a(byteString);
                    a(aVar);
                } else {
                    if (toAsciiLowercase.startsWith(a.a)) {
                    }
                    a(i2, 63, 64);
                    a(byteString);
                    a(aVar);
                }
            }
        }

        private void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.b(i | i3);
                return;
            }
            this.g.b(i3 | i2);
            i -= i2;
            while (i >= 128) {
                this.g.b(128 | (i & Opcodes.NEG_FLOAT));
                i >>>= 7;
            }
            this.g.b(i);
        }

        private void a(ByteString byteString) throws IOException {
            if (this.h) {
                t.a();
                if (t.a(byteString) < byteString.size()) {
                    Object eVar = new e();
                    t.a();
                    t.a(byteString, eVar);
                    byteString = eVar.j();
                    a(byteString.size(), Opcodes.NEG_FLOAT, 128);
                    this.g.a(byteString);
                    return;
                }
            }
            a(byteString.size(), Opcodes.NEG_FLOAT, 0);
            this.g.a(byteString);
        }

        final void a(int i) {
            this.a = i;
            i = Math.min(i, 16384);
            if (this.b != i) {
                if (i < this.b) {
                    this.i = Math.min(this.i, i);
                }
                this.j = true;
                this.b = i;
                if (this.b < this.f) {
                    if (this.b == 0) {
                        a();
                        return;
                    }
                    b(this.f - this.b);
                }
            }
        }
    }

    static {
        r0 = new a[61];
        int i = 0;
        r0[0] = new a(a.f, "");
        r0[1] = new a(a.c, "GET");
        r0[2] = new a(a.c, "POST");
        r0[3] = new a(a.d, "/");
        r0[4] = new a(a.d, "/index.html");
        r0[5] = new a(a.e, HttpConstant.HTTP);
        r0[6] = new a(a.e, "https");
        r0[7] = new a(a.b, "200");
        r0[8] = new a(a.b, "204");
        r0[9] = new a(a.b, "206");
        r0[10] = new a(a.b, "304");
        r0[11] = new a(a.b, "400");
        r0[12] = new a(a.b, "404");
        r0[13] = new a(a.b, "500");
        r0[14] = new a("accept-charset", "");
        r0[15] = new a("accept-encoding", "gzip, deflate");
        r0[16] = new a("accept-language", "");
        r0[17] = new a("accept-ranges", "");
        r0[18] = new a("accept", "");
        r0[19] = new a("access-control-allow-origin", "");
        r0[20] = new a("age", "");
        r0[21] = new a("allow", "");
        r0[22] = new a("authorization", "");
        r0[23] = new a("cache-control", "");
        r0[24] = new a("content-disposition", "");
        r0[25] = new a("content-encoding", "");
        r0[26] = new a("content-language", "");
        r0[27] = new a("content-length", "");
        r0[28] = new a("content-location", "");
        r0[29] = new a("content-range", "");
        r0[30] = new a(d.d, "");
        r0[31] = new a("cookie", "");
        r0[32] = new a("date", "");
        r0[33] = new a("etag", "");
        r0[34] = new a("expect", "");
        r0[35] = new a("expires", "");
        r0[36] = new a("from", "");
        r0[37] = new a("host", "");
        r0[38] = new a("if-match", "");
        r0[39] = new a("if-modified-since", "");
        r0[40] = new a("if-none-match", "");
        r0[41] = new a("if-range", "");
        r0[42] = new a("if-unmodified-since", "");
        r0[43] = new a("last-modified", "");
        r0[44] = new a("link", "");
        r0[45] = new a("location", "");
        r0[46] = new a("max-forwards", "");
        r0[47] = new a("proxy-authenticate", "");
        r0[48] = new a("proxy-authorization", "");
        r0[49] = new a("range", "");
        r0[50] = new a(Impl.COLUMN_REFERER, "");
        r0[51] = new a("refresh", "");
        r0[52] = new a("retry-after", "");
        r0[53] = new a("server", "");
        r0[54] = new a("set-cookie", "");
        r0[55] = new a("strict-transport-security", "");
        r0[56] = new a("transfer-encoding", "");
        r0[57] = new a("user-agent", "");
        r0[58] = new a("vary", "");
        r0[59] = new a(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, "");
        r0[60] = new a("www-authenticate", "");
        a = r0;
        Map linkedHashMap = new LinkedHashMap(a.length);
        while (i < a.length) {
            if (!linkedHashMap.containsKey(a[i].g)) {
                linkedHashMap.put(a[i].g, Integer.valueOf(i));
            }
            i++;
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
                stringBuilder.append(byteString.utf8());
                throw new IOException(stringBuilder.toString());
            }
        }
        return byteString;
    }
}
