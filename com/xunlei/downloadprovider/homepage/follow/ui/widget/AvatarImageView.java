package com.xunlei.downloadprovider.homepage.follow.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;

public class AvatarImageView extends FrameLayout {
    public ImageView a;
    public ImageView b;

    public AvatarImageView(Context context) {
        super(context);
        a(context);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.follow_tab_my_following_avatar_view, this, true);
        this.a = (ImageView) context.findViewById(R.id.iv_avatar);
        this.b = (ImageView) context.findViewById(R.id.iv_account_type);
    }
}
