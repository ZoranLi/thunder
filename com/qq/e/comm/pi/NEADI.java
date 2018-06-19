package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;

public interface NEADI {
    void loadAd(int i);

    void setBrowserType(int i);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setVideoOption(VideoOption videoOption);
}
