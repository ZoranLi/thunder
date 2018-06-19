package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class PayRenewLayout extends RelativeLayout implements OnClickListener {
    CheckBox a;
    private TextView b;
    private a c;
    private TextView d;

    public interface a {
    }

    public PayRenewLayout(Context context) {
        super(context);
    }

    public PayRenewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PayRenewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (CheckBox) findViewById(R.id.auto_renew_select_cb);
        this.b = (TextView) findViewById(R.id.auto_renew_info_tv);
        this.d = (TextView) findViewById(R.id.auto_renew_title_tv);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.auto_renew_layout) {
            if (this.a.isChecked() != null) {
                this.a.setChecked(false);
            } else {
                this.a.setChecked(true);
            }
            if (this.c != null) {
                this.a.isChecked();
            }
        }
    }

    public void setRenewTextSize(int i) {
        i = (float) i;
        this.b.setTextSize(i);
        this.d.setTextSize(i);
    }

    public void setRenewText(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void setOnClickRenewLayoutListener(a aVar) {
        this.c = aVar;
    }
}
