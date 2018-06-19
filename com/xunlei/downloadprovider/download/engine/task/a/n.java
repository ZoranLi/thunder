package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.download.engine.task.a.l.a;

/* compiled from: DownloadEngineCore */
final class n extends Handler {
    final /* synthetic */ a a;

    n(a aVar) {
        this.a = aVar;
    }

    public final void handleMessage(Message message) {
        new StringBuilder("start :").append(message.toString());
        this.a.a(message);
    }
}
