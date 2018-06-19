package com.xunlei.downloadprovider.download.privatespace.widget;

import com.xunlei.downloadprovider.download.privatespace.widget.CountDownView.a;

/* compiled from: VerifyCodeSendView */
final class b implements a {
    final /* synthetic */ VerifyCodeSendView a;

    b(VerifyCodeSendView verifyCodeSendView) {
        this.a = verifyCodeSendView;
    }

    public final void a(long j) {
        this.a.setText(String.format("%s秒后重新获取", new Object[]{Long.valueOf(j)}));
    }

    public final void a() {
        this.a.setText("获取验证码");
    }
}
