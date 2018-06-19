package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.a;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.List;

/* compiled from: IDialogContentModel */
public interface b {
    void a(IChatDialog iChatDialog, c<IChatDialog> cVar);

    void a(IChatDialog iChatDialog, @Nullable IChatMessage iChatMessage, c<List<IChatMessage>> cVar);
}
