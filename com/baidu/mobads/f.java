package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

class f implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ e b;

    f(e eVar, IOAdEvent iOAdEvent) {
        this.b = eVar;
        this.a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            this.b.a.c.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            this.b.a.b.onAdShow(0, null);
        } else {
            if (!IXAdEvent.AD_ERROR.equals(this.a.getType())) {
                if ("AdUserClick".equals(this.a.getType())) {
                    this.b.a.b.onAdClick(0, null);
                    return;
                }
                IXAdEvent.AD_USER_CLOSE.equals(this.a.getType());
            }
        }
    }
}
