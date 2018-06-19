package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

public class DownloadTaskInfo extends TaskInfo {
    private static final long serialVersionUID = 1;
    public boolean hasRequestRedList;
    public int mAppInstalledType = 0;
    public long mAppInstalledTypeLastModifyTime = 0;
    public String mDownloadingPlayUrl = null;
    public long mDownloadingPlayUrlLMT = 0;
    public String mEpisodeTagText = null;
    public EFileCategoryType mFileCategoryType = null;
    public boolean mHasCloseRedEnvelopeBanner;
    public boolean mIsDisplayDownloadException = false;
    public boolean mIsFileMissing = false;
    public long mIsFileMissingLMT = 0;
    public int mIsSensitiveResource = 0;
    public long mRemainderSeconds = 20;
    public String mSearchName = null;
    public boolean mShowSpeedupButton;
    public long mSnapshotCheckLMT = 0;
    public int mVideoDuration = 0;
    public long mVideoDurationLMT = 0;
    public int mVideoPlayedTime = 0;
}
