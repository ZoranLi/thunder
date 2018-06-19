package com.xunlei.downloadprovider.personal.a.c;

import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import java.util.Observable;
import java.util.Observer;

/* compiled from: UserInfoViewHolder */
final class ae implements Observer {
    final /* synthetic */ s a;

    ae(s sVar) {
        this.a = sVar;
    }

    public final void update(Observable observable, Object obj) {
        if ((observable instanceof j) != null) {
            this.a.j();
            this.a.i();
        }
    }
}
