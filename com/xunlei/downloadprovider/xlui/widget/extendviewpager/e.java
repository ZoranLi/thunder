package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: RecyclingPagerAdapter */
public abstract class e extends c {
    String b;
    private final d c;

    public int a() {
        return 1;
    }

    public int a(int i) {
        return 0;
    }

    public abstract View a(int i, View view);

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.b = e.class.getSimpleName();
        this.c = dVar;
        int a = a();
        if (a <= 0) {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        SparseArray[] sparseArrayArr = new SparseArray[a];
        for (int i = 0; i < a; i++) {
            sparseArrayArr[i] = new SparseArray();
        }
        dVar.d = a;
        dVar.e = sparseArrayArr[0];
        dVar.c = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        int length;
        d dVar = this.c;
        View[] viewArr = dVar.a;
        int[] iArr = dVar.b;
        int i = dVar.d > 1 ? 1 : 0;
        SparseArray sparseArray = dVar.e;
        for (length = viewArr.length - 1; length >= 0; length--) {
            int i2;
            View view = viewArr[length];
            if (view != null) {
                i2 = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if ((i2 >= 0 ? 1 : 0) != 0) {
                    if (i != 0) {
                        sparseArray = dVar.c[i2];
                    }
                    sparseArray.put(length, view);
                    view.setAccessibilityDelegate(null);
                }
            }
        }
        int length2 = dVar.a.length;
        int i3 = dVar.d;
        SparseArray[] sparseArrayArr = dVar.c;
        for (i = 0; i < i3; i++) {
            SparseArray sparseArray2 = sparseArrayArr[i];
            int size = sparseArray2.size();
            length = size - length2;
            int i4 = size - 1;
            size = 0;
            while (size < length) {
                i2 = i4 - 1;
                sparseArray2.remove(sparseArray2.keyAt(i4));
                size++;
                i4 = i2;
            }
        }
        super.notifyDataSetChanged();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        int a = a(i);
        View view = null;
        if (a != -1) {
            View a2;
            d dVar = this.c;
            if (dVar.d == 1) {
                a2 = d.a(dVar.e, i);
            } else if (a >= 0 && a < dVar.c.length) {
                a2 = d.a(dVar.c[a], i);
            }
            view = a2;
        }
        i = a(i, view);
        viewGroup.addView(i);
        new StringBuilder("instantiateItem view: ").append(i.hashCode());
        return i;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        new StringBuilder("destroyItem view: ").append(view.hashCode());
        viewGroup = a(i);
        if (viewGroup != -1) {
            d dVar = this.c;
            if (dVar.d == 1) {
                dVar.e.put(i, view);
            } else {
                dVar.c[viewGroup].put(i, view);
            }
            view.setAccessibilityDelegate(null);
        }
    }
}
