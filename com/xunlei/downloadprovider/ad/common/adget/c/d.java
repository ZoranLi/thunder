package com.xunlei.downloadprovider.ad.common.adget.c;

import android.view.View;
import com.qq.e.ads.nativ.NativeADDataRef;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.o;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: GDTProxyModel */
public final class d extends l<NativeADDataRef, a> {

    /* compiled from: GDTProxyModel */
    public interface a extends com.xunlei.downloadprovider.ad.common.h.a {
    }

    public final int d() {
        return 1;
    }

    public final String y() {
        return SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
    }

    public final String z() {
        return "腾讯";
    }

    public d(String str, NativeADDataRef nativeADDataRef) {
        this.s = str;
        a((Object) nativeADDataRef);
    }

    public final String j() {
        return this.C != null ? ((NativeADDataRef) this.C).getTitle() : "";
    }

    public final String m() {
        return this.C != null ? ((NativeADDataRef) this.C).getDesc() : "";
    }

    public final String k() {
        return this.C != null ? ((NativeADDataRef) this.C).getIconUrl() : "";
    }

    public final String l() {
        return this.C != null ? ((NativeADDataRef) this.C).getImgUrl() : "";
    }

    public final boolean w() {
        return this.C != null ? ((NativeADDataRef) this.C).isAPP() : false;
    }

    public final int D() {
        if (this.C != null) {
            return a.a(((NativeADDataRef) this.C).getAPPStatus());
        }
        return super.D();
    }

    public final int u() {
        return w() ? 2 : 0;
    }

    public final long n() {
        return this.C != null ? ((NativeADDataRef) this.C).getDownloadCount() : 0;
    }

    public final float q() {
        if (super.q() != 0.0f) {
            return super.q();
        }
        if (this.C != null) {
            if (((NativeADDataRef) this.C).getAPPScore() <= 0) {
                a(f.b());
            } else {
                a((float) ((NativeADDataRef) this.C).getAPPScore());
            }
        }
        return super.q();
    }

    public final double E() {
        return this.C != null ? ((NativeADDataRef) this.C).getAPPPrice() : 0.0d;
    }

    public final AD_SYSTEM_TYPE c() {
        return AD_SYSTEM_TYPE.SOURCE_GDT_FLAG;
    }

    public final void a(View view) {
        super.a(view);
        if (this.C != null) {
            ((NativeADDataRef) this.C).onExposured(view);
        }
    }

    public final void onClick(View view) {
        super.onClick(view);
        if (this.C != null) {
            ((NativeADDataRef) this.C).onClicked(view);
        }
    }

    public final void f() {
        if (this.C != null) {
            String str;
            NativeADDataRef nativeADDataRef = (NativeADDataRef) this.C;
            String str2 = this.H;
            String A = A();
            if (this.v == null) {
                str = "";
            } else {
                str = this.v.mStyleId;
            }
            o.a(nativeADDataRef, str2, A, str);
        }
    }

    public final void g() {
        if (this.C != null) {
            String str;
            NativeADDataRef nativeADDataRef = (NativeADDataRef) this.C;
            String str2 = this.H;
            String A = A();
            if (this.v == null) {
                str = "";
            } else {
                str = this.v.mStyleId;
            }
            o.b(nativeADDataRef, str2, A, str);
        }
    }

    public final long H() {
        return b.a;
    }

    public final boolean a(l lVar) {
        return (!(lVar instanceof d) || ((NativeADDataRef) ((d) lVar).G()).equalsAdData((NativeADDataRef) this.C) == null) ? null : true;
    }
}
