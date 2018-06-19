package com.igexin.push.d.a;

import com.igexin.b.a.b.a.a.m;
import com.igexin.b.a.b.c;
import com.igexin.b.a.b.d;
import com.igexin.b.a.b.f;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.a.e;
import com.igexin.push.d.c.g;
import com.igexin.push.d.c.h;
import com.igexin.push.util.EncryptUtils;
import java.util.Arrays;

public class b extends com.igexin.b.a.b.b {
    public static final String a = "com.igexin.push.d.a.b";
    public static int b = -1;
    private byte[] g;

    b(String str) {
        super(str, true);
    }

    private byte a(m mVar) {
        return (byte) b(mVar, 1);
    }

    public static com.igexin.b.a.b.b a() {
        com.igexin.b.a.b.b bVar = new b("socketProtocol");
        a aVar = new a("command", bVar);
        return bVar;
    }

    private e a(com.igexin.b.a.b.e eVar, d dVar, m mVar, g gVar) {
        if (gVar.h == (byte) 48) {
            return null;
        }
        byte a = a(mVar);
        if (a > (byte) 0) {
            a(mVar, a);
        }
        gVar.f = a(mVar);
        gVar.o = a(mVar);
        if (gVar.o > 0) {
            gVar.n = a(mVar, gVar.o);
        }
        if (gVar.e == 0) {
            c.b().a(new h());
            c.b().c();
            return null;
        }
        byte[] a2 = a(mVar, 11);
        int d = f.d(a2, 0);
        if (d <= b) {
            b = -1;
            throw new Exception("server packetId can't be less than previous");
        }
        b = d;
        int d2 = f.d(a2, 4);
        short b = f.b(a2, 8);
        int a3 = f.a(a2, 10);
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.a = b;
        bVar.b = (byte) a3;
        bVar.f = gVar.c;
        bVar.g = gVar.h;
        StringBuilder stringBuilder;
        if (b > (short) 0) {
            byte[] a4 = a(mVar, b);
            if (gVar.h == (byte) 16) {
                a4 = EncryptUtils.aesDecSocket(a4, EncryptUtils.getIV(f.b(d2)));
            } else if (gVar.h == (byte) 32) {
                if (a3 != 26) {
                    return null;
                }
                a4 = EncryptUtils.altAesDecSocket(a4, f.b(d2));
            } else if (gVar.h != (byte) 0) {
                return gVar.h == (byte) 48 ? null : null;
            }
            if (gVar.g == Byte.MIN_VALUE) {
                a4 = f.d(a4);
            } else if (gVar.g != (byte) 0) {
                return null;
            }
            bVar.a(a4);
            if (!Arrays.equals(gVar.n, EncryptUtils.getSocketSignature(bVar, d, d2))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|decode signature error!!!!");
                a.b(stringBuilder.toString());
                return null;
            }
        } else if (bVar.a < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|data len < 0, error");
            a.b(stringBuilder.toString());
            return null;
        }
        if (this.d != null) {
            c.b().a(this.d.c(eVar, dVar, bVar));
        }
        c.b().c();
        return null;
    }

    static g a(com.igexin.push.d.c.b bVar) {
        g gVar = new g();
        gVar.a = 1944742139;
        gVar.a(bVar.c);
        gVar.e = bVar.b > (byte) 0 ? 1 : 0;
        gVar.c = 7;
        gVar.b = 11;
        gVar.f = bVar.d;
        gVar.b += EncryptUtils.getRSAKeyId().length;
        if (bVar.a > 0) {
            gVar.p = EncryptUtils.getPacketId();
            gVar.q = (int) (System.currentTimeMillis() / 1000);
            gVar.n = EncryptUtils.getSocketSignature(bVar, gVar.p, gVar.q);
            gVar.o = gVar.n.length;
        } else {
            if (gVar.h == (byte) 0) {
                gVar.o = 0;
            }
            c.d();
            return gVar;
        }
        gVar.b += gVar.o;
        c.d();
        return gVar;
    }

    private byte[] a(m mVar, int i) {
        byte[] bArr = new byte[i];
        mVar.a(bArr);
        return bArr;
    }

    private int b(m mVar, int i) {
        byte[] a = a(mVar, i);
        return i == 1 ? f.a(a, 0) : i == 2 ? f.b(a, 0) : i == 4 ? f.d(a, 0) : 0;
    }

