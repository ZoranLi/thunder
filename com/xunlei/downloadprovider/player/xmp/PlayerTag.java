package com.xunlei.downloadprovider.player.xmp;

public enum PlayerTag {
    HOME(1, 0),
    FEED(1, 0),
    PERSONAL(1, 0),
    FOLLOW_TAB(1, 0),
    VIDEO_DETAIL(Integer.MAX_VALUE, 0),
    SPLASH_AD(1, 0),
    TOPIC_COLLECT(1, 0),
    CARD_SLIDE(1, 0);
    
    private int mAttachSizeLimit;
    private int mCacheSize;

    private PlayerTag(int i, int i2) {
        this.mAttachSizeLimit = i;
        this.mCacheSize = i2;
    }

    public final int getAttachSizeLimit() {
        return this.mAttachSizeLimit;
    }

    public final int getCacheSize() {
        return this.mCacheSize;
    }
}
