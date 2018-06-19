package com.huawei.hms.update.a;

import android.content.Context;

/* compiled from: DownloadRecord */
class c {
    private String a;
    private int b;
    private String c;
    private int d;

    c() {
    }

    public void a(Context context) {
        context = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD", 0);
        this.a = context.getString("mUri", "");
        this.b = context.getInt("mSize", 0);
        this.c = context.getString("mHash", "");
        this.d = context.getInt("mReceived", 0);
    }

    public void a(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = null;
    }

    public void a(Context context, int i) {
        this.d = i;
        b(context);
    }

    private void b(Context context) {
        context = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD", 0).edit();
        context.putString("mUri", this.a);
        context.putInt("mSize", this.b);
        context.putString("mHash", this.c);
        context.putInt("mReceived", this.d);
        context.commit();
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public boolean b(String str, int i, String str2) {
        if (str != null) {
            if (str2 != null) {
                if (this.a != null) {
                    if (this.a.equals(str) != null) {
                        if (this.b == i && this.c != null) {
                            if (this.c.equals(str2) != null) {
                                if (this.d > this.b) {
                                    return false;
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
