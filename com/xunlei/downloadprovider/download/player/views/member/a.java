package com.xunlei.downloadprovider.download.player.views.member;

import android.content.Context;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import java.util.Arrays;
import java.util.List;

/* compiled from: MemberActionHelper */
public final class a {
    public static List<Integer> a = Arrays.asList(new Integer[]{Integer.valueOf(3), Integer.valueOf(6)});

    public static String a(TaskInfo taskInfo) {
        if (LoginHelper.a().l()) {
            return "";
        }
        Object obj = (taskInfo == null || !com.xunlei.downloadprovider.download.c.a.a().a(taskInfo.getTaskId())) ? null : 1;
        if (obj == null) {
            if (!c(taskInfo)) {
                return com.xunlei.downloadprovider.download.c.a.a().d(taskInfo) == null ? "会员加速" : "加速试用";
            }
        }
        return "开通会员";
    }

    public static boolean b(TaskInfo taskInfo) {
        return (taskInfo != null && com.xunlei.downloadprovider.download.c.a.a().a(taskInfo.getTaskId()) && com.xunlei.downloadprovider.download.c.a.b(taskInfo) == null) ? true : null;
    }

    public static boolean c(TaskInfo taskInfo) {
        return (taskInfo == null || !com.xunlei.downloadprovider.download.c.a.a().a(taskInfo.getTaskId()) || com.xunlei.downloadprovider.download.c.a.b(taskInfo) == null) ? null : true;
    }

    public static void a(Context context, long j, String str) {
        LoginHelper a = LoginHelper.a();
        if (!l.c() || (!a.l() && a.g.g <= 0)) {
            n.a();
            n.b(j);
            PaymentEntryActivity.a(context, PayFrom.DOWNLOAD_LIST_SPEEDUP, str);
            return;
        }
        n.a();
        n.a(j);
    }

    public static void d(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (a()) {
                n.a();
                n.a(taskInfo.getTaskId());
                return;
            }
            com.xunlei.downloadprovider.download.c.a.a().c(taskInfo);
            com.xunlei.downloadprovider.download.c.a.a().g = false;
        }
    }

    public static boolean a() {
        if (!LoginHelper.a().l()) {
            if (LoginHelper.a().g.g <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return false;
        }
        if (!(taskInfo.getTaskStatus() == 8 || taskInfo.getTaskStatus() == 16)) {
            if (taskInfo.getTaskStatus() != 17) {
                return false;
            }
        }
        return true;
    }

    public static int e(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (taskInfo.mHasVipChannelSpeedup) {
                if (taskInfo.mVipChannelSpeed <= 0) {
                    if (taskInfo.mDcdnSpeed <= 0) {
                        if (taskInfo.mVipChannelStatus == 16) {
                            return 2;
                        }
                        return 1;
                    }
                }
                return 1;
            }
        }
        return null;
    }
}
