package com.qihoo360.mobilesafe.svcmanager;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qihoo360.mobilesafe.svcmanager.a.a;
import com.qihoo360.replugin.IBinderGetter;

/* compiled from: ServiceChannelImpl */
final class h extends a {
    h() {
    }

    public final IBinder a(String str) throws RemoteException {
        if (g.c) {
            g.d;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        IBinder iBinder = (IBinder) g.e.get(str);
        if (iBinder == null) {
            return c(str);
        }
        if (iBinder.isBinderAlive()) {
            if (iBinder.pingBinder()) {
                return iBinder;
            }
        }
        if (g.c) {
            g.d;
        }
        g.e.remove(str);
        return null;
    }

    private IBinder c(String str) {
        IBinderGetter iBinderGetter = (IBinderGetter) g.f.get(str);
        if (iBinderGetter == null) {
            return null;
        }
        try {
            IBinder iBinder = iBinderGetter.get();
            a(str, iBinder);
            return iBinder;
        } catch (DeadObjectException e) {
            if (g.c) {
                e.printStackTrace();
            }
            g.f.remove(str);
            return null;
        } catch (String str2) {
            if (g.c) {
                str2.printStackTrace();
            }
            return null;
        }
    }

    public final void a(String str, IBinder iBinder) throws RemoteException {
        g.e.put(str, iBinder);
    }

    public final void a(String str, IBinderGetter iBinderGetter) throws RemoteException {
        g.f.put(str, iBinderGetter);
    }

    public final void b(String str) throws RemoteException {
        g.e.remove(str);
    }

    public final IBinder a(String str, String str2, IBinder iBinder) throws RemoteException {
        return c.a(str, str2, getCallingPid(), iBinder);
    }

    public final void a(String str, String str2) throws RemoteException {
        c.a(str, str2, getCallingPid());
    }
}
