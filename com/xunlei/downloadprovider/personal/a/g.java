package com.xunlei.downloadprovider.personal.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import java.util.Locale;

/* compiled from: RenewalNewStyleDlg */
public final class g extends XLBaseDialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    private ImageView e;
    private TextView f;

    public g(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        context = LayoutInflater.from(this.mCtx).inflate(R.layout.dialog_usercenter_renewal_new_style, null);
        this.e = (ImageView) context.findViewById(R.id.dlg_renew_user_type_iv);
        this.f = (TextView) context.findViewById(R.id.dlg_renew_user_type_tv);
        this.a = (TextView) context.findViewById(R.id.dlg_renew_expire_tip_tv);
        this.b = (TextView) context.findViewById(R.id.dlg_renew_open_vip_btn);
        this.c = (TextView) context.findViewById(R.id.dlg_renew_open_svip_btn);
        this.d = (TextView) context.findViewById(R.id.dlg_renew_detail_tv);
        context.findViewById(R.id.dlg_cancel_iv).setOnClickListener(new h(this));
        setContentView(context);
    }

    public final void a() {
        int i;
        String str = "普通会员";
        if (LoginHelper.a().t()) {
            str = "超级会员";
            i = R.drawable.renew_dlg_svip_ic;
        } else if (LoginHelper.a().s()) {
            str = "白金会员";
            i = R.drawable.renew_dlg_bj_ic;
        } else {
            i = R.drawable.renew_dlg_normal_ic;
        }
        this.f.setText(String.format(Locale.CHINA, this.mCtx.getResources().getString(R.string.renew_dlg_user_type_format), new Object[]{str}));
        this.e.setImageResource(i);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "立即续费";
        }
        if (LoginHelper.a().t()) {
            this.b.setVisibility(8);
            this.c.setText(str);
            this.c.setTextColor(Color.parseColor("#F6CD64"));
            this.c.setBackgroundDrawable(this.mCtx.getResources().getDrawable(R.drawable.renew_dark_black_dlg_btn_bg));
            return;
        }
        this.c.setText("开通超会");
        this.c.setTextColor(Color.parseColor("#DCA358"));
        this.c.setBackgroundDrawable(this.mCtx.getResources().getDrawable(R.drawable.renew_dark_black_bg));
        this.b.setVisibility(0);
        this.b.setText(str);
        if (LoginHelper.a().s() != null) {
            this.b.setTextColor(Color.parseColor("#DCA358"));
            this.b.setBackgroundDrawable(this.mCtx.getResources().getDrawable(R.drawable.renew_light_orange_bg));
            return;
        }
        this.b.setTextColor(Color.parseColor("#1AA3FF"));
        this.b.setBackgroundDrawable(this.mCtx.getResources().getDrawable(R.drawable.renew_light_blue_bg));
    }
}
