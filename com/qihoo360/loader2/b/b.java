package com.qihoo360.loader2.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.qihoo360.loader2.b.a.a;
import com.qihoo360.replugin.b.c;
import java.util.HashMap;

/* compiled from: PrefImpl */
public final class b extends a {
    HashMap<String, Bundle> a = new HashMap();

    private Bundle b(String str) {
        Bundle bundle;
        synchronized (this.a) {
            bundle = (Bundle) this.a.get(str);
            if (bundle == null) {
                bundle = new Bundle();
                this.a.put(str, bundle);
            }
        }
        return bundle;
    }

    public final String a(String str, String str2, String str3) throws RemoteException {
        Bundle b = b(str);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("get: category=");
            stringBuilder.append(str);
            stringBuilder.append(" bundle=");
            stringBuilder.append(b);
            stringBuilder.append(" key=");
            stringBuilder.append(str2);
            c.a("ws001", stringBuilder.toString());
        }
        return b.containsKey(str2) != null ? b.getString(str2) : str3;
    }

    public final void b(String str, String str2, String str3) throws RemoteException {
        Bundle b = b(str);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("set: category=");
            stringBuilder.append(str);
            stringBuilder.append(" bundle=");
            stringBuilder.append(b);
            stringBuilder.append(" key=");
            stringBuilder.append(str2);
            stringBuilder.append(" value=");
            stringBuilder.append(str3);
            c.a("ws001", stringBuilder.toString());
        }
        b.putString(str2, str3);
    }

    public final Bundle a(String str) throws RemoteException {
        Bundle b = b(str);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("getAll: category=");
            stringBuilder.append(str);
            stringBuilder.append(" bundle=");
            stringBuilder.append(b);
            c.a("ws001", stringBuilder.toString());
        }
        return b;
    }
}
