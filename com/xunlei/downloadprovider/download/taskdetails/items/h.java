package com.xunlei.downloadprovider.download.taskdetails.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailEmptyPlaceholderViewHolder */
public final class h extends b {
    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.layout_task_empty, viewGroup, false);
    }

    public h(View view) {
        super(view);
    }

    public final void a(a aVar) {
        b(aVar);
        Integer num = (Integer) aVar.a(Integer.class);
        if (num != null) {
            this.itemView.setPadding(0, 0, 0, num.intValue());
        } else {
            this.itemView.setPadding(0, 0, 0, 0);
        }
    }
}
