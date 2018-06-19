package com.xunlei.downloadprovider.download.util;

import android.content.Context;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadlib.parameter.XLConstant.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

public final class DownloadError {

    public enum FailureCode {
        MEMORY_ERROR,
        INSUFFICIENT_SPACE,
        PATH_CANNOT_BE_WRITTEN,
        TORRENT_NOT_EXIST,
        TORRENT_INVALID,
        BT_PART_SUBTASK_DOWNLOAD_FAILURE,
        BT_ALL_SUBTASK_DOWNLOAD_FAILURE,
        BT_SUBFILE_DOWNLOAD_FAILURE,
        BT_TASK_DOWNLOAD_FAILURE,
        BT_FILE_PARSE_FAILURE,
        MAGNET_LINK_PARSE_FAILURE,
        EMULE_LINK_PARSE_FAILURE,
        FILE_ERROR,
        FILE_NOT_EXIST,
        GET_RESOURCE_NAME_FAILURE,
        RESOURCE_SERVER_CONNECTION_FAILURE,
        RESOURCE_SERVER_CONNECTION_INTERRUPTION,
        SENSITIVE_RESOURCE_DOWNLOAD_LIMITED,
        CONTINUINGLY_TASK_FAILURE,
        DOWNLOAD_INFORMATION_UPDATE_FAILURE,
        TASK_PARAMETER_ERROR,
        TASK_COUNT_MORE_THAN_UPPER_LIMIT,
        TASK_ALREADY_EXISTS,
        TASK_DELETED,
        TASK_LINK_FAILURE,
        TASK_CONTAINS_ILLEGAL_CONTENT,
        ABNORMAL_ACCOUNT,
        CONTRARY_LOCAL_LAWS_AND_REQULATIONS,
        REQUEST_OF_COPYRIGHT_OWNERS
    }

    public enum SpeedupFailureCode {
        UNKNOWN,
        SENSITIVE_RESOURCE_LIMITED,
        SHORT_OF_FLOW
    }

    public static FailureCode a(int i) {
        switch (i) {
            case 198:
            case 111085:
                return FailureCode.INSUFFICIENT_SPACE;
            case Impl.STATUS_CANCELED /*490*/:
                return FailureCode.TASK_DELETED;
            case Impl.STATUS_FILE_ERROR /*492*/:
                return FailureCode.MEMORY_ERROR;
            case 9103:
                return FailureCode.TASK_ALREADY_EXISTS;
            case 9111:
                return FailureCode.TASK_COUNT_MORE_THAN_UPPER_LIMIT;
            case 9112:
                return FailureCode.TASK_PARAMETER_ERROR;
            case XLErrorCode.TORRENT_PARSE_ERROR /*9302*/:
                return FailureCode.TORRENT_INVALID;
            case 11148:
                return FailureCode.TASK_LINK_FAILURE;
            case XLErrorCode.WRITE_FILE_ERR /*111127*/:
                return FailureCode.CONTINUINGLY_TASK_FAILURE;
            case XLErrorCode.OPEN_FILE_ERR /*111128*/:
                return FailureCode.PATH_CANNOT_BE_WRITTEN;
            case XLErrorCode.FILE_CFG_ERASE_ERROR /*111130*/:
                return FailureCode.DOWNLOAD_INFORMATION_UPDATE_FAILURE;
            case XLErrorCode.TASK_FAILURE_NO_DATA_PIPE /*111136*/:
                return FailureCode.RESOURCE_SERVER_CONNECTION_FAILURE;
            case 111137:
                return FailureCode.GET_RESOURCE_NAME_FAILURE;
            case 111151:
            case 111155:
            case 111156:
                return FailureCode.TASK_CONTAINS_ILLEGAL_CONTENT;
            case 111152:
                return FailureCode.ABNORMAL_ACCOUNT;
            case 111153:
                return FailureCode.CONTRARY_LOCAL_LAWS_AND_REQULATIONS;
            case 111154:
                return FailureCode.REQUEST_OF_COPYRIGHT_OWNERS;
            case XLErrorCode.TASK_FAIL_LONG_TIME_NO_RECV_DATA /*111176*/:
                return FailureCode.RESOURCE_SERVER_CONNECTION_INTERRUPTION;
            case XLErrorCode.TASK_FAILURE_QUERY_EMULE_HUB_FAILED /*114001*/:
            case XLErrorCode.TASK_FAILURE_EMULE_NO_RECORD /*114101*/:
                return FailureCode.EMULE_LINK_PARSE_FAILURE;
            case XLErrorCode.TASK_FAILURE_SUBTASK_FAILED /*114002*/:
                return FailureCode.BT_SUBFILE_DOWNLOAD_FAILURE;
            case XLErrorCode.TASK_FAILURE_QUERY_BT_HUB_FAILED /*114004*/:
                return FailureCode.BT_FILE_PARSE_FAILURE;
            case XLErrorCode.TASK_FAILURE_GET_TORRENT_FAILED /*114006*/:
                return FailureCode.MAGNET_LINK_PARSE_FAILURE;
            case XLErrorCode.TASK_FAILURE_ALL_SUBTASK_FAILED /*114009*/:
                return FailureCode.BT_ALL_SUBTASK_DOWNLOAD_FAILURE;
            case XLErrorCode.TASK_FAILURE_THEONLY_SUBTASK_FAILED /*114010*/:
                return FailureCode.BT_TASK_DOWNLOAD_FAILURE;
            case XLErrorCode.TASK_FAILURE_PART_SUBTASK_FAILED /*114011*/:
                return FailureCode.BT_PART_SUBTASK_DOWNLOAD_FAILURE;
            default:
                return 0;
        }
    }

