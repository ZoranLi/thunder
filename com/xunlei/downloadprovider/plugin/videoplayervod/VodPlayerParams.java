package com.xunlei.downloadprovider.plugin.videoplayervod;

import android.os.Bundle;
import com.xunlei.downloadprovider.plugin.videoplayervod.report.VodReportInfo;
import java.io.Serializable;

public class VodPlayerParams implements Serializable {
    private static final long serialVersionUID = 2023779537672018453L;
    public String mCID;
    public String mCoverUrl;
    public int mCurPlayPos;
    public Bundle mDownloadVodInfoBundle;
    public int mDuration;
    public long mFileSize;
    public String mGCID;
    public int mMaxPlayPos;
    public String mMovieId;
    public VodReportInfo mReportInfo;
    public int mStartPos;
    public String mTitle;
    public String mUrl;
    public String mVodSourceType;
    public int mVodType = 2;

    public Bundle getBundle() {
        Bundle bundle = new Bundle(15);
        bundle.putString("KEY_VodPlayerParams_ReportInfo_PlayType", this.mReportInfo != null ? this.mReportInfo.mPlayType : "");
        bundle.putString("KEY_VodPlayerParams_ReportInfo_PlayFrom", this.mReportInfo != null ? this.mReportInfo.mPlayFrom : "");
        bundle.putString("KEY_VodPlayerParams_VodSourceType", this.mVodSourceType);
        bundle.putInt("KEY_VodPlayerParams_StartPos", this.mStartPos);
        bundle.putString("KEY_VodPlayerParams_Title", this.mTitle);
        bundle.putString("KEY_VodPlayerParams_Url", this.mUrl);
        bundle.putString("KEY_VodPlayerParams_CoverUrl", this.mCoverUrl);
        bundle.putString("KEY_VodPlayerParams_CID", this.mCID);
        bundle.putString("KEY_VodPlayerParams_GCID", this.mGCID);
        bundle.putLong("KEY_VodPlayerParams_FileSize", this.mFileSize);
        bundle.putString("KEY_VodPlayerParams_MovieId", this.mMovieId);
        bundle.putInt("KEY_VodPlayerParams_VodType", this.mVodType);
        bundle.putInt("KEY_VodPlayerParams_Duration", this.mDuration);
        bundle.putInt("KEY_VodPlayerParams_CurPlayPos", this.mCurPlayPos);
        bundle.putInt("KEY_VodPlayerParams_MaxPlayPos", this.mMaxPlayPos);
        if (this.mDownloadVodInfoBundle != null) {
            bundle.putBundle("KEY_VodPlayerParams_DownloadVodInfo", this.mDownloadVodInfoBundle);
        }
        return bundle;
    }

    public int getVodType() {
        return this.mVodType;
    }
}
