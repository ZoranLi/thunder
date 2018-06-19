package com.xunlei.downloadprovider.member.payment.voucher;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class VoucherItemLayout extends RelativeLayout {
    TextView a;
    CheckBox b;
    boolean c;
    TextView d;
    float e;
    ProgressBar f;

    public VoucherItemLayout(Context context) {
        super(context);
    }

    public VoucherItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoucherItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.pay_voucher_item_tv);
        this.b = (CheckBox) findViewById(R.id.pay_voucher_item_select_cb);
        this.d = (TextView) findViewById(R.id.pay_voucher_item_lock_tv);
        this.d.setVisibility(isEnabled() ? 8 : 0);
        this.f = (ProgressBar) findViewById(R.id.loading_pb);
        this.f.setVisibility(8);
    }

    public void setChecked(boolean z) {
        this.c = z;
        this.b.setButtonDrawable(this.c ? R.drawable.ic_pay_selected : R.drawable.ic_pay_unselect);
    }
}
