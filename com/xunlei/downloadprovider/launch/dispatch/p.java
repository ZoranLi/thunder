package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tencent.open.SocialConstants;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.launch.f.a;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: SchemeDISPWebsiteDetail */
final class p extends d {
    p() {
    }

    protected final boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        intent = intent.getData();
        if (!a.c(intent) || "/websiteDetail".equals(intent.getPath()) == null) {
            return false;
        }
        return true;
    }

    protected final void a(Context context, Intent intent) {
        Uri data = intent.getData();
        String queryParameter = data.getQueryParameter("siteid");
        String queryParameter2 = data.getQueryParameter("title");
        String queryParameter3 = data.getQueryParameter("desc");
        String queryParameter4 = data.getQueryParameter("url");
        String queryParameter5 = data.getQueryParameter(SocialConstants.PARAM_APP_ICON);
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.a = queryParameter;
        websiteInfo.e = queryParameter2;
        websiteInfo.d = queryParameter3;
        websiteInfo.f = queryParameter4;
        websiteInfo.g = queryParameter5;
        intent.setClass(context, WebsiteDetailActivity.class);
        intent = a.a(data);
        WebsiteDetailActivity.a(context, new VideoUserInfo(), websiteInfo, intent);
        c.a(intent, a.b(data));
        c.a(DispatchConstants.OTHER, true);
    }
}
