package com.xunlei.downloadprovider.member.payment.voucher;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;
import java.util.List;

/* compiled from: VoucherItemView */
final class l implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ VoucherItemView b;

    l(VoucherItemView voucherItemView, Context context) {
        this.b = voucherItemView;
        this.a = context;
    }

    public final void onClick(View view) {
        if (this.b.h == null) {
            this.b.h = new n(this.a, this.b.a);
            this.b.h.b = this.b.i;
        }
        view = this.b.h;
        List d = this.b.b;
        Voucher e = this.b.f;
        view.a.a(d);
        b.b(view.a, e != null ? e.b : null);
        this.b.h.show();
        d.b();
    }
}
