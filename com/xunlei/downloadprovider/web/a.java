package com.xunlei.downloadprovider.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.xunlei.common.commonview.anim.AnimationManager;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.downloadprovider.web.browser.BrowserActivity;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: BrowserUtil */
public final class a {
    private static a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static void a(Context context, String str, @Nullable String str2, @Nullable String str3) {
        if (str3 == null) {
            str3 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        CustomWebViewActivity.a(context, str3, str, str2, CustomWebViewActivity.class);
    }

    public static void a(Context context, String str, boolean z, BrowserFrom browserFrom) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra("url", str);
        xLIntent.putExtra("zoom", z);
        xLIntent.putExtra("intent_key_start_from", browserFrom);
        xLIntent.setClass(context, BrowserActivity.class);
        if ((context instanceof Activity) != null) {
            context.startActivity(xLIntent);
            AnimationManager.playStartRightInLeftOutAnimation((Activity) context);
            return;
        }
        xLIntent.setFlags(268435456);
        context.startActivity(xLIntent);
    }

    public static void a(Context context, int i, String str, boolean z, BrowserFrom browserFrom) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra("url", str);
        xLIntent.putExtra("zoom", z);
        xLIntent.putExtra("intent_key_start_from", browserFrom);
        xLIntent.putExtra("first_entry", i);
        xLIntent.setClass(context, BrowserActivity.class);
        if ((context instanceof Activity) != 0) {
            context.startActivity(xLIntent);
            AnimationManager.playStartRightInLeftOutAnimation((Activity) context);
            return;
        }
        xLIntent.setFlags(268435456);
        context.startActivity(xLIntent);
    }

    public static void a(Context context, String str, String str2, String str3, BrowserFrom browserFrom) {
        Intent xLIntent = new XLIntent();
        xLIntent.putExtra("url", str);
        xLIntent.putExtra("zoom", true);
        xLIntent.putExtra("intent_key_start_from", browserFrom);
        xLIntent.putExtra("first_entry", 2074);
        xLIntent.putExtra("download_detail_key_word", str2);
        xLIntent.putExtra("download_detail_resource_ref_page_url", str3);
        xLIntent.setClass(context, BrowserActivity.class);
        if ((context instanceof Activity) != null) {
            context.startActivity(xLIntent);
            AnimationManager.playStartRightInLeftOutAnimation((Activity) context);
            return;
        }
        xLIntent.setFlags(268435456);
        context.startActivity(xLIntent);
    }
}
