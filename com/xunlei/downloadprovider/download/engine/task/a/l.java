package com.xunlei.downloadprovider.download.engine.task.a;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Request;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.a.a.a.b;
import com.xunlei.downloadprovider.download.engine.task.h;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.xllib.android.XLIntent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DownloadEngineCore */
public abstract class l {
    private MessageListener a;
    protected final c c = new c(this);
    protected Context d;
    protected DownloadManager e;
    protected Uri f;
    protected Handler g;
    protected Looper h;
    protected a i;
    protected Handler j;
    protected MessageListener k;
    String l;
    ExecutorService m = Executors.newCachedThreadPool();

    /* compiled from: DownloadEngineCore */
    public abstract class a extends Thread {
        final /* synthetic */ l b;

        public abstract void a(Message message);

        public a(l lVar) {
            this.b = lVar;
            super("download_engine");
        }

        @SuppressLint({"HandlerLeak"})
        public void run() {
            Looper.prepare();
            this.b.h = Looper.myLooper();
            this.b.g = new n(this);
            Looper.loop();
        }

        public void start() {
            this.b.g = null;
            super.start();
        }
    }

    public abstract void a(int i, TaskInfo taskInfo, int i2);

    public abstract void a(List<TaskInfo> list);

    public l(Service service) {
        this.d = service;
        a(DownloadConfig.getRealDownloadPath(this.d));
        b.a();
        this.e = g.a(this.d);
        this.f = this.e.getDownloadUri();
        this.a = new m(this);
        this.j = new StaticHandler(this.a);
    }

    public final Context f() {
        return this.d;
    }

