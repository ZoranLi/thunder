package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.umeng.message.proguard.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            context = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = context.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = context.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            context.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        context = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        attributeSet = context.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (attributeSet >= null) {
            setOrientation(attributeSet);
        }
        attributeSet = context.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (attributeSet >= null) {
            setGravity(attributeSet);
        }
        attributeSet = context.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (attributeSet == null) {
            setBaselineAligned(attributeSet);
        }
        this.mWeightSum = context.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1082130432);
        this.mBaselineAlignedChildIndex = context.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = context.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(context.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = context.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = context.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        context.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                virtualChildCount = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                virtualChildCount = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, virtualChildCount);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                int right;
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    right = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    right = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, right);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    virtualChildCount = (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth;
                } else {
                    virtualChildCount = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (isLayoutRtl) {
                virtualChildCount = getPaddingLeft();
            } else {
                virtualChildCount = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, virtualChildCount);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                int i2 = this.mGravity & 112;
                if (i2 != 48) {
                    if (i2 == 16) {
                        i += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i2 == 80) {
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
            }
            return (i + ((LayoutParams) childAt.getLayoutParams()).topMargin) + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0) {
            if (i < getChildCount()) {
                this.mBaselineAlignedChildIndex = i;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("base aligned child index out of range (0, ");
        stringBuilder.append(getChildCount());
        stringBuilder.append(k.t);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.mShowDividers & 4) != 0;
            } else {
                if ((this.mShowDividers & 2) == 0) {
                    return false;
                }
                for (i--; i >= 0; i--) {
                    if (getChildAt(i).getVisibility() != 8) {
                        z = true;
                        break;
                    }
                }
                return z;
            }
        }
    }

    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int measuredWidth;
        int i7 = i;
        int i8 = i2;
        int i9 = 0;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int i10 = this.mBaselineAlignedChildIndex;
        boolean z = this.mUseLargestChild;
        int i11 = 0;
        int i12 = i11;
        int i13 = i12;
        int i14 = i13;
        int i15 = i14;
        int i16 = i15;
        float f = 0.0f;
        Object obj = 1;
        int i17 = Integer.MIN_VALUE;
        while (i13 < virtualChildCount) {
            float f2;
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                r7.mTotalLength += measureNullChild(i13);
                f2 = f;
                i3 = i13;
                i4 = i9;
                i5 = virtualChildCount;
                i6 = mode2;
            } else {
                View view;
                int i18 = i11;
                if (virtualChildAt.getVisibility() != 8) {
                    int i19;
                    LayoutParams layoutParams;
                    int i20;
                    int i21;
                    if (hasDividerBeforeChildAt(i13)) {
                        r7.mTotalLength += r7.mDividerHeight;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    f2 = f + layoutParams2.weight;
                    int i22;
                    if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                        i3 = r7.mTotalLength;
                        i22 = i17;
                        r7.mTotalLength = Math.max(i3, (layoutParams2.topMargin + i3) + layoutParams2.bottomMargin);
                        i19 = i12;
                        view = virtualChildAt;
                        layoutParams = layoutParams2;
                        i20 = i9;
                        i5 = virtualChildCount;
                        i6 = mode2;
                        i14 = 1;
                        i21 = i16;
                        mode2 = i18;
                        i17 = i22;
                        virtualChildCount = i13;
                    } else {
                        i22 = i17;
                        if (layoutParams2.height != 0 || layoutParams2.weight <= 0.0f) {
                            i17 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.height = -2;
                            i17 = 0;
                        }
                        i6 = mode2;
                        mode2 = i18;
                        int i23 = i17;
                        int i24 = i22;
                        i5 = virtualChildCount;
                        virtualChildCount = i12;
                        i12 = i7;
                        view = virtualChildAt;
                        i19 = virtualChildCount;
                        i21 = i16;
                        virtualChildCount = 1073741824;
                        virtualChildCount = i13;
                        i13 = i8;
                        layoutParams = layoutParams2;
                        i20 = i9;
                        measureChildBeforeLayout(virtualChildAt, i13, i12, 0, i13, f2 == 0.0f ? r7.mTotalLength : 0);
                        i3 = i23;
                        if (i3 != Integer.MIN_VALUE) {
                            layoutParams.height = i3;
                        }
                        i3 = view.getMeasuredHeight();
                        i11 = r7.mTotalLength;
                        r7.mTotalLength = Math.max(i11, (((i11 + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) + getNextLocationOffset(view));
                        i17 = z ? Math.max(i3, i24) : i24;
                    }
                    if (i10 >= 0 && i10 == virtualChildCount + 1) {
                        r7.mBaselineChildTop = r7.mTotalLength;
                    }
                    if (virtualChildCount >= i10 || layoutParams.weight <= 0.0f) {
                        if (mode != 1073741824) {
                            i11 = -1;
                            if (layoutParams.width == -1) {
                                i3 = 1;
                                i15 = i3;
                                i12 = layoutParams.leftMargin + layoutParams.rightMargin;
                                measuredWidth = view.getMeasuredWidth() + i12;
                                i13 = Math.max(mode2, measuredWidth);
                                i4 = View.combineMeasuredStates(i20, view.getMeasuredState());
                                obj = (obj == null && layoutParams.width == i11) ? 1 : null;
                                if (layoutParams.weight <= 0.0f) {
                                    if (i3 == 0) {
                                        i12 = measuredWidth;
                                    }
                                    i8 = Math.max(i19, i12);
                                    i12 = i21;
                                } else {
                                    i8 = i19;
                                    if (i3 != 0) {
                                        measuredWidth = i12;
                                    }
                                    i12 = Math.max(i21, measuredWidth);
                                }
                            }
                        } else {
                            i11 = -1;
                        }
                        i3 = 0;
                        i12 = layoutParams.leftMargin + layoutParams.rightMargin;
                        measuredWidth = view.getMeasuredWidth() + i12;
                        i13 = Math.max(mode2, measuredWidth);
                        i4 = View.combineMeasuredStates(i20, view.getMeasuredState());
                        if (obj == null) {
                        }
                        if (layoutParams.weight <= 0.0f) {
                            i8 = i19;
                            if (i3 != 0) {
                                measuredWidth = i12;
                            }
                            i12 = Math.max(i21, measuredWidth);
                        } else {
                            if (i3 == 0) {
                                i12 = measuredWidth;
                            }
                            i8 = Math.max(i19, i12);
                            i12 = i21;
                        }
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i8 = i12;
                view = virtualChildAt;
                i5 = virtualChildCount;
                i6 = mode2;
                i12 = i16;
                virtualChildCount = i13;
                f2 = f;
                i13 = i18;
                i4 = i9;
                i17 = i17;
                i3 = getChildrenSkipCount(view, virtualChildCount) + virtualChildCount;
                i16 = i12;
                i11 = i13;
                i12 = i8;
            }
            i13 = i3 + 1;
            i9 = i4;
            f = f2;
            mode2 = i6;
            virtualChildCount = i5;
            i7 = i;
            i8 = i2;
        }
        i4 = i17;
        i8 = i12;
        i17 = i9;
        i5 = virtualChildCount;
        i6 = mode2;
        i12 = i16;
        mode2 = i11;
        if (r7.mTotalLength > 0) {
            measuredWidth = i5;
            if (hasDividerBeforeChildAt(measuredWidth)) {
                r7.mTotalLength += r7.mDividerHeight;
            }
        } else {
            measuredWidth = i5;
        }
        if (z) {
            i13 = i6;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                r7.mTotalLength = 0;
                i7 = 0;
                while (i7 < measuredWidth) {
                    View virtualChildAt2 = getVirtualChildAt(i7);
                    if (virtualChildAt2 == null) {
                        r7.mTotalLength += measureNullChild(i7);
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        i7 += getChildrenSkipCount(virtualChildAt2, i7);
                    } else {
                        LayoutParams layoutParams3 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        i10 = r7.mTotalLength;
                        r7.mTotalLength = Math.max(i10, (((i10 + i4) + layoutParams3.topMargin) + layoutParams3.bottomMargin) + getNextLocationOffset(virtualChildAt2));
                    }
                    i7++;
                }
            }
        } else {
            i13 = i6;
        }
        r7.mTotalLength += getPaddingTop() + getPaddingBottom();
        i7 = i2;
        i11 = View.resolveSizeAndState(Math.max(r7.mTotalLength, getSuggestedMinimumHeight()), i7, 0);
        i9 = (ViewCompat.MEASURED_SIZE_MASK & i11) - r7.mTotalLength;
        if (i14 == 0) {
            if (i9 == 0 || f <= 0.0f) {
                i3 = Math.max(i12, i8);
                if (z && i13 != 1073741824) {
                    for (i12 = 0; i12 < measuredWidth; i12++) {
                        View virtualChildAt3 = getVirtualChildAt(i12);
                        if (!(virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8 || ((LayoutParams) virtualChildAt3.getLayoutParams()).weight <= 0.0f)) {
                            virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                    }
                }
                i8 = i;
                if (obj == null && mode != 1073741824) {
                    mode2 = i3;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(mode2 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i8, i17), i11);
                if (i15 != 0) {
                    forceUniformWidth(measuredWidth, i7);
                }
            }
        }
        if (r7.mWeightSum > 0.0f) {
            f = r7.mWeightSum;
        }
        r7.mTotalLength = 0;
        float f3 = f;
        i3 = 0;
        int i25 = i9;
        i9 = i17;
        i17 = i25;
        while (i3 < measuredWidth) {
            float f4;
            View virtualChildAt4 = getVirtualChildAt(i3);
            float f5;
            if (virtualChildAt4.getVisibility() != 8) {
                int i26;
                int i27;
                int i28;
                Object obj2;
                Object obj3;
                LayoutParams layoutParams4 = (LayoutParams) virtualChildAt4.getLayoutParams();
                f5 = layoutParams4.weight;
                if (f5 > 0.0f) {
                    i26 = (int) ((((float) i17) * f5) / f3);
                    i27 = i17 - i26;
                    f4 = f3 - f5;
                    i17 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams4.leftMargin) + layoutParams4.rightMargin, layoutParams4.width);
                    if (layoutParams4.height == 0) {
                        if (i13 == 1073741824) {
                            if (i26 > 0) {
                                i4 = 1073741824;
                                virtualChildAt4.measure(i17, MeasureSpec.makeMeasureSpec(i26, i4));
                                i9 = View.combineMeasuredStates(i9, virtualChildAt4.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                            } else {
                                i4 = 1073741824;
                                i26 = 0;
                                virtualChildAt4.measure(i17, MeasureSpec.makeMeasureSpec(i26, i4));
                                i9 = View.combineMeasuredStates(i9, virtualChildAt4.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                            }
                        }
                    }
                    i4 = virtualChildAt4.getMeasuredHeight() + i26;
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    i26 = i4;
                    i4 = 1073741824;
                    virtualChildAt4.measure(i17, MeasureSpec.makeMeasureSpec(i26, i4));
                    i9 = View.combineMeasuredStates(i9, virtualChildAt4.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                } else {
                    f5 = f3;
                    i8 = i;
                    i27 = i17;
                    f4 = f5;
                }
                i17 = layoutParams4.leftMargin + layoutParams4.rightMargin;
                i4 = virtualChildAt4.getMeasuredWidth() + i17;
                mode2 = Math.max(mode2, i4);
                if (mode != 1073741824) {
                    i28 = i17;
                    i17 = -1;
                    if (layoutParams4.width == -1) {
                        obj2 = 1;
                        if (obj2 != null) {
                            i4 = i28;
                        }
                        i12 = Math.max(i12, i4);
                        obj3 = (obj == null && layoutParams4.width == i17) ? 1 : null;
                        i26 = r7.mTotalLength;
                        r7.mTotalLength = Math.max(i26, (((i26 + virtualChildAt4.getMeasuredHeight()) + layoutParams4.topMargin) + layoutParams4.bottomMargin) + getNextLocationOffset(virtualChildAt4));
                        obj = obj3;
                        i17 = i27;
                    }
                } else {
                    i28 = i17;
                    i17 = -1;
                }
                obj2 = null;
                if (obj2 != null) {
                    i4 = i28;
                }
                i12 = Math.max(i12, i4);
                if (obj == null) {
                }
                i26 = r7.mTotalLength;
                r7.mTotalLength = Math.max(i26, (((i26 + virtualChildAt4.getMeasuredHeight()) + layoutParams4.topMargin) + layoutParams4.bottomMargin) + getNextLocationOffset(virtualChildAt4));
                obj = obj3;
                i17 = i27;
            } else {
                f5 = f3;
                i8 = i;
                f4 = f5;
            }
            i3++;
            f3 = f4;
        }
        i8 = i;
        r7.mTotalLength += getPaddingTop() + getPaddingBottom();
        i3 = i12;
        i17 = i9;
        mode2 = i3;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(mode2 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i8, i17), i11);
        if (i15 != 0) {
            forceUniformWidth(measuredWidth, i7);
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int measuredHeight;
        int baseline;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = i2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || r7.mMaxDescent == null) {
            r7.mMaxAscent = new int[4];
            r7.mMaxDescent = new int[4];
        }
        int[] iArr2 = r7.mMaxAscent;
        int[] iArr3 = r7.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z3 = r7.mBaselineAligned;
        boolean z4 = r7.mUseLargestChild;
        int i10 = 1073741824;
        int i11 = mode == 1073741824 ? 1 : 0;
        int i12 = 0;
        int i13 = i12;
        int i14 = i13;
        int i15 = i14;
        int i16 = i15;
        int i17 = i16;
        int i18 = i17;
        int i19 = 1;
        float f = 0.0f;
        int i20 = Integer.MIN_VALUE;
        while (true) {
            iArr = iArr3;
            i3 = 8;
            if (i12 >= virtualChildCount) {
                break;
            }
            LayoutParams layoutParams;
            View virtualChildAt = getVirtualChildAt(i12);
            if (virtualChildAt == null) {
                r7.mTotalLength += measureNullChild(i12);
                i3 = i12;
                i12 = i10;
                z = z4;
                z2 = z3;
                i4 = mode;
            } else {
                int i21;
                View view;
                if (virtualChildAt.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i12)) {
                        r7.mTotalLength += r7.mDividerWidth;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    f += layoutParams2.weight;
                    if (mode == i10 && layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                        if (i11 != 0) {
                            r7.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = r7.mTotalLength;
                            r7.mTotalLength = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                        }
                        if (z3) {
                            i10 = MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(i10, i10);
                            i21 = i12;
                            z = z4;
                            z2 = z3;
                            layoutParams = layoutParams2;
                            i4 = mode;
                            view = virtualChildAt;
                        } else {
                            i21 = i12;
                            z = z4;
                            z2 = z3;
                            layoutParams = layoutParams2;
                            i4 = mode;
                            i14 = 1;
                            i12 = 1073741824;
                            view = virtualChildAt;
                            if (mode2 == i12 && layoutParams.height == -1) {
                                i3 = 1;
                                i18 = i3;
                            } else {
                                i3 = 0;
                            }
                            i10 = layoutParams.topMargin + layoutParams.bottomMargin;
                            measuredHeight = view.getMeasuredHeight() + i10;
                            i17 = View.combineMeasuredStates(i17, view.getMeasuredState());
                            if (z2) {
                                baseline = view.getBaseline();
                                if (baseline != -1) {
                                    i5 = ((((layoutParams.gravity >= 0 ? r7.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                                    iArr2[i5] = Math.max(iArr2[i5], baseline);
                                    iArr[i5] = Math.max(iArr[i5], measuredHeight - baseline);
                                }
                            }
                            i13 = Math.max(i13, measuredHeight);
                            i19 = (i19 == 0 && layoutParams.height == -1) ? 1 : 0;
                            if (layoutParams.weight <= 0.0f) {
                                if (i3 == 0) {
                                    i10 = measuredHeight;
                                }
                                i5 = Math.max(i16, i10);
                            } else {
                                i5 = i16;
                                if (i3 != 0) {
                                    measuredHeight = i10;
                                }
                                i15 = Math.max(i15, measuredHeight);
                            }
                        }
                    } else {
                        if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            layoutParams2.width = -2;
                            i10 = 0;
                        }
                        i21 = i12;
                        i6 = i10;
                        z = z4;
                        z2 = z3;
                        layoutParams = layoutParams2;
                        i4 = mode;
                        view = virtualChildAt;
                        measureChildBeforeLayout(virtualChildAt, i21, i8, f == 0.0f ? r7.mTotalLength : 0, i9, 0);
                        if (i6 != Integer.MIN_VALUE) {
                            layoutParams.width = i6;
                        }
                        i12 = view.getMeasuredWidth();
                        if (i11 != 0) {
                            r7.mTotalLength += ((layoutParams.leftMargin + i12) + layoutParams.rightMargin) + getNextLocationOffset(view);
                        } else {
                            i3 = r7.mTotalLength;
                            r7.mTotalLength = Math.max(i3, (((i3 + i12) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(view));
                        }
                        if (z) {
                            i20 = Math.max(i12, i20);
                        }
                    }
                    i12 = 1073741824;
                    if (mode2 == i12) {
                    }
                    i3 = 0;
                    i10 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i10;
                    i17 = View.combineMeasuredStates(i17, view.getMeasuredState());
                    if (z2) {
                        baseline = view.getBaseline();
                        if (baseline != -1) {
                            if (layoutParams.gravity >= 0) {
                            }
                            i5 = ((((layoutParams.gravity >= 0 ? r7.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr2[i5] = Math.max(iArr2[i5], baseline);
                            iArr[i5] = Math.max(iArr[i5], measuredHeight - baseline);
                        }
                    }
                    i13 = Math.max(i13, measuredHeight);
                    if (i19 == 0) {
                    }
                    if (layoutParams.weight <= 0.0f) {
                        i5 = i16;
                        if (i3 != 0) {
                            measuredHeight = i10;
                        }
                        i15 = Math.max(i15, measuredHeight);
                    } else {
                        if (i3 == 0) {
                            i10 = measuredHeight;
                        }
                        i5 = Math.max(i16, i10);
                    }
                } else {
                    i21 = i12;
                    i12 = i10;
                    z = z4;
                    z2 = z3;
                    i4 = mode;
                    baseline = i13;
                    i10 = i15;
                    i5 = i16;
                    i6 = i17;
                    view = virtualChildAt;
                }
                i6 = i21;
                i3 = getChildrenSkipCount(view, i6) + i6;
                i16 = i5;
            }
            i10 = i12;
            i12 = i3 + 1;
            iArr3 = iArr;
            z4 = z;
            z3 = z2;
            mode = i4;
            i8 = i;
        }
        i12 = i10;
        z = z4;
        z2 = z3;
        i4 = mode;
        baseline = i13;
        i10 = i15;
        i5 = i16;
        i6 = i17;
        if (r7.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            r7.mTotalLength += r7.mDividerWidth;
        }
        if (!(iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1)) {
            baseline = Math.max(baseline, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z) {
            i12 = i4;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                r7.mTotalLength = 0;
                measuredHeight = 0;
                while (measuredHeight < virtualChildCount) {
                    int i22;
                    virtualChildAt = getVirtualChildAt(measuredHeight);
                    if (virtualChildAt == null) {
                        r7.mTotalLength += measureNullChild(measuredHeight);
                    } else if (virtualChildAt.getVisibility() == i3) {
                        measuredHeight += getChildrenSkipCount(virtualChildAt, measuredHeight);
                    } else {
                        layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        if (i11 != 0) {
                            r7.mTotalLength += ((layoutParams.leftMargin + i20) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt);
                        } else {
                            i3 = r7.mTotalLength;
                            i22 = measuredHeight;
                            r7.mTotalLength = Math.max(i3, (((i3 + i20) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt));
                            measuredHeight = i22 + 1;
                            i3 = 8;
                        }
                    }
                    i22 = measuredHeight;
                    measuredHeight = i22 + 1;
                    i3 = 8;
                }
            }
        } else {
            i12 = i4;
        }
        r7.mTotalLength += getPaddingLeft() + getPaddingRight();
        i3 = View.resolveSizeAndState(Math.max(r7.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i23 = (ViewCompat.MEASURED_SIZE_MASK & i3) - r7.mTotalLength;
        if (i14 == 0) {
            if (i23 == 0 || f <= 0.0f) {
                i10 = Math.max(i10, i5);
                if (z && i12 != 1073741824) {
                    for (i12 = 0; i12 < virtualChildCount; i12++) {
                        View virtualChildAt2 = getVirtualChildAt(i12);
                        if (!(virtualChildAt2 == null || virtualChildAt2.getVisibility() == 8 || ((LayoutParams) virtualChildAt2.getLayoutParams()).weight <= 0.0f)) {
                            virtualChildAt2.measure(MeasureSpec.makeMeasureSpec(i20, 1073741824), MeasureSpec.makeMeasureSpec(virtualChildAt2.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i7 = virtualChildCount;
                if (i19 == 0 || mode2 == 1073741824) {
                    i10 = baseline;
                }
                setMeasuredDimension(i3 | (-16777216 & i6), View.resolveSizeAndState(Math.max(i10 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i9, i6 << 16));
                if (i18 == 0) {
                    forceUniformHeight(i7, i);
                }
            }
        }
        float f2 = r7.mWeightSum > 0.0f ? r7.mWeightSum : f;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        r7.mTotalLength = 0;
        i5 = i10;
        i10 = 0;
        mode = -1;
        while (i10 < virtualChildCount) {
            View virtualChildAt3 = getVirtualChildAt(i10);
            if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                i7 = virtualChildCount;
            } else {
                float f3;
                layoutParams = (LayoutParams) virtualChildAt3.getLayoutParams();
                float f4 = layoutParams.weight;
                if (f4 > 0.0f) {
                    i7 = virtualChildCount;
                    virtualChildCount = (int) ((((float) i23) * f4) / f2);
                    i23 -= virtualChildCount;
                    f3 = f2 - f4;
                    measuredHeight = getChildMeasureSpec(i9, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                    if (layoutParams.width == 0) {
                        if (i12 == 1073741824) {
                            if (virtualChildCount > 0) {
                                baseline = 1073741824;
                                virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(virtualChildCount, baseline), measuredHeight);
                                i6 = View.combineMeasuredStates(i6, virtualChildAt3.getMeasuredState() & -16777216);
                            } else {
                                baseline = 1073741824;
                                virtualChildCount = 0;
                                virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(virtualChildCount, baseline), measuredHeight);
                                i6 = View.combineMeasuredStates(i6, virtualChildAt3.getMeasuredState() & -16777216);
                            }
                        }
                    }
                    baseline = virtualChildAt3.getMeasuredWidth() + virtualChildCount;
                    if (baseline < 0) {
                        baseline = 0;
                    }
                    virtualChildCount = baseline;
                    baseline = 1073741824;
                    virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(virtualChildCount, baseline), measuredHeight);
                    i6 = View.combineMeasuredStates(i6, virtualChildAt3.getMeasuredState() & -16777216);
                } else {
                    i7 = virtualChildCount;
                    f3 = f2;
                }
                if (i11 != 0) {
                    r7.mTotalLength += ((virtualChildAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3);
                } else {
                    measuredHeight = r7.mTotalLength;
                    r7.mTotalLength = Math.max(measuredHeight, (((virtualChildAt3.getMeasuredWidth() + measuredHeight) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3));
                }
                measuredHeight = (mode2 == 1073741824 || layoutParams.height != -1) ? 0 : 1;
                baseline = layoutParams.topMargin + layoutParams.bottomMargin;
                virtualChildCount = virtualChildAt3.getMeasuredHeight() + baseline;
                mode = Math.max(mode, virtualChildCount);
                if (measuredHeight == 0) {
                    baseline = virtualChildCount;
                }
                measuredHeight = Math.max(i5, baseline);
                if (i19 != 0) {
                    i5 = -1;
                    if (layoutParams.height == -1) {
                        baseline = 1;
                        if (z2) {
                            i20 = virtualChildAt3.getBaseline();
                            if (i20 != i5) {
                                i5 = ((((layoutParams.gravity >= 0 ? r7.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                                iArr2[i5] = Math.max(iArr2[i5], i20);
                                iArr[i5] = Math.max(iArr[i5], virtualChildCount - i20);
                            }
                        }
                        i5 = measuredHeight;
                        i19 = baseline;
                        f2 = f3;
                    }
                } else {
                    i5 = -1;
                }
                baseline = 0;
                if (z2) {
                    i20 = virtualChildAt3.getBaseline();
                    if (i20 != i5) {
                        if (layoutParams.gravity >= 0) {
                        }
                        i5 = ((((layoutParams.gravity >= 0 ? r7.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr2[i5] = Math.max(iArr2[i5], i20);
                        iArr[i5] = Math.max(iArr[i5], virtualChildCount - i20);
                    }
                }
                i5 = measuredHeight;
                i19 = baseline;
                f2 = f3;
            }
            i10++;
            virtualChildCount = i7;
            measuredHeight = i;
        }
        i7 = virtualChildCount;
        r7.mTotalLength += getPaddingLeft() + getPaddingRight();
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1) {
            if (iArr2[3] == -1) {
                baseline = mode;
                i10 = i5;
                if (i19 == 0) {
                }
                i10 = baseline;
                setMeasuredDimension(i3 | (-16777216 & i6), View.resolveSizeAndState(Math.max(i10 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i9, i6 << 16));
                if (i18 == 0) {
                    forceUniformHeight(i7, i);
                }
            }
        }
        baseline = Math.max(mode, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        i10 = i5;
        if (i19 == 0) {
        }
        i10 = baseline;
        setMeasuredDimension(i3 | (-16777216 & i6), View.resolveSizeAndState(Math.max(i10 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i9, i6 << 16));
        if (i18 == 0) {
            forceUniformHeight(i7, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        i5 = this.mGravity & 112;
        int i6 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 16) {
            paddingTop = (((i4 - i2) - r6.mTotalLength) / 2) + getPaddingTop();
        } else if (i5 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i4) - i2) - r6.mTotalLength;
        }
        int i7 = 0;
        while (i7 < virtualChildCount) {
            int i8;
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i7);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                i8 = layoutParams.gravity;
                if (i8 < 0) {
                    i8 = i6;
                }
                i8 = GravityCompat.getAbsoluteGravity(i8, ViewCompat.getLayoutDirection(this)) & 7;
                if (i8 == 1) {
                    i8 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (i8 != 5) {
                    i8 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i8 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                }
                i5 = i8;
                if (hasDividerBeforeChildAt(i7)) {
                    paddingTop += r6.mDividerHeight;
                }
                int i9 = paddingTop + layoutParams.topMargin;
                LayoutParams layoutParams2 = layoutParams;
                setChildFrame(virtualChildAt, i5, i9 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i7 += getChildrenSkipCount(virtualChildAt, i7);
                paddingTop = i9 + ((measuredHeight + layoutParams2.bottomMargin) + getNextLocationOffset(virtualChildAt));
                i8 = 1;
                i7 += i8;
            }
            i8 = 1;
            i7 += i8;
        }
    }

    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i8 = this.mGravity & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        i7 = GravityCompat.getAbsoluteGravity(i7, ViewCompat.getLayoutDirection(this));
        int i9 = 1;
        if (i7 == 1) {
            paddingLeft = (((i3 - i) - r6.mTotalLength) / 2) + getPaddingLeft();
        } else if (i7 != 5) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = ((getPaddingLeft() + i3) - i) - r6.mTotalLength;
        }
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        i7 = 0;
        while (i7 < virtualChildCount) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14 = i5 + (i6 * i7);
            View virtualChildAt = getVirtualChildAt(i14);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i14);
                i10 = i9;
                i11 = paddingTop;
                i12 = virtualChildCount;
                i13 = i8;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i15;
                View view;
                LayoutParams layoutParams;
                View view2;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                i9 = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z) {
                    i15 = i7;
                    i12 = virtualChildCount;
                    if (layoutParams2.height != -1) {
                        i7 = virtualChildAt.getBaseline();
                        virtualChildCount = layoutParams2.gravity;
                        if (virtualChildCount < 0) {
                            virtualChildCount = i8;
                        }
                        virtualChildCount &= 112;
                        i13 = i8;
                        if (virtualChildCount != 16) {
                            i10 = 1;
                            i7 = ((((paddingBottom2 - i9) / 2) + paddingTop) + layoutParams2.topMargin) - layoutParams2.bottomMargin;
                        } else if (virtualChildCount == 48) {
                            if (virtualChildCount == 80) {
                                i7 = paddingTop;
                            } else {
                                virtualChildCount = (paddingBottom - i9) - layoutParams2.bottomMargin;
                                if (i7 != -1) {
                                    virtualChildCount -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i7);
                                }
                                i7 = virtualChildCount;
                            }
                            i10 = 1;
                        } else {
                            virtualChildCount = layoutParams2.topMargin + paddingTop;
                            if (i7 == -1) {
                                i10 = 1;
                                virtualChildCount += iArr[1] - i7;
                            } else {
                                i10 = 1;
                            }
                            i7 = virtualChildCount;
                        }
                        if (hasDividerBeforeChildAt(i14)) {
                            paddingLeft += r6.mDividerWidth;
                        }
                        virtualChildCount = layoutParams2.leftMargin + paddingLeft;
                        view = virtualChildAt;
                        i8 = i14;
                        i14 = virtualChildCount + getLocationOffset(virtualChildAt);
                        r19 = i15;
                        i11 = paddingTop;
                        layoutParams = layoutParams2;
                        setChildFrame(virtualChildAt, i14, i7, measuredWidth, i9);
                        view2 = view;
                        i7 = r19 + getChildrenSkipCount(view2, i8);
                        paddingLeft = virtualChildCount + ((measuredWidth + layoutParams.rightMargin) + getNextLocationOffset(view2));
                        i7++;
                        i9 = i10;
                        virtualChildCount = i12;
                        i8 = i13;
                        paddingTop = i11;
                    }
                } else {
                    i15 = i7;
                    i12 = virtualChildCount;
                }
                i7 = -1;
                virtualChildCount = layoutParams2.gravity;
                if (virtualChildCount < 0) {
                    virtualChildCount = i8;
                }
                virtualChildCount &= 112;
                i13 = i8;
                if (virtualChildCount != 16) {
                    i10 = 1;
                    i7 = ((((paddingBottom2 - i9) / 2) + paddingTop) + layoutParams2.topMargin) - layoutParams2.bottomMargin;
                } else if (virtualChildCount == 48) {
                    virtualChildCount = layoutParams2.topMargin + paddingTop;
                    if (i7 == -1) {
                        i10 = 1;
                    } else {
                        i10 = 1;
                        virtualChildCount += iArr[1] - i7;
                    }
                    i7 = virtualChildCount;
                } else {
                    if (virtualChildCount == 80) {
                        virtualChildCount = (paddingBottom - i9) - layoutParams2.bottomMargin;
                        if (i7 != -1) {
                            virtualChildCount -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i7);
                        }
                        i7 = virtualChildCount;
                    } else {
                        i7 = paddingTop;
                    }
                    i10 = 1;
                }
                if (hasDividerBeforeChildAt(i14)) {
                    paddingLeft += r6.mDividerWidth;
                }
                virtualChildCount = layoutParams2.leftMargin + paddingLeft;
                view = virtualChildAt;
                i8 = i14;
                i14 = virtualChildCount + getLocationOffset(virtualChildAt);
                r19 = i15;
                i11 = paddingTop;
                layoutParams = layoutParams2;
                setChildFrame(virtualChildAt, i14, i7, measuredWidth, i9);
                view2 = view;
                i7 = r19 + getChildrenSkipCount(view2, i8);
                paddingLeft = virtualChildCount + ((measuredWidth + layoutParams.rightMargin) + getNextLocationOffset(view2));
                i7++;
                i9 = i10;
                virtualChildCount = i12;
                i8 = i13;
                paddingTop = i11;
            } else {
                r19 = i7;
                i11 = paddingTop;
                i12 = virtualChildCount;
                i13 = i8;
                i10 = 1;
            }
            i7++;
            i9 = i10;
            virtualChildCount = i12;
            i8 = i13;
            paddingTop = i11;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        i &= GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & this.mGravity) != i) {
            this.mGravity = i | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        i &= 112;
        if ((this.mGravity & 112) != i) {
            this.mGravity = i | (this.mGravity & -113);
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        return this.mOrientation == 1 ? new LayoutParams(-1, -2) : null;
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
