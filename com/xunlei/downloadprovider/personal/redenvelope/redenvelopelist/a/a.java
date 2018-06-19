package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import com.xunlei.downloadprovider.personal.user.account.address.a.c;
import com.xunlei.downloadprovider.personal.user.account.address.a.d;

/* compiled from: RedEnvelopesAdapter */
public final class a extends c<e, b> {
    private final LayoutInflater f;
    private View g;
    private com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.b.a h;

    public final int a() {
        return 0;
    }

    public final int b(int i) {
        return 0;
    }

    public final /* synthetic */ void a(d dVar, int i) {
        b bVar = (b) dVar;
        e eVar = (e) c(i);
        new StringBuilder("onBindViewHolder = ").append(eVar);
        bVar.a(eVar);
        bVar.itemView.setTag(eVar);
    }

    public a(Context context, com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.b.a aVar) {
        super(context);
        this.f = LayoutInflater.from(context);
        this.h = aVar;
    }

    public final d a(int i) {
        this.g = this.f.inflate(R.layout.red_envelopes_item, null);
        return new b(this.g, this.h);
    }

    public final int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            e eVar = (e) c(i);
            if (eVar != null && TextUtils.equals(str, eVar.k)) {
                return i;
            }
        }
        return -1;
    }
}
