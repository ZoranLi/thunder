package com.xunlei.downloadprovider.ad.common.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.xllib.android.XLIntent;

public class WebViewToutiaoActivity extends CustomWebViewActivity {
    private static final String i = "WebViewToutiaoActivity";

    public final boolean c() {
        return false;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent xLIntent = new XLIntent(context, WebViewToutiaoActivity.class);
        xLIntent.putExtra("url", str);
        xLIntent.putExtra("contentid", str2);
        xLIntent.putExtra("tabid", str3);
        xLIntent.putExtra("content_type", str4);
        xLIntent.putExtra("playid", str5);
        xLIntent.putExtra("enter_time", str6);
        xLIntent.putExtra("tag", str7);
        xLIntent.putExtra("source", str8);
        if ((context instanceof Activity) == null) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }

    protected final void a() {
        super.a();
        if (VERSION.SDK_INT >= 21) {
            this.f.getSettings().setMixedContentMode(0);
        }
        this.f.a(new f(this));
    }

    protected final void b() {
        super.b();
        this.a.setOnQuitListener(new g(this));
        this.a.getmTitleView().setVisibility(8);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClickGoback(View view) {
        super.onClickGoback(view);
    }

    protected void onStop() {
        this.f.f();
        super.onStop();
    }

    protected void onDestroy() {
        String stringExtra = getIntent().getStringExtra("contentid");
        int intExtra = getIntent().getIntExtra("tabid", 0);
        String stringExtra2 = getIntent().getStringExtra("content_type");
        String stringExtra3 = getIntent().getStringExtra("playid");
        String stringExtra4 = getIntent().getStringExtra("enter_time");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        b.a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4, stringBuilder.toString(), getIntent().getStringExtra("tag"), getIntent().getStringExtra("source"));
        super.onDestroy();
    }
}
