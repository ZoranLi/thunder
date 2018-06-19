package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.launch.f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: XunleiAppSchemeDISP */
public final class t extends b {
    private List<d> a;

    protected final void a(Context context) {
    }

    protected final boolean a(Intent intent) {
        if (intent != null) {
            intent = intent.getData();
            if (!(intent == null || "xunleiapp".equals(intent.getScheme()) == null)) {
                return true;
            }
        }
        return null;
    }

    public final boolean a(Context context, Intent intent) {
        if (intent != null && a(intent) && a.c(intent.getData())) {
            if (this.a == null) {
                List arrayList = new ArrayList(5);
                arrayList.add(new l());
                arrayList.add(new j());
                arrayList.add(new n());
                arrayList.add(new m());
                arrayList.add(new p());
                arrayList.add(new i());
                arrayList.add(new o());
                arrayList.add(new k());
                this.a = arrayList;
            }
            for (d dVar : this.a) {
                boolean b = dVar.b(context, intent);
                StringBuilder stringBuilder = new StringBuilder("mDispatch : ");
                stringBuilder.append(dVar.getClass().getSimpleName());
                stringBuilder.append(" result:");
                stringBuilder.append(b);
                if (b) {
                    context = 1;
                    break;
                }
            }
            context = null;
            if (context != null) {
                return true;
            }
        }
        return false;
    }
}
