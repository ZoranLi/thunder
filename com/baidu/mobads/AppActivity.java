package com.baidu.mobads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.baidu.mobads.utils.b;
import com.baidu.mobads.utils.l;
import java.io.Serializable;

public class AppActivity extends Activity {
    private static boolean a;
    public static String activityName;
    private static ActionBarColorTheme c = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private AppActivityImp b = new AppActivityImp();

    public static class ActionBarColorTheme implements Serializable {
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.closeColor = i;
            this.titleColor = i2;
            this.progressColor = i3;
            this.backgroundColor = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public void setCloseColor(int i) {
            this.closeColor = i;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setTitleColor(int i) {
            this.titleColor = i;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public void setProgressColor(int i) {
            this.progressColor = i;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public void setBackgroundColor(int i) {
            this.backgroundColor = i;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return (this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor) ? true : null;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static Class<?> getActivityClass() {
        Class<?> cls = AppActivity.class;
        if (TextUtils.isEmpty(activityName)) {
            return cls;
        }
        try {
            return Class.forName(activityName);
        } catch (Throwable e) {
            l.a().e(e);
            return cls;
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return c;
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            c = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        a = z;
        AppActivityImp.canLpShowWhenLocked(z);
    }

    public static boolean getLpShowWhenLocked() {
        return a;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.b.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.b.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    protected void onApplyThemeResource(Theme theme, int i, boolean z) {
        this.b.onApplyThemeResource(theme, i, z);
        super.onApplyThemeResource(theme, i, z);
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.b.onChildTitleChanged(activity, charSequence);
        super.onChildTitleChanged(activity, charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.b.onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    public void onContentChanged() {
        this.b.onContentChanged();
        super.onContentChanged();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.b.onContextItemSelected(menuItem)) {
            return true;
        }
        return super.onContextItemSelected(menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        this.b.onContextMenuClosed(menu);
        super.onContextMenuClosed(menu);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.b.setActivity(this);
            this.b.onCreate(bundle);
        } catch (Throwable e) {
            l.a().e(e);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.b.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = this.b.onCreateDescription();
        if (onCreateDescription != null) {
            return onCreateDescription;
        }
        return super.onCreateDescription();
    }

    protected Dialog onCreateDialog(int i) {
        Dialog onCreateDialog = this.b.onCreateDialog(i);
        if (onCreateDialog != null) {
            return onCreateDialog;
        }
        return super.onCreateDialog(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.b.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (this.b.onCreatePanelMenu(i, menu)) {
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        View onCreatePanelView = this.b.onCreatePanelView(i);
        if (onCreatePanelView != null) {
            return onCreatePanelView;
        }
        return super.onCreatePanelView(i);
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        if (this.b.onCreateThumbnail(bitmap, canvas)) {
            return true;
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.b.onCreateView(str, context, attributeSet);
        if (onCreateView != null) {
            return onCreateView;
        }
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        if (new b().webviewMultiProcess(this)) {
            Intent intent = new Intent();
            intent.setAction("AppActivity_onDestroy");
            sendBroadcast(intent);
        }
        this.b.onDestroy();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.b.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (this.b.onKeyMultiple(i, i2, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.b.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onLowMemory() {
        this.b.onLowMemory();
        super.onLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.b.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        if (this.b.onMenuOpened(i, menu)) {
            return true;
        }
        return super.onMenuOpened(i, menu);
    }

    protected void onNewIntent(Intent intent) {
        this.b.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.b.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        this.b.onOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.b.onPanelClosed(i, menu);
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        this.b.onPause();
        super.onPause();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.b.onPostCreate(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.b.onPostResume();
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        this.b.onPrepareDialog(i, dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.b.onPrepareOptionsMenu(menu)) {
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (this.b.onPreparePanel(i, view, menu)) {
            return true;
        }
        return super.onPreparePanel(i, view, menu);
    }

    protected void onRestart() {
        super.onRestart();
        this.b.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.b.onRestoreInstanceState(bundle);
    }

    protected void onResume() {
        super.onResume();
        this.b.onResume();
    }

    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = this.b.onRetainNonConfigurationInstance();
        if (onRetainNonConfigurationInstance != null) {
            return onRetainNonConfigurationInstance;
        }
        return super.onRetainNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.onSaveInstanceState(bundle);
    }

    public boolean onSearchRequested() {
        if (this.b.onSearchRequested()) {
            return true;
        }
        return super.onSearchRequested();
    }

    protected void onStart() {
        super.onStart();
        this.b.onStart();
    }

    protected void onStop() {
        this.b.onStop();
        super.onStop();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.b.onTitleChanged(charSequence, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.b.onTrackballEvent(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.b.onUserInteraction();
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.b.onUserLeaveHint();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        this.b.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.b.onWindowFocusChanged(z);
    }
}
