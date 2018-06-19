package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.TopicDetailActivity;
import com.xunlei.downloadprovider.shortvideo.entity.LocationInfo;

/* compiled from: VideoTagView */
final class g implements OnClickListener {
    final /* synthetic */ LocationInfo a;
    final /* synthetic */ VideoTagView b;

    g(VideoTagView videoTagView, LocationInfo locationInfo) {
        this.b = videoTagView;
        this.a = locationInfo;
    }

    public final void onClick(View view) {
        if (this.a.a != null && !this.a.a.equals(this.b.e)) {
            TopicDetailActivity.a(view.getContext(), 3, this.a.a, this.a.b, this.b.d);
        }
    }
}
