package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.a;
import com.xiaomi.push.service.aw;
import com.xiaomi.smack.util.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class b {
    private static String b;
    private static long c;
    private static final byte[] f = new byte[0];
    String a;
    private a d;
    private short e;
    private byte[] g;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.a(5));
        stringBuilder.append("-");
        b = stringBuilder.toString();
    }

    public b() {
        this.e = (short) 2;
        this.g = f;
        this.a = null;
        this.d = new a();
    }

    b(a aVar, short s, byte[] bArr) {
        this.e = (short) 2;
        this.g = f;
        this.a = null;
        this.d = aVar;
        this.e = s;
        this.g = bArr;
    }

    @Deprecated
    public static b a(com.xiaomi.smack.packet.d dVar, String str) {
        int parseInt;
        b bVar = new b();
        try {
            parseInt = Integer.parseInt(dVar.l());
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("Blob parse chid err ");
            stringBuilder.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            parseInt = 1;
        }
        bVar.a(parseInt);
        bVar.a(dVar.k());
        bVar.c(dVar.n());
        bVar.b(dVar.o());
        bVar.a("XMLMSG", null);
        try {
            bVar.a(dVar.c().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                bVar.a((short) 3);
                return bVar;
            }
            bVar.a((short) 2);
            bVar.a("SECMSG", null);
            return bVar;
        } catch (UnsupportedEncodingException e2) {
            StringBuilder stringBuilder2 = new StringBuilder("Blob setPayload err： ");
            stringBuilder2.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
            return bVar;
        }
    }

    static b b(ByteBuffer byteBuffer) {
        try {
            byteBuffer = byteBuffer.slice();
            short s = byteBuffer.getShort(0);
            short s2 = byteBuffer.getShort(2);
            int i = byteBuffer.getInt(4);
            a aVar = new a();
            aVar.b(byteBuffer.array(), byteBuffer.arrayOffset() + 8, s2);
            byte[] bArr = new byte[i];
            byteBuffer.position(8 + s2);
            byteBuffer.get(bArr, 0, i);
            return new b(aVar, s, bArr);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("read Blob err :");
            stringBuilder.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String g() {
        String stringBuilder;
        synchronized (b.class) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(b);
            long j = c;
            c = j + 1;
            stringBuilder2.append(Long.toString(j));
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    public String a() {
        return this.d.l();
    }

    ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(l());
        }
        byteBuffer.putShort(this.e);
        byteBuffer.putShort((short) this.d.a());
        byteBuffer.putInt(this.g.length);
        int position = byteBuffer.position();
        this.d.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.d.a());
        byteBuffer.position(position + this.d.a());
        byteBuffer.put(this.g);
        return byteBuffer;
    }

    public void a(int i) {
        this.d.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.d.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.d.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.d.b(str2);
        }
    }

    public void a(String str) {
        this.d.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.d.c(str);
        this.d.p();
        if (!TextUtils.isEmpty(str2)) {
            this.d.d(str2);
        }
    }

    public void a(short s) {
        this.e = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.c(0);
        } else {
            this.d.c(1);
            bArr = aw.a(aw.a(str, h()), bArr);
        }
        this.g = bArr;
    }

    public String b() {
        return this.d.n();
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        return this.d.d();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                str = str.substring(indexOf2 + 1);
                this.d.a(parseLong);
                this.d.a(substring);
                this.d.b(str);
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("Blob parse user err ");
                stringBuilder.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            }
        }
    }

    public boolean d() {
        return this.d.x();
    }

    public byte[] d(String str) {
        if (this.d.u() == 1) {
            return aw.a(aw.a(str, h()), this.g);
        }
        if (this.d.u() == 0) {
            return this.g;
        }
        StringBuilder stringBuilder = new StringBuilder("unknow cipher = ");
        stringBuilder.append(this.d.u());
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        return this.g;
    }

    public int e() {
        return this.d.w();
    }

    public String f() {
        return this.d.y();
    }

    public String h() {
        String q = this.d.q();
        if ("ID_NOT_AVAILABLE".equals(q)) {
            return null;
        }
        if (!this.d.r()) {
            q = g();
            this.d.e(q);
        }
        return q;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        if (!this.d.g()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Long.toString(this.d.f()));
        stringBuilder.append("@");
        stringBuilder.append(this.d.h());
        stringBuilder.append("/");
        stringBuilder.append(this.d.j());
        return stringBuilder.toString();
    }

    public byte[] k() {
        return this.g;
    }

    public int l() {
        return (8 + this.d.b()) + this.g.length;
    }

    public short m() {
        return this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Blob [chid=");
        stringBuilder.append(c());
        stringBuilder.append("; Id=");
        stringBuilder.append(h());
        stringBuilder.append("; cmd=");
        stringBuilder.append(a());
        stringBuilder.append("; type=");
        stringBuilder.append(m());
        stringBuilder.append("; from=");
        stringBuilder.append(j());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
