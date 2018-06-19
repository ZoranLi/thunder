package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.cardview.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Style.FILL);
        this.mCornerRadius = (float) ((int) (f + PayBaseConstants.HALF_OF_FLOAT));
        this.mCardBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private int toEven(float f) {
        f = (int) (f + PayBaseConstants.HALF_OF_FLOAT);
        return f % 2 == 1 ? f - Float.MIN_VALUE : f;
    }

    void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    private void setShadowSize(float f, float f2) {
        StringBuilder stringBuilder;
        if (f < 0.0f) {
            stringBuilder = new StringBuilder("Invalid shadow size ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f2 < 0.0f) {
            stringBuilder = new StringBuilder("Invalid max shadow size ");
            stringBuilder.append(f2);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
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
                this.mShadowSize = (float) ((int) (((f * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) + PayBaseConstants.HALF_OF_FLOAT));
                this.mDirty = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float calculateVerticalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f2))) : f * SHADOW_MULTIPLIER;
    }

    static float calculateHorizontalPadding(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - COS_45) * ((double) f2))) : f;
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.mBackground.getColorForState(iArr, this.mBackground.getDefaultColor());
        if (this.mPaint.getColor() == iArr) {
            return null;
        }
        this.mPaint.setColor(iArr);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.mBackground != null && this.mBackground.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setCornerRadius(float f) {
        if (f < 0.0f) {
            StringBuilder stringBuilder = new StringBuilder("Invalid radius ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        f = (float) ((int) (f + PayBaseConstants.HALF_OF_FLOAT));
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
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    private void drawShadow(Canvas canvas) {
        float f = (-this.mCornerRadius) - this.mShadowSize;
        float f2 = (this.mCornerRadius + ((float) this.mInsetShadow)) + (this.mRawShadowSize / 2.0f);
        float f3 = 2.0f * f2;
        Object obj = this.mCardBounds.width() - f3 > 0.0f ? 1 : null;
        Object obj2 = this.mCardBounds.height() - f3 > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.top + f2);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - f3, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - f3, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
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
        float f = r0.mCornerRadius / (r0.mCornerRadius + r0.mShadowSize);
        r0.mCornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, r0.mCornerRadius + r0.mShadowSize, new int[]{r0.mShadowStartColor, r0.mShadowStartColor, r0.mShadowEndColor}, new float[]{0.0f, f, 1.0f}, TileMode.CLAMP));
        r0.mEdgeShadowPaint.setShader(new LinearGradient(0.0f, (-r0.mCornerRadius) + r0.mShadowSize, 0.0f, (-r0.mCornerRadius) - r0.mShadowSize, new int[]{r0.mShadowStartColor, r0.mShadowStartColor, r0.mShadowEndColor}, new float[]{0.0f, PayBaseConstants.HALF_OF_FLOAT, 1.0f}, TileMode.CLAMP));
        r0.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * SHADOW_MULTIPLIER;
        this.mCardBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f);
        buildShadowCorners();
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }

    void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinWidth() {
        return (Math.max(this.mRawMaxShadowSize, (this.mCornerRadius + ((float) this.mInsetShadow)) + (this.mRawMaxShadowSize / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f);
    }

    float getMinHeight() {
        return (Math.max(this.mRawMaxShadowSize, (this.mCornerRadius + ((float) this.mInsetShadow)) + ((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) * 2.0f);
    }

    void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    ColorStateList getColor() {
        return this.mBackground;
    }
}
