package com.baidu.mobads.production.d;

import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().getBaiduMapsInfo(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getCell(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getWIFI(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getGPS(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getNetType(this.a.f);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getMem();
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getAndroidId(this.a.f);
        XAdSDKFoundationFacade.getInstance().getCommonUtils().createRequestId(this.a.f, "");
    }
}
