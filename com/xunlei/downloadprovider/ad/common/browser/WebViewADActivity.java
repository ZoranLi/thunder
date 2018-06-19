package com.xunlei.downloadprovider.ad.common.browser;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebViewClient;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.report.CommonReportInfo;
import com.xunlei.downloadprovider.ad.common.report.d;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.web.a;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.xllib.android.XLIntent;

public class WebViewADActivity extends CustomWebViewActivity {
    private static final String i = "WebViewADActivity";
    private a j = null;
    private CommonReportInfo k = null;
    private WebViewClient l = new e(this);

    public final boolean c() {
        return false;
    }

    public static void startWebViewADActivity(Context context, String str, String str2, String str3, Bundle bundle) {
        context.startActivity(a(context, str, str2, str3, bundle));
    }

    public static Intent a(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent xLIntent = new XLIntent(context, WebViewADActivity.class);
        xLIntent.putExtra("from", str);
        xLIntent.putExtra("url", str2);
        xLIntent.putExtra("title", str3);
        if (bundle != null) {
            xLIntent.putExtras(bundle);
        }
        if ((context instanceof Activity) == null) {
            xLIntent.addFlags(268435456);
        }
        return xLIntent;
    }

    protected final void a(Intent intent) {
        super.a(intent);
        intent = intent.getSerializableExtra("ad_common_report_info");
        if (intent instanceof CommonReportInfo) {
            this.k = (CommonReportInfo) intent;
        }
    }

    protected final void a() {
        super.a();
        this.j = new a(this);
        this.f.setWebViewClient(this.l);
        if (VERSION.SDK_INT >= 21) {
            this.f.getSettings().setMixedContentMode(0);
        }
        this.f.a(new b(this));
        this.f.setOnDeepLinkCallListener(new c(this));
    }

    protected final void b() {
        super.b();
        this.a.setOnQuitListener(new d(this));
    }

    public void onBackPressed() {
        if (!this.f.h()) {
            i();
        }
        super.onBackPressed();
    }

    public void onClickGoback(View view) {
        i();
        super.onClickGoback(view);
    }

    public static void a(String str, CommonReportInfo commonReportInfo) {
        if (commonReportInfo != null) {
            d.a("web", str, commonReportInfo);
        }
    }

    public static void a(String str, CommonReportInfo commonReportInfo, int i) {
        if (commonReportInfo != null) {
            d.a("web", str, commonReportInfo, i);
        }
    }

    private void i() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_back");
            if (!TextUtils.isEmpty(stringExtra)) {
                int i = -1;
                int hashCode = stringExtra.hashCode();
                if (hashCode != -1256414617) {
                    if (hashCode != -1124130625) {
                        if (hashCode == 1145746141) {
                            if (stringExtra.equals("back_push_web_view")) {
                                i = 2;
                            }
                        }
                    } else if (stringExtra.equals("back_splash")) {
                        i = 0;
                    }
                } else if (stringExtra.equals("back_push_auction_transaction_state")) {
                    i = 1;
                }
                switch (i) {
                    case 0:
                        MainTabActivity.b(this, "thunder", null);
                        finish();
                        return;
                    case 1:
                        o d = i.a().d("auction");
                        if (!(d == null || TextUtils.isEmpty(d.e))) {
                            a.a();
                            a.a(this, d.e, null, this.h);
                        }
                        return;
                    case 2:
                        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
                        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
                            MainTabActivity.b(this, "thunder", null);
                        }
                        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    protected void onStop() {
        this.f.f();
        super.onStop();
    }
}
