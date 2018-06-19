package com.xunlei.downloadprovider.download.tasklist.list.banner.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.q;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;

/* compiled from: DownloadExceptionBanner */
public final class a extends c implements q {
    public p a;
    private b b;
    private DownloadTaskInfo c;
    private Context d;
    private g e;

    public final void a(DownloadTaskInfo downloadTaskInfo, long j, long j2, long j3) {
    }

    public final void a(Object obj) {
    }

    public final void d() {
    }

    public final RedPacketConditionsInfo e() {
        return null;
    }

    public a(Context context, ViewStub viewStub) {
        super(viewStub);
        this.d = context;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.b = new b(view);
        if (this.e != null) {
            if (TextUtils.isEmpty(this.e.b) == null) {
                this.b.a(this.e.b);
            }
        }
        this.b.f.setOnClickListener(new b(this));
        this.b.g.setOnClickListener(new c(this));
        if (g() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
            return;
        }
        viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
        c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
        c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, Object obj, boolean z) {
        if (downloadTaskInfo != null && (obj instanceof g)) {
            g gVar = (g) obj;
            this.e = gVar;
            this.c = downloadTaskInfo;
            this.c.mIsDisplayDownloadException = true;
            this.c.mSearchName = gVar.a;
            d(null);
        }
    }

    public final DownloadTaskInfo a() {
        return this.c;
    }

    public final Context b() {
        return this.d;
    }

    public final void a(int i) {
        d(i);
    }

    public final void c() {
        if (this.e != null && !TextUtils.isEmpty(this.e.a)) {
            SearchOperateActivity.a(this.d, "download_dl_fail_bar", this.e.a);
        }
    }
}
