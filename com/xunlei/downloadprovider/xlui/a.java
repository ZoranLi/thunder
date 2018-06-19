package com.xunlei.downloadprovider.xlui;

import android.app.Activity;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.R;

/* compiled from: DimModeHelper */
public final class a {
    public static void a(Activity activity, @ColorInt int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(R.id.fake_status_view);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(null);
            }
            findViewById.setBackgroundColor(i);
            return;
        }
        findViewById = new View(activity);
        activity = activity.getResources();
        findViewById.setLayoutParams(new LayoutParams(-1, activity.getDimensionPixelSize(activity.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID))));
        findViewById.setBackgroundColor(i);
        findViewById.setId(R.id.fake_status_view);
        viewGroup.addView(findViewById);
    }
}
