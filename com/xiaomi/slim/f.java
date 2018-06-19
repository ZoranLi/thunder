package com.xiaomi.slim;

import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.az;
import com.xiaomi.smack.a;
import com.xiaomi.smack.b;
import com.xiaomi.smack.h;
import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;

public class f extends h {
    private Thread w;
    private c x;
    private d y;
    private byte[] z;

    public f(XMPushService xMPushService, b bVar) {
        super(xMPushService, bVar);
    }

    private com.xiaomi.slim.b c(boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new com.xiaomi.slim.b;
        r0.<init>();
        r1 = "PING";
        r2 = 0;
        r0.a(r1, r2);
        if (r4 == 0) goto L_0x0013;
    L_0x000d:
        r4 = "1";
    L_0x000f:
        r0.a(r4);
        goto L_0x0016;
    L_0x0013:
        r4 = "0";
        goto L_0x000f;
    L_0x0016:
        r4 = new com.xiaomi.push.protobuf.b$j;
        r4.<init>();
        r1 = r3.d();
        r1 = r1.a();
        if (r1 == 0) goto L_0x002c;
    L_0x0025:
        r1 = com.xiaomi.push.protobuf.b.b.b(r1);	 Catch:{ d -> 0x002c }
        r4.a(r1);	 Catch:{ d -> 0x002c }
    L_0x002c:
        r1 = com.xiaomi.stats.h.c();
        if (r1 == 0) goto L_0x0039;
    L_0x0032:
        r1 = com.google.protobuf.micro.a.a(r1);
        r4.a(r1);
    L_0x0039:
        r4 = r4.c();
        r0.a(r4, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.slim.f.c(boolean):com.xiaomi.slim.b");
    }

    private void x() {
        try {
            this.x = new c(this.q.getInputStream(), this);
            this.y = new d(this.q.getOutputStream(), this);
            StringBuilder stringBuilder = new StringBuilder("Blob Reader (");
            stringBuilder.append(this.l);
            stringBuilder.append(k.t);
            this.w = new g(this, stringBuilder.toString());
            this.w.start();
        } catch (Throwable e) {
            throw new l("Error to init reader and writer", e);
        }
    }

    protected synchronized void a(int i, Exception exception) {
        if (this.x != null) {
            this.x.b();
            this.x = null;
        }
        if (this.y != null) {
            try {
                this.y.b();
            } catch (Throwable e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.y = null;
        }
        this.z = null;
        super.a(i, exception);
    }

    public synchronized void a(ap.b bVar) {
        a.a(bVar, s(), (a) this);
    }

    void a(b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder;
            if (bVar.d()) {
                stringBuilder = new StringBuilder("[Slim] RCV blob chid=");
                stringBuilder.append(bVar.c());
                stringBuilder.append("; id=");
                stringBuilder.append(bVar.h());
                stringBuilder.append("; errCode=");
                stringBuilder.append(bVar.e());
                stringBuilder.append("; err=");
                stringBuilder.append(bVar.f());
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            }
            if (bVar.c() == 0) {
                if ("PING".equals(bVar.a())) {
                    stringBuilder = new StringBuilder("[Slim] RCV ping id=");
                    stringBuilder.append(bVar.h());
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                    w();
                } else if ("CLOSE".equals(bVar.a())) {
                    c(13, null);
                }
            }
            for (a.a a : this.g.values()) {
                a.a(bVar);
            }
        }
    }

    @Deprecated
    public void a(d dVar) {
        b(b.a(dVar, null));
    }

    public synchronized void a(String str, String str2) {
        a.a(str, str2, (a) this);
    }

    protected void a(boolean z) {
        if (this.y != null) {
            b c = c(z);
            StringBuilder stringBuilder = new StringBuilder("[Slim] SND ping id=");
            stringBuilder.append(c.h());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            b(c);
            v();
            return;
        }
        throw new l("The BlobWriter is null.");
    }

    public void a(b[] bVarArr) {
        for (b b : bVarArr) {
            b(b);
        }
    }

    synchronized byte[] a() {
        if (this.z == null && !TextUtils.isEmpty(this.j)) {
            String e = az.e();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.j.substring(this.j.length() / 2));
            stringBuilder.append(e.substring(e.length() / 2));
            this.z = aw.a(this.j.getBytes(), stringBuilder.toString().getBytes());
        }
        return this.z;
    }

    public void b(b bVar) {
        if (this.y != null) {
            try {
                int a = this.y.a(bVar);
                this.o = System.currentTimeMillis();
                Object i = bVar.i();
                if (!TextUtils.isEmpty(i)) {
                    g.a(this.n, i, (long) a, false, System.currentTimeMillis());
                }
                for (a.a a2 : this.h.values()) {
                    a2.a(bVar);
                }
                return;
            } catch (Throwable e) {
                throw new l(e);
            }
        }
        throw new l("the writer is null.");
    }

    void b(d dVar) {
        if (dVar != null) {
            for (a.a a : this.g.values()) {
                a.a(dVar);
            }
        }
    }

    public boolean b() {
        return true;
    }

    protected synchronized void c() {
        x();
        this.y.a();
    }
}
