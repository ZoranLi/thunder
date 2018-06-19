package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: OpenPrivateSpaceTipDialog */
final class r implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ k b;

    r(k kVar, Context context) {
        this.b = kVar;
        this.a = context;
    }

    public final void onClick(View view) {
        an.b("open");
        this.b.dismiss();
        this.b.b.c(this.a.getString(R.string.open_private_space));
        this.b.b.b(this.a.getString(R.string.tips_private_space_can_do));
        this.b.b.a(true);
        this.b.b.a(this.a.getString(R.string.private_space_open));
        this.b.b.a();
        this.b.b.show();
    }
}
