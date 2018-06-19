package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Buffer */
public final class e implements Cloneable, f, g {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    @Nullable
    s a;
    public long b;

    public final e b() {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final /* bridge */ /* synthetic */ f p() throws IOException {
        return this;
    }

    public final /* synthetic */ f b(String str) throws IOException {
        return a(str);
    }

    public final /* synthetic */ f b(ByteString byteString) throws IOException {
        return a(byteString);
    }

    public final /* synthetic */ f c(byte[] bArr) throws IOException {
        return b(bArr);
    }

    public final /* synthetic */ f c(byte[] bArr, int i, int i2) throws IOException {
        return b(bArr, i, i2);
    }

    public final /* synthetic */ f f(int i) throws IOException {
        return d(i);
    }

    public final /* synthetic */ f g(int i) throws IOException {
        return c(i);
    }

    public final /* synthetic */ f h(int i) throws IOException {
        return b(i);
    }

    public final /* synthetic */ f i(long j) throws IOException {
        return h(j);
    }

    public final /* synthetic */ f j(long j) throws IOException {
        return g(j);
    }

    public final boolean c() {
        return this.b == 0;
    }

    public final void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public final e a(e eVar, long j, long j2) {
        if (eVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        y.a(this.b, j, j2);
        if (j2 == 0) {
            return this;
        }
        eVar.b += j2;
        s sVar = this.a;
        while (j >= ((long) (sVar.c - sVar.b))) {
            long j3 = j - ((long) (sVar.c - sVar.b));
            sVar = sVar.f;
            j = j3;
        }
        while (j2 > 0) {
            s sVar2 = new s(sVar);
            sVar2.b = (int) (((long) sVar2.b) + j);
            sVar2.c = Math.min(sVar2.b + ((int) j2), sVar2.c);
            if (eVar.a == null) {
                sVar2.g = sVar2;
                sVar2.f = sVar2;
                eVar.a = sVar2;
            } else {
                eVar.a.g.a(sVar2);
            }
            long j4 = j2 - ((long) (sVar2.c - sVar2.b));
            sVar = sVar.f;
            j = 0;
            j2 = j4;
        }
        return this;
    }

    public final byte d() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        s sVar = this.a;
        int i = sVar.b;
        int i2 = sVar.c;
        int i3 = i + 1;
        byte b = sVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = sVar.a();
            t.a(sVar);
        } else {
            sVar.b = i3;
        }
        return b;
    }

    public final byte b(long j) {
        y.a(this.b, j, 1);
        s sVar = this.a;
        while (true) {
            long j2 = (long) (sVar.c - sVar.b);
            if (j < j2) {
                return sVar.a[sVar.b + ((int) j)];
            }
            long j3 = j - j2;
            sVar = sVar.f;
            j = j3;
        }
    }

