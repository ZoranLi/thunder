package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.widget.Toast;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class q extends b {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    q(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void a(TorrentInfo torrentInfo) {
        if (torrentInfo == null) {
            Toast.makeText(this.a, "种子文件解析失败", 0).show();
            this.a.finish();
            return;
        }
        TorrentFileInfo[] torrentFileInfoArr = torrentInfo.mSubFileInfo;
        this.a.c = torrentInfo.mInfoHash;
        a.a.a(new r(this, torrentFileInfoArr, torrentInfo));
    }

    public final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        this.a.c();
        if (i == 0 && lXTaskInfo != null) {
            this.a.finish();
        }
    }
}
