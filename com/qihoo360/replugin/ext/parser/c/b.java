package com.qihoo360.replugin.ext.parser.c;

import com.qihoo360.replugin.ext.parser.b.a;
import com.qihoo360.replugin.ext.parser.b.c;
import com.qihoo360.replugin.ext.parser.b.d;
import com.qihoo360.replugin.ext.parser.exception.ParserException;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: ParseUtils */
public final class b {
    public static Charset a = Charset.forName("UTF-8");

    private static int b(ByteBuffer byteBuffer) {
        int a = a.a(byteBuffer);
        return (a & 128) != 0 ? (((a & Opcodes.NEG_FLOAT) << 7) | 0) + a.a(byteBuffer) : a;
    }

    public static c a(ByteBuffer byteBuffer, d dVar) {
        Object obj;
        ByteBuffer byteBuffer2 = byteBuffer;
        a aVar = dVar;
        long position = (long) byteBuffer.position();
        long[] jArr = new long[((int) aVar.c)];
        if (aVar.c > 0) {
            for (int i = 0; ((long) i) < aVar.c; i++) {
                jArr[i] = a.b(byteBuffer);
            }
        }
        Object obj2 = (aVar.e & 256) != 0 ? 1 : null;
        long j = (position + aVar.f) - ((long) aVar.b);
        byteBuffer2.position((int) j);
        com.qihoo360.replugin.ext.parser.a.b[] bVarArr = new com.qihoo360.replugin.ext.parser.a.b[jArr.length];
        int i2 = 0;
        while (i2 < jArr.length) {
            obj = obj2;
            bVarArr[i2] = new com.qihoo360.replugin.ext.parser.a.b(i2, j + jArr[i2]);
            i2++;
            obj2 = obj;
        }
        obj = obj2;
        long j2 = -1;
        c cVar = new c((int) aVar.c);
        String str = null;
        for (com.qihoo360.replugin.ext.parser.a.b bVar : bVarArr) {
            if (bVar.b == j2) {
                cVar.a[bVar.a] = str;
            } else {
                String str2;
                byteBuffer2.position((int) bVar.b);
                j2 = bVar.b;
                if (obj != null) {
                    b(byteBuffer);
                    byte[] bArr = new byte[b(byteBuffer)];
                    byteBuffer2.get(bArr);
                    str2 = new String(bArr, a);
                    a.a(byteBuffer);
                } else {
                    int i3 = byteBuffer.getShort() & 65535;
                    if ((32768 & i3) != 0) {
                        i3 = (((i3 & 32767) << 15) | 0) + (65535 & byteBuffer.getShort());
                    }
                    str2 = a.a(byteBuffer2, i3);
                    byteBuffer.getShort();
                }
                cVar.a[bVar.a] = str2;
                str = str2;
            }
        }
        byteBuffer2.position((int) (position + ((long) dVar.a())));
        return cVar;
    }

    public static void a(int i) {
        if (1 != i) {
            StringBuilder stringBuilder = new StringBuilder("Expect chunk type:");
            stringBuilder.append(Integer.toHexString(1));
            stringBuilder.append(", but got:");
            stringBuilder.append(Integer.toHexString(i));
            throw new ParserException(stringBuilder.toString());
        }
    }

    public static com.qihoo360.replugin.ext.parser.b.b a(ByteBuffer byteBuffer) {
        byteBuffer.getShort();
        a.a(byteBuffer);
        return new a(byteBuffer.getInt(), a.a(byteBuffer));
    }
}
