package com.xunlei.downloadprovider.homepage.redpacket;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RedPacketGuideDlg */
final class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        j.a();
        j.a(this.a.getContext(), "new_invited_red");
        this.a.dismiss();
    }
}
