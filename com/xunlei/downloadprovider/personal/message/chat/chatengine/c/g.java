package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatCustomMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatDialogNetwork */
public final class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ c b;
    final /* synthetic */ long c;
    final /* synthetic */ ChatMessage d;
    final /* synthetic */ d e;

    public g(d dVar, int i, c cVar, long j, ChatMessage chatMessage) {
        this.e = dVar;
        this.a = i;
        this.b = cVar;
        this.c = j;
        this.d = chatMessage;
    }

    public final void run() {
        c cVar;
        StringBuilder stringBuilder;
        if (this.a != 1) {
            cVar = this.b;
            stringBuilder = new StringBuilder("do not support this dialog type. dialogType: ");
            stringBuilder.append(this.a);
            cVar.a(b.a(-1000, stringBuilder.toString()));
        } else if (this.c == 0) {
            this.b.a(b.a(-1000, "targetUserId can not be zero."));
        } else if (this.d.messageContent() == null) {
            this.b.a(b.a(-1000, "chatMessage.messageContent() can not be null."));
        } else {
            int type;
            String content;
            JSONObject a;
            d a2 = d.a();
            IChatMessageContent messageContent = this.d.messageContent();
            int type2 = messageContent.type();
            boolean z = false;
            if (type2 != 1) {
                if (type2 != 3) {
                    if (type2 != 1001) {
                    }
                } else if (a2.a != null) {
                    a aVar = a2.a;
                    if (messageContent instanceof IChatCustomMessageContent) {
                        z = aVar.a((IChatCustomMessageContent) messageContent);
                    } else {
                        stringBuilder = new StringBuilder("messageContent can not be: ");
                        stringBuilder.append(messageContent.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                if (z) {
                    cVar = this.b;
                    stringBuilder = new StringBuilder("do not support this messageContent: ");
                    stringBuilder.append(this.d.messageContent());
                    cVar.a(b.a(-1000, stringBuilder.toString()));
                }
                type = this.d.messageContent().type();
                content = this.d.messageContent().content();
                if (TextUtils.isEmpty(content)) {
                    try {
                        a = d.a(this.c, content, type);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        c cVar2 = this.b;
                        StringBuilder stringBuilder2 = new StringBuilder("build requestBody error. e: ");
                        stringBuilder2.append(e.getMessage());
                        cVar2.a(b.a(-1000, stringBuilder2.toString()));
                        a = null;
                    }
                    this.e.b(this.e.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/one-to-one/record", a, new h(this)));
                    return;
                }
                this.b.a(b.a(-1000, "chatMessage.messageContent().content can not be empty."));
                return;
            }
            z = true;
            if (z) {
                type = this.d.messageContent().type();
                content = this.d.messageContent().content();
                if (TextUtils.isEmpty(content)) {
                    a = d.a(this.c, content, type);
                    this.e.b(this.e.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/one-to-one/record", a, new h(this)));
                    return;
                }
                this.b.a(b.a(-1000, "chatMessage.messageContent().content can not be empty."));
                return;
            }
            cVar = this.b;
            stringBuilder = new StringBuilder("do not support this messageContent: ");
            stringBuilder.append(this.d.messageContent());
            cVar.a(b.a(-1000, stringBuilder.toString()));
        }
    }
}
