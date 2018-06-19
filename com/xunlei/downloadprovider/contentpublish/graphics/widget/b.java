package com.xunlei.downloadprovider.contentpublish.graphics.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ImageGridView */
final class b implements OnClickListener {
    final /* synthetic */ PhotoView a;
    final /* synthetic */ int b;
    final /* synthetic */ ImageGridView c;

    b(ImageGridView imageGridView, PhotoView photoView, int i) {
        this.c = imageGridView;
        this.a = photoView;
        this.b = i;
    }

    public final void onClick(View view) {
        this.c.removeView(this.a);
        if (this.c.e != null) {
            this.c.e;
        }
    }
}
