package com.xunlei.downloadprovider.vod.speedplayback;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.payment.a.j;

/* compiled from: VodSpeedRateController */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        ThunderReport.reportEvent(e.a("triple_speed_btn_click"));
        a aVar = this.a;
        if (d.a()) {
            if (aVar.d == null) {
                aVar.d = new f(aVar.a.getContext());
                aVar.d.a = new c(aVar);
            }
            if (!j.a().a.l()) {
                aVar.c = null;
            }
            f fVar = aVar.d;
            VodSpeedRate vodSpeedRate = aVar.c;
            if (vodSpeedRate == null) {
                vodSpeedRate = VodSpeedRate.RATE_1_POINT_0;
            }
            if (fVar.b != null) {
                fVar.b.setSelected(false);
            }
            int childCount = fVar.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = fVar.d.getChildAt(i);
                if (childAt.getTag() != null && (childAt.getTag() instanceof VodSpeedRate) && ((VodSpeedRate) childAt.getTag()) == r2) {
                    childAt.setSelected(true);
                    fVar.b = childAt;
                    break;
                }
            }
            aVar.d.showAtLocation(aVar.a.getRootView(), 5, 0, 0);
        }
        if (this.a.b != null) {
            this.a.b.onClick(view);
        }
    }
}
