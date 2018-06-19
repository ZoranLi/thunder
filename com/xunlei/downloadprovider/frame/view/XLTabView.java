package com.xunlei.downloadprovider.frame.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class XLTabView extends LinearLayout {
    public String a;
    private int b;
    private String c;
    private View d;
    private TextView e;
    private ImageView f;
    private TextView g;

    @SuppressLint({"NewApi"})
    public XLTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public XLTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XLTabView(Context context) {
        super(context);
        a(context);
    }

    public String getTabTag() {
        return this.a;
    }

    public final XLTabView a(int i) {
        this.b = i;
        this.e.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
        return this;
    }

    public String getText() {
        return this.c;
    }

    public final XLTabView a(String str) {
        this.c = str;
        this.e.setText(str);
        return this;
    }

    @SuppressLint({"NewApi"})
    private void a(Context context) {
        this.d = LayoutInflater.from(context).inflate(R.layout.common_buttom_tab_item, this);
        this.e = (TextView) this.d.findViewById(R.id.common_buttom_tab_content_tv);
        this.f = (ImageView) this.d.findViewById(R.id.common_buttom_tab_point);
        this.g = (TextView) this.d.findViewById(R.id.common_button_tab_point_tv);
    }

    public void setSelection(boolean z) {
        this.d.setSelected(z);
        this.e.setSelected(z);
    }

    public void setPointVisible(int i) {
        this.f.setVisibility(i);
    }

    public final boolean a() {
        return this.f != null && this.f.getVisibility() == 0;
    }

    public void setPointTvVisible(int i) {
        this.g.setVisibility(i);
    }

    public void setPointTvText(String str) {
        this.g.setText(str);
    }
}
