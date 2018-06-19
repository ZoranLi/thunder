package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xunlei.downloadprovider.homepage.photoarticle.PhotoArticleDetailActivity;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import org.android.agoo.common.AgooConstants;

/* compiled from: SchemeDISPPhotoArticleDetail */
final class l extends d {
    l() {
    }

    protected final boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!(intent == null || !a.c(intent) || "/artical".equals(intent.getPath()) == null)) {
            z = true;
        }
        return z;
    }

    protected final void a(Context context, Intent intent) {
        intent.setClass(context, PhotoArticleDetailActivity.class);
        intent.putExtra("from", "forground_h5");
        Uri data = intent.getData();
        if (data != null) {
            intent.putExtra(AgooConstants.MESSAGE_ID, data.getQueryParameter(AgooConstants.MESSAGE_ID));
        }
        context.startActivity(intent);
        c.a(a.a(data), a.b(data));
        c.a("share_pic", true);
    }
}
