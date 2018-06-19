package com.igexin.push.core.a.a;

import com.igexin.push.core.a.f;
import com.igexin.push.core.b;
import com.igexin.push.core.b.g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;

public class d implements a {
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
        r0 = "do";	 Catch:{ JSONException -> 0x0031 }
        r0 = r3.has(r0);	 Catch:{ JSONException -> 0x0031 }
        if (r0 == 0) goto L_0x0031;	 Catch:{ JSONException -> 0x0031 }
    L_0x0008:
        r0 = "actionid";	 Catch:{ JSONException -> 0x0031 }
        r0 = r3.has(r0);	 Catch:{ JSONException -> 0x0031 }
        if (r0 == 0) goto L_0x0031;	 Catch:{ JSONException -> 0x0031 }
    L_0x0010:
        r0 = new com.igexin.push.core.bean.BaseAction;	 Catch:{ JSONException -> 0x0031 }
        r0.<init>();	 Catch:{ JSONException -> 0x0031 }
        r1 = "type";	 Catch:{ JSONException -> 0x0031 }
        r1 = r3.getString(r1);	 Catch:{ JSONException -> 0x0031 }
        r0.setType(r1);	 Catch:{ JSONException -> 0x0031 }
        r1 = "actionid";	 Catch:{ JSONException -> 0x0031 }
        r1 = r3.getString(r1);	 Catch:{ JSONException -> 0x0031 }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x0031 }
        r1 = "do";	 Catch:{ JSONException -> 0x0031 }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x0031 }
        r0.setDoActionId(r3);	 Catch:{ JSONException -> 0x0031 }
        return r0;
    L_0x0031:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.d.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        g.a().a(false);
        if (!baseAction.getDoActionId().equals("")) {
            f.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
