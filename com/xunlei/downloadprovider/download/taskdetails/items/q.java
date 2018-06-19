package com.xunlei.downloadprovider.download.taskdetails.items;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: DetailWebSourceInfoViewHolder */
public final class q extends b {
    private View a;
    private TextView b;
    private TextView c;
    private ImageView i;
    private RelativeLayout j;
    private String k;
    private DownloadTaskInfo l;
    private boolean m;
    private View n;
    private View o;
    private Context p = this.itemView.getContext();

    public q(View view) {
        super(view);
        this.a = view;
        this.b = (TextView) this.a.findViewById(R.id.task_ref_url);
        this.c = (TextView) this.a.findViewById(R.id.web_site_name);
        this.i = (ImageView) this.a.findViewById(R.id.iv_collection);
        this.n = this.a.findViewById(R.id.line_bottom);
        this.o = this.a.findViewById(R.id.line_top);
        this.j = (RelativeLayout) this.a.findViewById(R.id.keyword_web_container);
        this.j.setOnClickListener(new r(this));
        this.i.setOnClickListener(new s(this));
    }

    public static View a(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.download_detail_sniff_info, null);
    }

    public final void a(a aVar) {
        b(aVar);
        if (aVar.d != this.l) {
            this.l = aVar.d;
            aVar = this.l;
            if (TextUtils.isEmpty(aVar.mWebsiteName)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                TextView textView = this.c;
                StringBuilder stringBuilder = new StringBuilder("来源：");
                stringBuilder.append(aVar.mWebsiteName);
                textView.setText(stringBuilder.toString());
            }
            if (!TextUtils.isEmpty(aVar.mRefUrl)) {
                this.k = aVar.mRefUrl;
            } else if (!(aVar.mExtraInfo == null || TextUtils.isEmpty(aVar.mExtraInfo.mRefUrl))) {
                this.k = aVar.mExtraInfo.mRefUrl;
            }
            if (!TextUtils.isEmpty(this.k)) {
                this.b.setText(this.k);
            }
            this.m = com.xunlei.downloadprovider.web.website.g.b.a().a(this.k);
            if (this.m) {
                this.i.setSelected(true);
            } else {
                this.i.setSelected(false);
            }
            if (k.e(aVar) != null) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
                this.o.setVisibility(0);
            }
        }
    }

    public final void a() {
        if (!(this.l == null || this.i == null)) {
            this.m = com.xunlei.downloadprovider.web.website.g.b.a().a(this.k);
            if (this.m) {
                this.i.setSelected(true);
                return;
            }
            this.i.setSelected(false);
        }
    }

    public final void a(boolean z) {
        if (this.i != null) {
            this.i.setSelected(z);
        }
    }

    public static void a(String str, DownloadTaskInfo downloadTaskInfo) {
        com.xunlei.downloadprovider.download.report.a.a(str, downloadTaskInfo);
    }

    static /* synthetic */ void f(q qVar) {
        Activity c = qVar.c();
        if (c != null) {
            c.runOnUiThread(new w(qVar));
        }
    }

    static /* synthetic */ void g(q qVar) {
        Activity c = qVar.c();
        if (c != null) {
            c.runOnUiThread(new v(qVar));
        }
    }

    static /* synthetic */ void k(q qVar) {
        Intent xLIntent = new XLIntent("com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment");
        if (qVar.p != null) {
            LocalBroadcastManager.getInstance(qVar.p).sendBroadcast(xLIntent);
        }
    }
}
