package com.xunlei.tdlive.a;

import android.widget.BaseAdapter;
import com.xunlei.tdlive.a.c.a;
import com.xunlei.tdlive.modal.JsonWrapper;
import java.util.HashSet;

/* compiled from: JsonArrayAdapter */
public abstract class b<T> extends BaseAdapter implements c<T> {
    protected a a;
    private JsonWrapper b;
    private Object c;
    private boolean d;
    private boolean e;
    private HashSet<Integer> f;

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public b() {
        this(null);
    }

    public b(a aVar) {
        this.d = false;
        this.e = false;
        this.f = new HashSet();
        this.a = aVar;
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

    public JsonWrapper c() {
        return this.b;
    }

    public void a(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null && jsonWrapper.isArray()) {
            this.b = jsonWrapper;
            notifyDataSetChanged();
        }
    }

    public void a(JsonWrapper jsonWrapper, int i, int i2) {
        if (jsonWrapper != null && jsonWrapper.isArray()) {
            if (this.b != null) {
                this.b.replace(jsonWrapper, i, i2);
            } else {
                this.b = jsonWrapper;
            }
            notifyDataSetChanged();
        }
    }

    public void a(T t) {
        a(t, true, false);
    }

    public void b(T t) {
        a(t, false, false);
    }

    public void c(T t) {
        a(t, false, true);
    }

    public int getCount() {
        if (this.b != null) {
            return this.c == null ? this.b.getLength() : this.b.getLength() + 1;
        } else {
            return 0;
        }
    }

    public JsonWrapper a(int i) {
        if (this.b == null || !this.b.isArray() || i >= this.b.getLength()) {
            return 0;
        }
        JsonWrapper object = this.b.getObject(i);
        return object == null ? this.b.getArray(i) : object;
    }
}
