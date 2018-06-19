package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecommendFollowListBaseView */
public abstract class y extends FrameLayout {
    TextView a;
    RecommendFollowBaseView[] b = new RecommendFollowBaseView[4];
    TextView c;
    g d;
    private From e;

    protected abstract int getLayoutResId();

    public y(Context context, From from) {
        super(context);
        context = LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        this.a = (TextView) context.findViewById(R.id.tv_title);
        this.b[0] = (RecommendFollowBaseView) context.findViewById(R.id.recommend_0);
        this.b[1] = (RecommendFollowBaseView) context.findViewById(R.id.recommend_1);
        this.b[2] = (RecommendFollowBaseView) context.findViewById(R.id.recommend_2);
        this.b[3] = (RecommendFollowBaseView) context.findViewById(R.id.recommend_3);
        this.c = (TextView) context.findViewById(R.id.tv_follow_all);
        setFrom(from);
    }

    private void setFrom(From from) {
        this.e = from;
        for (RecommendFollowBaseView from2 : this.b) {
            from2.setFrom(this.e);
        }
    }

    private void setAllFollowBtnState(boolean z) {
        boolean z2 = false;
        if (z) {
            this.c.setEnabled(false);
            while (z2 < this.b.length) {
                this.b[z2].a();
                z2++;
            }
            return;
        }
        this.c.setEnabled(true);
        while (z2 < this.b.length) {
            this.b[z2].b();
            z2++;
        }
    }

    final void a(g gVar) {
        if (gVar != null) {
            int i = 0;
            if (gVar.b() == null) {
                this.c.setEnabled(false);
            } else {
                this.c.setEnabled(true);
            }
            while (i < this.b.length) {
                this.b[i].c();
                i++;
            }
        }
    }

    static void a(RecommendFollowBaseView recommendFollowBaseView, g gVar, int i) {
        b a = b.a();
        for (a aVar : gVar.b) {
            if (!a.b(aVar.b) && !gVar.c.contains(aVar)) {
                break;
            }
        }
        a aVar2 = null;
        if (aVar2 != null) {
            gVar.c.set(i, aVar2);
        }
        if (aVar2 != null) {
            recommendFollowBaseView.a(aVar2);
        }
    }

    static /* synthetic */ void a(y yVar, List list, boolean z, String str, String str2) {
        switch (ae.a[yVar.e.ordinal()]) {
            case 1:
                ad.a(list, z, str, str2);
                return;
            case 2:
                ad.b(list, z, str, str2);
                return;
            case 3:
                ChoicenessReporter.a(list, z, str, str2);
                break;
            default:
                break;
        }
    }

    static /* synthetic */ void a(y yVar, g gVar) {
        List<a> c = gVar.c();
        b a = b.a();
        List<a> arrayList = new ArrayList();
        for (a aVar : c) {
            if (!a.b(aVar.b)) {
                arrayList.add(aVar);
            }
        }
        if (!arrayList.isEmpty()) {
            List arrayList2 = new ArrayList();
            for (a aVar2 : arrayList) {
                arrayList2.add(Long.valueOf(aVar2.b));
            }
            yVar.setAllFollowBtnState(true);
            b.a().a(arrayList, new ac(yVar, gVar, arrayList2));
        }
    }
}