    public final void a(String str) {
        if (!(TextUtils.isEmpty(str) || str.endsWith("/"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/");
            str = stringBuilder.toString();
        }
        this.l = str;
        e.g(str);
    }

    public final s g() {
        return this.c;
    }

    final void a(TaskInfo taskInfo) {
        boolean z;
        File file;
        String uri;
        String a;
        StatEvent build;
        long j;
        String str;
        String str2;
        int downloadDirStorage;
        String str3;
        StatEvent build2;
        long storageAvailableSize;
        String str4;
        String str5;
        Context context;
        String b = com.xunlei.downloadprovider.download.engine.report.a.b(taskInfo.getTaskDownloadUrl());
        if (!e.e(taskInfo.mTitle)) {
            if (!e.e(taskInfo.mLocalFileName)) {
                z = false;
                if (AppStatusChgObserver.b().a && e.f(taskInfo.mLocalFileName)) {
                    com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
                    file = new File(com.xunlei.downloadprovider.download.engine.util.b.a(taskInfo));
                    uri = Uri.fromFile(file).toString();
                    if (file.exists()) {
                        DownloadBtFileExplorerActivity.a(this.d, uri, -1, 10, "manual/manual_downloadedlist(bt)", taskInfo.mRefUrl, taskInfo.mWebsiteName);
                    }
                }
                if (z && taskInfo.mFileSize != 0 && SettingStateController.getInstance().getAutoApkInstall() && taskInfo.getCustomFlags() != 101) {
                    com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
                    a = com.xunlei.downloadprovider.download.engine.util.b.a(taskInfo);
                    taskInfo.markToSeen();
                    build = HubbleEventBuilder.build("android_download", "dl_apk_complete_show");
                    build.add("gameid", b != null ? "" : b);
                    ThunderReport.reportEvent(build);
                    d.a(this.d, a, false);
                }
                j = taskInfo.mDownloadedSize / taskInfo.mDownloadDurationTime;
                str = taskInfo.mCreateOrigin;
                uri = taskInfo.mUrl;
                str2 = taskInfo.mRefUrl;
                downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage(-1);
                str3 = downloadDirStorage != 1 ? "in" : downloadDirStorage != 2 ? "out" : " other";
                build2 = HubbleEventBuilder.build("android_download", "dl_complete");
                storageAvailableSize = DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance());
                str4 = "from";
                if (str == null) {
                    str = "";
                }
                build2.add(str4, str);
                build2.add("is_apk", z ? "1" : "0");
                str5 = "gameid";
                if (b == null) {
                    b = "";
                }
                build2.add(str5, b);
                build2.add("if_hint_install", SettingStateController.getInstance().getAutoApkInstall() ? "1" : "0");
                build2.add("if_auto_install", "0");
                build2.add("disk_type", str3);
                build2.add("avg_speed", j);
                build2.add("url", uri);
                build2.add("ref_url", str2);
                build2.add("memory_space", storageAvailableSize);
                if (taskInfo != null) {
                    build2.add("filename", taskInfo.mTitle);
                    build2.add("filesize", taskInfo.mFileSize);
                    if (taskInfo.mTaskType != TaskType.BT) {
                        if (taskInfo.mTaskType == TaskType.MAGNET) {
                            build2.add("gcid", taskInfo.mGCID);
                        }
                    }
                    build2.add("gcid", taskInfo.mInfoHash);
                }
                ThunderReport.reportEvent(build2);
                context = this.d;
                if (taskInfo != null) {
                    if (context == null) {
                        Intent xLIntent = new XLIntent("com.xunlei.downloadprovider.ACTION_DOWNLOAD_STATUS");
                        xLIntent.putExtra("status", "STATUS_FINISHED");
                        xLIntent.putExtra("url", taskInfo.getTaskDownloadUrl());
                        xLIntent.putExtra(c.e, taskInfo.mTitle);
                        xLIntent.putExtra("path", taskInfo.mLocalFileName);
                        xLIntent.putExtra("return", 0);
                        context.sendBroadcast(xLIntent);
                    }
                }
            }
        }
        z = true;
        com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
        file = new File(com.xunlei.downloadprovider.download.engine.util.b.a(taskInfo));
        uri = Uri.fromFile(file).toString();
        if (file.exists()) {
            DownloadBtFileExplorerActivity.a(this.d, uri, -1, 10, "manual/manual_downloadedlist(bt)", taskInfo.mRefUrl, taskInfo.mWebsiteName);
        }
        com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
        a = com.xunlei.downloadprovider.download.engine.util.b.a(taskInfo);
        taskInfo.markToSeen();
        build = HubbleEventBuilder.build("android_download", "dl_apk_complete_show");
        if (b != null) {
        }
        build.add("gameid", b != null ? "" : b);
        ThunderReport.reportEvent(build);
        d.a(this.d, a, false);
        j = taskInfo.mDownloadedSize / taskInfo.mDownloadDurationTime;
        str = taskInfo.mCreateOrigin;
        uri = taskInfo.mUrl;
        str2 = taskInfo.mRefUrl;
        downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage(-1);
        if (downloadDirStorage != 1) {
            if (downloadDirStorage != 2) {
            }
        }
        build2 = HubbleEventBuilder.build("android_download", "dl_complete");
        storageAvailableSize = DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance());
        str4 = "from";
        if (str == null) {
            str = "";
        }
        build2.add(str4, str);
        if (z) {
        }
        build2.add("is_apk", z ? "1" : "0");
        str5 = "gameid";
        if (b == null) {
            b = "";
        }
        build2.add(str5, b);
        if (SettingStateController.getInstance().getAutoApkInstall()) {
        }
        build2.add("if_hint_install", SettingStateController.getInstance().getAutoApkInstall() ? "1" : "0");
        build2.add("if_auto_install", "0");
        build2.add("disk_type", str3);
        build2.add("avg_speed", j);
        build2.add("url", uri);
        build2.add("ref_url", str2);
        build2.add("memory_space", storageAvailableSize);
        if (taskInfo != null) {
            build2.add("filename", taskInfo.mTitle);
            build2.add("filesize", taskInfo.mFileSize);
            if (taskInfo.mTaskType != TaskType.BT) {
                if (taskInfo.mTaskType == TaskType.MAGNET) {
                    build2.add("gcid", taskInfo.mGCID);
                }
            }
            build2.add("gcid", taskInfo.mInfoHash);
        }
        ThunderReport.reportEvent(build2);
        try {
            context = this.d;
            if (taskInfo != null) {
                if (context == null) {
                    Intent xLIntent2 = new XLIntent("com.xunlei.downloadprovider.ACTION_DOWNLOAD_STATUS");
                    xLIntent2.putExtra("status", "STATUS_FINISHED");
                    xLIntent2.putExtra("url", taskInfo.getTaskDownloadUrl());
                    xLIntent2.putExtra(c.e, taskInfo.mTitle);
                    xLIntent2.putExtra("path", taskInfo.mLocalFileName);
                    xLIntent2.putExtra("return", 0);
                    context.sendBroadcast(xLIntent2);
                }
            }
        } catch (TaskInfo taskInfo2) {
            taskInfo2.printStackTrace();
        }
    }

