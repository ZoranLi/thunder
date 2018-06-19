package com.qiniu.android.dns.local;

import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.c;
import com.qiniu.android.dns.f;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: AndroidDnsServer */
public final class b implements c {
    public final f[] a(com.qiniu.android.dns.b bVar, NetworkInfo networkInfo) throws IOException {
        InetAddress[] b = a.b();
        if (b == null) {
            b = a.a();
        }
        if (b == null) {
            throw new IOException("cant get local dns server");
        }
        int i;
        int i2;
        networkInfo = new d(new f(b[0])).a(bVar, networkInfo);
        if (bVar.b) {
            for (f a : networkInfo) {
                f a2;
                if (a2.a()) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 == 0) {
                throw new DnshijackingException(bVar.a, b[0].getHostAddress());
            }
        }
        if (bVar.c != 0) {
            i2 = networkInfo.length;
            i = 0;
            while (i < i2) {
                a2 = networkInfo[i];
                if (a2.a() || a2.c <= bVar.c) {
                    i++;
                } else {
                    throw new DnshijackingException(bVar.a, b[0].getHostAddress(), a2.c);
                }
            }
        }
        return networkInfo;
    }
}
