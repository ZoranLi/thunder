package com.xunlei.downloadprovider.vod.speedplayback;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

public class VodSpeedRateTextView extends AppCompatTextView {
    public VodSpeedRateTextView(Context context) {
        this(context, null, 0);
    }

    public VodSpeedRateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VodSpeedRateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRate(VodSpeedRate vodSpeedRate) {
        if (vodSpeedRate == null) {
            vodSpeedRate = "倍速VIP";
            CharSequence spannableStringBuilder = new SpannableStringBuilder(vodSpeedRate);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF733B")), 2, vodSpeedRate.length(), 33);
            setText(spannableStringBuilder);
            return;
        }
        setText(vodSpeedRate.getRateDescription());
    }
}
