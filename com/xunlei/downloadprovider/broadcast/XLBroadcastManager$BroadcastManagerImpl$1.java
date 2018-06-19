package com.xunlei.downloadprovider.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.downloadprovider.broadcast.a.a.a;
import com.xunlei.downloadprovider.broadcast.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class XLBroadcastManager$BroadcastManagerImpl$1 extends BroadcastReceiver {
    final /* synthetic */ a a;

    public XLBroadcastManager$BroadcastManagerImpl$1(a aVar) {
        this.a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        a aVar = this.a;
        if (!aVar.b.isEmpty()) {
            for (b bVar : aVar.b) {
                if (!(bVar.a == null || bVar.b == null)) {
                    if (bVar.b.hasAction(intent.getAction())) {
                        bVar.a.onReceive(context, intent);
                    }
                }
            }
        }
        if (aVar.d.matchAction(intent.getAction())) {
            ArrayList arrayList = null;
            synchronized (aVar.c) {
                if (!aVar.c.isEmpty()) {
                    arrayList = new ArrayList(aVar.c);
                }
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) it.next();
                    if (aVar2.a != null) {
                        String action = intent.getAction();
                        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                            aVar2.a.a(context, intent);
                        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                            aVar2.a.b(context, intent);
                        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                            aVar2.a.c(context, intent);
                        } else {
                            "android.media.VOLUME_CHANGED_ACTION".equals(action);
                        }
                    }
                }
            }
        }
    }
}
