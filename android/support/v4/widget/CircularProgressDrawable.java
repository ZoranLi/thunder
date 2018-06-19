package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.Preconditions;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = new int[]{-16777216};
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    private boolean mFinishing;
    private Resources mResources;
    private final Ring mRing = new Ring();
    private float mRotation;
    private float mRotationCount;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    private static class Ring {
        int mAlpha = 255;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint = new Paint();
        float mArrowScale = 1.0f;
        int mArrowWidth;
        final Paint mCirclePaint = new Paint();
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim = 0.0f;
        final Paint mPaint = new Paint();
        float mRingCenterRadius;
        float mRotation = 0.0f;
        boolean mShowArrow;
        float mStartTrim = 0.0f;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth = 5.0f;
        final RectF mTempBounds = new RectF();

        Ring() {
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.mArrowPaint.setStyle(Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
            this.mCirclePaint.setColor(0);
        }

        void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        void setStrokeCap(Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        float getArrowWidth() {
            return (float) this.mArrowWidth;
        }

        float getArrowHeight() {
            return (float) this.mArrowHeight;
        }

        void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f = this.mRingCenterRadius + (this.mStrokeWidth / 2.0f);
            if (this.mRingCenterRadius <= 0.0f) {
                f = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.mArrowWidth) * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f, ((float) rect.centerY()) - f, ((float) rect.centerX()) + f, ((float) rect.centerY()) + f);
            rect = (this.mStartTrim + this.mRotation) * 1135869952;
            float f2 = ((this.mEndTrim + this.mRotation) * 360.0f) - rect;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            f = this.mStrokeWidth / 2.0f;
            rectF.inset(f, f);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            f = -f;
            rectF.inset(f, f);
            canvas.drawArc(rectF, rect, f2, false, this.mPaint);
            drawTriangle(canvas, rect, f2, rectF);
        }

        void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.mShowArrow) {
                if (this.mArrow == null) {
                    this.mArrow = new Path();
                    this.mArrow.setFillType(FillType.EVEN_ODD);
                } else {
                    this.mArrow.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (((float) this.mArrowWidth) * this.mArrowScale) / 2.0f;
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(((float) this.mArrowWidth) * this.mArrowScale, 0.0f);
                this.mArrow.lineTo((((float) this.mArrowWidth) * this.mArrowScale) / 2.0f, ((float) this.mArrowHeight) * this.mArrowScale);
                this.mArrow.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(null);
        }

        int[] getColors() {
            return this.mColors;
        }

        void setColor(int i) {
            this.mCurrentColor = i;
        }

        void setBackgroundColor(int i) {
            this.mCirclePaint.setColor(i);
        }

        int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[this.mColorIndex];
        }

        int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        void setAlpha(int i) {
            this.mAlpha = i;
        }

        int getAlpha() {
            return this.mAlpha;
        }

        void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        void setStartTrim(float f) {
            this.mStartTrim = f;
        }

        float getStartTrim() {
            return this.mStartTrim;
        }

        float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        void setEndTrim(float f) {
            this.mEndTrim = f;
        }

        float getEndTrim() {
            return this.mEndTrim;
        }

        void setRotation(float f) {
            this.mRotation = f;
        }

        float getRotation() {
            return this.mRotation;
        }

        void setCenterRadius(float f) {
            this.mRingCenterRadius = f;
        }

        float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        boolean getShowArrow() {
            return this.mShowArrow;
        }

        void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
            }
        }

        float getArrowScale() {
            return this.mArrowScale;
        }

        float getStartingRotation() {
            return this.mStartingRotation;
        }

        void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }
    }

    private int evaluateColorChange(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        i &= 255;
        return ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16)) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f))) << 8)) | (i + ((int) (f * ((float) ((i2 & 255) - i)))));
    }

    public int getOpacity() {
        return -3;
    }

    public CircularProgressDrawable(Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        this.mRing.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void setSizeParameters(float f, float f2, float f3, float f4) {
        Ring ring = this.mRing;
        float f5 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f2 * f5);
        ring.setCenterRadius(f * f5);
        ring.setColorIndex(0.0f);
        ring.setArrowDimensions(f3 * f5, f4 * f5);
    }

    public void setStyle(int i) {
        if (i == 0) {
            setSizeParameters(1093664768, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
        } else {
            setSizeParameters(1089470464, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    public void setStrokeWidth(float f) {
        this.mRing.setStrokeWidth(f);
        invalidateSelf();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    public void setCenterRadius(float f) {
        this.mRing.setCenterRadius(f);
        invalidateSelf();
    }

    public void setStrokeCap(Cap cap) {
        this.mRing.setStrokeCap(cap);
        invalidateSelf();
    }

    public Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public void setArrowDimensions(float f, float f2) {
        this.mRing.setArrowDimensions(f, f2);
        invalidateSelf();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public void setArrowEnabled(boolean z) {
        this.mRing.setShowArrow(z);
        invalidateSelf();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
        invalidateSelf();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
        invalidateSelf();
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
        invalidateSelf();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public void setBackgroundColor(int i) {
        this.mRing.setBackgroundColor(i);
        invalidateSelf();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        invalidateSelf();
    }

    private void setRotation(float f) {
        this.mRotation = f;
    }

    private float getRotation() {
        return this.mRotation;
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666);
            this.mAnimator.start();
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    private void updateRingColor(float f, Ring ring) {
        if (f > COLOR_CHANGE_OFFSET) {
            ring.setColor(evaluateColorChange((f - COLOR_CHANGE_OFFSET) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }

    private void applyFinishTranslation(float f, Ring ring) {
        updateRingColor(f, ring);
        float floor = (float) (Math.floor((double) (ring.getStartingRotation() / MAX_PROGRESS_ARC)) + 1.0d);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - MIN_PROGRESS_ARC) - ring.getStartingStartTrim()) * f));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f));
    }

    private void applyTransformation(float f, Ring ring, boolean z) {
        if (this.mFinishing) {
            applyFinishTranslation(f, ring);
            return;
        }
        if (f != 1.0f || z) {
            float f2;
            float startingStartTrim;
            z = ring.getStartingRotation();
            if (f < 0.5f) {
                f2 = f / 0.5f;
                startingStartTrim = ring.getStartingStartTrim();
                f2 = startingStartTrim;
                startingStartTrim = ((0.79f * MATERIAL_INTERPOLATOR.getInterpolation(f2)) + MIN_PROGRESS_ARC) + startingStartTrim;
            } else {
                startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                f2 = startingStartTrim - ((0.79f * (1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f))) + MIN_PROGRESS_ARC);
            }
            z += RING_ROTATION * f;
            float f3 = GROUP_FULL_ROTATION * (f + this.mRotationCount);
            ring.setStartTrim(f2);
            ring.setEndTrim(startingStartTrim);
            ring.setRotation(z);
            setRotation(f3);
        }
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                valueAnimator = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.updateRingColor(valueAnimator, ring);
                CircularProgressDrawable.this.applyTransformation(valueAnimator, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.applyTransformation(1.0f, ring, true);
                ring.storeOriginals();
                ring.goToNextColor();
                if (CircularProgressDrawable.this.mFinishing) {
                    CircularProgressDrawable.this.mFinishing = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.setShowArrow(false);
                    return;
                }
                CircularProgressDrawable.this.mRotationCount = CircularProgressDrawable.this.mRotationCount + 1.0f;
            }
        });
        this.mAnimator = ofFloat;
    }
}
