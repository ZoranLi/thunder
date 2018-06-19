package com.xunlei.downloadprovider.homepage.youliao.data;

import java.io.Serializable;

public class LikeInfo implements Serializable {
    private boolean mIsLiked;
    private int mLikeCount;

    public int getLikeCount() {
        return this.mLikeCount;
    }

    public void setLikeCount(int i) {
        this.mLikeCount = i;
    }

    public boolean isLiked() {
        return this.mIsLiked;
    }

    public void setLiked(boolean z) {
        this.mIsLiked = z;
    }
}
