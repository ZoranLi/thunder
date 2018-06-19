package com.xunlei.downloadprovider.member.payment.activity.widget;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.activity.b;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;

public class ActivityItemView extends RelativeLayout implements Checkable {
    public b a;
    public TextView b;
    public TextView c;
    public Context d;
    private boolean e;
    private TextView f;
    private ImageView g;
    private boolean h;

    public ActivityItemView(Context context) {
        this(context, null, 0);
    }

    public ActivityItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.d = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (TextView) findViewById(R.id.activity_pay_item_month_tv);
        this.f = (TextView) findViewById(R.id.activity_pay_item_price_tv);
        this.c = (TextView) findViewById(R.id.activity_pay_item_subscript_tv);
        this.g = (ImageView) findViewById(R.id.activity_pay_item_select_flag_iv);
        this.c.setVisibility(8);
    }

    public final void a() {
        if (!TextUtils.isEmpty(this.a.i)) {
            CharSequence charSequence = this.a.i;
            if (charSequence.contains("<") && charSequence.contains(">")) {
                this.f.setText(Html.fromHtml(charSequence.replace("<", "<font color=\"#F15E4A\"").replace(">", "</font>").replace("<font color=\"#F15E4A\"", "<font color=\"#F15E4A\">")));
                return;
            }
            this.f.setText(charSequence);
        } else if (this.a.t) {
            this.f.setText(this.d.getString(R.string.pay_meal_total_price, new Object[]{PayUtil.a(this.a.l)}));
        } else {
            this.f.setText(this.d.getString(R.string.pay_meal_month_unit_price, new Object[]{PayUtil.a(this.a.l / ((float) this.a.h))}));
        }
    }

    public int getRealPayMonth() {
        return this.a != null ? this.a.a : 0;
    }

    public double getTotalPayPrice() {
        return this.a != null ? this.a.b : 0.0d;
    }

    public String getPayAward() {
        return this.a != null ? this.a.e : "";
    }

    public String getPayTips() {
        return this.a != null ? this.a.d : "";
    }

    public String getExtParams() {
        return this.a != null ? this.a.f : "";
    }

    public String getActiveId() {
        return this.a != null ? this.a.g : "";
    }

    public void setChecked(boolean z) {
        this.e = z;
        setSelected(this.e);
        this.g.setVisibility(this.e ? 0 : 8);
        a();
    }

    public boolean isChecked() {
        return this.e;
    }

    public void toggle() {
        setChecked(this.e ^ 1);
    }

    public void setActivitySelectedState(boolean z) {
        this.h = z;
    }
}
