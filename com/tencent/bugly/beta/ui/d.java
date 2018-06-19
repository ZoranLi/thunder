package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.c;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
public class d implements OnPreDrawListener {
    final int a;
    final Object[] b;
    long c;
    StringBuilder d = new StringBuilder("loading");

    public d(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    public boolean onPreDraw() {
        boolean z = false;
        try {
            int i;
            switch (this.a) {
                case 1:
                    h hVar = (h) r1.b[0];
                    TextView textView = (TextView) r1.b[1];
                    Bitmap bitmap = (Bitmap) r1.b[2];
                    int intValue = ((Integer) r1.b[3]).intValue();
                    int measuredWidth = textView.getMeasuredWidth();
                    i = (int) (0.42857142857142855d * ((double) measuredWidth));
                    textView.setHeight(i);
                    if (hVar.u == null) {
                        if (intValue == 2) {
                            hVar.u = a.a(bitmap, measuredWidth, i, (float) a.a(e.E.s, 6.0f));
                        } else {
                            hVar.u = a.a(bitmap, measuredWidth, i, (float) a.a(e.E.s, 0.0f));
                        }
                        if (hVar.u != null) {
                            textView.setText("");
                            textView.setBackgroundDrawable(hVar.u);
                            textView.getViewTreeObserver().removeOnPreDrawListener(r1);
                            return true;
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - r1.c > 300) {
                        r1.c = currentTimeMillis;
                        if (r1.d.length() > 9) {
                            r1.d = new StringBuilder("loading");
                        } else {
                            r1.d.append(".");
                        }
                        textView.setText(r1.d.toString());
                    }
                    return true;
                case 2:
                    if (((Integer) r1.b[2]).intValue() > 0) {
                        int intValue2 = ((Integer) r1.b[0]).intValue();
                        TextView textView2 = (TextView) r1.b[1];
                        i = textView2.getMeasuredWidth();
                        int measuredHeight = textView2.getMeasuredHeight();
                        int i2 = (int) (((float) (e.E.B.widthPixels * e.E.B.heightPixels)) * 0.4f);
                        if (!(i == 0 || measuredHeight == 0 || i * measuredHeight > i2)) {
                            int i3;
                            r1.b[2] = Integer.valueOf(0);
                            Paint paint = new Paint();
                            paint.setStyle(Style.FILL);
                            paint.setAntiAlias(true);
                            if (intValue2 == 2) {
                                intValue2 = 8;
                                i3 = 7;
                            } else {
                                intValue2 = 0;
                                i3 = intValue2;
                            }
                            paint.setColor(-3355444);
                            Bitmap createBitmap = Bitmap.createBitmap(i, measuredHeight, Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            float f = (float) i;
                            float f2 = (float) measuredHeight;
                            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                            float f3 = (float) intValue2;
                            canvas.drawRoundRect(rectF, f3, f3, paint);
                            paint.setColor(-1);
                            RectF rectF2 = new RectF(2.0f, 2.0f, f - 2.0f, f2 - 2.0f);
                            f2 = (float) i3;
                            canvas.drawRoundRect(rectF2, f2, f2, paint);
                            paint.setColor(-3355444);
                            Bitmap createBitmap2 = Bitmap.createBitmap(i, measuredHeight, Config.ARGB_8888);
                            new Canvas(createBitmap2).drawRoundRect(rectF, f3, f3, paint);
                            Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
                            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                            textView2.setBackgroundDrawable(bitmapDrawable);
                            textView2.setOnTouchListener(new c(1, bitmapDrawable2, bitmapDrawable));
                            z = true;
                            return z;
                        }
                    }
                    z = true;
                    return z;
                case 3:
                    ViewGroup viewGroup = (ViewGroup) r1.b[0];
                    if (viewGroup.getMeasuredHeight() > a.a((Context) r1.b[1], 158.0f)) {
                        LayoutParams layoutParams = viewGroup.getLayoutParams();
                        layoutParams.height = a.a((Context) r1.b[1], 200.0f);
                        viewGroup.setLayoutParams(layoutParams);
                    }
                    return true;
                default:
                    break;
            }
        } catch (Throwable e) {
            Throwable th = e;
            if (!an.b(th)) {
                th.printStackTrace();
            }
            z = false;
        }
        return z;
    }
}
