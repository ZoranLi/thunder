package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class MediaPlayerLoadingView extends ImageView {
    private boolean a;
    private Animation b;
    private Handler c = new a(this);

    public MediaPlayerLoadingView(Context context) {
        super(context);
        setImageResource(R.drawable.ic_loading);
    }

    public MediaPlayerLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageResource(R.drawable.ic_loading);
    }

    public MediaPlayerLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setImageResource(R.drawable.ic_loading);
    }

    public final void a() {
        new StringBuilder("startLoading--isLoading=").append(this.a);
        this.c.removeMessages(1);
        this.c.sendEmptyMessageDelayed(1, 800);
    }

    public final void b() {
        new StringBuilder("stopLoading--isLoading=").append(this.a);
        this.c.removeMessages(1);
        if (this.a) {
            this.a = false;
            clearAnimation();
            setVisibility(8);
        }
    }

    static /* synthetic */ void a(MediaPlayerLoadingView mediaPlayerLoadingView) {
        new StringBuilder("doLoading--isLoading=").append(mediaPlayerLoadingView.a);
        if (mediaPlayerLoadingView.b == null) {
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            mediaPlayerLoadingView.b = rotateAnimation;
        }
        if (!mediaPlayerLoadingView.a) {
            mediaPlayerLoadingView.a = true;
            mediaPlayerLoadingView.startAnimation(mediaPlayerLoadingView.b);
            mediaPlayerLoadingView.setVisibility(0);
        }
    }
}
