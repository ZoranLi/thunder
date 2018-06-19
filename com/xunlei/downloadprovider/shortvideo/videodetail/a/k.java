package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

/* compiled from: CommentErrorViewHolder */
public final class k extends aq {
    private final ErrorBlankView a;
    private final a b;

    public k(View view, a aVar) {
        super(view);
        this.a = (ErrorBlankView) view.findViewById(R.id.ev_comment_error);
        this.a.a(null, "网络不给力", null);
        this.a.setVisibility(0);
        this.b = aVar;
        this.a.a("刷新", new l(this));
    }

    public final void a(aw awVar) {
        if (awVar.b == Boolean.TRUE) {
            this.a.a(null, "该视频不存在，评论无法显示", null);
            this.a.a("", null);
        }
    }
}
