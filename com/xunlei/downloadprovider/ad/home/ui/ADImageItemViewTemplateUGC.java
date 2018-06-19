package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.shortvideo.ui.s;

public class ADImageItemViewTemplateUGC extends ADImageItemviewBase<c> {
    private static final String d = "ADImageItemViewTemplateUGC";

    private int getStyleLayout() {
        return R.layout.choiceness_ad_image_item_template_ugc;
    }

    public int getReportStyle() {
        return 201;
    }

    public ADImageItemViewTemplateUGC(Context context) {
        super(context);
    }

    public ADImageItemViewTemplateUGC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ADImageItemViewTemplateUGC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return getStyleLayout();
    }

    protected final void a(Context context) {
        super.a(context);
        ((c) this.c).e = findViewById(R.id.item_icon_layout);
        if (((c) this.c).e != null) {
            ((c) this.c).e.getLayoutParams().width = s.a();
        }
        ((c) this.c).h = (TextView) findViewById(R.id.choiceness_ad_download_status_tv);
        ((c) this.c).i = (TextView) findViewById(R.id.tv_ad_tag);
        ((c) this.c).j = (TextView) findViewById(R.id.choiceness_ad_source_tv);
    }

    public final void b() {
        super.b();
        ((c) this.c).h.setText(u.a());
        ((c) this.c).h.setVisibility(8);
        ((c) this.c).i.setVisibility(4);
        ((c) this.c).j.setText("");
    }

    protected final void b(l lVar) {
        super.b(lVar);
        ((c) this.c).i.setVisibility(0);
    }

    protected final void c() {
        super.c();
        ((c) this.c).h.setText(o.a(this.a));
        ((c) this.c).h.setVisibility(0);
    }

    protected final void c(l lVar) {
        super.c(lVar);
        ((c) this.c).j.setText(f.a(lVar, R.string.choiceness_ad_source_short));
    }

    protected final /* synthetic */ a d() {
        return new c(this);
    }
}
