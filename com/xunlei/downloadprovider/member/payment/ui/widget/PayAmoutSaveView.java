package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;

public class PayAmoutSaveView extends LinearLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    public PayAmoutSaveView(Context context) {
        this(context, null, 0);
    }

    public PayAmoutSaveView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayAmoutSaveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.pay_amount_tv);
        this.b = (TextView) findViewById(R.id.save_price_tv);
        this.c = (TextView) findViewById(R.id.pay_amount_tip_tv);
        this.d = (TextView) findViewById(R.id.pay_unit_tip_tv);
        this.e = (TextView) findViewById(R.id.operate_tv);
    }

    public final PayAmoutSaveView a(int i) {
        if (i < 12) {
            i = 12;
        }
        this.c.setTextSize(2, (float) i);
        return this;
    }

    public final PayAmoutSaveView b(int i) {
        if (i < 12) {
            i = 12;
        }
        this.d.setTextSize(2, (float) i);
        return this;
    }

    public final PayAmoutSaveView c(int i) {
        if (i < 12) {
            i = 12;
        }
        this.a.setTextSize(2, (float) i);
        return this;
    }

    public final PayAmoutSaveView d(int i) {
        if (i < 12) {
            i = 12;
        }
        this.b.setTextSize(2, (float) i);
        return this;
    }

    public final void a(float f) {
        if (f > 0.0f) {
            this.e.setText("");
            this.b.setVisibility(0);
            this.b.setText(Html.fromHtml(this.b.getContext().getResources().getString(R.string.pay_save_money_html, new Object[]{PayUtil.a(f)})));
            return;
        }
        this.b.setVisibility(8);
        this.b.setText("");
    }

    public final void b(float f) {
        if (f <= 0.0f) {
            setVisibility(8);
            this.a.setText("");
            a(f);
            return;
        }
        setVisibility(0);
        this.a.setText(PayUtil.b(f));
    }

    public void setOperateTip(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e.setText("");
            this.b.setVisibility(0);
            return;
        }
        this.e.setText(Html.fromHtml(str.replace("<", "<font color=\"#F15E4A\"").replace(">", "</font>").replace("<font color=\"#F15E4A\"", "<font color=\"#F15E4A\">")));
        this.b.setVisibility(8);
    }
}
