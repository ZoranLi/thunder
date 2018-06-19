package com.xunlei.android.shortvideo;

import com.xunlei.android.shortvideo.ShortVideoInterface.a;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.XLConstant.XLErrorCode;
import com.xunlei.downloadlib.parameter.XLSessionInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.downloadlib.parameter.XLTaskLocalUrl;
import java.io.File;

public final class ShortVideoTask {
    static long f;
    public a a;
    XLTaskInfo b = new XLTaskInfo();
    public long c;
    public STATUS d;
    public long e;
    String g;
    public long h = 0;
    public long i = 0;
    public XLDownloadManager j = null;
    public int k = 0;
    private String l;
    private String m;
    private boolean n = false;

    public enum STATUS {
        INIT,
        PREDOWNLOADING,
        PREDOWNLOADED,
        SUCCESS,
        FAIL
    }

    public ShortVideoTask(a aVar, String str, String str2) {
        this.a = aVar;
        this.d = STATUS.INIT;
        this.c = -1;
        this.g = str;
        aVar = f;
        f = aVar + 1;
        this.e = aVar;
        this.m = str2;
        try {
            this.j = XLDownloadManager.getInstance();
        } catch (a aVar2) {
            aVar2.printStackTrace();
            this.k = 100;
        }
        str = new StringBuilder("ShortVideoTask VideoId=[");
        str.append(this.e);
        str.append("] mTitle=[");
        str.append(this.a.c);
        str.append("] mCacheDuration=");
        str.append(this.a.e);
        str.append("]");
        XLLog.d("ShortVideoTask", str.toString());
    }

    public final String a() {
        return new File(this.g, this.a.b).getPath();
    }

    public final boolean a(int i) {
        if (-1 == this.c) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("pause success VideoId=[");
        stringBuilder.append(this.e);
        stringBuilder.append("] status=[");
        stringBuilder.append(this.d);
        stringBuilder.append("] TaskId=[");
        stringBuilder.append(this.c);
        stringBuilder.append("] errCode=[");
        stringBuilder.append(i);
        stringBuilder.append("]");
        XLLog.d("ShortVideoTask", stringBuilder.toString());
        try {
            this.j.stopTaskWithReason(this.c, i);
            this.j.releaseTask(this.c);
        } catch (int i2) {
            i2.printStackTrace();
            this.k = 100;
        }
        this.c = -1;
        return true;
    }

