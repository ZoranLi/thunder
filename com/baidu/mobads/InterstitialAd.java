package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.f.a;
import com.baidu.mobads.production.f.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class InterstitialAd {
    public static final String TAG = "InterstitialAd";
    IOAdEventListener a;
    private AdSize b;
    private a c;
    private final IXAdLogger d;
    private InterstitialAdListener e;

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.d = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.e = new m(this);
        this.a = new n(this);
        RelativeLayout xAdView = new XAdView(context);
        xAdView.setListener(new p(this));
        this.b = adSize;
        if (a()) {
            this.c = new b(context, xAdView, Boolean.valueOf(true), str);
        } else if (b()) {
            this.c = new com.baidu.mobads.production.e.b(context, xAdView, Boolean.valueOf(true), adSize, str);
        }
        this.c.addEventListener(IXAdEvent.AD_LOADED, this.a);
        this.c.addEventListener(IXAdEvent.AD_ERROR, this.a);
        this.c.addEventListener(IXAdEvent.AD_STOPPED, this.a);
        this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.a);
        this.c.addEventListener(IXAdEvent.AD_STARTED, this.a);
        this.c.addEventListener("AdUserClick", this.a);
        this.c.request();
    }

    private boolean a() {
        return this.b.getValue() <= AdSize.InterstitialOther.getValue() && this.b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean b() {
        return this.b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public boolean isAdReady() {
        return this.c.v();
    }

    public void loadAd() {
        this.c.q();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.c.a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.e = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.c.a(activity);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void destroy() {
        this.c.p();
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null) {
            if (relativeLayout != null) {
                this.c.a(activity, relativeLayout);
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
