package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.x.a;
import com.xunlei.downloadprovider.download.engine.util.b;

/* compiled from: DownloadTask */
public final class m extends x<TaskInfo> {
    public DownloadInfo a;
    public TaskStatInfo b;
    protected int c = 1;
    public c d;

    public m(a<TaskInfo> aVar) {
        super(aVar);
    }

    public m() {
        super(null);
    }

    public final int a() {
        return this.c;
    }

    public final void a(String str, String str2, long j, String str3, String str4, DownloadAdditionInfo downloadAdditionInfo) {
        DownloadInfo downloadInfo = new DownloadInfo(str, b.a(str2), str3, str4);
        downloadInfo.setExtra(downloadAdditionInfo);
        downloadInfo.mFileSize = j;
        this.a = downloadInfo;
        this.c = 1;
    }

    public final void a(String str, String str2, long j, String str3) {
        DownloadInfo downloadInfo = new DownloadInfo(str, b.a(str2), null, str3);
        downloadInfo.mFileSize = j;
        this.a = downloadInfo;
        this.c = 1;
    }

    public final void a(long j) {
        if (this.a != null) {
            this.a.mCustomFlags = j;
        }
    }

    public final void a(boolean z) {
        if (this.a != null) {
            this.a.mTaskInvisible = z;
        }
    }
}
