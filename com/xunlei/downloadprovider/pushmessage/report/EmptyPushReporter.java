package com.xunlei.downloadprovider.pushmessage.report;

import android.content.Context;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;

public class EmptyPushReporter<INFO extends BasePushMessageInfo> extends BasePushReporter<INFO> {
    protected void reportHubbleClick(Context context, INFO info) {
    }

    protected void reportHubbleError(Context context, INFO info, String str) {
    }

    protected void reportHubbleReceive(Context context, INFO info) {
    }

    protected void reportHubbleShow(Context context, INFO info) {
    }
}
