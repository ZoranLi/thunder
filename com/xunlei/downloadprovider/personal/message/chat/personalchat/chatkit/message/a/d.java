package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;

/* compiled from: BaseSentCommentReplyMessageHolder */
public abstract class d<CONTROLLER extends a, MESSAGE_CONTENT extends BaseCommentReplyMessageContent> extends c<IChatMessage, MESSAGE_CONTENT> {
    protected e j = null;

    protected abstract CONTROLLER a();

    protected abstract a a(CONTROLLER controller);

    public d(Context context, View view) {
        super(context, view);
        a a = a();
        this.j = new e(view, a, a(a));
    }

    public final void a(IChatMessage iChatMessage) {
        super.a(iChatMessage);
        this.j.b = this.d;
        this.j.a(iChatMessage);
    }
}
