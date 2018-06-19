package com.xunlei.downloadprovider.ad.recommend;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: RecommendAdUtil */
public final class b {
    public static String a(l lVar) {
        if (lVar.x() != null) {
            if (!lVar.x().trim().equals("")) {
                return lVar.x().trim();
            }
        }
        if (lVar.u() == 2) {
            return BrothersApplication.getApplicationInstance().getString(R.string.task_list_recommend_use_app_ad_action_name);
        }
        return BrothersApplication.getApplicationInstance().getString(R.string.task_list_recommend_use_web_ad_action_name);
    }
}
