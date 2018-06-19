package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.FlexQuickCommentView;

/* compiled from: RefreshableCommentEmptyViewHolder */
public final class am extends aq {
    private final TextView a;
    private final FlexQuickCommentView b;
    private final a c;
    private final ImageView d;

    public am(View view, a aVar) {
        super(view);
        this.c = aVar;
        this.a = (TextView) view.findViewById(R.id.tv_empty_comment);
        this.d = (ImageView) view.findViewById(R.id.iv_refresh);
        this.b = (FlexQuickCommentView) view.findViewById(R.id.qk_comment);
        this.b.setVisibility(8);
        if (this.b != null) {
            this.b.setOnItemListener(new an(this));
        }
        if (this.d != null) {
            this.d.setOnClickListener(new ao(this));
        }
        this.a.setVisibility(null);
    }

    public final void a(aw awVar) {
        p[] pVarArr = (awVar.b == null || !(awVar.b instanceof p[])) ? null : (p[]) awVar.b;
        this.a.setVisibility(0);
        if (this.b != null) {
            if (awVar.c instanceof Object[]) {
                Object[] objArr = (Object[]) awVar.c;
                if (objArr[1] instanceof Boolean) {
                    this.b.setClickEnable(((Boolean) objArr[1]).booleanValue());
                }
            }
            if (pVarArr != null) {
                if (pVarArr.length != null) {
                    this.b.setContentsArray(pVarArr);
                    this.b.setVisibility(0);
                    this.a.setText("快捷评论");
                }
            }
            this.b.setVisibility(8);
            this.a.setText("暂无评论，快来抢沙发");
        }
    }
}
