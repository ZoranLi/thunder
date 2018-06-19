package com.xunlei.downloadprovider.publiser.campaign;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/* compiled from: TopicUtil */
final class q extends ClickableSpan {
    final /* synthetic */ TextView a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;

    q(TextView textView, String str, String str2, int i) {
        this.a = textView;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public final void onClick(View view) {
        TopicDetailActivity.a(this.a.getContext(), this.b, this.c);
        p.a(this.b, this.c);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.d);
    }
}
