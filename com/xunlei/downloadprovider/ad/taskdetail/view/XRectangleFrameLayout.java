package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.xunlei.downloadprovider.R;

public class XRectangleFrameLayout extends FrameLayout {
    private final float a;
    private float b;

    public XRectangleFrameLayout(Context context) {
        this(context, null);
    }

    public XRectangleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRectangleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.0f;
        this.b = 1.0f;
        context = context.obtainStyledAttributes(attributeSet, R.styleable.XRectangleFrameLayout);
        this.b = context.getFloat(null, 1.0f);
        if (this.b < 0.0f) {
            this.b = 1.0f;
        }
        new StringBuilder("mRatio: ").append(this.b);
        context.recycle();
    }

    public void setRatio(int i) {
        this.b = (float) i;
    }

    protected void onMeasure(int i, int i2) {
        i = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        MeasureSpec.getSize(i2);
        i = (i - getPaddingLeft()) - getPaddingRight();
        i2 = (int) (((float) i) / this.b);
        super.onMeasure(MeasureSpec.makeMeasureSpec((i + getPaddingLeft()) + getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((i2 + getPaddingTop()) + getPaddingBottom(), 1073741824));
    }
}
