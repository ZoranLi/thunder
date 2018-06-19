package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import android.view.View;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: DownloadLimitPrivilegeBanner */
public final class a extends c {
    public int a = 258;
    public b b;
    public Context c;
    public DownloadTaskInfo d;

    public a(Context context, ViewStub viewStub) {
        super(viewStub);
        this.c = context;
        viewStub.inflate();
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.b = new b(view);
        this.b.i.setOnClickListener(new b(this));
        this.b.g.setOnClickListener(new c(this));
        if (com.xunlei.downloadprovider.download.b.b.f() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.titleTextView), viewStub);
            return;
        }
        viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
        c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
        c.a(view.findViewById(R.id.titleTextView), viewStub);
    }

    public final boolean a() {
        return this.a == InputDeviceCompat.SOURCE_KEYBOARD;
    }

    public final boolean b() {
        return this.a == 258;
    }

    public final void a(boolean z, DownloadTaskInfo downloadTaskInfo) {
        if (z) {
            d(0);
        } else {
            d(8);
        }
        long j = -1;
        if (downloadTaskInfo != null) {
            j = downloadTaskInfo.getTaskId();
        }
        boolean z2 = z;
        BannerManager.a().a(z2, BannerManager$BannerType.TYPE_LIMIT_PRIVILEGE, j, null);
    }
}
