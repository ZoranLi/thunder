package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import com.umeng.message.proguard.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class h {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<a> f = null;

    public static class a {
        public static final a a = new a("internal-server-error");
        public static final a b = new a("forbidden");
        public static final a c = new a("bad-request");
        public static final a d = new a("conflict");
        public static final a e = new a("feature-not-implemented");
        public static final a f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");
        private String y;

        public a(String str) {
            this.y = str;
        }

        public String toString() {
            return this.y;
        }
    }

    public h(int i, String str, String str2, String str3, String str4, List<a> list) {
        this.a = i;
        this.b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
        this.f = list;
    }

    public h(Bundle bundle) {
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.b = bundle.getString("ext_err_type");
        }
        this.c = bundle.getString("ext_err_cond");
        this.d = bundle.getString("ext_err_reason");
        this.e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                a a = a.a((Bundle) parcelable);
                if (a != null) {
                    this.f.add(a);
                }
            }
        }
    }

    public h(a aVar) {
        a(aVar);
        this.e = null;
    }

    private void a(a aVar) {
        this.c = aVar.y;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (this.b != null) {
            bundle.putString("ext_err_type", this.b);
        }
        bundle.putInt("ext_err_code", this.a);
        if (this.d != null) {
            bundle.putString("ext_err_reason", this.d);
        }
        if (this.c != null) {
            bundle.putString("ext_err_cond", this.c);
        }
        if (this.e != null) {
            bundle.putString("ext_err_msg", this.e);
        }
        if (this.f != null) {
            Parcelable[] parcelableArr = new Bundle[this.f.size()];
            int i = 0;
            for (a e : this.f) {
                Bundle e2 = e.e();
                if (e2 != null) {
                    int i2 = i + 1;
                    parcelableArr[i] = e2;
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", parcelableArr);
        }
        return bundle;
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<error code=\"");
        stringBuilder.append(this.a);
        stringBuilder.append("\"");
        if (this.b != null) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(this.b);
            stringBuilder.append("\"");
        }
        if (this.d != null) {
            stringBuilder.append(" reason=\"");
            stringBuilder.append(this.d);
            stringBuilder.append("\"");
        }
        stringBuilder.append(">");
        if (this.c != null) {
            stringBuilder.append("<");
            stringBuilder.append(this.c);
            stringBuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.e != null) {
            stringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            stringBuilder.append(this.e);
            stringBuilder.append("</text>");
        }
        for (e d : c()) {
            stringBuilder.append(d.d());
        }
        stringBuilder.append("</error>");
        return stringBuilder.toString();
    }

    public synchronized List<a> c() {
        if (this.f == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.c != null) {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(k.s);
        stringBuilder.append(this.a);
        stringBuilder.append(k.t);
        if (this.e != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.e);
        }
        return stringBuilder.toString();
    }
}
