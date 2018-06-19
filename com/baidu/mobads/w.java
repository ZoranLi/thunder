package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

class w implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ v b;

    w(v vVar, IOAdEvent iOAdEvent) {
        this.b = vVar;
        this.a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            this.b.a.c.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            this.b.a.c.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.a.getType())) {
            this.b.a.c.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.a.getType())) {
            this.b.a.c.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            this.a.getData().get("message");
            this.b.a.c.onVideoError();
        }
    }
}
