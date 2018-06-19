package com.igexin.push.core.a;

import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import java.util.HashMap;
import java.util.Map;

public class j extends a {
    private static final String a = l.a;
    private static Map<String, b> b;

    public j() {
        Map hashMap = new HashMap();
        b = hashMap;
        hashMap.put("redirect_server", new t());
        b.put("response_deviceid", new v());
        b.put("pushmessage", new r());
        b.put("received", new s());
        b.put("sendmessage_feedback", new w());
        b.put("block_client", new d());
        b.put("settag_result", new x());
        b.put("response_bind", new c());
        b.put("response_unbind", new y());
    }

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4 instanceof com.igexin.push.d.c.p;
        if (r0 == 0) goto L_0x0062;
    L_0x0004:
        r0 = r4;
        r0 = (com.igexin.push.d.c.p) r0;
        r1 = r0.a();
        if (r1 == 0) goto L_0x0062;
    L_0x000d:
        r1 = r0.e;
        if (r1 == 0) goto L_0x0062;
    L_0x0011:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0062 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0062 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0062 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0062 }
        r0 = "action";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x0062 }
    L_0x0022:
        r0 = "action";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0062 }
        r2 = "received";	 Catch:{ Exception -> 0x0062 }
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x0062 }
        if (r0 != 0) goto L_0x0045;	 Catch:{ Exception -> 0x0062 }
    L_0x0030:
        r0 = "id";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x0062 }
    L_0x0038:
        r0 = "id";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0062 }
        r2 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x0062 }
        r2.a(r0);	 Catch:{ Exception -> 0x0062 }
    L_0x0045:
        r0 = "action";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0062;	 Catch:{ Exception -> 0x0062 }
    L_0x004d:
        r0 = "action";	 Catch:{ Exception -> 0x0062 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0062 }
        r2 = b;	 Catch:{ Exception -> 0x0062 }
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x0062 }
        r0 = (com.igexin.push.core.a.b) r0;	 Catch:{ Exception -> 0x0062 }
        if (r0 == 0) goto L_0x0062;	 Catch:{ Exception -> 0x0062 }
    L_0x005d:
        r4 = r0.a(r4, r1);	 Catch:{ Exception -> 0x0062 }
        return r4;
    L_0x0062:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.j.a(java.lang.Object):boolean");
    }
}
