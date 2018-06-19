package com.baidu.mobads.openad.interfaces.download;

import java.util.Observer;

public interface IOAdDownloader {

    public enum DownloadStatus {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");
        
        private int a;
        private String b;

        private DownloadStatus(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public final int getCode() {
            return this.a;
        }

        public final String getMessage() {
            return this.b;
        }
    }

    void addObserver(Observer observer);

    void cancel();

    int getFileSize();

    String getOutputPath();

    String getPackageName();

    float getProgress();

    DownloadStatus getState();

    String getTargetURL();

    String getTitle();

    String getURL();

    boolean isPausedManually();

    void pause();

    void removeObservers();

    void resume();

    void setPausedManually(boolean z);

    void start();
}
