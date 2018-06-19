package com.xunlei.downloadprovider.download.util;

import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;

/* compiled from: DownloadError */
final /* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[FailureCode.values().length];

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.values();
        r0 = r0.length;
        r0 = new int[r0];
        a = r0;
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.MEMORY_ERROR;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x001f }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.INSUFFICIENT_SPACE;	 Catch:{ NoSuchFieldError -> 0x001f }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x002a }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.PATH_CANNOT_BE_WRITTEN;	 Catch:{ NoSuchFieldError -> 0x002a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
        r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
    L_0x002a:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TORRENT_NOT_EXIST;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
        r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
    L_0x0035:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TORRENT_INVALID;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
        r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
    L_0x0040:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x004b }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.BT_PART_SUBTASK_DOWNLOAD_FAILURE;	 Catch:{ NoSuchFieldError -> 0x004b }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
        r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
    L_0x004b:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.BT_ALL_SUBTASK_DOWNLOAD_FAILURE;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
        r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
    L_0x0056:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.BT_SUBFILE_DOWNLOAD_FAILURE;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
        r2 = 8;	 Catch:{ NoSuchFieldError -> 0x0062 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0062 }
    L_0x0062:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x006e }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.BT_TASK_DOWNLOAD_FAILURE;	 Catch:{ NoSuchFieldError -> 0x006e }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x006e }
        r2 = 9;	 Catch:{ NoSuchFieldError -> 0x006e }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x006e }
    L_0x006e:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x007a }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.BT_FILE_PARSE_FAILURE;	 Catch:{ NoSuchFieldError -> 0x007a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007a }
        r2 = 10;	 Catch:{ NoSuchFieldError -> 0x007a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007a }
    L_0x007a:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.MAGNET_LINK_PARSE_FAILURE;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
        r2 = 11;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0086 }
    L_0x0086:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.EMULE_LINK_PARSE_FAILURE;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0092 }
        r2 = 12;	 Catch:{ NoSuchFieldError -> 0x0092 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0092 }
    L_0x0092:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x009e }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.FILE_ERROR;	 Catch:{ NoSuchFieldError -> 0x009e }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x009e }
        r2 = 13;	 Catch:{ NoSuchFieldError -> 0x009e }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x009e }
    L_0x009e:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00aa }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.FILE_NOT_EXIST;	 Catch:{ NoSuchFieldError -> 0x00aa }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00aa }
        r2 = 14;	 Catch:{ NoSuchFieldError -> 0x00aa }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00aa }
    L_0x00aa:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.GET_RESOURCE_NAME_FAILURE;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r2 = 15;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00b6 }
    L_0x00b6:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00c2 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.RESOURCE_SERVER_CONNECTION_FAILURE;	 Catch:{ NoSuchFieldError -> 0x00c2 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00c2 }
        r2 = 16;	 Catch:{ NoSuchFieldError -> 0x00c2 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00c2 }
    L_0x00c2:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00ce }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.RESOURCE_SERVER_CONNECTION_INTERRUPTION;	 Catch:{ NoSuchFieldError -> 0x00ce }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ce }
        r2 = 17;	 Catch:{ NoSuchFieldError -> 0x00ce }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00ce }
    L_0x00ce:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00da }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.SENSITIVE_RESOURCE_DOWNLOAD_LIMITED;	 Catch:{ NoSuchFieldError -> 0x00da }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00da }
        r2 = 18;	 Catch:{ NoSuchFieldError -> 0x00da }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00da }
    L_0x00da:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00e6 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.CONTINUINGLY_TASK_FAILURE;	 Catch:{ NoSuchFieldError -> 0x00e6 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00e6 }
        r2 = 19;	 Catch:{ NoSuchFieldError -> 0x00e6 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00e6 }
    L_0x00e6:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00f2 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.DOWNLOAD_INFORMATION_UPDATE_FAILURE;	 Catch:{ NoSuchFieldError -> 0x00f2 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00f2 }
        r2 = 20;	 Catch:{ NoSuchFieldError -> 0x00f2 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00f2 }
    L_0x00f2:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00fe }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_PARAMETER_ERROR;	 Catch:{ NoSuchFieldError -> 0x00fe }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00fe }
        r2 = 21;	 Catch:{ NoSuchFieldError -> 0x00fe }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00fe }
    L_0x00fe:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x010a }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_COUNT_MORE_THAN_UPPER_LIMIT;	 Catch:{ NoSuchFieldError -> 0x010a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x010a }
        r2 = 22;	 Catch:{ NoSuchFieldError -> 0x010a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x010a }
    L_0x010a:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0116 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_ALREADY_EXISTS;	 Catch:{ NoSuchFieldError -> 0x0116 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0116 }
        r2 = 23;	 Catch:{ NoSuchFieldError -> 0x0116 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0116 }
    L_0x0116:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0122 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_DELETED;	 Catch:{ NoSuchFieldError -> 0x0122 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0122 }
        r2 = 24;	 Catch:{ NoSuchFieldError -> 0x0122 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0122 }
    L_0x0122:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x012e }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.TASK_CONTAINS_ILLEGAL_CONTENT;	 Catch:{ NoSuchFieldError -> 0x012e }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x012e }
        r2 = 25;	 Catch:{ NoSuchFieldError -> 0x012e }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x012e }
    L_0x012e:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x013a }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.ABNORMAL_ACCOUNT;	 Catch:{ NoSuchFieldError -> 0x013a }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x013a }
        r2 = 26;	 Catch:{ NoSuchFieldError -> 0x013a }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x013a }
    L_0x013a:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0146 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.CONTRARY_LOCAL_LAWS_AND_REQULATIONS;	 Catch:{ NoSuchFieldError -> 0x0146 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0146 }
        r2 = 27;	 Catch:{ NoSuchFieldError -> 0x0146 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0146 }
    L_0x0146:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0152 }
        r1 = com.xunlei.downloadprovider.download.util.DownloadError.FailureCode.REQUEST_OF_COPYRIGHT_OWNERS;	 Catch:{ NoSuchFieldError -> 0x0152 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0152 }
        r2 = 28;	 Catch:{ NoSuchFieldError -> 0x0152 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0152 }
    L_0x0152:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.d.<clinit>():void");
    }
}
