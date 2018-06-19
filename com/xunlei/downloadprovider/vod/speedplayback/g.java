package com.xunlei.downloadprovider.vod.speedplayback;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VodSpeedSelectPopupWindow */
final class g implements OnClickListener {
    final /* synthetic */ VodSpeedRate a;
    final /* synthetic */ f b;

    g(f fVar, VodSpeedRate vodSpeedRate) {
        this.b = fVar;
        this.a = vodSpeedRate;
    }

    public final void onClick(View view) {
        if (this.b.b != null) {
            this.b.b.setSelected(false);
        }
        this.b.b = view;
        view.setSelected(true);
        if (this.b.a != null && this.b.a.a(this.a) != null) {
            this.b.dismiss();
        }
    }
}
