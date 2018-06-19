package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.design.R;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pool<Tab> sTabPool = new SynchronizedPool(16);
    private AdapterChangeListener mAdapterChangeListener;
    private int mContentInsetStart;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    int mMode;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private Tab mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    final int mTabBackgroundResId;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private final SlidingTabStrip mTabStrip;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final Pool<TabView> mTabViewPool;
    private final ArrayList<Tab> mTabs;
    ViewPager mViewPager;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    private class SlidingTabStrip extends LinearLayout {
        private ValueAnimator mIndicatorAnimator;
        private int mIndicatorLeft = -1;
        private int mIndicatorRight = -1;
        private int mLayoutDirection = -1;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        int mSelectedPosition = -1;
        float mSelectionOffset;

        SlidingTabStrip(Context context) {
            super(context);
            setWillNotDraw(null);
            this.mSelectedIndicatorPaint = new Paint();
        }

        void setSelectedIndicatorColor(int i) {
            if (this.mSelectedIndicatorPaint.getColor() != i) {
                this.mSelectedIndicatorPaint.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.mSelectedIndicatorHeight != i) {
                this.mSelectedIndicatorHeight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void setIndicatorPositionFromTabPosition(int i, float f) {
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = i;
            this.mSelectionOffset = f;
            updateIndicatorPosition();
        }

        float getIndicatorPosition() {
            return ((float) this.mSelectedPosition) + this.mSelectionOffset;
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (VERSION.SDK_INT < 23 && this.mLayoutDirection != i) {
                requestLayout();
                this.mLayoutDirection = i;
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824) {
                int i3 = 1;
                if (TabLayout.this.mMode == 1 && TabLayout.this.mTabGravity == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = i5;
                    while (i5 < childCount) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i6 = Math.max(i6, childAt.getMeasuredWidth());
                        }
                        i5++;
                    }
                    if (i6 > 0) {
                        if (i6 * childCount <= getMeasuredWidth() - (TabLayout.this.dpToPx(16) * 2)) {
                            i5 = 0;
                            while (i4 < childCount) {
                                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                                if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i6;
                                    layoutParams.weight = 0.0f;
                                    i5 = 1;
                                }
                                i4++;
                            }
                            i3 = i5;
                        } else {
                            TabLayout.this.mTabGravity = 0;
                            TabLayout.this.updateTabViews(false);
                        }
                        if (i3 != 0) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mIndicatorAnimator && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
                animateIndicatorToPosition(this.mSelectedPosition, Math.round((1065353216 - this.mIndicatorAnimator.getAnimatedFraction()) * ((float) this.mIndicatorAnimator.getDuration())));
                return;
            }
            updateIndicatorPosition();
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    i = (int) ((this.mSelectionOffset * ((float) childAt2.getLeft())) + ((1.0f - this.mSelectionOffset) * ((float) i)));
                    i2 = (int) ((this.mSelectionOffset * ((float) childAt2.getRight())) + ((1.0f - this.mSelectionOffset) * ((float) i2)));
                }
            }
            setIndicatorPosition(i, i2);
        }

        void setIndicatorPosition(int i, int i2) {
            if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
                this.mIndicatorLeft = i;
                this.mIndicatorRight = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void animateIndicatorToPosition(final int r10, int r11) {
            /*
            r9 = this;
            r0 = r9.mIndicatorAnimator;
            if (r0 == 0) goto L_0x0011;
        L_0x0004:
            r0 = r9.mIndicatorAnimator;
            r0 = r0.isRunning();
            if (r0 == 0) goto L_0x0011;
        L_0x000c:
            r0 = r9.mIndicatorAnimator;
            r0.cancel();
        L_0x0011:
            r0 = android.support.v4.view.ViewCompat.getLayoutDirection(r9);
            r1 = 1;
            if (r0 != r1) goto L_0x001a;
        L_0x0018:
            r0 = r1;
            goto L_0x001b;
        L_0x001a:
            r0 = 0;
        L_0x001b:
            r2 = r9.getChildAt(r10);
            if (r2 != 0) goto L_0x0025;
        L_0x0021:
            r9.updateIndicatorPosition();
            return;
        L_0x0025:
            r6 = r2.getLeft();
            r8 = r2.getRight();
            r2 = r9.mSelectedPosition;
            r2 = r10 - r2;
            r2 = java.lang.Math.abs(r2);
            if (r2 > r1) goto L_0x003e;
        L_0x0037:
            r0 = r9.mIndicatorLeft;
            r1 = r9.mIndicatorRight;
            r5 = r0;
            r7 = r1;
            goto L_0x0058;
        L_0x003e:
            r1 = android.support.design.widget.TabLayout.this;
            r2 = 24;
            r1 = r1.dpToPx(r2);
            r2 = r9.mSelectedPosition;
            if (r10 >= r2) goto L_0x0050;
        L_0x004a:
            if (r0 != 0) goto L_0x0054;
        L_0x004c:
            r1 = r1 + r8;
        L_0x004d:
            r5 = r1;
        L_0x004e:
            r7 = r5;
            goto L_0x0058;
        L_0x0050:
            if (r0 == 0) goto L_0x0054;
        L_0x0052:
            r1 = r1 + r8;
            goto L_0x004d;
        L_0x0054:
            r0 = r6 - r1;
            r5 = r0;
            goto L_0x004e;
        L_0x0058:
            if (r5 != r6) goto L_0x005c;
        L_0x005a:
            if (r7 == r8) goto L_0x008a;
        L_0x005c:
            r0 = new android.animation.ValueAnimator;
            r0.<init>();
            r9.mIndicatorAnimator = r0;
            r1 = android.support.design.widget.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            r0.setInterpolator(r1);
            r1 = (long) r11;
            r0.setDuration(r1);
            r11 = 2;
            r11 = new float[r11];
            r11 = {0, 1065353216};
            r0.setFloatValues(r11);
            r11 = new android.support.design.widget.TabLayout$SlidingTabStrip$1;
            r3 = r11;
            r4 = r9;
            r3.<init>(r5, r6, r7, r8);
            r0.addUpdateListener(r11);
            r11 = new android.support.design.widget.TabLayout$SlidingTabStrip$2;
            r11.<init>(r10);
            r0.addListener(r11);
            r0.start();
        L_0x008a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.SlidingTabStrip.animateIndicatorToPosition(int, int):void");
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
                canvas.drawRect((float) this.mIndicatorLeft, (float) (getHeight() - this.mSelectedIndicatorHeight), (float) this.mIndicatorRight, (float) getHeight(), this.mSelectedIndicatorPaint);
            }
        }
    }

    public static final class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        TabLayout mParent;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;
        TabView mView;

        Tab() {
        }

        @Nullable
        public final Object getTag() {
            return this.mTag;
        }

        @NonNull
        public final Tab setTag(@Nullable Object obj) {
            this.mTag = obj;
            return this;
        }

        @Nullable
        public final View getCustomView() {
            return this.mCustomView;
        }

        @NonNull
        public final Tab setCustomView(@Nullable View view) {
            this.mCustomView = view;
            updateView();
            return this;
        }

        @NonNull
        public final Tab setCustomView(@LayoutRes int i) {
            return setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(i, this.mView, false));
        }

        @Nullable
        public final Drawable getIcon() {
            return this.mIcon;
        }

        public final int getPosition() {
            return this.mPosition;
        }

        final void setPosition(int i) {
            this.mPosition = i;
        }

        @Nullable
        public final CharSequence getText() {
            return this.mText;
        }

        @NonNull
        public final Tab setIcon(@Nullable Drawable drawable) {
            this.mIcon = drawable;
            updateView();
            return this;
        }

        @NonNull
        public final Tab setIcon(@DrawableRes int i) {
            if (this.mParent != null) {
                return setIcon(AppCompatResources.getDrawable(this.mParent.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public final Tab setText(@Nullable CharSequence charSequence) {
            this.mText = charSequence;
            updateView();
            return this;
        }

        @NonNull
        public final Tab setText(@StringRes int i) {
            if (this.mParent != null) {
                return setText(this.mParent.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final void select() {
            if (this.mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.mParent.selectTab(this);
        }

        public final boolean isSelected() {
            if (this.mParent != null) {
                return this.mParent.getSelectedTabPosition() == this.mPosition;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        @NonNull
        public final Tab setContentDescription(@StringRes int i) {
            if (this.mParent != null) {
                return setContentDescription(this.mParent.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public final Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.mContentDesc = charSequence;
            updateView();
            return this;
        }

        @Nullable
        public final CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        final void updateView() {
            if (this.mView != null) {
                this.mView.update();
            }
        }

        final void reset() {
            this.mParent = null;
            this.mView = null;
            this.mTag = null;
            this.mIcon = null;
            this.mText = null;
            this.mContentDesc = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    class TabView extends LinearLayout {
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines = 2;
        private ImageView mIconView;
        private Tab mTab;
        private TextView mTextView;

        public TabView(Context context) {
            super(context);
            if (TabLayout.this.mTabBackgroundResId != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TabLayout.this.mTabBackgroundResId));
            }
            ViewCompat.setPaddingRelative(this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.mTab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.mTab.select();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.mTextView != null) {
                this.mTextView.setSelected(z);
            }
            if (this.mIconView != null) {
                this.mIconView.setSelected(z);
            }
            if (this.mCustomView != null) {
                this.mCustomView.setSelected(z);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mTextView != null) {
                getResources();
                float f = TabLayout.this.mTabTextSize;
                mode = this.mDefaultMaxLines;
                int i3 = 1;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    mode = 1;
                } else if (this.mTextView != null && this.mTextView.getLineCount() > 1) {
                    f = TabLayout.this.mTabTextMultiLineSize;
                }
                float textSize = this.mTextView.getTextSize();
                int lineCount = this.mTextView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.mTextView);
                if (f != textSize || (maxLines >= 0 && mode != maxLines)) {
                    if (TabLayout.this.mMode == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.mTextView.getLayout();
                        if (layout == null || approximateLineWidth(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.mTextView.setTextSize(0, f);
                        this.mTextView.setMaxLines(mode);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void setTab(@Nullable Tab tab) {
            if (tab != this.mTab) {
                this.mTab = tab;
                update();
            }
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        final void update() {
            Tab tab = this.mTab;
            View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                TabView parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.mCustomView = customView;
                if (this.mTextView != null) {
                    this.mTextView.setVisibility(8);
                }
                if (this.mIconView != null) {
                    this.mIconView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                this.mCustomTextView = (TextView) customView.findViewById(16908308);
                if (this.mCustomTextView != null) {
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
                }
                this.mCustomIconView = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.mCustomView != null) {
                    removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.mCustomTextView = null;
                this.mCustomIconView = null;
            }
            boolean z = false;
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.mTextView == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
                    addView(textView);
                    this.mTextView = textView;
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TabLayout.this.mTabTextAppearance);
                if (TabLayout.this.mTabTextColors != null) {
                    this.mTextView.setTextColor(TabLayout.this.mTabTextColors);
                }
                updateTextAndIcon(this.mTextView, this.mIconView);
            } else if (!(this.mCustomTextView == null && this.mCustomIconView == null)) {
                updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
            }
            if (tab != null && tab.isSelected()) {
                z = true;
            }
            setSelected(z);
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            CharSequence charSequence = null;
            Drawable icon = this.mTab != null ? this.mTab.getIcon() : null;
            CharSequence text = this.mTab != null ? this.mTab.getText() : null;
            CharSequence contentDescription = this.mTab != null ? this.mTab.getContentDescription() : null;
            int i = 0;
            if (imageView != null) {
                if (icon != null) {
                    imageView.setImageDrawable(icon);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(contentDescription);
            }
            int isEmpty = TextUtils.isEmpty(text) ^ 1;
            if (textView != null) {
                if (isEmpty != 0) {
                    textView.setText(text);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(contentDescription);
            }
            if (imageView != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (isEmpty != 0 && imageView.getVisibility() == 0) {
                    i = TabLayout.this.dpToPx(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            if (isEmpty == 0) {
                charSequence = contentDescription;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        public Tab getTab() {
            return this.mTab;
        }

        private float approximateLineWidth(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    private class AdapterChangeListener implements OnAdapterChangeListener {
        private boolean mAutoRefresh;

        AdapterChangeListener() {
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            if (TabLayout.this.mViewPager == viewPager) {
                TabLayout.this.setPagerAdapter(pagerAdapter2, this.mAutoRefresh);
            }
        }

        void setAutoRefresh(boolean z) {
            this.mAutoRefresh = z;
        }
    }

    public static class TabLayoutOnPageChangeListener implements OnPageChangeListener {
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<TabLayout> mTabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.mTabLayoutRef = new WeakReference(tabLayout);
        }

        public void onPageScrollStateChanged(int i) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.mTabLayoutRef.get();
            if (tabLayout != null) {
                boolean z;
                boolean z2 = false;
                if (this.mScrollState == 2) {
                    if (this.mPreviousScrollState != 1) {
                        z = false;
                        if (!(this.mScrollState == 2 && this.mPreviousScrollState == 0)) {
                            z2 = true;
                        }
                        tabLayout.setScrollPosition(i, f, z, z2);
                    }
                }
                z = true;
                z2 = true;
                tabLayout.setScrollPosition(i, f, z, z2);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.mTabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z;
                if (this.mScrollState != 0) {
                    if (this.mScrollState != 2 || this.mPreviousScrollState != 0) {
                        z = false;
                        tabLayout.selectTab(tabLayout.getTabAt(i), z);
                    }
                }
                z = true;
                tabLayout.selectTab(tabLayout.getTabAt(i), z);
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.mPreviousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        public void onTabSelected(Tab tab) {
            this.mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList();
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mSelectedListeners = new ArrayList();
        this.mTabViewPool = new SimplePool(12);
        ThemeUtils.checkAppCompatTheme(context);
        setHorizontalScrollBarEnabled(false);
        this.mTabStrip = new SlidingTabStrip(context);
        super.addView(this.mTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout);
        this.mTabStrip.setSelectedIndicatorHeight(attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.mTabStrip.setSelectedIndicatorColor(attributeSet.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        i = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.mTabPaddingBottom = i;
        this.mTabPaddingEnd = i;
        this.mTabPaddingTop = i;
        this.mTabPaddingStart = i;
        this.mTabPaddingStart = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
        this.mTabPaddingTop = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
        this.mTabPaddingEnd = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
        this.mTabPaddingBottom = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
        this.mTabTextAppearance = attributeSet.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        context = context.obtainStyledAttributes(this.mTabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.mTabTextSize = (float) context.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.mTabTextColors = context.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            if (attributeSet.hasValue(R.styleable.TabLayout_tabTextColor) != null) {
                this.mTabTextColors = attributeSet.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (attributeSet.hasValue(R.styleable.TabLayout_tabSelectedTextColor) != null) {
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), attributeSet.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.mRequestedTabMinWidth = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.mRequestedTabMaxWidth = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.mTabBackgroundResId = attributeSet.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.mContentInsetStart = attributeSet.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = attributeSet.getInt(R.styleable.TabLayout_tabMode, 1);
            this.mTabGravity = attributeSet.getInt(R.styleable.TabLayout_tabGravity, 0);
            attributeSet.recycle();
            context = getResources();
            this.mTabTextMultiLineSize = (float) context.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.mScrollableTabMinWidth = context.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } finally {
            context.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.mTabStrip.setSelectedIndicatorColor(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.mTabStrip.setSelectedIndicatorHeight(i);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0) {
            if (round < this.mTabStrip.getChildCount()) {
                if (z2) {
                    this.mTabStrip.setIndicatorPositionFromTabPosition(i, f);
                }
                if (this.mScrollAnimator && this.mScrollAnimator.isRunning()) {
                    this.mScrollAnimator.cancel();
                }
                scrollTo(calculateScrollXForTab(i, f), 0.0f);
                if (z) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(@NonNull Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(@NonNull Tab tab, boolean z) {
        addTab(tab, this.mTabs.size(), z);
    }

    public void addTab(@NonNull Tab tab, int i, boolean z) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        configureTab(tab, i);
        addTabView(tab);
        if (z) {
            tab.select();
        }
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        if (tabItem.mText != null) {
            newTab.setText(tabItem.mText);
        }
        if (tabItem.mIcon != null) {
            newTab.setIcon(tabItem.mIcon);
        }
        if (tabItem.mCustomLayout != 0) {
            newTab.setCustomView(tabItem.mCustomLayout);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        if (this.mSelectedListener != null) {
            removeOnTabSelectedListener(this.mSelectedListener);
        }
        this.mSelectedListener = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            addOnTabSelectedListener(onTabSelectedListener);
        }
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        if (!this.mSelectedListeners.contains(onTabSelectedListener)) {
            this.mSelectedListeners.add(onTabSelectedListener);
        }
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    @NonNull
    public Tab newTab() {
        Tab tab = (Tab) sTabPool.acquire();
        if (tab == null) {
            tab = new Tab();
        }
        tab.mParent = this;
        tab.mView = createTabView(tab);
        return tab;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    @Nullable
    public Tab getTabAt(int i) {
        if (i >= 0) {
            if (i < getTabCount()) {
                return (Tab) this.mTabs.get(i);
            }
        }
        return 0;
    }

    public int getSelectedTabPosition() {
        return this.mSelectedTab != null ? this.mSelectedTab.getPosition() : -1;
    }

    public void removeTab(Tab tab) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        int position = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : 0;
        removeTabViewAt(i);
        Tab tab = (Tab) this.mTabs.remove(i);
        if (tab != null) {
            tab.reset();
            sTabPool.release(tab);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            ((Tab) this.mTabs.get(i2)).setPosition(i2);
        }
        if (position == i) {
            selectTab(this.mTabs.isEmpty() ? 0 : (Tab) this.mTabs.get(Math.max(0, i - 1)));
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.mTabStrip.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator it = this.mTabs.iterator();
        while (it.hasNext()) {
            Tab tab = (Tab) it.next();
            it.remove();
            tab.reset();
            sTabPool.release(tab);
        }
        this.mSelectedTab = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.mTabGravity != i) {
            this.mTabGravity = i;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        if (this.mViewPager != null) {
            if (this.mPageChangeListener != null) {
                this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
            }
            if (this.mAdapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener(this.mAdapterChangeListener);
            }
        }
        if (this.mCurrentVpSelectedListener != null) {
            removeOnTabSelectedListener(this.mCurrentVpSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            this.mCurrentVpSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            addOnTabSelectedListener(this.mCurrentVpSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new AdapterChangeListener();
            }
            this.mAdapterChangeListener.setAutoRefresh(z);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), false, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, null);
        }
        this.mSetupViewPagerImplicitly = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        if (!(this.mPagerAdapter == null || this.mPagerAdapterObserver == null)) {
            this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (!this.mPagerAdapterObserver) {
                this.mPagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        if (this.mPagerAdapter != null) {
            int count = this.mPagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().setText(this.mPagerAdapter.getPageTitle(i)), false);
            }
            if (this.mViewPager != null && count > 0) {
                count = this.mViewPager.getCurrentItem();
                if (count != getSelectedTabPosition() && count < getTabCount()) {
                    selectTab(getTabAt(count));
                }
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            ((Tab) this.mTabs.get(i)).updateView();
        }
    }

    private TabView createTabView(@NonNull Tab tab) {
        TabView tabView = this.mTabViewPool != null ? (TabView) this.mTabViewPool.acquire() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        return tabView;
    }

    private void configureTab(Tab tab, int i) {
        tab.setPosition(i);
        this.mTabs.add(i, tab);
        tab = this.mTabs.size();
        while (true) {
            i++;
            if (i < tab) {
                ((Tab) this.mTabs.get(i)).setPosition(i);
            } else {
                return;
            }
        }
    }

    private void addTabView(Tab tab) {
        this.mTabStrip.addView(tab.mView, tab.getPosition(), createLayoutParamsForTabs());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void addView(View view, int i) {
        addViewInternal(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LayoutParams createLayoutParamsForTabs() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r6, int r7) {
        /*
        r5 = this;
        r0 = r5.getDefaultHeight();
        r0 = r5.dpToPx(r0);
        r1 = r5.getPaddingTop();
        r0 = r0 + r1;
        r1 = r5.getPaddingBottom();
        r0 = r0 + r1;
        r1 = android.view.View.MeasureSpec.getMode(r7);
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 == r2) goto L_0x0024;
    L_0x001c:
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0030;
    L_0x001f:
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3);
        goto L_0x0030;
    L_0x0024:
        r7 = android.view.View.MeasureSpec.getSize(r7);
        r7 = java.lang.Math.min(r0, r7);
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3);
    L_0x0030:
        r0 = android.view.View.MeasureSpec.getSize(r6);
        r1 = android.view.View.MeasureSpec.getMode(r6);
        if (r1 == 0) goto L_0x004a;
    L_0x003a:
        r1 = r5.mRequestedTabMaxWidth;
        if (r1 <= 0) goto L_0x0041;
    L_0x003e:
        r0 = r5.mRequestedTabMaxWidth;
        goto L_0x0048;
    L_0x0041:
        r1 = 56;
        r1 = r5.dpToPx(r1);
        r0 = r0 - r1;
    L_0x0048:
        r5.mTabMaxWidth = r0;
    L_0x004a:
        super.onMeasure(r6, r7);
        r6 = r5.getChildCount();
        r0 = 1;
        if (r6 != r0) goto L_0x0096;
    L_0x0054:
        r6 = 0;
        r1 = r5.getChildAt(r6);
        r2 = r5.mMode;
        switch(r2) {
            case 0: goto L_0x006b;
            case 1: goto L_0x005f;
            default: goto L_0x005e;
        };
    L_0x005e:
        goto L_0x0076;
    L_0x005f:
        r2 = r1.getMeasuredWidth();
        r4 = r5.getMeasuredWidth();
        if (r2 == r4) goto L_0x0076;
    L_0x0069:
        r6 = r0;
        goto L_0x0076;
    L_0x006b:
        r2 = r1.getMeasuredWidth();
        r4 = r5.getMeasuredWidth();
        if (r2 >= r4) goto L_0x0076;
    L_0x0075:
        goto L_0x0069;
    L_0x0076:
        if (r6 == 0) goto L_0x0096;
    L_0x0078:
        r6 = r5.getPaddingTop();
        r0 = r5.getPaddingBottom();
        r6 = r6 + r0;
        r0 = r1.getLayoutParams();
        r0 = r0.height;
        r6 = getChildMeasureSpec(r7, r6, r0);
        r7 = r5.getMeasuredWidth();
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3);
        r1.measure(r7, r6);
    L_0x0096:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.onMeasure(int, int):void");
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.mTabStrip.getChildAt(i);
        this.mTabStrip.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.mTabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                if (!this.mTabStrip.childrenNeedLayout()) {
                    if (getScrollX() != calculateScrollXForTab(i, 0.0f)) {
                        ensureScrollAnimator();
                        this.mScrollAnimator.setIntValues(new int[]{r0, r2});
                        this.mScrollAnimator.start();
                    }
                    this.mTabStrip.animateIndicatorToPosition(i, 300);
                    return;
                }
            }
            setScrollPosition(i, 0.0f, true);
        }
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
            this.mScrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrollAnimator.setDuration(300);
            this.mScrollAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.mTabStrip.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.mTabStrip.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void selectTab(Tab tab) {
        selectTab(tab, true);
    }

    void selectTab(Tab tab, boolean z) {
        Tab tab2 = this.mSelectedTab;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            if (z) {
                if ((tab2 == null || tab2.getPosition()) && position != -1) {
                    setScrollPosition(position, false, true);
                } else {
                    animateToTab(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            if (tab2 != null) {
                dispatchTabUnselected(tab2);
            }
            this.mSelectedTab = tab;
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        } else if (tab2 != null) {
            dispatchTabReselected(tab);
            animateToTab(tab.getPosition());
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.mSelectedListeners.get(size)).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.mSelectedListeners.get(size)).onTabUnselected(tab);
        }
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.mSelectedListeners.get(size)).onTabReselected(tab);
        }
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        View childAt = this.mTabStrip.getChildAt(i);
        i++;
        i = i < this.mTabStrip.getChildCount() ? this.mTabStrip.getChildAt(i) : 0;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (i != 0) {
            i2 = i.getWidth();
        }
        i = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        f = (int) ((((float) (width + i2)) * PayBaseConstants.HALF_OF_FLOAT) * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? i + f : i - f;
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.mTabStrip, this.mMode == 0 ? Math.max(0, this.mContentInsetStart - this.mTabPaddingStart) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.mTabStrip.setGravity(GravityCompat.START);
                break;
            case 1:
                this.mTabStrip.setGravity(1);
                break;
            default:
                break;
        }
        updateTabViews(true);
    }

    void updateTabViews(boolean z) {
        for (int i = 0; i < this.mTabStrip.getChildCount(); i++) {
            View childAt = this.mTabStrip.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        r1 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r1[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r1, iArr);
    }

    private int getDefaultHeight() {
        int size = this.mTabs.size();
        Object obj = null;
        for (int i = 0; i < size; i++) {
            Tab tab = (Tab) this.mTabs.get(i);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                obj = 1;
                break;
            }
        }
        return obj != null ? 72 : 48;
    }

    private int getTabMinWidth() {
        if (this.mRequestedTabMinWidth != -1) {
            return this.mRequestedTabMinWidth;
        }
        return this.mMode == 0 ? this.mScrollableTabMinWidth : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }
}
