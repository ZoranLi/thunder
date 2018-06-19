package com.xunlei.downloadprovider.ad.common.adget.c;

import android.view.View;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.o;

/* compiled from: GDTVodProxyModel */
public final class f extends l<NativeMediaADData, a> {
    public a a;

    /* compiled from: GDTVodProxyModel */
    public interface a {
        void a();

        void a(NativeMediaADData nativeMediaADData);

        void a(NativeMediaADData nativeMediaADData, int i);
    }

    public final int d() {
        return 2;
    }

    public final String y() {
        return SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
    }

    public final String z() {
        return "腾讯";
    }

    public f(String str, NativeMediaADData nativeMediaADData) {
        this.s = str;
        a((Object) nativeMediaADData);
    }

    public final String j() {
        return this.C != null ? ((NativeMediaADData) this.C).getTitle() : "";
    }

    public final String m() {
        return this.C != null ? ((NativeMediaADData) this.C).getDesc() : "";
    }

    public final String k() {
        return this.C != null ? ((NativeMediaADData) this.C).getIconUrl() : "";
    }

    public final String l() {
        return this.C != null ? ((NativeMediaADData) this.C).getImgUrl() : "";
    }

    public final boolean w() {
        return this.C != null ? ((NativeMediaADData) this.C).isAPP() : false;
    }

    public final int D() {
        if (this.C != null) {
            return a.a(((NativeMediaADData) this.C).getAPPStatus());
        }
        return super.D();
    }

    public final int u() {
        return w() ? 2 : 0;
    }

    public final long n() {
        return this.C != null ? ((NativeMediaADData) this.C).getDownloadCount() : 0;
    }

    public final float q() {
        return this.C != null ? (float) ((NativeMediaADData) this.C).getAPPScore() : 0.0f;
    }

    public final double E() {
        return this.C != null ? ((NativeMediaADData) this.C).getAPPPrice() : 0.0d;
    }

    public final AD_SYSTEM_TYPE c() {
        return AD_SYSTEM_TYPE.SOURCE_GDT_FLAG;
    }

    public final void a(View view) {
        super.a(view);
        if (this.C != null) {
            ((NativeMediaADData) this.C).onExposured(view);
        }
    }

    public final void onClick(View view) {
        super.onClick(view);
        if (this.C != null) {
            ((NativeMediaADData) this.C).onClicked(view);
        }
    }

    public final void f() {
        if (this.C != null) {
            NativeMediaADData nativeMediaADData = (NativeMediaADData) this.C;
            String str = this.H;
            String A = A();
            String str2 = this.v.mStyleId;
            o.a(nativeMediaADData, str, A);
        }
    }

    public final void g() {
        if (this.C != null) {
            NativeMediaADData nativeMediaADData = (NativeMediaADData) this.C;
            String str = this.H;
            String A = A();
            String str2 = this.v.mStyleId;
            o.b(nativeMediaADData, str, A);
        }
    }

    public final boolean F() {
        if (this.C != null) {
            return ((NativeMediaADData) this.C).isVideoAD();
        }
        return super.F();
    }

    public final long H() {
        return b.a;
    }

    public final boolean a(l lVar) {
        return (!(lVar instanceof f) || ((NativeMediaADData) ((f) lVar).G()).equalsAdData((NativeMediaADData) this.C) == null) ? null : true;
    }
}
