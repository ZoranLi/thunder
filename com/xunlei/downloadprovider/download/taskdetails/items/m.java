package com.xunlei.downloadprovider.download.taskdetails.items;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.taskdetails.items.views.DetailOperationButtonLayout;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: DetailShareBarViewHolder */
public final class m extends b implements OnClickListener {
    private DownloadTaskInfo a;
    private View b;
    private View c;
    private View i;
    private View j;
    private View k;
    private View l;
    private DetailOperationButtonLayout m;
    private boolean n;
    private OnClickListener o;
    private k p;

    public m(View view) {
        super(view);
        this.n = true;
        this.o = new n(this);
        this.p = new o(this);
        this.n = l.a().c();
        this.b = view;
        this.m = (DetailOperationButtonLayout) this.b.findViewById(R.id.operate_container);
        this.c = this.b.findViewById(R.id.detail_share_weixin_btn);
        this.c.setOnClickListener(this);
        this.i = this.b.findViewById(R.id.detail_share_qq_btn);
        this.i.setOnClickListener(this);
        this.j = this.b.findViewById(R.id.detail_share_qzone_btn);
        this.j.setOnClickListener(this);
        this.k = this.b.findViewById(R.id.container);
        this.l = this.b.findViewById(R.id.share_btn_container);
        if (this.n != null) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.layout_task_detail_share_bar, viewGroup, false);
    }

    public final void a(a aVar) {
        b(aVar);
        aVar = aVar.d;
        this.a = aVar;
        this.m.a(aVar, this.g, this.f);
    }

    public final void onClick(View view) {
        if (this.a != null) {
            String str = "download_detail_bar";
            if (this.f != null) {
                if ("home_collect_card".equals(this.f.k)) {
                    str = "home_collect_detail_bar";
                }
            }
            ShareOperationType shareOperationType = null;
            switch (view.getId()) {
                case R.id.detail_share_weixin_btn:
                    shareOperationType = ShareOperationType.WEIXIN;
                    break;
                case R.id.detail_share_qq_btn:
                    shareOperationType = ShareOperationType.QQ;
                    break;
                case R.id.detail_share_qzone_btn:
                case R.id.textView6:
                    shareOperationType = ShareOperationType.QZONE;
                    break;
                default:
                    break;
            }
            if (shareOperationType != null) {
                com.xunlei.downloadprovider.download.report.a.b(shareOperationType.getReportShareTo(), str, this.a.mGCID, this.a.mTitle, this.a.getTaskDownloadUrl());
                f a = c.a(str, this.a, com.xunlei.downloadprovider.cooperation.c.a().a(7), "", "");
                com.xunlei.downloadprovider.f.a.a();
                com.xunlei.downloadprovider.f.a.a((Activity) this.itemView.getContext(), shareOperationType, a, this.p);
            }
        }
    }
}
