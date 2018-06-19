package com.xunlei.downloadprovider.download.create;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.xllib.android.e;
import com.xunlei.xllib.android.e.a;

/* compiled from: ThunderTaskInterfaceImpl */
public final class at {
    public static void a(@NonNull DownData downData, @NonNull TaskStatInfo taskStatInfo) {
        ThunderTaskInteractionActivity.a(BrothersApplication.getApplicationInstance(), downData, taskStatInfo, null);
    }

    public static void a(Context context, @NonNull DownData downData, @NonNull TaskStatInfo taskStatInfo, @Nullable c cVar) {
        ThunderTaskInteractionFragment a = a(context);
        if (a == null) {
            ThunderTaskInteractionActivity.a(context, downData, taskStatInfo, cVar);
        } else {
            a.a(downData, taskStatInfo, cVar);
        }
    }

    public static void a() {
        n.a();
        if (n.b()) {
            Object obj = null;
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            boolean z = false;
            if (DownloadConfig.NONEXIST_REAL_DOWNLOAD_PATH.equals(DownloadConfig.getSavedRealDownloadPath(applicationInstance, -1, false))) {
                obj = DownloadConfig.getRealDownloadPath(applicationInstance);
            } else {
                boolean z2;
                String savedRealDownloadPath;
                String savedRealDownloadPath2;
                int downloadDirStorage;
                StringBuilder stringBuilder;
                String a = a.a();
                String b = a.b();
                if (!(TextUtils.isEmpty(b) || b.trim().length() == 0)) {
                    if (e.b(b) != 0) {
                        z2 = false;
                        if (TextUtils.isEmpty(a) || a.trim().length() == 0 || e.b(a) == 0) {
                            z = true;
                        }
                        if (!(z2 && z)) {
                            savedRealDownloadPath = DownloadConfig.getSavedRealDownloadPath(applicationInstance, 1, true);
                            if (z2) {
                                savedRealDownloadPath2 = DownloadConfig.getSavedRealDownloadPath(applicationInstance, 2, true);
                                if (z) {
                                    downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage();
                                    if (downloadDirStorage == 2) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(b);
                                        stringBuilder.append(savedRealDownloadPath2);
                                        obj = stringBuilder.toString();
                                    } else if (downloadDirStorage == 1) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(a);
                                        stringBuilder.append(savedRealDownloadPath);
                                        obj = stringBuilder.toString();
                                    }
                                } else {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(b);
                                    stringBuilder.append(savedRealDownloadPath2);
                                    obj = stringBuilder.toString();
                                }
                            } else {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(a);
                                stringBuilder.append(savedRealDownloadPath);
                                obj = stringBuilder.toString();
                            }
                        }
                    }
                }
                z2 = true;
                z = true;
                savedRealDownloadPath = DownloadConfig.getSavedRealDownloadPath(applicationInstance, 1, true);
                if (z2) {
                    savedRealDownloadPath2 = DownloadConfig.getSavedRealDownloadPath(applicationInstance, 2, true);
                    if (z) {
                        downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage();
                        if (downloadDirStorage == 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b);
                            stringBuilder.append(savedRealDownloadPath2);
                            obj = stringBuilder.toString();
                        } else if (downloadDirStorage == 1) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(a);
                            stringBuilder.append(savedRealDownloadPath);
                            obj = stringBuilder.toString();
                        }
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b);
                        stringBuilder.append(savedRealDownloadPath2);
                        obj = stringBuilder.toString();
                    }
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append(savedRealDownloadPath);
                    obj = stringBuilder.toString();
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                n.a();
                n.a(obj);
            }
        }
    }

    public static ThunderTaskInteractionFragment a(Context context) {
        if (!(context instanceof FragmentActivity)) {
            return null;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (!fragmentActivity.isFinishing()) {
            if (VERSION.SDK_INT < 17 || !fragmentActivity.isDestroyed()) {
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                ThunderTaskInteractionFragment thunderTaskInteractionFragment = (ThunderTaskInteractionFragment) supportFragmentManager.findFragmentByTag("ThunderTaskInteractionFragment");
                if (thunderTaskInteractionFragment == null) {
                    thunderTaskInteractionFragment = ThunderTaskInteractionFragment.a();
                    thunderTaskInteractionFragment.a(supportFragmentManager, null);
                    thunderTaskInteractionFragment.b = (Activity) context;
                }
                return thunderTaskInteractionFragment;
            }
        }
        return null;
    }
}
