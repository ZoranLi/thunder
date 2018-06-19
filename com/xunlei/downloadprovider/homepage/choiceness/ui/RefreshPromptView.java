package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;

public class RefreshPromptView extends TextView {
    private Handler a = new Handler();
    private ObjectAnimator b;
    private Runnable c = new aa(this);

    public RefreshPromptView(Context context) {
        super(context);
    }

    public RefreshPromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RefreshPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(int i) {
        this.a.removeCallbacks(this.c);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" 条内容更新");
        CharSequence stringBuilder2 = stringBuilder.toString();
        i = String.valueOf(i);
        int indexOf = stringBuilder2.indexOf(i);
        if (indexOf >= 0) {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(stringBuilder2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1294f6")), indexOf, i.length() + indexOf, 34);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(DipPixelUtil.sp2pix(14.0f)), indexOf, i.length() + indexOf, 34);
            setText(spannableStringBuilder);
            b();
            this.a.postDelayed(this.c, 1600);
        }
    }

    public final void a(String str) {
        this.a.removeCallbacks(this.c);
        setText(str);
        b();
        this.a.postDelayed(this.c, 1600);
    }

    public final void a() {
        this.a.removeCallbacks(this.c);
        if (this.b != null && this.b.isRunning()) {
            this.b.cancel();
        }
        this.b = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{getTranslationY(), (float) (-getHeight())});
        this.b.setDuration(400);
        this.b.start();
    }

    private void b() {
        if (this.b != null && this.b.isRunning()) {
            this.b.cancel();
        }
        this.b = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{getTranslationY(), 0.0f});
        this.b.setDuration(400);
        this.b.start();
    }
}
