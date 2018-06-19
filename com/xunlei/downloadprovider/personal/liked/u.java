package com.xunlei.downloadprovider.personal.liked;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.a.w;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.publiser.per.bq;
import com.xunlei.xllib.b.j;

/* compiled from: LikedVideoItemViewHolder */
public final class u extends bq<w> {
    private View a = this.itemView;
    private TextView b = ((TextView) this.itemView.findViewById(R.id.tv_time));
    private ImageView c = ((ImageView) this.itemView.findViewById(R.id.iv_poster));
    private TextView d = ((TextView) this.itemView.findViewById(R.id.tv_duration));
    private TextView e = ((TextView) this.itemView.findViewById(R.id.tv_title));
    private ImageView f = ((ImageView) this.itemView.findViewById(R.id.iv_publisher_avatar));
    private TextView g = ((TextView) this.itemView.findViewById(R.id.tv_publisher_name));
    private TextView h = ((TextView) this.itemView.findViewById(R.id.tv_play));
    private TextView i = ((TextView) this.itemView.findViewById(R.id.tv_like));
    private g j;

    public final void a(bp<w> bpVar) {
        if (bpVar != null) {
            if (bpVar.b != null) {
                w wVar = (w) bpVar.b;
                if (this.j != null) {
                    this.a.setOnClickListener(new v(this, wVar));
                }
                int i = 8;
                if (wVar.n) {
                    this.b.setVisibility(0);
                    this.b.setText(DateUtil.formatRelativeDay(wVar.m * 1000));
                } else {
                    this.b.setVisibility(8);
                }
                Object obj = wVar.e;
                if (!TextUtils.isEmpty(obj)) {
                    Glide.with(this.c.getContext()).load(obj).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).placeholder(R.drawable.choiceness_icon_default).into(this.c);
                }
                long j = wVar.f;
                if (j > 0) {
                    this.d.setText(j.a(j * 1000));
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                Glide.with(this.itemView.getContext()).load(wVar.i).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).into(this.f);
                CharSequence charSequence = wVar.c;
                if (TextUtils.isEmpty(charSequence)) {
                    this.e.setText("    ");
                } else {
                    this.e.setText(charSequence);
                }
                charSequence = wVar.g;
                this.g.setText(charSequence);
                this.g.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
                long j2 = wVar.j;
                this.h.setText(ConvertUtil.decimal2String(j2, 10000, 10000, "万"));
                this.h.setVisibility(j2 > 0 ? 0 : 8);
                j2 = wVar.k;
                this.i.setText(ConvertUtil.decimal2String(j2, 10000, 10000, "万"));
                bpVar = this.i;
                if (j2 > 0) {
                    i = 0;
                }
                bpVar.setVisibility(i);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be LikedVideoInfo type");
    }

    public u(ViewGroup viewGroup, g gVar) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liked_video_item_layout, viewGroup, false));
        this.j = gVar;
    }
}
