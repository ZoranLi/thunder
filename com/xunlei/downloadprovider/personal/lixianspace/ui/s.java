package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.downloadlib.parameter.TorrentInfo;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class s implements MessageListener {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    s(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 2) {
            this.a.e.setVisibility(0);
            this.a.f = new a(this.a, ((TorrentInfo) message.obj).mSubFileInfo);
            LXSpaceCreateTaskByMagnetUrlActivity.i(this.a);
            if (this.a.i.size() == this.a.j.size()) {
                this.a.g.a(false);
            }
            this.a.e.setAdapter(this.a.f);
            this.a.h.setVisibility(8);
        }
    }
}
