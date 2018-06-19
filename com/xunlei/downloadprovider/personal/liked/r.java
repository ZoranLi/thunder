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
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.publiser.per.bq;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: LikedCinecismItemViewHolder */
public final class r extends bq<d> {
    private View a = this.itemView;
    private TextView b = ((TextView) this.itemView.findViewById(R.id.tv_time));
    private ImageView c = ((ImageView) this.itemView.findViewById(R.id.iv_poster));
    private TextView d = ((TextView) this.itemView.findViewById(R.id.tv_title));
    private ImageView e = ((ImageView) this.itemView.findViewById(R.id.iv_publisher_avatar));
    private TextView f = ((TextView) this.itemView.findViewById(R.id.tv_publisher_name));
    private TextView g = ((TextView) this.itemView.findViewById(R.id.tv_play));
    private TextView h = ((TextView) this.itemView.findViewById(R.id.tv_like));
    private g i;

    public final void a(bp<d> bpVar) {
        if (bpVar != null) {
            if (bpVar.b != null) {
                TextView textView;
                int i;
                long j;
                d dVar = (d) bpVar.b;
                if (this.i != null) {
                    this.a.setOnClickListener(new s(this, dVar));
                }
                int i2 = 8;
                if (dVar.e) {
                    this.b.setVisibility(0);
                    this.b.setText(DateUtil.formatRelativeDay(dVar.a));
                } else {
                    this.b.setVisibility(8);
                }
                Object obj = dVar.b.d;
                if (!TextUtils.isEmpty(obj)) {
                    Glide.with(this.c.getContext()).load(obj).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).placeholder(R.drawable.choiceness_icon_default).into(this.c);
                }
                CharSequence charSequence = dVar.b.b;
                if (TextUtils.isEmpty(charSequence)) {
                    this.d.setText("    ");
                } else {
                    this.d.setText(charSequence);
                }
                VideoUserInfo videoUserInfo = dVar.c;
                if (videoUserInfo != null) {
                    Glide.with(this.itemView.getContext()).load(videoUserInfo.getPortraitUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).into(this.e);
                }
                videoUserInfo = dVar.c;
                if (videoUserInfo == null) {
                    textView = this.f;
                } else {
                    charSequence = videoUserInfo.getNickname();
                    this.f.setText(charSequence);
                    textView = this.f;
                    if (!TextUtils.isEmpty(charSequence)) {
                        i = 0;
                        textView.setVisibility(i);
                        j = (long) dVar.b.j;
                        this.g.setText(ConvertUtil.decimal2String(j, 10000, 10000, "万"));
                        this.g.setVisibility(j <= 0 ? 0 : 8);
                        j = (long) dVar.b.g;
                        this.h.setText(ConvertUtil.decimal2String(j, 10000, 10000, "万"));
                        bpVar = this.h;
                        if (j > 0) {
                            i2 = 0;
                        }
                        bpVar.setVisibility(i2);
                        return;
                    }
                }
                i = 8;
                textView.setVisibility(i);
                j = (long) dVar.b.j;
                this.g.setText(ConvertUtil.decimal2String(j, 10000, 10000, "万"));
                if (j <= 0) {
                }
                this.g.setVisibility(j <= 0 ? 0 : 8);
                j = (long) dVar.b.g;
                this.h.setText(ConvertUtil.decimal2String(j, 10000, 10000, "万"));
                bpVar = this.h;
                if (j > 0) {
                    i2 = 0;
                }
                bpVar.setVisibility(i2);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be LikedVideoInfo type");
    }

    public r(ViewGroup viewGroup, g gVar) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liked_cinecism_item_layout, viewGroup, false));
        this.i = gVar;
    }
}
