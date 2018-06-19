package com.xunlei.downloadprovider.plugin.a;

import android.content.Context;
import android.os.Bundle;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.plugin.q.a;

/* compiled from: ThunderHostFacadeImpl */
final class g implements a {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    g(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    public final void onPluginProgressUpdate(int i) {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        Bundle a = d.a("Host_Plugin_Manager_OnPluginProgressUpdate", this.a);
        a.putInt("percent", i);
        c.a(applicationInstance, "ACTION_Host_Plugin_Manager", a);
    }

    public final void onPluginPrepared() {
        c.a(BrothersApplication.getApplicationInstance(), "ACTION_Host_Plugin_Manager", d.a("Host_Plugin_Manager_OnPluginPrepared", this.a));
    }

    public final void onPluginFail(int i) {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        Bundle a = d.a("Host_Plugin_Manager_OnPluginFail", this.a);
        a.putInt("errorCode", i);
        c.a(applicationInstance, "ACTION_Host_Plugin_Manager", a);
    }
}
