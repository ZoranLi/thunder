package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionMenuItemView extends AppCompatTextView implements ItemView, ActionMenuChildView, OnClickListener {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu getPopup() {
            return ActionMenuItemView.this.mPopupCallback != null ? ActionMenuItemView.this.mPopupCallback.getPopup() : null;
        }

        protected boolean onForwardingStarted() {
            if (ActionMenuItemView.this.mItemInvoker == null || !ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData)) {
                return false;
            }
            ShowableListMenu popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.mMinWidth = context.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.mMaxIconSize = (int) ((1107296256 * resources.getDisplayMetrics().density) + 1056964608);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480 && (i < 640 || i2 < 480)) {
            if (configuration.orientation != 2) {
                return false;
            }
        }
        return true;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mSavedPaddingLeft = i;
        super.setPadding(i, i2, i3, i4);
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleForItemView(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() != 0 ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() != null && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.mItemInvoker != null) {
            this.mItemInvoker.invokeItem(this.mItemData);
        }
    }

    public void setItemInvoker(ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            if (this.mItemData) {
                this.mItemData.actionFormatChanged();
            }
        }
    }

    private void updateTextButtonVisibility() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.mTitle) ^ 1;
        if (this.mIcon != null) {
            if (this.mItemData.showsTextAsAction()) {
                if (!this.mAllowTextWithIcon) {
                    if (this.mExpandedFormat) {
                    }
                }
            }
            i = 0;
        }
        isEmpty &= i;
        CharSequence charSequence = null;
        setText(isEmpty != 0 ? this.mTitle : null);
        CharSequence contentDescription = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty != 0) {
                contentDescription = null;
            } else {
                contentDescription = this.mItemData.getTitle();
            }
            setContentDescription(contentDescription);
        } else {
            setContentDescription(contentDescription);
        }
        contentDescription = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty == 0) {
                charSequence = this.mItemData.getTitle();
            }
            TooltipCompat.setTooltipText(this, charSequence);
            return;
        }
        TooltipCompat.setTooltipText(this, contentDescription);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.mMaxIconSize) {
                f = ((float) this.mMaxIconSize) / ((float) intrinsicWidth);
                intrinsicWidth = this.mMaxIconSize;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.mMaxIconSize) {
                f = ((float) this.mMaxIconSize) / ((float) intrinsicHeight);
                intrinsicHeight = this.mMaxIconSize;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        updateTextButtonVisibility();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.mSavedPaddingLeft >= 0) {
            super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        i = mode == Integer.MIN_VALUE ? Math.min(i, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < i) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), i2);
        }
        if (!hasText && this.mIcon != 0) {
            super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
