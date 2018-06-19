package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.d;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c {
    private static c a;
    private Context b;
    private a c;
    private Map<String, a> d;

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean h = true;
        public boolean i = false;
        public int j = 1;
        private Context k;

        public a(Context context) {
            this.k = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.h = jSONObject.getBoolean("valid");
                aVar.i = jSONObject.getBoolean("paused");
                aVar.j = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.h);
                jSONObject.put("paused", aVar.i);
                jSONObject.put("envType", aVar.j);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                b.a(th);
                return null;
            }
        }

        private String d() {
            return com.xiaomi.channel.commonutils.android.a.a(this.k, this.k.getPackageName());
        }

        public void a(int i) {
            this.j = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = d.i(this.k);
            this.e = d();
            this.h = true;
            Editor edit = c.b(this.k).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", d());
            edit.putBoolean("valid", true);
            edit.commit();
        }

        public void a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.g = str3;
            Editor edit = c.b(this.k).edit();
            edit.putString("appId", this.a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.i = z;
        }

        public boolean a() {
            return c(this.a, this.b);
        }

        public void b() {
            c.b(this.k).edit().clear().commit();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.h = false;
            this.i = false;
            this.j = 1;
        }

        public void b(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = d.i(this.k);
            this.e = d();
            this.h = true;
        }

        public void b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.g = str3;
        }

        public void c() {
            this.h = false;
            c.b(this.k).edit().putBoolean("valid", this.h).commit();
        }

        public boolean c(String str, String str2) {
            return TextUtils.equals(this.a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && TextUtils.equals(this.f, d.i(this.k));
        }
    }

    private c(Context context) {
        this.b = context;
        n();
    }

    public static c a(Context context) {
        if (a == null) {
            a = new c(context);
        }
        return a;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    private void n() {
        this.c = new a(this.b);
        this.d = new HashMap();
        SharedPreferences b = b(this.b);
        this.c.a = b.getString("appId", null);
        this.c.b = b.getString("appToken", null);
        this.c.c = b.getString("regId", null);
        this.c.d = b.getString("regSec", null);
        this.c.f = b.getString("devId", null);
        if (!TextUtils.isEmpty(this.c.f) && this.c.f.startsWith("a-")) {
            this.c.f = d.i(this.b);
            b.edit().putString("devId", this.c.f).commit();
        }
        this.c.e = b.getString("vName", null);
        this.c.h = b.getBoolean("valid", true);
        this.c.i = b.getBoolean("paused", false);
        this.c.j = b.getInt("envType", 1);
        this.c.g = b.getString("regResource", null);
    }

    public void a(int i) {
        this.c.a(i);
        b(this.b).edit().putInt("envType", i).commit();
    }

    public void a(String str) {
        Editor edit = b(this.b).edit();
        edit.putString("vName", str);
        edit.commit();
        this.c.e = str;
    }

    public void a(String str, a aVar) {
        this.d.put(str, aVar);
        String a = a.a(aVar);
        StringBuilder stringBuilder = new StringBuilder("hybrid_app_info_");
        stringBuilder.append(str);
        b(this.b).edit().putString(stringBuilder.toString(), a).commit();
    }

    public void a(String str, String str2, String str3) {
        this.c.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.c.a(z);
        b(this.b).edit().putBoolean("paused", z).commit();
    }

    public boolean a() {
        return !TextUtils.equals(com.xiaomi.channel.commonutils.android.a.a(this.b, this.b.getPackageName()), this.c.e);
    }

    public boolean a(String str, String str2) {
        return this.c.c(str, str2);
    }

    public a b(String str) {
        if (this.d.containsKey(str)) {
            return (a) this.d.get(str);
        }
        StringBuilder stringBuilder = new StringBuilder("hybrid_app_info_");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        SharedPreferences b = b(this.b);
        if (!b.contains(str)) {
            return null;
        }
        a a = a.a(this.b, b.getString(str, ""));
        this.d.put(str, a);
        return a;
    }

    public void b(String str, String str2) {
        this.c.a(str, str2);
    }

    public boolean b() {
        if (this.c.a()) {
            return true;
        }
        b.a("Don't send message before initialization succeeded!");
        return false;
    }

    public boolean b(String str, String str2, String str3) {
        a b = b(str3);
        return b != null && TextUtils.equals(str, b.a) && TextUtils.equals(str2, b.b);
    }

    public String c() {
        return this.c.a;
    }

    public void c(String str) {
        this.d.remove(str);
        StringBuilder stringBuilder = new StringBuilder("hybrid_app_info_");
        stringBuilder.append(str);
        b(this.b).edit().remove(stringBuilder.toString()).commit();
    }

    public String d() {
        return this.c.b;
    }

    public String e() {
        return this.c.c;
    }

    public String f() {
        return this.c.d;
    }

    public String g() {
        return this.c.g;
    }

    public void h() {
        this.c.b();
    }

    public boolean i() {
        return this.c.a();
    }

    public void j() {
        this.c.c();
    }

    public boolean k() {
        return this.c.i;
    }

    public int l() {
        return this.c.j;
    }

    public boolean m() {
        return !this.c.h;
    }
}
