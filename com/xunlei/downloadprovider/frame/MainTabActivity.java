package com.xunlei.downloadprovider.frame;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.lib.tinker.Tinker;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.c.b.e;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.app.a.m;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.d.i.a;
import com.xunlei.downloadprovider.dialog.quit.QuitAppDialogFragment;
import com.xunlei.downloadprovider.discovery.kuainiao.d$a;
import com.xunlei.downloadprovider.download.c;
import com.xunlei.downloadprovider.download.create.ThunderTaskActivity;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.frame.dispatch.info.MainTabAuctionDispatchInfo;
import com.xunlei.downloadprovider.frame.dispatch.info.MainTabDispatchInfo;
import com.xunlei.downloadprovider.frame.dispatch.info.MainTabWebViewDispatchInfo;
import com.xunlei.downloadprovider.frame.view.XLTabLayout;
import com.xunlei.downloadprovider.frame.view.XLTabView;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.homepage.HomeFragment;
import com.xunlei.downloadprovider.homepage.follow.ac;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.login.ui.XLLoginOfflineDlgActivity;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.h;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.t;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.xllib.android.XLIntent;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainTabActivity extends ThunderTaskActivity implements a, d$a {
    public static final String a = "MainTabActivity";
    private com.xunlei.downloadprovider.frame.dispatch.a A = null;
    private e B = null;
    private h.a C = new q(this);
    public BaseFragment c;
    View d;
    LinearLayout g;
    public int h;
    public ArrayList<b> i = new ArrayList(10);
    ObjectAnimator j;
    private XLTabLayout k;
    private int l = R.id.main_activity_content_ly;
    private aa m;
    private Handler n;
    private g o;
    private com.xunlei.downloadprovider.member.login.b.h p;
    private d q;
    private boolean r = false;
    private TextView s;
    private LoginHelper t = LoginHelper.a();
    private LocalBroadcastManager u = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
    private BroadcastReceiver v;
    private Runnable w;
    private boolean x = true;
    private int y;
    private boolean z;

    public final void a(String str, int i, KnParams knParams) {
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(10);
        }
        bundle.putString("home_sub_tab_tag", str);
        a(context, "thunder", bundle, false);
    }

    public static void b(Context context, String str, Bundle bundle) {
        a(context, str, bundle, false);
    }

    public static void a(Context context, String str, Bundle bundle, boolean z) {
        if (context != null) {
            if (str != null) {
                if (bundle == null) {
                    bundle = new Bundle(10);
                }
                bundle.putString("tab_tag", str);
                str = new XLIntent(context, MainTabActivity.class);
                str.putExtras(bundle);
                if (z) {
                    str.addFlags(32768);
                }
                if ((context instanceof Activity) == null) {
                    str.addFlags(268435456);
                }
                context.startActivity(str);
            }
        }
    }

    public static void a(Activity activity) {
        a(activity, "thunder", new Bundle(9), false);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle(9);
        bundle.putString("download_url", str);
        bundle.putString("download_report", str4);
        bundle.putString("download_title", str2);
        bundle.putString("download_icon_url", str3);
        a(activity, "thunder", bundle, null);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = true;
        if (l.c() && this.t.d) {
            r.a().a((Context) this, "");
        }
        com.xunlei.downloadprovider.app.a.d.a().a(2, null);
        if (LaunchActivity.a) {
            Object string;
            boolean isTinkerLoaded = Tinker.with(BrothersApplication.getApplicationInstance()).isTinkerLoaded();
            SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("thunder_tinker", 0);
            if (sharedPreferences != null) {
                string = sharedPreferences.getString("tink_id", null);
            } else {
                string = null;
            }
            String a = com.xunlei.downloadprovider.app.h.a();
            if (!(!isTinkerLoaded || a == null || a.equals(string))) {
                Map hashMap = new HashMap();
                hashMap.put("last_patch_tink_id", string);
                hashMap.put("new_tinker_id", a);
                com.xunlei.downloadprovider.ad.common.report.a.a("tinker_loaded", hashMap);
                String a2 = com.xunlei.downloadprovider.app.h.a();
                if (a2 != null) {
                    sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("thunder_tinker", 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString("tink_id", a2).commit();
                    }
                }
            }
            getWindow().setFormat(-3);
            f.a((Context) this, "no_first_enter_thunder", true);
            setContentView(R.layout.main_activity_linearlayout);
            this.n = new a(this, new SoftReference(this));
            c();
            this.g = (LinearLayout) findViewById(R.id.lyt_update_bar);
            this.s = (TextView) this.g.findViewById(R.id.tv_tips);
            this.g.findViewById(R.id.iv_close).setOnClickListener(new v(this));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xunlei.downloadprovider.app.action.LIVE_DATA_UPDATED");
            intentFilter.addAction("action_enter_full_screen_mode");
            intentFilter.addAction("action_exit_full_screen_mode");
            this.v = new w(this);
            this.u.registerReceiver(this.v, intentFilter);
            this.q = new z(this);
            this.p = new i(this);
            this.o = new j(this);
            this.t.a(this.q);
            this.t.a(this.p);
            this.t.a(this.o);
            Beta.checkUpgrade(false, false);
            a(getIntent(), bundle);
            if (l.b() != null) {
                ThunderReport.setShouleiUserId(this.t.g.c());
            }
            i.a().a((a) this);
            com.xunlei.downloadprovider.discovery.kuainiao.d.a().a(this);
            overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
            bundle = com.xunlei.downloadprovider.publiser.common.guide.a.a();
            bundle.c = false;
            if (bundle.c() && !bundle.a.b && bundle.d()) {
                if (bundle.b.a()) {
                    bundle.b.a((Context) this);
                    bundle.c = true;
                }
                bundle.a.b = true;
            }
            com.xunlei.downloadprovider.pushmessage.e.c().e();
            this.B = new e(this);
            this.B.a();
            this.B.a = new o(this);
            this.B.a(false);
            if (l.c() != null) {
                com.xunlei.downloadprovider.personal.message.data.d.a(BrothersApplication.getApplicationInstance()).a(this.t.g.c(), new p(this));
            }
            b.b().a(this.C);
            com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a().d();
            j.a();
            j.a(new r(this));
            if (com.xunlei.downloadprovider.d.d.a().l.b() == n.b) {
                q.a().a("com.xunlei.plugin.qrcode", null, true);
            }
            bundle = getWindow();
            if (VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
                bundle.addFlags(Integer.MIN_VALUE);
                bundle.setStatusBarColor(0);
            }
            return;
        }
        startActivity(new XLIntent((Context) this, LaunchActivity.class));
        finish();
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = this.m != null ? this.m.a("thunder") : null;
        if (configuration instanceof BaseViewPagerFragment) {
            ((BaseViewPagerFragment) configuration).b(true);
        }
    }

    protected void onResume() {
        super.onResume();
        com.xunlei.downloadprovider.download.engine.task.n.a();
        com.xunlei.downloadprovider.a.g gVar = null;
        if (com.xunlei.downloadprovider.download.engine.task.n.b()) {
            com.xunlei.downloadprovider.download.engine.task.n.a();
            com.xunlei.downloadprovider.download.engine.task.n.p();
        } else {
            com.xunlei.downloadprovider.download.engine.task.n.a();
            com.xunlei.downloadprovider.download.engine.task.n.a(null);
        }
        if (!this.r) {
            this.r = true;
            b(getIntent());
        }
        if (l.c()) {
            com.xunlei.downloadprovider.download.engine.task.n.a().a(this.t);
        }
        if (getWindow().getDecorView().getSystemUiVisibility() == 4096) {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        com.xunlei.downloadprovider.member.login.c.i iVar = this.t.j;
        if (iVar.a) {
            XLLoginOfflineDlgActivity.a(BrothersApplication.getApplicationInstance());
            iVar.a = false;
        }
        if (com.xunlei.downloadprovider.d.d.a().b.m() && !com.xunlei.downloadprovider.a.a.a().b) {
            com.xunlei.downloadprovider.a.a a = com.xunlei.downloadprovider.a.a.a();
            if (a.a != null) {
                com.xunlei.downloadprovider.a.i iVar2 = new com.xunlei.downloadprovider.a.i();
                for (com.xunlei.downloadprovider.a.g gVar2 : a.a) {
                    boolean z;
                    int i;
                    SharedPreferences sharedPreferences;
                    StringBuilder stringBuilder;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis >= gVar2.f) {
                        if (currentTimeMillis <= gVar2.g) {
                            if (gVar2.h == null || gVar2.h.contains(Integer.valueOf(11100))) {
                                if (gVar2.i == null || gVar2.i.contains(AndroidConfig.getPartnerId())) {
                                    z = true;
                                    if (z) {
                                        i = gVar2.a;
                                        sharedPreferences = iVar2.a;
                                        stringBuilder = new StringBuilder("is_activity_showed_");
                                        stringBuilder.append(i);
                                        if (!sharedPreferences.getBoolean(stringBuilder.toString(), false)) {
                                            gVar = gVar2;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        i = gVar2.a;
                        sharedPreferences = iVar2.a;
                        stringBuilder = new StringBuilder("is_activity_showed_");
                        stringBuilder.append(i);
                        if (!sharedPreferences.getBoolean(stringBuilder.toString(), false)) {
                            gVar = gVar2;
                            break;
                        }
                    }
                }
            }
            if (gVar != null) {
                com.xunlei.downloadprovider.a.a.a().b = true;
                this.w = new h(this, gVar);
                this.n.postDelayed(this.w, 800);
            }
        }
        getWindow().getDecorView().post(new s(this));
    }

    protected void onPause() {
        super.onPause();
        this.n.removeCallbacks(this.w);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.k != null) {
            bundle.putString("save_fragment_tag", this.k.getCurrentTag());
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.t.b(this.q);
        this.t.b(this.p);
        this.t.b(this.o);
        if (this.n != null) {
            this.n.removeCallbacksAndMessages(null);
        }
        this.u.unregisterReceiver(this.v);
        if (this.m != null) {
            aa aaVar = this.m;
            if (aaVar.a != null) {
                aaVar.a.clear();
            }
            aaVar.a = null;
        }
        i.a().b(this);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().b(this);
        h();
        if (com.xunlei.downloadprovider.ad.taskdetail.a.b()) {
            com.xunlei.downloadprovider.ad.cache.b.a().b(STYLES_INFO.TASK_DETAIL_IMG, STYLES_INFO.TASK_DETAIL_BANNER);
        }
        if (com.xunlei.downloadprovider.ad.taskdetailnew.b.a()) {
            com.xunlei.downloadprovider.ad.cache.b.a().b(STYLES_INFO.TASK_DETAIL_NEW_IMG);
        }
        if (com.xunlei.downloadprovider.ad.taskdetailnew.b.d()) {
            com.xunlei.downloadprovider.ad.cache.b.a().b(STYLES_INFO.TASK_DETAIL_NEW_BANNER);
        }
        com.xunlei.downloadprovider.ad.home.a.b.d();
        b.b().b(this.C);
        if (this.z) {
            BrothersApplication.getSingletonInstance().killMyself();
        }
    }

    public final void a(i iVar) {
        runOnUiThread(new t(this));
    }

    public final void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        i = (i != 0 || xLAccelBandInfo == null) ? 0 : 1;
        runOnUiThread(new u(this, i));
    }

    protected void onStart() {
        super.onStart();
        com.xunlei.downloadprovider.h.i.b(this, "com.xunlei.downloadprovider.app.action.CHECK_LIVE_UPDATE");
        com.xunlei.downloadprovider.h.i.a(this, "com.xunlei.downloadprovider.app.action.CHECK_LIVE_UPDATE");
    }

    protected void onStop() {
        super.onStop();
        com.xunlei.downloadprovider.h.i.a("com.xunlei.downloadprovider.app.action.CHECK_LIVE_UPDATE");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 24) {
                Intent xLIntent = new XLIntent();
                xLIntent.setAction("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN");
                this.u.sendBroadcast(xLIntent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (this.c == 0 || this.c.onBackPressed() == 0) {
            i = ak.a();
            keyEvent = null;
            boolean z = false;
            while (keyEvent < i.b.size()) {
                z = ((ThunderXmpPlayer) i.b.valueAt(keyEvent)).k();
                if (z) {
                    break;
                }
                keyEvent++;
            }
            if (!z && TextUtils.isEmpty(this.k.getCurrentTag()) == 0) {
                if (this.k.getCurrentTag().equals("thunder") == 0) {
                    a("thunder", (Bundle) null);
                } else if (isFinishing() == 0) {
                    i = QuitAppDialogFragment.a();
                    i.a = new k(this);
                    try {
                        i.show(getSupportFragmentManager(), "QuitAppDialogFragment");
                        ThunderReport.reportEvent(HubbleEventBuilder.build("android_appExit", "appExit_show").add("is_login", i.b != null ? "1" : "0").add("is_signshow", i.c ? "1" : "0").add("is_download", i.d ? "1" : "0").add("is_change_set", i.e != 0 ? "1" : "0"));
                    } catch (int i2) {
                        i2.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    private void c() {
        this.d = findViewById(R.id.layout_tab);
        ac a = ac.a();
        a.a(false);
        a.b(false);
        a.c(false);
        this.m = new aa();
        this.k = (XLTabLayout) findViewById(R.id.main_activity_tab_ly);
        this.k.setOnTabChangeListener(new x(this));
        this.k.setOnClickListener(new y(this));
        int length = MainTabSpec.a.length;
        int screenWidth = AndroidConfig.getScreenWidth();
        int screenHeight = AndroidConfig.getScreenHeight();
        if (screenWidth > screenHeight) {
            screenWidth = screenHeight;
        }
        screenWidth /= length;
        for (screenHeight = 0; screenHeight < length; screenHeight++) {
            MainTabSpec$Tab mainTabSpec$Tab = MainTabSpec.a[screenHeight];
            XLTabView xLTabView = new XLTabView(this);
            if (!mainTabSpec$Tab.equals(MainTabSpec$Tab.USER) || l.c()) {
                xLTabView.a = mainTabSpec$Tab.getTag();
                xLTabView.a(getString(mainTabSpec$Tab.getText())).a(mainTabSpec$Tab.getIcon());
                t.a().a = true;
            } else {
                xLTabView.a = mainTabSpec$Tab.getTag();
                xLTabView.a(getString(R.string.main_tab_user_not_login)).a(R.drawable.main_tab_me_not_login_selector);
                t.a().a = false;
            }
            Object obj = this.k;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth, -1);
            layoutParams.gravity = 17;
            xLTabView.setOnClickListener(obj);
            obj.addView(xLTabView, layoutParams);
            b(screenHeight, xLTabView);
        }
    }

    private static void b(int i, XLTabView xLTabView) {
        boolean e;
        i a = i.a();
        switch (i) {
            case 0:
                e = a.e("recommend");
                break;
            case 1:
                e = a.e("livestream");
                break;
            case 2:
                e = a.e("find");
                break;
            case 3:
                e = a.e("user_center");
                break;
            default:
                e = false;
                break;
        }
        if (e) {
            xLTabView.setPointVisible(0);
        } else {
            xLTabView.setPointVisible(8);
        }
        xLTabView = new StringBuilder(" index ");
        xLTabView.append(i);
        xLTabView.append(" needShow ");
        xLTabView.append(e);
    }

    private boolean b(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("download_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                TaskStatInfo taskStatInfo = new TaskStatInfo(stringExtra, null);
                String stringExtra2 = intent.getStringExtra("download_report");
                taskStatInfo.a = stringExtra2;
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                String stringExtra3 = intent.getStringExtra("download_title");
                downloadAdditionInfo.b = intent.getStringExtra("download_icon_url");
                downloadAdditionInfo.a = stringExtra3;
                downloadAdditionInfo.f = true;
                if (com.xunlei.downloadprovider.ad.common.c.a.a(stringExtra2)) {
                    com.xunlei.downloadprovider.download.engine.task.g.a();
                    com.xunlei.downloadprovider.download.engine.task.g.a(stringExtra, stringExtra3, taskStatInfo, downloadAdditionInfo);
                } else {
                    c.a(this, stringExtra, stringExtra3, 0, "", taskStatInfo, downloadAdditionInfo, null);
                }
                return true;
            }
        }
        return null;
    }

    private void a(Intent intent, Bundle bundle) {
        if (intent != null) {
            if (this.A == null) {
                this.A = new com.xunlei.downloadprovider.frame.dispatch.a();
            }
            int i = 0;
            if (intent.getData() == null) {
                String string;
                if (bundle != null) {
                    string = bundle.getString("save_fragment_tag");
                    bundle.remove("save_fragment_tag");
                } else {
                    string = null;
                }
                bundle = intent.getExtras();
                if (bundle != null) {
                    CharSequence stringExtra = intent.getStringExtra("short_toast_msg");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Toast.makeText(getApplicationContext(), stringExtra, 0).show();
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = bundle.getString("tab_tag");
                    }
                    if (string != null) {
                        if ("exitApp".equals(bundle.getString("exit_app"))) {
                            finish();
                            BrothersApplication.getSingletonInstance().killMyself();
                        }
                        a(string, bundle);
                    }
                }
            } else {
                a("thunder", null);
            }
            a(intent);
            bundle = this.A;
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra("dispatch_info");
                if (serializableExtra instanceof MainTabDispatchInfo) {
                    bundle.a = (MainTabDispatchInfo) serializableExtra;
                    switch (bundle.a.getTo()) {
                        case 1:
                        case 2:
                            i = 1;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (!(i == 0 || intent == null)) {
                switch (bundle.a.getTo()) {
                    case 1:
                        if ((bundle.a instanceof MainTabAuctionDispatchInfo) != null) {
                            intent = ((MainTabAuctionDispatchInfo) bundle.a).getAuctionOrderDetailUrl();
                            if (!TextUtils.isEmpty(intent)) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("key_back", "back_push_auction_transaction_state");
                                WebViewADActivity.startWebViewADActivity(this, bundle.a.getFrom(), intent, null, bundle2);
                            }
                            return;
                        }
                        break;
                    case 2:
                        if ((bundle.a instanceof MainTabWebViewDispatchInfo) != null) {
                            MainTabWebViewDispatchInfo mainTabWebViewDispatchInfo = (MainTabWebViewDispatchInfo) bundle.a;
                            com.xunlei.downloadprovider.web.a.a();
                            com.xunlei.downloadprovider.web.a.a((Context) this, mainTabWebViewDispatchInfo.getUrl(), mainTabWebViewDispatchInfo.getTitle(), mainTabWebViewDispatchInfo.getFrom());
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void d() {
        com.xunlei.downloadprovider.personal.a.i.a(this, "sign", com.xunlei.downloadprovider.personal.a.b.a.a, com.xunlei.downloadprovider.personal.a.a.a().e(), com.xunlei.downloadprovider.personal.a.a.a().f());
    }

    private void g() {
        HomeFragment homeFragment = (HomeFragment) this.m.a("thunder");
        if (homeFragment != null) {
            homeFragment.h();
        }
        com.xunlei.downloadprovider.member.login.b.n.b();
        this.z = true;
        finish();
        PrivateSpaceMgr.a().e();
    }

    public final void a(boolean z) {
        moveTaskToBack(true);
        PrivateSpaceMgr.a().e();
        if (z) {
            com.xunlei.downloadprovider.h.a.a = true;
        }
    }

    public final BaseFragment a(String str, Bundle bundle) {
        if (str.equals("find") && com.xunlei.downloadprovider.discovery.kuainiao.d.b() && com.xunlei.downloadprovider.discovery.kuainiao.d.a().a) {
            com.xunlei.downloadprovider.discovery.kuainiao.d.c();
        }
        if ("xllive".equals(str)) {
            XLTabView a = this.k.a("xllive");
            if (a == null) {
                return null;
            }
            if (bundle == null) {
                bundle = new Bundle(9);
            }
            bundle.putBoolean("is_red_point_show", a.a());
            if (a.a()) {
                a("xllive", 8);
                long currentTimeMillis = System.currentTimeMillis();
                i.a().a(currentTimeMillis, "livestream");
                f.a((Context) this, "live_red_point_last_show_time", currentTimeMillis);
                f.a((Context) this, "live_red_point_show_count", f.b((Context) this, "live_red_point_show_count", 0) + 1);
                ac.a().a(currentTimeMillis);
            }
        }
        bundle = XLTabLayout.a(this.l, getSupportFragmentManager(), this.m, str, bundle);
        if (bundle != null) {
            this.c = bundle;
            this.k.setSelection(str);
        }
        c(MessageInfo.USER.equals(str));
        return bundle;
    }

    public final void a(String str, int i) {
        XLTabView a = this.k.a(str);
        if (a != null) {
            boolean z = false;
            if ("xllive".equals(str) && i == 0) {
                if (!DateUtil.isTheSameDay(f.b((Context) this, "live_red_point_last_show_time", 0), System.currentTimeMillis())) {
                    f.a((Context) this, "live_red_point_show_count", 0);
                } else if (f.b((Context) this, "live_red_point_show_count", 0) >= 3) {
                    return;
                }
            }
            if ("xllive".equals(str) != null) {
                str = ac.a();
                if (i == 0) {
                    z = true;
                }
                str.c(z);
            }
            a.setPointVisible(i);
        }
    }

    public final void b(boolean z) {
        if (z) {
            a("find", 0);
        } else {
            a("find", 8);
        }
    }

    public final void a() {
        a(MessageInfo.USER, 8);
    }

    public final void a(boolean z, String str) {
        XLTabView a = this.k.a(MessageInfo.USER);
        if (a.a() || !z) {
            a.setPointTvVisible(true);
            return;
        }
        a.setPointTvVisible(false);
        a.setPointTvText(str);
        a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder stringBuilder = new StringBuilder("onActivityResult--requestCode=");
        stringBuilder.append(i);
        stringBuilder.append("|resultCode=");
        stringBuilder.append(i2);
        if (i == 1000) {
            BaseFragment baseFragment = null;
            if (this.m != null) {
                baseFragment = this.m.a("thunder");
            }
            if (baseFragment instanceof BaseViewPagerFragment) {
                ((BaseViewPagerFragment) baseFragment).a(i, i2, intent);
            }
            return;
        }
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a(this, i, i2, intent);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        z = this.m ? this.m.a("thunder") : false;
        if (z && (z instanceof BaseViewPagerFragment)) {
            ((BaseViewPagerFragment) z).c();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!(this.k == null || this.k.getCurrentTag() == null || !this.k.getCurrentTag().equals("thunder"))) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.B != null) {
            this.B.a(i, strArr, iArr);
        }
    }

    private void h() {
        if (this.B != null) {
            this.B.d();
            this.B = null;
        }
    }

    public final void b() {
        this.d.setVisibility(0);
        if (this.j != null && this.j.isRunning()) {
            this.j.cancel();
            this.j = null;
        }
        this.j = ObjectAnimator.ofFloat(this.d, View.TRANSLATION_Y, new float[]{0.0f});
        this.j.setDuration(300);
        this.j.start();
    }

    private void c(boolean z) {
        if (!z) {
            com.xunlei.downloadprovider.h.j.a((Activity) this);
        } else if (this.t && this.t.s()) {
            com.xunlei.downloadprovider.h.j.a((Activity) this);
        } else {
            com.xunlei.downloadprovider.h.j.b((Activity) this);
        }
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra("exit", false)) {
                g();
            } else {
                b(intent);
                a(intent, null);
            }
        }
    }

    static /* synthetic */ void a(MainTabActivity mainTabActivity) {
        com.xunlei.downloadprovider.app.a.d a = com.xunlei.downloadprovider.app.a.d.a();
        if (!com.xunlei.downloadprovider.app.a.d.c) {
            com.xunlei.downloadprovider.app.a.d.c = true;
            c cVar = a.b[2];
            if (cVar instanceof m) {
                ((m) cVar).c();
            }
        }
        com.xunlei.downloadprovider.discovery.kuainiao.d.a();
        com.xunlei.downloadprovider.discovery.kuainiao.d.e();
        if (mainTabActivity.x) {
            mainTabActivity.x = false;
            if (!com.xunlei.xllib.android.b.a(mainTabActivity)) {
                com.xunlei.downloadprovider.download.engine.task.n.a();
                if (com.xunlei.downloadprovider.download.engine.task.n.j().getFinishedTaskCount() > 0) {
                    com.xunlei.downloadprovider.dialog.f fVar = new com.xunlei.downloadprovider.dialog.f(mainTabActivity);
                    fVar.a(mainTabActivity.getString(R.string.frame_main_check_net_message));
                    fVar.c(mainTabActivity.getString(R.string.frame_main_check_net_left_btn));
                    fVar.d(mainTabActivity.getString(R.string.frame_main_check_net_right_btn));
                    fVar.a(new m(mainTabActivity));
                    fVar.b(new n(mainTabActivity));
                    XLToast.setNoNetworkToastForbidden(true);
                    fVar.show();
                } else if (!com.xunlei.xllib.android.b.a(mainTabActivity)) {
                    Toast toast = new Toast(mainTabActivity);
                    View inflate = LayoutInflater.from(mainTabActivity).inflate(R.layout.movies_invalid_network_toast, null);
                    toast.setGravity(17, 0, 0);
                    toast.setView(inflate);
                    toast.setDuration(0);
                    toast.show();
                }
            }
            com.xunlei.downloadprovider.launch.guide.a.a aVar = new com.xunlei.downloadprovider.launch.guide.a.a();
            if (com.xunlei.downloadprovider.launch.guide.a.a.a()) {
                switch (com.xunlei.downloadprovider.d.d.a().f.b()) {
                    case 1:
                        aVar.a = new com.xunlei.downloadprovider.launch.guide.a.c();
                        break;
                    case 2:
                        aVar.a = new com.xunlei.downloadprovider.launch.guide.a.d();
                        break;
                    case 3:
                        aVar.a = new com.xunlei.downloadprovider.launch.guide.a.e();
                        break;
                    case 4:
                        aVar.a = new com.xunlei.downloadprovider.launch.guide.a.f();
                        break;
                    default:
                        aVar.a = new com.xunlei.downloadprovider.launch.guide.a.c();
                        break;
                }
            }
            if (com.xunlei.downloadprovider.launch.guide.a.a.a()) {
                LoginHelper.a();
                if (!l.c()) {
                    if (!LoginHelper.a().b.b) {
                        if (aVar.a == null) {
                            throw new RuntimeException("请先调用applyStrategy方法");
                        }
                        new StringBuilder("startLoginGuide3 mStrategy.name: ").append(aVar.a.getClass().getSimpleName());
                        if (aVar.a.a()) {
                            LoginHelper.a().a((Context) mainTabActivity, null, LoginFrom.MAIN_TAB_LOGIN_GUIDE, null);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean c(MainTabActivity mainTabActivity) {
        return mainTabActivity.k.getCurrentTabView() == mainTabActivity.k.a("find") ? true : null;
    }

    static /* synthetic */ boolean f(MainTabActivity mainTabActivity) {
        return mainTabActivity.k.getCurrentTabView() == mainTabActivity.k.a(MessageInfo.USER) ? true : null;
    }

    static /* synthetic */ void h(MainTabActivity mainTabActivity) {
        if (l.c()) {
            mainTabActivity.d();
        } else {
            mainTabActivity.t.a((Context) mainTabActivity, new l(mainTabActivity), LoginFrom.EXIT_APP_SIGN, null);
        }
    }
}
