package com.xunlei.downloadprovider.discovery.kuainiao;

import android.app.Activity;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: KuaiNiaoUtil */
public final class h {
    public static void a(Activity activity, PayFrom payFrom) {
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a(d.a().f());
        activity.startActivity(PaymentEntryActivity.b(activity, payEntryParam));
    }
}
