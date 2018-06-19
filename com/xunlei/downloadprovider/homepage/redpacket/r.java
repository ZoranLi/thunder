package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.u;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: RedPacketShareProfitDlg */
public final class r extends XLBaseDialog {
    private TextView a;
    private View b;
    private int c;
    private String d;
    private Context e;

    public r(Context context, int i, String str) {
        super(context, R.style.ThunderTheme.Dialog);
        this.e = context;
        this.c = i;
        this.d = str;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dlg_red_packet_share_profit);
        this.a = (TextView) findViewById(R.id.tv_profit_cash);
        findViewById(R.id.just_for_space).setOnClickListener(new s(this));
        this.b = findViewById(R.id.iv_profit_look);
        this.b.setOnClickListener(new t(this));
        findViewById(R.id.rl_packet_contain).setOnClickListener(new u(this));
        bundle = String.valueOf(((float) this.c) / 1000.0f);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle);
        stringBuilder.append("元");
        Object stringBuilder2 = stringBuilder.toString();
        CharSequence spannableString = new SpannableString(stringBuilder2);
        spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(40.0f)), 0, bundle.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, bundle.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(16.0f)), bundle.length(), stringBuilder2.length(), 33);
        this.a.setText(spannableString);
    }

    public final void show() {
        super.show();
        u.b(this.d);
    }
}
