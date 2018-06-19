package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseDispatchQueue */
public class c {
    private List<b> a = new ArrayList();

    public final boolean a(Context context, Intent intent) {
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                boolean a = ((b) this.a.get(i)).a(context, intent);
                c.class.getSimpleName();
                StringBuilder stringBuilder = new StringBuilder("mDispatch : ");
                stringBuilder.append(((b) this.a.get(i)).getClass().getSimpleName());
                stringBuilder.append(" result:");
                stringBuilder.append(a);
                if (a) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(b bVar) {
        if (this.a != null) {
            this.a.add(bVar);
        }
    }
}
