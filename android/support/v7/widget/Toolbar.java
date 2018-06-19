package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(Callback callback) {
        }

        ExpandedActionViewMenuPresenter() {
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menuBuilder;
        }

        public void updateMenuView(boolean z) {
            if (this.mCurrentExpandedItem) {
                Object obj = null;
                if (this.mMenu) {
                    z = this.mMenu.size();
                    for (boolean z2 = false; z2 < z; z2++) {
                        if (this.mMenu.getItem(z2) == this.mCurrentExpandedItem) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
                menuBuilder = Toolbar.this.generateDefaultLayoutParams();
                menuBuilder.gravity = GravityCompat.START | (Toolbar.this.mButtonGravity & 112);
                menuBuilder.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(menuBuilder);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if ((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) != null) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if ((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) != null) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(null);
            return true;
        }
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = null;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = null;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = null;
        }

        void copyMarginsFromCompat(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != null ? true : null;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new android.support.v7.widget.ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return Toolbar.this.mOnMenuItemClickListener != null ? Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem) : null;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        context = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.mTitleTextAppearance = context.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = context.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = context.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = context.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        if (context.hasValue(R.styleable.Toolbar_titleMargins) != 0) {
            attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, attributeSet);
        }
        this.mTitleMarginBottom = attributeSet;
        this.mTitleMarginTop = attributeSet;
        this.mTitleMarginEnd = attributeSet;
        this.mTitleMarginStart = attributeSet;
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (attributeSet >= null) {
            this.mTitleMarginStart = attributeSet;
        }
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (attributeSet >= null) {
            this.mTitleMarginEnd = attributeSet;
        }
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (attributeSet >= null) {
            this.mTitleMarginTop = attributeSet;
        }
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (attributeSet >= null) {
            this.mTitleMarginBottom = attributeSet;
        }
        this.mMaxButtonHeight = context.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        attributeSet = context.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset = context.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = context.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = context.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (!(attributeSet == -2147483648 && dimensionPixelOffset == Integer.MIN_VALUE)) {
            this.mContentInsets.setRelative(attributeSet, dimensionPixelOffset);
        }
        this.mContentInsetStartWithNavigation = context.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = context.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = context.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = context.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = context.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = context.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.mPopupContext = getContext();
        setPopupTheme(context.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = context.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = context.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = context.getDrawable(R.styleable.Toolbar_logo);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = context.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text)) {
            setLogoDescription(text);
        }
        if (context.hasValue(R.styleable.Toolbar_titleTextColor) != null) {
            setTitleTextColor(context.getColor(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (context.hasValue(R.styleable.Toolbar_subtitleTextColor) != null) {
            setSubtitleTextColor(context.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        context.recycle();
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
                return;
            }
            this.mPopupContext = new ContextThemeWrapper(getContext(), i);
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        rtlSpacingHelper.setDirection(z);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(AppCompatResources.getDrawable(getContext(), i));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout = this.mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (this.mLogoView != null && isChildOrHidden(this.mLogoView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.mLogoView != null ? this.mLogoView.getDrawable() : null;
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && isChildOrHidden(this.mTitleTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && isChildOrHidden(this.mSubtitleTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.mTitleTextAppearance = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.mSubtitleTextAppearance = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.mTitleTextColor = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.mSubtitleTextColor = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(i);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        return this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : 0);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && isChildOrHidden(this.mNavButtonView)) {
            removeView(this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        return this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.END | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.setRelative(i, i2);
    }

    public int getContentInsetStart() {
        return this.mContentInsets != null ? this.mContentInsets.getStart() : 0;
    }

    public int getContentInsetEnd() {
        return this.mContentInsets != null ? this.mContentInsets.getEnd() : 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(i, i2);
    }

    public int getContentInsetLeft() {
        return this.mContentInsets != null ? this.mContentInsets.getLeft() : 0;
    }

    public int getContentInsetRight() {
        return this.mContentInsets != null ? this.mContentInsets.getRight() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.mContentInsetStartWithNavigation != Integer.MIN_VALUE) {
            return this.mContentInsetStartWithNavigation;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.mContentInsetEndWithActions != Integer.MIN_VALUE) {
            return this.mContentInsetEndWithActions;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.mMenuView != null) {
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != null && peekMenu.hasVisibleItems()) {
                i = 1;
                if (i == 0) {
                    return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
                }
                return getContentInsetEnd();
            }
        }
        i = 0;
        if (i == 0) {
            return getContentInsetEnd();
        }
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.START | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.START | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            layoutParams = (LayoutParams) layoutParams;
        } else {
            layoutParams = generateLayoutParams(layoutParams);
        }
        layoutParams.mViewType = 1;
        if (z && this.mExpandedActionView) {
            view.setLayoutParams(layoutParams);
            this.mHiddenViews.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu peekMenu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
            if (!(savedState.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || peekMenu == null)) {
                MenuItem findItem = peekMenu.findItem(savedState.expandedMenuItemId);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (savedState.isOverflowOpen != null) {
                postShowOverflowMenu();
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            motionEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && motionEvent == null) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            motionEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && motionEvent == null) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        i = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        i2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        i3 = MeasureSpec.getMode(i2);
        if (i3 != 1073741824 && i5 >= 0) {
            if (i3 != 0) {
                i5 = Math.min(MeasureSpec.getSize(i2), i5);
            }
            i2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(i, i2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredWidth;
        int max;
        int combineMeasuredStates;
        int measuredHeight;
        int combineMeasuredStates2;
        int[] iArr = this.mTempMargins;
        if (ViewUtils.isLayoutRtl(this)) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = 1;
            i3 = 0;
        }
        if (shouldLayout(r7.mNavButtonView)) {
            measureChildConstrained(r7.mNavButtonView, i, 0, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(r7.mNavButtonView);
            max = Math.max(0, r7.mNavButtonView.getMeasuredHeight() + getVerticalMargins(r7.mNavButtonView));
            combineMeasuredStates = View.combineMeasuredStates(0, r7.mNavButtonView.getMeasuredState());
        } else {
            measuredWidth = 0;
            max = measuredWidth;
            combineMeasuredStates = max;
        }
        if (shouldLayout(r7.mCollapseButtonView)) {
            measureChildConstrained(r7.mCollapseButtonView, i, 0, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(r7.mCollapseButtonView);
            max = Math.max(max, r7.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(r7.mCollapseButtonView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[i3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(r7.mMenuView)) {
            measureChildConstrained(r7.mMenuView, i, max2, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mMenuView.getMeasuredWidth() + getHorizontalMargins(r7.mMenuView);
            max = Math.max(max, r7.mMenuView.getMeasuredHeight() + getVerticalMargins(r7.mMenuView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mMenuView.getMeasuredState());
        } else {
            measuredWidth = 0;
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        i3 = max2 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[i4] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(r7.mExpandedActionView)) {
            i3 += measureChildCollapseMargins(r7.mExpandedActionView, i, i3, i2, 0, iArr);
            max = Math.max(max, r7.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(r7.mExpandedActionView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(r7.mLogoView)) {
            i3 += measureChildCollapseMargins(r7.mLogoView, i, i3, i2, 0, iArr);
            max = Math.max(max, r7.mLogoView.getMeasuredHeight() + getVerticalMargins(r7.mLogoView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mLogoView.getMeasuredState());
        }
        i4 = getChildCount();
        max2 = max;
        max = i3;
        for (i3 = 0; i3 < i4; i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                max += measureChildCollapseMargins(childAt, i, max, i2, 0, iArr);
                max2 = Math.max(max2, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, childAt.getMeasuredState());
            }
        }
        i3 = r7.mTitleMarginTop + r7.mTitleMarginBottom;
        i4 = r7.mTitleMarginStart + r7.mTitleMarginEnd;
        if (shouldLayout(r7.mTitleTextView)) {
            measureChildCollapseMargins(r7.mTitleTextView, i, max + i4, i2, i3, iArr);
            measuredWidth = r7.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(r7.mTitleTextView);
            measuredHeight = r7.mTitleTextView.getMeasuredHeight() + getVerticalMargins(r7.mTitleTextView);
            combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, r7.mTitleTextView.getMeasuredState());
            combineMeasuredStates = measuredWidth;
        } else {
            measuredHeight = 0;
            combineMeasuredStates2 = combineMeasuredStates;
            combineMeasuredStates = measuredHeight;
        }
        if (shouldLayout(r7.mSubtitleTextView)) {
            int i5 = measuredHeight + i3;
            i3 = combineMeasuredStates2;
            combineMeasuredStates = Math.max(combineMeasuredStates, measureChildCollapseMargins(r7.mSubtitleTextView, i, max + i4, i2, i5, iArr));
            measuredHeight += r7.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(r7.mSubtitleTextView);
            combineMeasuredStates2 = View.combineMeasuredStates(i3, r7.mSubtitleTextView.getMeasuredState());
        } else {
            i3 = combineMeasuredStates2;
        }
        max += combineMeasuredStates;
        measuredWidth = Math.max(max2, measuredHeight) + (getPaddingTop() + getPaddingBottom());
        int i6 = i;
        currentContentInsetStart = View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i6, -16777216 & combineMeasuredStates2);
        measuredWidth = View.resolveSizeAndState(Math.max(measuredWidth, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16);
        if (shouldCollapse()) {
            measuredWidth = 0;
        }
        setMeasuredDimension(currentContentInsetStart, measuredWidth);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int layoutChildRight;
        int currentContentInsetLeft;
        int currentContentInsetRight;
        int max;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i6;
        int i7;
        int i8;
        LayoutParams layoutParams;
        int i9;
        int i10;
        LayoutParams layoutParams2;
        Object obj;
        int i11;
        LayoutParams layoutParams3;
        int i12;
        Toolbar toolbar = this;
        int i13 = ViewCompat.getLayoutDirection(this) == 1 ? 1 : 0;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i14 = width - paddingRight;
        int[] iArr = toolbar.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        minimumHeight = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (!shouldLayout(toolbar.mNavButtonView)) {
            i5 = paddingLeft;
        } else if (i13 != 0) {
            layoutChildRight = layoutChildRight(toolbar.mNavButtonView, i14, iArr, minimumHeight);
            i5 = paddingLeft;
            if (shouldLayout(toolbar.mCollapseButtonView)) {
                if (i13 == 0) {
                    layoutChildRight = layoutChildRight(toolbar.mCollapseButtonView, layoutChildRight, iArr, minimumHeight);
                } else {
                    i5 = layoutChildLeft(toolbar.mCollapseButtonView, i5, iArr, minimumHeight);
                }
            }
            if (shouldLayout(toolbar.mMenuView)) {
                if (i13 == 0) {
                    i5 = layoutChildLeft(toolbar.mMenuView, i5, iArr, minimumHeight);
                } else {
                    layoutChildRight = layoutChildRight(toolbar.mMenuView, layoutChildRight, iArr, minimumHeight);
                }
            }
            currentContentInsetLeft = getCurrentContentInsetLeft();
            currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i5);
            iArr[1] = Math.max(0, currentContentInsetRight - (i14 - layoutChildRight));
            max = Math.max(i5, currentContentInsetLeft);
            i14 = Math.min(layoutChildRight, i14 - currentContentInsetRight);
            if (shouldLayout(toolbar.mExpandedActionView)) {
                if (i13 == 0) {
                    i14 = layoutChildRight(toolbar.mExpandedActionView, i14, iArr, minimumHeight);
                } else {
                    max = layoutChildLeft(toolbar.mExpandedActionView, max, iArr, minimumHeight);
                }
            }
            if (shouldLayout(toolbar.mLogoView)) {
                if (i13 == 0) {
                    i14 = layoutChildRight(toolbar.mLogoView, i14, iArr, minimumHeight);
                } else {
                    max = layoutChildLeft(toolbar.mLogoView, max, iArr, minimumHeight);
                }
            }
            shouldLayout = shouldLayout(toolbar.mTitleTextView);
            shouldLayout2 = shouldLayout(toolbar.mSubtitleTextView);
            if (shouldLayout) {
                i6 = paddingRight;
                i7 = 0;
            } else {
                LayoutParams layoutParams4 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
                i6 = paddingRight;
                i7 = ((layoutParams4.topMargin + toolbar.mTitleTextView.getMeasuredHeight()) + layoutParams4.bottomMargin) + 0;
            }
            if (shouldLayout2) {
                i8 = width;
            } else {
                layoutParams = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
                i8 = width;
                i7 += (layoutParams.topMargin + toolbar.mSubtitleTextView.getMeasuredHeight()) + layoutParams.bottomMargin;
            }
            if (!shouldLayout) {
                if (shouldLayout2) {
                    i9 = paddingLeft;
                    i10 = minimumHeight;
                    paddingRight = 0;
                    addCustomViewsWithGravity(toolbar.mTempViews, 3);
                    i13 = toolbar.mTempViews.size();
                    i7 = max;
                    for (max = paddingRight; max < i13; max++) {
                        i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
                    }
                    minimumHeight = i10;
                    addCustomViewsWithGravity(toolbar.mTempViews, 5);
                    i13 = toolbar.mTempViews.size();
                    for (max = paddingRight; max < i13; max++) {
                        i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
                    }
                    addCustomViewsWithGravity(toolbar.mTempViews, 1);
                    i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
                    max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
                    i13 += max;
                    if (max < i7) {
                        i7 = i13 <= i14 ? max - (i13 - i14) : max;
                    }
                    i13 = toolbar.mTempViews.size();
                    while (paddingRight < i13) {
                        i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
                        paddingRight++;
                    }
                    toolbar.mTempViews.clear();
                }
            }
            layoutParams2 = (LayoutParams) (shouldLayout ? toolbar.mTitleTextView : toolbar.mSubtitleTextView).getLayoutParams();
            layoutParams = (LayoutParams) (shouldLayout2 ? toolbar.mSubtitleTextView : toolbar.mTitleTextView).getLayoutParams();
            if ((shouldLayout || toolbar.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || toolbar.mSubtitleTextView.getMeasuredWidth() <= 0)) {
                i9 = paddingLeft;
                obj = null;
            } else {
                i9 = paddingLeft;
                obj = 1;
            }
            paddingLeft = toolbar.mGravity & 112;
            i10 = minimumHeight;
            if (paddingLeft != 48) {
                i11 = max;
                paddingTop = (getPaddingTop() + layoutParams2.topMargin) + toolbar.mTitleMarginTop;
            } else if (paddingLeft == 80) {
                paddingLeft = (((height - paddingTop) - paddingBottom) - i7) / 2;
                i11 = max;
                if (paddingLeft >= layoutParams2.topMargin + toolbar.mTitleMarginTop) {
                    paddingLeft = layoutParams2.topMargin + toolbar.mTitleMarginTop;
                } else {
                    height = (((height - paddingBottom) - i7) - paddingLeft) - paddingTop;
                    if (height < layoutParams2.bottomMargin + toolbar.mTitleMarginBottom) {
                        paddingLeft = Math.max(0, paddingLeft - ((layoutParams.bottomMargin + toolbar.mTitleMarginBottom) - height));
                    }
                }
                paddingTop += paddingLeft;
            } else {
                i11 = max;
                paddingTop = (((height - paddingBottom) - layoutParams.bottomMargin) - toolbar.mTitleMarginBottom) - i7;
            }
            if (i13 == 0) {
                if (obj == null) {
                    i7 = toolbar.mTitleMarginStart;
                    i13 = 1;
                } else {
                    i13 = 1;
                    i7 = 0;
                }
                i7 -= iArr[i13];
                i14 -= Math.max(0, i7);
                iArr[i13] = Math.max(0, -i7);
                if (shouldLayout) {
                    max = i14;
                } else {
                    layoutParams3 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
                    max = i14 - toolbar.mTitleTextView.getMeasuredWidth();
                    i7 = toolbar.mTitleTextView.getMeasuredHeight() + paddingTop;
                    toolbar.mTitleTextView.layout(max, paddingTop, i14, i7);
                    max -= toolbar.mTitleMarginEnd;
                    paddingTop = i7 + layoutParams3.bottomMargin;
                }
                if (shouldLayout2) {
                    i7 = i14;
                } else {
                    layoutParams3 = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
                    paddingTop += layoutParams3.topMargin;
                    toolbar.mSubtitleTextView.layout(i14 - toolbar.mSubtitleTextView.getMeasuredWidth(), paddingTop, i14, toolbar.mSubtitleTextView.getMeasuredHeight() + paddingTop);
                    i7 = i14 - toolbar.mTitleMarginEnd;
                    i13 = layoutParams3.bottomMargin;
                }
                if (obj != null) {
                    i14 = Math.min(max, i7);
                }
                max = i11;
                paddingRight = 0;
                addCustomViewsWithGravity(toolbar.mTempViews, 3);
                i13 = toolbar.mTempViews.size();
                i7 = max;
                for (max = paddingRight; max < i13; max++) {
                    i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
                }
                minimumHeight = i10;
                addCustomViewsWithGravity(toolbar.mTempViews, 5);
                i13 = toolbar.mTempViews.size();
                for (max = paddingRight; max < i13; max++) {
                    i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
                }
                addCustomViewsWithGravity(toolbar.mTempViews, 1);
                i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
                max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
                i13 += max;
                if (max < i7) {
                    if (i13 <= i14) {
                    }
                }
                i13 = toolbar.mTempViews.size();
                while (paddingRight < i13) {
                    i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
                    paddingRight++;
                }
                toolbar.mTempViews.clear();
            }
            if (obj == null) {
                i12 = toolbar.mTitleMarginStart;
                paddingRight = 0;
            } else {
                paddingRight = 0;
                i12 = 0;
            }
            i13 = i12 - iArr[paddingRight];
            max = i11 + Math.max(paddingRight, i13);
            iArr[paddingRight] = Math.max(paddingRight, -i13);
            if (shouldLayout) {
                i7 = max;
            } else {
                layoutParams3 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
                i7 = toolbar.mTitleTextView.getMeasuredWidth() + max;
                width = toolbar.mTitleTextView.getMeasuredHeight() + paddingTop;
                toolbar.mTitleTextView.layout(max, paddingTop, i7, width);
                i7 += toolbar.mTitleMarginEnd;
                paddingTop = width + layoutParams3.bottomMargin;
            }
            if (shouldLayout2) {
                width = max;
            } else {
                layoutParams3 = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
                paddingTop += layoutParams3.topMargin;
                width = toolbar.mSubtitleTextView.getMeasuredWidth() + max;
                toolbar.mSubtitleTextView.layout(max, paddingTop, width, toolbar.mSubtitleTextView.getMeasuredHeight() + paddingTop);
                width += toolbar.mTitleMarginEnd;
                i13 = layoutParams3.bottomMargin;
            }
            if (obj != null) {
                max = Math.max(i7, width);
            }
            addCustomViewsWithGravity(toolbar.mTempViews, 3);
            i13 = toolbar.mTempViews.size();
            i7 = max;
            for (max = paddingRight; max < i13; max++) {
                i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
            }
            minimumHeight = i10;
            addCustomViewsWithGravity(toolbar.mTempViews, 5);
            i13 = toolbar.mTempViews.size();
            for (max = paddingRight; max < i13; max++) {
                i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
            }
            addCustomViewsWithGravity(toolbar.mTempViews, 1);
            i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
            max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
            i13 += max;
            if (max < i7) {
                if (i13 <= i14) {
                }
            }
            i13 = toolbar.mTempViews.size();
            while (paddingRight < i13) {
                i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
                paddingRight++;
            }
            toolbar.mTempViews.clear();
        } else {
            i5 = layoutChildLeft(toolbar.mNavButtonView, paddingLeft, iArr, minimumHeight);
        }
        layoutChildRight = i14;
        if (shouldLayout(toolbar.mCollapseButtonView)) {
            if (i13 == 0) {
                i5 = layoutChildLeft(toolbar.mCollapseButtonView, i5, iArr, minimumHeight);
            } else {
                layoutChildRight = layoutChildRight(toolbar.mCollapseButtonView, layoutChildRight, iArr, minimumHeight);
            }
        }
        if (shouldLayout(toolbar.mMenuView)) {
            if (i13 == 0) {
                layoutChildRight = layoutChildRight(toolbar.mMenuView, layoutChildRight, iArr, minimumHeight);
            } else {
                i5 = layoutChildLeft(toolbar.mMenuView, i5, iArr, minimumHeight);
            }
        }
        currentContentInsetLeft = getCurrentContentInsetLeft();
        currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - (i14 - layoutChildRight));
        max = Math.max(i5, currentContentInsetLeft);
        i14 = Math.min(layoutChildRight, i14 - currentContentInsetRight);
        if (shouldLayout(toolbar.mExpandedActionView)) {
            if (i13 == 0) {
                max = layoutChildLeft(toolbar.mExpandedActionView, max, iArr, minimumHeight);
            } else {
                i14 = layoutChildRight(toolbar.mExpandedActionView, i14, iArr, minimumHeight);
            }
        }
        if (shouldLayout(toolbar.mLogoView)) {
            if (i13 == 0) {
                max = layoutChildLeft(toolbar.mLogoView, max, iArr, minimumHeight);
            } else {
                i14 = layoutChildRight(toolbar.mLogoView, i14, iArr, minimumHeight);
            }
        }
        shouldLayout = shouldLayout(toolbar.mTitleTextView);
        shouldLayout2 = shouldLayout(toolbar.mSubtitleTextView);
        if (shouldLayout) {
            i6 = paddingRight;
            i7 = 0;
        } else {
            LayoutParams layoutParams42 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
            i6 = paddingRight;
            i7 = ((layoutParams42.topMargin + toolbar.mTitleTextView.getMeasuredHeight()) + layoutParams42.bottomMargin) + 0;
        }
        if (shouldLayout2) {
            i8 = width;
        } else {
            layoutParams = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
            i8 = width;
            i7 += (layoutParams.topMargin + toolbar.mSubtitleTextView.getMeasuredHeight()) + layoutParams.bottomMargin;
        }
        if (shouldLayout) {
            if (shouldLayout2) {
                i9 = paddingLeft;
                i10 = minimumHeight;
                paddingRight = 0;
                addCustomViewsWithGravity(toolbar.mTempViews, 3);
                i13 = toolbar.mTempViews.size();
                i7 = max;
                for (max = paddingRight; max < i13; max++) {
                    i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
                }
                minimumHeight = i10;
                addCustomViewsWithGravity(toolbar.mTempViews, 5);
                i13 = toolbar.mTempViews.size();
                for (max = paddingRight; max < i13; max++) {
                    i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
                }
                addCustomViewsWithGravity(toolbar.mTempViews, 1);
                i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
                max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
                i13 += max;
                if (max < i7) {
                    if (i13 <= i14) {
                    }
                }
                i13 = toolbar.mTempViews.size();
                while (paddingRight < i13) {
                    i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
                    paddingRight++;
                }
                toolbar.mTempViews.clear();
            }
        }
        if (shouldLayout) {
        }
        if (shouldLayout2) {
        }
        layoutParams2 = (LayoutParams) (shouldLayout ? toolbar.mTitleTextView : toolbar.mSubtitleTextView).getLayoutParams();
        layoutParams = (LayoutParams) (shouldLayout2 ? toolbar.mSubtitleTextView : toolbar.mTitleTextView).getLayoutParams();
        if (shouldLayout) {
        }
        i9 = paddingLeft;
        obj = null;
        paddingLeft = toolbar.mGravity & 112;
        i10 = minimumHeight;
        if (paddingLeft != 48) {
            i11 = max;
            paddingTop = (getPaddingTop() + layoutParams2.topMargin) + toolbar.mTitleMarginTop;
        } else if (paddingLeft == 80) {
            i11 = max;
            paddingTop = (((height - paddingBottom) - layoutParams.bottomMargin) - toolbar.mTitleMarginBottom) - i7;
        } else {
            paddingLeft = (((height - paddingTop) - paddingBottom) - i7) / 2;
            i11 = max;
            if (paddingLeft >= layoutParams2.topMargin + toolbar.mTitleMarginTop) {
                height = (((height - paddingBottom) - i7) - paddingLeft) - paddingTop;
                if (height < layoutParams2.bottomMargin + toolbar.mTitleMarginBottom) {
                    paddingLeft = Math.max(0, paddingLeft - ((layoutParams.bottomMargin + toolbar.mTitleMarginBottom) - height));
                }
            } else {
                paddingLeft = layoutParams2.topMargin + toolbar.mTitleMarginTop;
            }
            paddingTop += paddingLeft;
        }
        if (i13 == 0) {
            if (obj == null) {
                paddingRight = 0;
                i12 = 0;
            } else {
                i12 = toolbar.mTitleMarginStart;
                paddingRight = 0;
            }
            i13 = i12 - iArr[paddingRight];
            max = i11 + Math.max(paddingRight, i13);
            iArr[paddingRight] = Math.max(paddingRight, -i13);
            if (shouldLayout) {
                i7 = max;
            } else {
                layoutParams3 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
                i7 = toolbar.mTitleTextView.getMeasuredWidth() + max;
                width = toolbar.mTitleTextView.getMeasuredHeight() + paddingTop;
                toolbar.mTitleTextView.layout(max, paddingTop, i7, width);
                i7 += toolbar.mTitleMarginEnd;
                paddingTop = width + layoutParams3.bottomMargin;
            }
            if (shouldLayout2) {
                width = max;
            } else {
                layoutParams3 = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
                paddingTop += layoutParams3.topMargin;
                width = toolbar.mSubtitleTextView.getMeasuredWidth() + max;
                toolbar.mSubtitleTextView.layout(max, paddingTop, width, toolbar.mSubtitleTextView.getMeasuredHeight() + paddingTop);
                width += toolbar.mTitleMarginEnd;
                i13 = layoutParams3.bottomMargin;
            }
            if (obj != null) {
                max = Math.max(i7, width);
            }
            addCustomViewsWithGravity(toolbar.mTempViews, 3);
            i13 = toolbar.mTempViews.size();
            i7 = max;
            for (max = paddingRight; max < i13; max++) {
                i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
            }
            minimumHeight = i10;
            addCustomViewsWithGravity(toolbar.mTempViews, 5);
            i13 = toolbar.mTempViews.size();
            for (max = paddingRight; max < i13; max++) {
                i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
            }
            addCustomViewsWithGravity(toolbar.mTempViews, 1);
            i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
            max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
            i13 += max;
            if (max < i7) {
                if (i13 <= i14) {
                }
            }
            i13 = toolbar.mTempViews.size();
            while (paddingRight < i13) {
                i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
                paddingRight++;
            }
            toolbar.mTempViews.clear();
        }
        if (obj == null) {
            i13 = 1;
            i7 = 0;
        } else {
            i7 = toolbar.mTitleMarginStart;
            i13 = 1;
        }
        i7 -= iArr[i13];
        i14 -= Math.max(0, i7);
        iArr[i13] = Math.max(0, -i7);
        if (shouldLayout) {
            max = i14;
        } else {
            layoutParams3 = (LayoutParams) toolbar.mTitleTextView.getLayoutParams();
            max = i14 - toolbar.mTitleTextView.getMeasuredWidth();
            i7 = toolbar.mTitleTextView.getMeasuredHeight() + paddingTop;
            toolbar.mTitleTextView.layout(max, paddingTop, i14, i7);
            max -= toolbar.mTitleMarginEnd;
            paddingTop = i7 + layoutParams3.bottomMargin;
        }
        if (shouldLayout2) {
            i7 = i14;
        } else {
            layoutParams3 = (LayoutParams) toolbar.mSubtitleTextView.getLayoutParams();
            paddingTop += layoutParams3.topMargin;
            toolbar.mSubtitleTextView.layout(i14 - toolbar.mSubtitleTextView.getMeasuredWidth(), paddingTop, i14, toolbar.mSubtitleTextView.getMeasuredHeight() + paddingTop);
            i7 = i14 - toolbar.mTitleMarginEnd;
            i13 = layoutParams3.bottomMargin;
        }
        if (obj != null) {
            i14 = Math.min(max, i7);
        }
        max = i11;
        paddingRight = 0;
        addCustomViewsWithGravity(toolbar.mTempViews, 3);
        i13 = toolbar.mTempViews.size();
        i7 = max;
        for (max = paddingRight; max < i13; max++) {
            i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
        }
        minimumHeight = i10;
        addCustomViewsWithGravity(toolbar.mTempViews, 5);
        i13 = toolbar.mTempViews.size();
        for (max = paddingRight; max < i13; max++) {
            i14 = layoutChildRight((View) toolbar.mTempViews.get(max), i14, iArr, minimumHeight);
        }
        addCustomViewsWithGravity(toolbar.mTempViews, 1);
        i13 = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
        max = (i9 + (((i8 - i9) - i6) / 2)) - (i13 / 2);
        i13 += max;
        if (max < i7) {
            if (i13 <= i14) {
            }
        }
        i13 = toolbar.mTempViews.size();
        while (paddingRight < i13) {
            i7 = layoutChildLeft((View) toolbar.mTempViews.get(paddingRight), i7, iArr, minimumHeight);
            paddingRight++;
        }
        toolbar.mTempViews.clear();
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        iArr = iArr[1];
        int size = list.size();
        int i2 = iArr;
        iArr = null;
        int i3 = iArr;
        while (iArr < size) {
            View view = (View) list.get(iArr);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i4 = layoutParams.leftMargin - i;
            i = layoutParams.rightMargin - i2;
            i2 = Math.max(0, i4);
            int max = Math.max(0, i);
            i4 = Math.max(0, -i4);
            i3 += (i2 + view.getMeasuredWidth()) + max;
            iArr++;
            i2 = Math.max(0, -i);
            i = i4;
        }
        return i3;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        i += Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        iArr = getChildTop(view, i2);
        i2 = view.getMeasuredWidth();
        view.layout(i, iArr, i + i2, view.getMeasuredHeight() + iArr);
        return i + (i2 + layoutParams.rightMargin);
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        i -= Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        iArr = getChildTop(view, i2);
        i2 = view.getMeasuredWidth();
        view.layout(i - i2, iArr, i, view.getMeasuredHeight() + iArr);
        return i - (i2 + layoutParams.leftMargin);
    }

    private int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view = view.getMeasuredHeight();
        i = i > 0 ? (view - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - view) - layoutParams.bottomMargin) - i;
        }
        i = getPaddingTop();
        childVerticalGravity = getPaddingBottom();
        int height = getHeight();
        int i2 = (((height - i) - childVerticalGravity) - view) / 2;
        if (i2 < layoutParams.topMargin) {
            i2 = layoutParams.topMargin;
        } else {
            height = (((height - childVerticalGravity) - view) - i2) - i;
            if (height < layoutParams.bottomMargin) {
                i2 = Math.max(0, i2 - (layoutParams.bottomMargin - height));
            }
        }
        return i + i2;
    }

    private int getChildVerticalGravity(int i) {
        i &= 112;
        return (i == 16 || i == 48 || i == 80) ? i : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        int i2 = 0;
        int i3 = ViewCompat.getLayoutDirection(this) == 1 ? 1 : 0;
        int childCount = getChildCount();
        i = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        View childAt;
        if (i3 != 0) {
            for (childCount--; childCount >= 0; childCount--) {
                childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == i) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i2 < childCount) {
            childAt = getChildAt(i2);
            LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams2.gravity) == i) {
                list.add(childAt);
            }
            i2++;
        }
    }

    private int getChildHorizontalGravity(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        i = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        if (i == 1 || i == 3 || i == 5) {
            return i;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? null : true;
    }

    private int getHorizontalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!super.checkLayoutParams(layoutParams) || (layoutParams instanceof LayoutParams) == null) ? null : true;
    }

    private static boolean isCustomView(View view) {
        return ((LayoutParams) view.getLayoutParams()).mViewType == null ? true : null;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView((View) this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View view) {
        if (view.getParent() != this) {
            if (this.mHiddenViews.contains(view) == null) {
                return null;
            }
        }
        return true;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setMenuCallbacks(Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        if (this.mMenuView != null) {
            this.mMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }
}
