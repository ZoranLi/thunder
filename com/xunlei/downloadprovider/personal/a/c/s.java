package com.xunlei.downloadprovider.personal.a.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.AnimationDot;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.speedup.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.r;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.b;
import com.xunlei.downloadprovider.personal.a.j;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info.MessageCenterDispatchInfo;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.MessageCenterActivity;
import com.xunlei.downloadprovider.personal.message.data.d;
import com.xunlei.downloadprovider.personal.settings.SettingsIndexActivity;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountBindMobileActivity;
import com.xunlei.downloadprovider.personal.user.account.ui.UserAccountInfoActivity;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;
import com.xunlei.downloadprovider.publiser.common.h;
import com.xunlei.downloadprovider.publiser.per.br;
import com.xunlei.thunder.commonui.widget.CircleImageView;
import com.xunlei.xllib.b.k;
import java.util.List;
import java.util.Observer;

/* compiled from: UserInfoViewHolder */
public class s extends a implements b {
    private static boolean J = true;
    private static boolean K = true;
    private static String L = null;
    private static String M = null;
    private static int N = 0;
    private static final String a = "s";
    private TextView A;
    private View B;
    private View C;
    private TextView D;
    private TextView E;
    private ImageView F;
    private ImageView G;
    private View H;
    private a I;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private long S;
    private int T;
    private UserCenterFragment U;
    private StaticHandler V;
    private LoginHelper W;
    private FragmentActivity X;
    private MessageListener Y = new ac(this);
    private final g Z = new ad(this);
    private Runnable aa = new ak(this);
    private RelativeLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private RelativeLayout g;
    private View h;
    private CircleImageView i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private ImageView m;
    private TextView n;
    private RelativeLayout o;
    private TextView p;
    private TextView q;
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private LinearLayout y;
    private AnimationDot z;

