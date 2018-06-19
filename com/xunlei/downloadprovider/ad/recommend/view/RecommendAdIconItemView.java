package com.xunlei.downloadprovider.ad.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.recommend.b;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

public class RecommendAdIconItemView extends BaseRecommendAdItemView {
    private ZHTextView a = null;
    private RatingBar b = null;
    private TextView c = null;
    private TextView d = null;
    private ImageView e = null;
    private View f = null;

    public RecommendAdIconItemView(Context context) {
        super(context);
        b(context);
    }

    public RecommendAdIconItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public RecommendAdIconItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_task_list_recommend_list_icon_item, this, true);
        this.a = (ZHTextView) findViewById(R.id.name_tv);
        this.c = (TextView) findViewById(R.id.desc_tv);
        this.d = (TextView) findViewById(R.id.action_name_tv);
        this.e = (ImageView) findViewById(R.id.icon_iv);
        this.b = (RatingBar) findViewById(R.id.score_rb);
        this.f = findViewById(R.id.gray_line);
    }

    public void setData(l lVar) {
        Context context = getContext();
        String k = lVar.k();
        c.a(context, k).placeholder(R.drawable.download_ad_background).error(R.drawable.download_ad_background).fallback(R.drawable.download_ad_background).listener(null).into(this.e);
        this.a.setText(lVar.j());
        this.c.setText(lVar.m());
        this.d.setText(b.a(lVar));
        this.b.setRating(f.a(lVar.q()));
    }

    public void setDivideLineVisibility(int i) {
        this.f.setVisibility(i);
    }
}
