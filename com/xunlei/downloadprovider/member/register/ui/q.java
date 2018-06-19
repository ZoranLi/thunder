package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.p;
import com.xunlei.downloadprovider.member.register.a;

/* compiled from: BindMobileActivity */
final class q extends p {
    final /* synthetic */ BindMobileActivity a;

    q(BindMobileActivity bindMobileActivity) {
        this.a = bindMobileActivity;
    }

    public final boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2) {
        str2 = new StringBuilder("onUserAdSendMessage() errorCode=");
        str2.append(i);
        str2.append(" errorDesc=");
        str2.append(str);
        this.a.h();
        if (i == 0) {
            a.a("success", i);
            this.a.j();
            i = this.a;
            i.a(i.getString(R.string.bind_mobile_input_msg_verify_code));
        } else {
            a.a("fail", i);
            if (i != XLErrorCode.AQ_BINDED_MOBILE_ERROR) {
                this.a.a((int) R.string.bind_mobile_send_msg_verify_code_fail);
            } else {
                this.a.a((int) R.string.bind_mobile_number_already_bind);
            }
        }
        return false;
    }

    public final boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2) {
        str2 = new StringBuilder("onUserAqBindMobile() errorCode=");
        str2.append(i);
        str2.append(" errorDesc=");
        str2.append(str);
        this.a.h();
        if (i != 0) {
            a.b("fail", i);
            switch (i) {
                case XLErrorCode.AQ_USER_VERIFY_CODE_ERROR /*16781270*/:
                    this.a.a((int) R.string.bind_mobile_verify_err_incorrect);
                    break;
                case XLErrorCode.AQ_HAD_MOBILE_ERROR /*16781278*/:
                    this.a.a((int) R.string.bind_mobile_account_already_bind_phone);
                    break;
                case XLErrorCode.AQ_BINDED_MOBILE_ERROR /*16781279*/:
                    this.a.a((int) R.string.bind_mobile_number_already_bind);
                    break;
                case XLErrorCode.AQ_SEND_MESSAGE_ERROR /*16781281*/:
                    this.a.a((int) R.string.bind_mobile_verify_err_msg);
                    break;
                default:
                    this.a.a((int) R.string.bind_mobile_fail);
                    break;
            }
        }
        a.b("success", i);
        this.a.finish();
        return false;
    }
}
