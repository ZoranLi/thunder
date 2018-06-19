package com.huawei.hms.update.a.a;

import android.content.Context;

/* compiled from: UpdateInfo */
public class c {
    public int a = 0;
    public String b = "";
    public int c = 0;
    public String d = "";

    public c(int i, String str, int i2, String str2) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
    }

    public void a(Context context) {
        context = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0);
        this.a = context.getInt("mNewVersionCode", 0);
        this.b = context.getString("mUri", "");
        this.c = context.getInt("mSize", 0);
        this.d = context.getString("mHash", "");
    }

    public void b(Context context) {
        context = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0).edit();
        context.putInt("mNewVersionCode", this.a);
        context.putString("mUri", this.b);
        context.putInt("mSize", this.c);
        context.putString("mHash", this.d);
        context.commit();
    }

    public void c(Context context) {
        context = context.getSharedPreferences("com.huawei.hms.update.UPDATE_INFO", 0).edit();
        context.clear();
        context.commit();
    }

    public boolean a() {
        return this.a > 0 && this.c > 0 && this.b != null && !this.b.isEmpty();
    }
}
