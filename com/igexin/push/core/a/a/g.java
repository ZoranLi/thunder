package com.igexin.push.core.a.a;

import com.igexin.push.core.a.f;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;

public class g implements a {
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
        r0 = new com.igexin.push.core.bean.h;	 Catch:{ JSONException -> 0x001d }
        r0.<init>();	 Catch:{ JSONException -> 0x001d }
        r1 = "goto";	 Catch:{ JSONException -> 0x001d }
        r0.setType(r1);	 Catch:{ JSONException -> 0x001d }
        r1 = "actionid";	 Catch:{ JSONException -> 0x001d }
        r1 = r3.getString(r1);	 Catch:{ JSONException -> 0x001d }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x001d }
        r1 = "do";	 Catch:{ JSONException -> 0x001d }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x001d }
        r0.setDoActionId(r3);	 Catch:{ JSONException -> 0x001d }
        return r0;
    L_0x001d:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.g.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || baseAction.getDoActionId() == null || baseAction.getDoActionId().equals(""))) {
            f.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
