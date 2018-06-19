package com.qiniu.android.http;

import com.qiniu.android.c.s;
import com.qiniu.android.d.b;
import com.qiniu.android.http.CancellationHandler.CancellationException;
import com.xunlei.tdlive.protocol.XLLiveRequest;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import okhttp3.HttpUrl;
import okhttp3.aj;
import okhttp3.g;

/* compiled from: Client */
final class f implements g {
    final /* synthetic */ a a;
    final /* synthetic */ s b;
    final /* synthetic */ long c;
    final /* synthetic */ h d;
    final /* synthetic */ a e;

    f(a aVar, a aVar2, s sVar, long j, h hVar) {
        this.e = aVar;
        this.a = aVar2;
        this.b = sVar;
        this.c = j;
        this.d = hVar;
    }

    public final void a(okhttp3.f fVar, IOException iOException) {
        f fVar2 = this;
        IOException iOException2 = iOException;
        iOException.printStackTrace();
        String message = iOException.getMessage();
        int i = iOException2 instanceof CancellationException ? -2 : iOException2 instanceof UnknownHostException ? -1003 : (message == null || message.indexOf("Broken pipe") != 0) ? iOException2 instanceof SocketTimeoutException ? -1001 : iOException2 instanceof ConnectException ? XLLiveRequest.ERROR_ALEARDY_FOLLOW : -1 : XLLiveRequest.ERROR_NOT_FOLLOW;
        int i2 = i;
        HttpUrl httpUrl = fVar.a().a;
        fVar2.d.a(o.a(null, i2, "", "", "", httpUrl.b, httpUrl.e(), "", httpUrl.c, fVar2.a.b, -1, iOException.getMessage(), fVar2.b, fVar2.c), null);
    }

    public final void a(aj ajVar) throws IOException {
        a aVar = (a) ajVar.a.e;
        b.a(new d(this.d, a.a(ajVar, aVar.a, aVar.b, this.b, this.c)));
    }
}
