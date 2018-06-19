package com.xunlei.downloadprovider.publiser.per;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.downloadprovider.publiser.per.view.DynamicCinecismView;

/* compiled from: HistoryLikeCinecismViewHolder */
public final class ad extends bq<d> {
    private TextView a;
    private DynamicCinecismView b;
    private String c;

    public final void a(bp<d> bpVar) {
        d dVar = (d) bpVar.b;
        this.a.setText(DateUtil.formatRelativeTime(dVar.a));
        this.b.a(dVar.b);
        this.b.setOnClickListener(new ae(this, dVar));
    }

    ad(ViewGroup viewGroup, String str) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_like_cinecism_item, viewGroup, false));
        viewGroup = this.itemView;
        this.a = (TextView) viewGroup.findViewById(R.id.tv_time);
        this.b = (DynamicCinecismView) viewGroup.findViewById(R.id.dynamic_cinecism_view);
        this.c = str;
    }
}
