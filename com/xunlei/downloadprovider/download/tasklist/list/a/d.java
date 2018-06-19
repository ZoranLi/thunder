package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

/* compiled from: BasicPromotionCardViewHolder */
public class d extends f {
    protected ImageView a;
    protected ViewGroup b;
    protected ZHTextView c;
    protected TextView d;
    protected View e;
    protected TextView f;
    protected TextView g;

    public d(View view) {
        super(view);
        this.b = (ViewGroup) view.findViewById(R.id.cardContainer);
        if (this.b == null && (view instanceof ViewGroup)) {
            this.b = (ViewGroup) view;
        }
        view = this.b;
        this.a = (ImageView) view.findViewById(R.id.iconImageView);
        this.c = (ZHTextView) view.findViewById(R.id.titleTextView);
        this.d = (TextView) view.findViewById(R.id.detailTextView);
        this.e = view.findViewById(R.id.closeButton);
        this.f = (TextView) view.findViewById(R.id.actionButton);
        this.g = (TextView) view.findViewById(R.id.tagView);
    }

    public final void a(String str) {
        if (this.a != null && !TextUtils.isEmpty(str) && !str.equals(this.a.getTag(R.id.tag_image_id))) {
            this.a.setTag(R.id.tag_image_id, str);
            Glide.with(this.a.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().override(Integer.MIN_VALUE, Integer.MIN_VALUE).priority(Priority.IMMEDIATE).into(this.a);
        }
    }

    public final void a(CharSequence charSequence) {
        if (this.c != null) {
            this.c.setText(charSequence);
        }
    }
}
