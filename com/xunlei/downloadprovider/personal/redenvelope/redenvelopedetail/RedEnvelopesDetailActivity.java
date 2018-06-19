package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.h;
import com.xunlei.downloadprovider.member.payment.external.i;
import com.xunlei.downloadprovider.personal.redenvelope.f;
import com.xunlei.downloadprovider.personal.redenvelope.g;
import com.xunlei.downloadprovider.personal.redenvelope.g.a;
import com.xunlei.downloadprovider.personal.redenvelope.k;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.e;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;

public class RedEnvelopesDetailActivity extends BaseActivity {
    private ImageView a;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private UnifiedLoadingView o;
    private ErrorBlankView p;
    private int q;
    private String r;
    private e s;
    private Runnable t;
    private final Handler u = new Handler();
    private boolean v;
    private boolean w;
    @Nullable
    private d x = null;
    private a y = new f(this);
    private i z = new j(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a().addObserver(this.z);
        setContentView(R.layout.activity_red_envelopes_detail);
        bundle = new TitleBar((Activity) this);
        bundle.mTitle.setText(R.string.red_envelopes_title_bar_name);
        bundle.mRight1.setVisibility(0);
        this.p = (ErrorBlankView) findViewById(R.id.ev_show);
        this.a = (ImageView) findViewById(R.id.iv_red_gift_icon);
        this.c = (ImageView) findViewById(R.id.iv_red_gift_used_icon);
        this.d = (TextView) findViewById(R.id.tv_red_gift_title);
        this.e = (TextView) findViewById(R.id.tv_red_gift_left_time);
        this.f = (TextView) findViewById(R.id.tv_red_gift_content);
        this.g = (TextView) findViewById(R.id.tv_red_gift_convert_content);
        this.h = (TextView) findViewById(R.id.tv_red_gift_use_method_info);
        this.i = (LinearLayout) findViewById(R.id.rl_red_activation_code);
        this.j = (TextView) findViewById(R.id.tv_red_code);
        this.k = (TextView) findViewById(R.id.tv_red_code_copy);
        this.l = (TextView) findViewById(R.id.tv_support_android);
        this.m = (TextView) findViewById(R.id.tv_support_ios);
        this.n = (TextView) findViewById(R.id.tv_red_detail_bottom_btn);
        this.o = (UnifiedLoadingView) findViewById(R.id.red_envelopes_loading_view);
        this.o.setType(2);
        this.o.setBackgroundColor(Color.parseColor("#ffffff"));
        this.o.hidePageLoadingViewBack();
        bundle = getIntent();
        this.q = bundle.getIntExtra("extra_red_id", -1);
        this.r = bundle.getStringExtra("extra_red_from");
        a();
        this.n.setOnClickListener(new d(this));
        this.k.setOnClickListener(new e(this));
    }

    private void a() {
        if (b.a(getApplicationContext())) {
            if (com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a.a == null) {
                com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a.a = new com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a();
            }
            XLThreadPool.execute(new com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.b(com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a.a, String.valueOf(this.q), new a(this)));
            return;
        }
        b();
    }

