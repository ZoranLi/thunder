package com.xunlei.downloadprovider.download.privatespace;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: ClosePrivateSpaceTipDialog */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        an.a("confirm", "close");
        PrivateSpaceMgr.a();
        if (PrivateSpaceMgr.b() != null) {
            view = this.a.c();
            if (!TextUtils.isEmpty(view) && view.length() >= 6) {
                if (this.a.a == null) {
                    this.a.a = new XLWaitingDialog(this.a.getContext());
                }
                this.a.a.show();
                this.a.a.setProHintStr(this.a.getContext().getString(R.string.closing_private_space));
                v.b(view, new e(this));
            }
        }
    }
}
