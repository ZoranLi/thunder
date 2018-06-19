package com.alibaba.baichuan.android.trade.e;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.f.a;
import com.alibaba.baichuan.android.trade.utils.http.HttpHelper;
import com.alibaba.baichuan.android.trade.utils.http.HttpHelper.HttpHelpterException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        String str = null;
        try {
            Object obj;
            if (!a.a().equals(this.a.a)) {
                this.a.a = a.a();
            }
            new StringBuilder("开始从网络拉取config数据,url为：").append(this.a.a);
            AlibcContext.b();
            JSONObject jSONObject = new JSONObject(HttpHelper.a(this.a.a));
            new StringBuilder("网络拉取的config数据为").append(jSONObject.toString());
            AlibcContext.b();
            com.alibaba.baichuan.android.trade.e.a.a aVar = new com.alibaba.baichuan.android.trade.e.a.a();
            aVar.a(jSONObject);
            Object obj2 = null;
            if (aVar.a != null) {
                aVar.b = (Map) aVar.a.get("group0");
                if (aVar.b != null) {
                    aVar.a.remove("group0");
                }
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String a = c.a(aVar);
                if (!(aVar.b == null || aVar.a == null)) {
                    aVar.a.put("group0", aVar.b);
                }
                Map map = (Map) aVar.a.get("group0");
                if (map != null) {
                    String str2 = (String) map.get("sign");
                    if (str2 != null && str2.equals(a)) {
                        obj2 = 1;
                    }
                }
            }
            if (obj2 != null) {
                AlibcContext.b();
                e.a("Fetch_Config");
                this.a.c.a(aVar);
                return;
            }
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            e.a("Fetch_Config", "校验错误", null);
        } catch (HttpHelpterException e) {
            new StringBuilder("获取Http网络错误").append(e.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            if (e.statusCode != -999) {
                str = String.valueOf(e.statusCode);
            }
            e.a("Fetch_Config", "网络错误", str);
            e.getMessage();
        } catch (JSONException e2) {
            new StringBuilder("解析JSON出错").append(e2.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            e.a("Fetch_Config", "解析错误", null);
            e2.getMessage();
        }
    }
}
