package com.qiniu.android.http;

import com.qiniu.android.dns.a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.s;

/* compiled from: Client */
final class b implements s {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final List<InetAddress> a(String str) throws UnknownHostException {
        try {
            a aVar = this.a;
            int i = 0;
            com.qiniu.android.dns.b bVar = new com.qiniu.android.dns.b(str, (byte) 0);
            if (bVar.a != null) {
                if (bVar.a.trim().length() != null) {
                    if (a.a(bVar.a) != null) {
                        str = new String[]{bVar.a};
                    } else {
                        str = aVar.a(bVar);
                        if (str != null) {
                            if (str.length > 1) {
                                str = aVar.c.a(str);
                            }
                        }
                    }
                    InetAddress[] inetAddressArr = new InetAddress[str.length];
                    while (i < str.length) {
                        inetAddressArr[i] = InetAddress.getByName(str[i]);
                        i++;
                    }
                    str = new ArrayList();
                    Collections.addAll(str, inetAddressArr);
                    return str;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("empty domain ");
            stringBuilder.append(bVar.a);
            throw new IOException(stringBuilder.toString());
        } catch (String str2) {
            str2.printStackTrace();
            throw new UnknownHostException(str2.getMessage());
        }
    }
}
