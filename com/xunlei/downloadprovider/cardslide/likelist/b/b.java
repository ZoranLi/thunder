package com.xunlei.downloadprovider.cardslide.likelist.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.likelist.CardSlideLikeActivity;
import com.xunlei.downloadprovider.cardslide.likelist.c.a;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.personal.user.f;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.thunder.commonui.widget.CircleImageView;

/* compiled from: CardUserItemViewHolder */
public final class b extends a<a> {
    private CircleImageView a;
    private UserInfoTagView b;
    private ImageView c;
    private TextView d;
    private View e;
    private CardSlideLikeActivity f;
    private com.xunlei.downloadprovider.cardslide.likelist.c.b g;

    public final /* synthetic */ void a(Object obj) {
        a aVar = (a) obj;
        if (aVar != null && (aVar instanceof com.xunlei.downloadprovider.cardslide.likelist.c.b)) {
            this.g = (com.xunlei.downloadprovider.cardslide.likelist.c.b) aVar;
            obj = this.g.b;
            com.xunlei.downloadprovider.homepage.choiceness.b.a();
            com.xunlei.downloadprovider.homepage.choiceness.b.a(obj.getPortraitUrl(), this.a);
            this.d.setText(obj.getNickname());
            this.b.setUserInfo(obj);
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.g.c.getCoverUrl(), this.c, null);
        }
    }

    public b(View view, CardSlideLikeActivity cardSlideLikeActivity) {
        super(view);
        this.f = cardSlideLikeActivity;
        this.e = view;
        this.a = (CircleImageView) view.findViewById(R.id.iv_avatar);
        this.b = (UserInfoTagView) view.findViewById(R.id.view_user_info_tag);
        this.c = (ImageView) view.findViewById(R.id.iv_video_cover);
        this.d = (TextView) view.findViewById(R.id.tv_user_name);
        this.e.setOnClickListener(new c(this));
        this.c.setOnClickListener(new d(this));
    }

    static /* synthetic */ void a(b bVar) {
        f.a(HubbleEventBuilder.build("android_personal_click", "per_make_video"));
        VideoUserInfo videoUserInfo = bVar.g.b;
        m.a(bVar.f, Long.parseLong(videoUserInfo.getUid()), "per", videoUserInfo.getNickname(), videoUserInfo.getPortraitUrl(), From.ACCOUNT_CENTER);
    }

    static /* synthetic */ void b(b bVar) {
        ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
        aVar.a = bVar.g.c.getVideoId();
        aVar.u = ShortMovieDetailActivity.From.CARD_SLIDE_PAGE;
        aVar.v = bVar.g.c;
        aVar.w = bVar.g.b;
        ShortMovieDetailActivity.a(bVar.f, aVar);
    }
}
