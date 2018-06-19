package com.xunlei.downloadprovider.download.tasklist.list.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.d;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;

/* compiled from: CooperationCardViewHolder */
public final class a extends d {
    d h;
    private OnClickListener i;
    private OnClickListener j;
    private com.xunlei.downloadprovider.download.tasklist.list.a k;
    private int l;

    private a(View view, int i) {
        super(view);
        this.d.setVisibility(8);
        this.l = i;
    }

    public static a a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.control.a aVar, com.xunlei.downloadprovider.download.tasklist.list.a aVar2) {
        int f = b.f();
        if (f == 0) {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_promotion_card, viewGroup, false);
        } else if (f == 1) {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_promotion_card_style1, viewGroup, false);
        } else {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_card_template_basic_promotion_card_style2, viewGroup, false);
        }
        viewGroup = new a(context, f);
        viewGroup.setDownloadCenterControl(aVar);
        viewGroup.setAdapter(aVar2);
        return viewGroup;
    }

    public final void setAdapter(com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        this.k = aVar;
    }

    public final void fillData(e eVar) {
        this.h = (d) eVar.a(d.class);
        eVar = this.h.a;
        if (eVar != null) {
            OnClickListener onClickListener;
            a(eVar.getCopyWriting());
            a(eVar.getAppIconUrl());
            if (ApkHelper.isApkPackageInstalled(getContext(), eVar.getAppPackageName())) {
                this.f.setText(R.string.download_item_button_open);
            } else {
                this.f.setText(R.string.download_item_button_install);
            }
            View view = this.itemView;
            if (this.i != null) {
                onClickListener = this.i;
            } else {
                this.i = new b(this);
                onClickListener = this.i;
            }
            view.setOnClickListener(onClickListener);
            view = this.e;
            if (this.j != null) {
                onClickListener = this.j;
            } else {
                this.j = new c(this);
                onClickListener = this.j;
            }
            view.setOnClickListener(onClickListener);
            if (!this.h.b) {
                this.h.b = true;
                com.xunlei.downloadprovider.cooperation.a.a.a(l.c(eVar.getDisplayLocation()), eVar.getAppPackageName(), eVar.isShowInstallTip());
            }
        }
    }
}
