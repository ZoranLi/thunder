package com.alibaba.mtl.log;

import java.util.Map;

/* compiled from: UTMCVariables */
public final class c {
    public static final c a = new c();
    private boolean b = false;
    private boolean c = false;
    private String d = null;
    private Map<String, String> e = null;
    private boolean f = false;
    private boolean g = false;
    private String h = null;
    private String i = null;
    private String j = null;
    private boolean k = false;

    public static c a() {
        return a;
    }

    public final synchronized void a(String str) {
        this.h = str;
    }

    public final synchronized void b() {
        this.g = true;
    }

    public final synchronized boolean c() {
        return this.g;
    }

    public final synchronized void a(Map<String, String> map) {
        this.e = map;
    }

    public final synchronized Map<String, String> d() {
        return this.e;
    }
}
