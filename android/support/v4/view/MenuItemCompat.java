package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.View;

public final class MenuItemCompat {
    static final MenuVersionImpl IMPL;
    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    final class AnonymousClass1 implements android.view.MenuItem.OnActionExpandListener {
        final /* synthetic */ OnActionExpandListener val$listener;

        AnonymousClass1(OnActionExpandListener onActionExpandListener) {
            this.val$listener = onActionExpandListener;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.val$listener.onMenuItemActionExpand(menuItem);
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.val$listener.onMenuItemActionCollapse(menuItem);
        }
    }

    interface MenuVersionImpl {
        int getAlphabeticModifiers(MenuItem menuItem);

        CharSequence getContentDescription(MenuItem menuItem);

        ColorStateList getIconTintList(MenuItem menuItem);

        Mode getIconTintMode(MenuItem menuItem);

        int getNumericModifiers(MenuItem menuItem);

        CharSequence getTooltipText(MenuItem menuItem);

        void setAlphabeticShortcut(MenuItem menuItem, char c, int i);

        void setContentDescription(MenuItem menuItem, CharSequence charSequence);

        void setIconTintList(MenuItem menuItem, ColorStateList colorStateList);

        void setIconTintMode(MenuItem menuItem, Mode mode);

        void setNumericShortcut(MenuItem menuItem, char c, int i);

        void setShortcut(MenuItem menuItem, char c, char c2, int i, int i2);

        void setTooltipText(MenuItem menuItem, CharSequence charSequence);
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static class MenuItemCompatBaseImpl implements MenuVersionImpl {
        public int getAlphabeticModifiers(MenuItem menuItem) {
            return 0;
        }

        public CharSequence getContentDescription(MenuItem menuItem) {
            return null;
        }

        public ColorStateList getIconTintList(MenuItem menuItem) {
            return null;
        }

        public Mode getIconTintMode(MenuItem menuItem) {
            return null;
        }

        public int getNumericModifiers(MenuItem menuItem) {
            return 0;
        }

        public CharSequence getTooltipText(MenuItem menuItem) {
            return null;
        }

        public void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
        }

        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        }

        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        }

        public void setIconTintMode(MenuItem menuItem, Mode mode) {
        }

        public void setNumericShortcut(MenuItem menuItem, char c, int i) {
        }

        public void setShortcut(MenuItem menuItem, char c, char c2, int i, int i2) {
        }

        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        }

        MenuItemCompatBaseImpl() {
        }
    }

    @RequiresApi(26)
    static class MenuItemCompatApi26Impl extends MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        public CharSequence getContentDescription(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        public CharSequence getTooltipText(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        public void setShortcut(MenuItem menuItem, char c, char c2, int i, int i2) {
            menuItem.setShortcut(c, c2, i, i2);
        }

        public void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        public int getAlphabeticModifiers(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        public void setNumericShortcut(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        public int getNumericModifiers(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        public ColorStateList getIconTintList(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        public void setIconTintMode(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        public Mode getIconTintMode(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            IMPL = new MenuItemCompatApi26Impl();
        } else {
            IMPL = new MenuItemCompatBaseImpl();
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider) : menuItem;
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).getSupportActionProvider() : null;
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new AnonymousClass1(onActionExpandListener));
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else {
            IMPL.setContentDescription(menuItem, charSequence);
        }
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        return IMPL.getContentDescription(menuItem);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else {
            IMPL.setTooltipText(menuItem, charSequence);
        }
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        return IMPL.getTooltipText(menuItem);
    }

    public static void setShortcut(MenuItem menuItem, char c, char c2, int i, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c, c2, i, i2);
        } else {
            IMPL.setShortcut(menuItem, c, c2, i, i2);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else {
            IMPL.setNumericShortcut(menuItem, c, i);
        }
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        return IMPL.getNumericModifiers(menuItem);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else {
            IMPL.setAlphabeticShortcut(menuItem, c, i);
        }
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        return IMPL.getAlphabeticModifiers(menuItem);
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            IMPL.setIconTintList(menuItem, colorStateList);
        }
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        return IMPL.getIconTintList(menuItem);
    }

    public static void setIconTintMode(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            IMPL.setIconTintMode(menuItem, mode);
        }
    }

    public static Mode getIconTintMode(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        return IMPL.getIconTintMode(menuItem);
    }

    private MenuItemCompat() {
    }
}
