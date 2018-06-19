package com.xunlei.tdlive.a;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: JsonArrayAdapterBase */
public interface c<T> {

    /* compiled from: JsonArrayAdapterBase */
    public interface a {
        <T> void a(T t, boolean z, boolean z2);
    }

    void a(T t, boolean z, boolean z2);

    View getView(int i, View view, ViewGroup viewGroup);
}
