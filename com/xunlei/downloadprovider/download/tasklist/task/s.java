package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.download.engine.task.a.k;
import com.xunlei.downloadprovider.download.engine.task.a.r;
import com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.util.e;
import com.xunlei.downloadprovider.download.util.e.a;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.xllib.b.c;

/* compiled from: TaskWrapper */
public class s extends k {
    public final DownloadTaskInfo b = new DownloadTaskInfo();
    r<s> c;
    private TaskSpeedCountInfo d;

    s(@NonNull z zVar) {
        super(zVar);
        this.b.setTaskId(zVar.a());
    }

    public final long a() {
        return super.a();
    }

    public final int b() {
        if (this.b == null) {
            return super.b();
        }
        return this.b.getTaskStatus();
    }

    public final TaskInfo c() {
        return this.b;
    }

    @NonNull
    public final TaskSpeedCountInfo a(boolean z) {
        if (z || !this.d) {
            n.a();
            z = n.m(super.a());
            if (z) {
                this.d = z;
            }
        }
        if (!this.d) {
            this.d = new TaskSpeedCountInfo();
            this.d.mTaskId = super.a();
        }
        return this.d;
    }

    public final boolean d() {
        if (this.b == null) {
            return super.d();
        }
        return this.b.isTaskInvisible();
    }

    public final long f() {
        return this.a.f();
    }

    public final void i() {
        if (this.b != null) {
            a(this.a);
            a(this.b, this.a.c());
        }
    }

    public final void j() {
        if (this.b != null && this.b.isUnseen() && this.b.getTaskStatus() == 8) {
            this.b.markToSeen();
            l();
            n.a();
            n.a(this.b);
        }
    }

    final void a(@NonNull z zVar) {
        if (this.b != null) {
            if (zVar.c() != null) {
                TaskInfo.syncTaskBasicInfo(zVar.c(), this.b);
            }
            TaskInfo.calculateTaskRunningData(this.b);
        }
    }

