package com.baidu.mobads.g;

import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class j implements a {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
        }
    }
}
