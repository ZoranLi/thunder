package com.xunlei.downloadprovider.homepage.youliao.data;

import com.taobao.accs.AccsClientConfig;
import java.io.Serializable;

public class YouliaoVideo implements Serializable {
    private static final long serialVersionUID = 1;
    private int mCommentCount = 0;
    private int mDuration;
    private String mDynamicPosterUrl;
    private String mGcid;
    private String mIntroduction = "";
    private boolean mIsGif = true;
    private LikeInfo mLikeInfo = new LikeInfo();
    private int mPlayCount = 0;
    private String mPlayUrl;
    private int mPosition;
    private int mPosterHeight;
    private String mPosterUrl;
    private int mPosterWidth;
    private String mPreloadPlayUrl;
    private PublisherInfo mPublisherInfo = new PublisherInfo();
    private String mRecommendTag = AccsClientConfig.DEFAULT_CONFIGTAG;
    private String mServerParams = "";
    private String mServerResFrom;
    private int mShareCount = 0;
    private String mTitle;
    private String mVideoAddress;
    private String mVideoId;
    private double mVideoLatitude = -1.0d;
    private double mVideoLongitude = -1.0d;

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getGcid() {
        return this.mGcid;
    }

    public void setGcid(String str) {
        this.mGcid = str;
    }

    public String getPosterUrl() {
        return this.mPosterUrl;
    }

    public void setPosterUrl(String str) {
        this.mPosterUrl = str;
    }

    public String getDynamicPosterUrl() {
        return this.mDynamicPosterUrl;
    }

    public void setDynamicPosterUrl(String str) {
        this.mDynamicPosterUrl = str;
    }

    public int getPosterWidth() {
        return this.mPosterWidth;
    }

    public void setPosterWidth(int i) {
        this.mPosterWidth = i;
    }

    public int getPosterHeight() {
        return this.mPosterHeight;
    }

    public void setPosterHeight(int i) {
        this.mPosterHeight = i;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setPreloadPlayUrl(String str) {
        this.mPreloadPlayUrl = str;
    }

    public String getPreloadPlayUrl() {
        return this.mPreloadPlayUrl;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public int getPlayCount() {
        return this.mPlayCount;
    }

    public void setPlayCount(int i) {
        this.mPlayCount = i;
    }

    public LikeInfo getLikeInfo() {
        return this.mLikeInfo;
    }

    public void setLikeInfo(LikeInfo likeInfo) {
        this.mLikeInfo = likeInfo;
    }

    public int getCommentCount() {
        return this.mCommentCount;
    }

    public void setCommentCount(int i) {
        this.mCommentCount = i;
    }

    public int getShareCount() {
        return this.mShareCount;
    }

    public void setShareCount(int i) {
        this.mShareCount = i;
    }

    public String getIntroduction() {
        return this.mIntroduction;
    }

    public void setIntroduction(String str) {
        this.mIntroduction = str;
    }

    public PublisherInfo getPublisherInfo() {
        return this.mPublisherInfo;
    }

    public void setPublisherInfo(PublisherInfo publisherInfo) {
        this.mPublisherInfo = publisherInfo;
    }

    public String getServerParams() {
        return this.mServerParams;
    }

    public void setServerParams(String str) {
        this.mServerParams = str;
    }

    public String getServerResFrom() {
        return this.mServerResFrom;
    }

    public void setServerResFrom(String str) {
        this.mServerResFrom = str;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public boolean isGif() {
        return this.mIsGif;
    }

    public void setIsGif(boolean z) {
        this.mIsGif = z;
    }

    public String getRecommendTag() {
        return this.mRecommendTag;
    }

    public void setRecommendTag(String str) {
        this.mRecommendTag = str;
    }

    public double getVideoLatitude() {
        return this.mVideoLatitude;
    }

    public void setVideoLatitude(double d) {
        this.mVideoLatitude = d;
    }

    public double getVideoLongitude() {
        return this.mVideoLongitude;
    }

    public void setVideoLongitude(double d) {
        this.mVideoLongitude = d;
    }

    public String getVideoAddress() {
        return this.mVideoAddress;
    }

    public void setVideoAddress(String str) {
        this.mVideoAddress = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("YouliaoVideo{mVideoId='");
        stringBuilder.append(this.mVideoId);
        stringBuilder.append('\'');
        stringBuilder.append(", mTitle='");
        stringBuilder.append(this.mTitle);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
