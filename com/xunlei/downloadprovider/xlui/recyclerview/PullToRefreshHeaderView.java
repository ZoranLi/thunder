package com.xunlei.downloadprovider.xlui.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonview.GifView;
import com.xunlei.downloadprovider.R;

public class PullToRefreshHeaderView extends LinearLayout {
    final Handler a = new Handler();
    int b = null;
    GifView c;
    public int d;
    private View e;
    private View f;
    private TextView g;
    private ImageView h;

    public PullToRefreshHeaderView(Context context) {
        super(context);
        b();
    }

    public PullToRefreshHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.e = LayoutInflater.from(getContext()).inflate(R.layout.common_pull_to_refresh_header_view, null);
        addView(this.e, layoutParams);
        this.f = findViewById(R.id.pull_to_refresh_content);
        this.g = (TextView) findViewById(R.id.pull_to_refresh_text);
        this.c = (GifView) findViewById(R.id.pull_to_refresh_pulling);
        this.h = (ImageView) findViewById(R.id.pull_to_refresh_refreshing);
        measure(-2, -2);
        this.d = getMeasuredHeight();
        this.c.setVisibility(0);
        this.h.setVisibility(8);
    }

    protected int getWrapHeight() {
        return this.d;
    }

    public void setContentGravity(int i) {
        LayoutParams layoutParams = this.f.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            this.f.setLayoutParams(layoutParams2);
        }
    }

    public void setRefreshingText(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    public void setRefreshingText(int i) {
        this.g.setText(i);
    }

    public void setState(int i) {
        if (i != this.b) {
            setContentGravity(17);
            Drawable drawable;
            if (i == 2) {
                this.c.setVisibility(8);
                this.h.setVisibility(0);
                drawable = this.h.getDrawable();
                if (drawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawable).start();
                }
            } else {
                this.c.setVisibility(0);
                this.h.setVisibility(8);
                this.h.clearAnimation();
                drawable = this.h.getDrawable();
                if (drawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawable).stop();
                }
            }
            switch (i) {
                case 0:
                    setRefreshingText((CharSequence) "下拉刷新");
                    break;
                case 1:
                    if (this.b != 1) {
                        setRefreshingText((CharSequence) "下拉刷新");
                        break;
                    }
                    break;
                case 2:
                    setRefreshingText((CharSequence) "正在刷新...");
                    break;
                default:
                    break;
            }
            this.b = i;
        }
    }

    public int getState() {
        return this.b;
    }

    public void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.height = i;
        this.e.setLayoutParams(layoutParams);
    }

    public int getVisibleHeight() {
        return this.e.getLayoutParams().height;
    }

    public final boolean a() {
        return 2 == this.b;
    }

    final void a(int i) {
        i = ValueAnimator.ofInt(new int[]{getVisibleHeight(), i});
        i.addUpdateListener(new g(this));
        i.setDuration(300).start();
    }

    public void setPullingGif(int i) {
        this.c.setMovieResource(i);
        i = this.c.getLayoutParams();
        i.width = 378;
        i.height = 120;
        this.c.setLayoutParams(i);
    }
}
