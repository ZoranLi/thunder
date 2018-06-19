package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.report.c;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.TaskDetailNewBannerAdController;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;

/* compiled from: DetailBannerAdViewHolder */
public final class b extends a {
    private ImageView b = null;
    private View c = null;
    private TextView i = null;

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.layout_task_detail_new_banner_ad, viewGroup, false);
    }

    public b(View view, TaskDetailNewBannerAdController taskDetailNewBannerAdController) {
        super(view, taskDetailNewBannerAdController);
        this.b = (ImageView) view.findViewById(R.id.iv_banner);
        this.c = view.findViewById(R.id.btn_close);
        this.i = (TextView) view.findViewById(R.id.tv_ad_source);
        this.b.setOnClickListener(new c(this));
        this.c.setOnClickListener(new d(this));
    }

    private void a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.itemView.getLayoutParams();
        if (layoutParams != null) {
            if (i == 0) {
                layoutParams.topMargin = DipPixelUtil.dip2px(1084227584);
                layoutParams.width = -1;
                layoutParams.height = -2;
            } else {
                layoutParams.topMargin = 0;
                layoutParams.width = 0;
                layoutParams.height = 0;
            }
            this.itemView.setLayoutParams(layoutParams);
        }
    }

    public final void a(a aVar) {
        aVar = this.a;
        int i = 0;
        if (aVar.c) {
            aVar = aVar.d;
        } else {
            aVar = new c(Boolean.valueOf(false), e.a(-1, "you should check ad enabled first"));
        }
        if (((Boolean) aVar.a).booleanValue()) {
            this.a.i_();
            if (this.a.a.b != null) {
                a(8);
                return;
            }
            aVar = this.a.a.c;
            new StringBuilder("onBindData. (adInfo == null): ").append(aVar == null);
            if (aVar == null) {
                this.a.a(e.a(-11, "ad content is empty"));
                a(8);
                return;
            }
            a(0);
            View view = this.c;
            if (!this.a.a.a) {
                i = 8;
            }
            view.setVisibility(i);
            com.xunlei.downloadprovider.ad.common.c.a(this.itemView.getContext(), aVar.l()).placeholder(R.drawable.download_ad_background).error(R.drawable.download_ad_background).fallback(R.drawable.download_ad_background).listener(null).into(this.b);
            this.i.setText(f.a(aVar, R.string.task_detail_new_banner_ad_source));
            aVar = this.a;
            this.itemView.getContext();
            aVar.a(this.itemView);
            return;
        }
        this.a.a(aVar.b.b);
        a(8);
    }
}
