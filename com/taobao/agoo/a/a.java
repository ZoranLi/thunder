package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.client.b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    private ConcurrentMap<String, Integer> a = new ConcurrentHashMap();
    private String b;
    private long c;
    private Context d;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.d = context.getApplicationContext();
    }

    public void a(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null || num.intValue() != 2) {
            this.a.put(str, Integer.valueOf(2));
            b.a(this.d, "AGOO_BIND", this.c, this.a);
        }
    }

    public boolean b(String str) {
        if (this.a.isEmpty()) {
            b();
        }
        Integer num = (Integer) this.a.get(str);
        StringBuilder stringBuilder = new StringBuilder("isAgooRegistered begin..appStatus=");
        stringBuilder.append(num);
        stringBuilder.append(",mAgooBindStatus=");
        stringBuilder.append(this.a);
        ALog.i("AgooBindCache", stringBuilder.toString(), new Object[0]);
        if (UtilityImpl.utdidChanged(Config.PREFERENCES, this.d) || num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        }
    }

    public void a() {
        this.b = null;
    }

    public boolean d(String str) {
        return (this.b == null || this.b.equals(str) == null) ? null : true;
    }

    private void b() {
        try {
            Object string = this.d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.i("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.c = jSONArray.getLong(0);
            int i = 1;
            if (System.currentTimeMillis() < this.c + 86400000) {
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.a.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                    i++;
                }
                StringBuilder stringBuilder = new StringBuilder("restoreAgooClients mAgooBindStatus restore = ");
                stringBuilder.append(this.a);
                ALog.i("AgooBindCache", stringBuilder.toString(), new Object[0]);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(this.c));
            this.c = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
