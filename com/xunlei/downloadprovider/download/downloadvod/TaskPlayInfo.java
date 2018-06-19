package com.xunlei.downloadprovider.download.downloadvod;

import android.text.TextUtils;

public class TaskPlayInfo extends DownloadVodInfo {
    private static final String TAG = "TaskPlayInfo";
    private static final long serialVersionUID = 1;
    public String mLocalFileName;
    public String mTitle;

    public TaskPlayInfo(long j, int i) {
        if (j >= 0) {
            this.mTaskId = j;
            this.mBtSubIndex = i;
        }
    }

    public TaskPlayInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPlayUrl = str;
            this.mLocalFileName = this.mPlayUrl;
            this.mIsLocalPlay = true;
        }
    }
}
