package com.xunlei.downloadprovider.pushmessage.biz;

import android.support.annotation.NonNull;
import android.support.v4.view.PointerIconCompat;
import com.xunlei.downloadprovider.pushmessage.bean.MessageCenterPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.MessageCenterPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class MessageCenterPushBiz extends BasePushBiz<MessageCenterPushMessageInfo> {
    public static boolean isMessageCenterDisplayType(int i) {
        switch (i) {
            case 2:
            case 3:
            case 6:
            case 10:
            case 11:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return true;
            default:
                return false;
        }
    }

    public MessageCenterPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public MessageCenterPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return MessageCenterPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<MessageCenterPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<MessageCenterPushMessageInfo> createPushNotificationHandler() {
        return new MessageCenterPushNotificationHandler() {
            public int getNotificationId(MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
                switch (messageCenterPushMessageInfo.getDisplayType()) {
                    case 2:
                        return 1002;
                    case 3:
                        return 1003;
                    case 6:
                        return 1005;
                    case 10:
                        return 1008;
                    case 11:
                        return 1009;
                    case 12:
                        return 1010;
                    case 15:
                        return 1013;
                    case 16:
                        return 1014;
                    case 17:
                        return 1016;
                    case 18:
                        return PointerIconCompat.TYPE_ZOOM_IN;
                    case 19:
                        return PointerIconCompat.TYPE_ZOOM_OUT;
                    default:
                        return null;
                }
            }
        };
    }
}
