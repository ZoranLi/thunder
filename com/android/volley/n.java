package com.android.volley;

/* compiled from: Response */
public final class n<T> {
    public final T a;
    public final com.android.volley.a.a b;
    public final VolleyError c;
    public boolean d;

    /* compiled from: Response */
    public interface a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* compiled from: Response */
    public interface b<T> {
        void onResponse(T t);
    }

    public static <T> n<T> a(T t, com.android.volley.a.a aVar) {
        return new n(t, aVar);
    }

    public static <T> n<T> a(VolleyError volleyError) {
        return new n(volleyError);
    }

    private n(T t, com.android.volley.a.a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    private n(VolleyError volleyError) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = volleyError;
    }
}
