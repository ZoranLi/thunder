package com.alibaba.fastjson.b;

/* compiled from: Item */
final class d {
    int a;
    int b;
    int c;
    long d;
    String e;
    String f;
    String g;
    int h;
    d i;

    d() {
    }

    d(int i, d dVar) {
        this.a = i;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
        this.h = dVar.h;
    }

    final void a(int i, String str, String str2, String str3) {
        this.b = i;
        this.e = str;
        this.f = str2;
        this.g = str3;
        switch (i) {
            case 1:
            case 7:
            case 8:
            case 13:
                this.h = (i + str.hashCode()) & Integer.MAX_VALUE;
                return;
            case 12:
                this.h = (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            default:
                this.h = (i + ((str.hashCode() * str2.hashCode()) * str3.hashCode())) & Integer.MAX_VALUE;
                return;
        }
    }
}
