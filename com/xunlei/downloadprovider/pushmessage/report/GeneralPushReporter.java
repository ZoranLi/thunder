package com.xunlei.downloadprovider.pushmessage.report;

import android.content.Context;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;

public class GeneralPushReporter<INFO extends BasePushMessageInfo> extends BasePushReporter<INFO> {
    protected void reportHubbleReceive(Context context, INFO info) {
        l.a(info, null);
    }

    protected void reportHubbleShow(Context context, INFO info) {
        l.a(info, true);
    }

    protected void reportHubbleClick(Context context, INFO info) {
        l.c(info.getDisplayType(), info.getResTypeReport(), info.getMessageId(), info.getDeviceToken(), info.getServerTypeReport(), info.getTarget());
    }

    protected void reportHubbleError(Context context, INFO info, String str) {
        context = HubbleEventBuilder.build("android_push", "push_error");
        l.a(info.getDisplayType(), info.getResTypeReport(), info.getMessageId(), info.getDeviceToken(), info.getServerTypeReport(), info.getTarget(), (StatEvent) context);
        context.add("errcode", str);
        l.a(context);
    }
}
