package com.xunlei.downloadprovider.pushmessage.biz;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.pushmessage.bean.ChatPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.notification.ChatPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class ChatPushBiz extends BasePushBiz<ChatPushMessageInfo> {
    public ChatPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public ChatPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return ChatPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<ChatPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<ChatPushMessageInfo> createPushNotificationHandler() {
        return new ChatPushNotificationHandler();
    }
}
