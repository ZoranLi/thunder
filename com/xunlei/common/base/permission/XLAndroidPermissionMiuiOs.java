package com.xunlei.common.base.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XLAndroidPermissionMiuiOs {
    public static final String UNKNOWN = "UNKNOWN";

    public static Intent getSettingIntent(Context context) {
        if (getSystemVersionCode() < 6) {
            return null;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    public static int getSystemVersionCode() {
        String systemProperty = getSystemProperty();
        if (TextUtils.isEmpty(systemProperty) || systemProperty.equals(UNKNOWN) || systemProperty.length() != 2 || !systemProperty.toUpperCase().startsWith("V")) {
            return 0;
        }
        Integer valueOf;
        Integer valueOf2 = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(systemProperty.substring(1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            valueOf = valueOf2;
        }
        return valueOf.intValue();
    }

    public static String getSystemProperty() {
        IOException iOException;
        Throwable th;
        String str = UNKNOWN;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            try {
                String readLine = bufferedReader2.readLine();
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (IOException e2) {
                iOException = e2;
                bufferedReader = bufferedReader2;
                try {
                    iOException.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (IOException e3) {
            iOException = e3;
            iOException.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 0).size() > null;
    }

    public static boolean isMIUI() {
        return Build.MANUFACTURER.equals("Xiaomi");
    }
}
