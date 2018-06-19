package com.xunlei.downloadprovider.homepage.redpacket;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.redpacket.ShareCompleteToast.ToastType;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: RedPacketHelper */
final class l implements c<com.xunlei.downloadprovider.homepage.redpacket.a.c> {
    final /* synthetic */ j a;

    public final void onFail(String str) {
    }

    l(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        com.xunlei.downloadprovider.homepage.redpacket.a.c cVar = (com.xunlei.downloadprovider.homepage.redpacket.a.c) obj;
        if (cVar != null && cVar.a > 0) {
            StringBuilder stringBuilder = new StringBuilder("已赚：");
            stringBuilder.append(((float) cVar.a) / 1000.0f);
            stringBuilder.append("元");
            a.a(BrothersApplication.getApplicationInstance(), ToastType.TOAST_TYPE_SUCCESS, stringBuilder.toString());
        }
    }
}