    final void k() {
        int i;
        TaskInfo c;
        DownloadTaskInfo downloadTaskInfo = this.b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = downloadTaskInfo.mDownloadSpeed;
        if (j <= 0 || downloadTaskInfo.mFileSize <= 0) {
            downloadTaskInfo.mDownloadRemainTime = -1;
        } else {
            long j2 = downloadTaskInfo.mFileSize - downloadTaskInfo.mDownloadedSize;
            if (j2 > 0) {
                downloadTaskInfo.mDownloadRemainTime = j2 / j;
            }
        }
        if (downloadTaskInfo.mEpisodeTagText == null) {
            downloadTaskInfo.mEpisodeTagText = "";
            a a = e.a(downloadTaskInfo.mTitle);
            if (!(a == null || downloadTaskInfo.mTitle.contains("magnet") || downloadTaskInfo.mTaskType == TaskType.MAGNET)) {
                Object obj = "";
                if (a.b > 0) {
                    StringBuilder stringBuilder = new StringBuilder("第");
                    stringBuilder.append(a.b);
                    stringBuilder.append("集");
                    obj = stringBuilder.toString();
                }
                StringBuilder stringBuilder2;
                if (!TextUtils.isEmpty(a.d)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a.d);
                    stringBuilder2.append(" ");
                    stringBuilder2.append(obj);
                    obj = stringBuilder2.toString();
                } else if (a.a > 0) {
                    stringBuilder2 = new StringBuilder("第");
                    stringBuilder2.append(c.a(a.a));
                    stringBuilder2.append("季 ");
                    stringBuilder2.append(obj);
                    obj = stringBuilder2.toString();
                }
                if (!TextUtils.isEmpty(obj)) {
                    downloadTaskInfo.mEpisodeTagText = obj;
                    i = 1;
                    if (downloadTaskInfo.mFileCategoryType == null || downloadTaskInfo.mFileCategoryType == EFileCategoryType.E_OTHER_CATEGORY) {
                        if (TextUtils.isEmpty(downloadTaskInfo.mLocalFileName)) {
                            downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mLocalFileName);
                        } else {
                            downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mTitle);
                        }
                    }
                    if (a(downloadTaskInfo, elapsedRealtime, false)) {
                        i++;
                    }
                    c = this.a.c();
                    if (c != null && downloadTaskInfo.isUnseen() && downloadTaskInfo.setSeenFlag(c.getSeenFlag())) {
                        i++;
                    }
                    a(downloadTaskInfo, c);
                    if (i > 0) {
                        downloadTaskInfo.mRevision++;
                    }
                }
            }
        }
        i = 0;
        if (TextUtils.isEmpty(downloadTaskInfo.mLocalFileName)) {
            downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mTitle);
        } else {
            downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mLocalFileName);
        }
        if (a(downloadTaskInfo, elapsedRealtime, false)) {
            i++;
        }
        c = this.a.c();
        i++;
        a(downloadTaskInfo, c);
        if (i > 0) {
            downloadTaskInfo.mRevision++;
        }
    }

    private static void a(DownloadTaskInfo downloadTaskInfo, TaskInfo taskInfo) {
        if (taskInfo != null && !TextUtils.isEmpty(taskInfo.mRefUrl) && TextUtils.isEmpty(downloadTaskInfo.mRefUrl)) {
            downloadTaskInfo.mRefUrl = taskInfo.mRefUrl;
        } else if (!(taskInfo == null || taskInfo.mExtraInfo == null || TextUtils.isEmpty(taskInfo.mExtraInfo.mRefUrl) || !TextUtils.isEmpty(downloadTaskInfo.mRefUrl))) {
            downloadTaskInfo.mRefUrl = taskInfo.mExtraInfo.mRefUrl;
        }
        if (taskInfo != null && !TextUtils.isEmpty(taskInfo.mWebsiteName) && TextUtils.isEmpty(downloadTaskInfo.mWebsiteName)) {
            downloadTaskInfo.mWebsiteName = taskInfo.mWebsiteName;
        } else if (!(taskInfo == null || taskInfo.mExtraInfo == null || TextUtils.isEmpty(taskInfo.mExtraInfo.mWebsiteName) || !TextUtils.isEmpty(downloadTaskInfo.mWebsiteName))) {
            downloadTaskInfo.mWebsiteName = taskInfo.mExtraInfo.mWebsiteName;
        }
        if (!(taskInfo == null || TextUtils.isEmpty(taskInfo.mIconUrl) || !TextUtils.isEmpty(downloadTaskInfo.mIconUrl))) {
            downloadTaskInfo.mIconUrl = taskInfo.mIconUrl;
        }
        if (!(taskInfo == null || TextUtils.isEmpty(taskInfo.mDisplayName) || !TextUtils.isEmpty(downloadTaskInfo.mDisplayName))) {
            downloadTaskInfo.mDisplayName = taskInfo.mDisplayName;
        }
        if (!(taskInfo == null || TextUtils.isEmpty(taskInfo.mCreateOrigin) || !TextUtils.isEmpty(downloadTaskInfo.mCreateOrigin))) {
            downloadTaskInfo.mCreateOrigin = taskInfo.mCreateOrigin;
        }
        if (taskInfo != null) {
            downloadTaskInfo.setVodStatus(taskInfo.getVodStatus());
        }
    }

    static boolean a(com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo r8, long r9, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r8.getTaskStatus();
        r1 = 0;
        r2 = 8;
        if (r0 != r2) goto L_0x004a;
    L_0x0009:
        r2 = r8.mIsFileMissingLMT;
        r4 = r9 - r2;
        if (r11 != 0) goto L_0x0021;
    L_0x000f:
        r2 = r8.mIsFileMissingLMT;
        r6 = 0;
        r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r11 <= 0) goto L_0x0021;
    L_0x0017:
        r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r11 < 0) goto L_0x0021;
    L_0x001b:
        r2 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r11 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r11 < 0) goto L_0x004c;
    L_0x0021:
        r8.mIsFileMissing = r1;
        r11 = 1;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0047 }
        r1 = r8.mLocalFileName;	 Catch:{ Exception -> 0x0047 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0047 }
        r0 = r0.exists();	 Catch:{ Exception -> 0x0047 }
        if (r0 != 0) goto L_0x0033;	 Catch:{ Exception -> 0x0047 }
    L_0x0031:
        r8.mIsFileMissing = r11;	 Catch:{ Exception -> 0x0047 }
    L_0x0033:
        r0 = r8.isConsumed();	 Catch:{ Exception -> 0x0047 }
        if (r0 != 0) goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0039:
        com.xunlei.downloadprovider.download.engine.task.a.a.a.a();	 Catch:{ Exception -> 0x0047 }
        r0 = r8.getTaskId();	 Catch:{ Exception -> 0x0047 }
        r0 = com.xunlei.downloadprovider.download.engine.task.a.a.a.b(r0);	 Catch:{ Exception -> 0x0047 }
        r8.setConsumed(r0);	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        r8.mIsFileMissingLMT = r9;
        return r11;
    L_0x004a:
        r8.mIsFileMissing = r1;
    L_0x004c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.task.s.a(com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo, long, boolean):boolean");
    }

    final boolean a(long j, boolean z) {
        DownloadTaskInfo downloadTaskInfo = this.b;
        long j2 = j - downloadTaskInfo.mVideoDurationLMT;
        if (downloadTaskInfo.mLocalFileName != null && TextUtils.isEmpty(downloadTaskInfo.mDownloadingPlayUrl) && downloadTaskInfo.getTaskStatus() != 16 && !downloadTaskInfo.mIsFileMissing && downloadTaskInfo.mDownloadedSize > 0 && (j - downloadTaskInfo.mDownloadingPlayUrlLMT >= 5000 || downloadTaskInfo.mDownloadingPlayUrl == null)) {
            n.a();
            downloadTaskInfo.mDownloadingPlayUrl = n.c(downloadTaskInfo.mLocalFileName);
            if (downloadTaskInfo.mDownloadingPlayUrl == null) {
                downloadTaskInfo.mDownloadingPlayUrl = "";
            }
            downloadTaskInfo.mDownloadingPlayUrlLMT = j;
        }
        if (downloadTaskInfo.getTaskStatus() != 8 || downloadTaskInfo.mLocalFileName == null || (!z && j2 >= 0 && j2 < 5000 && downloadTaskInfo.mVideoDurationLMT > 0)) {
            return 0;
        }
        try {
            v.a().a(downloadTaskInfo.mLocalFileName, new t(this, downloadTaskInfo), downloadTaskInfo.mDownloadingPlayUrl);
        } catch (boolean z2) {
            z2.printStackTrace();
        }
        downloadTaskInfo.mVideoDurationLMT = j;
        return 1;
    }

    final void l() {
        DownloadTaskInfo downloadTaskInfo = this.b;
        downloadTaskInfo.mRevision++;
    }

    public final void a(z zVar, String str) {
        if ("UPDATE_GCID".equals(str)) {
            if (this.b.mExtraInfo == null) {
                this.b.syncExtraInfo();
            }
            if (this.b.mExtraInfo != null) {
                TaskExtraInfo taskExtraInfo = this.b.mExtraInfo;
                zVar = zVar.c().mExtraInfo;
                if (zVar != null) {
                    taskExtraInfo.mCID = zVar.mCID;
                    taskExtraInfo.mGCID = zVar.mGCID;
                }
                l();
            }
            if (this.c != null) {
                this.c.a(this, str);
            }
        }
    }
}
