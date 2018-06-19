package com.xunlei.downloadprovider.personal.a.b.c;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserOneGridScoreViewHolder */
final class g implements MessageListener {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 103:
                this.a.b(false);
                e.d(this.a);
                return;
            case 104:
                this.a.b(false);
                return;
            case 105:
                e.e(this.a);
                return;
            case 106:
                this.a.b(false);
                this.a.c(this.a.p);
                break;
            default:
                break;
        }
    }
}
