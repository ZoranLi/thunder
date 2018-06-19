package com.xunlei.downloadprovider.web.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.az;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.d.m;
import com.xunlei.downloadprovider.download.create.au;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.browser.a.i;
import com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper;
import java.io.File;

public class BrowserActivity extends BaseActivity implements au, com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment.b, com.xunlei.downloadprovider.web.browser.BrowserToolBarFragment.b {
    public static final String a = "BrowserActivity";
    private static long k = -1;
    private d A = new d(new q(this));
    private WebViewClient B = new t(this);
    private a C = new a();
    private String D;
    private String E = "";
    public Handler c;
    b d = new b();
    c e = new c();
    boolean f = false;
    a g;
    private XLAlertDialog h;
    private BrowserFrom i;
    private long j;
    private DownloadListener l = new c(this);
    private i m = new i();
    private WebView n;
    private ViewGroup o;
    private BrowserTitleBarFragment p;
    private BrowserToolBarFragment q;
    private boolean r = false;
    private boolean s = false;
    private InputAutoCompleteView t;
    private String u = "";
    private String v = "";
    private String w = "";
    private long x = 0;
    private WebChromeClient y = new o(this);
    private String z = "";

    private static class a {
        View a;
        View b;
        ImageView c;
        TextView d;
        TextView e;
        String f;
        OnClickListener g;

        private a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public final void a(int i) {
            if (this.a != null) {
                this.a.setVisibility(i);
            }
        }

        public final void b(int i) {
            if (this.c != null) {
                this.c.setImageResource(i);
            }
        }

