package com.xunlei.downloadprovider.vod.recordpublish;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.d;
import java.util.List;

/* compiled from: XlpsHotTopicAdapter */
public final class z extends Adapter<a> {
    b a;
    private final List<com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a> b;
    private final Context c;

    /* compiled from: XlpsHotTopicAdapter */
    public interface b {
        void a(com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a aVar);
    }

    /* compiled from: XlpsHotTopicAdapter */
    public class a extends ViewHolder {
        public TextView a;
        public TextView b;
        public LinearLayout c;
        final /* synthetic */ z d;

        public a(z zVar, View view) {
            this.d = zVar;
            super(view);
            this.a = (TextView) view.findViewById(R.id.xlps_hottopic_item_tv);
            this.b = (TextView) view.findViewById(R.id.xlps_hottopic_item_content);
            this.c = (LinearLayout) view.findViewById(R.id.xlps_hottopic_item_ly);
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a aVar2 = (com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a) this.b.get(i);
        aVar.b.setText(aVar2.b);
        aVar.a.setText(aVar2.a);
        aVar.c.setOnClickListener(new aa(this, i));
        if (aVar2.i > 0) {
            aVar.a.setMaxWidth((int) (0.49d * ((double) d.a(this.c))));
            new StringBuilder().append(aVar2.i);
            return;
        }
        aVar.a.setMaxWidth(Integer.MAX_VALUE);
    }

    public z(Context context, List<com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a> list) {
        this.b = list;
        this.c = context;
    }

    public final int getItemCount() {
        return this.b == null ? 0 : this.b.size();
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.c).inflate(R.layout.xlps_hottopic_item, viewGroup, false));
    }
}
