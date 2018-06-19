package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* compiled from: PolystarContent */
public final class m implements l, a {
    private final Path a = new Path();
    private final String b;
    private final j c;
    private final Type d;
    private final com.airbnb.lottie.a.b.a<?, Float> e;
    private final com.airbnb.lottie.a.b.a<?, PointF> f;
    private final com.airbnb.lottie.a.b.a<?, Float> g;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> h;
    private final com.airbnb.lottie.a.b.a<?, Float> i;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> j;
    private final com.airbnb.lottie.a.b.a<?, Float> k;
    @Nullable
    private s l;
    private boolean m;

    public m(j jVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.c = jVar;
        this.b = polystarShape.a;
        this.d = polystarShape.b;
        this.e = polystarShape.c.a();
        this.f = polystarShape.d.a();
        this.g = polystarShape.e.a();
        this.i = polystarShape.g.a();
        this.k = polystarShape.i.a();
        if (this.d == Type.Star) {
            this.h = polystarShape.f.a();
            this.j = polystarShape.h.a();
        } else {
            this.h = null;
            this.j = null;
        }
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.i);
        aVar.a(this.k);
        if (this.d == Type.Star) {
            aVar.a(this.h);
            aVar.a(this.j);
        }
        this.e.a((a) this);
        this.f.a((a) this);
        this.g.a((a) this);
        this.i.a((a) this);
        this.k.a((a) this);
        if (this.d == Type.Star) {
            this.i.a((a) this);
            this.k.a((a) this);
        }
    }

    public final void a(List<b> list, List<b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            b bVar = (b) list.get(list2);
            if (bVar instanceof s) {
                s sVar = (s) bVar;
                if (sVar.a == ShapeTrimPath.Type.Simultaneously) {
                    this.l = sVar;
                    this.l.a(this);
                }
            }
        }
    }

    public final Path e() {
        if (this.m) {
            return r0.a;
        }
        r0.a.reset();
        double d = 0.0d;
        float floatValue;
        double toRadians;
        float f;
        float f2;
        float floatValue2;
        float floatValue3;
        float f3;
        PointF pointF;
        double d2;
        float sin;
        switch (n.a[r0.d.ordinal()]) {
            case 1:
                double d3;
                float f4;
                float f5;
                float f6;
                floatValue = ((Float) r0.e.a()).floatValue();
                if (r0.g != null) {
                    d = (double) ((Float) r0.g.a()).floatValue();
                }
                toRadians = Math.toRadians(d - 90.0d);
                d = (double) floatValue;
                f = (float) (6.283185307179586d / d);
                f2 = f / 2.0f;
                floatValue -= (float) ((int) floatValue);
                if (floatValue != 0.0f) {
                    toRadians += (double) ((1.0f - floatValue) * f2);
                }
                float floatValue4 = ((Float) r0.i.a()).floatValue();
                float floatValue5 = ((Float) r0.h.a()).floatValue();
                floatValue2 = r0.j != null ? ((Float) r0.j.a()).floatValue() / 100.0f : 0.0f;
                floatValue3 = r0.k != null ? ((Float) r0.k.a()).floatValue() / 100.0f : 0.0f;
                if (floatValue != 0.0f) {
                    f3 = ((floatValue4 - floatValue5) * floatValue) + floatValue5;
                    d3 = (double) f3;
                    f4 = floatValue5;
                    f5 = floatValue2;
                    floatValue5 = (float) (d3 * Math.cos(toRadians));
                    floatValue2 = (float) (d3 * Math.sin(toRadians));
                    r0.a.moveTo(floatValue5, floatValue2);
                    d3 = toRadians + ((double) ((f * floatValue) / 2.0f));
                    f6 = f3;
                    f3 = floatValue5;
                } else {
                    f4 = floatValue5;
                    f5 = floatValue2;
                    double d4 = (double) floatValue4;
                    f3 = (float) (Math.cos(toRadians) * d4);
                    floatValue2 = (float) (d4 * Math.sin(toRadians));
                    r0.a.moveTo(f3, floatValue2);
                    d3 = toRadians + ((double) f2);
                    f6 = 0.0f;
                }
                double ceil = Math.ceil(d) * 2.0d;
                float f7 = f6;
                int i = 0;
                int i2 = 0;
                while (true) {
                    double d5 = (double) i;
                    if (d5 >= ceil) {
                        pointF = (PointF) r0.f.a();
                        r0.a.offset(pointF.x, pointF.y);
                        r0.a.close();
                        break;
                    }
                    float f8;
                    float f9;
                    float f10;
                    float f11;
                    double d6;
                    floatValue5 = i2 != 0 ? floatValue4 : f4;
                    if (f7 == 0.0f || d5 != ceil - 2.0d) {
                        f8 = f;
                        f = f2;
                    } else {
                        f8 = f;
                        f = (f * floatValue) / 2.0f;
                    }
                    if (f7 == 0.0f || d5 != ceil - 1.0d) {
                        f9 = floatValue4;
                    } else {
                        f9 = floatValue4;
                        floatValue5 = f7;
                    }
                    d2 = (double) floatValue5;
                    float f12 = f;
                    double d7 = d5;
                    f = (float) (d2 * Math.cos(d3));
                    sin = (float) (d2 * Math.sin(d3));
                    if (f5 == 0.0f && floatValue3 == 0.0f) {
                        r0.a.lineTo(f, sin);
                        f10 = f2;
                        f11 = floatValue3;
                        d6 = d3;
                        f6 = f12;
                    } else {
                        f10 = f2;
                        f11 = floatValue3;
                        double atan2 = (double) ((float) (Math.atan2((double) floatValue2, (double) f3) - 1.5707963267948966d));
                        f6 = (float) Math.cos(atan2);
                        f2 = (float) Math.sin(atan2);
                        d6 = d3;
                        double atan22 = (double) ((float) (Math.atan2((double) sin, (double) f) - 1.5707963267948966d));
                        floatValue5 = (float) Math.cos(atan22);
                        floatValue3 = (float) Math.sin(atan22);
                        floatValue4 = i2 != 0 ? f5 : f11;
                        float f13 = ((i2 != 0 ? f4 : f9) * floatValue4) * 0.47829f;
                        f6 *= f13;
                        f13 *= f2;
                        float f14 = ((i2 != 0 ? f9 : f4) * (i2 != 0 ? f11 : f5)) * 0.47829f;
                        floatValue5 *= f14;
                        f14 *= floatValue3;
                        if (floatValue != 0.0f) {
                            if (i == 0) {
                                f6 *= floatValue;
                                f13 *= floatValue;
                            } else if (d7 == ceil - 1.0d) {
                                floatValue5 *= floatValue;
                                f14 *= floatValue;
                            }
                        }
                        r0.a.cubicTo(f3 - f6, floatValue2 - f13, f + floatValue5, sin + f14, f, sin);
                        f6 = f12;
                    }
                    d3 = d6 + ((double) f6);
                    i2 ^= 1;
                    i++;
                    f3 = f;
                    floatValue2 = sin;
                    f = f8;
                    floatValue4 = f9;
                    f2 = f10;
                    floatValue3 = f11;
                }
                break;
            case 2:
                int floor = (int) Math.floor((double) ((Float) r0.e.a()).floatValue());
                if (r0.g != null) {
                    d = (double) ((Float) r0.g.a()).floatValue();
                }
                toRadians = Math.toRadians(d - 90.0d);
                d = (double) floor;
                floatValue = (float) (6.283185307179586d / d);
                f = ((Float) r0.k.a()).floatValue() / 100.0f;
                sin = ((Float) r0.i.a()).floatValue();
                double d8 = (double) sin;
                f2 = (float) (d8 * Math.cos(toRadians));
                floatValue3 = (float) (d8 * Math.sin(toRadians));
                r0.a.moveTo(f2, floatValue3);
                d2 = (double) floatValue;
                toRadians += d2;
                d = Math.ceil(d);
                double d9 = d8;
                floor = 0;
                while (((double) floor) < d) {
                    double d10;
                    double d11;
                    double d12;
                    floatValue2 = (float) (d9 * Math.cos(toRadians));
                    f3 = (float) (Math.sin(toRadians) * d9);
                    if (f != 0.0f) {
                        d10 = d;
                        d = (double) ((float) (Math.atan2((double) floatValue3, (double) f2) - 1.5707963267948966d));
                        d11 = toRadians;
                        d12 = d2;
                        toRadians = (double) ((float) (Math.atan2((double) f3, (double) floatValue2) - 1.5707963267948966d));
                        float f15 = (sin * f) * 0.25f;
                        r0.a.cubicTo(f2 - (((float) Math.cos(d)) * f15), floatValue3 - (((float) Math.sin(d)) * f15), floatValue2 + (((float) Math.cos(toRadians)) * f15), f3 + (f15 * ((float) Math.sin(toRadians))), floatValue2, f3);
                    } else {
                        d11 = toRadians;
                        d10 = d;
                        d12 = d2;
                        r0.a.lineTo(floatValue2, f3);
                    }
                    toRadians = d11 + d12;
                    floor++;
                    f2 = floatValue2;
                    floatValue3 = f3;
                    d = d10;
                    d2 = d12;
                }
                pointF = (PointF) r0.f.a();
                r0.a.offset(pointF.x, pointF.y);
                r0.a.close();
                break;
            default:
                break;
        }
        r0.a.close();
        g.a(r0.a, r0.l);
        r0.m = true;
        return r0.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a() {
        this.m = false;
        this.c.invalidateSelf();
    }
}
