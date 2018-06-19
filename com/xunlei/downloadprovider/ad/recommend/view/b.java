package com.xunlei.downloadprovider.ad.recommend.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: RecommendAdImageItemView */
public final class b extends BaseRecommendAdItemView {
    private TextView a = null;
    private RatingBar b = null;
    private TextView c = null;
    private TextView d = null;
    private ImageView e = null;
    private ImageView f = null;
    private View g = null;

    public b(Context context, @LayoutRes int i) {
        super(context);
        LayoutInflater.from(context).inflate(i, this, true);
        this.a = (TextView) findViewById(R.id.name_tv);
        this.c = (TextView) findViewById(R.id.desc_tv);
        this.d = (TextView) findViewById(R.id.action_name_tv);
        this.f = (ImageView) findViewById(R.id.image_iv);
        this.e = (ImageView) findViewById(R.id.icon_iv);
        this.b = (RatingBar) findViewById(R.id.score_rb);
        this.g = findViewById(R.id.gray_line);
    }

    public final void setDivideLineVisibility(int i) {
        if (this.g != 0) {
            this.g.setVisibility(0);
        }
    }

    public final void setData(l lVar) {
        if (this.e != null) {
            Context context = getContext();
            String k = lVar.k();
            c.b(context, k).placeholder(R.drawable.recommend_ad_icon_bg).error(R.drawable.recommend_ad_icon_bg).fallback(R.drawable.recommend_ad_icon_bg).listener(null).into(this.e);
        }
        if (this.f != null) {
            context = getContext();
            k = lVar.l();
            c.a(context, k).placeholder(R.drawable.download_ad_background).error(R.drawable.download_ad_background).fallback(R.drawable.download_ad_background).listener(null).into(this.f);
        }
        if (this.a != null) {
            this.a.setText(lVar.m());
        }
        if (this.c != null) {
            this.c.setText(lVar.j());
        }
        if (this.d != null) {
            this.d.setText(com.xunlei.downloadprovider.ad.recommend.b.a(lVar));
        }
        if (this.b != null) {
            this.b.setRating(f.a(lVar.q()));
        }
    }
}
