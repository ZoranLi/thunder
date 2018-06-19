package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BUGLY */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;
    protected String a;
    protected String b;
    protected String c;
    protected List<DownloadListener> d = new CopyOnWriteArrayList();
    protected long e;
    protected long f;
    protected boolean g = true;
    protected String h = "";
    protected int i = 0;
    protected int j = 1;

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public abstract File getSaveFile();

    public abstract int getStatus();

    public abstract void stop();

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.h = str4;
    }

    public long getTotalLength() {
        return this.f;
    }

    public void setTotalLength(long j) {
        this.f = j;
    }

    public long getSavedLength() {
        return this.e;
    }

    public void setSavedLength(long j) {
        this.e = j;
    }

    public String getDownloadUrl() {
        return this.a;
    }

    public void setNeededNotify(boolean z) {
        this.g = z;
    }

    public String getMD5() {
        return this.h;
    }

    public int getDownloadType() {
        return this.j;
    }

    public void setDownloadType(int i) {
        this.j = i;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener != null && !this.d.contains(downloadListener)) {
            this.d.add(downloadListener);
        }
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return (downloadListener == null || this.d.remove(downloadListener) == null) ? null : true;
    }

    public boolean isNeededNotify() {
        return this.g;
    }
}
