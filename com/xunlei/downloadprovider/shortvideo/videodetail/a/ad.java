package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.ShortMoviePublisherInfoView;

/* compiled from: PublisherInfoInnerViewHolder */
public final class ad {
    public ShortMoviePublisherInfoView a;
    private View b;
    private a c;
    private VideoUserInfo d = null;
    private c e = null;

    public ad(View view, a aVar) {
        this.b = view;
        this.c = aVar;
        this.a = (ShortMoviePublisherInfoView) this.b.findViewById(R.id.short_movie_publisher_info_view);
        this.a.setListener(this.c);
        this.a.setBackgroundColor(view.getContext().getResources().getColor(R.color.white));
        this.a.setDividerVisibility(null);
    }

    public final void a(VideoUserInfo videoUserInfo, c cVar) {
        StringBuilder stringBuilder = new StringBuilder("bindData. (videoUserInfo == null): ");
        boolean z = false;
        stringBuilder.append(videoUserInfo == null);
        stringBuilder.append(" (followInfo == null)");
        if (cVar == null) {
            z = true;
        }
        stringBuilder.append(z);
        this.d = videoUserInfo;
        this.e = cVar;
        videoUserInfo = this.a;
        VideoUserInfo videoUserInfo2 = this.d;
        c cVar2 = this.e;
        videoUserInfo.a(videoUserInfo2);
        videoUserInfo.a(cVar2);
    }
}
