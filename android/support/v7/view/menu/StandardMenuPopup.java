package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class StandardMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnItemClickListener, OnDismissListener {
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final OnAttachStateChangeListener mAttachStateChangeListener = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (StandardMenuPopup.this.mTreeObserver != null) {
                if (!StandardMenuPopup.this.mTreeObserver.isAlive()) {
                    StandardMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                StandardMenuPopup.this.mTreeObserver.removeGlobalOnLayoutListener(StandardMenuPopup.this.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity = 0;
    private final OnGlobalLayoutListener mGlobalLayoutListener = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing() && !StandardMenuPopup.this.mPopup.isModal()) {
                View view = StandardMenuPopup.this.mShownAnchorView;
                if (view != null) {
                    if (view.isShown()) {
                        StandardMenuPopup.this.mPopup.show();
                    }
                }
                StandardMenuPopup.this.dismiss();
            }
        }
    };
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;
    private boolean mShowTitle;
    View mShownAnchorView;
    private ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    public final void addMenu(MenuBuilder menuBuilder) {
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = z;
        this.mAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.mOverflowOnly);
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        i = context.getResources();
        this.mPopupMaxWidth = Math.max(i.getDisplayMetrics().widthPixels / 2, i.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuBuilder.addMenuPresenter(this, context);
    }

    public final void setForceShowIcon(boolean z) {
        this.mAdapter.setForceShowIcon(z);
    }

    public final void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    private boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (!this.mWasDismissed) {
            if (this.mAnchorView != null) {
                this.mShownAnchorView = this.mAnchorView;
                this.mPopup.setOnDismissListener(this);
                this.mPopup.setOnItemClickListener(this);
                this.mPopup.setModal(true);
                View view = this.mShownAnchorView;
                boolean z = this.mTreeObserver == null;
                this.mTreeObserver = view.getViewTreeObserver();
                if (z) {
                    this.mTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
                view.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mPopup.setAnchorView(view);
                this.mPopup.setDropDownGravity(this.mDropDownGravity);
                if (!this.mHasContentWidth) {
                    this.mContentWidth = MenuPopup.measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
                    this.mHasContentWidth = true;
                }
                this.mPopup.setContentWidth(this.mContentWidth);
                this.mPopup.setInputMethodMode(2);
                this.mPopup.setEpicenterBounds(getEpicenterBounds());
                this.mPopup.show();
                ViewGroup listView = this.mPopup.getListView();
                listView.setOnKeyListener(this);
                if (this.mShowTitle && this.mMenu.getHeaderTitle() != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.mMenu.getHeaderTitle());
                    }
                    frameLayout.setEnabled(false);
                    listView.addHeaderView(frameLayout, null, false);
                }
                this.mPopup.setAdapter(this.mAdapter);
                this.mPopup.show();
                return true;
            }
        }
        return false;
    }

    public final void show() {
        if (!tryShow()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public final void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public final boolean isShowing() {
        return !this.mWasDismissed && this.mPopup.isShowing();
    }

    public final void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (!this.mTreeObserver.isAlive()) {
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss();
        }
    }

    public final void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        if (this.mAdapter) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public final void setCallback(Callback callback) {
        this.mPresenterCallback = callback;
    }

    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
            menuPopupHelper.setPresenterCallback(this.mPresenterCallback);
            menuPopupHelper.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(subMenuBuilder));
            menuPopupHelper.setGravity(this.mDropDownGravity);
            menuPopupHelper.setOnDismissListener(this.mOnDismissListener);
            this.mOnDismissListener = null;
            this.mMenu.close(false);
            if (menuPopupHelper.tryShow(this.mPopup.getHorizontalOffset(), this.mPopup.getVerticalOffset())) {
                if (this.mPresenterCallback != null) {
                    this.mPresenterCallback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public final void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return null;
        }
        dismiss();
        return true;
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final ListView getListView() {
        return this.mPopup.getListView();
    }

    public final void setHorizontalOffset(int i) {
        this.mPopup.setHorizontalOffset(i);
    }

    public final void setVerticalOffset(int i) {
        this.mPopup.setVerticalOffset(i);
    }

    public final void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }
}
