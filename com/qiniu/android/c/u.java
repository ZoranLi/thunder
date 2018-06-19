package com.qiniu.android.c;

import com.qiniu.android.b.d.a;
import com.qiniu.android.d.b;
import com.qiniu.android.d.d;
import com.qiniu.android.d.e;
import com.qiniu.android.http.k;
import com.qiniu.android.http.o;
import com.xunlei.tdlive.protocol.XLLiveRequest;
import java.io.File;
import java.io.IOException;

/* compiled from: UploadManager */
public final class u implements a {
    final /* synthetic */ File a;
    final /* synthetic */ String b;
    final /* synthetic */ s c;
    final /* synthetic */ q d;
    final /* synthetic */ x e;
    final /* synthetic */ t f;

    public u(t tVar, File file, String str, s sVar, q qVar, x xVar) {
        this.f = tVar;
        this.a = file;
        this.b = str;
        this.c = sVar;
        this.d = qVar;
        this.e = xVar;
    }

    public final void a() {
        long j = 0;
        if (this.a.length() <= ((long) this.f.a.e)) {
            com.qiniu.android.http.a aVar = r1.f.b;
            a aVar2 = r1.f.a;
            File file = r1.a;
            String str = r1.b;
            s sVar = r1.c;
            q qVar = r1.d;
            x xVar = r1.e;
            e eVar = new e();
            k kVar = new k();
            if (str != null) {
                eVar.a("key", str);
                kVar.d = str;
            } else {
                kVar.d = "?";
            }
            if (file != null) {
                kVar.d = file.getName();
            }
            eVar.a("token", sVar.b);
            if (xVar == null) {
                xVar = x.a();
            }
            x xVar2 = xVar;
            eVar.a.putAll(xVar2.a);
            String str2 = null;
            if (xVar2.c) {
                if (file != null) {
                    try {
                        j = d.a(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    j = d.a(str2, str2.length);
                }
                eVar.a("crc32", String.valueOf(j));
            }
            d dVar = new d(xVar2, str);
            kVar.a = str2;
            kVar.b = file;
            kVar.e = xVar2.b;
            kVar.c = eVar;
            String a = aVar2.k.a(sVar.b, aVar2.l, str2);
            x xVar3 = xVar2;
            k kVar2 = kVar;
            e eVar2 = new e(xVar2, qVar, str, aVar2, sVar, a, aVar, kVar, dVar);
            aVar.a(a, kVar2, sVar, dVar, eVar2, xVar3.e);
            return;
        }
        String a2 = r1.f.a.b.a(r1.b, r1.a);
        q qVar2 = r1.d;
        if (r1.a != null) {
            j = r1.a.length();
        }
        b.a(new k(r1.f.b, r1.f.a, r1.a, r1.b, r1.c, new a(qVar2, j), r1.e, a2));
    }

    public final void a(int i) {
        Object obj;
        o a;
        u uVar = this;
        int i2 = i;
        if (!(i2 == -1 || i2 == -1003 || i2 == XLLiveRequest.ERROR_ALEARDY_FOLLOW || i2 == -1001)) {
            if (i2 != XLLiveRequest.ERROR_NOT_FOLLOW) {
                obj = null;
                if (obj == null) {
                    a = o.a(null, i2, "", "", "", "", "", "", 80, 0, 0, "Network error during preQuery", uVar.c, 0);
                } else {
                    a = o.a("invalid token");
                }
                uVar.d.a(uVar.b, a, null);
            }
        }
        obj = 1;
        if (obj == null) {
            a = o.a("invalid token");
        } else {
            a = o.a(null, i2, "", "", "", "", "", "", 80, 0, 0, "Network error during preQuery", uVar.c, 0);
        }
        uVar.d.a(uVar.b, a, null);
    }
}
