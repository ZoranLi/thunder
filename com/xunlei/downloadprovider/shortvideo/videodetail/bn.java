package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.View;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.common.recommendfollow.d;
import java.util.List;

/* compiled from: ShortMovieDetailFragment */
final class bn implements e$d<a, List<a>> {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ View c;
    final /* synthetic */ ShortMovieDetailFragment d;

    bn(ShortMovieDetailFragment shortMovieDetailFragment, long j, String str, View view) {
        this.d = shortMovieDetailFragment;
        this.a = j;
        this.b = str;
        this.c = view;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj2;
        if (this.d.mActivity != null) {
            if (this.d.mActivity.isFinishing() == null) {
                this.d.d();
                obj = this.d.d.b().getKind();
                String videoId = this.d.d.a().getVideoId();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                String stringBuilder2 = stringBuilder.toString();
                String str = (obj == null || obj.contentEquals("per") == null) ? "channel" : "personal";
                String str2 = str;
                String str3 = this.b;
                this.d.aq;
                bv.a(videoId, stringBuilder2, str2, str3, l.c(), "success", "", this.d.C());
                if (this.c != null) {
                    d.a(this.d.getActivity(), list, this.c, "follow_button");
                }
            }
        }
    }

    public final void a(String str) {
        this.d.b(true);
        String kind = this.d.d.b().getKind();
        String videoId = this.d.d.a().getVideoId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        String stringBuilder2 = stringBuilder.toString();
        kind = (kind == null || !kind.contentEquals("per")) ? "channel" : "personal";
        String str2 = kind;
        String str3 = this.b;
        this.d.aq;
        bv.a(videoId, stringBuilder2, str2, str3, l.c(), "fail", str, this.d.C());
    }
}
