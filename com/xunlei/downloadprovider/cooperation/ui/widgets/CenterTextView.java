package com.xunlei.downloadprovider.cooperation.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class CenterTextView extends TextView {
    private StaticLayout a;
    private TextPaint b;

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b = new TextPaint(1);
        this.b.setTextSize(getTextSize());
        this.b.setColor(getCurrentTextColor());
        this.a = new StaticLayout(getText(), this.b, getWidth(), Alignment.ALIGN_CENTER, 1.2f, 0.0f, false);
    }

    protected void onDraw(Canvas canvas) {
        this.a.draw(canvas);
    }
}
