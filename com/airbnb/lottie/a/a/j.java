package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* compiled from: MergePathsContent */
public final class j implements i, l {
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final String d;
    private final List<l> e = new ArrayList();
    private final MergePaths f;

    public j(MergePaths mergePaths) {
        if (VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d = mergePaths.a;
        this.f = mergePaths;
    }

    public final void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() == this) {
                break;
            }
        }
        while (listIterator.hasPrevious()) {
            b bVar = (b) listIterator.previous();
            if (bVar instanceof l) {
                this.e.add((l) bVar);
                listIterator.remove();
            }
        }
    }

    public final void a(List<b> list, List<b> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            ((l) this.e.get(i)).a(list, list2);
        }
    }

    public final Path e() {
        this.c.reset();
        switch (k.a[this.f.b.ordinal()]) {
            case 1:
                for (int i = 0; i < this.e.size(); i++) {
                    this.c.addPath(((l) this.e.get(i)).e());
                }
                break;
            case 2:
                a(Op.UNION);
                break;
            case 3:
                a(Op.REVERSE_DIFFERENCE);
                break;
            case 4:
                a(Op.INTERSECT);
                break;
            case 5:
                a(Op.XOR);
                break;
            default:
                break;
        }
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    @TargetApi(19)
    private void a(Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size > 0; size--) {
            List c;
            l lVar = (l) this.e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                c = cVar.c();
                for (int size2 = c.size() - 1; size2 >= 0; size2--) {
                    Path e = ((l) c.get(size2)).e();
                    e.transform(cVar.d());
                    this.b.addPath(e);
                }
            } else {
                this.b.addPath(lVar.e());
            }
        }
        int i = 0;
        l lVar2 = (l) this.e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            c = cVar2.c();
            while (i < c.size()) {
                Path e2 = ((l) c.get(i)).e();
                e2.transform(cVar2.d());
                this.a.addPath(e2);
                i++;
            }
        } else {
            this.a.set(lVar2.e());
        }
        this.c.op(this.a, this.b, op);
    }
}
