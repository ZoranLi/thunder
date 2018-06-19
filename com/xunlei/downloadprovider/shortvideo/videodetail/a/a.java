package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: BaseEffectADViewHolder */
public abstract class a extends aq {
    protected final View a;
    protected final ImageView b;
    protected final TextView c;
    protected final TextView d;
    protected l e = null;
    protected final com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a f;

    public a(View view, com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a aVar) {
        super(view);
        this.f = aVar;
        this.a = view.findViewById(R.id.ll_ad_root);
        this.b = (ImageView) view.findViewById(R.id.iv_poster);
        this.c = (TextView) view.findViewById(R.id.tv_desc);
        this.d = (TextView) view.findViewById(R.id.tv_name);
        view.setOnClickListener(new b(this, view));
    }

    public final void a(aw awVar) {
        if (awVar.b instanceof l) {
            this.e = (l) awVar.b;
        }
        if (this.e != null) {
            a(this.e);
        } else {
            this.a.setVisibility(8);
        }
    }

    protected void a(@NonNull l lVar) {
        if (!com.xunlei.downloadprovider.ad.d.a.a.a().b(3)) {
            lVar.a(this.itemView);
            com.xunlei.downloadprovider.ad.d.a.a.a().a(3);
        }
        this.a.setVisibility(0);
        Glide.with(this.b.getContext()).load(lVar.l()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().error(R.color.download_list_ad_icon_default).fallback(R.color.download_list_ad_icon_default).placeholder(R.color.download_list_ad_icon_default).into(this.b);
        this.c.setText(lVar.m());
        this.d.setText(lVar.j());
    }
}
