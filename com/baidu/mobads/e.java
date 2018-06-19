package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class e implements IOAdEventListener {
    final /* synthetic */ BaiduHybridAdManager a;

    e(BaiduHybridAdManager baiduHybridAdManager) {
        this.a = baiduHybridAdManager;
    }

    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new f(this, iOAdEvent));
    }
}
