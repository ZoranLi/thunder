package com.alibaba.baichuan.android.trade.c.a.a.b;

import anet.channel.util.HttpConstant;
import com.alibaba.baichuan.android.trade.c.a.a.c;
import java.io.Serializable;
import java.util.regex.Pattern;

public class f implements Serializable {
    public static final String[] a = new String[]{HttpConstant.HTTP, "https"};
    public static final String[] b = new String[]{"tbopen"};
    public String c;
    public String d;
    public String[] e;
    public String[] f;
    private transient Pattern[] g;

    public boolean a(c cVar) {
        String str;
        if (this.e == null || this.e.length <= 0) {
            str = cVar.e;
        } else {
            str = cVar.b();
            String c = cVar.c();
            if (c == null) {
                return false;
            }
            boolean z;
            for (Object equals : this.e) {
                if (c.equals(equals)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        if ("all".equals(this.d)) {
            return true;
        }
        if (((this.f == null ? 1 : 0) | (this.f.length == 0 ? 1 : 0)) != 0) {
            return false;
        }
        int i;
        if ("pattern".equals(this.d)) {
            if (this.g == null) {
                this.g = new Pattern[this.f.length];
                int length = this.g.length;
                for (i = 0; i < length; i++) {
                    this.g[i] = Pattern.compile(this.f[i]);
                }
            }
            for (Pattern matcher : this.g) {
                if (matcher.matcher(cVar.e).matches()) {
                    return true;
                }
            }
        } else if ("start".equals(this.d) != null) {
            for (String startsWith : this.f) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }
}
