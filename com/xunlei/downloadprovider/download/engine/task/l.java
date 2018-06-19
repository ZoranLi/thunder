package com.xunlei.downloadprovider.download.engine.task;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: DownloadEngineServiceLike */
final class l implements MessageListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 122) {
            k.a(this.a);
        }
    }
}
