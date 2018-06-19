package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDialogHelper */
final class b implements a<T> {
    final /* synthetic */ int a;

    b(int i) {
        this.a = i;
    }

    public final boolean a(T t) {
        if (t instanceof IChatDialog) {
            IChatDialog.a aVar = new IChatDialog.a();
            if (IChatDialog.a.a(Integer.valueOf(this.a), (IChatDialog) t) == null) {
                return true;
            }
        }
        return null;
    }
}
