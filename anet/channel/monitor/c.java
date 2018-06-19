package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;

/* compiled from: Taobao */
class c implements INetworkStatusChangeListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void onNetworkStatusChanged(NetworkStatus networkStatus) {
        this.a.n.a();
        b.f = 0;
        this.a.d();
    }
}
