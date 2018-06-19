package com.xunlei.downloadprovider.download.util.a.a;

import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: TaskSnapshotModel */
public final class e {
    public DownloadTaskInfo a;
    public BTSubTaskInfo b;
    public String c;
    private final float d = 0.05f;

    public e(String str) {
        this.c = str;
    }

    static boolean a(long j, long j2) {
        if (j2 > 0) {
            if (j > 0) {
                return j > ((long) Math.round(((float) j2) * 0.05f)) ? 1 : false;
            }
        }
        return false;
    }
}
