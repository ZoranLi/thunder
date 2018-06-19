package com.xunlei.downloadprovider.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.smtt.sdk.TbsReaderView;
import com.umeng.message.proguard.l;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.launch.dispatch.mocklink.LinkDownloadCenterActivity;

public class CommonFileReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.xunlei.action.COMMON_FILE_CLICK".equals(action)) {
            LinkDownloadCenterActivity.a(context, intent.getLongExtra(l.m, 0), "from_done_noti");
            c.a(context);
            c.a();
        } else if ("com.xunlei.action.COMMON_MERGE_FILES_CLICK".equals(action)) {
            LinkDownloadCenterActivity.a(context, -1, "from_done_noti");
            c.a(context);
            c.a();
        } else if ("com.xunlei.action.COMMON_DELETE_NOTI_CLICK".equals(action)) {
            c.a(context);
            c.a();
        } else {
            if ("com.xunlei.action.APK_CLICK".equals(action)) {
                if (intent.getBooleanExtra("isDoneListNoti", false)) {
                    c.a(context);
                    c.a();
                    return;
                }
                c.a(context);
                if (c.c() == 1) {
                    c.a(context);
                    c.a();
                }
                intent = intent.getStringExtra(TbsReaderView.KEY_FILE_PATH);
                if (intent != null) {
                    try {
                        ApkHelper.installApk(context, intent);
                    } catch (Context context2) {
                        new StringBuilder("open fail ").append(context2.getMessage());
                    }
                }
            }
        }
    }
}
