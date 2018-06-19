package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: FollowBtnView */
final class d implements aa {
    final /* synthetic */ FollowBtnView a;

    d(FollowBtnView followBtnView) {
        this.a = followBtnView;
    }

    public final void a(boolean z, List<String> list) {
        if (!(this.a.a == null || list == null)) {
            if (!list.isEmpty()) {
                if (list.contains(this.a.a.getUid()) != null) {
                    if (z) {
                        this.a.setEnabled(true);
                        return;
                    }
                    this.a.setEnabled(null);
                }
            }
        }
    }
}
