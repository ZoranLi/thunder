package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: RedEnvelopesActivity */
final class i implements OnClickListener {
    final /* synthetic */ RedEnvelopesActivity a;

    i(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void onClick(View view) {
        this.a.g.a(this.a, null, LoginFrom.PER_CL_PACKET, null);
    }
}
