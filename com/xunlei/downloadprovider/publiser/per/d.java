package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: DynamicCommentVideoViewHolder */
final class d implements OnLongClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.i == null) {
            return null;
        }
        this.a.i.a(3, this.a.h);
        return true;
    }
}
