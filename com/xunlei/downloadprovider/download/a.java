package com.xunlei.downloadprovider.download;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.download.taskdetails.DownloadDetailPageActivity;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.web.website.activity.DownloadTabWebsiteActivity;

/* compiled from: DownloadCenterPageUtil */
public final class a {
    private static final a a = new a();

    public static a a() {
        return a;
    }

    private a() {
    }

    public static void a(Context context, long j, String str) {
        a(context, j, str, null);
    }

    public static void a(Context context, long j, String str, Bundle bundle) {
        if (b.d()) {
            Activity c = AppStatusChgObserver.b().c();
            if (c != null && (c instanceof ShortMovieDetailActivity)) {
                c.finish();
            }
            a(context, j, str, null, bundle);
            return;
        }
        c(context, j, str, bundle);
    }

    public static void a(Context context) {
        if (context != null) {
            if (b.d()) {
                DownloadTabWebsiteActivity.a(context);
            } else {
                a(context, DLCenterEntry.personal_my_collection.toString());
            }
        }
    }

    public static void b(Context context, long j, String str) {
        if (b.e()) {
            DownloadDetailsActivity.a(context, j, str);
        } else {
            DownloadDetailPageActivity.a(context, j, str);
        }
    }

    public static void a(Context context, long j, String str, Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            bundle2 = new Bundle(9);
        }
        bundle2.putLong(l.m, j);
        bundle2.putString("from", str);
        if (bundle == null) {
            bundle = new Bundle(9);
        }
        bundle.putBundle("download_tab_arguments", bundle2);
        MainTabActivity.a(context, "download", bundle);
    }

    public static void c(Context context, long j, String str, Bundle bundle) {
        DownloadCenterActivity.a(context, j, str, bundle);
    }

    public static void a(Context context, String str) {
        a(context, -1, str, null);
    }

    public static void b(Context context, long j, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(9);
        }
        Bundle bundle2 = bundle;
        bundle2.putBoolean("extra_key_should_open_detailpage", true);
        if (b.d() != null) {
            a(context, j, str, null, bundle2);
        } else {
            c(context, j, str, bundle2);
        }
    }
}
