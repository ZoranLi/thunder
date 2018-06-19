package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Handler;
import android.os.Message;
import com.alibaba.sdk.android.feedback.xblink.i.g;

class m extends Handler {
    final Handler a;

    public m(Handler handler) {
        super(handler.getLooper());
        this.a = handler;
    }

    public void handleMessage(Message message) {
        StringBuilder stringBuilder;
        try {
            if (g.a()) {
                stringBuilder = new StringBuilder("handle message: ");
                stringBuilder.append(message.what);
                g.a("WebCoreProxyHandler", stringBuilder.toString());
            }
            this.a.handleMessage(message);
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("handleMessage exception: ");
            stringBuilder.append(th);
            g.b("WebCoreProxyHandler", stringBuilder.toString());
        }
    }
}
