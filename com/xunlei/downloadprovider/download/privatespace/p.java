package com.xunlei.downloadprovider.download.privatespace;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: OpenPrivateSpaceTipDialog */
final class p implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    p(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public final void onClick(View view) {
        an.a("confirm", "open");
        view = this.b.b.c();
        CharSequence b = this.b.b.b();
        if (!TextUtils.isEmpty(view)) {
            if (!TextUtils.isEmpty(b)) {
                if (view.length() >= 6) {
                    if (view.length() >= 6) {
                        if (view.equals(b)) {
                            if (this.b.c == null) {
                                this.b.c = new XLWaitingDialog(this.b.getContext());
                            }
                            this.b.c.setProHintStr(this.b.getContext().getString(R.string.opening_private_space));
                            this.b.c.show();
                            v.a(view, new q(this));
                            return;
                        }
                        XLToast.showToast(this.b.getContext(), this.b.getContext().getString(R.string.not_the_same_password));
                    }
                }
            }
        }
    }
}
