package com.xunlei.downloadprovider.download.engine.task;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: DownloadEngine */
final class j implements MessageListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void handleMessage(Message message) {
        new StringBuilder("start :").append(message.toString());
        switch (message.what) {
            case 100:
            case 101:
                i.a(this.a, message);
                break;
            default:
                break;
        }
        new StringBuilder("end :").append(message.toString());
    }
}
