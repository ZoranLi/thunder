package com.alibaba.baichuan.android.trade.e.a;

import android.content.SharedPreferences;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.g.a;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public final String a = c.class.getSimpleName();
    public SharedPreferences b = AlibcContext.a.getSharedPreferences("aliTradeConfigSP", 0);

    public final a a() {
        JSONException e;
        a aVar = null;
        String string = this.b.getString("aliTradeConfigSP", null);
        AlibcContext.b();
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            a aVar2 = new a();
            try {
                aVar2.a(jSONObject);
                return aVar2;
            } catch (JSONException e2) {
                e = e2;
                aVar = aVar2;
                new StringBuilder("拼接json出错").append(e.getMessage());
                a.b();
                return aVar;
            }
        } catch (JSONException e3) {
            e = e3;
            new StringBuilder("拼接json出错").append(e.getMessage());
            a.b();
            return aVar;
        }
    }
}
