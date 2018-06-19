package com.xunlei.downloadprovider.member.payment.voucher;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: VoucherListDlg */
final class p implements OnItemClickListener {
    final /* synthetic */ n a;

    p(n nVar) {
        this.a = nVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = ((Voucher) adapterView.getItemAtPosition(i)).b;
        if (this.a.c.b(str) == null) {
            b.a(this.a.a, str);
            this.a.a.notifyDataSetChanged();
            this.a.c.a(str, new q(this, str));
        }
    }
}
