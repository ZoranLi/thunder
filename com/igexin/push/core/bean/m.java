package com.igexin.push.core.bean;

import com.igexin.push.core.f;
import com.igexin.push.core.g;

public class m extends BaseAction {
    private String a;
    private boolean b;
    private boolean c;
    private String d;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public String c() {
        String str = this.a;
        if (this.b) {
            StringBuilder stringBuilder;
            if (str.indexOf("?") > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = "&cid=";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = "?cid=";
            }
            stringBuilder.append(str);
            stringBuilder.append(g.r);
            str = stringBuilder.toString();
        }
        if (this.c) {
            String m = f.a().m();
            if (m != null) {
                StringBuilder stringBuilder2;
                if (str.indexOf("?") > 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    str = "&nettype=";
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    str = "?nettype=";
                }
                stringBuilder2.append(str);
                stringBuilder2.append(m);
                return stringBuilder2.toString();
            }
        }
        return str;
    }
}
