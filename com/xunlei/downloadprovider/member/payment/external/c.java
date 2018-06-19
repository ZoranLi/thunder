package com.xunlei.downloadprovider.member.payment.external;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: NoLineClickableSpan */
public class c extends ClickableSpan {
    public void onClick(View view) {
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
