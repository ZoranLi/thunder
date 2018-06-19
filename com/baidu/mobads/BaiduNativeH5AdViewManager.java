package com.baidu.mobads;

import android.content.Context;

public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager a;

    private BaiduNativeH5AdViewManager() {
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            if (a == null) {
                a = new BaiduNativeH5AdViewManager();
            }
            baiduNativeH5AdViewManager = a;
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView adView = baiduNativeAdPlacement.getAdView();
        if (baiduNativeAdPlacement.getAdView() != null) {
            return adView;
        }
        adView = new BaiduNativeH5AdView(context, i);
        adView.setAdPlacement(baiduNativeAdPlacement);
        baiduNativeAdPlacement.setAdView(adView);
        return adView;
    }
}
