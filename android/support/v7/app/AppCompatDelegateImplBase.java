package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

@RequiresApi(14)
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
    static final boolean DEBUG = false;
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean SHOULD_INSTALL_EXCEPTION_HANDLER;
    private static boolean sInstalledExceptionHandler = true;
    private static final int[] sWindowBackgroundStyleable = new int[]{16842836};
    ActionBar mActionBar;
    final AppCompatCallback mAppCompatCallback;
    final Callback mAppCompatWindowCallback;
    final Context mContext;
    private boolean mEatKeyUpEvent;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    private boolean mIsStarted;
    MenuInflater mMenuInflater;
    final Callback mOriginalWindowCallback = this.mWindow.getCallback();
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private CharSequence mTitle;
    final Window mWindow;
    boolean mWindowNoTitle;

    final class AnonymousClass1 implements UncaughtExceptionHandler {
        final /* synthetic */ UncaughtExceptionHandler val$defHandler;

        AnonymousClass1(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.val$defHandler = uncaughtExceptionHandler;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            if (shouldWrapException(th)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(th.getMessage());
                stringBuilder.append(AppCompatDelegateImplBase.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
                Throwable notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.val$defHandler.uncaughtException(thread, notFoundException);
                return;
            }
            this.val$defHandler.uncaughtException(thread, th);
        }

        private boolean shouldWrapException(Throwable th) {
            if (!(th instanceof NotFoundException)) {
                return false;
            }
            th = th.getMessage();
            if (th == null || (!th.contains("drawable") && th.contains("Drawable") == null)) {
                return false;
            }
            return true;
        }
    }

    private class ActionBarDrawableToggleImpl implements Delegate {
        ActionBarDrawableToggleImpl() {
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImplBase.this.getActionBarThemedContext();
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImplBase.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
        public void onContentChanged() {
        }

        AppCompatWindowCallbackBase(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImplBase.this.dispatchKeyEvent(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent)) {
                if (AppCompatDelegateImplBase.this.onKeyShortcut(keyEvent.getKeyCode(), keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            i = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return i;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImplBase.this.onMenuOpened(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImplBase.this.onPanelClosed(i, menu);
        }
    }

    public boolean applyDayNight() {
        return false;
    }

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void initWindowDecorActionBar();

    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    abstract boolean onMenuOpened(int i, Menu menu);

    abstract void onPanelClosed(int i, Menu menu);

    public void onSaveInstanceState(Bundle bundle) {
    }

    abstract void onTitleChanged(CharSequence charSequence);

    public void setHandleNativeActionModesEnabled(boolean z) {
    }

    public void setLocalNightMode(int i) {
    }

    abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback);

    static {
        boolean z = VERSION.SDK_INT < 21;
        SHOULD_INSTALL_EXCEPTION_HANDLER = z;
        if (z && !sInstalledExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass1(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.mContext = context;
        this.mWindow = window;
        this.mAppCompatCallback = appCompatCallback;
        if ((this.mOriginalWindowCallback instanceof AppCompatWindowCallbackBase) != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.mAppCompatWindowCallback = wrapWindowCallback(this.mOriginalWindowCallback);
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
        context = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, sWindowBackgroundStyleable);
        window = context.getDrawableIfKnown(null);
        if (window != null) {
            this.mWindow.setBackgroundDrawable(window);
        }
        context.recycle();
    }

    Callback wrapWindowCallback(Callback callback) {
        return new AppCompatWindowCallbackBase(callback);
    }

    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            this.mMenuInflater = new SupportMenuInflater(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    public final Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    final Context getActionBarThemedContext() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    public void onStart() {
        this.mIsStarted = true;
    }

    public void onStop() {
        this.mIsStarted = false;
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
    }

    final boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    final boolean isStarted() {
        return this.mIsStarted;
    }

    final Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        onTitleChanged(charSequence);
    }

    final CharSequence getTitle() {
        if (this.mOriginalWindowCallback instanceof Activity) {
            return ((Activity) this.mOriginalWindowCallback).getTitle();
        }
        return this.mTitle;
    }
}
