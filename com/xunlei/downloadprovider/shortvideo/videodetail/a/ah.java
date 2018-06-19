package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;
import com.xunlei.xllib.b.j;

/* compiled from: RecommendItemViewHolder */
public final class ah extends aq {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final a e;
    private final View f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;

    public ah(View view, a aVar) {
        super(view);
        this.e = aVar;
        this.f = view;
        this.a = (ImageView) view.findViewById(R.id.iv_poster);
        this.b = (TextView) view.findViewById(R.id.tv_duration);
        this.c = (TextView) view.findViewById(R.id.tv_title);
        this.g = (ImageView) view.findViewById(R.id.iv_publisher_avatar);
        this.h = (TextView) view.findViewById(R.id.tv_publisher_name);
        this.d = (TextView) view.findViewById(R.id.tv_play);
        this.i = (TextView) view.findViewById(R.id.tv_like);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof b) {
                b bVar = (b) awVar.b;
                if (this.e != null) {
                    this.f.setOnClickListener(new ai(this, awVar));
                }
                awVar = bVar.a().getCoverUrl();
                if (!TextUtils.isEmpty(awVar)) {
                    Glide.with(this.a.getContext()).load(awVar).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).into(this.a);
                }
                long duration = (long) bVar.a().getDuration();
                int i = 8;
                if (duration > 0) {
                    this.b.setText(j.a(duration * 1000));
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                awVar = bVar.a().getTitle();
                if (TextUtils.isEmpty(awVar)) {
                    this.c.setText("    ");
                } else {
                    this.c.setText(awVar);
                }
                Glide.with(this.itemView.getContext()).load(bVar.b().getPortraitUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).into(this.g);
                awVar = bVar.b().getNickname();
                if (TextUtils.isEmpty(awVar)) {
                    this.h.setText("");
                    this.h.setVisibility(8);
                } else {
                    this.h.setText(awVar);
                    this.h.setVisibility(0);
                }
                awVar = bVar.a().getPlayCount();
                this.d.setText(com.xunlei.downloadprovider.h.b.a((long) awVar));
                this.d.setVisibility(awVar > null ? null : 8);
                awVar = bVar.a().getLikeCount();
                this.i.setText(com.xunlei.downloadprovider.h.b.a((long) awVar));
                TextView textView = this.i;
                if (awVar > null) {
                    i = 0;
                }
                textView.setVisibility(i);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be DetailVideoInfo type");
    }
}
