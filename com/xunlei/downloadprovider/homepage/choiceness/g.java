package com.xunlei.downloadprovider.homepage.choiceness;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.j;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessLiveStoryItemView;
import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChoicenessLiveStoryHelper */
public final class g {
    public XRecyclerView a;
    public k b;
    List<j> c = new ArrayList();
    private Context d;
    private ChoicenessLiveStoryItemView e;

    public g(Context context) {
        this.d = context;
    }

    public final void a() {
        if (d.a().o.a()) {
            a.a().getStoryData(new h(this));
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.b(this.e);
        }
    }

    static /* synthetic */ void a(g gVar) {
        if (gVar.b.d() || gVar.c == null || gVar.c.size() <= 0) {
            gVar.b();
            return;
        }
        if (gVar.e != null) {
            gVar.b();
        }
        gVar.e = new ChoicenessLiveStoryItemView(gVar.d);
        if (gVar.a != null) {
            gVar.a.a(gVar.e);
        }
        ChoicenessLiveStoryItemView choicenessLiveStoryItemView = gVar.e;
        g<j> gVar2 = gVar.c;
        choicenessLiveStoryItemView.a = gVar2;
        int i = 4;
        if (choicenessLiveStoryItemView.a.size() <= 4) {
            i = choicenessLiveStoryItemView.a.size() - 1;
        }
        choicenessLiveStoryItemView.a(0, i, "refresh");
        a aVar = choicenessLiveStoryItemView.b;
        aVar.a = gVar2;
        aVar.b = true;
        aVar.c = false;
        for (j d : gVar2) {
            if (!TextUtils.isEmpty(d.d())) {
                aVar.c = true;
            }
        }
        choicenessLiveStoryItemView.b.notifyDataSetChanged();
    }
}
