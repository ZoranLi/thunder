package android.support.v4.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getNestedScrollingParentForType(i) != 0;
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        if (hasNestedScrollingParent(i2)) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i, i2)) {
                    setNestedScrollingParentForType(i2, parent);
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i);
            setNestedScrollingParentForType(i, null);
        }
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        int[] iArr2 = iArr;
        if (isNestedScrollingEnabled()) {
            int i6 = i5;
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i6);
            if (nestedScrollingParentForType == null) {
                return false;
            }
            int i7;
            int i8;
            if (i == 0 && i2 == 0 && i3 == 0) {
                if (i4 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                r0.mView.getLocationInWindow(iArr2);
                i7 = iArr2[0];
                i8 = iArr2[1];
            } else {
                i7 = 0;
                i8 = i7;
            }
            ViewParentCompat.onNestedScroll(nestedScrollingParentForType, r0.mView, i, i2, i3, i4, i6);
            if (iArr2 != null) {
                r0.mView.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i7;
                iArr2[1] = iArr2[1] - i8;
            }
            return true;
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i3);
            if (nestedScrollingParentForType == null) {
                return false;
            }
            int i4;
            int i5;
            if (i == 0) {
                if (i2 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = i4;
            }
            if (iArr == null) {
                if (this.mTempNestedScrollConsumed == null) {
                    this.mTempNestedScrollConsumed = new int[2];
                }
                iArr = this.mTempNestedScrollConsumed;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.mView.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr[0] == 0) {
                if (iArr[1] == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f, f2, z);
            }
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        if (isNestedScrollingEnabled()) {
            ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(0);
            if (nestedScrollingParentForType != null) {
                return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
            }
        }
        return false;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    private ViewParent getNestedScrollingParentForType(int i) {
        switch (i) {
            case 0:
                return this.mNestedScrollingParentTouch;
            case 1:
                return this.mNestedScrollingParentNonTouch;
            default:
                return 0;
        }
    }

    private void setNestedScrollingParentForType(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.mNestedScrollingParentTouch = viewParent;
                return;
            case 1:
                this.mNestedScrollingParentNonTouch = viewParent;
                break;
            default:
                break;
        }
    }
}
