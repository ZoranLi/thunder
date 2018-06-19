package com.igexin.push.d;

import android.content.Context;
import com.igexin.b.a.b.a.a.k;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.e;
import com.igexin.push.core.g;

public class a implements com.igexin.b.a.d.a.a<String, Integer, b, e> {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    public e a(String str, Integer num, b bVar) {
        return (str.startsWith("socket") && g.h) ? new k(str, bVar) : null;
    }
}
