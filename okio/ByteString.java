package okio;

import com.umeng.message.proguard.k;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        y.a((long) bArr.length, (long) i, (long) i2);
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new ByteString(obj);
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(y.a));
        byteString.utf8 = str;
        return byteString;
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        str = new String(this.data, y.a);
        this.utf8 = str;
        return str;
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String base64() {
        return d.a(this.data);
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (String str2) {
            throw new AssertionError(str2);
        } catch (String str22) {
            throw new IllegalArgumentException(str22);
        }
    }

    public String base64Url() {
        return d.b(this.data);
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        str = d.a(str);
        return str != null ? new ByteString(str) : null;
    }

    public String hex() {
        int i = 0;
        char[] cArr = new char[(this.data.length * 2)];
        byte[] bArr = this.data;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = HEX_DIGITS[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = HEX_DIGITS[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return of(bArr);
        }
    }

    private static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder stringBuilder = new StringBuilder("Unexpected hex digit: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 97 || b > (byte) 122) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= (byte) 97 && b2 <= (byte) 122) {
                        bArr[i2] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString substring(int i) {
        return substring(i, this.data.length);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.data.length) {
            i2 = new StringBuilder("endIndex > length(");
            i2.append(this.data.length);
            i2.append(k.t);
            throw new IllegalArgumentException(i2.toString());
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.data.length) {
                return this;
            } else {
                i2 = new byte[i3];
                System.arraycopy(this.data, i, i2, 0, i3);
                return new ByteString(i2);
            }
        }
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    byte[] internalArray() {
        return this.data;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }

    void write(e eVar) {
        eVar.b(this.data, 0, this.data.length);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.data.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && y.a(this.data, i, bArr, i2, i3) != 0;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    public final int indexOf(ByteString byteString, int i) {
        return indexOf(byteString.internalArray(), i);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.data.length - bArr.length;
        for (i = Math.max(i, 0); i <= length; i++) {
            if (y.a(this.data, i, bArr, 0, bArr.length)) {
                return i;
            }
        }
        return -1;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        return lastIndexOf(byteString.internalArray(), i);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (i = Math.min(i, this.data.length - bArr.length); i >= 0; i--) {
            if (y.a(this.data, i, bArr, 0, bArr.length)) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == this.data.length && byteString.rangeEquals(0, this.data, 0, this.data.length) != null;
        }
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.data);
        this.hashCode = i;
        return i;
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            int i2 = getByte(i) & 255;
            int i3 = byteString.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            } else {
                i++;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf8 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, 64);
        StringBuilder stringBuilder;
        if (codePointIndexToCharIndex != -1) {
            String replace = utf8.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (codePointIndexToCharIndex < utf8.length()) {
                stringBuilder = new StringBuilder("[size=");
                stringBuilder.append(this.data.length);
                stringBuilder.append(" text=");
                stringBuilder.append(replace);
                stringBuilder.append("…]");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("[text=");
            stringBuilder.append(replace);
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else if (this.data.length <= 64) {
            stringBuilder = new StringBuilder("[hex=");
            stringBuilder.append(hex());
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder("[size=");
            stringBuilder.append(this.data.length);
            stringBuilder.append(" hex=");
            stringBuilder.append(substring(0, 64).hex());
            stringBuilder.append("…]");
            return stringBuilder.toString();
        }
    }

    static int codePointIndexToCharIndex(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(java.io.ObjectInputStream r3) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.readInt();
        r3 = read(r3, r0);
        r0 = okio.ByteString.class;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = "data";	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r3 = r3.data;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.set(r2, r3);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        return;
    L_0x001a:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
    L_0x0020:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.readObject(java.io.ObjectInputStream):void");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
