package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.redenvelope.a.a;

/* compiled from: GameUsedRequestHelper */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    b(a aVar, String str, String str2, a aVar2) {
        this.d = aVar;
        this.a = str;
        this.b = str2;
        this.c = aVar2;
    }

    public final void run() {
        CharSequence charSequence = this.a;
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/red_packets_cli/info_game_cdk_used?status=%status&code=%code&uid=%uid&gift_type=%giftType".replace("%status", "2").replace("%code", charSequence).replace("%uid", String.valueOf(LoginHelper.a().g.c())).replace("%giftType", this.b), new c(this), new d(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.d.a.a(sigJsonObjectRequest);
    }
}
