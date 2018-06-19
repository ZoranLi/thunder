package com.xunlei.downloadprovider.homepage.redpacket;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.redenvelope.f;

/* compiled from: RedPacketGuideDlg */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        f.a("giveup");
        this.a.dismiss();
    }
}
