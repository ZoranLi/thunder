package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.shortvideo.ui.s;

/* compiled from: ADGDTVideoItemTemplateUGC */
public class g extends a<b> {
    private static final String f = "g";

    public int getLayoutId() {
        return R.layout.choiceness_ad_gdt_play_vod_item_template_ugc;
    }

    public int getReportStyle() {
        return 201;
    }

    public g(Context context, a aVar) {
        super(context, aVar);
    }

    protected final void a(View view) {
        super.a(view);
        ((b) this.c).k = findViewById(R.id.item_icon_layout);
        if (((b) this.c).k != null) {
            ((b) this.c).k.getLayoutParams().width = s.a();
        }
        ((b) this.c).m = (TextView) view.findViewById(R.id.choiceness_ad_download_status_tv);
        ((b) this.c).o = (TextView) view.findViewById(R.id.tv_ad_tag);
        ((b) this.c).n = (TextView) view.findViewById(R.id.choiceness_ad_source_tv);
    }

    protected final void j() {
        super.j();
        ((b) this.c).m.setText(u.a());
        ((b) this.c).m.setVisibility(8);
        ((b) this.c).o.setVisibility(4);
        ((b) this.c).n.setText("");
    }

    protected final void g() {
        super.g();
        ((b) this.c).o.setVisibility(0);
    }

    protected final void i() {
        super.i();
        ((b) this.c).m.setText(this.d.w() ? u.a(this.d) : getResources().getString(R.string.ad_app_status_intalled));
        ((b) this.c).m.setVisibility(0);
    }

    protected final void h() {
        super.h();
        ((b) this.c).n.setText(f.a(this.d, R.string.choiceness_ad_source_short));
    }

    public final void a() {
        a(this.d);
    }

    protected final /* synthetic */ a e() {
        return new b(this);
    }
}
