package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean a = false;
    private static boolean b = false;

    public TbsLinuxToolsJni(Context context) {
        a(context);
    }

    private native int ChmodInner(String str, String str2);

    private void a(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (b) {
                return;
            }
            b = true;
            try {
                File file = TbsShareManager.isThirdPartyApp(context) ? new File(TbsShareManager.c(context)) : aj.a().m(context);
                if (file != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getAbsolutePath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append("liblinuxtoolsfortbssdk_jni.so");
                    if (!(new File(stringBuilder.toString()).exists() || TbsShareManager.isThirdPartyApp(context))) {
                        file = aj.a().l(context);
                    }
                    if (file != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(file.getAbsolutePath());
                        stringBuilder2.append(File.separator);
                        stringBuilder2.append("liblinuxtoolsfortbssdk_jni.so");
                        System.load(stringBuilder2.toString());
                        a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                th.printStackTrace();
                a = false;
            }
        }
    }

    public int a(String str, String str2) {
        if (a) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
