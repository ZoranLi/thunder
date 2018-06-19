package com.xunlei.downloadprovider.contentpublish.website.view;

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
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.bg;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.homepage.recommend.feed.k;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.List;

/* compiled from: WebsiteInfoViewHolder */
public final class o extends aq implements OnClickListener {
    private final TextView a;
    private final ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private final a f;
    private View g;
    private LinearLayout h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private final View l;
    private WebsiteInfo m;
    private boolean n = false;
    private boolean o = false;
    private List<v> p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private View t;

    public o(View view, a aVar) {
        super(view);
        this.f = aVar;
        this.a = (TextView) view.findViewById(R.id.tv_title);
        this.b = (ImageView) view.findViewById(R.id.iv_toggle_title);
        this.l = view.findViewById(R.id.lyt_base_info);
        this.a.getViewTreeObserver().addOnPreDrawListener(new p(this));
        this.t = view.findViewById(R.id.ryt_website);
        this.t.setOnClickListener(this);
        this.q = (ImageView) view.findViewById(R.id.iv_website_pic);
        this.r = (TextView) view.findViewById(R.id.tv_website_title);
        this.s = (TextView) view.findViewById(R.id.tv_website_url);
        this.g = view.findViewById(R.id.fl_click_nice);
        this.c = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.d = (TextView) view.findViewById(R.id.tv_good_count);
        this.e = (TextView) view.findViewById(R.id.tv_plus_one);
        this.h = (LinearLayout) view.findViewById(R.id.lyt_like_list);
        this.i = (ImageView) view.findViewById(R.id.iv_like_avatar1);
        this.j = (ImageView) view.findViewById(R.id.iv_like_avatar2);
        this.k = (ImageView) view.findViewById(R.id.iv_like_avatar3);
        this.b.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setRotation(null);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof WebsiteInfo) {
                WebsiteInfo websiteInfo = (WebsiteInfo) awVar.b;
                k.a();
                int d = k.d(1, websiteInfo.a);
                if (d <= websiteInfo.k) {
                    d = websiteInfo.k;
                }
                List list = (List) awVar.c;
                this.p = list;
                if (list != null && list.size() > r1) {
                    d = list.size();
                }
                websiteInfo.k = d;
                if (d > 0) {
                    String decimal2String = ConvertUtil.decimal2String((long) d, 10000, 10000, "万");
                    if (decimal2String.trim().contentEquals("0")) {
                        decimal2String = "";
                    }
                    TextView textView = this.d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(decimal2String);
                    stringBuilder.append("赞");
                    textView.setText(stringBuilder.toString());
                    this.h.setVisibility(0);
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.k.setVisibility(8);
                    if (list == null) {
                        d = 0;
                    } else {
                        d = list.size();
                    }
                    if (d > 0) {
                        this.i.setVisibility(0);
                        b.a();
                        b.a(((v) list.get(0)).c, this.i);
                    }
                    if (d > 1) {
                        this.j.setVisibility(0);
                        b.a();
                        b.a(((v) list.get(1)).c, this.j);
                    }
                    if (d > 2) {
                        this.k.setVisibility(0);
                        b.a();
                        b.a(((v) list.get(2)).c, this.k);
                    }
                } else {
                    this.h.setVisibility(8);
                }
                if (websiteInfo.j) {
                    a(false);
                } else {
                    this.c.setSelected(false);
                }
                if (this.m != awVar.b) {
                    this.m = (WebsiteInfo) awVar.b;
                    this.o = false;
                    this.a.setMaxLines(Integer.MAX_VALUE);
                    this.b.setRotation(0.0f);
                    awVar = this.m.d;
                    if (TextUtils.isEmpty(awVar)) {
                        this.l.setVisibility(8);
                    } else {
                        this.l.setVisibility(0);
                        this.a.setText(awVar);
                    }
                    this.r.setText(this.m.e);
                    this.s.setText(this.m.f);
                    b.a().a(this.q.getContext(), this.q, this.m.g, bg.a(this.q, this.m.g, this.m.h, this.m.i) != null ? R.drawable.website_icon_default_square : R.drawable.ic_website_default_vertical_pic);
                    this.e.setVisibility(8);
                    if (this.m.j != null) {
                        a(false);
                        return;
                    } else {
                        this.c.setSelected(false);
                        return;
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be WebsiteInfo type");
    }

    private void a(boolean z) {
        if (z) {
            z = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_in);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_out);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a.getContext(), R.anim.scale_out2);
            z.setAnimationListener(new q(this, loadAnimation));
            loadAnimation2.setAnimationListener(new r(this));
            this.e.setVisibility(0);
            this.c.startAnimation(z);
            this.e.startAnimation(loadAnimation2);
            return;
        }
        this.c.setSelected(true);
    }

    public final void onClick(View view) {
        if (this.f != null) {
            view = view.getId();
            if (view == R.id.fl_click_nice) {
                if (this.m != null && this.m.j == null) {
                    a(true);
                }
                this.f.a(this.g, 1, this.m);
            } else if (view == R.id.lyt_like_list) {
                this.f.a(this.h, 20, this.m);
            } else if (view == R.id.iv_like_avatar1) {
                this.f.a(this.i, 21, this.p.get(0));
            } else if (view == R.id.iv_like_avatar2) {
                this.f.a(this.j, 21, this.p.get(1));
            } else {
                int i = 2;
                if (view == R.id.iv_like_avatar3) {
                    this.f.a(this.k, 21, this.p.get(2));
                    return;
                }
                if (view != R.id.iv_toggle_title) {
                    if (view != R.id.tv_title) {
                        if (view == R.id.ryt_website) {
                            this.f.a(this.t, 28, this.m);
                        }
                        return;
                    }
                }
                this.b.animate().rotation(this.n ? 0.0f : 180.0f);
                view = this.a;
                if (!this.n) {
                    i = Integer.MAX_VALUE;
                }
                view.setMaxLines(i);
                this.n ^= 1;
            }
        }
    }
}
