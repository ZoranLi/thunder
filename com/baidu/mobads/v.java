package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class v implements IOAdEventListener {
    final /* synthetic */ VideoAdView a;

    v(VideoAdView videoAdView) {
        this.a = videoAdView;
    }

    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new w(this, iOAdEvent));
    }
}
