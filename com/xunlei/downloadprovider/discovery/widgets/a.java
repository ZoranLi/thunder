package com.xunlei.downloadprovider.discovery.widgets;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DiscoveryLocalServiceView */
final class a implements OnClickListener {
    final /* synthetic */ com.xunlei.downloadprovider.d.b.o.a a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    a(b bVar, com.xunlei.downloadprovider.d.b.o.a aVar, int i) {
        this.c = bVar;
        this.a = aVar;
        this.b = i;
    }

    public final void onClick(View view) {
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(this.c.a.getContext(), this.a.d, this.a.c, "");
        view = (this.a.e.a == null || this.a.e.a.equals("game_center") == null) ? null : 1;
        String str = "";
        if (this.b == 0) {
            str = view == null ? "tongcheng_1" : "game_center_1";
        } else if (this.b == 1) {
            str = view == null ? "tongcheng_2" : "game_center_2";
        } else if (this.b == 2) {
            str = view == null ? "tongcheng_3" : "game_center_3";
        }
        com.xunlei.downloadprovider.discovery.b.a.a(str, "0", null);
    }
}
