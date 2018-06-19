package com.tencent.bugly.beta.download;

/* compiled from: BUGLY */
public interface DownloadListener {
    void onCompleted(DownloadTask downloadTask);

    void onFailed(DownloadTask downloadTask, int i, String str);

    void onReceive(DownloadTask downloadTask);
}
