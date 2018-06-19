package com.xunlei.downloadprovider.publiser.per;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.model.CommentVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.view.DynamicVideoView;

/* compiled from: DynamicCommentVideoViewHolder */
public final class a extends bq<CommentVideoFeedInfo> {
    private ImageView a = ((ImageView) this.itemView.findViewById(R.id.iv_type_icon));
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e = ((TextView) this.itemView.findViewById(R.id.tv_time));
    private TextView f;
    private DynamicVideoView g;
    private CommentVideoFeedInfo h;
    private g i;

    public final void a(bp<CommentVideoFeedInfo> bpVar) {
        this.h = (CommentVideoFeedInfo) bpVar.b;
        bpVar = this.h.getCommentStatus();
        int i = 8;
        this.c.setVisibility(bpVar == -1 ? 0 : 8);
        TextView textView = this.d;
        if (bpVar == null) {
            i = 0;
        }
        textView.setVisibility(i);
        this.e.setText(DateUtil.formatRelativeTime(this.h.getBaseCommentInfo().getTime()));
        bpVar = this.h.getBaseCommentInfo().getContent();
        if (TextUtils.isEmpty(bpVar)) {
            this.f.setText("");
        } else {
            this.f.setText(bpVar);
        }
        this.g.a(this.h.getRelatedVideoInfo());
    }

    public a(ViewGroup viewGroup, g gVar) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_history_dynamic_item, viewGroup, false));
        this.i = gVar;
        this.a.setImageResource(R.drawable.ic_type_comment);
        this.b = (TextView) this.itemView.findViewById(R.id.tv_type_text);
        this.b.setText("评论了该视频");
        this.c = (TextView) this.itemView.findViewById(R.id.tv_comment_status_reviewing);
        this.d = (TextView) this.itemView.findViewById(R.id.tv_comment_status_not_pass);
        this.f = (TextView) this.itemView.findViewById(R.id.tv_content);
        this.itemView.setOnClickListener(new b(this));
        this.itemView.setOnLongClickListener(new c(this));
        this.g = (DynamicVideoView) this.itemView.findViewById(R.id.dynamic_video_view);
        this.g.setOnLongClickListener(new d(this));
        this.g.setOnClickListener(new e(this));
    }
}
