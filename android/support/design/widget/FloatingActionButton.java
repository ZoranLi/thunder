package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList mBackgroundTint;
    private Mode mBackgroundTintMode;
    private int mBorderWidth;
    boolean mCompatPadding;
    private AppCompatImageHelper mImageHelper;
    int mImagePadding;
    private FloatingActionButtonImpl mImpl;
    private int mMaxImageSize;
    private int mRippleColor;
    final Rect mShadowPadding;
    private int mSize;
    private final Rect mTouchArea;

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean mAutoHideEnabled;
        private OnVisibilityChangedListener mInternalAutoHideListener;
        private Rect mTmpRect;

        public Behavior() {
            this.mAutoHideEnabled = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.mAutoHideEnabled = context.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            context.recycle();
        }

        public void setAutoHideEnabled(boolean z) {
            this.mAutoHideEnabled = z;
        }

        public boolean isAutoHideEnabled() {
            return this.mAutoHideEnabled;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (isBottomSheet(view) != null) {
                updateFabVisibilityForBottomSheet(view, floatingActionButton);
            }
            return null;
        }

        private static boolean isBottomSheet(@NonNull View view) {
            view = view.getLayoutParams();
            return view instanceof LayoutParams ? ((LayoutParams) view).getBehavior() instanceof BottomSheetBehavior : null;
        }

        @VisibleForTesting
        void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.mInternalAutoHideListener = onVisibilityChangedListener;
        }

        private boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            LayoutParams layoutParams = (LayoutParams) floatingActionButton.getLayoutParams();
            if (this.mAutoHideEnabled && layoutParams.getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == null) {
                return true;
            }
            return false;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.mTmpRect == null) {
                this.mTmpRect = new Rect();
            }
            Rect rect = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.mInternalAutoHideListener, false);
            } else {
                floatingActionButton.show(this.mInternalAutoHideListener, false);
            }
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.hide(this.mInternalAutoHideListener, false);
            } else {
                floatingActionButton.show(this.mInternalAutoHideListener, false);
            }
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            offsetIfNeeded(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            coordinatorLayout = floatingActionButton.mShadowPadding;
            rect.set(floatingActionButton.getLeft() + coordinatorLayout.left, floatingActionButton.getTop() + coordinatorLayout.top, floatingActionButton.getRight() - coordinatorLayout.right, floatingActionButton.getBottom() - coordinatorLayout.bottom);
            return true;
        }

        private void offsetIfNeeded(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.mShadowPadding;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                LayoutParams layoutParams = (LayoutParams) floatingActionButton.getLayoutParams();
                int i = 0;
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin ? rect.right : floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    ViewCompat.offsetTopAndBottom(floatingActionButton, i);
                }
                if (i2 != 0) {
                    ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
                }
            }
        }
    }

    private class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        public float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.mShadowPadding.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(i + FloatingActionButton.this.mImagePadding, i2 + FloatingActionButton.this.mImagePadding, i3 + FloatingActionButton.this.mImagePadding, i4 + FloatingActionButton.this.mImagePadding);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.mCompatPadding;
        }
    }

    public void setBackgroundColor(int i) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShadowPadding = new Rect();
        this.mTouchArea = new Rect();
        ThemeUtils.checkAppCompatTheme(context);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.mBackgroundTint = context.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
        this.mBackgroundTintMode = ViewUtils.parseTintMode(context.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.mRippleColor = context.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
        this.mSize = context.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.mBorderWidth = context.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = context.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = context.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.mCompatPadding = context.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        context.recycle();
        this.mImageHelper = new AppCompatImageHelper(this);
        this.mImageHelper.loadFromAttributes(attributeSet, i);
        this.mMaxImageSize = (int) getResources().getDimension(R.dimen.design_fab_image_size);
        getImpl().setBackgroundDrawable(this.mBackgroundTint, this.mBackgroundTintMode, this.mRippleColor, this.mBorderWidth);
        getImpl().setElevation(dimension);
        getImpl().setPressedTranslationZ(dimension2);
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.mImagePadding = (sizeDimension - this.mMaxImageSize) / 2;
        getImpl().updatePadding();
        i = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension((this.mShadowPadding.left + i) + this.mShadowPadding.right, (i + this.mShadowPadding.top) + this.mShadowPadding.bottom);
    }

    @ColorInt
    public int getRippleColor() {
        return this.mRippleColor;
    }

    public void setRippleColor(@ColorInt int i) {
        if (this.mRippleColor != i) {
            this.mRippleColor = i;
            getImpl().setRippleColor(i);
        }
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.mBackgroundTint;
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.mBackgroundTint != colorStateList) {
            this.mBackgroundTint = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    @Nullable
    public Mode getBackgroundTintMode() {
        return this.mBackgroundTintMode;
    }

    public void setBackgroundTintMode(@Nullable Mode mode) {
        if (this.mBackgroundTintMode != mode) {
            this.mBackgroundTintMode = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    public void setImageResource(@DrawableRes int i) {
        this.mImageHelper.setImageResource(i);
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        show(onVisibilityChangedListener, true);
    }

    void show(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().show(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }

    public void hide() {
        hide(null);
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        hide(onVisibilityChangedListener, true);
    }

    void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().hide(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setSize(int i) {
        if (i != this.mSize) {
            this.mSize = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.mSize;
    }

    @Nullable
    private InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        return onVisibilityChangedListener == null ? null : new InternalVisibilityChangedListener() {
            public void onShown() {
                onVisibilityChangedListener.onShown(FloatingActionButton.this);
            }

            public void onHidden() {
                onVisibilityChangedListener.onHidden(FloatingActionButton.this);
            }
        };
    }

    int getSizeDimension() {
        return getSizeDimension(this.mSize);
    }

    private int getSizeDimension(int i) {
        while (true) {
            Resources resources = getResources();
            if (i != -1) {
                break;
            }
            i = Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < AUTO_MINI_LARGEST_SCREEN_WIDTH ? 1 : 0;
        }
        if (i != 1) {
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
        }
        return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    public boolean getContentRect(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.mShadowPadding.left;
        rect.top += this.mShadowPadding.top;
        rect.right -= this.mShadowPadding.right;
        rect.bottom -= this.mShadowPadding.bottom;
        return true;
    }

    @NonNull
    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, i2);
        }
        if (mode != 0) {
            return mode != 1073741824 ? i : i2;
        } else {
            return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (getContentRect(this.mTouchArea) && !this.mTouchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return null;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.mImpl == null) {
            this.mImpl = createImpl();
        }
        return this.mImpl;
    }

    private FloatingActionButtonImpl createImpl() {
        if (VERSION.SDK_INT >= 21) {
            return new FloatingActionButtonLollipop(this, new ShadowDelegateImpl());
        }
        return new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
    }
}
