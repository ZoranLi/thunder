package com.xunlei.downloadprovider.personal.user.account.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class UserAccountItem extends LinearLayout {
    private TextView a;
    private TextView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;

    public UserAccountItem(Context context) {
        super(context);
        a(context);
    }

    public UserAccountItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UserAccountItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.user_account_item, this);
        this.a = (TextView) findViewById(R.id.tv_account_item_name);
        this.b = (TextView) findViewById(R.id.tv_account_item_tip_text);
        this.c = (ImageView) findViewById(R.id.iv_account_item_tip_pic);
        this.d = (ImageView) findViewById(R.id.tv_account_item_tip_icon);
        this.e = (ImageView) findViewById(R.id.iv_account_item_go);
    }

    public void setAccountItemName(int i) {
        this.a.setText(i);
    }

    public void setItemTipPicVisibility(int i) {
        this.c.setVisibility(i);
    }

    public ImageView getAccountItemTipPic() {
        return this.c;
    }

    public void setItemTipIconVisibility(int i) {
        this.d.setVisibility(i);
    }

    public void setItemTipTextVisibility(int i) {
        this.b.setVisibility(i);
    }

    public void setItemGoVisibility(int i) {
        this.e.setVisibility(i);
    }

    public void setItemTipPic(int i) {
        this.c.setBackgroundResource(i);
    }

    public void setItemTipText(int i) {
        this.b.setText(i);
    }

    public void setItemTipText(String str) {
        this.b.setText(str);
    }

    public CharSequence getItemTipText() {
        return this.b.getText();
    }

    public void setItemTipTextColor(int i) {
        this.b.setTextColor(i);
    }
}
