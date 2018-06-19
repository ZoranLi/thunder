package com.xunlei.downloadprovider.personal.playrecord;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.a.a.c;

/* compiled from: LivePlayRecordInfoListItemHolder */
public final class a extends ag {
    public TextView a = null;
    public ImageView b = null;
    public TextView c = null;

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }

    public a(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.nickname);
        this.b = (ImageView) view.findViewById(R.id.live_level);
        this.c = (TextView) view.findViewById(R.id.xllive_watch_number);
    }

    public final void a(VideoPlayRecord videoPlayRecord, boolean z, boolean z2, boolean z3) {
        b bVar = (b) videoPlayRecord;
        this.m.setText(bVar.p);
        int i = 8;
        this.q.setVisibility(z ? 8 : 0);
        this.l.setVisibility(z ? 0 : 8);
        this.n.setVisibility(z ? 0 : 8);
        this.p.setVisibility(z ? 0 : 8);
        this.o.setVisibility(z ? 0 : 8);
        this.m.setVisibility(z ? false : true);
        this.d.setBackgroundResource(R.drawable.play_record_item_bg_selector);
        if (bVar.f()) {
            a("直播中", -1);
        } else {
            a("回看", -1);
        }
        if (z2) {
            this.k.setImageResource(z3 ? true : true);
        } else {
            this.k.setImageDrawable(false);
        }
        this.h.setVisibility(z2 ? true : false);
        z = this.j;
        if (z2) {
            i = 0;
        }
        z.setVisibility(i);
        this.f.setText(bVar.c());
        this.a.setText(bVar.b());
        z = this.c;
        z2 = new StringBuilder();
        z2.append(b.a(bVar.a, "onlinenum"));
        z2.append(bVar.f() ? "人在观看" : "人看过");
        z.setText(z2.toString());
        Glide.with(this.e.getContext()).load(bVar.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_dl_video).fallback(R.drawable.ic_dl_video).error(R.drawable.ic_dl_video).dontAnimate().transform(new BitmapTransformation[]{new c(this.e.getContext(), 5)}).into(this.e);
        Glide.with(this.b.getContext()).load(bVar.e()).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.b);
    }
}
