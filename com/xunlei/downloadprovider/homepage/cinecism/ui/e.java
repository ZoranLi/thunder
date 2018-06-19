package com.xunlei.downloadprovider.homepage.cinecism.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: CinecismCardView */
final class e extends ClickableSpan {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    e(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public final void onClick(View view) {
        this.b.a();
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
