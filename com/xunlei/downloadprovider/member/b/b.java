package com.xunlei.downloadprovider.member.b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: RenewalActionHelper */
public final class b {
    public static void a(@NonNull Context context, PayFrom payFrom, String str, String str2) {
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.d = str2;
        PaymentEntryActivity.a(context, payEntryParam.a(str));
    }
}
