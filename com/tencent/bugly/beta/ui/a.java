package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.c;
import com.tencent.bugly.beta.utils.e;

/* compiled from: BUGLY */
public abstract class a extends b {
    protected Context a;
    protected View b;
    protected FrameLayout c;
    protected LinearLayout d;
    protected ImageView e;
    protected TextView f;
    protected TextView g;
    protected TextView h;
    protected LinearLayout i;
    protected ResBean j;
    protected int k;
    protected int l;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getActivity();
        this.j = ResBean.a;
        if (this.l == 0) {
            TextView textView;
            r0.b = new RelativeLayout(r0.a);
            ((RelativeLayout) r0.b).setGravity(17);
            r0.b.setBackgroundColor(Color.argb(100, 0, 0, 0));
            r0.c = new FrameLayout(r0.a);
            r0.c.setLayoutParams(new LayoutParams(-2, -2));
            r0.d = new LinearLayout(r0.a);
            r0.d.setBackgroundColor(-1);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            r0.d.setGravity(17);
            r0.d.setLayoutParams(layoutParams);
            r0.d.setMinimumWidth(com.tencent.bugly.beta.global.a.a(r0.a, 280.0f));
            r0.d.setOrientation(1);
            if (r0.k == 2) {
                r11 = new float[8];
                float a = (float) com.tencent.bugly.beta.global.a.a(r0.a, 6.0f);
                r11[0] = a;
                r11[1] = a;
                r11[2] = a;
                r11[3] = a;
                r11[4] = a;
                r11[5] = a;
                r11[6] = a;
                r11[7] = a;
                Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(r11, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Style.FILL_AND_STROKE);
                r0.d.setBackgroundDrawable(shapeDrawable);
            }
            r0.f = new TextView(r0.a);
            r0.f.setGravity(16);
            r0.f.setSingleLine();
            TextView textView2 = r0.f;
            r0.j.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            r0.f.setTextSize(18.0f);
            r0.f.setLayoutParams(layoutParams);
            r0.f.setOnClickListener(null);
            r0.f.setEllipsize(TruncateAt.END);
            int a2 = com.tencent.bugly.beta.global.a.a(r0.a, 16.0f);
            r0.f.setPadding(a2, 0, a2, 0);
            r0.f.setTypeface(null, 1);
            r0.f.setHeight(com.tencent.bugly.beta.global.a.a(r0.a, 42.0f));
            r0.f.setTag(Beta.TAG_TITLE);
            View textView3 = new TextView(r0.a);
            textView3.setBackgroundColor(-3355444);
            textView3.setHeight(1);
            View scrollView = new ScrollView(r0.a);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, com.tencent.bugly.beta.global.a.a(r0.a, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            r0.i = new LinearLayout(r0.a);
            r0.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r0.i.setOrientation(1);
            r0.i.setPadding(a2, com.tencent.bugly.beta.global.a.a(r0.a, 10.0f), a2, 0);
            View linearLayout = new LinearLayout(r0.a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            int i = a2 / 2;
            linearLayout.setPadding(i, a2, i, a2);
            LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout.setLayoutParams(layoutParams3);
            LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i, 0, i, 0);
            r0.g = new TextView(r0.a);
            r0.g.setSingleLine();
            r0.g.setGravity(17);
            r0.g.setTag(Beta.TAG_CANCEL_BUTTON);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            i = com.tencent.bugly.beta.global.a.a(r0.a, 30.0f);
            if (r0.k == 2) {
                LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i, i);
                layoutParams6.gravity = 53;
                r0.g.setLayoutParams(layoutParams6);
                r0.g.setTextSize((float) (((double) i) * 0.3d));
            } else {
                r0.g.setLayoutParams(layoutParams4);
                r0.g.setTextSize(16.0f);
                textView = r0.g;
                r0.j.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                r0.g.setPadding(com.tencent.bugly.beta.global.a.a(r0.a, 10.0f), com.tencent.bugly.beta.global.a.a(r0.a, 5.0f), com.tencent.bugly.beta.global.a.a(r0.a, 10.0f), com.tencent.bugly.beta.global.a.a(r0.a, 5.0f));
            }
            r0.h = new TextView(r0.a);
            r0.h.setLayoutParams(layoutParams4);
            r0.h.setGravity(17);
            r0.h.setTextSize(16.0f);
            textView = r0.h;
            r0.j.getClass();
            textView.setTextColor(Color.parseColor("#273238"));
            r0.h.setSingleLine();
            r0.h.setPadding(com.tencent.bugly.beta.global.a.a(r0.a, 10.0f), com.tencent.bugly.beta.global.a.a(r0.a, 5.0f), com.tencent.bugly.beta.global.a.a(r0.a, 10.0f), com.tencent.bugly.beta.global.a.a(r0.a, 5.0f));
            r0.h.setTypeface(null, 1);
            r0.h.setTag(Beta.TAG_CONFIRM_BUTTON);
            int a3 = com.tencent.bugly.beta.global.a.a(r0.a, 40.0f);
            scrollView.addView(r0.i);
            if (r0.k == 2) {
                View frameLayout = new FrameLayout(r0.a);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i2 = i / 2;
                int i3 = i2 - 5;
                r0.c.setPadding(i2, i3, i3, i2);
                frameLayout.addView(r0.c);
                frameLayout.addView(r0.g);
                ((RelativeLayout) r0.b).addView(frameLayout);
            } else {
                r0.b.setPadding(a3, a3, a3, a3);
                ((RelativeLayout) r0.b).addView(r0.c);
                linearLayout.addView(r0.g);
            }
            r0.d.addView(r0.f);
            r0.d.addView(textView3);
            r0.d.addView(scrollView);
            r0.c.addView(r0.d);
            linearLayout.addView(r0.h);
            r0.c.addView(linearLayout);
            if (r0.k == 2) {
                Paint paint = new Paint();
                paint.setStyle(Style.FILL);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
                a3 = i / 2;
                Canvas canvas = new Canvas(createBitmap);
                paint.setColor(-3355444);
                float f = (float) a3;
                canvas.drawCircle(f, f, f, paint);
                canvas.rotate(45.0f, f, f);
                paint.setColor(-7829368);
                int a4 = com.tencent.bugly.beta.global.a.a(r0.a, 0.8f);
                float f2 = f * 0.4f;
                float f3 = (float) (a3 - a4);
                float f4 = f * 1.6f;
                float f5 = (float) (a3 + a4);
                Canvas canvas2 = canvas;
                float f6 = f5;
                float f7 = f5;
                Paint paint2 = paint;
                canvas2.drawRect(f2, f3, f4, f6, paint2);
                canvas2.drawRect(f3, f2, f7, f4, paint2);
                canvas.rotate(-45.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(i, i, Config.ARGB_8888);
                canvas = new Canvas(createBitmap2);
                paint.setColor(-7829368);
                canvas.drawCircle(f, f, f, paint);
                canvas.rotate(45.0f, f, f);
                paint.setColor(-3355444);
                canvas2 = canvas;
                canvas2.drawRect(f2, f3, f4, f7, paint2);
                canvas2.drawRect(f3, f2, f7, f4, paint2);
                canvas.rotate(-45.0f);
                Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                r0.g.setBackgroundDrawable(bitmapDrawable);
                r0.g.setOnTouchListener(new c(1, new Object[]{bitmapDrawable2, bitmapDrawable}));
            }
            r0.b.setOnClickListener(null);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            r0.b.startAnimation(alphaAnimation);
        } else {
            LayoutInflater layoutInflater2 = layoutInflater;
            r0.b = layoutInflater2.inflate(r0.l, null);
            r0.e = (ImageView) r0.b.findViewWithTag(Beta.TAG_IMG_BANNER);
            r0.f = (TextView) r0.b.findViewWithTag(Beta.TAG_TITLE);
            r0.g = (TextView) r0.b.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            r0.h = (TextView) r0.b.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        r0.g.setVisibility(8);
        r0.h.setVisibility(8);
        r0.g.setFocusable(true);
        r0.h.setFocusable(true);
        r0.h.requestFocus();
        return r0.b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    protected void a(String str, OnClickListener onClickListener, String str2, OnClickListener onClickListener2) {
        e.a(new 1(this, str, onClickListener, str2, onClickListener2));
    }

    public void a() {
        if (this.b == null) {
            super.a();
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        e.a(new 2(this, alphaAnimation));
        alphaAnimation.setAnimationListener(new 3(this));
    }
}
