package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;

/* compiled from: EffectADViewHolder */
public final class ab extends a {
    protected final TextView g;
    protected final TextView h;

    public ab(View view, a aVar) {
        super(view, aVar);
        this.g = (TextView) view.findViewById(R.id.tv_action);
        this.h = (TextView) view.findViewById(R.id.tv_ad_source_tag);
    }

    protected final void a(@NonNull l lVar) {
        Drawable drawable;
        super.a(lVar);
        CharSequence a = o.a(lVar);
        this.g.setVisibility(TextUtils.isEmpty(a) ? 8 : 0);
        this.g.setText(a);
        TextView textView = this.g;
        if (lVar.u() == 2) {
            drawable = BrothersApplication.getApplicationInstance().getResources().getDrawable(R.drawable.short_movie_detail_recommend_effect_ad_download_icon);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        } else {
            drawable = null;
        }
        textView.setCompoundDrawables(drawable, null, null, null);
        this.h.setText(f.a(lVar, R.string.choiceness_ad_source_guanggao));
    }
}
