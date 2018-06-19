package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: HistoryDynamicItemFragment */
final class y implements OnClickListener {
    final /* synthetic */ HistoryDynamicItemFragment a;

    y(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void onClick(View view) {
        view = this.a.j.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ReportActivity.a(this.a.b, -1, view.getId(), view.getRelateGcid(), view.getSourceId(), DispatchConstants.OTHER);
        this.a.j.dismiss();
        a.b("jubao", view.getId(), o.a(this.a.h), "active");
    }
}
