package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.activity.b;

/* compiled from: PayMealAreaView */
final class g implements OnClickListener {
    final /* synthetic */ PayMealAreaView a;

    g(PayMealAreaView payMealAreaView) {
        this.a = payMealAreaView;
    }

    public final void onClick(View view) {
        if (this.a.g() != null) {
            b bVar = (b) this.a.h;
            bVar.n = this.a.c.getIsOperate();
            this.a.j();
            if (bVar.a() != null) {
                PayMealAreaView.d(this.a);
            }
        }
    }
}