        public final void a(int i, int i2) {
            if (this.d != null) {
                this.d.setText(i);
            }
            if (this.e != 0) {
                if (i2 == 0) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setText(i2);
                    this.e.setVisibility(0);
                }
            }
        }
    }

    private static class c {
        String a;
        boolean b;
        int c;
        BrowserFrom d;
        boolean e;

        private c() {
            this.b = false;
            this.c = 0;
            this.e = false;
        }
    }

    private class b implements MessageListener {
        final /* synthetic */ BrowserActivity a;

        private b(BrowserActivity browserActivity) {
            this.a = browserActivity;
        }

        public final void handleMessage(Message message) {
            if (message.what == 10002) {
                this.a.a(message.arg1, (String) message.obj);
            }
        }
    }

    public final void b(boolean z) {
        if (this.q != null && this.q.a != null) {
            this.q.a.a(z);
        }
    }

    public final void a(int i, String str) {
        if (this.n != null) {
            this.n.setVisibility(4);
        }
        this.C.f = str;
        this.C.a(0);
        if (com.xunlei.xllib.android.b.a(this) == null) {
            this.C.b(R.drawable.commonui_bg_invalid_network);
            this.C.a(R.string.commonui_invalid_network, R.string.click_refresh);
        } else if (i == 404) {
            this.C.b(R.drawable.commonui_bg_page_gone);
            this.C.a(R.string.thunder_browser_error_page_title_get_info_failed, 0);
        } else {
            this.C.b(R.drawable.commonui_bg_invalid_network);
            this.C.a(R.string.unable_open_page, R.string.click_refresh);
        }
        if (this.C.b != 0) {
            this.C.b.requestFocus();
        }
    }

    public final void a() {
        this.C.a(4);
        if (this.n != null) {
            this.n.setVisibility(0);
        }
    }

    protected void onCreate(android.os.Bundle r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        super.onCreate(r7);
        r7 = r6.getWindow();
        r0 = -3;
        r7.setFormat(r0);
        r7 = new com.xunlei.common.androidutil.HandlerUtil$StaticHandler;
        r0 = r6.d;
        r7.<init>(r0);
        r6.c = r7;
        r7 = 2130968617; // 0x7f040029 float:1.7545893E38 double:1.052838386E-314;
        r6.setContentView(r7);
        r7 = r6.getIntent();
        r7 = r7.getExtras();
        r0 = 0;
        r1 = 1;
        if (r7 == 0) goto L_0x0070;
    L_0x0026:
        r2 = r6.e;
        r3 = "zoom";
        r3 = r7.getBoolean(r3, r1);
        r2.e = r3;
        r2 = r6.e;
        r2.e = r1;
        r2 = r6.e;
        r3 = "url";
        r3 = r7.getString(r3);
        r2.a = r3;
        r2 = r6.e;
        r3 = "first_entry";
        r3 = r7.getInt(r3, r0);
        r2.c = r3;
        r2 = r6.e;
        r3 = "asDownloader";
        r3 = r7.getBoolean(r3, r0);
        r2.b = r3;
        r2 = "intent_key_start_from";	 Catch:{ Exception -> 0x006a }
        r7 = r7.getSerializable(r2);	 Catch:{ Exception -> 0x006a }
        r7 = (com.xunlei.downloadprovider.web.BrowserFrom) r7;	 Catch:{ Exception -> 0x006a }
        r6.i = r7;	 Catch:{ Exception -> 0x006a }
        r7 = r6.e;	 Catch:{ Exception -> 0x006a }
        r2 = r6.i;	 Catch:{ Exception -> 0x006a }
        if (r2 != 0) goto L_0x0065;	 Catch:{ Exception -> 0x006a }
    L_0x0062:
        r2 = com.xunlei.downloadprovider.web.BrowserFrom.OTHER;	 Catch:{ Exception -> 0x006a }
        goto L_0x0067;	 Catch:{ Exception -> 0x006a }
    L_0x0065:
        r2 = r6.i;	 Catch:{ Exception -> 0x006a }
    L_0x0067:
        r7.d = r2;	 Catch:{ Exception -> 0x006a }
        goto L_0x0070;
    L_0x006a:
        r7 = r6.e;
        r2 = com.xunlei.downloadprovider.web.BrowserFrom.OTHER;
        r7.d = r2;
    L_0x0070:
        r7 = r6.getSupportFragmentManager();
        r2 = 2131886394; // 0x7f12013a float:1.9407366E38 double:1.053291828E-314;
        r7 = r7.findFragmentById(r2);
        r7 = (com.xunlei.downloadprovider.web.browser.BrowserTitleBarFragment) r7;
        r6.p = r7;
        r7 = 2131886399; // 0x7f12013f float:1.9407376E38 double:1.0532918306E-314;
        r7 = r6.findViewById(r7);
        r7 = (com.xunlei.downloadprovider.web.browser.InputAutoCompleteView) r7;
        r6.t = r7;
        r7 = r6.p;
        r7 = r7.h;
        r2 = r6.t;
        r7.b = r2;
        r2 = r7.b;
        if (r2 == 0) goto L_0x011e;
    L_0x0096:
        r2 = r7.b;
        r3 = r7.d;
        r3 = r3.c;
        r2.j = r3;
        r3 = r2.h;
        r4 = "layout_inflater";
        r3 = r3.getSystemService(r4);
        r3 = (android.view.LayoutInflater) r3;
        r4 = 2130968690; // 0x7f040072 float:1.754604E38 double:1.052838422E-314;
        r3 = r3.inflate(r4, r2);
        r2.i = r3;
        r3 = r2.i;
        r4 = 2131886742; // 0x7f120296 float:1.9408071E38 double:1.053292E-314;
        r3 = r3.findViewById(r4);
        r3 = (android.widget.LinearLayout) r3;
        r4 = new com.xunlei.downloadprovider.web.browser.ar;
        r4.<init>(r2);
        r3.setOnTouchListener(r4);
        r2.a();
        r3 = r2.e;
        r4 = r2.d;
        r3.addAll(r4);
        r3 = new com.xunlei.downloadprovider.web.browser.InputAutoCompleteView$a;
        r4 = r2.h;
        r3.<init>(r2, r4);
        r2.g = r3;
        r3 = 2131886743; // 0x7f120297 float:1.9408073E38 double:1.0532920005E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.ListView) r3;
        r2.k = r3;
        r3 = r2.k;
        r4 = new com.xunlei.downloadprovider.web.browser.as;
        r4.<init>(r2);
        r3.setOnTouchListener(r4);
        r3 = r2.k;
        r4 = r2.g;
        r3.setAdapter(r4);
        r3 = r2.j;
        r4 = new com.xunlei.downloadprovider.web.browser.at;
        r4.<init>(r2);
        r3.setOnKeyListener(r4);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2.f = r3;
        r3 = r2.f;
        r2 = r2.h;
        r4 = 2131362447; // 0x7f0a028f float:1.8344675E38 double:1.053032964E-314;
        r2 = r2.getString(r4);
        r3.add(r2);
        r2 = r7.b;
        r3 = new com.xunlei.downloadprovider.web.browser.ak;
        r3.<init>(r7);
        r2.setUIClient(r3);
    L_0x011e:
        r7 = r6.p;
        r2 = r7.getActivity();
        r3 = 2131886400; // 0x7f120140 float:1.9407378E38 double:1.053291831E-314;
        r2 = r2.findViewById(r3);
        r2 = (com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView) r2;
        r7.d = r2;
        r2 = r7.d;
        r7.getActivity();
        com.xunlei.downloadprovider.search.ui.widget.KeyboardHelpView.a();
        r2 = r7.d;
        r3 = new com.xunlei.downloadprovider.web.browser.ai;
        r3.<init>(r7);
        r2.setTextViewOnClickListener(r3);
        r2 = r7.d;
        r7 = r7.c;
        r2.setEditText(r7);
        r7 = r6.getSupportFragmentManager();
        r2 = 2131886398; // 0x7f12013e float:1.9407374E38 double:1.05329183E-314;
        r7 = r7.findFragmentById(r2);
        r7 = (com.xunlei.downloadprovider.web.browser.BrowserToolBarFragment) r7;
        r6.q = r7;
        r7 = r6.q;
        r7.a(r0);
        r7 = r6.q;
        r7.b(r0);
        r7 = r6.q;
        r7 = r7.a;
        r2 = new com.xunlei.downloadprovider.web.browser.d;
        r2.<init>(r6);
        r7.a = r2;
        r7 = r6.q;
        r2 = new com.xunlei.downloadprovider.web.browser.e;
        r2.<init>(r6);
        r7.c = r2;
        r7 = 2131886395; // 0x7f12013b float:1.9407368E38 double:1.0532918286E-314;
        r7 = r6.findViewById(r7);
        r7 = (android.view.ViewGroup) r7;
        r6.o = r7;
        r7 = 2131886397; // 0x7f12013d float:1.9407372E38 double:1.0532918296E-314;
        r7 = r6.findViewById(r7);
        r7 = (com.tencent.smtt.sdk.WebView) r7;
        r6.n = r7;
        r7 = r6.n;
        r2 = r7.getSettings();
        r2.setJavaScriptEnabled(r1);
        r2.setDomStorageEnabled(r1);
        r2.setDatabaseEnabled(r1);
        r3 = r6.getApplicationContext();
        r4 = "database";
        r3 = r3.getDir(r4, r0);
        r3 = r3.getPath();
        r2.setDatabasePath(r3);
        r3 = -1;
        r2.setCacheMode(r3);
        r2.setLoadWithOverviewMode(r1);
        r3 = com.tencent.smtt.sdk.WebSettings.RenderPriority.HIGH;
        r2.setRenderPriority(r3);
        r2.setBlockNetworkImage(r0);
        r2.setAppCacheEnabled(r1);
        r3 = 2;
        r2.setCacheMode(r3);
        r3 = "GBK";
        r2.setDefaultTextEncodingName(r3);
        r3 = r2.getUserAgentString();
        r4 = new java.lang.StringBuilder;
        r5 = "Android.Thunder.";
        r4.<init>(r5);
        r4.append(r3);
        r3 = r4.toString();
        r2.setUserAgentString(r3);
        r3 = r6.e;
        r3 = r3.e;
        if (r3 == 0) goto L_0x01ea;
    L_0x01e1:
        r2.setSupportZoom(r1);
        r2.setBuiltInZoomControls(r1);
        r2.setDisplayZoomControls(r0);
    L_0x01ea:
        r2 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
        r7.setScrollBarStyle(r2);
        r7.setFocusableInTouchMode(r1);
        r2 = r7.getSettings();
        r2.setUseWideViewPort(r1);
        r7.requestFocus();
        r2 = new android.os.Bundle;	 Catch:{ Exception -> 0x021b }
        r2.<init>();	 Catch:{ Exception -> 0x021b }
        r3 = "standardFullScreen";	 Catch:{ Exception -> 0x021b }
        r2.putBoolean(r3, r0);	 Catch:{ Exception -> 0x021b }
        r0 = "supportLiteWnd";	 Catch:{ Exception -> 0x021b }
        r2.putBoolean(r0, r1);	 Catch:{ Exception -> 0x021b }
        r0 = "DefaultVideoScreen";	 Catch:{ Exception -> 0x021b }
        r2.putInt(r0, r1);	 Catch:{ Exception -> 0x021b }
        r0 = r6.n;	 Catch:{ Exception -> 0x021b }
        r0 = r0.getX5WebViewExtension();	 Catch:{ Exception -> 0x021b }
        r1 = "setVideoParams";	 Catch:{ Exception -> 0x021b }
        r0.invokeMiscMethod(r1, r2);	 Catch:{ Exception -> 0x021b }
    L_0x021b:
        r0 = r6.m;
        r0.a(r7);
        r7 = r6.m;
        r0 = r6.l;
        r7.a(r0);
        r7 = r6.m;
        r0 = r6.y;
        r7.a(r0);
        r7 = r6.m;
        r0 = r6.B;
        r7.a(r0);
        r7 = r6.C;
        r0 = 2131886396; // 0x7f12013c float:1.940737E38 double:1.053291829E-314;
        r0 = r6.findViewById(r0);
        r7.a = r0;
        r1 = 2131886971; // 0x7f12037b float:1.9408536E38 double:1.053292113E-314;
        r1 = r0.findViewById(r1);
        r7.b = r1;
        r1 = 2131886968; // 0x7f120378 float:1.940853E38 double:1.0532921117E-314;
        r1 = r0.findViewById(r1);
        r1 = (android.widget.ImageView) r1;
        r7.c = r1;
        r1 = 2131886969; // 0x7f120379 float:1.9408532E38 double:1.053292112E-314;
        r1 = r0.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r7.d = r1;
        r1 = 2131886970; // 0x7f12037a float:1.9408534E38 double:1.0532921127E-314;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.TextView) r0;
        r7.e = r0;
        r0 = r7.b;
        if (r0 == 0) goto L_0x0278;
    L_0x026e:
        r0 = r7.b;
        r1 = new com.xunlei.downloadprovider.web.browser.x;
        r1.<init>(r7);
        r0.setOnClickListener(r1);
    L_0x0278:
        r7 = r6.C;
        r0 = new com.xunlei.downloadprovider.web.browser.f;
        r0.<init>(r6);
        r7.g = r0;
        com.xunlei.downloadprovider.download.c.a(r6, r6);
        r7 = com.xunlei.downloadprovider.web.browser.a.a.b.a();
        r0 = new com.xunlei.downloadprovider.web.browser.a.a.c;
        r0.<init>(r7);
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);
        r7 = com.xunlei.downloadprovider.web.browser.a.a.a();
        r0 = new com.xunlei.downloadprovider.web.browser.a.c;
        r0.<init>(r7);
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);
        r7 = com.xunlei.downloadprovider.web.website.g.b.a();
        r7.b();
        r6.c();
        r0 = java.lang.System.currentTimeMillis();
        r6.j = r0;
        r0 = r6.j;
        k = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserActivity.onCreate(android.os.Bundle):void");
    }

    protected void onResume() {
        super.onResume();
        new StringBuilder("onResume: ").append(getTaskId());
        if (this.n != null) {
            this.n.onResume();
        }
        if (this.q != null && this.q.a != null && this.n != null) {
            com.xunlei.downloadprovider.web.website.g.b.a().a(this.n.getUrl(), new v(this));
        }
    }

    protected void onPause() {
        if (this.n != null) {
            this.n.onPause();
        }
        new StringBuilder("onPause: ").append(getTaskId());
        super.onPause();
    }

    protected void onDestroy() {
        new StringBuilder("onDestroy: ").append(getTaskId());
        if (this.m != null) {
            this.m.a();
            BrowserTranscodeHelper.getInstance().closeOldConnect();
            this.m.k();
        }
        if (this.C != null) {
            a aVar = this.C;
            aVar.a = null;
            aVar.b = null;
        }
        if (this.n != null) {
            try {
                if (this.o != null) {
                    this.o.removeView(this.n);
                }
                this.n.removeAllViews();
                this.n.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.A != null) {
            this.A.a();
        }
        super.onDestroy();
    }

    private void c() {
        String str = this.e.a;
        if (this.e.b) {
            a(str, "", "", b("browser/other"));
            return;
        }
        m.a().c();
        if (!TextUtils.isEmpty(str)) {
            a(str, false);
        }
        if (this.p != null) {
            BrowserTitleBarFragment browserTitleBarFragment = this.p;
            if (!(browserTitleBarFragment.e == null || browserTitleBarFragment.f == null)) {
                browserTitleBarFragment.e.setVisibility(0);
                com.xunlei.downloadprovider.cooperation.a.a.a(l.c(browserTitleBarFragment.f.getDisplayLocation()), browserTitleBarFragment.f.getAppPackageName(), browserTitleBarFragment.f.isShowInstallTip());
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    public final void c(boolean z) {
        if (z) {
            this.p.b(this.m.g());
        }
    }

    public void onBrowserTitleBarBackButtonClick(View view) {
        d();
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, R.string.browser_input_empty_tip, 0).show();
        } else if (com.xunlei.downloadprovider.h.k.a.d(str)) {
            a(str, true);
        } else {
            a(str, true);
            XLThreadPool.execute(new g(this, str));
        }
    }

    public final void a(CooperationItem cooperationItem, boolean z) {
        if (cooperationItem != null) {
            boolean isApkPackageInstalled = ApkHelper.isApkPackageInstalled(getApplication(), cooperationItem.getAppPackageName());
            com.xunlei.downloadprovider.cooperation.a.a.a(l.c(cooperationItem.getDisplayLocation()), cooperationItem.getAppPackageName(), cooperationItem.isShowInstallTip(), isApkPackageInstalled, "");
            if (isApkPackageInstalled) {
                if (z) {
                    ApkHelper.openWebUrlByTargetBrowser(this, cooperationItem.getAppPackageName(), this.m ? this.m.g() : "");
                } else {
                    ApkHelper.launchAppByPackageName(this, cooperationItem.getAppPackageName());
                }
            } else if (cooperationItem.isShowInstallTip()) {
                CharSequence appDescription = cooperationItem.getAppDescription();
                if (this.h == null) {
                    this.h = new XLAlertDialog(this);
                }
                this.h.setMessage(appDescription);
                this.h.setTitle(cooperationItem.getTitle());
                this.h.setConfirmButtonText((CharSequence) "确认");
                this.h.setCancelButtonText((CharSequence) "取消");
                this.h.setOnClickConfirmButtonListener(new h(this, cooperationItem));
                this.h.setOnClickCancelButtonListener(new i(this, cooperationItem));
                this.h.show();
                com.xunlei.downloadprovider.cooperation.a.a.a(l.c(cooperationItem.getDisplayLocation()), cooperationItem.getAppPackageName());
            } else {
                b(cooperationItem);
            }
        }
    }

    private void b(CooperationItem cooperationItem) {
        com.xunlei.downloadprovider.cooperation.ui.b.a();
        if (com.xunlei.downloadprovider.cooperation.ui.b.a(cooperationItem)) {
            com.xunlei.downloadprovider.cooperation.ui.b.a();
            com.xunlei.downloadprovider.cooperation.ui.b.a(BrothersApplication.getApplicationInstance(), cooperationItem.getAppName());
            return;
        }
        n.a();
        long e = n.e(cooperationItem.getAppDownloadUrl());
        if (e != -1) {
            n.a();
            TaskInfo f = n.f(e);
            if (f == null || f.mLocalFileName == null || !new File(f.mLocalFileName).exists() || f.mDownloadedSize != f.mFileSize) {
                c(cooperationItem);
                return;
            } else {
                ApkHelper.installApk(this, f.mLocalFileName);
                return;
            }
        }
        c(cooperationItem);
    }

    private static void c(CooperationItem cooperationItem) {
        if (cooperationItem != null) {
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = TextUtils.isEmpty(cooperationItem.getAppSelfIconUrl()) ? cooperationItem.getAppIconUrl() : cooperationItem.getAppSelfIconUrl();
            downloadAdditionInfo.a = cooperationItem.getAppName();
            downloadAdditionInfo.f = true;
            String appDownloadUrl = cooperationItem.getAppDownloadUrl();
            TaskStatInfo taskStatInfo = new TaskStatInfo(appDownloadUrl, null);
            taskStatInfo.a = com.xunlei.downloadprovider.download.report.c.a(l.c(cooperationItem.getDisplayLocation()), cooperationItem.getAppPackageName());
            cooperationItem = "";
            if (!TextUtils.isEmpty(downloadAdditionInfo.a)) {
                cooperationItem = new StringBuilder();
                cooperationItem.append(downloadAdditionInfo.a);
                cooperationItem.append(ShareConstants.PATCH_SUFFIX);
                cooperationItem = cooperationItem.toString();
            }
            com.xunlei.downloadprovider.download.c.a(appDownloadUrl, cooperationItem, 0, "", taskStatInfo, downloadAdditionInfo, null);
        }
    }

    public void onBrowserRefreshButtonClick(View view) {
        if (!(com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) == null || this.m == null)) {
            this.p.a();
            this.m.b();
            this.m.i();
        }
    }

    public void onBrowserGoBackButtonClick(View view) {
        if (this.m != null) {
            this.p.a();
            this.m.g = true;
            BrowserTranscodeHelper.getInstance().filterUrlForTranscodeGoBack(this.m);
            this.m.d();
        }
    }

    public void onBrowserStopButtonClick(View view) {
        if (this.m != null) {
            this.m.a();
            BrowserTranscodeHelper.getInstance().closeOldConnect();
            this.p.b(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.m.a();
            BrowserTranscodeHelper.getInstance().closeOldConnect();
            if (this.m.c()) {
                this.p.a();
                BrowserTranscodeHelper.getInstance().filterUrlForTranscodeGoBack(this.m);
                this.m.d();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onBrowserGoForwardButtonClick(View view) {
        if (this.m != null) {
            this.p.a();
            this.m.g = true;
            BrowserTranscodeHelper.getInstance().filterUrlForTranscodeGoForward(this.m);
            this.m.f();
        }
    }

    public final void a(CooperationItem cooperationItem) {
        a(cooperationItem, true);
    }

    public final void a(boolean z) {
        if (!isFinishing()) {
            if (this.p) {
                z = this.p;
                if (z.b != null) {
                    z.b.a(false);
                }
            }
            if (this.e.b) {
                finish();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        TaskStatInfo taskStatInfo = new TaskStatInfo(str, str3);
        taskStatInfo.a = str4;
        DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
        downloadAdditionInfo.e = str3;
        downloadAdditionInfo.d = this.D;
        com.xunlei.downloadprovider.download.c.a(this, str, str2, 0, str3, taskStatInfo, downloadAdditionInfo, this.A);
    }

    public void onBackPressed() {
        if (this.p.b()) {
            this.p.a();
            return;
        }
        if (this.n != null) {
            this.n.stopLoading();
            BrowserTranscodeHelper.getInstance().closeOldConnect();
        }
        d();
    }

    private void d() {
        if (this.e.c == 43 || this.e.c == 42 || this.e.c == 16 || this.i.equals(BrowserFrom.THIRDAPP_URL_INPUT)) {
            MainTabActivity.b(this, "thunder", null);
        }
        finish();
    }

    public void onActionModeStarted(ActionMode actionMode) {
        if (this.p.b()) {
            if (this.g == null) {
                this.g = new a(new k(this));
            }
            a aVar = this.g;
            boolean d = com.xunlei.downloadprovider.d.l.a().d();
            if (actionMode != null) {
                Menu menu = actionMode.getMenu();
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    String charSequence = item.getTitle().toString();
                    if (charSequence.equals("复制") || charSequence.equals("分享") || charSequence.equals("网页搜索")) {
                        menu.getItem(i).setOnMenuItemClickListener(new b(aVar, actionMode));
                    }
                    if (!d && charSequence.equals("分享")) {
                        menu.removeItem(item.getItemId());
                    }
                }
                aa.d();
            }
        }
        super.onActionModeStarted(actionMode);
    }

    private String b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(this.i.toString());
        return stringBuilder.toString();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, boolean r6) {
        /*
        r4 = this;
        r0 = "";
        r1 = "thunder://";
        r1 = r5.startsWith(r1);
        if (r1 != 0) goto L_0x0049;
    L_0x000a:
        r1 = "magnet:?";
        r1 = r5.startsWith(r1);
        if (r1 != 0) goto L_0x0049;
    L_0x0012:
        r1 = "ed2k://";
        r1 = r5.startsWith(r1);
        if (r1 != 0) goto L_0x0049;
    L_0x001a:
        r1 = "http://thunder://";
        r1 = r5.startsWith(r1);
        if (r1 != 0) goto L_0x0049;
    L_0x0022:
        r1 = "http://ed2k://";
        r1 = r5.startsWith(r1);
        if (r1 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x0049;
    L_0x002b:
        r1 = "ftp://";
        r1 = r5.startsWith(r1);
        if (r1 == 0) goto L_0x0056;
    L_0x0033:
        r1 = "/";
        r1 = r5.endsWith(r1);
        if (r1 != 0) goto L_0x0056;
    L_0x003b:
        r1 = com.xunlei.downloadprovider.h.k.a(r5);
        if (r1 != 0) goto L_0x0047;
    L_0x0041:
        r1 = com.xunlei.downloadprovider.h.k.f(r5);
        if (r1 == 0) goto L_0x0056;
    L_0x0047:
        r0 = r5;
        goto L_0x0056;
    L_0x0049:
        r0 = "http://";
        r0 = r5.startsWith(r0);
        if (r0 == 0) goto L_0x0047;
    L_0x0051:
        r0 = 7;
        r0 = r5.substring(r0);
    L_0x0056:
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 1;
        if (r0 != 0) goto L_0x0082;
    L_0x005d:
        r0 = "";
        r2 = "";
        r3 = "browser/other";
        r3 = r4.b(r3);
        r4.a(r5, r0, r2, r3);
        r0 = r4.p;
        r0.a(r5, r1);
        r5 = r4.p;
        r5.a();
        if (r6 != 0) goto L_0x0081;
    L_0x0076:
        r5 = r4.m;
        r5 = r5.c();
        if (r5 != 0) goto L_0x0081;
    L_0x007e:
        r4.finish();
    L_0x0081:
        return;
    L_0x0082:
        r6 = com.xunlei.downloadprovider.h.k.a.d(r5);
        if (r6 == 0) goto L_0x010b;
    L_0x0088:
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 != 0) goto L_0x0105;
    L_0x008e:
        r6 = "www";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x0105;
    L_0x0096:
        r6 = "dy2018.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x009e:
        r6 = "dy2018.net";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00a6:
        r6 = "dytt8.net";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00ae:
        r6 = "dytt8.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00b6:
        r6 = "piaohua.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00be:
        r6 = "dygod.net";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00c6:
        r6 = "dygod.cn";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00ce:
        r6 = "dygod.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00d6:
        r6 = "ygdy8.net";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00de:
        r6 = "ygdy8.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00e6:
        r6 = "xiaopian.com";
        r6 = r5.startsWith(r6);
        if (r6 != 0) goto L_0x00f6;
    L_0x00ee:
        r6 = "dygod.org";
        r6 = r5.startsWith(r6);
        if (r6 == 0) goto L_0x0105;
    L_0x00f6:
        r6 = new java.lang.StringBuilder;
        r0 = "www.";
        r6.<init>(r0);
        r6.append(r5);
        r6 = r6.toString();
        goto L_0x0106;
    L_0x0105:
        r6 = r5;
    L_0x0106:
        r6 = com.xunlei.downloadprovider.h.k.a.e(r6);
        goto L_0x0112;
    L_0x010b:
        com.xunlei.downloadprovider.d.m.a();
        r6 = com.xunlei.downloadprovider.d.m.d(r5);
    L_0x0112:
        r0 = new java.lang.StringBuilder;
        r2 = "loadOnSearch: ";
        r0.<init>(r2);
        r0.append(r5);
        r5 = " ";
        r0.append(r5);
        r0.append(r6);
        r5 = r4.p;
        r5.a(r6, r1);
        r5 = r4.p;
        r5.a();
        r5 = r4.m;
        r5.g = r1;
        r5 = r4.m;
        r5.a(r6);
        r5 = com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper.getInstance();
        r0 = r4.m;
        r5.shouldOverrideUrlLoadingForTranscode(r0, r6, r1);
        r5 = r4.m;
        r5.i();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.BrowserActivity.a(java.lang.String, boolean):void");
    }

    static /* synthetic */ void a(BrowserActivity browserActivity, String str, String str2, String str3, String str4) {
        CooperationData b = com.xunlei.downloadprovider.cooperation.ui.b.b();
        if (b == null) {
            browserActivity.a(str, str2, str3, str4);
            return;
        }
        com.xunlei.downloadprovider.cooperation.ui.b.a();
        com.xunlei.downloadprovider.cooperation.ui.b.a(browserActivity.getSupportFragmentManager(), b, new n(browserActivity, str, str2, str3, str4));
    }

    static /* synthetic */ void a(BrowserActivity browserActivity, String str, String str2) {
        Object obj = 1;
        if (!com.xunlei.downloadprovider.h.k.a.d(str) || k.h(str) == 1) {
            obj = null;
        }
        if (!com.xunlei.downloadprovider.contentpublish.website.a.m.a().d(str) || str.length() >= 256) {
            obj = null;
        }
        if (!com.xunlei.xllib.android.b.a(browserActivity)) {
            obj = null;
        }
        if (obj == null) {
            com.xunlei.downloadprovider.web.website.g.b.a().a(str2, str, "");
            return;
        }
        browserActivity.z = "";
        browserActivity.E = "";
        az.a().a(str, new p(browserActivity, str2, str));
    }

    static /* synthetic */ void c(BrowserActivity browserActivity) {
        if (browserActivity.c != null) {
            browserActivity.c.postDelayed(new j(browserActivity), 500);
        }
    }

    static /* synthetic */ void f(BrowserActivity browserActivity) {
        com.xunlei.downloadprovider.web.website.g.b a = com.xunlei.downloadprovider.web.website.g.b.a();
        XLThreadPool.execute(new com.xunlei.downloadprovider.web.website.g.i(a, browserActivity.D, browserActivity.m.g(), browserActivity.E));
        if (!a.a(browserActivity.m.g()) && com.xunlei.downloadprovider.contentpublish.website.a.m.a().d(browserActivity.m.g())) {
            com.xunlei.downloadprovider.web.website.g.b.a();
            com.xunlei.downloadprovider.web.website.g.b.a(browserActivity, browserActivity.m.g(), browserActivity.D, browserActivity.E, "browser", new r(browserActivity));
        }
    }

    static /* synthetic */ void g(BrowserActivity browserActivity) {
        if (browserActivity.s) {
            com.xunlei.downloadprovider.download.a.a(browserActivity, DLCenterEntry.browser.toString());
            browserActivity.finish();
        }
    }

    static /* synthetic */ void j(BrowserActivity browserActivity) {
        browserActivity.q.a(browserActivity.m.c());
        browserActivity.q.b(browserActivity.m.e());
    }

    static /* synthetic */ void u(BrowserActivity browserActivity) {
        if (browserActivity.h != null && browserActivity.h.isShowing()) {
            browserActivity.h.dismiss();
        }
        browserActivity.h = null;
    }
}
