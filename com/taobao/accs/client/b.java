package com.taobao.accs.client;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    private Context a;
    private ConcurrentMap<String, Integer> b = new ConcurrentHashMap();
    private ConcurrentMap<String, Set<String>> c = new ConcurrentHashMap();
    private long d;
    private String e = "ClientManager_";
    private String f = "ACCS_BIND";

    public b(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append(str);
        this.e = stringBuilder.toString();
        this.a = context.getApplicationContext();
        context = new StringBuilder("ACCS_BIND");
        context.append(str);
        this.f = context.toString();
        a();
    }

    public void a(String str) {
        Integer num = (Integer) this.b.get(str);
        if (num == null || num.intValue() != 2) {
            this.b.put(str, Integer.valueOf(2));
            a(this.a, this.f, this.d, this.b);
        }
    }

    public void b(String str) {
        Integer num = (Integer) this.b.get(str);
        if (num == null || num.intValue() != 4) {
            this.b.put(str, Integer.valueOf(4));
            a(this.a, this.f, this.d, this.b);
        }
    }

    public boolean c(String str) {
        if (this.b.isEmpty()) {
            a();
        }
        Integer num = (Integer) this.b.get(str);
        String str2 = this.e;
        StringBuilder stringBuilder = new StringBuilder("isAppBinded begin..appStatus=");
        stringBuilder.append(num);
        stringBuilder.append(",mBindStatus=");
        stringBuilder.append(this.b);
        ALog.i(str2, stringBuilder.toString(), new Object[0]);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        Integer num = (Integer) this.b.get(str);
        return (num == null || num.intValue() != 4) ? null : true;
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    Set set = (Set) this.c.get(str);
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(str2);
                    this.c.put(str, set);
                }
            }
        } catch (String str3) {
            str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append(str3.toString());
            ALog.e(str2, stringBuilder.toString(), new Object[0]);
            str3.printStackTrace();
        }
    }

    public void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.c.remove(str);
            }
        } catch (String str2) {
            String str3 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append(str2.toString());
            ALog.e(str3, stringBuilder.toString(), new Object[0]);
            str2.printStackTrace();
        }
    }

    public boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Set set = (Set) this.c.get(str);
            if (!(set == null || set.contains(str2) == null)) {
                return true;
            }
            return false;
        } catch (String str3) {
            str2 = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append(str3.toString());
            ALog.e(str2, stringBuilder.toString(), new Object[0]);
            str3.printStackTrace();
        }
    }

    private void a() {
        try {
            Object string = this.a.getSharedPreferences(this.f, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.i(this.e, "restoreClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.d = jSONArray.getLong(0);
            int i = 1;
            if (System.currentTimeMillis() < this.d + 86400000) {
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.b.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                    i++;
                }
                String str = this.e;
                StringBuilder stringBuilder = new StringBuilder("restoreClients mBindStatus restore=");
                stringBuilder.append(this.b);
                ALog.i(str, stringBuilder.toString(), new Object[0]);
                return;
            }
            ALog.i(this.e, "restoreClients expired", "lastFlushTime", Long.valueOf(this.d));
            this.d = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, long j, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j <= 0 || j >= System.currentTimeMillis()) {
                jSONArray.put(((double) System.currentTimeMillis()) - (Math.random() * 8.64E7d));
            } else {
                jSONArray.put(j);
            }
            for (Object obj : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", obj);
                jSONObject.put("s", ((Integer) map.get(obj)).intValue());
                jSONArray.put(jSONObject);
            }
            context = context.getSharedPreferences(str, 0).edit();
            context.putString("bind_status", jSONArray.toString());
            context.apply();
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }
}