    private boolean a(boolean z) {
        int i;
        StringBuilder stringBuilder;
        this.n = z;
        GetTaskId getTaskId = new GetTaskId();
        int i2 = this.a.d;
        if (this.a.d < this.a.e) {
            i2 = this.a.e;
        } else if (this.a.d == 0 && this.a.e == -1) {
            i = 1;
            if (z) {
                i2 = this.j.createShortVideoTask(this.a.a, this.g, this.a.b, this.a.c, (int) this.e, i, this.a.e, getTaskId);
            } else {
                try {
                    i2 = this.j.createShortVideoTask(this.a.a, this.g, this.a.b, this.a.c, (int) this.e, i, -2, getTaskId);
                } catch (boolean z2) {
                    z2.printStackTrace();
                    return false;
                }
            }
            if (9000 == i2) {
                stringBuilder = new StringBuilder("doResumeTask createShortVideoTask fail, VideoId=[");
                stringBuilder.append(this.e);
                stringBuilder.append("] rc=[");
                stringBuilder.append(i2);
                stringBuilder.append("] mCreate=");
                stringBuilder.append(this.a.toString());
                XLLog.e("ShortVideoTask", stringBuilder.toString());
                this.k = i2;
                return false;
            }
            this.c = getTaskId.getTaskId();
            i2 = this.j.setDownloadTaskOrigin(getTaskId.getTaskId(), this.m);
            if (9000 == i2) {
                stringBuilder = new StringBuilder("doResumeTask setDownloadTaskOrigin fail, VideoId=[");
                stringBuilder.append(this.e);
                stringBuilder.append("] rc=[");
                stringBuilder.append(i2);
                stringBuilder.append("] TaskId=[");
                stringBuilder.append(getTaskId.getTaskId());
                stringBuilder.append("] mCreate=");
                stringBuilder.append(this.a.toString());
                XLLog.e("ShortVideoTask", stringBuilder.toString());
                this.k = i2;
                return false;
            }
            i2 = this.j.startTask(getTaskId.getTaskId());
            if (9000 == i2) {
                stringBuilder = new StringBuilder("doResumeTask startTask fail, VideoId=[");
                stringBuilder.append(this.e);
                stringBuilder.append("] rc=[");
                stringBuilder.append(i2);
                stringBuilder.append("] TaskId=[");
                stringBuilder.append(getTaskId.getTaskId());
                stringBuilder.append("] mCreate=");
                stringBuilder.append(this.a.toString());
                XLLog.e("ShortVideoTask", stringBuilder.toString());
                this.k = i2;
                return false;
            }
            stringBuilder = new StringBuilder("doResumeTask success VideoId=[");
            stringBuilder.append(this.e);
            stringBuilder.append("] status=[");
            stringBuilder.append(this.d);
            stringBuilder.append("] TaskId=[");
            stringBuilder.append(this.c);
            stringBuilder.append("] isP2pTask=[");
            stringBuilder.append(z2);
            stringBuilder.append("]");
            XLLog.d("ShortVideoTask", stringBuilder.toString());
            return true;
        }
        i = i2;
        if (z2) {
            i2 = this.j.createShortVideoTask(this.a.a, this.g, this.a.b, this.a.c, (int) this.e, i, this.a.e, getTaskId);
        } else {
            i2 = this.j.createShortVideoTask(this.a.a, this.g, this.a.b, this.a.c, (int) this.e, i, -2, getTaskId);
        }
        if (9000 == i2) {
            this.c = getTaskId.getTaskId();
            i2 = this.j.setDownloadTaskOrigin(getTaskId.getTaskId(), this.m);
            if (9000 == i2) {
                i2 = this.j.startTask(getTaskId.getTaskId());
                if (9000 == i2) {
                    stringBuilder = new StringBuilder("doResumeTask success VideoId=[");
                    stringBuilder.append(this.e);
                    stringBuilder.append("] status=[");
                    stringBuilder.append(this.d);
                    stringBuilder.append("] TaskId=[");
                    stringBuilder.append(this.c);
                    stringBuilder.append("] isP2pTask=[");
                    stringBuilder.append(z2);
                    stringBuilder.append("]");
                    XLLog.d("ShortVideoTask", stringBuilder.toString());
                    return true;
                }
                stringBuilder = new StringBuilder("doResumeTask startTask fail, VideoId=[");
                stringBuilder.append(this.e);
                stringBuilder.append("] rc=[");
                stringBuilder.append(i2);
                stringBuilder.append("] TaskId=[");
                stringBuilder.append(getTaskId.getTaskId());
                stringBuilder.append("] mCreate=");
                stringBuilder.append(this.a.toString());
                XLLog.e("ShortVideoTask", stringBuilder.toString());
                this.k = i2;
                return false;
            }
            stringBuilder = new StringBuilder("doResumeTask setDownloadTaskOrigin fail, VideoId=[");
            stringBuilder.append(this.e);
            stringBuilder.append("] rc=[");
            stringBuilder.append(i2);
            stringBuilder.append("] TaskId=[");
            stringBuilder.append(getTaskId.getTaskId());
            stringBuilder.append("] mCreate=");
            stringBuilder.append(this.a.toString());
            XLLog.e("ShortVideoTask", stringBuilder.toString());
            this.k = i2;
            return false;
        }
        stringBuilder = new StringBuilder("doResumeTask createShortVideoTask fail, VideoId=[");
        stringBuilder.append(this.e);
        stringBuilder.append("] rc=[");
        stringBuilder.append(i2);
        stringBuilder.append("] mCreate=");
        stringBuilder.append(this.a.toString());
        XLLog.e("ShortVideoTask", stringBuilder.toString());
        this.k = i2;
        return false;
    }

    public final boolean b() {
        if (-1 != this.c) {
            return false;
        }
        if (this.a.e == -1) {
            return a(false);
        }
        if (this.j.getSettingValue("short_video", "short_video_p2p_switch", false)) {
            return a(true);
        }
        return a(false);
    }

    public final String c() {
        if (this.l == null) {
            XLTaskLocalUrl xLTaskLocalUrl = new XLTaskLocalUrl();
            try {
                this.j.getLocalUrl(a(), xLTaskLocalUrl);
                this.l = xLTaskLocalUrl.mStrUrl;
            } catch (Throwable th) {
                th.printStackTrace();
                this.k = 100;
                return this.a.a;
            }
        }
        return this.l;
    }

