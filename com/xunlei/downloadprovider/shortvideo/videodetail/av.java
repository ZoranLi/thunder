package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.personal.user.ReportActivity;

/* compiled from: ShortMovieDetailFragment */
final class av implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    av(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(View view) {
        view = this.a.B.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ReportActivity.a(this.a.mActivity, 1, view.getId(), this.a.d.a().getGcid(), this.a.d.a().getVideoId(), DispatchConstants.OTHER);
        this.a.B.dismiss();
        bv.a(view.getId(), view.isHot(), "jubao");
    }
}
