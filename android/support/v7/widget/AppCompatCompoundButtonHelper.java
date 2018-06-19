package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        attributeSet = this.mView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (attributeSet.hasValue(R.styleable.CompoundButton_android_button) != 0) {
                i = attributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
                if (i != 0) {
                    this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), i));
                }
            }
            if (attributeSet.hasValue(R.styleable.CompoundButton_buttonTint) != 0) {
                CompoundButtonCompat.setButtonTintList(this.mView, attributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (attributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode) != 0) {
                CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(attributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
            attributeSet.recycle();
        } catch (Throwable th) {
            attributeSet.recycle();
        }
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    void setSupportButtonTintMode(@Nullable Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            buttonDrawable = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(buttonDrawable, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(buttonDrawable, this.mButtonTintMode);
            }
            if (buttonDrawable.isStateful()) {
                buttonDrawable.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(buttonDrawable);
        }
    }

    int getCompoundPaddingLeft(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        return buttonDrawable != null ? i + buttonDrawable.getIntrinsicWidth() : i;
    }
}
