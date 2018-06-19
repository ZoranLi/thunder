package com.igexin.push.core.bean;

import java.util.List;

public class c {
    private String a;
    private List<String> b;
    private int c;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<String> list) {
        this.b = list;
    }

    public List<String> b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void d() {
        this.c++;
    }

    public void e() {
        this.c--;
    }
}
