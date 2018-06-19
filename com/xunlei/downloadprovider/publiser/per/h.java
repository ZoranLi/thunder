package com.xunlei.downloadprovider.publiser.per;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.model.a;
import com.xunlei.downloadprovider.publiser.per.view.DynamicCinecismView;

/* compiled from: HistoryCommentCinecismViewHolder */
public final class h extends bq<a> {
    private TextView a = ((TextView) this.itemView.findViewById(R.id.tv_comment_status_reviewing));
    private TextView b = ((TextView) this.itemView.findViewById(R.id.tv_comment_status_not_pass));
    private TextView c;
    private TextView d;
    private DynamicCinecismView e;
    private a f;
    private g g;
    private String h;

    public final void a(bp<a> bpVar) {
        this.f = (a) bpVar.b;
        bpVar = this.f.b;
        int i = 8;
        this.a.setVisibility(bpVar == -1 ? 0 : 8);
        TextView textView = this.b;
        if (bpVar == null) {
            i = 0;
        }
        textView.setVisibility(i);
        bpVar = this.f.a;
        BaseCommentInfo baseCommentInfo = this.f.getBaseCommentInfo();
        if (baseCommentInfo != null) {
            this.c.setText(DateUtil.formatRelativeTime(baseCommentInfo.getTime()));
            this.d.setText(baseCommentInfo.getContent());
        }
        this.e.a(bpVar);
    }

    h(ViewGroup viewGroup, g gVar, String str) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_comment_cinecism_item, viewGroup, false));
        this.g = gVar;
        viewGroup = this.itemView;
        this.c = (TextView) viewGroup.findViewById(R.id.tv_time);
        this.d = (TextView) viewGroup.findViewById(R.id.tv_content);
        this.e = (DynamicCinecismView) viewGroup.findViewById(R.id.dynamic_cinecism_view);
        this.itemView.setOnClickListener(new i(this));
        this.itemView.setOnLongClickListener(new j(this));
        this.e.setOnClickListener(new k(this));
        this.e.setOnLongClickListener(new l(this));
        this.h = str;
    }
}
