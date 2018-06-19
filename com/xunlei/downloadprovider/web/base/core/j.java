package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: DefaultJsInterface */
final class j implements Runnable {
    final /* synthetic */ PayEntryParam a;
    final /* synthetic */ DefaultJsInterface b;

    j(DefaultJsInterface defaultJsInterface, PayEntryParam payEntryParam) {
        this.b = defaultJsInterface;
        this.a = payEntryParam;
    }

    public final void run() {
        PaymentEntryActivity.a(this.b.getContext(), this.a);
    }
}
