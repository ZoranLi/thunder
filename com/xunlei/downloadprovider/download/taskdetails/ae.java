package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: DownloadTaskSpHelper */
public final class ae {
    public static synchronized boolean a() {
        boolean z;
        synchronized (ae.class) {
            z = BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).getBoolean("download_showed_comment_guide", false);
        }
        return z;
    }
}
