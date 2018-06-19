package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;

/* compiled from: BaseCommentReplyMessageResourceItem */
public abstract class a<CONTROLLER extends com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.a, MESSAGE_CONTENT extends BaseCommentReplyMessageContent> {
    protected View a = null;
    protected CONTROLLER b = null;
    com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a c = null;
    protected TextView d = null;
    protected TextView e = null;
    IChatMessage f = null;
    MESSAGE_CONTENT g = null;
    private View h = null;

    public a(View view, CONTROLLER controller) {
        this.a = view;
        this.b = controller;
    }

    protected void a() {
        this.h = this.a.findViewById(R.id.fl_resource);
        this.d = (TextView) this.a.findViewById(R.id.tv_comment);
        this.e = (TextView) this.a.findViewById(R.id.tv_comment_user_nickname);
    }

    protected final void b() {
        this.h.setOnClickListener(new b(this));
    }

    public void a(MESSAGE_CONTENT message_content) {
        this.g = message_content;
        message_content = this.g.getMessageContent();
        this.d.setText(message_content.a);
        message_content = message_content.f;
        message_content = message_content != null ? message_content.nickname() : BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_default_user_nickname);
        TextView textView = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message_content);
        stringBuilder.append("：");
        textView.setText(stringBuilder.toString());
    }
}
