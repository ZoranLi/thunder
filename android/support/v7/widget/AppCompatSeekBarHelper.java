package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint = false;
    private boolean mHasTickMarkTintMode = false;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList = null;
    private Mode mTickMarkTintMode = null;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mView = seekBar;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        attributeSet = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        i = attributeSet.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (i != 0) {
            this.mView.setThumb(i);
        }
        setTickMark(attributeSet.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (attributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode) != 0) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(attributeSet.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (attributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint) != 0) {
            this.mTickMarkTintList = attributeSet.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.mHasTickMarkTint = true;
        }
        attributeSet.recycle();
        applyTickMarkTint();
    }

    void setTickMark(@Nullable Drawable drawable) {
        if (this.mTickMark != null) {
            this.mTickMark.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    @Nullable
    Drawable getTickMark() {
        return this.mTickMark;
    }

    void setTickMarkTintList(@Nullable ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    @Nullable
    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    void setTickMarkTintMode(@Nullable Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }

    @Nullable
    Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    private void applyTickMarkTint() {
        if (this.mTickMark == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            this.mTickMark = DrawableCompat.wrap(this.mTickMark.mutate());
            if (this.mHasTickMarkTint) {
                DrawableCompat.setTintList(this.mTickMark, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    @RequiresApi(11)
    void jumpDrawablesToCurrentState() {
        if (this.mTickMark != null) {
            this.mTickMark.jumpToCurrentState();
        }
    }

    void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    void drawTickMarks(Canvas canvas) {
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight())) / ((float) max);
                intrinsicWidth = canvas.save();
                canvas.translate((float) this.mView.getPaddingLeft(), (float) (this.mView.getHeight() / 2));
                for (intrinsicHeight = 0; intrinsicHeight <= max; intrinsicHeight++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicWidth);
            }
        }
    }
}
