package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static TypedValue sTempValue;

    protected ContextCompat() {
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, @Nullable Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static File getDataDir(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        context = context.getApplicationInfo().dataDir;
        return context != null ? new File(context) : null;
    }

    public static File[] getObbDirs(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getObbDirs();
        }
        return new File[]{context.getObbDir()};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] getExternalCacheDirs(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static final Drawable getDrawable(Context context, @DrawableRes int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (sLock) {
            if (sTempValue == null) {
                sTempValue = new TypedValue();
            }
            context.getResources().getValue(i, sTempValue, true);
            i = sTempValue.resourceId;
        }
        return context.getResources().getDrawable(i);
    }

    public static final ColorStateList getColorStateList(Context context, @ColorRes int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    @ColorInt
    public static final int getColor(Context context, @ColorRes int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static final File getNoBackupFilesDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File getCodeCacheDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getCodeCacheDir();
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File createFilesDir(java.io.File r3) {
        /*
        r0 = android.support.v4.content.ContextCompat.class;
        monitor-enter(r0);
        r1 = r3.exists();	 Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0028;
    L_0x0009:
        r1 = r3.mkdirs();	 Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0028;
    L_0x000f:
        r1 = r3.exists();	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r0);
        return r3;
    L_0x0017:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002a }
        r2 = "Unable to create files subdir ";
        r1.<init>(r2);	 Catch:{ all -> 0x002a }
        r3 = r3.getPath();	 Catch:{ all -> 0x002a }
        r1.append(r3);	 Catch:{ all -> 0x002a }
        r3 = 0;
        monitor-exit(r0);
        return r3;
    L_0x0028:
        monitor-exit(r0);
        return r3;
    L_0x002a:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.ContextCompat.createFilesDir(java.io.File):java.io.File");
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return VERSION.SDK_INT >= 24 ? context.createDeviceProtectedStorageContext() : null;
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return VERSION.SDK_INT >= 24 ? context.isDeviceProtectedStorage() : null;
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
