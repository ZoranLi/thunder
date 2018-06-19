package com.xunlei.downloadprovider.homepage.redpacket;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.cardslide.u;

/* compiled from: RedPacketShareProfitDlg */
final class t implements OnClickListener {
    final /* synthetic */ r a;

    t(r rVar) {
        this.a = rVar;
    }

    public final void onClick(View view) {
        j.a();
        j.a(this.a.e, "share_red");
        u.c(this.a.d);
        this.a.dismiss();
    }
}
