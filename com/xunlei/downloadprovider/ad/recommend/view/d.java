package com.xunlei.downloadprovider.ad.recommend.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.web.a;
import java.util.HashMap;

/* compiled from: RecommendAdViewHolder */
final class d implements OnClickListener {
    final /* synthetic */ o a;
    final /* synthetic */ String b;
    final /* synthetic */ View c;
    final /* synthetic */ c d;

    d(c cVar, o oVar, String str, View view) {
        this.d = cVar;
        this.a = oVar;
        this.b = str;
        this.c = view;
    }

    public final void onClick(View view) {
        a.a();
        a.a(this.d.getContext(), this.a == null ? "http://mou.niu.xunlei.com/scoremall/gamecenter/index.html?from=download_in" : this.a.g, this.b, "");
        view = new HashMap();
        view.put("point_status", this.c.getVisibility() == 0 ? "1" : "0");
        com.xunlei.downloadprovider.ad.home.a.a("android_mobgame_channel", "c_game_dlcenter_click", view);
        view = i.a();
        long currentTimeMillis = System.currentTimeMillis();
        view = view.d("game_center");
        if (view != null) {
            view.n = currentTimeMillis;
        }
        view = BrothersApplication.getApplicationInstance().getSharedPreferences("red_point_cloud_config", 0);
        if (view != null) {
            view.edit().putLong(String.valueOf("dlgamecenter"), currentTimeMillis).apply();
        }
        i.a();
        i.d();
        this.c.setVisibility(8);
        view = com.xunlei.downloadprovider.ad.b.a.a();
        com.xunlei.downloadprovider.ad.b.a.a(view.a);
        com.xunlei.downloadprovider.ad.b.a.a(view.b);
        com.xunlei.downloadprovider.ad.b.a.a(view.c);
    }
}
