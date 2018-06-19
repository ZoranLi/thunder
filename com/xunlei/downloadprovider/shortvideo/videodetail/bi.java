package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.e.b.b;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: ShortMovieDetailFragment */
final class bi implements k {
    final /* synthetic */ ShortMovieDetailFragment a;

    bi(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        String reportShareTo = shareOperationType.getReportShareTo();
        if (shareOperationType == ShareOperationType.DOWNLOAD) {
            ((a) this.a.mActivity).a();
            bv.b("download", this.a.d.a().getVideoId());
        } else if (shareOperationType == ShareOperationType.REPORT) {
            ((a) this.a.mActivity).b();
            bv.b("jubao", this.a.d.a().getVideoId());
        } else {
            bv.a(this.a.d.a().getVideoId(), reportShareTo, fVar.j);
        }
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        ShortMovieDetailFragment.ac(this.a);
        bv.a(this.a.d.a().getVideoId(), shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, fVar.j);
        if (i == 0) {
            com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(this.a.d.a().getVideoId(), 1, this.a.d.a().getGcid(), "share_success");
            b.a();
            b.a(this.a.d.a().getVideoId());
            j.a().a(this.a.getContext(), fVar);
        }
    }
}
