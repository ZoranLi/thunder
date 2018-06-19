package com.qiniu.android.dns.local;

import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.b;
import com.qiniu.android.dns.c;
import com.qiniu.android.dns.f;
import java.io.IOException;

/* compiled from: HijackingDetectWrapper */
public final class d implements c {
    private final f a;

    public d(f fVar) {
        this.a = fVar;
    }

    public final f[] a(b bVar, NetworkInfo networkInfo) throws IOException {
        int i;
        networkInfo = this.a.a(bVar, networkInfo);
        int i2 = 0;
        if (bVar.b) {
            for (f a : networkInfo) {
                if (a.a()) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                throw new DnshijackingException(bVar.a, this.a.a.getHostAddress());
            }
        }
        if (bVar.c != 0) {
            i = networkInfo.length;
            while (i2 < i) {
                f fVar = networkInfo[i2];
                if (fVar.a() || fVar.c <= bVar.c) {
                    i2++;
                } else {
                    throw new DnshijackingException(bVar.a, this.a.a.getHostAddress(), fVar.c);
                }
            }
        }
        return networkInfo;
    }
}
