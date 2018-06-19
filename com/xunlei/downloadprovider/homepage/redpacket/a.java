package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: RedPacketGuideDlg */
public final class a extends XLBaseDialog {
    private RelativeLayout a;
    private RelativeLayout b;
    private LottieAnimationView c;
    private LottieAnimationView d;
    private LottieAnimationView e;
    private LottieAnimationView f;
    private ImageView g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private LoginHelper k = LoginHelper.a();
    private StaticHandler l;
    private d m = new f(this);
    private MessageListener n = new g(this);

    public final void onBackPressed() {
    }

    public a(Context context) {
        super(context, R.style.RedPacketGuideStyle);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dlg_red_packet_guide);
        bundle = getWindow();
        if (bundle != null) {
            bundle.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = bundle.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            bundle.setAttributes(attributes);
        }
        this.l = new StaticHandler(this.n);
        this.k.a(this.m);
        this.a = (RelativeLayout) findViewById(R.id.rl_is_new_contain);
        this.b = (RelativeLayout) findViewById(R.id.rl_get_packet_contain);
        this.i = (ImageView) findViewById(R.id.iv_get_packet_press);
        this.j = (TextView) findViewById(R.id.tv_cash_count);
        this.h = (TextView) findViewById(R.id.tv_give_up_red_packet);
        this.g = (ImageView) findViewById(R.id.iv_get_packet);
        this.e = (LottieAnimationView) findViewById(R.id.lottie_view_red_packet1);
        this.f = (LottieAnimationView) findViewById(R.id.lottie_view_red_packet2);
        this.d = (LottieAnimationView) findViewById(R.id.lottie_view_button);
        this.c = (LottieAnimationView) findViewById(R.id.lottie_view_get_packet);
        this.d.setImageAssetsFolder("lottie/luckybtn/images");
        this.d.setAnimation("lottie/luckybtn/data.json");
        this.e.setImageAssetsFolder("lottie/luckymoney1/images");
        this.e.setAnimation("lottie/luckymoney1/data.json");
        this.f.setImageAssetsFolder("lottie/luckymoney2/images");
        this.f.setAnimation("lottie/luckymoney2/data.json");
        this.f.setVisibility(4);
        this.e.postDelayed(new b(this), 300);
        this.d.setOnClickListener(new c(this));
        this.h.setOnClickListener(new d(this));
        this.g.setOnClickListener(new e(this));
    }

    private void a() {
        j.a();
        j.b(new h(this));
    }

    private void a(boolean z) {
        if (z) {
            this.i.setVisibility(8);
            this.d.setClickable(true);
            XLToast.showToast(this.mCtx, "获取红包失败");
            return;
        }
        this.i.setVisibility(0);
        this.d.setClickable(false);
    }

    public final void show() {
        super.show();
        f.a(this.mCtx, "key_has_show_new_packet", true);
        com.xunlei.downloadprovider.personal.redenvelope.f.a(HubbleEventBuilder.build("android_packet", "packet_show_invite_new"));
    }

    public final void dismiss() {
        this.k.b(this.m);
        super.dismiss();
    }

    static /* synthetic */ void a(a aVar) {
        aVar.e.a();
        aVar.e.setMaxProgress(0.9f);
        aVar.d.a();
        aVar.e.a(new i(aVar));
    }

    static /* synthetic */ void b(a aVar) {
        aVar.a(false);
        if (aVar.k.b.e) {
            aVar.a();
        } else {
            aVar.k.a(null, LoginFrom.HOME_HONGBAO_GET.toString(), "new_hongbao");
        }
    }

    static /* synthetic */ void a(a aVar, Message message) {
        aVar.e.c();
        aVar.f.c();
        aVar.d.c();
        aVar.a.setVisibility(8);
        aVar.b.setVisibility(0);
        aVar.c.setImageAssetsFolder("lottie/luckymoney3/images");
        aVar.c.setAnimation("lottie/luckymoney3/data.json");
        aVar.c.setSpeed(1.5f);
        aVar.c.a();
        message = String.valueOf(((Float) message.obj).floatValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        stringBuilder.append("元");
        Object stringBuilder2 = stringBuilder.toString();
        CharSequence spannableString = new SpannableString(stringBuilder2);
        spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(40.0f)), 0, message.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, message.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(16.0f)), message.length(), stringBuilder2.length(), 33);
        aVar.j.setText(spannableString);
        com.xunlei.downloadprovider.personal.redenvelope.f.a(HubbleEventBuilder.build("android_packet", "packet_complete_invite_new"));
    }
}
