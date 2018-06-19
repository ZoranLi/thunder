package com.baidu.mobads;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class n implements IOAdEventListener {
    final /* synthetic */ InterstitialAd a;

    n(InterstitialAd interstitialAd) {
        this.a = interstitialAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        IXAdLogger adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
        String str = InterstitialAd.TAG;
        StringBuilder stringBuilder = new StringBuilder("evt.type=");
        stringBuilder.append(iOAdEvent.getType());
        adLogger.i(str, stringBuilder.toString());
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new o(this, iOAdEvent));
    }
}
