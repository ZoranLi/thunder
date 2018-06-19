package com.xunlei.downloadprovider.download.openwith;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.g;

public class ApkFinishIntallReceiver extends BroadcastReceiver {
    public static final String a = "ApkFinishIntallReceiver";

    public void onReceive(Context context, Intent intent) {
        if (!("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) == null && "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction()) == null)) {
            context = intent.getDataString();
            String trim = context != null ? context.substring(context.indexOf(Constants.COLON_SEPARATOR) + 1).trim() : null;
            if (TextUtils.isEmpty(trim) == null) {
                intent = new StringBuilder("安装了:");
                intent.append(trim);
                intent.append("包名的程序");
                g.a().a(trim);
                if (SettingStateController.getInstance().getAutoApkDelete() != null) {
                    intent = a.a();
                    if (!TextUtils.isEmpty(trim)) {
                        XLThreadPool.execute(new b(intent, trim));
                    }
                }
                if (BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER.equals(trim) == null) {
                    intent = HubbleEventBuilder.build("android_download", "dl_apk_install_show");
                    String str = "gameid";
                    if (trim == null) {
                        trim = "";
                    }
                    intent.add(str, trim);
                    ThunderReport.reportEvent(intent);
                }
            }
        }
    }

    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }
}
