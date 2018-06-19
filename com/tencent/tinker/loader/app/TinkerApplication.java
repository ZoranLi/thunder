package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Serializable;

/* compiled from: BUGLY */
public abstract class TinkerApplication extends Application {
    private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    private static final int TINKER_DISABLE = 0;
    private static final String TINKER_LOADER_METHOD = "tryLoad";
    private ApplicationLike applicationLike;
    private long applicationStartElapsedTime;
    private long applicationStartMillisTime;
    private final String delegateClassName;
    private final String loaderClassName;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    private Intent tinkerResultIntent;
    private boolean useSafeMode;

    protected TinkerApplication(int i) {
        this(i, "com.tencent.tinker.loader.app.DefaultApplicationLike", TinkerLoader.class.getName(), false);
    }

    protected TinkerApplication(int i, String str, String str2, boolean z) {
        this.applicationLike = null;
        this.tinkerFlags = i;
        this.delegateClassName = str;
        this.loaderClassName = str2;
        this.tinkerLoadVerifyFlag = z;
    }

    protected TinkerApplication(int i, String str) {
        this(i, str, TinkerLoader.class.getName(), false);
    }

    private ApplicationLike createDelegate() {
        try {
            return (ApplicationLike) Class.forName(this.delegateClassName, false, getClassLoader()).getConstructor(new Class[]{Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class}).newInstance(new Object[]{this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag), Long.valueOf(this.applicationStartElapsedTime), Long.valueOf(this.applicationStartMillisTime), this.tinkerResultIntent});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("createDelegate failed", th);
        }
    }

    private synchronized void ensureDelegate() {
        if (this.applicationLike == null) {
            this.applicationLike = createDelegate();
        }
    }

    private void onBaseContextAttached(Context context) {
        this.applicationStartElapsedTime = SystemClock.elapsedRealtime();
        this.applicationStartMillisTime = System.currentTimeMillis();
        loadTinker();
        ensureDelegate();
        this.applicationLike.onBaseContextAttached(context);
        if (this.useSafeMode != null) {
            context = ShareTinkerInternals.getProcessName(this);
            StringBuilder stringBuilder = new StringBuilder(ShareConstants.TINKER_OWN_PREFERENCE_CONFIG);
            stringBuilder.append(context);
            getSharedPreferences(stringBuilder.toString(), 0).edit().putInt(ShareConstants.TINKER_SAFE_MODE_COUNT, 0).commit();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
        onBaseContextAttached(context);
    }

    private void loadTinker() {
        if (this.tinkerFlags != 0) {
            this.tinkerResultIntent = new Intent();
            try {
                Class cls = Class.forName(this.loaderClassName, false, getClassLoader());
                this.tinkerResultIntent = (Intent) cls.getMethod(TINKER_LOADER_METHOD, new Class[]{TinkerApplication.class}).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[]{this});
            } catch (Serializable th) {
                ShareIntentUtil.setIntentReturnCode(this.tinkerResultIntent, -20);
                this.tinkerResultIntent.putExtra("intent_patch_exception", th);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        ensureDelegate();
        try {
            ComponentHotplug.ensureComponentHotplugInstalled(this);
            this.applicationLike.onCreate();
        } catch (Throwable e) {
            throw new TinkerRuntimeException("failed to make sure that ComponentHotplug logic is fine.", e);
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (this.applicationLike != null) {
            this.applicationLike.onTerminate();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.applicationLike != null) {
            this.applicationLike.onLowMemory();
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.applicationLike != null) {
            this.applicationLike.onTrimMemory(i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.applicationLike != null) {
            this.applicationLike.onConfigurationChanged(configuration);
        }
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        return this.applicationLike != null ? this.applicationLike.getResources(resources) : resources;
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader = super.getClassLoader();
        return this.applicationLike != null ? this.applicationLike.getClassLoader(classLoader) : classLoader;
    }

    public AssetManager getAssets() {
        AssetManager assets = super.getAssets();
        return this.applicationLike != null ? this.applicationLike.getAssets(assets) : assets;
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        return this.applicationLike != null ? this.applicationLike.getSystemService(str, systemService) : systemService;
    }

    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        return this.applicationLike != null ? this.applicationLike.getBaseContext(baseContext) : baseContext;
    }

    public void setUseSafeMode(boolean z) {
        this.useSafeMode = z;
    }

    public boolean isTinkerLoadVerifyFlag() {
        return this.tinkerLoadVerifyFlag;
    }

    public int getTinkerFlags() {
        return this.tinkerFlags;
    }
}
