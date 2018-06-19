package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private Rect mBounds = new Rect();
    private final RectF mClipRect = new RectF();
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint = new Paint();
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    SwipeProgressBar(View view) {
        this.mParent = view;
        this.mColor1 = COLOR1;
        this.mColor2 = Integer.MIN_VALUE;
        this.mColor3 = COLOR3;
        this.mColor4 = COLOR4;
    }

    final void setColorScheme(int i, int i2, int i3, int i4) {
        this.mColor1 = i;
        this.mColor2 = i2;
        this.mColor3 = i3;
        this.mColor4 = i4;
    }

    final void setTriggerPercentage(float f) {
        this.mTriggerPercentage = f;
        this.mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    final void start() {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }

    final void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }

    final boolean isRunning() {
        if (!this.mRunning) {
            if (this.mFinishTime <= 0) {
                return false;
            }
        }
        return true;
    }

    final void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.mBounds.width();
        int height = this.mBounds.height();
        int i = width / 2;
        int i2 = height / 2;
        int save = canvas.save();
        canvas2.clipRect(this.mBounds);
        if (!this.mRunning) {
            if (r6.mFinishTime <= 0) {
                if (r6.mTriggerPercentage > 0.0f && ((double) r6.mTriggerPercentage) <= 1.0d) {
                    drawTrigger(canvas2, i, i2);
                }
                canvas2.restoreToCount(save);
            }
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        long j = (currentAnimationTimeMillis - r6.mStartTime) / 2000;
        float f = ((float) ((currentAnimationTimeMillis - r6.mStartTime) % 2000)) / 20.0f;
        Object obj;
        if (r6.mRunning) {
            obj = null;
        } else if (currentAnimationTimeMillis - r6.mFinishTime >= 1000) {
            r6.mFinishTime = 0;
            return;
        } else {
            float f2 = (float) i;
            float interpolation = INTERPOLATOR.getInterpolation((((float) ((currentAnimationTimeMillis - r6.mFinishTime) % 1000)) / 10.0f) / 100.0f) * f2;
            r6.mClipRect.set(f2 - interpolation, 0.0f, f2 + interpolation, (float) height);
            canvas2.saveLayerAlpha(r6.mClipRect, 0, 0);
            obj = 1;
        }
        if (j == 0) {
            canvas2.drawColor(r6.mColor1);
        } else if (f >= 0.0f && f < 25.0f) {
            canvas2.drawColor(r6.mColor4);
        } else if (f >= 25.0f && f < 50.0f) {
            canvas2.drawColor(r6.mColor1);
        } else if (f < 50.0f || f >= 75.0f) {
            canvas2.drawColor(r6.mColor3);
        } else {
            canvas2.drawColor(r6.mColor2);
        }
        if (f >= 0.0f && f <= 25.0f) {
            Canvas canvas3 = canvas2;
            drawCircle(canvas3, (float) i, (float) i2, r6.mColor1, ((f + 25.0f) * 2.0f) / 100.0f);
        }
        if (f >= 0.0f && f <= 50.0f) {
            canvas3 = canvas2;
            drawCircle(canvas3, (float) i, (float) i2, r6.mColor2, (f * 2.0f) / 100.0f);
        }
        if (f >= 25.0f && f <= 75.0f) {
            canvas3 = canvas2;
            drawCircle(canvas3, (float) i, (float) i2, r6.mColor3, ((f - 25.0f) * 2.0f) / 100.0f);
        }
        if (f >= 50.0f && f <= 100.0f) {
            canvas3 = canvas2;
            drawCircle(canvas3, (float) i, (float) i2, r6.mColor4, ((f - 50.0f) * 2.0f) / 100.0f);
        }
        if (f >= 75.0f && f <= 100.0f) {
            canvas3 = canvas2;
            drawCircle(canvas3, (float) i, (float) i2, r6.mColor1, ((f - 75.0f) * 2.0f) / 100.0f);
        }
        if (r6.mTriggerPercentage > 0.0f && r14 != null) {
            canvas2.restoreToCount(save);
            width = canvas.save();
            canvas2.clipRect(r6.mBounds);
            drawTrigger(canvas2, i, i2);
            save = width;
        }
        ViewCompat.postInvalidateOnAnimation(r6.mParent, r6.mBounds.left, r6.mBounds.top, r6.mBounds.right, r6.mBounds.bottom);
        canvas2.restoreToCount(save);
    }

    private void drawTrigger(Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mColor1);
        i = (float) i;
        canvas.drawCircle(i, (float) i2, this.mTriggerPercentage * i, this.mPaint);
    }

    private void drawCircle(Canvas canvas, float f, float f2, int i, float f3) {
        this.mPaint.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        f2 = INTERPOLATOR.getInterpolation(f3);
        canvas.scale(f2, f2);
        canvas.drawCircle(0.0f, 0.0f, f, this.mPaint);
        canvas.restore();
    }

    final void setBounds(int i, int i2, int i3, int i4) {
        this.mBounds.left = i;
        this.mBounds.top = i2;
        this.mBounds.right = i3;
        this.mBounds.bottom = i4;
    }
}
