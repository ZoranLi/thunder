package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomDurationLongClickImageView */
final class a implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ CustomDurationLongClickImageView b;

    a(CustomDurationLongClickImageView customDurationLongClickImageView, OnClickListener onClickListener) {
        this.b = customDurationLongClickImageView;
        this.a = onClickListener;
    }

    public final void onClick(View view) {
        if (this.a != null && !this.b.b) {
            this.a.onClick(view);
        }
    }
}
