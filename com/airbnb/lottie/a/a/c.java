package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup */
public final class c implements d, l, a {
    private final Matrix a;
    private final Path b;
    private final RectF c;
    private final String d;
    private final List<b> e;
    private final j f;
    @Nullable
    private List<l> g;
    @Nullable
    private p h;

    private static List<b> a(j jVar, com.airbnb.lottie.model.layer.a aVar, List<b> list) {
        List<b> arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a = ((b) list.get(i)).a(jVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Nullable
    private static l a(List<b> list) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    c(j jVar, com.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable l lVar) {
        this.a = new Matrix();
        this.b = new Path();
        this.c = new RectF();
        this.d = str;
        this.f = jVar;
        this.e = list;
        if (lVar != null) {
            this.h = lVar.a();
            this.h.a(aVar);
            this.h.a((a) this);
        }
        jVar = new ArrayList();
        for (aVar = list.size() - 1; aVar >= null; aVar--) {
            b bVar = (b) list.get(aVar);
            if ((bVar instanceof i) != null) {
                jVar.add((i) bVar);
            }
        }
        for (aVar = jVar.size() - 1; aVar >= null; aVar--) {
            ((i) jVar.get(aVar)).a(list.listIterator(list.size()));
        }
    }

    public final void a() {
        this.f.invalidateSelf();
    }

    public final String b() {
        return this.d;
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        for (int i = 0; i < this.e.size(); i++) {
            b bVar = (b) this.e.get(i);
            if (bVar instanceof d) {
                d dVar = (d) bVar;
                if (str2 != null) {
                    if (!str2.equals(bVar.b())) {
                        dVar.a(str, str2, colorFilter);
                    }
                }
                dVar.a(str, null, colorFilter);
            }
        }
    }

    public final void a(List<b> list, List<b> list2) {
        list2 = new ArrayList(list.size() + this.e.size());
        list2.addAll(list);
        for (list = this.e.size() - 1; list >= null; list--) {
            b bVar = (b) this.e.get(list);
            bVar.a(list2, this.e.subList(0, list));
            list2.add(bVar);
        }
    }

    final List<l> c() {
        if (this.g == null) {
            this.g = new ArrayList();
            for (int i = 0; i < this.e.size(); i++) {
                b bVar = (b) this.e.get(i);
                if (bVar instanceof l) {
                    this.g.add((l) bVar);
                }
            }
        }
        return this.g;
    }

    final Matrix d() {
        if (this.h != null) {
            return this.h.a();
        }
        this.a.reset();
        return this.a;
    }

    public final Path e() {
        this.a.reset();
        if (this.h != null) {
            this.a.set(this.h.a());
        }
        this.b.reset();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            b bVar = (b) this.e.get(size);
            if (bVar instanceof l) {
                this.b.addPath(((l) bVar).e(), this.a);
            }
        }
        return this.b;
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.a.set(matrix);
        if (this.h != null) {
            this.a.preConcat(this.h.a());
            i = (int) ((((((float) ((Integer) this.h.a.a()).intValue()) / 100.0f) * ((float) i)) / 1132396544) * 1132396544);
        }
        for (matrix = this.e.size() - 1; matrix >= null; matrix--) {
            Object obj = this.e.get(matrix);
            if (obj instanceof d) {
                ((d) obj).a(canvas, this.a, i);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.a.set(matrix);
        if (this.h != null) {
            this.a.preConcat(this.h.a());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (matrix = this.e.size() - 1; matrix >= null; matrix--) {
            b bVar = (b) this.e.get(matrix);
            if (bVar instanceof d) {
                ((d) bVar).a(this.c, this.a);
                if (rectF.isEmpty()) {
                    rectF.set(this.c);
                } else {
                    rectF.set(Math.min(rectF.left, this.c.left), Math.min(rectF.top, this.c.top), Math.max(rectF.right, this.c.right), Math.max(rectF.bottom, this.c.bottom));
                }
            }
        }
    }

    public c(j jVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.j jVar2) {
        this(jVar, aVar, jVar2.a, a(jVar, aVar, jVar2.b), a(jVar2.b));
    }
}
