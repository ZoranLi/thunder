package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.content.Context;
import android.view.LayoutInflater;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import java.util.List;

/* compiled from: UserRegionCityAdapter */
public final class e extends c<a, d> {
    private LayoutInflater f;
    private List<a> g;

    public final int a() {
        return 0;
    }

    public final int b(int i) {
        return 0;
    }

    public e(Context context, List<a> list) {
        super(context, list);
        this.f = LayoutInflater.from(context);
        this.g = list;
    }

    public final d a(int i) {
        return new h(this.f.inflate(R.layout.user_item_region_list, null));
    }

    public final void a(d dVar, int i) {
        if (this.g != null && i > 0) {
            ((h) dVar).a((a) this.g.get(i - 1));
        }
    }
}
