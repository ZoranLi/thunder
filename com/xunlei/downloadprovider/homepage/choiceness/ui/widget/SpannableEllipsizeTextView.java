package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

public class SpannableEllipsizeTextView extends TextView {
    public SpannableEllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpannableEllipsizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (getLineCount() > 2) {
            int lineVisibleEnd = getLayout().getLineVisibleEnd(1);
            if (text.length() > lineVisibleEnd) {
                CharSequence spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(text.subSequence(0, lineVisibleEnd));
                setText(spannableStringBuilder);
            }
        }
        super.onDraw(canvas);
    }
}
