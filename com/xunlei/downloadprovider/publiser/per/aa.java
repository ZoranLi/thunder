package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: HistoryDynamicItemFragment */
final class aa implements OnClickListener {
    final /* synthetic */ HistoryDynamicItemFragment a;

    aa(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void onClick(View view) {
        this.a.j.dismiss();
        view = this.a.j.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        a.b("cancel", view.getId(), o.a(this.a.h), "active");
    }
}
