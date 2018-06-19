package com.qiniu.android.c;

import com.qiniu.android.b.d;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.c;
import com.qiniu.android.dns.local.b;
import com.qiniu.android.dns.local.f;
import com.qiniu.android.http.m;
import com.qiniu.android.http.q;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: Configuration */
public final class a {
    public final j a;
    public final h b;
    public final m c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public q i;
    public com.qiniu.android.dns.a j;
    public d k;
    public boolean l;

    /* compiled from: Configuration */
    public static class a {
        public d a = null;
        public j b = null;
        public h c = null;
        m d = null;
        boolean e = false;
        public int f = 262144;
        public int g = 524288;
        public int h = 10;
        public int i = 60;
        int j = 3;
        q k = null;
        com.qiniu.android.dns.a l = null;

        public a() {
            Object obj = null;
            b bVar = new b();
            try {
                obj = new f(InetAddress.getByName("119.29.29.29"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.l = new com.qiniu.android.dns.a(NetworkInfo.b, new c[]{bVar, obj});
        }

        public final a a() {
            return new a();
        }
    }

    private a(a aVar) {
        d dVar;
        this.l = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.a = aVar.b;
        h hVar = aVar.c;
        if (hVar == null) {
            hVar = new b(this);
        }
        this.b = hVar;
        this.h = aVar.j;
        this.c = aVar.d;
        this.i = aVar.k;
        if (aVar.a == null) {
            dVar = com.qiniu.android.b.a.a;
        } else {
            dVar = aVar.a;
        }
        this.k = dVar;
        this.j = aVar.l;
    }
}
