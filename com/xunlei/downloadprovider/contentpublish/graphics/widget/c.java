package com.xunlei.downloadprovider.contentpublish.graphics.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ImageGridView */
final class c implements OnClickListener {
    final /* synthetic */ ImageGridView a;

    c(ImageGridView imageGridView) {
        this.a = imageGridView;
    }

    public final void onClick(View view) {
        if (this.a.f != null) {
            this.a.f.onClick(this.a.g);
        }
    }
}
