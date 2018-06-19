package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;

public class ZHTextViewExpandable extends TextView {
    private c a;
    private CharSequence b;
    private int c = 2;
    private a d;
    private boolean e = true;
    private float f = null;

    public interface a {
        void b();
    }

    private static class b {
        public int a;
        public int b;

        private b() {
        }
    }

    private static class c {
        public ArrayList<b> a;
        public CharSequence b;
        public int c;
        public float d;

        private c() {
            this.a = new ArrayList();
            this.b = null;
        }
    }

    public int getMaxLine() {
        return this.c;
    }

    public void setMaxLine(int i) {
        this.c = i;
        invalidate();
        requestLayout();
    }

    public a getListener() {
        return this.d;
    }

    public void setListener(a aVar) {
        this.d = aVar;
    }

    public ZHTextViewExpandable(Context context) {
        super(context);
        a();
    }

    public ZHTextViewExpandable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ZHTextViewExpandable(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public float getTextIndentPadding() {
        return this.f;
    }

    public void setTextIndentPadding(float f) {
        this.f = f;
        if (VERSION.SDK_INT < 18 || isInLayout() == null) {
            requestLayout();
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        Exception exception;
        Exception e;
        Canvas canvas2;
        if (this.e) {
            if (!(r1.b == null || r1.b.equals(r1.a.b))) {
                a(r1.b, r1.a.c);
                invalidate();
            }
            canvas.save();
            Paint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            int ascent = (int) paint.ascent();
            int descent = (int) paint.descent();
            int maxLine = getMaxLine();
            int i2 = 0;
            int lineSpacingExtra = VERSION.SDK_INT >= 16 ? (int) getLineSpacingExtra() : 0;
            int max = Math.max(0, Math.min(maxLine, r1.a.a.size()));
            getGravity();
            int paddingTop = getPaddingTop();
            int i3 = getEllipsize() != null ? 1 : 0;
            if (r1.a.b != null) {
                int i4 = 0;
                while (i4 < max) {
                    b bVar = (b) r1.a.a.get(i4);
                    float paddingLeft = (float) getPaddingLeft();
                    if (i4 == 0) {
                        paddingLeft += r1.a.d;
                    }
                    float f = paddingLeft;
                    if (i3 != 0 && i4 == max - 1) {
                        try {
                            if (getMeasuredWidth() != 0 && r1.a.a.size() > max) {
                                String str;
                                CharSequence charSequence = r1.a.b;
                                if (getMeasuredWidth() <= 0) {
                                    try {
                                        i = max;
                                        max = i2;
                                        str = "";
                                    } catch (Exception e2) {
                                        exception = e2;
                                        i = max;
                                        max = i2;
                                        i2 = i4;
                                        exception.printStackTrace();
                                        i4 = i2 + 1;
                                        i2 = max;
                                        max = i;
                                    }
                                } else {
                                    String str2;
                                    String str3 = "";
                                    Paint paint2 = getPaint();
                                    if (charSequence == null) {
                                        str2 = "";
                                    } else {
                                        str2 = String.valueOf(charSequence);
                                    }
                                    StringBuilder stringBuilder = new StringBuilder();
                                    try {
                                        i = max;
                                        try {
                                            stringBuilder.append(str2.substring(bVar.a, bVar.b));
                                            stringBuilder.append("....");
                                            stringBuilder.append(str3);
                                            str = stringBuilder.toString();
                                            max = bVar.b;
                                            while (true) {
                                                Paint paint3 = paint2;
                                                if (paint2.measureText(str) <= ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                                                    break;
                                                }
                                                try {
                                                    i2 = 0;
                                                    try {
                                                        stringBuilder.delete(0, stringBuilder.length());
                                                        stringBuilder.append(str2.substring(bVar.a, max));
                                                        stringBuilder.append("....");
                                                        stringBuilder.append(str3);
                                                        max--;
                                                        str = stringBuilder.toString();
                                                        paint2 = paint3;
                                                    } catch (Exception e22) {
                                                        exception = e22;
                                                    }
                                                } catch (Exception e222) {
                                                    exception = e222;
                                                    i2 = i4;
                                                    max = 0;
                                                }
                                            }
                                            max = 0;
                                        } catch (Exception e3) {
                                            e222 = e3;
                                            canvas2 = canvas;
                                            max = 0;
                                            exception = e222;
                                            i2 = i4;
                                            exception.printStackTrace();
                                            i4 = i2 + 1;
                                            i2 = max;
                                            max = i;
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        canvas2 = canvas;
                                        i = max;
                                        max = 0;
                                        exception = e222;
                                        i2 = i4;
                                        exception.printStackTrace();
                                        i4 = i2 + 1;
                                        i2 = max;
                                        max = i;
                                    }
                                }
                                try {
                                    canvas.drawText(str, f, (float) (((paddingTop - ascent) + (i4 * lineSpacingExtra)) + (((-ascent) + descent) * i4)), paint);
                                    i2 = i4;
                                } catch (Exception e5) {
                                    e222 = e5;
                                    exception = e222;
                                    i2 = i4;
                                    exception.printStackTrace();
                                    i4 = i2 + 1;
                                    i2 = max;
                                    max = i;
                                }
                                i4 = i2 + 1;
                                i2 = max;
                                max = i;
                            }
                        } catch (Exception e6) {
                            e222 = e6;
                            canvas2 = canvas;
                            i = max;
                            max = i2;
                            exception = e222;
                            i2 = i4;
                            exception.printStackTrace();
                            i4 = i2 + 1;
                            i2 = max;
                            max = i;
                        }
                    }
                    i = max;
                    max = i2;
                    try {
                        i2 = i4;
                        try {
                            canvas.drawText(r1.a.b, bVar.a, bVar.b, f, (float) (((paddingTop - ascent) + (i4 * lineSpacingExtra)) + (((-ascent) + descent) * i4)), paint);
                        } catch (Exception e7) {
                            e222 = e7;
                            exception = e222;
                            exception.printStackTrace();
                            i4 = i2 + 1;
                            i2 = max;
                            max = i;
                        }
                    } catch (Exception e8) {
                        e222 = e8;
                        i2 = i4;
                        exception = e222;
                        exception.printStackTrace();
                        i4 = i2 + 1;
                        i2 = max;
                        max = i;
                    }
                    i4 = i2 + 1;
                    i2 = max;
                    max = i;
                }
            }
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        if (this.e) {
            Object obj;
            CharSequence charSequence = this.b;
            Paint paint = getPaint();
            if (charSequence == null) {
                obj = "";
            } else {
                obj = String.valueOf(charSequence);
            }
            int mode = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            int textIndentPadding = !TextUtils.isEmpty(obj) ? (int) (((getTextIndentPadding() + paint.measureText(obj)) + ((float) getPaddingLeft())) + ((float) getPaddingRight())) : 0;
            if (mode != 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                    i = Math.min(textIndentPadding, i);
                } else {
                    i = textIndentPadding;
                }
            }
            a(charSequence, (i - getPaddingLeft()) - getPaddingRight());
            int size = this.a.a.size();
            paint = getPaint();
            mode = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            float ascent = paint.ascent();
            float descent = paint.descent();
            int maxLine = getMaxLine();
            float f = 0.0f;
            if (VERSION.SDK_INT >= 16) {
                f = getLineSpacingExtra();
            }
            if (mode != 1073741824) {
                float f2 = (-ascent) + descent;
                textIndentPadding = (int) ((((float) getPaddingTop()) + f2) + ((float) getPaddingBottom()));
                size = Math.max(0, Math.min(size, maxLine));
                size = (int) ((((f2 * ((float) size)) + (((float) (size - 1)) * f)) + ((float) getPaddingTop())) + ((float) getPaddingBottom()));
                if (i2 != 0) {
                    if (mode != Integer.MIN_VALUE) {
                        i2 = Math.min(size, i2);
                    }
                }
                i2 = Math.max(size, textIndentPadding);
            }
            setMeasuredDimension(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.b = getText();
        if (VERSION.SDK_INT >= 18 && isInLayout() == null) {
            requestLayout();
        }
        invalidate();
    }

    private void a() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ZHTextView, 0, 0);
        this.f = obtainStyledAttributes.getDimension(0, this.f);
        obtainStyledAttributes.recycle();
        this.b = getText();
        this.a = new c();
        this.a.b = getText();
        this.a.d = this.f;
        if (this.f > 0.0f && VERSION.SDK_INT >= 18 && !isInLayout()) {
            requestLayout();
        }
        invalidate();
    }

    public int getLineCount() {
        return this.a != null ? this.a.a.size() : 0;
    }

    private void a(CharSequence charSequence, int i) {
        if (i > 0) {
            if (charSequence != null) {
                c cVar = this.a;
                cVar.a.clear();
                cVar.b = null;
                this.a.b = charSequence;
                this.a.c = i;
                this.a.d = getTextIndentPadding();
                Paint paint = getPaint();
                int length = charSequence.length();
                int i2 = (int) (((float) i) - this.a.d);
                int i3 = i2 <= 0 ? i : i2;
                int i4 = 0;
                int i5 = i4;
                while (i4 < length) {
                    i2 = paint.breakText(charSequence, i4, length, true, (float) (i5 == 0 ? i3 : i), null);
                    if (i2 <= 0) {
                        break;
                    }
                    b bVar = new b();
                    bVar.a = i4;
                    i4 += i2;
                    bVar.b = i4;
                    this.a.a.add(bVar);
                    i5++;
                }
                new StringBuilder(" lineCount----: ").append(this.a.a.size());
                if (this.d != null) {
                    charSequence = this.d;
                    this.a.a.size();
                    charSequence.b();
                }
            }
        }
    }
}
