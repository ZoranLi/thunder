package com.xunlei.downloadprovider.ad.common.adget.c;

import com.qq.e.ads.nativ.NativeAD.NativeAdListener;
import com.qq.e.ads.nativ.NativeADDataRef;
import com.qq.e.comm.util.AdError;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GDTNavLoader */
final class c implements NativeAdListener {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    c(b bVar, a aVar, String str) {
        this.c = bVar;
        this.a = aVar;
        this.b = str;
    }

    public final void onADLoaded(List<NativeADDataRef> list) {
        if (this.a != null) {
            List arrayList = new ArrayList();
            if (!(list == null || list.size() == 0)) {
                for (NativeADDataRef dVar : list) {
                    arrayList.add(new d(this.b, dVar));
                }
            }
            this.a.a(arrayList);
        }
    }

    public final void onNoAD(AdError adError) {
        if (this.a != null) {
            this.a.a(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public final void onADStatusChanged(NativeADDataRef nativeADDataRef) {
        if (this.a instanceof d.a) {
            d dVar = new d(this.b, nativeADDataRef);
        }
    }

    public final void onADError(NativeADDataRef nativeADDataRef, AdError adError) {
        if (this.a instanceof d.a) {
            d dVar = new d(this.b, nativeADDataRef);
            adError.getErrorCode();
            adError.getErrorMsg();
        }
    }
}
