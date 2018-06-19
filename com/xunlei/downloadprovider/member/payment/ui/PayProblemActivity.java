package com.xunlei.downloadprovider.member.payment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.param.XLAliDisContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxDisContractParam;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.downloadprovider.member.payment.ui.a.c;
import com.xunlei.downloadprovider.member.payment.ui.a.c.a;
import com.xunlei.xllib.android.XLIntent;
import java.util.HashSet;

public class PayProblemActivity extends BaseActivity implements a {
    private static Handler i = new Handler(Looper.getMainLooper());
    private RecyclerView a;
    private TextView c;
    private int d;
    private String e;
    private b f = new am(this);
    private int g = -1;
    private int h = -1;
    private int j;
    private SparseArray<HashSet<String>> k = new SparseArray();
    private com.xunlei.thunder.commonui.dialog.b l;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.payment_problem_activity);
        this.j = l.a().b();
        l.a().a(this.f);
        ((TextView) findViewById(R.id.titlebar_title)).setText(getResources().getString(R.string.pay_appear_problem_title));
        ((ImageView) findViewById(R.id.titlebar_left)).setOnClickListener(new al(this));
        this.a = (RecyclerView) findViewById(R.id.pay_problem_rv);
        this.a.setLayoutManager(new LinearLayoutManager(this));
        this.c = (TextView) findViewById(R.id.pay_problem_tips);
        Adapter cVar = new c(getResources().getStringArray(R.array.pay_problem_title), getResources().getStringArray(R.array.pay_problem_content), this);
        this.a.setAdapter(cVar);
        cVar.a = this;
        this.d = getIntent().getIntExtra("extra_vastype", 1);
        this.e = com.xunlei.downloadprovider.member.payment.a.a(this.d, 0);
        new StringBuilder("bizNo===").append(this.e);
    }

    public static void a(Fragment fragment, int i) {
        if (fragment != null) {
            if (fragment.getActivity() != null) {
                Intent xLIntent = new XLIntent(fragment.getActivity(), PayProblemActivity.class);
                xLIntent.putExtra("extra_vastype", i);
                fragment.startActivityForResult(xLIntent, 1);
            }
        }
    }

    private void b() {
        this.c.setVisibility(0);
        i.postDelayed(new an(this), 2000);
    }

    public final void a() {
        boolean z;
        if (this.k.size() > 0) {
            int size = this.k.size();
            int i = 0;
            z = i;
            while (i < size) {
                HashSet hashSet = (HashSet) this.k.get(this.k.keyAt(i));
                if (hashSet != null) {
                    z = hashSet.contains(this.e);
                    if (z) {
                        break;
                    }
                }
                i++;
            }
        } else {
            z = false;
        }
        if (z) {
            if (this.l == null) {
                com.xunlei.thunder.commonui.dialog.b c = new com.xunlei.thunder.commonui.dialog.b(this).a(true).c(R.string.ok);
                c.b = new ap(this);
                c = c.b((int) R.string.cancel);
                c.d = new ao(this);
                this.l = c;
                this.l.setTitle(getResources().getString(R.string.pay_auto_renew_title));
            }
            this.l.a(getResources().getString(R.string.pay_auto_renew_content, new Object[]{PayUtil.a(j.a().f())}));
            if (!this.l.isShowing()) {
                this.l.show();
            }
            return;
        }
        b();
        this.c.setText(getResources().getString(R.string.pay_cancel_auto_renew_not_contact));
        d.b(-1);
    }

    protected void onDestroy() {
        super.onDestroy();
        l.a().b(this.f);
        if (this.l != null) {
            this.l.dismiss();
        }
        i.removeCallbacksAndMessages(null);
        this.k.clear();
    }

    static /* synthetic */ void a(PayProblemActivity payProblemActivity, int i) {
        if (payProblemActivity.k.get(i) != null) {
            ((HashSet) payProblemActivity.k.get(i)).remove(payProblemActivity.e);
            i = new Intent();
            i.putExtra("extra:bizno", payProblemActivity.e);
            payProblemActivity.setResult(-1, i);
        }
    }

    static /* synthetic */ void g(PayProblemActivity payProblemActivity) {
        if (payProblemActivity.k.get(XLPayType.XL_ALIPAY_CONTRACT) == null || !((HashSet) payProblemActivity.k.get(XLPayType.XL_ALIPAY_CONTRACT)).contains(payProblemActivity.e)) {
            if (payProblemActivity.k.get(XLPayType.XL_WX_CONTRACT) != null && ((HashSet) payProblemActivity.k.get(XLPayType.XL_WX_CONTRACT)).contains(payProblemActivity.e)) {
                l a = l.a();
                l.c cVar = new l.c(payProblemActivity.d, 0, (byte) 0);
                XLPayParam xLWxDisContractParam = new XLWxDisContractParam();
                xLWxDisContractParam.mUserId = cVar.getUserId();
                xLWxDisContractParam.mSessionId = cVar.getSessionId();
                xLWxDisContractParam.mBizNo = cVar.getBizNo();
                xLWxDisContractParam.mParamExt = cVar.getParamExt();
                payProblemActivity.h = a.a.userGetXLContractor(4097).userDisContract(xLWxDisContractParam, cVar);
            }
            return;
        }
        a = l.a();
        cVar = new l.c(payProblemActivity.d, 0, (byte) 0);
        xLWxDisContractParam = new XLAliDisContractParam();
        xLWxDisContractParam.mUserId = cVar.getUserId();
        xLWxDisContractParam.mSessionId = cVar.getSessionId();
        xLWxDisContractParam.mBizNo = cVar.getBizNo();
        xLWxDisContractParam.mParamExt = cVar.getParamExt();
        payProblemActivity.g = a.a.userGetXLContractor(4096).userDisContract(xLWxDisContractParam, cVar);
    }
}
