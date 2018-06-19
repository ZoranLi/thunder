package com.xunlei.downloadprovider.publiser.per;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.model.LikeVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.view.DynamicVideoView;

/* compiled from: DynamicLikeVideoViewHolder */
public final class f extends bq<LikeVideoFeedInfo> {
    private ImageView a = ((ImageView) this.itemView.findViewById(R.id.iv_type_icon));
    private TextView b;
    private TextView c;
    private g d;
    private TextView e = ((TextView) this.itemView.findViewById(R.id.tv_time));
    private DynamicVideoView f;
    private LikeVideoFeedInfo g;

    public final void a(bp<LikeVideoFeedInfo> bpVar) {
        this.g = (LikeVideoFeedInfo) bpVar.b;
        this.e.setText(DateUtil.formatRelativeTime(this.g.getLikeTime()));
        this.f.a(this.g.getRelatedVideoInfo());
    }

    public f(ViewGroup viewGroup, g gVar) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_item, viewGroup, false));
        this.d = gVar;
        this.a.setImageResource(R.drawable.ic_type_like);
        this.b = (TextView) this.itemView.findViewById(R.id.tv_type_text);
        this.b.setText("赞了该视频");
        this.c = (TextView) this.itemView.findViewById(R.id.tv_content);
        this.c.setVisibility(8);
        this.f = (DynamicVideoView) this.itemView.findViewById(R.id.dynamic_video_view);
        this.f.setOnClickListener(new g(this));
    }
}
