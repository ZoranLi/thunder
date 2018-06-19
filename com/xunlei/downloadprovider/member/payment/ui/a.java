package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Handler;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.xllib.android.b;

/* compiled from: ActivationActivity */
final class a extends Handler {
    final /* synthetic */ ActivationActivity a;

    a(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case SecExceptionCode.SEC_ERROR_UMID_NETWORK_ERROR /*904*/:
                this.a.i.setVisibility(8);
                if (message.obj == null) {
                    this.a.e.setImageDrawable(null);
                    if (b.a(this.a.getApplicationContext()) == null) {
                        XLToast.showToast(this.a.getApplicationContext(), this.a.getResources().getString(R.string.sett_no_net));
                        return;
                    } else {
                        XLToast.showToast(this.a.getApplicationContext(), "获取验证码失败");
                        return;
                    }
                }
                this.a.k = (com.xunlei.downloadprovider.member.e.a) message.obj;
                if (this.a.k != null) {
                    this.a.e.setImageBitmap(this.a.k.a);
                    return;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UMID_SERVER_RESP_INVALID /*905*/:
                d.a("pay_key_success", this.a.n);
                LoginHelper.a().a(this.a.q);
                LoginHelper.a().b();
                i.e(LoginHelper.a().q);
                return;
            case SecExceptionCode.SEC_ERROR_UMID_ENVIRONMENT_CHANGED /*906*/:
                this.a.a();
                this.a.d.setText("");
                this.a.l = (String) message.obj;
                if (this.a.l != null) {
                    this.a.l = this.a.l.replace("兑换码", "激活码");
                    if (this.a.l.contains("激活码") != null) {
                        this.a.o = false;
                    }
                }
                this.a.b();
                XLToast.showToast(this.a.getApplicationContext(), this.a.l);
                break;
            default:
                break;
        }
    }
}
