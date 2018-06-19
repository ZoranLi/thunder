package com.xunlei.downloadprovider.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseListAdapter */
public abstract class e<T extends c> extends com.xunlei.downloadprovider.c.a.a.a implements com.xunlei.downloadprovider.search.ui.a.h.a {
    protected LayoutInflater a;
    public List<T> b = new ArrayList();
    protected a c;

    /* compiled from: BaseListAdapter */
    public interface a {
        Context getContext();
    }

    public abstract View a(Context context);

    public abstract void a(View view, T t);

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public e(a aVar) {
        this.c = aVar;
        this.a = LayoutInflater.from(aVar.getContext());
    }

    public int getCount() {
        return this.b.size();
    }

    private T a(int i) {
        return (i < 0 || i >= this.b.size()) ? null : (c) this.b.get(i);
    }

    public int getItemViewType(int i) {
        return a(i).p;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        viewGroup = a(i);
        if (view == null) {
            view = a(this.c.getContext());
            hVar = new h(this, view, i);
        } else {
            hVar = (h) view.getTag();
        }
        a(view, viewGroup);
        return hVar.a;
    }

    public final void a() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
    }
}
