package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: BrandADViewHolder */
public final class f extends ag {
    protected final View a;
    private l e = null;
    private final View f;
    private final ImageView g;

    public f(View view, a aVar) {
        super(view, aVar);
        this.f = view.findViewById(R.id.rl_ad_header_root);
        this.a = view.findViewById(R.id.rl_native_header_root);
        this.g = (ImageView) view.findViewById(R.id.iv_poster);
        this.g.setOnClickListener(new g(this));
    }

    public final void a(aw awVar) {
        super.a(awVar);
        this.e = this.d.b;
        if (this.e != null) {
            if (com.xunlei.downloadprovider.ad.d.a.a.a().b(1) == null) {
                this.e.a(this.itemView);
                com.xunlei.downloadprovider.ad.d.a.a.a().a(1);
            }
            this.a.setVisibility(8);
            this.f.setVisibility(0);
            Glide.with(this.g.getContext()).load(this.e.l()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).listener(new h(this)).error(R.color.download_list_ad_icon_default).placeholder(R.color.download_list_ad_icon_default).fallback(R.color.download_list_ad_icon_default).into(this.g);
            return;
        }
        a();
    }

    protected final void a() {
        this.f.setVisibility(8);
        this.a.setVisibility(0);
    }
}
