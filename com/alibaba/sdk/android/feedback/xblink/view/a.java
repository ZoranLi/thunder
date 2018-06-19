package com.alibaba.sdk.android.feedback.xblink.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;

public class a {
    private Context a;
    private View b;
    private PopupWindow c;
    private FrameLayout d;
    private LinearLayout e;
    private Animation f;
    private c g;

    public a(Context context, View view, String str, String[] strArr, OnClickListener onClickListener) {
        this.a = context;
        this.b = view;
        a(str, strArr, onClickListener);
        c();
        this.f = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        this.f.setDuration(250);
    }

    public a(Context context, View view, String[] strArr, OnClickListener onClickListener) {
        this(context, view, null, strArr, onClickListener);
    }

    private void a(String str, String[] strArr, OnClickListener onClickListener) {
        this.d = new FrameLayout(this.a);
        this.d.setLayoutParams(new LayoutParams(-1, -1));
        this.e = new LinearLayout(this.a);
        this.e.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.e.setLayoutParams(layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View button = new Button(this.a);
            button.setText(str);
            button.setBackgroundColor(-657931);
            button.setTextColor(-7829368);
            button.setLayoutParams(layoutParams);
            this.e.addView(button);
            View textView = new TextView(this.a);
            textView.setHeight(2);
            this.e.addView(textView);
        }
        if (strArr != null) {
            for (CharSequence charSequence : strArr) {
                View button2 = new Button(this.a);
                button2.setText(charSequence);
                button2.setTag(charSequence);
                button2.setBackgroundColor(-657931);
                button2.setTextColor(Color.rgb(28, 128, 255));
                button2.setLayoutParams(layoutParams);
                button2.setOnClickListener(onClickListener);
                button2.setPadding(0, 30, 0, 30);
                button2.setBackgroundResource(R.drawable.ali_feedback_popup_bg);
                ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.bottomMargin = 20;
                layoutParams2.leftMargin = 20;
                layoutParams2.rightMargin = 20;
                this.e.addView(button2, layoutParams2);
                View textView2 = new TextView(this.a);
                textView2.setHeight(2);
                this.e.addView(textView2);
            }
        }
        this.d.addView(this.e);
        this.d.setOnTouchListener(new b(this));
    }

    private void c() {
        this.c = new PopupWindow(this.a);
        this.c.setContentView(this.d);
        this.c.setWidth(-1);
        this.c.setHeight(-1);
        this.c.setFocusable(true);
        this.c.setOutsideTouchable(true);
        this.c.setBackgroundDrawable(new ColorDrawable(2130706432));
    }

    public void a() {
        this.c.showAtLocation(this.b, 81, 0, 0);
        this.e.startAnimation(this.f);
        this.c.update();
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void b() {
        this.c.dismiss();
    }
}
