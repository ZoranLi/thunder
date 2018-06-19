package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.frame.MainTabSpec.Tab;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;

/* compiled from: SchemeDISPCompatibleH5 */
final class k extends d {
    k() {
    }

    protected final boolean a(Intent intent) {
        if (intent != null) {
            intent = intent.getData();
            if (!(intent == null || !"xunlei.com".equals(intent.getHost()) || "xunleiapp".equals(intent.getScheme()) == null)) {
                return true;
            }
        }
        return null;
    }

    protected final void a(Context context, Intent intent) {
        intent = intent.getData();
        c.a(a.a(intent), a.b(intent));
        MainTabActivity.a(context, Tab.THUNDER.getTag(), null, false);
    }
}
