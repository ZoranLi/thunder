package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import com.android.volley.VolleyError;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.personal.redenvelope.f;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.e;

/* compiled from: RedEnvelopesDetailActivity */
final class a implements com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a.a {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    a(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void a(e eVar) {
        if (!RedEnvelopesDetailActivity.a(this.a)) {
            if (eVar == null || !eVar.a.equals(ITagManager.SUCCESS)) {
                RedEnvelopesDetailActivity.e(this.a);
                return;
            }
            this.a.s = eVar;
            this.a.o.hide();
            RedEnvelopesDetailActivity.c(this.a);
            RedEnvelopesDetailActivity.b(this.a, eVar);
            String d = this.a.r;
            int i = eVar.m;
            int i2 = eVar.g;
            eVar = eVar.b;
            StatEvent build = HubbleEventBuilder.build("android_packet", "packet_detail_show");
            build.add("from", d);
            build.add("packet_type", i);
            build.add("gift_type", i2);
            build.add("gameid", eVar);
            build.add("position_id", "packet_dlcenter_game");
            f.a(build);
        }
    }

    public final void a(VolleyError volleyError) {
        if (!RedEnvelopesDetailActivity.a(this.a)) {
            new StringBuilder("onGetRedEnvelopesError volleyError = ").append(volleyError.toString());
            this.a.b();
        }
    }
}
