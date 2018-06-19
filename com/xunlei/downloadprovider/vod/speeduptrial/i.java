package com.xunlei.downloadprovider.vod.speeduptrial;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: BubbleTipBarControl */
final class i implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ f b;

    i(f fVar, Context context) {
        this.b = fVar;
        this.a = context;
    }

    public final void onClick(View view) {
        if (this.b.a.a.a() != null) {
            PaymentEntryActivity.a(this.a, PayFrom.BXBB_SPEEDUP_TRIAL, null);
            this.b.d.a(32);
            view = HubbleEventBuilder.build("android_player", "bxbb_xfc_tryendkt_click");
            view.add("is_login", d.a());
            ThunderReport.reportEvent(view);
            return;
        }
        if (this.b.a.a.g == null) {
            this.b.c.b();
            if (this.b.a.c() != null) {
                this.b.a.a();
                d.a(true);
            } else if (this.b.a.d() != null) {
                this.b.a.b();
                d.a(null);
            }
        }
    }
}