    private long a(String str, String str2, String str3, String str4, String str5, boolean z, long j) {
        StringBuilder stringBuilder = new StringBuilder("OnCreateDownloadTask: Task<");
        stringBuilder.append(z);
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(j);
        stringBuilder.append(">(");
        stringBuilder.append(str5);
        stringBuilder.append(") url = ");
        stringBuilder.append(str);
        stringBuilder.append(" fileName = ");
        stringBuilder.append(str3);
        stringBuilder.append(" referer = ");
        stringBuilder.append(str4);
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            DownloadManager a = g.a(this.d);
            DownloadManager$Request downloadManager$Request = new DownloadManager$Request(Uri.parse(str));
            if (str5 == null) {
                str5 = "";
            }
            downloadManager$Request.setDownloadTaskXLOrigin(str5);
            downloadManager$Request.setAllowedOverRoaming(true);
            downloadManager$Request.setAllowedNetworkTypes(2);
            downloadManager$Request.setAllowedAutoResume(false);
            downloadManager$Request.setSynchroLxTask2Server(SettingStateController.getInstance().getAutoSyncToLixianSpaceFlag());
            downloadManager$Request.setNotificationVisibility(1);
            if (!TextUtils.isEmpty(str4)) {
                downloadManager$Request.addRequestHeader(Impl.COLUMN_REFERER, str4);
            }
            if (TextUtils.isEmpty(str3) != null) {
                downloadManager$Request.setDestinationUri(str2, "");
            } else if (XLFileTypeUtil.getFileCategoryTypeByName(str3) != EFileCategoryType.E_OTHER_CATEGORY) {
                downloadManager$Request.setDestinationUri(str2, str3);
            } else {
                downloadManager$Request.setDestinationUri(str2, "");
            }
            if (TextUtils.isEmpty(str3) == null) {
                downloadManager$Request.setTitle(str3);
            }
            downloadManager$Request.setDownloadSpdy(true);
            downloadManager$Request.setDownloadDelay(false);
            downloadManager$Request.setCustomFlags(j);
            downloadManager$Request.setVisibleInDownloadsUi(z ^ 1);
            if (a != null) {
                try {
                    str2 = a.enqueue(downloadManager$Request);
                } catch (String str22) {
                    str22.printStackTrace();
                }
                if (str22 > -1) {
                    try {
                        this.c.a.a(str22, true);
                    } catch (Exception e) {
                        str = e;
                        str.printStackTrace();
                        return str22;
                    }
                }
                return str22;
            }
            str22 = -1;
            if (str22 > -1) {
                this.c.a.a(str22, true);
            }
        } catch (Exception e2) {
            str = e2;
            str22 = -1;
            str.printStackTrace();
            return str22;
        }
        return str22;
    }

    private long a(Uri uri, long[] jArr, String str, String str2) {
        StringBuilder stringBuilder;
        if (!(TextUtils.isEmpty(str2) || str2.contains("(bt)"))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("(bt)");
            str2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("OnCreateDownloadTask: BTTask(");
        stringBuilder.append(str2);
        stringBuilder.append(") url = ");
        stringBuilder.append(uri);
        stringBuilder.append(" infoHash = ");
        stringBuilder.append(str);
        try {
            DownloadManager a = g.a(this.d);
            DownloadManager$Request downloadManager$Request = new DownloadManager$Request(uri);
            downloadManager$Request.setDownloadTaskXLOrigin(str2);
            downloadManager$Request.setAllowedOverRoaming(true);
            downloadManager$Request.setAllowedNetworkTypes(2);
            downloadManager$Request.setAllowedAutoResume(false);
            downloadManager$Request.setDestinationUri(DownloadConfig.getRealDownloadPath(this.d), null);
            downloadManager$Request.setDownloadSpdy(true);
            downloadManager$Request.setDownloadDelay(false);
            downloadManager$Request.setBtSelectSet(jArr);
            downloadManager$Request.setBtInfoHash(str);
            downloadManager$Request.setSynchroLxTask2Server(SettingStateController.getInstance().getAutoSyncToLixianSpaceFlag());
            downloadManager$Request.setNotificationVisibility(1);
            jArr = a != null ? a.enqueue(downloadManager$Request) : -1;
            if (jArr > -1) {
                try {
                    this.c.a.a(jArr, true);
                } catch (Exception e) {
                    uri = e;
                    uri.printStackTrace();
                    return jArr;
                }
            }
        } catch (Exception e2) {
            uri = e2;
            jArr = -1;
            uri.printStackTrace();
            return jArr;
        }
        return jArr;
    }

    protected final int b(long j, long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder("OnCreateDownloadTask: BTSubTask[");
        stringBuilder.append(j);
        stringBuilder.append("]:");
        stringBuilder.append(Arrays.toString(jArr));
        try {
            jArr = g.a(this.d).selectBtSubTask(j, jArr);
            try {
                j = this.c.h(j);
                if (j != null) {
                    j.b = false;
                }
            } catch (Exception e) {
                j = e;
                j.printStackTrace();
                return jArr;
            }
        } catch (Exception e2) {
            j = e2;
            jArr = null;
            j.printStackTrace();
            return jArr;
        }
        return jArr;
    }

    private static boolean a() {
        if (SettingStateController.getInstance().getAutoHighSpeedChannel()) {
            return h();
        }
        return false;
    }

    protected static boolean h() {
        LoginHelper.a();
        return com.xunlei.downloadprovider.member.login.b.l.b() && (LoginHelper.a().l() || LoginHelper.a().g.g > 0);
    }

    protected final long a(com.xunlei.downloadprovider.download.engine.task.m r22) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r21 = this;
        r10 = r21;
        r11 = r22;
        r1 = new java.lang.StringBuilder;
        r2 = "commitCoreTask  ";
        r1.<init>(r2);
        r1.append(r11);
        r12 = -1;
        if (r11 != 0) goto L_0x0013;
    L_0x0012:
        return r12;
    L_0x0013:
        r1 = r11.a;
        r2 = r1.mDownloadPath;
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x001f;
    L_0x001d:
        r2 = r10.l;
    L_0x001f:
        r3 = r2;
        r2 = r1.getExtra();
        r14 = r2.g;
        r15 = new com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
        r15.<init>();
        r4 = r1.mDownloadUrl;
        r15.mUrl = r4;
        r4 = r1.mFileName;
        r15.mTitle = r4;
        r4 = r1.mRefUrl;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x003f;
    L_0x003b:
        r4 = r1.mRefUrl;
        r15.mRefUrl = r4;
    L_0x003f:
        r4 = r1.mCreateOrigin;
        r15.mCreateOrigin = r4;
        r4 = r2.a;
        r15.mDisplayName = r4;
        r4 = r1.mCID;
        r15.mCID = r4;
        r4 = r1.mGCID;
        r15.mGCID = r4;
        r4 = r1.mFileSize;
        r15.mFileSize = r4;
        r4 = r15.mUrl;
        r4 = com.xunlei.downloadprovider.download.engine.util.b.e(r4);
        r15.mUrlEigenvalue = r4;
        r4 = r2.c;
        r15.mSniffKeyword = r4;
        r4 = r2.d;
        r15.mWebsiteName = r4;
        r4 = r2.b;
        r15.mIconUrl = r4;
        r4 = r2.f;
        r15.mIsToastForTask = r4;
        r2 = r2.h;
        r15.mCheckApkOperateWhenCreate = r2;
        r2 = r1.mTaskInvisible;
        r15.setTaskInvisible(r2);
        r4 = r1.mCustomFlags;
        r15.setCustomFlags(r4);
        r4 = java.lang.System.currentTimeMillis();
        r15.mCreateTime = r4;
        r2 = r15.mUrl;
        r2 = com.xunlei.downloadprovider.h.k.g(r2);
        if (r2 == 0) goto L_0x008b;
    L_0x0087:
        r2 = com.xunlei.download.DownloadManager.TaskType.MAGNET;
        r15.mTaskType = r2;
    L_0x008b:
        r8 = r11.b;
        r2 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r2 = r2.getAutoHighSpeedChannel();
        r9 = 1;
        if (r2 == 0) goto L_0x00a3;
    L_0x0098:
        com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r2 = com.xunlei.downloadprovider.member.login.b.l.b();
        if (r2 == 0) goto L_0x00a3;
    L_0x00a1:
        r15.mShouldAutoSpeedup = r9;
    L_0x00a3:
        r2 = r22.a();
        r7 = 2;
        if (r2 != r7) goto L_0x00d4;
    L_0x00aa:
        r2 = r15.mCID;
        r4 = r15.mFileSize;
        r6 = r15.mGCID;
        r7 = r15.mTitle;
        r2 = com.xunlei.downloadprovider.download.engine.util.b.a(r2, r4, r6, r7);
        r4 = r15.mTitle;
        r5 = r15.mRefUrl;
        r6 = r1.mCreateOrigin;
        r7 = r15.isTaskInvisible();
        r18 = r15.getCustomFlags();
        r1 = r10;
        r12 = 0;
        r13 = 2;
        r13 = r8;
        r12 = r9;
        r8 = r18;
        r1 = r1.a(r2, r3, r4, r5, r6, r7, r8);
    L_0x00cf:
        r3 = 0;
        r8 = 0;
        goto L_0x017f;
    L_0x00d4:
        r13 = r8;
        r12 = r9;
        r2 = r15.mUrl;
        r2 = r2.trim();
        r15.mUrl = r2;
        r2 = r15.mUrl;
        r2 = r2.trim();
        r4 = " ";
        r5 = "%20";
        r2 = r2.replace(r4, r5);
        r4 = "thunder://";
        r4 = r2.startsWith(r4);
        if (r4 == 0) goto L_0x0117;
    L_0x00f4:
        r4 = "/";
        r4 = r2.endsWith(r4);
        if (r4 == 0) goto L_0x0108;
    L_0x00fc:
        r4 = r2.length();
        r4 = r4 - r12;
        r5 = 0;
        r2 = r2.subSequence(r5, r4);
        r2 = (java.lang.String) r2;
    L_0x0108:
        r4 = com.xunlei.xllib.b.k.d(r2);
        r4 = com.xunlei.xllib.b.k.c(r4);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x0117;
    L_0x0116:
        r2 = r4;
    L_0x0117:
        r4 = r10.c;
        r4 = r4.a(r2);
        r6 = -1;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x0137;
    L_0x0123:
        r4 = r15.mTitle;
        r5 = r15.mRefUrl;
        r6 = r1.mCreateOrigin;
        r7 = r15.isTaskInvisible();
        r8 = r15.getCustomFlags();
        r1 = r10;
        r1 = r1.a(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x00cf;
    L_0x0137:
        r1 = r10.c;
        r1 = r1.b(r4);
        if (r1 == 0) goto L_0x017b;
    L_0x013f:
        r2 = r1.getTaskStatus();
        r15.setTaskStatus(r2);
        r2 = r1.mDownloadedSize;
        r15.mDownloadedSize = r2;
        r2 = r1.mLocalFileName;
        r15.mLocalFileName = r2;
        r2 = r1.mFileSize;
        r15.mFileSize = r2;
        r2 = r1.mTitle;
        r15.mTitle = r2;
        r2 = r1.isTaskInvisible();
        if (r2 == 0) goto L_0x017b;
    L_0x015c:
        r2 = r15.isTaskInvisible();
        if (r2 != 0) goto L_0x017b;
    L_0x0162:
        r2 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r6 = r1.getTaskId();
        r2.b(r6);
        r2 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r6 = r1.getTaskId();
        r8 = 0;
        r2.b(r6, r8);
        goto L_0x017d;
    L_0x017b:
        r8 = 0;
    L_0x017d:
        r1 = r4;
        r3 = r12;
    L_0x017f:
        r15.setTaskId(r1);
        r4 = (int) r1;
        r5 = 100;
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 == 0) goto L_0x0193;
    L_0x0189:
        r4 = -2;
        r3 = r15.mCreateOrigin;
        r7 = r15.mUrl;
        com.xunlei.downloadprovider.download.engine.report.a.b(r3, r7, r13);
        goto L_0x0221;
    L_0x0193:
        r16 = -1;
        r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1));
        if (r3 != 0) goto L_0x01a4;
    L_0x0199:
        r4 = -1;
        r3 = r15.mCreateOrigin;
        r7 = r15.mUrl;
        r8 = 2;
        com.xunlei.downloadprovider.download.engine.report.a.a(r3, r7, r8, r13);
        goto L_0x0221;
    L_0x01a4:
        r3 = r10.c;
        r6 = new com.xunlei.downloadprovider.download.engine.task.a.a;
        r6.<init>(r1, r15);
        r3.a(r6);
        r3 = r10.c;
        r3.a(r15);
        r3 = r15.mCreateOrigin;
        r6 = r15.mUrl;
        com.xunlei.downloadprovider.download.engine.report.a.a(r3, r6, r13);
        r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r3 <= 0) goto L_0x01d0;
    L_0x01be:
        r3 = a();
        if (r3 == 0) goto L_0x01d0;
    L_0x01c4:
        r3 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r6 = new long[r12];
        r7 = 0;
        r6[r7] = r1;
        r3.b(r6);
    L_0x01d0:
        r15.syncExtraInfo();	 Catch:{ Exception -> 0x01e2 }
        r3 = com.xunlei.downloadprovider.download.engine.task.a.a.a.a();	 Catch:{ Exception -> 0x01e2 }
        r6 = r15.mExtraInfo;	 Catch:{ Exception -> 0x01e2 }
        r3.a(r6);	 Catch:{ Exception -> 0x01e2 }
        r3 = r10.c;	 Catch:{ Exception -> 0x01e2 }
        r3.d(r1);	 Catch:{ Exception -> 0x01e2 }
        goto L_0x01e7;
    L_0x01e2:
        r0 = move-exception;
        r3 = r0;
        r3.printStackTrace();
    L_0x01e7:
        r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r3 <= 0) goto L_0x0209;
    L_0x01eb:
        r3 = r15.mUrl;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0209;
    L_0x01f3:
        r3 = new com.xunlei.downloadprovider.download.engine.util.CidUrl;	 Catch:{ Exception -> 0x0205 }
        r6 = r15.mCID;	 Catch:{ Exception -> 0x0205 }
        r7 = r15.mFileSize;	 Catch:{ Exception -> 0x0205 }
        r9 = r15.mGCID;	 Catch:{ Exception -> 0x0205 }
        r3.<init>(r6, r7, r9);	 Catch:{ Exception -> 0x0205 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0205 }
        r15.mUrl = r3;	 Catch:{ Exception -> 0x0205 }
        goto L_0x0209;
    L_0x0205:
        r3 = "";
        r15.mUrl = r3;
    L_0x0209:
        r3 = r10.c;
        r3.i();
        r3 = r10.c;
        r3.g();
        r3 = r10.c;
        r3 = r3.f;
        r3.a(r1);
        com.xunlei.downloadprovider.download.engine.task.h.a();
        com.xunlei.downloadprovider.download.engine.task.h.b(r15);
        r6 = r5;
    L_0x0221:
        r3 = r11.d;
        if (r3 == 0) goto L_0x022e;
    L_0x0225:
        if (r6 != r5) goto L_0x022b;
    L_0x0227:
        r3.b(r15, r4, r14);
        goto L_0x022e;
    L_0x022b:
        r3.a(r15, r4, r14);
    L_0x022e:
        r3 = r11.e;
        if (r3 != 0) goto L_0x0242;
    L_0x0232:
        r3 = r10.m;
        if (r3 == 0) goto L_0x023f;
    L_0x0236:
        r5 = new com.xunlei.downloadprovider.download.engine.task.y;
        r5.<init>(r11, r4, r15);
        r3.execute(r5);
        goto L_0x0242;
    L_0x023f:
        r11.a(r15);
    L_0x0242:
        r3 = r10.j;
        r3 = r3.obtainMessage(r6, r4, r14, r15);
        r3.sendToTarget();
        a(r6, r4, r15, r14);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.l.a(com.xunlei.downloadprovider.download.engine.task.m):long");
    }

    protected final long b(Uri uri, long[] jArr, String str, String str2, String str3, DownloadAdditionInfo downloadAdditionInfo) {
        com.xunlei.downloadprovider.download.engine.task.info.b qVar;
        c cVar = this.c;
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : cVar.k.values()) {
                if (aVar != null && aVar.c.mTaskType == TaskType.BT && aVar.c().mInfoHash.equals(aVar.c().mInfoHash)) {
                    qVar = new q(aVar);
                    break;
                }
            }
        }
        qVar = null;
        long a = a(uri, jArr, str, str3);
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskId(a);
        taskInfo.mInfoHash = str;
        taskInfo.mCreateOrigin = str3;
        taskInfo.mTitle = str2;
        taskInfo.mRefUrl = downloadAdditionInfo.e;
        taskInfo.mWebsiteName = downloadAdditionInfo.d;
        taskInfo.mCreateTime = System.currentTimeMillis();
        taskInfo.mTaskType = TaskType.BT;
        str3 = (qVar == null || qVar.a() != a) ? null : 1;
        int i = (int) a;
        TaskStatInfo taskStatInfo = new TaskStatInfo();
        taskStatInfo.c = taskInfo.mRefUrl;
        int i2 = 101;
        if (str3 != null) {
            i = -2;
            str3 = this.c.b(a);
            if (str3 != null) {
                taskInfo.setTaskStatus(str3.getTaskStatus());
                taskInfo.mDownloadedSize = str3.mDownloadedSize;
                taskInfo.mLocalFileName = str3.mLocalFileName;
                taskInfo.mFileSize = str3.mFileSize;
                taskInfo.mTitle = str3.mTitle;
            }
            com.xunlei.downloadprovider.download.engine.report.a.b(taskInfo.mCreateOrigin, taskInfo.getTaskDownloadUrl(), taskStatInfo);
        } else if (a == -1) {
            i = -1;
            com.xunlei.downloadprovider.download.engine.report.a.a(taskInfo.mCreateOrigin, taskInfo.getTaskDownloadUrl(), 2, taskStatInfo);
        } else {
            this.c.a(new a(a, taskInfo));
            this.c.a(taskInfo);
            i2 = 100;
            com.xunlei.downloadprovider.download.engine.report.a.a(taskInfo.mCreateOrigin, taskInfo.getTaskDownloadUrl(), taskStatInfo);
            try {
                taskInfo.syncExtraInfo();
                com.xunlei.downloadprovider.download.engine.task.a.a.a.a().a(taskInfo.mExtraInfo);
            } catch (String str32) {
                str32.printStackTrace();
            }
            this.c.f.a(a);
            h.a();
            h.b(taskInfo);
        }
        if (!(a() == null || a == -1)) {
            g.a().b(new long[]{a});
        }
        this.j.obtainMessage(i2, i, 0, taskInfo).sendToTarget();
        a(i2, i, taskInfo, 0);
        return a;
    }

    private static void a(int i, int i2, @NonNull TaskInfo taskInfo, int i3) {
        if (i == 101) {
            i = "ACTION_ADD_TASK_FAILED";
        } else if (i == 100) {
            i = "ACTION_ADD_TASK_SUCCESS";
        } else {
            return;
        }
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
        Intent intent = new Intent();
        intent.setAction(i);
        intent.putExtra("retCode", i2);
        intent.putExtra("needNoti", i3);
        intent.putExtra("taskInfo", taskInfo);
        intent.putExtra("taskId", taskInfo.getTaskId());
        instance.sendBroadcast(intent);
    }

    protected final void i() {
        if (this.c.k != null && !this.c.k.isEmpty()) {
            if (this.c.j) {
                this.c.j = false;
                n.a().n();
            }
            Collection arrayList = new ArrayList();
            for (a aVar : this.c.k.values()) {
                if (8 != aVar.b()) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            }
            long[] a = com.xunlei.downloadprovider.download.engine.util.b.a(arrayList);
            if (a.length > 0) {
                g.a().b(a);
            }
        }
    }

    protected final void a(boolean z) {
        if (this.c.k != null && !this.c.k.isEmpty()) {
            List arrayList = new ArrayList();
            for (a aVar : this.c.k.values()) {
                if (!aVar.d() && (4 == aVar.b() || 16 == aVar.b())) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            }
            if (arrayList.size() > 0) {
                this.c.a(z, (Collection) arrayList);
                h.a();
                h.b(arrayList);
            }
        }
    }

    protected final void a(Collection<Long> collection, boolean z) {
        if (collection != null && collection.size() > 0) {
            this.c.a(z, (Collection) collection);
            com.xunlei.downloadprovider.notification.c.a(this.d).a((Collection) collection);
        }
    }

    protected final void b(Collection<Long> collection, boolean z) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                this.c.i.removeAll(collection);
                g.a().c(z, com.xunlei.downloadprovider.download.engine.util.b.a((Collection) collection));
                if (a() && collection.size() <= false) {
                    for (Long longValue : collection) {
                        long longValue2 = longValue.longValue();
                        g.a().b(new long[]{longValue2});
                    }
                }
            }
        }
    }

    protected final void c(Collection<Long> collection, boolean z) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                this.c.a((Collection) collection, z);
            }
        }
    }

    protected final void a(@android.support.annotation.Nullable com.xunlei.downloadprovider.ipc.b r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r6 = r4.b(r6);
        if (r5 == 0) goto L_0x0034;
    L_0x0006:
        r0 = 0;
        r1 = r6.a;
        if (r1 == 0) goto L_0x0030;
    L_0x000b:
        r1 = r6.a;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x0030;
    L_0x0013:
        r0 = r6.a;
        r0 = r0.size();
        r0 = new long[r0];
        r1 = 0;
    L_0x001c:
        r2 = r0.length;
        if (r1 >= r2) goto L_0x0030;
    L_0x001f:
        r2 = r6.a;
        r2 = r2.get(r1);
        r2 = (java.lang.Long) r2;
        r2 = r2.longValue();
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L_0x001c;
    L_0x0030:
        r5.a(r0);	 Catch:{ RemoteException -> 0x0034 }
        return;
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.l.a(com.xunlei.downloadprovider.ipc.b, boolean):void");
    }

    protected final com.xunlei.downloadprovider.download.engine.task.b b(boolean z) {
        com.xunlei.downloadprovider.download.engine.task.b bVar = new com.xunlei.downloadprovider.download.engine.task.b();
        if (!(this.c.k == null || this.c.k.isEmpty())) {
            Collection arrayList = new ArrayList();
            for (a aVar : this.c.k.values()) {
                if (!aVar.d() && (2 == aVar.b() || 1 == aVar.b())) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            }
            this.c.a(arrayList, z);
            bVar.a = arrayList;
        }
        return bVar;
    }

    protected final void d(Collection<Long> collection, boolean z) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                g.a().b(z, com.xunlei.downloadprovider.download.engine.util.b.a((Collection) collection));
                collection = this.c.a((Collection) collection);
                if (!collection.isEmpty()) {
                    z = com.xunlei.downloadprovider.notification.c.a(this.d);
                    if (!collection.isEmpty()) {
                        if (!collection.isEmpty()) {
                            if (collection.size() == 1) {
                                TaskInfo taskInfo = ((TaskInfo[]) collection.toArray(new TaskInfo[1]))[0];
                                z.a(taskInfo, true);
                                if (taskInfo != null && taskInfo.getTaskStatus() == 8) {
                                    new StringBuilder("cancelDownloadSucNoti taskId=").append(taskInfo.getTaskId());
                                    z.cancelNotification(((int) taskInfo.getTaskId()) + 28156);
                                    int indexOf = com.xunlei.downloadprovider.notification.c.a.indexOf(Long.valueOf(taskInfo.getTaskId()));
                                    if (indexOf != -1) {
                                        com.xunlei.downloadprovider.notification.c.a.remove(indexOf);
                                        new StringBuilder("after remove size=").append(com.xunlei.downloadprovider.notification.c.a.size());
                                        if (com.xunlei.downloadprovider.notification.c.a.size() == 0) {
                                            z.cancelNotification(36156);
                                        } else {
                                            z.a(false);
                                        }
                                    }
                                }
                            } else {
                                Iterator it = collection.iterator();
                                while (it.hasNext()) {
                                    TaskInfo taskInfo2 = (TaskInfo) it.next();
                                    if (taskInfo2.getTaskStatus() == 8) {
                                        int indexOf2 = com.xunlei.downloadprovider.notification.c.a.indexOf(Long.valueOf(taskInfo2.getTaskId()));
                                        if (indexOf2 != -1) {
                                            com.xunlei.downloadprovider.notification.c.a.remove(indexOf2);
                                        }
                                    }
                                }
                                new StringBuilder("after remove size=").append(com.xunlei.downloadprovider.notification.c.a.size());
                                if (com.xunlei.downloadprovider.notification.c.a.size() == 0) {
                                    z.cancelNotification(36156);
                                } else {
                                    z.a(false);
                                }
                            }
                        }
                        Collection arrayList = new ArrayList();
                        Iterator it2 = collection.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(Long.valueOf(((TaskInfo) it2.next()).getTaskId()));
                        }
                        z.a(arrayList);
                    }
                    collection = collection.iterator();
                    while (collection.hasNext()) {
                        a(17, (TaskInfo) collection.next(), 8);
                    }
                }
            }
        }
    }

    protected final void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            Collection hashSet = new HashSet();
            Object hashSet2 = new HashSet(this.c.k.values());
            if (!com.xunlei.xllib.b.d.a(hashSet2)) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (str.equals(aVar.c.mLocalFileName)) {
                        StringBuilder stringBuilder = new StringBuilder("remove Task :");
                        stringBuilder.append(aVar.a());
                        stringBuilder.append(" by FilePath = ");
                        stringBuilder.append(str);
                        hashSet.add(Long.valueOf(aVar.a()));
                        break;
                    }
                }
                d(hashSet, z);
            }
        }
    }

    public final long j() {
        return this.c.a.a.b;
    }
}
