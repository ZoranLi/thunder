package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class PayOperateLayout extends RelativeLayout {
    private TextView a;
    private CheckBox b;
    private TextView c;
    private OnClickListener d;

    public PayOperateLayout(Context context) {
        super(context);
    }

    public PayOperateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PayOperateLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (CheckBox) findViewById(R.id.pay_operate_select_cb);
        this.a = (TextView) findViewById(R.id.pay_operate_tip_tv);
        this.c = (TextView) findViewById(R.id.pay_operate_type_tv);
        this.b.setChecked(true);
        setOnClickListener(new h(this));
    }

    public void setCheckListener(OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void setTips(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.setText("");
            this.b.setVisibility(8);
            return;
        }
        this.a.setText(Html.fromHtml(str.replace("<", "<font color=\"#F15E4A\"").replace(">", "</font>").replace("<font color=\"#F15E4A\"", "<font color=\"#F15E4A\">")));
        this.b.setVisibility(0);
    }

    public boolean getIsOperate() {
        return this.b.isChecked();
    }

    public void setTipsTextSize(int i) {
        this.a.setTextSize((float) i);
    }

    public void setDefaultCheck(boolean z) {
        this.b.setChecked(z);
    }

    public void setPayOpertateType(String str) {
        this.c.setText(str);
    }

    public TextView getPayOpertateTypeTv() {
        return this.c;
    }
}
