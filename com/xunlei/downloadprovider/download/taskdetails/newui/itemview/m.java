package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailDividerHolder */
public final class m extends b {
    public final void a(a aVar) {
    }

    public m(View view) {
        super(view);
    }

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.layout_task_detail_divider, viewGroup, false);
    }
}
