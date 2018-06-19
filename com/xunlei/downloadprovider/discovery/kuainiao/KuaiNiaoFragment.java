package com.xunlei.downloadprovider.discovery.kuainiao;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.accelerator.XLAccelUtil;
import com.xunlei.common.accelerator.js.KNJsInterface.JumpLisenter;
import com.xunlei.common.accelerator.js.KNJsUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.discovery.kuainiao.a.a;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;

public class KuaiNiaoFragment extends BaseFragment implements OnClickListener, JumpLisenter, a {
    protected static String a;
    private static CustomWebView e;
    private boolean b = false;
    private final String c = "KuaiNiaoFragment";
    private boolean d = true;
    private int f;
    private String g;
    private String h;
    private final g i = new a(this);
    private final d j = new b(this);
    private boolean k;

    public void jumpToLogin() {
        Intent xLIntent = new XLIntent(getApplicationContext(), LoginActivity.class);
        xLIntent.putExtra("login_from", "KuaiNiaoFragment");
        xLIntent.setFlags(268435456);
        startActivity(xLIntent);
    }

    public void jumpToPay() {
        PaymentEntryActivity.a(this.mActivity, PayFrom.BIRD_PAGE, d.a().f());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPageRoot == null) {
            this.mPageRoot = (ViewGroup) layoutInflater.inflate(R.layout.fragment_kuainiao, viewGroup, false);
            if (getExtras() != null) {
                this.b = getExtras().getBoolean("from_where", false);
                a = getExtras().getString("extra_card_id", "");
                this.f = getExtras().getInt("extra_card_time", 0);
                this.g = getExtras().getString("extra_card_validate_time");
                this.h = getExtras().getString("extra_card_receive_time");
            }
            findViewById(R.id.goback_btn).setOnClickListener(this);
            ((TextView) findViewById(R.id.title)).setText("迅雷快鸟");
            CustomWebView customWebView = (CustomWebView) findViewById(R.id.funpaly_webview);
            e = customWebView;
            customWebView.a("http://k.xunlei.com/speed-mini-shoulei-524/index.html");
            KNJsUtils.getKnJsUtils().initJsInterface(e.getWebView(), this);
            if (b.a(getActivity()) != null) {
                layoutInflater = e;
                viewGroup = new StringBuffer();
                viewGroup.append("http://k.xunlei.com/speed-mini-shoulei-524/index.html?version=11100&referfrom=");
                viewGroup.append(d.a().f());
                if (TextUtils.isEmpty(a) == null) {
                    viewGroup.append("&cardid=");
                    viewGroup.append(a);
                    viewGroup.append("&cardtime=");
                    viewGroup.append(this.f);
                    viewGroup.append("&validity_end_date=");
                    viewGroup.append(this.g);
                    viewGroup.append("&receive_time=");
                    viewGroup.append(this.h);
                }
                layoutInflater.a(viewGroup.toString());
            } else {
                XLToast.showToast(getActivity(), "网络连接有问题，请检查网络");
                e.a("http://swjsq.xunlei.com/mobile/shoulei/");
            }
            LoginHelper.a().a(this.i);
            LoginHelper.a().a(this.j);
        }
        layoutInflater = this.mPageRoot.getParent();
        if (!(layoutInflater == null || (layoutInflater instanceof ViewGroup) == null)) {
            ((ViewGroup) layoutInflater).removeView(this.mPageRoot);
        }
        XLAccelUtil.getInstance().getAccelerator().attachListener(this);
        return this.mPageRoot;
    }

    public void onResume() {
        super.onResume();
        com.xunlei.downloadprovider.discovery.kuainiao.a.b.a();
        com.xunlei.downloadprovider.discovery.kuainiao.a.b.d();
        if (!this.d) {
            if (((this.k != b.a(getActivity()) ? 1 : 0) & b.a(getActivity())) != 0) {
                e.getWebView().reload();
            } else if (b.a(getActivity())) {
                e.a("javascript:refresh()");
            }
        }
        this.d = false;
        this.k = b.a(getActivity());
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.goback_btn) {
            this.mActivity.finish();
        }
    }

    public boolean onBackPressed() {
        if (e.h()) {
            e.i();
            return true;
        }
        if (this.b) {
            MainTabActivity.b(this.mActivity, "thunder", null);
        }
        this.mActivity.finish();
        return false;
    }

    public void callBack(int i, int i2, String str) {
        if (i == 21) {
            if (TextUtils.isEmpty(a) == 0 && TextUtils.isEmpty(str) == 0) {
                this.mActivity.runOnUiThread(new c(this, str));
                str = new a();
                str.a = HubbleEventBuilder.build("android_kuainiao", "try_speed_tost_show");
                str.a.add("status", "vip_speed");
                str.a.add("vip_from", "k_an_shoulei_hytq_knhb");
                a.a(str);
            }
        }
    }

    public void onDestroy() {
        LoginHelper.a().b(this.i);
        LoginHelper.a().b(this.j);
        KNJsUtils.getKnJsUtils().uninitJsInterface();
        XLAccelUtil.getInstance().getAccelerator().detachListener(this);
        super.onDestroy();
    }
}
