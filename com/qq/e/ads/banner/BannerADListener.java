package com.qq.e.ads.banner;

import com.qq.e.comm.util.AdError;

public interface BannerADListener {
    void onADClicked();

    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onADReceiv();

    void onNoAD(AdError adError);
}
