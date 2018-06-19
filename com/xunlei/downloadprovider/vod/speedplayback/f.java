package com.xunlei.downloadprovider.vod.speedplayback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.vod.player.d;

/* compiled from: VodSpeedSelectPopupWindow */
final class f extends d {
    a a;
    View b;
    LinearLayout d;

    /* compiled from: VodSpeedSelectPopupWindow */
    interface a {
        boolean a(VodSpeedRate vodSpeedRate);
    }

    f(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.vod_play_speed_select_popupwindow, null);
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R.dimen.vod_player_speed_rate_popup_width));
        this.d = (LinearLayout) inflate.findViewById(R.id.vod_speed_rate_pop_container);
        this.d.removeAllViews();
        for (VodSpeedRate vodSpeedRate : VodSpeedRate.values()) {
            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.include_vod_speed_rate_item, null).findViewById(R.id.vod_speed_rate_item_tv);
            textView.setText(vodSpeedRate.getRateDescription());
            textView.setOnClickListener(new g(this, vodSpeedRate));
            textView.setTag(vodSpeedRate);
            this.d.addView(textView, new LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.vod_play_popup_item_height)));
            this.d.addView(LayoutInflater.from(context).inflate(R.layout.include_vod_play_popup_item_divider, null), new LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.payment_1_dp)));
        }
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
    }
}
