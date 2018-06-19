package com.xunlei.downloadprovider.vod.dlna;

import android.os.IBinder;
import com.qihoo360.replugin.RePlugin;

/* compiled from: DLNAHelper */
public final class a {
    private static a a = new a();
    private com.xunlei.a.a.a b = null;

    public static a a() {
        return a;
    }

    public final com.xunlei.a.a.a b() {
        if (this.b == null) {
            IBinder fetchBinder = RePlugin.fetchBinder("com.xunlei.plugin.libdlna", "com.xunlei.plugin.libdlna.dlnafacade");
            if (fetchBinder != null) {
                this.b = com.xunlei.a.a.a.a.a(fetchBinder);
            }
        }
        return this.b;
    }
}
