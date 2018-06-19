package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.b.c;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.xlui.widget.KeyLinearLayout;

/* compiled from: DownloadCenterMenuPopWindow */
public final class j extends w {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    private Context g;
    private View h;

    public j(Context context) {
        super(context);
        this.g = context;
        KeyLinearLayout keyLinearLayout = (KeyLinearLayout) LayoutInflater.from(context).inflate(R.layout.download_list_batch_pw, null);
        setContentView(keyLinearLayout);
        setWidth(DipPixelUtil.dip2px(146.0f));
        setHeight(-2);
        this.b = (TextView) keyLinearLayout.findViewById(R.id.batch_start);
        this.c = (TextView) keyLinearLayout.findViewById(R.id.batch_pause);
        this.d = (TextView) keyLinearLayout.findViewById(R.id.batch_switch_create);
        this.e = (TextView) keyLinearLayout.findViewById(R.id.multi_select_operation);
        this.f = (TextView) keyLinearLayout.findViewById(R.id.multi_select_operation_disable);
        this.a = (TextView) keyLinearLayout.findViewById(R.id.open_private_space);
        this.h = keyLinearLayout.findViewById(R.id.open_private_space_line);
        ((TextView) keyLinearLayout.findViewById(R.id.operate_private_space)).setVisibility(8);
        keyLinearLayout.findViewById(R.id.operate_private_space_line).setVisibility(8);
    }

    public final void a() {
        super.a();
        c cVar = d.a().d;
        if (c.o()) {
            this.a.setVisibility(0);
            this.h.setVisibility(0);
        } else {
            this.a.setVisibility(8);
            this.h.setVisibility(8);
        }
        PrivateSpaceMgr.a();
        if (PrivateSpaceMgr.b()) {
            Drawable drawable = this.g.getResources().getDrawable(R.drawable.ic_pri_space_open);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.setCompoundDrawables(drawable, null, null, null);
            this.a.setText(this.g.getString(R.string.close_private_space));
            return;
        }
        drawable = this.g.getResources().getDrawable(R.drawable.ic_pri_space_close);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.a.setCompoundDrawables(drawable, null, null, null);
        this.a.setText(this.g.getString(R.string.open_private_space));
    }
}
