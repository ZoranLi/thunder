package com.xunlei.downloadprovider.member.payment.voucher;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import java.util.List;

public final class VoucherItemView extends RelativeLayout {
    public c a;
    public List<Voucher> b;
    public float c;
    public int d;
    public String e;
    private Voucher f;
    private TextView g;
    private n h;
    private a i;
    private a j;

    public interface a {
        void a();
    }

    public VoucherItemView(Context context) {
        this(context, null, 0);
    }

    public VoucherItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoucherItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new m(this);
        a(context);
    }

    @TargetApi(21)
    public VoucherItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.i = new m(this);
        a(context);
    }

    private void a(Context context) {
        setPadding(context.getResources().getDimensionPixelOffset(R.dimen.payment_12_dp), 0, context.getResources().getDimensionPixelOffset(R.dimen.payment_13_dp), 0);
        View textView = new TextView(context);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setText("使用代金券");
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        addView(textView, layoutParams);
        this.g = new TextView(context);
        this.g.setTextSize(1, 14.0f);
        this.g.setCompoundDrawablePadding(context.getResources().getDimensionPixelOffset(R.dimen.payment_9_dp));
        this.g.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(R.drawable.ic_right_more), null);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        addView(this.g, layoutParams2);
        setVisibility(8);
        setOnClickListener(new l(this, context));
    }

    public final void a(Voucher voucher) {
        this.f = voucher;
        a();
        if (this.j != null) {
            this.j.a();
        }
    }

    public final void a() {
        if (this.b != null) {
            if (!this.b.isEmpty()) {
                setVisibility(0);
                if (this.a.a(this.c, this.d, this.e, this.f)) {
                    this.g.setText(Html.fromHtml(getResources().getString(R.string.pay_voucher_format_item, new Object[]{PayUtil.a(this.f.a)})));
                    return;
                }
                c();
                if (this.a.a(this.c, this.d, this.e, this.b)) {
                    this.g.setTextColor(getResources().getColor(R.color.payment_gray_acount_tips));
                    this.g.setText(getResources().getString(R.string.pay_voucher_list_avaiable));
                    return;
                }
                this.g.setTextColor(getResources().getColor(R.color.payment_gray_acount_tips));
                this.g.setText(getResources().getString(R.string.pay_voucher_list_unavaiable));
                return;
            }
        }
        b();
    }

    public final float getVoucherPrice() {
        return this.f != null ? this.f.a : 0.0f;
    }

    public final String getVoucherCode() {
        return this.f != null ? this.f.b : "";
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.dismiss();
            this.i = null;
            this.h.b = null;
        }
    }

    public final void setOnVoucherChangeListener(a aVar) {
        this.j = aVar;
    }

    public final void b() {
        c();
        setVisibility(8);
    }

    private void c() {
        this.f = null;
        if (this.h != null) {
            b.b(this.h.a, null);
        }
    }
}
