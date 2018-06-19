package com.xunlei.downloadprovider.ad.d;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.homepage.recommend.feed.k;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ad;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;
import java.util.List;

/* compiled from: AdBaseInfoViewHolder */
public final class a extends aq implements OnClickListener {
    private final TextView a;
    private final ImageView b;
    private final LinearLayout c;
    private final ImageView d;
    private final TextView e;
    private boolean f;
    private final View g;
    private final LinearLayout h;
    private final ImageView i;
    private final ImageView j;
    private final ImageView k;
    private final TextView l;
    private final TextView m;
    private final com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a n;
    private b o;
    private boolean p = false;
    private boolean q = false;
    private ad r = null;

    public a(View view, com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a aVar) {
        super(view);
        this.n = aVar;
        this.a = (TextView) view.findViewById(R.id.tv_title);
        this.b = (ImageView) view.findViewById(R.id.iv_toggle_title);
        this.m = (TextView) view.findViewById(R.id.btn_ad_download);
        l lVar = f.a(this.m.getContext()).c.d;
        if (lVar != null) {
            if (lVar.x() != null) {
                if (!lVar.x().trim().equals("")) {
                    this.m.setText(lVar.x().trim());
                    this.m.setOnClickListener(new c(this, lVar));
                }
            }
            this.m.setText(lVar.u() == 2 ? "马上玩" : "去看看");
            this.m.setOnClickListener(new c(this, lVar));
        }
        this.a.getViewTreeObserver().addOnPreDrawListener(new b(this));
        this.c = (LinearLayout) view.findViewById(R.id.lyt_channel);
        this.g = view.findViewById(R.id.fl_click_nice);
        this.d = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.l = (TextView) view.findViewById(R.id.tv_good_count);
        this.e = (TextView) view.findViewById(R.id.tv_plus_one);
        this.h = (LinearLayout) view.findViewById(R.id.lyt_like_list);
        this.i = (ImageView) view.findViewById(R.id.iv_like_avatar1);
        this.j = (ImageView) view.findViewById(R.id.iv_like_avatar2);
        this.k = (ImageView) view.findViewById(R.id.iv_like_avatar3);
        this.r = new ad(view, aVar);
        this.r.a.setFromAd(true);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof b) {
                this.r.a(((b) awVar.b).b(), null);
                this.o = (b) awVar.b;
                this.q = false;
                this.a.setMaxLines(Integer.MAX_VALUE);
                this.q = false;
                this.a.setMaxLines(Integer.MAX_VALUE);
                this.e.setVisibility(8);
                CharSequence title = this.o.a().getTitle();
                if (TextUtils.isEmpty(title)) {
                    this.a.setText("   ");
                } else {
                    this.a.setText(title);
                }
                if (this.o != null) {
                    this.c.setVisibility(8);
                }
                this.b.setOnClickListener(this);
                this.a.setOnClickListener(this);
                this.b.setRotation(0.0f);
                this.c.setOnClickListener(this);
                this.g.setOnClickListener(this);
                this.i.setOnClickListener(this);
                this.j.setOnClickListener(this);
                this.k.setOnClickListener(this);
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
                if (bVar.a().hasLike()) {
                    a(false);
                }
                bVar.a().setLikeCount(d);
                if (d > 0) {
                    awVar = ConvertUtil.decimal2String((long) d, 10000, 10000, "万");
                    if (awVar.trim().contentEquals("0")) {
                        awVar = "";
                    }
                    TextView textView = this.l;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(awVar);
                    stringBuilder.append("赞");
                    textView.setText(stringBuilder.toString());
                    this.h.setVisibility(0);
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.k.setVisibility(8);
                    if (list == null) {
                        awVar = null;
                    } else {
                        awVar = list.size();
                    }
                    if (awVar > null) {
                        this.i.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(0)).c, this.i);
                    }
                    if (awVar > 1) {
                        this.j.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(1)).c, this.j);
                    }
                    if (awVar > 2) {
                        this.k.setVisibility(0);
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(((v) list.get(2)).c, this.k);
                    }
                    return;
                }
                this.h.setVisibility(8);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be DetailVideoInfo type");
    }

    public final void onClick(View view) {
        if (this.n != null) {
            view = view.getId();
            if (view == R.id.fl_click_nice) {
                if (this.o != null && this.o.a().hasLike() == null && this.f == null) {
                    a(true);
                }
                if (this.f == null) {
                    this.n.a(this.g, 1, this.o);
                }
                this.f = true;
                return;
            }
            int i = 2;
            if (view != R.id.iv_toggle_title) {
                if (view != R.id.tv_title) {
                    if (view == R.id.lyt_channel) {
                        this.n.a(this.c, 6, this.o);
                        return;
                    } else if (view == R.id.iv_like_avatar1) {
                        this.n.a(this.i, 21, this.o.d.get(0));
                        return;
                    } else if (view == R.id.iv_like_avatar2) {
                        this.n.a(this.j, 21, this.o.d.get(1));
                        return;
                    } else {
                        if (view == R.id.iv_like_avatar3) {
                            this.n.a(this.k, 21, this.o.d.get(2));
                        }
                        return;
                    }
                }
            }
            this.b.animate().rotation(this.p ? 0.0f : 180.0f);
            view = this.a;
            if (!this.p) {
                i = Integer.MAX_VALUE;
            }
            view.setMaxLines(i);
            this.p ^= 1;
        }
    }

    private void a(boolean z) {
        if (z) {
            z = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_in);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_out);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_out2);
            z.setAnimationListener(new d(this, loadAnimation));
            loadAnimation2.setAnimationListener(new e(this));
            this.e.setVisibility(0);
            this.d.startAnimation(z);
            this.e.startAnimation(loadAnimation2);
            return;
        }
        this.d.setSelected(true);
    }
}
