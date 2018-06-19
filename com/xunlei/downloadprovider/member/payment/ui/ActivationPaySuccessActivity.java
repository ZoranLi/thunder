package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.h;
import com.xunlei.xllib.android.XLIntent;

public class ActivationPaySuccessActivity extends BaseActivity implements OnClickListener {
    private TextView a = null;
    private Button c = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activation_payment_success);
        findViewById(R.id.left_iv).setOnClickListener(this);
        this.a = (TextView) findViewById(R.id.rebuy_account_value);
        this.a.setText(j.a().a.n());
        this.c = (Button) findViewById(R.id.recharge_btn);
        this.c.setOnClickListener(this);
        d.e();
        bundle = new PayResultBean();
        bundle.setSuccess(true);
        h.a().a(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recharge_btn:
                PayUtil.a();
                a();
                finish();
                return;
            case R.id.left_iv:
                PayUtil.a();
                a();
                finish();
                break;
            default:
                break;
        }
    }

    private void a() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new XLIntent("action.type.activation.pay.success"));
    }

    public void onBackPressed() {
        PayUtil.a();
        a();
        finish();
        super.onBackPressed();
    }
}