    public static com.xunlei.downloadprovider.download.util.DownloadError.FailureCode a(com.xunlei.downloadprovider.download.engine.task.info.TaskInfo r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.mOriginalStatusCode;
        r1 = com.xunlei.download.DownloadManager.getReason(r0);
        r1 = (int) r1;
        r2 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        if (r1 == r2) goto L_0x001b;
    L_0x000b:
        r2 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        if (r1 == r2) goto L_0x0018;
    L_0x000f:
        r2 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
        if (r1 == r2) goto L_0x0015;
    L_0x0013:
        r1 = 0;
        goto L_0x001d;
    L_0x0015:
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_ALREADY_EXISTS;
        goto L_0x001d;
    L_0x0018:
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.INSUFFICIENT_SPACE;
        goto L_0x001d;
    L_0x001b:
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.FILE_ERROR;
    L_0x001d:
        if (r1 != 0) goto L_0x0042;
    L_0x001f:
        r1 = a(r0);
        r0 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TORRENT_INVALID;
        if (r1 != r0) goto L_0x0042;
    L_0x0027:
        r0 = r3.mTaskType;
        r2 = com.xunlei.download.DownloadManager.TaskType.BT;
        if (r0 != r2) goto L_0x0042;
    L_0x002d:
        r0 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0042 }
        r3 = r3.mUrl;	 Catch:{ URISyntaxException -> 0x0042 }
        r0.<init>(r3);	 Catch:{ URISyntaxException -> 0x0042 }
        r3 = new java.io.File;	 Catch:{ URISyntaxException -> 0x0042 }
        r3.<init>(r0);	 Catch:{ URISyntaxException -> 0x0042 }
        r3 = r3.exists();	 Catch:{ URISyntaxException -> 0x0042 }
        if (r3 != 0) goto L_0x0042;	 Catch:{ URISyntaxException -> 0x0042 }
    L_0x003f:
        r3 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TORRENT_NOT_EXIST;	 Catch:{ URISyntaxException -> 0x0042 }
        r1 = r3;
    L_0x0042:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.DownloadError.a(com.xunlei.downloadprovider.download.engine.task.info.TaskInfo):com.xunlei.downloadprovider.download.util.DownloadError$FailureCode");
    }

    public static SpeedupFailureCode b(TaskInfo taskInfo) {
        SpeedupFailureCode speedupFailureCode = null;
        if (taskInfo == null) {
            return null;
        }
        if (taskInfo.mVipChannelStatus == 16) {
            taskInfo = taskInfo.mVipChannelStatusCode;
            speedupFailureCode = SpeedupFailureCode.UNKNOWN;
            if (10 <= taskInfo && taskInfo <= 30) {
                speedupFailureCode = SpeedupFailureCode.SENSITIVE_RESOURCE_LIMITED;
            } else if (taskInfo == 104) {
                speedupFailureCode = SpeedupFailureCode.SHORT_OF_FLOW;
            }
        }
        return speedupFailureCode;
    }

    public static String a(TaskInfo taskInfo, Context context) {
        taskInfo = a(taskInfo);
        String valueOf = String.valueOf(context.getString(R.string.download_item_task_status_failed));
        if (taskInfo == null) {
            return valueOf;
        }
        switch (d.a[taskInfo.ordinal()]) {
            case 1:
                return String.valueOf(context.getString(R.string.download_item_task_fail_memory_error));
            case 2:
                return String.valueOf(context.getString(R.string.download_item_task_fail_insufficient_space));
            case 3:
                return String.valueOf(context.getString(R.string.download_item_task_fail_path_cannot_be_written));
            case 4:
                return String.valueOf(context.getString(R.string.download_item_task_fail_torrent_not_exist));
            case 5:
                return String.valueOf(context.getString(R.string.download_item_task_fail_torrent_invalid));
            case 6:
                return String.valueOf(context.getString(R.string.download_item_task_fail_bt_part_subtask_download_failure));
            case 7:
                return String.valueOf(context.getString(R.string.download_item_task_fail_bt_all_subtask_download_failure));
            case 8:
                return String.valueOf(context.getString(R.string.download_item_task_fail_bt_subfile_download_failure));
            case 9:
                return String.valueOf(context.getString(R.string.download_item_task_fail_bt_task_download_failure));
            case 10:
                return String.valueOf(context.getString(R.string.download_item_task_fail_bt_file_parse_failure));
            case 11:
                return String.valueOf(context.getString(R.string.download_item_task_fail_magnet_link_parse_failure));
            case 12:
                return String.valueOf(context.getString(R.string.download_item_task_fail_emule_link_parse_failure));
            case 13:
                return String.valueOf(context.getString(R.string.download_item_task_fail_file_error));
            case 14:
                return String.valueOf(context.getString(R.string.download_item_task_file_not_exist));
            case 15:
                return String.valueOf(context.getString(R.string.download_item_task_fail_get_resource_name_failure));
            case 16:
                return String.valueOf(context.getString(R.string.download_item_task_fail_resource_server_connection_failure));
            case 17:
                return String.valueOf(context.getString(R.string.download_item_task_fail_resource_server_connection_interruption));
            case 18:
                return String.valueOf(context.getString(R.string.download_item_task_fail_sensitive_resource_download_limited));
            case 19:
                return String.valueOf(context.getString(R.string.download_item_task_fail_continuingly_task_failure));
            case 20:
                return String.valueOf(context.getString(R.string.download_item_task_fail_download_information_update_failure));
            case 21:
                return String.valueOf(context.getString(R.string.download_item_task_fail_task_parameter_error));
            case 22:
                return String.valueOf(context.getString(R.string.download_item_task_fail_task_count_more_than_upper_limit));
            case 23:
                return String.valueOf(context.getString(R.string.download_item_task_fail_task_already_exists));
            case 24:
                return String.valueOf(context.getString(R.string.download_item_task_fail_task_deleted));
            case 25:
                return String.valueOf(context.getString(R.string.download_item_task_fail_task_contains_illegal_content));
            case 26:
                return String.valueOf(context.getString(R.string.download_item_task_fail_abnormal_account));
            case 27:
                return String.valueOf(context.getString(R.string.download_item_task_fail_contrary_local_laws_and_requlations));
            case 28:
                return String.valueOf(context.getString(R.string.download_item_task_fail_request_of_copyright_owners));
            default:
                return valueOf;
        }
    }

    public static boolean c(TaskInfo taskInfo) {
        return (taskInfo == null || !(taskInfo.mOriginalStatusCode == 111154 || taskInfo.mOriginalStatusCode == 111151 || taskInfo.mOriginalStatusCode == 111152 || taskInfo.mOriginalStatusCode == 111153 || taskInfo.mOriginalStatusCode == 111155 || taskInfo.mOriginalStatusCode == 111156)) ? null : true;
    }
}
