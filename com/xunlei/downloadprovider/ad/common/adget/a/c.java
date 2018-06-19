package com.xunlei.downloadprovider.ad.common.adget.a;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.o;
import com.xunlei.downloadprovider.ad.common.h.a;

/* compiled from: BaiduProxyModel */
public final class c extends l<NativeResponse, a> implements d {
    public final int d() {
        return 3;
    }

    public final String y() {
        return "baidu";
    }

    public final String z() {
        return "百度";
    }

    public c(String str, NativeResponse nativeResponse) {
        this.s = str;
        a((Object) nativeResponse);
    }

    public final String j() {
        return this.C != null ? ((NativeResponse) this.C).getTitle() : "";
    }

    public final String m() {
        return this.C != null ? ((NativeResponse) this.C).getDesc() : "";
    }

    public final String k() {
        return this.C != null ? ((NativeResponse) this.C).getIconUrl() : "";
    }

    public final String l() {
        return this.C != null ? ((NativeResponse) this.C).getImageUrl() : "";
    }

    public final boolean w() {
        if (this.C == null || ((NativeResponse) this.C).getAppPackage() == null || ((NativeResponse) this.C).getAppPackage().trim().equals("")) {
            return false;
        }
        return true;
    }

    public final int u() {
        return w() ? 2 : 0;
    }

    public final AD_SYSTEM_TYPE c() {
        return AD_SYSTEM_TYPE.SOURCE_BAIDU_FLAG;
    }

    public final void a(View view) {
        super.a(view);
        if (this.C != null) {
            ((NativeResponse) this.C).recordImpression(view);
        }
    }

    public final void onClick(View view) {
        super.onClick(view);
        if (this.C != null) {
            ((NativeResponse) this.C).handleClick(view);
        }
    }

    public final void f() {
        if (this.C != null) {
            o.a((NativeResponse) this.C, this.H, A(), this.v.mStyleId);
        }
    }

    public final void g() {
        if (this.C != null) {
            o.b((NativeResponse) this.C, this.H, A(), this.v.mStyleId);
        }
    }

    private boolean P() {
        if (this.C == null || ((NativeResponse) this.C).getMaterialType() != MaterialType.VIDEO) {
            return false;
        }
        return true;
    }

    public final String b() {
        if (this.C != null) {
            return ((NativeResponse) this.C).getVideoUrl();
        }
        return super.b();
    }

    public final long H() {
        return b.b;
    }

    public final void a(Context context) {
        if (this.C != null && P()) {
            ((NativeResponse) this.C).onStart(context);
        }
    }

    public final void b(Context context) {
        if (this.C != null && P()) {
            ((NativeResponse) this.C).onComplete(context);
        }
    }

    public final void a(Context context, int i) {
        if (this.C != null && P()) {
            ((NativeResponse) this.C).onFullScreen(context, i);
        }
    }
}
