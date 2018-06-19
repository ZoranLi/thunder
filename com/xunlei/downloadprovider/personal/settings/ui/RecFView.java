package com.xunlei.downloadprovider.personal.settings.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;

public class RecFView extends View {
    private int a;
    private int b;
    private RectF c;
    private Context d;
    private Paint e;
    private int f;

    public RecFView(Context context) {
        this(context, null);
    }

    public RecFView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecFView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.mRectView);
        this.f = attributeSet.getColor(0, 0);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setStyle(Style.FILL);
        this.e.setTextSize((float) DipPixelUtil.dip2px(15.0f));
        this.e.setColor(this.f);
        this.d = context;
        attributeSet.recycle();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        this.c = new RectF(0.0f, 0.0f, (float) this.a, (float) this.b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.c, (float) DipPixelUtil.dip2px(1.0f), (float) DipPixelUtil.dip2px(1.0f), this.e);
    }
}
