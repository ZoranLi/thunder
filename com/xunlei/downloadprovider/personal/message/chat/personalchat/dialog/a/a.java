package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.aa;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.List;

/* compiled from: DialogContentModel */
public final class a implements b {
    public final void a(IChatDialog iChatDialog, c<IChatDialog> cVar) {
        ((aa) p.a(aa.class)).a(iChatDialog, cVar);
    }

    public final void a(IChatDialog iChatDialog, @Nullable IChatMessage iChatMessage, c<List<IChatMessage>> cVar) {
        iChatDialog.listPreviousMessages(iChatMessage, 10, cVar);
    }
}
