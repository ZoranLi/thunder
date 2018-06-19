package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: FansAndFollowItemView */
final class m implements OnClickListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            if (this.a.g.b != 0) {
                this.a.a();
                return;
            }
        }
        XLToast.showToast(this.a.getContext(), "该用户未登录");
    }
}
