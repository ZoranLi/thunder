package com.qiniu.android.http;

import java.io.IOException;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.z;
import okhttp3.z.a;

/* compiled from: Client */
final class c implements z {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final aj a(a aVar) throws IOException {
        af a = aVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        aj a2 = aVar.a(a);
        long currentTimeMillis2 = System.currentTimeMillis();
        a aVar2 = (a) a.e;
        String str = "";
        try {
            aVar = aVar.b().b().getRemoteSocketAddress().toString();
        } catch (a aVar3) {
            aVar3.printStackTrace();
            aVar3 = str;
        }
        aVar2.a = aVar3;
        aVar2.b = currentTimeMillis2 - currentTimeMillis;
        return a2;
    }
}
