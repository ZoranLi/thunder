package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper extends DrawableWrapper {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean mAddPaddingForCorners = true;
    final RectF mContentBounds;
    float mCornerRadius;
    final Paint mCornerShadowPaint;
    Path mCornerShadowPath;
    private boolean mDirty = true;
    final Paint mEdgeShadowPaint;
    float mMaxShadowSize;
    private boolean mPrintedShadowClipWarning = false;
    float mRawMaxShadowSize;
    float mRawShadowSize;
    private float mRotation;
    private final int mShadowEndColor;
    private final int mShadowMiddleColor;
    float mShadowSize;
    private final int mShadowStartColor;

    public int getOpacity() {
        return -3;
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.mShadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.mShadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.mShadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Style.FILL);
        this.mCornerRadius = (float) Math.round(f);
        this.mContentBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private static int toEven(float f) {
        f = Math.round(f);
        return f % 2 == 1 ? f - Float.MIN_VALUE : f;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.mDirty = true;
    }

    void setShadowSize(float f, float f2) {
        if (f >= 0.0f) {
            if (f2 >= 0.0f) {
                f = (float) toEven(f);
                f2 = (float) toEven(f2);
                if (f > f2) {
                    if (this.mPrintedShadowClipWarning == null) {
                        this.mPrintedShadowClipWarning = true;
                    }
                    f = f2;
                }
                if (this.mRawShadowSize != f || this.mRawMaxShadowSize != f2) {
                    this.mRawShadowSize = f;
                    this.mRawMaxShadowSize = f2;
                    this.mShadowSize = (float) Math.round(f * SHADOW_MULTIPLIER);
                    this.mMaxShadowSize = f2;
                    this.mDirty = true;
                    invalidateSelf();
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f2))) : f * SHADOW_MULTIPLIER;
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - COS_45) * ((double) f2))) : f;
    }

    public void setCornerRadius(float f) {
        f = (float) Math.round(f);
        if (this.mCornerRadius != f) {
            this.mCornerRadius = f;
            this.mDirty = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    final void setRotation(float f) {
        if (this.mRotation != f) {
            this.mRotation = f;
            invalidateSelf();
        }
    }

    private void drawShadow(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.mRotation, this.mContentBounds.centerX(), this.mContentBounds.centerY());
        float f4 = (-this.mCornerRadius) - this.mShadowSize;
        float f5 = this.mCornerRadius;
        float f6 = 2.0f * f5;
        Object obj = this.mContentBounds.width() - f6 > 0.0f ? 1 : null;
        Object obj2 = r0.mContentBounds.height() - f6 > 0.0f ? 1 : null;
        float f7 = f5 / ((r0.mRawShadowSize - (r0.mRawShadowSize * 0.5f)) + f5);
        float f8 = f5 / ((r0.mRawShadowSize - (r0.mRawShadowSize * SHADOW_TOP_SCALE)) + f5);
        float f9 = f5 / ((r0.mRawShadowSize - (r0.mRawShadowSize * SHADOW_BOTTOM_SCALE)) + f5);
        int save2 = canvas.save();
        canvas2.translate(r0.mContentBounds.left + f5, r0.mContentBounds.top + f5);
        canvas2.scale(f7, f8);
        canvas2.drawPath(r0.mCornerShadowPath, r0.mCornerShadowPaint);
        if (obj != null) {
            canvas2.scale(SHADOW_BOTTOM_SCALE / f7, SHADOW_BOTTOM_SCALE);
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
            canvas2.drawRect(0.0f, f4, r0.mContentBounds.width() - f6, -r0.mCornerRadius, r0.mEdgeShadowPaint);
        } else {
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        i = canvas.save();
        canvas2.translate(r0.mContentBounds.right - f5, r0.mContentBounds.bottom - f5);
        f8 = f;
        canvas2.scale(f7, f8);
        canvas2.rotate(180.0f);
        canvas2.drawPath(r0.mCornerShadowPath, r0.mCornerShadowPaint);
        if (obj != null) {
            canvas2.scale(SHADOW_BOTTOM_SCALE / f7, SHADOW_BOTTOM_SCALE);
            f3 = f2;
            f2 = f8;
            canvas2.drawRect(0.0f, f4, r0.mContentBounds.width() - f6, (-r0.mCornerRadius) + r0.mShadowSize, r0.mEdgeShadowPaint);
        } else {
            f3 = f2;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        int save3 = canvas.save();
        canvas2.translate(r0.mContentBounds.left + f5, r0.mContentBounds.bottom - f5);
        canvas2.scale(f7, f2);
        canvas2.rotate(270.0f);
        canvas2.drawPath(r0.mCornerShadowPath, r0.mCornerShadowPaint);
        if (obj2 != null) {
            canvas2.scale(SHADOW_BOTTOM_SCALE / f2, SHADOW_BOTTOM_SCALE);
            canvas2.drawRect(0.0f, f4, r0.mContentBounds.height() - f6, -r0.mCornerRadius, r0.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        save = canvas.save();
        canvas2.translate(r0.mContentBounds.right - f5, r0.mContentBounds.top + f5);
        f5 = f3;
        canvas2.scale(f7, f5);
        canvas2.rotate(90.0f);
        canvas2.drawPath(r0.mCornerShadowPath, r0.mCornerShadowPaint);
        if (obj2 != null) {
            canvas2.scale(SHADOW_BOTTOM_SCALE / f5, SHADOW_BOTTOM_SCALE);
            canvas2.drawRect(0.0f, f4, r0.mContentBounds.height() - f6, -r0.mCornerRadius, r0.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save);
        canvas2.restoreToCount(i2);
    }

    private void buildShadowCorners() {
        RectF rectF = new RectF(-this.mCornerRadius, -this.mCornerRadius, this.mCornerRadius, this.mCornerRadius);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.mShadowSize, -this.mShadowSize);
        if (this.mCornerShadowPath == null) {
            r0.mCornerShadowPath = new Path();
        } else {
            r0.mCornerShadowPath.reset();
        }
        r0.mCornerShadowPath.setFillType(FillType.EVEN_ODD);
        r0.mCornerShadowPath.moveTo(-r0.mCornerRadius, 0.0f);
        r0.mCornerShadowPath.rLineTo(-r0.mShadowSize, 0.0f);
        r0.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        r0.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        r0.mCornerShadowPath.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = r0.mCornerRadius / f;
            float f3 = ((SHADOW_BOTTOM_SCALE - f2) / 2.0f) + f2;
            Shader shader = r8;
            float[] fArr = new float[]{0.0f, f2, f3, SHADOW_BOTTOM_SCALE};
            Paint paint = r0.mCornerShadowPaint;
            Shader radialGradient = new RadialGradient(0.0f, 0.0f, f, new int[]{0, r0.mShadowStartColor, r0.mShadowMiddleColor, r0.mShadowEndColor}, fArr, TileMode.CLAMP);
            paint.setShader(shader);
        }
        Paint paint2 = r0.mEdgeShadowPaint;
        float f4 = rectF.top;
        paint2.setShader(new LinearGradient(0.0f, f4, 0.0f, rectF2.top, new int[]{r0.mShadowStartColor, r0.mShadowMiddleColor, r0.mShadowEndColor}, new float[]{0.0f, 0.5f, SHADOW_BOTTOM_SCALE}, TileMode.CLAMP));
        r0.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * SHADOW_MULTIPLIER;
        this.mContentBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.mContentBounds.left, (int) this.mContentBounds.top, (int) this.mContentBounds.right, (int) this.mContentBounds.bottom);
        buildShadowCorners();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getMinWidth() {
        return (Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (this.mRawMaxShadowSize / 2.0f)) * 2.0f) + (this.mRawMaxShadowSize * 2.0f);
    }

    public float getMinHeight() {
        return (Math.max(this.mRawMaxShadowSize, this.mCornerRadius + ((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) * 2.0f);
    }
}
