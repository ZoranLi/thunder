package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

@RestrictTo({Scope.LIBRARY_GROUP})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        int combineMeasuredStates;
        int resolveMinimumHeight;
        int measuredHeight;
        int i4;
        AlertDialogLayout alertDialogLayout = this;
        int i5 = i;
        int i6 = i2;
        int childCount = getChildCount();
        View view = null;
        View view2 = view;
        View view3 = view2;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if (id != R.id.contentPanel) {
                        if (id != R.id.customPanel) {
                            return false;
                        }
                    }
                    if (view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        i3 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i5, 0);
            paddingTop += view.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            combineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i5, 0);
            resolveMinimumHeight = resolveMinimumHeight(view2);
            measuredHeight = view2.getMeasuredHeight() - resolveMinimumHeight;
            paddingTop += resolveMinimumHeight;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        } else {
            resolveMinimumHeight = 0;
            measuredHeight = resolveMinimumHeight;
        }
        if (view3 != null) {
            if (i3 == 0) {
                i4 = 0;
            } else {
                i4 = MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), i3);
            }
            view3.measure(i5, i4);
            i4 = view3.getMeasuredHeight();
            paddingTop += i4;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        } else {
            i4 = 0;
        }
        size -= paddingTop;
        if (view2 != null) {
            paddingTop -= resolveMinimumHeight;
            measuredHeight = Math.min(size, measuredHeight);
            if (measuredHeight > 0) {
                size -= measuredHeight;
                resolveMinimumHeight += measuredHeight;
            }
            view2.measure(i5, MeasureSpec.makeMeasureSpec(resolveMinimumHeight, 1073741824));
            paddingTop += view2.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && size > 0) {
            paddingTop -= i4;
            view3.measure(i5, MeasureSpec.makeMeasureSpec(i4 + size, i3));
            paddingTop += view3.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        }
        int i7 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            view3 = getChildAt(i3);
            if (view3.getVisibility() != 8) {
                i7 = Math.max(i7, view3.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i7 + (getPaddingLeft() + getPaddingRight()), i5, combineMeasuredStates), View.resolveSizeAndState(paddingTop, i6, 0));
        if (mode != 1073741824) {
            forceUniformWidth(childCount, i6);
        }
        return true;
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        while (true) {
            int minimumHeight = ViewCompat.getMinimumHeight(view);
            if (minimumHeight <= 0) {
                if (!(view instanceof ViewGroup)) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() != 1) {
                    break;
                }
                view = viewGroup.getChildAt(0);
            } else {
                return minimumHeight;
            }
        }
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        i6 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & 112;
        int i8 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i7 == 16) {
            paddingTop = (((i4 - i2) - i6) / 2) + getPaddingTop();
        } else if (i7 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i4) - i2) - i6;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i5 = 0;
        } else {
            i5 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                i7 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i6 = layoutParams.gravity;
                if (i6 < 0) {
                    i6 = i8;
                }
                i6 = GravityCompat.getAbsoluteGravity(i6, ViewCompat.getLayoutDirection(this)) & 7;
                if (i6 == 1) {
                    i6 = ((((paddingRight2 - i7) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (i6 != 5) {
                    i6 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i6 = (paddingRight - i7) - layoutParams.rightMargin;
                }
                if (hasDividerBeforeChildAt(i9)) {
                    paddingTop += i5;
                }
                int i10 = paddingTop + layoutParams.topMargin;
                setChildFrame(childAt, i6, i10, i7, measuredHeight);
                paddingTop = i10 + (measuredHeight + layoutParams.bottomMargin);
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
