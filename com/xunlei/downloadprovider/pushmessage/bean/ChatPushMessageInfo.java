package com.xunlei.downloadprovider.pushmessage.bean;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.o.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.e;
import org.json.JSONObject;

public class ChatPushMessageInfo extends BasePushMessageInfo {
    public int chatDialogId;
    public IChatMessage chatNotifyAndReportMessage;
    public String chatPushMsgBody;
    public long receiverUserId;

    public static ChatPushMessageInfo parse(PushOriginalInfo pushOriginalInfo) {
        BasePushMessageInfo chatPushMessageInfo = new ChatPushMessageInfo();
        BasePushMessageInfo.parseBaseInfo(chatPushMessageInfo, pushOriginalInfo);
        parseChatParams(pushOriginalInfo.getCustomMsgBody(), pushOriginalInfo.getCustomMsgJO(), chatPushMessageInfo);
        return chatPushMessageInfo;
    }

    private static void parseChatParams(String str, JSONObject jSONObject, ChatPushMessageInfo chatPushMessageInfo) {
        chatPushMessageInfo.setReceiverUserId(jSONObject.optLong("receiver"));
        chatPushMessageInfo.setChatPushMsgBody(str);
        str = a.a(p.b(), jSONObject);
        if (a.a(str)) {
            chatPushMessageInfo.setChatNotifyAndReportMessage((IChatMessage) str.a);
            if (chatPushMessageInfo.getChatNotifyAndReportMessage() != null) {
                chatPushMessageInfo.setChatDialogId(chatPushMessageInfo.getChatNotifyAndReportMessage().chatDialog().dialogId());
                str = chatPushMessageInfo.getChatNotifyAndReportMessage();
                e eVar = new e();
                jSONObject = jSONObject.optInt("unread_num");
                eVar.a = BrothersApplication.getApplicationInstance().getResources().getString(R.string.personal_chat_notification_title);
                eVar.c = str.sender().avatarUrl();
                StringBuilder stringBuilder = new StringBuilder("[");
                stringBuilder.append(jSONObject);
                stringBuilder.append("]");
                stringBuilder.append(str.sender().nickname());
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(str.messageContent().previewText());
                eVar.b = stringBuilder.toString();
                new StringBuilder("parseChatNotificationInfo info: ").append(eVar.toString());
                chatPushMessageInfo.setTitle(eVar.a);
                chatPushMessageInfo.setDesc(eVar.b);
                chatPushMessageInfo.setBigPic(eVar.c);
            }
        }
    }

    public int getChatDialogId() {
        return this.chatDialogId;
    }

    public void setChatDialogId(int i) {
        this.chatDialogId = i;
    }

    public IChatMessage getChatNotifyAndReportMessage() {
        return this.chatNotifyAndReportMessage;
    }

    public void setChatNotifyAndReportMessage(IChatMessage iChatMessage) {
        this.chatNotifyAndReportMessage = iChatMessage;
    }

    public long getReceiverUserId() {
        return this.receiverUserId;
    }

    public void setReceiverUserId(long j) {
        this.receiverUserId = j;
    }

    public String getChatPushMsgBody() {
        return this.chatPushMsgBody;
    }

    public void setChatPushMsgBody(String str) {
        this.chatPushMsgBody = str;
    }
}
