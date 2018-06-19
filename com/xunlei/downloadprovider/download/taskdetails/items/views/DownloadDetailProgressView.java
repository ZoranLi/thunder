package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.download.speedup.view.FlickerSingleProgressView;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.r;

public class DownloadDetailProgressView extends FlickerSingleProgressView {
    private int f = null;

    public DownloadDetailProgressView(Context context) {
        super(context);
    }

    public DownloadDetailProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DownloadDetailProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public DownloadDetailProgressView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setTaskProgress(DownloadTaskInfo downloadTaskInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(downloadTaskInfo.mUrl);
        setSaveKey(stringBuilder.toString());
        switch (downloadTaskInfo.getTaskStatus()) {
            case 1:
                setVisibility(0);
                d();
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(getSaveKey());
                downloadTaskInfo.append("=state_waiting");
                return;
            case 2:
                setVisibility(0);
                d();
                stringBuilder = new StringBuilder();
                stringBuilder.append(getSaveKey());
                stringBuilder.append("=state_running");
                break;
            case 4:
                setVisibility(0);
                c();
                stringBuilder = new StringBuilder();
                stringBuilder.append(getSaveKey());
                stringBuilder.append("=state_pause");
                break;
            case 8:
                if (getVisibility() == null) {
                    setVisibility(8);
                    b();
                }
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(getSaveKey());
                downloadTaskInfo.append("=statesuccess");
                return;
            case 16:
                setVisibility(0);
                b();
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(getSaveKey());
                downloadTaskInfo.append("=statefailed");
                return;
            case 17:
                if (getVisibility() == null) {
                    setVisibility(8);
                    b();
                }
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(getSaveKey());
                downloadTaskInfo.append("=statedelete");
                return;
            default:
                break;
        }
        if (downloadTaskInfo.getTaskStatus() == 4 || downloadTaskInfo.getTaskStatus() == 2) {
            long j = 0;
            if (downloadTaskInfo.mFileSize > 0) {
                j = (downloadTaskInfo.mDownloadedSize * 100) / downloadTaskInfo.mFileSize;
            }
            this.f = (int) j;
            a(this.f);
        }
        if (r.a(downloadTaskInfo) != null) {
            a();
        } else {
            b();
        }
    }

    public int getProgress() {
        return this.f;
    }
}
