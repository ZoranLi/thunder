package com.xunlei.downloadprovider.personal.settings.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.personal.settings.PathChooserActivity;
import com.xunlei.xllib.android.e;

/* compiled from: SDCardViewHolder */
final class d implements OnClickListener {
    final /* synthetic */ SDCardViewHolder a;

    d(SDCardViewHolder sDCardViewHolder) {
        this.a = sDCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.n == null) {
            this.a.setSelected(true);
            if (this.a.m != null) {
                view = this.a.m;
                int i = this.a.i;
                view.a(this.a.n);
            }
        } else if (e.b(this.a.j) == 0) {
            XLToast.showToast(this.a.getContext(), "SD卡已拔出");
        } else if (this.a.q != null) {
            PathChooserActivity.a((Activity) this.a.getContext(), this.a.o);
        }
    }
}
