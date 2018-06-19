package com.qq.e.ads.nativ;

import android.view.View;
import java.util.List;

public interface NativeADDataRef {
    boolean equalsAdData(NativeADDataRef nativeADDataRef);

    double getAPPPrice();

    int getAPPScore();

    int getAPPStatus();

    int getAdPatternType();

    String getDesc();

    long getDownloadCount();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getProgress();

    String getTitle();

    boolean isAPP();

    void negativeFeedback();

    void onClicked(View view);

    void onExposured(View view);
}
