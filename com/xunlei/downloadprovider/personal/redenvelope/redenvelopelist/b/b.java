package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.a.a;

/* compiled from: RedEnvelopesManager */
final class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    b(a aVar, int i, a aVar2) {
        this.c = aVar;
        this.a = i;
        this.b = aVar2;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/red_packets_cli/list_v2?&uid=%uid&cursor=%cursor&size=%size".replace("%uid", String.valueOf(LoginHelper.a().g.c())).replace("%cursor", String.valueOf(this.a)).replace("%size", "20"), new c(this), new d(this));
        sigJsonObjectRequest.setShouldCache(false);
        this.c.a.a(sigJsonObjectRequest);
    }
}
