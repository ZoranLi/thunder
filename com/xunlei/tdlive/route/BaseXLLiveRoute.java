package com.xunlei.tdlive.route;

import android.content.Context;
import android.os.RemoteException;
import com.xunlei.tdlive.route.IXLLiveRoute.Stub;
import com.xunlei.tdlive.route.util.Route;

public abstract class BaseXLLiveRoute extends Stub {
    private Context a;
    private Route b;

    public abstract void onInit(Route route);

    public BaseXLLiveRoute(Context context) {
        this.a = context;
    }

    public boolean dispatch(String str, String str2) throws RemoteException {
        if (this.b == null) {
            Route route = new Route();
            this.b = route;
            onInit(route);
        }
        return this.b.doRoute(getContext(), str, str2);
    }

    public final Context getContext() {
        return this.a;
    }
}