    public final boolean a(String str, XLSessionInfo xLSessionInfo) {
        try {
            return 9000 == this.j.getSessionInfoByUrl(str, xLSessionInfo);
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        }
    }

    public final void b(int i) {
        this.a.e = i;
    }

    public final boolean d() {
        try {
            int taskInfo = this.j.getTaskInfo(this.c, 1, this.b);
            if (9000 != taskInfo) {
                StringBuilder stringBuilder = new StringBuilder("updateTaskInfo getTaskInfo fail, VideoId=[");
                stringBuilder.append(this.e);
                stringBuilder.append("] status=[");
                stringBuilder.append(this.d);
                stringBuilder.append("] rc=[");
                stringBuilder.append(taskInfo);
                stringBuilder.append("] TaskId=[");
                stringBuilder.append(this.c);
                stringBuilder.append("]");
                XLLog.e("ShortVideoTask", stringBuilder.toString());
                a(taskInfo);
                this.d = STATUS.FAIL;
                this.k = taskInfo;
                return false;
            }
            if (this.b.mDownloadSize > 0) {
                this.i = this.b.mDownloadSize;
            }
            if (this.b.mFileSize > 0) {
                this.h = this.b.mFileSize;
            }
            StringBuilder stringBuilder2;
            if (2 == this.b.mTaskStatus) {
                stringBuilder2 = new StringBuilder("updateTaskInfo task SUCCESS, VideoId=[");
                stringBuilder2.append(this.e);
                stringBuilder2.append("] status=[");
                stringBuilder2.append(this.d);
                stringBuilder2.append("]");
                XLLog.d("ShortVideoTask", stringBuilder2.toString());
                this.d = STATUS.SUCCESS;
                a(this.b.mErrorCode);
                return false;
            } else if (3 == this.b.mTaskStatus && XLErrorCode.VIDEO_CACHE_FINISH == this.b.mErrorCode) {
                stringBuilder2 = new StringBuilder("updateTaskInfo task PREDOWNLOADED, VideoId=[");
                stringBuilder2.append(this.e);
                stringBuilder2.append("] status=[");
                stringBuilder2.append(this.d);
                stringBuilder2.append("]");
                XLLog.e("ShortVideoTask", stringBuilder2.toString());
                this.d = STATUS.PREDOWNLOADED;
                a(this.b.mErrorCode);
                return false;
            } else if (3 != this.b.mTaskStatus) {
                StringBuilder stringBuilder3 = new StringBuilder("updateTaskInfo getTaskInfo VideoId=[");
                stringBuilder3.append(this.e);
                stringBuilder3.append("] status=[");
                stringBuilder3.append(this.d);
                stringBuilder3.append("] TaskId=[");
                stringBuilder3.append(this.c);
                stringBuilder3.append("] mDownloadSize=[");
                stringBuilder3.append(this.b.mDownloadSize);
                stringBuilder3.append("] mFileSize=[");
                stringBuilder3.append(this.b.mFileSize);
                stringBuilder3.append("] mDownloadSpeed=[");
                stringBuilder3.append(this.b.mDownloadSpeed);
                stringBuilder3.append("] mCacheDuration=[");
                stringBuilder3.append(this.a.e);
                stringBuilder3.append("] ");
                XLLog.d("ShortVideoTask", stringBuilder3.toString());
                return true;
            } else if (this.n) {
                stringBuilder2 = new StringBuilder("updateTaskInfo change Task, VideoId=[");
                stringBuilder2.append(this.e);
                stringBuilder2.append("] status=[");
                stringBuilder2.append(this.d);
                stringBuilder2.append("] mTaskInfo.mErrorCode=[");
                stringBuilder2.append(this.b.mErrorCode);
                stringBuilder2.append("]");
                XLLog.e("ShortVideoTask", stringBuilder2.toString());
                a(194);
                a(false);
                return true;
            } else {
                stringBuilder2 = new StringBuilder("updateTaskInfo task FAIL, VideoId=[");
                stringBuilder2.append(this.e);
                stringBuilder2.append("] status=[");
                stringBuilder2.append(this.d);
                stringBuilder2.append("] mTaskInfo.mErrorCode=[");
                stringBuilder2.append(this.b.mErrorCode);
                stringBuilder2.append("]");
                XLLog.e("ShortVideoTask", stringBuilder2.toString());
                this.d = STATUS.FAIL;
                a(this.b.mErrorCode);
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.k = 100;
            return false;
        }
    }
}
