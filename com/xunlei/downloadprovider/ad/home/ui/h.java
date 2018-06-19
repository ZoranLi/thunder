package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.shortvideo.ui.s;

/* compiled from: ADGDTVideoItemTemplateUGCStyle2 */
public class h extends a<c> {
    private static final String f = "h";

    public int getLayoutId() {
        return R.layout.choiceness_ad_gdt_play_vod_item_template_ugc_style_2;
    }

    public int getReportStyle() {
        return 202;
    }

    public h(Context context, a aVar) {
        super(context, aVar);
    }

    protected final void a(View view) {
        super.a(view);
        ((c) this.c).k = findViewById(R.id.item_icon_layout);
        if (((c) this.c).k != null) {
            ((c) this.c).k.getLayoutParams().width = s.a();
        }
        ((c) this.c).m = (ImageView) view.findViewById(R.id.btn_action);
        ((c) this.c).n = (TextView) view.findViewById(R.id.choiceness_ad_source_tv);
    }

    protected final void j() {
        super.j();
        ((c) this.c).m.setVisibility(4);
        ((c) this.c).n.setText("");
    }

    protected final void i() {
        if (this.d.u() == 2) {
            ((c) this.c).m.setImageResource(R.drawable.choiceness_ad_bg_download_btn_template_ugc_selector);
        } else {
            ((c) this.c).m.setImageResource(R.drawable.choiceness_ad_web_btn_template_ugc_selector);
        }
        ((c) this.c).m.setVisibility(0);
    }

    protected final void h() {
        super.h();
        ((c) this.c).n.setText(f.a(this.d, R.string.choiceness_ad_source));
    }

    public final void a() {
        a(this.d);
    }

    protected final /* synthetic */ a e() {
        return new c(this);
    }
}
