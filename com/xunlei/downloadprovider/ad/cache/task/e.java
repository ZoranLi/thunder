package com.xunlei.downloadprovider.ad.cache.task;

import android.os.Handler.Callback;
import android.os.Message;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;

/* compiled from: ExpireTask */
final class e implements Callback {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (message.obj instanceof STYLES_INFO) {
                    STYLES_INFO styles_info = (STYLES_INFO) message.obj;
                    if (this.a.c.contains(styles_info)) {
                        new StringBuilder("handle expired cache stylesInfo: ").append(styles_info.name());
                        this.a.b.a(styles_info);
                        break;
                    }
                }
                break;
            case 1001:
                synchronized (this.a.c) {
                    for (STYLES_INFO styles_info2 : this.a.c) {
                        new StringBuilder("cyclical handle expired cache stylesInfo: ").append(styles_info2.name());
                        this.a.b.a(styles_info2);
                    }
                }
                this.a.d();
                break;
            default:
                break;
        }
        return true;
    }
}
