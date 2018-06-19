package com.baidu.mobads;

public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);
    
    private int a;

    public final int getValue() {
        return this.a;
    }

    private AdSize(int i) {
        this.a = i;
    }
}
