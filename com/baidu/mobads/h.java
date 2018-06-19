package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class h implements IOAdEventListener {
    final /* synthetic */ BaiduNativeH5AdView a;

    h(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.a = baiduNativeH5AdView;
    }

    public void run(IOAdEvent iOAdEvent) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new i(this, iOAdEvent));
    }
}
