package com.airbnb.lottie.model;

import android.support.annotation.ColorInt;

/* compiled from: DocumentData */
public final class d {
    public String a;
    public String b;
    public int c;
    int d;
    public int e;
    double f;
    @ColorInt
    public int g;
    @ColorInt
    public int h;
    public int i;
    public boolean j;

    public d(String str, String str2, int i, int i2, int i3, double d, @ColorInt int i4, @ColorInt int i5, int i6, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = d;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = z;
    }

    public final int hashCode() {
        int hashCode = (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        return (31 * ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))))) + this.g;
    }
}
