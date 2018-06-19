package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.d.a;

/* compiled from: Taobao */
final class f extends a {
    final /* synthetic */ NetworkService a;

    f(NetworkService networkService) {
        this.a = networkService;
    }

    public final n a(int i) throws RemoteException {
        if (this.a.c[i] == null) {
            if (i != 1) {
                this.a.c[i] = new anetwork.channel.http.a(this.a.b);
            } else {
                this.a.c[i] = new anetwork.channel.c.a(this.a.b);
            }
        }
        return this.a.c[i];
    }
}
