package com.xunlei.downloadprovider.pushmessage.report;

import android.content.Context;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;

public abstract class BasePushReporter<INFO extends BasePushMessageInfo> implements IPushReporter<INFO> {
    protected abstract void reportHubbleClick(Context context, INFO info);

    protected abstract void reportHubbleError(Context context, INFO info, String str);

    protected abstract void reportHubbleReceive(Context context, INFO info);

    protected abstract void reportHubbleShow(Context context, INFO info);

    public void reportReceive(Context context, INFO info) {
        if (info.IsReportHubblePop()) {
            reportHubbleReceive(context, info);
        }
    }

    public void reportShow(Context context, INFO info) {
        if (info.IsReportHubblePop()) {
            reportHubbleShow(context, info);
        }
    }

    public void reportClick(Context context, INFO info) {
        reportHubbleClick(context, info);
    }

    public void reportError(Context context, INFO info, String str) {
        reportHubbleError(context, info, str);
    }
}
