package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.ui.aa;
import com.xunlei.downloadprovider.homepage.follow.ui.ac;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.r;

/* compiled from: FollowingPlayerUGCViewHolder */
public final class i extends ViewHolder {
    public final void a(ap apVar) {
        d dVar = (d) apVar.b;
        h hVar = (h) this.itemView;
        int adapterPosition = getAdapterPosition();
        r acVar = new ac();
        BaseVideoInfo baseVideoInfo = dVar.b;
        if (dVar.c == null) {
            dVar.c = new VideoUserInfo();
        }
        hVar.a(adapterPosition, baseVideoInfo, dVar.c, acVar);
        hVar.getReportStrategy().b = dVar;
    }

    public i(Context context, a aVar, aa aaVar) {
        super(new h(context, aVar, aaVar));
    }
}
