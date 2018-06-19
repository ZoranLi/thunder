package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

/* compiled from: MessageCenterUnreadCountManager */
final class n implements Runnable {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        this.a.setChanged();
        this.a.notifyObservers(this.a.a.b());
    }
}
