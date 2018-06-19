package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import android.database.Observable;
import java.util.Iterator;

/* compiled from: MessageCenterDataObservable */
public class h extends Observable<i> {
    public final void d(int i) {
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(i);
        }
    }
}
