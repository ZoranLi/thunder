package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;

/* compiled from: ChatDialogHelper */
final class c implements b<T, Z> {
    c() {
    }

    public final boolean a(T t, Z z) {
        if ((t instanceof SingleChatDialog) && (z instanceof SingleChatDialog)) {
            SingleChatDialog singleChatDialog = (SingleChatDialog) t;
            SingleChatDialog singleChatDialog2 = (SingleChatDialog) z;
            singleChatDialog2.tryUpdateLastMessage(singleChatDialog.lastMessage());
            singleChatDialog2.tryUpdateLastServerMessage(singleChatDialog.lastServerMessage());
            if (singleChatDialog.syncTime() > singleChatDialog2.syncTime()) {
                singleChatDialog2.setSyncTime(singleChatDialog.syncTime());
            }
        }
        return true;
    }
}
