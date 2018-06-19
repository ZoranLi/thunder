package com.xunlei.downloadprovider.web.website.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.bf;

/* compiled from: CollectSuccessDialog */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        a.b(this.a);
        bf.a(this.a.f, "sure", this.a.g);
    }
}
