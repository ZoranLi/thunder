package com.xunlei.downloadprovider.publiser.common.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class PublisherBottomFollowBtn extends FrameLayout {
    private TextView a;
    private TextView b;

    public PublisherBottomFollowBtn(@NonNull Context context) {
        super(context);
        a();
    }

    public PublisherBottomFollowBtn(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PublisherBottomFollowBtn(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.publisher_bottom_follow_btn, this);
        this.a = (TextView) findViewById(R.id.tv_followed);
        this.b = (TextView) findViewById(R.id.tv_unfollow);
    }

    public void setFollowStatus(boolean z) {
        if (z) {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }
}
