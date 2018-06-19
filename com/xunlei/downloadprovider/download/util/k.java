package com.xunlei.downloadprovider.download.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.io.File;

/* compiled from: TaskHelper */
public final class k {
    public static boolean a(TaskInfo taskInfo) {
        if (taskInfo == null || taskInfo.mTaskType == TaskType.MAGNET) {
            return false;
        }
        if (TextUtils.isEmpty(taskInfo.mLocalFileName)) {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
        } else {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
        }
        if (taskInfo == EFileCategoryType.E_VIDEO_CATEGORY) {
            return true;
        }
        return false;
    }

    public static boolean b(TaskInfo taskInfo) {
        if (!(taskInfo == null || taskInfo.mTaskType == TaskType.MAGNET)) {
            if (taskInfo.mTaskType != TaskType.BT) {
                if (TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                    taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
                } else {
                    taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
                }
                if (taskInfo == EFileCategoryType.E_MUSIC_CATEGORY) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean c(TaskInfo taskInfo) {
        if (!a(taskInfo)) {
            if (b(taskInfo) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean a(BTSubTaskInfo bTSubTaskInfo) {
        if (bTSubTaskInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(bTSubTaskInfo.mLocalFileName)) {
            bTSubTaskInfo = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskInfo.mTitle);
        } else {
            bTSubTaskInfo = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskInfo.mLocalFileName);
        }
        if (bTSubTaskInfo == EFileCategoryType.E_MUSIC_CATEGORY) {
            return true;
        }
        return false;
    }

    public static boolean b(BTSubTaskInfo bTSubTaskInfo) {
        if (bTSubTaskInfo == null) {
            return false;
        }
        if (!a(bTSubTaskInfo.mLocalFileName)) {
            if (a(bTSubTaskInfo.mTitle) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(BTSubTaskInfo bTSubTaskInfo) {
        if (!b(bTSubTaskInfo)) {
            if (a(bTSubTaskInfo) == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && XLFileTypeUtil.getFileCategoryTypeByName(str) == EFileCategoryType.E_VIDEO_CATEGORY) {
            return true;
        }
        return false;
    }

    public static boolean d(TaskInfo taskInfo) {
        return (taskInfo == null || taskInfo.getTaskStatus() != 8) ? null : true;
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        return downloadTaskInfo != null && downloadTaskInfo.mVipChannelStatusCode == -100;
    }

    public static boolean e(TaskInfo taskInfo) {
        return taskInfo != null && taskInfo.mTaskType == TaskType.BT;
    }

    public static String f(TaskInfo taskInfo) {
        if (!(taskInfo == null || taskInfo.mTaskType != TaskType.BT || TextUtils.isEmpty(taskInfo.mLocalFileName))) {
            if (!TextUtils.isEmpty(taskInfo.mInfoHash)) {
                String str;
                if (taskInfo.mLocalFileName.endsWith("/")) {
                    str = taskInfo.mLocalFileName;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(taskInfo.mLocalFileName);
                    stringBuilder.append("/");
                    str = stringBuilder.toString();
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(".");
                stringBuilder2.append(taskInfo.mInfoHash);
                stringBuilder2.append(".torrent");
                return stringBuilder2.toString();
            }
        }
        return null;
    }

    public static boolean g(TaskInfo taskInfo) {
        if (taskInfo == null || taskInfo.mTaskType == TaskType.MAGNET) {
            return false;
        }
        if (TextUtils.isEmpty(taskInfo.mLocalFileName)) {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
        } else {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
        }
        if (taskInfo == EFileCategoryType.E_SOFTWARE_CATEGORY) {
            return true;
        }
        return false;
    }

    public static boolean b(DownloadTaskInfo downloadTaskInfo) {
        boolean z = downloadTaskInfo.isUnseen() && downloadTaskInfo.getTaskStatus() == 8;
        return (downloadTaskInfo.mIsFileMissing || ((downloadTaskInfo.isConsumed() && (downloadTaskInfo.mTaskType == TaskType.MAGNET || downloadTaskInfo.mFileCategoryType == EFileCategoryType.E_VIDEO_CATEGORY)) || (downloadTaskInfo.mFileCategoryType == EFileCategoryType.E_VIDEO_CATEGORY && downloadTaskInfo.mVideoPlayedTime > null))) ? false : z;
    }

    public static String a(Context context, BTSubTaskItem bTSubTaskItem) {
        String str = "";
        if (bTSubTaskItem != null) {
            if (!TextUtils.isEmpty(bTSubTaskItem.mLocalFileName)) {
                if (XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mLocalFileName) == EFileCategoryType.E_SOFTWARE_CATEGORY && bTSubTaskItem.mTaskStatus == 8) {
                    context = ApkHelper.getApkInfo(context, bTSubTaskItem.mLocalFileName);
                    if (context != null) {
                        context = context.getApkLabel();
                        if (context != null) {
                            bTSubTaskItem = new StringBuilder();
                            bTSubTaskItem.append(context);
                            bTSubTaskItem.append(ShareConstants.PATCH_SUFFIX);
                            str = bTSubTaskItem.toString();
                        }
                    }
                } else {
                    str = bTSubTaskItem.mTitle;
                }
                return str;
            }
        }
        return "";
    }

    public static Drawable a(String str, Context context) {
        context = context.getPackageManager();
        PackageInfo packageArchiveInfo = context.getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return applicationInfo.loadIcon(context);
    }

    public static String b(String str, Context context) {
        context = context.getPackageManager().getPackageArchiveInfo(str, 1);
        if (context == null) {
            return null;
        }
        ApplicationInfo applicationInfo = context.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return context.versionName;
    }

    public static boolean c(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            if (!TextUtils.isEmpty(downloadTaskInfo.mLocalFileName)) {
                return new File(downloadTaskInfo.mLocalFileName).exists();
            }
        }
        return null;
    }

    public static String h(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return "dl_unfinish";
        }
        return taskInfo.getTaskStatus() == 8 ? "dl_finish" : "dl_unfinish";
    }

    public static boolean d(DownloadTaskInfo downloadTaskInfo) {
        if (a.a().e == downloadTaskInfo.getTaskId() && downloadTaskInfo.mIsEnteredHighSpeedTrial && !a(downloadTaskInfo) && i(downloadTaskInfo) > 0) {
            return true;
        }
        return false;
    }

    public static long i(TaskInfo taskInfo) {
        if (taskInfo.getTaskId() != a.a().e) {
            return -1;
        }
        long j = 0;
        n.a();
        taskInfo = n.f(taskInfo.getTaskId());
        if (taskInfo != null) {
            float g = a.g();
            long j2 = (long) (((float) taskInfo.mFileSize) * g);
            long d = (a.a().d() - taskInfo.mDownloadedSize) + j2;
            StringBuilder stringBuilder = new StringBuilder("downloadSize: ");
            stringBuilder.append(taskInfo.mDownloadedSize);
            stringBuilder.append("  beforeTry:  ");
            stringBuilder.append(a.a().d());
            stringBuilder.append("  canUse :");
            stringBuilder.append(j2);
            stringBuilder.append("   factor: ");
            stringBuilder.append(g);
            j = d;
        }
        return j;
    }

    public static long j(TaskInfo taskInfo) {
        n.a();
        TaskInfo f = n.f(taskInfo.getTaskId());
        if (f != null) {
            taskInfo = f;
        }
        return (long) (((float) taskInfo.mFileSize) * a.g());
    }

    public static boolean a(TaskInfo taskInfo, long j) {
        return (taskInfo.mVipChannelStatusCode != -100 && j > 0) ? null : true;
    }

    public static boolean k(TaskInfo taskInfo) {
        if (taskInfo.mVipChannelStatusCode == -100) {
            return true;
        }
        if ((a.a().d() - taskInfo.mDownloadedSize) + ((long) (((float) taskInfo.mFileSize) * a.g())) > 0) {
            return null;
        }
        return true;
    }
}
