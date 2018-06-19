package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;

public class LikeView extends RelativeLayout {
    private TextView a;
    private ImageView b;
    private TextView c;
    private String d = "赞";

    public LikeView(Context context) {
        super(context);
        a(context);
    }

    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.click_like_view, this, true);
        this.a = (TextView) findViewById(R.id.tv_plus_one);
        this.b = (ImageView) findViewById(R.id.like_icon);
        this.c = (TextView) findViewById(R.id.like_count);
    }

    public final void a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), R.anim.scale_out2);
        loadAnimation.setAnimationListener(new e(this, loadAnimation2));
        loadAnimation3.setAnimationListener(new f(this));
        this.a.setVisibility(0);
        this.b.startAnimation(loadAnimation);
        this.a.startAnimation(loadAnimation3);
    }

    public final void a(boolean z, int i) {
        if (z) {
            this.b.setEnabled(false);
        } else {
            this.b.setEnabled(true);
        }
        if (i == 0) {
            this.c.setText(this.d);
        } else {
            this.c.setText(ConvertUtil.decimal2String((long) i, 10000, 10000, "万"));
        }
        if (TextUtils.isEmpty(this.c.getText())) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
    }

    public void setEmptyText(String str) {
        this.d = str;
    }

    public void setLikeIcon(int i) {
        this.b.setImageResource(i);
    }

    public void setLikeCountTextSize(int i) {
        this.c.setTextSize(1, (float) i);
    }

    public void setLikeCountTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void setLikeImageResource(int i) {
        this.b.setImageResource(i);
    }

    public final void b() {
        this.b.clearAnimation();
        this.a.clearAnimation();
        this.a.setVisibility(8);
    }
}
