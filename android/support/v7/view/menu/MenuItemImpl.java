package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView.ItemView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded = false;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint = false;
    private OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private int mShowAsAction = 0;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.mMenu = menuBuilder;
        this.mId = i2;
        this.mGroup = i;
        this.mCategoryOrder = i3;
        this.mOrdering = i4;
        this.mTitle = charSequence;
        this.mShowAsAction = i5;
    }

    public final boolean invoke() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.mClickListener;
        r1 = 1;
        if (r0 == 0) goto L_0x000e;
    L_0x0005:
        r0 = r3.mClickListener;
        r0 = r0.onMenuItemClick(r3);
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = r3.mMenu;
        r2 = r3.mMenu;
        r0 = r0.dispatchMenuItemSelected(r2, r3);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r3.mItemCallback;
        if (r0 == 0) goto L_0x0023;
    L_0x001d:
        r0 = r3.mItemCallback;
        r0.run();
        return r1;
    L_0x0023:
        r0 = r3.mIntent;
        if (r0 == 0) goto L_0x0033;
    L_0x0027:
        r0 = r3.mMenu;	 Catch:{ ActivityNotFoundException -> 0x0033 }
        r0 = r0.getContext();	 Catch:{ ActivityNotFoundException -> 0x0033 }
        r2 = r3.mIntent;	 Catch:{ ActivityNotFoundException -> 0x0033 }
        r0.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0033 }
        return r1;
    L_0x0033:
        r0 = r3.mActionProvider;
        if (r0 == 0) goto L_0x0040;
    L_0x0037:
        r0 = r3.mActionProvider;
        r0 = r0.onPerformDefaultAction();
        if (r0 == 0) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.MenuItemImpl.invoke():boolean");
    }

    public final boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final int getGroupId() {
        return this.mGroup;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.mCategoryOrder;
    }

    public final int getOrdering() {
        return this.mOrdering;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    final Runnable getCallback() {
        return this.mItemCallback;
    }

    public final MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.mShortcutAlphabeticChar == c) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.mShortcutAlphabeticChar == c && this.mShortcutAlphabeticModifiers == i) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i);
        this.mMenu.onItemsChanged(0);
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public final char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public final int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.mShortcutNumericChar == c) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.mShortcutNumericChar == c && this.mShortcutNumericModifiers == i) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        this.mMenu.onItemsChanged(0);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.mShortcutNumericChar = c;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged('\u0000');
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i2);
        this.mMenu.onItemsChanged('\u0000');
        return this;
    }

    final char getShortcut() {
        return this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
    }

    final String getShortcutLabel() {
        char shortcut = getShortcut();
        if (shortcut == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(sPrependShortcutLabel);
        if (shortcut == '\b') {
            stringBuilder.append(sDeleteShortcutLabel);
        } else if (shortcut == '\n') {
            stringBuilder.append(sEnterShortcutLabel);
        } else if (shortcut != ' ') {
            stringBuilder.append(shortcut);
        } else {
            stringBuilder.append(sSpaceShortcutLabel);
        }
        return stringBuilder.toString();
    }

    final boolean shouldShowShortcut() {
        return this.mMenu.isShortcutsVisible() && getShortcut() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public final boolean hasSubMenu() {
        return this.mSubMenu != null;
    }

    public final void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.mTitle;
    }

    final CharSequence getTitleForItemView(ItemView itemView) {
        if (itemView == null || itemView.prefersCondensedTitle() == null) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        if (this.mSubMenu != null) {
            this.mSubMenu.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.mMenu.getContext().getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed != null ? this.mTitleCondensed : this.mTitle;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.mIconDrawable != null) {
            return applyIconTintIfNecessary(this.mIconDrawable);
        }
        if (this.mIconResId == 0) {
            return null;
        }
        Drawable drawable = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        return applyIconTintIfNecessary(drawable);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.mIconDrawable = null;
        this.mIconResId = i;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.mHasIconTint) {
                DrawableCompat.setTintList(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat.setTintMode(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        boolean z2 = this.mFlags;
        this.mFlags = z | (this.mFlags & -2);
        if (z2 != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    public final void setExclusiveCheckable(boolean z) {
        this.mFlags = (z ? true : false) | (this.mFlags & -5);
    }

    public final boolean isExclusiveCheckable() {
        return (this.mFlags & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(this);
        } else {
            setCheckedInt(z);
        }
        return this;
    }

    final void setCheckedInt(boolean z) {
        boolean z2 = this.mFlags;
        this.mFlags = (z ? true : false) | (this.mFlags & -3);
        if (z2 != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }

    public final boolean isVisible() {
        return (this.mActionProvider == null || !this.mActionProvider.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.mActionProvider.isVisible();
    }

    final boolean setVisibleInt(boolean z) {
        boolean z2 = this.mFlags;
        this.mFlags = (z ? false : true) | (this.mFlags & -9);
        if (z2 != this.mFlags) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (setVisibleInt(z)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.mTitle != null ? this.mTitle.toString() : null;
    }

    final void setMenuInfo(ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public final void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public final boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public final boolean isActionButton() {
        return (this.mFlags & 32) == 32;
    }

    public final boolean requestsActionButton() {
        return (this.mShowAsAction & 1) == 1;
    }

    public final boolean requiresActionButton() {
        return (this.mShowAsAction & 2) == 2;
    }

    public final void setIsActionButton(boolean z) {
        if (z) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public final boolean showsTextAsAction() {
        return (this.mShowAsAction & 4) == 4;
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.mShowAsAction = i;
                this.mMenu.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public final SupportMenuItem setActionView(View view) {
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public final SupportMenuItem setActionView(int i) {
        Context context = this.mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final View getActionView() {
        if (this.mActionView != null) {
            return this.mActionView;
        }
        if (this.mActionProvider == null) {
            return null;
        }
        this.mActionView = this.mActionProvider.onCreateActionView(this);
        return this.mActionView;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    public final SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.mActionProvider != null) {
            this.mActionProvider.reset();
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        if (this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener(new VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    public final SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        if (this.mOnActionExpandListener != null) {
            if (!this.mOnActionExpandListener.onMenuItemActionExpand(this)) {
                return false;
            }
        }
        return this.mMenu.expandItemActionView(this);
    }

    public final boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        if (this.mOnActionExpandListener != null) {
            if (!this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
                return false;
            }
        }
        return this.mMenu.collapseItemActionView(this);
    }

    public final boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null && this.mActionProvider != null) {
            this.mActionView = this.mActionProvider.onCreateActionView(this);
        }
        if (this.mActionView != null) {
            return true;
        }
        return false;
    }

    public final void setActionViewExpanded(boolean z) {
        this.mIsActionViewExpanded = z;
        this.mMenu.onItemsChanged(false);
    }

    public final boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.mTooltipText;
    }
}
