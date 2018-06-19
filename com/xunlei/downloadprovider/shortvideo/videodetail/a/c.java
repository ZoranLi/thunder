package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.homepage.recommend.feed.k;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.ShortMovieBaseTitleInfoView;
import java.util.List;

/* compiled from: BaseInfoViewHolder */
public final class c extends aq implements OnClickListener {
    private ImageView a;
    private TextView b;
    private TextView c;
    private final a d;
    private View e;
    private LinearLayout f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private b j;
    private ad k = null;
    private ShortMovieBaseTitleInfoView l = null;

    public static c a(LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar) {
        return new c(layoutInflater.inflate(R.layout.layout_base_info, viewGroup, false), aVar);
    }

    private c(View view, a aVar) {
        super(view);
        this.d = aVar;
        this.l = (ShortMovieBaseTitleInfoView) view.findViewById(R.id.short_movie_base_title_info_view);
        this.e = view.findViewById(R.id.fl_click_nice);
        this.a = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.b = (TextView) view.findViewById(R.id.tv_good_count);
        this.c = (TextView) view.findViewById(R.id.tv_plus_one);
        this.f = (LinearLayout) view.findViewById(R.id.lyt_like_list);
        this.g = (ImageView) view.findViewById(R.id.iv_like_avatar1);
        this.h = (ImageView) view.findViewById(R.id.iv_like_avatar2);
        this.i = (ImageView) view.findViewById(R.id.iv_like_avatar3);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.k = new ad(view, aVar);
    }

    public final void a(aw awVar) {
        if (awVar != null && (awVar.b instanceof b)) {
            if (awVar.c instanceof com.xunlei.downloadprovider.shortvideo.videodetail.model.c) {
                this.k.a(((b) awVar.b).b(), (com.xunlei.downloadprovider.shortvideo.videodetail.model.c) awVar.c);
                b bVar = (b) awVar.b;
                k.a();
                int d = k.d(1, bVar.a().getVideoId());
                if (d <= bVar.a().getLikeCount()) {
                    d = bVar.a().getLikeCount();
                }
                List list = bVar.d;
                if (list != null && list.size() > r1) {
                    d = list.size();
                }
                bVar.a().setLikeCount(d);
                if (d > 0) {
                    String decimal2String = ConvertUtil.decimal2String((long) d, 10000, 10000, "万");
                    if (decimal2String.trim().contentEquals("0")) {
                        decimal2String = "";
                    }
                    TextView textView = this.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(decimal2String);
                    stringBuilder.append("赞");
                    textView.setText(stringBuilder.toString());
                    this.f.setVisibility(0);
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                    this.i.setVisibility(8);
                    if (list == null) {
                        d = 0;
                    } else {
                        d = list.size();
                    }
                    if (d > 0) {
                        this.g.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(0)).c, this.g);
                    }
                    if (d > 1) {
                        this.h.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(1)).c, this.h);
                    }
                    if (d > 2) {
                        this.i.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(2)).c, this.i);
                    }
                } else {
                    this.f.setVisibility(8);
                }
                if (bVar.a().hasLike()) {
                    a(false);
                } else {
                    this.a.setSelected(false);
                }
                if (this.j != awVar.b) {
                    this.j = (b) awVar.b;
                    this.l.a(this.j);
                    this.c.setVisibility(8);
                    if (this.j.a().hasLike() != null) {
                        a(false);
                        return;
                    } else {
                        this.a.setSelected(false);
                        return;
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be DetailVideoInfo type. extraData should be FollowInfo");
    }

    private void a(boolean z) {
        if (z) {
            z = AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.scale_in);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.scale_out);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.scale_out2);
            z.setAnimationListener(new d(this, loadAnimation));
            loadAnimation2.setAnimationListener(new e(this));
            this.c.setVisibility(0);
            this.a.startAnimation(z);
            this.c.startAnimation(loadAnimation2);
            return;
        }
        this.a.setSelected(true);
    }

    public final void onClick(View view) {
        if (this.d != null) {
            view = view.getId();
            if (view == R.id.fl_click_nice) {
                if (this.j != null && this.j.a().hasLike() == null) {
                    a(true);
                }
                this.d.a(this.e, 1, this.j);
            } else if (view == R.id.lyt_like_list) {
                this.d.a(this.f, 20, this.j);
            } else if (view == R.id.iv_like_avatar1) {
                this.d.a(this.g, 21, this.j.d.get(0));
            } else if (view == R.id.iv_like_avatar2) {
                this.d.a(this.h, 21, this.j.d.get(1));
            } else {
                if (view == R.id.iv_like_avatar3) {
                    this.d.a(this.i, 21, this.j.d.get(2));
                }
            }
        }
    }
}
