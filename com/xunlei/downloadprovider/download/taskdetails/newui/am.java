package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.player.a.m$a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: DownloadDetailsActivityFragment */
final class am implements m$a {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    am(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a() {
        DownloadDetailsActivityFragment.q;
        if (this.a.f != null) {
            this.a.a("dl_play_fullscreen");
            DownloadDetailsActivityFragment downloadDetailsActivityFragment = this.a;
            DownloadTaskInfo downloadTaskInfo = this.a.f;
            DownloadDetailsActivityFragment.g(downloadDetailsActivityFragment);
        }
    }

    public final void b() {
        DownloadDetailsActivityFragment.q;
        this.a.m();
    }
}
