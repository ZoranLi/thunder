package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.view.View;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.personal.redenvelope.f;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.RedEnvelopesDetailActivity;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import com.xunlei.downloadprovider.personal.user.account.address.a.a.a;

/* compiled from: RedEnvelopesActivity */
final class g implements a {
    final /* synthetic */ RedEnvelopesActivity a;

    g(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void a(View view, int i) {
        this.a.e = i;
        e eVar = (e) view.getTag();
        RedEnvelopesDetailActivity.b(this.a, eVar.a, "personal_center_packet");
        i = eVar.f;
        int i2 = eVar.g;
        int i3 = eVar.e;
        long j = eVar.i - eVar.h;
        view = 2;
        if (i3 != 2) {
            view = j <= 0 ? true : null;
        }
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_list_click");
        build.add("packet_type", i);
        build.add("gift_type", i2);
        build.add("status", view);
        f.a(build);
    }
}
