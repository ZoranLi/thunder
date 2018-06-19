package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.b.p;
import com.xunlei.downloadprovider.d.d;

public class KeyboardHelpView extends LinearLayout {
    private static boolean e = false;
    private String[] a;
    private String[] b;
    private TextView[] c;
    private boolean d;
    private boolean f;

    public KeyboardHelpView(Context context) {
        super(context);
        this.a = new String[]{"www.", "m.", "wap.", "https://", "http://"};
        this.b = new String[]{".", "/", ".com", ".cn", ".tw"};
        this.d = true;
        this.f = true;
        a(context);
    }

    public KeyboardHelpView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new String[]{"www.", "m.", "wap.", "https://", "http://"};
        this.b = new String[]{".", "/", ".com", ".cn", ".tw"};
        this.d = true;
        this.f = true;
        a(context);
    }

    public KeyboardHelpView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new String[]{"www.", "m.", "wap.", "https://", "http://"};
        this.b = new String[]{".", "/", ".com", ".cn", ".tw"};
        this.d = true;
        this.f = true;
        a(context);
    }

    private void a(Context context) {
        d.a().m.a(this.a);
        d.a().m.b(this.b);
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(0);
        b(context);
        setWordsOfViews(this.a);
    }

    public void setEditText(EditText editText) {
        editText = d.a().m;
        p.b();
    }

    private void b(Context context) {
        this.c = new TextView[(this.a.length >= this.b.length ? this.a.length : this.b.length)];
        for (int i = 0; i < this.c.length; i++) {
            View textView = new TextView(context);
            textView.setBackgroundResource(R.drawable.search_keyboard_hint_bg);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, DipPixelUtil.dip2px(30.0f), 1.0f);
            layoutParams.gravity = 17;
            if (i != this.c.length - 1) {
                layoutParams.setMargins(0, 0, DipPixelUtil.dip2px(5.0f), 0);
            }
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            this.c[i] = textView;
            addView(textView);
        }
    }

    private void setWordsOfViews(String[] strArr) {
        for (int i = 0; i < this.c.length; i++) {
            if (i < strArr.length) {
                this.c[i].setText(strArr[i]);
                this.c[i].setVisibility(0);
            } else {
                this.c[i].setVisibility(8);
            }
        }
    }

    public static void a() {
        p pVar = d.a().m;
        p.b();
    }

    public static void b() {
        p pVar = d.a().m;
        p.b();
    }

    public static void c() {
        p pVar = d.a().m;
        p.b();
    }

    public void setTextViewOnClickListener(OnClickListener onClickListener) {
        onClickListener = d.a().m;
        p.b();
    }
}
