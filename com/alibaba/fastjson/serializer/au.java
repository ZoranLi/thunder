package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* compiled from: SerialWriterStringEncoder */
public final class au {
    static final ThreadLocal<SoftReference<byte[]>> b = new ThreadLocal();
    final CharsetEncoder a;

    public au(Charset charset) {
        this(charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    private au(CharsetEncoder charsetEncoder) {
        this.a = charsetEncoder;
    }

    public final byte[] a(char[] cArr, int i, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        try {
            cArr = this.a.encode(CharBuffer.wrap(cArr, 0, i), wrap, true);
            if (cArr.isUnderflow() == 0) {
                cArr.throwException();
            }
            cArr = this.a.flush(wrap);
            if (cArr.isUnderflow() == 0) {
                cArr.throwException();
            }
            cArr = wrap.position();
            i = new byte[cArr];
            System.arraycopy(bArr, 0, i, 0, cArr);
            return i;
        } catch (char[] cArr2) {
            throw new JSONException(cArr2.getMessage(), cArr2);
        }
    }

    static byte[] a(int i) {
        if (i > 131072) {
            return new byte[i];
        }
        if ((i >>> 10) <= 0) {
            i = 1024;
        } else {
            i = 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        i = new byte[i];
        b.set(new SoftReference(i));
        return i;
    }
}
