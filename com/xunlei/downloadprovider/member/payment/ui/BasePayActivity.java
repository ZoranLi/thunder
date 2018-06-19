package com.xunlei.downloadprovider.member.payment.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLAllContractResp$ContractedResult;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.param.XLAliPayContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractParam;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.c;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.external.l$a;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.member.payment.ui.widget.a;
import com.xunlei.thunder.commonui.dialog.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class BasePayActivity extends BaseActivity {
    protected String a;
    PayFrom c;
    protected PayEntryParam d;
    protected l$a e;
    String f;
    protected String g;
    HashSet<String> h = new HashSet();
    protected int i = -1;
    private XLPayParam j;
    private String k;
    private int l;
    private XLOnPayListener m = new i(this);
    private boolean n = false;
    private b o;
    private b p;
    private a q;
    private d r = new q(this);
    private int s = -1;
    private g t = new j(this);

    @LayoutRes
    public abstract int a();

    public abstract void a(int i);

    protected void a(Object obj, int i, String str) {
    }

    public abstract com.xunlei.downloadprovider.member.payment.d.a b();

    public abstract int c();

    public abstract void d();

    public abstract void g();

    public abstract int h();

    public abstract PayUtil$OrderType i();

    public abstract void init(View view);

    public abstract int j();

    protected void k() {
    }

    @CallSuper
    protected void m() {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.d == null) {
            this.d = (PayEntryParam) bundle.getParcelable("PayEntryParam");
        }
        l.a().a(this.m);
        LoginHelper.a().a(this.r);
        LoginHelper.a().a(this.t);
        a(getIntent());
        bundle = View.inflate(this, a(), null);
        setContentView(bundle);
        init(bundle);
        this.i = l.a().b();
        com.xunlei.downloadprovider.member.payment.d.a(this.a);
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            Uri data = intent.getData();
            if (data == null || !TextUtils.equals(PayBaseConstants.ALI_CALLBACK_SCHEME, data.getScheme())) {
                setIntent(intent);
                a(intent);
            } else {
                intent = data.getQueryParameter(PayBaseConstants.ALI_CALLBACK_IDENTIFY);
                if (TextUtils.equals("T", intent)) {
                    a(0, "", this.j, this.k, 1);
                } else if (TextUtils.isEmpty(intent) != null) {
                    a(101, getResources().getString(R.string.pay_user_cancel), this.j, this.k, 1);
                } else {
                    a(100, getResources().getString(R.string.pay_failed), this.j, this.k, 1);
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        j.a();
        if (com.xunlei.downloadprovider.member.login.b.l.b() && this.e != null && this.e.f && this.e.h == 2) {
            d();
            this.s = l.a().b();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null && this.d == null) {
            this.d = (PayEntryParam) bundle.getParcelable("PayEntryParam");
        }
        new StringBuilder("onRestoreInstanceState--EntryParam=").append(this.d);
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        new StringBuilder("onSaveInstanceState--EntryParam=").append(this.d);
        bundle.putParcelable("PayEntryParam", this.d);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        l.a().b(this.m);
        LoginHelper.a().b(this.r);
        LoginHelper.a().b(this.t);
        if (this.p != null) {
            this.p.dismiss();
        }
        if (this.q != null) {
            this.q.dismiss();
        }
        if (this.o != null) {
            this.o.dismiss();
        }
        this.e = null;
        com.xunlei.downloadprovider.member.payment.d.f("");
    }

    private void a(@NonNull Intent intent) {
        if (this.d == null) {
            this.d = (PayEntryParam) intent.getParcelableExtra("PayEntryParam");
        }
        if (this.d != null) {
            this.c = this.d.a;
            this.a = this.d.b;
            intent = this.d.b("voucher_code");
            if (intent == null || !(intent instanceof String)) {
                intent = "";
            } else {
                intent = intent.toString();
            }
            this.f = intent;
            intent = new StringBuilder("PayFrom = ");
            intent.append(this.c);
            intent.append(" , original reportRefer =");
            intent.append(f.a(this.c));
            intent.append(" ,reportRefer=");
            intent.append(this.a);
            if (this.c != null) {
                j.a().b = this.c.isFromKuaiNiao();
            }
            com.xunlei.downloadprovider.member.payment.d.f(this.d.d);
        }
    }

    public final boolean a(String str) {
        if (this.n) {
            return true;
        }
        if (TextUtils.isEmpty(str) || this.h.contains(str) == null) {
            return null;
        }
        return true;
    }

    private void b(String str) {
        if (this.o == null) {
            b a = new b(this).d(R.string.ok).a(false).a().a(-1, 8);
            a.c = new k(this);
            this.o = a;
            this.o.setCancelable(true);
            this.o.setCanceledOnTouchOutside(true);
        }
        this.o.a((CharSequence) str);
        if (this.o.isShowing() == null) {
            this.o.show();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.CallSuper
    private void a(int r28, java.lang.String r29, java.lang.Object r30, java.lang.String r31, int r32) {
        /*
        r27 = this;
        r0 = r27;
        r6 = r28;
        r1 = r30;
        r2 = r31;
        if (r1 == 0) goto L_0x0299;
    L_0x000a:
        r3 = r1 instanceof com.xunlei.common.new_ptl.pay.param.XLPayParam;
        if (r3 == 0) goto L_0x0299;
    L_0x000e:
        r3 = r0.e;
        if (r3 != 0) goto L_0x0014;
    L_0x0012:
        goto L_0x0299;
    L_0x0014:
        r3 = r27.isFinishing();
        if (r3 == 0) goto L_0x001b;
    L_0x001a:
        return;
    L_0x001b:
        r0.k = r2;
        r7 = r1;
        r7 = (com.xunlei.common.new_ptl.pay.param.XLPayParam) r7;
        r1 = r7 instanceof com.xunlei.downloadprovider.member.payment.external.l.c;
        r3 = -1;
        r11 = 0;
        if (r1 == 0) goto L_0x0037;
    L_0x0026:
        r1 = r7;
        r1 = (com.xunlei.downloadprovider.member.payment.external.l.c) r1;
        r4 = r1.a;
        r5 = l();
        r1 = r1.b;
        r1 = a(r5, r1);
        r5 = r1;
        goto L_0x0052;
    L_0x0037:
        r1 = r7.getBizNo();
        r1 = com.xunlei.downloadprovider.member.payment.a.a(r1);
        if (r1 == 0) goto L_0x0050;
    L_0x0041:
        r4 = l();
        r5 = r1.b;
        r4 = a(r4, r5);
        r1 = r1.a;
        r5 = r4;
        r4 = r1;
        goto L_0x0052;
    L_0x0050:
        r4 = r3;
        r5 = r11;
    L_0x0052:
        r1 = "payment";
        r8 = new java.lang.StringBuilder;
        r9 = "[onPayComplete] vasType=";
        r8.<init>(r9);
        r8.append(r4);
        r9 = " ,orderType=";
        r8.append(r9);
        r8.append(r5);
        r9 = " ,orderId=";
        r8.append(r9);
        r8.append(r2);
        r8 = r8.toString();
        com.sina.weibo.sdk.utils.LogUtil.e(r1, r8);
        r1 = r27.b();
        r8 = r27.c();
        r9 = 0;
        r10 = 1;
        if (r6 != 0) goto L_0x0083;
    L_0x0081:
        r12 = r10;
        goto L_0x0084;
    L_0x0083:
        r12 = r9;
    L_0x0084:
        r13 = new com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
        r13.<init>();
        r13.setSuccess(r12);
        if (r12 == 0) goto L_0x00bc;
    L_0x008e:
        r14 = r0.c;
        if (r14 == 0) goto L_0x00b9;
    L_0x0092:
        r14 = r0.c;
        r14 = r14.isFromRedPacket();
        if (r14 == 0) goto L_0x00b9;
    L_0x009a:
        r14 = r0.e;
        if (r14 == 0) goto L_0x00b9;
    L_0x009e:
        r14 = r0.f;
        r14 = android.text.TextUtils.isEmpty(r14);
        if (r14 != 0) goto L_0x00b9;
    L_0x00a6:
        r14 = r0.f;
        r15 = r0.e;
        r15 = r15.a;
        r14 = android.text.TextUtils.equals(r14, r15);
        if (r14 == 0) goto L_0x00b9;
    L_0x00b2:
        r14 = r0.f;
        r13.setExtraParam1(r14);
        r14 = r10;
        goto L_0x00ba;
    L_0x00b9:
        r14 = r9;
    L_0x00ba:
        if (r14 != 0) goto L_0x00c1;
    L_0x00bc:
        r14 = "";
        r13.setExtraParam1(r14);
    L_0x00c1:
        r14 = com.xunlei.downloadprovider.member.payment.external.h.a();
        r14.a(r13);
        if (r12 == 0) goto L_0x00d5;
    L_0x00ca:
        r12 = com.xunlei.common.accelerator.XLAccelUtil.getInstance();
        r12 = r12.getAccelerator();
        r12.updateUserInfo();
    L_0x00d5:
        r12 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r6 == 0) goto L_0x01c3;
    L_0x00d9:
        r2 = 51;
        if (r6 == r2) goto L_0x0160;
    L_0x00dd:
        if (r6 == r12) goto L_0x0160;
    L_0x00df:
        switch(r6) {
            case 10000: goto L_0x00eb;
            case 10001: goto L_0x00eb;
            case 10002: goto L_0x00eb;
            case 10003: goto L_0x00eb;
            default: goto L_0x00e2;
        };
    L_0x00e2:
        switch(r6) {
            case 10010: goto L_0x00eb;
            case 10011: goto L_0x00eb;
            case 10012: goto L_0x00eb;
            case 10013: goto L_0x00eb;
            default: goto L_0x00e5;
        };
    L_0x00e5:
        switch(r6) {
            case 10020: goto L_0x00eb;
            case 10021: goto L_0x00eb;
            case 10022: goto L_0x00eb;
            default: goto L_0x00e8;
        };
    L_0x00e8:
        r2 = r29;
        goto L_0x00fd;
    L_0x00eb:
        r2 = java.util.Locale.getDefault();
        r7 = "支付出错，请稍后再试！(错误码：%d)";
        r12 = new java.lang.Object[r10];
        r13 = java.lang.Integer.valueOf(r28);
        r12[r9] = r13;
        r2 = java.lang.String.format(r2, r7, r12);
    L_0x00fd:
        r7 = r0.p;
        if (r7 != 0) goto L_0x012e;
    L_0x0101:
        r7 = new com.xunlei.thunder.commonui.dialog.b;
        r7.<init>(r0);
        r12 = 2131362088; // 0x7f0a0128 float:1.8343947E38 double:1.0530327865E-314;
        r7 = r7.d(r12);
        r7 = r7.a(r9);
        r7 = r7.a();
        r9 = 8;
        r3 = r7.a(r3, r9);
        r7 = new com.xunlei.downloadprovider.member.payment.ui.m;
        r7.<init>(r0);
        r3.c = r7;
        r0.p = r3;
        r3 = r0.p;
        r3.setCancelable(r10);
        r3 = r0.p;
        r3.setCanceledOnTouchOutside(r10);
    L_0x012e:
        r3 = r0.p;
        r3.a(r2);
        r2 = r0.p;
        r2 = r2.isShowing();
        if (r2 != 0) goto L_0x0140;
    L_0x013b:
        r2 = r0.p;
        r2.show();
    L_0x0140:
        r2 = r0.a;
        r3 = r0.e;
        r7 = r3.b();
        r9 = "5.60.2.5510";
        r10 = r1.a;
        r1 = r0.e;
        r12 = r1.f;
        r1 = r2;
        r2 = r4;
        r3 = r5;
        r4 = r8;
        r5 = r32;
        r8 = r9;
        r9 = r10;
        r10 = r12;
        com.xunlei.downloadprovider.member.payment.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0.e = r11;
        goto L_0x0293;
    L_0x0160:
        r2 = r0.a;
        r3 = r0.e;
        r17 = r3.b();
        r1 = r1.a;
        r3 = r0.e;
        r3 = r3.f;
        r12 = r4;
        r13 = r5;
        r14 = r8;
        r15 = r32;
        r16 = r2;
        r18 = r1;
        r19 = r3;
        com.xunlei.downloadprovider.member.payment.d.a(r12, r13, r14, r15, r16, r17, r18, r19);
        r1 = com.xunlei.downloadprovider.d.d.a();
        r1 = r1.h;
        r1 = r1.a();
        if (r1 == 0) goto L_0x0293;
    L_0x0188:
        r1 = r0.q;
        if (r1 != 0) goto L_0x01af;
    L_0x018c:
        r1 = new com.xunlei.downloadprovider.member.payment.ui.widget.a;
        r1.<init>(r0);
        r0.q = r1;
        r1 = r0.q;
        r2 = new com.xunlei.downloadprovider.member.payment.ui.n;
        r2.<init>(r0);
        r1.setOnCancelListener(r2);
        r1 = r0.q;
        r2 = new com.xunlei.downloadprovider.member.payment.ui.o;
        r2.<init>(r0);
        r1.b = r2;
        r1 = r0.q;
        r2 = new com.xunlei.downloadprovider.member.payment.ui.p;
        r2.<init>(r0);
        r1.a = r2;
    L_0x01af:
        r1 = r0.q;
        r1 = r1.isShowing();
        if (r1 != 0) goto L_0x0293;
    L_0x01b7:
        r1 = r0.q;
        r1.show();
        r1 = r0.a;
        com.xunlei.downloadprovider.member.payment.d.d(r1);
        goto L_0x0293;
    L_0x01c3:
        r3 = new com.xunlei.downloadprovider.member.payment.ui.l;
        r3.<init>(r0);
        com.xunlei.common.concurrent.XLThreadPool.execute(r3);
        r3 = r1.c;
        r6 = r7.getBizNo();
        r3 = android.text.TextUtils.equals(r3, r6);
        if (r3 == 0) goto L_0x0224;
    L_0x01d7:
        r3 = com.xunlei.downloadprovider.member.payment.activity.c.a();
        r6 = r1.d;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r14 = r14.g;
        r14 = r14.c();
        r13.append(r14);
        r13.append(r6);
        r6 = r13.toString();
        r13 = r3.c;
        r13 = r13.containsKey(r6);
        if (r13 == 0) goto L_0x020b;
    L_0x01fe:
        r9 = r3.c;
        r9 = r9.get(r6);
        r9 = (java.lang.Integer) r9;
        r9 = r9.intValue();
        goto L_0x0211;
    L_0x020b:
        r13 = r3.a;
        r9 = r13.getInt(r6, r9);
    L_0x0211:
        r9 = r9 + r10;
        r10 = r3.b;
        r10 = r10.putInt(r6, r9);
        r10.apply();
        r3 = r3.c;
        r9 = java.lang.Integer.valueOf(r9);
        r3.put(r6, r9);
    L_0x0224:
        r3 = r1.a;
        r6 = "vip2017libao";
        r3 = android.text.TextUtils.equals(r3, r6);
        if (r3 == 0) goto L_0x0235;
    L_0x022e:
        r3 = com.xunlei.downloadprovider.download.tasklist.list.banner.a.e.c();
        r3.b(r12);
    L_0x0235:
        r12 = r0.a;
        r3 = r0.e;
        r3 = r3.i;
        r18 = "5.60.2.5510";
        r19 = r27.h();
        r20 = r27.j();
        r21 = r27.i();
        r6 = r0.e;
        r22 = r6.b();
        r6 = r0.e;
        r6 = r6.f;
        r9 = r0.d;
        r10 = "taskid";
        r25 = r9.c(r10);
        r13 = r4;
        r14 = r5;
        r15 = r8;
        r16 = r32;
        r17 = r3;
        r23 = r6;
        r24 = r1;
        com.xunlei.downloadprovider.member.payment.d.a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        r9 = new com.xunlei.downloadprovider.member.payment.bean.PaySucInfo;
        r6 = r0.a;
        r1 = r9;
        r3 = r4;
        r4 = r5;
        r5 = r8;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = r27.b();
        r2 = r1.c;
        r3 = r7.getBizNo();
        r2 = android.text.TextUtils.equals(r2, r3);
        if (r2 == 0) goto L_0x0288;
    L_0x0284:
        r1 = r1.d;
        r9.activityExt = r1;
    L_0x0288:
        r1 = r0.d;
        r1 = r1.c;
        r9.successDest = r1;
        com.xunlei.downloadprovider.member.payment.ui.PaymentSuccessActivity.a(r0, r9);
        r0.e = r11;
    L_0x0293:
        r27.k();
        r0.j = r11;
        return;
    L_0x0299:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.ui.BasePayActivity.a(int, java.lang.String, java.lang.Object, java.lang.String, int):void");
    }

    private static PayUtil$OrderType a(boolean z, int i) {
        PayUtil$OrderType payUtil$OrderType = PayUtil$OrderType.OPEN;
        if (i == 1) {
            return PayUtil$OrderType.UPGRADE;
        }
        if (z) {
            return PayUtil$OrderType.RENEW;
        }
        return PayUtil$OrderType.OPEN;
    }

    @CallSuper
    protected void a(boolean z) {
        if (this.h.isEmpty() && z && !isFinishing()) {
            l.a().b();
        }
    }

    public final void a(@NonNull l$a com_xunlei_downloadprovider_member_payment_external_l_a) {
        if (com_xunlei_downloadprovider_member_payment_external_l_a != null) {
            this.e = com_xunlei_downloadprovider_member_payment_external_l_a;
            int toXLSdkOrderType = com_xunlei_downloadprovider_member_payment_external_l_a.d.toXLSdkOrderType();
            int i = com_xunlei_downloadprovider_member_payment_external_l_a.e;
            int i2 = com_xunlei_downloadprovider_member_payment_external_l_a.g;
            this.g = com.xunlei.downloadprovider.member.payment.a.a(i, toXLSdkOrderType);
            j.a();
            if (com.xunlei.downloadprovider.member.login.b.l.b()) {
                JSONObject a = com_xunlei_downloadprovider_member_payment_external_l_a.a();
                String str;
                boolean b;
                if (1 != com_xunlei_downloadprovider_member_payment_external_l_a.h) {
                    if (2 == com_xunlei_downloadprovider_member_payment_external_l_a.h) {
                        if (com_xunlei_downloadprovider_member_payment_external_l_a.f != null) {
                            com_xunlei_downloadprovider_member_payment_external_l_a = l.a();
                            XLWxContractParam a2 = l.a(i, toXLSdkOrderType, i2, a, this.a);
                            this.l = com_xunlei_downloadprovider_member_payment_external_l_a.a.userGetXLContractor(4097).userContract(a2, a2);
                            return;
                        }
                        com_xunlei_downloadprovider_member_payment_external_l_a = l.a();
                        str = this.a;
                        b = j.a().b();
                        if (toXLSdkOrderType == 1 && i.b(i) && b) {
                            i = 209;
                        }
                        String a3 = com.xunlei.downloadprovider.member.payment.a.a(i, toXLSdkOrderType);
                        StringBuilder stringBuilder = new StringBuilder("[wxPay] vasType=");
                        stringBuilder.append(i);
                        stringBuilder.append(" ,orderType=");
                        stringBuilder.append(toXLSdkOrderType);
                        stringBuilder.append(" ,isKuaiNiaoMemberType=");
                        stringBuilder.append(b);
                        stringBuilder.append(" ,bizNo=");
                        stringBuilder.append(a3);
                        com_xunlei_downloadprovider_member_payment_external_l_a.a(a3, i2, str, a, null);
                    }
                    return;
                } else if (com_xunlei_downloadprovider_member_payment_external_l_a.f != null) {
                    com_xunlei_downloadprovider_member_payment_external_l_a = l.a();
                    XLAliPayContractParam a4 = l.a(i, toXLSdkOrderType, i2, PayBaseConstants.ALI_CALLBACK_URI, a, this.a);
                    this.l = com_xunlei_downloadprovider_member_payment_external_l_a.a.userGetXLContractor(4096).userContract(a4, a4);
                    return;
                } else {
                    com_xunlei_downloadprovider_member_payment_external_l_a = l.a();
                    str = this.a;
                    b = j.a().b();
                    StringBuilder stringBuilder2 = new StringBuilder("[aliPay] vasType=");
                    stringBuilder2.append(i);
                    stringBuilder2.append(" ,orderType=");
                    stringBuilder2.append(toXLSdkOrderType);
                    stringBuilder2.append(" ,isKuaiNiaoMemberType=");
                    stringBuilder2.append(b);
                    if (toXLSdkOrderType == 1 && i.b(i) && b) {
                        i = 209;
                    }
                    com_xunlei_downloadprovider_member_payment_external_l_a.a(com.xunlei.downloadprovider.member.payment.a.a(i, toXLSdkOrderType), i2, str, a, this, null);
                    return;
                }
            }
            LoginHelper.a().a(LoginPageType.LOGIN_FLOAT, getApplicationContext(), new r(this, com_xunlei_downloadprovider_member_payment_external_l_a), LoginFrom.PAY_PAGE, 268435456, null);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected static boolean l() {
        j.a();
        if (com.xunlei.downloadprovider.member.login.b.l.b() && j.a().c()) {
            if (!(1 == j.a().a.g.f())) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void a(BasePayActivity basePayActivity, int i, String str, Object obj, int i2) {
        if (obj != null && basePayActivity.l == i2) {
            basePayActivity.j = (XLPayParam) obj;
            if (basePayActivity.j != null) {
                if (basePayActivity.e != null) {
                    if (i == 102) {
                        i = basePayActivity.j.getBizNo();
                        if (TextUtils.equals("1001", i) == null) {
                            if (TextUtils.equals("1006", i) == 0) {
                                i = 0;
                                if (i == 0) {
                                    basePayActivity.b(basePayActivity.getString(R.string.alipay_no_installed_tip));
                                    basePayActivity.j = null;
                                }
                                i = basePayActivity.j;
                                str = new XLAlertDialog(basePayActivity);
                                str.setConfirmButtonText((int) R.string.pay_alipay_uninstall_confirm_text);
                                str.setMessage((int) R.string.pay_alipay_uninstall_content_text);
                                str.setOnClickConfirmButtonListener(new c(i, basePayActivity, str));
                                str.show();
                                return;
                            }
                        }
                        i = 1;
                        if (i == 0) {
                            i = basePayActivity.j;
                            str = new XLAlertDialog(basePayActivity);
                            str.setConfirmButtonText((int) R.string.pay_alipay_uninstall_confirm_text);
                            str.setMessage((int) R.string.pay_alipay_uninstall_content_text);
                            str.setOnClickConfirmButtonListener(new c(i, basePayActivity, str));
                            str.show();
                            return;
                        }
                        basePayActivity.b(basePayActivity.getString(R.string.alipay_no_installed_tip));
                        basePayActivity.j = null;
                    } else if (i == 54) {
                        basePayActivity.b(basePayActivity.getString(R.string.wechat_no_installed_tip));
                        basePayActivity.j = null;
                    } else if (i != 0) {
                        basePayActivity.a(i, str, basePayActivity.j, basePayActivity.k, basePayActivity.e.h);
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(BasePayActivity basePayActivity, int i, XLAllContractResp xLAllContractResp, int i2) {
        basePayActivity.h.clear();
        if (i == 0 && xLAllContractResp != null && com.xunlei.xllib.b.d.a(xLAllContractResp.mContractedLists) == 0) {
            for (XLAllContractResp$ContractedResult xLAllContractResp$ContractedResult : xLAllContractResp.mContractedLists) {
                if (xLAllContractResp$ContractedResult != null) {
                    basePayActivity.h.add(xLAllContractResp$ContractedResult.bizno);
                }
            }
        }
        basePayActivity.a(i2);
    }

    static /* synthetic */ void a(BasePayActivity basePayActivity, int i, String str, int i2) {
        if (basePayActivity.s == i2 && basePayActivity.j != 0) {
            if (i != 0) {
                i = 53;
                str = basePayActivity.getResources().getString(R.string.pay_failed);
            } else if (basePayActivity.h.contains(basePayActivity.j.getBizNo()) == 0) {
                i2 = basePayActivity.h;
                CharSequence bizNo = basePayActivity.j.getBizNo();
                Object obj = TextUtils.equals("1001", bizNo) ? "baijin" : TextUtils.equals("1006", bizNo) ? "supervip" : "";
                if (i2.contains(obj) == 0) {
                    i = 51;
                }
            }
            basePayActivity.a(i, str, basePayActivity.j, basePayActivity.k, 2);
            basePayActivity.s = -1;
        }
    }
}
