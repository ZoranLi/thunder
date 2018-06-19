package com.alibaba.sdk.android.feedback.xblink.g;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

class c implements HandshakeCompletedListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        g.a("tag", "Handshake finished!");
        StringBuilder stringBuilder = new StringBuilder("\t CipherSuite:");
        stringBuilder.append(handshakeCompletedEvent.getCipherSuite());
        g.a("tag", stringBuilder.toString());
        stringBuilder = new StringBuilder("\t SessionId ");
        stringBuilder.append(handshakeCompletedEvent.getSession());
        g.a("tag", stringBuilder.toString());
        stringBuilder = new StringBuilder("\t PeerHost ");
        stringBuilder.append(handshakeCompletedEvent.getSession().getPeerHost());
        g.a("tag", stringBuilder.toString());
    }
}
