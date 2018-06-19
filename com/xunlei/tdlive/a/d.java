package com.xunlei.tdlive.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.tdlive.a.c.a;
import com.xunlei.tdlive.modal.JsonWrapper;

/* compiled from: JsonArrayPageAdapter */
public abstract class d<T> extends PagerAdapter implements c<T> {
    protected a a;
    private boolean b = false;
    private JsonWrapper c;

    protected abstract void a(int i, View view);

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void a(T t) {
        a(t, true, false);
    }

    public boolean a() {
        if (this.b) {
            return false;
        }
        this.b = true;
        return true;
    }

    public void b() {
        this.b = false;
    }

    public void a(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null && jsonWrapper.isArray()) {
            this.c = jsonWrapper;
            notifyDataSetChanged();
        }
    }

    public JsonWrapper a(int i) {
        if (this.c == null || !this.c.isArray() || i >= this.c.getLength()) {
            return 0;
        }
        JsonWrapper object = this.c.getObject(i);
        return object == null ? this.c.getArray(i) : object;
    }

    public int getCount() {
        return this.c != null ? this.c.getLength() : 0;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        a(i, view);
        viewGroup.removeView(view);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        i = getView(i, null, viewGroup);
        if (i != 0) {
            viewGroup.addView(i, -1, -1);
        }
        return i;
    }
}
