package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskDetailEmptyAdView */
public class i extends a {
    private static final String c = "i";

    public final void a(@NonNull l lVar) {
    }

    public String getAdUIStyle() {
        return RePlugin.PROCESS_UI;
    }

    public i(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(0, 0));
        d();
    }

    public final void d() {
        int bottomMarginWhileHide = getBottomMarginWhileHide();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = bottomMarginWhileHide;
        }
    }
}
