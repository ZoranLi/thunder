package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;

/* compiled from: BaseReceivedCommentReplyMessageHolder */
public abstract class c<CONTROLLER extends a, MESSAGE_CONTENT extends BaseCommentReplyMessageContent> extends b<IChatMessage, MESSAGE_CONTENT> {
    protected e i = null;

    protected abstract CONTROLLER a();

    protected abstract a a(CONTROLLER controller);

    public c(Context context, View view) {
        super(context, view);
        a a = a();
        this.i = new e(view, a, a(a));
    }

    public final void a(IChatMessage iChatMessage) {
        super.a(iChatMessage);
        this.i.b = this.d;
        this.i.a(iChatMessage);
    }
}
