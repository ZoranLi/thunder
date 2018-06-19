package com.xunlei.downloadprovider.web.base.core;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class WebTitleBar extends FrameLayout {
    public TextView a;
    private String b;
    private CustomWebView c;
    private ImageView d;
    private View e;
    private TextView f;
    private View g;
    private a h = null;

    public interface a {
        void a();
    }

    public WebTitleBar(Context context) {
        super(context);
        a(context);
    }

    public WebTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.web_title_bar, this, false);
        addView(inflate, new LayoutParams(-1, -2));
        this.d = (ImageView) inflate.findViewById(R.id.goback_btn);
        this.d.setOnClickListener(new ah(this, context));
        this.e = inflate.findViewById(R.id.cancel_btn);
        this.e.setOnClickListener(new ai(this, context));
        this.f = (TextView) inflate.findViewById(R.id.title);
        this.a = (TextView) inflate.findViewById(R.id.right_text);
        this.g = inflate.findViewById(R.id.title_line);
    }

    public String getTitleText() {
        return this.b;
    }

    public void setTitleText(String str) {
        this.b = str;
        this.f.setText(str);
    }

    public final void a(CustomWebView customWebView) {
        this.c = customWebView;
        customWebView.a(new aj(this));
    }

    public void setOnRightTextClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setRightText(String str) {
        this.a.setText(str);
    }

    private void a() {
        if (this.c == null) {
            throw new UnsupportedOperationException("should call bindWebView() method");
        }
    }

    public void setTitleAlpha(float f) {
        if (f == 0.0f) {
            this.d.setImageResource(R.drawable.short_list_back_icon_selector);
        } else {
            this.d.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        }
        f = (int) (255.0f * f);
        setBackgroundColor(Color.argb(f, 255, 255, 255));
        this.f.setTextColor(Color.argb(f, 51, 51, 51));
        int color = getResources().getColor(R.color.search_line_color);
        this.g.setBackgroundColor(Color.argb(f, Color.red(color), Color.green(color), Color.blue(color)));
    }

    public void setOnGoBackClickListener(OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnQuitListener(a aVar) {
        this.h = aVar;
    }

    public TextView getmTitleView() {
        return this.f;
    }

    static /* synthetic */ void c(WebTitleBar webTitleBar) {
        webTitleBar.a();
        if (webTitleBar.c.h()) {
            webTitleBar.e.setVisibility(0);
        } else {
            webTitleBar.e.setVisibility(8);
        }
    }
}
