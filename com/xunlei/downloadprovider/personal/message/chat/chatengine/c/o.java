package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.d;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: ChatMessageNetwork */
public final class o extends a {
    private static o a;

    /* compiled from: ChatMessageNetwork */
    public static class a extends com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a {
        @Nullable
        static ChatMessage a(boolean z, @NonNull IChatUser iChatUser, @Nullable SingleChatDialog singleChatDialog, JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            IChatUser a;
            long optLong = jSONObject.optLong("sender");
            if (z) {
                a = e.a(optLong, iChatUser, com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().a);
            } else {
                a = iChatUser;
            }
            if (a == null) {
                return null;
            }
            iChatUser = d.a().a(a, iChatUser, jSONObject.optInt("class"), jSONObject.optString("content"));
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setMessageId(jSONObject.optLong(AgooConstants.MESSAGE_ID));
            boolean optInt = jSONObject.optInt(Impl.COLUMN_GROUP_ID);
            if (singleChatDialog == null) {
                if (z) {
                    singleChatDialog = u.a().c().b(optInt);
                } else {
                    singleChatDialog = new SingleChatDialog(optInt);
                }
            }
            if (optInt != singleChatDialog.dialogId()) {
                singleChatDialog.setDialogId(optInt);
            }
            chatMessage.setChatDialog(singleChatDialog);
            chatMessage.setMessageContent(iChatUser);
            chatMessage.setSender(a);
            chatMessage.setCreatorType(1);
            chatMessage.setCreateAt(jSONObject.optInt("created_at", f.a()));
            chatMessage.setStatus(2);
            return chatMessage;
        }

        public static com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<IChatMessage> a(boolean z, JSONObject jSONObject) {
            com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<IChatMessage> aVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a();
            if (jSONObject == null) {
                aVar.b = -1001;
                aVar.c = "jsonObject is null";
                return aVar;
            }
            aVar.c = ITagManager.SUCCESS;
            IChatUser b = com.xunlei.downloadprovider.personal.message.chat.chatengine.c.d.a.b(jSONObject.optJSONObject("group"));
            if (b == null) {
                aVar.b = -1001;
                aVar.c = "targetChatUser invalid";
                return aVar;
            }
            z = a(z, b, null, jSONObject.optJSONObject("record"));
            if (!z) {
                aVar.b = -1001;
                aVar.c = "chatMessage is null";
                return aVar;
            } else if (z.chatDialog() == null) {
                aVar.b = -1001;
                aVar.c = "chatMessage's chatDialog is null";
                return aVar;
            } else {
                SingleChatDialog singleChatDialog = (SingleChatDialog) z.chatDialog();
                singleChatDialog.setSendBefore(jSONObject.optBoolean("send_before", false));
                singleChatDialog.setFollow(jSONObject.optBoolean("is_follow", false));
                singleChatDialog.setTargetUser(b);
                aVar.a = z;
                return aVar;
            }
        }
    }

    private o() {
    }

    public static o a() {
        if (a == null) {
            a = new o();
        }
        return a;
    }
}
