package com.xunlei.downloadprovider.web.website.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.bf;

/* compiled from: CollectSuccessDialog */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        bf.a(this.a.f, "cancel", this.a.g);
    }
}