    private e b(com.igexin.b.a.b.e eVar, d dVar, m mVar, g gVar) {
        if (gVar.h == (byte) 48) {
            byte a = a(mVar);
            if (a > (byte) 0) {
                this.g = a(mVar, a);
            }
        }
        if (gVar.e == 0) {
            c.b().a(new h());
        } else {
            byte[] a2 = a(mVar, 3);
            short b = f.b(a2, 0);
            int a3 = f.a(a2, 2);
            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
            bVar.a = b;
            bVar.b = (byte) a3;
            bVar.f = gVar.c;
            if (a3 != 26) {
                return null;
            }
            if (bVar.a > 0) {
                byte[] a4 = a(mVar, b);
                if (gVar.h == (byte) 48) {
                    a4 = com.igexin.b.a.a.a.a(a4, this.g == null ? c.b().a() : com.igexin.b.b.a.a(this.g));
                }
                if (gVar.g == Byte.MIN_VALUE) {
                    a4 = f.d(a4);
                } else if (gVar.g != (byte) 0) {
                    return null;
                }
                bVar.a(a4);
            }
            if (this.d != null) {
                c.b().a(this.d.c(eVar, dVar, bVar));
            }
        }
        c.b().c();
        return null;
    }

    public Object a(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        Object obj2 = null;
        if (obj instanceof com.igexin.push.d.c.b) {
            int a;
            com.igexin.push.d.c.b bVar = (com.igexin.push.d.c.b) obj;
            g a2 = a(bVar);
            if (bVar.b > (byte) 0 && bVar.a > 0) {
                if ((a2.g & 192) == 128) {
                    bVar.a(f.c(bVar.e));
                }
                if ((a2.h & 48) == 16) {
                    byte[] iv = EncryptUtils.getIV(f.b(a2.q));
                    if ((a2.f & 16) != 16) {
                        bVar.a(EncryptUtils.aesEncSocket(bVar.e, iv));
                    }
                } else if ((a2.h & 48) != 0) {
                    String stringBuilder;
                    if ((a2.h & 48) == 48) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(a);
                        stringBuilder2.append("|encry type = 0x30 not support");
                        stringBuilder = stringBuilder2.toString();
                    } else if ((a2.h & 48) == 32) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(a);
                        stringBuilder3.append("|encry type = 0x20 reserved");
                        a.b(stringBuilder3.toString());
                    } else {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(a);
                        stringBuilder4.append("|encry type = ");
                        stringBuilder4.append(a2.h & 48);
                        stringBuilder4.append(" not support");
                        stringBuilder = stringBuilder4.toString();
                    }
                    a.b(stringBuilder);
                    return null;
                }
            }
            obj2 = new byte[(a2.b + (bVar.b > (byte) 0 ? bVar.a + 11 : 0))];
            int a3 = f.a(1944742139, obj2, 0);
            a3 += f.c(a2.b, obj2, a3);
            a3 += f.c(a2.c, obj2, a3);
            a3 += f.c(a2.a(), obj2, a3);
            a3 += f.c(a2.e, obj2, a3);
            byte[] rSAKeyId = EncryptUtils.getRSAKeyId();
            a3 += f.c(rSAKeyId.length, obj2, a3);
            a3 += f.a(rSAKeyId, 0, obj2, a3, rSAKeyId.length);
            a3 += f.c(a2.b(), obj2, a3);
            if (bVar.a > 0) {
                a3 += f.c(a2.o, obj2, a3);
                a = f.a(a2.n, 0, obj2, a3, a2.o);
            } else {
                a = f.c(0, obj2, a3);
            }
            a3 += a;
            if (bVar.b > (byte) 0) {
                a3 += f.a(a2.p, obj2, a3);
                a3 += f.a(a2.q, obj2, a3);
                a3 += f.b(bVar.a, obj2, a3);
                a3 += f.c(bVar.b, obj2, a3);
                if (bVar.a > 0) {
                    f.a(bVar.e, 0, obj2, a3, bVar.a);
                }
            }
        }
        return obj2;
    }

    public e b(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        StringBuilder stringBuilder;
        String str;
        m mVar = obj instanceof m ? (m) obj : null;
        if (mVar == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            str = "|syncIns is null";
        } else {
            byte[] a = a(mVar, 8);
            if (f.d(a, 0) != 1944742139) {
                return null;
            }
            g gVar = new g();
            gVar.b = a[4] & 255;
            gVar.c = a[5] & 255;
            gVar.a(a[6]);
            gVar.e = a[7] & 255;
            if (gVar.c == 7) {
                return a(eVar, dVar, mVar, gVar);
            }
            if (gVar.c == 1) {
                return b(eVar, dVar, mVar, gVar);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|server socket resp version = ");
            stringBuilder.append(gVar.c);
            str = ", not support !!!";
        }
        stringBuilder.append(str);
        a.b(stringBuilder.toString());
        return null;
    }

    public /* synthetic */ Object c(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        return b(eVar, dVar, obj);
    }
}
