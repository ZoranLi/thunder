package com.xunlei.common.commonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.R;

public class SimpleLoadingPageView extends LinearLayout implements IWebpageProgress {
    public static int TYPE_ALL_WHITE_BG = 1;
    public static int TYPE_GLOBAL;
    private GifView gifView;
    private BounceLoadingView mBounceLoadingView;
    private View mContainer;
    private int mCurrentType = null;
    private ImageView mLoadingAnimate;
    private TextView mTextView;

    public SimpleLoadingPageView(Context context, int i) {
        super(context);
        this.mCurrentType = i;
        init();
    }

    public SimpleLoadingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SimpleLoadingPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(17);
        initView();
    }

    private void initView() {
        if (this.mCurrentType == TYPE_GLOBAL) {
            this.mContainer = LayoutInflater.from(getContext()).inflate(R.layout.layout_simple_loading_global, this);
            this.mLoadingAnimate = (ImageView) findViewById(R.id.loading_animate);
        } else {
            this.mContainer = LayoutInflater.from(getContext()).inflate(R.layout.layout_simple_loading, this);
            this.mBounceLoadingView = (BounceLoadingView) findViewById(R.id.gif_view);
            this.mBounceLoadingView.addBitmap(R.drawable.bounce_loading_3);
            this.mBounceLoadingView.addBitmap(R.drawable.bounce_loading_1);
            this.mBounceLoadingView.addBitmap(R.drawable.bounce_loading_2);
            this.mBounceLoadingView.setShadowColor(Color.parseColor("#d2d9de"));
            this.mBounceLoadingView.setDuration(700);
        }
        this.mTextView = (TextView) this.mContainer.findViewById(R.id.loading_tip);
    }

    public void setTip(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(str);
        }
    }

    public void show() {
        setVisibility(0);
        if (this.mCurrentType == TYPE_GLOBAL) {
            ((AnimationDrawable) this.mLoadingAnimate.getDrawable()).start();
        } else {
            this.mBounceLoadingView.start();
        }
    }

    public void hide() {
        setVisibility(8);
        if (this.mCurrentType == TYPE_GLOBAL) {
            ((AnimationDrawable) this.mLoadingAnimate.getDrawable()).stop();
        } else {
            this.mBounceLoadingView.stop();
        }
    }

    public void hideBlackBackground() {
        this.mContainer.setBackgroundResource(0);
    }
}
