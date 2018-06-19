package com.xunlei.downloadprovider.personal.score;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import java.util.Arrays;
import java.util.List;

/* compiled from: UserSignInDialog */
public final class p extends XLBaseDialog {
    ImageView a;
    TextView b;
    private SignInOneDayView c;
    private SignInOneDayView d;
    private SignInOneDayView e;
    private SignInOneDayView f;
    private SignInOneDayView g;
    private SignInOneDayView h;
    private SignInOneDayView i;
    private TextView j;
    private int k;
    private List<Integer> l;
    private Context m;

    public p(Context context, int i) {
        super(context, R.style.ThunderTheme.Dialog);
        r1 = new Integer[7];
        int i2 = 5;
        int i3 = 0;
        r1[0] = Integer.valueOf(5);
        r1[1] = Integer.valueOf(5);
        r1[2] = Integer.valueOf(5);
        r1[3] = Integer.valueOf(5);
        r1[4] = Integer.valueOf(5);
        r1[5] = Integer.valueOf(5);
        r1[6] = Integer.valueOf(20);
        this.l = Arrays.asList(r1);
        this.k = i;
        this.m = context;
        context = LayoutInflater.from(this.m).inflate(R.layout.xl_sign_in_dialog, null);
        this.c = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_1);
        this.d = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_2);
        this.e = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_3);
        this.f = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_4);
        this.g = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_5);
        this.h = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_6);
        this.i = (SignInOneDayView) context.findViewById(R.id.sign_in_card_day_7);
        this.a = (ImageView) context.findViewById(R.id.iv_sign_in_dlg_close);
        this.b = (TextView) context.findViewById(R.id.tv_sign_in_btn);
        this.j = (TextView) context.findViewById(R.id.tv_sign_in_title);
        setContentView(context);
        context = Arrays.asList(new SignInOneDayView[]{this.c, this.d, this.e, this.f, this.g, this.h, this.i});
        i = Arrays.asList(new String[]{"x5", "x5", "x5", "x5", "x5", "x5", "x20"});
        while (i3 < context.size()) {
            SignInOneDayView signInOneDayView = (SignInOneDayView) context.get(i3);
            StringBuilder stringBuilder = new StringBuilder("第");
            int i4 = i3 + 1;
            stringBuilder.append(i4);
            stringBuilder.append("天");
            signInOneDayView.setTvSignInDays(stringBuilder.toString());
            signInOneDayView.setTvSignInCoins((String) i.get(i3));
            i3 = i4;
        }
        a(context);
        context = this.k;
        if (this.k > 7) {
            context = this.k % 7;
        }
        if (context == 7) {
            i2 = 6;
        }
        i = new SpannableString(BrothersApplication.getApplicationInstance().getString(R.string.user_center_sign_in_title).replace("%s", String.valueOf(((Integer) this.l.get(context - 1)).intValue())));
        i.setSpan(new ForegroundColorSpan(Color.parseColor("#0f97ff")), 4, i2, 33);
        this.j.setText(i);
    }

    private void a(List<SignInOneDayView> list) {
        int i = this.k;
        if (this.k > 7) {
            i = this.k % 7;
        }
        for (int i2 = 0; i2 < i; i2++) {
            ((SignInOneDayView) list.get(i2)).setIvGoldCoinVisibility(0);
        }
    }
}
