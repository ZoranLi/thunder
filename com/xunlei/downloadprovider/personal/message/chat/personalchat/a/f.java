package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import android.content.Context;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: PersonalChatManager */
public final class f implements c<IChatDialog> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;
    final /* synthetic */ b d;

    public f(b bVar, Context context, String str, c cVar) {
        this.d = bVar;
        this.a = context;
        this.b = str;
        this.c = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        IChatDialog iChatDialog = (IChatDialog) obj;
        b.b();
        if (b.a(this.a, iChatDialog, this.b) == null) {
            XLToast.showToast(this.a, this.a.getString(R.string.personal_chat_dialog_open_dialog_fail));
            this.c.a(b.a(-1, "进入聊天室失败"));
            return;
        }
        this.c.a(Boolean.valueOf(true));
    }

    public final void a(b bVar) {
        int i = bVar.a;
        if (i != 1000) {
            if (i == 1003) {
                i = R.string.personal_chat_dialog_open_dialog_limit;
                XLToast.showToast(this.a, this.a.getString(i));
                this.c.a(bVar);
            }
        } else if (bVar.b == 2) {
            i = R.string.personal_chat_dialog_open_dialog_new_user_forbid;
            XLToast.showToast(this.a, this.a.getString(i));
            this.c.a(bVar);
        }
        i = R.string.personal_chat_dialog_open_dialog_fail;
        XLToast.showToast(this.a, this.a.getString(i));
        this.c.a(bVar);
    }
}
