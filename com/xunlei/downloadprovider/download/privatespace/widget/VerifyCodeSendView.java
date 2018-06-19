package com.xunlei.downloadprovider.download.privatespace.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.download.privatespace.widget.CountDownView.a;

public class VerifyCodeSendView extends CountDownView {
    public VerifyCodeSendView(Context context) {
        this(context, null, 0);
    }

    public VerifyCodeSendView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerifyCodeSendView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMaxCountDown(60);
        setText("获取验证码");
        setICountDownCallback(new b(this));
    }

    public final void setICountDownCallback(a aVar) {
        super.setICountDownCallback(aVar);
    }
}
