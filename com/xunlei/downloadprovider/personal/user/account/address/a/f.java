package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.content.Context;
import android.view.LayoutInflater;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import java.util.List;

/* compiled from: UserRegionProvinceAdapter */
public final class f extends c<a, d> {
    private final int f = 1001;
    private final int g = 1002;
    private LayoutInflater h;
    private List<a> i;

    public final int a() {
        return 1;
    }

    public final int b(int i) {
        return i == 1 ? 1001 : 1002;
    }

    public f(Context context, List<a> list) {
        super(context, list);
        this.h = LayoutInflater.from(context);
        this.i = list;
    }

    public final d a(int i) {
        if (i == 1001) {
            return new g(this.h.inflate(R.layout.user_item_region_all, null));
        }
        if (i == 1002) {
            return new h(this.h.inflate(R.layout.user_item_region_list, null));
        }
        return null;
    }

    public final void a(d dVar, int i) {
        if (this.i != null && i > 1) {
            ((h) dVar).a((a) this.i.get(i - 2));
        }
    }
}
