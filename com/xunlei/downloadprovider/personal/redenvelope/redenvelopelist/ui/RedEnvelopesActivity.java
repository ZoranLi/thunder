package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.d;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.personal.redenvelope.g;
import com.xunlei.downloadprovider.personal.redenvelope.k;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.a;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

public class RedEnvelopesActivity extends BaseActivity {
    private RecyclerView a;
    private UnifiedLoadingView c;
    private ErrorBlankView d;
    private int e;
    private PullToRefreshRecyclerView f;
    private LoginHelper g = LoginHelper.a();
    private a h;
    private int i = 0;
    private List<e> j = new ArrayList();
    private boolean k;
    private boolean l;
    private boolean m;
    private e n;
    private d<RecyclerView> o = new f(this);
    private com.xunlei.downloadprovider.member.login.b.d p = new k(this);
    private Handler q = new Handler();
    private g.a r = new m(this);
    @Nullable
    private com.xunlei.downloadprovider.download.engine.task.d s = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g.a(this.p);
        setContentView(R.layout.activity_red_envelopes);
        this.c = (UnifiedLoadingView) findViewById(R.id.red_envelopes_loading_view);
        bundle = new TitleBar((Activity) this);
        bundle.mTitle.setText(getResources().getString(R.string.user_center_red_envelopes));
        bundle.mRight1.setVisibility(0);
        this.d = (ErrorBlankView) findViewById(R.id.ev_show);
        this.f = (PullToRefreshRecyclerView) findViewById(R.id.rcv_red_contents);
        this.f.setHeaderViewNotShow();
        this.f.setPullToRefreshOverScrollEnabled(true);
        this.f.setMode(Mode.PULL_FROM_END);
        this.f.setOnRefreshListener(this.o);
        this.a = (RecyclerView) this.f.getRefreshableView();
        this.a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.h = new a(this, new a(this));
        this.a.setAdapter(this.h);
        if (!(getIntent() == null || getIntent().getBooleanExtra("extra:from_expired_push_click", false) == null)) {
            f.a().g();
            bundle = HubbleEventBuilder.build("android_push", "push_click");
            bundle.add("type", "viphb_overdue");
            ThunderReport.reportEvent(bundle);
        }
        if (b.a(getApplicationContext()) == null) {
            c();
        } else if (l.c() == null) {
            b();
        } else {
            a();
        }
        this.h.d = new g(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001) {
            if (intent != null) {
                e eVar = (e) this.h.c(this.e);
                eVar.e = intent.getIntExtra("extra_status", -1);
                i = this.e;
                if (this.a != null && eVar != null) {
                    com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.b bVar = (com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.b) this.a.findViewHolderForAdapterPosition(i);
                    if (bVar != null) {
                        bVar.a(eVar);
                    }
                }
            }
        }
    }

    private void b() {
        if (this.f != null) {
            this.f.setMode(Mode.DISABLED);
        }
        this.d.a(ResourcesCompat.getDrawable(getResources(), R.drawable.commonui_bg_not_login, null), getResources().getString(R.string.tips_not_login), "登录后查看礼包");
        this.d.setVisibility(0);
        this.d.a("登录", new i(this));
    }

    private void c() {
        this.d.setErrorType(2);
        this.d.setVisibility(0);
        this.d.a("刷新", new j(this));
    }

    protected void onDestroy() {
        this.g.b(this.p);
        this.q.removeCallbacksAndMessages(null);
        if (this.s != null) {
            this.s.a();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        this.s = new com.xunlei.downloadprovider.download.engine.task.d(new d(this));
    }

    private void a() {
        this.c.setType(2);
        this.c.setBackgroundColor(Color.parseColor("#ffffff"));
        this.c.hidePageLoadingViewBack();
        com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.a.a().a(new h(this), this.i);
    }

    static /* synthetic */ void a(RedEnvelopesActivity redEnvelopesActivity, Context context, e eVar) {
        int i = eVar.f;
        int i2 = eVar.g;
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_list_btn_click");
        build.add("packet_type", i);
        build.add("gift_type", i2);
        build.add("clickid", "use_now");
        com.xunlei.downloadprovider.personal.redenvelope.f.a(build);
        switch (eVar.o) {
            case 0:
                switch (eVar.f) {
                    case 1:
                        g.a(redEnvelopesActivity, eVar.k, eVar.b, eVar.l, eVar.d, redEnvelopesActivity.s);
                        return;
                    case 2:
                        g.a(context, PayFrom.RED_PACKET_LIST_ITEM, eVar.j, eVar.b);
                        return;
                    case 3:
                        com.xunlei.downloadprovider.discovery.kuainiao.d.a(context, eVar.j, eVar.m);
                        return;
                    case 4:
                        g.a(context, PayFrom.RED_PACKET_LIST_ITEM, eVar.j, eVar.b);
                        return;
                    case 5:
                        g.a(context, eVar.k);
                        return;
                    case 8:
                        g.b(redEnvelopesActivity, "v_an_shoulei_push_xz_ec_list");
                        break;
                    case 11:
                    case 12:
                    case 13:
                        g.a((Context) redEnvelopesActivity, PayFrom.RED_PACKET_LIST_ITEM, eVar.j, eVar.f);
                        return;
                    default:
                        break;
                }
                return;
            case 1:
                if (eVar.f == 3) {
                    com.xunlei.downloadprovider.discovery.kuainiao.d.a(context, eVar.j, eVar.m);
                    return;
                } else {
                    g.a(context, eVar.k);
                    return;
                }
            case 2:
                g.a(redEnvelopesActivity, eVar.k, eVar.b, eVar.l, eVar.d, redEnvelopesActivity.s);
                return;
            case 3:
                if (!(eVar.f == 11 || eVar.f == 12)) {
                    if (eVar.f != 13) {
                        if (eVar.f == 8) {
                            g.b(redEnvelopesActivity, "v_an_shoulei_push_xz_ec_list");
                            return;
                        } else {
                            g.a(context, PayFrom.RED_PACKET_LIST_ITEM, eVar.j, eVar.b);
                            return;
                        }
                    }
                }
                g.a((Context) redEnvelopesActivity, PayFrom.RED_PACKET_LIST_ITEM, eVar.j, eVar.f);
                return;
            case 4:
                if (redEnvelopesActivity.l == null) {
                    redEnvelopesActivity.l = true;
                    redEnvelopesActivity.n = eVar;
                    g.a(redEnvelopesActivity.r);
                    return;
                }
                break;
            default:
                XLToast.showToast(redEnvelopesActivity, redEnvelopesActivity.getResources().getString(R.string.red_envelopes_new_type_user_tip));
                break;
        }
    }

    static /* synthetic */ void j(RedEnvelopesActivity redEnvelopesActivity) {
        redEnvelopesActivity.d.setErrorType(0);
        redEnvelopesActivity.d.setVisibility(0);
        redEnvelopesActivity.d.a("", null);
        if (redEnvelopesActivity.f != null) {
            redEnvelopesActivity.f.setMode(Mode.DISABLED);
        }
    }

    static /* synthetic */ void o(RedEnvelopesActivity redEnvelopesActivity) {
        redEnvelopesActivity = redEnvelopesActivity.h;
        if (!redEnvelopesActivity.d()) {
            int itemCount = redEnvelopesActivity.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                e eVar = (e) redEnvelopesActivity.c(i);
                if (eVar != null) {
                    long j = eVar.i;
                    long j2 = eVar.h;
                    if (eVar.e != 2 && j > j2) {
                        eVar.h = j2 + 60;
                        redEnvelopesActivity.notifyItemChanged(i);
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(RedEnvelopesActivity redEnvelopesActivity, e eVar) {
        k.a();
        k.a(String.valueOf(eVar.a));
        com.xunlei.downloadprovider.personal.redenvelope.a.a().a(eVar.j, String.valueOf(eVar.g), new e(redEnvelopesActivity));
    }

    static /* synthetic */ void a(RedEnvelopesActivity redEnvelopesActivity, String str) {
        if (!TextUtils.isEmpty(str)) {
            redEnvelopesActivity.runOnUiThread(new c(redEnvelopesActivity, str));
        }
    }

    static /* synthetic */ void s(RedEnvelopesActivity redEnvelopesActivity) {
        if (redEnvelopesActivity.m) {
            redEnvelopesActivity.runOnUiThread(new b(redEnvelopesActivity));
            return;
        }
        g.a(redEnvelopesActivity.r);
        redEnvelopesActivity.m = true;
    }
}