    public final short e() {
        if (this.b < 2) {
            StringBuilder stringBuilder = new StringBuilder("size < 2: ");
            stringBuilder.append(this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        s sVar = this.a;
        int i = sVar.b;
        int i2 = sVar.c;
        if (i2 - i < 2) {
            return (short) (((d() & 255) << 8) | (d() & 255));
        }
        byte[] bArr = sVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.a = sVar.a();
            t.a(sVar);
        } else {
            sVar.b = i4;
        }
        return (short) i;
    }

    public final int f() {
        if (this.b < 4) {
            StringBuilder stringBuilder = new StringBuilder("size < 4: ");
            stringBuilder.append(this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        s sVar = this.a;
        int i = sVar.b;
        int i2 = sVar.c;
        if (i2 - i < 4) {
            return ((((d() & 255) << 24) | ((d() & 255) << 16)) | ((d() & 255) << 8)) | (d() & 255);
        }
        byte[] bArr = sVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.b -= 4;
        if (i4 == i2) {
            this.a = sVar.a();
            t.a(sVar);
        } else {
            sVar.b = i4;
        }
        return i;
    }

    public final short g() {
        return y.a(e());
    }

    public final int h() {
        return y.a(f());
    }

    public final long i() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i = 0;
        int i2 = 0;
        long j = 0;
        do {
            s sVar = r0.a;
            byte[] bArr = sVar.a;
            int i3 = sVar.b;
            int i4 = sVar.c;
            while (i3 < i4) {
                int i5;
                int i6 = bArr[i3];
                if (i6 >= (byte) 48 && i6 <= (byte) 57) {
                    i5 = i6 - 48;
                } else if (i6 >= (byte) 97 && i6 <= (byte) 102) {
                    i5 = (i6 - 97) + 10;
                } else if (i6 < (byte) 65 || i6 > (byte) 70) {
                    if (i != 0) {
                        i2 = 1;
                        if (i3 != i4) {
                            r0.a = sVar.a();
                            t.a(sVar);
                        } else {
                            sVar.b = i3;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                        stringBuilder.append(Integer.toHexString(i6));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                } else {
                    i5 = (i6 - 65) + 10;
                }
                if ((j & -1152921504606846976L) != 0) {
                    e b = new e().h(j).b(i6);
                    StringBuilder stringBuilder2 = new StringBuilder("Number too large: ");
                    stringBuilder2.append(b.k());
                    throw new NumberFormatException(stringBuilder2.toString());
                }
                i3++;
                i++;
                j = (j << 4) | ((long) i5);
            }
            if (i3 != i4) {
                sVar.b = i3;
            } else {
                r0.a = sVar.a();
                t.a(sVar);
            }
            if (i2 == 0) {
                break;
            }
        } while (r0.a != null);
        r0.b -= (long) i;
        return j;
    }

    public final ByteString j() {
        return new ByteString(m());
    }

    public final ByteString c(long j) throws EOFException {
        return new ByteString(e(j));
    }

    public final String k() {
        try {
            return a(this.b, y.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private String k(long j) throws EOFException {
        return a(j, y.a);
    }

    private String a(long j, Charset charset) throws EOFException {
        y.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j == 0) {
            return "";
        } else {
            s sVar = this.a;
            if (((long) sVar.b) + j > ((long) sVar.c)) {
                return new String(e(j), charset);
            }
            String str = new String(sVar.a, sVar.b, (int) j, charset);
            sVar.b = (int) (((long) sVar.b) + j);
            this.b -= j;
            if (sVar.b == sVar.c) {
                this.a = sVar.a();
                t.a(sVar);
            }
            return str;
        }
    }

    final String d(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (b(j2) == (byte) 13) {
                j = k(j2);
                f(2);
                return j;
            }
        }
        j = k(j);
        f(1);
        return j;
    }

    public final byte[] m() {
        try {
            return e(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] e(long j) throws EOFException {
        y.a(this.b, 0, j);
        if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[((int) j)];
        a(bArr);
        return bArr;
    }

    public final void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public final int a(byte[] bArr, int i, int i2) {
        y.a((long) bArr.length, (long) i, (long) i2);
        s sVar = this.a;
        if (sVar == null) {
            return -1;
        }
        i2 = Math.min(i2, sVar.c - sVar.b);
        System.arraycopy(sVar.a, sVar.b, bArr, i, i2);
        sVar.b += i2;
        this.b -= (long) i2;
        if (sVar.b == sVar.c) {
            this.a = sVar.a();
            t.a(sVar);
        }
        return i2;
    }

    public final void n() {
        try {
            f(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void f(long j) throws EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            long j2 = (long) min;
            this.b -= j2;
            long j3 = j - j2;
            j = this.a;
            j.b += min;
            if (this.a.b == this.a.c) {
                j = this.a;
                this.a = j.a();
                t.a(j);
            }
            j = j3;
        }
    }

    public final e a(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    public final e a(String str) {
        return a(str, 0, str.length());
    }

    public final e a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            i2 = new StringBuilder("beginIndex < 0: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (i2 < i) {
            r0 = new StringBuilder("endIndex < beginIndex: ");
            r0.append(i2);
            r0.append(" < ");
            r0.append(i);
            throw new IllegalArgumentException(r0.toString());
        } else if (i2 > str.length()) {
            r0 = new StringBuilder("endIndex > string.length: ");
            r0.append(i2);
            r0.append(" > ");
            r0.append(str.length());
            throw new IllegalArgumentException(r0.toString());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                int min;
                if (charAt < '') {
                    s e = e(1);
                    byte[] bArr = e.a;
                    i3 = e.c - i;
                    min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (true) {
                        i = i4;
                        if (i >= min) {
                            break;
                        }
                        charAt = str.charAt(i);
                        if (charAt >= '') {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    i3 = (i3 + i) - e.c;
                    e.c += i3;
                    this.b += (long) i3;
                } else if (charAt < 'ࠀ') {
                    b((charAt >> 6) | 192);
                    b((charAt & 63) | 128);
                    i++;
                } else {
                    if (charAt >= '?') {
                        if (charAt <= '?') {
                            i3 = i + 1;
                            if (i3 < i2) {
                                min = str.charAt(i3);
                            } else {
                                min = 0;
                            }
                            if (charAt <= '?' && min >= 56320) {
                                if (min <= 57343) {
                                    int i5 = 65536 + (((charAt & -55297) << 10) | (-56321 & min));
                                    b((i5 >> 18) | 240);
                                    b(((i5 >> 12) & 63) | 128);
                                    b(((i5 >> 6) & 63) | 128);
                                    b((i5 & 63) | 128);
                                    i += 2;
                                }
                            }
                            b(63);
                            i = i3;
                        }
                    }
                    b((charAt >> 12) | 224);
                    b(((charAt >> 6) & 63) | 128);
                    b((charAt & 63) | 128);
                    i++;
                }
            }
            return this;
        }
    }

    public final e a(int i) {
        if (i < 128) {
            b(i);
        } else if (i < 2048) {
            b((i >> 6) | 192);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | 224);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                b(63);
            }
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Unexpected code point: ");
            stringBuilder.append(Integer.toHexString(i));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this;
    }

    public final e b(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final e b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = (long) i2;
        y.a((long) bArr.length, (long) i, j);
        i2 += i;
        while (i < i2) {
            s e = e(1);
            int min = Math.min(i2 - i, 8192 - e.c);
            System.arraycopy(bArr, i, e.a, e.c, min);
            i += min;
            e.c += min;
        }
        this.b += j;
        return this;
    }

    public final long a(v vVar) throws IOException {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = vVar.a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    public final e b(int i) {
        s e = e(1);
        byte[] bArr = e.a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public final e c(int i) {
        s e = e(2);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 2;
        return this;
    }

    public final e d(int i) {
        s e = e(4);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 4;
        return this;
    }

    public final e g(long j) {
        if (j == 0) {
            return b((int) 48);
        }
        int i = 0;
        int i2 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return a("-9223372036854775808");
            }
            i = 1;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (i != 0) {
            i2++;
        }
        s e = e(i2);
        byte[] bArr = e.a;
        int i3 = e.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = c[(int) (j % 10)];
            j /= 10;
        }
        if (i != 0) {
            bArr[i3 - 1] = 45;
        }
        e.c += i2;
        this.b += (long) i2;
        return this;
    }

    public final e h(long j) {
        if (j == 0) {
            return b((int) 48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        s e = e(numberOfTrailingZeros);
        byte[] bArr = e.a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (j & 15)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b += (long) numberOfTrailingZeros;
        return this;
    }

    final s e(int i) {
        if (i > 0) {
            if (i <= 8192) {
                s sVar;
                if (this.a == null) {
                    this.a = t.a();
                    i = this.a;
                    s sVar2 = this.a;
                    sVar = this.a;
                    sVar2.g = sVar;
                    i.f = sVar;
                    return sVar;
                }
                sVar = this.a.g;
                if (sVar.c + i > 8192 || sVar.e == 0) {
                    sVar = sVar.a(t.a());
                }
                return sVar;
            }
        }
        throw new IllegalArgumentException();
    }

    public final void a_(e eVar, long j) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (eVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            y.a(eVar.b, 0, j);
            while (j > 0) {
                s sVar;
                int i = 0;
                if (j < ((long) (eVar.a.c - eVar.a.b))) {
                    int i2;
                    sVar = this.a != null ? this.a.g : null;
                    if (sVar != null && sVar.e) {
                        long j2 = j + ((long) sVar.c);
                        if (sVar.d) {
                            i2 = 0;
                        } else {
                            i2 = sVar.b;
                        }
                        if (j2 - ((long) i2) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            eVar.a.a(sVar, (int) j);
                            eVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    sVar = eVar.a;
                    i2 = (int) j;
                    if (i2 > 0) {
                        if (i2 <= sVar.c - sVar.b) {
                            s sVar2;
                            if (i2 >= 1024) {
                                sVar2 = new s(sVar);
                            } else {
                                sVar2 = t.a();
                                System.arraycopy(sVar.a, sVar.b, sVar2.a, 0, i2);
                            }
                            sVar2.c = sVar2.b + i2;
                            sVar.b += i2;
                            sVar.g.a(sVar2);
                            eVar.a = sVar2;
                        }
                    }
                    throw new IllegalArgumentException();
                }
                sVar = eVar.a;
                long j3 = (long) (sVar.c - sVar.b);
                eVar.a = sVar.a();
                if (this.a == null) {
                    this.a = sVar;
                    s sVar3 = this.a;
                    sVar = this.a;
                    s sVar4 = this.a;
                    sVar.g = sVar4;
                    sVar3.f = sVar4;
                } else {
                    sVar = this.a.g.a(sVar);
                    if (sVar.g == sVar) {
                        throw new IllegalStateException();
                    } else if (sVar.g.e) {
                        int i3 = sVar.c - sVar.b;
                        int i4 = 8192 - sVar.g.c;
                        if (!sVar.g.d) {
                            i = sVar.g.b;
                        }
                        if (i3 <= i4 + i) {
                            sVar.a(sVar.g, i3);
                            sVar.a();
                            t.a(sVar);
                        }
                    }
                }
                eVar.b -= j3;
                this.b += j3;
                j -= j3;
            }
        }
    }

    public final long a(e eVar, long j) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            eVar.a_(this, j);
            return j;
        }
    }

    public final long o() {
        return a((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long a(byte b, long j, long j2) {
        e eVar = this;
        long j3 = 0;
        if (j >= 0) {
            if (j2 >= j) {
                long j4 = j2 > eVar.b ? eVar.b : j2;
                if (j == j4) {
                    return -1;
                }
                s sVar = eVar.a;
                if (sVar == null) {
                    return -1;
                }
                if (eVar.b - j >= j) {
                    while (true) {
                        long j5 = j3 + ((long) (sVar.c - sVar.b));
                        if (j5 >= j) {
                            break;
                        }
                        sVar = sVar.f;
                        j3 = j5;
                    }
                } else {
                    j3 = eVar.b;
                    while (j3 > j) {
                        sVar = sVar.g;
                        j3 -= (long) (sVar.c - sVar.b);
                    }
                }
                long j6 = j;
                while (j3 < j4) {
                    byte[] bArr = sVar.a;
                    int min = (int) Math.min((long) sVar.c, (((long) sVar.b) + j4) - j3);
                    for (int i = (int) ((((long) sVar.b) + j6) - j3); i < min; i++) {
                        if (bArr[i] == b) {
                            return ((long) (i - sVar.b)) + j3;
                        }
                    }
                    byte b2 = b;
                    long j7 = j3 + ((long) (sVar.c - sVar.b));
                    sVar = sVar.f;
                    j6 = j7;
                    j3 = j6;
                }
                return -1;
            }
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(eVar.b), Long.valueOf(j), Long.valueOf(j2)}));
    }

    public final w a() {
        return w.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.b != eVar.b) {
            return false;
        }
        long j = 0;
        if (this.b == 0) {
            return true;
        }
        s sVar = this.a;
        obj = eVar.a;
        int i = sVar.b;
        int i2 = obj.b;
        while (j < this.b) {
            long min = (long) Math.min(sVar.c - i, obj.c - i2);
            int i3 = i2;
            i2 = i;
            i = 0;
            while (((long) i) < min) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (sVar.a[i2] != obj.a[i3]) {
                    return false;
                }
                i++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == sVar.c) {
                sVar = sVar.f;
                i = sVar.b;
            } else {
                i = i2;
            }
            if (i3 == obj.c) {
                obj = obj.f;
                i2 = obj.b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        s sVar = this.a;
        if (sVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = sVar.b; i2 < sVar.c; i2++) {
                i = sVar.a[i2] + (31 * i);
            }
            sVar = sVar.f;
        } while (sVar != this.a);
        return i;
    }

    public final String l() throws EOFException {
        long a = a((byte) 10, 0, Long.MAX_VALUE);
        if (a != -1) {
            return d(a);
        }
        if (Long.MAX_VALUE < this.b && b(9223372036854775806L) == (byte) 13 && b(Long.MAX_VALUE) == (byte) 10) {
            return d(Long.MAX_VALUE);
        }
        e eVar = new e();
        a(eVar, 0, Math.min(32, this.b));
        StringBuilder stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.b, Long.MAX_VALUE));
        stringBuilder.append(" content=");
        stringBuilder.append(eVar.j().hex());
        stringBuilder.append('…');
        throw new EOFException(stringBuilder.toString());
    }

    public final String toString() {
        if (this.b > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("size > Integer.MAX_VALUE: ");
            stringBuilder.append(this.b);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ByteString byteString;
        int i = (int) this.b;
        if (i == 0) {
            byteString = ByteString.EMPTY;
        } else {
            byteString = new SegmentedByteString(this, i);
        }
        return byteString.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        e eVar = new e();
        if (this.b == 0) {
            return eVar;
        }
        eVar.a = new s(this.a);
        s sVar = eVar.a;
        s sVar2 = eVar.a;
        s sVar3 = eVar.a;
        sVar2.g = sVar3;
        sVar.f = sVar3;
        sVar = this.a;
        while (true) {
            sVar = sVar.f;
            if (sVar != this.a) {
                eVar.a.g.a(new s(sVar));
            } else {
                eVar.b = this.b;
                return eVar;
            }
        }
    }
}
