package com.xunlei.downloadprovider.publiser.per;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.view.WebsiteView;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.model.c;

/* compiled from: HistoryCommentWebsiteViewHolder */
public final class m extends bq<c> {
    private TextView a = ((TextView) this.itemView.findViewById(R.id.tv_comment_status_reviewing));
    private TextView b = ((TextView) this.itemView.findViewById(R.id.tv_comment_status_not_pass));
    private TextView c;
    private TextView d;
    private TextView e;
    private WebsiteView f;
    private c g;
    private BaseCommentInfo h;
    private WebsiteInfo i;
    private g j;

    public final void a(bp<c> bpVar) {
        this.g = (c) bpVar.b;
        bpVar = this.g.b;
        this.a.setVisibility(bpVar == -1 ? 0 : 8);
        this.b.setVisibility(bpVar == null ? null : 8);
        this.i = this.g.a;
        bpVar = this.g.getBaseCommentInfo();
        this.h = bpVar;
        if (bpVar != null) {
            this.c.setText(DateUtil.formatRelativeTime(bpVar.getTime()));
            this.d.setText(bpVar.getContent());
        }
        if (this.i != null) {
            bpVar = this.e;
            WebsiteInfo websiteInfo = this.i;
            if (TextUtils.isEmpty(websiteInfo.d)) {
                bpVar.setVisibility(8);
            } else {
                bpVar.setText(websiteInfo.d);
                bpVar.setVisibility(0);
                bpVar.setOnClickListener(new r(websiteInfo));
            }
        } else {
            this.e.setVisibility(8);
        }
        this.f.a(this.i);
    }

    public m(ViewGroup viewGroup, g gVar) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_comment_website_item, viewGroup, false));
        this.j = gVar;
        viewGroup = this.itemView;
        this.c = (TextView) viewGroup.findViewById(R.id.tv_time);
        this.d = (TextView) viewGroup.findViewById(R.id.tv_content);
        this.e = (TextView) viewGroup.findViewById(R.id.tv_website_description);
        this.f = (WebsiteView) viewGroup.findViewById(R.id.layout_website_view);
        this.itemView.setOnClickListener(new n(this));
        this.itemView.setOnLongClickListener(new o(this));
        this.f.setOnClickListener(new p(this));
        this.f.setOnLongClickListener(new q(this));
    }
}
