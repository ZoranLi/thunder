package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.common.concurrent.XLThreadPool;

/* compiled from: DNLAController */
final class h extends BroadcastReceiver {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            context = intent.getAction();
            intent = -1;
            int hashCode = context.hashCode();
            if (hashCode != 878007972) {
                if (hashCode == 1805719813) {
                    if (context.equals("ACTION_OnPrepared") != null) {
                        intent = true;
                    }
                }
            } else if (context.equals("ACTION_OnCompletion") != null) {
                intent = null;
            }
            switch (intent) {
                case null:
                    return;
                case 1:
                    XLThreadPool.execute(new i(this.a));
                    break;
                default:
                    break;
            }
        }
    }
}
