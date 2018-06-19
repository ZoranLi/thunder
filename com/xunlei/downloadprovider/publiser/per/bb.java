package com.xunlei.downloadprovider.publiser.per;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;

/* compiled from: HistoryPublishItemFragment */
final class bb implements OnClickListener {
    final /* synthetic */ PublishVideoFeedInfo a;
    final /* synthetic */ HistoryPublishItemFragment b;

    bb(HistoryPublishItemFragment historyPublishItemFragment, PublishVideoFeedInfo publishVideoFeedInfo) {
        this.b = historyPublishItemFragment;
        this.a = publishVideoFeedInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.f(this.a.getRelatedVideoInfo().getVideoId(), o.a(this.b.e), "shortvideo");
        this.b.l.a(this.a.getRelatedVideoInfo().getVideoId(), this.a.getRelatedVideoInfo().getGcid(), new ap(this.b, this.a.getRelatedVideoInfo()));
    }
}
