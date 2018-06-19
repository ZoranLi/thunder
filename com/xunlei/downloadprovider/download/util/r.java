package com.xunlei.downloadprovider.download.util;

import android.text.TextUtils;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.HashMap;

/* compiled from: TaskTypeIconUtil */
public final class r {

    /* compiled from: TaskTypeIconUtil */
    public static class a {
        static final HashMap<String, Integer> a = new TaskTypeIconUtil$TaskTypeSmallImageStyle1$1();

        public static int a(TaskInfo taskInfo, EFileCategoryType eFileCategoryType) {
            String str = taskInfo.mTitle;
            if (str != null) {
                str = str.trim();
            }
            TaskType taskType = taskInfo.mTaskType;
            TaskType taskType2 = TaskType.BT;
            int i = R.drawable.ic_dl_music_style1;
            if (taskType == taskType2) {
                i = R.drawable.ic_dl_folder_style1;
            } else if (taskInfo.mTaskType == TaskType.MAGNET) {
                i = R.drawable.ic_dl_magnet_style1;
            } else {
                taskInfo = null;
                if (str != null) {
                    taskInfo = XLFileTypeUtil.extractFileExt(str, false).toLowerCase();
                    if (a.containsKey(taskInfo)) {
                        taskInfo = ((Integer) a.get(taskInfo)).intValue();
                    } else {
                        if (str != null) {
                            switch (s.a[XLFileTypeUtil.getFileCategoryTypeByName(str).ordinal()]) {
                                case 1:
                                    break;
                                case 2:
                                    taskInfo = 2130838473;
                                    break;
                                case 3:
                                    taskInfo = 2130838485;
                                    break;
                                case 4:
                                    taskInfo = 2130838450;
                                    break;
                                case 5:
                                    taskInfo = 2130838462;
                                    break;
                                case 6:
                                    taskInfo = 2130838479;
                                    break;
                                case 7:
                                    taskInfo = 2130838487;
                                    break;
                                default:
                                    break;
                            }
                        }
                        taskInfo = 2130838475;
                    }
                }
                if ((taskInfo == 2130838475 || taskInfo == null) && eFileCategoryType != null) {
                    switch (s.a[eFileCategoryType.ordinal()]) {
                        case 1:
                            i = R.drawable.ic_dl_video_default_style1;
                            break;
                        case 2:
                            break;
                        case 3:
                            i = R.drawable.ic_dl_text_style1;
                            break;
                        case 4:
                            i = R.drawable.ic_dl_apk_bg_style1;
                            break;
                        case 5:
                            i = R.drawable.ic_dl_image_style1;
                            break;
                        case 6:
                            i = R.drawable.ic_dl_rar_style1;
                            break;
                        case 7:
                            i = R.drawable.ic_dl_torrent_style1;
                            break;
                        default:
                            i = R.drawable.ic_dl_other_style1;
                            break;
                    }
                }
                i = taskInfo;
            }
            return i == 0 ? R.drawable.ic_dl_other_style1 : i;
        }
    }

    public static EFileCategoryType a(TaskInfo taskInfo) {
        if (taskInfo == null) {
            return null;
        }
        if (taskInfo.mTaskType == TaskType.MAGNET) {
            return EFileCategoryType.E_TORRENT_CATEGORY;
        }
        if (taskInfo instanceof DownloadTaskInfo) {
            DownloadTaskInfo downloadTaskInfo = (DownloadTaskInfo) taskInfo;
            if (downloadTaskInfo.mFileCategoryType != null) {
                if (downloadTaskInfo.mFileCategoryType != EFileCategoryType.E_OTHER_CATEGORY) {
                    taskInfo = downloadTaskInfo.mFileCategoryType;
                }
            }
            if (TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
            } else {
                taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
            }
            downloadTaskInfo.mFileCategoryType = taskInfo;
        } else if (TextUtils.isEmpty(taskInfo.mLocalFileName)) {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
        } else {
            taskInfo = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
        }
        return taskInfo;
    }
}
