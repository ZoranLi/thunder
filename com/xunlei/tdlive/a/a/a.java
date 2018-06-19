package com.xunlei.tdlive.a.a;

import android.support.v7.widget.RecyclerView.Adapter;
import com.xunlei.tdlive.modal.JsonWrapper;
import java.util.HashSet;

/* compiled from: BaseRecycleAdapter */
public abstract class a<H extends f> extends Adapter<H> {
    protected c a;
    protected d b;
    private JsonWrapper c;
    private boolean d = false;
    private HashSet<Integer> e = new HashSet();

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean a() {
        if (this.d) {
            return false;
        }
        this.d = true;
        return true;
    }

    public void b() {
        this.d = false;
    }

    public void a(c cVar) {
        this.a = cVar;
    }

    public void a(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null && jsonWrapper.isArray()) {
            this.c = jsonWrapper;
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.c != null ? this.c.getLength() : 0;
    }

    public JsonWrapper a(int i) {
        if (this.c == null || !this.c.isArray() || i >= this.c.getLength()) {
            return 0;
        }
        JsonWrapper object = this.c.getObject(i);
        return object == null ? this.c.getArray(i) : object;
    }
}
