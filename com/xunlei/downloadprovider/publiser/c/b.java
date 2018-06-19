package com.xunlei.downloadprovider.publiser.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: RadLivingInfoViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a.b("living", o.a(this.a.e.a().getKind()), "publish");
        a.b(this.a);
    }
}