    private void a(long j) {
        this.c.setVisibility(0);
        this.d.setTextColor(Color.parseColor("#999999"));
        this.e.setTextColor(Color.parseColor("#999999"));
        this.e.setText(com.xunlei.downloadprovider.personal.redenvelope.e.b.replace("%s", com.xunlei.downloadprovider.personal.redenvelope.e.b(j)));
        this.a.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.red_icon_default, null));
        this.n.setBackgroundColor(Color.parseColor("#999999"));
        this.n.setClickable(false);
        this.n.setVisibility(0);
    }

    public static void a(Context context, int i, String str) {
        Intent xLIntent = new XLIntent(context, RedEnvelopesDetailActivity.class);
        xLIntent.putExtra("extra_red_id", i);
        xLIntent.putExtra("extra_red_from", str);
        context.startActivity(xLIntent);
    }

    public static void b(Context context, int i, String str) {
        Intent xLIntent = new XLIntent(context, RedEnvelopesDetailActivity.class);
        xLIntent.putExtra("extra_red_id", i);
        xLIntent.putExtra("extra_red_from", str);
        ((Activity) context).startActivityForResult(xLIntent, 10001);
    }

    private void a(int i) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra("extra_status", i);
        setResult(10001, xLIntent);
    }

    protected void onResume() {
        super.onResume();
        this.x = new d(new k(this));
    }

    private void b() {
        this.p.setErrorType(2);
        this.p.setVisibility(0);
        this.p.a("刷新", new c(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.x != null) {
            this.x.a();
        }
        h.a().deleteObserver(this.z);
    }

    private void a(e eVar, int i, long j) {
        if (eVar != null) {
            long j2 = eVar.f;
            String str = eVar.d;
            if (i == 2) {
                a(j2);
                this.c.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.red_envelopes_used, null));
                if (eVar.m == 1) {
                    this.n.setText("已下载");
                } else {
                    this.n.setText("已使用");
                }
            } else if (j <= null) {
                a(j2);
                this.c.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2130839120, null));
                this.n.setText("已过期");
            } else {
                this.n.setVisibility(0);
                this.n.setBackgroundResource(R.drawable.red_detail_bottom_btn_bg);
                this.c.setVisibility(8);
                this.d.setTextColor(Color.parseColor("#fc4622"));
                this.e.setTextColor(Color.parseColor("#666666"));
                this.e.setText(com.xunlei.downloadprovider.personal.redenvelope.e.a.replace("%s", com.xunlei.downloadprovider.personal.redenvelope.e.a(j * 1000)));
                eVar = this.a;
                if (!(str == null || eVar == null)) {
                    com.xunlei.downloadprovider.homepage.choiceness.b.a().a(str, eVar, null);
                }
            }
        }
    }

    static /* synthetic */ boolean a(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        if (!redEnvelopesDetailActivity.isFinishing()) {
            if (VERSION.SDK_INT < 17 || redEnvelopesDetailActivity.isDestroyed() == null) {
                return null;
            }
        }
        return true;
    }

    static /* synthetic */ void c(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        k.a();
        String valueOf = String.valueOf(redEnvelopesDetailActivity.s.b);
        boolean z = false;
        if (!(valueOf == null || k.a == null || !k.a.getBoolean(valueOf, false))) {
            z = true;
        }
        if (z) {
            redEnvelopesDetailActivity.s.e = 2;
        }
    }

    static /* synthetic */ void b(RedEnvelopesDetailActivity redEnvelopesDetailActivity, e eVar) {
        if (eVar != null) {
            new StringBuilder("RedDetailModel = ").append(eVar);
            redEnvelopesDetailActivity.d.setText(eVar.c);
            redEnvelopesDetailActivity.f.setText(eVar.h);
            redEnvelopesDetailActivity.h.setText(eVar.i);
            if (!TextUtils.isEmpty(eVar.s)) {
                redEnvelopesDetailActivity.n.setText(eVar.s);
            }
            redEnvelopesDetailActivity.a(eVar, eVar.e, eVar.q - eVar.o);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(com.xunlei.downloadprovider.personal.redenvelope.e.b(eVar.p));
            stringBuilder.append("-");
            stringBuilder.append(com.xunlei.downloadprovider.personal.redenvelope.e.b(eVar.q));
            redEnvelopesDetailActivity.g.setText(stringBuilder.toString());
            if (!(eVar == null || TextUtils.isEmpty(eVar.l))) {
                int i = 1;
                if (!(eVar.m == 1 || eVar.m == 4)) {
                    if (eVar.m != 5) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    redEnvelopesDetailActivity.i.setVisibility(0);
                    redEnvelopesDetailActivity.j.setText(eVar.l);
                    switch (eVar.n) {
                        case 1:
                            redEnvelopesDetailActivity.l.setVisibility(0);
                            redEnvelopesDetailActivity.m.setVisibility(8);
                            break;
                        case 2:
                            redEnvelopesDetailActivity.l.setVisibility(8);
                            redEnvelopesDetailActivity.m.setVisibility(0);
                            break;
                        case 3:
                            redEnvelopesDetailActivity.l.setVisibility(0);
                            redEnvelopesDetailActivity.m.setVisibility(0);
                            break;
                        default:
                            redEnvelopesDetailActivity.l.setVisibility(8);
                            redEnvelopesDetailActivity.m.setVisibility(8);
                            break;
                    }
                    if (eVar.e != 2 && eVar.q > eVar.o) {
                        redEnvelopesDetailActivity.t = new b(redEnvelopesDetailActivity);
                        redEnvelopesDetailActivity.u.postDelayed(redEnvelopesDetailActivity.t, 60000);
                        return;
                    }
                }
            }
            redEnvelopesDetailActivity.i.setVisibility(8);
            switch (eVar.n) {
                case 1:
                    redEnvelopesDetailActivity.l.setVisibility(0);
                    redEnvelopesDetailActivity.m.setVisibility(8);
                    break;
                case 2:
                    redEnvelopesDetailActivity.l.setVisibility(8);
                    redEnvelopesDetailActivity.m.setVisibility(0);
                    break;
                case 3:
                    redEnvelopesDetailActivity.l.setVisibility(0);
                    redEnvelopesDetailActivity.m.setVisibility(0);
                    break;
                default:
                    redEnvelopesDetailActivity.l.setVisibility(8);
                    redEnvelopesDetailActivity.m.setVisibility(8);
                    break;
            }
            if (eVar.e != 2) {
            }
        }
    }

    static /* synthetic */ void e(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        redEnvelopesDetailActivity.p.setErrorType(0);
        redEnvelopesDetailActivity.p.setVisibility(0);
        redEnvelopesDetailActivity.p.a("", null);
    }

    static /* synthetic */ void g(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        if (redEnvelopesDetailActivity.s != null) {
            switch (redEnvelopesDetailActivity.s.t) {
                case 0:
                    if (redEnvelopesDetailActivity.s != null) {
                        switch (redEnvelopesDetailActivity.s.m) {
                            case 1:
                                g.a(redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.k, redEnvelopesDetailActivity.s.c, redEnvelopesDetailActivity.s.j, redEnvelopesDetailActivity.s.d, redEnvelopesDetailActivity.x);
                                break;
                            case 2:
                                g.a((Context) redEnvelopesDetailActivity, PayFrom.RED_PACKET_DETAILS, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.c);
                                break;
                            case 3:
                                com.xunlei.downloadprovider.discovery.kuainiao.d.a((Context) redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.h);
                                break;
                            case 4:
                                g.a((Context) redEnvelopesDetailActivity, PayFrom.RED_PACKET_DETAILS, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.c);
                                break;
                            case 5:
                                g.a(redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.k);
                                break;
                            case 8:
                                g.b(redEnvelopesDetailActivity, "v_an_shoulei_push_xz_ec_due");
                                break;
                            case 11:
                            case 12:
                            case 13:
                                g.a((Context) redEnvelopesDetailActivity, PayFrom.RED_PACKET_DETAILS, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.m);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 1:
                    if (redEnvelopesDetailActivity.s.m != 3) {
                        g.a(redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.k);
                        break;
                    } else {
                        com.xunlei.downloadprovider.discovery.kuainiao.d.a((Context) redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.h);
                        break;
                    }
                case 2:
                    g.a(redEnvelopesDetailActivity, redEnvelopesDetailActivity.s.k, redEnvelopesDetailActivity.s.c, redEnvelopesDetailActivity.s.j, redEnvelopesDetailActivity.s.d, redEnvelopesDetailActivity.x);
                    break;
                case 3:
                    if (redEnvelopesDetailActivity.s.m != 8) {
                        g.a((Context) redEnvelopesDetailActivity, PayFrom.RED_PACKET_DETAILS, redEnvelopesDetailActivity.s.l, redEnvelopesDetailActivity.s.c);
                        break;
                    } else {
                        g.b(redEnvelopesDetailActivity, "v_an_shoulei_push_xz_ec_due");
                        break;
                    }
                case 4:
                    if (!redEnvelopesDetailActivity.v) {
                        redEnvelopesDetailActivity.v = true;
                        g.a(redEnvelopesDetailActivity.y);
                        break;
                    }
                    break;
                default:
                    XLToast.showToast(redEnvelopesDetailActivity, redEnvelopesDetailActivity.getResources().getString(R.string.red_envelopes_new_type_user_tip));
                    break;
            }
            String str = redEnvelopesDetailActivity.r;
            int i = redEnvelopesDetailActivity.s.m;
            int i2 = redEnvelopesDetailActivity.s.g;
            redEnvelopesDetailActivity = redEnvelopesDetailActivity.s.b;
            StatEvent build = HubbleEventBuilder.build("android_packet", "packet_detail_click");
            build.add("from", str);
            build.add("packet_type", i);
            build.add("gift_type", i2);
            build.add("clickid", "foot_button");
            build.add("gameid", redEnvelopesDetailActivity);
            build.add("position_id", "packet_dlcenter_game");
            f.a(build);
        }
    }

    static /* synthetic */ void j(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        redEnvelopesDetailActivity.a(2);
        redEnvelopesDetailActivity.a(redEnvelopesDetailActivity.s, 2, -1);
        k.a();
        k.a(String.valueOf(redEnvelopesDetailActivity.s.b));
        com.xunlei.downloadprovider.personal.redenvelope.a.a().a(redEnvelopesDetailActivity.s.l, String.valueOf(redEnvelopesDetailActivity.s.g), new l(redEnvelopesDetailActivity));
    }

    static /* synthetic */ void a(RedEnvelopesDetailActivity redEnvelopesDetailActivity, String str) {
        if (!TextUtils.isEmpty(str)) {
            redEnvelopesDetailActivity.runOnUiThread(new i(redEnvelopesDetailActivity, str));
        }
    }

    static /* synthetic */ void k(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        if (redEnvelopesDetailActivity.w) {
            redEnvelopesDetailActivity.runOnUiThread(new h(redEnvelopesDetailActivity));
            return;
        }
        g.a(redEnvelopesDetailActivity.y);
        redEnvelopesDetailActivity.w = true;
    }

    static /* synthetic */ void d(RedEnvelopesDetailActivity redEnvelopesDetailActivity, e eVar) {
        if (eVar != null) {
            int i = eVar.e;
            long j = eVar.q - eVar.o;
            long j2 = eVar.o;
            if (j > 0) {
                eVar.o = j2 + 60;
                redEnvelopesDetailActivity.e.setText(com.xunlei.downloadprovider.personal.redenvelope.e.a.replace("%s", com.xunlei.downloadprovider.personal.redenvelope.e.a(j * 1000)));
                return;
            }
            redEnvelopesDetailActivity.a(eVar, i, j);
            redEnvelopesDetailActivity.u.removeCallbacks(redEnvelopesDetailActivity.t);
        }
    }
}
