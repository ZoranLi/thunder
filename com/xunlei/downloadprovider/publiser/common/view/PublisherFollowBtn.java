package com.xunlei.downloadprovider.publiser.common.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class PublisherFollowBtn extends FrameLayout {
    public TextView a;
    public View b;
    private TextView c;

    public PublisherFollowBtn(@NonNull Context context) {
        super(context);
        a();
    }

    public PublisherFollowBtn(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PublisherFollowBtn(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setBackgroundResource(R.drawable.publisher_top_follow_btn_bg);
        LayoutInflater.from(getContext()).inflate(R.layout.publisher_follow_btn, this);
        this.c = (TextView) findViewById(R.id.tv_followed);
        this.a = (TextView) findViewById(R.id.tv_unfollow);
        this.b = findViewById(R.id.layout_follow_loading);
        ((ImageView) findViewById(R.id.iv_follow_loading)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.follow_loading));
    }

    public void setFollowStatus(boolean z) {
        this.b.setVisibility(8);
        if (z) {
            setSelected(true);
            this.a.setVisibility(8);
            this.c.setVisibility(0);
            return;
        }
        setSelected(false);
        this.c.setVisibility(8);
        this.a.setVisibility(0);
    }
}
