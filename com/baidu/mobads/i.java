package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class i implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ h b;

    i(h hVar, IOAdEvent iOAdEvent) {
        this.b = hVar;
        this.a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            this.b.a.f = true;
            this.b.a.b.setRequestStarted(false);
            this.b.a.recordImpression();
            if (this.b.a.d != null) {
                this.b.a.d.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            this.b.a.b.setRequestStarted(false);
            if (this.b.a.d != null) {
                this.b.a.d.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
            }
        } else if ("AdUserClick".equals(this.a.getType())) {
            this.b.a.b.setClicked(true);
            if (this.b.a.d != null) {
                this.b.a.d.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.a.getType())) {
            this.b.a.b.setWinSended(true);
        } else if ("AdLoadData".equals(this.a.getType())) {
            this.b.a.g = true;
            if (this.b.a.d != null) {
                this.b.a.d.onAdDataLoaded();
            }
        }
    }
}
