package com.alibaba.mtl.appmonitor.f;

import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.i;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.t;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: UTUtil */
public final class c {
    public static void a(UTDimensionValueSet uTDimensionValueSet, d dVar) {
        Integer c = uTDimensionValueSet.c();
        if (c != null) {
            f a = f.a(c.intValue());
            i iVar = (i) a.a().a(i.class, new Object[0]);
            iVar.b = 6699;
            if (uTDimensionValueSet.b() != null) {
                iVar.f.putAll(uTDimensionValueSet.b());
            }
            uTDimensionValueSet = new HashMap();
            uTDimensionValueSet.put("meta", t.a());
            uTDimensionValueSet.put("_event_id", c);
            b bVar = (com.alibaba.mtl.appmonitor.c.d) a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
            bVar.put(dVar.c());
            a.a().a((b) dVar);
            uTDimensionValueSet.put("data", bVar);
            iVar.f.put(a.a(), new JSONObject(uTDimensionValueSet).toString());
            iVar.f.put(LogField.EVENTID.toString(), "6699");
            a(iVar);
            a.a().a(bVar);
        }
    }

    public static void a(i iVar) {
        com.alibaba.mtl.log.e.i.a("UTUtil", "upload without flowback. args:", iVar.f);
        com.alibaba.mtl.appmonitor.e.a.a();
        com.alibaba.mtl.appmonitor.e.a.a(iVar.f);
        a.a().a((b) iVar);
    }
}
