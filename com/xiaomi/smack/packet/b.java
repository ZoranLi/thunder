package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class b extends d {
    private a c = a.a;
    private final Map<String, String> d = new HashMap();

    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");
        private String f;

        private a(String str) {
            this.f = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            str = str.toLowerCase();
            return a.toString().equals(str) ? a : b.toString().equals(str) ? b : d.toString().equals(str) ? d : c.toString().equals(str) ? c : e.toString().equals(str) ? e : null;
        }

        public String toString() {
            return this.f;
        }
    }

    public b(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.c = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public a a() {
        return this.c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.c = a.a;
        } else {
            this.c = aVar;
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.d.putAll(map);
    }

    public Bundle b() {
        Bundle b = super.b();
        if (this.c != null) {
            b.putString("ext_iq_type", this.c.toString());
        }
        return b;
    }

    public String c() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<iq ");
        if (k() != null) {
            StringBuilder stringBuilder2 = new StringBuilder("id=\"");
            stringBuilder2.append(k());
            stringBuilder2.append("\" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (m() != null) {
            stringBuilder.append("to=\"");
            stringBuilder.append(d.a(m()));
            stringBuilder.append("\" ");
        }
        if (n() != null) {
            stringBuilder.append("from=\"");
            stringBuilder.append(d.a(n()));
            stringBuilder.append("\" ");
        }
        if (l() != null) {
            stringBuilder.append("chid=\"");
            stringBuilder.append(d.a(l()));
            stringBuilder.append("\" ");
        }
        for (Entry entry : this.d.entrySet()) {
            stringBuilder.append(d.a((String) entry.getKey()));
            stringBuilder.append("=\"");
            stringBuilder.append(d.a((String) entry.getValue()));
            stringBuilder.append("\" ");
        }
        if (this.c == null) {
            str = "type=\"get\">";
        } else {
            stringBuilder.append("type=\"");
            stringBuilder.append(a());
            str = "\">";
        }
        stringBuilder.append(str);
        str = d();
        if (str != null) {
            stringBuilder.append(str);
        }
        stringBuilder.append(s());
        h p = p();
        if (p != null) {
            stringBuilder.append(p.b());
        }
        stringBuilder.append("</iq>");
        return stringBuilder.toString();
    }

    public String d() {
        return null;
    }
}
