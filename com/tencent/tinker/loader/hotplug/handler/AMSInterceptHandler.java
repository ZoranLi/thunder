package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Method;

/* compiled from: BUGLY */
public class AMSInterceptHandler implements BinderInvocationHandler {
    private static final int INTENT_SENDER_ACTIVITY;
    private static final String TAG = "Tinker.AMSIntrcptHndlr";
    private static final int[] TRANSLUCENT_ATTR_ID = new int[]{16842840};
    private final Context mContext;

    static {
        int intValue;
        try {
            intValue = ((Integer) ShareReflectUtil.findField(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            intValue = 2;
        }
        INTENT_SENDER_ACTIVITY = intValue;
    }

    public AMSInterceptHandler(Context context) {
        while (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == null) {
                break;
            }
            context = baseContext;
        }
        this.mContext = context;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if (WBConstants.SHARE_START_ACTIVITY.equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivities".equals(name)) {
            return handleStartActivities(obj, method, objArr);
        }
        if ("startActivityAndWait".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivityWithConfig".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivityAsUser".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("getIntentSender".equals(name)) {
            return handleGetIntentSender(obj, method, objArr);
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivity(Object obj, Method method, Object[] objArr) throws Throwable {
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] instanceof Intent) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            Intent intent = new Intent((Intent) objArr[i]);
            processActivityIntent(intent);
            objArr[i] = intent;
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivities(Object obj, Method method, Object[] objArr) throws Throwable {
        int i = 0;
        int i2 = 0;
        while (i2 < objArr.length) {
            if (objArr[i2] instanceof Intent[]) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 != -1) {
            Intent[] intentArr = (Intent[]) objArr[i2];
            while (i < intentArr.length) {
                Intent intent = new Intent(intentArr[i]);
                processActivityIntent(intent);
                intentArr[i] = intent;
                i++;
            }
        }
        return method.invoke(obj, objArr);
    }

    private Object handleGetIntentSender(Object obj, Method method, Object[] objArr) throws Throwable {
        int i = 0;
        int i2 = 0;
        while (i2 < objArr.length) {
            if (objArr[i2] instanceof Intent[]) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 != -1 && ((Integer) objArr[0]).intValue() == INTENT_SENDER_ACTIVITY) {
            Intent[] intentArr = (Intent[]) objArr[i2];
            while (i < intentArr.length) {
                Intent intent = new Intent(intentArr[i]);
                processActivityIntent(intent);
                intentArr[i] = intent;
                i++;
            }
        }
        return method.invoke(obj, objArr);
    }

    private void processActivityIntent(Intent intent) {
        String className;
        String str = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getPackageName();
            className = intent.getComponent().getClassName();
        } else {
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                resolveActivity = IncrementComponentManager.resolveIntent(intent);
            }
            if (resolveActivity == null || resolveActivity.filter == null || !resolveActivity.filter.hasCategory("android.intent.category.DEFAULT")) {
                className = null;
            } else {
                str = resolveActivity.activityInfo.packageName;
                className = resolveActivity.activityInfo.name;
            }
        }
        if (IncrementComponentManager.isIncrementActivity(className)) {
            ActivityInfo queryActivityInfo = IncrementComponentManager.queryActivityInfo(className);
            storeAndReplaceOriginalComponentName(intent, str, className, ActivityStubManager.assignStub(className, queryActivityInfo.launchMode, hasTransparentTheme(queryActivityInfo)));
        }
    }

    private void storeAndReplaceOriginalComponentName(Intent intent, String str, String str2, String str3) {
        Parcelable componentName = new ComponentName(str, str2);
        ShareIntentUtil.fixIntentClassLoader(intent, this.mContext.getClassLoader());
        intent.putExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT, componentName);
        intent.setComponent(new ComponentName(str, str3));
    }

    private boolean hasTransparentTheme(android.content.pm.ActivityInfo r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = r4.getThemeResource();
        r0 = r3.mContext;
        r0 = r0.getResources();
        r0 = r0.newTheme();
        r1 = 1;
        r0.applyStyle(r4, r1);
        r4 = 0;
        r1 = 0;
        r2 = TRANSLUCENT_ATTR_ID;	 Catch:{ Throwable -> 0x002e, all -> 0x0027 }
        r0 = r0.obtainStyledAttributes(r2);	 Catch:{ Throwable -> 0x002e, all -> 0x0027 }
        r1 = r0.getBoolean(r4, r4);	 Catch:{ Throwable -> 0x002f, all -> 0x0024 }
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.recycle();
    L_0x0023:
        return r1;
    L_0x0024:
        r4 = move-exception;
        r1 = r0;
        goto L_0x0028;
    L_0x0027:
        r4 = move-exception;
    L_0x0028:
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1.recycle();
    L_0x002d:
        throw r4;
    L_0x002e:
        r0 = r1;
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.recycle();
    L_0x0034:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler.hasTransparentTheme(android.content.pm.ActivityInfo):boolean");
    }
}
