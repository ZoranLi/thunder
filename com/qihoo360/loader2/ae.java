package com.qihoo360.loader2;

import android.os.IBinder.DeathRecipient;
import com.qihoo360.replugin.packages.c;

/* compiled from: PluginProcessMain */
final class ae implements DeathRecipient {
    ae() {
    }

    public final void binderDied() {
        if (aa.a()) {
            System.exit(0);
        }
        ac.c = null;
        c.a();
    }
}
