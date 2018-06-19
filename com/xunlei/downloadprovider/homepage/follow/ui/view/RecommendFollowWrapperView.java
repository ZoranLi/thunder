package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;

public class RecommendFollowWrapperView extends RecommendFollowBaseView {
    private RecommendFollowView a;
    private RecommendFollowLiveView b;

    public RecommendFollowWrapperView(Context context) {
        super(context);
        a(context);
    }

    public RecommendFollowWrapperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RecommendFollowWrapperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.follow_recommend_wrapper_item, this, true);
        this.a = (RecommendFollowView) context.findViewById(R.id.recommend);
        this.b = (RecommendFollowLiveView) context.findViewById(R.id.recommend_live);
    }

    public void setFrom(From from) {
        super.setFrom(from);
        this.a.setFrom(from);
        this.b.setFrom(from);
    }

    public final void a(a aVar) {
        super.a(aVar);
        if ("rad".equals(aVar.c)) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            this.b.a(aVar);
            return;
        }
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.a.a(aVar);
    }

    public void setOnFollowSuccessListener(RecommendFollowBaseView.a aVar) {
        this.a.setOnFollowSuccessListener(aVar);
        this.b.setOnFollowSuccessListener(aVar);
    }

    protected final void a() {
        this.a.a();
        this.b.a();
    }

    protected final void b() {
        this.a.b();
        this.b.b();
    }
}
