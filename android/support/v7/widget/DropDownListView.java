package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.view.MotionEvent;
import android.view.View;

class DropDownListView extends ListViewCompat {
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;

    public DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(null);
    }

    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                i = 0;
                z = i;
                break;
            default:
                i = 0;
                z = true;
                break;
        }
        i = motionEvent.findPointerIndex(i);
        if (i < 0) {
            i = 0;
            z = i;
            if (!(z && r9 == 0)) {
                clearPressedItem();
            }
            if (!z) {
                if (this.mScrollHelper == 0) {
                    this.mScrollHelper = new ListViewAutoScrollHelper(this);
                }
                this.mScrollHelper.setEnabled(true);
                this.mScrollHelper.onTouch(this, motionEvent);
            } else if (this.mScrollHelper != null) {
                this.mScrollHelper.setEnabled(false);
            }
            return z;
        }
        int x = (int) motionEvent.getX(i);
        i = (int) motionEvent.getY(i);
        int pointToPosition = pointToPosition(x, i);
        if (pointToPosition == -1) {
            i = 1;
            clearPressedItem();
            if (!z) {
                if (this.mScrollHelper == 0) {
                    this.mScrollHelper = new ListViewAutoScrollHelper(this);
                }
                this.mScrollHelper.setEnabled(true);
                this.mScrollHelper.onTouch(this, motionEvent);
            } else if (this.mScrollHelper != null) {
                this.mScrollHelper.setEnabled(false);
            }
            return z;
        }
        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
        setPressedItem(childAt, pointToPosition, (float) x, (float) i);
        if (actionMasked == 1) {
            clickPressedItem(childAt, pointToPosition);
        }
        i = 0;
        z = true;
        clearPressedItem();
        if (!z) {
            if (this.mScrollHelper == 0) {
                this.mScrollHelper = new ListViewAutoScrollHelper(this);
            }
            this.mScrollHelper.setEnabled(true);
            this.mScrollHelper.onTouch(this, motionEvent);
        } else if (this.mScrollHelper != null) {
            this.mScrollHelper.setEnabled(false);
        }
        return z;
    }

    private void clickPressedItem(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.mClickAnimation != null) {
            this.mClickAnimation.cancel();
            this.mClickAnimation = null;
        }
    }

    private void setPressedItem(View view, int i, float f, float f2) {
        this.mDrawsInPressedState = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.mMotionPosition != -1) {
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.mMotionPosition = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean touchModeDrawsInPressedStateCompat() {
        if (!this.mDrawsInPressedState) {
            if (!super.touchModeDrawsInPressedStateCompat()) {
                return false;
            }
        }
        return true;
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        if (!this.mHijackFocus) {
            if (!super.hasWindowFocus()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFocused() {
        if (!this.mHijackFocus) {
            if (!super.isFocused()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFocus() {
        if (!this.mHijackFocus) {
            if (!super.hasFocus()) {
                return false;
            }
        }
        return true;
    }
}
