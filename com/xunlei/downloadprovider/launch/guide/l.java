package com.xunlei.downloadprovider.launch.guide;

import android.support.annotation.NonNull;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.d.d;

/* compiled from: GuideModel */
public final class l implements q {
    @NonNull
    public final a a() {
        a aVar = new a();
        b(aVar);
        return aVar;
    }

    @NonNull
    public final a a(@NonNull a aVar) {
        b(aVar);
        return aVar;
    }

    private static void b(@NonNull a aVar) {
        CooperationItem a = c.a().a(1);
        if (a == null) {
            a = new CooperationItem();
            a.setDisplayLocation(1);
            a.setAppName(BrothersApplication.getApplicationInstance().getString(R.string.default_bindapk_name));
            a.setCopyWriting(BrothersApplication.getApplicationInstance().getString(R.string.default_bindapk_content));
            a.setAppPackageName("com.sogou.novel");
            a.setAppSelfIconUrl("");
            a.setAppIconUrl("");
            a.setAppDownloadUrl("http://dl.k.sogou.com/channel/SogouNovel1575.apk");
        }
        aVar.a = a;
        aVar.d = ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance().getApplicationContext(), aVar.a.getAppPackageName());
        aVar.c = d.a().f.a();
        aVar.b = aVar.a();
    }
}
