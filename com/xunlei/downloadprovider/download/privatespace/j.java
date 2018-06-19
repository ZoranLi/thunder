package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: NoVipUsePrivateSpaceTipDialog */
final class j implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ g b;

    j(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
    }

    public final void onClick(View view) {
        an.a("open");
        this.b.dismiss();
        PaymentEntryActivity.a(this.a, PayFrom.DOWNLOAD_TASK_PRIVATE_SPACE);
    }
}
