package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.content.SharedPreferences.Editor;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.i;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a {
    private void b(b bVar, String str) {
        m mVar = new m();
        String string = FeedbackAPI.mContext.getSharedPreferences("ywPrefsTools", 0).getString("getHistoryStatus", "0");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mVar.a("data", jSONObject);
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    private void c(b bVar, String str) {
        try {
            int intValue = ((Integer) new JSONObject(str).getJSONObject("data").get("status")).intValue();
            Editor edit = FeedbackAPI.mContext.getSharedPreferences("ywPrefsTools", 0).edit();
            edit.putString("getHistoryStatus", String.valueOf(intValue));
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d(b bVar, String str) {
        m mVar = new m();
        mVar.a("code", "0");
        try {
            mVar.a("data", new JSONObject((String) FeedbackAPI.mFeedbackCustomInfoMap.get("conf")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            new StringBuilder("ui conf:").append((String) FeedbackAPI.mFeedbackCustomInfoMap.get("conf"));
            if (bVar != null) {
                bVar.a(mVar);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public synchronized void a(b bVar, String str) {
        m mVar = new m();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openIMId", FeedbackAPI.mFeedbackCustomInfoMap.get("openIMId"));
            jSONObject.put("credential", FeedbackAPI.mFeedbackCustomInfoMap.get("credential"));
            jSONObject.put("appkey", FeedbackAPI.mFeedbackCustomInfoMap.get("appkey"));
            jSONObject.put("deviceId", FeedbackAPI.mFeedbackCustomInfoMap.get("deviceId"));
            for (Entry entry : i.a(this.a).entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (FeedbackAPI.mExtInfo != null) {
                try {
                    jSONObject.put("feedback_message_attri", FeedbackAPI.mExtInfo);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (FeedbackAPI.mExtInfo != null) {
                jSONObject.put("extInfo", FeedbackAPI.mExtInfo);
            }
        } catch (JSONException e22) {
            e22.printStackTrace();
        }
        mVar.a("data", jSONObject);
        new StringBuilder("customInfoJsonObj:").append(jSONObject.toString());
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    public boolean a(String str, String str2, b bVar) {
        if ("customInfo".equals(str)) {
            a(bVar, str2);
            return true;
        } else if ("getConf".equals(str)) {
            d(bVar, str2);
            return true;
        } else if ("getPrevStatus".equals(str)) {
            b(bVar, str2);
            return true;
        } else if (!"setPrevStatus".equals(str)) {
            return false;
        } else {
            c(bVar, str2);
            return true;
        }
    }
}
