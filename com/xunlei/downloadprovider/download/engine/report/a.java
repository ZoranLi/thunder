package com.xunlei.downloadprovider.download.engine.report;

import android.text.TextUtils;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import org.android.agoo.common.AgooConstants;

/* compiled from: DownloadReporter */
public final class a {
    public static void a(String str) {
        String b = com.xunlei.xllib.android.b.a.b(BrothersApplication.getApplicationInstance());
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_download", "dl_create").add("from", str).add("net_type", b).add("memory_space", DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance())));
    }

    private static void a(String str, String str2, String str3, int i, TaskStatInfo taskStatInfo) {
        long storageAvailableSize = DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance());
        str = HubbleEventBuilder.build("android_download", "dl_create_result").add("from", str);
        String str4 = "url";
        if (str2 == null) {
            str2 = "";
        }
        str = str.add(str4, str2).add("result", str3).add("errorcode", i).add("memory_space", storageAvailableSize);
        if (taskStatInfo != null) {
            str.add("ref_url", taskStatInfo.c).add("transid", taskStatInfo.d).add("transargs", taskStatInfo.e).add("scheme", taskStatInfo.f).add("magnet_complete", taskStatInfo.g != 0 ? "yes" : "no");
            if (TextUtils.isEmpty(taskStatInfo.i) == null) {
                str.add("appid", taskStatInfo.i);
                str.add("sdkid", taskStatInfo.j);
            }
        }
        ThunderReport.reportEvent(str);
    }

    public static void a(String str, String str2, int i, TaskStatInfo taskStatInfo) {
        a(str, str2, "fail", i, taskStatInfo);
    }

    public static void a(String str, String str2, TaskStatInfo taskStatInfo) {
        a(str, str2, "success", 0, taskStatInfo);
    }

    public static void b(String str, String str2, TaskStatInfo taskStatInfo) {
        a(str, str2, AgooConstants.MESSAGE_DUPLICATE, 0, taskStatInfo);
    }

    @android.support.annotation.Nullable
    public static java.lang.String b(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x000b }
        r0 = "game_id";	 Catch:{ Exception -> 0x000b }
        r1 = r1.getQueryParameter(r0);	 Catch:{ Exception -> 0x000b }
        goto L_0x000c;
    L_0x000b:
        r1 = 0;
    L_0x000c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.report.a.b(java.lang.String):java.lang.String");
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_download", "dl_create_collect_click");
        String str4 = "url";
        if (str == null) {
            str = "";
        }
        build.add(str4, str);
        build.add("clickid", str2);
        str = "from";
        if (str3 == null) {
            str3 = "";
        }
        build.add(str, str3);
        ThunderReport.reportEvent(build);
    }

    public static String a(TaskInfo taskInfo) {
        String str = "";
        taskInfo = taskInfo.getTaskStatus();
        if (taskInfo == 4) {
            return "pause";
        }
        if (taskInfo == 8) {
            return "finish";
        }
        if (taskInfo == 16) {
            return "fail";
        }
        switch (taskInfo) {
            case 1:
                return "wait";
            case 2:
                return "downloading";
            default:
                return str;
        }
    }
}
