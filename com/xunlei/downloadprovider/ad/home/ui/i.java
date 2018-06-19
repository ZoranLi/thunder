package com.xunlei.downloadprovider.ad.home.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.xllib.android.b;

/* compiled from: ADImageItemviewBase */
final class i implements OnClickListener {
    final /* synthetic */ ADImageItemviewBase a;

    i(ADImageItemviewBase aDImageItemviewBase) {
        this.a = aDImageItemviewBase;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            if (this.a.a.c() != AD_SYSTEM_TYPE.SOURCE_BAIDU_FLAG || b.e(this.a.getContext()) == null || this.a.a.w() == null) {
                ADImageItemviewBase.a(this.a);
                return;
            }
            ADImageItemviewBase.a(this.a, new j(this));
            this.a.f.show();
        }
    }
}
