package com.tencent.bugly.beta.tinker;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.app.TinkerApplication;
import java.lang.reflect.Method;

/* compiled from: BUGLY */
public class TinkerPatchReflectApplication extends TinkerApplication {
    private static final String TAG = "Tinker.ReflectApp";
    private boolean isReflectFailure = false;
    private String rawApplicationName = null;
    private Application realApplication;

    public TinkerPatchReflectApplication() {
        super(7, "com.tencent.bugly.beta.tinker.TinkerApplicationLike", TinkerLoader.class.getName(), false);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        try {
            String rawApplicationName = getRawApplicationName(context);
            if (rawApplicationName == null) {
                throw new RuntimeException("can get real realApplication from manifest!");
            }
            this.realApplication = (Application) Class.forName(rawApplicationName, false, getClassLoader()).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (this.realApplication != null) {
                try {
                    Method declaredMethod = ContextWrapper.class.getDeclaredMethod("attachBaseContext", new Class[]{Context.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.realApplication, new Object[]{context});
                } catch (Context context2) {
                    throw new IllegalStateException(context2);
                }
            }
        } catch (Context context22) {
            throw new IllegalStateException(context22);
        }
    }

    public void onCreate() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = r12.realApplication;
        if (r0 == 0) goto L_0x0120;
    L_0x0004:
        r0 = 0;
        r1 = 1;
        r2 = "android.app.ActivityThread";	 Catch:{ Throwable -> 0x00d2 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x00d2 }
        r3 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.getActivityThread(r12, r2);	 Catch:{ Throwable -> 0x00d2 }
        r4 = "mInitialApplication";	 Catch:{ Throwable -> 0x00d2 }
        r4 = r2.getDeclaredField(r4);	 Catch:{ Throwable -> 0x00d2 }
        r4.setAccessible(r1);	 Catch:{ Throwable -> 0x00d2 }
        r5 = r4.get(r3);	 Catch:{ Throwable -> 0x00d2 }
        r5 = (android.app.Application) r5;	 Catch:{ Throwable -> 0x00d2 }
        r6 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        if (r6 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0023:
        if (r5 != r12) goto L_0x002a;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0025:
        r5 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        r4.set(r3, r5);	 Catch:{ Throwable -> 0x00d2 }
    L_0x002a:
        r4 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        if (r4 == 0) goto L_0x0052;	 Catch:{ Throwable -> 0x00d2 }
    L_0x002e:
        r4 = "mAllApplications";	 Catch:{ Throwable -> 0x00d2 }
        r4 = r2.getDeclaredField(r4);	 Catch:{ Throwable -> 0x00d2 }
        r4.setAccessible(r1);	 Catch:{ Throwable -> 0x00d2 }
        r4 = r4.get(r3);	 Catch:{ Throwable -> 0x00d2 }
        r4 = (java.util.List) r4;	 Catch:{ Throwable -> 0x00d2 }
        r5 = r0;	 Catch:{ Throwable -> 0x00d2 }
    L_0x003e:
        r6 = r4.size();	 Catch:{ Throwable -> 0x00d2 }
        if (r5 >= r6) goto L_0x0052;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0044:
        r6 = r4.get(r5);	 Catch:{ Throwable -> 0x00d2 }
        if (r6 != r12) goto L_0x004f;	 Catch:{ Throwable -> 0x00d2 }
    L_0x004a:
        r6 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        r4.set(r5, r6);	 Catch:{ Throwable -> 0x00d2 }
    L_0x004f:
        r5 = r5 + 1;
        goto L_0x003e;
    L_0x0052:
        r4 = "android.app.LoadedApk";	 Catch:{ ClassNotFoundException -> 0x0059 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0059 }
        goto L_0x005f;
    L_0x0059:
        r4 = "android.app.ActivityThread$PackageInfo";	 Catch:{ Throwable -> 0x00d2 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ Throwable -> 0x00d2 }
    L_0x005f:
        r5 = "mApplication";	 Catch:{ Throwable -> 0x00d2 }
        r4 = r4.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00d2 }
        r4.setAccessible(r1);	 Catch:{ Throwable -> 0x00d2 }
        r5 = 0;
        r6 = android.app.Application.class;	 Catch:{ NoSuchFieldException -> 0x0073 }
        r7 = "mLoadedApk";	 Catch:{ NoSuchFieldException -> 0x0073 }
        r6 = r6.getDeclaredField(r7);	 Catch:{ NoSuchFieldException -> 0x0073 }
        r5 = r6;
        goto L_0x0077;
    L_0x0073:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ Throwable -> 0x00d2 }
    L_0x0077:
        r6 = 2;	 Catch:{ Throwable -> 0x00d2 }
        r7 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x00d2 }
        r8 = "mPackages";	 Catch:{ Throwable -> 0x00d2 }
        r7[r0] = r8;	 Catch:{ Throwable -> 0x00d2 }
        r8 = "mResourcePackages";	 Catch:{ Throwable -> 0x00d2 }
        r7[r1] = r8;	 Catch:{ Throwable -> 0x00d2 }
        r8 = r0;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0083:
        if (r8 >= r6) goto L_0x00df;	 Catch:{ Throwable -> 0x00d2 }
    L_0x0085:
        r9 = r7[r8];	 Catch:{ Throwable -> 0x00d2 }
        r9 = r2.getDeclaredField(r9);	 Catch:{ Throwable -> 0x00d2 }
        r9.setAccessible(r1);	 Catch:{ Throwable -> 0x00d2 }
        r9 = r9.get(r3);	 Catch:{ Throwable -> 0x00d2 }
        r9 = (java.util.Map) r9;	 Catch:{ Throwable -> 0x00d2 }
        r9 = r9.entrySet();	 Catch:{ Throwable -> 0x00d2 }
        r9 = r9.iterator();	 Catch:{ Throwable -> 0x00d2 }
    L_0x009c:
        r10 = r9.hasNext();	 Catch:{ Throwable -> 0x00d2 }
        if (r10 == 0) goto L_0x00cf;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00a2:
        r10 = r9.next();	 Catch:{ Throwable -> 0x00d2 }
        r10 = (java.util.Map.Entry) r10;	 Catch:{ Throwable -> 0x00d2 }
        r10 = r10.getValue();	 Catch:{ Throwable -> 0x00d2 }
        r10 = (java.lang.ref.WeakReference) r10;	 Catch:{ Throwable -> 0x00d2 }
        r10 = r10.get();	 Catch:{ Throwable -> 0x00d2 }
        if (r10 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00b4:
        r11 = r4.get(r10);	 Catch:{ Throwable -> 0x00d2 }
        if (r11 != r12) goto L_0x009c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00ba:
        r11 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        if (r11 == 0) goto L_0x00c3;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00be:
        r11 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        r4.set(r10, r11);	 Catch:{ Throwable -> 0x00d2 }
    L_0x00c3:
        r11 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        if (r11 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00c7:
        if (r5 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x00d2 }
    L_0x00c9:
        r11 = r12.realApplication;	 Catch:{ Throwable -> 0x00d2 }
        r5.set(r11, r10);	 Catch:{ Throwable -> 0x00d2 }
        goto L_0x009c;
    L_0x00cf:
        r8 = r8 + 1;
        goto L_0x0083;
    L_0x00d2:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r4 = "Error, reflect Application fail, result:";
        r3.<init>(r4);
        r3.append(r2);
        r12.isReflectFailure = r1;
    L_0x00df:
        r1 = r12.isReflectFailure;
        if (r1 != 0) goto L_0x0120;
    L_0x00e3:
        r1 = "com.tencent.bugly.beta.tinker.TinkerApplicationLike";	 Catch:{ Throwable -> 0x0111 }
        r2 = r12.getClassLoader();	 Catch:{ Throwable -> 0x0111 }
        r1 = java.lang.Class.forName(r1, r0, r2);	 Catch:{ Throwable -> 0x0111 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0111 }
        r3 = "replaceApplicationLike delegateClass:";	 Catch:{ Throwable -> 0x0111 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0111 }
        r2.append(r1);	 Catch:{ Throwable -> 0x0111 }
        r2 = "getTinkerPatchApplicationLike";	 Catch:{ Throwable -> 0x0111 }
        r3 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0111 }
        r2 = r1.getDeclaredMethod(r2, r3);	 Catch:{ Throwable -> 0x0111 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0111 }
        r0 = r2.invoke(r1, r0);	 Catch:{ Throwable -> 0x0111 }
        r2 = "application";	 Catch:{ Throwable -> 0x0111 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r2);	 Catch:{ Throwable -> 0x0111 }
        r2 = r12.realApplication;	 Catch:{ Throwable -> 0x0111 }
        r1.set(r0, r2);	 Catch:{ Throwable -> 0x0111 }
        goto L_0x0120;
    L_0x0111:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "replaceApplicationLike exception:";
        r1.<init>(r2);
        r0 = r0.getMessage();
        r1.append(r0);
    L_0x0120:
        super.onCreate();
        r0 = r12.realApplication;
        if (r0 == 0) goto L_0x012c;
    L_0x0127:
        r0 = r12.realApplication;
        r0.onCreate();
    L_0x012c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerPatchReflectApplication.onCreate():void");
    }

    public String getRawApplicationName(Context context) {
        if (this.rawApplicationName != null) {
            return this.rawApplicationName;
        }
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_PATCH_APPLICATION");
            if (context != null) {
                this.rawApplicationName = String.valueOf(context);
            } else {
                this.rawApplicationName = null;
            }
            new StringBuilder("with app realApplication from manifest applicationName:").append(this.rawApplicationName);
            return this.rawApplicationName;
        } catch (Context context2) {
            new StringBuilder("getManifestApplication exception:").append(context2.getMessage());
            return null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.onConfigurationChanged(configuration);
        } else {
            this.realApplication.onConfigurationChanged(configuration);
        }
    }

    public void onLowMemory() {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.onLowMemory();
        } else {
            this.realApplication.onLowMemory();
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.onTrimMemory(i);
        } else {
            this.realApplication.onTrimMemory(i);
        }
    }

    public void onTerminate() {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.onTerminate();
        } else {
            this.realApplication.onTerminate();
        }
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (!this.isReflectFailure || this.realApplication == null) {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        }
        return this.realApplication.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.unregisterReceiver(broadcastReceiver);
        } else {
            this.realApplication.unregisterReceiver(broadcastReceiver);
        }
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (!this.isReflectFailure || this.realApplication == null) {
            return super.bindService(intent, serviceConnection, i);
        }
        return this.realApplication.bindService(intent, serviceConnection, i);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.unbindService(serviceConnection);
        } else {
            this.realApplication.unbindService(serviceConnection);
        }
    }

    @TargetApi(14)
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.registerComponentCallbacks(componentCallbacks);
        } else {
            this.realApplication.registerComponentCallbacks(componentCallbacks);
        }
    }

    @TargetApi(14)
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.unregisterComponentCallbacks(componentCallbacks);
        } else {
            this.realApplication.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    @TargetApi(14)
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            this.realApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @TargetApi(14)
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            this.realApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @TargetApi(18)
    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            this.realApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    @TargetApi(18)
    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        if (!this.isReflectFailure || this.realApplication == null) {
            super.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        } else {
            this.realApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    public Resources getResources() {
        if (!this.isReflectFailure || this.realApplication == null) {
            return super.getResources();
        }
        return this.realApplication.getResources();
    }

    public ClassLoader getClassLoader() {
        if (!this.isReflectFailure || this.realApplication == null) {
            return super.getClassLoader();
        }
        return this.realApplication.getClassLoader();
    }

    public AssetManager getAssets() {
        return (!this.isReflectFailure || this.realApplication == null) ? super.getAssets() : this.realApplication.getAssets();
    }

    public ContentResolver getContentResolver() {
        if (!this.isReflectFailure || this.realApplication == null) {
            return super.getContentResolver();
        }
        return this.realApplication.getContentResolver();
    }
}
