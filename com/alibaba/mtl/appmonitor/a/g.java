package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.f.c;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.t;
import com.alibaba.mtl.log.model.LogField;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: EventRepo */
final class g implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ e b;

    g(e eVar, Map map) {
        this.b = eVar;
        this.a = map;
    }

    public final void run() {
        Map map = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            b bVar = (UTDimensionValueSet) entry.getKey();
            List<b> list = (List) entry.getValue();
            if (list.size() != 0) {
                Integer c = bVar.c();
                if (c != null) {
                    f a = f.a(c.intValue());
                    int i = 0;
                    i iVar = (i) a.a().a(i.class, new Object[0]);
                    iVar.b = c.intValue();
                    if (bVar.b() != null) {
                        iVar.f.putAll(bVar.b());
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("meta", t.a());
                    b bVar2 = (d) a.a().a(d.class, new Object[0]);
                    for (b bVar3 : list) {
                        bVar2.put(bVar3.c());
                        if (i == 0) {
                            stringBuilder.append(bVar3.f);
                            stringBuilder2.append(bVar3.g);
                        } else {
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder.append(bVar3.f);
                            stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder2.append(bVar3.g);
                        }
                        i++;
                        a.a().a(bVar3);
                    }
                    hashMap.put("data", bVar2);
                    iVar.f.put(a.a(), new JSONObject(hashMap).toString());
                    String stringBuilder3 = stringBuilder.toString();
                    String stringBuilder4 = stringBuilder2.toString();
                    iVar.f.put(LogField.ARG1.toString(), stringBuilder3);
                    iVar.f.put(LogField.ARG2.toString(), stringBuilder4);
                    iVar.c = stringBuilder3;
                    iVar.d = stringBuilder4;
                    c.a(iVar);
                    a.a().a(bVar2);
                }
            }
            a.a().a(bVar);
        }
    }
}
