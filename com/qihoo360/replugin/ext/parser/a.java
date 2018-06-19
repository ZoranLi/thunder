package com.qihoo360.replugin.ext.parser;

import android.support.v4.view.InputDeviceCompat;
import com.qihoo360.replugin.ext.parser.a.e;
import com.qihoo360.replugin.ext.parser.b.a.f;
import com.qihoo360.replugin.ext.parser.b.a.g;
import com.qihoo360.replugin.ext.parser.b.a.i;
import com.qihoo360.replugin.ext.parser.b.a.j;
import com.qihoo360.replugin.ext.parser.b.d;
import com.qihoo360.replugin.ext.parser.c.b;
import com.qihoo360.replugin.ext.parser.exception.ParserException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: AbstractApkParser */
public abstract class a implements Closeable {
    private String a;

    public abstract byte[] a(String str) throws IOException;

    public void close() throws IOException {
    }

    public final String a() throws IOException {
        if (this.a == null) {
            Object eVar = new e();
            byte[] a = a(ShareConstants.RES_MANIFEST);
            if (a == null) {
                throw new ParserException("Manifest file not found");
            }
            com.qihoo360.replugin.ext.parser.a.a aVar = new com.qihoo360.replugin.ext.parser.a.a(ByteBuffer.wrap(a));
            aVar.d = eVar;
            com.qihoo360.replugin.ext.parser.b.a a2 = aVar.a();
            if (a2 != null && (a2.a == 3 || a2.a == 0)) {
                a2 = aVar.a();
                if (a2 != null) {
                    b.a(a2.a);
                    aVar.a = b.a(aVar.c, (d) a2);
                    a2 = aVar.a();
                    if (a2 != null) {
                        if (a2.a == 384) {
                            int a3 = ((j) a2).a() / 4;
                            long[] jArr = new long[a3];
                            for (int i = 0; i < a3; i++) {
                                jArr[i] = com.qihoo360.replugin.ext.parser.c.a.b(aVar.c);
                            }
                            aVar.b = new String[jArr.length];
                            a2 = aVar.a();
                        }
                        while (a2 != null) {
                            long position = (long) aVar.c.position();
                            int i2;
                            int i3;
                            switch (a2.a) {
                                case 256:
                                    i2 = aVar.c.getInt();
                                    i3 = aVar.c.getInt();
                                    f fVar = new f();
                                    if (i2 > 0) {
                                        fVar.a = aVar.a.a[i2];
                                    }
                                    if (i3 > 0) {
                                        fVar.b = aVar.a.a[i3];
                                    }
                                    aVar.d.a(fVar);
                                    break;
                                case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                                    i2 = aVar.c.getInt();
                                    i3 = aVar.c.getInt();
                                    com.qihoo360.replugin.ext.parser.b.a.e eVar2 = new com.qihoo360.replugin.ext.parser.b.a.e();
                                    if (i2 > 0) {
                                        eVar2.a = aVar.a.a[i2];
                                    }
                                    if (i3 > 0) {
                                        eVar2.b = aVar.a.a[i3];
                                    }
                                    aVar.d.a(eVar2);
                                    break;
                                case 258:
                                    i2 = aVar.c.getInt();
                                    i3 = aVar.c.getInt();
                                    i iVar = new i();
                                    if (i2 > 0) {
                                        iVar.a = aVar.a.a[i2];
                                    }
                                    iVar.b = aVar.a.a[i3];
                                    aVar.c.getShort();
                                    aVar.c.getShort();
                                    i2 = aVar.c.getShort() & 65535;
                                    aVar.c.getShort();
                                    aVar.c.getShort();
                                    aVar.c.getShort();
                                    com.qihoo360.replugin.ext.parser.b.a.b bVar = new com.qihoo360.replugin.ext.parser.b.a.b(i2);
                                    for (int i4 = 0; i4 < i2; i4++) {
                                        int i5 = aVar.c.getInt();
                                        int i6 = aVar.c.getInt();
                                        com.qihoo360.replugin.ext.parser.b.a.a aVar2 = new com.qihoo360.replugin.ext.parser.b.a.a();
                                        if (i5 > 0) {
                                            aVar2.a = aVar.a.a[i5];
                                        }
                                        aVar2.b = aVar.a.a[i6];
                                        if (aVar2.b.isEmpty() && aVar.b != null && i6 < aVar.b.length) {
                                            aVar2.b = aVar.b[i6];
                                        }
                                        i5 = aVar.c.getInt();
                                        if (i5 > 0) {
                                            aVar2.c = aVar.a.a[i5];
                                        }
                                        b.a(aVar.c);
                                        if (aVar.d != null) {
                                            aVar2.d = aVar2.c;
                                            bVar.a[i4] = aVar2;
                                        }
                                    }
                                    iVar.c = bVar;
                                    if (aVar.d == null) {
                                        break;
                                    }
                                    aVar.d.a(iVar);
                                    break;
                                case 259:
                                    g gVar = new g();
                                    i3 = aVar.c.getInt();
                                    int i7 = aVar.c.getInt();
                                    if (i3 > 0) {
                                        gVar.a = aVar.a.a[i3];
                                    }
                                    gVar.b = aVar.a.a[i7];
                                    if (aVar.d == null) {
                                        break;
                                    }
                                    aVar.d.a(gVar);
                                    break;
                                case 260:
                                    break;
                                default:
                                    if (a2.a >= 256 && a2.a <= 383) {
                                        ByteBuffer byteBuffer = aVar.c;
                                        byteBuffer.position(byteBuffer.position() + a2.a());
                                        break;
                                    }
                                    StringBuilder stringBuilder = new StringBuilder("Unexpected chunk type:");
                                    stringBuilder.append(a2.a);
                                    throw new ParserException(stringBuilder.toString());
                                    break;
                            }
                            aVar.c.position((int) (position + ((long) a2.a())));
                            a2 = aVar.a();
                        }
                    }
                }
            }
            this.a = eVar.a.toString();
        }
        return this.a;
    }
}
