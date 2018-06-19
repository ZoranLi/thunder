package com.xunlei.downloadprovider.member.payment.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.widget.TextView;
import com.igexin.sdk.PushConsts;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.b.a;
import com.xunlei.downloadprovider.member.b.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.member.payment.bean.PaySucInfo;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountBindMobileActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.xllib.android.XLIntent;
import org.json.JSONObject;

public class PaymentSuccessActivity extends BaseActivity {
    private CustomWebView a;
    private String c;
    private PaySucInfo d;

    protected void onCreate(Bundle bundle) {
        boolean z;
        int i;
        String text;
        String a;
        WebSettings settings;
        CookieManager instance;
        String str;
        String format;
        StringBuilder stringBuilder;
        super.onCreate(bundle);
        this.c = LoginHelper.a().i();
        setContentView(R.layout.payment_success_activity);
        this.d = (PaySucInfo) getIntent().getParcelableExtra("pay_suc_info");
        PayUtil.a = true;
        PayUtil.b = true;
        a a2 = c.a(null);
        a2.a();
        LoginHelper.a().a(new ar(this, LoginHelper.a().o(), a2));
        PayUtil.a();
        LoginHelper.a().b();
        i.e(LoginHelper.a().q);
        i.f(LoginHelper.a().q);
        ((TextView) findViewById(R.id.title)).setText(getString(R.string.pay_result_success_title, new Object[]{this.d.orderType.getText()}));
        int i2 = this.d.vasType;
        if (!com.xunlei.downloadprovider.member.payment.i.a(i2)) {
            if (!com.xunlei.downloadprovider.member.payment.i.b(i2)) {
                z = false;
                i = 8;
                if (z) {
                    View inflate = ((ViewStub) findViewById(R.id.pay_suc_old_content_vs)).inflate();
                    TextView textView = (TextView) inflate.findViewById(R.id.success_prompt);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.account);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.product_key);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.product_value);
                    TextView textView5 = (TextView) inflate.findViewById(R.id.pay_duration);
                    inflate = inflate.findViewById(R.id.bind_mobile_btn);
                    inflate.setOnClickListener(new au(this));
                    if (TextUtils.isEmpty(this.c)) {
                        i = 0;
                    }
                    inflate.setVisibility(i);
                    textView.setText(getString(R.string.pay_result_success_prompt, new Object[]{this.d.orderType.getText()}));
                    textView2.setText(getString(R.string.pay_result_account, new Object[]{text, b()}));
                    textView3.setText(getString(R.string.pay_result_product, new Object[]{text}));
                    a = PayUtil.a(this.d.vasType);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(text);
                    stringBuilder2.append(a);
                    textView4.setText(stringBuilder2.toString());
                    a = a(this.d.orderType, this.d.monthOrDays);
                    textView5.setText(getString(R.string.pay_result_duration, new Object[]{text, a}));
                } else {
                    text = this.d.orderType.getText();
                    View inflate2 = ((ViewStub) findViewById(R.id.pay_suc_new_content_vs)).inflate();
                    ((TextView) inflate2.findViewById(R.id.account_tv)).setText(getString(R.string.pay_result_account, new Object[]{text, b()}));
                    View findViewById = inflate2.findViewById(R.id.bind_mobile_tv);
                    if (TextUtils.isEmpty(this.c)) {
                        i = 0;
                    }
                    findViewById.setVisibility(i);
                    findViewById.setOnClickListener(new at(this));
                    a = PayUtil.a(this.d.vasType);
                    TextView textView6 = (TextView) inflate2.findViewById(R.id.pay_result_detail_tv);
                    Object[] objArr = new Object[1];
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(text);
                    stringBuilder3.append(a);
                    stringBuilder3.append(a(this.d.orderType, this.d.monthOrDays));
                    objArr[0] = stringBuilder3.toString();
                    textView6.setText(getString(R.string.pay_result_detail_format, objArr));
                }
                this.a = (CustomWebView) findViewById(R.id.webView);
                settings = this.a.getSettings();
                settings.setCacheMode(2);
                settings.setUseWideViewPort(true);
                settings.setLoadWithOverviewMode(true);
                settings.setSupportMultipleWindows(false);
                this.a.setScrollBarStyle(33554432);
                this.a.setWebViewClient(new as(this));
                text = c();
                if (VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(this);
                }
                instance = CookieManager.getInstance();
                instance.setAcceptCookie(true);
                instance.removeAllCookie();
                str = ".xunlei.com";
                format = String.format("; domain=%s", new Object[]{str});
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("userid=%s", new Object[]{Long.valueOf(LoginHelper.a().g.c())}));
                stringBuilder.append(format);
                instance.setCookie(str, stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("sessionid=%s", new Object[]{LoginHelper.a().c()}));
                stringBuilder.append(format);
                instance.setCookie(str, stringBuilder.toString());
                CookieSyncManager.getInstance().sync();
                TextUtils.isEmpty(instance.getCookie(str));
                this.a.a(text);
                d.a(1 ^ TextUtils.isEmpty(this.c));
            }
        }
        z = true;
        i = 8;
        if (z) {
            View inflate3 = ((ViewStub) findViewById(R.id.pay_suc_old_content_vs)).inflate();
            TextView textView7 = (TextView) inflate3.findViewById(R.id.success_prompt);
            TextView textView22 = (TextView) inflate3.findViewById(R.id.account);
            TextView textView32 = (TextView) inflate3.findViewById(R.id.product_key);
            TextView textView42 = (TextView) inflate3.findViewById(R.id.product_value);
            TextView textView52 = (TextView) inflate3.findViewById(R.id.pay_duration);
            inflate3 = inflate3.findViewById(R.id.bind_mobile_btn);
            inflate3.setOnClickListener(new au(this));
            if (TextUtils.isEmpty(this.c)) {
                i = 0;
            }
            inflate3.setVisibility(i);
            textView7.setText(getString(R.string.pay_result_success_prompt, new Object[]{this.d.orderType.getText()}));
            textView22.setText(getString(R.string.pay_result_account, new Object[]{text, b()}));
            textView32.setText(getString(R.string.pay_result_product, new Object[]{text}));
            a = PayUtil.a(this.d.vasType);
            StringBuilder stringBuilder22 = new StringBuilder();
            stringBuilder22.append(text);
            stringBuilder22.append(a);
            textView42.setText(stringBuilder22.toString());
            a = a(this.d.orderType, this.d.monthOrDays);
            textView52.setText(getString(R.string.pay_result_duration, new Object[]{text, a}));
        } else {
            text = this.d.orderType.getText();
            View inflate22 = ((ViewStub) findViewById(R.id.pay_suc_new_content_vs)).inflate();
            ((TextView) inflate22.findViewById(R.id.account_tv)).setText(getString(R.string.pay_result_account, new Object[]{text, b()}));
            View findViewById2 = inflate22.findViewById(R.id.bind_mobile_tv);
            if (TextUtils.isEmpty(this.c)) {
                i = 0;
            }
            findViewById2.setVisibility(i);
            findViewById2.setOnClickListener(new at(this));
            a = PayUtil.a(this.d.vasType);
            TextView textView62 = (TextView) inflate22.findViewById(R.id.pay_result_detail_tv);
            Object[] objArr2 = new Object[1];
            StringBuilder stringBuilder32 = new StringBuilder();
            stringBuilder32.append(text);
            stringBuilder32.append(a);
            stringBuilder32.append(a(this.d.orderType, this.d.monthOrDays));
            objArr2[0] = stringBuilder32.toString();
            textView62.setText(getString(R.string.pay_result_detail_format, objArr2));
        }
        this.a = (CustomWebView) findViewById(R.id.webView);
        settings = this.a.getSettings();
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportMultipleWindows(false);
        this.a.setScrollBarStyle(33554432);
        this.a.setWebViewClient(new as(this));
        text = c();
        if (VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(this);
        }
        instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeAllCookie();
        str = ".xunlei.com";
        format = String.format("; domain=%s", new Object[]{str});
        stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("userid=%s", new Object[]{Long.valueOf(LoginHelper.a().g.c())}));
        stringBuilder.append(format);
        instance.setCookie(str, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("sessionid=%s", new Object[]{LoginHelper.a().c()}));
        stringBuilder.append(format);
        instance.setCookie(str, stringBuilder.toString());
        CookieSyncManager.getInstance().sync();
        TextUtils.isEmpty(instance.getCookie(str));
        this.a.a(text);
        d.a(1 ^ TextUtils.isEmpty(this.c));
    }

    public void onBackPressed() {
        a();
    }

    private void a() {
        if (this.d.successDest == null) {
            setResult(-1);
            finish();
            return;
        }
        this.d.successDest.go(this);
        finish();
    }

    public void onClickGoback(View view) {
        d.c("0");
        a();
    }

    private static String a(PayUtil$OrderType payUtil$OrderType, int i) {
        String str = "";
        if (payUtil$OrderType == PayUtil$OrderType.UPGRADE) {
            payUtil$OrderType = new StringBuilder();
            payUtil$OrderType.append(i);
            payUtil$OrderType.append("天");
            return payUtil$OrderType.toString();
        } else if (payUtil$OrderType != PayUtil$OrderType.OPEN && payUtil$OrderType != PayUtil$OrderType.RENEW) {
            return str;
        } else {
            if (i >= 12) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i / 12);
                stringBuilder.append("年");
                i %= 12;
                if (i > 0) {
                    stringBuilder.append(i);
                    stringBuilder.append("个月");
                }
                return stringBuilder.toString();
            }
            payUtil$OrderType = new StringBuilder();
            payUtil$OrderType.append(i);
            payUtil$OrderType.append("个月");
            return payUtil$OrderType.toString();
        }
    }

    public static void a(Activity activity, PaySucInfo paySucInfo) {
        if (activity != null) {
            Intent xLIntent = new XLIntent(activity, PaymentSuccessActivity.class);
            xLIntent.putExtra("pay_suc_info", paySucInfo);
            activity.startActivity(xLIntent);
            activity.finish();
        }
    }

    private static String b() {
        String d = LoginHelper.a().d();
        return TextUtils.isEmpty(d) ? LoginHelper.a().n() : d;
    }

    private String c() {
        Builder buildUpon = Uri.parse("http://act.vip.xunlei.com/vip/slpayadv/white.html").buildUpon();
        buildUpon.appendQueryParameter("order_id", this.d.orderId);
        buildUpon.appendQueryParameter("vas_type", String.valueOf(this.d.vasType));
        buildUpon.appendQueryParameter("refer_from", this.d.referfrom);
        buildUpon.appendQueryParameter("order_type", String.valueOf(this.d.orderType.toXLSdkOrderType()));
        buildUpon.appendQueryParameter("month", String.valueOf(this.d.monthOrDays));
        if (!TextUtils.isEmpty(this.d.activityExt)) {
            try {
                JSONObject jSONObject = new JSONObject(this.d.activityExt);
                buildUpon.appendQueryParameter("actid", jSONObject.optString("actid"));
                buildUpon.appendQueryParameter(PushConsts.KEY_SERVICE_PIT, jSONObject.optString(PushConsts.KEY_SERVICE_PIT));
            } catch (Exception e) {
                e.toString();
            }
        }
        return buildUpon.build().toString();
    }

    static /* synthetic */ void c(PaymentSuccessActivity paymentSuccessActivity) {
        if (TextUtils.isEmpty(paymentSuccessActivity.c)) {
            d.c("3");
            UserAccountBindMobileActivity.a(paymentSuccessActivity, "paysucbar");
        }
        paymentSuccessActivity.finish();
    }
}
