package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class r implements IOAdEventListener {
    final /* synthetic */ SplashAd a;

    r(SplashAd splashAd) {
        this.a = splashAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        if (this.a.d != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new s(this, iOAdEvent));
        }
    }
}
