package com.xunlei.downloadprovider.personal.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class JustifyTextView extends TextView {
    private static final String a = "JustifyTextView";
    private int b;
    private int c;
    private int d;
    private int e;
    private Paint f = new Paint();
    private int g;
    private boolean h = null;

    public JustifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f.setAntiAlias(true);
        this.f.setColor(Color.parseColor("#406599"));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(android.graphics.Canvas r18) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r3 = r17.getCurrentTextColor();	 Catch:{ Exception -> 0x0219 }
        r2.setColor(r3);	 Catch:{ Exception -> 0x0219 }
        r3 = r17.getDrawableState();	 Catch:{ Exception -> 0x0219 }
        r2.drawableState = r3;	 Catch:{ Exception -> 0x0219 }
        r3 = r0.f;	 Catch:{ Exception -> 0x0219 }
        r4 = r2.getTextSize();	 Catch:{ Exception -> 0x0219 }
        r3.setTextSize(r4);	 Catch:{ Exception -> 0x0219 }
        r3 = r17.getMeasuredWidth();	 Catch:{ Exception -> 0x0219 }
        r0.c = r3;	 Catch:{ Exception -> 0x0219 }
        r3 = r17.getMeasuredHeight();	 Catch:{ Exception -> 0x0219 }
        r0.d = r3;	 Catch:{ Exception -> 0x0219 }
        r3 = r17.getText();	 Catch:{ Exception -> 0x0219 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0219 }
        r4 = 0;	 Catch:{ Exception -> 0x0219 }
        r0.b = r4;	 Catch:{ Exception -> 0x0219 }
        r0.g = r4;	 Catch:{ Exception -> 0x0219 }
        r5 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0219 }
        r6 = r17.getTextSize();	 Catch:{ Exception -> 0x0219 }
        r5 = r5 + r6;	 Catch:{ Exception -> 0x0219 }
        r5 = (int) r5;	 Catch:{ Exception -> 0x0219 }
        r0.b = r5;	 Catch:{ Exception -> 0x0219 }
        r5 = r17.getLayout();	 Catch:{ Exception -> 0x0219 }
        if (r5 != 0) goto L_0x0049;	 Catch:{ Exception -> 0x0219 }
    L_0x0048:
        return;	 Catch:{ Exception -> 0x0219 }
    L_0x0049:
        r6 = r2.getFontMetrics();	 Catch:{ Exception -> 0x0219 }
        r7 = r6.descent;	 Catch:{ Exception -> 0x0219 }
        r6 = r6.ascent;	 Catch:{ Exception -> 0x0219 }
        r7 = r7 - r6;	 Catch:{ Exception -> 0x0219 }
        r6 = (double) r7;	 Catch:{ Exception -> 0x0219 }
        r6 = java.lang.Math.ceil(r6);	 Catch:{ Exception -> 0x0219 }
        r6 = (int) r6;	 Catch:{ Exception -> 0x0219 }
        r6 = (float) r6;	 Catch:{ Exception -> 0x0219 }
        r7 = r5.getSpacingMultiplier();	 Catch:{ Exception -> 0x0219 }
        r6 = r6 * r7;	 Catch:{ Exception -> 0x0219 }
        r7 = r5.getSpacingAdd();	 Catch:{ Exception -> 0x0219 }
        r6 = r6 + r7;	 Catch:{ Exception -> 0x0219 }
        r6 = (int) r6;	 Catch:{ Exception -> 0x0219 }
        r7 = r4;	 Catch:{ Exception -> 0x0219 }
    L_0x0065:
        r8 = r5.getLineCount();	 Catch:{ Exception -> 0x0219 }
        if (r7 >= r8) goto L_0x0218;	 Catch:{ Exception -> 0x0219 }
    L_0x006b:
        r8 = r5.getLineStart(r7);	 Catch:{ Exception -> 0x0219 }
        r9 = r5.getLineEnd(r7);	 Catch:{ Exception -> 0x0219 }
        r10 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r10 = android.text.StaticLayout.getDesiredWidth(r3, r8, r9, r10);	 Catch:{ Exception -> 0x0219 }
        r8 = r3.substring(r8, r9);	 Catch:{ Exception -> 0x0219 }
        r9 = r5.getLineCount();	 Catch:{ Exception -> 0x0219 }
        r11 = 1;	 Catch:{ Exception -> 0x0219 }
        r9 = r9 - r11;	 Catch:{ Exception -> 0x0219 }
        r13 = 2;	 Catch:{ Exception -> 0x0219 }
        r14 = 0;	 Catch:{ Exception -> 0x0219 }
        if (r7 >= r9) goto L_0x0174;	 Catch:{ Exception -> 0x0219 }
    L_0x0089:
        if (r8 == 0) goto L_0x00a1;	 Catch:{ Exception -> 0x0219 }
    L_0x008b:
        r9 = r8.length();	 Catch:{ Exception -> 0x0219 }
        if (r9 != 0) goto L_0x0092;	 Catch:{ Exception -> 0x0219 }
    L_0x0091:
        goto L_0x00a1;	 Catch:{ Exception -> 0x0219 }
    L_0x0092:
        r9 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r9 = r9 - r11;	 Catch:{ Exception -> 0x0219 }
        r9 = r8.charAt(r9);	 Catch:{ Exception -> 0x0219 }
        r15 = 10;	 Catch:{ Exception -> 0x0219 }
        if (r9 == r15) goto L_0x00a1;	 Catch:{ Exception -> 0x0219 }
    L_0x009f:
        r9 = r11;	 Catch:{ Exception -> 0x0219 }
        goto L_0x00a2;	 Catch:{ Exception -> 0x0219 }
    L_0x00a1:
        r9 = r4;	 Catch:{ Exception -> 0x0219 }
    L_0x00a2:
        if (r9 == 0) goto L_0x016d;	 Catch:{ Exception -> 0x0219 }
    L_0x00a4:
        r9 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r15 = 3;	 Catch:{ Exception -> 0x0219 }
        if (r9 <= r15) goto L_0x00bb;	 Catch:{ Exception -> 0x0219 }
    L_0x00ab:
        r9 = r8.charAt(r4);	 Catch:{ Exception -> 0x0219 }
        r12 = 32;	 Catch:{ Exception -> 0x0219 }
        if (r9 != r12) goto L_0x00bb;	 Catch:{ Exception -> 0x0219 }
    L_0x00b3:
        r9 = r8.charAt(r11);	 Catch:{ Exception -> 0x0219 }
        if (r9 != r12) goto L_0x00bb;	 Catch:{ Exception -> 0x0219 }
    L_0x00b9:
        r9 = r11;	 Catch:{ Exception -> 0x0219 }
        goto L_0x00bc;	 Catch:{ Exception -> 0x0219 }
    L_0x00bb:
        r9 = r4;	 Catch:{ Exception -> 0x0219 }
    L_0x00bc:
        if (r9 == 0) goto L_0x00d7;	 Catch:{ Exception -> 0x0219 }
    L_0x00be:
        r9 = "  ";	 Catch:{ Exception -> 0x0219 }
        r12 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r12 = (float) r12;	 Catch:{ Exception -> 0x0219 }
        r4 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r9, r14, r12, r4);	 Catch:{ Exception -> 0x0219 }
        r4 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r4 = android.text.StaticLayout.getDesiredWidth(r9, r4);	 Catch:{ Exception -> 0x0219 }
        r14 = r14 + r4;	 Catch:{ Exception -> 0x0219 }
        r8 = r8.substring(r15);	 Catch:{ Exception -> 0x0219 }
    L_0x00d7:
        r4 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r4 = r4 - r11;	 Catch:{ Exception -> 0x0219 }
        r9 = r8.length();	 Catch:{ Exception -> 0x0219 }
        if (r9 <= r13) goto L_0x010d;	 Catch:{ Exception -> 0x0219 }
    L_0x00e2:
        r9 = 0;	 Catch:{ Exception -> 0x0219 }
        r12 = r8.charAt(r9);	 Catch:{ Exception -> 0x0219 }
        r15 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;	 Catch:{ Exception -> 0x0219 }
        if (r12 != r15) goto L_0x010d;	 Catch:{ Exception -> 0x0219 }
    L_0x00eb:
        r11 = r8.charAt(r11);	 Catch:{ Exception -> 0x0219 }
        if (r11 != r15) goto L_0x010d;	 Catch:{ Exception -> 0x0219 }
    L_0x00f1:
        r11 = r8.substring(r9, r13);	 Catch:{ Exception -> 0x0219 }
        r9 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r9 = android.text.StaticLayout.getDesiredWidth(r11, r9);	 Catch:{ Exception -> 0x0219 }
        r12 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r12 = (float) r12;	 Catch:{ Exception -> 0x0219 }
        r15 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r11, r14, r12, r15);	 Catch:{ Exception -> 0x0219 }
        r14 = r14 + r9;	 Catch:{ Exception -> 0x0219 }
        r9 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r9 = r9 + r13;	 Catch:{ Exception -> 0x0219 }
        r0.g = r9;	 Catch:{ Exception -> 0x0219 }
    L_0x010d:
        r9 = r0.c;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r9 = r9 - r10;	 Catch:{ Exception -> 0x0219 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0219 }
        r9 = r9 / r4;	 Catch:{ Exception -> 0x0219 }
        r4 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r10 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r11 = r0.e;	 Catch:{ Exception -> 0x0219 }
        if (r10 > r11) goto L_0x015d;	 Catch:{ Exception -> 0x0219 }
    L_0x011d:
        r10 = r0.e;	 Catch:{ Exception -> 0x0219 }
        if (r10 < r4) goto L_0x012a;	 Catch:{ Exception -> 0x0219 }
    L_0x0121:
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r10 = r0.f;	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r10);	 Catch:{ Exception -> 0x0219 }
        goto L_0x0157;	 Catch:{ Exception -> 0x0219 }
    L_0x012a:
        r10 = r0.e;	 Catch:{ Exception -> 0x0219 }
        r11 = 0;	 Catch:{ Exception -> 0x0219 }
        r10 = r8.substring(r11, r10);	 Catch:{ Exception -> 0x0219 }
        r11 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r11 = (float) r11;	 Catch:{ Exception -> 0x0219 }
        r12 = r0.f;	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r10, r14, r11, r12);	 Catch:{ Exception -> 0x0219 }
        r11 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r10 = android.text.StaticLayout.getDesiredWidth(r10, r11);	 Catch:{ Exception -> 0x0219 }
        r10 = r10 + r9;	 Catch:{ Exception -> 0x0219 }
        r14 = r14 + r10;	 Catch:{ Exception -> 0x0219 }
        r9 = r0.e;	 Catch:{ Exception -> 0x0219 }
        r10 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r8 = r8.substring(r9, r10);	 Catch:{ Exception -> 0x0219 }
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r10 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r10);	 Catch:{ Exception -> 0x0219 }
    L_0x0157:
        r8 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r8 = r8 + r4;	 Catch:{ Exception -> 0x0219 }
        r0.g = r8;	 Catch:{ Exception -> 0x0219 }
        goto L_0x0180;	 Catch:{ Exception -> 0x0219 }
    L_0x015d:
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r10 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r10);	 Catch:{ Exception -> 0x0219 }
        r8 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r8 = r8 + r4;	 Catch:{ Exception -> 0x0219 }
        r0.g = r8;	 Catch:{ Exception -> 0x0219 }
        goto L_0x0180;	 Catch:{ Exception -> 0x0219 }
    L_0x016d:
        r4 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r4, r2);	 Catch:{ Exception -> 0x0219 }
        goto L_0x0180;	 Catch:{ Exception -> 0x0219 }
    L_0x0174:
        r4 = r0.h;	 Catch:{ Exception -> 0x0219 }
        if (r4 == 0) goto L_0x0183;	 Catch:{ Exception -> 0x0219 }
    L_0x0178:
        r4 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r4 = r4 + r6;	 Catch:{ Exception -> 0x0219 }
        r9 = r0.d;	 Catch:{ Exception -> 0x0219 }
        if (r4 > r9) goto L_0x0180;	 Catch:{ Exception -> 0x0219 }
    L_0x017f:
        goto L_0x0183;	 Catch:{ Exception -> 0x0219 }
    L_0x0180:
        r10 = 0;	 Catch:{ Exception -> 0x0219 }
        goto L_0x020e;	 Catch:{ Exception -> 0x0219 }
    L_0x0183:
        r4 = r8.length();	 Catch:{ Exception -> 0x0219 }
        if (r4 <= r13) goto L_0x01b4;	 Catch:{ Exception -> 0x0219 }
    L_0x0189:
        r4 = 0;	 Catch:{ Exception -> 0x0219 }
        r9 = r8.charAt(r4);	 Catch:{ Exception -> 0x0219 }
        r10 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;	 Catch:{ Exception -> 0x0219 }
        if (r9 != r10) goto L_0x01b4;	 Catch:{ Exception -> 0x0219 }
    L_0x0192:
        r9 = r8.charAt(r11);	 Catch:{ Exception -> 0x0219 }
        if (r9 != r10) goto L_0x01b4;	 Catch:{ Exception -> 0x0219 }
    L_0x0198:
        r9 = r8.substring(r4, r13);	 Catch:{ Exception -> 0x0219 }
        r4 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r4 = android.text.StaticLayout.getDesiredWidth(r9, r4);	 Catch:{ Exception -> 0x0219 }
        r10 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r10 = (float) r10;	 Catch:{ Exception -> 0x0219 }
        r11 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r9, r14, r10, r11);	 Catch:{ Exception -> 0x0219 }
        r14 = r14 + r4;	 Catch:{ Exception -> 0x0219 }
        r4 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r4 = r4 + r13;	 Catch:{ Exception -> 0x0219 }
        r0.g = r4;	 Catch:{ Exception -> 0x0219 }
    L_0x01b4:
        r4 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r9 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r10 = r0.e;	 Catch:{ Exception -> 0x0219 }
        if (r9 > r10) goto L_0x01fe;	 Catch:{ Exception -> 0x0219 }
    L_0x01be:
        r9 = r0.e;	 Catch:{ Exception -> 0x0219 }
        if (r9 < r4) goto L_0x01cc;	 Catch:{ Exception -> 0x0219 }
    L_0x01c2:
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r10 = r0.f;	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r10);	 Catch:{ Exception -> 0x0219 }
        r10 = 0;	 Catch:{ Exception -> 0x0219 }
        goto L_0x01f8;	 Catch:{ Exception -> 0x0219 }
    L_0x01cc:
        r9 = r0.e;	 Catch:{ Exception -> 0x0219 }
        r10 = 0;	 Catch:{ Exception -> 0x0219 }
        r9 = r8.substring(r10, r9);	 Catch:{ Exception -> 0x0219 }
        r11 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r11 = (float) r11;	 Catch:{ Exception -> 0x0219 }
        r12 = r0.f;	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r9, r14, r11, r12);	 Catch:{ Exception -> 0x0219 }
        r11 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r9 = android.text.StaticLayout.getDesiredWidth(r9, r11);	 Catch:{ Exception -> 0x0219 }
        r14 = r14 + r9;	 Catch:{ Exception -> 0x0219 }
        r9 = r0.e;	 Catch:{ Exception -> 0x0219 }
        r11 = r8.length();	 Catch:{ Exception -> 0x0219 }
        r8 = r8.substring(r9, r11);	 Catch:{ Exception -> 0x0219 }
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r11 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r11);	 Catch:{ Exception -> 0x0219 }
    L_0x01f8:
        r8 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r8 = r8 + r4;	 Catch:{ Exception -> 0x0219 }
        r0.g = r8;	 Catch:{ Exception -> 0x0219 }
        goto L_0x020e;	 Catch:{ Exception -> 0x0219 }
    L_0x01fe:
        r10 = 0;	 Catch:{ Exception -> 0x0219 }
        r9 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r9 = (float) r9;	 Catch:{ Exception -> 0x0219 }
        r11 = r17.getPaint();	 Catch:{ Exception -> 0x0219 }
        r1.drawText(r8, r14, r9, r11);	 Catch:{ Exception -> 0x0219 }
        r8 = r0.g;	 Catch:{ Exception -> 0x0219 }
        r8 = r8 + r4;	 Catch:{ Exception -> 0x0219 }
        r0.g = r8;	 Catch:{ Exception -> 0x0219 }
    L_0x020e:
        r4 = r0.b;	 Catch:{ Exception -> 0x0219 }
        r4 = r4 + r6;	 Catch:{ Exception -> 0x0219 }
        r0.b = r4;	 Catch:{ Exception -> 0x0219 }
        r7 = r7 + 1;
        r4 = r10;
        goto L_0x0065;
    L_0x0218:
        return;
    L_0x0219:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.message.JustifyTextView.onDraw(android.graphics.Canvas):void");
    }

    public void setSpanPos(int i) {
        this.e = i;
    }

    public void setEllipsize(boolean z) {
        this.h = z;
    }
}
