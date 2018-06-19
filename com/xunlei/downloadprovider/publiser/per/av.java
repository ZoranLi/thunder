package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: HistoryPublishItemFragment */
final class av extends c {
    final /* synthetic */ HistoryPublishItemFragment a;

    av(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (i == 0) {
            this.a.h.postDelayed(new aw(this), 300);
        }
    }
}
