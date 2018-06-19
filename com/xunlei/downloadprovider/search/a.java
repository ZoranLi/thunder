package com.xunlei.downloadprovider.search;

import android.app.Activity;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;

/* compiled from: SearchModuleUtil */
public abstract class a {
    public static void a(Activity activity) {
        SearchOperateActivity.a(activity, "", "");
        activity.overridePendingTransition(R.anim.search_activity_in, R.anim.search_activity_out);
    }
}
