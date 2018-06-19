package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.j;
import java.util.List;

/* compiled from: FontCharacter */
public final class g {
    public final List<j> a;
    public final double b;
    private final char c;
    private final int d;
    private final String e;
    private final String f;

    public static int a(char c, String str, String str2) {
        return ('\u001f' * (((0 + c) * 31) + str.hashCode())) + str2.hashCode();
    }

    public g(List<j> list, char c, int i, double d, String str, String str2) {
        this.a = list;
        this.c = c;
        this.d = i;
        this.b = d;
        this.e = str;
        this.f = str2;
    }

    public final int hashCode() {
        return a(this.c, this.f, this.e);
    }
}
