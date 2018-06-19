package com.xunlei.downloadprovider.download.privatespace;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: VerifyPrivateSpaceDialog */
final class ar implements OnClickListener {
    final /* synthetic */ ao a;

    ar(ao aoVar) {
        this.a = aoVar;
    }

    public final void onClick(View view) {
        an.c("confirm");
        view = this.a.c();
        if (this.a.a == null) {
            this.a.a = new XLWaitingDialog(this.a.getContext());
        }
        this.a.a.show();
        this.a.a.setProHintStr(this.a.getContext().getString(R.string.verify_private_space));
        v.b(view, new as(this));
    }
}
