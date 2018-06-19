package com.xunlei.downloadprovider.xlui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;

public class ZHTextView extends TextView {
    private b a;
    private CharSequence b;
    private boolean c = true;
    private float d = null;

    private static class a {
        public int a;
        public int b;

        private a() {
        }
    }

    private static class b {
        public ArrayList<a> a;
        public CharSequence b;
        public int c;
        public float d;

        private b() {
            this.a = new ArrayList();
            this.b = null;
        }
    }

    public ZHTextView(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public ZHTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, (int) null);
    }

    public ZHTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, (int) null);
    }

    @TargetApi(21)
    public ZHTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet, i2);
    }

    public float getTextIndentPadding() {
        return this.d;
    }

    public void setTextIndentPadding(float f) {
        this.d = f;
        if (VERSION.SDK_INT < 18 || isInLayout() == null) {
            requestLayout();
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        Exception exception;
        Exception e;
        int i2;
        Canvas canvas2;
        if (this.c) {
            int maxLines;
            int lineSpacingExtra;
            if (!(r1.b == null || r1.b.equals(r1.a.b))) {
                a(r1.b, r1.a.c);
                invalidate();
            }
            canvas.save();
            Paint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            int ascent = (int) paint.ascent();
            int descent = (int) paint.descent();
            int i3 = 0;
            if (VERSION.SDK_INT >= 16) {
                maxLines = getMaxLines();
                lineSpacingExtra = (int) getLineSpacingExtra();
            } else {
                maxLines = 1;
                lineSpacingExtra = 0;
            }
            int max = Math.max(0, Math.min(maxLines, r1.a.a.size()));
            int i4 = max - 1;
            int i5 = (-ascent) + descent;
            maxLines = (lineSpacingExtra * i4) + (i5 * max);
            descent = getGravity();
            if ((descent & 16) != 0) {
                descent = getPaddingTop() + ((((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - maxLines) / 2);
            } else if ((descent & 80) != 0) {
                descent = (getMeasuredHeight() - maxLines) - getPaddingBottom();
            } else {
                descent = getPaddingTop();
            }
            int i6 = descent;
            int i7 = getEllipsize() != null ? 1 : 0;
            if (r1.a.b != null) {
                int i8 = 0;
                while (i8 < max) {
                    a aVar = (a) r1.a.a.get(i8);
                    float paddingLeft = (float) getPaddingLeft();
                    if (i8 == 0) {
                        paddingLeft += r1.a.d;
                    }
                    float f = paddingLeft;
                    if (i7 != 0 && i8 == i4) {
                        try {
                            if (getMeasuredWidth() != 0 && r1.a.a.size() > max) {
                                String str;
                                CharSequence charSequence = r1.a.b;
                                if (getMeasuredWidth() <= 0) {
                                    try {
                                        str = "";
                                        i = max;
                                        max = i3;
                                    } catch (Exception e2) {
                                        exception = e2;
                                        i2 = i8;
                                        i = max;
                                        max = i3;
                                        canvas2 = canvas;
                                        exception.printStackTrace();
                                        i8 = i2 + 1;
                                        i3 = max;
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
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        canvas2 = canvas;
                                        i = max;
                                        max = 0;
                                        exception = e2;
                                        i2 = i8;
                                        exception.printStackTrace();
                                        i8 = i2 + 1;
                                        i3 = max;
                                        max = i;
                                    }
                                    try {
                                        stringBuilder.append(str2.substring(aVar.a, aVar.b));
                                        stringBuilder.append("....");
                                        stringBuilder.append(str3);
                                        String stringBuilder2 = stringBuilder.toString();
                                        max = aVar.b;
                                        while (true) {
                                            Paint paint3 = paint2;
                                            if (paint2.measureText(stringBuilder2) <= ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                                                break;
                                            }
                                            try {
                                                i3 = 0;
                                                try {
                                                    stringBuilder.delete(0, stringBuilder.length());
                                                    stringBuilder.append(str2.substring(aVar.a, max));
                                                    stringBuilder.append("....");
                                                    stringBuilder.append(str3);
                                                    max--;
                                                    stringBuilder2 = stringBuilder.toString();
                                                    paint2 = paint3;
                                                } catch (Exception e22) {
                                                    exception = e22;
                                                    i2 = i8;
                                                }
                                            } catch (Exception e222) {
                                                canvas2 = canvas;
                                                exception = e222;
                                                i2 = i8;
                                                max = 0;
                                            }
                                        }
                                        max = 0;
                                        str = stringBuilder2;
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        canvas2 = canvas;
                                        max = 0;
                                        exception = e222;
                                        i2 = i8;
                                        exception.printStackTrace();
                                        i8 = i2 + 1;
                                        i3 = max;
                                        max = i;
                                    }
                                }
                                try {
                                    canvas.drawText(str, f, (float) (((i6 - ascent) + (i8 * lineSpacingExtra)) + (i8 * i5)), paint);
                                    i2 = i8;
                                } catch (Exception e5) {
                                    e222 = e5;
                                    exception = e222;
                                    i2 = i8;
                                    exception.printStackTrace();
                                    i8 = i2 + 1;
                                    i3 = max;
                                    max = i;
                                }
                                i8 = i2 + 1;
                                i3 = max;
                                max = i;
                            }
                        } catch (Exception e6) {
                            e222 = e6;
                            i = max;
                            max = i3;
                            canvas2 = canvas;
                            exception = e222;
                            i2 = i8;
                            exception.printStackTrace();
                            i8 = i2 + 1;
                            i3 = max;
                            max = i;
                        }
                    }
                    i = max;
                    max = i3;
                    try {
                        i2 = i8;
                        try {
                            canvas.drawText(r1.a.b, aVar.a, aVar.b, f, (float) (((i6 - ascent) + (i8 * lineSpacingExtra)) + (i8 * i5)), paint);
                        } catch (Exception e7) {
                            e222 = e7;
                            exception = e222;
                            exception.printStackTrace();
                            i8 = i2 + 1;
                            i3 = max;
                            max = i;
                        }
                    } catch (Exception e8) {
                        e222 = e8;
                        i2 = i8;
                        exception = e222;
                        exception.printStackTrace();
                        i8 = i2 + 1;
                        i3 = max;
                        max = i;
                    }
                    i8 = i2 + 1;
                    i3 = max;
                    max = i;
                }
            }
            canvas2 = canvas;
            canvas.restore();
            return;
        }
        canvas2 = canvas;
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        if (this.c) {
            Object obj;
            int maxLines;
            float lineSpacingExtra;
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
            if (VERSION.SDK_INT >= 16) {
                maxLines = getMaxLines();
                lineSpacingExtra = getLineSpacingExtra();
            } else {
                lineSpacingExtra = 0.0f;
                maxLines = 1;
            }
            if (mode != 1073741824) {
                float f = (-ascent) + descent;
                textIndentPadding = (int) ((((float) getPaddingTop()) + f) + ((float) getPaddingBottom()));
                size = Math.max(0, Math.min(size, maxLines));
                size = (int) ((((f * ((float) size)) + (((float) (size - 1)) * lineSpacingExtra)) + ((float) getPaddingTop())) + ((float) getPaddingBottom()));
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

    private void a(AttributeSet attributeSet, int i) {
        attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.ZHTextView, i, 0);
        this.d = attributeSet.getDimension(0, this.d);
        attributeSet.recycle();
        this.b = getText();
        this.a = new b();
        this.a.b = getText();
        this.a.d = this.d;
        if (this.d > 0 && VERSION.SDK_INT >= 18 && isInLayout() == null) {
            requestLayout();
        }
        invalidate();
    }

    private void a(CharSequence charSequence, int i) {
        if (i > 0) {
            if (charSequence != null) {
                b bVar = this.a;
                bVar.a.clear();
                bVar.b = null;
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
                    a aVar = new a();
                    aVar.a = i4;
                    i4 += i2;
                    aVar.b = i4;
                    this.a.a.add(aVar);
                    i5++;
                }
            }
        }
    }

    public int getCurrentLineNum() {
        return this.a != null ? this.a.a.size() : 0;
    }
}
