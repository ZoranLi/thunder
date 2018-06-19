package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import java.util.List;

/* compiled from: RecommendFollowListViewHolder */
public final class ag extends ViewHolder {
    public ag(Context context, From from) {
        super(new af(context, from));
    }

    public final void a(ap apVar) {
        g gVar = (g) apVar.b;
        af afVar = (af) this.itemView;
        afVar.d = gVar;
        afVar.a.setText(gVar.a);
        List c = gVar.c();
        int size = c.size();
        if (size > 4) {
            size = 4;
        }
        for (int i = 0; i < size; i++) {
            a aVar = (a) c.get(i);
            afVar.b[i].setVisibility(0);
            afVar.b[i].a(aVar);
            RecommendFollowBaseView recommendFollowBaseView = afVar.b[i];
            if (b.a().b(aVar.b)) {
                y.a(recommendFollowBaseView, gVar, i);
            }
            recommendFollowBaseView.setOnFollowSuccessListener(new z(afVar, recommendFollowBaseView, gVar, i));
        }
        while (size < 4) {
            afVar.b[size].setVisibility(8);
            size++;
        }
        afVar.a(gVar);
        afVar.c.setOnClickListener(new aa(afVar, gVar));
    }
}
