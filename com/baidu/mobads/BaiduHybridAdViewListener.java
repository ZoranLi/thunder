package com.baidu.mobads;

public interface BaiduHybridAdViewListener {
    void onAdClick(int i, String str);

    void onAdFailed(int i, String str, String str2);

    void onAdShow(int i, String str);
}
