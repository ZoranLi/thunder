package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import android.content.Intent;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;

/* compiled from: MessageCenterContract */
public interface e {

    /* compiled from: MessageCenterContract */
    public interface a extends com.xunlei.downloadprovider.personal.message.chat.personalchat.d.a {
        void a(Intent intent);
    }

    /* compiled from: MessageCenterContract */
    public interface b extends com.xunlei.downloadprovider.personal.message.chat.personalchat.d.b<a> {
        void a(MessageType messageType, String str);

        void f();
    }
}
