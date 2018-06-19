package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.r;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;

/* compiled from: PersonalChatStrangerViewHolder */
public final class a extends r<IChatDialog> {
    protected View a = null;
    protected ImageView b = null;
    protected TextView c = null;
    protected TextView d = null;
    protected TextView e = null;
    protected TextView f = null;
    protected UserInfoTagView i = null;

    public final /* synthetic */ void a(b bVar) {
        IChatDialog iChatDialog = (IChatDialog) bVar;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.b.a(this.f, iChatDialog.getUnreadCount());
        com.xunlei.downloadprovider.personal.message.chat.a.a(this.b.getContext(), iChatDialog.getAvatarUrl(), this.b);
        this.c.setText(iChatDialog.getTitle());
        this.d.setText(iChatDialog.lastMessage() != null ? iChatDialog.lastMessage().messageContent().previewText() : "");
        this.e.setText(this.g.a(f.a(iChatDialog.lastMessage())));
        this.e.setVisibility(iChatDialog.lastMessage().createdAt() == 0 ? 8 : 0);
        bVar = iChatDialog.targetUser().userInfo();
        if (bVar != null) {
            this.i.setUserInfo(bVar);
            this.i.setVisibility(0);
            return;
        }
        this.i.setVisibility(8);
    }

    public a(View view) {
        super(view);
        this.a = view.findViewById(R.id.root_view);
        this.b = (ImageView) view.findViewById(R.id.iv_avatar);
        this.c = (TextView) view.findViewById(R.id.tv_name);
        this.d = (TextView) view.findViewById(R.id.tv_desc);
        this.e = (TextView) view.findViewById(R.id.tv_date);
        this.f = (TextView) view.findViewById(R.id.tv_unread_count);
        this.i = (UserInfoTagView) view.findViewById(R.id.view_user_info_tag);
    }
}
