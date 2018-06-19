package com.xunlei.common.accelerator.bean;

import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xunlei.common.accelerator.js.KNJsInterfaceImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AllExpCardsBean extends BaseResultBean {
    public List<CardInfo> cardList = new ArrayList();

    public static class CardInfo {
        public String expcardid;
        public int minutes;
        public int state;
        public String validate;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("id:");
            stringBuffer.append(this.expcardid);
            stringBuffer.append(";state:");
            stringBuffer.append(this.state);
            stringBuffer.append(";validate:");
            stringBuffer.append(this.validate);
            stringBuffer.append(";minutes:");
            stringBuffer.append(this.minutes);
            return stringBuffer.toString();
        }
    }

    public static AllExpCardsBean paraseJson(String str) {
        JSONException e;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            str = new AllExpCardsBean();
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("cardinfos");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            CardInfo cardInfo = new CardInfo();
                            cardInfo.expcardid = jSONObject2.optString(KNJsInterfaceImpl.EXTRA_KEY_CARD);
                            cardInfo.minutes = jSONObject2.optInt("time");
                            cardInfo.validate = jSONObject2.optString(c.j);
                            cardInfo.state = jSONObject2.optInt(XiaomiOAuthConstants.EXTRA_STATE_2);
                            str.cardList.add(cardInfo);
                        }
                    }
                }
                str.setSeq(jSONObject.optInt("sequence"));
                str.setError(jSONObject.optInt("errno"));
                str.setRichmessage(jSONObject.optString("richmessage"));
                str.setMessage(jSONObject.optString("message"));
                return str;
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return str;
            }
        } catch (String str2) {
            e = str2;
            str2 = null;
            e.printStackTrace();
            return str2;
        }
    }
}
