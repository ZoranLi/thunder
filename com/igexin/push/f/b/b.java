package com.igexin.push.f.b;

import com.igexin.push.core.a.f;
import com.igexin.push.core.bean.PushTaskBean;

public class b extends h {
    private PushTaskBean a;
    private String b;

    public b(PushTaskBean pushTaskBean, String str, long j) {
        super(j);
        this.o = false;
        this.a = pushTaskBean;
        this.b = str;
    }

    protected void a() {
        f.a().c(this.a, this.b);
    }

    public int b() {
        return 0;
    }

    public void c() {
        super.c();
    }
}
