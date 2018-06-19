package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;

/* compiled from: CommentDynamicItemInfo */
public class b {
    protected BaseCommentInfo baseCommentInfo;

    public BaseCommentInfo getBaseCommentInfo() {
        if (this.baseCommentInfo == null) {
            synchronized (this) {
                if (this.baseCommentInfo == null) {
                    this.baseCommentInfo = new BaseCommentInfo();
                }
            }
        }
        return this.baseCommentInfo;
    }

    public void setBaseCommentInfo(BaseCommentInfo baseCommentInfo) {
        this.baseCommentInfo = baseCommentInfo;
    }
}
