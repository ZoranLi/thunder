package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;

/* compiled from: IChatDialogService */
public interface aa {
    @Nullable
    IChatDialog a(int i);

    void a(long j, c<IChatDialog> cVar);

    void a(c<Integer> cVar);

    void a(IChatDialog iChatDialog, c<IChatDialog> cVar);

    void a(i iVar, c<g> cVar);

    void b(i iVar, c<g> cVar);

    void c(IChatDialog iChatDialog, c<Boolean> cVar);

    void c(i iVar, c<g> cVar);
}
