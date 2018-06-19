package com.xunlei.downloadprovider.xlui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.xunlei.downloadprovider.R;

public class BGAProgressBar extends ProgressBar {
    private static final String a = "BGAProgressBar";
    private Paint b;
    private Mode c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private RectF r;
    private Rect s;
    private String t;

    private enum Mode {
        System,
        Horizontal,
        Circle,
        Comet,
        Wave
    }

    public BGAProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public BGAProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = new Rect();
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.c = Mode.System;
        this.d = Color.parseColor("#70A800");
        this.e = (int) TypedValue.applyDimension(2, 10.0f, context.getResources().getDisplayMetrics());
        this.f = a(context, (float) 1082130432);
        this.g = Color.parseColor("#70A800");
        this.h = a(context, (float) 1073741824);
        this.i = Color.parseColor("#CCCCCC");
        this.j = a(context, (float) 1065353216);
        this.k = false;
        this.l = false;
        this.m = a(context, (float) 1098907648);
        a(context, attributeSet);
        this.o = Math.max(this.h, this.j);
    }

    private void a(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.BGAProgressBar);
        attributeSet = context.getIndexCount();
        for (int i = 0; i < attributeSet; i++) {
            int index = context.getIndex(i);
            if (index == 0) {
                this.c = Mode.values()[context.getInt(index, Mode.System.ordinal())];
            } else if (index == 1) {
                this.d = context.getColor(index, this.d);
            } else if (index == 2) {
                this.e = context.getDimensionPixelOffset(index, this.e);
            } else if (index == 3) {
                this.f = context.getDimensionPixelOffset(index, this.f);
            } else if (index == 4) {
                this.g = context.getColor(index, this.g);
            } else if (index == 5) {
                this.h = context.getDimensionPixelOffset(index, this.h);
            } else if (index == 6) {
                this.i = context.getColor(index, this.i);
            } else if (index == 7) {
                this.j = context.getDimensionPixelOffset(index, this.j);
            } else if (index == 8) {
                this.k = context.getBoolean(index, this.k);
                if (this.k) {
                    this.b.setStrokeCap(Cap.ROUND);
                }
            } else if (index == 9) {
                this.l = context.getBoolean(index, this.l);
            } else if (index == 10) {
                this.m = context.getDimensionPixelOffset(index, this.m);
            }
        }
        context.recycle();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void onMeasure(int r5, int r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.c;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.System;	 Catch:{ all -> 0x00c3 }
        if (r0 != r1) goto L_0x000c;
    L_0x0007:
        super.onMeasure(r5, r6);	 Catch:{ all -> 0x00c3 }
        monitor-exit(r4);
        return;
    L_0x000c:
        r0 = r4.c;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Horizontal;	 Catch:{ all -> 0x00c3 }
        if (r0 != r1) goto L_0x0058;
    L_0x0012:
        r4.a();	 Catch:{ all -> 0x00c3 }
        r5 = android.view.View.MeasureSpec.getSize(r5);	 Catch:{ all -> 0x00c3 }
        r0 = r4.getPaddingTop();	 Catch:{ all -> 0x00c3 }
        r1 = r4.getPaddingBottom();	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
        r1 = r4.l;	 Catch:{ all -> 0x00c3 }
        if (r1 == 0) goto L_0x0030;
    L_0x0026:
        r1 = r4.h;	 Catch:{ all -> 0x00c3 }
        r2 = r4.j;	 Catch:{ all -> 0x00c3 }
        r1 = java.lang.Math.max(r1, r2);	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
        goto L_0x003f;
    L_0x0030:
        r1 = r4.p;	 Catch:{ all -> 0x00c3 }
        r2 = r4.h;	 Catch:{ all -> 0x00c3 }
        r3 = r4.j;	 Catch:{ all -> 0x00c3 }
        r2 = java.lang.Math.max(r2, r3);	 Catch:{ all -> 0x00c3 }
        r1 = java.lang.Math.max(r1, r2);	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
    L_0x003f:
        r6 = resolveSize(r0, r6);	 Catch:{ all -> 0x00c3 }
        r4.setMeasuredDimension(r5, r6);	 Catch:{ all -> 0x00c3 }
        r5 = r4.getMeasuredWidth();	 Catch:{ all -> 0x00c3 }
        r6 = r4.getPaddingLeft();	 Catch:{ all -> 0x00c3 }
        r5 = r5 - r6;
        r6 = r4.getPaddingRight();	 Catch:{ all -> 0x00c3 }
        r5 = r5 - r6;
        r4.n = r5;	 Catch:{ all -> 0x00c3 }
        monitor-exit(r4);
        return;
    L_0x0058:
        r0 = r4.c;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Circle;	 Catch:{ all -> 0x00c3 }
        if (r0 != r1) goto L_0x00ad;
    L_0x005e:
        r0 = r4.m;	 Catch:{ all -> 0x00c3 }
        r0 = r0 * 2;
        r1 = r4.o;	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
        r1 = r4.getPaddingLeft();	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
        r1 = r4.getPaddingRight();	 Catch:{ all -> 0x00c3 }
        r0 = r0 + r1;
        r5 = resolveSize(r0, r5);	 Catch:{ all -> 0x00c3 }
        r6 = resolveSize(r0, r6);	 Catch:{ all -> 0x00c3 }
        r5 = java.lang.Math.min(r5, r6);	 Catch:{ all -> 0x00c3 }
        r6 = r4.getPaddingLeft();	 Catch:{ all -> 0x00c3 }
        r6 = r5 - r6;
        r0 = r4.getPaddingRight();	 Catch:{ all -> 0x00c3 }
        r6 = r6 - r0;
        r0 = r4.o;	 Catch:{ all -> 0x00c3 }
        r6 = r6 - r0;
        r6 = r6 / 2;
        r4.m = r6;	 Catch:{ all -> 0x00c3 }
        r6 = r4.r;	 Catch:{ all -> 0x00c3 }
        if (r6 != 0) goto L_0x0098;
    L_0x0091:
        r6 = new android.graphics.RectF;	 Catch:{ all -> 0x00c3 }
        r6.<init>();	 Catch:{ all -> 0x00c3 }
        r4.r = r6;	 Catch:{ all -> 0x00c3 }
    L_0x0098:
        r6 = r4.r;	 Catch:{ all -> 0x00c3 }
        r0 = r4.m;	 Catch:{ all -> 0x00c3 }
        r0 = r0 * 2;
        r0 = (float) r0;	 Catch:{ all -> 0x00c3 }
        r1 = r4.m;	 Catch:{ all -> 0x00c3 }
        r1 = r1 * 2;
        r1 = (float) r1;	 Catch:{ all -> 0x00c3 }
        r2 = 0;
        r6.set(r2, r2, r0, r1);	 Catch:{ all -> 0x00c3 }
        r4.setMeasuredDimension(r5, r5);	 Catch:{ all -> 0x00c3 }
        monitor-exit(r4);
        return;
    L_0x00ad:
        r0 = r4.c;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Comet;	 Catch:{ all -> 0x00c3 }
        if (r0 != r1) goto L_0x00b8;
    L_0x00b3:
        super.onMeasure(r5, r6);	 Catch:{ all -> 0x00c3 }
        monitor-exit(r4);
        return;
    L_0x00b8:
        r0 = r4.c;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Wave;	 Catch:{ all -> 0x00c3 }
        if (r0 != r1) goto L_0x00c1;
    L_0x00be:
        super.onMeasure(r5, r6);	 Catch:{ all -> 0x00c3 }
    L_0x00c1:
        monitor-exit(r4);
        return;
    L_0x00c3:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.onMeasure(int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void onDraw(android.graphics.Canvas r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.c;	 Catch:{ all -> 0x01f5 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.System;	 Catch:{ all -> 0x01f5 }
        if (r0 != r1) goto L_0x000c;
    L_0x0007:
        super.onDraw(r11);	 Catch:{ all -> 0x01f5 }
        monitor-exit(r10);
        return;
    L_0x000c:
        r0 = r10.c;	 Catch:{ all -> 0x01f5 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Horizontal;	 Catch:{ all -> 0x01f5 }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r0 != r1) goto L_0x0137;
    L_0x0014:
        r11.save();	 Catch:{ all -> 0x01f5 }
        r0 = r10.getPaddingLeft();	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r1 = r10.getMeasuredHeight();	 Catch:{ all -> 0x01f5 }
        r1 = r1 / 2;
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r11.translate(r0, r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.getProgress();	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r0 = r0 * r2;
        r1 = r10.getMax();	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0 = r0 / r1;
        r1 = r10.n;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0 = r0 * r1;
        r1 = r10.l;	 Catch:{ all -> 0x01f5 }
        r3 = 0;
        if (r1 == 0) goto L_0x00a3;
    L_0x003b:
        r1 = r10.n;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 <= 0) goto L_0x0045;
    L_0x0042:
        r0 = r10.n;	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
    L_0x0045:
        r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0069;
    L_0x0049:
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r3 = r10.g;	 Catch:{ all -> 0x01f5 }
        r1.setColor(r3);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r3 = r10.h;	 Catch:{ all -> 0x01f5 }
        r3 = (float) r3;	 Catch:{ all -> 0x01f5 }
        r1.setStrokeWidth(r3);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r3 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r1.setStyle(r3);	 Catch:{ all -> 0x01f5 }
        r4 = 0;
        r5 = 0;
        r7 = 0;
        r8 = r10.b;	 Catch:{ all -> 0x01f5 }
        r3 = r11;
        r6 = r0;
        r3.drawLine(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x01f5 }
    L_0x0069:
        r1 = r10.k;	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x0078;
    L_0x006d:
        r1 = r10.h;	 Catch:{ all -> 0x01f5 }
        r3 = r10.j;	 Catch:{ all -> 0x01f5 }
        r1 = r1 + r3;
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r1 = r1 * r2;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r1 / r2;
        r0 = r0 + r1;
    L_0x0078:
        r1 = r0;
        r0 = r10.n;	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0132;
    L_0x0080:
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r10.i;	 Catch:{ all -> 0x01f5 }
        r0.setColor(r2);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r10.j;	 Catch:{ all -> 0x01f5 }
        r2 = (float) r2;	 Catch:{ all -> 0x01f5 }
        r0.setStrokeWidth(r2);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r0.setStyle(r2);	 Catch:{ all -> 0x01f5 }
        r2 = 0;
        r0 = r10.n;	 Catch:{ all -> 0x01f5 }
        r3 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r4 = 0;
        r5 = r10.b;	 Catch:{ all -> 0x01f5 }
        r0 = r11;
        r0.drawLine(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x01f5 }
        goto L_0x0132;
    L_0x00a3:
        r10.a();	 Catch:{ all -> 0x01f5 }
        r1 = r10.n;	 Catch:{ all -> 0x01f5 }
        r2 = r10.q;	 Catch:{ all -> 0x01f5 }
        r1 = r1 - r2;
        r2 = r10.f;	 Catch:{ all -> 0x01f5 }
        r1 = r1 - r2;
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r2 <= 0) goto L_0x00b4;
    L_0x00b3:
        r0 = r1;
    L_0x00b4:
        r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x00d8;
    L_0x00b8:
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r10.g;	 Catch:{ all -> 0x01f5 }
        r1.setColor(r2);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r10.h;	 Catch:{ all -> 0x01f5 }
        r2 = (float) r2;	 Catch:{ all -> 0x01f5 }
        r1.setStrokeWidth(r2);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r1.setStyle(r2);	 Catch:{ all -> 0x01f5 }
        r5 = 0;
        r6 = 0;
        r8 = 0;
        r9 = r10.b;	 Catch:{ all -> 0x01f5 }
        r4 = r11;
        r7 = r0;
        r4.drawLine(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x01f5 }
    L_0x00d8:
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = android.graphics.Paint.Align.LEFT;	 Catch:{ all -> 0x01f5 }
        r1.setTextAlign(r2);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = android.graphics.Paint.Style.FILL;	 Catch:{ all -> 0x01f5 }
        r1.setStyle(r2);	 Catch:{ all -> 0x01f5 }
        r1 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r10.d;	 Catch:{ all -> 0x01f5 }
        r1.setColor(r2);	 Catch:{ all -> 0x01f5 }
        r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x00f5;
    L_0x00f1:
        r1 = r10.f;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0 = r0 + r1;
    L_0x00f5:
        r1 = r10.t;	 Catch:{ all -> 0x01f5 }
        r2 = r10.p;	 Catch:{ all -> 0x01f5 }
        r2 = r2 / 2;
        r2 = (float) r2;	 Catch:{ all -> 0x01f5 }
        r3 = r10.b;	 Catch:{ all -> 0x01f5 }
        r11.drawText(r1, r0, r2, r3);	 Catch:{ all -> 0x01f5 }
        r1 = r10.q;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0 = r0 + r1;
        r1 = r10.f;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r3 = r0 + r1;
        r0 = r10.n;	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0132;
    L_0x0111:
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.i;	 Catch:{ all -> 0x01f5 }
        r0.setColor(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.j;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0.setStrokeWidth(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r0.setStyle(r1);	 Catch:{ all -> 0x01f5 }
        r4 = 0;
        r0 = r10.n;	 Catch:{ all -> 0x01f5 }
        r5 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r6 = 0;
        r7 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r11;
        r2.drawLine(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x01f5 }
    L_0x0132:
        r11.restore();	 Catch:{ all -> 0x01f5 }
        monitor-exit(r10);
        return;
    L_0x0137:
        r0 = r10.c;	 Catch:{ all -> 0x01f5 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Circle;	 Catch:{ all -> 0x01f5 }
        if (r0 != r1) goto L_0x01df;
    L_0x013d:
        r11.save();	 Catch:{ all -> 0x01f5 }
        r0 = r10.getPaddingLeft();	 Catch:{ all -> 0x01f5 }
        r1 = r10.o;	 Catch:{ all -> 0x01f5 }
        r1 = r1 / 2;
        r0 = r0 + r1;
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r1 = r10.getPaddingTop();	 Catch:{ all -> 0x01f5 }
        r3 = r10.o;	 Catch:{ all -> 0x01f5 }
        r3 = r3 / 2;
        r1 = r1 + r3;
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r11.translate(r0, r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r0.setStyle(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.i;	 Catch:{ all -> 0x01f5 }
        r0.setColor(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.j;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0.setStrokeWidth(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.m;	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r1 = r10.m;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r3 = r10.m;	 Catch:{ all -> 0x01f5 }
        r3 = (float) r3;	 Catch:{ all -> 0x01f5 }
        r4 = r10.b;	 Catch:{ all -> 0x01f5 }
        r11.drawCircle(r0, r1, r3, r4);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = android.graphics.Paint.Style.STROKE;	 Catch:{ all -> 0x01f5 }
        r0.setStyle(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.g;	 Catch:{ all -> 0x01f5 }
        r0.setColor(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.h;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0.setStrokeWidth(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.getProgress();	 Catch:{ all -> 0x01f5 }
        r0 = (float) r0;	 Catch:{ all -> 0x01f5 }
        r0 = r0 * r2;
        r1 = r10.getMax();	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r0 = r0 / r1;
        r1 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;
        r5 = r0 * r1;
        r3 = r10.r;	 Catch:{ all -> 0x01f5 }
        r4 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;
        r6 = 0;
        r7 = r10.b;	 Catch:{ all -> 0x01f5 }
        r2 = r11;
        r2.drawArc(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x01f5 }
        r0 = r10.l;	 Catch:{ all -> 0x01f5 }
        if (r0 != 0) goto L_0x01da;
    L_0x01b0:
        r10.a();	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = android.graphics.Paint.Style.FILL;	 Catch:{ all -> 0x01f5 }
        r0.setStyle(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = r10.d;	 Catch:{ all -> 0x01f5 }
        r0.setColor(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.b;	 Catch:{ all -> 0x01f5 }
        r1 = android.graphics.Paint.Align.CENTER;	 Catch:{ all -> 0x01f5 }
        r0.setTextAlign(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r10.t;	 Catch:{ all -> 0x01f5 }
        r1 = r10.m;	 Catch:{ all -> 0x01f5 }
        r1 = (float) r1;	 Catch:{ all -> 0x01f5 }
        r2 = r10.m;	 Catch:{ all -> 0x01f5 }
        r3 = r10.p;	 Catch:{ all -> 0x01f5 }
        r3 = r3 / 2;
        r2 = r2 + r3;
        r2 = (float) r2;	 Catch:{ all -> 0x01f5 }
        r3 = r10.b;	 Catch:{ all -> 0x01f5 }
        r11.drawText(r0, r1, r2, r3);	 Catch:{ all -> 0x01f5 }
    L_0x01da:
        r11.restore();	 Catch:{ all -> 0x01f5 }
        monitor-exit(r10);
        return;
    L_0x01df:
        r0 = r10.c;	 Catch:{ all -> 0x01f5 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Comet;	 Catch:{ all -> 0x01f5 }
        if (r0 != r1) goto L_0x01ea;
    L_0x01e5:
        super.onDraw(r11);	 Catch:{ all -> 0x01f5 }
        monitor-exit(r10);
        return;
    L_0x01ea:
        r0 = r10.c;	 Catch:{ all -> 0x01f5 }
        r1 = com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.Mode.Wave;	 Catch:{ all -> 0x01f5 }
        if (r0 != r1) goto L_0x01f3;
    L_0x01f0:
        super.onDraw(r11);	 Catch:{ all -> 0x01f5 }
    L_0x01f3:
        monitor-exit(r10);
        return;
    L_0x01f5:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.xlui.widget.BGAProgressBar.onDraw(android.graphics.Canvas):void");
    }

    private void a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d", new Object[]{Integer.valueOf((getProgress() * 100) / getMax())}));
        stringBuilder.append("%");
        this.t = stringBuilder.toString();
        this.b.setTextSize((float) this.e);
        this.b.setStyle(Style.FILL);
        this.b.getTextBounds(this.t, 0, this.t.length(), this.s);
        this.q = this.s.width();
        this.p = this.s.height();
    }

    private static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
