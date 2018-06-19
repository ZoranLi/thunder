package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.g.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;

public class SplashAd {
    private a a;
    private int b;
    private volatile String c;
    private SplashAdListener d;
    private IOAdEventListener e;

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this.b = 4;
        this.c = "init";
        this.d = new q(this);
        this.e = new r(this);
        try {
            com.baidu.mobads.a.a.l = System.currentTimeMillis();
            com.baidu.mobads.a.a.m = 0;
            com.baidu.mobads.a.a.n = 0;
            com.baidu.mobads.a.a.o = 0;
            com.baidu.mobads.a.a.p = 0;
            com.baidu.mobads.a.a.q = 0;
            com.baidu.mobads.a.a.r = 0;
            if (!AppActivity.isAnti()) {
                a(viewGroup, context);
            }
            if (splashAdListener != null) {
                this.d = splashAdListener;
            }
            if (TextUtils.isEmpty(str) != null) {
                this.d.onAdFailed("请您输入正确的广告位ID");
                return;
            }
            splashAdListener = new XAdView(context);
            splashAdListener.setListener(new t(this, context, splashAdListener, str, z));
            splashAdListener.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(splashAdListener);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            viewGroup = com.baidu.mobads.c.a.a();
            splashAdListener = new StringBuilder("splash ad create failed: ");
            splashAdListener.append(e.toString());
            viewGroup.a(splashAdListener.toString());
        }
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public static void setBitmapDisplayMode(int i) {
        a.b(i);
    }

    public void destroy() {
        if (this.a != null) {
            this.a.p();
        }
    }

    public static void setMaxVideoCacheCapacityMb(int i) {
        if (i < 15 || i > 100) {
            h.a(30);
            XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "开屏设置视频最大缓存值有效范围在15~100M,默认30M", "");
            return;
        }
        h.a(i);
    }

    private void a(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }
}
