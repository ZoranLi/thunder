package com.xunlei.downloadprovider.download.player.a;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.vod.player.PointerPopupWindow;

/* compiled from: SubtitleController */
final class bc implements Runnable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ ba b;

    bc(ba baVar, SharedPreferences sharedPreferences) {
        this.b = baVar;
        this.a = sharedPreferences;
    }

    public final void run() {
        ae l = this.b.s.l();
        boolean z = false;
        if (l.a != null && l.a.getVisibility() == 0) {
            z = true;
        }
        if (this.b.v == null && !r2) {
            ba baVar = this.b;
            ba baVar2 = this.b;
            int dip2px = DipPixelUtil.dip2px(12.0f);
            int dip2px2 = DipPixelUtil.dip2px(200.0f);
            View view = baVar2.h;
            View inflate = LayoutInflater.from(baVar2.g).inflate(R.layout.vod_player_subtitle_number_tip_popupwindow, null);
            ((TextView) inflate.findViewById(R.id.tip_text)).setText("字幕功能全新上线，快来试试");
            PopupWindow pointerPopupWindow = new PointerPopupWindow(baVar2.g, dip2px2);
            pointerPopupWindow.setContentView(inflate);
            pointerPopupWindow.a.setImageResource(R.drawable.vod_player_popup_arrow);
            pointerPopupWindow.a(view, ((-dip2px2) * 2) / 3, dip2px);
            baVar.v = pointerPopupWindow;
            this.a.edit().putBoolean("KEY_Subtitle_First_Use_Tips_Shown", true).apply();
        }
    }
}
