package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class HintAnimEditText extends AppCompatEditText {
    float a;
    private CharSequence b = "";
    private Paint c;
    private float d;
    private float e;

    public HintAnimEditText(Context context) {
        super(context);
        a();
    }

    public HintAnimEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HintAnimEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setColor(Color.rgb(90, 100, 115));
        this.c.setTextSize(getTextSize());
        this.c.setTextAlign(Align.CENTER);
        setLongClickable(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float compoundPaddingLeft = (float) getCompoundPaddingLeft();
        this.d = getPaint().measureText(this.b.toString());
        canvas.drawText(this.b.toString(), compoundPaddingLeft + (this.d / 2.0f), ((float) getLineBounds(0, null)) + this.e, this.c);
    }

    public void setHintString(CharSequence charSequence) {
        this.b = charSequence;
        this.d = getPaint().measureText(this.b.toString());
        invalidate();
    }
}
