package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.shortvideo.ui.s;

/* compiled from: ADPlayVodItemTemplateUGC */
public class p extends l<c> {
    private static final String d = "p";

    private int getStyleLayout() {
        return R.layout.choiceness_ad_play_vod_item_temple_ugc;
    }

    public int getReportStyle() {
        return 201;
    }

    public p(Context context, a aVar) {
        super(context, aVar);
    }

    public int getLayoutId() {
        return getStyleLayout();
    }

    protected final void e() {
        super.e();
        ((c) this.b).h = findViewById(R.id.item_icon_layout);
        if (((c) this.b).h != null) {
            ((c) this.b).h.getLayoutParams().width = s.a();
        }
        ((c) this.b).k = (TextView) findViewById(R.id.choiceness_ad_download_status_tv);
        ((c) this.b).l = (TextView) findViewById(R.id.tv_ad_tag);
        ((c) this.b).m = (TextView) findViewById(R.id.choiceness_ad_source_tv);
    }

    public final void i() {
        super.i();
        ((c) this.b).l.setVisibility(4);
        ((c) this.b).k.setText(u.a());
        ((c) this.b).k.setVisibility(8);
        ((c) this.b).m.setText("");
    }

    protected final void b(l lVar) {
        super.b(lVar);
        ((c) this.b).l.setVisibility(0);
    }

    protected final void h() {
        super.h();
        ((c) this.b).k.setText(o.a(this.c));
        ((c) this.b).k.setVisibility(0);
        ((c) this.b).k.setOnClickListener(new q(this));
    }

    protected final void c(l lVar) {
        super.c(lVar);
        ((c) this.b).m.setText(f.a(lVar, R.string.choiceness_ad_source_short));
    }

    protected final /* synthetic */ a a() {
        return new c(this);
    }
}
