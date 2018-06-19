package com.xunlei.tdlive;

import android.content.Context;
import android.os.RemoteException;
import com.xunlei.tdlive.route.BaseXLLiveRoute;
import com.xunlei.tdlive.route.util.Route;

class LivePlugin$2 extends BaseXLLiveRoute {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$2(LivePlugin livePlugin, Context context) {
        this.this$0 = livePlugin;
        super(context);
    }

    protected void onInit(Route route) {
        route.register("tdlive://login", this.this$0.login);
        route.register("tdlive://authPhone", this.this$0.authPhone);
        route.register("tdlive://home", this.this$0.home);
    }

    public boolean dispatch(String str, String str2) throws RemoteException {
        if (super.dispatch(str, str2) != null) {
            return null;
        }
        LivePluginAppRouteDispatcher.dispatch(str2);
        return true;
    }
}
