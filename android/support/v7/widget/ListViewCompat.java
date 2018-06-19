package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ListViewCompat extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private static final int[] STATE_SET_NOTHING = new int[]{0};
    private Field mIsChildViewEnabled;
    protected int mMotionPosition;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    final Rect mSelectorRect;

    private static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        void setEnabled(boolean z) {
            this.mEnabled = z;
        }

        public boolean setState(int[] iArr) {
            return this.mEnabled ? super.setState(iArr) : null;
        }

        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.mEnabled) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.mEnabled) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.mEnabled ? super.setVisible(z, z2) : false;
        }
    }

    protected boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }

    public ListViewCompat(Context context) {
        this(context, null);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        try {
            this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled.setAccessible(true);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.mSelector = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.mSelector);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && shouldShowSelectorCompat()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean shouldShowSelectorCompat() {
        return touchModeDrawsInPressedStateCompat() && isPressed();
    }

    protected void drawSelectorCompat(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.mSelectorRect);
                selector.draw(canvas);
            }
        }
    }

    public int lookForSelectablePosition(int i, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            if (!isInTouchMode()) {
                int count = adapter.getCount();
                if (getAdapter().areAllItemsEnabled()) {
                    if (i >= 0) {
                        if (i < count) {
                            return i;
                        }
                    }
                    return -1;
                }
                if (z) {
                    i = Math.max(false, i);
                    while (i < count && !adapter.isEnabled(i)) {
                        i++;
                    }
                } else {
                    i = Math.min(i, count - 1);
                    while (i >= 0 && !adapter.isEnabled(i)) {
                        i--;
                    }
                }
                if (i >= 0) {
                    if (i < count) {
                        return i;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    protected void positionSelectorLikeTouchCompat(int i, View view, float f, float f2) {
        positionSelectorLikeFocusCompat(i, view);
        view = getSelector();
        if (view != null && i != -1) {
            DrawableCompat.setHotspot(view, f, f2);
        }
    }

    protected void positionSelectorLikeFocusCompat(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i, view);
        if (z2) {
            i = this.mSelectorRect;
            view = i.exactCenterX();
            i = i.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.setHotspot(selector, view, i);
        }
    }

    protected void positionSelectorCompat(int i, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        try {
            boolean z = this.mIsChildViewEnabled.getBoolean(this);
            if (view.isEnabled() != z) {
                this.mIsChildViewEnabled.set(this, Boolean.valueOf(z ^ 1));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (int i2) {
            i2.printStackTrace();
        }
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        i2 = getListPaddingTop();
        i3 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return i2 + i3;
        }
        i2 += i3;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = i2;
        i2 = 0;
        int i7 = i2;
        int i8 = i7;
        View view = null;
        while (i2 < count) {
            int itemViewType = adapter.getItemViewType(i2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i2, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                itemViewType = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                itemViewType = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, itemViewType);
            view.forceLayout();
            if (i2 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            } else {
                if (i5 >= 0 && i2 >= i5) {
                    i8 = i6;
                }
                i2++;
            }
        }
        return i6;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.mSelector != null) {
            this.mSelector.setEnabled(z);
        }
    }
}
