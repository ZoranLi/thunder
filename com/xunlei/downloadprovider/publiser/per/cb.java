package com.xunlei.downloadprovider.publiser.per;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: PublisherActivity */
final class cb implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ PublisherActivity c;

    cb(PublisherActivity publisherActivity, String str, String str2) {
        this.c = publisherActivity;
        this.a = str;
        this.b = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.c.c(this.a);
        a.a(this.a, this.c.k, "confirm", o.a(this.b), "");
    }
}
