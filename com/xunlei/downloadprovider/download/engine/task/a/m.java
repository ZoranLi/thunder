package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: DownloadEngineCore */
final class m implements MessageListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void handleMessage(Message message) {
        if (this.a.k != null) {
            this.a.k.handleMessage(message);
        }
    }
}
