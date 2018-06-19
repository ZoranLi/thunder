package com.xunlei.downloadprovider.homepage.redpacket;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: RedPacketGuideDlg */
final class g implements MessageListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1003:
                a.a(this.a, message);
                return;
            case 1004:
                this.a.a(true);
                return;
            case 1005:
                this.a.dismiss();
                break;
            default:
                break;
        }
    }
}
