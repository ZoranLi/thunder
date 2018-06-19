package com.alibaba.baichuan.android.trade.e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.e.a.b;
import com.alibaba.baichuan.android.trade.e.a.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static String a = null;
    private static String f = "albbTradeConfig";
    private static volatile a j;
    public String b;
    public String c = "1.0.0";
    public long d = (System.currentTimeMillis() + 3600000);
    Runnable e = new b(this);
    private b g = new b();
    private c h;
    private Context i = AlibcContext.a;
    private c k = new c();
    private final long l = 21600000;
    private final long m = 3600000;
    private Handler n = new Handler();

    class a implements com.alibaba.baichuan.android.trade.e.c.a {
        final /* synthetic */ a a;

        a(a aVar) {
            this.a = aVar;
        }

        public final void a(com.alibaba.baichuan.android.trade.e.a.a aVar) {
            this.a.g.a(aVar);
            Editor edit = this.a.k.b.edit();
            JSONObject jSONObject = new JSONObject();
            for (String str : aVar.a.keySet()) {
                try {
                    jSONObject.put(str, new JSONObject((Map) aVar.a.get(str)));
                } catch (JSONException e) {
                    new StringBuilder("拼接json出错").append(e.getMessage());
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                }
            }
            edit.putString("aliTradeConfigSP", jSONObject.toString());
            edit.commit();
            if (com.alibaba.baichuan.android.trade.adapter.ut.a.a() != null) {
                com.alibaba.baichuan.android.trade.adapter.ut.a.b();
            }
            synchronized (a.class) {
                this.a.d = System.currentTimeMillis() + 21600000;
                new StringBuilder("当前的时间为过期时间戳为").append(this.a.d);
                AlibcContext.b();
            }
        }
    }

    private static boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z'))) {
                return false;
            }
        }
        return true;
    }

    public static a g() {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new a();
                }
            }
        }
        return j;
    }

    public final int a() {
        Object a = a("double11OpenType");
        if (a instanceof String) {
            try {
                return Integer.parseInt((String) a);
            } catch (NumberFormatException e) {
                e.toString();
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        return 0;
    }

    public final Object a(String str) {
        return str == null ? null : this.g.a(f, str, null);
    }

    public final Object a(String str, Object obj) {
        return this.g.a(f, str, obj);
    }

    public final int b() {
        Object a = a("sampling");
        if (a instanceof String) {
            try {
                return Integer.parseInt((String) a);
            } catch (NumberFormatException e) {
                e.toString();
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        return 10000;
    }

    public final boolean c() {
        return com.alibaba.baichuan.android.trade.utils.b.a(a("loginDegarade", Boolean.valueOf(false)));
    }

    public final String d() {
        String str = (String) a("channelName");
        if (str == null || str.length() <= 0) {
            if (!b(a)) {
                new StringBuilder("Channel chars must in [0-9][a-z][A-Z], now : ").append(a);
                com.alibaba.baichuan.android.trade.utils.g.a.b();
                a = "0";
            }
            return a;
        }
        String str2 = (String) a("channelType");
        if (str2 == null || str2.length() <= 0) {
            StringBuilder stringBuilder = new StringBuilder("0");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
    }

    public final String e() {
        return String.format("2014_%s_%s@baichuan_android_%s", new Object[]{d(), AlibcContext.c(), AlibcContext.d});
    }

    public final String f() {
        return AlibcContext.h != null ? AlibcContext.h : a("isvCode") != null ? (String) a("isvCode") : null;
    }

    a() {
        AlibcContext.b();
        if (this.k.a() != null) {
            AlibcContext.b();
            this.g.a(this.k.a());
        } else {
            AlibcContext.b();
            try {
                AlibcContext.b();
                JSONObject jSONObject = new JSONObject("{\n  \"group0\": {\n    \"dataId\": \"com.alibaba.baichuan.nbcp.meta.default\",\n    \"group\": \"1.0.0\",\n    \"lastUpdate\": \"Jun 14, 2016 2:12:22 PM\",\n    \"sign\": \"\"\n  },\n  \"albbTradeConfig\": {\n    \"isSyncForTaoke\": \"YES\",\n    \"isForceH5\": \"NO\",\n    \"isNeedAlipay\": \"YES\",\n    \"loginDegarade\": \"NO\"\n  },\n  \"group2\": {\n    \"abc1\": \"agc1\",\n    \"abc2\": \"agc2\",\n    \"abc3\": \"agc3\",\n    \"11111\":\"11111\"\n  }\n}");
                com.alibaba.baichuan.android.trade.e.a.a aVar = new com.alibaba.baichuan.android.trade.e.a.a();
                aVar.a(jSONObject);
                this.g.a(aVar);
                AlibcContext.b();
            } catch (JSONException e) {
                new StringBuilder("本地默认配置文件解析错误").append(e.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        this.h = new c(this.i, new a(this));
        this.e.run();
    }
}
