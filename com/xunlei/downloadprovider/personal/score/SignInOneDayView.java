package com.xunlei.downloadprovider.personal.score;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class SignInOneDayView extends RelativeLayout {
    private TextView a;
    private TextView b;
    private ImageView c;

    public SignInOneDayView(Context context) {
        super(context);
        a(context);
    }

    public SignInOneDayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SignInOneDayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.xl_sign_in_one_day, this);
        this.a = (TextView) findViewById(R.id.tv_sign_in_days);
        this.b = (TextView) findViewById(R.id.tv_sign_in_coins);
        this.c = (ImageView) findViewById(R.id.iv_gold_coin_receive);
    }

    public void setTvSignInDays(String str) {
        this.a.setText(str);
    }

    public void setTvSignInCoins(String str) {
        this.b.setText(str);
    }

    public void setIvGoldCoinVisibility(int i) {
        this.c.setVisibility(i);
    }
}
