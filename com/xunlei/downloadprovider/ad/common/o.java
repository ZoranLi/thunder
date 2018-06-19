package com.xunlei.downloadprovider.ad.common;

import android.app.Activity;
import android.content.Context;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: UIHelper */
public final class o {
    public static void a(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    public static String a(l lVar) {
        if (lVar.x() != null) {
            if (!lVar.x().trim().equals("")) {
                return lVar.x().trim();
            }
        }
        if (lVar.u() == 2) {
            return b(lVar);
        }
        return BrothersApplication.getApplicationInstance().getString(R.string.ad_web_action_name);
    }

    public static String b(l lVar) {
        lVar = lVar.D();
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        String a = a();
        switch (lVar) {
            case 1:
                return applicationInstance.getString(R.string.ad_app_status_undownload);
            case 2:
                return applicationInstance.getString(R.string.ad_app_status_downloading);
            case 3:
                return applicationInstance.getString(R.string.ad_app_status_uninstall);
            case 4:
                return applicationInstance.getString(R.string.ad_app_status_intalled);
            default:
                return a;
        }
    }

    public static String a() {
        return BrothersApplication.getApplicationInstance().getString(R.string.ad_app_status_undownload);
    }
}
