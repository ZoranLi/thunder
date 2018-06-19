package com.xunlei.downloadprovider.publiser.per;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.contentpublish.website.view.WebsiteView;
import com.xunlei.downloadprovider.publiser.per.model.e;

/* compiled from: HistoryLikeWebsiteViewHolder */
public final class af extends bq<e> {
    private TextView a;
    private TextView b;
    private WebsiteView c;

    public final void a(bp<e> bpVar) {
        e eVar = (e) bpVar.b;
        this.a.setText(DateUtil.formatRelativeTime(eVar.a));
        TextView textView = this.b;
        WebsiteInfo websiteInfo = eVar.b;
        if (TextUtils.isEmpty(websiteInfo.d)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(websiteInfo.d);
        }
        bpVar = eVar.b;
        this.c.a(bpVar);
        this.c.setOnClickListener(new ag(this, bpVar));
        this.itemView.setOnClickListener(new ah(this, bpVar));
    }

    public af(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_like_website_item, viewGroup, false));
        viewGroup = this.itemView;
        this.a = (TextView) viewGroup.findViewById(R.id.tv_time);
        this.b = (TextView) viewGroup.findViewById(R.id.tv_website_description);
        this.c = (WebsiteView) viewGroup.findViewById(R.id.layout_website_view);
    }
}