    public s(View view, FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        super(view);
        this.U = userCenterFragment;
        this.X = fragmentActivity;
        this.W = LoginHelper.a();
        this.U.a(this, "key_user_info_view");
        this.V = new StaticHandler(this.Y);
        this.b = (RelativeLayout) view.findViewById(R.id.rl_setting_icon_contain);
        this.c = (ImageView) view.findViewById(R.id.iv_message_icon);
        this.d = (TextView) view.findViewById(R.id.tv_message_count);
        this.e = (TextView) view.findViewById(R.id.tv_user_msg_pop_text);
        this.f = (ImageView) view.findViewById(R.id.iv_message_red_point);
        this.h = view.findViewById(R.id.already_login_layout);
        this.i = (CircleImageView) view.findViewById(R.id.iv_user_icon);
        this.j = (TextView) view.findViewById(R.id.tv_user_name);
        this.k = (ImageView) view.findViewById(R.id.iv_member_type_icon);
        this.l = (TextView) view.findViewById(R.id.tv_member_level);
        this.m = (ImageView) view.findViewById(R.id.iv_year_vip_icon);
        this.n = (TextView) view.findViewById(R.id.tv_expiration_date);
        this.o = (RelativeLayout) view.findViewById(R.id.user_guide_bar);
        this.p = (TextView) view.findViewById(R.id.tv_user_guide_language);
        this.q = (TextView) view.findViewById(R.id.tv_user_guide_btn);
        this.r = (LinearLayout) view.findViewById(R.id.user_center_fans_bar);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_follow_contain);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_fans_contain);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_visitors_contain);
        this.s = (TextView) view.findViewById(R.id.tv_follow_count);
        this.t = (TextView) view.findViewById(R.id.tv_fans_count);
        this.u = (TextView) view.findViewById(R.id.tv_visitor_count);
        this.g = (RelativeLayout) view.findViewById(R.id.not_login_layout);
        this.y = (LinearLayout) view.findViewById(R.id.ll_logging_layout);
        this.z = (AnimationDot) view.findViewById(R.id.login_animation_dot);
        this.A = (TextView) view.findViewById(R.id.tv_not_login);
        this.B = view.findViewById(R.id.rl_vip_icon);
        this.C = view.findViewById(R.id.member_action_fl);
        this.D = (TextView) view.findViewById(R.id.member_action_tv);
        this.E = (TextView) view.findViewById(R.id.member_action_subtitle_tv);
        this.F = (ImageView) view.findViewById(R.id.user_head_sculpture_iv);
        this.G = (ImageView) view.findViewById(R.id.member_action_flash_iv);
        this.H = view.findViewById(R.id.member_action_ll);
    }

    private void c(String str) {
        MessageCenterActivity.a(this.itemView.getContext(), new MessageCenterDispatchInfo(str, this.T));
    }

    private void b(int i) {
        if (i > 0) {
            this.l.setText(String.valueOf(i));
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.k.setImageResource(R.drawable.ic_normal_vip_no_level);
        this.l.setVisibility(8);
    }

    private void c(int i) {
        if (i > 0) {
            this.l.setText(String.valueOf(i));
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.k.setImageResource(R.drawable.ic_normal_vip_no_level);
        this.l.setVisibility(8);
    }

    private void d(int i) {
        if (i > 0) {
            this.l.setText(String.valueOf(i));
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.k.setImageResource(R.drawable.ic_normal_vip_no_level);
        this.l.setVisibility(8);
    }

    private void h() {
        this.k.setImageResource(R.drawable.ic_kuainiao_vip);
        this.l.setVisibility(8);
    }

    private void e(int i) {
        CharSequence i2 = this.W.i();
        int i3 = 8;
        StringBuilder stringBuilder;
        if (i < 80) {
            this.o.setVisibility(0);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("%");
            Object replace = BrothersApplication.getApplicationInstance().getString(R.string.user_center_guide_bar2).replace("%s", stringBuilder2.toString());
            if (i != 0) {
                i3 = 9;
            }
            CharSequence spannableString = new SpannableString(replace);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#b99b64")), 0, i3, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#fd8e3a")), i3, replace.length(), 33);
            this.q.setText(R.string.user_center_guide_btn2);
            this.p.setText(spannableString);
            if (!this.O) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("%");
                j.a(stringBuilder.toString(), TextUtils.isEmpty(i2) ^ true, "accountbar");
                this.O = true;
            }
        } else if (TextUtils.isEmpty(i2)) {
            this.o.setVisibility(0);
            Object string = BrothersApplication.getApplicationInstance().getString(R.string.user_center_guide_bar1);
            CharSequence spannableString2 = new SpannableString(string);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#b99b64")), 0, 9, 33);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#fd8e3a")), 9, string.length(), 33);
            this.q.setText(R.string.user_center_guide_btn1);
            this.p.setText(spannableString2);
            if (!this.O) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("%");
                j.a(stringBuilder.toString(), TextUtils.isEmpty(i2) ^ true, "phonebar");
                this.O = true;
            }
        } else {
            this.o.setVisibility(8);
        }
    }

    private void i() {
        long d = (long) com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b().d();
        if (this.d != null) {
            if (!l.c()) {
                this.d.setVisibility(8);
            } else if (d > 0) {
                this.d.setVisibility(0);
                if (d <= 99) {
                    this.d.setText(String.valueOf(d));
                    return;
                }
                this.d.setText("99+");
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    private void j() {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j b = com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b();
        com.xunlei.downloadprovider.personal.message.data.s sVar = b.e() ? new com.xunlei.downloadprovider.personal.message.data.s() : com.xunlei.downloadprovider.personal.message.data.s.a(b.a, b.b.a.b());
        int i = sVar.a;
        int i2 = sVar.b;
        int i3 = sVar.c;
        int i4 = sVar.e;
        int i5 = sVar.d;
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            this.T = 5;
            this.e.setVisibility(8);
            if (i5 > 0) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(8);
            }
        } else if (i > 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            this.T = 1;
            f((int) R.string.user_center_msg_pop_comment);
        } else if (i == 0 && i2 > 0 && i3 == 0 && i4 == 0) {
            this.T = 3;
            f((int) R.string.user_center_msg_pop_follow);
        } else if (i == 0 && i2 == 0 && i3 > 0 && i4 == 0) {
            this.T = 2;
            f((int) R.string.user_center_msg_pop_start);
        } else if (i == 0 && i2 == 0 && i3 == 0 && i4 > 0) {
            this.T = 5;
            f((int) R.string.user_center_msg_pop_chat);
        } else {
            this.T = 5;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((i + i2) + i3) + i4);
            String replace = applicationInstance.getString(R.string.user_center_msg_pop_text).replace("%s", stringBuilder.toString());
            this.e.setVisibility(0);
            this.e.setText(replace);
            d(replace);
        }
    }

    private void f(int i) {
        String string = BrothersApplication.getApplicationInstance().getString(i);
        this.e.setVisibility(0);
        this.e.setText(string);
        d(string);
    }

    private static void d(String str) {
        if (K) {
            j.a(k.a(str));
            K = null;
        }
    }

    public final void a() {
        K = true;
        if (this.W.b.b) {
            this.z.show();
            this.g.setClickable(false);
            this.y.setVisibility(0);
            this.A.setVisibility(8);
            return;
        }
        this.z.hide();
        this.g.setClickable(true);
        this.y.setVisibility(8);
        this.A.setVisibility(0);
    }

    public final void b() {
        k();
    }

    private void k() {
        if (this.V != null) {
            this.V.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        super.c();
        if (UserCenterFragment.a) {
            this.W.a(this.Z);
            Observer aeVar = new ae(this);
            com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b().addObserver(aeVar);
            this.U.c = aeVar;
            UserCenterFragment.a = false;
        }
    }

    public final void d() {
        super.d();
        this.W.b(this.Z);
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b().deleteObserver(this.U.c);
        UserCenterFragment.a = true;
        l();
        k();
    }

    private void l() {
        this.H.removeCallbacks(this.aa);
        if (this.I != null) {
            a aVar = this.I;
            aVar.a.removeCallbacks(aVar.f);
            aVar.d.stop();
        }
        this.H.setVisibility(8);
    }

    public final void a(Object obj) {
        this.P = true;
        if (l.c()) {
            PayUtil$OrderType payUtil$OrderType;
            long a;
            int f;
            boolean g;
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            this.j.setText(this.W.n());
            this.i.setBackgroundResource(R.drawable.user_center_default_avatar);
            Object e = this.W.e();
            if (!TextUtils.isEmpty(e)) {
                boolean z = com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) && J;
                Context context = this.i.getContext();
                if ((context instanceof Activity) && VERSION.SDK_INT >= 17) {
                    Activity activity = (Activity) context;
                    if (!activity.isFinishing()) {
                        if (activity.isDestroyed()) {
                        }
                    }
                }
                Glide.with(context).load(e).diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.ic_default_avatar).error(R.drawable.ic_default_avatar).placeholder(R.drawable.ic_default_avatar).listener(new ag(this)).dontAnimate().skipMemoryCache(z).into(this.i);
            }
            int d = com.xunlei.downloadprovider.member.payment.a.j.a().d();
            if (!com.xunlei.downloadprovider.member.payment.a.j.a().c()) {
                payUtil$OrderType = PayUtil$OrderType.OPEN;
            } else if (i.b(d)) {
                payUtil$OrderType = PayUtil$OrderType.RENEW;
            } else {
                a = com.xunlei.downloadprovider.personal.a.f.a.a(LoginHelper.a().o());
                if (a == -1) {
                    payUtil$OrderType = PayUtil$OrderType.OPEN;
                } else if (a < 31) {
                    payUtil$OrderType = PayUtil$OrderType.RENEW;
                } else {
                    payUtil$OrderType = PayUtil$OrderType.UPGRADE;
                }
            }
            TextView textView = this.D;
            d = payUtil$OrderType == PayUtil$OrderType.UPGRADE ? R.string.user_center_btn_update : payUtil$OrderType == PayUtil$OrderType.RENEW ? R.string.user_center_btn_renew : R.string.user_center_btn_member;
            textView.setText(d);
            this.E.setVisibility(8);
            r b = c.a().b(f.a(PayFrom.PERSONAL_CENTER_FAST_PAY));
            if (b != null) {
                if (!TextUtils.isEmpty(b.b)) {
                    this.D.setText(b.b);
                }
                if (!TextUtils.isEmpty(b.d)) {
                    this.E.setVisibility(0);
                    this.E.setText(b.d);
                }
            }
            if (com.xunlei.downloadprovider.member.payment.a.j.a().c()) {
                if (i.b(com.xunlei.downloadprovider.member.payment.a.j.a().d())) {
                    this.h.setBackgroundDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.bg_user_center_top_supvip));
                } else {
                    this.h.setBackgroundDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.bg_user_center_top_baijin));
                }
                this.i.setBorderWidth((int) TypedValue.applyDimension(0, 5.0f, this.itemView.getContext().getResources().getDisplayMetrics()));
                this.i.setBorderColor(Color.parseColor("#EFBE53"));
                this.F.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) this.i.getLayoutParams();
                layoutParams.topMargin = (int) TypedValue.applyDimension(1, 9.0f, this.itemView.getContext().getResources().getDisplayMetrics());
                this.i.setLayoutParams(layoutParams);
            } else {
                this.h.setBackgroundDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.bg_user_center_top));
                this.i.setBorderWidth(0);
                this.F.setVisibility(8);
                LayoutParams layoutParams2 = (LayoutParams) this.i.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.i.setLayoutParams(layoutParams2);
            }
            this.H.setVisibility(0);
            this.H.removeCallbacks(this.aa);
            this.H.post(this.aa);
            if (this.W.l() == null) {
                if (this.W.g.g() == null) {
                    this.n.setVisibility(8);
                    obj = this.W.l();
                    d = this.W.m();
                    f = this.W.g.f();
                    g = this.W.g.g();
                    if (f != 0) {
                        if (f != 5) {
                            switch (f) {
                                case 2:
                                    if (obj != null) {
                                        if (!g) {
                                            h();
                                            break;
                                        }
                                        this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                                        this.k.setImageResource(R.drawable.ic_normal_vip_expirate);
                                        b(d);
                                        break;
                                    }
                                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                                    this.k.setImageResource(R.drawable.ic_normal_vip_level);
                                    b(d);
                                    break;
                                case 3:
                                    if (obj != null) {
                                        if (!g) {
                                            h();
                                            break;
                                        }
                                        this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                                        this.k.setImageResource(R.drawable.ic_normal_vip_expirate);
                                        c(d);
                                        break;
                                    }
                                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                                    this.k.setImageResource(R.drawable.ic_normal_vip_level);
                                    c(d);
                                    break;
                                default:
                                    if (g) {
                                        h();
                                        break;
                                    }
                                    break;
                            }
                        } else if (obj != null) {
                            this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                            this.k.setImageResource(R.drawable.ic_super_vip_level);
                            d(d);
                        } else if (g) {
                            this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                            this.k.setImageResource(R.drawable.ic_super_vip_expirate);
                            d(d);
                        } else {
                            h();
                        }
                    } else if (g) {
                        this.k.setImageResource(R.drawable.ic_normal_vip_no_level);
                        this.l.setVisibility(8);
                    } else {
                        h();
                    }
                    if (obj == null) {
                        if (g) {
                            this.m.setImageResource(R.drawable.ic_year_vip_gray);
                            this.O = false;
                            if (!(l.c() == null || (UserCenterFragment.b == null && TextUtils.isEmpty(this.W.i()) == null))) {
                                e(UserCenterFragment.b);
                            }
                            com.xunlei.downloadprovider.personal.a.f.a.a(this.V);
                            this.r.setVisibility(0);
                            if (com.xunlei.xllib.android.b.a(this.itemView.getContext()) == null) {
                                L = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_follow_count", "0");
                                M = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_fans_count", "0");
                                N = com.xunlei.downloadprovider.personal.a.a.a().a("key_user_visitor_count");
                            }
                            if (TextUtils.isEmpty(L) == null) {
                                this.s.setText(L);
                            }
                            if (TextUtils.isEmpty(M) == null) {
                                this.t.setText(M);
                            }
                            this.u.setText(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) N));
                            new h().a(this.W.g.c(), new ai(this));
                            if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
                                VisitorNetworkHelper.a().a(this.W.g.c(), new aj(this));
                            }
                            com.xunlei.downloadprovider.personal.a.a.a().c();
                        }
                    }
                    if (this.W.u() == null) {
                        this.m.setImageResource(R.drawable.ic_year_vip_red);
                    } else {
                        this.m.setImageResource(R.drawable.ic_year_vip_gray);
                    }
                    this.O = false;
                    e(UserCenterFragment.b);
                    com.xunlei.downloadprovider.personal.a.f.a.a(this.V);
                    this.r.setVisibility(0);
                    if (com.xunlei.xllib.android.b.a(this.itemView.getContext()) == null) {
                        L = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_follow_count", "0");
                        M = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_fans_count", "0");
                        N = com.xunlei.downloadprovider.personal.a.a.a().a("key_user_visitor_count");
                    }
                    if (TextUtils.isEmpty(L) == null) {
                        this.s.setText(L);
                    }
                    if (TextUtils.isEmpty(M) == null) {
                        this.t.setText(M);
                    }
                    this.u.setText(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) N));
                    new h().a(this.W.g.c(), new ai(this));
                    if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
                        VisitorNetworkHelper.a().a(this.W.g.c(), new aj(this));
                    }
                    com.xunlei.downloadprovider.personal.a.a.a().c();
                }
            }
            a = com.xunlei.downloadprovider.personal.a.f.a.a(this.W.o());
            obj = new StringBuilder("getMemberExpireDate days = ");
            obj.append(this.W.o());
            obj.append(", ");
            obj.append(a);
            if (a >= 0) {
                if (a == 0) {
                    this.n.setText("今日到期");
                } else {
                    obj = new StringBuilder("剩");
                    obj.append(a);
                    obj.append("天到期");
                    this.n.setText(obj.toString());
                }
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            obj = this.W.l();
            d = this.W.m();
            f = this.W.g.f();
            g = this.W.g.g();
            if (f != 0) {
                if (f != 5) {
                    switch (f) {
                        case 2:
                            if (obj != null) {
                                if (!g) {
                                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                                    this.k.setImageResource(R.drawable.ic_normal_vip_expirate);
                                    b(d);
                                    break;
                                }
                                h();
                                break;
                            }
                            this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                            this.k.setImageResource(R.drawable.ic_normal_vip_level);
                            b(d);
                            break;
                        case 3:
                            if (obj != null) {
                                if (!g) {
                                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                                    this.k.setImageResource(R.drawable.ic_normal_vip_expirate);
                                    c(d);
                                    break;
                                }
                                h();
                                break;
                            }
                            this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                            this.k.setImageResource(R.drawable.ic_normal_vip_level);
                            c(d);
                            break;
                        default:
                            if (g) {
                                h();
                                break;
                            }
                            break;
                    }
                } else if (obj != null) {
                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_isvip_level_color));
                    this.k.setImageResource(R.drawable.ic_super_vip_level);
                    d(d);
                } else if (g) {
                    this.l.setTextColor(ContextCompat.getColor(BrothersApplication.getApplicationInstance(), R.color.me_notvip_level_color));
                    this.k.setImageResource(R.drawable.ic_super_vip_expirate);
                    d(d);
                } else {
                    h();
                }
            } else if (g) {
                this.k.setImageResource(R.drawable.ic_normal_vip_no_level);
                this.l.setVisibility(8);
            } else {
                h();
            }
            if (obj == null) {
                if (g) {
                    this.m.setImageResource(R.drawable.ic_year_vip_gray);
                    this.O = false;
                    e(UserCenterFragment.b);
                    com.xunlei.downloadprovider.personal.a.f.a.a(this.V);
                    this.r.setVisibility(0);
                    if (com.xunlei.xllib.android.b.a(this.itemView.getContext()) == null) {
                        L = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_follow_count", "0");
                        M = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_fans_count", "0");
                        N = com.xunlei.downloadprovider.personal.a.a.a().a("key_user_visitor_count");
                    }
                    if (TextUtils.isEmpty(L) == null) {
                        this.s.setText(L);
                    }
                    if (TextUtils.isEmpty(M) == null) {
                        this.t.setText(M);
                    }
                    this.u.setText(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) N));
                    new h().a(this.W.g.c(), new ai(this));
                    if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
                        VisitorNetworkHelper.a().a(this.W.g.c(), new aj(this));
                    }
                    com.xunlei.downloadprovider.personal.a.a.a().c();
                }
            }
            if (this.W.u() == null) {
                this.m.setImageResource(R.drawable.ic_year_vip_gray);
            } else {
                this.m.setImageResource(R.drawable.ic_year_vip_red);
            }
            this.O = false;
            e(UserCenterFragment.b);
            com.xunlei.downloadprovider.personal.a.f.a.a(this.V);
            this.r.setVisibility(0);
            if (com.xunlei.xllib.android.b.a(this.itemView.getContext()) == null) {
                L = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_follow_count", "0");
                M = com.xunlei.downloadprovider.personal.a.a.a().b("key_user_fans_count", "0");
                N = com.xunlei.downloadprovider.personal.a.a.a().a("key_user_visitor_count");
            }
            if (TextUtils.isEmpty(L) == null) {
                this.s.setText(L);
            }
            if (TextUtils.isEmpty(M) == null) {
                this.t.setText(M);
            }
            this.u.setText(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) N));
            new h().a(this.W.g.c(), new ai(this));
            if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
                VisitorNetworkHelper.a().a(this.W.g.c(), new aj(this));
            }
            com.xunlei.downloadprovider.personal.a.a.a().c();
        } else {
            this.h.setVisibility(8);
            this.g.setVisibility(0);
            this.o.setVisibility(8);
            this.r.setVisibility(8);
            this.d.setVisibility(8);
        }
        if (l.c() != null) {
            i();
            j();
            d.a(BrothersApplication.getApplicationInstance()).a(this.W.g.c(), new ah(this));
        } else {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
        }
        this.b.setOnClickListener(new t(this));
        this.c.setOnClickListener(new af(this));
        this.g.setOnClickListener(new al(this));
        this.i.setOnClickListener(new am(this));
        this.j.setOnClickListener(new an(this));
        this.o.setOnClickListener(new ao(this));
        this.p.setOnClickListener(new ap(this));
        this.q.setOnClickListener(new aq(this));
        this.v.setOnClickListener(new ar(this));
        this.w.setOnClickListener(new u(this));
        this.x.setOnClickListener(new v(this));
        this.e.setOnClickListener(new w(this));
        this.B.setOnClickListener(new x(this));
        this.m.setOnClickListener(new y(this));
        this.C.setOnClickListener(new z(this));
    }

    static /* synthetic */ void a(s sVar) {
        j.a("top_config", false);
        sVar.X.startActivity(new Intent(sVar.X, SettingsIndexActivity.class));
        sVar.X.overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
        br.b();
    }

    static /* synthetic */ void a(s sVar, String str) {
        j.a("top_messcenter", false);
        if (sVar.W != null) {
            if (l.c()) {
                sVar.c(str);
                return;
            }
            LoginHelper.a().a(sVar.itemView.getContext(), new aa(sVar, str), LoginFrom.MESSAGE_CENTER, null);
        }
    }

    static /* synthetic */ void b(s sVar) {
        j.a("head_usericon", false);
        sVar.W.a(sVar.X, null, LoginFrom.SELF_LOGIN, null);
    }

    static /* synthetic */ void d(s sVar) {
        boolean isEmpty = TextUtils.isEmpty(sVar.W.i()) ^ 1;
        if (sVar.R < 80) {
            j.a("head_usericon", false);
            UserAccountInfoActivity.a(sVar.X, "accountbar");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sVar.R);
            stringBuilder.append("%");
            j.b(stringBuilder.toString(), isEmpty, "accountbar");
            return;
        }
        if (!isEmpty) {
            UserAccountBindMobileActivity.a(sVar.X, false, "phonebar");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(sVar.R);
            stringBuilder2.append("%");
            j.b(stringBuilder2.toString(), false, "phonebar");
        }
    }

    static /* synthetic */ void g(s sVar) {
        com.xunlei.downloadprovider.personal.a.b.h hVar;
        String str = "http://act.vip.xunlei.com/vip/2015/shoulei_v2/";
        List list = com.xunlei.downloadprovider.personal.a.d.d.a().a;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hVar = (com.xunlei.downloadprovider.personal.a.b.h) list.get(i);
                if (TextUtils.equals(hVar.c, "member_center")) {
                    break;
                }
            }
        }
        hVar = null;
        if (!(hVar == null || TextUtils.isEmpty(hVar.g))) {
            str = hVar.g;
        }
        if (sVar.W.l()) {
            com.xunlei.downloadprovider.personal.a.i.a(sVar.X, str, sVar.X.getString(R.string.xunlei_member_center), "per_cl");
        } else {
            PaymentEntryActivity.a(sVar.X, PayFrom.PERSONAL_CENTER_VIP_INFO_AREA);
        }
        sVar = HubbleEventBuilder.build("android_personal_click", "per_vipicon_click");
        LoginHelper.a();
        sVar.add("is_login", l.c());
        sVar.add("is_vip", LoginHelper.a().l());
        ThunderReport.reportEvent(sVar);
    }

    static /* synthetic */ void h(s sVar) {
        int i = 0;
        j.a("bar_pay", false);
        PaymentEntryActivity.a(sVar.X, PayFrom.PERSONAL_CENTER_FAST_PAY);
        int a = (int) com.xunlei.downloadprovider.personal.a.f.a.a(sVar.W.o());
        if (sVar.Q == 1) {
            i = 1;
        }
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_cl_pay");
        build.add("is_vip", LoginHelper.a().l());
        build.add("rest_days", a);
        build.add("isrenew", i);
        com.xunlei.downloadprovider.personal.user.f.a(build);
    }
}
