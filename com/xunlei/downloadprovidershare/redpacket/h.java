package com.xunlei.downloadprovidershare.redpacket;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: RedPacketShareDlgView */
final class h implements MessageListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1001) {
            if (i == 1003) {
                g.a(this.a);
            }
            return;
        }
        g.a(this.a, message);
    }
}
