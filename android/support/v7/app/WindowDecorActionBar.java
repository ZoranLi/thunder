package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations = true;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (!(WindowDecorActionBar.this.mContentAnimations == null || WindowDecorActionBar.this.mContentView == null)) {
                WindowDecorActionBar.this.mContentView.setTranslationY(0.0f);
                WindowDecorActionBar.this.mContainerView.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar.this.mCurrentShowAnim = null;
            WindowDecorActionBar.this.completeDeferredDestroyActionMode();
            if (WindowDecorActionBar.this.mOverlayLayout != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.mOverlayLayout);
            }
        }
    };
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    private boolean mNowShowing = true;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            WindowDecorActionBar.this.mCurrentShowAnim = null;
            WindowDecorActionBar.this.mContainerView.requestLayout();
        }
    };
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs = new ArrayList();
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
        }
    };

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public ActionModeImpl(Context context, Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                if (WindowDecorActionBar.checkShowingFlags(WindowDecorActionBar.this.mHiddenByApp, WindowDecorActionBar.this.mHiddenBySystem, false)) {
                    this.mCallback.onDestroyActionMode(this);
                } else {
                    WindowDecorActionBar.this.mDeferredDestroyActionMode = this;
                    WindowDecorActionBar.this.mDeferredModeDestroyCallback = this.mCallback;
                }
                this.mCallback = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.mContextView.closeMode();
                WindowDecorActionBar.this.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.mOverlayLayout.setHideOnContentScrollEnabled(WindowDecorActionBar.this.mHideOnContentScroll);
                WindowDecorActionBar.this.mActionMode = null;
            }
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean onCreateActionMode = this.mCallback.onCreateActionMode(this, this.mMenu);
                return onCreateActionMode;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        public void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.mContextView.setTitleOptional(z);
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.isTitleOptional();
        }

        public View getCustomView() {
            return this.mCustomView != null ? (View) this.mCustomView.get() : null;
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.mCallback != null ? this.mCallback.onActionItemClicked(this, menuItem) : null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return null;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                WindowDecorActionBar.this.mContextView.showOverflowMenu();
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public Object getTag() {
            return this.mTag;
        }

        public Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public Tab setTabListener(TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= null) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, null));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            if (this.mPosition >= null) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, i));
        }

        public Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            if (this.mPosition >= null) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setText(int i) {
            return setText(WindowDecorActionBar.this.mContext.getResources().getText(i));
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(i));
        }

        public Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            if (this.mPosition >= null) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    static boolean checkShowingFlags(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (!z) {
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    public void onContentScrollStopped() {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.mActivity = activity;
        activity = activity.getWindow().getDecorView();
        init(activity);
        if (!z) {
            this.mContentView = activity.findViewById(true);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.mDialog = dialog;
        init(dialog.getWindow().getDecorView());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public WindowDecorActionBar(View view) {
        init(view);
    }

    private void init(View view) {
        this.mOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.mOverlayLayout != null) {
            this.mOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.mDecorToolbar = getDecorToolbar(view.findViewById(R.id.action_bar));
        this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.mContainerView = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        if (!(this.mDecorToolbar == null || this.mContextView == null)) {
            if (this.mContainerView != null) {
                int dimensionPixelSize;
                this.mContext = this.mDecorToolbar.getContext();
                view = (this.mDecorToolbar.getDisplayOptions() & 4) != null ? 1 : null;
                if (view != null) {
                    this.mDisplayHomeAsUpSet = true;
                }
                ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
                if (!actionBarPolicy.enableHomeButtonByDefault()) {
                    if (view == null) {
                        view = null;
                        setHomeButtonEnabled(view);
                        setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
                        view = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
                        if (view.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
                            setHideOnContentScrollEnabled(true);
                        }
                        dimensionPixelSize = view.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
                        if (dimensionPixelSize != 0) {
                            setElevation((float) dimensionPixelSize);
                        }
                        view.recycle();
                        return;
                    }
                }
                view = 1;
                setHomeButtonEnabled(view);
                setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
                view = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
                if (view.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
                    setHideOnContentScrollEnabled(true);
                }
                dimensionPixelSize = view.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
                if (dimensionPixelSize != 0) {
                    setElevation((float) dimensionPixelSize);
                }
                view.recycle();
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" can only be used with a compatible window decor layout");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
        stringBuilder.append(view);
        throw new IllegalStateException(stringBuilder.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.mContainerView, f);
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mContainerView);
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void setHasEmbeddedTabs(boolean z) {
        this.mHasEmbeddedTabs = z;
        if (this.mHasEmbeddedTabs) {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        } else {
            this.mDecorToolbar.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        boolean z2 = true;
        z = getNavigationMode();
        if (this.mTabScrollView != null) {
            if (z) {
                this.mTabScrollView.setVisibility(0);
                if (this.mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(this.mOverlayLayout);
                }
            } else {
                this.mTabScrollView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        boolean z3 = !this.mHasEmbeddedTabs && z;
        decorToolbar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !z) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(0);
                this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.mOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(this.mOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.mContainerView.setTabContainer(scrollingTabContainerView);
            }
            this.mTabScrollView = scrollingTabContainerView;
        }
    }

    void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void onWindowVisibilityChanged(int i) {
        this.mCurWindowVisibility = i;
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.mShowHideAnimationEnabled = z;
        if (!z && this.mCurrentShowAnim) {
            this.mCurrentShowAnim.cancel();
        }
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z, 1);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? true : false, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? true : false, 4);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? true : false, 8);
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? true : false, 16);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mDecorToolbar.setHomeButtonEnabled(z);
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.mDecorToolbar.getNavigationMode()) {
            case 1:
                this.mDecorToolbar.setDropdownSelectedPosition(i);
                return;
            case 2:
                selectTab((Tab) this.mTabs.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((i & i2) | ((i2 ^ -1) & displayOptions));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public ActionMode startActionMode(Callback callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionMode actionModeImpl = new ActionModeImpl(this.mContextView.getContext(), callback);
        if (actionModeImpl.dispatchOnCreate() == null) {
            return null;
        }
        this.mActionMode = actionModeImpl;
        actionModeImpl.invalidate();
        this.mContextView.initForMode(actionModeImpl);
        animateToMode(true);
        this.mContextView.sendAccessibilityEvent(32);
        return actionModeImpl;
    }

    private void configureTab(Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.mTabs.add(i, tabImpl);
        tab = this.mTabs.size();
        while (true) {
            i++;
            if (i < tab) {
                ((TabImpl) this.mTabs.get(i)).setPosition(i);
            } else {
                return;
            }
        }
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(Tab tab, int i, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, i, z);
        configureTab(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public Tab newTab() {
        return new TabImpl();
    }

    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.mTabScrollView != null) {
            int position = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(i);
            TabImpl tabImpl = (TabImpl) this.mTabs.remove(i);
            if (tabImpl != null) {
                tabImpl.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i2 = i; i2 < size; i2++) {
                ((TabImpl) this.mTabs.get(i2)).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.mTabs.isEmpty() ? 0 : (TabImpl) this.mTabs.get(Math.max(0, i - 1)));
            }
        }
    }

    public void selectTab(Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.mSavedTabPosition = i;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.mActivity instanceof FragmentActivity) || this.mDecorToolbar.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, disallowAddToBackStack);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, disallowAddToBackStack);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, disallowAddToBackStack);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack != null && disallowAddToBackStack.isEmpty() == null) {
            disallowAddToBackStack.commit();
        }
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void enableContentAnimations(boolean z) {
        this.mContentAnimations = z;
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            if (this.mOverlayLayout != null) {
                this.mOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            if (this.mOverlayLayout != null) {
                this.mOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (!z || this.mOverlayLayout.isInOverlayMode()) {
            this.mHideOnContentScroll = z;
            this.mOverlayLayout.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public void setHideOffset(int i) {
        if (i == 0 || this.mOverlayLayout.isInOverlayMode()) {
            this.mOverlayLayout.setActionBarHideOffset(i);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    private void updateVisibility(boolean z) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doShow(boolean r5) {
        /*
        r4 = this;
        r0 = r4.mCurrentShowAnim;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r4.mCurrentShowAnim;
        r0.cancel();
    L_0x0009:
        r0 = r4.mContainerView;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r4.mCurWindowVisibility;
        r1 = 0;
        if (r0 != 0) goto L_0x0084;
    L_0x0014:
        r0 = r4.mShowHideAnimationEnabled;
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        if (r5 == 0) goto L_0x0084;
    L_0x001a:
        r0 = r4.mContainerView;
        r0.setTranslationY(r1);
        r0 = r4.mContainerView;
        r0 = r0.getHeight();
        r0 = -r0;
        r0 = (float) r0;
        if (r5 == 0) goto L_0x0039;
    L_0x0029:
        r5 = 2;
        r5 = new int[r5];
        r5 = {0, 0};
        r2 = r4.mContainerView;
        r2.getLocationInWindow(r5);
        r2 = 1;
        r5 = r5[r2];
        r5 = (float) r5;
        r0 = r0 - r5;
    L_0x0039:
        r5 = r4.mContainerView;
        r5.setTranslationY(r0);
        r5 = new android.support.v7.view.ViewPropertyAnimatorCompatSet;
        r5.<init>();
        r2 = r4.mContainerView;
        r2 = android.support.v4.view.ViewCompat.animate(r2);
        r2 = r2.translationY(r1);
        r3 = r4.mUpdateListener;
        r2.setUpdateListener(r3);
        r5.play(r2);
        r2 = r4.mContentAnimations;
        if (r2 == 0) goto L_0x006f;
    L_0x0059:
        r2 = r4.mContentView;
        if (r2 == 0) goto L_0x006f;
    L_0x005d:
        r2 = r4.mContentView;
        r2.setTranslationY(r0);
        r0 = r4.mContentView;
        r0 = android.support.v4.view.ViewCompat.animate(r0);
        r0 = r0.translationY(r1);
        r5.play(r0);
    L_0x006f:
        r0 = sShowInterpolator;
        r5.setInterpolator(r0);
        r0 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r5.setDuration(r0);
        r0 = r4.mShowListener;
        r5.setListener(r0);
        r4.mCurrentShowAnim = r5;
        r5.start();
        goto L_0x00a3;
    L_0x0084:
        r5 = r4.mContainerView;
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5.setAlpha(r0);
        r5 = r4.mContainerView;
        r5.setTranslationY(r1);
        r5 = r4.mContentAnimations;
        if (r5 == 0) goto L_0x009d;
    L_0x0094:
        r5 = r4.mContentView;
        if (r5 == 0) goto L_0x009d;
    L_0x0098:
        r5 = r4.mContentView;
        r5.setTranslationY(r1);
    L_0x009d:
        r5 = r4.mShowListener;
        r0 = 0;
        r5.onAnimationEnd(r0);
    L_0x00a3:
        r5 = r4.mOverlayLayout;
        if (r5 == 0) goto L_0x00ac;
    L_0x00a7:
        r5 = r4.mOverlayLayout;
        android.support.v4.view.ViewCompat.requestApplyInsets(r5);
    L_0x00ac:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.WindowDecorActionBar.doShow(boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doHide(boolean r5) {
        /*
        r4 = this;
        r0 = r4.mCurrentShowAnim;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r4.mCurrentShowAnim;
        r0.cancel();
    L_0x0009:
        r0 = r4.mCurWindowVisibility;
        if (r0 != 0) goto L_0x007a;
    L_0x000d:
        r0 = r4.mShowHideAnimationEnabled;
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        if (r5 == 0) goto L_0x007a;
    L_0x0013:
        r0 = r4.mContainerView;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.setAlpha(r1);
        r0 = r4.mContainerView;
        r1 = 1;
        r0.setTransitioning(r1);
        r0 = new android.support.v7.view.ViewPropertyAnimatorCompatSet;
        r0.<init>();
        r2 = r4.mContainerView;
        r2 = r2.getHeight();
        r2 = -r2;
        r2 = (float) r2;
        if (r5 == 0) goto L_0x003e;
    L_0x002f:
        r5 = 2;
        r5 = new int[r5];
        r5 = {0, 0};
        r3 = r4.mContainerView;
        r3.getLocationInWindow(r5);
        r5 = r5[r1];
        r5 = (float) r5;
        r2 = r2 - r5;
    L_0x003e:
        r5 = r4.mContainerView;
        r5 = android.support.v4.view.ViewCompat.animate(r5);
        r5 = r5.translationY(r2);
        r1 = r4.mUpdateListener;
        r5.setUpdateListener(r1);
        r0.play(r5);
        r5 = r4.mContentAnimations;
        if (r5 == 0) goto L_0x0065;
    L_0x0054:
        r5 = r4.mContentView;
        if (r5 == 0) goto L_0x0065;
    L_0x0058:
        r5 = r4.mContentView;
        r5 = android.support.v4.view.ViewCompat.animate(r5);
        r5 = r5.translationY(r2);
        r0.play(r5);
    L_0x0065:
        r5 = sHideInterpolator;
        r0.setInterpolator(r5);
        r1 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.setDuration(r1);
        r5 = r4.mHideListener;
        r0.setListener(r5);
        r4.mCurrentShowAnim = r0;
        r0.start();
        return;
    L_0x007a:
        r5 = r4.mHideListener;
        r0 = 0;
        r5.onAnimationEnd(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.WindowDecorActionBar.doHide(boolean):void");
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.mNowShowing && (height == 0 || getHideOffset() < height);
    }

    public void animateToMode(boolean z) {
        if (z) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (shouldAnimateContextView()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
            if (z) {
                z = this.mDecorToolbar.setupAnimatorToVisibility(4, FADE_OUT_DURATION_MS);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200);
            } else {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, 200);
                z = this.mContextView.setupAnimatorToVisibility(8, FADE_OUT_DURATION_MS);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(z, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.mContainerView);
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public boolean isTitleTruncated() {
        return this.mDecorToolbar != null && this.mDecorToolbar.isTitleTruncated();
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeAsUpIndicator(int i) {
        this.mDecorToolbar.setNavigationIcon(i);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeActionContentDescription(int i) {
        this.mDecorToolbar.setNavigationContentDescription(i);
    }

    public void onContentScrollStarted() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.cancel();
            this.mCurrentShowAnim = null;
        }
    }

    public boolean collapseActionView() {
        if (this.mDecorToolbar == null || !this.mDecorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public int getSelectedNavigationIndex() {
        switch (this.mDecorToolbar.getNavigationMode()) {
            case 1:
                return this.mDecorToolbar.getDropdownSelectedPosition();
            case 2:
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.mDecorToolbar.getNavigationMode()) {
            case 1:
                return this.mDecorToolbar.getDropdownItemCount();
            case 2:
                return this.mTabs.size();
            default:
                return 0;
        }
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public void setNavigationMode(int i) {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab(null);
            this.mTabScrollView.setVisibility(8);
        }
        if (!(navigationMode == i || this.mHasEmbeddedTabs || this.mOverlayLayout == null)) {
            ViewCompat.requestApplyInsets(this.mOverlayLayout);
        }
        this.mDecorToolbar.setNavigationMode(i);
        boolean z = false;
        if (i == 2) {
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            if (this.mSavedTabPosition != -1) {
                setSelectedNavigationItem(this.mSavedTabPosition);
                this.mSavedTabPosition = -1;
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        boolean z2 = i == 2 && !this.mHasEmbeddedTabs;
        decorToolbar.setCollapsible(z2);
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (i == 2 && this.mHasEmbeddedTabs == 0) {
            z = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z);
    }

    public Tab getTabAt(int i) {
        return (Tab) this.mTabs.get(i);
    }

    public void setIcon(int i) {
        this.mDecorToolbar.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public void setLogo(int i) {
        this.mDecorToolbar.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (this.mActionMode == null) {
            return false;
        }
        Menu menu = this.mActionMode.getMenu();
        if (menu == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }
}
