package com.xunlei.common.businessutil;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.xllib.android.e;
import com.xunlei.xllib.android.e.a;
import java.io.File;

class DownloadPathConfig {
    private static final String DEFAULT_DOWNLOAD_DIR_NAME = "Android/obb/com.xunlei.downloadprovider";
    static final String DOWNLOAD_PATH_NOEXIST = "##noexist##";
    private static String sDownloadDirName = "Android/obb/com.xunlei.downloadprovider";
    private static final String sDownloadDirPath;
    private static String sPrimarySDCard;
    private static String sSlaveSDCard;

    DownloadPathConfig() {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sDownloadDirName);
        stringBuilder.append(File.separator);
        sDownloadDirPath = stringBuilder.toString();
    }

    static String getDownloadDirNameImpl() {
        return sDownloadDirName;
    }

    @NonNull
    static String getDownloadPathImpl(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStoragePathImpl(context));
        stringBuilder.append(sDownloadDirPath);
        return stringBuilder.toString();
    }

    static void initDefaultDownloadPathImpl(Context context) {
        if (VERSION.SDK_INT >= 19) {
            sDownloadDirName = DEFAULT_DOWNLOAD_DIR_NAME;
            try {
                context.getObbDir();
            } catch (Context context2) {
                context2.printStackTrace();
            }
            SettingStateController.getInstance().setRealSlaveDownloadPath(sDownloadDirName);
            return;
        }
        sDownloadDirName = "ThunderDownload";
    }

    private static String selectDefaultDownloadPath(Context context) {
        StringBuilder stringBuilder;
        context = a.a();
        String b = a.b();
        String str = "";
        Object obj = 1;
        Object obj2 = (b == null || b.length() <= 0 || e.b(b) <= 0) ? null : 1;
        Object obj3 = (context == null || context.length() <= 0 || e.b(context) <= 0) ? null : 1;
        int i = 2;
        if (obj2 == null || obj3 == null) {
            if (obj2 == null) {
                if (obj3 == null) {
                    context = str;
                    obj = null;
                    if (!context.endsWith("/")) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(context);
                        stringBuilder.append("/");
                        context = stringBuilder.toString();
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(context);
                    stringBuilder.append(sDownloadDirPath);
                    context = stringBuilder.toString();
                    if (obj != null) {
                        setRealDownloadPathImpl(i, sDownloadDirName);
                    }
                    return context;
                }
            }
            context = b;
            if (context.endsWith("/")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(context);
                stringBuilder.append("/");
                context = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(context);
            stringBuilder.append(sDownloadDirPath);
            context = stringBuilder.toString();
            if (obj != null) {
                setRealDownloadPathImpl(i, sDownloadDirName);
            }
            return context;
        } else if (e.a(b) >= e.a((String) context)) {
            context = b;
            if (context.endsWith("/")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(context);
                stringBuilder.append("/");
                context = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(context);
            stringBuilder.append(sDownloadDirPath);
            context = stringBuilder.toString();
            if (obj != null) {
                setRealDownloadPathImpl(i, sDownloadDirName);
            }
            return context;
        }
        i = 1;
        if (context.endsWith("/")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context);
            stringBuilder.append("/");
            context = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(context);
        stringBuilder.append(sDownloadDirPath);
        context = stringBuilder.toString();
        if (obj != null) {
            setRealDownloadPathImpl(i, sDownloadDirName);
        }
        return context;
    }

    static String getRealDownloadPathImpl(Context context) {
        int downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage(-1);
        String savedRealDownloadPathImpl = getSavedRealDownloadPathImpl(context, downloadDirStorage, false);
        if (savedRealDownloadPathImpl.equals("##noexist##")) {
            savedRealDownloadPathImpl = selectDefaultDownloadPath(context);
        } else if (downloadDirStorage == 1) {
            context = new StringBuilder();
            context.append(a.a());
            context.append(savedRealDownloadPathImpl);
            savedRealDownloadPathImpl = context.toString();
        } else if (downloadDirStorage == 2) {
            context = new StringBuilder();
            context.append(a.b());
            context.append(savedRealDownloadPathImpl);
            savedRealDownloadPathImpl = context.toString();
        }
        if (savedRealDownloadPathImpl.endsWith("/") != null) {
            return savedRealDownloadPathImpl;
        }
        context = new StringBuilder();
        context.append(savedRealDownloadPathImpl);
        context.append("/");
        return context.toString();
    }

    static String getSavedRealDownloadPathImpl(Context context, int i, boolean z) {
        if (!(i == 1 || i == 2)) {
            i = SettingStateController.getInstance().getDownloadDirStorage(-1);
        }
        String str = "##noexist##";
        if (1 == i) {
            str = SettingStateController.getInstance().getRealPrimaryDownloadPath("##noexist##");
        } else if (2 == i) {
            str = SettingStateController.getInstance().getRealSlaveDownloadPath("##noexist##");
        }
        return ("##noexist##".equals(str) == null || !z) ? str : sDownloadDirName;
    }

    static String setRealDownloadPathImpl(int i, String str) {
        SettingStateController.getInstance().setDownloadDirStorage(i);
        if (1 == i) {
            SettingStateController.getInstance().setRealPrimaryDownloadPath(str);
        } else if (2 == i) {
            SettingStateController.getInstance().setRealSlaveDownloadPath(str);
        }
        return str;
    }

    static String getStoragePathImpl(Context context) {
        if (TextUtils.isEmpty(sPrimarySDCard) != null) {
            sPrimarySDCard = a.a();
        }
        if (TextUtils.isEmpty(sSlaveSDCard) != null) {
            sSlaveSDCard = a.b();
        }
        context = sPrimarySDCard;
        String str = sSlaveSDCard;
        int downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage();
        Object obj = null;
        Object obj2 = (str == null || str.length() <= 0 || e.b(str) <= 0) ? null : 1;
        if (context != null && context.length() > 0 && e.b(context) > 0) {
            obj = 1;
        }
        String str2 = downloadDirStorage == 2 ? str : context;
        if (obj2 == null || obj == null) {
            if (obj2 != null && downloadDirStorage == 1) {
                context = str;
                if (context == null) {
                }
            } else if (obj != null && downloadDirStorage == 2) {
                return context == null ? "" : context;
            }
        }
        context = str2;
        if (context == null) {
        }
    }
}
