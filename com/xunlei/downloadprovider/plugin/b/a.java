package com.xunlei.downloadprovider.plugin.b;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.xunlei.common.commonview.RoundProgressBar;
import com.xunlei.downloadprovider.R;

/* compiled from: PluginLoadingPopupWindow */
public final class a {
    public Activity a;
    public View b;
    public PopupWindow c;
    public RoundProgressBar d = ((RoundProgressBar) this.g.findViewById(R.id.dlg_storage_tip_size_rpbar));
    public TextView e;
    public OnDismissListener f;
    private View g;

    public a(Activity activity) {
        this.a = activity;
        this.b = activity.getWindow().getDecorView();
        this.g = LayoutInflater.from(activity).inflate(R.layout.plugin_loading_progress_bar, null);
        this.d.setMax(100);
        this.e = (TextView) this.g.findViewById(R.id.plugin_download_tip_txtview);
        this.c = new PopupWindow(this.g, -2, -2);
        this.c.setFocusable(true);
        this.c.setOutsideTouchable(true);
        this.c.setBackgroundDrawable(new BitmapDrawable());
        this.c.setOnDismissListener(new b(this));
    }

    public final boolean a() {
        return this.c != null ? this.c.isShowing() : false;
    }
}
