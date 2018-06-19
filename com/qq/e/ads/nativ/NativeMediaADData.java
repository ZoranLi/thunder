package com.qq.e.ads.nativ;

import android.content.res.Configuration;
import android.view.View;
import com.qq.e.ads.contentad.ContentAdData;
import java.util.List;

public interface NativeMediaADData extends ContentAdData {
    void bindView(MediaView mediaView, boolean z);

    void destroy();

    boolean equalsAdData(NativeMediaADData nativeMediaADData);

    double getAPPPrice();

    int getAPPScore();

    int getAPPStatus();

    int getAdPatternType();

    int getCurrentPosition();

    String getDesc();

    long getDownloadCount();

    int getDuration();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getProgress();

    String getTitle();

    boolean isAPP();

    boolean isPlaying();

    @Deprecated
    boolean isVideoAD();

    boolean isVideoLoaded();

    void onClicked(View view);

    void onConfigurationChanged(Configuration configuration);

    void onExposured(View view);

    void onScroll(int i, View view);

    void play();

    void preLoadVideo();

    void resume();

    void setMediaListener(MediaListener mediaListener);

    void setVolumeOn(boolean z);

    void stop();
}
