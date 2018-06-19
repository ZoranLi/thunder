package com.xunlei.downloadprovider.launch.guide.a;

import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: MainTabLoginGuideStrategy3 */
public final class e extends b {
    public final boolean a() {
        long b = f.b(BrothersApplication.getApplicationInstance(), "main_tab_login_guide_time_millis", 0);
        long currentTimeMillis = System.currentTimeMillis();
        boolean isTheSameDay = DateUtil.isTheSameDay(b, currentTimeMillis) ^ 1;
        if (isTheSameDay) {
            f.a(BrothersApplication.getApplicationInstance(), "main_tab_login_guide_time_millis", currentTimeMillis);
        }
        return isTheSameDay;
    }
}
