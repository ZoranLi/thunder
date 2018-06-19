package com.qihoo360.replugin.ext.parser.a;

import android.support.v4.view.InputDeviceCompat;
import com.qihoo360.replugin.ext.parser.b.a.d;
import com.qihoo360.replugin.ext.parser.b.a.h;
import com.qihoo360.replugin.ext.parser.b.a.j;
import com.qihoo360.replugin.ext.parser.b.c;
import com.qihoo360.replugin.ext.parser.exception.ParserException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: BinaryXmlParser */
public final class a {
    public c a;
    public String[] b;
    public ByteBuffer c;
    public d d;
    private ByteOrder e = ByteOrder.LITTLE_ENDIAN;

    public a(ByteBuffer byteBuffer) {
        this.c = byteBuffer.duplicate();
        this.c.order(this.e);
    }

    public final com.qihoo360.replugin.ext.parser.b.a a() {
        if (!this.c.hasRemaining()) {
            return null;
        }
        long position = (long) this.c.position();
        int i = this.c.getShort() & 65535;
        int i2 = 65535 & this.c.getShort();
        long b = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
        if (i == 3) {
            return new d(i, i2, b);
        }
        if (i != 384) {
            com.qihoo360.replugin.ext.parser.b.a dVar;
            switch (i) {
                case 0:
                    return new com.qihoo360.replugin.ext.parser.b.a.c(i, i2, b);
                case 1:
                    dVar = new com.qihoo360.replugin.ext.parser.b.d(i, i2, b);
                    dVar.c = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                    dVar.d = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                    dVar.e = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                    dVar.f = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                    dVar.g = com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                    this.c.position((int) (position + ((long) i2)));
                    return dVar;
                default:
                    switch (i) {
                        case 256:
                        case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                        case 258:
                        case 259:
                        case 260:
                            dVar = new h(i, i2, b);
                            dVar.c = (int) com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                            dVar.d = (int) com.qihoo360.replugin.ext.parser.c.a.b(this.c);
                            this.c.position((int) (position + ((long) i2)));
                            return dVar;
                        default:
                            StringBuilder stringBuilder = new StringBuilder("Unexpected chunk type:");
                            stringBuilder.append(i);
                            throw new ParserException(stringBuilder.toString());
                    }
            }
        }
        this.c.position((int) (position + ((long) i2)));
        return new j(i, i2, b);
    }
}
