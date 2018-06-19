package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.shortvideo.ui.s;

/* compiled from: ADPlayVodItemTemplateUGCStyle2 */
public class r extends l<d> {
    private static final String d = "r";

    private int getStyleLayout() {
        return R.layout.choiceness_ad_play_vod_item_temple_ugc_style_2;
    }

    public int getReportStyle() {
        return 202;
    }

    public r(Context context, a aVar) {
        super(context, aVar);
    }

    public int getLayoutId() {
        return getStyleLayout();
    }

    protected final void e() {
        super.e();
        ((d) this.b).h = findViewById(R.id.item_icon_layout);
        if (((d) this.b).h != null) {
            ((d) this.b).h.getLayoutParams().width = s.a();
        }
        ((d) this.b).k = (ImageView) findViewById(R.id.btn_action);
        ((d) this.b).l = (TextView) findViewById(R.id.choiceness_ad_source_tv);
    }

    public final void i() {
        super.i();
        ((d) this.b).k.setVisibility(4);
        ((d) this.b).l.setText("");
    }

    protected final void b(l lVar) {
        super.b(lVar);
        if (lVar.u() == 2) {
            ((d) this.b).k.setImageResource(R.drawable.choiceness_ad_bg_download_btn_template_ugc_selector);
        } else {
            ((d) this.b).k.setImageResource(R.drawable.choiceness_ad_web_btn_template_ugc_selector);
        }
        ((d) this.b).k.setOnClickListener(new s(this, lVar));
        ((d) this.b).k.setVisibility(0);
    }

    protected final void c(l lVar) {
        super.c(lVar);
        ((d) this.b).l.setText(f.a(lVar, R.string.choiceness_ad_source));
    }

    protected final /* synthetic */ a a() {
        return new d(this);
    }
}
