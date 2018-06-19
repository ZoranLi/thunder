package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: CancelPayTipsDialog */
public final class a extends XLBaseDialog {
    public OnClickListener a;
    public OnClickListener b;
    private View c;
    private ImageView d;
    private TextView e;

    public a(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.payment_dialog_paycancel_tips);
        setCanceledOnTouchOutside(null);
        this.d = (ImageView) findViewById(R.id.iv_paycancel_tips);
        this.c = findViewById(R.id.dlg_cancel_btn);
        this.c.setOnClickListener(new b(this));
        this.e = (TextView) findViewById(R.id.dlg_confirm_btn);
        this.e.setText("继续支付");
        this.e.setOnClickListener(new c(this));
    }

    public final void show() {
        super.show();
    }
}
