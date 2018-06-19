package com.android.volley.toolbox;

import com.android.volley.g;
import java.io.InputStream;
import java.util.List;

/* compiled from: HttpResponse */
public final class l {
    final int a;
    final List<g> b;
    final int c;
    final InputStream d;

    public l(int i, List<g> list) {
        this(i, list, -1, null);
    }

    public l(int i, List<g> list, int i2, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }
}
