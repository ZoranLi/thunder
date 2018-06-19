package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;

/* compiled from: SchemeDISPShortMovie */
final class n extends d {
    n() {
    }

    protected final boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!(intent == null || !a.c(intent) || "/resourceDetail".equals(intent.getPath()) == null)) {
            z = true;
        }
        return z;
    }

    protected final void a(Context context, Intent intent) {
        intent.setClass(context, ShortMovieDetailActivity.class);
        Uri data = intent.getData();
        String a = a.a(data);
        intent.putExtra("from", a);
        context.startActivity(intent);
        c.a(a, a.b(data));
        c.a("share_video", true);
    }
}
