package com.xunlei.downloadprovider.ad.common.adget.c;

import android.content.Context;
import com.qq.e.ads.nativ.NativeMediaAD;
import com.qq.e.ads.nativ.NativeMediaAD.NativeMediaADListener;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.qq.e.comm.util.AdError;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.downloadprovider.ad.common.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GDTVodNavLoader */
public final class e implements NativeMediaADListener, h {
    private Context a;
    private String b;
    private String c;
    private int d;
    private a e;
    private List<f> f = new ArrayList();

    public final void onADClicked(NativeMediaADData nativeMediaADData) {
    }

    public final void onADExposure(NativeMediaADData nativeMediaADData) {
    }

    public e(Context context, String str, int i) {
        this.a = context;
        this.b = str;
        this.d = i;
    }

    public final void a(a aVar, String str) {
        this.c = str;
        this.e = aVar;
        new NativeMediaAD(com.xunlei.downloadprovider.ad.a.a(), "1104872693", this.b, this).loadAD(this.d);
    }

    public final void onADLoaded(List<NativeMediaADData> list) {
        if (this.e != null) {
            List arrayList = new ArrayList();
            if (!(list == null || list.isEmpty())) {
                for (NativeMediaADData fVar : list) {
                    l fVar2 = new f(this.c, fVar);
                    fVar2.v = STYLES_INFO.HOME_VOD;
                    arrayList.add(fVar2);
                    this.f.add(fVar2);
                }
            }
            this.e.a(arrayList);
        }
    }

    public final void onNoAD(AdError adError) {
        if (this.e != null) {
            this.e.a(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    public final void onADStatusChanged(NativeMediaADData nativeMediaADData) {
        nativeMediaADData = a(nativeMediaADData);
        if (nativeMediaADData != null) {
            nativeMediaADData.a();
        }
    }

    public final void onADError(NativeMediaADData nativeMediaADData, AdError adError) {
        f.a a = a(nativeMediaADData);
        if (a != null) {
            a.a(nativeMediaADData, adError.getErrorCode());
        }
    }

    public final void onADVideoLoaded(NativeMediaADData nativeMediaADData) {
        f.a a = a(nativeMediaADData);
        if (a != null) {
            a.a(nativeMediaADData);
        }
    }

    private f.a a(NativeMediaADData nativeMediaADData) {
        for (f fVar : this.f) {
            if (((NativeMediaADData) fVar.G()).equals(nativeMediaADData)) {
                return fVar.a;
            }
        }
        return null;
    }
}
