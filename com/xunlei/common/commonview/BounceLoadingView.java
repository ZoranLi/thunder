package com.xunlei.common.commonview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.ArrayList;

public class BounceLoadingView extends View {
    private static final int DEFAULT_DURATION = 800;
    private static final int SHADOW_COLOR = -3355444;
    private static final String TAG = "BounceLoadingView";
    private ValueAnimator animator;
    private ArrayList<Bitmap> mBitmapList;
    private Paint mBitmapPaint;
    private Bitmap mCurrentBitmap;
    private int mCurrentIndex;
    private int mDuration;
    private float mHalfShadowHeight;
    private float mHalfShadowWidth;
    private float mPercent;
    private int mShadowColor;
    private Paint mShadowPaint;
    private RectF mShadowRectF;
    private float mTopMargin;
    private Matrix matrix;

    public BounceLoadingView(Context context) {
        this(context, null);
    }

    public BounceLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BounceLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShadowColor = SHADOW_COLOR;
        this.mDuration = 800;
        setup();
    }

    @TargetApi(21)
    public BounceLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mShadowColor = SHADOW_COLOR;
        this.mDuration = 800;
    }

    private void setup() {
        this.mPercent = 0.0f;
        this.mCurrentIndex = 0;
        this.matrix = new Matrix();
        this.mShadowRectF = new RectF();
        this.mBitmapList = new ArrayList();
        this.mShadowPaint = new Paint(1);
        this.mShadowPaint.setStyle(Style.FILL);
        this.mShadowPaint.setColor(this.mShadowColor);
        this.mBitmapPaint = new Paint(1);
    }

    public void addBitmap(int i) {
        try {
            addBitmap(BitmapFactory.decodeResource(getResources(), i));
        } catch (int i2) {
            i2.printStackTrace();
        }
    }

    public void addBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.mBitmapList.add(bitmap);
        }
    }

    public void addBitmaps(ArrayList<Bitmap> arrayList) {
        if (arrayList != null) {
            this.mBitmapList.addAll(arrayList);
        }
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void start() {
        new StringBuilder("start--").append(getContext());
        stop();
        if (this.animator == null) {
            this.animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
            this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animator.setRepeatCount(-1);
            this.animator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    valueAnimator = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (valueAnimator != BounceLoadingView.this.mPercent) {
                        BounceLoadingView.this.mPercent = valueAnimator;
                        BounceLoadingView.this.postInvalidate();
                    }
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BounceLoadingView.this.mCurrentIndex = 0;
                    BounceLoadingView.this.mCurrentBitmap = (Bitmap) BounceLoadingView.this.mBitmapList.get(BounceLoadingView.this.mCurrentIndex);
                    new StringBuilder("onAnimationStart--").append(BounceLoadingView.this.getContext());
                }

                public void onAnimationRepeat(Animator animator) {
                    new StringBuilder("onAnimationRepeat--").append(BounceLoadingView.this.getContext());
                    if (BounceLoadingView.this.mBitmapList != null && BounceLoadingView.this.mBitmapList.size() > null) {
                        BounceLoadingView.this.mCurrentIndex = BounceLoadingView.this.mCurrentIndex + 1;
                        if (BounceLoadingView.this.mCurrentIndex >= BounceLoadingView.this.mBitmapList.size()) {
                            BounceLoadingView.this.mCurrentIndex = 0;
                        }
                        BounceLoadingView.this.mCurrentBitmap = (Bitmap) BounceLoadingView.this.mBitmapList.get(BounceLoadingView.this.mCurrentIndex);
                    }
                }
            });
        }
        this.animator.setDuration((long) this.mDuration);
        this.animator.start();
    }

    public void stop() {
        StringBuilder stringBuilder = new StringBuilder("onAnimationRepeat--stop=");
        stringBuilder.append(this.animator);
        stringBuilder.append(getContext());
        if (this.animator != null) {
            this.animator.cancel();
            this.animator = null;
        }
    }

    public void setShadowColor(int i) {
        this.mShadowColor = i;
        if (this.mShadowPaint != 0) {
            this.mShadowPaint.setColor(this.mShadowColor);
            postInvalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mHalfShadowWidth = Math.max(16.0f, (((float) getWidth()) / 4.0f) * this.mPercent);
        this.mHalfShadowHeight = Math.max(8.0f, (((float) getHeight()) / 9.0f) * this.mPercent);
        this.mShadowRectF.set((((float) getWidth()) / 2.0f) - this.mHalfShadowWidth, (((float) (getHeight() * 7)) / 8.0f) - this.mHalfShadowHeight, (((float) getWidth()) / 2.0f) + this.mHalfShadowWidth, (((float) (getHeight() * 7)) / 8.0f) + this.mHalfShadowHeight);
        canvas.drawOval(this.mShadowRectF, this.mShadowPaint);
        if (this.mCurrentBitmap != null) {
            canvas.save();
            this.mTopMargin = ((((float) getHeight()) * 0.9f) - ((float) this.mCurrentBitmap.getHeight())) * this.mPercent;
            canvas.translate((((float) getWidth()) / 2.0f) - (((float) this.mCurrentBitmap.getWidth()) / 2.0f), this.mTopMargin);
            canvas.drawBitmap(this.mCurrentBitmap, this.matrix, this.mBitmapPaint);
            canvas.restore();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }
}
