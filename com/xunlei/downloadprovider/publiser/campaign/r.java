package com.xunlei.downloadprovider.publiser.campaign;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.shortvideo.entity.AudioInfo;

/* compiled from: TopicUtil */
final class r extends ClickableSpan {
    final /* synthetic */ AudioInfo a;
    final /* synthetic */ TextView b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;

    r(AudioInfo audioInfo, TextView textView, String str, int i) {
        this.a = audioInfo;
        this.b = textView;
        this.c = str;
        this.d = i;
    }

    public final void onClick(View view) {
        if (this.a != null) {
            TopicDetailActivity.a(this.b.getContext(), 2, this.a.a, this.a.b, this.c);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.d);
    }
}
