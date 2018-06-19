package com.xunlei.downloadprovider.ad.common.adget.a;

import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaiduNavLoader */
final class b implements BaiduNativeNetworkListener {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    b(a aVar, a aVar2, String str) {
        this.c = aVar;
        this.a = aVar2;
        this.b = str;
    }

    public final void onNativeLoad(List<NativeResponse> list) {
        if (this.a != null) {
            List arrayList = new ArrayList();
            if (!(list == null || list.size() == 0)) {
                for (NativeResponse cVar : list) {
                    l cVar2 = new c(this.b, cVar);
                    cVar2.a(f.b());
                    arrayList.add(cVar2);
                }
            }
            this.a.a(arrayList);
        }
    }

    public final void onNativeFail(NativeErrorCode nativeErrorCode) {
        if (this.a != null) {
            this.a.a(nativeErrorCode.ordinal(), nativeErrorCode.name());
        }
    }
}
