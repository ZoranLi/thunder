package me.iwf.photopicker.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.b.a;
import me.iwf.photopicker.b.b;

/* compiled from: SelectableAdapter */
public abstract class h<VH extends ViewHolder> extends Adapter<VH> {
    private static final String a = "h";
    protected List<b> f = new ArrayList();
    protected List<String> g = new ArrayList();
    public int h = 0;

    public final void b(a aVar) {
        if (this.g.contains(aVar.a)) {
            this.g.remove(aVar.a);
        } else {
            this.g.add(aVar.a);
        }
    }

    public final int c() {
        return this.g.size();
    }

    public final List<a> d() {
        return ((b) this.f.get(this.h)).e;
    }

    public final List<String> e() {
        List<String> arrayList = new ArrayList(d().size());
        for (a aVar : d()) {
            arrayList.add(aVar.a);
        }
        return arrayList;
    }

    public final List<String> f() {
        return this.g;
    }

    public final boolean a(a aVar) {
        return this.g.contains(aVar.a);
    }
}
