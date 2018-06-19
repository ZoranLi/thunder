package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

public interface MediaListener {
    void onADButtonClicked();

    void onFullScreenChanged(boolean z);

    void onReplayButtonClicked();

    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
