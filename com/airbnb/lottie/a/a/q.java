package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.k;
import java.util.List;

/* compiled from: ShapeContent */
public final class q implements l, a {
    private final Path a = new Path();
    private final String b;
    private final j c;
    private final com.airbnb.lottie.a.b.a<?, Path> d;
    private boolean e;
    @Nullable
    private s f;

    public q(j jVar, com.airbnb.lottie.model.layer.a aVar, k kVar) {
        this.b = kVar.a;
        this.c = jVar;
        this.d = kVar.b.a();
        aVar.a(this.d);
        this.d.a((a) this);
    }

    public final void a(List<b> list, List<b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            b bVar = (b) list.get(list2);
            if (bVar instanceof s) {
                s sVar = (s) bVar;
                if (sVar.a == Type.Simultaneously) {
                    this.f = sVar;
                    this.f.a(this);
                }
            }
        }
    }

    public final Path e() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        this.a.set((Path) this.d.a());
        this.a.setFillType(FillType.EVEN_ODD);
        g.a(this.a, this.f);
        this.e = true;
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a() {
        this.e = false;
        this.c.invalidateSelf();
    }
}
