package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.notification.h;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.pushmessage.a;
import com.xunlei.downloadprovider.pushmessage.bean.ChatPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz$a;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.b.k;

public class ChatPushNotificationHandler extends NotificationManagerPushNotificationHandler<ChatPushMessageInfo> {
    public String getNotificationTag(ChatPushMessageInfo chatPushMessageInfo) {
        return "single_chat_message";
    }

    public void onClick(Context context, ChatPushMessageInfo chatPushMessageInfo) {
    }

    public BasePushBiz$a shouldInterceptNotification(Context context, ChatPushMessageInfo chatPushMessageInfo) {
        if (b.c() != null) {
            if (b.d() != null) {
                LoginHelper.a();
                if (l.c() == null) {
                    return BasePushBiz$a.a(true, "user has logged out");
                }
                if (chatPushMessageInfo.getReceiverUserId() != LoginHelper.a().g.c()) {
                    return BasePushBiz$a.a(true, "invalid receiver");
                }
                if (chatPushMessageInfo.getChatNotifyAndReportMessage() != null && chatPushMessageInfo.getChatNotifyAndReportMessage().chatDialog() != null && ((long) chatPushMessageInfo.getChatNotifyAndReportMessage().createdAt()) < chatPushMessageInfo.getChatNotifyAndReportMessage().chatDialog().syncTime()) {
                    return BasePushBiz$a.a(true, "ignore this delay chatMessage. chatMessage.createAt < chatDialog.syncTime");
                }
                a.a().a(chatPushMessageInfo.getChatPushMsgBody());
                if (chatPushMessageInfo.getChatNotifyAndReportMessage() == null) {
                    return BasePushBiz$a.a(true, "chatNotifyAndReportMessage is null");
                }
                context = chatPushMessageInfo.getChatNotifyAndReportMessage();
                IChatDialog chatDialog = context.chatDialog();
                StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_receive");
                build.add("relationship", chatDialog.isFollow() ? "follow_you" : "stranger");
                build.add("friendid", chatDialog.targetUser().userId());
                build.add("sessionid", chatDialog.dialogId());
                build.add("messageid", context.messageId());
                build.add("content", k.c(context.messageContent().previewText(), "UTF-8"));
                build.add("send_ts", context.createdAt());
                build.add("contentid", c.a(context.messageContent()));
                build.add("type", context.messageContent().reportType());
                ThunderReport.reportEvent(build);
                a.a();
                if (a.a(chatPushMessageInfo.getChatNotifyAndReportMessage()) == null) {
                    return BasePushBiz$a.a(true, "don't need show");
                }
                chatPushMessageInfo.setChatNotifyAndReportMessage(null);
                return BasePushBiz$a.a(null, "");
            }
        }
        return BasePushBiz$a.a(true, "chat switch off or chat disabled");
    }

    public Notification getNotification(Context context, ChatPushMessageInfo chatPushMessageInfo, int i, Bitmap bitmap) {
        return m.a(context, chatPushMessageInfo.getTitle(), chatPushMessageInfo.getDesc(), i);
    }

    public int getNotificationId(ChatPushMessageInfo chatPushMessageInfo) {
        chatPushMessageInfo = chatPushMessageInfo.getChatDialogId();
        h.a(Integer.valueOf(chatPushMessageInfo));
        return chatPushMessageInfo;
    }

    public void onDismiss(Context context, ChatPushMessageInfo chatPushMessageInfo) {
        h.b(Integer.valueOf(chatPushMessageInfo.getChatDialogId()));
    }

    public Intent createClickIntent(Context context, ChatPushMessageInfo chatPushMessageInfo) {
        Intent xLIntent = new XLIntent(context, LaunchActivity.class);
        xLIntent.addFlags(268435456);
        xLIntent.putExtra("chat_push_msg_body", chatPushMessageInfo.getChatPushMsgBody());
        xLIntent.putExtra("dispatch_from_key", 1115);
        h.a();
        return xLIntent;
    }
}
