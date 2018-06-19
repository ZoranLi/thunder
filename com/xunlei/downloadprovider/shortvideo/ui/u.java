package com.xunlei.downloadprovider.shortvideo.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.category.ShortVideoCategoryActivity;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;

/* compiled from: VideoRecommendView */
final class u implements OnClickListener {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            ChoicenessReporter.a(this.a.d.b.getVideoId(), "more_rectag_video", "home_collect", this.a.d.o);
            ShortVideoCategoryActivity.a(this.a.c, this.a.d.o, "hometab");
        }
    }
}
