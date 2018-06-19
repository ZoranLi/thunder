package com.xunlei.downloadprovider.member.payment.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseAbsAdapter */
public abstract class a<T> extends BaseAdapter {
    protected List<T> a = new ArrayList();
    protected Context b;
    protected LayoutInflater c;

    public abstract void a(T t, h hVar);

    public long getItemId(int i) {
        return (long) i;
    }

    public a(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.a.size();
    }

    public T getItem(int i) {
        return this.a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = this.b;
        if (view == null) {
            view = new h(context, viewGroup);
        } else {
            view = (h) view.getTag();
        }
        a(getItem(i), view);
        return view.b;
    }

    public final void a(List<T> list) {
        if (list != null) {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }
}
