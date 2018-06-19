package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
        private Method mMethod;
        private Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.mRealOwner = obj;
            obj = obj.getClass();
            try {
                this.mMethod = obj.getMethod(str, PARAM_TYPES);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(str);
                stringBuilder.append(" in class ");
                stringBuilder.append(obj.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, new Object[]{menuItem});
                return true;
            } catch (MenuItem menuItem2) {
                throw new RuntimeException(menuItem2);
            }
        }
    }

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList = null;
        private Mode itemIconTintMode = null;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public void readGroup(AttributeSet attributeSet) {
            attributeSet = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.groupId = attributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = attributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = attributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = attributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = attributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = attributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            attributeSet.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            attributeSet = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.itemId = attributeSet.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (attributeSet.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & SupportMenu.CATEGORY_MASK) | (attributeSet.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 65535);
            this.itemTitle = attributeSet.getText(R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = attributeSet.getText(R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = attributeSet.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(attributeSet.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = attributeSet.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(attributeSet.getString(R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = attributeSet.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (attributeSet.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.itemCheckable = attributeSet.getBoolean(R.styleable.MenuItem_android_checkable, false);
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = attributeSet.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.itemVisible = attributeSet.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = attributeSet.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = attributeSet.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = attributeSet.getString(R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = attributeSet.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = attributeSet.getString(R.styleable.MenuItem_actionViewClass);
            this.itemActionProviderClassName = attributeSet.getString(R.styleable.MenuItem_actionProviderClass);
            if ((this.itemActionProviderClassName != null) && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
            } else {
                this.itemActionProvider = null;
            }
            this.itemContentDescription = attributeSet.getText(R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = attributeSet.getText(R.styleable.MenuItem_tooltipText);
            if (attributeSet.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.itemIconTintMode = DrawableUtils.parseTintMode(attributeSet.getInt(R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
            } else {
                this.itemIconTintMode = null;
            }
            if (attributeSet.hasValue(R.styleable.MenuItem_iconTint)) {
                this.itemIconTintList = attributeSet.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.itemIconTintList = null;
            }
            attributeSet.recycle();
            this.itemAdded = false;
        }

        private char getShortcut(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private void setItem(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable > 0).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            if (this.itemShowAsAction >= 0) {
                menuItem.setShowAsAction(this.itemShowAsAction);
            }
            if (this.itemListenerMethodName != null) {
                if (SupportMenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
            }
            if (this.itemCheckable >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            if (this.itemActionViewClassName != null) {
                menuItem.setActionView((View) newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
                z = true;
            }
            if (this.itemActionViewLayout > 0 && !r2) {
                menuItem.setActionView(this.itemActionViewLayout);
            }
            if (this.itemActionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, this.itemActionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
            MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
            if (this.itemIconTintMode != null) {
                MenuItemCompat.setIconTintMode(menuItem, this.itemIconTintMode);
            }
            if (this.itemIconTintList != null) {
                MenuItemCompat.setIconTintList(menuItem, this.itemIconTintList);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private <T> T newInstance(java.lang.String r2, java.lang.Class<?>[] r3, java.lang.Object[] r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = android.support.v7.view.SupportMenuInflater.this;	 Catch:{ Exception -> 0x0019 }
            r0 = r0.mContext;	 Catch:{ Exception -> 0x0019 }
            r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x0019 }
            r2 = r0.loadClass(r2);	 Catch:{ Exception -> 0x0019 }
            r2 = r2.getConstructor(r3);	 Catch:{ Exception -> 0x0019 }
            r3 = 1;	 Catch:{ Exception -> 0x0019 }
            r2.setAccessible(r3);	 Catch:{ Exception -> 0x0019 }
            r2 = r2.newInstance(r4);	 Catch:{ Exception -> 0x0019 }
            return r2;
        L_0x0019:
            r2 = 0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.SupportMenuInflater.MenuState.newInstance(java.lang.String, java.lang.Class[], java.lang.Object[]):T");
        }
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof SupportMenu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                i = this.mContext.getResources().getLayout(i);
                try {
                    parseMenu(i, Xml.asAttributeSet(i), menu);
                    if (i != 0) {
                        i.close();
                        return;
                    }
                    return;
                } catch (XmlPullParserException e) {
                    menu = e;
                    Object obj = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (IOException e2) {
                    menu = e2;
                    xmlResourceParser = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (Throwable th) {
                    menu = th;
                    xmlResourceParser = i;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw menu;
                }
            } catch (XmlPullParserException e3) {
                menu = e3;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (IOException e4) {
                menu = e4;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (Throwable th2) {
                menu = th2;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw menu;
            }
        }
        super.inflate(i, menu);
    }

    private void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        menu = xmlPullParser.getEventType();
        while (menu != 2) {
            menu = xmlPullParser.next();
            if (menu == 1) {
                break;
            }
        }
        menu = xmlPullParser.getName();
        if (menu.equals(XML_MENU)) {
            menu = xmlPullParser.next();
            int i = menu;
            Object obj = null;
            menu = null;
            Menu menu2 = menu;
            while (menu == null) {
                String name;
                switch (i) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (menu2 != null) {
                            break;
                        }
                        name = xmlPullParser.getName();
                        if (!name.equals(XML_GROUP)) {
                            if (!name.equals(XML_ITEM)) {
                                if (!name.equals(XML_MENU)) {
                                    menu2 = 1;
                                    obj = name;
                                    break;
                                }
                                parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                                break;
                            }
                            menuState.readItem(attributeSet);
                            break;
                        }
                        menuState.readGroup(attributeSet);
                        break;
                    case 3:
                        name = xmlPullParser.getName();
                        if (menu2 == null || !name.equals(r6)) {
                            if (!name.equals(XML_GROUP)) {
                                if (!name.equals(XML_ITEM)) {
                                    if (!name.equals(XML_MENU)) {
                                        break;
                                    }
                                    menu = 1;
                                    break;
                                } else if (!menuState.hasAddedItem()) {
                                    if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                                        menuState.addSubMenuItem();
                                        break;
                                    } else {
                                        menuState.addItem();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            menuState.resetGroup();
                            break;
                        }
                        obj = null;
                        menu2 = null;
                        break;
                    default:
                        break;
                }
                i = xmlPullParser.next();
            }
            return;
        }
        attributeSet = new StringBuilder("Expecting menu, got ");
        attributeSet.append(menu);
        throw new RuntimeException(attributeSet.toString());
    }

    Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    private Object findRealOwner(Object obj) {
        while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return obj;
    }
}
