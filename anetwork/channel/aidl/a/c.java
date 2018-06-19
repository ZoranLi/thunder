package anetwork.channel.aidl.a;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.h.a;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class c extends a {
    Future<Object> a;
    NetworkResponse b;

    public c(Future<Object> future) {
        this.a = future;
    }

    public final boolean a(boolean z) throws RemoteException {
        if (this.a == null) {
            return true;
        }
        return this.a.cancel(z);
    }

    public final boolean a() throws RemoteException {
        if (this.a == null) {
            return true;
        }
        return this.a.isCancelled();
    }

    public final boolean b() throws RemoteException {
        if (this.a == null) {
            return true;
        }
        return this.a.isDone();
    }

    public final NetworkResponse a(long j) throws RemoteException {
        if (this.a != null) {
            try {
                return (NetworkResponse) this.a.get(j, TimeUnit.MILLISECONDS);
            } catch (long j2) {
                if ("NO SUPPORT".equalsIgnoreCase(j2.getMessage())) {
                    ALog.e("anet.ParcelableFutureResponse", "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, j2, new Object[0]);
                }
                return new NetworkResponse((byte) 0);
            }
        } else if (this.b != null) {
            return this.b;
        } else {
            return new NetworkResponse((byte) 0);
        }
    }
}
