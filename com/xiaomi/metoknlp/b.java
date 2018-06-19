package com.xiaomi.metoknlp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static boolean a = true;
    private static int b = 1;
    private static b c;
    private Context d;
    private SharedPreferences e = this.d.getSharedPreferences("config", 0);
    private List f = new ArrayList();

    private b(Context context) {
        this.d = context;
    }

    public static b a() {
        return c;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (c == null) {
                c = new b(context);
            }
        }
    }

    public static boolean b() {
        return false;
    }

    public void a(g gVar) {
        if (gVar != null) {
            synchronized (this.f) {
                this.f.add(gVar);
            }
        }
    }

    public void a(String str) {
        Editor edit = this.e.edit();
        edit.putString("config_update_time", str);
        edit.commit();
    }

    public void c() {
        synchronized (this.f) {
            for (g a : this.f) {
                a.a();
            }
        }
    }

    public void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.k();
        r1 = com.xiaomi.metoknlp.a.e.h();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = com.xiaomi.metoknlp.a.e.d();
        r2 = "collect";
        r3 = new java.lang.StringBuilder;
        r4 = "t_";
        r3.<init>(r4);
        r3.append(r0);
        r3 = r3.toString();
        r2 = com.xiaomi.metoknlp.c.a(r2, r3);
        r3 = 0;
        r4 = 5;
        if (r2 == 0) goto L_0x0031;
    L_0x002b:
        r5 = r2.isEmpty();
        if (r5 == 0) goto L_0x0056;
    L_0x0031:
        r2 = r3;
    L_0x0032:
        r5 = "collect";
        r6 = new java.lang.StringBuilder;
        r7 = "t_";
        r6.<init>(r7);
        r6.append(r0);
        r6 = r6.toString();
        r5 = com.xiaomi.metoknlp.c.a(r5, r6);
        if (r5 == 0) goto L_0x004e;
    L_0x0048:
        r6 = r5.isEmpty();
        if (r6 == 0) goto L_0x0052;
    L_0x004e:
        r2 = r2 + 1;
        if (r2 != r4) goto L_0x0032;
    L_0x0052:
        if (r2 != r4) goto L_0x0055;
    L_0x0054:
        return;
    L_0x0055:
        r2 = r5;
    L_0x0056:
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0173 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x0173 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0173 }
        r6 = "data";	 Catch:{ Exception -> 0x0173 }
        r5 = r5.getString(r6);	 Catch:{ Exception -> 0x0173 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0173 }
        r5 = r11.e;	 Catch:{ Exception -> 0x0173 }
        r6 = "s_f";	 Catch:{ Exception -> 0x0173 }
        r7 = "";	 Catch:{ Exception -> 0x0173 }
        r5 = r5.getString(r6, r7);	 Catch:{ Exception -> 0x0173 }
        r6 = "s_f";	 Catch:{ Exception -> 0x0173 }
        r7 = "";	 Catch:{ Exception -> 0x0173 }
        r6 = r2.optString(r6, r7);	 Catch:{ Exception -> 0x0173 }
        r7 = "f_d_d";	 Catch:{ Exception -> 0x0173 }
        r7 = r2.optInt(r7, r3);	 Catch:{ Exception -> 0x0173 }
        r7 = com.xiaomi.metoknlp.a.e.a(r7);	 Catch:{ Exception -> 0x0173 }
        r8 = r11.e;	 Catch:{ Exception -> 0x0173 }
        r8 = r8.edit();	 Catch:{ Exception -> 0x0173 }
        r9 = "s_f";	 Catch:{ Exception -> 0x0173 }
        r8.putString(r9, r6);	 Catch:{ Exception -> 0x0173 }
        r9 = "f_d_d";	 Catch:{ Exception -> 0x0173 }
        r8.putBoolean(r9, r7);	 Catch:{ Exception -> 0x0173 }
        r7 = "m_s_u";	 Catch:{ Exception -> 0x0173 }
        r9 = "m_s_u";	 Catch:{ Exception -> 0x0173 }
        r10 = "https://metok.sys.miui.com";	 Catch:{ Exception -> 0x0173 }
        r2 = r2.optString(r9, r10);	 Catch:{ Exception -> 0x0173 }
        r8.putString(r7, r2);	 Catch:{ Exception -> 0x0173 }
        r8.commit();	 Catch:{ Exception -> 0x0173 }
        r2 = new java.util.Date;	 Catch:{ Exception -> 0x0173 }
        r2.<init>();	 Catch:{ Exception -> 0x0173 }
        r2 = new java.util.Date;	 Catch:{ Exception -> 0x0173 }
        r2.<init>();	 Catch:{ Exception -> 0x0173 }
        r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0173 }
        r7 = "yyyyMMddHHmm";	 Catch:{ Exception -> 0x0173 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x0173 }
        if (r5 == 0) goto L_0x00de;	 Catch:{ Exception -> 0x0173 }
    L_0x00b5:
        r7 = r5.isEmpty();	 Catch:{ Exception -> 0x0173 }
        if (r7 != 0) goto L_0x00de;	 Catch:{ Exception -> 0x0173 }
    L_0x00bb:
        if (r6 == 0) goto L_0x00de;	 Catch:{ Exception -> 0x0173 }
    L_0x00bd:
        r7 = r6.isEmpty();	 Catch:{ Exception -> 0x0173 }
        if (r7 != 0) goto L_0x00de;	 Catch:{ Exception -> 0x0173 }
    L_0x00c3:
        r5 = r2.parse(r5);	 Catch:{ Exception -> 0x0173 }
        r2 = r2.parse(r6);	 Catch:{ Exception -> 0x0173 }
        r6 = r2.before(r5);	 Catch:{ Exception -> 0x0173 }
        if (r6 != 0) goto L_0x00d7;	 Catch:{ Exception -> 0x0173 }
    L_0x00d1:
        r2 = r2.equals(r5);	 Catch:{ Exception -> 0x0173 }
        if (r2 == 0) goto L_0x00de;	 Catch:{ Exception -> 0x0173 }
    L_0x00d7:
        r11.a(r1);	 Catch:{ Exception -> 0x0173 }
        r11.c();	 Catch:{ Exception -> 0x0173 }
        return;
    L_0x00de:
        r2 = "collect";
        r5 = new java.lang.StringBuilder;
        r6 = "f_";
        r5.<init>(r6);
        r5.append(r0);
        r5 = r5.toString();
        r2 = com.xiaomi.metoknlp.c.a(r2, r5);
        if (r2 == 0) goto L_0x00fa;
    L_0x00f4:
        r5 = r2.isEmpty();
        if (r5 == 0) goto L_0x011d;
    L_0x00fa:
        r2 = "collect";
        r5 = new java.lang.StringBuilder;
        r6 = "f_";
        r5.<init>(r6);
        r5.append(r0);
        r5 = r5.toString();
        r2 = com.xiaomi.metoknlp.c.a(r2, r5);
        if (r2 == 0) goto L_0x0116;
    L_0x0110:
        r5 = r2.isEmpty();
        if (r5 == 0) goto L_0x011a;
    L_0x0116:
        r3 = r3 + 1;
        if (r3 != r4) goto L_0x00fa;
    L_0x011a:
        if (r3 != r4) goto L_0x011d;
    L_0x011c:
        return;
    L_0x011d:
        r0 = new org.json.JSONObject;	 Catch:{  }
        r0.<init>(r2);	 Catch:{  }
        r2 = new org.json.JSONObject;	 Catch:{  }
        r3 = "data";	 Catch:{  }
        r0 = r0.getString(r3);	 Catch:{  }
        r2.<init>(r0);	 Catch:{  }
        r0 = r11.e;	 Catch:{  }
        r0 = r0.edit();	 Catch:{  }
        r3 = "d_m_i";	 Catch:{  }
        r4 = "d_m_i";	 Catch:{  }
        r5 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;	 Catch:{  }
        r7 = r2.optLong(r4, r5);	 Catch:{  }
        r0.putLong(r3, r7);	 Catch:{  }
        r3 = "d_n_s";	 Catch:{  }
        r4 = "d_n_s";	 Catch:{  }
        r7 = b;	 Catch:{  }
        r4 = r2.optInt(r4, r7);	 Catch:{  }
        r4 = com.xiaomi.metoknlp.a.e.a(r4);	 Catch:{  }
        r0.putBoolean(r3, r4);	 Catch:{  }
        r3 = "d_s_t";	 Catch:{  }
        r4 = "d_s_t";	 Catch:{  }
        r7 = r2.optLong(r4, r5);	 Catch:{  }
        r0.putLong(r3, r7);	 Catch:{  }
        r3 = "d_s_c_t";	 Catch:{  }
        r4 = "d_s_c_t";	 Catch:{  }
        r4 = r2.optLong(r4, r5);	 Catch:{  }
        r0.putLong(r3, r4);	 Catch:{  }
        r0.commit();	 Catch:{  }
        r11.a(r1);
        r11.c();
    L_0x0173:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.b.d():void");
    }

    public String e() {
        return this.e.getString("m_s_u", "https://metok.sys.miui.com");
    }

    public boolean f() {
        return this.e.getBoolean("f_d_d", true);
    }

    public long g() {
        return this.e.getLong("d_m_i", Long.MAX_VALUE);
    }

    public boolean h() {
        return this.e.getBoolean("d_n_s", a);
    }

    public long i() {
        return this.e.getLong("d_s_t", Long.MAX_VALUE);
    }

    public long j() {
        return this.e.getLong("d_s_c_t", Long.MAX_VALUE);
    }

    public String k() {
        return this.e.getString("config_update_time", "0");
    }
}
