package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import java.lang.reflect.Field;

public class CountDownCircleProgressBar extends ProgressBar {
    private final RectF a;
    private final Rect b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private String t;
    private int u;
    private int v;
    private Cap w;

    protected synchronized void onDraw(android.graphics.Canvas r17) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 10, insn: 0x00c2: MOVE  (r6 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:16:0x00bd, method: com.xunlei.downloadprovider.ad.splash.view.CountDownCircleProgressBar.onDraw(android.graphics.Canvas):void
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:168)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r16 = this;
        r1 = r16;
        r8 = r17;
        monitor-enter(r16);
        r2 = r1.j;	 Catch:{ all -> 0x011d }
        if (r2 == 0) goto L_0x0014;	 Catch:{ all -> 0x011d }
    L_0x0009:
        r2 = r1.h;	 Catch:{ all -> 0x011d }
        r3 = r1.h;	 Catch:{ all -> 0x011d }
        r4 = r1.g;	 Catch:{ all -> 0x011d }
        r5 = r1.e;	 Catch:{ all -> 0x011d }
        r8.drawCircle(r2, r3, r4, r5);	 Catch:{ all -> 0x011d }
    L_0x0014:
        r2 = r1.u;	 Catch:{ all -> 0x011d }
        r9 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;	 Catch:{ all -> 0x011d }
        switch(r2) {
            case 1: goto L_0x004a;
            case 2: goto L_0x0023;
            default: goto L_0x001b;
        };	 Catch:{ all -> 0x011d }
    L_0x001b:
        r2 = 4618760256179416344; // 0x401921fb54442d18 float:3.37028055E12 double:6.283185307179586;	 Catch:{ all -> 0x011d }
        r4 = r1.k;	 Catch:{ all -> 0x011d }
        goto L_0x0071;	 Catch:{ all -> 0x011d }
    L_0x0023:
        r3 = r1.a;	 Catch:{ all -> 0x011d }
        r4 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;	 Catch:{ all -> 0x011d }
        r5 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;	 Catch:{ all -> 0x011d }
        r6 = 0;	 Catch:{ all -> 0x011d }
        r7 = r1.d;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r2.drawArc(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
        r3 = r1.a;	 Catch:{ all -> 0x011d }
        r4 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;	 Catch:{ all -> 0x011d }
        r2 = getProgress();	 Catch:{ all -> 0x011d }
        r2 = (float) r2;	 Catch:{ all -> 0x011d }
        r9 = r9 * r2;	 Catch:{ all -> 0x011d }
        r2 = getMax();	 Catch:{ all -> 0x011d }
        r2 = (float) r2;	 Catch:{ all -> 0x011d }
        r5 = r9 / r2;	 Catch:{ all -> 0x011d }
        r6 = 0;	 Catch:{ all -> 0x011d }
        r7 = r1.c;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r2.drawArc(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
        goto L_0x00d6;	 Catch:{ all -> 0x011d }
    L_0x004a:
        r3 = r1.a;	 Catch:{ all -> 0x011d }
        r4 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;	 Catch:{ all -> 0x011d }
        r5 = 1135869952; // 0x43b40000 float:360.0 double:5.611943214E-315;	 Catch:{ all -> 0x011d }
        r6 = 0;	 Catch:{ all -> 0x011d }
        r7 = r1.d;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r2.drawArc(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
        r3 = r1.a;	 Catch:{ all -> 0x011d }
        r4 = -1028390912; // 0xffffffffc2b40000 float:-90.0 double:NaN;	 Catch:{ all -> 0x011d }
        r2 = getProgress();	 Catch:{ all -> 0x011d }
        r2 = (float) r2;	 Catch:{ all -> 0x011d }
        r9 = r9 * r2;	 Catch:{ all -> 0x011d }
        r2 = getMax();	 Catch:{ all -> 0x011d }
        r2 = (float) r2;	 Catch:{ all -> 0x011d }
        r5 = r9 / r2;	 Catch:{ all -> 0x011d }
        r6 = 1;	 Catch:{ all -> 0x011d }
        r7 = r1.c;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r2.drawArc(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
        goto L_0x00d6;	 Catch:{ all -> 0x011d }
    L_0x0071:
        r4 = (double) r4;	 Catch:{ all -> 0x011d }
        r2 = r2 / r4;	 Catch:{ all -> 0x011d }
        r9 = (float) r2;	 Catch:{ all -> 0x011d }
        r11 = r1.g;	 Catch:{ all -> 0x011d }
        r2 = r1.g;	 Catch:{ all -> 0x011d }
        r3 = r1.l;	 Catch:{ all -> 0x011d }
        r12 = r2 - r3;	 Catch:{ all -> 0x011d }
        r2 = getProgress();	 Catch:{ all -> 0x011d }
        r2 = (float) r2;	 Catch:{ all -> 0x011d }
        r3 = getMax();	 Catch:{ all -> 0x011d }
        r3 = (float) r3;	 Catch:{ all -> 0x011d }
        r2 = r2 / r3;	 Catch:{ all -> 0x011d }
        r3 = r1.k;	 Catch:{ all -> 0x011d }
        r3 = (float) r3;	 Catch:{ all -> 0x011d }
        r2 = r2 * r3;	 Catch:{ all -> 0x011d }
        r13 = (int) r2;	 Catch:{ all -> 0x011d }
        r14 = 0;	 Catch:{ all -> 0x011d }
    L_0x008d:
        r2 = r1.k;	 Catch:{ all -> 0x011d }
        if (r14 >= r2) goto L_0x00d6;	 Catch:{ all -> 0x011d }
    L_0x0091:
        r2 = (float) r14;	 Catch:{ all -> 0x011d }
        r2 = r2 * r9;	 Catch:{ all -> 0x011d }
        r3 = r1.h;	 Catch:{ all -> 0x011d }
        r4 = (double) r2;	 Catch:{ all -> 0x011d }
        r6 = java.lang.Math.sin(r4);	 Catch:{ all -> 0x011d }
        r2 = (float) r6;	 Catch:{ all -> 0x011d }
        r2 = r2 * r12;	 Catch:{ all -> 0x011d }
        r3 = r3 + r2;	 Catch:{ all -> 0x011d }
        r2 = r1.h;	 Catch:{ all -> 0x011d }
        r6 = java.lang.Math.cos(r4);	 Catch:{ all -> 0x011d }
        r6 = (float) r6;	 Catch:{ all -> 0x011d }
        r6 = r6 * r12;	 Catch:{ all -> 0x011d }
        r6 = r2 - r6;	 Catch:{ all -> 0x011d }
        r2 = r1.h;	 Catch:{ all -> 0x011d }
        r15 = r11;	 Catch:{ all -> 0x011d }
        r10 = java.lang.Math.sin(r4);	 Catch:{ all -> 0x011d }
        r7 = (float) r10;	 Catch:{ all -> 0x011d }
        r7 = r7 * r15;	 Catch:{ all -> 0x011d }
        r7 = r7 + r2;	 Catch:{ all -> 0x011d }
        r2 = r1.h;	 Catch:{ all -> 0x011d }
        r4 = java.lang.Math.cos(r4);	 Catch:{ all -> 0x011d }
        r4 = (float) r4;	 Catch:{ all -> 0x011d }
        r4 = r4 * r15;	 Catch:{ all -> 0x011d }
        r10 = r2 - r4;	 Catch:{ all -> 0x011d }
        if (r14 >= r13) goto L_0x00c8;	 Catch:{ all -> 0x011d }
    L_0x00bd:
        r11 = r1.c;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r4 = r6;	 Catch:{ all -> 0x011d }
        r5 = r7;	 Catch:{ all -> 0x011d }
        r6 = r10;	 Catch:{ all -> 0x011d }
        r7 = r11;	 Catch:{ all -> 0x011d }
        r2.drawLine(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
        goto L_0x00d2;	 Catch:{ all -> 0x011d }
    L_0x00c8:
        r11 = r1.d;	 Catch:{ all -> 0x011d }
        r2 = r8;	 Catch:{ all -> 0x011d }
        r4 = r6;	 Catch:{ all -> 0x011d }
        r5 = r7;	 Catch:{ all -> 0x011d }
        r6 = r10;	 Catch:{ all -> 0x011d }
        r7 = r11;	 Catch:{ all -> 0x011d }
        r2.drawLine(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x011d }
    L_0x00d2:
        r14 = r14 + 1;	 Catch:{ all -> 0x011d }
        r11 = r15;	 Catch:{ all -> 0x011d }
        goto L_0x008d;	 Catch:{ all -> 0x011d }
    L_0x00d6:
        r2 = r1.s;	 Catch:{ all -> 0x011d }
        if (r2 == 0) goto L_0x011b;	 Catch:{ all -> 0x011d }
    L_0x00da:
        r2 = r1.t;	 Catch:{ all -> 0x011d }
        r3 = 1;	 Catch:{ all -> 0x011d }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x011d }
        r4 = r16.getProgress();	 Catch:{ all -> 0x011d }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x011d }
        r5 = 0;	 Catch:{ all -> 0x011d }
        r3[r5] = r4;	 Catch:{ all -> 0x011d }
        r2 = java.lang.String.format(r2, r3);	 Catch:{ all -> 0x011d }
        r3 = r1.f;	 Catch:{ all -> 0x011d }
        r4 = r1.n;	 Catch:{ all -> 0x011d }
        r3.setTextSize(r4);	 Catch:{ all -> 0x011d }
        r3 = r1.f;	 Catch:{ all -> 0x011d }
        r4 = r1.q;	 Catch:{ all -> 0x011d }
        r3.setColor(r4);	 Catch:{ all -> 0x011d }
        r3 = r1.f;	 Catch:{ all -> 0x011d }
        r4 = r2.length();	 Catch:{ all -> 0x011d }
        r5 = r1.b;	 Catch:{ all -> 0x011d }
        r6 = 0;	 Catch:{ all -> 0x011d }
        r3.getTextBounds(r2, r6, r4, r5);	 Catch:{ all -> 0x011d }
        r3 = r1.h;	 Catch:{ all -> 0x011d }
        r4 = r1.i;	 Catch:{ all -> 0x011d }
        r5 = r1.b;	 Catch:{ all -> 0x011d }
        r5 = r5.height();	 Catch:{ all -> 0x011d }
        r5 = r5 / 2;	 Catch:{ all -> 0x011d }
        r5 = (float) r5;	 Catch:{ all -> 0x011d }
        r4 = r4 + r5;	 Catch:{ all -> 0x011d }
        r5 = r1.f;	 Catch:{ all -> 0x011d }
        r8.drawText(r2, r3, r4, r5);	 Catch:{ all -> 0x011d }
    L_0x011b:
        monitor-exit(r16);
        return;
    L_0x011d:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r16);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.view.CountDownCircleProgressBar.onDraw(android.graphics.Canvas):void");
    }

    public CountDownCircleProgressBar(Context context) {
        this(context, null);
    }

    public CountDownCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new RectF();
        this.b = new Rect();
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = new Paint(1);
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mOnlyIndeterminate");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(false));
            declaredField = ProgressBar.class.getDeclaredField("mIndeterminate");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(false));
            declaredField = ProgressBar.class.getDeclaredField("mCurrentDrawable");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        context = context.obtainStyledAttributes(attributeSet, R.styleable.CountDownCircleProgressBar);
        this.j = context.getColor(3, 0);
        this.s = context.getBoolean(1, true);
        this.k = context.getInt(0, 45);
        this.t = context.hasValue(10) ? context.getString(10) : "%d%%";
        this.u = context.getInt(11, 0);
        this.v = context.getInt(12, 0);
        this.w = context.hasValue(13) ? Cap.values()[context.getInt(13, 0)] : Cap.BUTT;
        this.l = (float) context.getDimensionPixelSize(2, DipPixelUtil.dip2px(4.0f));
        this.n = (float) context.getDimensionPixelSize(7, DipPixelUtil.dip2px(11.0f));
        this.m = (float) context.getDimensionPixelSize(8, DipPixelUtil.dip2px(1.0f));
        this.o = context.getColor(4, Color.parseColor("#fff2a670"));
        this.p = context.getColor(5, Color.parseColor("#fff2a670"));
        this.q = context.getColor(6, Color.parseColor("#fff2a670"));
        this.r = context.getColor(9, Color.parseColor("#ffe3e3e5"));
        context.recycle();
        this.f.setTextAlign(Align.CENTER);
        this.f.setTextSize(this.n);
        this.c.setStyle(this.u == 1 ? Style.FILL : Style.STROKE);
        this.c.setStrokeWidth(this.m);
        this.c.setColor(this.o);
        this.c.setStrokeCap(this.w);
        this.d.setStyle(this.u == 1 ? Style.FILL : Style.STROKE);
        this.d.setStrokeWidth(this.m);
        this.d.setColor(this.r);
        this.d.setStrokeCap(this.w);
        this.e.setStyle(Style.FILL);
        this.e.setColor(this.j);
    }

    private void a() {
        Shader shader = null;
        if (this.o != this.p) {
            switch (r0.v) {
                case 0:
                    float f = r0.a.left;
                    float f2 = r0.a.top;
                    float f3 = r0.a.left;
                    float f4 = r0.a.bottom;
                    int i = r0.o;
                    Shader linearGradient = new LinearGradient(f, f2, f3, f4, i, r0.p, TileMode.CLAMP);
                    break;
                case 1:
                    Shader radialGradient = new RadialGradient(r0.h, r0.i, r0.g, r0.o, r0.p, TileMode.CLAMP);
                    break;
                case 2:
                    double d;
                    float f5 = (float) (((((double) r0.m) / 3.141592653589793d) * 2.0d) / ((double) r0.g));
                    if (r0.w == Cap.BUTT && r0.u == 2) {
                        d = 0.0d;
                    } else {
                        d = Math.toDegrees((double) f5);
                    }
                    f5 = (float) (-90.0d - d);
                    shader = new SweepGradient(r0.h, r0.i, new int[]{r0.o, r0.p}, new float[]{0.0f, 1.0f});
                    Matrix matrix = new Matrix();
                    matrix.postRotate(f5, r0.h, r0.i);
                    shader.setLocalMatrix(matrix);
                    break;
            }
            Shader shader2 = shader;
            r0.c.setShader(shader2);
            return;
        }
        r0.c.setShader(null);
        r0.c.setColor(r0.o);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = (float) (i / 2);
        this.i = (float) (i2 / 2);
        this.g = Math.min(this.h, this.i);
        this.a.top = this.i - this.g;
        this.a.bottom = this.i + this.g;
        this.a.left = this.h - this.g;
        this.a.right = this.h + this.g;
        a();
        this.a.inset(this.m / 1073741824, this.m / 1073741824);
    }

    public int getBackgroundColor() {
        return this.j;
    }

    public void setBackgroundColor(int i) {
        this.j = i;
        this.e.setColor(i);
        invalidate();
    }

    public void setProgressTextFormatPattern(String str) {
        this.t = str;
        invalidate();
    }

    public String getProgressTextFormatPattern() {
        return this.t;
    }

    public void setProgressStrokeWidth(float f) {
        this.m = f;
        this.a.inset(this.m / 2.0f, this.m / 2.0f);
        invalidate();
    }

    public float getProgressStrokeWidth() {
        return this.m;
    }

    public void setProgressTextSize(float f) {
        this.n = f;
        invalidate();
    }

    public float getProgressTextSize() {
        return this.n;
    }

    public void setProgressStartColor(int i) {
        this.o = i;
        a();
        invalidate();
    }

    public int getProgressStartColor() {
        return this.o;
    }

    public void setProgressEndColor(int i) {
        this.p = i;
        a();
        invalidate();
    }

    public int getProgressEndColor() {
        return this.p;
    }

    public void setProgressTextColor(int i) {
        this.q = i;
        invalidate();
    }

    public int getProgressTextColor() {
        return this.q;
    }

    public void setProgressBackgroundColor(int i) {
        this.r = i;
        this.d.setColor(this.r);
        invalidate();
    }

    public int getProgressBackgroundColor() {
        return this.r;
    }

    public int getLineCount() {
        return this.k;
    }

    public void setLineCount(int i) {
        this.k = i;
        invalidate();
    }

    public float getLineWidth() {
        return this.l;
    }

    public void setLineWidth(float f) {
        this.l = f;
        invalidate();
    }

    public int getStyle() {
        return this.u;
    }

    public void setStyle(int i) {
        this.u = i;
        this.c.setStyle(this.u == 1 ? Style.FILL : Style.STROKE);
        this.d.setStyle(this.u == 1 ? Style.FILL : Style.STROKE);
        invalidate();
    }

    public int getShader() {
        return this.v;
    }

    public void setShader(int i) {
        this.v = i;
        a();
        invalidate();
    }

    public Cap getCap() {
        return this.w;
    }

    public void setCap(Cap cap) {
        this.w = cap;
        this.c.setStrokeCap(cap);
        this.d.setStrokeCap(cap);
        invalidate();
    }
}
