package com.xunlei.downloadprovider.ad.home.ui;

import com.xunlei.downloadprovider.ad.common.adget.l;

public interface ADItemView {

    public enum AD_LAYOUT_TYPE {
        IMAGE_TYPE_VIEW,
        SHORT_VOD_TYPE_VIEW,
        LONG_VOD_TYPE_VIEW,
        PLAY_VOD_TYPE_VIEW
    }

    String a(String str);

    void a(l lVar);

    AD_LAYOUT_TYPE getADType();

    String getViewPositionKey();
}
