package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.design.R;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    final CollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    int mCurrentOffset;
    private boolean mDrawCollapsingTitle;
    private View mDummyView;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    WindowInsetsCompat mLastInsets;
    private OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private ValueAnimator mScrimAnimator;
    private int mScrimVisibleHeightTrigger;
    private boolean mScrimsAreShown;
    Drawable mStatusBarScrim;
    private final Rect mTmpRect;
    private Toolbar mToolbar;
    private View mToolbarDirectChild;
    private int mToolbarId;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int mCollapseMode = 0;
        float mParallaxMult = 1056964608;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        @interface CollapseMode {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.mCollapseMode = context.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(context.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            context.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setCollapseMode(int i) {
            this.mCollapseMode = i;
        }

        public int getCollapseMode() {
            return this.mCollapseMode;
        }

        public void setParallaxMultiplier(float f) {
            this.mParallaxMult = f;
        }

        public float getParallaxMultiplier() {
            return this.mParallaxMult;
        }
    }

    private class OffsetUpdateListener implements OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.mCurrentOffset = i;
            appBarLayout = CollapsingToolbarLayout.this.mLastInsets != null ? CollapsingToolbarLayout.this.mLastInsets.getSystemWindowInsetTop() : null;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                switch (layoutParams.mCollapseMode) {
                    case 1:
                        viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                        break;
                    case 2:
                        viewOffsetHelper.setTopAndBottomOffset(Math.round(((float) (-i)) * layoutParams.mParallaxMult));
                        break;
                    default:
                        break;
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            if (CollapsingToolbarLayout.this.mStatusBarScrim != null && appBarLayout > null) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.mCollapsingTextHelper.setExpansionFraction(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - appBarLayout)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshToolbar = true;
        this.mTmpRect = new Rect();
        this.mScrimVisibleHeightTrigger = -1;
        ThemeUtils.checkAppCompatTheme(context);
        this.mCollapsingTextHelper = new CollapsingTextHelper(this);
        this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.mCollapsingTextHelper.setExpandedTextGravity(context.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.mCollapsingTextHelper.setCollapsedTextGravity(context.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        attributeSet = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.mExpandedMarginBottom = attributeSet;
        this.mExpandedMarginEnd = attributeSet;
        this.mExpandedMarginTop = attributeSet;
        this.mExpandedMarginStart = attributeSet;
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart) != null) {
            this.mExpandedMarginStart = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd) != null) {
            this.mExpandedMarginEnd = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop) != null) {
            this.mExpandedMarginTop = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom) != null) {
            this.mExpandedMarginBottom = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.mCollapsingTitleEnabled = context.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(context.getText(R.styleable.CollapsingToolbarLayout_title));
        this.mCollapsingTextHelper.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.mCollapsingTextHelper.setCollapsedTextAppearance(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance) != null) {
            this.mCollapsingTextHelper.setExpandedTextAppearance(context.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance) != null) {
            this.mCollapsingTextHelper.setCollapsedTextAppearance(context.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.mScrimVisibleHeightTrigger = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.mScrimAnimationDuration = (long) context.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(context.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(context.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.mToolbarId = context.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        context.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            ViewCompat.requestApplyInsets(this);
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.mOnOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(this.mOnOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        ensureToolbar();
        if (this.mToolbar == null && this.mContentScrim != null && this.mScrimAlpha > 0) {
            this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled && this.mDrawCollapsingTitle) {
            this.mCollapsingTextHelper.draw(canvas);
        }
        if (this.mStatusBarScrim != null && this.mScrimAlpha > 0) {
            int systemWindowInsetTop = this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, getWidth(), systemWindowInsetTop - this.mCurrentOffset);
                this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
                this.mStatusBarScrim.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.mContentScrim == null || this.mScrimAlpha <= 0 || !isToolbarChild(view)) {
            z = false;
        } else {
            this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j) == null) {
            if (!z) {
                return false;
            }
        }
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mContentScrim != 0) {
            this.mContentScrim.setBounds(0, 0, i, i2);
        }
    }

    private void ensureToolbar() {
        if (this.mRefreshToolbar) {
            Toolbar toolbar = null;
            this.mToolbar = null;
            this.mToolbarDirectChild = null;
            if (this.mToolbarId != -1) {
                this.mToolbar = (Toolbar) findViewById(this.mToolbarId);
                if (this.mToolbar != null) {
                    this.mToolbarDirectChild = findDirectChild(this.mToolbar);
                }
            }
            if (this.mToolbar == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                this.mToolbar = toolbar;
            }
            updateDummyView();
            this.mRefreshToolbar = false;
        }
    }

    private boolean isToolbarChild(View view) {
        if (this.mToolbarDirectChild != null) {
            if (this.mToolbarDirectChild != this) {
                return view == this.mToolbarDirectChild;
            }
        }
        return view == this.mToolbar;
    }

    private View findDirectChild(View view) {
        View parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private void updateDummyView() {
        if (!(this.mCollapsingTitleEnabled || this.mDummyView == null)) {
            ViewParent parent = this.mDummyView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mDummyView);
            }
        }
        if (this.mCollapsingTitleEnabled && this.mToolbar != null) {
            if (this.mDummyView == null) {
                this.mDummyView = new View(getContext());
            }
            if (this.mDummyView.getParent() == null) {
                this.mToolbar.addView(this.mDummyView, -1, -1);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        ensureToolbar();
        super.onMeasure(i, i2);
        i2 = MeasureSpec.getMode(i2);
        int systemWindowInsetTop = this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : 0;
        if (i2 == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = false;
        if (this.mLastInsets) {
            z = this.mLastInsets.getSystemWindowInsetTop();
            childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < z) {
                    ViewCompat.offsetTopAndBottom(childAt, z);
                }
            }
        }
        if (this.mCollapsingTitleEnabled && this.mDummyView) {
            childCount = 1;
            z = ViewCompat.isAttachedToWindow(this.mDummyView) && !this.mDummyView.getVisibility();
            this.mDrawCollapsingTitle = z;
            if (this.mDrawCollapsingTitle) {
                int titleMarginEnd;
                int titleMarginStart;
                if (!ViewCompat.getLayoutDirection(this)) {
                    childCount = 0;
                }
                z = getMaxOffsetForPinChild(this.mToolbarDirectChild ? this.mToolbarDirectChild : this.mToolbar);
                ViewGroupUtils.getDescendantRect(this, this.mDummyView, this.mTmpRect);
                CollapsingTextHelper collapsingTextHelper = this.mCollapsingTextHelper;
                int i6 = this.mTmpRect.left;
                if (childCount != 0) {
                    titleMarginEnd = this.mToolbar.getTitleMarginEnd();
                } else {
                    titleMarginEnd = this.mToolbar.getTitleMarginStart();
                }
                i6 += titleMarginEnd;
                titleMarginEnd = (this.mTmpRect.top + z) + this.mToolbar.getTitleMarginTop();
                int i7 = this.mTmpRect.right;
                if (childCount != 0) {
                    titleMarginStart = this.mToolbar.getTitleMarginStart();
                } else {
                    titleMarginStart = this.mToolbar.getTitleMarginEnd();
                }
                collapsingTextHelper.setCollapsedBounds(i6, titleMarginEnd, i7 + titleMarginStart, (this.mTmpRect.bottom + z) - this.mToolbar.getTitleMarginBottom());
                this.mCollapsingTextHelper.setExpandedBounds(childCount != 0 ? this.mExpandedMarginEnd : this.mExpandedMarginStart, this.mTmpRect.top + this.mExpandedMarginTop, (i3 - i) - (childCount != 0 ? this.mExpandedMarginStart : this.mExpandedMarginEnd), (i4 - i2) - this.mExpandedMarginBottom);
                this.mCollapsingTextHelper.recalculate();
            }
        }
        z = getChildCount();
        while (z2 < z) {
            getViewOffsetHelper(getChildAt(z2)).onViewLayout();
            z2++;
        }
        if (this.mToolbar) {
            if (this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mToolbar.getTitle());
            }
            if (this.mToolbarDirectChild) {
                if (this.mToolbarDirectChild != this) {
                    setMinimumHeight(getHeightWithMargins(this.mToolbarDirectChild));
                }
            }
            setMinimumHeight(getHeightWithMargins(this.mToolbar));
        }
        updateScrimVisibility();
    }

    private static int getHeightWithMargins(@NonNull View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return (view.getHeight() + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin;
    }

    static ViewOffsetHelper getViewOffsetHelper(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        viewOffsetHelper = new ViewOffsetHelper(view);
        view.setTag(R.id.view_offset_helper, viewOffsetHelper);
        return viewOffsetHelper;
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.mCollapsingTextHelper.setText(charSequence);
    }

    @Nullable
    public CharSequence getTitle() {
        return this.mCollapsingTitleEnabled ? this.mCollapsingTextHelper.getText() : null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = z;
            updateDummyView();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = ViewCompat.isLaidOut(this) && !isInEditMode();
        setScrimsShown(z, z2);
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.mScrimsAreShown != z) {
            int i = 0;
            if (z2) {
                if (z) {
                    i = 255;
                }
                animateScrim(i);
            } else {
                if (z) {
                    i = 255;
                }
                setScrimAlpha(i);
            }
            this.mScrimsAreShown = z;
        }
    }

    private void animateScrim(int i) {
        ensureToolbar();
        if (this.mScrimAnimator == null) {
            this.mScrimAnimator = new ValueAnimator();
            this.mScrimAnimator.setDuration(this.mScrimAnimationDuration);
            this.mScrimAnimator.setInterpolator(i > this.mScrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrimAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.mScrimAnimator.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(new int[]{this.mScrimAlpha, i});
        this.mScrimAnimator.start();
    }

    void setScrimAlpha(int i) {
        if (i != this.mScrimAlpha) {
            if (!(this.mContentScrim == null || this.mToolbar == null)) {
                ViewCompat.postInvalidateOnAnimation(this.mToolbar);
            }
            this.mScrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int getScrimAlpha() {
        return this.mScrimAlpha;
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        if (this.mContentScrim != drawable) {
            Drawable drawable2 = null;
            if (this.mContentScrim != null) {
                this.mContentScrim.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.mContentScrim = drawable2;
            if (this.mContentScrim != null) {
                this.mContentScrim.setBounds(0, 0, getWidth(), getHeight());
                this.mContentScrim.setCallback(this);
                this.mContentScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        if (this.mStatusBarScrim != drawable) {
            Drawable drawable2 = null;
            if (this.mStatusBarScrim != null) {
                this.mStatusBarScrim.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.mStatusBarScrim = drawable2;
            if (this.mStatusBarScrim != null) {
                if (this.mStatusBarScrim.isStateful() != null) {
                    this.mStatusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarScrim, ViewCompat.getLayoutDirection(this));
                this.mStatusBarScrim.setVisible(getVisibility() == 0, false);
                this.mStatusBarScrim.setCallback(this);
                this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarScrim;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.mContentScrim;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.mCollapsingTextHelper != null) {
            i |= this.mCollapsingTextHelper.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!(super.verifyDrawable(drawable) || drawable == this.mContentScrim)) {
            if (drawable != this.mStatusBarScrim) {
                return null;
            }
        }
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.mStatusBarScrim == null || this.mStatusBarScrim.isVisible() == z)) {
            this.mStatusBarScrim.setVisible(z, false);
        }
        if (this.mContentScrim != null && this.mContentScrim.isVisible() != z) {
            this.mContentScrim.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mCollapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(i);
    }

    public int getCollapsedTitleGravity() {
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.mCollapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.mCollapsingTextHelper.setExpandedTextGravity(i);
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.mExpandedMarginStart = i;
        this.mExpandedMarginTop = i2;
        this.mExpandedMarginEnd = i3;
        this.mExpandedMarginBottom = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.mExpandedMarginStart = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.mExpandedMarginTop = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.mExpandedMarginEnd = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.mExpandedMarginBottom = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        if (this.mScrimVisibleHeightTrigger != i) {
            this.mScrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.mScrimVisibleHeightTrigger >= 0) {
            return this.mScrimVisibleHeightTrigger;
        }
        int systemWindowInsetTop = this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        this.mScrimAnimationDuration = j;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final void updateScrimVisibility() {
        if (this.mContentScrim != null || this.mStatusBarScrim != null) {
            setScrimsShown(getHeight() + this.mCurrentOffset < getScrimVisibleHeightTrigger());
        }
    }

    final int getMaxOffsetForPinChild(View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
