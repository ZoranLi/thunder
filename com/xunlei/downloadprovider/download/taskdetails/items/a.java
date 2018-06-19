package com.xunlei.downloadprovider.download.taskdetails.items;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.ad.taskdetail.view.g;
import com.xunlei.downloadprovider.ad.taskdetail.view.i;
import com.xunlei.downloadprovider.ad.taskdetail.view.j;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailADViewHolder */
public class a extends b {
    private static final String b = "a";
    public com.xunlei.downloadprovider.ad.taskdetail.a a = null;
    private com.xunlei.downloadprovider.ad.taskdetail.view.a c = null;

    public static View a(Context context, int i, com.xunlei.downloadprovider.ad.taskdetail.a aVar) {
        switch (i) {
            case 8:
                i = new j(context);
                break;
            case 9:
                i = g.a(context);
                break;
            case 10:
                i = new i(context);
                break;
            default:
                i = 0;
                break;
        }
        if (i != 0) {
            i.setAdController(aVar);
        }
        return i;
    }

    public a(View view) {
        super(view);
        if (view instanceof com.xunlei.downloadprovider.ad.taskdetail.view.a) {
            this.c = (com.xunlei.downloadprovider.ad.taskdetail.view.a) view;
        }
    }

    public final void a(com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar) {
        b(aVar);
        aVar = aVar.d;
        if (this.a == null || this.c == null) {
            aVar = new StringBuilder("onBindData,Both AbstractTaskDetailAd and AbstractTaskDetailAdView can not be null: (AbstractTaskDetailAd == null): ");
            boolean z = false;
            aVar.append(this.a == null);
            aVar.append(" (AbstractTaskDetailAdView==null): ");
            if (this.c == null) {
                z = true;
            }
            aVar.append(z);
            return;
        }
        this.c.setDownloadTaskInfo(aVar);
        this.a.a(this.c);
    }
}
