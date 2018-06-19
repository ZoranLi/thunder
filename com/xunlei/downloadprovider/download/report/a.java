package com.xunlei.downloadprovider.download.report;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.download.util.r;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: DLCenterReporter */
public final class a {
    private static final DecimalFormat a = new DecimalFormat("0.00");

    public static void a(long j, int i, long j2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_try_1_show");
        build.add("speed", j);
        if (i != 0) {
            build.add("act_info", i);
        }
        build.add("taskid", j2);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_push", "push_pop");
        build.add("type", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_push", "push_click");
        build.add("type", str);
        build.add("clickid", str2);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_task_bar_show");
        build.add("type", str);
        ThunderReport.reportEvent(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_task_bar_click");
        build.add("type", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(int i, DownloadTaskInfo downloadTaskInfo) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_try_2_click");
        LoginHelper.a();
        build.add("is_login", l.b());
        if (i != 0) {
            build.add("act_info", i);
        }
        a(downloadTaskInfo, build);
        ThunderReport.reportEvent(build);
    }

    public static void d(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_try_4_tipclose");
        build.add("status", str);
        LoginHelper.a();
        build.add("is_login", l.b());
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, int i, DownloadTaskInfo downloadTaskInfo) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_try_5_openvip");
        build.add("status", str);
        LoginHelper.a();
        build.add("is_login", l.b());
        if (i != 0) {
            build.add("act_info", i);
        }
        a(downloadTaskInfo, build);
        ThunderReport.reportEvent(build);
    }

    public static void a() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_try_6_toast_alert"));
    }

    public static void b() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_try_push_alert"));
    }

