package com.xunlei.downloadprovider.cardslide;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: CardSlideActivity */
final class l implements MessageListener {
    final /* synthetic */ CardSlideActivity a;

    l(CardSlideActivity cardSlideActivity) {
        this.a = cardSlideActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (!(this.a.w == null || this.a.z == -1)) {
                    this.a.a(this.a.z, this.a.w);
                    break;
                }
            case 1001:
                CardSlideActivity.t(this.a);
                return;
            case 1002:
                this.a.h();
                return;
            default:
                break;
        }
    }
}
