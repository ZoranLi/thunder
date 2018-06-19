package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smack.util.d;

public class c extends d {
    private String c = null;
    private String d = null;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i = false;
    private String j;
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private boolean o = false;

    public c(Bundle bundle) {
        super(bundle);
        this.c = bundle.getString("ext_msg_type");
        this.e = bundle.getString("ext_msg_lang");
        this.d = bundle.getString("ext_msg_thread");
        this.f = bundle.getString("ext_msg_sub");
        this.g = bundle.getString("ext_msg_body");
        this.h = bundle.getString("ext_body_encode");
        this.j = bundle.getString("ext_msg_appid");
        this.i = bundle.getBoolean("ext_msg_trans", false);
        this.o = bundle.getBoolean("ext_msg_encrypt", false);
        this.k = bundle.getString("ext_msg_seq");
        this.l = bundle.getString("ext_msg_mseq");
        this.m = bundle.getString("ext_msg_fseq");
        this.n = bundle.getString("ext_msg_status");
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public Bundle b() {
        Bundle b = super.b();
        if (!TextUtils.isEmpty(this.c)) {
            b.putString("ext_msg_type", this.c);
        }
        if (this.e != null) {
            b.putString("ext_msg_lang", this.e);
        }
        if (this.f != null) {
            b.putString("ext_msg_sub", this.f);
        }
        if (this.g != null) {
            b.putString("ext_msg_body", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            b.putString("ext_body_encode", this.h);
        }
        if (this.d != null) {
            b.putString("ext_msg_thread", this.d);
        }
        if (this.j != null) {
            b.putString("ext_msg_appid", this.j);
        }
        if (this.i) {
            b.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.k)) {
            b.putString("ext_msg_seq", this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
            b.putString("ext_msg_mseq", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            b.putString("ext_msg_fseq", this.m);
        }
        if (this.o) {
            b.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.n)) {
            b.putString("ext_msg_status", this.n);
        }
        return b;
    }

    public void b(String str) {
        this.k = str;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<message");
        if (t() != null) {
            stringBuilder.append(" xmlns=\"");
            stringBuilder.append(t());
            stringBuilder.append("\"");
        }
        if (this.e != null) {
            stringBuilder.append(" xml:lang=\"");
            stringBuilder.append(i());
            stringBuilder.append("\"");
        }
        if (k() != null) {
            stringBuilder.append(" id=\"");
            stringBuilder.append(k());
            stringBuilder.append("\"");
        }
        if (m() != null) {
            stringBuilder.append(" to=\"");
            stringBuilder.append(d.a(m()));
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            stringBuilder.append(" seq=\"");
            stringBuilder.append(e());
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            stringBuilder.append(" mseq=\"");
            stringBuilder.append(f());
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            stringBuilder.append(" fseq=\"");
            stringBuilder.append(g());
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(h())) {
            stringBuilder.append(" status=\"");
            stringBuilder.append(h());
            stringBuilder.append("\"");
        }
        if (n() != null) {
            stringBuilder.append(" from=\"");
            stringBuilder.append(d.a(n()));
            stringBuilder.append("\"");
        }
        if (l() != null) {
            stringBuilder.append(" chid=\"");
            stringBuilder.append(d.a(l()));
            stringBuilder.append("\"");
        }
        if (this.i) {
            stringBuilder.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.j)) {
            stringBuilder.append(" appid=\"");
            stringBuilder.append(d());
            stringBuilder.append("\"");
        }
        if (!TextUtils.isEmpty(this.c)) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(this.c);
            stringBuilder.append("\"");
        }
        if (this.o) {
            stringBuilder.append(" s=\"1\"");
        }
        stringBuilder.append(">");
        if (this.f != null) {
            stringBuilder.append("<subject>");
            stringBuilder.append(d.a(this.f));
            stringBuilder.append("</subject>");
        }
        if (this.g != null) {
            stringBuilder.append("<body");
            if (!TextUtils.isEmpty(this.h)) {
                stringBuilder.append(" encode=\"");
                stringBuilder.append(this.h);
                stringBuilder.append("\"");
            }
            stringBuilder.append(">");
            stringBuilder.append(d.a(this.g));
            stringBuilder.append("</body>");
        }
        if (this.d != null) {
            stringBuilder.append("<thread>");
            stringBuilder.append(this.d);
            stringBuilder.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.c)) {
            h p = p();
            if (p != null) {
                stringBuilder.append(p.b());
            }
        }
        stringBuilder.append(s());
        stringBuilder.append("</message>");
        return stringBuilder.toString();
    }

    public void c(String str) {
        this.l = str;
    }

    public String d() {
        return this.j;
    }

    public void d(String str) {
        this.m = str;
    }

    public String e() {
        return this.k;
    }

    public void e(String str) {
        this.n = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!super.equals(cVar)) {
            return false;
        }
        if (this.g != null) {
            if (!this.g.equals(cVar.g)) {
                return false;
            }
        } else if (cVar.g != null) {
            return false;
        }
        if (this.e != null) {
            if (!this.e.equals(cVar.e)) {
                return false;
            }
        } else if (cVar.e != null) {
            return false;
        }
        if (this.f != null) {
            if (!this.f.equals(cVar.f)) {
                return false;
            }
        } else if (cVar.f != null) {
            return false;
        }
        if (this.d != null) {
            if (!this.d.equals(cVar.d)) {
                return false;
            }
        } else if (cVar.d != null) {
            return false;
        }
        return this.c == cVar.c;
    }

    public String f() {
        return this.l;
    }

    public void f(String str) {
        this.c = str;
    }

    public String g() {
        return this.m;
    }

    public void g(String str) {
        this.f = str;
    }

    public String h() {
        return this.n;
    }

    public void h(String str) {
        this.g = str;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((this.c != null ? this.c.hashCode() : 0) * 31) + (this.g != null ? this.g.hashCode() : 0)) * 31) + (this.d != null ? this.d.hashCode() : 0)) * 31) + (this.e != null ? this.e.hashCode() : 0));
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }

    public String i() {
        return this.e;
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.e = str;
    }
}
