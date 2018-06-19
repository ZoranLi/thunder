package com.xunlei.downloadprovider.member.payment.activity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ActivityModel */
final class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        Map all = c.a(this.a).getAll();
        if (all != null && !all.isEmpty()) {
            Set<String> keySet = all.keySet();
            Set<String> hashSet = new HashSet();
            for (String str : keySet) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    c.b(this.a).put(str, (Integer) obj);
                } else if (obj instanceof Boolean) {
                    c.b(this.a).put(str, Integer.valueOf(1));
                    hashSet.add(str);
                }
            }
            if (hashSet.isEmpty()) {
                for (String remove : hashSet) {
                    c.c(this.a).remove(remove);
                }
                c.c(this.a).commit();
                for (String remove2 : hashSet) {
                    c.c(this.a).putInt(remove2, 1);
                }
                c.c(this.a).commit();
            }
        }
    }
}
