package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JSONLexer */
public interface b {
    int a();

    long a(char c);

    Enum<?> a(Class<?> cls, h hVar, char c);

    Number a(boolean z);

    String a(h hVar);

    String a(h hVar, char c);

    void a(int i);

    boolean a(Feature feature);

    int b(char c);

    String b();

    String b(h hVar);

    String c(char c);

    void c();

    void close();

    void d();

    char e();

    char f();

    void g();

    void h();

    int i();

    Number j();

    BigDecimal k();

    String l();

    void m();

    int n();

    void o();

    void p();

    boolean q();

    int r();

    long s();

    boolean t();

    String u();

    byte[] v();

    float w();

    TimeZone x();

    Locale y();

    String z();
}
