package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.appcompat.R;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActionBarContainer(android.content.Context r3, android.util.AttributeSet r4) {
        /*
        r2 = this;
        r2.<init>(r3, r4);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x000f;
    L_0x0009:
        r0 = new android.support.v7.widget.ActionBarBackgroundDrawableV21;
        r0.<init>(r2);
        goto L_0x0014;
    L_0x000f:
        r0 = new android.support.v7.widget.ActionBarBackgroundDrawable;
        r0.<init>(r2);
    L_0x0014:
        android.support.v4.view.ViewCompat.setBackground(r2, r0);
        r0 = android.support.v7.appcompat.R.styleable.ActionBar;
        r3 = r3.obtainStyledAttributes(r4, r0);
        r4 = android.support.v7.appcompat.R.styleable.ActionBar_background;
        r4 = r3.getDrawable(r4);
        r2.mBackground = r4;
        r4 = android.support.v7.appcompat.R.styleable.ActionBar_backgroundStacked;
        r4 = r3.getDrawable(r4);
        r2.mStackedBackground = r4;
        r4 = android.support.v7.appcompat.R.styleable.ActionBar_height;
        r0 = -1;
        r4 = r3.getDimensionPixelSize(r4, r0);
        r2.mHeight = r4;
        r4 = r2.getId();
        r0 = android.support.v7.appcompat.R.id.split_action_bar;
        r1 = 1;
        if (r4 != r0) goto L_0x0049;
    L_0x003f:
        r2.mIsSplit = r1;
        r4 = android.support.v7.appcompat.R.styleable.ActionBar_backgroundSplit;
        r4 = r3.getDrawable(r4);
        r2.mSplitBackground = r4;
    L_0x0049:
        r3.recycle();
        r3 = r2.mIsSplit;
        r4 = 0;
        if (r3 == 0) goto L_0x0057;
    L_0x0051:
        r3 = r2.mSplitBackground;
        if (r3 != 0) goto L_0x0060;
    L_0x0055:
        r4 = r1;
        goto L_0x0060;
    L_0x0057:
        r3 = r2.mBackground;
        if (r3 != 0) goto L_0x0060;
    L_0x005b:
        r3 = r2.mStackedBackground;
        if (r3 != 0) goto L_0x0060;
    L_0x005f:
        goto L_0x0055;
    L_0x0060:
        r2.setWillNotDraw(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPrimaryBackground(android.graphics.drawable.Drawable r5) {
        /*
        r4 = this;
        r0 = r4.mBackground;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r4.mBackground;
        r1 = 0;
        r0.setCallback(r1);
        r0 = r4.mBackground;
        r4.unscheduleDrawable(r0);
    L_0x000f:
        r4.mBackground = r5;
        if (r5 == 0) goto L_0x0037;
    L_0x0013:
        r5.setCallback(r4);
        r5 = r4.mActionBarView;
        if (r5 == 0) goto L_0x0037;
    L_0x001a:
        r5 = r4.mBackground;
        r0 = r4.mActionBarView;
        r0 = r0.getLeft();
        r1 = r4.mActionBarView;
        r1 = r1.getTop();
        r2 = r4.mActionBarView;
        r2 = r2.getRight();
        r3 = r4.mActionBarView;
        r3 = r3.getBottom();
        r5.setBounds(r0, r1, r2, r3);
    L_0x0037:
        r5 = r4.mIsSplit;
        r0 = 0;
        r1 = 1;
        if (r5 == 0) goto L_0x0043;
    L_0x003d:
        r5 = r4.mSplitBackground;
        if (r5 != 0) goto L_0x004c;
    L_0x0041:
        r0 = r1;
        goto L_0x004c;
    L_0x0043:
        r5 = r4.mBackground;
        if (r5 != 0) goto L_0x004c;
    L_0x0047:
        r5 = r4.mStackedBackground;
        if (r5 != 0) goto L_0x004c;
    L_0x004b:
        goto L_0x0041;
    L_0x004c:
        r4.setWillNotDraw(r0);
        r4.invalidate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.setPrimaryBackground(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackedBackground(android.graphics.drawable.Drawable r5) {
        /*
        r4 = this;
        r0 = r4.mStackedBackground;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r4.mStackedBackground;
        r1 = 0;
        r0.setCallback(r1);
        r0 = r4.mStackedBackground;
        r4.unscheduleDrawable(r0);
    L_0x000f:
        r4.mStackedBackground = r5;
        if (r5 == 0) goto L_0x003b;
    L_0x0013:
        r5.setCallback(r4);
        r5 = r4.mIsStacked;
        if (r5 == 0) goto L_0x003b;
    L_0x001a:
        r5 = r4.mStackedBackground;
        if (r5 == 0) goto L_0x003b;
    L_0x001e:
        r5 = r4.mStackedBackground;
        r0 = r4.mTabContainer;
        r0 = r0.getLeft();
        r1 = r4.mTabContainer;
        r1 = r1.getTop();
        r2 = r4.mTabContainer;
        r2 = r2.getRight();
        r3 = r4.mTabContainer;
        r3 = r3.getBottom();
        r5.setBounds(r0, r1, r2, r3);
    L_0x003b:
        r5 = r4.mIsSplit;
        r0 = 0;
        r1 = 1;
        if (r5 == 0) goto L_0x0047;
    L_0x0041:
        r5 = r4.mSplitBackground;
        if (r5 != 0) goto L_0x0050;
    L_0x0045:
        r0 = r1;
        goto L_0x0050;
    L_0x0047:
        r5 = r4.mBackground;
        if (r5 != 0) goto L_0x0050;
    L_0x004b:
        r5 = r4.mStackedBackground;
        if (r5 != 0) goto L_0x0050;
    L_0x004f:
        goto L_0x0045;
    L_0x0050:
        r4.setWillNotDraw(r0);
        r4.invalidate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.setStackedBackground(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSplitBackground(android.graphics.drawable.Drawable r4) {
        /*
        r3 = this;
        r0 = r3.mSplitBackground;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r3.mSplitBackground;
        r1 = 0;
        r0.setCallback(r1);
        r0 = r3.mSplitBackground;
        r3.unscheduleDrawable(r0);
    L_0x000f:
        r3.mSplitBackground = r4;
        r0 = 0;
        if (r4 == 0) goto L_0x002c;
    L_0x0014:
        r4.setCallback(r3);
        r4 = r3.mIsSplit;
        if (r4 == 0) goto L_0x002c;
    L_0x001b:
        r4 = r3.mSplitBackground;
        if (r4 == 0) goto L_0x002c;
    L_0x001f:
        r4 = r3.mSplitBackground;
        r1 = r3.getMeasuredWidth();
        r2 = r3.getMeasuredHeight();
        r4.setBounds(r0, r0, r1, r2);
    L_0x002c:
        r4 = r3.mIsSplit;
        r1 = 1;
        if (r4 == 0) goto L_0x0037;
    L_0x0031:
        r4 = r3.mSplitBackground;
        if (r4 != 0) goto L_0x0040;
    L_0x0035:
        r0 = r1;
        goto L_0x0040;
    L_0x0037:
        r4 = r3.mBackground;
        if (r4 != 0) goto L_0x0040;
    L_0x003b:
        r4 = r3.mStackedBackground;
        if (r4 != 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0035;
    L_0x0040:
        r3.setWillNotDraw(r0);
        r3.invalidate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.setSplitBackground(android.graphics.drawable.Drawable):void");
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        i = i == 0 ? 1 : 0;
        if (this.mBackground != null) {
            this.mBackground.setVisible(i, false);
        }
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setVisible(i, false);
        }
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setVisible(i, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return ((drawable != this.mBackground || this.mIsSplit) && (!(drawable == this.mStackedBackground && this.mIsStacked) && (!(drawable == this.mSplitBackground && this.mIsSplit) && super.verifyDrawable(drawable) == null))) ? null : true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackground != null && this.mBackground.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        if (this.mStackedBackground != null && this.mStackedBackground.isStateful()) {
            this.mStackedBackground.setState(getDrawableState());
        }
        if (this.mSplitBackground != null && this.mSplitBackground.isStateful()) {
            this.mSplitBackground.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mBackground != null) {
            this.mBackground.jumpToCurrentState();
        }
        if (this.mStackedBackground != null) {
            this.mStackedBackground.jumpToCurrentState();
        }
        if (this.mSplitBackground != null) {
            this.mSplitBackground.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.mIsTransitioning = z;
        setDescendantFocusability(z ? true : true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsTransitioning) {
            if (super.onInterceptTouchEvent(motionEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.mTabContainer != null) {
            removeView(this.mTabContainer);
        }
        this.mTabContainer = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        return i != 0 ? super.startActionModeForChild(view, callback, i) : null;
    }

    private boolean isCollapsed(View view) {
        if (!(view == null || view.getVisibility() == 8)) {
            if (view.getMeasuredHeight() != null) {
                return null;
            }
        }
        return true;
    }

    private int getMeasuredHeightWithMargins(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return (view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
    }

    public void onMeasure(int i, int i2) {
        if (this.mActionBarView == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.mActionBarView != 0) {
            i = MeasureSpec.getMode(i2);
            if (!(this.mTabContainer == null || this.mTabContainer.getVisibility() == 8 || i == 1073741824)) {
                int measuredHeightWithMargins = !isCollapsed(this.mActionBarView) ? getMeasuredHeightWithMargins(this.mActionBarView) : !isCollapsed(this.mContextView) ? getMeasuredHeightWithMargins(this.mContextView) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(measuredHeightWithMargins + getMeasuredHeightWithMargins(this.mTabContainer), i == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        z = this.mTabContainer;
        i4 = 1;
        int i5 = 0;
        boolean z2 = z && z.getVisibility() != 8;
        if (z && z.getVisibility() != 8) {
            i2 = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) z.getLayoutParams();
            z.layout(i, (i2 - z.getMeasuredHeight()) - layoutParams.bottomMargin, i3, i2 - layoutParams.bottomMargin);
        }
        if (this.mIsSplit == 0) {
            if (this.mBackground != 0) {
                if (this.mActionBarView.getVisibility() == 0) {
                    this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                } else if (this.mContextView == 0 || this.mContextView.getVisibility() != 0) {
                    this.mBackground.setBounds(0, 0, 0, 0);
                } else {
                    this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
                }
                i5 = 1;
            }
            this.mIsStacked = z2;
            if (z2 && this.mStackedBackground != 0) {
                this.mStackedBackground.setBounds(z.getLeft(), z.getTop(), z.getRight(), z.getBottom());
                if (i4 == 0) {
                    invalidate();
                }
            }
        } else if (this.mSplitBackground) {
            this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            if (i4 == 0) {
                invalidate();
            }
        }
        i4 = i5;
        if (i4 == 0) {
            invalidate();
        }
    }
}