    public static void c() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_try_push_click"));
    }

    public static void a(String str, String str2, String str3) {
        n.a();
        TaskCountsStatistics j = n.j();
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_show");
        String str4 = "from";
        if (str == null) {
            str = DispatchConstants.OTHER;
        }
        build.add(str4, str);
        str = "appid";
        if (str3 == null) {
            str3 = "";
        }
        build.add(str, str3);
        str = "sdkid";
        if (str2 == null) {
            str2 = "";
        }
        build.add(str, str2);
        build.add("imei", AndroidConfig.getIMEI(BrothersApplication.getApplicationInstance()));
        build.add(SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC());
        str = "is_login";
        LoginHelper.a();
        build.add(str, l.b() != null ? "1" : "0");
        str2 = new StringBuilder();
        str2.append(j.getFinishedTaskCount());
        build.add("finish_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getRunningCount());
        build.add("downloading_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getFailedCount());
        build.add("fail_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getPausedCount());
        build.add("pause_tasknum", str2.toString());
        build.add("net_type", com.xunlei.xllib.android.b.a.b(BrothersApplication.getApplicationInstance()));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        n.a();
        TaskCountsStatistics j = n.j();
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_show");
        String str4 = "from";
        if (str == null) {
            str = DispatchConstants.OTHER;
        }
        build.add(str4, str);
        str = "appid";
        if (str3 == null) {
            str3 = "";
        }
        build.add(str, str3);
        str = "sdkid";
        if (str2 == null) {
            str2 = "";
        }
        build.add(str, str2);
        build.add("imei", AndroidConfig.getIMEI(BrothersApplication.getApplicationInstance()));
        build.add(SocializeProtocolConstants.PROTOCOL_KEY_MAC, AndroidConfig.getMAC());
        str = "is_login";
        LoginHelper.a();
        build.add(str, l.b() != null ? "1" : "0");
        str2 = new StringBuilder();
        str2.append(j.getFinishedTaskCount());
        build.add("finish_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getRunningCount());
        build.add("downloading_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getFailedCount());
        build.add("fail_tasknum", str2.toString());
        str2 = new StringBuilder();
        str2.append(j.getPausedCount());
        build.add("pause_tasknum", str2.toString());
        build.add("net_type", com.xunlei.xllib.android.b.a.b(BrothersApplication.getApplicationInstance()));
        build.addString("switch_tab", z ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
        build.add("clickid", str);
        build.add("if_red_point", z ? "1" : "0");
        if ("top_kuainiao".equals(str) != null) {
            build.add("is_vip", LoginHelper.a().l() != null ? "1" : "0");
            build.add("vip_type", LoginHelper.a().g.f());
        }
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
        build.add("clickid", str);
        build.add("if_red_point", "0");
        if ("top_kuainiao".equals(str) != null) {
            build.add("is_vip", LoginHelper.a().l() != null ? "1" : "0");
            build.add("vip_type", LoginHelper.a().g.f());
        }
        build.add("aidfrom", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        ThunderReport.reportEvent(c(str, str2, str3, str4, str5));
    }

    private static StatEvent c(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_list_click");
        if (str5 == null) {
            str5 = "";
        }
        build.add("dl_from", str5);
        if (str == null) {
            str = "";
        }
        build.add("clickid", str);
        if (str2 == null) {
            str2 = "";
        }
        build.add("status", str2);
        build.add("tabid", str3 == null ? "" : str3);
        if (str3 == null) {
            str4 = "";
        }
        build.add("src_type", str4);
        return build;
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, String str) {
        StatEvent c = c("dl_unfinish_speed", "downloading", str, b((TaskInfo) downloadTaskInfo), downloadTaskInfo != null ? downloadTaskInfo.mCreateOrigin : "");
        a(downloadTaskInfo, c);
        ThunderReport.reportEvent(c);
    }

    public static void b(DownloadTaskInfo downloadTaskInfo, String str) {
        long taskId;
        str = c("dl_unfinish_pause", "downloading", str, b((TaskInfo) downloadTaskInfo), downloadTaskInfo != null ? downloadTaskInfo.mCreateOrigin : "");
        String str2 = "taskid";
        if (downloadTaskInfo != null) {
            taskId = downloadTaskInfo.getTaskId();
        } else {
            taskId = 0;
        }
        str.add(str2, taskId);
        ThunderReport.reportEvent(str);
    }

    public static void c(DownloadTaskInfo downloadTaskInfo, String str) {
        long taskId;
        str = c("dl_unfinish_start", "pause", str, b((TaskInfo) downloadTaskInfo), downloadTaskInfo != null ? downloadTaskInfo.mCreateOrigin : "");
        String str2 = "taskid";
        if (downloadTaskInfo != null) {
            taskId = downloadTaskInfo.getTaskId();
        } else {
            taskId = 0;
        }
        str.add(str2, taskId);
        ThunderReport.reportEvent(str);
    }

    public static void d() {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_alert_opentip_show");
        build.add("from", "top_vip");
        ThunderReport.reportEvent(build);
    }

    public static void e() {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_kuaniao_show");
        build.add("is_vip", LoginHelper.a().l() ? "1" : "0");
        build.add("vip_type", LoginHelper.a().g.f());
        ThunderReport.reportEvent(build);
    }

    public static void c(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskAlert_show");
        if (str == null) {
            str = "";
        }
        build.add("status", str);
        if (str2 == null) {
            str2 = "";
        }
        build.add("tabid", str2);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskAlert_click");
        build.add("clickid", str);
        if (str2 == null) {
            str2 = "";
        }
        build.add("status", str2);
        if (str3 == null) {
            str3 = "";
        }
        build.add("tabid", str3);
        ThunderReport.reportEvent(build);
    }

    public static String a(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return "";
        }
        String str = "";
        int taskStatus = taskInfo.getTaskStatus();
        if (taskStatus == 4) {
            str = "pause";
        } else if (taskStatus == 8) {
            str = "finish";
        } else if (taskStatus != 16) {
            switch (taskStatus) {
                case 1:
                    str = "wait";
                    break;
                case 2:
                    str = "downloading";
                    if (taskInfo.mHasVipChannelSpeedup != null) {
                        str = "downloading_speed";
                        break;
                    }
                    break;
                default:
                    break;
            }
        } else {
            str = "fail";
        }
        return str;
    }

    public static void a(String str, String str2, boolean z, String str3, boolean z2, boolean z3) {
        a(str, str2, z, str3, z2, z3, 0);
    }

    public static void a(String str, String str2, boolean z, String str3, boolean z2, boolean z3, int i) {
        StringBuilder stringBuilder = new StringBuilder("dl_center_taskDetail_show:isSniffShow: false;fileName = ");
        stringBuilder.append(str);
        stringBuilder.append(";from = ");
        stringBuilder.append(str2);
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskDetail_show");
        build.addString("if_sniff_show", "0");
        String str4 = "title";
        if (str == null) {
            str = "";
        }
        build.addString(str4, str);
        str = "from";
        if (str2 == null) {
            str2 = DispatchConstants.OTHER;
        }
        build.addString(str, str2);
        build.addString("if_speedup", z ? "1" : "0");
        str = "task_status";
        if (str3 == null) {
            str3 = "";
        }
        build.addString(str, str3);
        build.addString("if_url_show", z2 ? "1" : "0");
        build.addString("if_show_discuss", z3 ? "yes" : "no");
        build.add("play_status", i);
        build.add("if_new", b.e() != null ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void a(long j) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskDetail_close");
        build.add("stay_period", j);
        build.add("if_new", b.e() ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, TaskInfo taskInfo) {
        if (taskInfo != null) {
            ThunderReport.reportEvent(a(str, k.h(taskInfo), k.e(taskInfo), ""));
        }
    }

    private static StatEvent a(String str, String str2, int i, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_taskDetail_click");
        if (str == null) {
            str = "";
        }
        build.add("clickid", str);
        if (str2 == null) {
            str2 = "";
        }
        build.add("status", str2);
        build.add("if_bt", i);
        build.add("user_type", str3);
        build.add("if_new", b.e() != null ? "1" : "0");
        return build;
    }

    public static void a(DownloadTaskInfo downloadTaskInfo) {
        StatEvent a = a("dl_acce", k.h(downloadTaskInfo), k.e(downloadTaskInfo), "");
        a(downloadTaskInfo, a);
        ThunderReport.reportEvent(a);
    }

    public static void b(DownloadTaskInfo downloadTaskInfo) {
        long taskId;
        StatEvent a = a("dl_pause", k.h(downloadTaskInfo), k.e(downloadTaskInfo), "");
        String str = "taskid";
        if (downloadTaskInfo != null) {
            taskId = downloadTaskInfo.getTaskId();
        } else {
            taskId = 0;
        }
        a.add(str, taskId);
        ThunderReport.reportEvent(a);
    }

    public static void c(DownloadTaskInfo downloadTaskInfo) {
        long taskId;
        StatEvent a = a("dl_download", k.h(downloadTaskInfo), k.e(downloadTaskInfo), "");
        String str = "taskid";
        if (downloadTaskInfo != null) {
            taskId = downloadTaskInfo.getTaskId();
        } else {
            taskId = 0;
        }
        a.add(str, taskId);
        ThunderReport.reportEvent(a);
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "download_share_to");
        String str6 = "to";
        if (str == null) {
            str = "";
        }
        build.addString(str6, str);
        str = "from";
        if (str2 == null) {
            str2 = "";
        }
        build.addString(str, str2);
        build.add("gcid", str3);
        build.add("filename", Uri.encode(str4));
        build.add("dlurl", Uri.encode(str5));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "download_share_result");
        String str7 = "to";
        if (str == null) {
            str = "";
        }
        build.addString(str7, str);
        str = "result";
        if (str2 == null) {
            str2 = "";
        }
        build.addString(str, str2);
        str = "from";
        if (str3 == null) {
            str3 = "";
        }
        build.addString(str, str3);
        build.add("gcid", str4);
        build.add("filename", Uri.encode(str5));
        build.add("dlurl", Uri.encode(str6));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, int i, int i2, String str2) {
        LoginHelper.a();
        boolean c = l.c();
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_tabshow");
        build.add("tabid", str);
        build.add("tasknum", i);
        build.add("speedup_num", i2);
        build.add("collect_status", str2);
        build.add("if_login", c ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void e(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_qrcode_click");
        if (str == null) {
            str = "";
        }
        build.add("step", str);
        ThunderReport.reportEvent(build);
    }

    public static void f(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_newtask_click");
        build.add("step", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_redpoint_show");
        build.add("tabid", "collect");
        build.add("if_red_point", z ? "1" : "0");
        ThunderReport.reportEvent(build);
    }

    public static void g(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_newbt_click");
        build.add("step", str);
        ThunderReport.reportEvent(build);
    }

    public static void h(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_alert_newtask_click");
        build.add("clickid", str);
        ThunderReport.reportEvent(build);
    }

    public static void d(String str, String str2) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_delete_alert_click").addString("clickid", str);
        String str3 = "dl_from";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(str3, str2));
    }

    public static void a(String str, boolean z, String str2) {
        StringBuilder stringBuilder = new StringBuilder("dl_delete_alert_click:clickid = ");
        stringBuilder.append(str);
        stringBuilder.append(",if_choose = ");
        stringBuilder.append(z);
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_delete_alert_click").addString("clickid", str).addString("if_choose", z ? "1" : "0");
        z = "dl_from";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(z, str2));
    }

    public static void i(String str) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_bar_pop");
        String str2 = "user_type";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(build.addString(str2, str));
    }

    public static void j(String str) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "download_task_banner_show").addString("type", str));
    }

    public static void k(String str) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "download_task_banner_click").addString("type", str));
    }

    public static void l(String str) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "download_task_banner_close").addString("type", str));
    }

    public static void m(String str) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_bar_click");
        String str2 = "user_type";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(build.addString(str2, str));
    }

    public static void e(String str, String str2) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_tab_show").addString("tab", str).addString("task_type", str2);
        str.add("if_new", b.e() ? "1" : "0");
        ThunderReport.reportEvent(str);
    }

    public static void b(String str, String str2, String str3, boolean z) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_quick_show").addString("gcid", str).addString("position", str2).addString("comment", str3).addString("if_progress", z ? "1" : "0");
        str.add("if_new", b.e() != null ? "1" : "0");
        ThunderReport.reportEvent(str);
    }

    public static void a(String str, String str2, String str3, String str4) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_quick_click").addString("gcid", str).addString("position", str2).addString("comment", str3).addString("clickId", str4);
        str.add("if_new", b.e() != null ? "1" : "0");
        ThunderReport.reportEvent(str);
    }

    public static void c(String str, String str2, String str3) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_click").addString("gcid", str).addString("button", str3).addString("cid", str2);
        str.add("if_new", b.e() != null ? "1" : "0");
        ThunderReport.reportEvent(str);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2) {
        str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_comment_result").addString("result", str).addString("errorcode", str2).addString("gcid", str3).addString("discussid", str4).addString("new_discussid", str5).addString("type", str6).addInt("if_default", z).addString("wordid", str7).addInt("if_process", z2);
        str.add("if_new", b.e() != null ? "1" : "0");
        ThunderReport.reportEvent(str);
    }

    public static void n(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_copy_link_show");
        String str2 = "url";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(build.addString(str2, str));
    }

    public static void o(String str) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_copy_link_click");
        String str2 = "url";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(build.addString(str2, str));
    }

    public static void f(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "share_xlpasswd_float_show");
        String str3 = "from";
        if (str == null) {
            str = "";
        }
        str = build.addString(str3, str);
        String str4 = "gcid";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(str4, str2));
    }

    public static void d(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "share_xlpasswd_float_click");
        String str4 = "from";
        if (str == null) {
            str = "";
        }
        str = build.addString(str4, str);
        String str5 = "gcid";
        if (str2 == null) {
            str2 = "";
        }
        ThunderReport.reportEvent(str.addString(str5, str2).addString("clickid", str3));
    }

    public static String b(TaskInfo taskInfo) {
        String str = "";
        if (taskInfo == null) {
            return str;
        }
        switch (b.a[r.a(taskInfo).ordinal()]) {
            case 1:
                taskInfo = "video";
                break;
            case 2:
                taskInfo = "image";
                break;
            case 3:
                taskInfo = "music";
                break;
            case 4:
                taskInfo = "apk";
                break;
            case 5:
                taskInfo = "torrent";
                break;
            case 6:
                taskInfo = "compress";
                break;
            default:
                taskInfo = DispatchConstants.OTHER;
                break;
        }
        return taskInfo;
    }

    public static String a(List<e> list) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < list.size(); i++) {
            DownloadTaskInfo b = ((e) list.get(i)).b();
            if (b != null) {
                if (i == 0) {
                    stringBuffer.append(b.mCreateOrigin);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuffer.toString());
                    stringBuilder.append("|");
                    stringBuilder.append(b.mCreateOrigin);
                    if (stringBuilder.toString().length() < 256) {
                        stringBuffer.append("|");
                        stringBuffer.append(b.mCreateOrigin);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    private static void a(DownloadTaskInfo downloadTaskInfo, StatEvent statEvent) {
        if (downloadTaskInfo != null) {
            if (statEvent != null) {
                String str = downloadTaskInfo.mLocalFileName;
                String str2 = null;
                if (!(TextUtils.isEmpty(str) || !str.contains(".") || str.endsWith("."))) {
                    int lastIndexOf = str.lastIndexOf(".");
                    if (lastIndexOf > 0) {
                        str2 = str.substring(lastIndexOf + 1);
                    }
                }
                statEvent.add("taskid", downloadTaskInfo.getTaskId());
                statEvent.add("filesize", downloadTaskInfo.mFileSize);
                statEvent.add("filetype", str2);
                statEvent.add("dl_speed", downloadTaskInfo.mDownloadSpeed);
                statEvent.add("dl_all_speed", h.e().b());
                statEvent.add("dl_process", a.format((((double) downloadTaskInfo.mDownloadedSize) * 1.0d) / ((double) downloadTaskInfo.mFileSize)));
            }
        }
    }

    public static void p(String str) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_guide", "guide_tip_show").addString("type", "bxbb").addString("from", str));
    }

    public static void q(String str) {
        StatEvent addString = HubbleEventBuilder.build("android_guide", "guide_tip_click").addString("type", "bxbb");
        String str2 = "from";
        if (str == null) {
            str = DispatchConstants.OTHER;
        }
        ThunderReport.reportEvent(addString.addString(str2, str));
    }

    public static void a(String str, List<CommentInfo> list) {
        List arrayList = new ArrayList();
        for (CommentInfo commentInfo : list) {
            Map hashMap = new HashMap();
            hashMap.put(AgooConstants.MESSAGE_ID, String.valueOf(commentInfo.getId()));
            hashMap.put("if_process", com.xunlei.downloadprovider.download.taskdetails.b.b.a(commentInfo) ? "1" : "0");
            hashMap.put("content", commentInfo.getContent());
            arrayList.add(hashMap);
        }
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_center_detail_comment_show").addString("if_new", "1").addString("gcid", str).addString("contentlist", ThunderReport.getContentList(arrayList)));
    }
}
