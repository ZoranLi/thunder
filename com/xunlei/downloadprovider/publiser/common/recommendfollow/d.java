package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import java.util.List;

/* compiled from: FollowRecommendManager */
public final class d {
    public static void a(Activity activity, List<a> list, View view, String str) {
        if (activity != null) {
            if ((VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !com.xunlei.xllib.b.d.a(list)) {
                if (list.size() >= 3) {
                    e eVar = new e(activity, view, list, str);
                    eVar.setWidth(-1);
                    eVar.a();
                    if (eVar.isShowing() != null) {
                        list = activity.getWindow().getAttributes();
                        list.alpha = 0.6f;
                        activity.getWindow().setAttributes(list);
                    }
                    j.a(str);
                }
            }
        }
    }
}
