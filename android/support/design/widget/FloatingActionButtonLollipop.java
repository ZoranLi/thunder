package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonImpl {
    private InsetDrawable mInsetDrawable;

    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulGradientDrawable() {
        }
    }

    void jumpDrawableToCurrentState() {
    }

    void onDrawableStateChanged(int[] iArr) {
    }

    boolean requirePreDrawListener() {
        return false;
    }

    FloatingActionButtonLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    void setBackgroundDrawable(ColorStateList colorStateList, Mode mode, int i, int i2) {
        this.mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
        DrawableCompat.setTintList(this.mShapeDrawable, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, mode);
        }
        if (i2 > 0) {
            this.mBorderDrawable = createBorderDrawable(i2, colorStateList);
            colorStateList = new LayerDrawable(new Drawable[]{this.mBorderDrawable, this.mShapeDrawable});
        } else {
            this.mBorderDrawable = null;
            colorStateList = this.mShapeDrawable;
        }
        this.mRippleDrawable = new RippleDrawable(ColorStateList.valueOf(i), colorStateList, null);
        this.mContentBackground = this.mRippleDrawable;
        this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
    }

    void setRippleColor(int i) {
        if (this.mRippleDrawable instanceof RippleDrawable) {
            ((RippleDrawable) this.mRippleDrawable).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    void onElevationsChanged(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.mView, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.mView, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(ANIM_INTERPOLATOR);
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.mView, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.mView, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(ANIM_INTERPOLATOR);
            stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, animatorSet);
            f2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.mView, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.mView, View.TRANSLATION_Z, new float[]{this.mView.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.mView, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            f2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            f2.setInterpolator(ANIM_INTERPOLATOR);
            stateListAnimator.addState(ENABLED_STATE_SET, f2);
            f = new AnimatorSet();
            f.play(ObjectAnimator.ofFloat(this.mView, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.mView, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            f.setInterpolator(ANIM_INTERPOLATOR);
            stateListAnimator.addState(EMPTY_STATE_SET, f);
            this.mView.setStateListAnimator(stateListAnimator);
        } else if (this.mView.isEnabled()) {
            this.mView.setElevation(f);
            if (this.mView.isFocused() == null) {
                if (this.mView.isPressed() == null) {
                    this.mView.setTranslationZ(0.0f);
                }
            }
            this.mView.setTranslationZ(f2);
        } else {
            this.mView.setElevation(0.0f);
            this.mView.setTranslationZ(0.0f);
        }
        if (this.mShadowViewDelegate.isCompatPaddingEnabled() != null) {
            updatePadding();
        }
    }

    public float getElevation() {
        return this.mView.getElevation();
    }

    void onCompatShadowChanged() {
        updatePadding();
    }

    void onPaddingUpdated(Rect rect) {
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            this.mInsetDrawable = new InsetDrawable(this.mRippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
            this.mShadowViewDelegate.setBackgroundDrawable(this.mInsetDrawable);
            return;
        }
        this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
    }

    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawableLollipop();
    }

    GradientDrawable newGradientDrawableForShape() {
        return new AlwaysStatefulGradientDrawable();
    }

    void getPadding(Rect rect) {
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            float radius = this.mShadowViewDelegate.getRadius();
            float elevation = getElevation() + this.mPressedTranslationZ;
            int ceil = (int) Math.ceil((double) ShadowDrawableWrapper.calculateHorizontalPadding(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) ShadowDrawableWrapper.calculateVerticalPadding(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
