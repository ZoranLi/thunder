package com.igexin.push.core.a.a;

import com.igexin.b.a.c.a;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.g;

public class f implements a {
    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new com.igexin.push.core.bean.BaseAction;	 Catch:{ JSONException -> 0x0014 }
        r0.<init>();	 Catch:{ JSONException -> 0x0014 }
        r1 = "null";	 Catch:{ JSONException -> 0x0014 }
        r0.setType(r1);	 Catch:{ JSONException -> 0x0014 }
        r1 = "actionid";	 Catch:{ JSONException -> 0x0014 }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x0014 }
        r0.setActionId(r3);	 Catch:{ JSONException -> 0x0014 }
        return r0;
    L_0x0014:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.f.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String f = com.igexin.push.core.a.f.a().f(pushTaskBean.getTaskId(), pushTaskBean.getMessageId());
        StringBuilder stringBuilder = new StringBuilder("EndAction execute, remove pushMessage from pushMessageMap, key = ");
        stringBuilder.append(f);
        a.b(stringBuilder.toString());
        try {
            g.ai.remove(f);
        } catch (Exception e) {
            stringBuilder = new StringBuilder("EndAction|");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
        }
        return true;
    }
}
