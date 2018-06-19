package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.bv;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.f;

/* compiled from: RecommendWebsiteViewHolder */
public final class ak extends aq {
    private ImageView a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private String f;
    private VideoUserInfo g;
    private WebsiteInfo h;

    public ak(View view) {
        super(view);
        this.a = (ImageView) view.findViewById(R.id.iv_poster);
        this.b = (TextView) view.findViewById(R.id.tv_link_title);
        this.c = (TextView) view.findViewById(R.id.tv_link_url);
        this.d = (ImageView) view.findViewById(R.id.iv_publisher_avatar);
        this.e = (TextView) view.findViewById(R.id.tv_publisher_name);
        view.setOnClickListener(new al(this));
    }

    public final void a(aw awVar) {
        f fVar = (f) awVar.b;
        this.f = fVar.a;
        this.h = fVar.b;
        this.g = fVar.c;
        this.e.setText(this.g.getNickname());
        this.b.setText(this.h.e);
        this.c.setText(this.h.f);
        b.a().a(this.a.getContext(), this.a, this.h.g, R.drawable.ic_website_default_vertical_pic);
        b.a();
        b.a(this.g.getPortraitUrl(), this.d, R.drawable.choiceness_icon_default, R.drawable.choiceness_icon_default, R.drawable.choiceness_icon_default);
        bv.a(fVar.a, this.h.a, this.g.getUid(), this.g.getKind());
    }
}
