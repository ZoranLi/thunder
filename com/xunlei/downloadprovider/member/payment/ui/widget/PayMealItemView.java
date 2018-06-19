package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;

public class PayMealItemView extends RelativeLayout implements Checkable {
    public TextView a;
    public TextView b;
    public TextView c;
    public boolean d;
    public String e;
    public int f;
    public boolean g;
    private ImageView h;
    private boolean i;
    private Context j;

    public static float a(int i, float f, float f2) {
        float f3 = (((float) i) * f) - f2;
        return f3 < 0.0f ? 0.0f : f3;
    }

    public PayMealItemView(Context context) {
        this(context, null, 0);
    }

    public PayMealItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = true;
    }

    public PayMealItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = true;
        this.j = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.meal_month);
        this.b = (TextView) findViewById(R.id.meal_price);
        this.c = (TextView) findViewById(R.id.meal_save);
        this.h = (ImageView) findViewById(R.id.meal_select_flag_iv);
    }

    public void setChecked(boolean z) {
        this.i = z;
        setSelected(this.i);
        this.h.setVisibility(this.i ? 0 : 8);
    }

    public boolean isChecked() {
        return this.i;
    }

    public void toggle() {
        setChecked(this.i ^ 1);
    }

    public static String a(int i, float f) {
        return PayUtil.a(f / ((float) i));
    }

    public void setIsNeedHideSubscript(boolean z) {
        this.g = z;
    }
}
