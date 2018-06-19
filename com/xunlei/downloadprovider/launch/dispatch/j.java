package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import org.android.agoo.common.AgooConstants;

/* compiled from: SchemeDISPCinecismDetail */
final class j extends d {
    j() {
    }

    protected final boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!(intent == null || !a.c(intent) || "/cinecism".equals(intent.getPath()) == null)) {
            z = true;
        }
        return z;
    }

    protected final void a(Context context, Intent intent) {
        intent.setClass(context, CinecismDetailActivity.class);
        intent.putExtra("from", "share_page");
        Uri data = intent.getData();
        if (data != null) {
            intent.putExtra(AgooConstants.MESSAGE_ID, data.getQueryParameter(AgooConstants.MESSAGE_ID));
        }
        context.startActivity(intent);
        c.a(a.a(data), a.b(data));
        c.a("share_pic", true);
    }
}
