package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.xlui.widget.KeyLinearLayout;

/* compiled from: DownloadTabMenuPopWindow */
public final class ae extends w {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    private Context h;

    public ae(Context context) {
        super(context);
        this.h = context;
        KeyLinearLayout keyLinearLayout = (KeyLinearLayout) LayoutInflater.from(context).inflate(R.layout.download_list_batch_pw, null);
        setContentView(keyLinearLayout);
        setWidth(DipPixelUtil.dip2px(146.0f));
        setHeight(-2);
        this.c = (TextView) keyLinearLayout.findViewById(R.id.batch_start);
        this.d = (TextView) keyLinearLayout.findViewById(R.id.batch_pause);
        this.e = (TextView) keyLinearLayout.findViewById(R.id.batch_switch_create);
        this.f = (TextView) keyLinearLayout.findViewById(R.id.multi_select_operation);
        this.g = (TextView) keyLinearLayout.findViewById(R.id.multi_select_operation_disable);
        this.a = (TextView) keyLinearLayout.findViewById(R.id.open_private_space);
        this.b = (TextView) keyLinearLayout.findViewById(R.id.operate_private_space);
        PrivateSpaceMgr.a();
        if (PrivateSpaceMgr.b() != null) {
            context = this.h.getResources().getDrawable(R.drawable.ic_pri_space_remove);
            context.setBounds(0, 0, context.getMinimumWidth(), context.getMinimumHeight());
            this.a.setCompoundDrawables(context, null, null, null);
            this.a.setText(this.h.getString(R.string.close_private_space));
            this.b.setVisibility(0);
            Drawable drawable;
            if (PrivateSpaceMgr.a().f()) {
                drawable = this.h.getResources().getDrawable(R.drawable.ic_show_pri_file);
                drawable.setBounds(0, 0, context.getMinimumWidth(), context.getMinimumHeight());
                this.b.setCompoundDrawables(drawable, null, null, null);
                this.b.setText(R.string.show_private_file);
                return;
            }
            drawable = this.h.getResources().getDrawable(R.drawable.ic_hide_pri_file);
            drawable.setBounds(0, 0, context.getMinimumWidth(), context.getMinimumHeight());
            this.b.setCompoundDrawables(drawable, null, null, null);
            this.b.setText(R.string.hide_private_file);
            return;
        }
        context = this.h.getResources().getDrawable(R.drawable.ic_pri_space_open);
        context.setBounds(0, 0, context.getMinimumWidth(), context.getMinimumHeight());
        this.a.setCompoundDrawables(context, null, null, null);
        this.a.setText(this.h.getString(R.string.open_private_space));
        this.b.setVisibility(8);
    }
}
