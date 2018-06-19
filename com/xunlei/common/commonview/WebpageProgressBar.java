package com.xunlei.common.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class WebpageProgressBar extends View implements IWebpageProgress {
    private static final int FRAME_REFRESH_DELAY = 16;
    private Animation mFinishAnimation;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mMaxProgress = 10000;
    private Paint mPaint = new Paint();
    private int mProgress;
    private Runnable mRefreshRunnable = new Runnable() {
        public void run() {
            int access$200 = WebpageProgressBar.this.mMaxProgress;
            int access$300 = WebpageProgressBar.this.mProgress;
            if (access$300 < WebpageProgressBar.this.mMaxProgress) {
                if (WebpageProgressBar.this.mState == State.FINISHING) {
                    access$200 = 200;
                } else {
                    access$200 = 60 / (access$200 / (access$200 - access$300));
                }
                if (access$200 > 0) {
                    WebpageProgressBar.this.setProgress(access$300 + access$200);
                }
                if (WebpageProgressBar.this.isShown()) {
                    WebpageProgressBar.this.mHandler.postDelayed(this, 16);
                }
                return;
            }
            WebpageProgressBar.this.hide();
        }
    };
    private State mState = State.NONE;

    private enum State {
        NONE,
        PROGRESSING,
        FINISHING
    }

    public WebpageProgressBar(Context context) {
        super(context);
    }

    public WebpageProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebpageProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void show() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
        if (this.mFinishAnimation != null) {
            this.mFinishAnimation.cancel();
            this.mFinishAnimation = null;
        }
        this.mState = State.PROGRESSING;
        setVisibility(0);
        this.mHandler.post(this.mRefreshRunnable);
    }

    public void hide() {
        if (this.mFinishAnimation != null) {
            this.mFinishAnimation.cancel();
            this.mFinishAnimation = null;
        }
        animaToFinish();
    }

    private void resetState() {
        if (this.mFinishAnimation != null) {
            this.mFinishAnimation.cancel();
            this.mFinishAnimation = null;
        }
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
        this.mState = State.NONE;
        this.mProgress = 0;
    }

    private void animaToFinish() {
        this.mState = State.FINISHING;
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        alphaAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                WebpageProgressBar.this.mFinishAnimation = null;
                WebpageProgressBar.this.doProgressFinish();
            }
        });
        this.mFinishAnimation = alphaAnimation;
        startAnimation(alphaAnimation);
    }

    private void doProgressFinish() {
        resetState();
        setVisibility(4);
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMaxProgress() {
        return this.mMaxProgress;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > this.mMaxProgress) {
            i = this.mMaxProgress;
        }
        this.mProgress = i;
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int left = getLeft();
        int top = getTop();
        int bottom = getBottom();
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) left, (float) top, (float) (left + ((this.mProgress * getWidth()) / this.mMaxProgress)), (float) bottom, this.mPaint);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setupPaints();
    }

    private void setupPaints() {
        this.mPaint.setColor(Color.argb(255, 91, 152, 254));
    }
}
