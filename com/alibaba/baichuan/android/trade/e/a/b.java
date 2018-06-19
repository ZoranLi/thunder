package com.alibaba.baichuan.android.trade.e.a;

import com.alibaba.baichuan.android.trade.AlibcContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b {
    private static final String c = "b";
    private Map a = new HashMap();
    private Set b = new HashSet();

    private synchronized void b(String str, String str2, Object obj) {
        Map map = (Map) this.a.get(str);
        if (map == null) {
            map = new HashMap();
            this.a.put(str, map);
        }
        map.put(str2, obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Object a(java.lang.String r2, java.lang.String r3, java.lang.Object r4) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.a;	 Catch:{ all -> 0x0019 }
        r2 = r0.get(r2);	 Catch:{ all -> 0x0019 }
        r2 = (java.util.Map) r2;	 Catch:{ all -> 0x0019 }
        if (r2 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r2.get(r3);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r2 = r2.get(r3);	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);
        return r2;
    L_0x0017:
        monitor-exit(r1);
        return r4;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.e.a.b.a(java.lang.String, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public final synchronized void a(a aVar) {
        aVar = aVar.a;
        StringBuilder stringBuilder = new StringBuilder("config更新，config更新的参数值为:");
        String str = null;
        stringBuilder.append(aVar != null ? aVar : null);
        stringBuilder.append("   configMem当前值=");
        stringBuilder.append(this.a != null ? this.a : null);
        stringBuilder.append("   filter名单=");
        stringBuilder.append(this.b != null ? this.b.toString() : null);
        AlibcContext.b();
        if (aVar != null) {
            for (String str2 : aVar.keySet()) {
                for (Entry entry : ((Map) aVar.get(str2)).entrySet()) {
                    if (!this.b.contains(entry.getKey()) || !str2.equals("albbTradeConfig")) {
                        b(str2, (String) entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        aVar = new StringBuilder("更新后configMemdo=");
        if (this.a != null) {
            str = this.a.toString();
        }
        aVar.append(str);
        AlibcContext.b();
    }
}
