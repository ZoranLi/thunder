package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(e eVar, int i) {
        super(null);
        y.a(eVar.b, 0, (long) i);
        int i2 = 0;
        s sVar = eVar.a;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            if (sVar.c == sVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += sVar.c - sVar.b;
            i4++;
            sVar = sVar.f;
        }
        this.segments = new byte[i4][];
        this.directory = new int[(i4 * 2)];
        s sVar2 = eVar.a;
        eVar = null;
        while (i2 < i) {
            this.segments[eVar] = sVar2.a;
            i2 += sVar2.c - sVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            this.directory[eVar] = i2;
            this.directory[this.segments.length + eVar] = sVar2.b;
            sVar2.d = true;
            eVar++;
            sVar2 = sVar2.f;
        }
    }

    public final String utf8() {
        return a().utf8();
    }

    public final String string(Charset charset) {
        return a().string(charset);
    }

    public final String base64() {
        return a().base64();
    }

    public final String hex() {
        return a().hex();
    }

    public final ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    public final ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    public final ByteString md5() {
        return a().md5();
    }

    public final ByteString sha1() {
        return a().sha1();
    }

    public final ByteString sha256() {
        return a().sha256();
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return a().hmacSha1(byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return a().hmacSha256(byteString);
    }

    public final String base64Url() {
        return a().base64Url();
    }

    public final ByteString substring(int i) {
        return a().substring(i);
    }

    public final ByteString substring(int i, int i2) {
        return a().substring(i, i2);
    }

    public final byte getByte(int i) {
        int i2;
        y.a((long) this.directory[this.segments.length - 1], (long) i, 1);
        int a = a(i);
        if (a == 0) {
            i2 = 0;
        } else {
            i2 = this.directory[a - 1];
        }
        return this.segments[a][(i - i2) + this.directory[this.segments.length + a]];
    }

    private int a(int i) {
        i = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return i >= 0 ? i : i ^ -1;
    }

    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    public final byte[] toByteArray() {
        int i = 0;
        Object obj = new byte[this.directory[this.segments.length - 1]];
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            System.arraycopy(this.segments[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int i = 0;
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    final void write(e eVar) {
        int i = 0;
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            s sVar = new s(this.segments[i], i3, (i3 + i4) - i2);
            if (eVar.a == null) {
                sVar.g = sVar;
                sVar.f = sVar;
                eVar.a = sVar;
            } else {
                eVar.a.g.a(sVar);
            }
            i++;
            i2 = i4;
        }
        eVar.b += (long) i2;
    }

    public final boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i >= 0) {
            if (i <= size() - i3) {
                int a = a(i);
                while (i3 > 0) {
                    int i4;
                    if (a == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.directory[a - 1];
                    }
                    int min = Math.min(i3, ((this.directory[a] - i4) + i4) - i);
                    if (!byteString.rangeEquals(i2, this.segments[a], (i - i4) + this.directory[this.segments.length + a], min)) {
                        return false;
                    }
                    i += min;
                    i2 += min;
                    i3 -= min;
                    a++;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= size() - i3 && i2 >= 0) {
            if (i2 <= bArr.length - i3) {
                int a = a(i);
                while (i3 > 0) {
                    int i4;
                    if (a == 0) {
                        i4 = 0;
                    } else {
                        i4 = this.directory[a - 1];
                    }
                    int min = Math.min(i3, ((this.directory[a] - i4) + i4) - i);
                    if (!y.a(this.segments[a], (i - i4) + this.directory[this.segments.length + a], bArr, i2, min)) {
                        return false;
                    }
                    i += min;
                    i2 += min;
                    i3 -= min;
                    a++;
                }
                return true;
            }
        }
        return false;
    }

    public final int indexOf(byte[] bArr, int i) {
        return a().indexOf(bArr, i);
    }

    public final int lastIndexOf(byte[] bArr, int i) {
        return a().lastIndexOf(bArr, i);
    }

    private ByteString a() {
        return new ByteString(toByteArray());
    }

    final byte[] internalArray() {
        return toByteArray();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size()) != null;
        }
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        i = this.segments.length;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            byte[] bArr = this.segments[i2];
            int i5 = this.directory[i + i2];
            int i6 = this.directory[i2];
            i4 = (i6 - i4) + i5;
            while (i5 < i4) {
                i3 = bArr[i5] + (31 * i3);
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        return a().toString();
    }

    private Object writeReplace() {
        return a();
    }
}
