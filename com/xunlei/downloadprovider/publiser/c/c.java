package com.xunlei.downloadprovider.publiser.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: RadLivingInfoViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a.b("living_back", o.a(this.a.e.a().getKind()), "publish");
        com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRecord(this.a.d, String.valueOf(this.a.a), this.a.b, this.a.c);
    }
}
