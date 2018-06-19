package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.view.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import com.xunlei.downloadprovider.homepage.choiceness.m;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: ChoicenessWebsiteView */
public final class at extends a implements b<n> {
    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        n nVar = (n) eVar;
        getReportStrategy().a = nVar;
        a((WebsiteInfo) nVar.a, (VideoUserInfo) nVar.b);
    }

    public at(@NonNull Context context) {
        super(context, new m());
    }

    protected final boolean a(long j) {
        return System.currentTimeMillis() - j < 864000000 ? 1 : 0;
    }
}
