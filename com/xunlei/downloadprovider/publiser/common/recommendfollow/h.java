package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: FollowRecommendPopWindow */
final class h implements OnDismissListener {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void onDismiss() {
        LayoutParams attributes = this.a.k.getWindow().getAttributes();
        attributes.alpha = 1.0f;
        this.a.k.getWindow().setAttributes(attributes);
        this.a.k = null;
    }
}
