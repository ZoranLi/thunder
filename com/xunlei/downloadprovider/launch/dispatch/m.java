package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: SchemeDISPPublisher */
final class m extends d {
    m() {
    }

    protected final boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!(intent == null || !a.c(intent) || "/publisher".equals(intent.getPath()) == null)) {
            z = true;
        }
        return z;
    }

    protected final void a(Context context, Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            Object queryParameter = data.getQueryParameter("userId");
            intent.putExtra("userid", queryParameter);
            if (TextUtils.isEmpty(queryParameter) == null) {
                intent = data.getQueryParameter("kind");
                CharSequence queryParameter2 = data.getQueryParameter("username");
                if (TextUtils.isEmpty(queryParameter2)) {
                    queryParameter2 = "迅雷用户";
                }
                CharSequence charSequence = queryParameter2;
                if (TextUtils.isEmpty(intent)) {
                    intent = "per";
                }
                Intent intent2 = intent;
                long parseLong = Long.parseLong(queryParameter);
                c.a(a.a(data), a.b(data));
                com.xunlei.downloadprovider.personal.user.account.m.a(context, parseLong, intent2, charSequence, "", From.SHARE_H5);
            }
        }
    }
}
