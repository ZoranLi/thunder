package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.shortvideo.ui.s;

public class ADImageItemViewTemplateUGCStyle2 extends ADImageItemviewBase<d> {
    private static final String d = "ADImageItemViewTemplateUGCStyle2";

    private int getStyleLayout() {
        return R.layout.choiceness_ad_image_item_template_ugc_style_2;
    }

    public int getReportStyle() {
        return 202;
    }

    public ADImageItemViewTemplateUGCStyle2(Context context) {
        super(context);
    }

    public ADImageItemViewTemplateUGCStyle2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ADImageItemViewTemplateUGCStyle2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return getStyleLayout();
    }

    protected final void a(Context context) {
        super.a(context);
        ((d) this.c).e = findViewById(R.id.item_icon_layout);
        if (((d) this.c).e != null) {
            ((d) this.c).e.getLayoutParams().width = s.a();
        }
        ((d) this.c).h = (ImageView) findViewById(R.id.btn_action);
        ((d) this.c).i = (TextView) findViewById(R.id.choiceness_ad_source_tv);
    }

    public final void b() {
        super.b();
        ((d) this.c).h.setVisibility(4);
        ((d) this.c).i.setText("");
    }

    protected final void b(l lVar) {
        super.b(lVar);
        if (lVar.u() == 2) {
            ((d) this.c).h.setImageResource(R.drawable.choiceness_ad_bg_download_btn_template_ugc_selector);
        } else {
            ((d) this.c).h.setImageResource(R.drawable.choiceness_ad_web_btn_template_ugc_selector);
        }
        ((d) this.c).h.setVisibility(0);
    }

    protected final void c(l lVar) {
        super.c(lVar);
        ((d) this.c).i.setText(f.a(lVar, R.string.choiceness_ad_source));
    }

    protected final /* synthetic */ a d() {
        return new d(this);
    }
}
