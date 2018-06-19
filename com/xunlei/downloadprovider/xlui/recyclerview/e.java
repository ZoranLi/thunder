package com.xunlei.downloadprovider.xlui.recyclerview;

import android.content.Context;
import android.view.View;

/* compiled from: LoadingMoreFooterViewHolder */
final class e extends i {
    LoadingMoreFooterView a;

    /* compiled from: LoadingMoreFooterViewHolder */
    static class a extends a {
        int b;
        int c = 0;

        public final void a(int i) {
            this.b = i;
            if (i == 0) {
                this.c = 0;
            } else if (i != 2) {
                this.c = 0;
            } else {
                this.c = 0;
            }
        }
    }

    private e(View view) {
        super(view);
        this.a = (LoadingMoreFooterView) view;
    }

    static e a(Context context) {
        return new e(new LoadingMoreFooterView(context));
    }
}
