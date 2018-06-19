package com.xunlei.downloadprovider.vod.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class VodNotifyLoadingCircle extends LinearLayout {
    public static final String a = "VodNotifyLoadingCircle";
    private TextView b;
    private ImageView c;
    private RotateAnimation d;

    @SuppressLint({"NewApi"})
    public VodNotifyLoadingCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public VodNotifyLoadingCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public VodNotifyLoadingCircle(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.d = new RotateAnimation(0.0f, 720.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.setDuration(1000);
        this.d.setRepeatCount(-1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (TextView) findViewById(R.id.tv_loading_text);
        this.c = (ImageView) findViewById(R.id.iv_loading);
        this.b.setBackgroundColor(0);
        this.b.setHighlightColor(0);
    }

    public String getLoadingText() {
        return this.b.getText().toString();
    }

    public void setLoadingText(CharSequence charSequence) {
        this.b.setText(charSequence);
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.setFocusable(true);
    }
}
