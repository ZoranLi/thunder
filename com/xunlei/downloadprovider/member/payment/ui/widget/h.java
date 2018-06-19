package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PayOperateLayout */
final class h implements OnClickListener {
    final /* synthetic */ PayOperateLayout a;

    h(PayOperateLayout payOperateLayout) {
        this.a = payOperateLayout;
    }

    public final void onClick(View view) {
        this.a.b.setChecked(this.a.b.isChecked() ^ 1);
        if (this.a.d != null) {
            this.a.d.onClick(view);
        }
    }
}
