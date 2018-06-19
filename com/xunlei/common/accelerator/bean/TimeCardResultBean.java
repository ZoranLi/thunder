package com.xunlei.common.accelerator.bean;

import android.text.TextUtils;
import com.xunlei.common.accelerator.js.KNJsInterfaceImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeCardResultBean extends BaseResultBean {
    public String expcardid = "";
    public int leftseconds;

    public static TimeCardResultBean parse(String str) {
        JSONException e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new TimeCardResultBean();
            try {
                str.expcardid = jSONObject.optString(KNJsInterfaceImpl.EXTRA_KEY_CARD);
                str.leftseconds = jSONObject.optInt("leftseconds");
                str.setSeq(jSONObject.optInt("sequence"));
                str.setError(jSONObject.optInt("errno"));
                str.setRichmessage(jSONObject.optString("richmessage"));
                str.setMessage(jSONObject.optString("message"));
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return str;
            }
        } catch (JSONException e3) {
            e = e3;
            str = null;
            e.printStackTrace();
            return str;
        }
        return str;
    }
}
