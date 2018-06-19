package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b.a;

/* compiled from: TaskListFeedHeaderViewHolder */
public final class l extends f implements c {
    private int a;

    public final int a() {
        return 1;
    }

    public static l a(Context context, ViewGroup viewGroup, int i) {
        return new l(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_header, viewGroup, false), i);
    }

    private l(View view, int i) {
        super(view);
        this.a = i;
        view = a.a();
        view.e = i;
        a aVar = (a) view.b.get(Integer.valueOf(i));
        if (aVar == null) {
            aVar = new a();
            view.b.put(Integer.valueOf(i), aVar);
        }
        aVar.a = this;
    }
}
