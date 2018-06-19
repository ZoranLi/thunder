package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;

/* compiled from: TaskDetailBannerAdViewStyle4 */
public final class h extends d {
    protected TextView e = null;
    protected TextView f = null;
    protected ImageView g = null;

    public final String getAdUIStyle() {
        return "204";
    }

    protected final int getLayoutResourceId() {
        return R.layout.layout_task_detail_ad_style_banner_4;
    }

    public h(Context context) {
        super(context);
        a();
    }

    protected final void b() {
        super.b();
        this.e = (TextView) findViewById(R.id.tv_source);
        this.f = (TextView) findViewById(R.id.btn_action);
        this.g = (ImageView) findViewById(R.id.iv_mask);
    }

    protected final void g() {
        this.g.setVisibility(8);
        super.g();
        this.e.setText(f.a(this.b, R.string.choiceness_ad_source));
        this.f.setText(o.a(this.b));
    }

    protected final void i() {
        super.i();
        this.g.setVisibility(0);
    }
}
