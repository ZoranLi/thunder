package com.xiaomi.metoknlp.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.igexin.sdk.PushConsts;
import com.xiaomi.metoknlp.a;
import java.util.ArrayList;
import java.util.List;

public class c {
    private static c a;
    private Context b;
    private Handler c = new d(this, a.a().d().getLooper());
    private List d = new ArrayList();
    private BroadcastReceiver e = new e();

    private c(Context context) {
        this.b = context;
        this.b.registerReceiver(this.e, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    public static c a() {
        return a;
    }

    public static void a(Context context) {
        if (a == null) {
            a = new c(context);
        }
    }

    public void a(a aVar) {
        synchronized (this.d) {
            this.d.add(aVar);
        }
    }
}
