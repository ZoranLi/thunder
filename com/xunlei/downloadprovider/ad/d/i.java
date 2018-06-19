package com.xunlei.downloadprovider.ad.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: ShortMoviePlayCompleteADCtr */
public final class i {
    public l a;
    public View b;
    public int c;
    public OnClickListener d;
    private Context e;
    private final String f = "adv_bigvideo_detail_show";
    private final String g = "adv_bigvideo_detail_click";

    public i(Context context) {
        this.e = context;
        this.a = f.a(BrothersApplication.getApplicationInstance()).c.d;
    }

    public i(l lVar, Context context) {
        this.a = lVar;
        this.e = context;
    }

    public final void a(ViewGroup viewGroup) {
        if (this.a != null) {
            if (this.c == 0) {
                a("adv_bigvideo_detail_show");
            }
            if (this.b == null) {
                this.b = LayoutInflater.from(BrothersApplication.getApplicationInstance()).inflate(R.layout.short_movie_detail_vod_ad, viewGroup, true);
            } else {
                b();
            }
            if (this.b != null) {
                a(this.b);
                if (this.c == 1) {
                    viewGroup = this.b.findViewById(R.id.replay_btn);
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                        viewGroup.setOnClickListener(new j(this));
                    }
                }
            }
        }
    }

    public final void a() {
        if (this.b != null) {
            View findViewById = this.b.findViewById(R.id.float_container);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public final void b() {
        if (this.b != null) {
            View findViewById = this.b.findViewById(R.id.float_container);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
    }

    final void a(String str) {
        Object obj;
        Map hashMap = new HashMap();
        hashMap.put("advid", this.a.e());
        String str2 = "ad_type";
        l lVar = this.a;
        if (lVar.A != null) {
            if (!lVar.A.equals("")) {
                obj = lVar.A;
                hashMap.put(str2, obj);
                hashMap.put("material", this.a.a());
                a.a(str, hashMap);
            }
        }
        obj = "0";
        hashMap.put(str2, obj);
        hashMap.put("material", this.a.a());
        a.a(str, hashMap);
    }

    public final void a(View view) {
        if (this.a != null) {
            view.findViewById(R.id.mask_view).setOnTouchListener(new k(this));
            Glide.with(this.e).load(this.a.k()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into((ImageView) view.findViewById(R.id.vi_icon));
            ((TextView) view.findViewById(R.id.tv_name)).setText(this.a.j());
            ((RatingBar) view.findViewById(R.id.score_rb)).setRating(this.a.q());
            ((TextView) view.findViewById(R.id.btn_download)).setText(this.a.u() == 2 ? "点击下载" : "查看详情");
            view.findViewById(R.id.container).setOnClickListener(new l(this, view));
        }
    }
}
