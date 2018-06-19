package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info.MessageCenterDispatchInfo;
import com.xunlei.downloadprovider.personal.message.d;
import com.xunlei.downloadprovider.pushmessage.bean.MessageCenterPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz$a;
import com.xunlei.downloadprovider.pushmessage.l;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.xllib.android.XLIntent;

public abstract class MessageCenterPushNotificationHandler extends NotificationManagerPushNotificationHandler<MessageCenterPushMessageInfo> {
    public String getNotificationTag(MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
        return null;
    }

    public void onClick(Context context, MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
    }

    public void onDismiss(Context context, MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
    }

    public Notification getNotification(Context context, MessageCenterPushMessageInfo messageCenterPushMessageInfo, int i, Bitmap bitmap) {
        context = m.a(context, messageCenterPushMessageInfo.getTitle(), messageCenterPushMessageInfo.getDesc(), i);
        d.a().b();
        return context;
    }

    public Intent createClickIntent(Context context, MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
        String videoId = messageCenterPushMessageInfo.getVideoId();
        String gcId = messageCenterPushMessageInfo.getGcId();
        Intent xLIntent = new XLIntent(context, LaunchActivity.class);
        xLIntent.addFlags(268435456);
        new MessageCenterDispatchInfo("push_click", getMessageCenterDispatchTo(messageCenterPushMessageInfo.getDisplayType())).buildIntent(xLIntent);
        xLIntent.putExtra("dispatch_from_key", 1105);
        messageCenterPushMessageInfo = new StringBuilder("createNewIntent movieId=");
        messageCenterPushMessageInfo.append(videoId);
        messageCenterPushMessageInfo.append(",gcId=");
        messageCenterPushMessageInfo.append(gcId);
        l.a(context);
        return xLIntent;
    }

    private static int getMessageCenterDispatchTo(int i) {
        switch (a.a[getMessageCenterMessageType(i).ordinal()]) {
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
                return 3;
            case 4:
                return 2;
            default:
                return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType getMessageCenterMessageType(int r1) {
        /*
        r0 = 6;
        if (r1 == r0) goto L_0x0018;
    L_0x0003:
        switch(r1) {
            case 2: goto L_0x0015;
            case 3: goto L_0x0012;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r1) {
            case 10: goto L_0x0015;
            case 11: goto L_0x0012;
            case 12: goto L_0x0015;
            default: goto L_0x0009;
        };
    L_0x0009:
        switch(r1) {
            case 17: goto L_0x000f;
            case 18: goto L_0x0015;
            case 19: goto L_0x0012;
            default: goto L_0x000c;
        };
    L_0x000c:
        r1 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.UNKNOWN;
        return r1;
    L_0x000f:
        r1 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.VISIT;
        return r1;
    L_0x0012:
        r1 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.STAR;
        return r1;
    L_0x0015:
        r1 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.COMMENT;
        return r1;
    L_0x0018:
        r1 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.FOLLOW;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.notification.MessageCenterPushNotificationHandler.getMessageCenterMessageType(int):com.xunlei.downloadprovider.personal.message.MessageActivty$MessageType");
    }

    public BasePushBiz$a shouldInterceptNotification(Context context, MessageCenterPushMessageInfo messageCenterPushMessageInfo) {
        return BasePushBiz$a.a(null, "");
    }
}
