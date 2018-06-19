package com.igexin.push.core.a.a;

import com.igexin.push.core.b;
import com.igexin.push.core.b.g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;

public class e implements a {
    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "do";	 Catch:{ JSONException -> 0x0052 }
        r0 = r4.has(r0);	 Catch:{ JSONException -> 0x0052 }
        if (r0 == 0) goto L_0x0052;	 Catch:{ JSONException -> 0x0052 }
    L_0x0008:
        r0 = "actionid";	 Catch:{ JSONException -> 0x0052 }
        r0 = r4.has(r0);	 Catch:{ JSONException -> 0x0052 }
        if (r0 == 0) goto L_0x0052;	 Catch:{ JSONException -> 0x0052 }
    L_0x0010:
        r0 = "duration";	 Catch:{ JSONException -> 0x0052 }
        r0 = r4.has(r0);	 Catch:{ JSONException -> 0x0052 }
        if (r0 == 0) goto L_0x0052;	 Catch:{ JSONException -> 0x0052 }
    L_0x0018:
        r0 = new com.igexin.push.core.bean.e;	 Catch:{ JSONException -> 0x0052 }
        r0.<init>();	 Catch:{ JSONException -> 0x0052 }
        r1 = "type";	 Catch:{ JSONException -> 0x0052 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0052 }
        r0.setType(r1);	 Catch:{ JSONException -> 0x0052 }
        r1 = "actionid";	 Catch:{ JSONException -> 0x0052 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0052 }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x0052 }
        r1 = "do";	 Catch:{ JSONException -> 0x0052 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0052 }
        r0.setDoActionId(r1);	 Catch:{ JSONException -> 0x0052 }
        r1 = "duration";	 Catch:{ JSONException -> 0x0052 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0052 }
        if (r1 == 0) goto L_0x0051;	 Catch:{ JSONException -> 0x0052 }
    L_0x0040:
        r1 = "duration";	 Catch:{ JSONException -> 0x0052 }
        r4 = r4.getString(r1);	 Catch:{ JSONException -> 0x0052 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ JSONException -> 0x0052 }
        r1 = r4.longValue();	 Catch:{ JSONException -> 0x0052 }
        r0.a(r1);	 Catch:{ JSONException -> 0x0052 }
    L_0x0051:
        return r0;
    L_0x0052:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.e.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        long currentTimeMillis = System.currentTimeMillis() + (((com.igexin.push.core.bean.e) baseAction).a() * 1000);
        g.a().a(true);
        g.a().f(currentTimeMillis);
        return true;
    }
}
