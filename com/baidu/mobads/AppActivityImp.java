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
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.b;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.XAdInstanceInfo;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppActivityImp {
    public static final String EXTRA_AD_INSTANCE_INFO = "EXTRA_DATA_STRING_AD";
    public static final String EXTRA_COMMAND_EXTRA_INFO = "EXTRA_DATA_STRING_COM";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LANDINGPAGE_EXTRA_INFO = "EXTRA_DATA_STRING";
    private static boolean b = false;
    private static Class<?> d;
    private static AtomicBoolean f = new AtomicBoolean(false);
    private static ActionBarColorTheme g;
    private Activity a;
    private Object c;
    private Method[] e = null;

    public AppActivityImp(Activity activity) {
        this.a = activity;
    }

    public void setActivity(Activity activity) {
        this.a = activity;
    }

    public static void canLpShowWhenLocked(boolean z) {
        b = z;
    }

    public static boolean isAppActivityOpening() {
        return f.get();
    }

    private Method a(String str) {
        if (this.e == null) {
            return null;
        }
        for (Method method : this.e) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public void invokeRemoteStatic(String str, Object... objArr) {
        try {
            l a = l.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            str = a(str);
            if (str != null) {
                if (objArr != null) {
                    if (objArr.length != 0) {
                        str.invoke(null, objArr);
                    }
                }
                str.invoke(null, new Object[0]);
            }
        } catch (Throwable e) {
            l.a().d(e);
        }
    }

    private void a(String str, Object... objArr) {
        try {
            l a = l.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            str = a(str);
            if (str != null) {
                if (objArr != null) {
                    if (objArr.length != 0) {
                        str.invoke(this.c, objArr);
                    }
                }
                str.invoke(this.c, new Object[0]);
            }
        } catch (Throwable e) {
            l.a().d(e);
        }
    }

    private boolean b(String str, Object... objArr) {
        try {
            l a = l.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            str = a(str);
            if (str != null) {
                if (objArr != null) {
                    if (objArr.length != 0) {
                        return ((Boolean) str.invoke(this.c, objArr)).booleanValue();
                    }
                }
                return ((Boolean) str.invoke(this.c, new Object[0])).booleanValue();
            }
        } catch (Throwable e) {
            l.a().d(e);
        }
        return false;
    }

    private Object c(String str, Object... objArr) {
        try {
            l a = l.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            str = a(str);
            if (str != null) {
                if (objArr != null) {
                    if (objArr.length != 0) {
                        return str.invoke(this.c, objArr);
                    }
                }
                return str.invoke(this.c, new Object[0]);
            }
        } catch (Throwable e) {
            l.a().d(e);
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b("dispatchKeyEvent", keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return b("dispatchTouchEvent", motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return b("dispatchTrackballEvent", motionEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        a("onActivityResult", Integer.valueOf(i), Integer.valueOf(i2), intent);
    }

    protected void onApplyThemeResource(Theme theme, int i, boolean z) {
        a("onApplyThemeResource", theme, Integer.valueOf(i), Boolean.valueOf(z));
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        a("onChildTitleChanged", activity, charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        a("onConfigurationChanged", configuration);
    }

    public void onContentChanged() {
        a("onContentChanged", new Object[0]);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return b("onContextItemSelected", menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        a("onContextMenuClosed", menu);
    }

    protected void onCreate(Bundle bundle) {
        try {
            f.set(true);
            Intent intent = this.a.getIntent();
            if (intent != null) {
                g = (ActionBarColorTheme) intent.getSerializableExtra("theme");
                b = intent.getBooleanExtra("showWhenLocked", true);
            }
            intent.putExtra("multiProcess", new b().webviewMultiProcess(this.a));
            if (AppActivity.isAnti() && intent.getParcelableExtra(EXTRA_DATA) == null) {
                Parcelable xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(null, new XAdInstanceInfo(new JSONObject()));
                a(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra(EXTRA_LANDINGPAGE_EXTRA_INFO));
                a(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra(EXTRA_COMMAND_EXTRA_INFO));
                a(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo(), this.a.getIntent().getStringExtra(EXTRA_AD_INSTANCE_INFO));
                intent.putExtra(EXTRA_DATA, xAdLandingPageExtraInfo);
            }
            String str = "com.baidu.mobads.container.landingpage.App2Activity";
            ClassLoader d = com.baidu.mobads.g.b.d();
            if (d == null) {
                d = loadLocalApk(str);
            } else {
                d = Class.forName(str, true, d);
            }
            this.e = d.getDeclaredMethods();
            this.c = d.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.a});
            invokeRemoteStatic("canLpShowWhenLocked", Boolean.valueOf(b));
            invokeRemoteStatic("setActionBarColor", Integer.valueOf(g.closeColor), Integer.valueOf(g.titleColor), Integer.valueOf(g.progressColor), Integer.valueOf(g.backgroundColor));
            l.a().d(str, d, this.c);
        } catch (Throwable e) {
            l.a().e(e);
        }
        a("onCreate", bundle);
    }

    public Class<?> loadLocalApk(String str) {
        IXAdLogger a = l.a();
        try {
            str = Class.forName(str, true, new DexClassLoader(g.a(this.a), this.a.getFilesDir().getAbsolutePath(), null, getClass().getClassLoader()));
        } catch (Throwable e) {
            a.e(e);
            str = null;
        }
        StringBuilder stringBuilder = new StringBuilder("jar.path=, clz=");
        stringBuilder.append(str);
        a.i(stringBuilder.toString());
        return str;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        a("onCreateContextMenu", contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        return (CharSequence) c("onCreateDescription", new Object[0]);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog dialog = (Dialog) c("onCreateDialog", Integer.valueOf(i));
        return dialog != null ? dialog : dialog;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return b("onCreateOptionsMenu", menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return b("onCreatePanelMenu", Integer.valueOf(i), menu);
    }

    public View onCreatePanelView(int i) {
        try {
            return (View) c("onCreatePanelView", Integer.valueOf(i));
        } catch (int i2) {
            i2.printStackTrace();
            return 0;
        }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return b("onCreateThumbnail", bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) c("onCreateView", str, context, attributeSet);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    protected void onDestroy() {
        f.set(false);
        a("onDestroy", new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return b("onKeyDown", Integer.valueOf(i), keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return b("onKeyMultiple", Integer.valueOf(i), Integer.valueOf(i2), keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return b("onKeyUp", Integer.valueOf(i), keyEvent);
    }

    public void onLowMemory() {
        a("onLowMemory", new Object[0]);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return b("onMenuItemSelected", Integer.valueOf(i), menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return b("onMenuOpened", Integer.valueOf(i), menu);
    }

    protected void onNewIntent(Intent intent) {
        a("onNewIntent", intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return b("onOptionsItemSelected", menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        a("onOptionsMenuClosed", menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        a("onPanelClosed", Integer.valueOf(i), menu);
    }

    protected void onPause() {
        a("onPause", new Object[0]);
    }

    protected void onPostCreate(Bundle bundle) {
        a("onPostCreate", bundle);
    }

    protected void onPostResume() {
        a("onPostResume", new Object[0]);
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        a("onPrepareDialog", Integer.valueOf(i), dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return b("onPrepareOptionsMenu", menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return b("onPreparePanel", Integer.valueOf(i), view, menu);
    }

    protected void onRestart() {
        a("onRestart", new Object[0]);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        a("onRestoreInstanceState", bundle);
    }

    protected void onResume() {
        a("onResume", new Object[0]);
    }

    public Object onRetainNonConfigurationInstance() {
        return c("onRetainNonConfigurationInstance", new Object[0]);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        a("onSaveInstanceState", bundle);
    }

    public boolean onSearchRequested() {
        return b("onSearchRequested", new Object[0]);
    }

    protected void onStart() {
        a("onStart", new Object[0]);
    }

    protected void onStop() {
        a("onStop", new Object[0]);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        a("onTitleChanged", charSequence, Integer.valueOf(i));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return b("onTouchEvent", motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return b("onTrackballEvent", motionEvent);
    }

    public void onUserInteraction() {
        a("onUserInteraction", new Object[0]);
    }

    protected void onUserLeaveHint() {
        a("onUserLeaveHint", new Object[0]);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        a("onWindowAttributesChanged", layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        a("onWindowFocusChanged", Boolean.valueOf(z));
    }

    public static String classToString(Class<?> cls, Object obj) {
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : cls.getDeclaredFields()) {
                String name;
                try {
                    field.setAccessible(true);
                    name = field.getName();
                    try {
                        if (a(field.getType())) {
                            jSONObject.put(name, field.get(obj));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        l.a().e(name);
                        l.a().e(e);
                    }
                } catch (Exception e3) {
                    e = e3;
                    name = null;
                    l.a().e(name);
                    l.a().e(e);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e4) {
            l.a().e(e4);
            return "";
        }
    }

    private static void a(Class<?> cls, Object obj, String str) {
        String name;
        Throwable e;
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    name = field.getName();
                    try {
                        Class type = field.getType();
                        if (!jSONObject.isNull(name) && a(type)) {
                            field.set(obj, jSONObject.get(name));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        l.a().e(name);
                        l.a().e(e);
                    }
                } catch (Exception e3) {
                    e = e3;
                    name = null;
                    l.a().e(name);
                    l.a().e(e);
                }
            }
        } catch (Throwable e4) {
            l.a().e(e4);
        }
    }

    private static boolean a(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (!(cls.equals(String.class) || cls.equals(Integer.class) || cls.equals(Integer.TYPE) || cls.equals(Boolean.class) || cls.equals(Boolean.TYPE) || cls.equals(Double.class) || cls.equals(Double.TYPE) || cls.equals(Long.class) || cls.equals(Long.TYPE) || cls.equals(JSONArray.class))) {
            if (cls.equals(JSONObject.class) == null) {
                return false;
            }
        }
        return true;
    }
}
