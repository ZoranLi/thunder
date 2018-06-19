package com.xunlei.downloadprovider.personal.message.chat.personalchat;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.xllib.b.k;

/* compiled from: ChatReport */
public final class c {
    public static void a(IChatMessage iChatMessage, String str, boolean z) {
        IChatDialog chatDialog = iChatMessage.chatDialog();
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_message_click");
        build.add("relationship", chatDialog.isFollow() ? "follow_you" : "stranger");
        build.add("friendid", chatDialog.targetUser().userId());
        build.add("sessionid", chatDialog.dialogId());
        build.add("messageid", iChatMessage.messageId());
        build.add("content", k.c(iChatMessage.messageContent().previewText(), "UTF-8"));
        build.add("send_ts", iChatMessage.createdAt());
        build.add("contentid", a(iChatMessage.messageContent()));
        build.add("type", iChatMessage.messageContent().reportType());
        build.add("area", str);
        build.add("action", z ? "go" : "none");
        ThunderReport.reportEvent(build);
    }

    public static String a(IChatMessageContent iChatMessageContent) {
        return iChatMessageContent instanceof BaseCommentReplyMessageContent ? ((BaseCommentReplyMessageContent) iChatMessageContent).reportContentId() : "";
    }

    public static void a(IChatDialog iChatDialog, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_pannel_action");
        a(iChatDialog, str, build);
        build.add("action", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a(IChatMessage iChatMessage, String str, boolean z, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_send_result");
        a(iChatMessage.chatDialog(), str, build);
        build.add("messageid", z ? iChatMessage.messageId() : 0);
        build.add("content", k.c(iChatMessage.messageContent().previewText(), "UTF-8"));
        build.add("result", z ? "success" : "fail");
        iChatMessage = "errorcode";
        if (z) {
            i = 0;
        }
        build.add(iChatMessage, i);
        ThunderReport.reportEvent(build);
    }

    public static void a(IChatDialog iChatDialog, String str, boolean z, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_follow_click_result");
        a(iChatDialog, str, build);
        build.add("result", z ? "success" : "fail");
        iChatDialog = "errorcode";
        if (z) {
            i = 0;
        }
        build.add(iChatDialog, i);
        ThunderReport.reportEvent(build);
    }

    public static void a() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_personal_click", "chat_pop_show"));
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "chat_pop_click");
        build.add("action", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(IChatDialog iChatDialog, String str, StatEvent statEvent) {
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        statEvent.add("from", str);
        if (iChatDialog != null) {
            statEvent.add("relationship", iChatDialog.isFollow() ? "follow_you" : "stranger");
            statEvent.add("friendid", iChatDialog.targetUser().userId());
            statEvent.add("sessionid", iChatDialog.dialogId());
        }
    }
}
