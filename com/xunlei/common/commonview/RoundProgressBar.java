package com.xunlei.common.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.common.R;

public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private long max;
    private RectF oval;
    private Paint paint;
    private long progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private String text;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.RoundProgressBar);
        this.roundColor = context.getColor(R.styleable.RoundProgressBar_rPbarColor, Color.rgb(239, 241, 247));
        this.roundProgressColor = context.getColor(R.styleable.RoundProgressBar_rPbarProgressColor, Color.rgb(91, Opcodes.FLOAT_TO_DOUBLE, 254));
        this.textColor = context.getColor(R.styleable.RoundProgressBar_rPbarTextColor, Color.rgb(255, 255, 255));
        this.textSize = context.getDimension(R.styleable.RoundProgressBar_rPbarTextSize, 1092616192);
        this.roundWidth = context.getDimension(R.styleable.RoundProgressBar_rPbarWidth, 1094713344);
        this.max = (long) context.getInteger(R.styleable.RoundProgressBar_rPbarMax, 100);
        this.textIsDisplayable = context.getBoolean(R.styleable.RoundProgressBar_rPbarTextIsDisplayable, 1);
        this.style = context.getInt(R.styleable.RoundProgressBar_rPbarStyle, 0);
        this.progress = (long) context.getInt(R.styleable.RoundProgressBar_rPbarProgress, 0);
        setProgress(this.progress);
        context.recycle();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = (float) width;
        int i = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setColor(this.roundColor);
        this.paint.setStyle(Style.STROKE);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(f, f, (float) i, this.paint);
        new StringBuilder().append(width);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT);
        if (this.max > 0) {
            int i2 = (int) ((((float) this.progress) / ((float) this.max)) * 100.0f);
            if (!TextUtils.isEmpty(this.text)) {
                canvas.drawText(this.text, f - (this.paint.measureText(this.text) / 2.0f), f + (this.textSize / 2.0f), this.paint);
            } else if (this.textIsDisplayable && i2 != 0 && this.style == 0) {
                Paint paint = this.paint;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i2);
                stringBuilder.append("%");
                float measureText = paint.measureText(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(i2);
                stringBuilder.append("%");
                canvas.drawText(stringBuilder.toString(), f - (measureText / 2.0f), f + (this.textSize / 2.0f), this.paint);
            }
            this.paint.setStrokeWidth(this.roundWidth);
            this.paint.setColor(this.roundProgressColor);
            if (this.oval == null) {
                float f2 = (float) (width - i);
                float f3 = (float) (width + i);
                this.oval = new RectF(f2, f2, f3, f3);
            }
            switch (this.style) {
                case 0:
                    this.paint.setStyle(Style.STROKE);
                    canvas.drawArc(this.oval, -90.0f, (float) ((360 * this.progress) / this.max), false, this.paint);
                    return;
                case 1:
                    this.paint.setStyle(Style.FILL_AND_STROKE);
                    if (this.progress != 0) {
                        canvas.drawArc(this.oval, -90.0f, (float) ((360 * this.progress) / this.max), true, this.paint);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized long getMax() {
        return this.max;
    }

    public synchronized void setMax(long j) {
        if (j < 0) {
            j = 0;
        }
        this.max = j;
    }

    public synchronized long getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(long j) {
        if (j < 0) {
            j = 0;
        }
        if (j > this.max) {
            j = this.max;
        }
        if (j <= this.max) {
            this.progress = j;
            postInvalidate();
        }
    }

    public int getCricleColor() {
        return this.roundColor;
    }

    public void setCricleColor(int i) {
        this.roundColor = i;
    }

    public int getCricleProgressColor() {
        return this.roundProgressColor;
    }

    public void setCricleProgressColor(int i) {
        this.roundProgressColor = i;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getRoundWidth() {
        return this.roundWidth;
    }

    public void setRoundWidth(float f) {
        this.roundWidth = f;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
        postInvalidate();
    }
}
