package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: ShortMovieDetailFragment */
final class bt implements OnClickListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    bt(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i = this.a.d.b().getKind();
        String videoId = this.a.d.a().getVideoId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.d.b().getUid());
        String stringBuilder2 = stringBuilder.toString();
        String str = (i == 0 || !i.contentEquals("per")) ? "channel" : "personal";
        String str2 = str;
        String str3 = "discuss_result";
        LoginHelper.a();
        boolean c = l.c();
        boolean z = this.a.p != null && this.a.p.b;
        bv.a(videoId, stringBuilder2, str2, str3, c, z);
        LoginHelper.a();
        if (l.c()) {
            dialogInterface.dismiss();
            this.a.e("discuss_result");
            return;
        }
        str = this.a.d.a().getVideoId();
        dialogInterface = new StringBuilder();
        dialogInterface.append(this.a.d.b().getUid());
        videoId = dialogInterface.toString();
        dialogInterface = (i == 0 || i.contentEquals("per") == null) ? "channel" : "personal";
        LoginHelper.a();
        bv.a(str, videoId, dialogInterface, "discuss_result", l.c(), "skip_login", "", this.a.C());
        this.a.aq.a(this.a.mActivity, new bu(this), LoginFrom.VIDEO_DETAIL_FOLLOW, null);
    }
}
