package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;

/* compiled from: JointActivityItemView */
final class k implements OnClickListener {
    final /* synthetic */ JointActivityItemView a;

    k(JointActivityItemView jointActivityItemView) {
        this.a = jointActivityItemView;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.a();
        }
        view = f.a("home_collect_caomei_click");
        view.add("type", "newuser_guide");
        ThunderReport.reportEvent(view);
        CustomWebViewActivity.a(this.a.getContext(), "", "http://act.vip.xunlei.com/m/vip/2018/zbfl/?referfrom=v_an_shoulei_acti_syxstj", "", CustomWebViewActivity.class);
    }
}
