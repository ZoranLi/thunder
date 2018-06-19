package com.xunlei.downloadprovider.search.ui.a;

import android.content.Context;
import android.database.DataSetObserver;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseCustomAdapter */
public abstract class a<T> extends com.xunlei.downloadprovider.c.a.a.a {
    private List<T> a = new ArrayList();
    protected Context d;

    public long getItemId(int i) {
        return (long) i;
    }

    public a(Context context) {
        this.d = context;
    }

    public final void a(List<T> list) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        if (!d.a(this.a)) {
            this.a.clear();
        }
        if (!d.a(list)) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return d.a(this.a) ? 0 : this.a.size();
    }

    public T getItem(int i) {
        return this.a.get(i);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            super.unregisterDataSetObserver(dataSetObserver);
        } catch (DataSetObserver dataSetObserver2) {
            dataSetObserver2.printStackTrace();
        }
    }
}
