package com.xunlei.downloadprovider.launch.guide.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.launch.guide.p.a;

/* compiled from: GuideLastItemView */
public class e extends a {
    private static final String d = "e";
    private View e;
    private View f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private View j;
    private CheckBox k;

    public e(Context context, a aVar) {
        super(context, aVar);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.e = LayoutInflater.from(this.a).inflate(R.layout.guide_last_item_view, this);
        this.f = this.e.findViewById(R.id.ll_guide_bind_apk_layout);
        this.g = (ImageView) this.e.findViewById(R.id.iv_guide_bind_apk_icon);
        this.j = this.e.findViewById(R.id.fl_guide_bind_apk_selector);
        this.k = (CheckBox) this.e.findViewById(R.id.cb_select_install_bind_apk);
        this.h = (TextView) this.e.findViewById(R.id.tv_bind_apk_desc);
        this.i = (TextView) this.e.findViewById(R.id.tv_bind_apk_name);
        setDownLoadLayoutVisibility(4);
        a();
        setBindAPKOptionSelected(null);
        this.k.setOnCheckedChangeListener(new f(this));
        this.j.setOnClickListener(new g(this));
    }

    public void setDownLoadLayoutVisibility(int i) {
        this.f.setVisibility(i);
    }

    private void a() {
        this.i.setText("");
        this.h.setText("");
        c.a(getContext(), "", this.g);
    }

    public void setBindAPKOptionSelected(boolean z) {
        this.k.setChecked(z);
    }

    public final void a(int i) {
        i = this.b.l();
        setDownLoadLayoutVisibility(i.a() ? 0 : 4);
        CooperationItem cooperationItem = i.a;
        if (cooperationItem == null) {
            a();
        } else {
            this.i.setText(cooperationItem.getAppName());
            this.h.setText(cooperationItem.getCopyWriting());
            c.a(getContext(), TextUtils.isEmpty(cooperationItem.getAppIconUrl()) ? cooperationItem.getAppSelfIconUrl() : cooperationItem.getAppIconUrl(), this.g);
        }
        setBindAPKOptionSelected(i.b);
    }
}
