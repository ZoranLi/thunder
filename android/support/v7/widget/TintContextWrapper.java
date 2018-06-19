package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Theme mTheme;

    public static Context wrap(@NonNull Context context) {
        if (!shouldWrap(context)) {
            return context;
        }
        synchronized (CACHE_LOCK) {
            if (sCache == null) {
                sCache = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = sCache.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) sCache.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        sCache.remove(size);
                    }
                }
                size = sCache.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) sCache.get(size);
                    Context context2 = weakReference != null ? (TintContextWrapper) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            Context tintContextWrapper = new TintContextWrapper(context);
            sCache.add(new WeakReference(tintContextWrapper));
            return tintContextWrapper;
        }
    }

    private static boolean shouldWrap(@NonNull Context context) {
        if (!((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources))) {
            if ((context.getResources() instanceof VectorEnabledTintResources) == null) {
                if (VERSION.SDK_INT >= 21) {
                    if (VectorEnabledTintResources.shouldBeUsed() == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, context.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new TintResources(this, context.getResources());
        this.mTheme = null;
    }

    public Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    public void setTheme(int i) {
        if (this.mTheme == null) {
            super.setTheme(i);
        } else {
            this.mTheme.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.mResources;
    }

    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }
}
