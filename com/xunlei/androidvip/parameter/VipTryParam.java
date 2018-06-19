package com.xunlei.androidvip.parameter;

public class VipTryParam {
    public long mBandwidth;
    public String mCid;
    public long mCurrentSpeed;
    public int mFileIndex;
    public String mFileName;
    public long mFileSize;
    public String mGcid;
    public String mResId;
    public int mResType;
    public String mTrialKey;
    public String mUrl;
    public long mUserId;

    public VipTryParam(long j, long j2, long j3, int i, String str, String str2, String str3, long j4, String str4, String str5, int i2, String str6) {
        this.mCurrentSpeed = j;
        this.mBandwidth = j2;
        this.mUserId = j3;
        this.mResType = i;
        this.mUrl = str;
        this.mGcid = str2;
        this.mCid = str3;
        this.mFileSize = j4;
        this.mFileName = str4;
        this.mResId = str5;
        this.mFileIndex = i2;
        this.mTrialKey = str6;
    }

    public boolean checkMemberVar() {
        if (this.mUrl == null || this.mGcid == null || this.mCid == null || this.mFileName == null || this.mResId == null || this.mTrialKey == null) {
            return false;
        }
        return true;
    }
}
