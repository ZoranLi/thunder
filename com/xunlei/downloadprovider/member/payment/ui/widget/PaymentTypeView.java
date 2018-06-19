package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;

public final class PaymentTypeView extends LinearLayout implements OnClickListener {
    public View a;
    public View b;
    public View c;
    public View d;
    private CheckBox e;
    private CheckBox f;
    private a g;
    private int h;

    public interface a {
        void a(int i);
    }

    public static boolean a(int i) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
        }
        return true;
    }

    public PaymentTypeView(Context context) {
        this(context, null, 0);
    }

    public PaymentTypeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 2;
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.e = (CheckBox) findViewById(R.id.allipay_select_cb);
        this.f = (CheckBox) findViewById(R.id.wxpay_select_cb);
        this.c = findViewById(R.id.alipay_layout);
        this.c.setOnClickListener(this);
        this.d = findViewById(R.id.wxpay_layout);
        this.d.setOnClickListener(this);
        this.a = findViewById(R.id.payment_type_tip_tv);
        this.b = findViewById(R.id.payment_type_line_tv);
        a();
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view == R.id.wxpay_layout) {
            c();
        } else if (view == R.id.alipay_layout) {
            b();
        }
    }

    private void b() {
        this.f.setChecked(false);
        this.e.setChecked(true);
        this.h = 1;
        if (this.g != null) {
            this.g.a(this.h);
        }
    }

    private void c() {
        this.f.setChecked(true);
        this.e.setChecked(false);
        this.h = 2;
        if (this.g != null) {
            this.g.a(this.h);
        }
    }

    public final void setOnPaymentTypeSelectListener(a aVar) {
        this.g = aVar;
    }

    public final int getPayType() {
        return this.h;
    }

    private static boolean a(@android.support.annotation.NonNull android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = r2.getApplicationContext();
        r2 = r2.getPackageManager();
        r1 = "com.tencent.mm";	 Catch:{ NameNotFoundException -> 0x0017 }
        r2 = r2.getPackageInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x0017 }
        if (r2 == 0) goto L_0x0016;
    L_0x0014:
        r2 = 1;
        return r2;
    L_0x0016:
        return r0;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.ui.widget.PaymentTypeView.a(android.content.Context):boolean");
    }

    public final void a() {
        boolean a = a(getContext());
        int i = this.d.getVisibility() == 8 ? 1 : 0;
        if (a) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        if (i != 0 || !a || (!this.f.isChecked() && !this.e.isChecked())) {
            if (a && d.a().h.h()) {
                c();
            } else {
                b();
            }
        }
    }
}
