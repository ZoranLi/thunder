package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.component.XAdView.Listener;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.g.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class t implements Listener {
    final /* synthetic */ Context a;
    final /* synthetic */ XAdView b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ SplashAd e;

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    t(SplashAd splashAd, Context context, XAdView xAdView, String str, boolean z) {
        this.e = splashAd;
        this.a = context;
        this.b = xAdView;
        this.c = str;
        this.d = z;
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.e.a != null) {
            this.e.a.a(i);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.e.a != null) {
            this.e.a.a(z);
        }
    }

    public void onLayoutComplete(int i, int i2) {
        if (this.e.a == null) {
            float screenDensity = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.a);
            if (((float) i) >= 200.0f * screenDensity) {
                if (((float) i2) >= 150.0f * screenDensity) {
                    this.e.a = new a(this.a, this.b, this.c, this.d, i, i2, this.e.b);
                    this.e.a.addEventListener("AdUserClick", this.e.e);
                    this.e.a.addEventListener(IXAdEvent.AD_LOADED, this.e.e);
                    this.e.a.addEventListener(IXAdEvent.AD_STARTED, this.e.e);
                    this.e.a.addEventListener(IXAdEvent.AD_STOPPED, this.e.e);
                    this.e.a.addEventListener(IXAdEvent.AD_ERROR, this.e.e);
                    this.e.a.request();
                    return;
                }
            }
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            this.e.d.onAdDismissed();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        if (this.e.a != null) {
            this.e.a.o();
        }
    }

    public void onAttachedToWindow() {
        if (this.e.a != null) {
            this.e.a.n();
        }
    }
}
