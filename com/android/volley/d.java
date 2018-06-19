package com.android.volley;

/* compiled from: DefaultRetryPolicy */
public final class d implements p {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public d() {
        this(2500, 1, 1.0f);
    }

    public d(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void a(VolleyError volleyError) throws VolleyError {
        int i = 1;
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if (this.b > this.c) {
            i = 0;
        }
        if (i == 0) {
            throw volleyError;
        }
    }
}
