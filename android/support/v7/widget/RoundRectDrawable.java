package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable extends Drawable {
    private ColorStateList mBackground;
    private final RectF mBoundsF;
    private final Rect mBoundsI;
    private boolean mInsetForPadding = false;
    private boolean mInsetForRadius = true;
    private float mPadding;
    private final Paint mPaint;
    private float mRadius;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private Mode mTintMode = Mode.SRC_IN;

    public int getOpacity() {
        return -3;
    }

    RoundRectDrawable(ColorStateList colorStateList, float f) {
        this.mRadius = f;
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    void setPadding(float f, boolean z, boolean z2) {
        if (f != this.mPadding || this.mInsetForPadding != z || this.mInsetForRadius != z2) {
            this.mPadding = f;
            this.mInsetForPadding = z;
            this.mInsetForRadius = z2;
            updateBounds(0.0f);
            invalidateSelf();
        }
    }

    float getPadding() {
        return this.mPadding;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.mPaint;
        if (this.mTintFilter == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.mTintFilter);
            obj = 1;
        }
        canvas.drawRoundRect(this.mBoundsF, this.mRadius, this.mRadius, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    private void updateBounds(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.mBoundsF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.mBoundsI.set(rect);
        if (this.mInsetForPadding != null) {
            rect = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
            this.mBoundsI.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mPadding, this.mRadius, this.mInsetForRadius)), (int) Math.ceil((double) rect));
            this.mBoundsF.set(this.mBoundsI);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateBounds(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.mBoundsI, this.mRadius);
    }

    void setRadius(float f) {
        if (f != this.mRadius) {
            this.mRadius = f;
            updateBounds(0.0f);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public float getRadius() {
        return this.mRadius;
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.mBackground.getColorForState(iArr, this.mBackground.getDefaultColor());
        boolean z = iArr != this.mPaint.getColor();
        if (z) {
            this.mPaint.setColor(iArr);
        }
        if (this.mTint == null || this.mTintMode == null) {
            return z;
        }
        this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
        return true;
    }

    public boolean isStateful() {
        return (this.mTint != null && this.mTint.isStateful()) || ((this.mBackground != null && this.mBackground.isStateful()) || super.isStateful());
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }
}
