package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.app.ActionBarDrawerToggle.DelegateProvider;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity extends FragmentActivity implements SupportParentable, DelegateProvider, AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder taskStackBuilder) {
    }

    @CallSuper
    public void onSupportActionModeFinished(@NonNull ActionMode actionMode) {
    }

    @CallSuper
    public void onSupportActionModeStarted(@NonNull ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    @Nullable
    public ActionMode onWindowStartingSupportActionMode(@NonNull Callback callback) {
        return null;
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        AppCompatDelegate delegate = getDelegate();
        delegate.installViewFactory();
        delegate.onCreate(bundle);
        if (delegate.applyDayNight() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(@StyleRes int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
    }

    @Nullable
    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    public void setContentView(@LayoutRes int i) {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    protected void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public <T extends View> T findViewById(@IdRes int i) {
        return getDelegate().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem) != 0) {
            return true;
        }
        i = getSupportActionBar();
        return (menuItem.getItemId() != 16908332 || i == 0 || (i.getDisplayOptions() & 4) == 0) ? false : onSupportNavigateUp();
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Nullable
    public ActionMode startSupportActionMode(@NonNull Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    public boolean onSupportNavigateUp() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.getSupportParentActivityIntent();
        if (r0 == 0) goto L_0x0026;
    L_0x0006:
        r1 = r2.supportShouldUpRecreateTask(r0);
        if (r1 == 0) goto L_0x0021;
    L_0x000c:
        r0 = android.support.v4.app.TaskStackBuilder.create(r2);
        r2.onCreateSupportNavigateUpTaskStack(r0);
        r2.onPrepareSupportNavigateUpTaskStack(r0);
        r0.startActivities();
        android.support.v4.app.ActivityCompat.finishAffinity(r2);	 Catch:{ IllegalStateException -> 0x001d }
        goto L_0x0024;
    L_0x001d:
        r2.finish();
        goto L_0x0024;
    L_0x0021:
        r2.supportNavigateUpTo(r0);
    L_0x0024:
        r0 = 1;
        return r0;
    L_0x0026:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatActivity.onSupportNavigateUp():boolean");
    }

    @Nullable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    public void supportNavigateUpTo(@NonNull Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Nullable
    public Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().onSaveInstanceState(bundle);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create((Activity) this, (AppCompatCallback) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    private boolean performMenuItemShortcut(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT < 26 && keyEvent.isCtrlPressed() == 0 && KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) == 0 && keyEvent.getRepeatCount() == 0 && KeyEvent.isModifierKey(keyEvent.getKeyCode()) == 0) {
            i = getWindow();
            if (!(i == 0 || i.getDecorView() == null || i.getDecorView().dispatchKeyShortcutEvent(keyEvent) == 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }
}
