package com.alibaba.mtl.log.f;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

/* compiled from: BaseRequestAuth */
public final class a implements b {
    private String a = null;
    private String b = null;

    public final String a() {
        return this.a;
    }

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a(String str) {
        if (this.a != null) {
            if (this.b != null) {
                if (str == null) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.b);
                return j.a(j.c(stringBuilder.toString().getBytes()));
            }
        }
        i.a("BaseRequestAuth", "There is no appkey,please check it!");
        return null;
    }
}
