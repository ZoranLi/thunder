package com.xunlei.downloadprovider.homepage.photoarticle.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.List;

/* compiled from: PhotoArticleLikeViewHolder */
public final class d extends aq {
    private List<v> a;
    private LikeView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private PhotoArticleInfo g;

    /* compiled from: PhotoArticleLikeViewHolder */
    private class a implements OnClickListener {
        final /* synthetic */ d a;
        private v b;

        public a(d dVar, v vVar) {
            this.a = dVar;
            this.b = vVar;
        }

        public final void onClick(View view) {
            m.a(view.getContext(), this.b.a, "per", this.b.b, this.b.c, From.LINK_DETAIL_LIKE);
        }
    }

    public d(View view) {
        super(view);
        this.b = (LikeView) view.findViewById(R.id.like_view);
        this.b.setLikeIcon(R.drawable.ic_shortdetail_like_selector);
        this.b.setEmptyText("");
        this.b.setOnClickListener(new e(this, view));
        this.c = (ImageView) view.findViewById(R.id.like_icon0);
        this.d = (ImageView) view.findViewById(R.id.like_icon1);
        this.e = (ImageView) view.findViewById(R.id.like_icon2);
        this.f = (TextView) view.findViewById(R.id.like_count);
    }

    public final void a(aw awVar) {
        TextView textView;
        StringBuilder stringBuilder;
        this.g = (PhotoArticleInfo) awVar.b;
        this.a = (List) awVar.c;
        awVar = this.a;
        if (awVar != null) {
            if (!awVar.isEmpty()) {
                this.f.setVisibility(0);
                int min = Math.min(awVar.size(), 3);
                if (min == 1) {
                    a(this.c, (v) awVar.get(0));
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                } else if (min == 2) {
                    a(this.c, (v) awVar.get(0));
                    a(this.d, (v) awVar.get(1));
                    this.e.setVisibility(8);
                } else {
                    a(this.c, (v) awVar.get(0));
                    a(this.d, (v) awVar.get(1));
                    a(this.e, (v) awVar.get(2));
                }
                awVar = this.g.h;
                this.b.a(this.g.g, 0);
                textView = this.f;
                stringBuilder = new StringBuilder();
                stringBuilder.append(ConvertUtil.decimal2String((long) awVar, 10000, 10000, "万"));
                stringBuilder.append("赞");
                textView.setText(stringBuilder.toString());
            }
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        awVar = this.g.h;
        this.b.a(this.g.g, 0);
        textView = this.f;
        stringBuilder = new StringBuilder();
        stringBuilder.append(ConvertUtil.decimal2String((long) awVar, 10000, 10000, "万"));
        stringBuilder.append("赞");
        textView.setText(stringBuilder.toString());
    }

    private void a(ImageView imageView, v vVar) {
        imageView.setVisibility(0);
        imageView.setOnClickListener(new a(this, vVar));
        Glide.with(imageView.getContext()).load(vVar.c).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.feedflow_icon_default).error(R.drawable.feedflow_icon_default).dontAnimate().transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.a(imageView.getContext())}).into(imageView);
    }
}
