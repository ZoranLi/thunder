package com.xunlei.downloadprovider.vod.player;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.xunlei.downloadprovider.R;

/* compiled from: VodPlayerBasePopupWindow */
public class d extends PopupWindow {
    private OnDismissListener a;
    protected Context c;

    public void setOnDismissListener(OnDismissListener onDismissListener) {
    }

    public d(Context context) {
        super(context);
        this.c = context;
        super.setOnDismissListener(new e(this, context));
    }

    public void setContentView(View view) {
        super.setContentView(view);
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(this.c.getResources().getDimensionPixelSize(R.dimen.vod_player_popup_menu_width));
        setHeight(-1);
        setFocusable(true);
        setAnimationStyle(R.style.vod_player_menu_anim);
    }
}
