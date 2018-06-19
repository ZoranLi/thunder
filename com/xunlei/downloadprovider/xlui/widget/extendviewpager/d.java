package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.util.SparseArray;
import android.view.View;

/* compiled from: RecycleBin */
public final class d {
    View[] a = new View[0];
    int[] b = new int[0];
    SparseArray<View>[] c;
    int d;
    SparseArray<View> e;

    static View a(SparseArray<View> sparseArray, int i) {
        int size = sparseArray.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            View view = (View) sparseArray.get(keyAt);
            if (keyAt == i) {
                sparseArray.remove(keyAt);
                return view;
            }
        }
        size--;
        View view2 = (View) sparseArray.valueAt(size);
        sparseArray.remove(sparseArray.keyAt(size));
        return view2;
    }
}
