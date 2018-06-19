package com.xunlei.downloadprovider.vod.speedplayback;

import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: VodSpeedRateController */
final class c implements a {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final boolean a(VodSpeedRate vodSpeedRate) {
        if (this.a.c == vodSpeedRate) {
            return false;
        }
        if (vodSpeedRate != null) {
            StatEvent a = e.a("triple_speed_select_click");
            a.add("triple_speed_type", String.valueOf(vodSpeedRate.getRateValue()));
            ThunderReport.reportEvent(a);
        }
        if (j.a().a.l()) {
            this.a.a(vodSpeedRate, false);
            return true;
        }
        this.a.c = vodSpeedRate;
        PaymentEntryActivity.a(this.a.a.getContext(), PayFrom.VOD_SPEED_RATE);
        return true;
    }
}
