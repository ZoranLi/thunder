package com.igexin.b.a.b;

public abstract class e extends com.igexin.b.a.d.e {
    public String a;
    public b b;
    public Object c;
    public d d;

    public e(int i, String str, b bVar) {
        super(i);
        if (str != null) {
            this.a = a(str);
        }
        this.b = bVar;
    }

    public e(String str, b bVar) {
        this(0, str, bVar);
    }

    private String a(String str) {
        return f.a(f.a(str));
    }

    public void f() {
        if (this.b != null) {
            this.b.a(false);
        }
        this.b = null;
        this.d = null;
        this.c = null;
        this.a = null;
        super.f();
    }
}
