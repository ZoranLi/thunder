package com.qihoo360.replugin.component.a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* compiled from: PluginApplicationClient */
final class b implements ComponentCallbacks2 {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onTrimMemory(int i) {
        this.a.b(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.a.b(configuration);
    }

    public final void onLowMemory() {
        this.a.b();
    }
}
