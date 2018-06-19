package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayAction;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.personal.lixianspace.a;
import com.xunlei.downloadprovider.personal.lixianspace.expansion.a.b;
import com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.ColumnChartView;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: LXSpaceExpansionDlg */
public final class c extends XLBaseDialog {
    private static final String a = "c";
    private ColumnChartView b;
    private b c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private Button n;
    private PayAction o;

    public c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b) {
        super(context, (byte) -66);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_expansion_dlg);
        this.d = (ImageView) findViewById(R.id.lx_space_ex_title_bg);
        this.e = (ImageView) findViewById(R.id.lx_space_ex_year_icon);
        this.f = (ImageView) findViewById(R.id.lx_space_ex_vip_icon);
        this.g = (TextView) findViewById(R.id.lx_space_ex_vip_level);
        this.h = (TextView) findViewById(R.id.lx_space_ex_vip_level_tips);
        this.i = (TextView) findViewById(R.id.lx_space_ex_vip_normal);
        this.j = (TextView) findViewById(R.id.lx_space_exp_every_month_tips);
        this.k = (TextView) findViewById(R.id.lx_space_ex_current_count_tv);
        this.l = (TextView) findViewById(R.id.lx_space_ex_upgrade_count_tv);
        this.m = (TextView) findViewById(R.id.lx_space_ex_detial_tv);
        this.m.setOnClickListener(new e(this));
        this.b = (ColumnChartView) findViewById(R.id.lx_space_ex_ccv);
        this.n = (Button) findViewById(R.id.lx_space_ex_open_vip_btn);
        this.n.setOnClickListener(new f(this));
        findViewById(R.id.lx_space_ex_close_iv).setOnClickListener(new g(this));
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Glide.with(getContext()).load(LoginHelper.a().e()).diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.ic_default_avatar).error(R.drawable.ic_default_avatar).placeholder(R.drawable.ic_default_avatar).listener(new h(this)).dontAnimate().skipMemoryCache(false).into(300, 300);
        b();
        this.c.a((Object) "lx-space-download-config");
        c();
    }

    public final void show() {
        super.show();
        b();
        this.c.a((Object) "lx-space-download-config");
        c();
    }

    private void b() {
        if (this.c == null) {
            this.c = new b(getContext(), new d(this));
        }
    }

    public final void dismiss() {
        super.dismiss();
    }

    private void c() {
        boolean l = j.a().a.l();
        int d = j.a().d();
        int m = j.a().a.m();
        boolean e = j.a().e();
        int i = R.drawable.lx_space_ex_title_normal;
        if (l) {
            this.e.setVisibility(e ? 0 : 8);
            ImageView imageView = this.d;
            if (d == 5) {
                i = R.drawable.lx_space_ex_title_svip;
            }
            imageView.setImageResource(i);
            if (d == 2) {
                TextView textView = this.i;
                StringBuilder stringBuilder = new StringBuilder("普通会员 VIP");
                stringBuilder.append(m);
                textView.setText(stringBuilder.toString());
                this.i.setTextColor(getContext().getResources().getColor(R.color.lx_space_ex_normal_count));
                this.i.setVisibility(0);
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                return;
            }
            this.i.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setImageResource(d == 5 ? R.drawable.ic_super_vip_level : R.drawable.ic_normal_vip_level);
            this.g.setVisibility(0);
            this.g.setText(String.valueOf(m));
            return;
        }
        this.i.setText("非会员");
        this.i.setTextColor(getContext().getResources().getColor(R.color.lx_space_ex_current));
        this.i.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.d.setImageResource(R.drawable.lx_space_ex_title_normal);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("+");
            int indexOf2 = str.indexOf(k.t);
            if (indexOf == -1 || indexOf2 == -1) {
                this.l.setText(str);
            } else {
                CharSequence spannableString = new SpannableString(str);
                spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.upgrade_download_config_gray), 0, indexOf, 33);
                spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.upgrade_download_config_red), indexOf, indexOf2, 33);
                spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.upgrade_download_config_gray), indexOf2, str.length(), 33);
                this.l.setText(spannableString, BufferType.SPANNABLE);
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        CharSequence charSequence;
        boolean l = j.a().a.l();
        int d = j.a().d();
        j.a().a.m();
        boolean e = j.a().e();
        if (!l) {
            d = 0;
        }
        int b = a.b();
        int c = a.c();
        StringBuffer stringBuffer = new StringBuffer();
        if (l) {
            cVar.l.setVisibility(0);
            TextView textView = cVar.k;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("个");
            textView.setText(stringBuilder.toString());
            if (d == 5) {
                cVar.k.setTextColor(cVar.getContext().getResources().getColor(R.color.lx_space_ex_super_count));
                if (e) {
                    cVar.l.setText("");
                    cVar.l.setVisibility(8);
                    charSequence = "续费会员";
                } else {
                    stringBuffer.append("开通年费会员(+");
                    stringBuffer.append(c);
                    stringBuffer.append("个)");
                    charSequence = "开通年费会员";
                }
                PayAction payAction = new PayAction(PayUtil$OrderType.OPEN);
                payAction.c = 12;
                cVar.o = payAction;
            } else {
                cVar.k.setTextColor(cVar.getContext().getResources().getColor(R.color.lx_space_ex_normal_count));
                if (d == 3) {
                    charSequence = "升级超级会员";
                    stringBuffer.append("升级超级会员(+");
                    stringBuffer.append(c);
                    stringBuffer.append("个)");
                    cVar.o = new PayAction(PayUtil$OrderType.UPGRADE);
                } else {
                    charSequence = "开通超级会员";
                    stringBuffer.append("开通超级会员(+");
                    stringBuffer.append(c);
                    stringBuffer.append("个)");
                }
            }
            cVar.a(stringBuffer.toString());
        } else {
            cVar.a(cVar.getContext().getResources().getString(R.string.lx_space_exp_download_no));
            cVar.k.setTextColor(cVar.getContext().getResources().getColor(R.color.lx_space_ex_normal_count));
            cVar.l.setVisibility(8);
            charSequence = "开通会员";
        }
        cVar.n.setText(charSequence);
    }
}
