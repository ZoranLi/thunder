package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.k;
import com.xunlei.downloadprovider.member.b.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.h;
import com.xunlei.downloadprovider.member.payment.external.i;
import com.xunlei.downloadprovider.member.payment.f;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChoicenessVipRenewalRemindItemView extends RelativeLayout {
    k a;
    private d b;
    private a c;
    private Context d;
    private PreferenceHelper e;
    private final String f = f.a(PayFrom.HOME_CHOICE_RENEW);
    private i g = new ap(this);
    private final OnClickListener h = new aq(this);
    private boolean i = null;

    private static class a {
        TextView a;
        TextView b;
        TextView c;
        ImageView d;
        ImageView e;

        private a() {
        }
    }

    public ChoicenessVipRenewalRemindItemView(Context context, d dVar, k kVar) {
        super(context);
        this.a = kVar;
        a(context);
        if (dVar != null) {
            if (this.b == null) {
                this.b = dVar;
            }
            if (this.c == null) {
                this.c = (a) getTag();
            }
            this.c.a.setText(this.b.b());
            this.c.b.setText(this.b.c());
            this.c.c.setText(this.b.d());
            if (this.i != null) {
                context = j.a().d();
                long b = PayUtil.b(j.a().f());
                if (5 != context) {
                    if (b >= 0) {
                        this.c.c.setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.renew_red_light_btg));
                        this.c.c.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                }
                this.c.c.setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.renew_dark_black_bg));
                this.c.c.setTextColor(Color.parseColor("#FFDA8C"));
            } else {
                this.c.c.setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.bg_sy_renew));
                this.c.c.setTextColor(Color.parseColor("#FFFFFF"));
            }
            if (this.c != null) {
                if (this.c.e != null) {
                    if (this.i != null) {
                        this.c.e.setVisibility(0);
                        context = j.a().d();
                        if (5 == context) {
                            this.c.e.setImageResource(R.drawable.renew_svip_style_old_ic);
                        } else if (PayUtil.b(j.a().f()) < 0) {
                            this.c.e.setImageResource(R.drawable.renew_speedup_style_old_ic);
                        } else if (3 == context) {
                            this.c.e.setImageResource(R.drawable.renew_baijin_style_old_ic);
                        } else {
                            this.c.e.setImageResource(R.drawable.renew_normal_style_old_ic);
                        }
                    } else {
                        this.c.e.setVisibility(8);
                    }
                }
            }
        }
        if (this.c == null) {
            this.c = (a) getTag();
        }
        this.c.c.setOnClickListener(this.h);
        this.c.d.setOnClickListener(this.h);
        setOnClickListener(new an(this));
        LoginHelper.a().a(new ao(this));
        h.a().addObserver(this.g);
    }

    public ChoicenessVipRenewalRemindItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessVipRenewalRemindItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        if (this.d == null) {
            this.d = context;
        }
        this.i = com.xunlei.downloadprovider.d.d.a().h.j();
        context = LayoutInflater.from(context).inflate(this.i ? R.layout.choiceness_renewal_new_style_item : R.layout.choiceness_renewal_item, this, true);
        if (this.c == null) {
            this.c = new a();
        }
        this.c.a = (TextView) context.findViewById(R.id.item_main_title);
        this.c.b = (TextView) context.findViewById(R.id.item_sub_title);
        this.c.c = (TextView) context.findViewById(R.id.item_btn_renew);
        this.c.d = (ImageView) context.findViewById(R.id.item_delete_icon);
        this.c.e = (ImageView) context.findViewById(R.id.renew_user_type_iv);
        setTag(this.c);
    }

    private String getBubbleid() {
        return this.b != null ? this.b.f() : "";
    }

    static /* synthetic */ void e(ChoicenessVipRenewalRemindItemView choicenessVipRenewalRemindItemView) {
        if (choicenessVipRenewalRemindItemView.e == null) {
            choicenessVipRenewalRemindItemView.e = new PreferenceHelper(choicenessVipRenewalRemindItemView.d, "vip_renew_homePage");
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        choicenessVipRenewalRemindItemView = choicenessVipRenewalRemindItemView.e;
        StringBuilder stringBuilder = new StringBuilder("dateAndUser");
        stringBuilder.append(LoginHelper.a().g.c());
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(format);
        stringBuilder3.append(LoginHelper.a().g.c());
        choicenessVipRenewalRemindItemView.putString(stringBuilder2, stringBuilder3.toString());
    }
}
