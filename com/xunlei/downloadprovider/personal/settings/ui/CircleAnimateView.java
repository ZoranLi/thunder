package com.xunlei.downloadprovider.personal.settings.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class CircleAnimateView extends View {
    public int a;
    private Paint b;
    private float c;
    private int d;

    public CircleAnimateView(Context context) {
        super(context);
        a(context);
    }

    public CircleAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.FILL);
        this.b.setColor(context.getResources().getColor(R.color.blue));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = getMeasuredWidth();
    }

    protected void onDraw(Canvas canvas) {
        StringBuilder stringBuilder = new StringBuilder("onDraw width=");
        stringBuilder.append(this.d);
        stringBuilder.append(",height=");
        stringBuilder.append(this.a);
        stringBuilder.append(",transtion=");
        stringBuilder.append(this.c);
        float f = 0.0f;
        if (((double) this.c) < 0.5d) {
            this.b.setAlpha((int) ((1.0f - (this.c * 3.5f) >= 0.0f ? 1.0f - (this.c * 3.5f) : 0.0f) * 255.0f));
            int dip2px = DipPixelUtil.dip2px(15.0f);
            float f2 = (float) dip2px;
            canvas.drawCircle(((((float) ((this.d / 2) - dip2px)) * this.c) * 3.0f) + f2, ((float) this.a) - (((float) (this.a / 2)) * (this.c * 3.0f > 1.0f ? 1.0f : this.c * 3.0f)), f2, this.b);
            canvas.drawCircle((float) (this.d / 2), ((float) this.a) - (((float) (this.a / 2)) * this.c), (float) DipPixelUtil.dip2px(5.0f), this.b);
            canvas.drawCircle((((float) this.d) * 0.8f) - (((((float) this.d) * 0.8f) - ((float) (this.d / 2))) * this.c), (((float) this.a) * 0.8f) - (((0.8f * ((float) this.a)) - ((float) (this.a / 2))) * this.c), (float) DipPixelUtil.dip2px(6.0f), this.b);
            if (1.0f - (this.c * 3.0f) >= 0.0f) {
                f = 1.0f - (this.c * 3.0f);
            }
            this.b.setAlpha((int) (255.0f * f));
            canvas.drawCircle(((float) this.d) - ((((float) (this.d - (this.d / 2))) * this.c) * 2.5f), (((float) this.a) * 0.75f) - ((((0.75f * ((float) this.a)) - ((float) (this.a / 2))) * this.c) * 2.5f), (float) DipPixelUtil.dip2px(7.0f), this.b);
            canvas.drawCircle((((float) (this.d / 2)) * this.c) * 2.5f, (float) (this.a / 2), (float) DipPixelUtil.dip2px(6.0f), this.b);
        } else if (((double) this.c) < 0.7d) {
            new StringBuilder("drawUpCircle transtion=").append(this.c);
            this.b.setAlpha((int) (255.0f * (1.0f - ((this.c - PayBaseConstants.HALF_OF_FLOAT) * 3.0f))));
            canvas.drawCircle((((float) this.d) * 0.25f) + (((((float) this.d) * 0.25f) * (this.c - PayBaseConstants.HALF_OF_FLOAT)) * 3.5f), (0.125f * ((float) this.a)) + ((((((float) this.a) * 2.0f) / 5.0f) * (this.c - PayBaseConstants.HALF_OF_FLOAT)) * 3.5f), (float) DipPixelUtil.dip2px(9.0f), this.b);
            canvas.drawCircle((0.75f * ((float) this.d)) - (((0.25f * ((float) this.d)) * (this.c - PayBaseConstants.HALF_OF_FLOAT)) * 3.5f), (0.125f * ((float) this.a)) + ((((((float) this.a) * 2.0f) / 5.0f) * (this.c - PayBaseConstants.HALF_OF_FLOAT)) * 3.5f), (float) DipPixelUtil.dip2px(8.0f), this.b);
        } else {
            new StringBuilder("drawFinalCircle transtion=").append(this.c);
            if (1.0d - (((double) (this.c - 0.7f)) * 3.5d) >= 0.0d) {
                f = 1.0f - ((this.c - 0.7f) * 3.5f);
            }
            this.b.setAlpha((int) (255.0f * f));
            canvas.drawCircle((0.875f * ((float) this.d)) - (((0.375f * ((float) this.d)) * (this.c - 0.7f)) * 3.5f), (0.0625f * ((float) this.a)) + ((((((float) this.a) * 1.0f) / 2.0f) * (this.c - 0.7f)) * 3.5f), (float) DipPixelUtil.dip2px(10.0f), this.b);
        }
    }

    public void setTranstion(float f) {
        this.c = f;
    }

    public final void setWidthAndHeight$255f295(int i) {
        this.a = i;
    }
}
