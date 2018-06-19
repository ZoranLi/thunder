package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.i;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    public synchronized void a(b bVar, String str) {
        m mVar = new m();
        Map a = i.a(this.a);
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : a.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (FeedbackAPI.mExtInfo != null) {
            try {
                jSONObject.put("feedback_message_attri", FeedbackAPI.mExtInfo.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        mVar.a("data", jSONObject);
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"getInfo".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
