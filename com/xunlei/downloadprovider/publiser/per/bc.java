package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;

/* compiled from: HistoryPublishVideoItemViewHolder */
public final class bc<T extends bn> extends bq<PublishVideoFeedInfo> {
    private final T a;
    private final g b;
    private i c;
    private bo d;
    private bp<PublishVideoFeedInfo> e;
    private BaseVideoInfo f;
    private String g;

    public bc(T t, g gVar, bo boVar) {
        super(t.a());
        this.a = t;
        this.b = gVar;
        this.a.a(gVar);
        this.itemView.setOnLongClickListener(new bd(this));
        this.d = boVar;
    }

    public final void a(bp<PublishVideoFeedInfo> bpVar) {
        this.e = bpVar;
        this.f = ((PublishVideoFeedInfo) bpVar.b).getRelatedVideoInfo();
        this.g = ((PublishVideoFeedInfo) bpVar.b).getUserInfo().getKind();
        this.a.a(getAdapterPosition(), (PublishVideoFeedInfo) bpVar.b);
    }

    static /* synthetic */ void a(bc bcVar) {
        if (bcVar.f.getPublisherId() <= 0 || bcVar.f.getPublisherId() == LoginHelper.a().g.c()) {
            Context context = bcVar.itemView.getContext();
            bcVar.c = new i(context);
            bcVar.c.a();
            bcVar.c.b();
            bcVar.c.c();
            bcVar.c.c(new be(bcVar, context));
            bcVar.c.d(new bg(bcVar));
            bcVar.c.show();
        }
    }
}
