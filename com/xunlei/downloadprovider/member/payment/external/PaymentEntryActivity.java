package com.xunlei.downloadprovider.member.payment.external;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.ui.PayActivity;
import com.xunlei.xllib.android.XLIntent;

public class PaymentEntryActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onNewIntent(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c.a().a(false);
        intent.setClass(this, PayActivity.class);
        startActivity(intent);
        finish();
    }

    public static void a(Context context, PayFrom payFrom) {
        a(context, payFrom, null);
    }

    public static void a(Context context, PayFrom payFrom, String str) {
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a(str);
        a(context, payEntryParam);
    }

    public static void a(Context context, PayEntryParam payEntryParam) {
        context.startActivity(b(context, payEntryParam));
        payEntryParam.toString();
    }

    public static Intent b(Context context, PayEntryParam payEntryParam) {
        if (payEntryParam == null) {
            throw new NullPointerException("PayEntryParam is null");
        }
        Intent xLIntent = new XLIntent(context, PaymentEntryActivity.class);
        xLIntent.putExtra("PayEntryParam", payEntryParam);
        if ((context instanceof Activity) == null) {
            xLIntent.addFlags(268435456);
        }
        return xLIntent;
    }
}
