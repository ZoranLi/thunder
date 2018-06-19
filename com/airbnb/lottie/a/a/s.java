package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent */
public final class s implements b, a {
    final Type a;
    public final com.airbnb.lottie.a.b.a<?, Float> b;
    public final com.airbnb.lottie.a.b.a<?, Float> c;
    public final com.airbnb.lottie.a.b.a<?, Float> d;
    private String e;
    private final List<a> f = new ArrayList();

    public final void a(List<b> list, List<b> list2) {
    }

    public s(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.e = shapeTrimPath.a;
        this.a = shapeTrimPath.b;
        this.b = shapeTrimPath.c.a();
        this.c = shapeTrimPath.d.a();
        this.d = shapeTrimPath.e.a();
        aVar.a(this.b);
        aVar.a(this.c);
        aVar.a(this.d);
        this.b.a((a) this);
        this.c.a((a) this);
        this.d.a((a) this);
    }

    public final void a() {
        for (int i = 0; i < this.f.size(); i++) {
            ((a) this.f.get(i)).a();
        }
    }

    public final String b() {
        return this.e;
    }

    final void a(a aVar) {
        this.f.add(aVar);
    }
}
