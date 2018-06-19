package com.xunlei.thunder.commonui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.thunder.commonui.R;

public class ErrorBlankView extends RelativeLayout {
    private View a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private Button e;
    private int f = 2;

    public ErrorBlankView(Context context) {
        super(context);
        a(context);
    }

    public ErrorBlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ErrorBlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public Button getActionButton() {
        return this.e;
    }

    private void a(Context context) {
        setBackgroundColor(-1);
        this.a = LayoutInflater.from(context).inflate(R.layout.commonui_layout_error_blank_view, null, false);
        this.a.setOnClickListener(null);
        this.b = (ImageView) this.a.findViewById(R.id.iv_icon);
        this.c = (TextView) this.a.findViewById(R.id.tv_title);
        this.d = (TextView) this.a.findViewById(R.id.tv_detail);
        this.e = (Button) this.a.findViewById(R.id.btn_action);
        context = new LayoutParams(-1, -2);
        context.addRule(15);
        addView(this.a, context);
        setErrorType(this.f);
    }

    public void setErrorType(int i) {
        this.f = i;
        if (i == 0) {
            this.b.setImageResource(R.drawable.commonui_bg_page_empty);
            this.c.setText(R.string.commonui_page_empty);
            this.d.setVisibility(8);
        } else if (i == 1) {
            this.b.setImageResource(R.drawable.commonui_bg_page_gone);
            this.c.setText(R.string.commonui_page_gone);
            this.d.setVisibility(8);
        } else if (i == 2) {
            this.b.setImageResource(R.drawable.commonui_bg_invalid_network);
            this.c.setText(R.string.commonui_invalid_network);
            this.d.setText(R.string.commonui_page_click_to_refresh);
            this.d.setVisibility(0);
        } else if (i == -2) {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        } else {
            this.b.setImageDrawable(null);
            this.c.setText("");
            this.d.setVisibility(8);
            this.f = -1;
        }
    }

    public int getErrorType() {
        return this.f;
    }

    public final void a(Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
        if (drawable == null) {
            this.b.setVisibility(8);
        } else {
            this.b.setImageDrawable(drawable);
            this.b.setVisibility(0);
        }
        this.c.setText(charSequence);
        if (TextUtils.isEmpty(charSequence2) != null) {
            this.d.setVisibility(4);
            return;
        }
        this.d.setText(charSequence2);
        this.d.setVisibility(0);
    }

    public final void a(@DrawableRes int i, @StringRes int i2) {
        if (i == 0) {
            this.b.setVisibility(8);
        } else {
            this.b.setImageResource(i);
            this.b.setVisibility(0);
        }
        this.c.setText(i2);
        this.d.setVisibility(4);
    }

    public final void a(String str, OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setText(str);
        this.e.setOnClickListener(onClickListener);
        this.e.setVisibility(null);
    }

    public void setActionButtonListener(OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setContentLayoutParams(int i) {
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        if (layoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
            layoutParams2.topMargin = i;
            layoutParams2.addRule(10);
            this.a.setLayoutParams(layoutParams2);
            return;
        }
        layoutParams.topMargin = i;
        layoutParams.addRule(10);
        requestLayout();
    }
}
