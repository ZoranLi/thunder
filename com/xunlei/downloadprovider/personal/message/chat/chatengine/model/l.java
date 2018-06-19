package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import java.util.Comparator;

/* compiled from: SingleChatDialog */
final class l implements Comparator<IChatMessage> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((IChatMessage) obj2).createdAt() - ((IChatMessage) obj).createdAt();
    }
}
