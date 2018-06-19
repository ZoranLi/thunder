package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: HistoryPublishItemFragment */
final class ba implements OnClickListener {
    final /* synthetic */ HistoryPublishItemFragment a;

    ba(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.b();
        }
    }
}
