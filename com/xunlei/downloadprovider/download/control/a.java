package com.xunlei.downloadprovider.download.control;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ApkHelper$ApkInfo;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationDialogActivity;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.b;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.member.payment.paymentfloat.FloatActivity;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.xllib.android.XLIntent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DownloadCenterControl */
public final class a {
    public Activity a;
    protected Handler b = new Handler(new b(this));
    XLAlertDialog c = null;
    XLAlertDialog d = null;
    public DownloadListControl e;

    public static void a(q qVar) {
        try {
            p.a().a.registerObserver(qVar);
        } catch (q qVar2) {
            qVar2.printStackTrace();
        }
    }

    public static void b(q qVar) {
        try {
            p.a().a.unregisterObserver(qVar);
        } catch (q qVar2) {
            qVar2.printStackTrace();
        }
    }

    public final void a(TaskInfo taskInfo, String str, String str2) {
        a aVar = this;
        TaskInfo taskInfo2 = taskInfo;
        String str3 = str;
        if (taskInfo2 != null) {
            String str4 = taskInfo2.mLocalFileName;
            String str5 = taskInfo2.mTitle;
            if (!TextUtils.isEmpty(str4)) {
                File file = new File(str4);
                if (taskInfo2.mTaskType == TaskType.BT) {
                    if (!file.exists()) {
                        XLToast.showToast(aVar.a.getApplicationContext(), aVar.a.getString(R.string.task_detail_file_noexist));
                    } else if (file.listFiles() == null || file.listFiles().length != 1) {
                        if (taskInfo2 != null) {
                            com.xunlei.downloadprovider.download.report.a.a("dl_finish_other", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                        }
                        a(aVar.a, taskInfo2, "dlcenter_total_bar");
                    } else {
                        EFileCategoryType fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(file.listFiles()[0].getAbsolutePath());
                        if (fileCategoryTypeByName == null || !(fileCategoryTypeByName == EFileCategoryType.E_MUSIC_CATEGORY || fileCategoryTypeByName == EFileCategoryType.E_VIDEO_CATEGORY)) {
                            if (taskInfo2 != null) {
                                com.xunlei.downloadprovider.download.report.a.a("dl_finish_other", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                            }
                            a(aVar.a, taskInfo2, "dlcenter_total_bar");
                            return;
                        }
                        str4 = file.listFiles()[0].getAbsolutePath();
                        com.xunlei.downloadprovider.download.report.a.a("dl_finish_open_video", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                        d.a(aVar.a, str4, false);
                    }
                } else if (!file.exists()) {
                    a(taskInfo, str);
                } else if (taskInfo2.mFileSize == 0) {
                    XLToast.showToast(aVar.a.getApplicationContext(), aVar.a.getString(R.string.download_list_invalid_file));
                } else {
                    taskInfo2.setConsumed(true);
                    taskInfo2.mRevision++;
                    com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
                    TaskInfo taskInfo3 = null;
                    if (!e.e(str5)) {
                        if (!e.e(str4)) {
                            if (!e.f(str5)) {
                                if (taskInfo2.mTaskType != TaskType.MAGNET) {
                                    long taskId = taskInfo.getTaskId();
                                    if (XLFileTypeUtil.getFileCategoryTypeByName(str4) == EFileCategoryType.E_VIDEO_CATEGORY && taskInfo2 != null) {
                                        com.xunlei.downloadprovider.download.report.a.a("dl_finish_open_video", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                                    } else if (taskInfo2 != null) {
                                        com.xunlei.downloadprovider.download.report.a.a("dl_finish_other", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                                    }
                                    Context context = aVar.a;
                                    if (XLFileTypeUtil.isLocalVodSupport(str4)) {
                                        BTSubTaskInfo d;
                                        n.a();
                                        b i = n.i(str4);
                                        if (i != null && i.c() != null) {
                                            taskInfo3 = i.c();
                                            d = i.d();
                                        } else if (taskId >= 0) {
                                            n.a();
                                            taskInfo3 = n.f(taskId);
                                            d = null;
                                        } else {
                                            d = null;
                                        }
                                        if (taskInfo3 != null) {
                                            VodPlayerActivityNew.a(context, taskInfo3, d, str2);
                                            return;
                                        }
                                        VodPlayerActivityNew.a(context, new TaskPlayInfo(str4), str2, null, true, 0, null);
                                        return;
                                    }
                                    d.a(context, str4, false);
                                    return;
                                }
                            }
                            if (taskInfo2 != null) {
                                com.xunlei.downloadprovider.download.report.a.a("dl_finish_other", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                            }
                            String uri = Uri.fromFile(new File(str4)).toString();
                            StringBuilder stringBuilder = new StringBuilder("file://");
                            stringBuilder.append(str4);
                            str3 = stringBuilder.toString();
                            n.a();
                            DownloadBtFileExplorerActivity.a(aVar.a, uri, n.d(str3), 9, "", taskInfo2.mRefUrl, taskInfo2.mWebsiteName);
                            return;
                        }
                    }
                    ApkHelper$ApkInfo apkInfo = ApkHelper.getApkInfo(aVar.a.getBaseContext(), str4);
                    if (ApkHelper.compareLocalApp(aVar.a.getBaseContext(), apkInfo) == 4) {
                        str4 = apkInfo.getPackageName();
                        if (str4 == null || !str4.equals(aVar.a.getPackageName())) {
                            if (taskInfo2 != null) {
                                com.xunlei.downloadprovider.download.report.a.a("dl_finish_open_app", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                            }
                            ApkHelper.launchAppByPackageName(aVar.a.getBaseContext(), str4);
                            return;
                        }
                        MainTabActivity.b(aVar.a, "thunder", null);
                        return;
                    }
                    if (str4 != null) {
                        if (taskInfo2 != null) {
                            com.xunlei.downloadprovider.download.report.a.a("dl_finish_install", "finish", str3, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo2.mCreateOrigin);
                        }
                        d.a(aVar.a, str4, false);
                    }
                }
            }
        }
    }

    public static void a(Context context, TaskInfo taskInfo, String str) {
        com.xunlei.downloadprovider.download.a.a();
        boolean e = com.xunlei.downloadprovider.download.b.b.e();
        if (!com.xunlei.downloadprovider.download.b.b.d()) {
            if (!e) {
                Intent xLIntent = new XLIntent("com.xunLei.downloadCenter.MoreOperate");
                xLIntent.putExtra("taskInfo", taskInfo);
                xLIntent.putExtra("from", str);
                context.sendBroadcast(xLIntent);
                return;
            }
        }
        com.xunlei.downloadprovider.download.a.b(context, taskInfo.getTaskId(), str);
    }

    public static void a(Context context, PayFrom payFrom, long j) {
        if (PayFrom.DOWNLOAD_TASK_FREE_TRIAL != payFrom) {
            if (PayFrom.DOWNLOAD_LIST_SPEEDUP != payFrom) {
                PaymentEntryActivity.a(context, payFrom, 0);
                return;
            }
        }
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a("taskid", Long.valueOf(j));
        FloatActivity.a(context, payEntryParam);
    }

    public final void a(long j, PayFrom payFrom) {
        if (payFrom == null) {
            payFrom = PayFrom.DOWNLOAD_LIST_SPEEDUP;
        }
        LoginHelper a = LoginHelper.a();
        if (!l.c() || (!a.l() && a.g.g <= 0)) {
            n.a();
            n.b(j);
            a(this.a, payFrom, j);
            return;
        }
        n.a();
        n.a(j);
    }

    public static void a(TaskInfo taskInfo) {
        p a = p.a();
        if (taskInfo.getTaskStatus() == 1 || taskInfo.getTaskStatus() == 2) {
            taskInfo.mRunningInfo.a(4);
            taskInfo.mRevision++;
        }
        n.a();
        n.a(new long[]{taskInfo.getTaskId()});
        a aVar = a.a;
        List arrayList = new ArrayList();
        arrayList.add(taskInfo);
        aVar.b(arrayList);
    }

    public final void a() {
        CooperationData a = com.xunlei.downloadprovider.cooperation.ui.b.a(1007, 17);
        if (a != null) {
            CooperationDialogActivity.a(this.a, a, SceneUiStyle.TWO_BUTTON, null);
        } else {
            XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.net_disable));
        }
    }

    public final boolean a(com.xunlei.downloadprovider.cooperation.ui.a aVar) {
        CooperationData a = com.xunlei.downloadprovider.cooperation.ui.b.a(1008, 19);
        if (a == null) {
            return null;
        }
        CooperationDialogActivity.a(this.a, a, SceneUiStyle.THREE_BUTTON, aVar);
        return true;
    }

    public static void a(List<TaskInfo> list, boolean z) {
        p a = p.a();
        if (!list.isEmpty()) {
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                TaskInfo taskInfo = (TaskInfo) list.get(i);
                jArr[i] = taskInfo.getTaskId();
                BannerManager.a().a(taskInfo);
                taskInfo.mRunningInfo.a(17);
                taskInfo.mRevision++;
                PrivateSpaceMgr.a().a(taskInfo.getTaskId());
                if (!PrivateSpaceMgr.a().f()) {
                    PrivateSpaceMgr.a().a(taskInfo.getTaskId(), true);
                }
            }
            n.a().c(z, jArr);
            a.a.c(list);
        }
        com.xunlei.downloadprovider.download.c.a.a().a(list);
    }

    public static void c() {
        p.a();
        n.a();
        n.f();
    }

    public static void a(Context context, boolean z) {
        String a = f.a(PayFrom.DOWNLOAD_LIST_TOP_TXT_LINK);
        if (z) {
            z = c.a().b(a);
            a = "";
            if (z) {
                if (!TextUtils.isEmpty(z.g)) {
                    a = Uri.parse(z.g).getQueryParameter("aidfrom");
                }
                com.xunlei.downloadprovider.download.report.a.b("download_task_120", a);
            } else {
                com.xunlei.downloadprovider.download.report.a.a("download_task", false);
            }
            if (!z || TextUtils.isEmpty(z.g)) {
                z = new PayEntryParam(PayFrom.DOWNLOAD_LIST_TOP_TXT_LINK);
                z.d = a;
                PaymentEntryActivity.a(context, z);
                return;
            }
            CustomWebViewActivity.a(context, "", z.g, "", CustomWebViewActivity.class);
            return;
        }
        com.xunlei.downloadprovider.download.report.a.a("download_task", false);
        PaymentEntryActivity.a(context, PayFrom.DOWNLOAD_LIST_TOP_TXT_LINK, null);
    }

    public final void a(TaskInfo taskInfo, String str) {
        if (DownloadConfig.isStoragePathExist(this.a.getApplicationContext())) {
            if (taskInfo != null) {
                com.xunlei.downloadprovider.download.report.a.a("dl_finish_download", "finish", str, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo.mCreateOrigin);
            }
            str = new h(this, taskInfo);
            if (this.d != null) {
                this.d.dismiss();
                this.d = null;
            }
            this.d = new XLAlertDialog(this.a);
            this.d.setMessage(this.a.getString(R.string.download_list_redownload_task));
            this.d.setCancelButtonText(this.a.getString(R.string.cancel));
            this.d.setConfirmButtonText(this.a.getString(R.string.download_item_text_redownload));
            this.d.setCanceledOnTouchOutside(true);
            this.d.setOnClickCancelButtonListener(new i(this, str));
            this.d.setOnClickConfirmButtonListener(new j(this, str));
            this.d.show();
            return;
        }
        XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.download_list_sd_noexist));
    }

    public final void a(OnClickListener onClickListener) {
        if (this.c != null) {
            this.c.dismiss();
            this.c = null;
        }
        this.c = new XLAlertDialog(this.a);
        this.c.setMessage(this.a.getString(R.string.net_change_mobile_continus_tips));
        this.c.setCancelButtonText(this.a.getString(R.string.net_change_start_downloading));
        this.c.setConfirmButtonText(this.a.getString(R.string.net_change_close));
        this.c.setCanceledOnTouchOutside(true);
        this.c.setOnClickCancelButtonListener(new k(this, onClickListener));
        this.c.setOnClickConfirmButtonListener(new l(this));
        this.c.show();
    }

    public final void b(TaskInfo taskInfo) {
        if (!com.xunlei.xllib.android.b.a(this.a)) {
            a();
        } else if (com.xunlei.xllib.android.b.f(this.a)) {
            p.a().b(taskInfo, false);
        } else if (!a(new m(this, taskInfo))) {
            a(new n(this, taskInfo));
        }
    }

    public final void c(TaskInfo taskInfo) {
        if (!com.xunlei.xllib.android.b.a(this.a)) {
            a();
        } else if (com.xunlei.xllib.android.b.f(this.a)) {
            p.a().a(taskInfo, false);
        } else if (!a(new o(this, taskInfo))) {
            a(new c(this, taskInfo));
        }
    }

    public final void b() {
        if (!com.xunlei.xllib.android.b.a(this.a)) {
            a();
        } else if (com.xunlei.xllib.android.b.f(this.a)) {
            p.a();
            p.a(false);
        } else if (!a(new f(this))) {
            a(new g(this));
        }
    }

    public final void a(TaskInfo taskInfo, String str, String str2, String str3, k kVar) {
        if (this.a != null) {
            if (taskInfo != null) {
                if (this.a instanceof DownloadCenterActivity) {
                    DownloadCenterActivity downloadCenterActivity = (DownloadCenterActivity) this.a;
                    DownloadTaskInfo downloadTaskInfo = (DownloadTaskInfo) taskInfo;
                    if (TextUtils.isEmpty(str3) != null) {
                        str3 = "button_press";
                    }
                    com.xunlei.downloadprovider.download.util.n.a(downloadCenterActivity, str3, downloadTaskInfo, str, str2, kVar, "download_list_longbutton");
                    return;
                }
                if (this.e != null) {
                    DownloadListControl downloadListControl = this.e;
                    if (taskInfo != null) {
                        if (downloadListControl.getActivity() != null) {
                            if (TextUtils.isEmpty(str3)) {
                                str3 = "button_press";
                            }
                            String str4 = str3;
                            str3 = new StringBuilder();
                            str3.append(downloadListControl.a);
                            str3.append(" - showShareDialog:");
                            str3.append(taskInfo.mTitle);
                            com.xunlei.downloadprovider.download.util.n.a(downloadListControl.getActivity(), str4, taskInfo, str, str2, kVar, "download_list_longbutton");
                        }
                    }
                }
            }
        }
    }
}
